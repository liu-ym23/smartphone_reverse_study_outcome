package com.bytedance.android.livesdk.chatroom.distribution;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.widgetdescriptor.template.distribution.externalinjectcomponent.ExternalInjectWrapperWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f105741a;

    public c(d r100) {
        this.f105741a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual((Boolean) r100, r101) == false) goto L38;
        d r102 = this.f105741a;
        r102.getClass();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L33
        ExternalInjectWrapperWidget r104 = (ExternalInjectWrapperWidget) ((LinkedHashMap) r102.f105743b).get("ec_shop_live_bottom_guide");     // Catch: Throwable -> L33
        if (r104 == null) goto L30;
        FrameLayout r105 = r102.f105744c;     // Catch: Throwable -> L33
        if (r105 == null) goto L30;
        DataCenter r106 = r102.f105746e;     // Catch: Throwable -> L33
        if (r106 == null) goto L15;
        Boolean r107 = (Boolean) r106.get("data_is_portrait", r101);     // Catch: Throwable -> L33
        if (r107 == null) goto L15;
        boolean r108 = r107.booleanValue();     // Catch: Throwable -> L33
    L16:
        if (r108 == false) goto L29;
        FrameLayout r109 = r102.f105745d;     // Catch: Throwable -> L33
        if (r109 == null) goto L20;
        r109.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));     // Catch: Throwable -> L33
    L20:
        FrameLayout r110 = r102.f105744c;     // Catch: Throwable -> L33
        if (r110 == null) goto L23;
        r110.setVisibility(0);     // Catch: Throwable -> L33
    L23:
        WidgetManager r111 = r102.f105748g;     // Catch: Throwable -> L33
        if (r111 == null) goto L26;
        r111.load(r105, r104, false);     // Catch: Throwable -> L33
    L26:
        DataCenter r112 = r102.f105746e;     // Catch: Throwable -> L33
        if (r112 == null) goto L29;
        r112.observe("data_is_portrait", new a(r105));     // Catch: Throwable -> L33
    L29:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L33
    L31:
        Result.m9449constructorimpl(r113);     // Catch: Throwable -> L33
        return;
    L15:
        r108 = true;
    L30:
        r113 = null;
    L33:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }
}
