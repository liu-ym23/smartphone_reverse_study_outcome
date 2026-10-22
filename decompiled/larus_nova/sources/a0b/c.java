package a0b;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends PermissionPurposeWindowPermissionResult {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.utils.h.e f1338b;

    public c(com.ss.android.lark.utils.h.e r100) {
        this.f1338b = r100;
    }

    @Override // com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult, com.ss.android.lark.permission.StoragePermissionUtils.a
    public final void b(StoragePermissionUtils.c r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        boolean r101 = r100.f438547d;
        if (r101 == true) goto L5;
        Log.w("LarkCameraChecker", "failed to open camera: no storage permission");
    L5:
        this.f1338b.a(r101);
    }
}
