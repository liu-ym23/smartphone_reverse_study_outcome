package com.android.ttcjpaysdk.thirdparty.verify.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import com.android.ttcjpaysdk.base.utils.html.utils.UIComponentSpannableParser;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0002 !B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nJ6\u0010\u001a\u001a\u00020\u00142\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u001f\u001a\u00020\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/RecommendView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lcom/android/ttcjpaysdk/thirdparty/verify/view/RecommendView$OnClickListener;", "contentView", "Landroid/view/View;", "ivPayIcon", "Landroid/widget/ImageView;", "tvRecommend", "Landroid/widget/TextView;", "tvUse", "tvVoucherMsg", "bindVoucherMsg", "", "voucherMsgInfo", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "hasVoucherMsg", "", "setClickListener", "setData", "icon", "", "msg", "buttonLabel", "viewVisible", "Companion", "OnClickListener", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecommendView extends LinearLayout {
    public static final Companion Companion = null;
    private static final String TAG = "RecommendView";
    private OnClickListener clickListener;
    private View contentView;
    private ImageView ivPayIcon;
    private TextView tvRecommend;
    private TextView tvUse;
    private TextView tvVoucherMsg;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/RecommendView$Companion;", "", "()V", "TAG", "", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/RecommendView$OnClickListener;", "", "onVisibie", "", "text", "", "onclick", "buttonName", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnClickListener {
        void onVisibie(String r100);

        void onclick(String r100);
    }

    static {
        Companion = new Companion(null);
    }

    public RecommendView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public RecommendView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final void viewVisible() {
        setVisibility(0);
        View r100 = this.contentView;
        if (r100 == null) goto L5;
        CJPayViewExtensionsKt.viewVisible(r100);
    L5:
        OnClickListener r101 = this.clickListener;
        if (r101 == null) goto L13;
        TextView r102 = this.tvRecommend;
        if (r102 == null) goto L10;
        CharSequence r103 = r102.getText();
    L11:
        r101.onVisibie(String.valueOf(r103));
        return;
    L10:
        r103 = null;
        goto L11
    }

    public static final /* synthetic */ OnClickListener access$getClickListener$p(RecommendView r100) {
        return r100.clickListener;
    }

    private final void bindVoucherMsg(UIComponent r110) {
        TextView r100 = this.tvVoucherMsg;
        if (r100 != null) goto L6;
        return;
    L6:
        if (hasVoucherMsg(r110) == true) goto L9;
        CJPayViewExtensionsKt.viewGone(r100);
        return;
    L9:
        UIComponentSpannableParser r101 = UIComponentSpannableParser.INSTANCE;
        Intrinsics.checkNotNull(r110);
        r100.setText(UIComponentSpannableParser.convertComponentsToSpannable$default(r101, CollectionsKt.listOf(r110), getContext(), null, new WeakReference(r100), 4, null));
        CJPayViewExtensionsKt.viewVisible(r100);
    }

    private final boolean hasVoucherMsg(UIComponent r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.text;
    L7:
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L23;
        if (r100 == null) goto L16;
        r101 = r100.url;
    L16:
        if (r101 != null) goto L18;
    L21:
        boolean r104 = true;
    L22:
        if (r104 == false) goto L23;
        return false;
    L18:
        if (r101.length() == 0) goto L21;
        r104 = false;
    L23:
        return true;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    public final void setClickListener(OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        this.clickListener = r100;
    }

    public RecommendView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.cj_pay_view_pay_type_recommend_layout, this);
        this.contentView = r103;
        TextView r104 = null;
        if (r103 == null) goto L5;
        ImageView r105 = (ImageView) r103.findViewById(R.id.cj_pay_iv_pay_icon);
    L6:
        this.ivPayIcon = r105;
        View r106 = this.contentView;
        if (r106 == null) goto L9;
        TextView r107 = (TextView) r106.findViewById(R.id.cj_pay_tv_recommend);
    L10:
        this.tvRecommend = r107;
        View r108 = this.contentView;
        if (r108 == null) goto L13;
        TextView r109 = (TextView) r108.findViewById(R.id.cj_pay_tv_voucher_msg);
    L14:
        this.tvVoucherMsg = r109;
        View r110 = this.contentView;
        if (r110 == null) goto L17;
        r104 = (TextView) r110.findViewById(R.id.cj_pay_use);
    L17:
        this.tvUse = r104;
        return;
    L13:
        r109 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    public final void setData(String r100, String r101, final String r110, UIComponent r111) {
        boolean r102 = true;
        boolean r103 = !TextUtils.isEmpty(r100);
        ImageView r104 = this.ivPayIcon;
        if (r104 == null) goto L9;
        if (r103 == false) goto L6;
        final ImageView r105 = r104;
    L7:
        if (r105 == null) goto L9;
        final long r106 = System.currentTimeMillis();
        CJPayViewExtensionsKt.viewVisible(r105);
        ImageLoader.Companion.getInstance().loadImage(r100, new RecommendView$setData$2$1(r105, r106));
    L12:
        if (r101 != null) goto L14;
    L17:
        boolean r107 = true;
    L18:
        if (r107 == true) goto L26;
        TextView r108 = this.tvRecommend;
        if (r108 == null) goto L22;
        CJPayViewExtensionsKt.viewVisible(r108);
    L22:
        TextView r109 = this.tvRecommend;
        if (r109 == null) goto L29;
        r109.setText(r101);
    L29:
        bindVoucherMsg(r111);
        if (r110 != null) goto L32;
    L35:
        if (r102 == true) goto L46;
        TextView r112 = this.tvUse;
        if (r112 == null) goto L39;
        CJPayViewExtensionsKt.viewVisible(r112);
    L39:
        TextView r113 = this.tvUse;
        if (r113 == null) goto L43;
        r113.setText(r110);
    L43:
        TextView r114 = this.tvUse;
        if (r114 == null) goto L49;
        r114.setOnClickListener(new AnonymousClass3(this, r110));
    L49:
        CJLogger.a(TAG, "setData showIcon=" + r103 + " showVoucherMsg=" + hasVoucherMsg(r111));
        return;
    L46:
        TextView r115 = this.tvUse;
        if (r115 == null) goto L49;
        CJPayViewExtensionsKt.viewGone(r115);
        goto L49
    L32:
        if (r110.length() == 0) goto L35;
        r102 = false;
        goto L35
    L26:
        TextView r116 = this.tvRecommend;
        if (r116 == null) goto L29;
        CJPayViewExtensionsKt.viewGone(r116);
        goto L29
    L14:
        if (r101.length() == 0) goto L17;
        r107 = false;
        goto L18
    L6:
        r105 = null;
    L9:
        if (r104 == null) goto L12;
        CJPayViewExtensionsKt.viewGone(r104);
        goto L12
    }

    public /* synthetic */ RecommendView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void setData$default(RecommendView r100, String r101, String r102, String r103, UIComponent r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = "";
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = "";
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = "";
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = null;
    L14:
        r100.setData(r101, r102, r103, r104);
    }
}
