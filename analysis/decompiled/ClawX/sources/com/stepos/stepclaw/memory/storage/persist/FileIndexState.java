package com.stepos.stepclaw.memory.storage.persist;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/persist/FileIndexState;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hash", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lastModified", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "entryCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;JI)V", "getHash", "()Ljava/lang/String;", "getLastModified", "()J", "getEntryCount", "()I", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class FileIndexState {
    private final int entryCount;
    private final String hash;
    private final long lastModified;

    public FileIndexState(String hash, long j4, int i8) {
        p.e(hash, "hash");
        this.hash = hash;
        this.lastModified = j4;
        this.entryCount = i8;
    }

    public static /* synthetic */ FileIndexState copy$default(FileIndexState fileIndexState, String str, long j4, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = fileIndexState.hash;
        }
        if ((i9 & 2) != 0) {
            j4 = fileIndexState.lastModified;
        }
        if ((i9 & 4) != 0) {
            i8 = fileIndexState.entryCount;
        }
        return fileIndexState.copy(str, j4, i8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLastModified() {
        return this.lastModified;
    }

    /* renamed from: component3, reason: from getter */
    public final int getEntryCount() {
        return this.entryCount;
    }

    public final FileIndexState copy(String hash, long lastModified, int entryCount) {
        p.e(hash, "hash");
        return new FileIndexState(hash, lastModified, entryCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileIndexState)) {
            return false;
        }
        FileIndexState fileIndexState = (FileIndexState) other;
        return p.a(this.hash, fileIndexState.hash) && this.lastModified == fileIndexState.lastModified && this.entryCount == fileIndexState.entryCount;
    }

    public final int getEntryCount() {
        return this.entryCount;
    }

    public final String getHash() {
        return this.hash;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public int hashCode() {
        return Integer.hashCode(this.entryCount) + b.e(this.hash.hashCode() * 31, 31, this.lastModified);
    }

    public String toString() {
        return "FileIndexState(hash=" + this.hash + ", lastModified=" + this.lastModified + ", entryCount=" + this.entryCount + ")";
    }
}
