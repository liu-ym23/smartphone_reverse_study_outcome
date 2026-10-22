package org.tukaani.xz;

import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class MemoryLimitException extends XZIOException {
    private static final long serialVersionUID = 3;
    private final int memoryLimit;
    private final int memoryNeeded;

    public MemoryLimitException(int i8, int i9) {
        super(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID + i8 + " KiB of memory would be needed; limit was " + i9 + " KiB");
        this.memoryNeeded = i8;
        this.memoryLimit = i9;
    }

    public int getMemoryLimit() {
        return this.memoryLimit;
    }

    public int getMemoryNeeded() {
        return this.memoryNeeded;
    }
}
