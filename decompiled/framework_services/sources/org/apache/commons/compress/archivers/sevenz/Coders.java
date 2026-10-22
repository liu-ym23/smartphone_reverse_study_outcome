package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.FlushShieldFilterOutputStream;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableWrapperOutputStream;

/* JADX INFO: loaded from: classes3.dex */
class Coders {
    private static final Map<SevenZMethod, CoderBase> CODER_MAP = null;

    static class BCJDecoder extends CoderBase {
        private final FilterOptions opts;

        BCJDecoder(FilterOptions opts) {
            super(new Class[0]);
            this.opts = opts;
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            return this.opts.getInputStream(in);
        L4:
            e = move-exception;
            throw new IOException("BCJ filter used in " + archiveName + " needs XZ for Java > 1.4 - see https://commons.apache.org/proper/commons-compress/limitations.html#7Z", e);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        OutputStream encode(OutputStream out, Object options) {
            return new FlushShieldFilterOutputStream(this.opts.getOutputStream(new FinishableWrapperOutputStream(out)));
        }
    }

    static class BZIP2Decoder extends CoderBase {
        BZIP2Decoder() {
            super(new Class[]{Number.class});
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            return new BZip2CompressorInputStream(in);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        OutputStream encode(OutputStream out, Object options) throws IOException {
            int blockSize = CoderBase.numberOptionOrDefault(options, 9);
            return new BZip2CompressorOutputStream(out, blockSize);
        }
    }

    static class CopyDecoder extends CoderBase {
        CopyDecoder() {
            super(new Class[0]);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            return in;
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        OutputStream encode(OutputStream out, Object options) {
            return out;
        }
    }

    static class Deflate64Decoder extends CoderBase {
        Deflate64Decoder() {
            super(new Class[]{Number.class});
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            return new Deflate64CompressorInputStream(in);
        }
    }

    static class DeflateDecoder extends CoderBase {
        private static final byte[] ONE_ZERO_BYTE = null;

        static class DeflateDecoderInputStream extends InputStream {
            Inflater inflater;
            InflaterInputStream inflaterInputStream;

            public DeflateDecoderInputStream(InflaterInputStream inflaterInputStream, Inflater inflater) {
                this.inflaterInputStream = inflaterInputStream;
                this.inflater = inflater;
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                return this.inflaterInputStream.read();
            }

            @Override // java.io.InputStream
            public int read(byte[] b, int off, int len) throws IOException {
                return this.inflaterInputStream.read(b, off, len);
            }

            @Override // java.io.InputStream
            public int read(byte[] b) throws IOException {
                return this.inflaterInputStream.read(b);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.inflaterInputStream.close();     // Catch: Throwable -> L5
                this.inflater.end();
                return;
            L5:
                th = move-exception;
                this.inflater.end();
                throw th;
            }
        }

        static class DeflateDecoderOutputStream extends OutputStream {
            Deflater deflater;
            DeflaterOutputStream deflaterOutputStream;

            public DeflateDecoderOutputStream(DeflaterOutputStream deflaterOutputStream, Deflater deflater) {
                this.deflaterOutputStream = deflaterOutputStream;
                this.deflater = deflater;
            }

            @Override // java.io.OutputStream
            public void write(int b) throws IOException {
                this.deflaterOutputStream.write(b);
            }

            @Override // java.io.OutputStream
            public void write(byte[] b) throws IOException {
                this.deflaterOutputStream.write(b);
            }

            @Override // java.io.OutputStream
            public void write(byte[] b, int off, int len) throws IOException {
                this.deflaterOutputStream.write(b, off, len);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.deflaterOutputStream.close();     // Catch: Throwable -> L5
                this.deflater.end();
                return;
            L5:
                th = move-exception;
                this.deflater.end();
                throw th;
            }
        }

        static {
            ONE_ZERO_BYTE = new byte[1];
        }

        DeflateDecoder() {
            super(new Class[]{Number.class});
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String archiveName, InputStream in, long uncompressedLength, Coder coder, byte[] password) throws IOException {
            Inflater inflater = new Inflater(true);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(new SequenceInputStream(in, new ByteArrayInputStream(ONE_ZERO_BYTE)), inflater);
            return new DeflateDecoderInputStream(inflaterInputStream, inflater);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        OutputStream encode(OutputStream out, Object options) {
            int level = CoderBase.numberOptionOrDefault(options, 9);
            Deflater deflater = new Deflater(level, true);
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(out, deflater);
            return new DeflateDecoderOutputStream(deflaterOutputStream, deflater);
        }
    }

    Coders() {
    }

    static {
        CODER_MAP = new AnonymousClass1();
    }

    static CoderBase findByMethod(SevenZMethod method) {
        return CODER_MAP.get(method);
    }

    static InputStream addDecoder(String archiveName, InputStream is, long uncompressedLength, Coder coder, byte[] password) throws IOException {
        CoderBase cb = findByMethod(SevenZMethod.byId(coder.decompressionMethodId));
        if (cb == null) goto L7;
        return cb.decode(archiveName, is, uncompressedLength, coder, password);
    L7:
        throw new IOException("Unsupported compression method " + Arrays.toString(coder.decompressionMethodId) + " used in " + archiveName);
    }

    static OutputStream addEncoder(OutputStream out, SevenZMethod method, Object options) throws IOException {
        CoderBase cb = findByMethod(method);
        if (cb == null) goto L7;
        return cb.encode(out, options);
    L7:
        throw new IOException("Unsupported compression method " + method);
    }
}
