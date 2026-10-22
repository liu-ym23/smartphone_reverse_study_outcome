package com.bytedance.android.ec.window.base.shop;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ec.core.utils.l0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/ECStoreBottomDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreBottomDialog extends AppCompatDialog {
    public ECStoreBottomDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ECStoreBottomDialogStyle);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        l0.d(r101);
    L6:
        Window r102 = getWindow();
        if (r102 == null) goto L11;
        Intrinsics.checkNotNullParameter(r102, "$this$makeSizeFullScreen");
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.width = -1;
        r103.height = -1;
        r102.setAttributes(r103);
        View r104 = l0.a(r102);
        r104.setPadding(0, 0, 0, 0);
        r104.setSystemUiVisibility(r104.getSystemUiVisibility() | 1280);
        r102.setGravity(80);
        return;
    }
}
