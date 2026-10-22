package com.stepos.alphame.persona.privacy;

import android.content.Context;
import android.content.DialogInterface;
import androidx.core.app.f;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.BuildConfig;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.DialogInterfaceC0865j;
import stepos.support.v7.app.S;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/stepos/alphame/persona/privacy/PolicyManager;", "", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "", "initPolicy", "(Landroid/content/Context;)V", "Lcom/stepos/alphame/persona/privacy/OnPolicyCheckListener;", "listener", "checkNewestPolicy", "(Landroid/content/Context;Lcom/stepos/alphame/persona/privacy/OnPolicyCheckListener;)V", "", "isSystemAlert", "Lcom/stepos/alphame/persona/privacy/OnPolicyConfirmListener;", "showReGrantDialog", "(ZLandroid/content/Context;Lcom/stepos/alphame/persona/privacy/OnPolicyConfirmListener;)V", "", "appId", "Ljava/lang/String;", "appSecret", "appVersionName", "Lstepos/support/v7/app/j;", "mReGrantDialog", "Lstepos/support/v7/app/j;", "<init>", "()V", "Companion", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PolicyManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<PolicyManager> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PolicyManager>() { // from class: com.stepos.alphame.persona.privacy.PolicyManager$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PolicyManager invoke() {
            return new PolicyManager();
        }
    });

    @NotNull
    public static final String TAG = "PolicyManager";

    @NotNull
    private final String appId = "44847302403461083790";

    @NotNull
    private final String appSecret = "6d193fe8202147a68cddff953c9e6296";

    @NotNull
    private final String appVersionName = BuildConfig.VERSION_NAME;

    @Nullable
    private DialogInterfaceC0865j mReGrantDialog;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/persona/privacy/PolicyManager$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/alphame/persona/privacy/PolicyManager;", "getINSTANCE", "()Lcom/stepos/alphame/persona/privacy/PolicyManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PolicyManager getINSTANCE() {
            return (PolicyManager) PolicyManager.INSTANCE$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkNewestPolicy$lambda$0(OnPolicyCheckListener listener, PolicySdkResultBean policySdkResultBean) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (policySdkResultBean.getCode() != 0) {
            AlphaMeLogger.debugLog(TAG, "errorcode = " + policySdkResultBean.getCode());
            return;
        }
        AlphaMeLogger.debugLog(TAG, "checkNewestPolicy policySdkResultBean.getPolicyNewestPath()= " + policySdkResultBean.getPolicyNewestPath());
        AlphaMeLogger.debugLog(TAG, "checkNewestPolicy policySdkResultBean.getPolicyNewest()= " + policySdkResultBean.getPolicyNewest());
        if (!policySdkResultBean.getPolicyNewest()) {
            AlphaMeLogger.debugLog(TAG, "checkNewestPolicy policyRegrantFlag= " + policySdkResultBean.getPolicyRegrantFlag());
            policySdkResultBean.getPolicyRegrantFlag();
            listener.onResult(policySdkResultBean.getPolicyRegrantFlag());
        }
        AlphaMeLogger.debugLog(TAG, "checkNewestPolicy getPolicyNewestPath= " + policySdkResultBean.getPolicyNewestPath());
    }

    public final void checkNewestPolicy(@NotNull Context context, @NotNull OnPolicyCheckListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            PolicySdk.checkNewestPolicy(context, true, PolicySdkToolsUtils.INSTANCE.getLanguage(), "pp", new f(listener));
        } catch (Exception e4) {
            AlphaMeLogger.debugLog(TAG, "协议检查异常：" + e4);
            e4.printStackTrace();
        }
    }

    public final void initPolicy(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap map = new HashMap();
        map.put("up", "file:////android_asset/up_0.html");
        map.put("pp", "file:////android_asset/AicyPrivacyPolicy.html");
        map.put("picl", "file:////android_asset/PersonalInformationCollectionList.html");
        map.put("tisl", "file:////android_asset/AicyThird-partyInformationSharingList.html");
        map.put("pcpi", "file:////android_asset/PersonalInformationProtectionRulesOfChildren.html");
        PolicySdk.initSDK(context, this.appId, this.appSecret, this.appVersionName, map);
    }

    public final void showReGrantDialog(boolean isSystemAlert, @NotNull Context context, @NotNull final OnPolicyConfirmListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String string = context.getString(R.string.privacy_pp);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        try {
            String string2 = context.getString(R.string.aicy_app_name);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            AlphaMeLogger.debugLog(TAG, "thread=" + Thread.currentThread() + "   context=" + context);
            this.mReGrantDialog = PolicySdk.showReGrantDialog(context, true, null, Boolean.TRUE, Boolean.FALSE, string2, string, "pp", new S() { // from class: com.stepos.alphame.persona.privacy.PolicyManager.showReGrantDialog.1
                public /* bridge */ /* synthetic */ void onPermissionClick(DialogInterface dialogInterface, boolean z4, boolean z5, Map map) {
                }

                @Override // stepos.support.v7.app.S
                public void onPermissionClick(@NotNull DialogInterface dialog, boolean alwaysDeny, boolean allow) {
                    Intrinsics.checkNotNullParameter(dialog, "dialog");
                    listener.onAccept(allow);
                }
            });
        } catch (Exception e4) {
            AlphaMeLogger.debugLog(TAG, "更新隐私弹窗异常：" + e4);
            e4.printStackTrace();
        }
        DialogInterfaceC0865j dialogInterfaceC0865j = this.mReGrantDialog;
        if (dialogInterfaceC0865j != null) {
            Boolean boolValueOf = dialogInterfaceC0865j != null ? Boolean.valueOf(dialogInterfaceC0865j.isShowing()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (boolValueOf.booleanValue()) {
                return;
            }
            DialogInterfaceC0865j dialogInterfaceC0865j2 = this.mReGrantDialog;
            Intrinsics.checkNotNull(dialogInterfaceC0865j2);
            dialogInterfaceC0865j2.show();
        }
    }
}
