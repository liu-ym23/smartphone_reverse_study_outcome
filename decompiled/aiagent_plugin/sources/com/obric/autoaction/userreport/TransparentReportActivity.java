package com.obric.autoaction.userreport;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.core.view.ai;
import com.obric.oui.sheet.OInsetSheet;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: TransparentReportActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TransparentReportActivity extends GeneratePluginActivity {
    private a reportController;

    public static /* synthetic */ x lambda$GA5pstVpb6UYzRVRKLG4Ck3tiGg(TransparentReportActivity r0) {
        return onCreate$lambda$0(r0);
    }

    public static /* synthetic */ x lambda$HMYOXUWu9fFtIwGfCe5UFEettiY(TransparentReportActivity r0, boolean r1) {
        return onCreate$lambda$1(r0, r1);
    }

    public static /* synthetic */ void lambda$qkqyAVr0z_jPhLucacBCFtVAraM(TransparentReportActivity r0, DialogInterface r1) {
        onCreate$lambda$2(r0, r1);
    }

    public String getPluginPkgName() {
        return "com.obric.aiagent.plugin";
    }

    public TransparentReportActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r3) {
        super/*android.app.Activity*/.onCreate(r3);
        ai.a(getWindow(), false);
        getWindow().setStatusBarColor(0);
        this.reportController = new a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        a.C0604a r4 = b.f25172a.c();
        if (r4 == null) goto L7;
        a r0 = this.reportController;
        if (r0 == null) goto L7;
        r0.a(r4);
    L7:
        a r5 = this.reportController;
        if (r5 == null) goto L10;
        r5.a(new $$Lambda$TransparentReportActivity$GA5pstVpb6UYzRVRKLG4Ck3tiGg(this), new $$Lambda$TransparentReportActivity$HMYOXUWu9fFtIwGfCe5UFEettiY(this));
    L10:
        a r6 = this.reportController;
        if (r6 == null) goto L15;
        OInsetSheet r7 = r6.b();
        if (r7 == null) goto L15;
        r7.setOnDismissListener(new $$Lambda$TransparentReportActivity$qkqyAVr0z_jPhLucacBCFtVAraM(this));
    L15:
        b.f25172a.d();
    }

    private static final x onCreate$lambda$0(TransparentReportActivity r2) {
        TransparentReportActivity r3 = (TransparentReportActivity) ZeusTransformUtils.wrapperContextForParams(r2, TransparentReportActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r0 = b.f25172a.a();
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        r3.finish();
        return x.f38692a;
    }

    private static final x onCreate$lambda$1(TransparentReportActivity r2, boolean r3) {
        TransparentReportActivity r4 = (TransparentReportActivity) ZeusTransformUtils.wrapperContextForParams(r2, TransparentReportActivity.class, "com.obric.aiagent.plugin");
        d.h.a.b<Boolean, x> r0 = b.f25172a.b();
        if (r0 == null) goto L5;
        r0.invoke(Boolean.valueOf(r3));
    L5:
        r4.finish();
        return x.f38692a;
    }

    private static final void onCreate$lambda$2(TransparentReportActivity r2, DialogInterface r3) {
        TransparentReportActivity r4 = (TransparentReportActivity) ZeusTransformUtils.wrapperContextForParams(r2, TransparentReportActivity.class, "com.obric.aiagent.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        if (r4.isFinishing() == true) goto L6;
        r4.finish();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super/*android.app.Activity*/.onPause();
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Activity*/.onDestroy();
        a r0 = this.reportController;
        if (r0 == null) goto L7;
        OInsetSheet r1 = r0.b();
        if (r1 == null) goto L7;
        r1.dismiss();
    L7:
        a r2 = this.reportController;
        if (r2 == null) goto L13;
        OInsetSheet r3 = r2.b();
        if (r3 == null) goto L14;
        r3.setOnDismissListener(null);
        return;
    L14:
        return;
    }
}
