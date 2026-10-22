package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/l;", "", "", "overlay", "stateDesc", "", "colorOverlay", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "Z", Const.INTENT_KEY_APIKEY, "()Z", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.l, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class LiveSublineKeys {
    private final boolean colorOverlay;
    private final String overlay;
    private final String stateDesc;

    public LiveSublineKeys(String overlay, String stateDesc, boolean z10) {
        kotlin.jvm.internal.p.i(overlay, "overlay");
        kotlin.jvm.internal.p.i(stateDesc, "stateDesc");
        this.overlay = overlay;
        this.stateDesc = stateDesc;
        this.colorOverlay = z10;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getColorOverlay() {
        return this.colorOverlay;
    }

    /* renamed from: b, reason: from getter */
    public final String getOverlay() {
        return this.overlay;
    }

    /* renamed from: c, reason: from getter */
    public final String getStateDesc() {
        return this.stateDesc;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveSublineKeys)) {
            return false;
        }
        LiveSublineKeys liveSublineKeys = (LiveSublineKeys) other;
        return kotlin.jvm.internal.p.d(this.overlay, liveSublineKeys.overlay) && kotlin.jvm.internal.p.d(this.stateDesc, liveSublineKeys.stateDesc) && this.colorOverlay == liveSublineKeys.colorOverlay;
    }

    public int hashCode() {
        return (((this.overlay.hashCode() * 31) + this.stateDesc.hashCode()) * 31) + Boolean.hashCode(this.colorOverlay);
    }

    public String toString() {
        return "LiveSublineKeys(overlay=" + this.overlay + ", stateDesc=" + this.stateDesc + ", colorOverlay=" + this.colorOverlay + ")";
    }
}
