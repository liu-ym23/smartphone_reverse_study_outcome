package com.bytedance.android.shopping.orderlist.common.widgets.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonYataErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function0;", "", "action", "setErrorRetryListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonYataErrorView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f180065a;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f180066a;

        public a(Function0 r100) {
            this.f180066a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f180066a.invoke();
        }
    }

    public OrderCommonYataErrorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OrderCommonYataErrorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setErrorRetryListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (this.f180065a != null) goto L5;
        this.f180065a = new LinkedHashMap();
    L5:
        Map<Integer, View> r101 = this.f180065a;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        View r103 = (View) r102.get(Integer.valueOf(R.id.order_list_error_retry));
        if (r103 != null) goto L11;
        r103 = findViewById(R.id.order_list_error_retry);
        if (r103 == null) goto L10;
        this.f180065a.put(Integer.valueOf(R.id.order_list_error_retry), r103);
        goto L11
    L10:
        r103 = null;
    L11:
        TextView r104 = (TextView) r103;
        if (r104 == null) goto L15;
        r104.setOnClickListener(new a(r100));
        return;
    }

    public OrderCommonYataErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180065a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.order_list_view_error, this, true);
    }

    public /* synthetic */ OrderCommonYataErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
