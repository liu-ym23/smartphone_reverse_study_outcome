package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface ZipEncoding {
    boolean canEncode(String r1);

    String decode(byte[] r1) throws IOException;

    ByteBuffer encode(String r1) throws IOException;
}
