package com.obric.utils;

import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.attestation.AttestationConfig;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.privacy.bridge.IEnvBridge;
import com.bytedance.privacy.exception.BdPrivacyException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceIdPrivacy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u001c\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00100\u0012J\u001c\u0010\u0013\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00100\u0012J\u0006\u0010\u0014\u001a\u00020\u0010J\u001e\u0010\u0015\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00100\u0012H\u0002J\u001e\u0010\u0016\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00100\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/utils/DeviceIdPrivacy;", "", "()V", "PRIVACY_DID_APP_ID", "", "PRIVACY_DID_KEY_ALIAS", "TAG", "config", "Lcom/bytedance/privacy/attestation/AttestationConfig;", "getConfig", "()Lcom/bytedance/privacy/attestation/AttestationConfig;", "setConfig", "(Lcom/bytedance/privacy/attestation/AttestationConfig;)V", "privacyDeviceId", "buildAttestationConfig", "getIdAttestation", "", "callback", "Lkotlin/Function1;", "getPrivacyDeviceId", "init", "updateIdAttestation", "updatePrivacyDeviceId", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceIdPrivacy {
    public static final DeviceIdPrivacy INSTANCE = null;
    private static final String PRIVACY_DID_APP_ID = "obric_call_contacts";
    private static final String PRIVACY_DID_KEY_ALIAS = "obric_call_contacts_alias_intelligent_call";
    private static final String TAG = "DeviceIdPrivacy";
    private static AttestationConfig config;
    private static volatile String privacyDeviceId;

    public static /* synthetic */ void $r8$lambda$3mimaZYlQcRrExyqPGa2kYJwHfs(Function1 r0) {
        updatePrivacyDeviceId$lambda$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$4FCsJAIGl5AvMkWqiSpxmT28grQ(Function1 r0) {
        updateIdAttestation$lambda$4(r0);
    }

    static {
        INSTANCE = new DeviceIdPrivacy();
    }

    private DeviceIdPrivacy() {
    }

    public static final /* synthetic */ void access$setPrivacyDeviceId$p(String r0) {
        privacyDeviceId = r0;
    }

    public final AttestationConfig getConfig() {
        return config;
    }

    public final void setConfig(AttestationConfig r1) {
        config = r1;
    }

    public final void init() {
        IAccountBridge r2 = new DeviceIdPrivacy$init$accountBridge$1();
        IEnvBridge r0 = new DeviceIdPrivacy$init$envBridge$1();
        privacyDeviceId = null;
        config = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        PrivacySdk.init(r2, r0);     // Catch: Throwable -> L5
        DeviceIdPrivacy r3 = INSTANCE;     // Catch: Throwable -> L5
        r3.updatePrivacyDeviceId(DeviceIdPrivacy$init$1$1.INSTANCE);     // Catch: Throwable -> L5
        r3.updateIdAttestation(DeviceIdPrivacy$init$1$2.INSTANCE);     // Catch: Throwable -> L5
        Object r4 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m806exceptionOrNullimpl(r4);
        if (r5 == null) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "init privacy sdk failed", r5);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void updatePrivacyDeviceId(final Function1<? super String, Unit> r2) {
        GlobalUtils.INSTANCE.execute(new DeviceIdPrivacy$$ExternalSyntheticLambda1(r2));
    }

    private static final void updatePrivacyDeviceId$lambda$2(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "$callback");
        String r0 = privacyDeviceId;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r3.invoke(privacyDeviceId);
        return;
    L12:
        privacyDeviceId = PrivacySdk.getPseudoManager().getPseudoDID(ContactsApplication.getInstance().getApplicationContext(), PRIVACY_DID_APP_ID);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "updatePrivacyDeviceId: " + privacyDeviceId);
        r3.invoke(privacyDeviceId);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final void updateIdAttestation(final Function1<? super String, Unit> r2) {
        GlobalUtils.INSTANCE.execute(new DeviceIdPrivacy$$ExternalSyntheticLambda0(r2));
    }

    private static final void updateIdAttestation$lambda$4(Function1 r6) {
        Intrinsics.checkNotNullParameter(r6, "$callback");
        DeviceIdPrivacy r1 = INSTANCE;
        if (config != null) goto L10;
        config = r1.buildAttestationConfig();
    L10:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        String r3 = PrivacySdk.getIdAttestationManager().getIDAttestationString(ContactsApplication.getInstance().getApplicationContext(), PRIVACY_DID_APP_ID, PRIVACY_DID_KEY_ALIAS, config);     // Catch: Throwable -> L7
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getIdAttestation success: " + r3);     // Catch: Throwable -> L7
        r6.invoke(r3);     // Catch: Throwable -> L7
        Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.m803constructorimpl(ResultKt.createFailure(th));
    }

    public final void getPrivacyDeviceId(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        String r0 = privacyDeviceId;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        updatePrivacyDeviceId(r2);
    L11:
        r2.invoke(privacyDeviceId);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void getIdAttestation(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        updateIdAttestation(r2);
    }

    private final AttestationConfig buildAttestationConfig() throws BdPrivacyException {
        AttestationConfig.Builder r1 = new AttestationConfig.Builder();
        r1.requestId(AttestationConfig.IdType.RPDID);
        r1.requestDeviceHealthStatus();
        AttestationConfig r2 = r1.build();
        Intrinsics.checkNotNullExpressionValue(r2, "builder.build()");
        return r2;
    }
}
