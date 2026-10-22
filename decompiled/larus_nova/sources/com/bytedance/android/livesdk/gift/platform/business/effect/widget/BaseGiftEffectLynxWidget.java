package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoDraggableView;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.GiftEffectInfoFullScreenView;
import com.bytedance.android.livesdk.gift.platform.business.effect.service.ViewIdentifier;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import i12.e;
import i12.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l02.f;
import l02.g;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseGiftEffectLynxWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", "getIdentifier", "()Lcom/bytedance/android/livesdk/gift/platform/business/effect/service/ViewIdentifier;", LocationMonitorConst.IDENTIFIER, "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseGiftEffectLynxWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewIdentifier f129550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, zy0.b> f129551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, GiftEffectInfoFullScreenView> f129552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, GiftEffectInfoDraggableView> f129553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f129554e;

    public static final class a {
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGiftEffectLynxWidget f129555a;

        public b(BaseGiftEffectLynxWidget r100) {
            this.f129555a = r100;
        }

        @Override // l02.g
        public final void a(int r100, String r101, String r102) {
            this.f129555a.xq(r100, r101, r102);
        }

        @Override // l02.g
        public final void b(int r110, boolean r111, float r112, String r113, boolean r114, String r115, String r116) {
            Intrinsics.checkNotNullParameter(r113, "schema");
            this.f129555a.Aq(r110, r111, r112, r113, r114, r115, r116);
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public int getLayoutId() {
        return R.layout.ttlive_gift_effect_info_lynx_widget;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onInit(Object[] r100) {
    }

    public BaseGiftEffectLynxWidget() {
        this.f129550a = ViewIdentifier.Operation;
        this.f129551b = new LinkedHashMap();
        this.f129552c = new LinkedHashMap();
        this.f129553d = new LinkedHashMap();
        this.f129554e = new b(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        e r100 = o.b();
        if (r100 == null) goto L5;
        m.f163449e.getClass();
        com.bytedance.android.scope.o r101 = (com.bytedance.android.scope.o) m.b(r100).a(Reflection.getOrCreateKotlinClass(f.class));
    L6:
        f r102 = (f) r101;
        if (r102 == null) goto L9;
        b r103 = this.f129554e;
        Intrinsics.checkNotNullParameter(r103, "listener");
        ((ArrayList) r102.f506859a).remove(r103);
    L9:
        Iterator r104 = ((LinkedHashMap) this.f129551b).entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        zy0.b r105 = (zy0.b) ((Map.Entry) r104.next()).getValue();
        if (r105 == null) goto L11;
        r105.dispose();
        goto L11
    L15:
        ((LinkedHashMap) this.f129551b).clear();
        Iterator r106 = ((LinkedHashMap) this.f129552c).values().iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        zq((GiftEffectInfoFullScreenView) r106.next());
        goto L17
    L19:
        Iterator r107 = ((LinkedHashMap) this.f129553d).values().iterator();
    L21:
        if (r107.hasNext() == false) goto L23;
        zq((GiftEffectInfoDraggableView) r107.next());
        goto L21
    L23:
        ((LinkedHashMap) this.f129552c).clear();
        ((LinkedHashMap) this.f129553d).clear();
        return;
    L5:
        r101 = null;
        goto L6
    }

    public ViewIdentifier getIdentifier() {
        return this.f129550a;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onLoad(Object[] r100) {
        e r101 = o.b();
        if (r101 == null) goto L5;
        m.f163449e.getClass();
        com.bytedance.android.scope.o r102 = (com.bytedance.android.scope.o) m.b(r101).a(Reflection.getOrCreateKotlinClass(f.class));
    L6:
        f r103 = (f) r102;
        if (r103 == null) goto L10;
        b r104 = this.f129554e;
        Intrinsics.checkNotNullParameter(r104, "listener");
        ((ArrayList) r103.f506859a).add(r104);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void yq(String r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        zy0.b r101 = (zy0.b) ((LinkedHashMap) this.f129551b).get(r100);
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f129551b.remove(r100);
    }

    public final void zq(View r100) {
        if (getIdentifier() != ViewIdentifier.MediaContainer) goto L5;
        ((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).C2(r100);
        return;
    L5:
        this.containerView.removeView(r100);
    }

    public final void wq(String r100, ViewGroup r101, String r102) {
        if (((LinkedHashMap) this.f129551b).get(r102) == null) goto L6;
        yq(r102);
    L6:
        if (c.a() == false) goto L8;
        zy0.b r103 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(this.context, UriProtector.parse(r100), null);
    L9:
        if (r103 != null) goto L11;
        return;
    L11:
        if (((Boolean) c.f129624c.getValue(null, c.f129622a[1])).booleanValue() == true) goto L22;
    L17:
        r101.addView(r103.c());
        xy0.a<?> r104 = r103.g();
        if (r104 == null) goto L20;
        r104.load();
    L20:
        this.f129551b.put(r102, r103);
        return;
    L22:
        r103.x();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ALogger.e("BaseGiftEffectLynxWidget", "registerKryptonServices error " + e);
        e.printStackTrace();
        goto L17
    L8:
        r103 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(this.context, UriProtector.parse(r100), null);
        goto L9
    }

    public void xq(int r100, String r101, String r102) {
        if (r102 != null) goto L5;
        r102 = ViewIdentifier.Operation.getValue();
    L5:
        if ((!Intrinsics.areEqual(r102, getIdentifier().getValue())) == false) goto L7;
        return;
    L7:
        if (r101 != null) goto L9;
        r101 = "default";
    L9:
        Intrinsics.checkNotNullParameter(r101, "channel");
        if (r100 == 0) goto L19;
        if (r100 == 1) goto L14;
        return;
    L14:
        if (((LinkedHashMap) this.f129553d).get(r101) == null) goto L24;
        yq(r101);
        GiftEffectInfoDraggableView r103 = this.f129553d.remove(r101);
        if (r103 == null) goto L25;
        zq(r103);
        return;
    L25:
        return;
    L24:
        return;
    L19:
        if (((LinkedHashMap) this.f129552c).get(r101) == null) goto L27;
        yq(r101);
        GiftEffectInfoFullScreenView r104 = this.f129552c.remove(r101);
        if (r104 == null) goto L28;
        zq(r104);
        return;
    L28:
        return;
    }

    public void Aq(int r100, boolean r101, float r102, String r103, boolean r104, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r103, "schema");
        if (r111 != null) goto L6;
        r111 = ViewIdentifier.Operation.getValue();
    L6:
        if ((!Intrinsics.areEqual(r111, getIdentifier().getValue())) == false) goto L8;
        return;
    L8:
        int r112 = 0;
        int r105 = 6;
        AttributeSet r106 = null;
        if (r100 == 0) goto L25;
        if (r100 != 1) goto L37;
        if (r110 != null) goto L14;
        r110 = "default";
    L14:
        View r107 = (GiftEffectInfoDraggableView) ((LinkedHashMap) this.f129553d).get(r110);
        if (r107 == null) goto L17;
        zq(r107);
    L17:
        GiftEffectInfoDraggableView r108 = new GiftEffectInfoDraggableView(this.containerView.getContext(), r106, r105, r112);
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(-2, -2);
        int r113 = s1.f(r102);
        if (r102 < 0.0f) goto L20;
        ((ViewGroup.MarginLayoutParams) r109).topMargin = r113;
    L20:
        r108.setLayoutParams(r109);
        r108.setDraggable(r101);
        r108.setTopMarginPx(r113);
        this.f129553d.put(r110, r108);
        if (getIdentifier() != ViewIdentifier.MediaContainer) goto L23;
        ((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).c3(r108);
    L24:
        wq(r103, r108, r110);
        return;
    L23:
        this.containerView.addView(r108);
        goto L24
    L37:
        return;
    L25:
        if (r110 != null) goto L27;
        r110 = "default";
    L27:
        View r114 = (GiftEffectInfoFullScreenView) ((LinkedHashMap) this.f129552c).get(r110);
        if (r114 == null) goto L30;
        zq(r114);
    L30:
        GiftEffectInfoFullScreenView r115 = new GiftEffectInfoFullScreenView(this.containerView.getContext(), null, 6, 0);
        r115.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r115.setTouchable(r104);
        this.f129552c.put(r110, r115);
        if (getIdentifier() != ViewIdentifier.MediaContainer) goto L33;
        ((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).c3(r115);
    L34:
        wq(r103, r115, r110);
        return;
    L33:
        this.containerView.addView(r115);
        goto L34
    }
}
