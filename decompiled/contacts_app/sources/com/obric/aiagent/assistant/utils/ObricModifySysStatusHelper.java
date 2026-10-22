package com.obric.aiagent.assistant.utils;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.GlobalProxyLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricModifySysStatusHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005J&\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005J$\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricModifySysStatusHelper;", "", "<init>", "()V", "METHOD_DISABLE_ASSIST", "", "METHOD_ENABLE_ASSIST", "METHOD_SHOW_ENABLE_DIALOG", "METHOD_SHOW_INSTALL_DIALOG", "RESULT_KEY", "TAG", "disableAiAssistant", "", "context", "Landroid/content/Context;", "enableAiAssistant", "showEnableDialog", "title", "desc", ObricModifySysStatusHelper.METHOD_SHOW_INSTALL_DIALOG, "doActionToAiAssistant", "methodName", "extras", "Landroid/os/Bundle;", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricModifySysStatusHelper {
    public static final ObricModifySysStatusHelper INSTANCE = null;
    public static final String METHOD_DISABLE_ASSIST = "disableAssist";
    public static final String METHOD_ENABLE_ASSIST = "enableAssist";
    public static final String METHOD_SHOW_ENABLE_DIALOG = "showDialog";
    public static final String METHOD_SHOW_INSTALL_DIALOG = "showInstallDialog";
    public static final String RESULT_KEY = "result";
    public static final String TAG = "ObricModifySysStatusHelper";

    static {
        INSTANCE = new ObricModifySysStatusHelper();
    }

    private ObricModifySysStatusHelper() {
    }

    public final boolean disableAiAssistant(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        return doActionToAiAssistant$default(this, r8, METHOD_DISABLE_ASSIST, null, 4, null);
    }

    public final boolean enableAiAssistant(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        return doActionToAiAssistant$default(this, r8, METHOD_ENABLE_ASSIST, null, 4, null);
    }

    public static /* synthetic */ boolean showEnableDialog$default(ObricModifySysStatusHelper r1, Context r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.showEnableDialog(r2, r3, r4);
    }

    public final boolean showEnableDialog(Context r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Bundle r0 = new Bundle();
        r0.putString("title", r4);
        r0.putString("desc", r5);
        return doActionToAiAssistant(r3, METHOD_SHOW_ENABLE_DIALOG, r0);
    }

    public static /* synthetic */ boolean showInstallDialog$default(ObricModifySysStatusHelper r1, Context r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.showInstallDialog(r2, r3, r4);
    }

    public final boolean showInstallDialog(Context r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Bundle r0 = new Bundle();
        r0.putString("title", r4);
        r0.putString("desc", r5);
        return doActionToAiAssistant(r3, METHOD_SHOW_INSTALL_DIALOG, r0);
    }

    static /* synthetic */ boolean doActionToAiAssistant$default(ObricModifySysStatusHelper r0, Context r1, String r2, Bundle r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.doActionToAiAssistant(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean doActionToAiAssistant(Context r5, String r6, Bundle r7) {
        ContentProviderClient r2 = 0;
        Bundle r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        ContentProviderClient r8 = r5.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://obric.assist.management"));     // Catch: Throwable -> L15 Exception -> L17 SecurityException -> L22 RemoteException -> L27
        if (r8 != null) goto L42;
    L13:
        if (r8 == null) goto L33;
    L14:
        r8.close();
    L33:
        if (r3 == null) goto L45;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "call result = " + r3.getBoolean("result"));
        return r3.getBoolean("result", false);
    L45:
        return false;
    L42:
        r3 = r8.call(r6, null, r7);     // Catch: Exception -> L7 SecurityException -> L9 RemoteException -> L11 Throwable -> L36
        goto L13
    L11:
        e = e;
    L29:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "call remote " + r6 + " error!", e);     // Catch: Throwable -> L36
        if (r8 == null) goto L33;
    L9:
        e = e;
    L24:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "call remote " + r6 + " error!", e);     // Catch: Throwable -> L36
        if (r8 == null) goto L33;
    L7:
        e = e;
    L19:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "call remote " + r6 + " error!", e);     // Catch: Throwable -> L36
        if (r8 == null) goto L33;
    L36:
        th = th;
        r2 = r5;
    L38:
        if (r2 == 0) goto L40;
        r2.close();
    L40:
        throw th;
    L27:
        e = e;
        r8 = null;
    L22:
        e = e;
        r8 = null;
    L17:
        e = e;
        r8 = null;
    L15:
        th = th;
        goto L38
    }
}
