package com.android.ttcjpaysdk.base.service;

import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0015Js\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072Q\u0010\b\u001aM\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012.\u0012,\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00110\t2\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayAgreementDialogService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getAgreementDialog", "Landroidx/fragment/app/DialogFragment;", "numberOfAgreements", "", "isAuth", "", "setAgreementView", "Lkotlin/Function2;", "Landroid/widget/TextView;", "Lkotlin/ParameterName;", "name", "view", "Lkotlin/Function1;", "", "agreementName", "", "action", "btnAction", "Lcom/android/ttcjpaysdk/base/service/ICJPayAgreementDialogService$IBtnAction;", "IBtnAction", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayAgreementDialogService extends ICJPayService {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayAgreementDialogService$IBtnAction;", "", "agree", "", "dialog", "Landroidx/fragment/app/DialogFragment;", "disagree", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IBtnAction {
        void agree(DialogFragment r100);

        void disagree(DialogFragment r100);
    }

    DialogFragment getAgreementDialog(int r100, boolean r101, Function2<? super TextView, ? super Function1<? super String, Unit>, Unit> r102, IBtnAction r103);
}
