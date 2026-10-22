package com.stepos.policy.sdk.activity;

import Z2.F;
import Z2.M;
import Z2.Q;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.o;
import ch.qos.logback.core.CoreConstants;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.R;
import com.stepos.policy.sdk.PolicyManager;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.util.HookMacAddressUtils;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SmartBarPaddingUtil;
import com.stepos.policy.sdk.widget.PolicySDKLoadDataView;
import f1.AbstractC0557a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsJVMKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import stepos.support.v7.app.AbstractActivityC0866k;
import stepos.support.v7.app.AbstractC0860e;
import t0.J;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b>\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006J\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\bJ\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u000f\u0010\u001a\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001a\u0010\bJ!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\bR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00103R\"\u00104\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0018\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b9\u0010;\"\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lcom/stepos/policy/sdk/activity/PolicyWebViewActivity;", "Lstepos/support/v7/app/k;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "()V", "bundle", "fetchPolicyData", "showNetWorkErrorView", "showNotNetWorkView", "Landroid/view/ViewGroup;", "viewGroup", "setViewContainerPadding", "(Landroid/view/ViewGroup;)V", "setHomeAsUpEnabled", "", "mUri", "webViewLoadData", "(Ljava/lang/String;)V", "", "onSupportNavigateUp", "()Z", "onBackPressed", "onDestroy", "", "errorCode", "showLoadDataView", "(ILandroid/os/Bundle;)V", "fitStatusBarWithUiMode", "initWebview", "Landroid/app/Activity;", "mActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "Landroid/webkit/WebView;", "mWebView", "Landroid/webkit/WebView;", "mTitle", "Ljava/lang/String;", "Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;", "loadDataView", "Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;", "getLoadDataView", "()Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;", "setLoadDataView", "(Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;)V", "Landroid/os/Bundle;", "mNeedLoadData", "Z", "getMNeedLoadData", "setMNeedLoadData", "(Z)V", "isAgree", "I", "()I", "setAgree", "(I)V", "<init>", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPolicyWebViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicyWebViewActivity.kt\ncom/stepos/policy/sdk/activity/PolicyWebViewActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,607:1\n1#2:608\n*E\n"})
/* loaded from: classes.dex */
public final class PolicyWebViewActivity extends AbstractActivityC0866k {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Function1<? super Context, Unit> webViewSettingBtnCallback;

    @Nullable
    private Bundle bundle;
    private int isAgree;

    @Nullable
    private PolicySDKLoadDataView loadDataView;

    @Nullable
    private Activity mActivity;

    @Nullable
    private Context mContext;
    private boolean mNeedLoadData;

    @Nullable
    private String mTitle;

    @Nullable
    private String mUri;

    @Nullable
    private WebView mWebView;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004J,\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/stepos/policy/sdk/activity/PolicyWebViewActivity$Companion;", "", "()V", "webViewSettingBtnCallback", "Lkotlin/Function1;", "Landroid/content/Context;", "", "getWebViewSettingBtnCallback", "()Lkotlin/jvm/functions/Function1;", "setWebViewSettingBtnCallback", "(Lkotlin/jvm/functions/Function1;)V", "setSettingBtnCallback", "mWebViewSettingBtnCallback", "startOnLineWebViewActivity", CoreConstants.CONTEXT_SCOPE_VALUE, "uri", "", "title", "bundle", "Landroid/os/Bundle;", "startWebViewActivity", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPolicyWebViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicyWebViewActivity.kt\ncom/stepos/policy/sdk/activity/PolicyWebViewActivity$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,607:1\n1#2:608\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void setSettingBtnCallback$default(Companion companion, Function1 function1, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                function1 = null;
            }
            companion.setSettingBtnCallback(function1);
        }

        @Nullable
        public final Function1<Context, Unit> getWebViewSettingBtnCallback() {
            return PolicyWebViewActivity.webViewSettingBtnCallback;
        }

        public final void setSettingBtnCallback(@Nullable Function1<? super Context, Unit> mWebViewSettingBtnCallback) {
            setWebViewSettingBtnCallback(mWebViewSettingBtnCallback);
        }

        public final void setWebViewSettingBtnCallback(@Nullable Function1<? super Context, Unit> function1) {
            PolicyWebViewActivity.webViewSettingBtnCallback = function1;
        }

        public final void startOnLineWebViewActivity(@NotNull Context context, @Nullable String uri, @Nullable String title, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("uri", uri);
            intent.putExtra("title", title);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            try {
                intent.setClass(context, PolicyWebViewActivity.class);
                context.startActivity(intent);
            } catch (Exception unused) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.setClass(context, PolicyWebViewActivity.class);
                context.startActivity(intent);
            }
        }

        public final void startWebViewActivity(@NotNull Context context, @Nullable String uri, @Nullable String title) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("uri", uri);
            intent.putExtra("title", title);
            try {
                intent.setClass(context, PolicyWebViewActivity.class);
                context.startActivity(intent);
            } catch (Exception e4) {
                PolicySdkLogUtils.INSTANCE.e("PolicyWebViewActivity", "startWebViewActivity Exception: " + e4.getMessage());
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.setClass(context, PolicyWebViewActivity.class);
                context.startActivity(intent);
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.stepos.policy.sdk.activity.PolicyWebViewActivity$initWebview$1", f = "PolicyWebViewActivity.kt", i = {}, l = {310}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nPolicyWebViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicyWebViewActivity.kt\ncom/stepos/policy/sdk/activity/PolicyWebViewActivity$initWebview$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,607:1\n1#2:608\n*E\n"})
    /* renamed from: com.stepos.policy.sdk.activity.PolicyWebViewActivity$initWebview$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05001 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public C05001(Continuation<? super C05001> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return PolicyWebViewActivity.this.new C05001(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            PolicyWebViewActivity policyWebViewActivity;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                PolicySdkLogUtils.INSTANCE.d("initWebview", "isAgree = " + PolicyWebViewActivity.this.getIsAgree());
                if (PolicyWebViewActivity.this.mContext != null) {
                    Context context = PolicyWebViewActivity.this.mContext;
                    if (context != null) {
                        PolicyWebViewActivity policyWebViewActivity2 = PolicyWebViewActivity.this;
                        PolicyManager policyManager = PolicyManager.INSTANCE;
                        this.L$0 = context;
                        this.L$1 = policyWebViewActivity2;
                        this.label = 1;
                        obj = policyManager.getAgreeStatus(context, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        policyWebViewActivity = policyWebViewActivity2;
                    }
                } else {
                    PolicyWebViewActivity.this.setAgree(0);
                }
                PolicySdkLogUtils.INSTANCE.d("initWebview", "launch end isAgree = " + PolicyWebViewActivity.this.getIsAgree());
                return Unit.INSTANCE;
            }
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            policyWebViewActivity = (PolicyWebViewActivity) this.L$1;
            ResultKt.throwOnFailure(obj);
            policyWebViewActivity.setAgree(((Number) obj).intValue());
            PolicySdkLogUtils.INSTANCE.d("initWebview", "launch end isAgree = " + PolicyWebViewActivity.this.getIsAgree());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C05001) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.stepos.policy.sdk.activity.PolicyWebViewActivity$onBackPressed$1", f = "PolicyWebViewActivity.kt", i = {}, l = {585}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.policy.sdk.activity.PolicyWebViewActivity$onBackPressed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05011 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public C05011(Continuation<? super C05011> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return PolicyWebViewActivity.this.new C05011(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (M.a(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            WebView webView = PolicyWebViewActivity.this.mWebView;
            if (webView != null) {
                webView.setVisibility(0);
            }
            PolicySDKLoadDataView loadDataView = PolicyWebViewActivity.this.getLoadDataView();
            if (loadDataView != null) {
                loadDataView.hideEmptyView();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C05011) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.stepos.policy.sdk.activity.PolicyWebViewActivity$onSupportNavigateUp$1", f = "PolicyWebViewActivity.kt", i = {}, l = {567}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.policy.sdk.activity.PolicyWebViewActivity$onSupportNavigateUp$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05021 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public C05021(Continuation<? super C05021> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return PolicyWebViewActivity.this.new C05021(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (M.a(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            WebView webView = PolicyWebViewActivity.this.mWebView;
            if (webView != null) {
                webView.setVisibility(0);
            }
            PolicySDKLoadDataView loadDataView = PolicyWebViewActivity.this.getLoadDataView();
            if (loadDataView != null) {
                loadDataView.hideEmptyView();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C05021) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private final void fitStatusBarWithUiMode() {
        WebSettings settings;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            WebView webView = this.mWebView;
            WebSettings settings2 = webView != null ? webView.getSettings() : null;
            if (settings2 != null) {
                settings2.setForceDark(2);
            }
            WebView webView2 = this.mWebView;
            settings = webView2 != null ? webView2.getSettings() : null;
            if (settings == null) {
                return;
            }
            settings.setAlgorithmicDarkeningAllowed(true);
            return;
        }
        WebView webView3 = this.mWebView;
        WebSettings settings3 = webView3 != null ? webView3.getSettings() : null;
        if (settings3 != null) {
            settings3.setForceDark(0);
        }
        WebView webView4 = this.mWebView;
        settings = webView4 != null ? webView4.getSettings() : null;
        if (settings == null) {
            return;
        }
        settings.setAlgorithmicDarkeningAllowed(false);
    }

    private final void initWebview() {
        J.y(AbstractC0557a.z(this), Q.f2190b, new C05001(null), 2);
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setWebViewClient(new WebViewClient() { // from class: com.stepos.policy.sdk.activity.PolicyWebViewActivity.initWebview.2
                @Override // android.webkit.WebViewClient
                @RequiresApi(21)
                @Nullable
                public WebResourceResponse shouldInterceptRequest(@Nullable WebView view, @Nullable WebResourceRequest request) throws IOException {
                    Uri url;
                    if (request != null) {
                        try {
                            url = request.getUrl();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            PolicySdkLogUtils.INSTANCE.e("shouldInterceptRequest", " err = " + e4.getMessage() + ": ");
                        }
                    } else {
                        url = null;
                    }
                    String strValueOf = String.valueOf(url);
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                    companion.d("shouldInterceptRequest", "url = " + strValueOf + ": ");
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                    String lowerCase = strValueOf.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".pdf", false, 2, null) && PolicyWebViewActivity.this.mContext != null) {
                        companion.d("shouldInterceptRequest", "pdf url = ".concat(strValueOf));
                        Context context = PolicyWebViewActivity.this.mContext;
                        if (context != null) {
                            PolicySdkToolsUtils.Companion companion2 = PolicySdkToolsUtils.INSTANCE;
                            Uri uri = Uri.parse(strValueOf);
                            Intrinsics.checkNotNullExpressionValue(uri, "parse(url)");
                            companion2.startBrowser(context, uri);
                        }
                        return super.shouldInterceptRequest(view, request);
                    }
                    boolean zIsNetworkAvailable = PolicySdkNetworkUtil.isNetworkAvailable(PolicyWebViewActivity.this.mActivity);
                    companion.d("shouldInterceptRequest", "isAgree = " + PolicyWebViewActivity.this.getIsAgree() + " | isNetworkAvailable = " + zIsNetworkAvailable);
                    if (!zIsNetworkAvailable || PolicyWebViewActivity.this.getIsAgree() == 0) {
                        companion.d("shouldInterceptRequest", "url = " + strValueOf + ": ");
                        Context context2 = PolicyWebViewActivity.this.mContext;
                        if (context2 != null) {
                            PolicyWebViewActivity policyWebViewActivity = PolicyWebViewActivity.this;
                            Locale locale2 = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                            String lowerCase2 = strValueOf.toLowerCase(locale2);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                            if (StringsKt__StringsJVMKt.endsWith$default(lowerCase2, ".css", false, 2, null) && policyWebViewActivity.mContext != null) {
                                String customPolicyCSSFileName = PolicyManager.INSTANCE.getCustomPolicyCSSFileName();
                                try {
                                    companion.d("shouldInterceptRequest", "PolicyManager.customPolicyCSSFileName = " + customPolicyCSSFileName + ": ");
                                    if (TextUtils.isEmpty(customPolicyCSSFileName)) {
                                        customPolicyCSSFileName = "policysdk_stepos_style.css";
                                        companion.d("shouldInterceptRequest", "policysdk backup cssFileName = policysdk_stepos_style.css: ");
                                    }
                                    if (!TextUtils.isEmpty(customPolicyCSSFileName) && PolicySdkToolsUtils.INSTANCE.checkFileExistsInAssets(context2, customPolicyCSSFileName)) {
                                        InputStream inputStreamOpen = context2.getAssets().open(customPolicyCSSFileName);
                                        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "it.assets.open(cssFileName)");
                                        WebResourceResponse webResourceResponse = new WebResourceResponse("text/css", Constants.UTF_8_CODE, inputStreamOpen);
                                        companion.d("shouldInterceptRequest", "getAssets css = " + customPolicyCSSFileName + ": ");
                                        return webResourceResponse;
                                    }
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                    PolicySdkLogUtils.INSTANCE.e("shouldInterceptRequest", " err = " + e5.getMessage() + ": ");
                                }
                            }
                        }
                    } else {
                        companion.d("shouldInterceptRequest", " isNetworkAvailable load online css");
                    }
                    return super.shouldInterceptRequest(view, request);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull String url) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(url, "url");
                    PolicySdkLogUtils.INSTANCE.d("shouldOverrideUrlLoading", "url = " + url);
                    Context context = PolicyWebViewActivity.this.mContext;
                    if (context == null) {
                        return true;
                    }
                    PolicySdkToolsUtils.Companion companion = PolicySdkToolsUtils.INSTANCE;
                    Uri uri = Uri.parse(url);
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(url)");
                    companion.startBrowser(context, uri);
                    return true;
                }
            });
        }
        WebView webView2 = this.mWebView;
        WebSettings settings = webView2 != null ? webView2.getSettings() : null;
        if (settings != null) {
            settings.setLoadWithOverviewMode(true);
        }
        if (settings != null) {
            settings.setUseWideViewPort(true);
        }
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        if (settings != null) {
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }
        if (settings != null) {
            settings.setDomStorageEnabled(true);
        }
        if (settings != null) {
            settings.setAllowFileAccess(true);
        }
        if (settings != null) {
            settings.setAllowContentAccess(true);
        }
        PolicySdkLogUtils.INSTANCE.d("PolicyWebViewActivity", "initWebview: " + this.mUri);
        WebView webView3 = this.mWebView;
        if (webView3 == null) {
            return;
        }
        webView3.setOverScrollMode(2);
    }

    private final void showLoadDataView(int errorCode, Bundle bundle) {
        if (errorCode == -10003) {
            showNotNetWorkView();
        } else if (errorCode == 0 && bundle != null) {
            fetchPolicyData(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNetWorkErrorView$lambda$5(PolicyWebViewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = this$0.bundle;
        if (bundle != null) {
            this$0.fetchPolicyData(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$8(PolicyWebViewActivity this$0, View view) {
        Context context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Context, Unit> function1 = webViewSettingBtnCallback;
        if (function1 != null && (context = this$0.mContext) != null) {
            function1.invoke(context);
        }
        this$0.startActivity(new Intent("android.settings.SETTINGS"));
        this$0.mNeedLoadData = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void webViewLoadData$lambda$9(PolicyWebViewActivity this$0, String mUri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mUri, "$mUri");
        try {
            WebView webView = this$0.mWebView;
            if (webView != null) {
                webView.setVisibility(0);
            }
            PolicySDKLoadDataView policySDKLoadDataView = this$0.loadDataView;
            if (policySDKLoadDataView != null) {
                policySDKLoadDataView.hideEmptyView();
            }
            WebView webView2 = this$0.mWebView;
            if (webView2 != null) {
                webView2.loadData("", "text/html", Constants.UTF_8_CODE);
            }
            WebView webView3 = this$0.mWebView;
            if (webView3 != null) {
                webView3.loadUrl(mUri);
            }
        } catch (Exception e4) {
            PolicySdkLogUtils.INSTANCE.e("PolicyWebViewActivity", "webViewLoadData Exception: " + e4.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
    public final void fetchPolicyData(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showProgress();
        }
        String string = bundle.getString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = bundle.getString(PolicySdkConstants.BUNDLE_KEY_CATEGORY);
        long j4 = bundle.getLong(PolicySdkConstants.BUNDLE_KEY_VERSION);
        if (!PolicySdkNetworkUtil.isNetworkAvailable(this.mActivity)) {
            PolicySDKLoadDataView policySDKLoadDataView2 = this.loadDataView;
            if (policySDKLoadDataView2 != null) {
                policySDKLoadDataView2.hideProgress();
            }
            showNotNetWorkView();
            return;
        }
        try {
            PolicySdk.getPolicy(string, (String) objectRef.element, Long.valueOf(j4), new PolicySdk.PolicySdkCallback() { // from class: com.stepos.policy.sdk.activity.PolicyWebViewActivity.fetchPolicyData.1
                @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                public void getResult(@Nullable PolicySdkResultBean policySdkResultBean) {
                    PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
                    StringBuilder sb = new StringBuilder("getPolicy  getResult = ");
                    sb.append(policySdkResultBean != null ? Integer.valueOf(policySdkResultBean.getCode()) : null);
                    sb.append(' ');
                    companion.d("fetchPolicyData", sb.toString());
                    J.y(AbstractC0557a.z(PolicyWebViewActivity.this), null, new PolicyWebViewActivity$fetchPolicyData$1$getResult$1(PolicyWebViewActivity.this, policySdkResultBean, objectRef, null), 3);
                }
            });
        } catch (Exception e4) {
            showNetWorkErrorView();
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder("Exception= ");
            e4.printStackTrace();
            sb.append(Unit.INSTANCE);
            sb.append(' ');
            companion.d("fetchPolicyData", sb.toString());
        }
    }

    @Nullable
    public final PolicySDKLoadDataView getLoadDataView() {
        return this.loadDataView;
    }

    public final boolean getMNeedLoadData() {
        return this.mNeedLoadData;
    }

    /* renamed from: isAgree, reason: from getter */
    public final int getIsAgree() {
        return this.isAgree;
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.activity.o, android.app.Activity
    public void onBackPressed() {
        WebView webView = this.mWebView;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
            return;
        }
        WebView webView2 = this.mWebView;
        if (webView2 != null) {
            webView2.goBack();
        }
        J.y(AbstractC0557a.z(this), null, new C05011(null), 3);
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            HookMacAddressUtils.INSTANCE.hookMacAddress(this);
            setContentView(R.layout.activity_policysdk_webview);
            setViewContainerPadding((ViewGroup) findViewById(R.id.root_layout));
            setHomeAsUpEnabled();
            WeakReference weakReference = new WeakReference(this);
            this.mActivity = (Activity) new WeakReference(this).get();
            this.mContext = (Context) weakReference.get();
            this.mWebView = (WebView) findViewById(R.id.webView);
            this.loadDataView = (PolicySDKLoadDataView) findViewById(R.id.load_data_view);
            Bundle extras = getIntent().getExtras();
            this.bundle = extras;
            if (extras != null) {
                this.mUri = extras.getString("uri");
                Bundle bundle = this.bundle;
                this.mTitle = bundle != null ? bundle.getString("title") : null;
            }
            AbstractC0860e supportActionBar = getSupportActionBar();
            if (supportActionBar != null && !TextUtils.isEmpty(this.mTitle)) {
                supportActionBar.r(this.mTitle);
            }
            fitStatusBarWithUiMode();
            initWebview();
            String str = this.mUri;
            if (str == null || !StringsKt__StringsJVMKt.equals$default(str, PolicySdkConstants.ONLINE_POLICY_WEB_VIEW, false, 2, null)) {
                String str2 = this.mUri;
                if (str2 != null) {
                    webViewLoadData(str2);
                    return;
                }
                return;
            }
            Bundle bundle2 = this.bundle;
            Integer numValueOf = bundle2 != null ? Integer.valueOf(bundle2.getInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY)) : null;
            if (numValueOf != null) {
                showLoadDataView(numValueOf.intValue(), this.bundle);
            }
        } catch (Exception e4) {
            PolicySdkLogUtils.INSTANCE.e("onCreate", "PolicyWebViewActivity  Exception = " + e4.getMessage());
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public void onDestroy() {
        INSTANCE.setSettingBtnCallback(null);
        WebView webView = this.mWebView;
        ViewParent parent = webView != null ? webView.getParent() : null;
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mWebView);
        }
        WebView webView2 = this.mWebView;
        if (webView2 != null) {
            webView2.destroy();
        }
        HookMacAddressUtils.INSTANCE.closeHookMacAddress();
        this.mActivity = null;
        this.mContext = null;
        super.onDestroy();
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, android.app.Activity
    public void onResume() {
        Bundle bundle;
        super.onResume();
        if (!this.mNeedLoadData || (bundle = this.bundle) == null) {
            return;
        }
        fetchPolicyData(bundle);
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k
    public boolean onSupportNavigateUp() {
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        StringBuilder sb = new StringBuilder("mWebView?.canGoBack() = ");
        WebView webView = this.mWebView;
        sb.append(webView != null ? Boolean.valueOf(webView.canGoBack()) : null);
        companion.d("onSupportNavigateUp", sb.toString());
        WebView webView2 = this.mWebView;
        if (webView2 == null || !webView2.canGoBack()) {
            WebView webView3 = this.mWebView;
            if (webView3 != null) {
                webView3.clearHistory();
            }
            finish();
        } else {
            WebView webView4 = this.mWebView;
            if (webView4 != null) {
                webView4.goBack();
            }
            J.y(AbstractC0557a.z(this), null, new C05021(null), 3);
        }
        return super.onSupportNavigateUp();
    }

    public final void setAgree(int i4) {
        this.isAgree = i4;
    }

    public final void setHomeAsUpEnabled() {
        try {
            AbstractC0860e supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.m();
            }
            AbstractC0860e supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.l(true);
            }
            AbstractC0860e supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.o(true);
            }
        } catch (Exception unused) {
        }
    }

    public final void setLoadDataView(@Nullable PolicySDKLoadDataView policySDKLoadDataView) {
        this.loadDataView = policySDKLoadDataView;
    }

    public final void setMNeedLoadData(boolean z4) {
        this.mNeedLoadData = z4;
    }

    public final void setViewContainerPadding(@Nullable ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        SmartBarPaddingUtil.setPaddingActionBar(this, viewGroup);
    }

    public final void showNetWorkErrorView() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showEmptyView(R.string.policy_sdk_network_error, R.drawable.policy_mz_ic_empty_view_no_network, new a(this, 1), true, R.string.policy_sdk_network_retry);
        }
    }

    public final void showNotNetWorkView() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showEmptyView(R.string.policy_stepos_wif_setting_dialog_message, R.drawable.policy_mz_ic_empty_view_no_network, new a(this, 0), true, R.string.policy_sdk_btn_setting_network);
        }
    }

    public final void webViewLoadData(@NotNull String mUri) {
        Intrinsics.checkNotNullParameter(mUri, "mUri");
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.post(new o(15, this, mUri));
        }
    }
}
