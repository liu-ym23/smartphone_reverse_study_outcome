package com.stepos.ailauncher.agent.aispace.connect;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$string;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/l0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "LY8/t;", "onConfirm", "onCancel", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lp9/a;Lp9/a;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.l0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2216l0 {
    public static final C2216l0 INSTANCE = new C2216l0();

    public final void a(Context context, InterfaceC5063a<Y8.t> onConfirm, InterfaceC5063a<Y8.t> onCancel) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        kotlin.jvm.internal.p.i(onCancel, "onCancel");
        String string = context.getString(R$string.disconnect_dialog_title);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = context.getString(R$string.disconnect_dialog_desc);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        String string3 = context.getString(R$string.disconnect_dialog_cancel);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        String string4 = context.getString(R$string.disconnect_dialog_confirm);
        kotlin.jvm.internal.p.h(string4, "getString(...)");
        com.stepos.ailauncher.container.dialog.f.q(new S4.d(context, string, string2, string3, string4, onCancel, onConfirm), "disconnectExternalAgent");
    }
}
