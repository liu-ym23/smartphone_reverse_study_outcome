package com.bytedance.android.ec.hybrid.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.api.card.IECHybridCardService;
import com.bytedance.android.ec.hybrid.data.entity.ECPreloadConfigItemV3;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ability.DataResolver;
import com.bytedance.android.ec.hybrid.list.ability.c0;
import com.bytedance.android.ec.hybrid.list.ability.d0;
import com.bytedance.android.ec.hybrid.list.ability.f0;
import com.bytedance.android.ec.hybrid.list.ability.j0;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.ability.p;
import com.bytedance.android.ec.hybrid.list.ability.r;
import com.bytedance.android.ec.hybrid.list.ability.y;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridHolderUpdateParams;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ChipData;
import com.bytedance.android.ec.hybrid.list.entity.dto.ChipViewConfig;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.j;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECDefLoadMoreViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.holder.EmptyViewHolder;
import com.bytedance.android.ec.hybrid.list.util.o;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import yj.u;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/ECHybridListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "Landroid/content/Context;", "t", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f46839w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataResolver f46840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f46841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<?> f46842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<BaseViewHolder> f46843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Stack<ECLynxCardHolder>> f46844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<Integer, Stack<BaseViewHolder>> f46845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.list.util.e f46846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.bytedance.android.ec.hybrid.list.ability.b> f46847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.list.entity.b f46848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function2<? super String, ? super Boolean, Unit> f46849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function3<? super String, ? super Boolean, ? super Boolean, Unit> f46850k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super ECHybridHolderUpdateParams, Unit> f46851l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f46852m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f0 f46853n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f46854o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f46855p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f46856q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f46857r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<Long> f46858s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Context f46859t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ECHybridListEngine f46860u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.list.ability.a f46861v;

    public static final class a {
    }

    static {
    }

    public final j C2() {
        Intrinsics.checkNotNullParameter("insert_card_section", "sectionId");
        DataResolver r100 = this.f46840a;
        if (r100 == null) goto L20;
        ArrayList<i> r101 = r100.f46937c;
        if (r101 == null) goto L21;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((i) r103).f47107a, "insert_card_section") == false) goto L8;
    L13:
        i r104 = (i) r103;
        if (r104 != null) goto L16;
        return null;
    L16:
        return r104.f47114h;
    L12:
        r103 = null;
        goto L13
    L21:
        return null;
    L20:
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        DataResolver r100 = this.f46840a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.i();
    }

    public final Context getContext() {
        return this.f46859t;
    }

    public static String B2(String r100) {
        String r101 = UriProtector.getQueryParameter(UriProtector.parse(r100), "surl");
        if (r101 != null) goto L6;
        return r100;
    L6:
        return r101;
    }

    public final Integer E2(ECPreloadConfigItemV3 r100) {
        if (((Number) this.f46857r.getValue()).intValue() > 0) goto L5;
        return null;
    L5:
        if (r100 == null) goto L29;
        int r101 = ((Number) this.f46857r.getValue()).intValue();
        Double r102 = r100.getMarginLeft();
        if (r102 == null) goto L9;
        double r103 = r102.doubleValue();
        int r104 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r101 = r101 - com.bytedance.android.ec.hybrid.list.util.c.a(Double.valueOf(r103), null, Boolean.FALSE);
    L9:
        Double r105 = r100.getMarginRight();
        if (r105 == null) goto L12;
        double r106 = r105.doubleValue();
        int r107 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r101 = r101 - com.bytedance.android.ec.hybrid.list.util.c.a(Double.valueOf(r106), null, Boolean.FALSE);
    L12:
        Integer r108 = r100.getColumnNum();
        if (r108 == null) goto L29;
        int r109 = r108.intValue();
        if (r109 != 1) goto L19;
        return Integer.valueOf(r101);
    L19:
        if (2 > r109) goto L29;
        if (6 < r109) goto L29;
        Double r110 = r100.getItemGapH();
        if (r110 == null) goto L28;
        double r111 = r110.doubleValue();
        int r112 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        return Integer.valueOf((r101 - ((r109 - 1) * com.bytedance.android.ec.hybrid.list.util.c.a(Double.valueOf(r111), null, Boolean.FALSE))) / r109);
    L28:
        return Integer.valueOf(r101 / r109);
    L29:
        return null;
    }

    public final void H2(Function1<? super BaseViewHolder, Unit> r110) {
        HashSet<BaseViewHolder> r100 = this.f46843d;
        ArrayList r101 = new ArrayList();
        Iterator<BaseViewHolder> r102 = r100.iterator();
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L11;
        BaseViewHolder r104 = r102.next();
        if (r104.itemView.getParent() == null) goto L9;
        r103 = false;
    L9:
        if (r103 == false) goto L3;
        r101.add(r104);
        goto L3
    L11:
        Set r105 = CollectionsKt.toMutableSet(r101);
        if (this.f46842c == null) goto L59;
    L31:
        LinkedHashSet r106 = new LinkedHashSet();
        RecyclerView.RecycledViewPool r107 = this.f46860u.f46871b.getRecycledViewPool();
        LinkedHashSet r108 = new LinkedHashSet();
        Set r109 = r105;
        Iterator r111 = r109.iterator();
    L33:
        if (r111.hasNext() == false) goto L42;
        BaseViewHolder r112 = (BaseViewHolder) r111.next();
        List<?> r113 = this.f46842c;
        if (r113 != null) goto L37;
    L39:
        RecyclerView.ViewHolder r114 = r107.getRecycledView(r112.getItemViewType());
    L40:
        if (r114 == null) goto L33;
        r108.add(r114);
        r114 = r107.getRecycledView(r112.getItemViewType());
        goto L40
    L37:
        if (CollectionsKt.contains(r113, r112) != true) goto L39;
        r106.add(r112);
        goto L39
    L42:
        Iterator r115 = r108.iterator();
    L44:
        if (r115.hasNext() == false) goto L46;
        r107.putRecycledView((RecyclerView.ViewHolder) r115.next());
        goto L44
    L46:
        Set r116 = r105;
        if (r116 == null) goto L58;
        TypeIntrinsics.asMutableCollection(r116).removeAll(r106);
        TypeIntrinsics.asMutableCollection(r116).removeAll(r108);
        if ((!r116.isEmpty()) == false) goto L56;
        this.f46843d.removeAll(r116);
        Iterator r117 = r109.iterator();
    L52:
        if (r117.hasNext() == false) goto L76;
        BaseViewHolder r118 = (BaseViewHolder) r117.next();
        r118.onRelease();
        if (r110 == null) goto L52;
        Unit r119 = r110.invoke(r118);
        goto L52
    L76:
        return;
    L56:
        return;
    L58:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L59:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L23
        Field r121 = RecyclerView.class.getDeclaredField("mRecycler");     // Catch: Throwable -> L23
        r121.setAccessible(true);     // Catch: Throwable -> L23
        Object r122 = r121.get(this.f46860u.f46871b);     // Catch: Throwable -> L23
        Object r123 = null;
        if ((r122 instanceof RecyclerView.Recycler) == true) goto L17;
        r122 = null;
    L17:
        Field r124 = RecyclerView.Recycler.class.getDeclaredField("mCachedViews");     // Catch: Throwable -> L23
        r124.setAccessible(true);     // Catch: Throwable -> L23
        Object r125 = r124.get((RecyclerView.Recycler) r122);     // Catch: Throwable -> L23
        if ((r125 instanceof List) == false) goto L21;
        r123 = r125;
    L21:
        this.f46842c = (List) r123;     // Catch: Throwable -> L23
        Object r126 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L31;
        Lazy r128 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(k.a.f47501b, "reflect recyclerView#mRecycler#mCachedViews failed");
        if (HybridAppInfoService.f47545p.isLocalTest() == false) goto L31;
        throw r127;
    L23:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        DataResolver r101 = this.f46840a;
        if (r101 == null) goto L29;
        j0 r102 = (j0) this.f46855p.getValue();
        ArrayList<ECHybridListItemVO> r103 = r101.f46943i;
        if (r103 != null) goto L7;
    L9:
        ArrayList<ECHybridListItemVO> r104 = r101.f46943i;
        if (r104 == null) goto L34;
        int r105 = r104.size();
        if (r100 < 0) goto L16;
        if (r105 <= r100) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == true) goto L20;
        r104 = null;
    L20:
        if (r104 == null) goto L34;
        if (r102 != null) goto L31;
        Integer r107 = ((ECHybridListItemVO) ListProtector.get(r104, r100)).f47028c;
        if (r107 == null) goto L33;
        return r107.intValue();
    L33:
        return ECHybridListItemType.INVALID.getType();
    L31:
        return r102.Dv((ECHybridListItemVO) ListProtector.get(r104, r100));
    L16:
        r106 = false;
    L34:
        return ECHybridListItemType.INVALID.getType();
    L7:
        if (r100 != r103.size()) goto L9;
        return ECHybridListItemType.HYBRID_LIST_LOAD_MORE_VIEW_HOLDER.getType();
    L29:
        return ECHybridListItemType.INVALID.getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        BaseViewHolder r101 = (BaseViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        ECHybridListItemVO r102 = r101.f47152c;
        if (r102 == null) goto L5;
        r102.T = null;
    L5:
        r101.o();
        ECHybridListItemVO r103 = r101.f47152c;
        if (r103 == null) goto L8;
        r103.K = false;
    L8:
        r101.f47152c = null;
        r101.f47154e = null;
    }

    public final ECLynxCardHolder z2(int r110) {
        DataResolver r100 = this.f46840a;
        if (r100 == null) goto L35;
        HashMap<String, com.bytedance.android.ec.hybrid.list.entity.k.a> r101 = r100.f46936b;
        if (r101 == null) goto L11;
        com.bytedance.android.ec.hybrid.list.entity.k.a r102 = r101.get(String.valueOf(r110));
        if (r102 == null) goto L11;
        com.bytedance.android.ec.hybrid.list.entity.f r103 = r102.f47132a;
        if (r103 == null) goto L11;
        String r104 = r103.f47100a;
    L12:
        if (r104 == null) goto L35;
        Stack<ECLynxCardHolder> r105 = this.f46844e.get(B2(r104));
        if (r105 == null) goto L35;
        if ((!r105.isEmpty()) == true) goto L19;
        Function2<? super String, ? super Boolean, Unit> r111 = this.f46849j;
        if (r111 == null) goto L35;
        Unit r112 = r111.invoke(r104, Boolean.FALSE);
        goto L35
    L19:
        if (Logger.debug() == false) goto L22;
        Logger.d("CardPreload_getItemView", "current scheme = " + r104 + ", preladScheme = " + r105.get(0).f47167p.f47313b);
    L22:
        if (StringsKt.equals$default(r105.get(0).f47167p.f47313b, r104, false, 2, null) == true) goto L25;
        boolean r113 = com.bytedance.android.ec.hybrid.monitor.f.f47559a;
        JSONObject r114 = new JSONObject();
        r114.put("preload_schema", r105.get(0).f47167p.f47313b);
        r114.put("current_schema", r104);
        Unit r106 = Unit.INSTANCE;
        com.bytedance.android.ec.hybrid.monitor.f.b("ec_hybrid_use_preload", "schema is change", r114.toString());
        goto L35
    L25:
        if (Logger.debug() == false) goto L27;
        Logger.d("CardPreload_getItemView", "viewType " + r110 + " preload = true ");
    L27:
        Function2<? super String, ? super Boolean, Unit> r115 = this.f46849j;
        if (r115 == null) goto L30;
        Unit r116 = r115.invoke(r104, Boolean.TRUE);
    L30:
        Lazy r117 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b, " get lynx card holder from cache: ".concat(r104));
        return r105.pop();
    L11:
        r104 = null;
    L35:
        m0 r118 = (m0) this.f46861v.getAbility(m0.class);
        if (r118 == null) goto L39;
        ECLynxCardHolder r119 = r118.a(this.f46859t);
        if (r119 == null) goto L39;
        return r119;
    L39:
        FrameLayout r107 = new FrameLayout(this.f46859t);
        r107.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        Unit r120 = Unit.INSTANCE;
        return new ECLynxCardHolder(r107, this.f46860u.f46888s, null, null, null, null, null, null, false, false, 2044);
    }

    public final BaseViewHolder A2(ViewGroup r100, int r101) {
        if (r101 != ECHybridListItemType.HYBRID_LIST_LOAD_MORE_VIEW_HOLDER.getType()) goto L10;
        l0 r102 = (l0) this.f46861v.getAbility(l0.class);
        if (r102 == null) goto L8;
        ECLoadMoreViewHolder r103 = r102.a(r100);
        if (r103 == null) goto L8;
        return r103;
    L8:
        FrameLayout r104 = new FrameLayout(this.f46859t);
        TextView r105 = new TextView(r104.getContext());
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, -2);
        r106.gravity = 17;
        Unit r107 = Unit.INSTANCE;
        r104.addView(r105, r106);
        return new ECDefLoadMoreViewHolder(r104);
    L10:
        Stack<BaseViewHolder> r108 = this.f46845f.get(Integer.valueOf(r101));
        if (r108 != null) goto L13;
    L22:
        ECHybridListEngine.Companion r109 = ECHybridListEngine.f46869x;
        String r110 = this.f46860u.f46888s;
        r109.getClass();
        BaseViewHolder r111 = ECHybridListEngine.Companion.a(r110, r101, r100);
        Function3<? super String, ? super Boolean, ? super Boolean, Unit> r112 = this.f46850k;
        if (r112 == null) goto L25;
        Unit r113 = r112.invoke(String.valueOf(r101), Boolean.FALSE, Boolean.valueOf(r111.n4()));
    L25:
        return r111;
    L13:
        if ((!r108.isEmpty()) == false) goto L22;
        if (Logger.debug() == false) goto L17;
        Logger.d("CardPreload_getItemView", "viewType " + r101 + " preload = true ");
    L17:
        Function3<? super String, ? super Boolean, ? super Boolean, Unit> r114 = this.f46850k;
        if (r114 == null) goto L21;
        String r115 = String.valueOf(r101);
        Boolean r116 = Boolean.TRUE;
        Unit r117 = r114.invoke(r115, r116, r116);
    L21:
        return r108.pop();
    }

    public final BaseViewHolder D2(final ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        long r100 = System.currentTimeMillis();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L24
        ECHybridListItemType.Companion.getClass();     // Catch: Throwable -> L24
        if (ECHybridListItemType.a.a(r111) == false) goto L7;
        BaseViewHolder r102 = z2(r111);     // Catch: Throwable -> L24
    L22:
        Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L24
    L26:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L37;
        boolean r105 = com.bytedance.android.ec.hybrid.monitor.f.f47559a;
        String r106 = r104.getMessage();
        String r107 = "none-delivered";
        if (r106 != null) goto L31;
        r106 = "none-delivered";
    L31:
        com.bytedance.android.ec.hybrid.monitor.f.b("error_adapter_create_vh", "create ex:".concat(r106), null);
        Lazy r108 = ECMallLogUtil.f47441a;
        com.bytedance.android.ec.hybrid.log.mall.b.c r109 = com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b;
        String r112 = r104.getMessage();
        if (r112 == null) goto L35;
        r107 = r112;
    L35:
        ECMallLogUtil.b(r109, "error_adapter_create_vh create ex:".concat(r107));
    L37:
        if (Result.m9455isFailureimpl(r103) == false) goto L39;
        r103 = null;
    L39:
        BaseViewHolder r113 = (BaseViewHolder) r103;
        if (r113 != null) goto L42;
        final View r114 = new View(r110.getContext());
        r113 = new ECHybridListAdapter$onCreateViewHolder$viewHolder$3(r110, r114);
    L42:
        ViewParent r115 = r113.itemView.getParent();
        if (r115 != null) goto L45;
    L48:
        r113.f47151b = this.f46861v;
        r113.f47156g = this;
        this.f46843d.add(r113);
        r113.onCreate();
        long r116 = System.currentTimeMillis();
        r113.f47157h = Long.valueOf(r100);
        r113.f47158i = Long.valueOf(r116);
        r113.itemView.setTranslationZ(1.0f);
        r113.itemView.setElevation(-1.0f);
        r113.itemView.setTag("type : " + r111);
        System.currentTimeMillis();
        return r113;
    L45:
        if ((r115 instanceof ViewGroup) == false) goto L47;
        ((ViewGroup) r115).removeView(r113.itemView);
    L47:
        boolean r117 = com.bytedance.android.ec.hybrid.monitor.f.f47559a;
        com.bytedance.android.ec.hybrid.monitor.f.b("error_adapter_create_vh", "itemView(viewType:" + r111 + ") has parent", null);
        goto L48
    L7:
        if (ECHybridListItemType.a.c(r111) == false) goto L19;
        IECHybridCardService r118 = (IECHybridCardService) com.bytedance.android.ec.hybrid.a.f().getService(IECHybridCardService.class);     // Catch: Throwable -> L24
        if (r118 == null) goto L11;
        RecyclerView.ViewHolder r119 = r118.generateMitaCardViewHolder(this.f46861v, r110);     // Catch: Throwable -> L24
    L13:
        if ((r119 instanceof BaseViewHolder) == true) goto L15;
        r119 = null;
    L15:
        r102 = (BaseViewHolder) r119;     // Catch: Throwable -> L24
        if (r102 != null) goto L22;
        r102 = new EmptyViewHolder(new FrameLayout(r110.getContext()));     // Catch: Throwable -> L24
        goto L22
    L11:
        r119 = null;
        goto L13
    L19:
        if (ECHybridListItemType.a.b(Integer.valueOf(r111)) == false) goto L21;
        int r120 = ECHybridListItemType.MALL_CHANNEL_CARD.getType();     // Catch: Throwable -> L24
        ECHybridListEngine.Companion r121 = ECHybridListEngine.f46869x;     // Catch: Throwable -> L24
        String r122 = this.f46860u.f46888s;     // Catch: Throwable -> L24
        r121.getClass();     // Catch: Throwable -> L24
        r102 = ECHybridListEngine.Companion.a(r122, r120, r110);     // Catch: Throwable -> L24
        goto L22
    L21:
        r102 = A2(r110, r111);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r410, int r411) {
        BaseViewHolder r100 = (BaseViewHolder) r410;
        Intrinsics.checkNotNullParameter(r100, "holder");
        long r101 = System.currentTimeMillis();
        r100.f47160k = this.f46852m ? 1 : 0;
        if ((r100 instanceof ECLoadMoreViewHolder) == false) goto L14;
        p r102 = (p) this.f46856q.getValue();
        if (r102 == null) goto L9;
        r r103 = r102.IE();
        if (r103 == null) goto L9;
        r103.b(r100, r100.f47152c, r411);
    L9:
        r100.b4(null, "", null);
        p r104 = (p) this.f46856q.getValue();
        if (r104 == null) goto L409;
        r r105 = r104.j70();
        if (r105 == null) goto L410;
        r105.b(r100, r100.f47152c, r411);
        return;
    L410:
        return;
    L409:
        return;
    L14:
        DataResolver r106 = this.f46840a;
        if (r106 == null) goto L299;
        final ECHybridListItemVO r110 = r106.g(r411);
        if (r110 == null) goto L299;
        if (1 > r411) goto L33;
        if (4 < r411) goto L33;
        Integer r111 = r110.f47028c;
        int r112 = ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_VIDEO_CARD.getType();
        if (r111 != null) goto L26;
    L27:
        Integer r113 = r110.f47028c;
        int r114 = ECHybridListItemType.SHOP_VIEW_HOLDER_NATIVE_LIVE_CARD.getType();
        if (r113 == null) goto L33;
        if (r113.intValue() != r114) goto L33;
    L32:
        this.f46848i.f47067a = true;
        goto L33
    L26:
        if (r111.intValue() == r112) goto L32;
    L33:
        boolean r115 = r110.f47049w;
        if (r115 == true) goto L36;
    L39:
        this.f46848i.f47069c = false;
    L40:
        if (r115 == false) goto L42;
    L45:
        this.f46848i.f47070d = false;
    L47:
        if ((r100 instanceof ECLynxCardHolder) == false) goto L272;
        ECLynxCardHolder r116 = (ECLynxCardHolder) r100;
        ECNAMallCardExtra r117 = r110.c();
        if (r117 == null) goto L51;
        ChipViewConfig r118 = r117.getChipViewConfig();
    L52:
        com.bytedance.android.ec.hybrid.list.entity.b r119 = this.f46848i;
        Intrinsics.checkNotNullParameter(r119, "ecDeferSrcData");
        Lazy r120 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b, "ChipView|| holder:" + r116 + "  applyChipViewConfig");
        ViewGroup r107 = r116.L;
        if ((r107 instanceof FrameLayout) == true) goto L55;
        r107 = null;
    L55:
        FrameLayout r108 = (FrameLayout) r107;
        if (r108 != null) goto L58;
        long r121 = r101;
        String r122 = "";
    L269:
        boolean r109 = r110.Z;
        r116.I = r109;
        if (r109 == false) goto L273;
        r116.f47165J = new ECHybridListAdapter$onBindViewHolder$1$1(r110);
    L273:
        c0 r123 = (c0) this.f46861v.getAbility(c0.class);
        if (r123 != null) goto L277;
        boolean r124 = false;
    L287:
        if (r124 == true) goto L289;
    L300:
        r100.f47162m = false;
        DataResolver r125 = this.f46840a;
        if (r125 == null) goto L384;
        ECHybridListItemVO r126 = r125.g(r411);
        if (r126 == null) goto L384;
        Integer r127 = r126.f47028c;
        if (r127 == null) goto L381;
        int r128 = r127.intValue();
        r126.T = r100;
        DataResolver r129 = this.f46840a;
        if (r129 == null) goto L311;
        HashMap<String, com.bytedance.android.ec.hybrid.list.entity.k.a> r130 = r129.f46936b;
        if (r130 == null) goto L311;
        com.bytedance.android.ec.hybrid.list.entity.k.a r131 = r130.get(String.valueOf(r128));
    L312:
        r100.f47152c = r126;
        r100.f47154e = r131;
        long r210 = System.currentTimeMillis();
        p r132 = (p) this.f46856q.getValue();
        if (r132 == null) goto L317;
        r r133 = r132.IE();
        if (r133 == null) goto L317;
        r133.b(r100, r100.f47152c, r411);
    L317:
        Object r134 = r126.d();
        String r135 = r126.f47029d;
        if (r135 != null) goto L320;
        r135 = r122;
    L320:
        r100.b4(r134, r135, r131);
        p r136 = (p) this.f46856q.getValue();
        if (r136 == null) goto L326;
        r r137 = r136.j70();
        if (r137 == null) goto L326;
        r137.b(r100, r100.f47152c, r411);
    L326:
        if (r100.f47161l == false) goto L330;
        d0 r138 = (d0) this.f46861v.getAbility(d0.class);
        if (r138 == null) goto L330;
        r138.a(r128);
    L330:
        ECLynxCardHolder.BindType r139 = ECLynxCardHolder.BindType.UNKNOWN;
        if ((r100 instanceof ECLynxCardHolder) == false) goto L343;
        ECLynxCardHolder r140 = (ECLynxCardHolder) r100;
        ECLynxCardHolder.BindType r141 = r140.H;
        Boolean r142 = r140.f47170s;
        if (r142 == null) goto L341;
        boolean r143 = r142.booleanValue();
        if (r143 == false) goto L337;
        int r144 = 1;
    L338:
        if (r143 == false) goto L340;
        r140.f47170s = Boolean.FALSE;
    L340:
        Integer r211 = r144;
    L344:
        Function1<? super ECHybridHolderUpdateParams, Unit> r145 = this.f46851l;
        if (r145 == null) goto L381;
        if (r100.f47161l == false) goto L351;
        com.bytedance.android.ec.hybrid.list.holder.e r146 = r100.f47163n;
        if (r146 == null) goto L351;
        Long r310 = Long.valueOf(r146.f47207c);
    L352:
        Long r147 = r100.f47158i;
        long r148 = 0;
        if (r147 == null) goto L355;
        long r149 = r147.longValue();
    L356:
        Long r150 = r100.f47157h;
        if (r150 == null) goto L359;
        long r151 = r150.longValue();
    L360:
        long r152 = r149 - r151;
        Long r153 = r126.C;
        if (r153 == null) goto L363;
        long r154 = r153.longValue();
    L364:
        Long r155 = r126.B;
        if (r155 == null) goto L367;
        r148 = r155.longValue();
    L367:
        long r156 = r154 - r148;
        long r311 = System.currentTimeMillis() - r210;
        long r212 = System.currentTimeMillis();
        if (r131 == null) goto L375;
        com.bytedance.android.ec.hybrid.list.entity.f r157 = r131.f47132a;
        if (r157 == null) goto L375;
        String r158 = r157.f47100a;
        if (r158 == null) goto L375;
        String r213 = r158;
    L377:
        if (this.f46852m == false) goto L379;
        int r214 = 2;
    L380:
        boolean r159 = r100.f47161l;
        boolean r160 = this.f46841b;
        Integer r161 = r126.f47027b;
        int r412 = r141.ordinal();
        r145.invoke(new ECHybridHolderUpdateParams(r210, r212, r128, r213, r214, r159 ? 1 : 0, r211, r311, r310, r100.f47157h, r100.f47158i, r126.B, r126.C, (r152 + r156) + r311, r160, r161, r412));
        goto L381
    L379:
        r214 = 1;
    L375:
        r213 = r122;
        goto L377
    L363:
        r154 = 0;
        goto L364
    L359:
        r151 = 0;
        goto L360
    L355:
        r149 = 0;
    L351:
        r310 = null;
        goto L352
    L337:
        r144 = 0;
        goto L338
    L341:
        r139 = r141;
    L343:
        r141 = r139;
        r211 = null;
    L311:
        r131 = null;
    L381:
        y r162 = (y) this.f46861v.getAbility(y.class);
        if (r162 == null) goto L384;
        r162.l40(r100.itemView, r126);
    L384:
        Iterator r163 = ((ArrayList) this.f46847h).iterator();
    L386:
        if (r163.hasNext() == false) goto L389;
        ((com.bytedance.android.ec.hybrid.list.ability.b) r163.next()).a(r411);
        goto L386
    L389:
        if (((ArrayList) this.f46858s).isEmpty() == false) goto L392;
        if (r411 != 0) goto L392;
        ((ArrayList) this.f46858s).add(Long.valueOf(r121));
        ((ArrayList) this.f46858s).add(Long.valueOf(System.currentTimeMillis()));
    L392:
        r100.getItemViewType();
        System.currentTimeMillis();
        return;
    L289:
        if (Logger.debug() == false) goto L292;
        Logger.d("peive", "onBindViewHolder position = " + r411 + " noBind = true");
    L292:
        if (r100.f47161l == false) goto L298;
        Integer r164 = r110.f47028c;
        if (r164 == null) goto L298;
        int r165 = r164.intValue();
        d0 r166 = (d0) this.f46861v.getAbility(d0.class);
        if (r166 == null) goto L298;
        r166.a(r165);
    L298:
        r100.f47162m = true;
        return;
    L277:
        if (r110.f47049w == true) goto L279;
    L285:
        r124 = false;
    L286:
        Lazy r167 = ECMallLogUtil.f47441a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b, "shouldNoBind = " + r124 + ", itemType = " + r110.f47028c + ", itemId = " + r110.f47029d + ", cacheFlag = " + r110.f47049w + ", straightDispatch = " + r110.f47050x + ", isHomepageReceived = " + r123.KB() + ", canStraightDispatch = " + r123.s60());
        goto L287
    L279:
        if (r110.f47050x == false) goto L285;
        if (r123.KB() == false) goto L285;
        if (r123.s60() == false) goto L285;
        r124 = true;
        goto L286
    L58:
        if (r118 == null) goto L60;
        Integer r168 = r118.getLoadLynxNextLoop();
    L61:
        if (r168 != null) goto L64;
    L66:
        boolean r169 = false;
    L67:
        r116.G = r169;
        SimpleDraweeView r170 = (SimpleDraweeView) r108.findViewById(R.id.iv_mall_card_chip_image);
        if (r170 != null) goto L70;
        r121 = r101;
        r122 = "";
    L183:
        if (r116.F == true) goto L193;
        IHybridHostService r171 = com.bytedance.android.ec.hybrid.a.h();
        if (r171 == null) goto L189;
        u r172 = r171.getIHybridPluginService();
        if (r172 == null) goto L189;
        Boolean r173 = Boolean.valueOf(r172.a());
    L190:
        Lazy r174 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b, "ChipView|| holder:" + r116 + "  checkPluginReady = " + r173 + ' ');
        if ((!Intrinsics.areEqual(r173, Boolean.FALSE)) == true) goto L193;
        r116.F = true;
    L189:
        r173 = null;
    L193:
        if (r118 != null) goto L197;
        Lazy r175 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b, "ChipView|| holder:" + r116 + "  chipViewConfig is null");
        if (r170 == null) goto L269;
        r170.setVisibility(8);
        goto L269
    L197:
        String r176 = r118.getType();
        if (r176 == null) goto L269;
        if (r176.hashCode() != 100313435) goto L269;
        if (r176.equals("image") == false) goto L269;
        if (r170 != null) goto L207;
        r170 = new SimpleDraweeView(r108.getContext());
        r170.setId(R.id.iv_mall_card_chip_image);
        Lazy r177 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b, "ChipView|| holder:" + r116 + "  viewGroup:" + r108 + "  add chipImage " + r170 + ' ');
        int r178 = 0;
        r170.getHierarchy().setFadeDuration(0);
        r108.addView(r170, 0);
    L208:
        r170.setVisibility(r178);
        String r179 = r118.getBackground();
        if (r179 != null) goto L398;
    L213:
        r116.C4(r118);
        FrameLayout.LayoutParams r180 = new FrameLayout.LayoutParams(-1, -2);
        Integer r181 = r118.getMarginTop();
        if (r181 == null) goto L216;
        int r182 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r183 = com.bytedance.android.ec.hybrid.list.util.c.d(r181);
    L217:
        r180.topMargin = r183;
        Integer r184 = r118.getMarginLeft();
        if (r184 == null) goto L220;
        int r185 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r186 = com.bytedance.android.ec.hybrid.list.util.c.d(r184);
    L221:
        r180.leftMargin = r186;
        Integer r187 = r118.getMarginRight();
        if (r187 == null) goto L224;
        int r188 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r189 = com.bytedance.android.ec.hybrid.list.util.c.d(r187);
    L225:
        r180.rightMargin = r189;
        Unit r190 = Unit.INSTANCE;
        r170.setLayoutParams(r180);
        r170.setTranslationY(2.0f);
        String r191 = r118.getAspectRatio();
        if (r191 == null) goto L230;
        Float r192 = StringsKt.toFloatOrNull(r191);
        if (r192 == null) goto L230;
        r170.setAspectRatio(r192.floatValue());
    L230:
        Integer r193 = r118.getMinHeight();
        if (r193 == null) goto L234;
        int r194 = r193.intValue();
        int r195 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r170.setMinimumHeight(com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r194)));
    L234:
        if (r116.F == true) goto L269;
        ChipData r196 = r118.getChipData();
        if (r196 == null) goto L269;
        Lazy r197 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b, "ChipView|| holder:" + r116 + "  imageUrl is " + r196.getImageUrl());
        if (r119.f47069c == true) goto L240;
    L268:
        r116.v4(r118, r170, r119);
        goto L269
    L240:
        if (Intrinsics.areEqual(r116.N, MallPageName.X_TAB_MALL) == false) goto L268;
        boolean r198 = o.f47348a;
        String r199 = r196.getImageUrl();
        if (o.f47348a == true) goto L244;
        Bitmap r200 = null;
    L251:
        if (r200 != null) goto L253;
    L259:
        boolean r201 = false;
    L260:
        if (r200 == null) goto L267;
        if (r201 == false) goto L267;
        if (r200.getWidth() <= 0) goto L267;
        if (r200.getHeight() <= 0) goto L267;
        r170.setImageBitmap(r200);
    L267:
        r116.v4(r118, r170, r119);
        goto L269
    L253:
        if (r200.isRecycled() == true) goto L259;
        if (r200.getWidth() <= 0) goto L259;
        if (r200.getHeight() <= 0) goto L259;
        r201 = true;
        goto L260
    L244:
        SoftReference<Bitmap> r202 = o.f47351d.get(r199);
        if (r202 == null) goto L247;
        r200 = r202.get();
    L248:
        if (r200 == null) goto L250;
        o.c(true);
        goto L251
    L250:
        o.c(false);
        goto L251
    L247:
        r200 = null;
        goto L248
    L224:
        r189 = 0;
        goto L225
    L220:
        r186 = 0;
        goto L221
    L216:
        r183 = 0;
        goto L217
    L398:
        ((GenericDraweeHierarchy) r170.getHierarchy()).setPlaceholderImage(new ColorDrawable(Color.parseColor(r179)));     // Catch: IllegalArgumentException -> L212
    L212:
        Lazy r203 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.b.c.f47457b, "chipViewConfig background parse error ,origin color string is " + r179 + ' ');
        goto L213
    L207:
        r178 = 0;
        goto L208
    L70:
        if (r119.f47067a == false) goto L72;
    L179:
        r121 = r101;
        r122 = "";
    L180:
        r170.setTag(R.id.iv_enable_defer_src, Boolean.FALSE);
        goto L183
    L72:
        if (r119.f47068b >= 4) goto L179;
        if (1 > r411) goto L179;
        if (4 < r411) goto L179;
        int r204 = com.bytedance.android.ec.hybrid.tools.f.f47635a;
        Object r205 = Boolean.FALSE;
        int r206 = com.bytedance.android.ec.base.settings.c.f42815a;
        Result.Companion r207 = Result.Companion;     // Catch: Throwable -> L167
        Object r208 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_mall_first_screen_render_optimize");     // Catch: Throwable -> L139
        if (r208 != null) goto L82;
        r121 = r101;
        r122 = "";
    L132:
        Object r209 = null;
    L133:
        Object r215 = Result.m9449constructorimpl(r209);     // Catch: Throwable -> L135
    L142:
        Throwable r216 = Result.m9452exceptionOrNullimpl(r215);     // Catch: Throwable -> L165
        if (r216 == null) goto L146;
        EnsureManager.ensureNotReachHere(r216);     // Catch: Throwable -> L165
    L146:
        if (Result.m9455isFailureimpl(r215) == false) goto L149;
        r215 = null;
    L149:
        if ((r215 instanceof Boolean) == true) goto L151;
        r215 = null;
    L151:
        Boolean r217 = (Boolean) r215;     // Catch: Throwable -> L165
        if (r217 == null) goto L154;
        Object r218 = r217;
    L175:
        r205 = r218;
    L177:
        if (((Boolean) r205).booleanValue() == false) goto L180;
        r170.setTag(R.id.iv_enable_defer_src, Boolean.TRUE);
        r119.f47068b++;
        goto L183
    L154:
        IHybridHostService r219 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L165
        if (r219 == null) goto L157;
        Object r220 = r219.getHostABValue("ec_mall_first_screen_render_optimize", r205);     // Catch: Throwable -> L165
    L158:
        if (r220 == null) goto L177;
        if ((r220 instanceof Boolean) == true) goto L162;
        r220 = null;
    L162:
        Boolean r221 = (Boolean) r220;     // Catch: Throwable -> L165
        r218 = r221;
        if (r221 != null) goto L175;
    L165:
        th = th;
    L169:
        Result.Companion r222 = Result.Companion;
        Object r223 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r224 = Result.m9452exceptionOrNullimpl(r223);
        if (r224 == null) goto L172;
        EnsureManager.ensureNotReachHere(r224);
    L172:
        boolean r225 = Result.m9455isFailureimpl(r223);
        r218 = r223;
        if (r225 == false) goto L175;
    L157:
        r220 = null;
    L135:
        th = th;
    L402:
        Result.Companion r226 = Result.Companion;     // Catch: Throwable -> L165
        r215 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        goto L142
    L82:
        r122 = "";
    L137:
        th = th;
        r121 = r101;
        goto L402
    L84:
        if ((r208 instanceof Boolean) == true) goto L86;
        Object r227 = null;
    L87:
        r209 = (Boolean) r227;     // Catch: Throwable -> L137
        if (r209 == null) goto L91;
        r121 = r101;
        goto L133
    L91:
        if ((r208 instanceof Number) == false) goto L118;
        r121 = r101;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L101;
        Float r228 = Float.valueOf(((Number) r208).floatValue());     // Catch: Throwable -> L135
        if ((r228 instanceof Boolean) == true) goto L99;
        r228 = null;
    L99:
        r209 = (Boolean) r228;     // Catch: Throwable -> L135
        goto L133
    L101:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L107;
        Double r229 = Double.valueOf(((Number) r208).doubleValue());     // Catch: Throwable -> L135
        if ((r229 instanceof Boolean) == true) goto L105;
        r229 = null;
    L105:
        r209 = (Boolean) r229;     // Catch: Throwable -> L135
        goto L133
    L107:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L113;
        Integer r230 = Integer.valueOf(((Number) r208).intValue());     // Catch: Throwable -> L135
        if ((r230 instanceof Boolean) == true) goto L111;
        r230 = null;
    L111:
        r209 = (Boolean) r230;     // Catch: Throwable -> L135
        goto L133
    L113:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L120;
        Long r231 = Long.valueOf(((Number) r208).longValue());     // Catch: Throwable -> L135
        if ((r231 instanceof Boolean) == true) goto L117;
        r231 = null;
    L117:
        r209 = (Boolean) r231;     // Catch: Throwable -> L135
    L120:
        if ((r208 instanceof JSONObject) == false) goto L122;
    L404:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L128
        Object r232 = SDKSettingsCacheManager.a().fromJson(r208.toString(), Boolean.class);     // Catch: Throwable -> L128
        if ((r232 instanceof Boolean) == true) goto L126;
        r232 = null;
    L126:
        Object r233 = Result.m9449constructorimpl((Boolean) r232);     // Catch: Throwable -> L128
    L130:
        r209 = r233;
        if (Result.m9455isFailureimpl(r209) == false) goto L133;
    L128:
        th = move-exception;
        Result.Companion r234 = Result.Companion;     // Catch: Throwable -> L135
        r233 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L135
        goto L130
    L122:
        if ((r208 instanceof JSONArray) == false) goto L132;
    L118:
        r121 = r101;
        goto L120
    L86:
        r227 = r208;
    L139:
        th = th;
        r121 = r101;
        r122 = "";
    L167:
        th = th;
        r121 = r101;
        r122 = "";
        goto L169
    L64:
        if (r168.intValue() != 1) goto L66;
        r169 = true;
        goto L67
    L60:
        r168 = null;
        goto L61
    L51:
        r118 = null;
        goto L52
    L272:
        r121 = r101;
        r122 = "";
        goto L273
    L42:
        if (o.f47348a == false) goto L45;
        if (r411 > 5) goto L45;
        this.f46848i.f47070d = true;
        goto L47
    L36:
        if (o.f47348a == false) goto L39;
        if (r411 > 5) goto L39;
        this.f46848i.f47069c = true;
    L299:
        r121 = r101;
        r122 = "";
        goto L300
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return D2(r100, r101);
    }

    public final BaseViewHolder y2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        DataResolver r102 = this.f46840a;
        if (r102 == null) goto L12;
        ECHybridListItemVO r103 = r102.d(r100, r101);
        if (r103 == null) goto L13;
        Object r104 = r103.T;
        if (r104 != null) goto L9;
        return null;
    L9:
        if ((r104 instanceof BaseViewHolder) == true) goto L11;
        return null;
    L11:
        return (BaseViewHolder) r104;
    L13:
        return null;
    L12:
        return null;
    }

    public ECHybridListAdapter(Context r100, ECHybridListEngine r101, com.bytedance.android.ec.hybrid.list.ability.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listEngine");
        Intrinsics.checkNotNullParameter(r102, "abilityManager");
        this.f46859t = r100;
        this.f46860u = r101;
        this.f46861v = r102;
        this.f46843d = new HashSet();
        this.f46844e = new HashMap();
        this.f46845f = new HashMap();
        this.f46846g = new com.bytedance.android.ec.hybrid.list.util.e();
        this.f46847h = new ArrayList();
        this.f46848i = new com.bytedance.android.ec.hybrid.list.entity.b();
        this.f46854o = "";
        this.f46855p = LazyKt.lazy(new ECHybridListAdapter$typeMapper$2(this));
        this.f46856q = LazyKt.lazy(new ECHybridListAdapter$processorManager$2(this));
        this.f46857r = LazyKt.lazy(new ECHybridListAdapter$screenWidth$2(this));
        this.f46858s = new ArrayList();
    }

    public final void G2(final String r210, final Integer r211, final Function1<? super ECLynxCardHolder, Unit> r212) {
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_hybrid_list_preload_lynx_card");
        m0 r100 = (m0) this.f46861v.getAbility(m0.class);
        if (r100 == null) goto L8;
        ECLynxCardHolder r101 = r100.a(this.f46859t);
        if (r101 == null) goto L8;
        ECLynxCardHolder r102 = r101;
    L9:
        r102.f47151b = this.f46861v;
        final ECLynxCardHolder r103 = r102;
        r102.g4(r210, r211, new ECHybridListAdapter$preloadLynxCard$$inlined$apply$lambda$1(r103, this, r210, r211, r212));
        return;
    L8:
        FrameLayout r104 = new FrameLayout(this.f46859t);
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        Unit r105 = Unit.INSTANCE;
        r102 = new ECLynxCardHolder(r104, "", null, null, null, null, null, null, false, false, 2044);
        goto L9
    }

    public final boolean F2(final String r210, Integer r211, final ECPreloadConfigItemV3 r212, RecyclerView r213) {
        Intrinsics.checkNotNullParameter(r213, "recyclerView");
        if (r210 != null) goto L10;
        if (r211 == null) goto L10;
        if (this.f46845f.get(r211) != null) goto L8;
        this.f46845f.put(r211, new Stack());
    L8:
        long r100 = System.currentTimeMillis();
        Stack<BaseViewHolder> r101 = this.f46845f.get(r211);
        Intrinsics.checkNotNull(r101);
        ECHybridListEngine.Companion r102 = ECHybridListEngine.f46869x;
        String r103 = this.f46860u.f46888s;
        int r104 = r211.intValue();
        r102.getClass();
        BaseViewHolder r105 = ECHybridListEngine.Companion.a(r103, r104, r213);
        r105.g4("", null, null);
        com.bytedance.android.ec.hybrid.list.holder.e r106 = new com.bytedance.android.ec.hybrid.list.holder.e(String.valueOf(r211.intValue()), true, System.currentTimeMillis() - r100);
        Intrinsics.checkNotNullParameter(r106, "status");
        Intrinsics.checkNotNullParameter(r106, "status");
        r105.f47163n = r106;
        Unit r107 = Unit.INSTANCE;
        r101.add(r105);
        return true;
    L10:
        if (r210 == null) goto L23;
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_hybrid_list_preload_lynx_card");
        final String r108 = B2(r210);
        if (this.f46844e.get(r108) != null) goto L14;
        this.f46844e.put(r108, new Stack());
    L14:
        m0 r109 = (m0) this.f46861v.getAbility(m0.class);
        if (r109 == null) goto L20;
        ECLynxCardHolder r110 = r109.a(this.f46859t);
        if (r110 == null) goto L20;
        ECLynxCardHolder r111 = r110;
    L21:
        final ECLynxCardHolder r112 = r111;
        r111.g4(r210, E2(r212), new ECHybridListAdapter$preLoadOneCardNew$$inlined$apply$lambda$1(r112, this, r210, r212, r108));
        return true;
    L20:
        FrameLayout r113 = new FrameLayout(this.f46859t);
        r113.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        Unit r114 = Unit.INSTANCE;
        r111 = new ECLynxCardHolder(r113, "", null, null, null, null, null, null, false, false, 2044);
        goto L21
    L23:
        return false;
    }
}
