package org.apache.commons.compress.compressors;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface CompressorStreamProvider {
    CompressorInputStream createCompressorInputStream(String r1, InputStream r2, boolean r3) throws CompressorException;

    CompressorOutputStream createCompressorOutputStream(String r1, OutputStream r2) throws CompressorException;

    Set<String> getInputStreamCompressorNames();

    Set<String> getOutputStreamCompressorNames();
}
