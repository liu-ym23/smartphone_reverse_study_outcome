package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: ConfirmDialogWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f23718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.h.a.a<x> f23722e;

    public static /* synthetic */ x lambda$3aYckt0sgXRs3ORx6H9rwyjw9m0(a r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$gt2Y4Bw0IRGtc-jfvWlYXbDcZ6s, reason: not valid java name */
    public static /* synthetic */ x m504lambda$gt2Y4Bw0IRGtcjfvWlYXbDcZ6s(DialogInterface r0, int r1) {
        return a(r0, r1);
    }

    public a(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r4, DBDefinition.TITLE);
        o.e(r5, "confirmText");
        this.f23718a = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f23719b = r4;
        this.f23720c = r5;
    }

    public final Context getContext() {
        return this.f23718a;
    }

    public final void a(String r1) {
        this.f23721d = r1;
    }

    public final void a(d.h.a.a<x> r3) {
        this.f23722e = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final void a() {
        com.obric.oui.dialog.v2.alert.a r0 = new com.obric.oui.dialog.v2.alert.a(this.f23718a);
        com.obric.oui.dialog.v2.alert.a.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast(this.f23719b, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null);
        r0.a(true);
        r0.a((CharSequence) ZeusTransformUtils.preCheckCast(this.f23720c, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$a$3aYckt0sgXRs3ORx6H9rwyjw9m0(this));
        r0.b((CharSequence) ZeusTransformUtils.preCheckCast(p.a(ZeusTransformUtils.mapRes(R.string.oui_cancel_only, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_cancel_only"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"), $$Lambda$a$gt2Y4Bw0IRGtcjfvWlYXbDcZ6s.INSTANCE);
        r0.b(true);
        ((OAlertDialog) ZeusTransformUtils.preCheckCast(r0.g(), OAlertDialog.class, "com.obric.aiagent.plugin")).show();
    }

    private static final x a(a r1, DialogInterface r2, int r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r4, "dialog");
        r4.dismiss();
        d.h.a.a<x> r5 = r1.f23722e;
        if (r5 == null) goto L6;
        r5.invoke();
    L6:
        return x.f38692a;
    }

    private static final x a(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r3, "dialog");
        r3.dismiss();
        return x.f38692a;
    }
}
