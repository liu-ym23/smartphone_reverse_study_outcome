package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.e;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.PanelElementProvider;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.ComposePool;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.RedDotHelper;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import jp1.c;
import jp1.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kp1.b;

/* JADX INFO: loaded from: classes8.dex */
public abstract class PanelComposer implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f116588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b<lp1.b<Object>>> f116589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jp1.b f116590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.a f116591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PanelElementProvider f116592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f116593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TreeSet<RedDotDelegate> f116594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f116595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f116596i;

    @Override // jp1.c
    public final d<Object> d() {
        return (d) this.f116588a.getValue();
    }

    public abstract hp1.a e();

    @Override // jp1.c
    public final void release() {
        this.f116591d.b(AnonymousClass1.INSTANCE);
        ArrayList r100 = (ArrayList) this.f116589b;
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).release();
        goto L4
    L6:
        r100.clear();
        MorePanelDynamicControllerViewModel.Companion r102 = MorePanelDynamicControllerViewModel.Companion;
        jp1.b r103 = this.f116590c;
        if (r103 == null) goto L9;
        DataCenter r104 = r103.getDataCenter();
    L10:
        r102.getClass();
        k r105 = (k) MorePanelDynamicControllerViewModel.Companion.a(r104);
        if (r105 == null) goto L15;
        r105.cancelShowEffect();
        return;
    L15:
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // jp1.c
    public Context getContext() {
        return this.f116595h;
    }

    @Override // jp1.c
    public final void b(ArrayList<? extends e> r110) {
        Intrinsics.checkNotNullParameter(r110, "buttons");
        jp1.b r100 = this.f116590c;
        if (r100 != null) goto L5;
        return;
    L5:
        ip1.e r111 = d().a(r110);
        if (r111 == null) goto L81;
        Intrinsics.checkNotNullParameter(r111, "$this$asType");
        ArrayList<lp1.b<Object>> r112 = r111.f495265a;
        if (r112 == null) goto L98;
        boolean r101 = true;
        ViewGroup r102 = null;
        if ((!r112.isEmpty()) == true) goto L13;
        r112 = null;
    L13:
        if (r112 == null) goto L99;
        jp1.b r103 = this.f116590c;
        if (r103 == null) goto L19;
        DataCenter r104 = r103.getDataCenter();
        if (r104 == null) goto L19;
        boolean r105 = z.e(r104, false);
    L21:
        if (c4.a(r105) == false) goto L46;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r112.iterator();
    L24:
        if (r107.hasNext() == false) goto L26;
        CollectionsKt.addAll(r106, ((lp1.b) r107.next()).getChildren());
        goto L24
    L26:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r106.iterator();
    L28:
        if (r109.hasNext() == false) goto L33;
        Object r113 = r109.next();
        if ((r113 instanceof lp1.a) == false) goto L28;
        r108.add(r113);
        goto L28
    L33:
        if ((!r108.isEmpty()) == true) goto L36;
        r108 = null;
    L36:
        if (r108 == null) goto L46;
        this.f116594g.clear();
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r115 = r108.iterator();
    L39:
        if (r115.hasNext() == false) goto L41;
        r114.add(((lp1.a) r115.next()).getButton().f115921m);
        goto L39
    L41:
        jp1.b r116 = this.f116590c;
        if (r116 == null) goto L44;
        x3 r117 = r116.getToolbarManager();
    L45:
        RedDotHelper.b(r114, r117, this.f116594g);
        goto L46
    L44:
        r117 = null;
    L46:
        ArrayList r118 = (ArrayList) this.f116589b;
        Iterator r119 = r118.iterator();
    L48:
        if (r119.hasNext() == false) goto L55;
        b r120 = (b) r119.next();
        ComposePool.c(this.f116591d, r120);
        View r121 = r120.e();
        if (r121 == null) goto L48;
        ViewGroup r122 = this.f116593f;
        if (r122 == null) goto L54;
        r122.removeView(r121);
    L54:
        r120.i();
        goto L48
    L55:
        r118.clear();
        ViewGroup r123 = this.f116593f;
        if (r123 != null) goto L58;
    L69:
        Iterator<T> r124 = r112.iterator();
    L71:
        if (r124.hasNext() == false) goto L100;
        lp1.b r125 = (lp1.b) r124.next();
        Intrinsics.checkNotNullParameter(r125, "elementModel");
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        b<? extends lp1.b<Object>> r126 = this.f116591d.a(r125.getElementType());
        if (r126 != null) goto L75;
        r126 = this.f116592e.a(new kp1.a(r125.getElementType(), r100));
        Intrinsics.checkNotNullParameter(r126, "$this$asType");
    L75:
        ((ArrayList) this.f116589b).add(r126);
        ViewGroup r127 = this.f116593f;
        if (r127 == null) goto L80;
        View r128 = r126.c(r127);
        if (r128 == null) goto L80;
        r128.setTag(R.id.ttlive_more_panel_view_tag_of_element, r126);
    L80:
        r126.h(r125);
        goto L71
    L100:
        return;
    L58:
        if (r123.getChildCount() > 0) goto L61;
        r101 = false;
    L61:
        if (r101 == false) goto L63;
        r102 = r123;
    L63:
        if (r102 == null) goto L69;
        Sequence<View> r129 = UtilityKotlinExtentionsKt.g(r102);
        if (r129 == null) goto L69;
        Sequence r130 = SequencesKt.mapNotNull(r129, new PanelComposer$resetPanel$3(this));
        if (r130 == null) goto L69;
        SequencesKt.onEach(r130, new PanelComposer$resetPanel$4(this));
    L19:
        r105 = true;
        goto L21
    L99:
        return;
    L98:
        return;
    }

    @Override // jp1.c
    public void c(hp1.c r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f116590c = r100;
        this.f116593f = (ViewGroup) r100.findView(R.id.panel_container);
        if (g.b() == false) goto L5;
        int r101 = -1;
    L6:
        MoreMixSharePanelUtils r102 = MoreMixSharePanelUtils.INSTANCE;
        jp1.b r103 = this.f116590c;
        boolean r104 = true;
        if (r103 == null) goto L11;
        DataCenter r105 = r103.getDataCenter();
        if (r105 == null) goto L11;
        boolean r106 = z.e(r105, false);
    L12:
        DataCenter r107 = this.f116596i;
        if (r107 == null) goto L16;
        r104 = z.m(r107, true);
    L16:
        if (r102.isMoreMixShareMode(r106, r104) == false) goto L18;
        r101 = ColorProtector.parseColor("#F3F3F4");
    L18:
        ViewGroup r108 = this.f116593f;
        if (r108 == null) goto L22;
        r108.setBackgroundColor(r101);
        return;
    L22:
        return;
    L11:
        r106 = true;
        goto L12
    L5:
        r101 = (int) 4279638051L;
        goto L6
    }

    public PanelComposer(Context r100, DataCenter r101) {
        this.f116595h = r100;
        this.f116596i = r101;
        this.f116588a = LazyKt.lazy(new PanelComposer$dataProcessor$2(this));
        this.f116589b = new ArrayList();
        this.f116591d = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.a();
        this.f116592e = PanelElementProvider.f116546b;
        this.f116594g = new TreeSet();
    }
}
