package com.android.ttcjpaysdk.thirdparty.verify.view.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.thirdparty.data.FreqSuggestCardInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "holderStyle", "", "(Landroid/content/Context;Ljava/lang/String;)V", "data", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/thirdparty/data/FreqSuggestCardInfo;", "Lkotlin/collections/ArrayList;", "onClickAdapterListener", "Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;", "getOnClickAdapterListener", "()Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;", "setOnClickAdapterListener", "(Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;)V", "getItemCount", "", "getItemViewType", "position", "getLayoutId", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "OnClickAdapterListener", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BdBankCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    public static final String HOLDER_STYLE_DEFAULT = "default";
    public static final String HOLDER_STYLE_SPLIT = "split";
    public static final int VIEW_BOTTOM = 1;
    public static final int VIEW_NORMAL = 0;
    public static final int VIEW_SINGLE = 2;
    private final Context context;
    private ArrayList<FreqSuggestCardInfo> data;
    private final String holderStyle;
    private OnClickAdapterListener onClickAdapterListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$Companion;", "", "()V", "HOLDER_STYLE_DEFAULT", "", "HOLDER_STYLE_SPLIT", "VIEW_BOTTOM", "", "VIEW_NORMAL", "VIEW_SINGLE", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/viewholder/BdBankCardAdapter$OnClickAdapterListener;", "", "onClickBindCard", "", "onSelectBankCard", "info", "Lcom/android/ttcjpaysdk/thirdparty/data/FreqSuggestCardInfo;", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnClickAdapterListener {
        void onClickBindCard();

        void onSelectBankCard(FreqSuggestCardInfo r100);
    }

    static {
        Companion = new Companion(null);
    }

    private final int getLayoutId() {
        if (Intrinsics.areEqual(this.holderStyle, "split") == false) goto L5;
        return R.layout.cj_pay_item_bd_counter_bank_card_split_layout;
    L5:
        return R.layout.cj_pay_item_bd_counter_bank_card_layout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final OnClickAdapterListener getOnClickAdapterListener() {
        return this.onClickAdapterListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        return ((FreqSuggestCardInfo) ListProtector.get(this.data, r100)).type;
    }

    public final void setOnClickAdapterListener(OnClickAdapterListener r100) {
        this.onClickAdapterListener = r100;
    }

    public BdBankCardAdapter(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "holderStyle");
        this.context = r100;
        this.holderStyle = r101;
        this.data = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        FreqSuggestCardInfo r102 = (FreqSuggestCardInfo) ListProtector.get(this.data, r101);
        if ((r100 instanceof BdBankCardViewHolder) == false) goto L6;
        BdBankCardViewHolder r103 = (BdBankCardViewHolder) r100;
        r103.bindData(r102);
        r103.setOnClickAdapterListener(this.onClickAdapterListener);
        return;
    L6:
        if ((r100 instanceof BdAddCardViewHolder) == false) goto L10;
        BdAddCardViewHolder r104 = (BdAddCardViewHolder) r100;
        r104.bindData(r102);
        r104.setOnClickAdapterListener(this.onClickAdapterListener);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r110 == 0) goto L12;
        if (r110 == 1) goto L15;
        if (r110 == 2) goto L14;
        return new BdBankCardViewHolder(LayoutInflater.from(this.context).inflate(getLayoutId(), r100, false), false, this.holderStyle, 2, null);
    L14:
        return new BdAddCardViewHolder(LayoutInflater.from(this.context).inflate(R.layout.cj_pay_item_bd_counter_add_card_layout, r100, false));
    L15:
        return new BdBankCardViewHolder(LayoutInflater.from(this.context).inflate(getLayoutId(), r100, false), true, this.holderStyle);
    L12:
        return new BdBankCardViewHolder(LayoutInflater.from(this.context).inflate(getLayoutId(), r100, false), false, this.holderStyle, 2, null);
    }

    public /* synthetic */ BdBankCardAdapter(Context r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = "default";
    L5:
        this(r100, r101);
    }
}
