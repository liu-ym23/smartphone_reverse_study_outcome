package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import com.bytedance.android.shopping.commentv3.data.interfaces.CommentSliceComponent;
import com.bytedance.android.shopping.commentv3.view.CommentSliceView;
import com.bytedance.android.shopping.commentv3.view.FilterCardSliceView;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mc3.d;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/FilterCardViewHolder;", "Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/BaseSliceViewHolder;", "Lcom/bytedance/android/shopping/commentv3/view/FilterCardSliceView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterCardViewHolder extends BaseSliceViewHolder<FilterCardSliceView> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f172862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f172863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f172864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f172865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function1<? super Integer, Unit> f172866n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f172867a;

        public a() {
            this.f172867a = true;
        }
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.BaseSliceViewHolder
    public final Map<String, Object> T3() {
        LinkedHashMap r100 = new LinkedHashMap();
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("need_fold", Integer.valueOf(this.f172862j ? 1 : 0));
        r101.put("is_fold", Integer.valueOf(this.f172865m.f172867a ? 1 : 0));
        Unit r102 = Unit.INSTANCE;
        r100.put("na_data", r101);
        com.bytedance.android.shopping.commentv3.data.b r103 = this.f172854c;
        if (r103 == null) goto L9;
        d r104 = r103.f172740e;
        if (r104 == null) goto L9;
        mc3.a r105 = r104.f512875b;
        if (r105 == null) goto L9;
        r100.put("selected_tab", r105.e());
    L9:
        com.bytedance.android.shopping.commentv3.data.b r106 = this.f172854c;
        String r107 = null;
        if (r106 == null) goto L21;
        d r108 = r106.f172740e;
        if (r108 == null) goto L21;
        mc3.a r109 = r108.f512875b;
        if (r109 == null) goto L21;
        Object r110 = r109.f512871a.get("selected_first");
        if ((r110 instanceof Map) == true) goto L18;
        r110 = null;
    L18:
        Map r111 = (Map) r110;
        if (r111 == null) goto L21;
        r100.put("selected_first", r111);
    L21:
        com.bytedance.android.shopping.commentv3.data.b r112 = this.f172854c;
        if (r112 == null) goto L33;
        d r113 = r112.f172740e;
        if (r113 == null) goto L33;
        mc3.a r114 = r113.f512875b;
        if (r114 == null) goto L33;
        Object r115 = r114.f512871a.get("selected_second");
        if ((r115 instanceof Map) == true) goto L30;
        r115 = null;
    L30:
        Map r116 = (Map) r115;
        if (r116 == null) goto L33;
        r100.put("selected_second", r116);
    L33:
        com.bytedance.android.shopping.commentv3.data.b r117 = this.f172854c;
        if (r117 == null) goto L40;
        d r118 = r117.f172740e;
        if (r118 == null) goto L40;
        mc3.a r119 = r118.f512875b;
        if (r119 == null) goto L40;
        r107 = r119.d();
    L40:
        if (r107 != null) goto L42;
        r107 = "";
    L42:
        r100.put("second_filter", r107);
        return r100;
    }

    @Override // com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.BaseSliceViewHolder
    public final Map<String, fc3.b> U3(IAction r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = ActionType.FILTER_EXPAND.getType();
        Intrinsics.checkNotNullParameter(r110, "$this$hasAction");
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        Map r102 = null;
        Object r103 = null;
        if (Intrinsics.areEqual(r110.getType(), r101) == true) goto L17;
        List<IAction> r104 = r110.getActions();
        if (r104 == null) goto L15;
        Iterator<T> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((IAction) r106).getType(), r101) == false) goto L9;
    L14:
        IAction r107 = (IAction) r106;
    L16:
        if (r107 != null) goto L17;
        boolean r108 = false;
    L19:
        if (r108 == false) goto L33;
        String r109 = ActionType.FILTER_EXPAND.getType();
        Intrinsics.checkNotNullParameter(r110, "$this$getFields");
        if ((r110 instanceof SlcCommonAction) == false) goto L29;
        Object r111 = ((SlcCommonAction) r110).getData().get(SlcCommonAction.KEY_PARAMS);
        if ((r111 instanceof Map) == false) goto L27;
        r103 = r111;
    L27:
        r102 = (Map) r103;
    L29:
        if (r102 == null) goto L31;
        long r112 = nc3.a.c(r102, "anim_time", 200);
    L32:
        r100.put(r109, new hc3.b(r112, this.f172864l, this.f172863k, this.f172865m, new FilterCardViewHolder$getActionParmas$1(this), this.f172866n, this.f172852a));
        goto L33
    L31:
        r112 = 200;
    L33:
        return r100;
    L13:
        r106 = null;
        goto L14
    L15:
        r107 = null;
    L17:
        r108 = true;
        goto L19
    }

    public FilterCardViewHolder(CommentSliceView r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100, r101);
        this.f172865m = new a();
    }

    public final void Z3(final CommentSliceComponent r100, Function1<? super Integer, Unit> r101, FetchFrom r102) {
        Intrinsics.checkNotNullParameter(r100, "component");
        this.f172866n = r101;
        W3(r100.getTemplate());
        if (r102 != null) goto L5;
    L7:
        FilterCardSliceView r103 = (FilterCardSliceView) this.f172852a;
        if (r103 == null) goto L12;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L12;
        r104.height = -2;
        ((FilterCardSliceView) this.f172852a).setLayoutParams(r104);
    L12:
        Map<String, Object> r105 = r100.getStyle();
        int r106 = 124;
        if (r105 == null) goto L15;
        r106 = nc3.a.b(r105, "fold_height", 124);
    L15:
        this.f172864l = Y3(r106);
        FilterCardSliceView.a r107 = new FilterCardSliceView.a(null);
        r107.f172960a = this.f172864l;
        r107.f172961b = new FilterCardViewHolder$resetParams$$inlined$apply$lambda$1(this, r100);
        r107.f172962c = new FilterCardViewHolder$resetParams$$inlined$apply$lambda$2(this, r100);
        FilterCardSliceView r108 = (FilterCardSliceView) this.f172852a;
        if (r108 == null) goto L18;
        r108.setConfigParams(r107);
    L18:
        X3(r100);
        FilterCardSliceView r109 = (FilterCardSliceView) this.f172852a;
        if (r109 == null) goto L22;
        r109.post(new b(this));
        return;
    L22:
        return;
    L5:
        if (r102.getFrom() != FetchFrom.SKU_SWITCH.getFrom()) goto L7;
        this.f172865m.f172867a = true;
        goto L7
    }
}
