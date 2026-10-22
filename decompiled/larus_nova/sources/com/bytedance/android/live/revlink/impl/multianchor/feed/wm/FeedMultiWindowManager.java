package com.bytedance.android.live.revlink.impl.multianchor.feed.wm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import b31.d;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.g;
import com.bytedance.android.live.revlink.impl.multianchor.feed.breakthrough.FeedMultiBreakThroughBarManager;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.FeedMultiPlayUiResolver;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.e;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.FeedMultiLynxContainer;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.a;
import com.bytedance.android.live.revlink.impl.multianchor.feed.machine.c;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.FeedMultiPlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h;
import com.bytedance.android.live.revlink.impl.multianchor.ui.b;
import com.bytedance.android.live.revlink.impl.multianchor.ui.s;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiFeedUtils;
import com.bytedance.android.live.revlink.impl.pk.ui.IMProgressBarLayout;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.obric.sva.sdk.data.ISmModel;
import f31.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k31.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class FeedMultiWindowManager implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<List<k>> f94338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f94339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FeedMultiPlayUiResolver f94340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f94341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w21.a f94342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.b f94343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.live.revlink.impl.multianchor.feed.b> f94344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IRoom f94345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f94346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FeedMultiLynxContainer f94347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b f94348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f94349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f94350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f94351n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FeedMultiBreakThroughBarManager f94352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final FrameLayout f94353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.player.b f94354q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f94355r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f94356s;

    public final void a() {
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r100 = this.f94348k;
        FrameLayout r101 = null;
        if (r100 == null) goto L5;
        FeedMultiPlayMode r102 = r100.f94284d;
    L6:
        boolean r103 = false;
        if (r102 != FeedMultiPlayMode.BREAK_THROUGH) goto L17;
        FeedMultiBreakThroughBarManager r104 = this.f94352o;
        if (r104 == null) goto L12;
        r101 = r104.f94106b;
    L12:
        if (b(com.bytedance.android.live.revlink.impl.multianchor.dynamic.k.a.f94088b) == false) goto L14;
    L15:
        r103 = true;
    L16:
        c(r101, r103);
        return;
    L14:
        if (z41.g.f569928o.a() == false) goto L16;
    L17:
        c(null, false);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void d() {
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r100 = this.f94348k;
        if (r100 != null) goto L5;
        return;
    L5:
        f r101 = this.f94349l;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f94346i == false) goto L145;
        UtilityKotlinExtentionsKt.w(this.f94353p);
        e r102 = this.f94340c.a(this.f94354q.f94272f.f94264a, r100, r101, new FeedMultiWindowManager$updateLayout$layoutState$1(this));
        ArrayList r103 = null;
        if (this.f94356s == false) goto L69;
        w21.a r104 = this.f94342e;
        com.bytedance.android.live.revlink.impl.multianchor.feed.player.a r105 = this.f94354q.f94272f;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "frameState");
        Intrinsics.checkNotNullParameter(r102, "layoutState");
        Intrinsics.checkNotNullParameter(r105, "containerSize");
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.b r106 = r102.f94195c;
        int r107 = 0;
        if (r106 != null) goto L15;
    L17:
        boolean r108 = false;
    L18:
        if (r108 == true) goto L24;
        IMProgressBarLayout r109 = r104.f557984b;
        if (r109 == null) goto L22;
        r104.f557986d.removeView(r109);
    L22:
        r104.f557984b = null;
    L106:
        FeedMultiLynxContainer r110 = this.f94347j;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r102, "layoutState");
        b31.e r111 = r102.f94194b;
        if (r111 == null) goto L150;
        int r112 = r111.f17175a;
        int r113 = r111.f17176b;
        int r114 = r111.f17177c;
        int r115 = r111.f17178d;
        if (r110.f94207b == true) goto L119;
        FrameLayout r116 = (FrameLayout) r110.f94206a.getValue();
        if (r116 == null) goto L118;
        ViewParent r117 = r116.getParent();
        if (r117 == null) goto L118;
        if ((r117 instanceof ViewGroup) == false) goto L118;
        ((ViewGroup) r117).removeView(r116);
    L118:
        r110.f94209d.addView((FrameLayout) r110.f94206a.getValue(), -1, -1);
        r110.f94207b = true;
    L119:
        MutableLiveData<List<k>> r118 = r110.f94210e;
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f r119 = r102.f94196d;
        if (r119 == null) goto L143;
        Map<String, com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.g> r120 = r119.f94199a;
        if (r120 == null) goto L143;
        r103 = new ArrayList(r120.size());
        Iterator<Map.Entry<String, com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.g>> r121 = r120.entrySet().iterator();
    L125:
        if (r121.hasNext() == false) goto L143;
        Map.Entry<String, com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.g> r122 = r121.next();
        String r123 = r122.getKey();
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.g r124 = r122.getValue();
        Double r125 = r124.f94204c;
        if (r125 == null) goto L129;
        float r126 = (float) r125.doubleValue();
    L130:
        float r127 = r112;
        int r128 = ((int) (r126 * r127)) + r115;
        Double r129 = r124.f94205d;
        if (r129 == null) goto L133;
        float r130 = (float) r129.doubleValue();
    L134:
        float r131 = r113;
        int r132 = ((int) (r130 * r131)) + r114;
        Double r133 = r124.f94202a;
        if (r133 == null) goto L137;
        float r134 = (float) r133.doubleValue();
    L138:
        int r135 = (int) (r134 * r127);
        Double r136 = r124.f94203b;
        if (r136 == null) goto L141;
        float r137 = (float) r136.doubleValue();
    L142:
        r103.add(new k(r123, "", r128, r132, r135, (int) (r137 * r131), false, true, 0, ISmModel.VERSION_0300, 0));
        r115 = r115;
        r121 = r121;
        r112 = r112;
        goto L125
    L141:
        r137 = 0.0f;
        goto L142
    L137:
        r134 = 0.0f;
        goto L138
    L133:
        r130 = 0.0f;
        goto L134
    L129:
        r126 = 0.0f;
    L143:
        r118.setValue(r103);
        return;
    L150:
        return;
    L24:
        if (r104.f557984b != null) goto L27;
        IMProgressBarLayout r138 = new IMProgressBarLayout(r104.f557985c);
        r138.a(false, 0, 0);
        r138.setLayerType(1, null);
        r104.f557986d.addView(r138);
        r104.f557984b = r138;
    L27:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r139 = r100.f94285e;
        if ((r139 instanceof h) == true) goto L30;
        r139 = null;
    L30:
        h r140 = (h) r139;
        if (r140 == null) goto L50;
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.f r141 = r140.f94307c;
        if (r100.f94284d != FeedMultiPlayMode.VOTE) goto L36;
        boolean r142 = true;
    L37:
        IMProgressBarLayout r143 = r104.f557984b;
        if (r143 == null) goto L50;
        if (r141 == null) goto L43;
        Integer r144 = r141.f94302b;
        if (r144 == null) goto L43;
        int r145 = r144.intValue();
    L44:
        long r146 = r145;
        if (r141 == null) goto L49;
        Integer r147 = r141.f94303c;
        if (r147 == null) goto L49;
        r107 = r147.intValue();
    L49:
        r143.a(r142, r146, r107);
    L43:
        r145 = 0;
        goto L44
    L36:
        r142 = false;
    L50:
        Boolean r148 = r102.f94193a;
        if (r148 == null) goto L106;
        r148.booleanValue();
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.b r149 = r102.f94195c;
        if (r149 == null) goto L106;
        s r150 = r149.f94190b;
        if (r150 == null) goto L106;
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f r151 = r102.f94196d;
        if (r151 == null) goto L106;
        Integer r152 = r151.f94200b;
        if (r152 == null) goto L106;
        int r153 = r152.intValue();
        b31.e r154 = r102.f94194b;
        if (r154 == null) goto L106;
        int r155 = r154.f17179e;
        int r156 = r154.f17180f;
        r104.f557983a.getClass();
        b31.a r157 = d.a(r150, r153, r155, r156);
        if (r157 == null) goto L106;
        IMProgressBarLayout r158 = r104.f557984b;
        if (r158 == null) goto L106;
        b31.c.b(r158, new b31.a(r157.f17167a, p.f40070a.a(7.0f), r157.f17169c, r157.f17170d, r157.f17171e, r157.f17172f));
        goto L106
    L15:
        if (r106.f94189a != true) goto L17;
        r108 = true;
        goto L18
    L69:
        this.f94343f.a(r102);
        a r159 = this.f94341d;
        r159.getClass();
        Intrinsics.checkNotNullParameter(r102, "layoutState");
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.a r160 = r102.f94197e;
        if (r160 == null) goto L72;
        Boolean r161 = r160.f94188a;
    L74:
        if (Intrinsics.areEqual(r161, Boolean.TRUE) == true) goto L76;
        int r162 = MultiFeedUtils.f94865a;
        MultiFeedUtils.b(r159.f94217g);
        goto L106
    L76:
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f r163 = r102.f94196d;
        if (r163 == null) goto L106;
        Integer r164 = r163.f94200b;
        if (r164 == null) goto L106;
        int r165 = r164.intValue();
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f r166 = r102.f94196d;
        if (r166 == null) goto L106;
        Integer r167 = r166.f94201c;
        if (r167 == null) goto L106;
        int r168 = r167.intValue();
        String r169 = r159.f94211a;
        if (r169 != null) goto L87;
        r169 = d51.c.A0.k();
    L87:
        String r170 = r169;
        String r171 = r159.f94212b;
        if (r171 != null) goto L90;
        r171 = d51.c.A0.j();
    L90:
        String r172 = r171;
        if (t41.a.f544564m.a() == true) goto L93;
    L105:
        int r173 = MultiFeedUtils.f94865a;
        MultiFeedUtils.e(r159.f94217g, r165, r168, MultiFeedUtils.ViewIndex.INDEX_0, r170, r172);
        r159.f94213c = r170;
        r159.f94214d = r172;
        r159.f94215e = r165;
        r159.f94216f = r168;
        goto L106
    L93:
        if (Intrinsics.areEqual(r170, r159.f94213c) == false) goto L105;
        if (Intrinsics.areEqual(r172, r159.f94214d) == false) goto L105;
        if (r159.f94215e != r165) goto L105;
        if (r159.f94216f != r168) goto L105;
        if (r159.f94217g.findViewById(R.id.ttlive_multi_anchor_top_bg) == null) goto L105;
        if (r159.f94217g.findViewById(R.id.ttlive_multi_anchor_bottom_bg) == null) goto L105;
    L72:
        r161 = null;
        goto L74
    L145:
        UtilityKotlinExtentionsKt.u(this.f94353p);
    }

    public final boolean b(com.bytedance.android.live.revlink.impl.multianchor.dynamic.k r100) {
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r101 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.f97568m;
        if (r101.a().R8() == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return true;
    L10:
        if (this.f94356s == true) goto L20;
        g r103 = this.f94350m;
        if (r103 != null) goto L15;
    L17:
        return false;
    L15:
        if (r103.d(r100.f94087a) != true) goto L17;
        return true;
    L20:
        return true;
    L5:
        if (r101.a().h7() == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.b
    public final void requestLayout(String r100) {
        Intrinsics.checkNotNullParameter("updateTopReserve", "source");
        d();
        a();
    }

    public final void c(View r100, boolean r101) {
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.b r102 = this.f94348k;
        if (r102 != null) goto L5;
        return;
    L5:
        f r103 = this.f94349l;
        if (r103 != null) goto L8;
        return;
    L8:
        boolean r104 = this.f94354q.f94272f.f94264a;
        e r105 = this.f94340c.a(r104, r102, r103, new FeedMultiWindowManager$setBreakThroughBar$layoutState$1(this));
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.b r106 = this.f94343f;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r105, "layoutState");
        if (PadConfigUtils.a() == false) goto L11;
    L44:
        this.f94351n = r100;
        return;
    L11:
        if (FoldScreenUtils.f() == true) goto L44;
        if (r100 != null) goto L21;
        View r107 = r106.f94219b;
        if (r107 == null) goto L20;
        FrameLayout r108 = r106.f94220c;
        if (r108 == null) goto L20;
        r108.removeView(r107);
    L20:
        r106.f94219b = null;
        goto L44
    L21:
        com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.c r109 = r105.f94198f;
        if (r109 == null) goto L27;
        boolean r110 = true;
        if (r109.f94191a != true) goto L27;
        if (r101 == false) goto L27;
    L28:
        if (r110 == true) goto L35;
        View r111 = r106.f94219b;
        if (r111 == null) goto L34;
        FrameLayout r112 = r106.f94220c;
        if (r112 == null) goto L34;
        r112.removeView(r111);
    L34:
        r106.f94219b = null;
        goto L44
    L35:
        View r113 = r106.f94219b;
        if (r113 == null) goto L40;
        FrameLayout r114 = r106.f94220c;
        if (r114 == null) goto L40;
        r114.removeView(r113);
    L40:
        FrameLayout r115 = r106.f94220c;
        if (r115 == null) goto L43;
        r115.addView(r100);
    L43:
        r106.f94219b = r100;
        r106.a(r105);
    L27:
        r110 = false;
        goto L28
    }

    public FeedMultiWindowManager(FrameLayout r100, com.bytedance.android.live.revlink.impl.multianchor.feed.player.b r101, c r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "feedMultiLayout");
        Intrinsics.checkNotNullParameter(r102, "machine");
        this.f94353p = r100;
        this.f94354q = r101;
        this.f94355r = r102;
        this.f94356s = r103;
        MutableLiveData<List<k>> r104 = new MutableLiveData();
        this.f94338a = r104;
        Context r105 = r100.getContext();
        if (r105 != null) goto L5;
        r105 = s1.getContext();
    L5:
        this.f94339b = r105;
        this.f94340c = new FeedMultiPlayUiResolver(r105, r101);
        this.f94341d = new a(r100);
        this.f94342e = new w21.a(r105, r100);
        this.f94343f = new com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget.b(r100);
        this.f94344g = new ArrayList();
        this.f94347j = new FeedMultiLynxContainer(r105, r100, r104);
    }
}
