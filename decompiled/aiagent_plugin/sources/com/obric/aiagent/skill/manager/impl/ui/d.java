package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionSkillUi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final void a(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: lambda$1uKdO-1aQUHVwVQZZlkmzJaOb4o, reason: not valid java name */
    public static /* synthetic */ void m343lambda$1uKdO1aQUHVwVQZZlkmzJaOb4o(d.h.a.a r0, DialogInterface r1, int r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$iElakSz9QExJ5GBtx2W54dYJ0uc(DialogInterface r0, int r1) {
        a(r0, r1);
    }

    public static final void a(FragmentActivity r20, com.obric.aiagent.skill.manager.api.e r21, d.h.a.a<d.x> r22) {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r20, FragmentActivity.class, "com.obric.aiagent.plugin");
        final d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "<this>");
        d.h.b.o.e(r21, "skill");
        d.h.b.o.e(r2, "onConfirm");
        com.obric.oui.dialog.v2.alert.a r8 = com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(r0.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_app_function_disable_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_app_function_disable_title"), new Object[]{com.obric.aiagent.skill.manager.impl.az.d(r21)}), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).b((CharSequence) ZeusTransformUtils.preCheckCast(r0.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_app_function_disable_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_app_function_disable_message")), CharSequence.class, "com.obric.aiagent.plugin")).a(true);
        String r3 = r0.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_cancel"));
        d.h.b.o.c(r3, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r14 = com.obric.oui.dialog.v2.alert.a.b(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), $$Lambda$d$iElakSz9QExJ5GBtx2W54dYJ0uc.INSTANCE, null, 4, null);
        String r1 = r0.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_app_function_disable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_app_function_disable"));
        d.h.b.o.c(r1, "getString(...)");
        ((OAlertDialog) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.a.a(r14, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$d$1uKdO1aQUHVwVQZZlkmzJaOb4o(r2), null, 4, null).b(true).g(), OAlertDialog.class, "com.obric.aiagent.plugin")).show();
    }

    private static final void a(d.h.a.a r1, DialogInterface r2, int r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.a.class, "com.obric.aiagent.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        r4.invoke();
    }
}
