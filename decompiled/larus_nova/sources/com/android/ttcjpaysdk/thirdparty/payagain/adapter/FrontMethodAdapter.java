package com.android.ttcjpaysdk.thirdparty.payagain.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.thirdparty.payagain.data.FrontPaymentMethodInfo;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0019\u001a\u00020\u000f2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\u001e\u0010\u001a\u001a\u00020\u001b2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0006H\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "data", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/thirdparty/payagain/data/FrontPaymentMethodInfo;", "Lkotlin/collections/ArrayList;", "hasMultipleVoucher", "", WidgetCostModule.TYPE_INFLATE, "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "onMethodAdapterListener", "Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;", "getOnMethodAdapterListener", "()Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;", "setOnMethodAdapterListener", "(Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;)V", "calculationHashMulitVoucher", "dataChangedNotify", "", "list", "getItemCount", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "OnMethodAdapterListener", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FrontMethodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    public static final int VIEW_TYPE_CREDIT_PAY = 1;
    public static final int VIEW_TYPE_DY_PAY = 0;
    private final Context context;
    private ArrayList<FrontPaymentMethodInfo> data;
    private boolean hasMultipleVoucher;
    private final LayoutInflater inflate;
    private OnMethodAdapterListener onMethodAdapterListener;
    private final int type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$Companion;", "", "()V", "VIEW_TYPE_CREDIT_PAY", "", "VIEW_TYPE_DY_PAY", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/FrontMethodAdapter$OnMethodAdapterListener;", "", "onClickCreditPayVoucherItem", "", "info", "Lcom/android/ttcjpaysdk/thirdparty/payagain/data/FrontPaymentMethodInfo;", "index", "", "onSelectBalance", "onSelectBankCard", "onSelectBindCard", "onSelectCombinePay", "onSelectCreditPay", "onSelectFundPay", "onSelectIncome", "onSelectSharePay", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnMethodAdapterListener {
        void onClickCreditPayVoucherItem(FrontPaymentMethodInfo r100, int r101);

        void onSelectBalance(FrontPaymentMethodInfo r100, int r101);

        void onSelectBankCard(FrontPaymentMethodInfo r100, int r101);

        void onSelectBindCard(FrontPaymentMethodInfo r100, int r101);

        void onSelectCombinePay(FrontPaymentMethodInfo r100, int r101);

        void onSelectCreditPay(FrontPaymentMethodInfo r100, int r101);

        void onSelectFundPay(FrontPaymentMethodInfo r100, int r101);

        void onSelectIncome(FrontPaymentMethodInfo r100, int r101);

        void onSelectSharePay(FrontPaymentMethodInfo r100, int r101);
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final Context getContext() {
        return this.context;
    }

    public final OnMethodAdapterListener getOnMethodAdapterListener() {
        return this.onMethodAdapterListener;
    }

    private final boolean calculationHashMulitVoucher(ArrayList<FrontPaymentMethodInfo> r100) {
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L11;
        FrontPaymentMethodInfo r103 = (FrontPaymentMethodInfo) r101.next();
        if (Intrinsics.areEqual(r103.status, "1") == false) goto L4;
        if (TextUtils.isEmpty(r103.voucher_info.vouchers_label) == true) goto L4;
        r102 = r102 + 1;
        goto L4
    L11:
        if (r102 <= 1) goto L21;
        return true;
    L21:
        return false;
    }

    public final void dataChangedNotify(ArrayList<FrontPaymentMethodInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.data.clear();
        this.data.addAll(r100);
        this.hasMultipleVoucher = calculationHashMulitVoucher(this.data);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        return Intrinsics.areEqual(((FrontPaymentMethodInfo) ListProtector.get(this.data, r100)).paymentType, "creditpay") ? 1 : 0;
    }

    public final void setOnMethodAdapterListener(OnMethodAdapterListener r100) {
        this.onMethodAdapterListener = r100;
    }

    public FrontMethodAdapter(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.type = r101;
        this.inflate = LayoutInflater.from(r100);
        this.data = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        FrontPaymentMethodInfo r102 = (FrontPaymentMethodInfo) ListProtector.get(this.data, r101);
        if ((r100 instanceof BaseViewHolder) == false) goto L5;
        BaseViewHolder r103 = (BaseViewHolder) r100;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        if ((r100 instanceof FrontMethodViewHolder) == false) goto L11;
        ((FrontMethodViewHolder) r100).setsMultipleVoucher(this.hasMultipleVoucher);
    L13:
        ((BaseViewHolder) r100).bindData(r102);
        ViewGroup.LayoutParams r104 = r100.itemView.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r105 = (RecyclerView.LayoutParams) r104;
        if (r101 != 0) goto L16;
        ((ViewGroup.MarginLayoutParams) r105).topMargin = CJPayBasicUtils.dipToPX(this.context, 8.0f);
        return;
    L16:
        ViewGroup.LayoutParams r106 = r100.itemView.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r106)).topMargin = 0;
        return;
    L11:
        if ((r100 instanceof FrontMethodCreditPayViewHolder) == false) goto L13;
        ((FrontMethodCreditPayViewHolder) r100).setsMultipleVoucher(this.hasMultipleVoucher);
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 0) goto L5;
        BaseViewHolder r102 = new FrontMethodViewHolder(this.inflate.inflate(R.layout.cj_pay_item_front_method_layout, r100, false));
    L9:
        r102.setOnMethodAdapterListener(this.onMethodAdapterListener);
        return r102;
    L5:
        if (r101 == 1) goto L7;
        r102 = new FrontMethodViewHolder(this.inflate.inflate(R.layout.cj_pay_item_front_method_layout, r100, false));
        goto L9
    L7:
        r102 = new FrontMethodCreditPayViewHolder(this.inflate.inflate(R.layout.cj_pay_item_front_method_credit_pay_layout, r100, false));
        goto L9
    }

    public /* synthetic */ FrontMethodAdapter(Context r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 0;
    L5:
        this(r100, r101);
    }
}
