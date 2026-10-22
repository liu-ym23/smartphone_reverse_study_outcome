package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AudienceHeightFixMode;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutAlign;
import com.bytedance.live.layout.LayoutScale;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import t51.g;
import t51.i;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lt51/g;", AbsMethodDelegate.TAG_INVOKE, "()Lt51/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DefaultConfig$gameHorizontalConfig$2 extends FunctionReferenceImpl implements Function0<g> {
    public DefaultConfig$gameHorizontalConfig$2(DefaultConfig r100) {
        super(0, r100, DefaultConfig.class, "initGameLinkHorizontalConfig", "initGameLinkHorizontalConfig()Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/RevLayoutConfig;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final g invoke2() {
        DefaultConfig r100 = (DefaultConfig) this.receiver;
        int r101 = DefaultConfig.f98578m;
        r100.getClass();
        g r102 = new g();
        LinkedHashMap r103 = new LinkedHashMap();
        Integer r104 = Integer.valueOf(DeviceType.NORMAL_MOBILE_H.ordinal());
        t51.a r105 = new t51.a();
        AdjustBase r106 = AdjustBase.CONTENT;
        r105.m(r106.ordinal());
        LayoutScale r107 = LayoutScale.ASPECT_FIT;
        r105.t(r107.ordinal());
        LayoutAlign r108 = LayoutAlign.CENTER;
        r105.n(r108.ordinal());
        r105.s();
        AudienceHeightFixMode r109 = AudienceHeightFixMode.OriginContainerHeight;
        r105.r(r109.ordinal());
        i r110 = new i();
        r110.j(0.0f);
        r110.m(0.0f);
        r110.k(1.0f);
        r110.i(1.0f);
        Unit r111 = Unit.INSTANCE;
        r105.v(r110);
        r103.put(r104, r105);
        Integer r112 = Integer.valueOf(DeviceType.PAD_H.ordinal());
        t51.a r113 = new t51.a();
        r113.m(r106.ordinal());
        r113.t(r107.ordinal());
        r113.n(r108.ordinal());
        r113.r(r109.ordinal());
        i r114 = new i();
        r114.j(0.0f);
        r114.m(0.0f);
        r114.k(1.0f);
        r114.i(1.0f);
        r113.v(r114);
        r103.put(r112, r113);
        r102.g(r103);
        return r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ g invoke() {
        return invoke2();
    }
}
