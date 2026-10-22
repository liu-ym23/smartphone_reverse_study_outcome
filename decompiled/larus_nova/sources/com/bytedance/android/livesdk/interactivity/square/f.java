package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f141161a;

    public f(g r100) {
        this.f141161a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((com.bytedance.android.livesdk.interactivity.api.base.d) r100).f132904a != PublicScreenAreaPageType.Square) goto L5;
        boolean r101 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).setNeedShowGiftEffectSwitch(false);
        DataCenter r102 = this.f141161a.f141168g;
        j32.a r103 = new j32.a();
        r103.f497099a = 9;
        r103.f497100b = false;
        Unit r104 = Unit.INSTANCE;
        r102.put("cmd_enter_widget_visible_change", r103);
        return;
    L5:
        DataCenter r105 = this.f141161a.f141168g;
        j32.a r106 = new j32.a();
        r106.f497099a = 9;
        r106.f497100b = true;
        Unit r107 = Unit.INSTANCE;
        r105.put("cmd_enter_widget_visible_change", r106);
    }
}
