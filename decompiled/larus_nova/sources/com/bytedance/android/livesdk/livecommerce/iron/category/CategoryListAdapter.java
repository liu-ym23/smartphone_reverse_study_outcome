package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.TopCategoryView;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.skin.f;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryListAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PromotionCategory> f148557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super PromotionCategory, ? super Integer, Unit> f148558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f148559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CategoryViewHolder f148560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f148561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f148562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f148563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final il.a f148564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f148565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f148566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final gi2.a f148567k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f148568a;

        public a(int r100) {
            this.f148568a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f148557a.size();
    }

    public final PromotionCategory z2() {
        Iterator<T> r100 = this.f148557a.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (((PromotionCategory) r101).getSelected() == false) goto L4;
    L10:
        return (PromotionCategory) r101;
    L8:
        r101 = null;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        final CategoryViewHolder r101 = (CategoryViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        this.f148564h.c("livesdk_list_tab_show", ((PromotionCategory) ListProtector.get(this.f148557a, r101.getAdapterPosition())).getUniqueIndex(), new AnonymousClass1(this, r101));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        final CategoryViewHolder r102 = (CategoryViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final int r103 = r102.getAdapterPosition();     // Catch: Exception -> L23
        if (((PromotionCategory) ListProtector.get(this.f148557a, r103)).getSelected() == false) goto L6;
        this.f148560d = r102;     // Catch: Exception -> L23
        this.f148559c = r103;     // Catch: Exception -> L23
    L6:
        boolean r104 = false;
        if (r103 == 0) goto L9;
    L11:
        PromotionCategory r105 = (PromotionCategory) CollectionsKt.getOrNull(this.f148557a, r103);     // Catch: Exception -> L23
        if (r105 != null) goto L14;
    L21:
        r102.T3((PromotionCategory) ListProtector.get(this.f148557a, r103), this.f148561e, this.f148565i, this.f148566j, new AnonymousClass3(this, r103, r102, r101));     // Catch: Exception -> L23
        return;
    L14:
        if (r105.getEnhanceType() <= 0) goto L16;
        r104 = true;
    L16:
        if (r104 == true) goto L19;
        r105 = null;
    L19:
        if (r105 == null) goto L21;
        this.f148562f.add(r105.getUniqueIndex());     // Catch: Exception -> L23
        goto L21
    L9:
        if (this.f148560d != null) goto L11;
        this.f148560d = r102;     // Catch: Exception -> L23
        this.f148559c = 0;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new CategoryViewHolder(new TopCategoryView(this.f148563g, null, 6, 0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        CategoryViewHolder r103 = (CategoryViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        Object r104 = CollectionsKt.firstOrNull(r102);
        if (r104 != null) goto L5;
    L10:
        super.onBindViewHolder(r103, r101, r102);
        Unit r105 = Unit.INSTANCE;
        return;
    L5:
        if ((r104 instanceof a) == true) goto L8;
        r104 = null;
    L8:
        if (r104 == null) goto L10;
        int r106 = ((a) r104).f148568a;
        r103.f148574a.d(r106);
    }

    public static final void y2(CategoryListAdapter r100, boolean r101, List r102, int r103, Boolean r110) {
        r100.getClass();
        oh.a.c("ECLiveListTabShowClickEvent", new com.bytedance.android.livesdk.livecommerce.iron.category.a(r100, r101, (PromotionCategory) ListProtector.get(r102, r103), r102, r110));
    }

    public CategoryListAdapter(Context r100, il.a r101, int r102, String r103, f r104, gi2.a r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "eventMap");
        this.f148563g = r100;
        this.f148564h = r101;
        this.f148565i = r103;
        this.f148566j = r104;
        this.f148567k = r105;
        this.f148557a = new ArrayList();
        this.f148561e = r102;
        this.f148562f = new LinkedHashSet();
    }
}
