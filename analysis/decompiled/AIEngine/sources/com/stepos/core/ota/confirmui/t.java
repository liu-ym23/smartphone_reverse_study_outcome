package com.stepos.core.ota.confirmui;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7529a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OtaConfirmDialogPresenter f7530b;

    public /* synthetic */ t(OtaConfirmDialogPresenter otaConfirmDialogPresenter, int i10) {
        this.f7529a = i10;
        this.f7530b = otaConfirmDialogPresenter;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7529a;
        OtaConfirmDialogPresenter otaConfirmDialogPresenter = this.f7530b;
        switch (i10) {
            case 0:
                return OtaConfirmDialogPresenter.showNoNetworkGuide$lambda$7(otaConfirmDialogPresenter);
            case 1:
                return OtaConfirmDialogPresenter.start$lambda$2(otaConfirmDialogPresenter);
            case 2:
                return OtaConfirmDialogPresenter.showWifiGuide$lambda$21(otaConfirmDialogPresenter);
            case 3:
                return OtaConfirmDialogPresenter.showWifiGuide$lambda$23(otaConfirmDialogPresenter);
            case 4:
                return OtaConfirmDialogPresenter.showDownloadConfirm$lambda$5(otaConfirmDialogPresenter);
            case 5:
                return OtaConfirmDialogPresenter.showUpdateConfirm$lambda$19(otaConfirmDialogPresenter);
            case 6:
                return OtaConfirmDialogPresenter.showServiceGuide$lambda$29(otaConfirmDialogPresenter);
            case 7:
                return OtaConfirmDialogPresenter.showResumeCellular$lambda$13(otaConfirmDialogPresenter);
            case 8:
                return OtaConfirmDialogPresenter.showCellularReminder$lambda$9(otaConfirmDialogPresenter);
            case 9:
                return OtaConfirmDialogPresenter.showCellularUpdate$lambda$25(otaConfirmDialogPresenter);
            case 10:
                return OtaConfirmDialogPresenter.showSwitchCellularDownload$lambda$14(otaConfirmDialogPresenter);
            case 11:
                return OtaConfirmDialogPresenter.showResumeConfirm$lambda$10(otaConfirmDialogPresenter);
            case 12:
                return OtaConfirmDialogPresenter.showSwitchCellularUpdate$lambda$16(otaConfirmDialogPresenter);
            default:
                return OtaConfirmDialogPresenter.showResourceGate$lambda$37(otaConfirmDialogPresenter);
        }
    }
}
