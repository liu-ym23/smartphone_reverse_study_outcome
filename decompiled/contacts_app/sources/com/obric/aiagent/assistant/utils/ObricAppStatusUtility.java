package com.obric.aiagent.assistant.utils;

import android.app.role.RoleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import com.GlobalProxyLancet;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: ObricAppStatusUtility.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatusUtility;", "", "<init>", "()V", "checkAppEnableStatus", "Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "context", "Landroid/content/Context;", "packageName", "", "isLogin", "", "mCachedStatus", "Lcom/obric/aiagent/assistant/utils/ObricAppStatusUtility$CachedStatus;", "mScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchUnexpiredCachedStatus", "checkApprovalAsync", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkApprovalSync", "cancellationSignal", "Landroid/os/CancellationSignal;", "getSystemDefaultAssistant", "Companion", "CachedStatus", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricAppStatusUtility {
    private static final String AUTHORITY = "com.larus.nova.privacy.provider";
    private static final long CACHE_DURATION_MS = 5000;
    private static final Uri CONTENT_URI = null;
    public static final Companion Companion = null;
    private static final String PERMISSION_MANAGE_ROLE_HOLDERS = null;
    private static final Uri PRIVACY_CONTENT_URI = null;
    private static final long QUERY_TIMEOUT_MS = 2000;
    private static final String TAG = "ObricAppStatusUtil";
    public static final String kAssistantPkg = "com.larus.nova";
    private volatile CachedStatus mCachedStatus;
    private final CoroutineScope mScope;

    /* JADX INFO: compiled from: ObricAppStatusUtility.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatusUtility$CachedStatus;", "", "status", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "timestamp", "", "<init>", "(Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;J)V", "getStatus", "()Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class CachedStatus {
        private final PrivacyApprovalStatus status;
        private final long timestamp;

        public static /* synthetic */ CachedStatus copy$default(CachedStatus r0, PrivacyApprovalStatus r1, long r2, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.status;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.timestamp;
        L9:
            return r0.copy(r1, r2);
        }

        public final PrivacyApprovalStatus component1() {
            return this.status;
        }

        public final long component2() {
            return this.timestamp;
        }

        public final CachedStatus copy(PrivacyApprovalStatus r1, long r2) {
            Intrinsics.checkNotNullParameter(r1, "status");
            return new CachedStatus(r1, r2);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof CachedStatus) == true) goto L8;
            return false;
        L8:
            CachedStatus r7 = (CachedStatus) r6;
            if (this.status == r7.status) goto L12;
            return false;
        L12:
            if (this.timestamp == r7.timestamp) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.status.hashCode() * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "CachedStatus(status=" + this.status + ", timestamp=" + this.timestamp + ')';
        }

        public CachedStatus(PrivacyApprovalStatus r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "status");
            this.status = r2;
            this.timestamp = r3;
        }

        public /* synthetic */ CachedStatus(PrivacyApprovalStatus r1, long r2, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = -1;
        L5:
            this(r1, r2);
        }

        public final PrivacyApprovalStatus getStatus() {
            return this.status;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    /* JADX INFO: compiled from: ObricAppStatusUtility.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatusUtility$Companion;", "", "<init>", "()V", "TAG", "", "CONTENT_URI", "Landroid/net/Uri;", "kAssistantPkg", "AUTHORITY", "PRIVACY_CONTENT_URI", "PERMISSION_MANAGE_ROLE_HOLDERS", "CACHE_DURATION_MS", "", "QUERY_TIMEOUT_MS", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.assistant.utils.ObricAppStatusUtility$checkApprovalAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObricAppStatusUtility.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusUtility", f = "ObricAppStatusUtility.kt", i = {0}, l = {114}, m = "checkApprovalAsync", n = {"cancellationSignal"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricAppStatusUtility this$0;

        AnonymousClass1(ObricAppStatusUtility r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.checkApprovalAsync(null, this);
        }
    }

    public ObricAppStatusUtility() {
        this.mCachedStatus = new CachedStatus(PrivacyApprovalStatus.CannotObtain, 0, 2, null);
        this.mScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public static final /* synthetic */ CoroutineScope access$getMScope$p(ObricAppStatusUtility r0) {
        return r0.mScope;
    }

    static {
        Companion = new Companion(null);
        Uri r0 = Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(...)");
        CONTENT_URI = r0;
        Uri r1 = Uri.parse("content://com.larus.nova.privacy.provider/status");
        Intrinsics.checkNotNullExpressionValue(r1, "parse(...)");
        PRIVACY_CONTENT_URI = r1;
        PERMISSION_MANAGE_ROLE_HOLDERS = "android.permission.MANAGE_ROLE_HOLDERS";
    }

    public final boolean isLogin(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        ObricAppStatusUtility r3 = this;     // Catch: Throwable -> L9
        Bundle r5 = r4.getContentResolver().call(CONTENT_URI, "is_login", null, null);     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        boolean r6 = r5.getBoolean("is_login");     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.m803constructorimpl(Boolean.valueOf(r6));     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.m806exceptionOrNullimpl(r7);
        if (r8 == null) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "isLogin error: " + r8.getMessage(), r8);
    L15:
        if (Result.m809isFailureimpl(r7) == false) goto L18;
        r7 = false;
    L18:
        return ((Boolean) r7).booleanValue();
    L6:
        r6 = false;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final CachedStatus fetchUnexpiredCachedStatus() {
        long r0 = System.currentTimeMillis();
        CachedStatus r4 = this.mCachedStatus;
        if ((r0 - r4.getTimestamp()) < 5000) goto L5;
        return null;
    L5:
        if (r4.getTimestamp() == (-1)) goto L9;
        return r4;
    L9:
        return null;
    }

    public final Object checkApprovalAsync(Context r7, Continuation<? super PrivacyApprovalStatus> r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        CancellationSignal r6 = (CancellationSignal) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L22:
        PrivacyApprovalStatus r10 = (PrivacyApprovalStatus) r9;
        if (r10 != null) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "[Assist-PrivApproval] query timeout");
        r6.cancel();
        return PrivacyApprovalStatus.Timeout;
    L26:
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        CachedStatus r11 = fetchUnexpiredCachedStatus();
        if (r11 != null) goto L17;
        CancellationSignal r12 = new CancellationSignal();
        ObricAppStatusUtility$checkApprovalAsync$result$1 r3 = new ObricAppStatusUtility$checkApprovalAsync$result$1(this, r7, r12, null);
        r0.L$0 = r12;
        r0.label = 1;
        Object r13 = TimeoutKt.withTimeoutOrNull(200000, r3, r0);
        if (r13 != r1) goto L21;
        return r1;
    L21:
        r9 = r13;
        r6 = r12;
        goto L22
    L17:
        return r11.getStatus();
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    public final PrivacyApprovalStatus checkApprovalSync(Context r14, CancellationSignal r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        CachedStatus r4 = fetchUnexpiredCachedStatus();
        if (r4 != null) goto L5;
        Cursor r5 = null;
        r5 = r14.getContentResolver().query(PRIVACY_CONTENT_URI, new String[]{"value"}, null, null, null, r15);     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        if (r5 != null) goto L10;
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "[Assist-PrivApproval] query failed: cursor is null");     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        PrivacyApprovalStatus r16 = PrivacyApprovalStatus.CannotObtain;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "[Assist-PrivApproval] query result: " + r16);     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        if (r5 == null) goto L29;
    L18:
        r5.close();
    L29:
        CachedStatus r17 = new CachedStatus(r16, System.currentTimeMillis());
        this.mCachedStatus = r17;
        return r17.getStatus();
    L10:
        if (r5.moveToFirst() == false) goto L15;
        if (r5.getInt(0) != 1) goto L14;
        r16 = PrivacyApprovalStatus.Approved;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        goto L16
    L14:
        r16 = PrivacyApprovalStatus.NotApproved;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
    L19:
        th = move-exception;
        if (r5 == null) goto L33;
        r5.close();
    L33:
        throw th;
    L25:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "[Assist-PrivApproval] query timeout (" + e + ')', e);     // Catch: Throwable -> L19
        r16 = PrivacyApprovalStatus.Timeout;     // Catch: Throwable -> L19
        if (r5 == null) goto L29;
    L21:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "[Assist-PrivApproval] query failed (exception, " + e + ')', e);     // Catch: Throwable -> L19
        r16 = PrivacyApprovalStatus.CannotObtain;     // Catch: Throwable -> L19
        if (r5 == null) goto L29;
    L5:
        return r4.getStatus();
    }

    public final String getSystemDefaultAssistant(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        RoleManager r7 = (RoleManager) r8.getSystemService("role");
        if (r7 != null) goto L6;
        return null;
    L6:
        if (r7.isRoleAvailable("android.app.role.ASSISTANT") == false) goto L24;
        String r2 = PERMISSION_MANAGE_ROLE_HOLDERS;
        if (r8.checkSelfPermission(r2) == 0) goto L25;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "无权限：需要 " + r2);
        return null;
    L25:
        Method r9 = RoleManager.class.getMethod("getRoleHolders", new Class[]{String.class});     // Catch: Exception -> L20 SecurityException -> L22
        r9.setAccessible(true);     // Catch: Exception -> L20 SecurityException -> L22
        Object r10 = r9.invoke(r7, new Object[]{"android.app.role.ASSISTANT"});     // Catch: Exception -> L20 SecurityException -> L22
        if ((r10 instanceof List) == false) goto L14;
        List r11 = (List) r10;     // Catch: Exception -> L20 SecurityException -> L22
    L15:
        if (r11 == null) goto L18;
        String r12 = (String) CollectionsKt.getOrNull(r11, 0);     // Catch: Exception -> L20 SecurityException -> L22
        if (r12 == null) goto L18;
        return r12;
    L18:
        return "";
    L14:
        r11 = null;
    L22:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = move-exception;
        e.printStackTrace();
    L24:
        return null;
    }

    public final AppEnableStatus checkAppEnableStatus(Context r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        if (r9 == null) goto L36;
        String r7 = r9;
        int r0 = r7.length() - 1;
        boolean r2 = false;
        int r3 = 0;
        boolean r4 = false;
    L5:
        if (r3 > r0) goto L21;
        if (r4 == true) goto L8;
        int r5 = r3;
    L10:
        if (Intrinsics.compare(r7.charAt(r5), 32) > 0) goto L12;
        boolean r6 = true;
    L13:
        if (r4 == false) goto L14;
        if (r6 == false) goto L21;
        r0 = r0 - 1;
        goto L5
    L14:
        if (r6 == false) goto L15;
        r3 = r3 + 1;
        goto L5
    L15:
        r4 = true;
        goto L5
    L12:
        r6 = false;
        goto L13
    L8:
        r5 = r0;
    L21:
        if (r7.subSequence(r3, r0 + 1).toString().length() != 0) goto L23;
        r2 = true;
    L23:
        if (r2 == true) goto L36;
        int r10 = r8.getPackageManager().getApplicationEnabledSetting(r9);     // Catch: PackageManager.NameNotFoundException -> L32
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "assistState = " + r10);     // Catch: PackageManager.NameNotFoundException -> L32
        if (r10 == 0) goto L31;
        if (r10 == 1) goto L31;
        return AppEnableStatus.AppDisabled;
    L31:
        return AppEnableStatus.Enabled;
    L32:
        e = move-exception;
        e.printStackTrace();
        return AppEnableStatus.NoInstalled;
    L36:
        return AppEnableStatus.NoInstalled;
    }
}
