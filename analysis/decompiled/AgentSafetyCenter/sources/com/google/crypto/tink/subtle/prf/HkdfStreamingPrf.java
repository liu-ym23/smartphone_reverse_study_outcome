package com.google.crypto.tink.subtle.prf;

import com.google.crypto.tink.aead.a;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class HkdfStreamingPrf implements StreamingPrf {
    private final Enums.HashType hashType;
    private final byte[] ikm;
    private final byte[] salt;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.google.crypto.tink.subtle.prf.HkdfStreamingPrf$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[Enums.HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[Enums.HashType.SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public HkdfStreamingPrf(Enums.HashType hashType, byte[] bArr, byte[] bArr2) {
        this.hashType = hashType;
        this.ikm = Arrays.copyOf(bArr, bArr.length);
        this.salt = Arrays.copyOf(bArr2, bArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getJavaxHmacName(Enums.HashType hashType) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha384";
        }
        if (i == 4) {
            return "HmacSha512";
        }
        a.a("No getJavaxHmacName for given hash ", hashType, " known");
        return null;
    }

    @Override // com.google.crypto.tink.subtle.prf.StreamingPrf
    public InputStream computePrf(byte[] bArr) {
        return new HkdfInputStream(bArr);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public class HkdfInputStream extends InputStream {
        private ByteBuffer buffer;
        private int ctr = -1;
        private final byte[] input;
        private Mac mac;
        private byte[] prk;

        public HkdfInputStream(byte[] bArr) {
            this.input = Arrays.copyOf(bArr, bArr.length);
        }

        private void initialize() throws IllegalStateException, InvalidKeyException, IOException {
            try {
                this.mac = EngineFactory.MAC.getInstance(HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType));
                if (HkdfStreamingPrf.this.salt == null || HkdfStreamingPrf.this.salt.length == 0) {
                    this.mac.init(new SecretKeySpec(new byte[this.mac.getMacLength()], HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
                } else {
                    this.mac.init(new SecretKeySpec(HkdfStreamingPrf.this.salt, HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
                }
                this.mac.update(HkdfStreamingPrf.this.ikm);
                this.prk = this.mac.doFinal();
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(0);
                this.buffer = byteBufferAllocateDirect;
                byteBufferAllocateDirect.mark();
                this.ctr = 0;
            } catch (GeneralSecurityException e10) {
                throw new IOException("Creating HMac failed", e10);
            }
        }

        private void updateBuffer() throws IllegalStateException, InvalidKeyException {
            this.mac.init(new SecretKeySpec(this.prk, HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
            this.buffer.reset();
            this.mac.update(this.buffer);
            this.mac.update(this.input);
            int i = this.ctr + 1;
            this.ctr = i;
            this.mac.update((byte) i);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.mac.doFinal());
            this.buffer = byteBufferWrap;
            byteBufferWrap.mark();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i3) throws IllegalStateException, IOException {
            try {
                if (this.ctr == -1) {
                    initialize();
                }
                int i10 = 0;
                while (i10 < i3) {
                    if (!this.buffer.hasRemaining()) {
                        if (this.ctr == 255) {
                            break;
                        }
                        updateBuffer();
                    }
                    int iMin = Math.min(i3 - i10, this.buffer.remaining());
                    this.buffer.get(bArr, i, iMin);
                    i += iMin;
                    i10 += iMin;
                }
                return i10;
            } catch (GeneralSecurityException e10) {
                this.mac = null;
                throw new IOException("HkdfInputStream failed", e10);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read() throws IllegalStateException, IOException {
            byte[] bArr = new byte[1];
            int i = read(bArr, 0, 1);
            if (i == 1) {
                return bArr[0] & 255;
            }
            if (i == -1) {
                return i;
            }
            f.l("Reading failed");
            return 0;
        }
    }
}
