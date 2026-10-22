package com.android.ttcjpaysdk.bindcard.base.ui.wrapper.confirm;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.ImageView;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayFontUtils;
import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.thirdparty.view.TypefaceTextSpan;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001-B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010*\u001a\u00020\bH\u0002J\u000e\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0014R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\bX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/confirm/BindCardConfirmBaseWrapper;", "", "contentView", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "(Landroid/view/View;Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "closeIcon", "Landroid/widget/ImageView;", "confirmBtn", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCustomButton;", "getContentView", "()Landroid/view/View;", "listener", "Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/confirm/BindCardConfirmBaseWrapper$SecondConfirmWrapperListener;", "secondConfirmInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo;", "getSecondConfirmInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo;", "setSecondConfirmInfo", "(Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo;)V", "style", "getStyle", "setStyle", "(Ljava/lang/String;)V", "bindViews", "", "confirmInfo", "getCustomLogParams", "Lorg/json/JSONObject;", "getHalfRootView", "setBackgroundColor", "color", "", "setConfirmButtonText", "confirmButton", "text", "setConfirmListener", "confirmListener", "SecondConfirmWrapperListener", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BindCardConfirmBaseWrapper {
    private final String TAG;
    private final Activity activity;
    private ImageView closeIcon;
    private CJPayCustomButton confirmBtn;
    private final View contentView;
    private SecondConfirmWrapperListener listener;
    private CJPayNoPwdPayInfo secondConfirmInfo;
    private String style;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/ui/wrapper/confirm/BindCardConfirmBaseWrapper$SecondConfirmWrapperListener;", "", "dismiss", "", "onClose", "onConfirm", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SecondConfirmWrapperListener {
        void dismiss();

        void onClose();

        void onConfirm();
    }

    public View getHalfRootView() {
        return null;
    }

    public void setBackgroundColor(int r100) {
    }

    public JSONObject getCustomLogParams() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, BindCardPayConfirmConstants.Key.POP_STYLE, getStyle());
        return r100;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final CJPayNoPwdPayInfo getSecondConfirmInfo() {
        return this.secondConfirmInfo;
    }

    public String getStyle() {
        return this.style;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public static final /* synthetic */ CJPayCustomButton access$getConfirmBtn$p(BindCardConfirmBaseWrapper r100) {
        return r100.confirmBtn;
    }

    public static final /* synthetic */ SecondConfirmWrapperListener access$getListener$p(BindCardConfirmBaseWrapper r100) {
        return r100.listener;
    }

    public void bindViews(CJPayNoPwdPayInfo r100) {
        this.secondConfirmInfo = r100;
        CJPayCustomButton r101 = this.confirmBtn;
        if (r100 == null) goto L6;
        String r102 = r100.button_text;
        if (r102 == null) goto L6;
    L7:
        setConfirmButtonText(r101, r102);
        return;
    L6:
        r102 = "";
        goto L7
    }

    public final void setConfirmListener(SecondConfirmWrapperListener r100) {
        Intrinsics.checkNotNullParameter(r100, "confirmListener");
        this.listener = r100;
    }

    public final void setSecondConfirmInfo(CJPayNoPwdPayInfo r100) {
        this.secondConfirmInfo = r100;
    }

    public void setStyle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.style = r100;
    }

    public BindCardConfirmBaseWrapper(View r100, Activity r101) {
        this.contentView = r100;
        this.activity = r101;
        this.TAG = "BindCardConfirmBaseWrapper";
        this.style = "";
        ImageView r102 = null;
        if (r100 == null) goto L5;
        CJPayCustomButton r103 = (CJPayCustomButton) r100.findViewById(R.id.confirm_btn);
    L6:
        this.confirmBtn = r103;
        if (r100 == null) goto L9;
        r102 = (ImageView) r100.findViewById(R.id.close_icon);
    L9:
        this.closeIcon = r102;
        if (r102 == null) goto L12;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r102, new AnonymousClass1(this));
    L12:
        CJPayCustomButton r104 = this.confirmBtn;
        if (r104 == null) goto L16;
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r104, new AnonymousClass2(this));
        return;
    L16:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final /* synthetic */ void access$setListener$p(BindCardConfirmBaseWrapper r100, SecondConfirmWrapperListener r101) {
        r100.listener = r101;
    }

    private final void setConfirmButtonText(CJPayCustomButton r110, String r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        int r100 = r111.length();
        int r101 = 0;
    L5:
        int r102 = -1;
        if (r101 >= r100) goto L14;
        if ('$' != r111.charAt(r101)) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L15;
        r101 = r101 + 1;
    L15:
        int r104 = r111.length() - 1;
        if (r104 < 0) goto L26;
    L17:
        int r105 = r104 - 1;
        if ('$' != r111.charAt(r104)) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == true) goto L22;
        if (r105 < 0) goto L26;
        r104 = r105;
        goto L17
    L22:
        r102 = r104;
        goto L26
    L20:
        r106 = false;
    L26:
        if (r101 < 0) goto L35;
        if (r102 < 0) goto L35;
        if (r101 >= r102) goto L35;
        SpannableStringBuilder r107 = new SpannableStringBuilder(StringsKt.replace$default(r111, "$", "", false, 4, null));
        if (Intrinsics.areEqual(CJEnv.e(), "1128") == false) goto L33;
        r107.setSpan(new TypefaceTextSpan(CJPayFontUtils.getTypefaceDouYinMedium(CJPayHostInfo.applicationContext), CJPayBasicUtils.dipToPX(CJPayBasicExtensionKt.getContext(), 16.0f), CJPayBasicUtils.dipToPX(CJPayBasicExtensionKt.getContext(), 2.0f)), r101, r102 - 1, 33);
    L33:
        r110.setText(r107);
        return;
    L35:
        r110.setText(r111);
        return;
    L10:
        r103 = false;
        goto L11
    L14:
        r101 = -1;
        goto L15
    }
}
