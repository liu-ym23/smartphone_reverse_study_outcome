package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h0 extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class<? extends Widget> f159961d;

    public h0(long r100, String r101, Class<? extends Widget> r102) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "widgetClass");
        super(TabType.IS_WIDGET_TAB, r100, r101);
        this.f159961d = r102;
    }
}
