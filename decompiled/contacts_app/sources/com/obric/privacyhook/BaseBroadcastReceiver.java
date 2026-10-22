package com.obric.privacyhook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.privacy.PrivacyUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0016\u0010\u0016\u001a\u00020\n*\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0004R\u0014\u0010\u0003\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/privacyhook/BaseBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "pendingIntent", "Landroid/content/Intent;", "onHandleError", "", "context", "Landroid/content/Context;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", MemorySourceLinkType.INTENT, "onPermissionDenied", "onReceive", "onReceiveAction", "verifyPermission", "", "safeBroadcast", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseBroadcastReceiver extends BroadcastReceiver {
    private Intent pendingIntent;

    public static /* synthetic */ void $r8$lambda$FBjLojU7zv1DvPTzZwEjohlpW0o(BaseBroadcastReceiver r0, Context r1) {
        onPermissionDenied$lambda$1(r0, r1);
    }

    protected void onHandleError(Context r1, Exception r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public abstract void onReceiveAction(Context r1, Intent r2);

    public BaseBroadcastReceiver() {
    }

    protected String getTAG() {
        String r1 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r1, "javaClass.simpleName");
        return r1;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r6, Intent r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (ContactsUtils.DEBUG == false) goto L11;
        String r0 = getTAG();
        StringBuilder r1 = new StringBuilder("Received broadcast: ");
        if (r7 == null) goto L8;
        String r2 = r7.getAction();
        if (r2 == null) goto L8;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r0, r1.append(r2).toString());
    L8:
        r2 = "null-action";
    L11:
        if (verifyPermission(r6) == true) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(getTAG(), "Permission verification failed");
        this.pendingIntent = r7;
        return;
    L14:
        PrivacyUtils.INSTANCE.applicationInit();
        String r3 = null;
        if (r7 != null) goto L27;
        Intent r4 = null;
    L20:
        onReceiveAction(r6, r4);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        String r5 = getTAG();
        StringBuilder r8 = new StringBuilder("Error handling broadcast: ");
        if (r7 == null) goto L25;
        r3 = r7.getAction();
    L25:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(r5, r8.append(r3).toString(), e);
        onHandleError(r6, e, r7);
        return;
    L27:
        r7.putExtra("_receiver_class", r7.getClass().getName());     // Catch: Exception -> L17
        Unit r9 = Unit.INSTANCE;     // Catch: Exception -> L17
        r4 = r7;
        goto L20
    }

    protected boolean verifyPermission(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        return PrivacyUtils.hasBasePermissionAndAgree(r0);
    }

    private final void onPermissionDenied(final Context r3) {
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        PrivacyUtils.startBasePermissionApplyIfNeeded(r0, new BaseBroadcastReceiver$$ExternalSyntheticLambda0(this, r3));
    }

    private static final void onPermissionDenied$lambda$1(BaseBroadcastReceiver r1, Context r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$context");
        r1.safeBroadcast(r2, r1.pendingIntent);
    }

    protected final void safeBroadcast(Context r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == null) goto L11;
        r2.sendBroadcast(r3);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(getTAG(), "Start service failed: ", e);
        return;
    }
}
