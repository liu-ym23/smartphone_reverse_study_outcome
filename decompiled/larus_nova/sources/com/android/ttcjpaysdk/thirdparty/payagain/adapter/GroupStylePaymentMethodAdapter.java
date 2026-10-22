package com.android.ttcjpaysdk.thirdparty.payagain.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.thirdparty.payagain.data.FrontPaymentMethodInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u001e\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/GroupStylePaymentMethodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isCombine", "", "useVoucherMsgV2", "isEnableCheckbox", "(Landroid/content/Context;ZZZ)V", "data", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/thirdparty/payagain/data/FrontPaymentMethodInfo;", "Lkotlin/collections/ArrayList;", "onMethodAdapterListener", "Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/GroupStylePaymentMethodAdapter$OnGroupStyleMethodAdapterListener;", "getOnMethodAdapterListener", "()Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/GroupStylePaymentMethodAdapter$OnGroupStyleMethodAdapterListener;", "setOnMethodAdapterListener", "(Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/GroupStylePaymentMethodAdapter$OnGroupStyleMethodAdapterListener;)V", "dataChangedNotify", "", "list", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "OnGroupStyleMethodAdapterListener", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroupStylePaymentMethodAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    public static final int VIEW_FOLD_AREA = 2;
    public static final int VIEW_SPLIT_LINE = 1;
    public static final int VIEW_TYPE_DY_PAY = 0;
    private final Context context;
    private ArrayList<FrontPaymentMethodInfo> data;
    private final boolean isCombine;
    private final boolean isEnableCheckbox;
    private OnGroupStyleMethodAdapterListener onMethodAdapterListener;
    private final boolean useVoucherMsgV2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/GroupStylePaymentMethodAdapter$Companion;", "", "()V", "VIEW_FOLD_AREA", "", "VIEW_SPLIT_LINE", "VIEW_TYPE_DY_PAY", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\nH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/adapter/GroupStylePaymentMethodAdapter$OnGroupStyleMethodAdapterListener;", "", "onMethodFoldClick", "", "isExpanded", "", "onOtherPaymentTypeClick", "info", "Lcom/android/ttcjpaysdk/thirdparty/payagain/data/FrontPaymentMethodInfo;", "position", "", "onSelecIncome", "onSelectBalance", "onSelectBankCard", "onSelectBindCard", "onSelectCombinePay", "index", "onSelectSharePay", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnGroupStyleMethodAdapterListener {
        void onMethodFoldClick(boolean r100);

        void onOtherPaymentTypeClick(FrontPaymentMethodInfo r100, int r101);

        void onSelecIncome(FrontPaymentMethodInfo r100, int r101);

        void onSelectBalance(FrontPaymentMethodInfo r100, int r101);

        void onSelectBankCard(FrontPaymentMethodInfo r100, int r101);

        void onSelectBindCard(FrontPaymentMethodInfo r100, int r101);

        void onSelectCombinePay(FrontPaymentMethodInfo r100, int r101);

        void onSelectSharePay(FrontPaymentMethodInfo r100, int r101);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[FrontPaymentMethodInfo.ViewType.values().length];
            r100[FrontPaymentMethodInfo.ViewType.SPLIT_LINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FrontPaymentMethodInfo.ViewType.FOLD_AREA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
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

    public final OnGroupStyleMethodAdapterListener getOnMethodAdapterListener() {
        return this.onMethodAdapterListener;
    }

    public final void dataChangedNotify(ArrayList<FrontPaymentMethodInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.data.clear();
        this.data.addAll(r100);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        FrontPaymentMethodInfo.ViewType r101 = ((FrontPaymentMethodInfo) ListProtector.get(this.data, r100)).view_type;
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        return 1;
    L9:
        if (r102 == 2) goto L13;
        return 0;
    L13:
        return 2;
    L5:
        r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        goto L7
    }

    public final void setOnMethodAdapterListener(OnGroupStyleMethodAdapterListener r100) {
        this.onMethodAdapterListener = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        FrontPaymentMethodInfo r102 = (FrontPaymentMethodInfo) ListProtector.get(this.data, r101);
        if ((r100 instanceof PGNormalPayViewHolder) == false) goto L6;
        PGNormalPayViewHolder r103 = (PGNormalPayViewHolder) r100;
        r103.bindData(r102);
        r103.setOnMethodAdapterListener(this.onMethodAdapterListener);
        return;
    L6:
        if ((r100 instanceof PGPayWithFoldAreaViewHolder) == false) goto L10;
        ((PGPayWithFoldAreaViewHolder) r100).setOnMethodAdapterListener(this.onMethodAdapterListener);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L14;
        return new PGNormalPayViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_normal_pay_layout, r100, false), this.isCombine, this.useVoucherMsgV2, this.isEnableCheckbox);
    L14:
        return new PGPayWithFoldAreaViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_pay_with_fold_area_layout, r100, false), this.isCombine, this.useVoucherMsgV2);
    L15:
        return new PGPayWithSplitLineViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_pay_with_split_line_layout, r100, false), this.isCombine, this.useVoucherMsgV2);
    L12:
        return new PGNormalPayViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_normal_pay_layout, r100, false), this.isCombine, this.useVoucherMsgV2, this.isEnableCheckbox);
    }

    public GroupStylePaymentMethodAdapter(Context r100, boolean r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.isCombine = r101;
        this.useVoucherMsgV2 = r102;
        this.isEnableCheckbox = r103;
        this.data = new ArrayList();
    }

    public /* synthetic */ GroupStylePaymentMethodAdapter(Context r100, boolean r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = false;
    L11:
        this(r100, r101, r102, r103);
    }
}
