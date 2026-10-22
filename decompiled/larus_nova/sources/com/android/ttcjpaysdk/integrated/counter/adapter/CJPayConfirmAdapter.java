package com.android.ttcjpaysdk.integrated.counter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import com.android.ttcjpaysdk.integrated.counter.IntegratedFactory;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.android.ttcjpaysdk.integrated.counter.viewholder.BaseViewHolder;
import com.android.ttcjpaysdk.integrated.counter.viewholder.SingleTypeViewHolder;
import com.android.ttcjpaysdk.std.asset.view.CJBusinessFooterView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005HIJKLB\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010(\u001a\u00020)J\u001e\u0010*\u001a\u00020)2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.J\u001a\u0010/\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010,j\n\u0012\u0004\u0012\u00020-\u0018\u0001`.J\b\u00100\u001a\u00020\u0006H\u0002J\b\u00101\u001a\u00020\u0006H\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u000205H\u0002J\u0006\u00106\u001a\u00020)J\u0006\u00107\u001a\u00020)J\u0006\u00108\u001a\u00020)J\u0006\u00109\u001a\u00020)J\u0010\u0010:\u001a\u0002052\u0006\u00103\u001a\u00020\u0006H\u0002J\u0006\u0010;\u001a\u000205J\u0018\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0006H\u0016J\u0018\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0006H\u0016J\u0010\u0010B\u001a\u00020)2\b\u0010C\u001a\u0004\u0018\u00010\nJ\u0006\u0010D\u001a\u00020)J\u0006\u0010E\u001a\u00020)J\u0006\u0010F\u001a\u00020)J\u0006\u0010G\u001a\u00020)R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "type", "", "showNum", "(Landroid/content/Context;II)V", "businessDesc", "", "confirmAdapter", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/ConfirmAdapterProxy;", "getContext", "()Landroid/content/Context;", WidgetCostModule.TYPE_INFLATE, "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "onConfirmAdapterListener", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmAdapterListener;", "getOnConfirmAdapterListener", "()Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmAdapterListener;", "setOnConfirmAdapterListener", "(Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmAdapterListener;)V", "onConfirmBannerAdapterListener", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmBannerAdapterListener;", "getOnConfirmBannerAdapterListener", "()Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmBannerAdapterListener;", "setOnConfirmBannerAdapterListener", "(Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmBannerAdapterListener;)V", "onDyPayConfirmAdapterListener", "Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnDyPayConfirmAdapterListener;", "getOnDyPayConfirmAdapterListener", "()Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnDyPayConfirmAdapterListener;", "setOnDyPayConfirmAdapterListener", "(Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnDyPayConfirmAdapterListener;)V", "getShowNum", "()I", "setShowNum", "(I)V", "clearAdapterShowNum", "", "dataChangedNotify", "list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "Lkotlin/collections/ArrayList;", "getAdapterData", "getBusinessFooterPosition", "getItemCount", "getItemViewType", "position", "hasBusinessFooter", "", "hideBannerLoading", "hideDyPayAddNewCardLoading", "hideLoading", "hideWxBankCardLoading", "isBusinessFooterPosition", "isConfirmListCollapsed", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBusinessFooter", SocialConstants.PARAM_APP_DESC, "showBannerLoading", "showDyPayAddNewCardLoading", DyPayConstant.KEY_SHOW_LOADING, "showWxBankCardLoading", "BusinessViewHolder", "Companion", "OnConfirmAdapterListener", "OnConfirmBannerAdapterListener", "OnDyPayConfirmAdapterListener", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayConfirmAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    private static final int VIEW_TYPE_BUSINESS = 1457;
    private static boolean isBannerLoading;
    private static boolean isDyPayAddNewCardLoading;
    private static volatile boolean isLoading;
    private static boolean isWxBankCardLoading;
    private String businessDesc;
    private ConfirmAdapterProxy confirmAdapter;
    private final Context context;
    private final LayoutInflater inflate;
    private OnConfirmAdapterListener onConfirmAdapterListener;
    private OnConfirmBannerAdapterListener onConfirmBannerAdapterListener;
    private OnDyPayConfirmAdapterListener onDyPayConfirmAdapterListener;
    private int showNum;
    private final int type;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$BusinessViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/android/ttcjpaysdk/std/asset/view/CJBusinessFooterView;", "(Lcom/android/ttcjpaysdk/std/asset/view/CJBusinessFooterView;)V", "getView", "()Lcom/android/ttcjpaysdk/std/asset/view/CJBusinessFooterView;", "bind", "", SocialConstants.PARAM_APP_DESC, "", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BusinessViewHolder extends RecyclerView.ViewHolder {
        private final CJBusinessFooterView view;

        public final CJBusinessFooterView getView() {
            return this.view;
        }

        public BusinessViewHolder(CJBusinessFooterView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.view = r100;
        }

        public final void bind(String r100) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
            this.view.bindData(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$Companion;", "", "()V", "VIEW_TYPE_BUSINESS", "", "isBannerLoading", "", "()Z", "setBannerLoading", "(Z)V", "isDyPayAddNewCardLoading", "setDyPayAddNewCardLoading", "isLoading", "setLoading", "isWxBankCardLoading", "setWxBankCardLoading", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean isBannerLoading() {
            return CJPayConfirmAdapter.access$isBannerLoading$cp();
        }

        public final boolean isDyPayAddNewCardLoading() {
            return CJPayConfirmAdapter.access$isDyPayAddNewCardLoading$cp();
        }

        public final boolean isLoading() {
            return CJPayConfirmAdapter.access$isLoading$cp();
        }

        public final boolean isWxBankCardLoading() {
            return CJPayConfirmAdapter.access$isWxBankCardLoading$cp();
        }

        public final void setBannerLoading(boolean r100) {
            CJPayConfirmAdapter.access$setBannerLoading$cp(r100);
        }

        public final void setDyPayAddNewCardLoading(boolean r100) {
            CJPayConfirmAdapter.access$setDyPayAddNewCardLoading$cp(r100);
        }

        public final void setLoading(boolean r100) {
            CJPayConfirmAdapter.access$setLoading$cp(r100);
        }

        public final void setWxBankCardLoading(boolean r100) {
            CJPayConfirmAdapter.access$setWxBankCardLoading$cp(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmAdapterListener;", "", "onClickBanner", "", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "onClickMorePayMethod", "onSelectDetail", "onSelectPaymentMethodInfo", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnConfirmAdapterListener {
        void onClickBanner(PaymentMethodInfo r100);

        void onClickMorePayMethod();

        void onSelectDetail(PaymentMethodInfo r100);

        void onSelectPaymentMethodInfo(PaymentMethodInfo r100);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnConfirmBannerAdapterListener;", "", "onClickBanner", "", "onClickBannerSubPayList", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "onClickBannerWxBankCard", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnConfirmBannerAdapterListener {
        void onClickBanner();

        void onClickBannerSubPayList(PaymentMethodInfo r100);

        void onClickBannerWxBankCard(PaymentMethodInfo r100);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/adapter/CJPayConfirmAdapter$OnDyPayConfirmAdapterListener;", "", "onClickBindCard", "", "info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "onClickCardTypeItem", "onClickCreditPayVoucherItem", "onClickIconTips", "Lcom/android/ttcjpaysdk/base/ui/data/IconTips;", "onSelectDetail", "onSelectPaymentMethodInfo", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDyPayConfirmAdapterListener {
        void onClickBindCard(PaymentMethodInfo r100);

        void onClickCardTypeItem(PaymentMethodInfo r100);

        void onClickCreditPayVoucherItem(PaymentMethodInfo r100);

        void onClickIconTips(IconTips r100);

        void onSelectDetail(PaymentMethodInfo r100);

        void onSelectPaymentMethodInfo(PaymentMethodInfo r100);
    }

    static {
        Companion = new Companion(null);
    }

    public final void hideBannerLoading() {
        isBannerLoading = false;
        notifyDataSetChanged();
    }

    public final void hideDyPayAddNewCardLoading() {
        isDyPayAddNewCardLoading = false;
        notifyDataSetChanged();
    }

    public final void hideLoading() {
        isLoading = false;
        notifyDataSetChanged();
    }

    public final void hideWxBankCardLoading() {
        isWxBankCardLoading = false;
        notifyDataSetChanged();
    }

    public final void showBannerLoading() {
        isBannerLoading = true;
        notifyDataSetChanged();
    }

    public final void showDyPayAddNewCardLoading() {
        isDyPayAddNewCardLoading = true;
        notifyDataSetChanged();
    }

    public final void showLoading() {
        isLoading = true;
        notifyDataSetChanged();
    }

    public final void showWxBankCardLoading() {
        isWxBankCardLoading = true;
        notifyDataSetChanged();
    }

    private final int getBusinessFooterPosition() {
        ConfirmAdapterProxy r100 = this.confirmAdapter;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getItemCount();
    }

    private final boolean hasBusinessFooter() {
        if (this.businessDesc.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void clearAdapterShowNum() {
        ConfirmAdapterProxy r100 = this.confirmAdapter;
        if (r100 == null) goto L5;
        r100.clearAdapterShowNum();
    L5:
        notifyDataSetChanged();
    }

    public final ArrayList<PaymentMethodInfo> getAdapterData() {
        ConfirmAdapterProxy r100 = this.confirmAdapter;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getData();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ConfirmAdapterProxy r100 = this.confirmAdapter;
        if (r100 == null) goto L5;
        int r101 = r100.getItemCount();
    L7:
        return r101 + (hasBusinessFooter() ? 1 : 0);
    L5:
        r101 = 0;
        goto L7
    }

    public final boolean isConfirmListCollapsed() {
        ConfirmAdapterProxy r100 = this.confirmAdapter;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isCanCollapse() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final /* synthetic */ boolean access$isBannerLoading$cp() {
        return isBannerLoading;
    }

    public static final /* synthetic */ boolean access$isDyPayAddNewCardLoading$cp() {
        return isDyPayAddNewCardLoading;
    }

    public static final /* synthetic */ boolean access$isLoading$cp() {
        return isLoading;
    }

    public static final /* synthetic */ boolean access$isWxBankCardLoading$cp() {
        return isWxBankCardLoading;
    }

    public final Context getContext() {
        return this.context;
    }

    public final OnConfirmAdapterListener getOnConfirmAdapterListener() {
        return this.onConfirmAdapterListener;
    }

    public final OnConfirmBannerAdapterListener getOnConfirmBannerAdapterListener() {
        return this.onConfirmBannerAdapterListener;
    }

    public final OnDyPayConfirmAdapterListener getOnDyPayConfirmAdapterListener() {
        return this.onDyPayConfirmAdapterListener;
    }

    public final int getShowNum() {
        return this.showNum;
    }

    public static final /* synthetic */ void access$setBannerLoading$cp(boolean r100) {
        isBannerLoading = r100;
    }

    public static final /* synthetic */ void access$setDyPayAddNewCardLoading$cp(boolean r100) {
        isDyPayAddNewCardLoading = r100;
    }

    public static final /* synthetic */ void access$setLoading$cp(boolean r100) {
        isLoading = r100;
    }

    public static final /* synthetic */ void access$setWxBankCardLoading$cp(boolean r100) {
        isWxBankCardLoading = r100;
    }

    private final boolean isBusinessFooterPosition(int r100) {
        if (hasBusinessFooter() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100 != getBusinessFooterPosition()) goto L7;
        return true;
    }

    public final void dataChangedNotify(ArrayList<PaymentMethodInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ConfirmAdapterProxy r101 = this.confirmAdapter;
        if (r101 == null) goto L5;
        r101.dataChangedNotify(r100);
    L5:
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        if (isBusinessFooterPosition(r100) == false) goto L6;
        return VIEW_TYPE_BUSINESS;
    L6:
        ConfirmAdapterProxy r101 = this.confirmAdapter;
        if (r101 != null) goto L11;
        return 0;
    L11:
        return r101.getItemViewType(r100);
    }

    public final void setBusinessFooter(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (Intrinsics.areEqual(r100, this.businessDesc) == false) goto L7;
        return;
    L7:
        boolean r101 = hasBusinessFooter();
        int r102 = getBusinessFooterPosition();
        this.businessDesc = r100;
        boolean r103 = hasBusinessFooter();
        if (r101 == true) goto L11;
        if (r103 == false) goto L11;
        notifyItemInserted(r102);
        return;
    L11:
        if (r101 == false) goto L14;
        if (r103 == true) goto L14;
        notifyItemRemoved(r102);
        return;
    L14:
        if (r101 == false) goto L19;
        notifyItemChanged(r102);
        return;
    }

    public final void setOnConfirmAdapterListener(OnConfirmAdapterListener r100) {
        this.onConfirmAdapterListener = r100;
    }

    public final void setOnConfirmBannerAdapterListener(OnConfirmBannerAdapterListener r100) {
        this.onConfirmBannerAdapterListener = r100;
    }

    public final void setOnDyPayConfirmAdapterListener(OnDyPayConfirmAdapterListener r100) {
        this.onDyPayConfirmAdapterListener = r100;
    }

    public final void setShowNum(int r100) {
        this.showNum = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof BusinessViewHolder) == false) goto L6;
        ((BusinessViewHolder) r100).bind(this.businessDesc);
        return;
    L6:
        ConfirmAdapterProxy r102 = this.confirmAdapter;
        if (r102 == null) goto L10;
        r102.onBindViewHolder(r100, r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == VIEW_TYPE_BUSINESS) goto L5;
        ConfirmAdapterProxy r102 = this.confirmAdapter;
        if (r102 == null) goto L9;
        RecyclerView.ViewHolder r103 = r102.onCreateViewHolder(r100, r101);
    L11:
        if ((r103 instanceof BaseViewHolder) == false) goto L13;
        BaseViewHolder r104 = (BaseViewHolder) r103;
        r104.setOnConfirmAdapterListener(this.onConfirmAdapterListener);
        r104.setOnDyPayConfirmAdapterListener(this.onDyPayConfirmAdapterListener);
        r104.setOnConfirmBannerAdapterListener(this.onConfirmBannerAdapterListener);
    L13:
        if (r103 == null) goto L15;
        return r103;
    L15:
        return new SingleTypeViewHolder(this.inflate.inflate(R.layout.cj_pay_item_confirm_single_type_layout, r100, false));
    L9:
        r103 = null;
        goto L11
    L5:
        return new BusinessViewHolder(new CJBusinessFooterView(r100.getContext(), null, 0, 6, null));
    }

    public CJPayConfirmAdapter(Context r100, int r101, int r102) {
        this.context = r100;
        this.type = r101;
        this.showNum = r102;
        this.businessDesc = "";
        ConfirmAdapterProxy r103 = IntegratedFactory.Companion.getConfirmAdapter(r100, r101);
        this.confirmAdapter = r103;
        if (r103 == null) goto L6;
        r103.setShowNum(this.showNum);
    L6:
        isWxBankCardLoading = false;
        isDyPayAddNewCardLoading = false;
        this.inflate = LayoutInflater.from(r100);
    }
}
