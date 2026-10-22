package com.android.ttcjpaysdk.thirdparty.data;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.utils.CJPayScreenUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPaySwitchAccountPanelModel;", "", "curUserAvatar", "", "curUserName", "merchantLogoUrl", "voucherTitle", "voucherDesc", "subTitle", "targetAccountAvatar", "targetAccountName", "targetAccountPhoneNumber", "buttonTittle", "logger", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPaySwitchAccountPanelLogger;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/data/CJPaySwitchAccountPanelLogger;)V", "getButtonTittle", "()Ljava/lang/String;", "getCurUserAvatar", "getCurUserName", "getLogger", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPaySwitchAccountPanelLogger;", "getMerchantLogoUrl", "getSubTitle", "getTargetAccountAvatar", "getTargetAccountName", "getTargetAccountPhoneNumber", "getVoucherDesc", "getVoucherTitle", "buildVoucherTitleLable", "Landroid/text/SpannableStringBuilder;", "textView", "Landroid/widget/TextView;", "willTextWrap", "", "text", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySwitchAccountPanelModel {
    private final String buttonTittle;
    private final String curUserAvatar;
    private final String curUserName;
    private final CJPaySwitchAccountPanelLogger logger;
    private final String merchantLogoUrl;
    private final String subTitle;
    private final String targetAccountAvatar;
    private final String targetAccountName;
    private final String targetAccountPhoneNumber;
    private final String voucherDesc;
    private final String voucherTitle;

    public final String getButtonTittle() {
        return this.buttonTittle;
    }

    public final String getCurUserAvatar() {
        return this.curUserAvatar;
    }

    public final String getCurUserName() {
        return this.curUserName;
    }

    public final CJPaySwitchAccountPanelLogger getLogger() {
        return this.logger;
    }

    public final String getMerchantLogoUrl() {
        return this.merchantLogoUrl;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTargetAccountAvatar() {
        return this.targetAccountAvatar;
    }

    public final String getTargetAccountName() {
        return this.targetAccountName;
    }

    public final String getTargetAccountPhoneNumber() {
        return this.targetAccountPhoneNumber;
    }

    public final String getVoucherDesc() {
        return this.voucherDesc;
    }

    public final String getVoucherTitle() {
        return this.voucherTitle;
    }

    public final SpannableStringBuilder buildVoucherTitleLable(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        boolean r102 = willTextWrap(this.voucherTitle + ' ' + this.voucherDesc, r100);
        StringBuilder r103 = new StringBuilder();
        r103.append(this.voucherTitle);
        r103.append(' ');
        SpannableString r104 = new SpannableString(r103.toString());
        if (r102 == false) goto L5;
        r104 = new SpannableString(this.voucherTitle + '\n');
    L5:
        r101.append(r104);
        SpannableString r105 = new SpannableString(this.voucherDesc);
        r105.setSpan(new ForegroundColorSpan(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED)), 0, r105.length(), 33);
        r101.append(r105);
        return r101;
    }

    private final boolean willTextWrap(String r100, TextView r101) {
        TextPaint r102 = r101.getPaint();
        if (r102.measureText(r100) <= (CJPayScreenUtils.INSTANCE.getScreenWidth(r101.getContext()) - 42)) goto L5;
        return true;
    L5:
        return false;
    }

    public CJPaySwitchAccountPanelModel(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, CJPaySwitchAccountPanelLogger r112) {
        Intrinsics.checkNotNullParameter(r100, "curUserAvatar");
        Intrinsics.checkNotNullParameter(r101, "curUserName");
        Intrinsics.checkNotNullParameter(r102, "merchantLogoUrl");
        Intrinsics.checkNotNullParameter(r103, "voucherTitle");
        Intrinsics.checkNotNullParameter(r104, "voucherDesc");
        Intrinsics.checkNotNullParameter(r105, "subTitle");
        Intrinsics.checkNotNullParameter(r106, "targetAccountAvatar");
        Intrinsics.checkNotNullParameter(r107, "targetAccountName");
        Intrinsics.checkNotNullParameter(r110, "targetAccountPhoneNumber");
        Intrinsics.checkNotNullParameter(r111, "buttonTittle");
        Intrinsics.checkNotNullParameter(r112, "logger");
        this.curUserAvatar = r100;
        this.curUserName = r101;
        this.merchantLogoUrl = r102;
        this.voucherTitle = r103;
        this.voucherDesc = r104;
        this.subTitle = r105;
        this.targetAccountAvatar = r106;
        this.targetAccountName = r107;
        this.targetAccountPhoneNumber = r110;
        this.buttonTittle = r111;
        this.logger = r112;
    }
}
