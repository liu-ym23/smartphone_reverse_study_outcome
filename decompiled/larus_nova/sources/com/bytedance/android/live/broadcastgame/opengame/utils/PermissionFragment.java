package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.app.Fragment;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/utils/PermissionFragment;", "Landroid/app/Fragment;", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PermissionFragment extends Fragment {
    public PermissionFragment() {
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        String[] r101 = getArguments().getStringArray(ComplianceResult.JsonKey.PERMISSIONS);
        if (r101 == null) goto L6;
        requestPermissions(r101, 1);
        return;
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        Intrinsics.checkNotNullParameter(r211, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r212, "grantResults");
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r210), r211, r212};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102612);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r104 = 0;
    L8:
        if (r104 >= r112) goto L15;
        f06.a r105 = r111[r104];
        int r113 = r104;
        int r114 = r112;
        f06.a[] r115 = r111;
        f06.d r106 = r105.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r101, "void", r110);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r210, r211, r212);
    L20:
        getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        return;
    L14:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
