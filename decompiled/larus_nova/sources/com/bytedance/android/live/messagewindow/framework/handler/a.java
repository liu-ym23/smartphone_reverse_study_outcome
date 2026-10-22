package com.bytedance.android.live.messagewindow.framework.handler;

import android.content.Context;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant$Position;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.m1;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a<T> implements a71.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, Pair<v61.a, g71.b>> f83106a;

    public String c() {
        return "AbsCommonCardHandler";
    }

    @Override // a71.a
    public abstract /* synthetic */ WeakReference<Context> getContext();

    public a() {
        this.f83106a = new LinkedHashMap();
    }

    public void g() {
        i r100 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r100 == null) goto L7;
        CardAlogParamsBuilder r101 = new CardAlogParamsBuilder();
        r101.d(c());
        r101.c("onHandlerDestroy");
        Unit r102 = Unit.INSTANCE;
        r100.d(r101.b());
        return;
    }

    public void h() {
        i r100 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r100 == null) goto L7;
        CardAlogParamsBuilder r101 = new CardAlogParamsBuilder();
        r101.d(c());
        r101.c("onInit");
        Unit r102 = Unit.INSTANCE;
        r100.d(r101.b());
        return;
    }

    public void a(z61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "commonCardEvent");
        i r101 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r101 == null) goto L12;
        CardAlogParamsBuilder r102 = new CardAlogParamsBuilder();
        r102.d(c());
        r102.c("combineTypeCardRefresh");
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r103 = r100.f570442b;
        if (r103 == null) goto L10;
        String r104 = r103.f98971g;
        if (r104 == null) goto L10;
        r102.a("card data info", r104);
    L10:
        Unit r105 = Unit.INSTANCE;
        r101.d(r102.b());
        return;
    }

    public void b(T r100) {
        i r101 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r101 == null) goto L7;
        CardAlogParamsBuilder r102 = new CardAlogParamsBuilder();
        r102.d(c());
        r102.c("destroyCard");
        Unit r103 = Unit.INSTANCE;
        r101.d(r102.b());
        return;
    }

    public final void f(Integer r100) {
        if (r100 == null) goto L16;
        r100.intValue();
        i r101 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r101 == null) goto L10;
        CardAlogParamsBuilder r102 = new CardAlogParamsBuilder();
        r102.d(c());
        r102.c("onCardShow");
        String r103 = String.valueOf(r100.intValue());
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r102.a("cardType", r103);
        Unit r104 = Unit.INSTANCE;
        r101.d(r102.b());
    L10:
        Pair<v61.a, g71.b> r105 = this.f83106a.get(r100);
        if (r105 == null) goto L17;
        v61.a r106 = r105.getFirst();
        if (r106 == null) goto L18;
        r106.show();
        return;
    L18:
        return;
    L17:
        return;
    }

    public void i(h r100) {
        i r101 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r101 == null) goto L7;
        CardAlogParamsBuilder r102 = new CardAlogParamsBuilder();
        r102.d(c());
        r102.c("recreateCard");
        Unit r103 = Unit.INSTANCE;
        r101.d(r102.b());
        return;
    }

    public final void d(T r100, CommonCardInitScene r101) {
        Intrinsics.checkNotNullParameter(r101, "initScene");
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L6;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d(c());
        r103.c("initCommonCard");
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
    L6:
        i r105 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r105 == null) goto L42;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r106 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_init");
        boolean r107 = r100 instanceof m1;
        Integer r108 = null;
        if (r107 == true) goto L12;
        Object r109 = null;
    L14:
        if (((m1) r109) == null) goto L16;
        Integer r110 = Integer.valueOf(CommonCardConstant$Position.BOTTOM_RIGHT.getValue());
    L24:
        r106.b("position", r110);
        if (r107 == true) goto L27;
        Object r111 = null;
    L28:
        m1 r112 = (m1) r111;
        if (r112 == null) goto L34;
        Integer r113 = r112.type;
        if (r113 == null) goto L34;
        r108 = r113;
    L40:
        r106.b("type", r108);
        r106.b("init_scene", r101);
        Unit r114 = Unit.INSTANCE;
        r105.b(r106.a());
        return;
    L34:
        boolean r115 = r100 instanceof i3;
        Object r116 = r100;
        if (r115 == true) goto L37;
        r116 = (T) null;
    L37:
        i3 r117 = (i3) r116;
        if (r117 == null) goto L40;
        r108 = r117.type;
        goto L40
    L27:
        r111 = r100;
        goto L28
    L16:
        if ((r100 instanceof i3) == true) goto L18;
        Object r118 = null;
    L19:
        i3 r119 = (i3) r118;
        if (r119 == null) goto L22;
        r110 = r119.domain;
        goto L24
    L22:
        r110 = null;
        goto L24
    L18:
        r118 = r100;
        goto L19
    L12:
        r109 = r100;
        goto L14
    }

    public void e(T r100, CommonCardInitScene r101) {
        Intrinsics.checkNotNullParameter(r101, "initScene");
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L7;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d(c());
        r103.c("initOrRefreshCard");
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
        return;
    }

    public final void j(com.bytedance.android.live.room.api.messagewindow.builder.card.b r100, CompositeDisposable r101) {
        Intrinsics.checkNotNullParameter(r100, "commonCard");
        Intrinsics.checkNotNullParameter(r101, "cd");
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L6;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d(c());
        r103.c("combineCardRelease");
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
    L6:
        y61.a r105 = getCommonCardContext();
        if (r105 == null) goto L10;
        r105.unRegisterCardCallback(r100, r101);
        return;
    }
}
