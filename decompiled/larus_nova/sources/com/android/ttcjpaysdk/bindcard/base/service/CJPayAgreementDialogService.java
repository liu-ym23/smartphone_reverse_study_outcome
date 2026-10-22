package com.android.ttcjpaysdk.bindcard.base.service;

import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.android.ttcjpaysdk.base.service.ICJPayAgreementDialogService;
import com.android.ttcjpaysdk.bindcard.base.BuildConfig;
import com.android.ttcjpaysdk.bindcard.base.applog.CJPayAgreementDialogLogger;
import com.android.ttcjpaysdk.bindcard.base.ui.CJPayAgreementDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Js\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2Q\u0010\t\u001aM\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012.\u0012,\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/service/CJPayAgreementDialogService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayAgreementDialogService;", "()V", "getAgreementDialog", "Landroidx/fragment/app/DialogFragment;", "numberOfAgreements", "", "isAuth", "", "setAgreementView", "Lkotlin/Function2;", "Landroid/widget/TextView;", "Lkotlin/ParameterName;", "name", "view", "Lkotlin/Function1;", "", "agreementName", "", "action", "btnAction", "Lcom/android/ttcjpaysdk/base/service/ICJPayAgreementDialogService$IBtnAction;", "getPackageName", "getScene", "Lcom/android/ttcjpaysdk/bindcard/base/ui/CJPayAgreementDialog$Scenes;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAgreementDialogService implements ICJPayAgreementDialogService {
    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    public CJPayAgreementDialogService() {
    }

    private final CJPayAgreementDialog.Scenes getScene(int r100, boolean r101) {
        if (r101 == false) goto L6;
        if (r100 <= 1) goto L6;
        return CJPayAgreementDialog.Scenes.TWO_AGREEMENTS_AUTH;
    L6:
        if (r101 == true) goto L10;
        if (r100 <= 1) goto L10;
        return CJPayAgreementDialog.Scenes.TWO_AGREEMENTS_CONTINUE;
    L10:
        return CJPayAgreementDialog.Scenes.AN_AGREEMENT;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayAgreementDialogService
    public DialogFragment getAgreementDialog(int r100, boolean r101, Function2<? super TextView, ? super Function1<? super String, Unit>, Unit> r102, final ICJPayAgreementDialogService.IBtnAction r103) {
        Intrinsics.checkNotNullParameter(r102, "setAgreementView");
        Intrinsics.checkNotNullParameter(r103, "btnAction");
        return CJPayAgreementDialog.Builder.setScene(getScene(r100, r101)).setAgreementSource(CJPayAgreementDialogLogger.AgreementSource.AUTH).build(r102, new AnonymousClass1(r103));
    }
}
