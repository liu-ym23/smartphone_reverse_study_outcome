package com.bytedance.android.live.effect;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68829a;

    public t(LiveEffectContextFactoryDelegate$Type r100) {
        this.f68829a = r100;
    }

    public void onEvent(com.bytedance.android.live.effect.gesture.a r100) {
        if (r100 == null) goto L14;
        int r101 = r100.f68016a;
        com.bytedance.android.live.effect.gesture.a.C1112a r102 = r100.f68017b;
        switch(r101) {
            case 201: goto L12;
            case 202: goto L11;
            case 203: goto L10;
            case 204: goto L9;
            case 205: goto L8;
            case 206: goto L7;
            case 207: goto L6;
            default: goto L21;
        };
    L6:
        long r103 = r102.f68021d;
        LiveEffectContextFactoryDelegate$Type r104 = this.f68829a;
        List<String> r105 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r104).e().e().g();
        return;
    L7:
        float r106 = r102.f68019b;
        LiveEffectContextFactoryDelegate$Type r107 = this.f68829a;
        List<String> r108 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r107).e().e().a();
        return;
    L8:
        float r109 = r102.f68020c;
        LiveEffectContextFactoryDelegate$Type r110 = this.f68829a;
        List<String> r111 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r110).e().e().e();
        return;
    L9:
        float r112 = r102.f68019b;
        LiveEffectContextFactoryDelegate$Type r113 = this.f68829a;
        List<String> r114 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r113).e().e().f();
        return;
    L10:
        float r115 = r102.f68019b;
        LiveEffectContextFactoryDelegate$Type r116 = this.f68829a;
        List<String> r117 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r116).e().e().d();
        return;
    L11:
        float r118 = r102.f68019b;
        LiveEffectContextFactoryDelegate$Type r119 = this.f68829a;
        List<String> r120 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r119).e().e().c();
        return;
    L12:
        float r121 = r102.f68019b;
        LiveEffectContextFactoryDelegate$Type r122 = this.f68829a;
        List<String> r123 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r122).e().e().b();
        return;
    L21:
        return;
    }
}
