package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSLandscapeTabsWidget f160016a;

    public y(VSLandscapeTabsWidget r100) {
        this.f160016a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        StringBuilder r101 = new StringBuilder("MatchRoomLandScapeAnimUtil.mStateSubject = ");
        if (r100 != null) goto L5;
        Object r102 = "";
    L6:
        r101.append(r102.toString());
        ALogger.i("LiveMultiTab", r101.toString());
        if (Intrinsics.areEqual(r100, 2) == false) goto L13;
        VSLandscapeTabsWidget r103 = this.f160016a;
        if (r103.f159925w == true) goto L11;
        VSLandscapeTabsWidget.Yq(r103);
    L11:
        this.f160016a.f159925w = true;
        return;
    L13:
        return;
    L5:
        r102 = r100;
        goto L6
    }
}
