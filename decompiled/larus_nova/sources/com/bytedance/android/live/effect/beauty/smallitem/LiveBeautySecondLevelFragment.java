package com.bytedance.android.live.effect.beauty.smallitem;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveBeautySecondLevelFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DivideItemDecoration", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautySecondLevelFragment extends BaseFragment {
    public static final /* synthetic */ int C = 0;
    public final d A;
    public boolean B;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f67533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Sticker f67534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f67535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f67536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f67537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f67538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f67539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LiveEffectContextFactoryDelegate$Type f67540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.effect.sticker.e f67541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f67542m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<Integer> f67543n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<Integer> f67544o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f67545p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Handler f67546q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f67547r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f67548s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f67549t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f67550u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f67551v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f67552w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f67553x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final e f67554y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f67555z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveBeautySecondLevelFragment$DivideItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DivideItemDecoration extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f67556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f67557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f67558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f67559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f67560e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f67561f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ArrayList<Integer> f67562g;

        public DivideItemDecoration(ArrayList<Integer> r100) {
            Intrinsics.checkNotNullParameter(r100, "conditionList");
            this.f67562g = r100;
            Paint r101 = new Paint(5);
            r101.setColor(872415231);
            r101.setStyle(Paint.Style.FILL);
            Unit r102 = Unit.INSTANCE;
            this.f67556a = r101;
            this.f67557b = UtilityKotlinExtentionsKt.h(15);
            this.f67558c = UtilityKotlinExtentionsKt.h(36);
            this.f67559d = UtilityKotlinExtentionsKt.h(0.5f);
            float r103 = UtilityKotlinExtentionsKt.h(4.5f);
            this.f67560e = r103;
            this.f67561f = (int) (r103 * 2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
            Intrinsics.checkNotNullParameter(r110, "c");
            Intrinsics.checkNotNullParameter(r111, "parent");
            Intrinsics.checkNotNullParameter(r112, "state");
            super.onDraw(r110, r111, r112);
            int r113 = r111.getChildCount();
            int r100 = 0;
        L3:
            if (r100 >= r113) goto L8;
            View r101 = r111.getChildAt(r100);
            if (this.f67562g.contains(Integer.valueOf(r111.getChildAdapterPosition(r101))) == false) goto L7;
            float r102 = r101.getLeft() - this.f67560e;
            float r103 = this.f67557b;
            r110.drawRect(r102, r103, r102 + this.f67559d, r103 + this.f67558c, this.f67556a);
        L7:
            r100 = r100 + 1;
            goto L3
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            super.getItemOffsets(r100, r101, r102, r103);
            int r104 = r102.getChildAdapterPosition(r101);
            if (this.f67562g.contains(Integer.valueOf(r104)) == false) goto L6;
            r100.set(this.f67561f, 0, 0, 0);
            return;
        L6:
            if (r104 != 1) goto L8;
            r100.set((int) this.f67560e, 0, 0, 0);
            return;
        L8:
            r100.set(0, 0, 0, 0);
        }
    }

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautySecondLevelFragment f67563a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LiveBeautySecondLevelFragment r100 = this.f67563a;
            int r101 = LiveBeautySecondLevelFragment.C;
            r100.Z90("BeautyModeChangeListener_onChangeComplete");
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveBeautySecondLevelFragment r100 = this.f67563a;
            int r101 = LiveBeautySecondLevelFragment.C;
            r100.getClass();
            List<String> r102 = LiveEffectContext.f66734h;
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(r100.f67540k).a(), com.bytedance.android.live.effect.api.d0.f66759i, "LiveBeautySecondLevelFragment_onBeautyModeChange");
            LiveEffectContext.a.a(r100.f67540k).b().l().c("beautyclassify", r100.f67540k, new WeakReference(r100.f67553x), true);
        }

        public b(LiveBeautySecondLevelFragment r100) {
            this.f67563a = r100;
        }
    }

    public static final class c implements com.bytedance.android.live.effect.beauty.smallitem.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautySecondLevelFragment f67564a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f67565a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f67566b;

            public a(c r100, List r101) {
                this.f67565a = r100;
                this.f67566b = r101;
            }

            public final void a() {
                LiveBeautySecondLevelFragment r100 = this.f67565a.f67564a;
                List<EffectCategoryModel> r101 = this.f67566b;
                int r102 = LiveBeautySecondLevelFragment.C;
                if (r100.isDestroyed() == true) goto L21;
                List<EffectCategoryModel> r103 = r101;
                if (r103 != null) goto L8;
            L11:
                boolean r104 = true;
            L12:
                if (r104 == true) goto L22;
                List<EffectCategoryModel> r105 = r101;
                ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
                Iterator r107 = r105.iterator();
            L16:
                if (r107.hasNext() == false) goto L18;
                r106.add(((EffectCategoryModel) r107.next()).getName());
                goto L16
            L18:
                LiveBeautySecLevelSlidingTab r108 = (LiveBeautySecLevelSlidingTab) r100.S90(R.id.broadcast_beauty_second_level_strip);
                ((ArrayList) r108.A).clear();
                ((ArrayList) r108.A).addAll(r106);
                r108.a();
                ((LiveBeautySecLevelSlidingTab) r100.S90(R.id.broadcast_beauty_second_level_strip)).setOnClickItemListener(new m(r100));
                ((LiveBeautySecLevelSlidingTab) r100.S90(R.id.broadcast_beauty_second_level_strip)).b(0);
                List<String> r109 = LiveEffectContext.f66734h;
                LiveEffectContext.a.a(r100.f67540k).b().l().a(r100.f67540k, "beautyclassify", r101, r100.A);
                return;
            L22:
                return;
            L8:
                if (r103.isEmpty() == true) goto L11;
                r104 = false;
                goto L12
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

        @Override // com.bytedance.android.live.effect.beauty.smallitem.b
        public final void onError() {
            LoadingStatusView r100 = (LoadingStatusView) this.f67564a.S90(R.id.small_item_beauty_loading_view);
            if (r100 == null) goto L5;
            r100.showError();
        L5:
            this.f67564a.f67541l.m();
        }

        public c(LiveBeautySecondLevelFragment r100) {
            this.f67564a = r100;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.b
        public final void onSuccess(List<EffectCategoryModel> r100) {
            Intrinsics.checkNotNullParameter(r100, "stickerCategoryList");
            this.f67564a.f67546q.post(new a(this, r100));
        }
    }

    public static final class d implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautySecondLevelFragment f67567a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f67568a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f67569b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f67570c;

            public a(d r100, List r101, List r102) {
                this.f67568a = r100;
                this.f67569b = r101;
                this.f67570c = r102;
            }

            public final void a() {
                LiveBeautySecondLevelFragment r100 = this.f67568a.f67567a;
                List r101 = this.f67569b;
                List r102 = this.f67570c;
                r100.getClass();
                Intrinsics.checkNotNullParameter(r101, "stickerList");
                if (r100.isDestroyed() == false) goto L6;
                return;
            L6:
                if (r101.isEmpty() == false) goto L8;
                LiveEffectMonitor.d(com.bytedance.android.live.effect.api.d0.f66759i, 1000, "empty list");
            L8:
                int r103 = 1;
                if (r100.f67545p == false) goto L31;
                List r104 = r101;
                LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
                Iterator r106 = r104.iterator();
            L12:
                if (r106.hasNext() == false) goto L14;
                Object r110 = r106.next();
                r105.put(((Sticker) r110).getResourceId(), r110);
                goto L12
            L14:
                List<String> r107 = LiveEffectContext.f66734h;
                com.bytedance.android.live.effect.beauty.smallitem.c r108 = LiveEffectContext.a.a(r100.f67540k).b().b();
                int r111 = r108.f67665d;
                if (r111 <= 0) goto L17;
                List r109 = CollectionsKt.take(r108.f67664c, r111);
            L19:
                if ((!r109.isEmpty()) == false) goto L27;
                ArrayList r112 = new ArrayList();
                Iterator r113 = r109.iterator();
            L22:
                if (r113.hasNext() == false) goto L26;
                Sticker r114 = (Sticker) r105.get((String) r113.next());
                if (r114 == null) goto L22;
                r112.add(r114);
                goto L22
            L26:
                List r115 = CollectionsKt.plus(r112, r104);
                int r116 = r112.size();
            L28:
                if (r116 <= 0) goto L30;
                LiveBeautySecLevelSlidingTab r117 = (LiveBeautySecLevelSlidingTab) r100.S90(R.id.broadcast_beauty_second_level_strip);
                ListProtector.add(r117.A, 0, "我的常用");
                r117.a();
                ((LiveBeautySecLevelSlidingTab) r100.S90(R.id.broadcast_beauty_second_level_strip)).b(0);
            L30:
                List r118 = r115;
                int r119 = r116;
                r101 = r118;
            L32:
                LiveSmallItemBeautyTemplateAdapter r120 = r100.V90();
                r120.getClass();
                Intrinsics.checkNotNullParameter(r101, "list");
                ((ArrayList) r120.f67626a).clear();
                ((ArrayList) r120.f67627b).clear();
                ((LinkedHashMap) r120.f67628c).clear();
                List r121 = r101;
                ((ArrayList) r120.f67626a).addAll(r121);
                List<String> r122 = r120.f67627b;
                List r123 = r101;
                ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
                Iterator r125 = r123.iterator();
            L34:
                if (r125.hasNext() == false) goto L36;
                r124.add(((Sticker) r125.next()).getEffectId());
                goto L34
            L36:
                ((ArrayList) r122).addAll(r124);
                r120.notifyDataSetChanged();
                r100.aa0(0);
                if (r100.f67534e != null) goto L44;
                if (m90.b.f512543a.c(r100.f67540k).booleanValue() == false) goto L44;
                if ((!r121.isEmpty()) == false) goto L44;
                r100.f67534e = (Sticker) ListProtector.get(r101, 0);
            L44:
                if (r100.S90(R.id.small_item_beauty_loading_view) == null) goto L46;
                ((LoadingStatusView) r100.S90(R.id.small_item_beauty_loading_view)).setVisibility(8);
            L46:
                if (r102 == null) goto L65;
                r100.f67543n.clear();
                if (r100.f67545p == false) goto L51;
                if (r119 <= 0) goto L51;
                r100.f67543n.add(Integer.valueOf(r119));
            L51:
                Iterator r126 = r102.iterator();
                int r127 = 0;
            L53:
                if (r126.hasNext() == false) goto L64;
                int r128 = ((Number) r126.next()).intValue();
                if (r128 != 0) goto L62;
                LiveBeautySecLevelSlidingTab r129 = (LiveBeautySecLevelSlidingTab) r100.S90(R.id.broadcast_beauty_second_level_strip);
                if (r127 >= 0) goto L59;
                r129.getClass();
            L63:
                r127 = r127 + 1;
                goto L53
            L59:
                if (r127 >= ((ArrayList) r129.A).size()) goto L63;
                ListProtector.remove(r129.A, r127);
                r129.a();
                goto L63
            L62:
                r100.f67543n.add(Integer.valueOf(r128));
                goto L63
            L64:
                ((LiveBeautySecLevelSlidingTab) r100.S90(R.id.broadcast_beauty_second_level_strip)).b(0);
            L65:
                r100.f67544o.clear();
                int r130 = r100.f67543n.size();
            L66:
                if (r103 >= r130) goto L68;
                r100.f67544o.add(Integer.valueOf(r100.W90(r103)));
                r103 = r103 + 1;
                goto L66
            L68:
                r100.Z90("ttlive_anchor_effect_LiveBeautySecondLevelFragment_beautyLoadCallback_onSuccess");
                return;
            L27:
                r115 = r101;
                r116 = 0;
                goto L28
            L17:
                r109 = CollectionsKt.emptyList();
                goto L19
            L31:
                r119 = 0;
                goto L32
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
            LoadingStatusView r100 = (LoadingStatusView) this.f67567a.S90(R.id.small_item_beauty_loading_view);
            if (r100 == null) goto L5;
            r100.showError();
        L5:
            this.f67567a.f67541l.m();
        }

        public d(LiveBeautySecondLevelFragment r100) {
            this.f67567a = r100;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void a(List<Sticker> r100, List<Integer> r101) {
            Intrinsics.checkNotNullParameter(r100, "stickerList");
            if (r100.isEmpty() == false) goto L7;
            LoadingStatusView r102 = (LoadingStatusView) this.f67567a.S90(R.id.small_item_beauty_loading_view);
            if (r102 == null) goto L9;
            r102.showError();
            return;
        L9:
            return;
        L7:
            this.f67567a.f67546q.post(new a(this, r100, r101));
        }
    }

    public static final class e implements ILiveEffectComposerManager.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveBeautySecondLevelFragment f67571a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f67572a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f67573b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Sticker f67574c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f67575d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ float f67576e;

            public a(e r100, String r101, Sticker r102, String r103, float r104) {
                this.f67572a = r100;
                this.f67573b = r101;
                this.f67574c = r102;
                this.f67575d = r103;
                this.f67576e = r104;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LiveBeautySecondLevelFragment r100 = this.f67572a.f67571a;     // Catch: Throwable -> L4
                int r101 = LiveBeautySecondLevelFragment.C;     // Catch: Throwable -> L4
                LiveSmallItemBeautyTemplateAdapter r102 = r100.V90();     // Catch: Throwable -> L4
                String r103 = this.f67573b;     // Catch: Throwable -> L4
                Sticker r104 = this.f67574c;     // Catch: Throwable -> L4
                String r105 = this.f67575d;     // Catch: Throwable -> L4
                float r106 = this.f67576e;     // Catch: Throwable -> L4
                r102.getClass();     // Catch: Throwable -> L4
                ILiveEffectComposerManager.c.a.a(r102, r103, r104, r105, r106);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public e(LiveBeautySecondLevelFragment r100) {
            this.f67571a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
        public final void F(String r100, Sticker r101, String r102, float r103) {
            ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
        public final void u2(String r100, Sticker r101, String r110, float r111, HashMap<String, String> r112) {
            LiveBeautySecondLevelFragment r113 = this.f67571a;
            if (r113.f67555z == false) goto L8;
            RecyclerView r114 = (RecyclerView) r113.S90(R.id.small_item_beauty_recycle_view);
            if (r114 == null) goto L9;
            r114.post(new a(this, r100, r101, r110, r111));
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final LiveSmallItemBeautyTemplateAdapter V90() {
        return (LiveSmallItemBeautyTemplateAdapter) this.f67547r.getValue();
    }

    public final View X90() {
        return (View) this.f67550u.getValue();
    }

    public final View Y90() {
        return (View) this.f67549t.getValue();
    }

    public final void U90() {
        List<String> r100 = LiveEffectContext.f66734h;
        Iterator<T> r101 = LiveEffectContext.a.a(this.f67540k).a().o(com.bytedance.android.live.effect.api.d0.f66759i).iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L21;
        Sticker r103 = (Sticker) r101.next();
        Sticker.ComposerConfig r104 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r103.getComposerConfigList());
        if (r104 == null) goto L8;
        int r105 = r104.getDefaultValue();
    L9:
        float r106 = com.bytedance.android.live.effect.q.d(r103, r105);
        List<String> r107 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r108 = LiveEffectContext.a.a(this.f67540k).a();
        String r109 = r103.getEffectId();
        Sticker.ComposerConfig r110 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r103.getComposerConfigList());
        if (r110 == null) goto L13;
        String r111 = r110.getTag();
        if (r111 == null) goto L13;
    L14:
        Float r112 = r108.G(r109, r111);
        if (r112 == null) goto L17;
        float r113 = r112.floatValue();
    L19:
        if (r113 == r106) goto L4;
        r102 = true;
        goto L4
    L17:
        r113 = 0.0f;
    L13:
        r111 = "";
        goto L14
    L8:
        r105 = 0;
        goto L9
    L21:
        this.f67536g = r102;
        if (r102 == false) goto L24;
        X90().setClickable(true);
        X90().setAlpha(1.0f);
        X90().setContentDescription(s1.B(R.string.ttlive_effect_live_beauty_small_reset));
        return;
    L24:
        X90().setClickable(false);
        X90().setAlpha(0.5f);
        X90().setContentDescription(s1.B(R.string.ttlive_effect_live_beauty_small_reset_disable));
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67540k).a().K(this.f67554y);
        super.onDestroy();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67540k).b().h().a(this.f67548s, "beautyclassify");
        super.onDestroyView();
        ((LinkedHashMap) this.f67533d).clear();
    }

    public LiveBeautySecondLevelFragment() {
        this.f67533d = new LinkedHashMap();
        this.f67536g = true;
        this.f67538i = R.layout.ttlive_effect_item_external_beauty_template_small_item;
        this.f67539j = R.layout.ttlive_effect_beauty_sub_item_template;
        this.f67540k = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f67541l = new com.bytedance.android.live.effect.sticker.e("beautyclassify");
        this.f67542m = "";
        this.f67543n = new ArrayList();
        this.f67544o = new ArrayList();
        this.f67545p = LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().b();
        this.f67546q = new Handler(Looper.getMainLooper());
        this.f67547r = LazyKt.lazy(new LiveBeautySecondLevelFragment$beautyAdapter$2(this));
        this.f67548s = new b(this);
        this.f67549t = LazyKt.lazy(new LiveBeautySecondLevelFragment$smallItemBeautySeekBar$2(this));
        this.f67550u = LazyKt.lazy(new LiveBeautySecondLevelFragment$smallItemBeautyResetView$2(this));
        this.f67553x = new c(this);
        this.f67554y = new e(this);
        this.A = new d(this);
        this.B = true;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        LiveSmallItemBeautyTemplateAdapter r100 = V90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r100.f67638m).b().g().e(r100.f67635j);
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LiveSmallItemBeautyTemplateAdapter r100 = V90();
        r100.getClass();
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r100.f67638m).b().g().a(r100.f67635j);
        if (this.B == true) goto L5;
        Z90("on resume");
        return;
    L5:
        this.B = false;
    }

    public final View S90(int r100) {
        if (this.f67533d != null) goto L5;
        this.f67533d = new LinkedHashMap();
    L5:
        View r101 = this.f67533d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f67533d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final int W90(int r100) {
        int r101 = 0;
        if (this.f67543n.size() > r100) goto L5;
        return 0;
    L5:
        int r102 = 0;
    L6:
        if (r101 >= r100) goto L8;
        r102 = r102 + ((Number) ListProtector.get(this.f67543n, r101)).intValue();
        r101 = r101 + 1;
        goto L6
    L8:
        if (r102 > 0) goto L10;
        return r102;
    L10:
        return r102 + 1;
    }

    public final void Z90(String r100) {
        if (Y90() != null) goto L5;
        return;
    L5:
        int r101 = 0;
        if (m90.b.f512543a.c(this.f67540k).booleanValue() == true) goto L13;
        Y90().setVisibility(8);
        if (S90(R.id.small_item_beauty_recycle_view) == null) goto L10;
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setAlpha(0.75f);
    L10:
        List<String> r102 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67540k).a().T(r100, false);
        return;
    L13:
        if (S90(R.id.small_item_beauty_recycle_view) == null) goto L15;
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setAlpha(1.0f);
    L15:
        List<String> r103 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67540k).a().T(r100, false);
        ILiveEffectComposerManager r104 = LiveEffectContext.a.a(this.f67540k).a();
        String r105 = com.bytedance.android.live.effect.api.d0.f66759i;
        if (r104.U(r105) <= 0) goto L19;
        Y90().setVisibility(8);
        return;
    L19:
        Sticker r106 = this.f67534e;
        View r107 = null;
        if (r106 == null) goto L22;
        Sticker.ComposerConfig r108 = r106.getSmallItemConfig();
    L23:
        if (r108 != null) goto L26;
        Y90().setVisibility(8);
        return;
    L26:
        Y90().setVisibility(0);
        View r109 = Y90();
        Sticker r110 = this.f67534e;
        if (r110 == null) goto L29;
        String r111 = r110.getName();
    L30:
        r109.setTag(r111);
        ILiveEffectComposerManager r112 = LiveEffectContext.a.a(this.f67540k).a();
        Sticker r113 = this.f67534e;
        String r114 = "";
        if (r113 == null) goto L34;
        String r115 = r113.getEffectId();
        if (r115 == null) goto L34;
    L35:
        Sticker r116 = this.f67534e;
        if (r116 == null) goto L43;
        Sticker.ComposerConfig r117 = r116.getSmallItemConfig();
        if (r117 == null) goto L43;
        String r118 = r117.getTag();
        if (r118 == null) goto L43;
        r114 = r118;
    L43:
        Float r119 = r112.G(r115, r114);
        if (r119 != null) goto L52;
        Sticker r120 = this.f67534e;
        Intrinsics.checkNotNull(r120);
        Sticker r121 = this.f67534e;
        if (r121 == null) goto L50;
        Sticker.ComposerConfig r122 = r121.getSmallItemConfig();
        if (r122 == null) goto L50;
        Integer r123 = Integer.valueOf(r122.getDefaultValue());
    L51:
        Intrinsics.checkNotNull(r123);
        r119 = Float.valueOf(com.bytedance.android.live.effect.q.d(r120, r123.intValue()));
    L50:
        r123 = null;
    L52:
        Sticker r124 = this.f67534e;
        int r125 = 100;
        boolean r126 = true;
        if (r124 == null) goto L64;
        Sticker.ComposerConfig r127 = r124.getSmallItemConfig();
        if (r127 == null) goto L64;
        if (r127.getDoubleDirection() != true) goto L64;
        View r128 = Y90();
        if ((r128 instanceof BeautifyAdjustPercentBar) == true) goto L61;
        r128 = null;
    L61:
        BeautifyAdjustPercentBar r129 = (BeautifyAdjustPercentBar) r128;
        if (r129 == null) goto L70;
        r129.Y5(50, -50, 0, false);
    L70:
        View r130 = Y90();
        if ((r130 instanceof BeautifyAdjustPercentBar) == false) goto L74;
        r107 = r130;
    L74:
        BeautifyAdjustPercentBar r131 = (BeautifyAdjustPercentBar) r107;
        if (r131 == null) goto L94;
        int r132 = com.bytedance.android.live.effect.q.f68060a;
        Sticker r133 = this.f67534e;
        Intrinsics.checkNotNull(r133);
        float r134 = r119.floatValue();
        Intrinsics.checkNotNullParameter(r133, "sticker");
        Sticker.ComposerConfig r135 = r133.getSmallItemConfig();
        if (r134 == 0.0f) goto L93;
        if (r135 == null) goto L81;
        r125 = r135.getMaxValue();
        int r136 = r135.getMinValue();
    L82:
        if (r136 < 0) goto L85;
        r126 = false;
    L85:
        if (r126 == true) goto L87;
        float r137 = r134 * 10000;
        float r138 = r125 - r136;
    L92:
        r101 = MathKt.roundToInt(r137 / r138);
        goto L93
    L87:
        if (r134 <= 0) goto L89;
        int r139 = 5000 / r125;
    L90:
        r137 = r134 * r139;
        r138 = 2;
        goto L92
    L89:
        r139 = (-5000) / r136;
        goto L90
    L81:
        r136 = 0;
    L93:
        r131.setPercent(r101);
    L94:
        ILiveEffectComposerManager r140 = LiveEffectContext.a.a(this.f67540k).a();
        Sticker r141 = this.f67534e;
        Intrinsics.checkNotNull(r141);
        r140.a(r105, r141, "ttlive_anchor_effect_LiveBeautySecondLevelFragment_refreshView");
        return;
    L64:
        View r142 = Y90();
        if ((r142 instanceof BeautifyAdjustPercentBar) == true) goto L67;
        r142 = null;
    L67:
        BeautifyAdjustPercentBar r143 = (BeautifyAdjustPercentBar) r142;
        if (r143 == null) goto L70;
        r143.Y5(100, 0, 0, true);
    L34:
        r115 = "";
        goto L35
    L29:
        r111 = null;
        goto L30
    L22:
        r108 = null;
        goto L23
    }

    public final void aa0(int r100) {
        LiveBeautySecLevelSlidingTab r101 = (LiveBeautySecLevelSlidingTab) S90(R.id.broadcast_beauty_second_level_strip);
        if (r101 == null) goto L11;
        List<String> r102 = r101.getDatas();
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.size() > r100) goto L9;
        return;
    L9:
        Disposable r103 = com.bytedance.android.live.effect.utils.k.f68877a;
        String r104 = this.f67542m;
        String r105 = (String) ListProtector.get(r102, r100);
        Intrinsics.checkNotNullParameter(r104, "eventPage");
        Intrinsics.checkNotNullParameter(r105, "tabName");
        HashMap r106 = new HashMap();
        r106.put("live_type", "video_live");
        r106.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r105);
        com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_subitem_tab_show", r106, r104);
        return;
    }

    public final void ba0(String r100) {
        List<String> r101 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.api.c r102 = LiveEffectContext.a.a(this.f67540k).e();
        HashMap<String, String> r103 = new HashMap();
        r103.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_take_detail");
        r103.put("evnet_type", "click");
        r103.put("evnet_belong", "live_take");
        Unit r104 = Unit.INSTANCE;
        r102.sendLog(r100, r103);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        ALogger.i("ttlive_anchor_effect_LiveBeautySecondLevelFragment", "onHiddenChanged,hidden:" + r100);
        if (r100 == true) goto L12;
        Z90("onHiddenChanged");
        LiveBeautySecLevelSlidingTab r101 = (LiveBeautySecLevelSlidingTab) S90(R.id.broadcast_beauty_second_level_strip);
        if (r101 == null) goto L10;
        aa0(r101.getCurrentPosition());
    L10:
        LiveSmallItemBeautyTemplateAdapter r102 = V90();
        r102.f67639n = m90.b.f512543a.c(this.f67540k).booleanValue();
        r102.notifyItemChanged(0);
        return;
    }

    public static final int T90(LiveBeautySecondLevelFragment r100, int r101) {
        int r102 = r100.f67543n.size();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r102) goto L9;
        r104 = r104 + ((Number) ListProtector.get(r100.f67543n, r103)).intValue();
        if (((-1) + r101) < r104) goto L13;
        r103 = r103 + 1;
        goto L4
    L13:
        return r103;
    L9:
        return -1;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = null;
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.liveuikit_layout_loading_error, null);
        r103.setOnClickListener(new j(this));
        ((LoadingStatusView) S90(R.id.small_item_beauty_loading_view)).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r103).setUseProgressBar(getResources().getDimensionPixelSize(R.dimen.ttlive_effect_default_list_progressbar_size)));
        ((LoadingStatusView) S90(R.id.small_item_beauty_loading_view)).showLoading();
        View r104 = Y90();
        if ((r104 instanceof BeautifyAdjustPercentBar) == true) goto L5;
        r104 = null;
    L5:
        BeautifyAdjustPercentBar r105 = (BeautifyAdjustPercentBar) r104;
        if (r105 == null) goto L8;
        r105.U5(s1.h(R.color.ttlive_effect_broadcast_beauty_template_seek_bar_progress_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_progress_bg_color), s1.h(R.color.ttlive_effect_broadcast_beauty_seek_bar_circle_color));
    L8:
        this.f67551v = X90().findViewById(R.id.icon);
        this.f67552w = X90().findViewById(R.id.reset_text);
        View r106 = Y90();
        if ((r106 instanceof BeautifyAdjustPercentBar) == false) goto L12;
        r102 = r106;
    L12:
        BeautifyAdjustPercentBar r107 = (BeautifyAdjustPercentBar) r102;
        if (r107 == null) goto L15;
        r107.setOnLevelChangeListener(new k(this));
    L15:
        List<String> r108 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67540k).a().l(this.f67554y);
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).setAdapter(V90());
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).addItemDecoration(new DivideItemDecoration(this.f67544o));
        ((RecyclerView) S90(R.id.small_item_beauty_recycle_view)).addOnScrollListener(new LiveBeautySecondLevelFragment$initView$3(this));
        X90().setOnClickListener(new l(this));
        Z90("ttlive_anchor_effect_LiveBeautySecondLevelFragment_beautyInitView");
        U90();
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().a().a();
        com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.f67540k).b().l(), "beautyclassify", this.f67540k, new WeakReference(this.f67553x), 8);
        if (LiveEffectContext.a.a(this.f67540k).b().h().c() == false) goto L19;
        LiveEffectContext.a.a(this.f67540k).b().h().f(this.f67548s, "beautyclassify");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_effect_fragment_beauty_small_second_level_item, r101, false);
    }
}
