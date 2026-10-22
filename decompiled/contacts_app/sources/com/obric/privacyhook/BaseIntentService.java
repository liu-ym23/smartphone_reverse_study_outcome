package com.obric.privacyhook;

import android.app.IntentService;
import android.content.Intent;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.privacy.PrivacyUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseIntentService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0004J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH$J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\"\u0010\r\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0004J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/privacyhook/BaseIntentService;", "Landroid/app/IntentService;", "name", "", "(Ljava/lang/String;)V", "getLogTag", "handleAction", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onCreate", "onDestroy", "onError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onHandleIntent", "onPermissionDenied", "verifyPermission", "", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseIntentService extends IntentService {
    public static final Companion Companion = null;
    private static final String TAG = "BaseIntentService";

    /* JADX INFO: compiled from: BaseIntentService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/privacyhook/BaseIntentService$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$2-k_6_6i-SLlJqv-v7FG9EmqVnc, reason: not valid java name */
    public static /* synthetic */ void m761$r8$lambda$2k_6_6iSLlJqvv7FG9EmqVnc(BaseIntentService r0, Intent r1) {
        onPermissionDenied$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    protected final String getLogTag() {
        return TAG;
    }

    protected abstract void handleAction(String r1, Intent r2);

    protected final void onError(Exception r1, Intent r2) {
    }

    public BaseIntentService(String r1) {
        super(r1);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(getLogTag(), "Service destroyed: " + getClass().getSimpleName());
    L5:
        super.onDestroy();
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent r6) {
        if (verifyPermission() == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Permission verification failed");
        return;
    L6:
        if (r6 != null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(getLogTag(), "Received null intent");
        return;
    L9:
        PrivacyUtils.INSTANCE.applicationInit();
        String r0 = r6.getAction();
        if (ContactsUtils.DEBUG == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(getLogTag(), "Handling action: " + r0);
    L17:
        handleAction(r0, r6);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(getLogTag(), "Error handling action: " + r0, e);
        onError(e, r6);
    }

    private final boolean verifyPermission() {
        ContactsApplication r1 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r1, "getInstance()");
        return PrivacyUtils.hasBasePermissionAndAgree(r1);
    }

    private final void onPermissionDenied(final Intent r3) {
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        PrivacyUtils.startBasePermissionApplyIfNeeded(r0, new BaseIntentService$$ExternalSyntheticLambda0(this, r3));
    }

    private static final void onPermissionDenied$lambda$0(BaseIntentService r1, Intent r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.startService(r2);
    }
}
