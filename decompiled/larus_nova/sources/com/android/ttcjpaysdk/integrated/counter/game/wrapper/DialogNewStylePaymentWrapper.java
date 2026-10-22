package com.android.ttcjpaysdk.integrated.counter.game.wrapper;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J(\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J(\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogNewStylePaymentWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "actionListener", "Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogNewStylePaymentWrapper$ActionListener;", "getActionListener", "()Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogNewStylePaymentWrapper$ActionListener;", "setActionListener", "(Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogNewStylePaymentWrapper$ActionListener;)V", "ivArrow", "Landroid/widget/ImageView;", "ivIcon", "ivIconMask", "tvRecommend", "Landroid/widget/TextView;", "tvSubTitle", "tvTitle", "bindData", "", "payTypeItem", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "loadImage", "url", "", "view", "maskView", "isEnable", "", "setIconView", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "ActionListener", "integrated-counter-game_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogNewStylePaymentWrapper extends BaseWrapper {
    private ActionListener actionListener;
    private final View itemView;
    private final ImageView ivArrow;
    private final ImageView ivIcon;
    private final ImageView ivIconMask;
    private final TextView tvRecommend;
    private final TextView tvSubTitle;
    private final TextView tvTitle;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/game/wrapper/DialogNewStylePaymentWrapper$ActionListener;", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "integrated-counter-game_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ActionListener {
        void onClick();
    }

    public final ActionListener getActionListener() {
        return this.actionListener;
    }

    public DialogNewStylePaymentWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.itemView = r100;
        this.ivIcon = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon);
        this.ivIconMask = (ImageView) r100.findViewById(R.id.cj_pay_payment_method_icon_unable_mask);
        this.tvTitle = (TextView) r100.findViewById(R.id.cj_pay_payment_method_title);
        this.tvRecommend = (TextView) r100.findViewById(R.id.cj_pay_payment_method_recommend_icon);
        this.tvSubTitle = (TextView) r100.findViewById(R.id.cj_pay_payment_method_sub_title);
        this.ivArrow = (ImageView) r100.findViewById(R.id.iv_right_arrow);
    }

    public final void bindData(PaymentMethodInfo r100) {
        if (r100 == null) goto L16;
        loadImage(r100.icon_url, this.ivIcon, this.ivIconMask, Intrinsics.areEqual(r100.status, "1"));
        this.tvTitle.setText(r100.title);
        if (TextUtils.isEmpty(r100.sub_title) == false) goto L6;
        this.tvSubTitle.setVisibility(8);
    L8:
        if (TextUtils.isEmpty(r100.mark) == true) goto L10;
        this.tvRecommend.setText(r100.mark);
        this.tvRecommend.setVisibility(0);
    L12:
        if (Intrinsics.areEqual(r100.status, "1") == false) goto L14;
        TextView r101 = this.tvTitle;
        r101.setTextColor(r101.getContext().getResources().getColor(R.color.cj_pay_color_black_64));
        this.tvSubTitle.setTextColor(this.tvTitle.getContext().getResources().getColor(R.color.cj_pay_color_black_64));
        this.ivArrow.setImageResource(R.drawable.cj_pay_integrated_icon_dialog_new_style_right_arrow);
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.itemView, new DialogNewStylePaymentWrapper$bindData$1$1(this));
        return;
    L14:
        TextView r102 = this.tvTitle;
        r102.setTextColor(r102.getContext().getResources().getColor(R.color.cj_pay_color_gray_202));
        this.tvSubTitle.setTextColor(this.tvTitle.getContext().getResources().getColor(R.color.cj_pay_color_gray_202));
        this.ivArrow.setImageResource(R.drawable.cj_pay_integrated_icon_right_arrow_disabled);
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.itemView, DialogNewStylePaymentWrapper$bindData$1$2.INSTANCE);
        return;
    L10:
        this.tvRecommend.setVisibility(8);
        goto L12
    L6:
        this.tvSubTitle.setText(r100.sub_title);
        goto L8
    }

    public final void setActionListener(ActionListener r100) {
        this.actionListener = r100;
    }

    private final void loadImage(String r100, final ImageView r101, final ImageView r102, final boolean r103) {
        ImageLoader.Companion.getInstance().loadImage(r100, new AnonymousClass1(r101, this, r102, r103));
    }

    private final void setIconView(Bitmap r100, ImageView r101, ImageView r102, boolean r103) {
        r101.setImageBitmap(r100);
        if (r103 == false) goto L5;
        r102.setVisibility(8);
        return;
    L5:
        r102.setVisibility(0);
    }

    public static final /* synthetic */ void access$setIconView(DialogNewStylePaymentWrapper r100, Bitmap r101, ImageView r102, ImageView r103, boolean r104) {
        r100.setIconView(r101, r102, r103, r104);
    }
}
