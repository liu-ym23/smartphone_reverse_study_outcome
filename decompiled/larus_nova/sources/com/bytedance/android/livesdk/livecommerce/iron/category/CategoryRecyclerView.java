package com.bytedance.android.livesdk.livecommerce.iron.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "getCurrentVisibleWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CategoryListAdapter f148571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f148572b;

    public static final class a {
    }

    static {
    }

    public final long getCurrentVisibleWidth() {
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return 0;
    L4:
        if ((getLayoutManager() instanceof LinearLayoutManager) == false) goto L31;
        RecyclerView.LayoutManager r100 = getLayoutManager();     // Catch: Exception -> L25
        if ((r100 instanceof LinearLayoutManager) == true) goto L8;
        r100 = null;
    L8:
        LinearLayoutManager r101 = (LinearLayoutManager) r100;     // Catch: Exception -> L25
        int r102 = 0;
        if (r101 == null) goto L11;
        int r103 = r101.findLastVisibleItemPosition();     // Catch: Exception -> L25
    L12:
        if (r103 < 0) goto L32;
        long r104 = 0;
    L14:
        View r105 = getChildAt(r102);     // Catch: Exception -> L25
        if (r105 != null) goto L17;
    L21:
        if (r102 == r103) goto L24;
        r102 = r102 + 1;
        goto L14
    L24:
        return r104;
    L17:
        if (this.f148572b == 2) goto L19;
        int r106 = r105.getWidth() + UtilityKotlinExtentionsKt.d(8);     // Catch: Exception -> L25
    L20:
        r104 = r104 + ((long) r106);
        goto L21
    L19:
        r106 = r105.getWidth();     // Catch: Exception -> L25
        goto L20
    L32:
        return 0;
    L11:
        r103 = 0;
        goto L12
    L31:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CategoryListAdapter r100 = this.f148571a;
        if (r100 == null) goto L16;
        List r101 = CollectionsKt.toList(r100.f148562f);
        if (r101 == null) goto L22;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L23;
        String r103 = (String) r102.next();
        int r104 = ci2.a.f23851a;
        if (r103 == null) goto L8;
        q r105 = q.f48131a;
        String r106 = r105.getString("ec_live_tab_enhance_control_show", "");
        HashMap<String, JSONObject> r107 = j.f44312a;
        JSONObject r108 = j.i(r106);
        if (r108 != null) goto L15;
        r108 = new JSONObject();
    L15:
        r108.put(r103, 1);
        r105.putString("ec_live_tab_enhance_control_show", r108.toString());
        goto L8
    L23:
        return;
    L22:
        return;
    }

    public final void t() {
        if (getItemDecorationCount() <= 0) goto L14;
        int r100 = getItemDecorationCount() - 1;     // Catch: Exception -> L8
    L5:
        if (r100 < 0) goto L15;
        removeItemDecoration(getItemDecorationAt(r100));     // Catch: Exception -> L8
        r100 = r100 - 1;
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    public CategoryRecyclerView(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        addItemDecoration(new CategoryItemDecoration(UtilityKotlinExtentionsKt.d(8), 0, null, null, null, null, null, null, 252));
        setFocusableInTouchMode(false);
        setHasFixedSize(true);
        addOnScrollListener(new AnonymousClass1());
        CategoryLineaLayoutManager r100 = new CategoryLineaLayoutManager(getContext());
        r100.setOrientation(0);
        Unit r111 = Unit.INSTANCE;
        setLayoutManager(r100);
    }

    public final void r(Function1<? super PromotionCategory, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "tabChangedCallback");
        boolean r101 = false;
        scrollToPosition(0);
        CategoryListAdapter r102 = this.f148571a;
        if (r102 == null) goto L31;
        PromotionCategory r103 = r102.z2();
        if (r103 == null) goto L31;
        PromotionCategory.a r104 = PromotionCategory.Companion;
        String r105 = r103.getUniqueIndex();
        r104.getClass();
        Integer r106 = null;
        if ((!PromotionCategory.a.b(r105)) == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L31;
        CategoryListAdapter r107 = this.f148571a;
        if (r107 == null) goto L31;
        PromotionCategory r108 = (PromotionCategory) CollectionsKt.getOrNull(r107.f148557a, r107.f148559c);
        if (r108 == null) goto L16;
        r108.setSelected(false);
    L16:
        r107.notifyItemChanged(r107.f148559c);
        Iterator<PromotionCategory> r109 = r107.f148557a.iterator();
        int r110 = 0;
    L18:
        if (r109.hasNext() == false) goto L23;
        PromotionCategory r111 = r109.next();
        PromotionCategory.a r112 = PromotionCategory.Companion;
        String r113 = r111.getUniqueIndex();
        r112.getClass();
        if (PromotionCategory.a.b(r113) == true) goto L24;
        r110 = r110 + 1;
    L24:
        Integer r114 = Integer.valueOf(r110);
        if (r114.intValue() < 0) goto L27;
        r101 = true;
    L27:
        if (r101 == false) goto L29;
        r106 = r114;
    L29:
        if (r106 == null) goto L31;
        int r115 = r106.intValue();
        ((PromotionCategory) ListProtector.get(r107.f148557a, r115)).setSelected(true);
        r107.notifyItemChanged(r115);
        goto L31
    L23:
        r110 = -1;
    L31:
        CategoryListAdapter r116 = this.f148571a;
        if (r116 == null) goto L39;
        PromotionCategory r117 = r116.z2();
        if (r117 == null) goto L40;
        r100.invoke(r117);
        return;
    L40:
        return;
    }

    public CategoryRecyclerView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        addItemDecoration(new CategoryItemDecoration(UtilityKotlinExtentionsKt.d(8), 0, null, null, null, null, null, null, 252));
        setFocusableInTouchMode(false);
        setHasFixedSize(true);
        addOnScrollListener(new AnonymousClass1());
        CategoryLineaLayoutManager r112 = new CategoryLineaLayoutManager(getContext());
        r112.setOrientation(0);
        Unit r113 = Unit.INSTANCE;
        setLayoutManager(r112);
    }

    public CategoryRecyclerView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        addItemDecoration(new CategoryItemDecoration(UtilityKotlinExtentionsKt.d(8), 0, null, null, null, null, null, null, 252));
        setFocusableInTouchMode(false);
        setHasFixedSize(true);
        addOnScrollListener(new AnonymousClass1());
        CategoryLineaLayoutManager r113 = new CategoryLineaLayoutManager(getContext());
        r113.setOrientation(0);
        Unit r114 = Unit.INSTANCE;
        setLayoutManager(r113);
    }
}
