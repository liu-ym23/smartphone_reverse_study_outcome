package com.bytedance.android.gamecp.business.download.installstatus;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.android.gamecp.business.download.custommade.CustomInstallActivity;
import com.bytedance.android.gamecp.business.download.custommade.NewCustomInstallActivity;
import com.bytedance.android.gamecp.business.download.custommade.fragment.CustomInstallFailFragment;
import com.bytedance.android.gamecp.business.download.custommade.fragment.CustomInstallSuccessFragment;
import com.bytedance.android.gamecp.business.download.custommade.fragment.CustomInstallingFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f52788b;

    public j(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f52788b = r100;
        this.f52787a = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getPackageName();
    }

    @Override // com.bytedance.android.gamecp.business.download.installstatus.e
    public boolean a(a r100, StringBuilder r101, StringBuilder r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "checkInfo");
        Intrinsics.checkNotNullParameter(r101, "stepStayStack");
        Intrinsics.checkNotNullParameter(r102, "stepStayTime");
        if (Intrinsics.areEqual(r100.f52763a, this.f52787a) == false) goto L32;
        String r104 = r100.f52764b;
        if (Intrinsics.areEqual(r104, CustomInstallingFragment.class.getName()) == false) goto L9;
        this.f52788b.e(r101.toString(), r102.toString(), r103);
        return true;
    L9:
        if (Intrinsics.areEqual(r104, CustomInstallSuccessFragment.class.getName()) == false) goto L13;
        this.f52788b.d(r101.toString(), r102.toString(), r103);
        return true;
    L13:
        if (Intrinsics.areEqual(r104, CustomInstallFailFragment.class.getName()) == false) goto L34;
        Activity r105 = com.bytedance.android.gamecp.host_api.a.b().getHostAppService().getTopActivity();
        boolean r106 = r105 instanceof CustomInstallActivity;
        if (r106 == false) goto L17;
    L20:
        if (r106 == false) goto L23;
        Fragment r107 = ((CustomInstallActivity) r105).f52551e;
    L27:
        if ((r107 instanceof CustomInstallFailFragment) == false) goto L29;
        int r108 = ((CustomInstallFailFragment) r107).f52667m;
    L30:
        this.f52788b.c("fail install " + r108, r101.toString(), r102.toString(), r103);
        return true;
    L29:
        r108 = -11;
        goto L30
    L23:
        if ((r105 instanceof NewCustomInstallActivity) == false) goto L25;
        r107 = ((NewCustomInstallActivity) r105).f52591e;
        goto L27
    L25:
        r107 = null;
        goto L27
    L17:
        if ((r105 instanceof NewCustomInstallActivity) == true) goto L20;
        r108 = -12;
        goto L30
    L34:
        return false;
    L32:
        return false;
    }
}
