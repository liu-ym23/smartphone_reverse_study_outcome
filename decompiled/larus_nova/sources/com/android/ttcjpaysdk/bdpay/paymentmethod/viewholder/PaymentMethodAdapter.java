package com.android.ttcjpaysdk.bdpay.paymentmethod.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.bdpay.paymentmethod.bean.MethodPayTypeInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u001e\u0010\u0013\u001a\u00020\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PaymentMethodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isCombine", "", "useVoucherMsgV2", "(Landroid/content/Context;ZZ)V", "data", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo;", "Lkotlin/collections/ArrayList;", "onMethodAdapterListener", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PaymentMethodAdapter$OnMethodAdapterListener;", "getOnMethodAdapterListener", "()Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PaymentMethodAdapter$OnMethodAdapterListener;", "setOnMethodAdapterListener", "(Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PaymentMethodAdapter$OnMethodAdapterListener;)V", "dataChangedNotify", "", "list", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "OnMethodAdapterListener", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentMethodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    public static final int VIEW_FOLD_AREA = 2;
    public static final int VIEW_SPLIT_LINE = 1;
    public static final int VIEW_TYPE_DY_PAY = 0;
    private final Context context;
    private ArrayList<MethodPayTypeInfo> data;
    private final boolean isCombine;
    private OnMethodAdapterListener onMethodAdapterListener;
    private final boolean useVoucherMsgV2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PaymentMethodAdapter$Companion;", "", "()V", "VIEW_FOLD_AREA", "", "VIEW_SPLIT_LINE", "VIEW_TYPE_DY_PAY", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/viewholder/PaymentMethodAdapter$OnMethodAdapterListener;", "", "onMethodFoldClick", "", "isExpanded", "", "onOtherPaymentTypeClick", "info", "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo;", "position", "", "onSelecIncome", "onSelectBalance", "onSelectBankCard", "onSelectBindCard", "onSelectSharePay", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnMethodAdapterListener {
        void onMethodFoldClick(boolean r100);

        void onOtherPaymentTypeClick(MethodPayTypeInfo r100, int r101);

        void onSelecIncome(MethodPayTypeInfo r100, int r101);

        void onSelectBalance(MethodPayTypeInfo r100, int r101);

        void onSelectBankCard(MethodPayTypeInfo r100, int r101);

        void onSelectBindCard(MethodPayTypeInfo r100, int r101);

        void onSelectSharePay(MethodPayTypeInfo r100, int r101);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[MethodPayTypeInfo.ViewType.values().length];
            r100[MethodPayTypeInfo.ViewType.SPLIT_LINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MethodPayTypeInfo.ViewType.FOLD_AREA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final OnMethodAdapterListener getOnMethodAdapterListener() {
        return this.onMethodAdapterListener;
    }

    public final void dataChangedNotify(ArrayList<MethodPayTypeInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.data.clear();
        this.data.addAll(r100);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        MethodPayTypeInfo.ViewType r101 = ((MethodPayTypeInfo) ListProtector.get(this.data, r100)).getView_type();
        int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r102 != 1) goto L5;
        return 1;
    L5:
        if (r102 == 2) goto L9;
        return 0;
    L9:
        return 2;
    }

    public final void setOnMethodAdapterListener(OnMethodAdapterListener r100) {
        this.onMethodAdapterListener = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        MethodPayTypeInfo r102 = (MethodPayTypeInfo) ListProtector.get(this.data, r101);
        if ((r100 instanceof NormalPayViewHolder) == false) goto L6;
        NormalPayViewHolder r103 = (NormalPayViewHolder) r100;
        r103.bindData(r102);
        r103.setOnMethodAdapterListener(this.onMethodAdapterListener);
        return;
    L6:
        if ((r100 instanceof PayWithFoldAreaViewHolder) == false) goto L10;
        ((PayWithFoldAreaViewHolder) r100).setOnMethodAdapterListener(this.onMethodAdapterListener);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L14;
        return new NormalPayViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_normal_pay_layout, r100, false), this.isCombine, this.useVoucherMsgV2);
    L14:
        return new PayWithFoldAreaViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_pay_with_fold_area_layout, r100, false), this.isCombine, this.useVoucherMsgV2);
    L15:
        return new PayWithSplitLineViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_pay_with_split_line_layout, r100, false), this.isCombine, this.useVoucherMsgV2);
    L12:
        return new NormalPayViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_normal_pay_layout, r100, false), this.isCombine, this.useVoucherMsgV2);
    }

    public PaymentMethodAdapter(Context r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.isCombine = r101;
        this.useVoucherMsgV2 = r102;
        this.data = new ArrayList();
    }

    public /* synthetic */ PaymentMethodAdapter(Context r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = false;
    L8:
        this(r100, r101, r102);
    }
}
