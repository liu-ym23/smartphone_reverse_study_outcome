package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/task/space/t0;", "", "", "memoryShareEnabled", "", "version", "<init>", "(ZI)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_APIKEY, "()Z", "I", Const.INTENT_KEY_PKGNAME, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.t0, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class MemorySettingState {
    private final boolean memoryShareEnabled;
    private final int version;

    public MemorySettingState(boolean z10, int i10) {
        this.memoryShareEnabled = z10;
        this.version = i10;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getMemoryShareEnabled() {
        return this.memoryShareEnabled;
    }

    /* renamed from: b, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemorySettingState)) {
            return false;
        }
        MemorySettingState memorySettingState = (MemorySettingState) other;
        return this.memoryShareEnabled == memorySettingState.memoryShareEnabled && this.version == memorySettingState.version;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.memoryShareEnabled) * 31) + Integer.hashCode(this.version);
    }

    public String toString() {
        return "MemorySettingState(memoryShareEnabled=" + this.memoryShareEnabled + ", version=" + this.version + ")";
    }
}
