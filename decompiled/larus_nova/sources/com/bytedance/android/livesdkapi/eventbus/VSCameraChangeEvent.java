package com.bytedance.android.livesdkapi.eventbus;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/eventbus/VSCameraChangeEvent;", "", "from", "Lcom/bytedance/android/livesdkapi/eventbus/VSJumpCameraEvent;", RemoteMessageConst.TO, "(Lcom/bytedance/android/livesdkapi/eventbus/VSJumpCameraEvent;Lcom/bytedance/android/livesdkapi/eventbus/VSJumpCameraEvent;)V", "getFrom", "()Lcom/bytedance/android/livesdkapi/eventbus/VSJumpCameraEvent;", "getTo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VSCameraChangeEvent {
    private final VSJumpCameraEvent from;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    private final VSJumpCameraEvent f162630to;

    public static /* synthetic */ VSCameraChangeEvent copy$default(VSCameraChangeEvent r100, VSJumpCameraEvent r101, VSJumpCameraEvent r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.from;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f162630to;
    L9:
        return r100.copy(r101, r102);
    }

    public final VSJumpCameraEvent component1() {
        return this.from;
    }

    public final VSJumpCameraEvent component2() {
        return this.f162630to;
    }

    public final VSCameraChangeEvent copy(VSJumpCameraEvent r100, VSJumpCameraEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        return new VSCameraChangeEvent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VSCameraChangeEvent) == false) goto L10;
        VSCameraChangeEvent r101 = (VSCameraChangeEvent) r100;
        if (Intrinsics.areEqual(this.from, r101.from) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f162630to, r101.f162630to) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        VSJumpCameraEvent r100 = this.from;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        VSJumpCameraEvent r104 = this.f162630to;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "VSCameraChangeEvent(from=" + this.from + ", to=" + this.f162630to + ")";
    }

    public final VSJumpCameraEvent getFrom() {
        return this.from;
    }

    public final VSJumpCameraEvent getTo() {
        return this.f162630to;
    }

    public VSCameraChangeEvent(VSJumpCameraEvent r100, VSJumpCameraEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        this.from = r100;
        this.f162630to = r101;
    }
}
