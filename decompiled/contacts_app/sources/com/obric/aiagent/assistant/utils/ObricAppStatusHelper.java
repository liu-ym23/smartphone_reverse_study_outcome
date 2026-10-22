package com.obric.aiagent.assistant.utils;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricAppStatusHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001c\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatusHelper;", "", "<init>", "()V", "kAssistantPkg", "", "statusUtility", "Lcom/obric/aiagent/assistant/utils/ObricAppStatusUtility;", "getStatusUtility", "()Lcom/obric/aiagent/assistant/utils/ObricAppStatusUtility;", "statusUtility$delegate", "Lkotlin/Lazy;", "getObricAppStatus", "Lcom/obric/aiagent/assistant/utils/ObricAppStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getObricAppStatusSync", "getObricAppStatusFull", "Lcom/obric/aiagent/assistant/utils/ObricAppStatusFull;", "onlySysStatus", "", "getDefaultAssistantState", "Lcom/obric/aiagent/assistant/utils/DefaultAssistantStatus;", "getAppEnableState", "Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "getAppPrivacyApprovalState", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "getAppLoginState", "assistant-status-utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricAppStatusHelper {
    public static final ObricAppStatusHelper INSTANCE = null;
    private static final String kAssistantPkg = "com.larus.nova";
    private static final Lazy statusUtility$delegate = null;

    /* JADX INFO: compiled from: ObricAppStatusHelper.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[PrivacyApprovalStatus.values().length];
            r0[PrivacyApprovalStatus.NotApproved.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PrivacyApprovalStatus.CannotObtain.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PrivacyApprovalStatus.Timeout.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PrivacyApprovalStatus.Approved.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.assistant.utils.ObricAppStatusHelper$getObricAppStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: ObricAppStatusHelper.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusHelper", f = "ObricAppStatusHelper.kt", i = {0, 0}, l = {31}, m = "getObricAppStatus", n = {"this", "context"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricAppStatusHelper this$0;

        AnonymousClass1(ObricAppStatusHelper r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getObricAppStatus(null, this);
        }
    }

    public static /* synthetic */ ObricAppStatusUtility $r8$lambda$VeBEojXpF3U_FVHqYUVi5NOIK38() {
        return statusUtility_delegate$lambda$0();
    }

    private ObricAppStatusHelper() {
    }

    static {
        INSTANCE = new ObricAppStatusHelper();
        statusUtility$delegate = LazyKt.lazy(new ObricAppStatusHelper$$ExternalSyntheticLambda0());
    }

    public final ObricAppStatusUtility getStatusUtility() {
        return (ObricAppStatusUtility) statusUtility$delegate.getValue();
    }

    private static final ObricAppStatusUtility statusUtility_delegate$lambda$0() {
        return new ObricAppStatusUtility();
    }

    public final Object getObricAppStatus(Context r6, Continuation<? super ObricAppStatus> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r6 = (Context) r0.L$1;
        ObricAppStatusHelper this = (ObricAppStatusHelper) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L29:
        int r9 = WhenMappings.$EnumSwitchMapping$0[((PrivacyApprovalStatus) r8).ordinal()];
        if (r9 == 1) goto L52;
        if (r9 == 2) goto L50;
        if (r9 == 3) goto L50;
        if (r9 != 4) goto L48;
        if (this.getStatusUtility().isLogin(r6) == true) goto L42;
        return ObricAppStatus.UserNoLogin;
    L42:
        if (Intrinsics.areEqual(this.getStatusUtility().getSystemDefaultAssistant(r6), "com.larus.nova") == true) goto L46;
        return ObricAppStatus.NotRoleAssistant;
    L46:
        return ObricAppStatus.Success;
    L48:
        throw new NoWhenBranchMatchedException();
    L50:
        return ObricAppStatus.PrivacyNotObtainError;
    L52:
        return ObricAppStatus.PrivacyNotApprovalError;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r6 == null) goto L17;
        AppEnableStatus r10 = getStatusUtility().checkAppEnableStatus(r6, "com.larus.nova");
        if (r10 != AppEnableStatus.NoInstalled) goto L23;
        return ObricAppStatus.NoInstalledError;
    L23:
        if (r10 == AppEnableStatus.AppDisabled) goto L25;
        ObricAppStatusUtility r11 = getStatusUtility();
        r0.L$0 = this;
        r0.L$1 = r6;
        r0.label = 1;
        r8 = r11.checkApprovalAsync(r6, r0);
        if (r8 != r1) goto L29;
        return r1;
    L25:
        return ObricAppStatus.AppDisabledError;
    L17:
        return ObricAppStatus.Unknown;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    public final ObricAppStatus getObricAppStatusSync(Context r4) {
        if (r4 == null) goto L4;
        AppEnableStatus r0 = getStatusUtility().checkAppEnableStatus(r4, "com.larus.nova");
        if (r0 != AppEnableStatus.NoInstalled) goto L10;
        return ObricAppStatus.NoInstalledError;
    L10:
        if (r0 == AppEnableStatus.AppDisabled) goto L12;
        PrivacyApprovalStatus r1 = getStatusUtility().checkApprovalSync(r4, null);
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 == 1) goto L36;
        if (r2 == 2) goto L34;
        if (r2 == 3) goto L34;
        if (r2 != 4) goto L32;
        if (getStatusUtility().isLogin(r4) == true) goto L26;
        return ObricAppStatus.UserNoLogin;
    L26:
        if (Intrinsics.areEqual(getStatusUtility().getSystemDefaultAssistant(r4), "com.larus.nova") == true) goto L30;
        return ObricAppStatus.NotRoleAssistant;
    L30:
        return ObricAppStatus.Success;
    L32:
        throw new NoWhenBranchMatchedException();
    L34:
        return ObricAppStatus.PrivacyNotObtainError;
    L36:
        return ObricAppStatus.PrivacyNotApprovalError;
    L12:
        return ObricAppStatus.AppDisabledError;
    L4:
        return ObricAppStatus.Unknown;
    }

    public static /* synthetic */ ObricAppStatusFull getObricAppStatusFull$default(ObricAppStatusHelper r0, Context r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.getObricAppStatusFull(r1, r2);
    }

    public final ObricAppStatusFull getObricAppStatusFull(Context r10, boolean r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ObricAppStatusFull r8 = new ObricAppStatusFull(null, null, false, false, 15, null);
        r8.setEnableStatus(getStatusUtility().checkAppEnableStatus(r10, "com.larus.nova"));
        if (r8.getEnableStatus() == AppEnableStatus.Enabled) goto L8;
        return r8;
    L8:
        if (r11 == false) goto L10;
        r8.setPrivacyApprovalStatus(getStatusUtility().checkApprovalSync(r10, null));
        r8.setLogin(getStatusUtility().isLogin(r10));
    L10:
        r8.setRoleAssistant(Intrinsics.areEqual(getStatusUtility().getSystemDefaultAssistant(r10), "com.larus.nova"));
        return r8;
    }

    public final DefaultAssistantStatus getDefaultAssistantState(Context r1) {
        if (r1 == null) goto L4;
        String r0 = getStatusUtility().getSystemDefaultAssistant(r1);
        if (r0 != null) goto L10;
        return DefaultAssistantStatus.Unknown;
    L10:
        if (Intrinsics.areEqual(r0, "com.larus.nova") == false) goto L14;
        return DefaultAssistantStatus.IsDefaultAssistant;
    L14:
        return DefaultAssistantStatus.NotDefaultAssistant;
    L4:
        return DefaultAssistantStatus.Unknown;
    }

    public final AppEnableStatus getAppEnableState(Context r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return getStatusUtility().checkAppEnableStatus(r2, "com.larus.nova");
    }

    public final PrivacyApprovalStatus getAppPrivacyApprovalState(Context r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (getAppEnableState(r4) == AppEnableStatus.Enabled) goto L10;
        return PrivacyApprovalStatus.CannotObtain;
    L10:
        return getStatusUtility().checkApprovalSync(r4, null);
    }

    public final boolean getAppLoginState(Context r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (getAppPrivacyApprovalState(r4) == PrivacyApprovalStatus.Approved) goto L9;
        return false;
    L9:
        return getStatusUtility().isLogin(r4);
    }
}
