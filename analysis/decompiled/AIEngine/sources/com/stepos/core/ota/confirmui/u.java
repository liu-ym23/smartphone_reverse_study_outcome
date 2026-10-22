package com.stepos.core.ota.confirmui;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7531a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OtaConfirmDialogPresenter f7532b;

    public /* synthetic */ u(OtaConfirmDialogPresenter otaConfirmDialogPresenter, int i10) {
        this.f7531a = i10;
        this.f7532b = otaConfirmDialogPresenter;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f7531a;
        OtaConfirmDialogPresenter otaConfirmDialogPresenter = this.f7532b;
        switch (i10) {
            case 0:
                return OtaConfirmDialogPresenter.start$lambda$1(otaConfirmDialogPresenter);
            case 1:
                return OtaConfirmDialogPresenter.showWifiGuide$lambda$22(otaConfirmDialogPresenter);
            case 2:
                return OtaConfirmDialogPresenter.showUnavailable$lambda$27(otaConfirmDialogPresenter);
            case 3:
                return OtaConfirmDialogPresenter.showServiceGuide$lambda$28(otaConfirmDialogPresenter);
            case 4:
                return OtaConfirmDialogPresenter.showResumeCellular$lambda$12(otaConfirmDialogPresenter);
            case 5:
                return OtaConfirmDialogPresenter.showCellularReminder$lambda$8(otaConfirmDialogPresenter);
            case 6:
                return OtaConfirmDialogPresenter.showCellularUpdate$lambda$24(otaConfirmDialogPresenter);
            case 7:
                return OtaConfirmDialogPresenter.showCellularUpdate$lambda$26(otaConfirmDialogPresenter);
            case 8:
                return OtaConfirmDialogPresenter.showSwitchCellularDownload$lambda$15(otaConfirmDialogPresenter);
            case 9:
                return OtaConfirmDialogPresenter.showResumeConfirm$lambda$11(otaConfirmDialogPresenter);
            case 10:
                return OtaConfirmDialogPresenter.showSwitchCellularUpdate$lambda$17(otaConfirmDialogPresenter);
            default:
                return OtaConfirmDialogPresenter.showNoNetworkGuide$lambda$6(otaConfirmDialogPresenter);
        }
    }
}
