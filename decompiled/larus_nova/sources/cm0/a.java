package cm0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.messagewindow.builder.card.CardMountingsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements u61.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.room.api.messagewindow.builder.card.a f24152a;

    public a() {
    }

    public final dm0.a b() {
        com.bytedance.android.live.room.api.messagewindow.builder.card.a r100 = this.f24152a;
        if (r100 != null) goto L10;
        IllegalStateException r101 = new IllegalStateException("you must call assemble() method before build()");
        i r102 = ((IMiddlewareMsgWindowService) k.n(IMiddlewareMsgWindowService.class)).cardMonitor();
        if (r102 == null) goto L11;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        Intrinsics.checkNotNullParameter(r101, "tr");
        r103.f98996a = r101;
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
        throw r101;
    L11:
        throw r101;
    L10:
        return new dm0.a(r100);
    }

    @Override // u61.a
    public final a a(Function1 r110) {
        Intrinsics.checkNotNullParameter(r110, "init");
        CardMountingsBuilder r100 = new CardMountingsBuilder();
        r110.invoke(r100);
        if (Intrinsics.areEqual(r100.f98925c, CardMountingsBuilder.c.f98939a) == false) goto L5;
    L6:
        Intrinsics.checkNotNullParameter("the identity or priority must be not null, you can call initCard() method to init", "msg");
        Intrinsics.checkNotNullParameter("the identity or priority must be not null, you can call initCard() method to init", "msg");
        IllegalArgumentException r101 = new IllegalArgumentException("the identity or priority must be not null, you can call initCard() method to init");
        ALogger.e("ICardBuildCheck", r101);
        if (v.a() == true) goto L10;
    L8:
        this.f24152a = new com.bytedance.android.live.room.api.messagewindow.builder.card.a(r100.f98923a, r100.f98925c, r100.f98926d, r100.f98924b, r100.f98927e, r100.f98928f, r100.f98929g, r100.f98930h, r100.f98931i);
        return this;
    L10:
        throw r101;
    L5:
        if (r100.f98926d != Integer.MIN_VALUE) goto L8;
        goto L6
    }
}
