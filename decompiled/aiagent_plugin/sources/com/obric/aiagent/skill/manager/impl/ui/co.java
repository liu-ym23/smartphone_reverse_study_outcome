package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.impl.en;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillUseSecurityGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class co {
    public static /* synthetic */ d.x lambda$3EUnBLyJyZP48tIgebBbOiInipY(DialogInterface r0, int r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$4-BHDlE5-egPcPmbOgcZaA2JAeY, reason: not valid java name */
    public static /* synthetic */ d.x m342lambda$4BHDlE5egPcPmbOgcZaA2JAeY(d.h.a.a r0, DialogInterface r1, int r2) {
        return a(r0, r1, r2);
    }

    public static final void a(FragmentActivity r4, com.obric.aiagent.skill.manager.api.e r5, d.h.a.a<d.x> r6) {
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r4, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        d.h.b.o.e(r8, "onAllowed");
        if (r5 == null) goto L5;
        com.obric.aiagent.skill.manager.api.aj r9 = r5.i();
    L6:
        boolean r0 = true;
        if (r9 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.aiagent.plugin"), cm.a.m);
        return;
    L14:
        if (r9 != null) goto L16;
    L18:
        r0 = false;
    L19:
        if (r0 == true) goto L21;
    L23:
        r8.invoke();
        return;
    L21:
        if (com.obric.aiagent.skill.manager.api.al.f19195a.a().B() == false) goto L23;
        a(r7, r8);
        return;
    L16:
        if (en.c(r9) != true) goto L18;
    L9:
        if (en.d(r9) != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r9 = null;
        goto L6
    }

    private static final void a(FragmentActivity r5, d.h.a.a<d.x> r6) {
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r5, FragmentActivity.class, "com.obric.aiagent.plugin");
        final d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        OAlertDialog r9 = new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(r7, Context.class, "com.obric.aiagent.plugin")).a(ZeusTransformUtils.mapRes(R.string.obric_skill_security_scanning_warning_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_security_scanning_warning_title")).b((CharSequence) ZeusTransformUtils.preCheckCast(r7.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_security_scanning_warning_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_security_scanning_warning_message")), CharSequence.class, "com.obric.aiagent.plugin")).a(false).b(ZeusTransformUtils.mapRes(R.string.obric_skill_security_scanning_warning_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_security_scanning_warning_cancel"), $$Lambda$co$3EUnBLyJyZP48tIgebBbOiInipY.INSTANCE).a(ZeusTransformUtils.mapRes(R.string.obric_skill_security_scanning_warning_confirm, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_security_scanning_warning_confirm"), new $$Lambda$co$4BHDlE5egPcPmbOgcZaA2JAeY(r8)).b(true).g();
        ((OAlertDialog) ZeusTransformUtils.preCheckCast(r9, OAlertDialog.class, "com.obric.aiagent.plugin")).setCanceledOnTouchOutside(true);
        ((OAlertDialog) ZeusTransformUtils.preCheckCast(r9, OAlertDialog.class, "com.obric.aiagent.plugin")).show();
    }

    private static final d.x a(DialogInterface r1, int r2) {
        d.h.b.o.e((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin"), "<unused var>");
        return d.x.f38692a;
    }

    private static final d.x a(d.h.a.a r1, DialogInterface r2, int r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin"), "<unused var>");
        r4.invoke();
        return d.x.f38692a;
    }
}
