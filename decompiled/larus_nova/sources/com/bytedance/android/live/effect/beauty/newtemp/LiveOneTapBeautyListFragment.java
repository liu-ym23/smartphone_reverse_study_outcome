package com.bytedance.android.live.effect.beauty.newtemp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterHelper;
import com.bytedance.android.live.effect.beauty.smallitem.q;
import com.bytedance.android.live.effect.sticker.presenter.n;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/newtemp/LiveOneTapBeautyListFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOneTapBeautyListFragment extends BaseFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f67372m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f67373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f67375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f67376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f67377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f67378i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f67379j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f67380k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f67381l;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveOneTapBeautyListFragment f67382a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveOneTapBeautyListFragment r100 = this.f67382a;
            int r101 = LiveOneTapBeautyListFragment.f67372m;
            LiveOneTapBeautyAdapter r102 = r100.T90();
            if (r102 == null) goto L6;
            m90.c<Integer> r103 = m90.b.f512545c;
            int r104 = r103.c(r102.f67358b).intValue();
            int r105 = r102.f67361e;
            r102.f67361e = r104;
            r103.e(r102.f67358b, Integer.valueOf(r104));
            r102.notifyItemChanged(r105);
            r102.notifyItemChanged(r102.f67361e);
            return;
        }

        public b(LiveOneTapBeautyListFragment r100) {
            this.f67382a = r100;
        }
    }

    public static final class c implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveOneTapBeautyListFragment f67383a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f67384a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f67385b;

            public a(c r100, List r101) {
                this.f67384a = r100;
                this.f67385b = r101;
            }

            public final void a() {
                if (this.f67384a.f67383a.S90(R.id.small_item_beauty_loading_view) == null) goto L5;
                ((LoadingStatusView) this.f67384a.f67383a.S90(R.id.small_item_beauty_loading_view)).setVisibility(8);
            L5:
                int r100 = 0;
                if (this.f67384a.f67383a.S90(R.id.small_item_beauty_recycle_view) == null) goto L8;
                ((RecyclerView) this.f67384a.f67383a.S90(R.id.small_item_beauty_recycle_view)).setVisibility(0);
            L8:
                LiveOneTapBeautyListFragment r101 = this.f67384a.f67383a;
                List r102 = this.f67385b;
                r101.getClass();
                Intrinsics.checkNotNullParameter(r102, "stickerCategoryList");
                if (r102.isEmpty() == false) goto L12;
            L39:
                LiveOneTapBeautyListFragment r103 = this.f67384a.f67383a;
                List r104 = this.f67385b;
                r103.getClass();
                List<String> r105 = LiveEffectContext.f66734h;
                if (((CopyOnWriteArrayList) LiveEffectContext.a.a(r103.f67374e).b().g().f66680b).isEmpty() == true) goto L46;
                Iterator r106 = r104.iterator();
            L44:
                if (r106.hasNext() == false) goto L51;
                LiveOneTapBeautyListFragment.U90((Sticker) r106.next());
                goto L44
            L51:
                return;
            L46:
                return;
            L12:
                if (r101.isDestroyed() == true) goto L39;
                Sticker r107 = (Sticker) CollectionsKt.getOrNull(r102, m90.b.f512545c.c(r101.f67374e).intValue());
                List r108 = r102;
                ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
                Iterator r110 = r108.iterator();
            L16:
                if (r110.hasNext() == false) goto L36;
                Object r111 = r110.next();
                int r112 = r100 + 1;
                if (r100 >= 0) goto L20;
                CollectionsKt.throwIndexOverflow();
            L20:
                Sticker r113 = (Sticker) r111;
                String r114 = r113.getName();
                if (r114 != null) goto L23;
                String r115 = "";
            L24:
                String r116 = r113.getName();
                if (r116 != null) goto L27;
                String r117 = "";
            L28:
                UrlModel r118 = new UrlModel();
                UrlModel r119 = r113.getIcon();
                List<String> r120 = null;
                if (r119 == null) goto L31;
                String r121 = r119.getUri();
            L32:
                r118.setUri(r121);
                UrlModel r122 = r113.getIcon();
                if (r122 == null) goto L35;
                r120 = r122.getUrlList();
            L35:
                r118.setUrlList(r120);
                Unit r123 = Unit.INSTANCE;
                r109.add(new o90.a(r115, r117, r118, String.valueOf(r113.getId()), r112));
                r100 = r112;
                goto L16
            L31:
                r121 = null;
                goto L32
            L27:
                r117 = r116;
                goto L28
            L23:
                r115 = r114;
                goto L24
            L36:
                LiveOneTapBeautyAdapter r124 = r101.T90();
                if (r124 == null) goto L39;
                Intrinsics.checkNotNullParameter(r109, "beautyTemplateModelList");
                ((ArrayList) r124.f67359c).clear();
                ((ArrayList) r124.f67359c).addAll(r109);
                r124.notifyDataSetChanged();
                goto L39
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

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void onError() {
            LoadingStatusView r100 = (LoadingStatusView) this.f67383a.S90(R.id.small_item_beauty_loading_view);
            if (r100 == null) goto L6;
            r100.showError();
            return;
        }

        public c(LiveOneTapBeautyListFragment r100) {
            this.f67383a = r100;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void a(List<Sticker> r100, List<Integer> r101) {
            Intrinsics.checkNotNullParameter(r100, "stickerList");
            this.f67383a.f67376g.post(new a(this, r100));
        }
    }

    public static final class d implements LiveOneTapBeautyAdapter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveOneTapBeautyListFragment f67386a;

        public d(LiveOneTapBeautyListFragment r100) {
            this.f67386a = r100;
        }

        @Override // com.bytedance.android.live.effect.beauty.newtemp.LiveOneTapBeautyAdapter.b
        public final void onItemClick(int r110) {
            long r100 = System.currentTimeMillis();
            LiveOneTapBeautyListFragment r101 = this.f67386a;
            if ((r100 - r101.f67379j) >= 1500) goto L6;
            f2.c("模板切换过快，请稍后再试", 0);
            return;
        L6:
            r101.f67379j = r100;
            LiveOneTapBeautyAdapter r102 = r101.T90();
            if (r102 != null) goto L10;
            return;
        L10:
            if (((ArrayList) r102.f67359c).size() > r110) goto L12;
            return;
        L12:
            LiveOneTapBeautyListFragment r103 = this.f67386a;
            LiveOneTapBeautyAdapter r104 = r103.T90();
            if (r104 != null) goto L16;
            return;
        L16:
            if (((ArrayList) r104.f67359c).size() <= r110) goto L171;
            o90.a r105 = (o90.a) ListProtector.get(r104.f67359c, r110);
            List<String> r106 = LiveEffectContext.f66734h;
            com.bytedance.android.live.effect.beauty.newtemp.c r107 = LiveEffectContext.a.a(r103.f67374e).b().c();
            r107.getClass();
            Intrinsics.checkNotNullParameter("inspiration_beautification", "panel");
            List r108 = (List) ((LinkedHashMap) r107.f67390a).get("inspiration_beautification");
            if (r108 == null) goto L28;
            Iterator r109 = r108.iterator();
        L22:
            if (r109.hasNext() == false) goto L26;
            Object r111 = r109.next();
            if (Intrinsics.areEqual(String.valueOf(((Sticker) r111).getId()), r105.f522432d) == false) goto L22;
        L27:
            Sticker r112 = (Sticker) r111;
        L30:
            if (r112 != null) goto L32;
            ALogger.e("ttlive_inspiration_panel", "onItemSelect sticker not found");
            return;
        L32:
            List r113 = r108;
            if (r113 != null) goto L35;
        L38:
            boolean r114 = true;
        L39:
            if (r114 == false) goto L41;
        L120:
            f2.c("资源正在下载中，请稍后重试", 0);
            return;
        L41:
            if (LiveOneTapBeautyListFragment.U90(r112) == false) goto L120;
            int r115 = r104.f67361e;
            r104.f67361e = r110;
            m90.b.f512545c.e(r104.f67358b, Integer.valueOf(r110));
            r104.notifyItemChanged(r115);
            r104.notifyItemChanged(r104.f67361e);
            List<LocalSubStickerItem> r116 = r112.getSubItemStickerList();
            if (r116.isEmpty() == false) goto L46;
            ALogger.e("ttlive_inspiration_panel", "useTemplate subItems is empty");
            return;
        L46:
            List<String> r117 = LiveEffectContext.f66734h;
            com.bytedance.android.live.effect.beauty.makeups.a.C1110a.a(LiveEffectContext.a.a(r103.f67374e).b().f(), null, "ttlive_inspiration_panelinspiration_reset");
            LiveComposerFilterHelper.a(LiveEffectContext.a.a(r103.f67374e).b().m(), null, "ttlive_inspiration_panelinspiration_reset", "inspiration", false, false, 56);
            Iterator r118 = ((CopyOnWriteArrayList) LiveEffectContext.a.a(r103.f67374e).b().g().f66680b).iterator();
        L48:
            if (r118.hasNext() == false) goto L66;
            Sticker r119 = (Sticker) r118.next();
            Iterator<T> r120 = r116.iterator();
        L51:
            if (r120.hasNext() == false) goto L55;
            Object r121 = r120.next();
            if (Intrinsics.areEqual(r119.getResourceId(), ((LocalSubStickerItem) r121).getResId()) == false) goto L51;
        L57:
            if (((LocalSubStickerItem) r121) == null) goto L59;
            boolean r122 = true;
        L60:
            if (r122 == true) goto L48;
            if (r119.isSubItem() == false) goto L65;
            List<String> r123 = LiveEffectContext.f66734h;
            LiveEffectContext.a.a(r103.f67374e).a().O(d0.f66759i, r119, "ttlive_anchor_effect_LiveBeautySecondLevelFragment_reset");
        L65:
            List<String> r124 = LiveEffectContext.f66734h;
            ILiveEffectComposerManager r125 = LiveEffectContext.a.a(r103.f67374e).a();
            String r126 = d0.f66759i;
            Sticker.ComposerConfig r127 = r119.getSmallItemConfig();
            Intrinsics.checkNotNull(r127);
            ILiveEffectComposerManager.f.e(r125, r126, r119, r127.getTag(), com.bytedance.android.live.effect.q.d(r119, 0));
            goto L48
        L59:
            r122 = false;
            goto L60
        L55:
            r121 = null;
            goto L57
        L66:
            m90.c<Boolean> r128 = m90.b.f512543a;
            if (r128.c(r103.f67374e).booleanValue() == true) goto L70;
            r128.e(r103.f67374e, Boolean.TRUE);
            xs2.b.a().post(new n90.c(true, d0.f66759i));
            List<String> r129 = LiveEffectContext.f66734h;
            LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).e().d(false);
        L70:
            Iterator<T> r130 = r116.iterator();
        L72:
            if (r130.hasNext() == false) goto L119;
            LocalSubStickerItem r131 = (LocalSubStickerItem) r130.next();
            String r132 = r131.getType();
            int r133 = r132.hashCode();
            if (r133 != (-2028190455)) goto L76;
            if (r132.equals(LocalSubStickerItem.BEAUTY_TYPE_MAKEUP) == false) goto L72;
            Sticker r134 = r131.getMappingSticker();
            ArrayList<Sticker.ComposerConfig> r135 = r131.getConfigList();
            if (r134 == null) goto L72;
            if (r135.isEmpty() == true) goto L72;
            List<String> r136 = LiveEffectContext.f66734h;
            com.bytedance.android.live.effect.beauty.makeups.a.C1110a.a(LiveEffectContext.a.a(r103.f67374e).b().f(), r134, "ttlive_inspiration_panel_OnSelectItemChange_");
            Iterator<T> r137 = r135.iterator();
        L117:
            if (r137.hasNext() == false) goto L72;
            Sticker.ComposerConfig r138 = (Sticker.ComposerConfig) r137.next();
            ALogger.e("ttlive_inspiration_panel", "MAKEUP updateValue," + r134.getName() + ' ' + r138.getTag() + ' ' + r138.getDefaultValue());
            List<String> r139 = LiveEffectContext.f66734h;
            ((com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(r103.f67374e).b().f()).e(r134, r138, r138.getDefaultValue());
            goto L117
        L76:
            if (r133 != 1955267708) goto L78;
            if (r132.equals(LocalSubStickerItem.BEAUTY_TYPE_BEAUTY) == false) goto L72;
            Sticker r140 = r131.getMappingSticker();
            Sticker.ComposerConfig r141 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r131.getConfigList());
            if (r140 == null) goto L72;
            if (r141 == null) goto L72;
            List<String> r142 = LiveEffectContext.f66734h;
            ILiveEffectComposerManager r143 = LiveEffectContext.a.a(r103.f67374e).a();
            String r144 = d0.f66759i;
            r143.a(r144, r140, "ttlive_inspiration_panel_refreshView");
            ALogger.i("ttlive_inspiration_panel", "BEAUTY updateValue," + r140.getName() + ' ' + r141.getDefaultValue());
            ILiveEffectComposerManager r145 = LiveEffectContext.a.a(r103.f67374e).a();
            Sticker.ComposerConfig r146 = r140.getSmallItemConfig();
            if (r146 == null) goto L106;
            String r147 = r146.getTag();
            if (r147 == null) goto L106;
        L107:
            ILiveEffectComposerManager.f.e(r145, r144, r140, r147, com.bytedance.android.live.effect.q.d(r140, r141.getDefaultValue()));
        L106:
            r147 = "";
            goto L107
        L78:
            if (r133 != 2073804664) goto L72;
            if (r132.equals(LocalSubStickerItem.BEAUTY_TYPE_FILTER) == false) goto L72;
            Sticker r148 = r131.getMappingSticker();
            Sticker.ComposerConfig r149 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r131.getConfigList());
            if (r148 == null) goto L72;
            if (r149 == null) goto L72;
            List<String> r150 = LiveEffectContext.f66734h;
            ILiveEffectComposerManager r151 = LiveEffectContext.a.a(r103.f67374e).a();
            Iterator<T> r152 = r151.o(d0.f66751a).iterator();
        L88:
            if (r152.hasNext() == false) goto L92;
            Object r153 = r152.next();
            if (Intrinsics.areEqual(((Sticker) r153).getResourceId(), r148.getResourceId()) == false) goto L88;
        L94:
            if (((Sticker) r153) != null) goto L72;
            ALogger.i("ttlive_inspiration_panel", "Filter updateValue," + r148.getName() + ' ' + r149.getDefaultValue());
            List<String> r154 = LiveEffectContext.f66734h;
            com.bytedance.android.live.effect.beauty.makeups.a r155 = LiveEffectContext.a.a(r103.f67374e).b().f();
            String r156 = d0.f66751a;
            ((com.bytedance.android.live.effect.beauty.makeups.d) r155).c(r156, r148, r103.f67375f);
            r151.b(r156, "ttlive_inspiration_panel");
            r151.a(r156, r148, "ttlive_inspiration_panel");
            Unit r157 = Unit.INSTANCE;
            goto L72
        L92:
            r153 = null;
            goto L94
        L119:
            List<String> r158 = LiveEffectContext.f66734h;
            LiveEffectContext.a.a(r103.f67374e).a().x("ttlive_inspiration_panel_OneTapItemChange_");
            return;
        L35:
            if (r113.isEmpty() == true) goto L38;
            r114 = false;
            goto L39
        L26:
            r111 = null;
            goto L27
        L28:
            r112 = null;
            goto L30
        }
    }

    static {
    }

    public final LiveOneTapBeautyAdapter T90() {
        return (LiveOneTapBeautyAdapter) this.f67377h.getValue();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        List<String> r100 = LiveEffectContext.f66734h;
        n.b.b(LiveEffectContext.a.a(this.f67374e).b().h(), this.f67378i);
        super.onDestroyView();
        ((LinkedHashMap) this.f67373d).clear();
    }

    public LiveOneTapBeautyListFragment() {
        this.f67373d = new LinkedHashMap();
        this.f67374e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f67375f = "";
        this.f67376g = new Handler(Looper.getMainLooper());
        this.f67377h = LazyKt.lazy(new LiveOneTapBeautyListFragment$beautyAdapter$2(this));
        this.f67378i = new b(this);
        this.f67380k = new d(this);
        this.f67381l = new c(this);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    public static boolean U90(Sticker r100) {
        LiveEffectContextFactoryDelegate$Type r101 = i.f67406a;
        Intrinsics.checkNotNullParameter(r100, "localSticker");
        if (r100.getSubItemStickerList().size() == r100.getComposerConfigList().size()) goto L5;
        i.a(CollectionsKt.mutableListOf(new Sticker[]{r100}));
    L5:
        Iterator<T> r102 = r100.getSubItemStickerList().iterator();
        boolean r103 = true;
    L7:
        if (r102.hasNext() == false) goto L24;
        Sticker r104 = ((LocalSubStickerItem) r102.next()).getMappingSticker();
        if (r104 == null) goto L12;
        String r105 = r104.getStickerPanel();
        if (r105 == null) goto L12;
    L13:
        if (r104 == null) goto L23;
        if (r104.isDownloaded() == true) goto L21;
        List<String> r106 = LiveEffectContext.f66734h;
        LiveEffectContextFactoryDelegate$Type r107 = i.f67406a;
        if (LiveEffectContext.a.a(r107).b().r().q(r104) == true) goto L20;
        ALogger.d("ttlive_inspiration_panel", "item not download,id:" + r104.getId() + ",name:" + r104.getName());
        LiveEffectContext.a.a(r107).b().r().g(r105, r104, i.f67407b);
        boolean r108 = false;
    L22:
        if (r108 == true) goto L7;
    L20:
        r104.setDownloaded(true);
    L21:
        r108 = true;
    L23:
        r103 = false;
    L12:
        r105 = d0.f66759i;
        goto L13
    L24:
        return r103;
    }

    public final View S90(int r100) {
        if (this.f67373d != null) goto L5;
        this.f67373d = new LinkedHashMap();
    L5:
        View r101 = this.f67373d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f67373d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r100 == true) goto L10;
        LiveOneTapBeautyAdapter r101 = T90();
        if (r101 == null) goto L11;
        m90.c<Integer> r102 = m90.b.f512545c;
        int r103 = r102.c(r101.f67358b).intValue();
        int r104 = r101.f67361e;
        r101.f67361e = r103;
        r102.e(r101.f67358b, Integer.valueOf(r103));
        r101.notifyItemChanged(r104);
        r101.notifyItemChanged(r101.f67361e);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LiveDoubleColorBallAnimationView r102 = null;
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_effect_view_panel_loading_error_view, null);
        r103.setOnClickListener(new g(this));
        View r104 = getView();
        if (r104 != null) goto L5;
    L6:
        Context r105 = getContext();
        if (r105 == null) goto L9;
        r102 = new LiveDoubleColorBallAnimationView(r105);
        int r106 = r102.getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(r106, r106);
        r107.gravity = 17;
        r102.setLayoutParams(r107);
        Unit r108 = Unit.INSTANCE;
    L9:
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setVisibility(8);
        ((LoadingStatusView) S90(R.id.small_item_beauty_loading_view)).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r103).setLoadingView(r102));
        ((LoadingStatusView) S90(R.id.small_item_beauty_loading_view)).showLoading();
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setAdapter(T90());
        ALogger.i("ttlive_inspiration_panel", "refreshView, reason = OneTapInitView");
        List<String> r109 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f67374e).a().U(d0.f66759i) <= 0) goto L12;
    L20:
        S90(R.id.small_item_beauty_recycle_view).setAlpha(0.5f);
        View r110 = S90(R.id.toast_view);
        if (r110 == null) goto L23;
        r110.setVisibility(0);
        r110.setOnClickListener(h.f67405a);
    L23:
        com.bytedance.android.live.effect.beauty.newtemp.c.a(LiveEffectContext.a.a(this.f67374e).b().c(), this.f67374e, new WeakReference(this.f67381l));
        if (LiveEffectContext.a.a(this.f67374e).b().h().c() == true) goto L26;
        return;
    L26:
        if (Intrinsics.areEqual(this.f67375f, "live_take_page") == false) goto L30;
        n.b.a(LiveEffectContext.a.a(this.f67374e).b().h(), this.f67378i);
        return;
    L30:
        return;
    L12:
        if (LiveEffectContext.a.a(this.f67374e).a().U(d0.f66761k) > 0) goto L20;
        if (LiveEffectContext.a.a(this.f67374e).a().U(d0.f66751a) > 0) goto L20;
        View r111 = S90(R.id.toast_view);
        if (r111 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r111);
    L19:
        S90(R.id.small_item_beauty_recycle_view).setAlpha(1.0f);
        goto L23
    L5:
        if (r104.getContext() != null) goto L9;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_effect_fragment_beauty_template_item_new, r101, false);
    }
}
