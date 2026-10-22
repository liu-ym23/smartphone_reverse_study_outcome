package com.bytedance.android.live.recharge.exchange.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.incentive.exchange.i;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001c\u0010 B#\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b\u001c\u0010#R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView;", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/ImageView;", "getMSelectIcon", "()Landroid/widget/ImageView;", "setMSelectIcon", "(Landroid/widget/ImageView;)V", "mSelectIcon", "", "b", "Z", "getMSelect", "()Z", "setMSelect", "(Z)V", "mSelect", "Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView$a;", "c", "Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView$a;", "getMOnSelectClickListner", "()Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView$a;", "setMOnSelectClickListner", "(Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView$a;)V", "mOnSelectClickListner", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExchangeConfirmDefaultView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f89972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f89973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f89974c;

    public interface a {
        void a(boolean r100);
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExchangeConfirmDefaultView f89975a;

        public b(ExchangeConfirmDefaultView r100) {
            this.f89975a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ImageView r101 = this.f89975a.getMSelectIcon();
            if (r101 != null) goto L5;
        L9:
            ExchangeConfirmDefaultView r102 = this.f89975a;
            r102.setMSelect(!r102.getMSelect());
            com.bytedance.android.live.recharge.combinedpay.a.C1374a r103 = com.bytedance.android.live.recharge.combinedpay.a.f89668a;
            com.bytedance.android.live.recharge.combinedpay.a.f89669b.set(Boolean.valueOf(this.f89975a.getMSelect()));
            a r104 = this.f89975a.getMOnSelectClickListner();
            if (r104 == null) goto L13;
            r104.a(this.f89975a.getMSelect());
            return;
        L13:
            return;
        L5:
            if (this.f89975a.getMSelect() == false) goto L7;
            int r105 = R.drawable.ttlive_recharge_balance_exchange_unselect;
        L8:
            r101.setImageResource(r105);
            goto L9
        L7:
            r105 = R.drawable.ttlive_recharge_balance_exchange_select;
            goto L8
        }
    }

    public final void a() {
        this.f89972a = (ImageView) FrameLayout.inflate(getContext(), R.layout.ttlive_dialog_exchange_confirm_default_select_layout, this).findViewById(R.id.exchange_confirm_select_icon);
        if (i.a() == false) goto L7;
        TextView r100 = (TextView) findViewById(R.id.exchange_confirm_select_text);
        if (r100 == null) goto L7;
        r100.setText(R.string.ttlive_balance_exchange_confirm_default_use_text_tax_saving);
    L7:
        ImageView r101 = this.f89972a;
        if (r101 == null) goto L11;
        r101.setOnClickListener(new b(this));
        return;
    }

    public final a getMOnSelectClickListner() {
        return this.f89974c;
    }

    public final boolean getMSelect() {
        return this.f89973b;
    }

    public final ImageView getMSelectIcon() {
        return this.f89972a;
    }

    public ExchangeConfirmDefaultView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a();
    }

    public final void setMOnSelectClickListner(a r100) {
        this.f89974c = r100;
    }

    public final void setMSelect(boolean r100) {
        this.f89973b = r100;
    }

    public final void setMSelectIcon(ImageView r100) {
        this.f89972a = r100;
    }

    public ExchangeConfirmDefaultView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        a();
    }

    public ExchangeConfirmDefaultView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a();
    }
}
