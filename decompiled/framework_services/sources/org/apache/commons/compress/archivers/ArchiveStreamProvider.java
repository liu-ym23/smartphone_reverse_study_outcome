package org.apache.commons.compress.archivers;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface ArchiveStreamProvider {
    ArchiveInputStream createArchiveInputStream(String r1, InputStream r2, String r3) throws ArchiveException;

    ArchiveOutputStream createArchiveOutputStream(String r1, OutputStream r2, String r3) throws ArchiveException;

    Set<String> getInputStreamArchiveNames();

    Set<String> getOutputStreamArchiveNames();
}
