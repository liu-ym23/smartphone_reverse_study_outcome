package org.apache.commons.compress.compressors.gzip;

/* JADX INFO: loaded from: classes3.dex */
public class GzipParameters {
    private String comment;
    private int compressionLevel;
    private String filename;
    private long modificationTime;
    private int operatingSystem;

    public GzipParameters() {
        this.compressionLevel = -1;
        this.operatingSystem = 255;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int compressionLevel) {
        if (compressionLevel < (-1)) goto L9;
        if (compressionLevel > 9) goto L9;
        this.compressionLevel = compressionLevel;
        return;
    L9:
        throw new IllegalArgumentException("Invalid gzip compression level: " + compressionLevel);
    }

    public long getModificationTime() {
        return this.modificationTime;
    }

    public void setModificationTime(long modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setOperatingSystem(int operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
