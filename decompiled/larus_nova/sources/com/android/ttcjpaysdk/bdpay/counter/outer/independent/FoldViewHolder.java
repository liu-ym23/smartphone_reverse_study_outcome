package com.android.ttcjpaysdk.bdpay.counter.outer.independent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0007R9\u0010\u0005\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/FoldViewHolder;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/OHomePageMethodViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "clickListener", "Lkotlin/Function1;", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/OHomePageMethodFoldBean;", "Lkotlin/ParameterName;", "name", "data", "", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "tvFoldText", "Landroid/widget/TextView;", "bindData", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoldViewHolder extends OHomePageMethodViewHolder {
    public static final Companion Companion = null;
    private Function1<? super OHomePageMethodFoldBean, Unit> clickListener;
    private OHomePageMethodFoldBean data;
    private final TextView tvFoldText;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/FoldViewHolder$Companion;", "", "()V", "create", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/FoldViewHolder;", "parent", "Landroid/view/ViewGroup;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final FoldViewHolder create(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new FoldViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.cj_pay_pay_method_upgrade_fold_view_layout, r100, false));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final Function1<OHomePageMethodFoldBean, Unit> getClickListener() {
        return this.clickListener;
    }

    public FoldViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.tvFoldText = (TextView) r100.findViewById(R.id.cj_pay_method_fold_text);
    }

    public final void bindData(final OHomePageMethodFoldBean r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.data = r100;
        this.tvFoldText.setText(r100.getDesc());
        String r101 = r100.getFoldScene();
        LinearLayout.LayoutParams r102 = null;
        if (Intrinsics.areEqual(r101, OHomePageMethodFoldBean.FOLD_SCENE_GROUP_INNER) == false) goto L20;
        View r103 = this.itemView;
        if ((r103 instanceof LinearLayout) == false) goto L9;
        LinearLayout r104 = (LinearLayout) r103;
    L10:
        if (r104 == null) goto L13;
        r104.setGravity(16);
    L13:
        ViewGroup.LayoutParams r105 = this.tvFoldText.getLayoutParams();
        if ((r105 instanceof LinearLayout.LayoutParams) == false) goto L16;
        r102 = (LinearLayout.LayoutParams) r105;
    L16:
        if (r102 == null) goto L34;
        r102.leftMargin = CJPayBasicExtensionKt.dp(46);
    L34:
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.itemView, new AnonymousClass1(r100, this));
        return;
    L9:
        r104 = null;
        goto L10
    L20:
        if (Intrinsics.areEqual(r101, "group") == false) goto L34;
        View r106 = this.itemView;
        if ((r106 instanceof LinearLayout) == false) goto L24;
        LinearLayout r107 = (LinearLayout) r106;
    L25:
        if (r107 == null) goto L28;
        r107.setGravity(17);
    L28:
        ViewGroup.LayoutParams r108 = this.tvFoldText.getLayoutParams();
        if ((r108 instanceof LinearLayout.LayoutParams) == false) goto L31;
        r102 = (LinearLayout.LayoutParams) r108;
    L31:
        if (r102 == null) goto L34;
        r102.leftMargin = 0;
        goto L34
    L24:
        r107 = null;
        goto L25
    }

    public final void setClickListener(Function1<? super OHomePageMethodFoldBean, Unit> r100) {
        this.clickListener = r100;
    }
}
