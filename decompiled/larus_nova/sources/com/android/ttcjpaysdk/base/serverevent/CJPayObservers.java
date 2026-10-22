package com.android.ttcjpaysdk.base.serverevent;

import com.android.ttcjpaysdk.base.framework.manager.CJScreenshotRiskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/serverevent/CJPayObservers;", "", "switchObserver", "Lcom/android/ttcjpaysdk/base/serverevent/CJPayLifecycleObserver;", "screenShot", "Lcom/android/ttcjpaysdk/base/framework/manager/CJScreenshotRiskManager;", "(Lcom/android/ttcjpaysdk/base/serverevent/CJPayLifecycleObserver;Lcom/android/ttcjpaysdk/base/framework/manager/CJScreenshotRiskManager;)V", "getScreenShot", "()Lcom/android/ttcjpaysdk/base/framework/manager/CJScreenshotRiskManager;", "getSwitchObserver", "()Lcom/android/ttcjpaysdk/base/serverevent/CJPayLifecycleObserver;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayObservers {
    private final CJScreenshotRiskManager screenShot;
    private final CJPayLifecycleObserver switchObserver;

    public static /* synthetic */ CJPayObservers copy$default(CJPayObservers r100, CJPayLifecycleObserver r101, CJScreenshotRiskManager r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.switchObserver;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.screenShot;
    L9:
        return r100.copy(r101, r102);
    }

    public final CJPayLifecycleObserver component1() {
        return this.switchObserver;
    }

    public final CJScreenshotRiskManager component2() {
        return this.screenShot;
    }

    public final CJPayObservers copy(CJPayLifecycleObserver r100, CJScreenshotRiskManager r101) {
        Intrinsics.checkNotNullParameter(r100, "switchObserver");
        Intrinsics.checkNotNullParameter(r101, "screenShot");
        return new CJPayObservers(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayObservers) == true) goto L8;
        return false;
    L8:
        CJPayObservers r101 = (CJPayObservers) r100;
        if (Intrinsics.areEqual(this.switchObserver, r101.switchObserver) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.screenShot, r101.screenShot) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.switchObserver.hashCode() * 31) + this.screenShot.hashCode();
    }

    public String toString() {
        return "CJPayObservers(switchObserver=" + this.switchObserver + ", screenShot=" + this.screenShot + ')';
    }

    public final CJScreenshotRiskManager getScreenShot() {
        return this.screenShot;
    }

    public final CJPayLifecycleObserver getSwitchObserver() {
        return this.switchObserver;
    }

    public CJPayObservers(CJPayLifecycleObserver r100, CJScreenshotRiskManager r101) {
        Intrinsics.checkNotNullParameter(r100, "switchObserver");
        Intrinsics.checkNotNullParameter(r101, "screenShot");
        this.switchObserver = r100;
        this.screenShot = r101;
    }
}
