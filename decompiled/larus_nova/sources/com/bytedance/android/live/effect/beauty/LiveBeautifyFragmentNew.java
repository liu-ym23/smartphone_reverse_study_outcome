package com.bytedance.android.live.effect.beauty;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.avadjust.LiveColorAdjustFragment;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.beauty.body.LiveBodyBeautyFragment;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterFragment;
import com.bytedance.android.live.effect.beauty.presets.LiveBeautyPresetsFragment;
import com.bytedance.android.live.effect.beauty.sticker.LiveStickerBeautyFragment;
import com.bytedance.android.live.effect.sticker.presenter.n;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.live.effect.template.BeautifyTemplate;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.kg;
import com.bytedance.android.livesdk.config.ul;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.h4;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/LiveBeautifyFragmentNew;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautifyFragmentNew extends Fragment {
    public static final Map<BeautifyTemplate.BeautifyContentType, Integer> A = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f67032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f67033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f67034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<BeautifyTemplate.BeautifyContentType, Pair<BeautifyTabItemView, Fragment>> f67036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f67037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f67038j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f67039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f67040l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f67041m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f67042n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f67043o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f67044p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f67045q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f67046r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f67047s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f67048t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final BeautifyTemplate f67049u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public BeautifyTemplate.BeautifyContentType f67050v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f67051w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Boolean f67052x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f67053y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b f67054z;

    public static final class a {
        public static String a(BeautifyTemplate.BeautifyContentType r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "beautifyContentType");
            int r102 = e.f67213a[r100.ordinal()];
            if (r102 != 1) goto L5;
            if (r101 == false) goto L20;
            return "beautyclassify";
        L20:
            return d0.f66759i;
        L5:
            if (r102 == 2) goto L25;
            if (r102 == 3) goto L24;
            if (r102 != 4) goto L11;
            return "live_adjustment";
        L11:
            if (r102 == 5) goto L13;
            return "";
        L13:
            return "livebody";
        L24:
            return d0.f66762l;
        L25:
            return d0.f66761k;
        }
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautifyFragmentNew f67055a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveBeautifyFragmentNew r100 = this.f67055a;
            Iterator r101 = ((LinkedHashMap) r100.f67036h).entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L17;
            Map.Entry r102 = (Map.Entry) r101.next();
            BeautifyTabItemView r103 = (BeautifyTabItemView) ((Pair) r102.getValue()).getFirst();
            Map<BeautifyTemplate.BeautifyContentType, Integer> r104 = LiveBeautifyFragmentNew.A;
            String r105 = a.a((BeautifyTemplate.BeautifyContentType) r102.getKey(), r100.f67037i);
            n.f68348a.getClass();
            if (n.a.f68349a.contains(r105) == false) goto L13;
            List<String> r106 = LiveEffectContext.f66734h;
            if (o.a.d(LiveEffectContext.a.a(r100.f67035g).b().d(), r105) == LiveEffectContext.a.a(r100.f67035g).b().d().m(r105)) goto L13;
            if (r103 == null) goto L4;
            View r107 = r103.f67025f;
            if (r107 == null) goto L4;
            r107.setVisibility(0);
        L13:
            if (r103 == null) goto L4;
            View r108 = r103.f67025f;
            if (r108 == null) goto L4;
            r108.setVisibility(4);
            goto L4
        L17:
            Iterator r109 = ((LinkedHashMap) this.f67055a.f67036h).entrySet().iterator();
        L19:
            if (r109.hasNext() == false) goto L37;
            Map.Entry r110 = (Map.Entry) r109.next();
            Map<BeautifyTemplate.BeautifyContentType, Integer> r111 = LiveBeautifyFragmentNew.A;
            String r112 = a.a((BeautifyTemplate.BeautifyContentType) r110.getKey(), this.f67055a.f67037i);
            List<String> r113 = LiveEffectContext.f66734h;
            if (LiveEffectContext.a.a(this.f67055a.f67035g).b().h().b().contains(r112) == true) goto L19;
            String r114 = d0.f66759i;
            if (Intrinsics.areEqual(r112, r114) == true) goto L24;
            if (Intrinsics.areEqual(r112, "beautyclassify") == true) goto L27;
            if (Intrinsics.areEqual(r112, d0.f66762l) == true) goto L30;
            String r115 = d0.f66761k;
            if (Intrinsics.areEqual(r112, r115) == true) goto L33;
            if (Intrinsics.areEqual(r112, "livebody") == false) goto L19;
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.f67055a.f67035g).a(), "livebody", "LiveBodyBeautyListFragment_onBeautyModeChange");
            LiveEffectContext.a.a(this.f67055a.f67035g).b().p().b(null);
            goto L19
        L33:
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.f67055a.f67035g).a(), r115, "LiveMakeupsBeautyFragment_onBeautyModeChange");
            ((com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(this.f67055a.f67035g).b().f()).b(null);
            goto L19
        L30:
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.f67055a.f67035g).a(), d0.f66751a, "LiveMakeupsBeautyFragment_onBeautyModeChange");
            LiveEffectContext.a.a(this.f67055a.f67035g).b().m().d(null, this.f67055a.f67033e);
            goto L19
        L27:
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.f67055a.f67035g).a(), r114, "LiveBeautySecondLevelFragment_onBeautyModeChange");
            com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.f67055a.f67035g).b().l(), "beautyclassify", this.f67055a.f67035g, null, 8);
            goto L19
        L24:
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.f67055a.f67035g).a(), r114, "LiveSmallItemBeautyFragment_onBeautyModeChange");
            LiveEffectContext.a.a(this.f67055a.f67035g).b().g().c(null, r114, LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().a());
            goto L19
        }

        public b(LiveBeautifyFragmentNew r100) {
            this.f67055a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautifyFragmentNew f67056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BeautifyTemplate.BeautifyContentType f67057b;

        public c(LiveBeautifyFragmentNew r100, BeautifyTemplate.BeautifyContentType r101) {
            this.f67056a = r100;
            this.f67057b = r101;
        }

        public final void a() {
            LiveBeautifyFragmentNew r100 = this.f67056a;     // Catch: Exception -> L26
            BeautifyTemplate.BeautifyContentType r101 = this.f67057b;     // Catch: Exception -> L26
            Map<BeautifyTemplate.BeautifyContentType, Integer> r102 = LiveBeautifyFragmentNew.A;     // Catch: Exception -> L26
            Fragment r103 = r100.X90(r101);     // Catch: Exception -> L26
            if (Build.VERSION.SDK_INT >= 22) goto L5;
            return;
        L5:
            if (this.f67056a.S90(R.id.tab_container) != null) goto L7;
            return;
        L7:
            if ((r103 instanceof PreViewBeautyFragment) == false) goto L34;
            int r104 = ((LinearLayout) this.f67056a.S90(R.id.tab_container)).getChildCount();     // Catch: Exception -> L26
            int r105 = 0;
        L9:
            if (r105 >= r104) goto L17;
            View r106 = ((LinearLayout) this.f67056a.S90(R.id.tab_container)).getChildAt(r105);     // Catch: Exception -> L26
            if (r106.getId() != (-1)) goto L13;
            r106.setId(View.generateViewId());     // Catch: Exception -> L26
        L13:
            if (r105 == 0) goto L15;
            ((LinearLayout) this.f67056a.S90(R.id.tab_container)).getChildAt(r105 - 1).setAccessibilityTraversalBefore(r106.getId());     // Catch: Exception -> L26
        L15:
            r105 = r105 + 1;     // Catch: Exception -> L26
            goto L9
        L17:
            if (this.f67056a.S90(R.id.tab_container) != null) goto L19;
            return;
        L19:
            if (((PreViewBeautyFragment) r103).getView() == null) goto L36;
            View r107 = (View) SequencesKt.last(UtilityKotlinExtentionsKt.g((ViewGroup) this.f67056a.S90(R.id.tab_container)));     // Catch: Exception -> L26
            View r108 = ((PreViewBeautyFragment) r103).getView();     // Catch: Exception -> L26
            if (r108 == null) goto L23;
            View r109 = r108.findViewById(R.id.reset_view);     // Catch: Exception -> L26
        L24:
            r107.setAccessibilityTraversalBefore(((LinearLayout) r109).getId());     // Catch: Exception -> L26
            return;
        L23:
            r109 = null;
            goto L24
        L36:
            return;
        L34:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements ILiveEffectComposerManager.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautifyFragmentNew f67058a;

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
        public final void a(String r100, Sticker r101) {
        }

        public d(LiveBeautifyFragmentNew r100) {
            this.f67058a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
        public final void b(boolean r100, String r101, Sticker r102) {
            if (r100 == false) goto L7;
            String r103 = d0.f66761k;
            if (StringUtils.equal(r101, r103) == false) goto L8;
            LiveBeautifyFragmentNew r104 = this.f67058a;
            Map<BeautifyTemplate.BeautifyContentType, Integer> r105 = LiveBeautifyFragmentNew.A;
            r104.getClass();
            List<String> r106 = LiveEffectContext.f66734h;
            LiveEffectContext.a.a(r104.f67035g).b().r().p(r103, new g(r104), true);
            return;
        L8:
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f67034f = false;
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67035g).a().g(this.f67048t);
        super.onDestroyView();
        ((LinkedHashMap) this.f67032d).clear();
    }

    static {
        A = MapsKt.mapOf(new Pair[]{TuplesKt.to(BeautifyTemplate.BeautifyContentType.BEAUTY_TEMPLATE, Integer.valueOf(R.string.ttlive_effect_live_beauty_small_template)), TuplesKt.to(BeautifyTemplate.BeautifyContentType.BEAUTY, Integer.valueOf(R.string.ttlive_effect_live_beauty_small_title)), TuplesKt.to(BeautifyTemplate.BeautifyContentType.MAKEUPS, Integer.valueOf(R.string.ttlive_effect_live_beauty_makeups_title)), TuplesKt.to(BeautifyTemplate.BeautifyContentType.FILTER, Integer.valueOf(R.string.ttlive_effect_live_start_live_filter)), TuplesKt.to(BeautifyTemplate.BeautifyContentType.AV_ADJUST, Integer.valueOf(R.string.ttlive_effect_live_av_adjust_title_color)), TuplesKt.to(BeautifyTemplate.BeautifyContentType.BODY_BEAUTY, Integer.valueOf(R.string.ttlive_effect_live_body_beauty_title)), TuplesKt.to(BeautifyTemplate.BeautifyContentType.STICKER, Integer.valueOf(R.string.ttlive_effect_live_sticker_title)), TuplesKt.to(BeautifyTemplate.BeautifyContentType.PRESETS, Integer.valueOf(R.string.ttlive_effect_live_beauty_presets_title))});
    }

    public final void U90() {
        if (yo0.f121705a.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        BeautifyTabItemView r100 = Y90(BeautifyTemplate.BeautifyContentType.BODY_BEAUTY);
        if (r100 == null) goto L9;
        r100.setDotVisibility(m90.b.f512553k.c(this.f67035g).booleanValue());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final void W90() {
        Iterator r100 = ((LinkedHashMap) this.f67036h).keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L24;
        BeautifyTemplate.BeautifyContentType r101 = (BeautifyTemplate.BeautifyContentType) r100.next();
        BeautifyTabItemView r102 = Y90(r101);
        if (r102 == null) goto L4;
        if (this.f67050v != r101) goto L10;
        ?? r103 = 1;
    L11:
        TextView r104 = r102.f67020a;
        if (r104 == null) goto L17;
        if (r103 == 0) goto L15;
        int r105 = R.color.ttlive_effect_beautify_tab_name_selected_color;
    L16:
        r104.setTextColor(s1.h(r105));
        goto L17
    L15:
        r105 = R.color.ttlive_effect_beautify_tab_name_unselected_color;
    L17:
        TextView r106 = r102.f67020a;
        if (r106 == 0) goto L20;
        r106.setTypeface(Typeface.DEFAULT, r103);
    L20:
        View r107 = r102.f67022c;
        if (r107 == null) goto L23;
        UtilityKotlinExtentionsKt.A(r107, r103);
    L23:
        r102.f67023d = r103;
        goto L4
    L10:
        r103 = 0;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        List<String> r100 = LiveEffectContext.f66734h;
        n.b.b(LiveEffectContext.a.a(this.f67035g).b().h(), this.f67054z);
        super.onDestroy();
    }

    public LiveBeautifyFragmentNew() {
        this.f67032d = new LinkedHashMap();
        this.f67033e = "";
        this.f67035g = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f67036h = new LinkedHashMap();
        this.f67037i = LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().a();
        this.f67038j = LazyKt.lazy(LiveBeautifyFragmentNew$enableAvAdjustInBeautyPanel$2.INSTANCE);
        this.f67039k = LazyKt.lazy(LiveBeautifyFragmentNew$enableAvAdjustTeaOpt$2.INSTANCE);
        this.f67040l = LazyKt.lazy(new LiveBeautifyFragmentNew$presetsFragment$2(this));
        this.f67041m = LazyKt.lazy(new LiveBeautifyFragmentNew$beautyFragment$2(this));
        this.f67042n = LazyKt.lazy(new LiveBeautifyFragmentNew$beautyTemplateFragment$2(this));
        this.f67043o = LazyKt.lazy(new LiveBeautifyFragmentNew$makeupsBeautyFragment$2(this));
        this.f67044p = LazyKt.lazy(new LiveBeautifyFragmentNew$filterFragment$2(this));
        this.f67045q = LazyKt.lazy(new LiveBeautifyFragmentNew$bodyBeautyFragment$2(this));
        this.f67046r = LazyKt.lazy(new LiveBeautifyFragmentNew$stickerFragment$2(this));
        this.f67047s = LazyKt.lazy(new LiveBeautifyFragmentNew$adjustFragment$2(this));
        this.f67048t = new d(this);
        this.f67049u = new BeautifyTemplate(CollectionsKt.listOf(BeautifyTemplate.BeautifyContentType.BEAUTY));
        this.f67051w = d0.f66753c;
        this.f67052x = h4.f132626a.getValue();
        this.f67053y = LazyKt.lazy(new LiveBeautifyFragmentNew$enableBeautyMode$2(this));
        this.f67054z = new b(this);
    }

    public final View S90(int r100) {
        if (this.f67032d != null) goto L5;
        this.f67032d = new LinkedHashMap();
    L5:
        View r101 = this.f67032d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f67032d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void V90(BeautifyTemplate.BeautifyContentType r110) {
        BeautifyTemplate.BeautifyContentType r100 = BeautifyTemplate.BeautifyContentType.BODY_BEAUTY;
        if (r110 != r100) goto L5;
        int r101 = com.bytedance.android.live.effect.utils.a.f68866a;
        int r102 = CollectionsKt.indexOf(((LinkedHashMap) this.f67036h).keySet(), r110) + 1;
        HashMap r103 = new HashMap();
        r103.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, String.valueOf(r102));
        com.bytedance.android.live.effect.utils.c.a("livesdk_anchor_beautybody_icon_click", r103, "");
    L5:
        View r104 = getView();
        if (r104 == null) goto L9;
        r104.post(new c(this, r110));
    L9:
        if (this.f67050v != r110) goto L11;
        return;
    L11:
        if (r110 != r100) goto L13;
        m90.b.f512553k.e(this.f67035g, Boolean.FALSE);
        U90();
    L13:
        BeautifyTemplate.BeautifyContentType r105 = BeautifyTemplate.BeautifyContentType.STICKER;
        if (r110 != r105) goto L18;
        m90.c<Boolean> r106 = m90.b.f512554l;
        r106.e(this.f67035g, Boolean.FALSE);
        BeautifyTabItemView r107 = Y90(r105);
        if (r107 == null) goto L18;
        r107.setDotVisibility(r106.c(this.f67035g).booleanValue());
    L18:
        FragmentTransaction r108 = getChildFragmentManager().beginTransaction();
        Iterator r109 = ((LinkedHashMap) this.f67036h).keySet().iterator();
    L20:
        if (r109.hasNext() == false) goto L26;
        BeautifyTemplate.BeautifyContentType r111 = (BeautifyTemplate.BeautifyContentType) r109.next();
        if (r110 == r111) goto L20;
        Fragment r112 = X90(r111);
        if (r112 == null) goto L20;
        r108.hide(r112);
        goto L20
    L26:
        Fragment r113 = X90(r110);
        View r114 = S90(R.id.content_background_view);
        if (r114 == null) goto L29;
        r114.setVisibility(0);
    L29:
        FrameLayout r115 = (FrameLayout) S90(R.id.content_layout);
        if (r115 == null) goto L32;
        r115.setVisibility(0);
    L32:
        List<String> r116 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.api.c r117 = LiveEffectContext.a.a(this.f67035g).e();
        Intrinsics.checkNotNullParameter(r110, "beautifyContentType");
        switch(e.f67214b[r110.ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L34;
        };
    L34:
        String r118 = "";
    L41:
        HashMap<String, String> r119 = new HashMap();
        r119.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, this.f67033e);
        Intrinsics.checkNotNullParameter(r110, "beautifyContentType");
        int[] r120 = e.f67215c;
        String r121 = "adjust";
        if (r120[r110.ordinal()] == 1) goto L44;
        Object r122 = null;
    L45:
        if (r122 == null) goto L56;
        Intrinsics.checkNotNullParameter(r110, "type");
        if (((Boolean) this.f67039k.getValue()).booleanValue() == false) goto L54;
        Map<? extends String, ? extends String> r123 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r110, "beautifyContentType");
        if (r120[r110.ordinal()] == 1) goto L51;
        r121 = null;
    L51:
        if (r121 != null) goto L53;
        r121 = "";
    L53:
        r123.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r121);
        r123.put("live_type", "video_live");
        r123.put("anchor_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        r123.put("room_id", "");
    L55:
        r119.putAll(r123);
        goto L56
    L54:
        r123 = MapsKt.emptyMap();
    L56:
        Unit r124 = Unit.INSTANCE;
        r117.sendLog(r118, r119);
        if (r113 == null) goto L67;
        if (r113.isAdded() == false) goto L62;
        r108.show(r113);
        goto L67
    L62:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r108, r113, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content_layout) == true) goto L65;
        r108.add(R.id.content_layout, r113);
    L65:
        r108.show(r113);
    L67:
        if (kg.f120599a.getValue().booleanValue() == false) goto L69;
        r108.commitAllowingStateLoss();
    L70:
        this.f67050v = r110;
        return;
    L69:
        r108.commitNowAllowingStateLoss();
        goto L70
    L44:
        r122 = "adjust";
        goto L45
    L35:
        r118 = "livesdk_anchor_presets_tab_show";
        goto L41
    L36:
        r118 = "livesdk_anchor_beautybody_tab_show";
        goto L41
    L37:
        r118 = "livesdk_beauty_panel_tab_show";
        goto L41
    L38:
        r118 = "livesdk_filter_tab_show";
        goto L41
    L39:
        r118 = "livesdk_makeup_tab_show";
        goto L41
    L40:
        r118 = "livesdk_beauty_tab_show";
        goto L41
    }

    public final Fragment X90(BeautifyTemplate.BeautifyContentType r100) {
        Pair r101 = (Pair) ((LinkedHashMap) this.f67036h).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (Fragment) r101.getSecond();
    }

    public final BeautifyTabItemView Y90(BeautifyTemplate.BeautifyContentType r100) {
        Pair r101 = (Pair) ((LinkedHashMap) this.f67036h).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (BeautifyTabItemView) r101.getFirst();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f67034f = true;
        ViewGroup.LayoutParams r100 = S90(R.id.content_background_view).getLayoutParams();
        r100.height = s1.f(150.0f);
        S90(R.id.content_background_view).setLayoutParams(r100);
        if (this.f67037i == false) goto L12;
        ViewGroup.LayoutParams r101 = S90(R.id.content_background_view).getLayoutParams();
        r101.height = s1.f(218.0f);
        S90(R.id.content_background_view).setLayoutParams(r101);
        a1.m(S90(R.id.tab_container), s1.f(6.0f));
        ViewGroup.LayoutParams r102 = ((LinearLayout) S90(R.id.tab_container)).getLayoutParams();
        r102.height = s1.f(44.0f);
        ((LinearLayout) S90(R.id.tab_container)).setLayoutParams(r102);
        ViewGroup.LayoutParams r103 = S90(R.id.line).getLayoutParams();
        if ((r103 instanceof ConstraintLayout.LayoutParams) == true) goto L7;
        r103 = null;
    L7:
        ConstraintLayout.LayoutParams r104 = (ConstraintLayout.LayoutParams) r103;
        if (r104 == null) goto L10;
        ((ViewGroup.MarginLayoutParams) r104).topMargin = s1.f(44.0f);
    L10:
        ViewGroup.LayoutParams r105 = r110.getLayoutParams();
        r105.height = s1.f(324.0f);
        r110.setLayoutParams(r105);
    L12:
        if (this.f67037i == false) goto L23;
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == false) goto L23;
        BeautifyTemplate r106 = this.f67049u;
        if (r106.f68830a == false) goto L23;
        List<BeautifyTemplate.BeautifyContentType> r107 = r106.f68831b;
        if (r107 == null) goto L21;
        ListProtector.add(TypeIntrinsics.asMutableList(r107), 0, BeautifyTemplate.BeautifyContentType.BEAUTY_TEMPLATE);
        goto L23
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.android.live.effect.template.BeautifyTemplate.BeautifyContentType>");
    L23:
        if (this.f67037i == false) goto L25;
    L37:
        int r108 = -1;
    L38:
        Iterator<BeautifyTemplate.BeautifyContentType> r109 = this.f67049u.f68831b.iterator();
    L40:
        if (r109.hasNext() == false) goto L119;
        BeautifyTemplate.BeautifyContentType r112 = r109.next();
        if (this.f67036h.containsKey(r112) == false) goto L50;
        Pair r113 = (Pair) ((LinkedHashMap) this.f67036h).get(r112);
        if (r113 == null) goto L57;
        BeautifyTabItemView r114 = (BeautifyTabItemView) r113.getFirst();
        if (r114 == null) goto L57;
        ViewGroup r115 = UtilityKotlinExtentionsKt.p(r114);
        if (r115 == null) goto L59;
        r115.removeView(r114);
    L59:
        if (((Boolean) this.f67053y.getValue()).booleanValue() == false) goto L85;
        String r116 = a.a(r112, this.f67037i);
        n.f68348a.getClass();
        if (n.a.f68349a.contains(r116) == false) goto L68;
        List<String> r117 = LiveEffectContext.f66734h;
        if (o.a.d(LiveEffectContext.a.a(this.f67035g).b().d(), r116) == LiveEffectContext.a.a(this.f67035g).b().d().m(r116)) goto L68;
        if (r114 == null) goto L72;
        View r118 = r114.f67025f;
        if (r118 == null) goto L72;
        r118.setVisibility(0);
    L72:
        LinearLayout r119 = (LinearLayout) S90(R.id.tab_container);
        if (r119 == null) goto L75;
        Integer r120 = Integer.valueOf(r119.getChildCount());
    L77:
        if (r120.intValue() != 0) goto L81;
        LinearLayout r121 = (LinearLayout) S90(R.id.tab_container);
        if (r121 == null) goto L101;
        LinearLayout.LayoutParams r122 = new LinearLayout.LayoutParams(-2, -2);
        r122.leftMargin = s1.f(12.0f);
        Unit r123 = Unit.INSTANCE;
        r121.addView(r114, r122);
    L101:
        if (r108 == (-1)) goto L106;
        if (r114 == null) goto L106;
        ViewGroup.LayoutParams r124 = r114.getLayoutParams();
        if (r124 == null) goto L106;
        r124.width = r108;
    L106:
        Map<BeautifyTemplate.BeautifyContentType, Pair<BeautifyTabItemView, Fragment>> r125 = this.f67036h;
        switch(f.f67216a[r112.ordinal()]) {
            case 1: goto L117;
            case 2: goto L116;
            case 3: goto L115;
            case 4: goto L114;
            case 5: goto L113;
            case 6: goto L112;
            case 7: goto L111;
            case 8: goto L110;
            default: goto L109;
        };
    L110:
        Object r126 = (LiveBeautyPresetsFragment) this.f67040l.getValue();
    L118:
        r125.put(r112, new Pair(r114, r126));
        goto L40
    L111:
        r126 = (LiveStickerBeautyFragment) this.f67046r.getValue();
        goto L118
    L112:
        r126 = (LiveBodyBeautyFragment) this.f67045q.getValue();
        goto L118
    L113:
        r126 = (LiveColorAdjustFragment) this.f67047s.getValue();
        goto L118
    L114:
        r126 = (LiveComposerFilterFragment) this.f67044p.getValue();
        goto L118
    L115:
        r126 = (PreViewMakeupsBeautyFragment) this.f67043o.getValue();
        goto L118
    L116:
        r126 = (PreViewBeautyFragment) this.f67041m.getValue();
        goto L118
    L117:
        r126 = (LiveBeautyTemplateFragment) this.f67042n.getValue();
        goto L118
    L109:
        throw new NoWhenBranchMatchedException();
    L81:
        LinearLayout r127 = (LinearLayout) S90(R.id.tab_container);
        if (r127 == null) goto L101;
        r127.addView(r114);
        goto L101
    L75:
        r120 = null;
    L68:
        if (r114 == null) goto L72;
        View r128 = r114.f67025f;
        if (r128 == null) goto L72;
        r128.setVisibility(4);
        goto L72
    L85:
        if (this.f67037i == false) goto L98;
        LinearLayout.LayoutParams r129 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout r130 = (LinearLayout) S90(R.id.tab_container);
        if (r130 == null) goto L89;
        Integer r131 = Integer.valueOf(r130.getChildCount());
    L91:
        if (r131.intValue() != 0) goto L95;
        LinearLayout r132 = (LinearLayout) S90(R.id.tab_container);
        if (r132 == null) goto L101;
        r129.leftMargin = s1.f(12.0f);
        Unit r133 = Unit.INSTANCE;
        r132.addView(r114, r129);
        goto L101
    L95:
        LinearLayout r134 = (LinearLayout) S90(R.id.tab_container);
        if (r134 == null) goto L101;
        r134.addView(r114, r129);
        goto L101
    L89:
        r131 = null;
        goto L91
    L98:
        LinearLayout r135 = (LinearLayout) S90(R.id.tab_container);
        if (r135 == null) goto L101;
        r135.addView(r114);
    L57:
        r114 = null;
        goto L59
    L50:
        Context r136 = getContext();
        if (r136 == null) goto L57;
        BeautifyTabItemView r137 = new BeautifyTabItemView(r136, ((Boolean) this.f67053y.getValue()).booleanValue(), this.f67037i, 12);
        Integer r138 = A.get(r112);
        if (r138 == null) goto L55;
        int r139 = r138.intValue();
    L56:
        r137.setTabName(r139);
        r137.setOnClickListener(new h(this, r112));
        r114 = r137;
        goto L59
    L55:
        r139 = R.string.ttlive_effect_live_beauty_small_title;
        goto L56
    L119:
        S90(R.id.content_background_view).setOnClickListener(i.f67292a);
        BeautifyTemplate.BeautifyContentType r140 = this.f67050v;
        this.f67050v = null;
        if (this.f67052x.booleanValue() == false) goto L124;
        List<BeautifyTemplate.BeautifyContentType> r141 = this.f67049u.f68831b;
        BeautifyTemplate.BeautifyContentType r142 = BeautifyTemplate.BeautifyContentType.BEAUTY;
        if (r141.contains(r142) == false) goto L124;
    L125:
        if (r140 != null) goto L127;
        r140 = r142;
    L127:
        V90(r140);
        W90();
        this.f67049u.f68831b.contains(BeautifyTemplate.BeautifyContentType.FILTER);
        if (this.f67049u.f68831b.contains(BeautifyTemplate.BeautifyContentType.MAKEUPS) == false) goto L131;
        List<String> r143 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67035g).b().r().p(d0.f66761k, new g(this), true);
    L131:
        if (this.f67049u.f68831b.contains(BeautifyTemplate.BeautifyContentType.BODY_BEAUTY) == false) goto L133;
        U90();
    L133:
        List<BeautifyTemplate.BeautifyContentType> r144 = this.f67049u.f68831b;
        BeautifyTemplate.BeautifyContentType r145 = BeautifyTemplate.BeautifyContentType.STICKER;
        if (r144.contains(r145) == false) goto L138;
        BeautifyTabItemView r146 = Y90(r145);
        if (r146 == null) goto L138;
        r146.setDotVisibility(m90.b.f512554l.c(this.f67035g).booleanValue());
    L138:
        Iterator r147 = ((LinkedHashMap) this.f67036h).keySet().iterator();
    L140:
        if (r147.hasNext() == false) goto L142;
        final BeautifyTemplate.BeautifyContentType r148 = (BeautifyTemplate.BeautifyContentType) r147.next();
        final BeautifyTabItemView r149 = Y90(r148);
        r3.e(r149, new LiveBeautifyFragmentNew$setAccessibility$1(r149, r148));
        goto L140
    L142:
        List<String> r150 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67035g).a().V(this.f67048t);
        if (Intrinsics.areEqual(ul.f121383a.getValue().b(), Boolean.TRUE) == false) goto L148;
        if (m90.b.D.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).booleanValue() == false) goto L148;
        f2.b(R.string.ttlive_effect_area_small_item_beauty_notice, 0);
    L148:
        if (((Boolean) this.f67053y.getValue()).booleanValue() == false) goto L162;
        n.b.a(LiveEffectContext.a.a(this.f67035g).b().h(), this.f67054z);
        return;
    L162:
        return;
    L124:
        r142 = (BeautifyTemplate.BeautifyContentType) CollectionsKt.first(this.f67049u.f68831b);
        goto L125
    L25:
        if (this.f67052x.booleanValue() == false) goto L29;
        if (this.f67049u.f68831b.contains(BeautifyTemplate.BeautifyContentType.PRESETS) == false) goto L29;
    L30:
        float r151 = 60.0f;
        if (((Boolean) this.f67038j.getValue()).booleanValue() == true) goto L33;
        r108 = s1.f(60.0f);
        goto L38
    L33:
        if (this.f67049u.f68831b.size() <= 4) goto L35;
        r151 = 48.0f;
    L35:
        r108 = s1.f(r151);
    L29:
        if (this.f67049u.f68831b.contains(BeautifyTemplate.BeautifyContentType.AV_ADJUST) == false) goto L37;
        goto L30
    }

    public static final void T90(LiveBeautifyFragmentNew r100, EffectChannelResponse r101, int r102) {
        r100.getClass();
        boolean r103 = false;
        if (r102 >= r101.getAllCategoryEffects().size()) goto L17;
        if (r102 == 30) goto L17;
        List<String> r104 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.beauty.makeups.a r105 = LiveEffectContext.a.a(r100.f67035g).b().f();
        Effect r106 = (Effect) ListProtector.get(r101.getAllCategoryEffects(), r102);
        ((com.bytedance.android.live.effect.beauty.makeups.d) r105).getClass();
        Intrinsics.checkNotNullParameter(r106, "effect");
        List<String> r107 = r106.getTags();
        List<String> r108 = r107;
        if (r108 != null) goto L10;
    L11:
        r103 = true;
    L12:
        if (r103 == false) goto L14;
    L15:
        T90(r100, r101, r102 + 1);
        return;
    L14:
        if (r107.contains("new") == false) goto L15;
        return;
    L10:
        if (r108.isEmpty() == false) goto L12;
    L17:
        if (r100.f67034f == false) goto L24;
        BeautifyTabItemView r109 = r100.Y90(BeautifyTemplate.BeautifyContentType.MAKEUPS);
        if (r109 == null) goto L25;
        r109.setDotVisibility(false);
        return;
    L25:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_effect_fragment_beautify_new, r101, false);
    }
}
