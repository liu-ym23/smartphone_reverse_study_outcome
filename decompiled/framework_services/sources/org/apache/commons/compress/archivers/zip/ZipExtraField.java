package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes3.dex */
public interface ZipExtraField {
    public static final int EXTRAFIELD_HEADER_SIZE = 4;

    byte[] getCentralDirectoryData();

    ZipShort getCentralDirectoryLength();

    ZipShort getHeaderId();

    byte[] getLocalFileDataData();

    ZipShort getLocalFileDataLength();

    void parseFromCentralDirectoryData(byte[] r1, int r2, int r3) throws ZipException;

    void parseFromLocalFileData(byte[] r1, int r2, int r3) throws ZipException;
}
