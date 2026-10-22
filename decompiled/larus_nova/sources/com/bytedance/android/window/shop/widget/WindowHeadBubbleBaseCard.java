package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowHeadBubbleBaseCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "setSubTitle", "(Landroid/widget/TextView;)V", "subTitle", "Lcom/facebook/drawee/view/SimpleDraweeView;", "b", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCover", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setCover", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "cover", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "c", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getIcon", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "setIcon", "(Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;)V", "icon", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeadBubbleBaseCard extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f189902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SimpleDraweeView f189903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECDraweeView f189904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f189905d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f189906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ uq3.e f189907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function2 f189908c;

        public a(Function1 r100, uq3.e r101, Function2 r102) {
            this.f189906a = r100;
            this.f189907b = r101;
            this.f189908c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1 r101 = this.f189906a;
            if (r101 == null) goto L5;
            Unit r102 = (Unit) r101.invoke(this.f189907b.f551222e);
        L5:
            Function2 r103 = this.f189908c;
            if (r103 == null) goto L13;
            Integer r104 = this.f189907b.f551223f;
            if (r104 == null) goto L10;
            String r105 = String.valueOf(r104.intValue());
        L11:
            Unit r106 = (Unit) r103.invoke("bubble_click", r105);
            return;
        L10:
            r105 = null;
            goto L11
        }
    }

    public final SimpleDraweeView getCover() {
        SimpleDraweeView r100 = this.f189903b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cover");
    L5:
        return r100;
    }

    public final ECDraweeView getIcon() {
        ECDraweeView r100 = this.f189904c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("icon");
    L5:
        return r100;
    }

    public final TextView getSubTitle() {
        TextView r100 = this.f189902a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subTitle");
    L5:
        return r100;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f189904c = (ECDraweeView) findViewById(R.id.ec_window_head_bubble_head_icon);
        this.f189902a = (TextView) findViewById(R.id.ec_window_head_bubble_subtitle);
        this.f189903b = (SimpleDraweeView) findViewById(R.id.ec_window_head_bubble_cover);
        this.f189905d = findViewById(R.id.ec_window_head_bubble_just_watched);
    }

    public final void setCover(SimpleDraweeView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f189903b = r100;
    }

    public final void setIcon(ECDraweeView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f189904c = r100;
    }

    public final void setSubTitle(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f189902a = r100;
    }

    public WindowHeadBubbleBaseCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public final void R5(uq3.e r210, Function1<? super String, Unit> r211, Function2<? super String, ? super String, Unit> r212, Function4<? super View, ? super uq3.e, ? super Integer, ? super Function0<Unit>, Unit> r213, int r214) {
        Intrinsics.checkNotNullParameter(r210, "bubbleVO");
        TextView r100 = this.f189902a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subTitle");
    L5:
        r100.setText(r210.f551221d);
        ECDraweeView r101 = this.f189904c;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("icon");
    L8:
        h0.d(r101, r210.f551219b, null, null, null, null, null, 120);
        SimpleDraweeView r110 = this.f189903b;
        if (r110 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cover");
    L11:
        List<? extends ECUrlModel> r102 = r210.f551220c;
        if (r102 == null) goto L14;
        ECUrlModel r111 = (ECUrlModel) CollectionsKt.getOrNull(r102, 0);
    L15:
        h0.d(r110, r111, null, null, null, null, null, 120);
        if (r212 == null) goto L22;
        Integer r103 = r210.f551223f;
        if (r103 == null) goto L20;
        String r104 = String.valueOf(r103.intValue());
    L21:
        Unit r105 = r212.invoke("bubble_show", r104);
        goto L22
    L20:
        r104 = null;
    L22:
        setOnClickListener(new a(r211, r210, r212));
        if (r213 == null) goto L26;
        Unit r106 = r213.invoke(this, r210, Integer.valueOf(r214), null);
        return;
    L26:
        return;
    L14:
        r111 = null;
        goto L15
    }
}
