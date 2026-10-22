package com.bytedance.android.live.profit.format.voicechat.dialog;

import android.app.Activity;
import com.bytedance.bpea.cert.token.TokenCert;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements o60.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f87612a = null;

    static {
        f87612a = new a();
    }

    public a() {
    }

    @Override // o60.a
    public final void a(Activity r100, final o60.b r101, String[] r102) {
        TokenCert r103 = VoiceChatMicPermissionDialog.f87606b;
        Function1<Boolean, Unit> r104 = new VoiceChatMicPermissionDialog$Companion$requestPermission$1$1(r101);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "callback");
        VoiceChatMicPermissionDialog r105 = new VoiceChatMicPermissionDialog(r100);
        r105.f87608a = r104;
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r105);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
    }
}
