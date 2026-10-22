package com.stepos.policy.sdk.activity;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LifecycleOwnerKt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.R;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicyHtmlLinkHandler;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SmartBarPaddingUtil;
import com.stepos.policy.sdk.widget.PolicySDKLoadDataView;
import j9.m;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import org.java_websocket.WebSocketImpl;
import stepos.support.v7.app.AbstractActivityC1962k;
import stepos.support.v7.app.AbstractC1955d;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\bJ\u0019\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00122\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b#\u0010 J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u0019\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b,\u0010\u0015R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010>R\u0016\u0010?\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/stepos/policy/sdk/activity/PolicyHtmlViewerActivity;", "Lstepos/support/v7/app/k;", AppAgent.CONSTRUCT, "()V", "Landroid/os/Bundle;", "savedInstanceState", "LC7/r;", AppAgent.ON_CREATE, "(Landroid/os/Bundle;)V", "Landroid/view/ViewGroup;", "viewGroup", "setViewContainerPadding", "(Landroid/view/ViewGroup;)V", "setHomeAsUpEnabled", "", "onSupportNavigateUp", "()Z", "onDestroy", "", PolicyHtmlViewerActivity.EXTRA_URI, "loadPolicyHtml", "(Ljava/lang/String;)V", "bundle", "fetchOnlinePolicy", QueryAlgorithmBundle.KEY_CATEGORY, "tryLoadLocalPolicy", "(Ljava/lang/String;)Z", "resolveLocalPolicyContentUri", "(Ljava/lang/String;)Ljava/lang/String;", BffConstant.Type.Url, "linkText", "openPolicyLink", "(Ljava/lang/String;Ljava/lang/String;)V", "html", "contentUri", "displayHtml", "showProgress", "hideProgress", "showNoDataView", "showNetWorkErrorView", "showNotNetWorkView", "applyBottomContentPadding", "applyViewerTheme", PolicyHtmlViewerActivity.EXTRA_TITLE, "applyActivityTitle", "Landroid/app/Activity;", "mActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "mUri", "Ljava/lang/String;", "Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;", "loadDataView", "Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;", "Landroidx/core/widget/NestedScrollView;", "htmlScrollView", "Landroidx/core/widget/NestedScrollView;", "Landroid/widget/TextView;", "htmlContentView", "Landroid/widget/TextView;", "Landroid/os/Bundle;", "onlineMode", "Z", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyHtmlViewerActivity extends AbstractActivityC1962k {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ONLINE_MODE = "online_mode";
    private static final String EXTRA_TITLE = "title";
    private static final String EXTRA_URI = "uri";
    private static final String TAG = "PolicyHtmlViewerActivity";
    private static k settingBtnCallback;
    private Bundle bundle;
    private TextView htmlContentView;
    private NestedScrollView htmlScrollView;
    private PolicySDKLoadDataView loadDataView;
    private Activity mActivity;
    private Context mContext;
    private String mUri;
    private boolean onlineMode;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ7\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/policy/sdk/activity/PolicyHtmlViewerActivity$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "Landroid/content/Context;", "LC7/r;", "callback", "setSettingBtnCallback", "(LS7/k;)V", "context", "", PolicyHtmlViewerActivity.EXTRA_URI, PolicyHtmlViewerActivity.EXTRA_TITLE, "Landroid/os/Bundle;", "bundle", "openPolicy", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "start", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "startOnline", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "EXTRA_ONLINE_MODE", "Ljava/lang/String;", "EXTRA_TITLE", "EXTRA_URI", "TAG", "settingBtnCallback", "LS7/k;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ void openPolicy$default(Companion companion, Context context, String str, String str2, Bundle bundle, int i, Object obj) {
            if ((i & 8) != 0) {
                bundle = null;
            }
            companion.openPolicy(context, str, str2, bundle);
        }

        public final void openPolicy(Context context, String str, String str2) {
            kotlin.jvm.internal.k.f(context, "context");
            openPolicy$default(this, context, str, str2, null, 8, null);
        }

        public final void setSettingBtnCallback(k callback) {
            PolicyHtmlViewerActivity.settingBtnCallback = callback;
        }

        public final void start(Context context, String uri, String title) {
            kotlin.jvm.internal.k.f(context, "context");
            Intent intent = new Intent(context, (Class<?>) PolicyHtmlViewerActivity.class);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_URI, uri);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_TITLE, title);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }

        public final void startOnline(Context context, String title, Bundle bundle) {
            kotlin.jvm.internal.k.f(context, "context");
            Intent intent = new Intent(context, (Class<?>) PolicyHtmlViewerActivity.class);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_TITLE, title);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_ONLINE_MODE, true);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }

        private Companion() {
        }

        public final void openPolicy(Context context, String uri, String title, Bundle bundle) {
            kotlin.jvm.internal.k.f(context, "context");
            if (PolicySdkConstants.isOnlinePolicyViewerUri(uri)) {
                startOnline(context, title, bundle);
            } else {
                start(context, uri, title);
            }
        }
    }

    @c(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1", f = "PolicyHtmlViewerActivity.kt", l = {WebSocketImpl.DEFAULT_PORT}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11451 extends SuspendLambda implements n {
        final /* synthetic */ String $uri;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11451(String str, H7.c<? super C11451> cVar) {
            super(2, cVar);
            this.$uri = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return PolicyHtmlViewerActivity.this.new C11451(this.$uri, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0083 A[Catch: all -> 0x0011, TRY_LEAVE, TryCatch #0 {all -> 0x0011, blocks: (B:6:0x000d, B:19:0x003d, B:26:0x0056, B:28:0x0075, B:31:0x007c, B:32:0x0083), top: B:40:0x0007 }] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.String r0 = "loadPolicyHtml failed: "
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r2 = r9.label
                r3 = 1
                if (r2 == 0) goto L1e
                if (r2 != r3) goto L16
                int r1 = r9.I$0
                kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                goto L3d
            L11:
                r10 = move-exception
                goto L8e
            L14:
                r10 = move-exception
                goto L56
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1e:
                kotlin.b.b(r10)
                r10 = 0
                u9.d r2 = m9.AbstractC1691I.f5315a     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                u9.c r2 = u9.c.f6743a     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 r4 = new com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r5 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                java.lang.String r6 = r9.$uri     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                r7 = 0
                r4.<init>(r5, r6, r7)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                r9.I$0 = r10     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                r9.label = r3     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                java.lang.Object r2 = m9.AbstractC1683A.w(r2, r4, r9)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                if (r2 != r1) goto L3b
                return r1
            L3b:
                r1 = r10
                r10 = r2
            L3d:
                java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r2 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                java.lang.String r3 = r9.$uri     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$displayHtml(r2, r10, r3)     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                if (r1 != 0) goto L8b
            L48:
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r9 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$hideProgress(r9)
                goto L8b
            L4e:
                r0 = move-exception
                r1 = r10
                r10 = r0
                goto L8e
            L52:
                r1 = move-exception
                r8 = r1
                r1 = r10
                r10 = r8
            L56:
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r2 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE     // Catch: java.lang.Throwable -> L11
                java.lang.String r3 = "PolicyHtmlViewerActivity"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L11
                r4.<init>(r0)     // Catch: java.lang.Throwable -> L11
                java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L11
                r4.append(r10)     // Catch: java.lang.Throwable -> L11
                java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> L11
                r2.e(r3, r10)     // Catch: java.lang.Throwable -> L11
                java.lang.String r10 = r9.$uri     // Catch: java.lang.Throwable -> L11
                java.lang.String r10 = com.stepos.policy.sdk.util.PolicyHtmlLinkHandler.resolveCategoryForCloudPolicyUrl(r10)     // Catch: java.lang.Throwable -> L11
                if (r10 == 0) goto L83
                int r0 = r10.length()     // Catch: java.lang.Throwable -> L11
                if (r0 != 0) goto L7c
                goto L83
            L7c:
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r0 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L11
                boolean r1 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$tryLoadLocalPolicy(r0, r10)     // Catch: java.lang.Throwable -> L11
                goto L88
            L83:
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r10 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L11
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$showNoDataView(r10)     // Catch: java.lang.Throwable -> L11
            L88:
                if (r1 != 0) goto L8b
                goto L48
            L8b:
                C7.r r9 = C7.r.f317a
                return r9
            L8e:
                if (r1 != 0) goto L95
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r9 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$hideProgress(r9)
            L95:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.C11451.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11451) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private final void applyActivityTitle(String title) {
        if (title == null || m.s0(title)) {
            return;
        }
        try {
            AbstractC1955d supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.l();
            }
            AbstractC1955d supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.q(title);
            }
        } catch (Exception unused) {
        }
        setTitle(title);
    }

    private final void applyBottomContentPadding() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            SmartBarPaddingUtil.applyBottomNavigationPadding(nestedScrollView, getResources().getDimensionPixelSize(R.dimen.policy_sdk_html_viewer_bottom_padding));
        }
    }

    private final void applyViewerTheme() {
        int iViewerBackgroundColor = PolicyHtmlDisplayAdapter.viewerBackgroundColor(this);
        View viewFindViewById = findViewById(R.id.root_layout);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(iViewerBackgroundColor);
        }
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setBackgroundColor(iViewerBackgroundColor);
        }
        TextView textView = this.htmlContentView;
        if (textView != null) {
            textView.setBackgroundColor(iViewerBackgroundColor);
        }
        TextView textView2 = this.htmlContentView;
        if (textView2 != null) {
            textView2.setTextColor(PolicyHtmlDisplayAdapter.textColor(this));
        }
        SmartBarPaddingUtil.applyNavigationBarContrast(this, iViewerBackgroundColor, !PolicyHtmlDisplayAdapter.isDarkMode(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayHtml(String html, String contentUri) {
        if (m.s0(html)) {
            showNoDataView();
            return;
        }
        applyActivityTitle(PolicyHtmlDisplayAdapter.resolveDisplayTitle(PolicyHtmlDisplayAdapter.extractTitle(html), getIntent().getStringExtra(EXTRA_TITLE)));
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.scrollTo(0, 0);
        }
        NestedScrollView nestedScrollView2 = this.htmlScrollView;
        if (nestedScrollView2 != null) {
            nestedScrollView2.setVisibility(0);
        }
        TextView textView = this.htmlContentView;
        if (textView != null) {
            boolean zIsDarkMode = PolicyHtmlDisplayAdapter.isDarkMode(this);
            PolicyHtmlLinkHandler.INSTANCE.bindHtmlLinks(textView, PolicyHtmlDisplayAdapter.prepareHtml(html, zIsDarkMode), contentUri, zIsDarkMode, PolicyHtmlDisplayAdapter.linkColor(this), new n() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$displayHtml$1$1
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, (String) obj2);
                    return r.f317a;
                }

                public final void invoke(String url, String str) {
                    kotlin.jvm.internal.k.f(url, "url");
                    this.this$0.openPolicyLink(url, str);
                }
            }, new k() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$displayHtml$1$2
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return r.f317a;
                }

                public final void invoke(String url) {
                    kotlin.jvm.internal.k.f(url, "url");
                    PolicySdkToolsUtils.INSTANCE.startBrowser(this.this$0, url);
                }
            });
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.hideEmptyView();
        }
    }

    public static /* synthetic */ void displayHtml$default(PolicyHtmlViewerActivity policyHtmlViewerActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = policyHtmlViewerActivity.mUri;
        }
        policyHtmlViewerActivity.displayHtml(str, str2);
    }

    private final void fetchOnlinePolicy(Bundle bundle) {
        String string = bundle.getString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE);
        final String string2 = bundle.getString(PolicySdkConstants.BUNDLE_KEY_CATEGORY);
        long j5 = bundle.getLong(PolicySdkConstants.BUNDLE_KEY_VERSION);
        int i = bundle.getInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, 0);
        if (i == -10004) {
            showNetWorkErrorView();
            return;
        }
        if (i == -10003) {
            showNotNetWorkView();
            return;
        }
        if (!PolicySdkNetworkUtil.isNetworkAvailable(this.mActivity)) {
            tryLoadLocalPolicy(string2);
            return;
        }
        showProgress();
        try {
            PolicySdk.getPolicy(string, string2, Long.valueOf(j5), new PolicySdk.PolicySdkCallback() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.fetchOnlinePolicy.1
                @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                public void getResult(PolicySdkResultBean policySdkResultBean) {
                    AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(PolicyHtmlViewerActivity.this), null, new PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(PolicyHtmlViewerActivity.this, policySdkResultBean, string2, null), 3);
                }
            });
        } catch (Exception unused) {
            hideProgress();
            showNetWorkErrorView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideProgress() {
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadPolicyHtml(String uri) {
        showProgress();
        AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new C11451(uri, null), 3);
    }

    public static final void openPolicy(Context context, String str, String str2) {
        INSTANCE.openPolicy(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openPolicyLink(String url, String linkText) {
        String strResolveLocalPolicyContentUri;
        if (PolicySdkNetworkGate.shouldBlock() || !PolicySdkNetworkUtil.isNetworkAvailable(this)) {
            String strResolveCategoryForCloudPolicyUrl = PolicyHtmlLinkHandler.resolveCategoryForCloudPolicyUrl(url);
            if (strResolveCategoryForCloudPolicyUrl != null && strResolveCategoryForCloudPolicyUrl.length() != 0 && (strResolveLocalPolicyContentUri = resolveLocalPolicyContentUri(strResolveCategoryForCloudPolicyUrl)) != null) {
                INSTANCE.start(this, strResolveLocalPolicyContentUri, linkText);
                return;
            }
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
            StringBuilder sbW = B7.a.w("local policy link unresolved, url=", url, " category=", strResolveCategoryForCloudPolicyUrl, " blocked=");
            sbW.append(PolicySdkNetworkGate.shouldBlock());
            companion.d(TAG, sbW.toString());
        }
        INSTANCE.start(this, url, linkText);
    }

    private final String resolveLocalPolicyContentUri(String category) {
        String policyNewestPath;
        Context context;
        Context contextCreateDeviceProtectedStorageContext;
        PolicySdkResultBean policyNewestPath2 = PolicySdk.getPolicyNewestPath(this.mActivity, category);
        if (policyNewestPath2.getCode() != 0 && (context = this.mContext) != null && (contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext()) != null) {
            policyNewestPath2 = PolicySdk.getPolicyNewestPath(contextCreateDeviceProtectedStorageContext, category);
        }
        if (policyNewestPath2.getCode() != 0 || (policyNewestPath = policyNewestPath2.getPolicyNewestPath()) == null || policyNewestPath.length() == 0) {
            return null;
        }
        return FileProvider.getUriForFile(this, getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath2.getPolicyNewestPath())).toString();
    }

    public static final void setSettingBtnCallback(k kVar) {
        INSTANCE.setSettingBtnCallback(kVar);
    }

    private final void showNetWorkErrorView() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            PolicySDKLoadDataView.showEmptyView$default(policySDKLoadDataView, R.string.policy_sdk_network_error, R.drawable.policy_mz_ic_empty_view_no_network, new a(this, 0), false, 0, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNetWorkErrorView$lambda$5(PolicyHtmlViewerActivity this$0, View view) {
        kotlin.jvm.internal.k.f(this$0, "this$0");
        Bundle bundle = this$0.bundle;
        if (bundle != null) {
            this$0.fetchOnlinePolicy(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNoDataView() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            PolicySDKLoadDataView.showEmptyView$default(policySDKLoadDataView, R.string.policy_sdk_no_data, R.drawable.policy_mz_ic_empty_view_no_network, null, false, 0, 16, null);
        }
    }

    private final void showNotNetWorkView() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        k kVar = settingBtnCallback;
        View.OnClickListener kVar2 = kVar != null ? new G4.k(this, kVar, 1) : null;
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showEmptyView(R.string.policy_sdk_network_error, R.drawable.policy_mz_ic_empty_view_no_network, kVar2 == null ? new a(this, 1) : kVar2, kVar2 == null, R.string.policy_sdk_btn_setting_network);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$8$lambda$7(PolicyHtmlViewerActivity this$0, k callback, View view) {
        kotlin.jvm.internal.k.f(this$0, "this$0");
        kotlin.jvm.internal.k.f(callback, "$callback");
        Context context = this$0.mContext;
        if (context != null) {
            callback.invoke(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$9(PolicyHtmlViewerActivity this$0, View view) {
        kotlin.jvm.internal.k.f(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }

    private final void showProgress() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showProgress();
        }
    }

    public static final void start(Context context, String str, String str2) {
        INSTANCE.start(context, str, str2);
    }

    public static final void startOnline(Context context, String str, Bundle bundle) {
        INSTANCE.startOnline(context, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryLoadLocalPolicy(String category) {
        if (category == null || category.length() == 0) {
            showNoDataView();
            return false;
        }
        String strResolveLocalPolicyContentUri = resolveLocalPolicyContentUri(category);
        if (strResolveLocalPolicyContentUri != null) {
            loadPolicyHtml(strResolveLocalPolicyContentUri);
            return true;
        }
        showNoDataView();
        return false;
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_html_viewer);
        setViewContainerPadding((ViewGroup) findViewById(R.id.root_layout));
        setHomeAsUpEnabled();
        this.mActivity = this;
        this.mContext = this;
        this.loadDataView = (PolicySDKLoadDataView) findViewById(R.id.load_data_view);
        this.htmlScrollView = (NestedScrollView) findViewById(R.id.html_scroll_view);
        this.htmlContentView = (TextView) findViewById(R.id.html_content);
        applyBottomContentPadding();
        applyViewerTheme();
        this.bundle = getIntent().getExtras();
        this.mUri = getIntent().getStringExtra(EXTRA_URI);
        this.onlineMode = getIntent().getBooleanExtra(EXTRA_ONLINE_MODE, false);
        applyActivityTitle(getIntent().getStringExtra(EXTRA_TITLE));
        boolean z10 = this.onlineMode;
        r rVar = null;
        r rVar2 = r.f317a;
        if (z10) {
            Bundle bundle = this.bundle;
            if (bundle != null) {
                fetchOnlinePolicy(bundle);
                rVar = rVar2;
            }
            if (rVar == null) {
                showNoDataView();
                return;
            }
            return;
        }
        String str = this.mUri;
        if (str != null) {
            loadPolicyHtml(str);
            rVar = rVar2;
        }
        if (rVar == null) {
            showNoDataView();
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (isFinishing()) {
            settingBtnCallback = null;
        }
        super.onDestroy();
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public final void setHomeAsUpEnabled() {
        try {
            AbstractC1955d supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.k();
            }
            AbstractC1955d supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.j(true);
            }
            AbstractC1955d supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.o(true);
            }
        } catch (Exception unused) {
        }
    }

    public final void setViewContainerPadding(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        SmartBarPaddingUtil.setPaddingActionBar(this, viewGroup);
    }

    public static final void openPolicy(Context context, String str, String str2, Bundle bundle) {
        INSTANCE.openPolicy(context, str, str2, bundle);
    }
}
