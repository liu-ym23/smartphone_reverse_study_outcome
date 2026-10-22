package com.obric.privacyhook;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.privacy.PrivacyUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H$J\"\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u000e\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/privacyhook/BaseService;", "Landroid/app/Service;", "()V", "pendingIntent", "Landroid/content/Intent;", "handleAuthorizedAction", "", MemorySourceLinkType.INTENT, "handleAuthorizedStart", "", "flags", "startId", "handlePermissionDenied", "originalIntent", "onStartCommand", "startBasePermissionApplyWithCallback", "verifyBasePermission", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseService extends Service {
    private Intent pendingIntent;

    public static /* synthetic */ void $r8$lambda$Z0RbNIlnfJLFSakVhuXcs4Ar1Cg(BaseService r0) {
        startBasePermissionApplyWithCallback$lambda$0(r0);
    }

    protected abstract void handleAuthorizedAction(Intent r1);

    public BaseService() {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r2, int r3, int r4) {
        if (verifyBasePermission() == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("BaseService", "Permission verification failed");
        return 2;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        return handleAuthorizedStart(r2, r3, r4);
    }

    private final void handlePermissionDenied(Intent r1) {
        this.pendingIntent = r1;
        startBasePermissionApplyWithCallback();
        stopSelf();
    }

    private final void startBasePermissionApplyWithCallback() {
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        PrivacyUtils.startBasePermissionApplyIfNeeded(r0, new BaseService$$ExternalSyntheticLambda0(this));
    }

    private static final void startBasePermissionApplyWithCallback$lambda$0(BaseService r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.startService(r1.pendingIntent);
    }

    private final boolean verifyBasePermission() {
        Context r1 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r1, "applicationContext");
        return PrivacyUtils.hasBasePermissionAndAgree(r1);
    }

    private final int handleAuthorizedStart(Intent r1, int r2, int r3) {
        handleAuthorizedAction(r1);
        return super.onStartCommand(r1, r2, r3);
    }
}
