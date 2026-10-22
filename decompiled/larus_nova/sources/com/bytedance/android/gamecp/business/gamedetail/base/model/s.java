package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.UserGameStats")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/s;", "", "", "userActiveStatus", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "userHistoryPkgStatus", "b", "isShouldInstallActivationPackage", "c", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s implements vh7.h {

    @SerializedName("is_should_install_activation_package")
    protected int isShouldInstallActivationPackage;

    @SerializedName("user_active_status")
    protected int userActiveStatus;

    @SerializedName("user_history_pkg_status")
    protected int userHistoryPkgStatus;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L12;
        s r101 = (s) r100;
        if (this.userActiveStatus == r101.userActiveStatus) goto L8;
        return false;
    L8:
        if (this.userHistoryPkgStatus == r101.userHistoryPkgStatus) goto L10;
        return false;
    L10:
        if (this.isShouldInstallActivationPackage == r101.isShouldInstallActivationPackage) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.userActiveStatus * 31) + this.userHistoryPkgStatus) * 31) + this.isShouldInstallActivationPackage;
    }

    public final String toString() {
        return "UserGameStats(userActiveStatus=" + this.userActiveStatus + ", userHistoryPkgStatus=" + this.userHistoryPkgStatus + ", isShouldInstallActivationPackage=" + this.isShouldInstallActivationPackage + ")";
    }

    public s() {
        this.userActiveStatus = 0;
        this.userHistoryPkgStatus = 0;
        this.isShouldInstallActivationPackage = 0;
    }

    public final int a() {
        return this.userActiveStatus;
    }

    public final int b() {
        return this.userHistoryPkgStatus;
    }

    public final int c() {
        return this.isShouldInstallActivationPackage;
    }

    public s(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        this.userActiveStatus = (int) r100.j();
        r102 = r102 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.userHistoryPkgStatus = (int) r100.j();
        r102 = r102 | 2;
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this.isShouldInstallActivationPackage = (int) r100.j();
        r102 = r102 | 4;
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L19;
        this.userActiveStatus = 0;
    L19:
        if ((r102 & 2) != 0) goto L22;
        this.userHistoryPkgStatus = 0;
    L22:
        if ((r102 & 4) != 0) goto L37;
        this.isShouldInstallActivationPackage = 0;
        return;
    }
}
