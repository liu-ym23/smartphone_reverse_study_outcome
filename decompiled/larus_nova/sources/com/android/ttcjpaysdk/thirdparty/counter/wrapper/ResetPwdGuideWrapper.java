package com.android.ttcjpaysdk.thirdparty.counter.wrapper;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.imageloader.ImageLoader;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.android.ttcjpaysdk.base.ui.data.CJPayResultGuideInfo;
import com.android.ttcjpaysdk.thirdparty.counter.data.CJPayCounterTradeQueryResponseBean;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/wrapper/ResetPwdGuideWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "actionListener", "Lcom/android/ttcjpaysdk/thirdparty/counter/wrapper/ResetPwdGuideWrapper$ResetPwdOnClickListener;", "anotherVerifyType", "Landroid/widget/TextView;", "btnText", "contentTextView", "progressLoading", "Landroid/widget/ProgressBar;", "singleBtn", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCustomButton;", "titleBarIcon", "Landroid/widget/ImageView;", "titleBarText", "titleTextView", "initActions", "", "initWrapper", "responseBean", "Lcom/android/ttcjpaysdk/thirdparty/counter/data/CJPayCounterTradeQueryResponseBean;", "setActionListener", "listener", "setConfirmBtnLoading", "isShowLoading", "", "ResetPwdOnClickListener", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResetPwdGuideWrapper extends BaseWrapper {
    private final String TAG;
    private ResetPwdOnClickListener actionListener;
    private final TextView anotherVerifyType;
    private String btnText;
    private final TextView contentTextView;
    private ProgressBar progressLoading;
    private final CJPayCustomButton singleBtn;
    private final ImageView titleBarIcon;
    private final TextView titleBarText;
    private final TextView titleTextView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/wrapper/ResetPwdGuideWrapper$ResetPwdOnClickListener;", "", "onCancel", "", "onConfirm", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ResetPwdOnClickListener {
        void onCancel();

        void onConfirm();
    }

    public final void initActions() {
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.singleBtn, new AnonymousClass1(this));
        CJPayViewExtensionsKt.setDebouncingOnClickListener(this.anotherVerifyType, new AnonymousClass2(this));
    }

    public ResetPwdGuideWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.TAG = "ResetPwdGuideWrapper";
        this.titleBarIcon = (ImageView) r100.findViewById(R.id.iv_title_icon);
        this.titleBarText = (TextView) r100.findViewById(R.id.tv_title_text);
        this.titleTextView = (TextView) r100.findViewById(R.id.keep_dialog_title);
        this.contentTextView = (TextView) r100.findViewById(R.id.keep_dialog_text);
        this.singleBtn = (CJPayCustomButton) r100.findViewById(R.id.keep_dialog_btn);
        this.anotherVerifyType = (TextView) r100.findViewById(R.id.keep_dialog_another_verify_type);
        this.progressLoading = (ProgressBar) r100.findViewById(R.id.keep_dialog_btn_loading);
        this.btnText = "";
    }

    public static final /* synthetic */ ResetPwdOnClickListener access$getActionListener$p(ResetPwdGuideWrapper r100) {
        return r100.actionListener;
    }

    public static final /* synthetic */ String access$getTAG$p(ResetPwdGuideWrapper r100) {
        return r100.TAG;
    }

    public static final /* synthetic */ ImageView access$getTitleBarIcon$p(ResetPwdGuideWrapper r100) {
        return r100.titleBarIcon;
    }

    public final void initWrapper(CJPayCounterTradeQueryResponseBean r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        CJPayResultGuideInfo r101 = r100.result_guide_info;
        TextView r102 = this.titleBarText;
        if (r102 == null) goto L8;
        r102.setText(r101.header_desc);
    L8:
        TextView r103 = this.titleTextView;
        if (r103 == null) goto L12;
        r103.setText(r101.title);
    L12:
        TextView r104 = this.contentTextView;
        if (r104 == null) goto L16;
        r104.setText(r101.sub_title);
    L16:
        CJPayCustomButton r105 = this.singleBtn;
        if (r105 == null) goto L20;
        r105.setText(r101.confirm_btn_desc);
    L20:
        this.btnText = r101.confirm_btn_desc;
        TextView r106 = this.anotherVerifyType;
        if (r106 == null) goto L24;
        r106.setText(r101.cancel_btn_desc);
    L24:
        ImageLoader.Companion.getInstance().loadImage(r101.pic_url, new ResetPwdGuideWrapper$initWrapper$1$1(this));
        initActions();
    }

    public final void setActionListener(ResetPwdOnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.actionListener = r100;
    }

    public final void setConfirmBtnLoading(boolean r100) {
        if (r100 == false) goto L15;
        ProgressBar r101 = this.progressLoading;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        CJPayCustomButton r102 = this.singleBtn;
        if (r102 == null) goto L11;
        r102.setText("");
    L11:
        CJPayCustomButton r103 = this.singleBtn;
        if (r103 == null) goto L29;
        r103.setClickable(false);
        return;
    L29:
        return;
    L15:
        ProgressBar r104 = this.progressLoading;
        if (r104 == null) goto L19;
        r104.setVisibility(8);
    L19:
        CJPayCustomButton r105 = this.singleBtn;
        if (r105 == null) goto L23;
        r105.setText(this.btnText);
    L23:
        CJPayCustomButton r106 = this.singleBtn;
        if (r106 == null) goto L30;
        r106.setClickable(true);
        return;
    }
}
