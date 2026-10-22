package com.stepos.policy.sdk.activity;

import La.H;
import Ua.C1060i;
import Ua.M;
import Y8.t;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.C1398p;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.R$dimen;
import com.stepos.policy.sdk.R$drawable;
import com.stepos.policy.sdk.R$id;
import com.stepos.policy.sdk.R$layout;
import com.stepos.policy.sdk.R$string;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.util.InPageCloudPolicyTarget;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicyHtmlLinkHandler;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SmartBarPaddingUtil;
import com.stepos.policy.sdk.widget.PolicySDKLoadDataView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5074l;
import stepos.support.v7.app.d;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0003J\u0019\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\"\u0010\bJ\u0019\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b$\u0010\fJ\u0017\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0014¢\u0006\u0004\b,\u0010\u0003R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010>R\u0016\u0010?\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/stepos/policy/sdk/activity/PolicyHtmlViewerActivity;", "Lstepos/support/v7/app/d;", "<init>", "()V", "", PolicyHtmlViewerActivity.EXTRA_URI, "LY8/t;", "loadPolicyHtml", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "bundle", "fetchOnlinePolicy", "(Landroid/os/Bundle;)V", QueryAlgorithmBundle.KEY_CATEGORY, "", "tryLoadLocalPolicy", "(Ljava/lang/String;)Z", "resolveLocalPolicyContentUri", "(Ljava/lang/String;)Ljava/lang/String;", "url", "linkText", "openPolicyLink", "(Ljava/lang/String;Ljava/lang/String;)V", "html", "contentUri", "displayHtml", "showProgress", "hideProgress", "showNoDataView", "showNetWorkErrorView", "showNotNetWorkView", "applyBottomContentPadding", "applyViewerTheme", "title", "applyActivityTitle", "savedInstanceState", "onCreate", "Landroid/view/ViewGroup;", "viewGroup", "setViewContainerPadding", "(Landroid/view/ViewGroup;)V", "setHomeAsUpEnabled", "onSupportNavigateUp", "()Z", "onDestroy", "Landroid/app/Activity;", "mActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "mUri", "Ljava/lang/String;", "Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;", "loadDataView", "Lcom/stepos/policy/sdk/widget/PolicySDKLoadDataView;", "Landroidx/core/widget/NestedScrollView;", "htmlScrollView", "Landroidx/core/widget/NestedScrollView;", "Landroid/widget/TextView;", "htmlContentView", "Landroid/widget/TextView;", "Landroid/os/Bundle;", "onlineMode", "Z", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity extends d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ONLINE_MODE = "online_mode";
    private static final String EXTRA_TITLE = "title";
    private static final String EXTRA_URI = "uri";
    private static final String TAG = "PolicyHtmlViewerActivity";
    private static InterfaceC5074l<? super Context, t> settingBtnCallback;
    private Bundle bundle;
    private TextView htmlContentView;
    private NestedScrollView htmlScrollView;
    private PolicySDKLoadDataView loadDataView;
    private Activity mActivity;
    private Context mContext;
    private String mUri;
    private boolean onlineMode;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ7\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/policy/sdk/activity/PolicyHtmlViewerActivity$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Landroid/content/Context;", "LY8/t;", "callback", "setSettingBtnCallback", "(Lp9/l;)V", "context", "", PolicyHtmlViewerActivity.EXTRA_URI, "title", "Landroid/os/Bundle;", "bundle", "openPolicy", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "start", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "startOnline", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "EXTRA_ONLINE_MODE", "Ljava/lang/String;", "EXTRA_TITLE", "EXTRA_URI", "TAG", "settingBtnCallback", "Lp9/l;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ void openPolicy$default(Companion companion, Context context, String str, String str2, Bundle bundle, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                bundle = null;
            }
            companion.openPolicy(context, str, str2, bundle);
        }

        public final void openPolicy(Context context, String str, String str2) {
            p.i(context, "context");
            openPolicy$default(this, context, str, str2, null, 8, null);
        }

        public final void setSettingBtnCallback(InterfaceC5074l<? super Context, t> callback) {
            PolicyHtmlViewerActivity.settingBtnCallback = callback;
        }

        public final void start(Context context, String uri, String title) {
            p.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) PolicyHtmlViewerActivity.class);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_URI, uri);
            intent.putExtra("title", title);
            if (!(context instanceof Activity)) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            context.startActivity(intent);
        }

        public final void startOnline(Context context, String title, Bundle bundle) {
            p.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) PolicyHtmlViewerActivity.class);
            intent.putExtra("title", title);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_ONLINE_MODE, true);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            context.startActivity(intent);
        }

        private Companion() {
        }

        public final void openPolicy(Context context, String uri, String title, Bundle bundle) {
            p.i(context, "context");
            if (PolicySdkConstants.isOnlinePolicyViewerUri(uri)) {
                startOnline(context, title, bundle);
            } else {
                start(context, uri, title);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InPageCloudPolicyTarget.values().length];
            try {
                iArr[InPageCloudPolicyTarget.IN_APP_CDN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InPageCloudPolicyTarget.LOCAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InPageCloudPolicyTarget.BROWSER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
    @InterfaceC4112d(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1", f = "PolicyHtmlViewerActivity.kt", l = {81}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38661 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ String $uri;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38661(String str, InterfaceC4014c<? super C38661> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$uri = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return PolicyHtmlViewerActivity.this.new C38661(this.$uri, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C38661) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0089 A[Catch: all -> 0x0011, TRY_LEAVE, TryCatch #0 {all -> 0x0011, blocks: (B:6:0x000d, B:19:0x003d, B:26:0x0057, B:28:0x007b, B:31:0x0082, B:32:0x0089), top: B:40:0x0007 }] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                int r0 = r8.I$0
                kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                goto L3d
            L11:
                r9 = move-exception
                goto L94
            L14:
                r9 = move-exception
                goto L57
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1e:
                kotlin.C4849c.b(r9)
                r9 = 0
                Ua.I r1 = Ua.Y.b()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 r3 = new com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r4 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                java.lang.String r5 = r8.$uri     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                r6 = 0
                r3.<init>(r4, r5, r6)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                r8.I$0 = r9     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                r8.label = r2     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                java.lang.Object r1 = Ua.C1056g.j(r1, r3, r8)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                if (r1 != r0) goto L3b
                return r0
            L3b:
                r0 = r9
                r9 = r1
            L3d:
                java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r1 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                java.lang.String r2 = r8.$uri     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$displayHtml(r1, r9, r2)     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
                if (r0 != 0) goto L91
            L48:
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r8 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$hideProgress(r8)
                goto L91
            L4e:
                r0 = move-exception
                r7 = r0
                r0 = r9
                r9 = r7
                goto L94
            L53:
                r0 = move-exception
                r7 = r0
                r0 = r9
                r9 = r7
            L57:
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.INSTANCE     // Catch: java.lang.Throwable -> L11
                java.lang.String r2 = "PolicyHtmlViewerActivity"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L11
                r3.<init>()     // Catch: java.lang.Throwable -> L11
                java.lang.String r4 = "loadPolicyHtml failed: "
                r3.append(r4)     // Catch: java.lang.Throwable -> L11
                java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L11
                r3.append(r9)     // Catch: java.lang.Throwable -> L11
                java.lang.String r9 = r3.toString()     // Catch: java.lang.Throwable -> L11
                r1.e(r2, r9)     // Catch: java.lang.Throwable -> L11
                java.lang.String r9 = r8.$uri     // Catch: java.lang.Throwable -> L11
                java.lang.String r9 = com.stepos.policy.sdk.util.PolicyHtmlLinkHandler.resolveCategoryForCloudPolicyUrl(r9)     // Catch: java.lang.Throwable -> L11
                if (r9 == 0) goto L89
                int r1 = r9.length()     // Catch: java.lang.Throwable -> L11
                if (r1 != 0) goto L82
                goto L89
            L82:
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r1 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L11
                boolean r0 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$tryLoadLocalPolicy(r1, r9)     // Catch: java.lang.Throwable -> L11
                goto L8e
            L89:
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r9 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L11
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$showNoDataView(r9)     // Catch: java.lang.Throwable -> L11
            L8e:
                if (r0 != 0) goto L91
                goto L48
            L91:
                Y8.t r8 = Y8.t.f7040a
                return r8
            L94:
                if (r0 != 0) goto L9b
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r8 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$hideProgress(r8)
            L9b:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.C38661.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void applyActivityTitle(String title) {
        if (title == null || H.x0(title)) {
            return;
        }
        try {
            stepos.support.v7.app.a supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.r(true);
            }
            stepos.support.v7.app.a supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.u(title);
            }
        } catch (Exception unused) {
        }
        setTitle(title);
    }

    private final void applyBottomContentPadding() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            SmartBarPaddingUtil.applyBottomNavigationPadding(nestedScrollView, getResources().getDimensionPixelSize(R$dimen.policy_sdk_html_viewer_bottom_padding));
        }
    }

    private final void applyViewerTheme() {
        int iViewerBackgroundColor = PolicyHtmlDisplayAdapter.viewerBackgroundColor(this);
        View viewFindViewById = findViewById(R$id.root_layout);
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
        if (H.x0(html)) {
            showNoDataView();
            return;
        }
        applyActivityTitle(PolicyHtmlDisplayAdapter.resolveDisplayTitle(PolicyHtmlDisplayAdapter.extractTitle(html), getIntent().getStringExtra("title")));
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
            PolicyHtmlLinkHandler.INSTANCE.bindHtmlLinks(textView, PolicyHtmlDisplayAdapter.prepareHtml(html, zIsDarkMode), contentUri, zIsDarkMode, PolicyHtmlDisplayAdapter.linkColor(this), new p9.p<String, String, t>() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$displayHtml$1$1
                {
                    super(2);
                }

                @Override // p9.p
                public /* bridge */ /* synthetic */ t invoke(String str, String str2) {
                    invoke2(str, str2);
                    return t.f7040a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String url, String str) {
                    p.i(url, "url");
                    this.this$0.openPolicyLink(url, str);
                }
            }, new InterfaceC5074l<String, t>() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$displayHtml$1$2
                {
                    super(1);
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(String str) {
                    invoke2(str);
                    return t.f7040a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String url) {
                    p.i(url, "url");
                    PolicySdkToolsUtils.INSTANCE.startBrowser(this.this$0, url);
                }
            });
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.hideEmptyView();
        }
    }

    public static /* synthetic */ void displayHtml$default(PolicyHtmlViewerActivity policyHtmlViewerActivity, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = policyHtmlViewerActivity.mUri;
        }
        policyHtmlViewerActivity.displayHtml(str, str2);
    }

    private final void fetchOnlinePolicy(Bundle bundle) {
        String string = bundle.getString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE);
        final String string2 = bundle.getString(PolicySdkConstants.BUNDLE_KEY_CATEGORY);
        long j10 = bundle.getLong(PolicySdkConstants.BUNDLE_KEY_VERSION);
        int i10 = bundle.getInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, 0);
        if (i10 == -10004) {
            showNetWorkErrorView();
            return;
        }
        if (i10 == -10003) {
            showNotNetWorkView();
            return;
        }
        if (!PolicySdkNetworkUtil.isNetworkAvailable(this.mActivity)) {
            tryLoadLocalPolicy(string2);
            return;
        }
        showProgress();
        try {
            PolicySdk.getPolicy(string, string2, Long.valueOf(j10), new PolicySdk.PolicySdkCallback() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.fetchOnlinePolicy.1
                @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                public void getResult(PolicySdkResultBean policySdkResultBean) {
                    C1060i.d(C1398p.a(PolicyHtmlViewerActivity.this), null, null, new PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(PolicyHtmlViewerActivity.this, policySdkResultBean, string2, null), 3, null);
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
        C1060i.d(C1398p.a(this), null, null, new C38661(uri, null), 3, null);
    }

    public static final void openPolicy(Context context, String str, String str2) {
        INSTANCE.openPolicy(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openPolicyLink(String url, String linkText) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[PolicyHtmlLinkHandler.resolveInPageCloudPolicyTarget(url, new InterfaceC5074l<String, Boolean>() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$openPolicyLink$target$1
            {
                super(1);
            }

            @Override // p9.InterfaceC5074l
            public final Boolean invoke(String cat) {
                p.i(cat, "cat");
                return Boolean.valueOf(this.this$0.resolveLocalPolicyContentUri(cat) != null);
            }
        }, !PolicySdkNetworkGate.shouldBlock() && PolicySdkNetworkUtil.isNetworkAvailable(this)).ordinal()];
        if (i10 == 1) {
            INSTANCE.start(this, url, linkText);
            return;
        }
        if (i10 == 2) {
            String strResolveLocalCategoryForInPageLink = PolicyHtmlLinkHandler.resolveLocalCategoryForInPageLink(url, new InterfaceC5074l<String, Boolean>() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$openPolicyLink$category$1
                {
                    super(1);
                }

                @Override // p9.InterfaceC5074l
                public final Boolean invoke(String cat) {
                    p.i(cat, "cat");
                    return Boolean.valueOf(this.this$0.resolveLocalPolicyContentUri(cat) != null);
                }
            });
            String strResolveLocalPolicyContentUri = strResolveLocalCategoryForInPageLink != null ? resolveLocalPolicyContentUri(strResolveLocalCategoryForInPageLink) : null;
            if (strResolveLocalPolicyContentUri != null) {
                INSTANCE.start(this, strResolveLocalPolicyContentUri, linkText);
                return;
            } else {
                PolicySdkToolsUtils.INSTANCE.startBrowser(this, url);
                return;
            }
        }
        if (i10 != 3) {
            return;
        }
        PolicySdkLogUtils.INSTANCE.d(TAG, "in-page cloud policy has no local file and SDK cannot use network, open browser url=" + url);
        PolicySdkToolsUtils.INSTANCE.startBrowser(this, url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveLocalPolicyContentUri(String category) {
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
        return androidx.core.content.b.getUriForFile(this, getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath2.getPolicyNewestPath())).toString();
    }

    public static final void setSettingBtnCallback(InterfaceC5074l<? super Context, t> interfaceC5074l) {
        INSTANCE.setSettingBtnCallback(interfaceC5074l);
    }

    private final void showNetWorkErrorView() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            PolicySDKLoadDataView.showEmptyView$default(policySDKLoadDataView, R$string.policy_sdk_network_error, R$drawable.policy_mz_ic_empty_view_no_network, new View.OnClickListener() { // from class: com.stepos.policy.sdk.activity.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PolicyHtmlViewerActivity.showNetWorkErrorView$lambda$6(this.f30576a, view);
                }
            }, false, 0, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNetWorkErrorView$lambda$6(PolicyHtmlViewerActivity this$0, View view) {
        p.i(this$0, "this$0");
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
            PolicySDKLoadDataView.showEmptyView$default(policySDKLoadDataView, R$string.policy_sdk_no_data, R$drawable.policy_mz_ic_empty_view_no_network, null, false, 0, 16, null);
        }
    }

    private final void showNotNetWorkView() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        final InterfaceC5074l<? super Context, t> interfaceC5074l = settingBtnCallback;
        View.OnClickListener onClickListener = interfaceC5074l != null ? new View.OnClickListener() { // from class: com.stepos.policy.sdk.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyHtmlViewerActivity.showNotNetWorkView$lambda$9$lambda$8(this.f30577a, interfaceC5074l, view);
            }
        } : null;
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showEmptyView(R$string.policy_sdk_network_error, R$drawable.policy_mz_ic_empty_view_no_network, onClickListener == null ? new View.OnClickListener() { // from class: com.stepos.policy.sdk.activity.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PolicyHtmlViewerActivity.showNotNetWorkView$lambda$10(this.f30579a, view);
                }
            } : onClickListener, onClickListener == null, R$string.policy_sdk_btn_setting_network);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$10(PolicyHtmlViewerActivity this$0, View view) {
        p.i(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$9$lambda$8(PolicyHtmlViewerActivity this$0, InterfaceC5074l callback, View view) {
        p.i(this$0, "this$0");
        p.i(callback, "$callback");
        Context context = this$0.mContext;
        if (context != null) {
            callback.invoke(context);
        }
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

    @Override // stepos.support.v7.app.d, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.activity_policy_html_viewer);
        setViewContainerPadding((ViewGroup) findViewById(R$id.root_layout));
        setHomeAsUpEnabled();
        this.mActivity = this;
        this.mContext = this;
        this.loadDataView = (PolicySDKLoadDataView) findViewById(R$id.load_data_view);
        this.htmlScrollView = (NestedScrollView) findViewById(R$id.html_scroll_view);
        this.htmlContentView = (TextView) findViewById(R$id.html_content);
        applyBottomContentPadding();
        applyViewerTheme();
        this.bundle = getIntent().getExtras();
        this.mUri = getIntent().getStringExtra(EXTRA_URI);
        this.onlineMode = getIntent().getBooleanExtra(EXTRA_ONLINE_MODE, false);
        applyActivityTitle(getIntent().getStringExtra("title"));
        t tVar = null;
        if (this.onlineMode) {
            Bundle bundle = this.bundle;
            if (bundle != null) {
                fetchOnlinePolicy(bundle);
                tVar = t.f7040a;
            }
            if (tVar == null) {
                showNoDataView();
                return;
            }
            return;
        }
        String str = this.mUri;
        if (str != null) {
            loadPolicyHtml(str);
            tVar = t.f7040a;
        }
        if (tVar == null) {
            showNoDataView();
        }
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        if (isFinishing()) {
            settingBtnCallback = null;
        }
        super.onDestroy();
    }

    @Override // stepos.support.v7.app.d
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public final void setHomeAsUpEnabled() {
        try {
            stepos.support.v7.app.a supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.q(false);
            }
            stepos.support.v7.app.a supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.p(true);
            }
            stepos.support.v7.app.a supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.s(true);
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
