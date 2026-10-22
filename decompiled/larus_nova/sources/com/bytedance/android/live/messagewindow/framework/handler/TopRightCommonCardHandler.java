package com.bytedance.android.live.messagewindow.framework.handler;

import android.content.Context;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import com.bytedance.android.livesdk.config.ny0;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.j3;
import com.bytedance.android.livesdkapi.depend.model.live.DslTypeInt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import m71.e;
import r71.f;

/* JADX INFO: loaded from: classes46.dex */
public final class TopRightCommonCardHandler extends a<i3> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Integer, i3> f83099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f83100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<Context> f83101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f83102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q71.a f83103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y61.a f83104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> f83105h;

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void h() {
        super.h();
        y61.a r100 = this.f83104g;
        if (r100 == null) goto L9;
        Map<Integer, i3> r101 = r100.getTopRightCardData();
        if (r101 == null) goto L9;
        if ((!r101.isEmpty()) == false) goto L9;
        this.f83099b = r101;
    L9:
        y61.a r102 = this.f83104g;
        if (r102 == null) goto L12;
        r102.setTopRightCardData(this.f83099b);
    L12:
        int r103 = e.f512327a;
        if (m71.b.f512324a.getValue().d() == true) goto L26;
        y61.a r104 = this.f83104g;
        if (r104 == null) goto L21;
        Map<MsgWindowPosition, Map<Integer, Pair<v61.a, g71.b>>> r105 = r104.getCardMapV2();
        if (r105 == null) goto L21;
        Map<Integer, Pair<v61.a, g71.b>> r106 = r105.get(MsgWindowPosition.TOP_RIGHT);
        if (r106 == null) goto L21;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f83106a = r106;
    L21:
        y61.a r107 = this.f83104g;
        if (r107 == null) goto L50;
        Map<MsgWindowPosition, Map<Integer, Pair<v61.a, g71.b>>> r108 = r107.getCardMapV2();
        if (r108 == null) goto L51;
        Map<Integer, Pair<v61.a, g71.b>> r109 = r108.put(MsgWindowPosition.TOP_RIGHT, this.f83106a);
        return;
    L51:
        return;
    L50:
        return;
    L26:
        y61.a r110 = this.f83104g;
        String r111 = null;
        if (r110 == null) goto L39;
        Map<w61.b, Map<Integer, Pair<v61.a, g71.b>>> r112 = r110.getCardMapV3();
        if (r112 == null) goto L39;
        DataCenter r113 = this.f83102e;
        if (r113 == null) goto L35;
        IRoom r114 = a0.n(r113);
        if (r114 == null) goto L35;
        String r115 = r114.getIdStr();
    L36:
        Map<Integer, Pair<v61.a, g71.b>> r116 = r112.get(new w61.b(r115, MsgWindowPosition.TOP_RIGHT));
        if (r116 == null) goto L39;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        this.f83106a = r116;
    L35:
        r115 = null;
    L39:
        y61.a r117 = this.f83104g;
        if (r117 == null) goto L53;
        Map<w61.b, Map<Integer, Pair<v61.a, g71.b>>> r118 = r117.getCardMapV3();
        if (r118 == null) goto L54;
        DataCenter r119 = this.f83102e;
        if (r119 == null) goto L48;
        IRoom r120 = a0.n(r119);
        if (r120 == null) goto L48;
        r111 = r120.getIdStr();
    L48:
        Map<Integer, Pair<v61.a, g71.b>> r121 = r118.put(new w61.b(r111, MsgWindowPosition.TOP_RIGHT), this.f83106a);
        return;
    L54:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final String c() {
        return this.f83100c;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void g() {
        super.g();
    }

    @Override // a71.a
    public final y61.a getCommonCardContext() {
        return this.f83104g;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a, a71.a
    public WeakReference<Context> getContext() {
        return this.f83101d;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void a(final z61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "commonCardEvent");
        super.a(r100);
        Map<Integer, i3> r101 = this.f83099b;
        if (r101 == null) goto L5;
        i3 r102 = r101.get(Integer.valueOf(r100.f570442b.getType()));
    L6:
        if (r102 == null) goto L22;
        Pair<v61.a, g71.b> r103 = this.f83106a.get(Integer.valueOf(r100.f570442b.getType()));
        if (r103 == null) goto L20;
        v61.a r104 = r103.getFirst();
        if (r104 == null) goto L20;
        if (this.f83105h.get(r104) != null) goto L20;
        this.f83105h.put(r104, r100.f570442b);
        y61.a r105 = this.f83104g;
        if (r105 == null) goto L20;
        final CompositeDisposable r106 = r105.registerCardCallback(r104, r100.f570442b.getType(), r100);
        if (r106 == null) goto L20;
        if (ny0.f120869a.getValue().booleanValue() == false) goto L20;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r107 = r100.f570442b;
        r107.f98965a = new TopRightCommonCardHandler$combineTypeCardRefresh$$inlined$let$lambda$1(r106, this, r100);
    L20:
        f(Integer.valueOf(r100.f570442b.getType()));
        return;
    L22:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void b(i3 r100) {
        i3 r101 = r100;
        super.b(r101);
        Integer r102 = r101.type;
        if (r102 == null) goto L25;
        int r103 = r102.intValue();
        Pair<v61.a, g71.b> r104 = this.f83106a.get(Integer.valueOf(r103));
        if (r104 == null) goto L9;
        g71.b r105 = r104.getSecond();
        if (r105 == null) goto L9;
        r105.reset();
    L9:
        Pair<v61.a, g71.b> r106 = this.f83106a.get(Integer.valueOf(r103));
        if (r106 == null) goto L14;
        v61.a r107 = r106.getFirst();
        if (r107 == null) goto L14;
        r107.dismiss();
    L14:
        this.f83106a.remove(Integer.valueOf(r103));
        this.f83099b.remove(Integer.valueOf(r103));
        Pair<v61.a, g71.b> r108 = this.f83106a.get(Integer.valueOf(r103));
        if (r108 == null) goto L26;
        v61.a r109 = r108.getFirst();
        if (r109 != null) goto L19;
        return;
    L19:
        if (e.b() == false) goto L23;
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r110 = this.f83105h.get(r109);
        if (r110 == null) goto L23;
        r110.a();
    L23:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r111 = this.f83105h.remove(r109);
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.handler.a
    public final void e(i3 r110, CommonCardInitScene r111) {
        i3 r100 = r110;
        Intrinsics.checkNotNullParameter(r111, "initScene");
        super.e(r100, r111);
        Pair<v61.a, g71.b> r101 = this.f83106a.get(r100.type);
        if (r101 == null) goto L37;
        v61.a r102 = r101.getFirst();
        if (r102 == null) goto L37;
        ICardLifecycle$State r103 = r102.A();
        if (r103 == null) goto L37;
        if (r103.isShowOrHide() != true) goto L37;
        j3 r104 = r100.cardDisplayInfo;
        if (r104 == null) goto L15;
        LiveDSLModel r105 = r104.dslDetail;
        if (r105 == null) goto L15;
        Long r106 = Long.valueOf(r105.getDslType());
    L16:
        long r107 = DslTypeInt.DslTypeSlice.getValue();
        if (r106 != null) goto L20;
    L22:
        long r108 = DslTypeInt.DslTypeLynxAir.getValue();
        if (r106 != null) goto L26;
    L32:
        Pair<v61.a, g71.b> r109 = this.f83106a.get(r100.type);
        if (r109 == null) goto L76;
        v61.a r112 = r109.getFirst();
        if (r112 == null) goto L76;
        r112.e(r100, null);
    L76:
        Integer r113 = r100.type;
        if (r113 == null) goto L80;
        i3 r114 = this.f83099b.put(Integer.valueOf(r113.intValue()), r100);
        return;
    L80:
        return;
    L26:
        if (r106.longValue() != r108) goto L32;
    L27:
        Pair<v61.a, g71.b> r115 = this.f83106a.get(r100.type);
        if (r115 == null) goto L76;
        v61.a r116 = r115.getFirst();
        if (r116 == null) goto L76;
        r116.R(r100);
        goto L76
    L20:
        if (r106.longValue() != r107) goto L22;
    L15:
        r106 = null;
    L37:
        Pair<v61.a, g71.b> r117 = this.f83106a.get(r100.type);
        if (r117 == null) goto L42;
        g71.b r118 = r117.getSecond();
        if (r118 == null) goto L42;
        r118.reset();
    L42:
        Intrinsics.checkNotNullParameter(r111, "initScene");
        d(r100, r111);
        Integer r119 = r100.type;
        int r120 = 0;
        if (r119 == null) goto L68;
        int r121 = r119.intValue();
        gm0.c r122 = new gm0.c(r100, this.f83102e);
        d r123 = new d(this);
        Intrinsics.checkNotNullParameter(r123, "showCardCallback");
        r122.f481649b = r123;
        Context r124 = getContext().get();
        if (r124 == null) goto L52;
        Map<Integer, Pair<v61.a, g71.b>> r125 = this.f83106a;
        Integer r126 = Integer.valueOf(r121);
        DataCenter r127 = this.f83102e;
        Integer r128 = r100.priority;
        if (r128 == null) goto L49;
        int r129 = r128.intValue();
    L50:
        r125.put(r126, TuplesKt.to(new com.bytedance.android.live.messagewindow.business.card.e(r100, r127, r121, r129, r124, r111), r122));
        goto L52
    L49:
        r129 = 0;
    L52:
        if (e.b() == false) goto L67;
        Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r130 = this.f83105h;
        if (r130 == null) goto L67;
        Pair<v61.a, g71.b> r131 = this.f83106a.get(Integer.valueOf(r121));
        if (r131 == null) goto L58;
        v61.a r132 = r131.getFirst();
    L59:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r133 = r130.get(r132);
        if (r133 == null) goto L62;
        r133.a();
    L62:
        Pair<v61.a, g71.b> r134 = this.f83106a.get(Integer.valueOf(r121));
        if (r134 == null) goto L65;
        v61.a r135 = r134.getFirst();
    L66:
        com.bytedance.android.live.room.api.messagewindow.builder.card.b r136 = (com.bytedance.android.live.room.api.messagewindow.builder.card.b) TypeIntrinsics.asMutableMap(r130).remove(r135);
        goto L67
    L65:
        r135 = null;
        goto L66
    L58:
        r132 = null;
    L67:
        r122.c();
    L68:
        q71.a r137 = this.f83103f;
        if (r137 == null) goto L76;
        q71.d<f> r138 = r137.c(r100.combineType, MsgWindowPosition.TOP_RIGHT);
        if (r138 == null) goto L76;
        int r139 = f.f536400d;
        Integer r140 = r100.type;
        if (r140 == null) goto L75;
        r120 = r140.intValue();
    L75:
        r138.b(f.a.a(r120, CardDataState.SHOW, r111));
        goto L76
    }

    public TopRightCommonCardHandler(WeakReference r100, DataCenter r101, q71.a r102, y61.a r103, Map r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "cardLifecycleMap");
        this.f83101d = r100;
        this.f83102e = r101;
        this.f83103f = r102;
        this.f83104g = r103;
        this.f83105h = r104;
        this.f83099b = new LinkedHashMap();
        this.f83100c = "TopRightCommonCardHandler";
    }
}
