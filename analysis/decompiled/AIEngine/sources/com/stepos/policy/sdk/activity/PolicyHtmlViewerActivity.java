package com.stepos.policy.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.r;
import com.stepos.aiengine.R;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.policy.sdk.PolicySdk;
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
import gc.q;
import java.io.File;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import rb.c;
import stepos.support.v7.app.f;
import v0.n0;
import v0.o0;
import v0.w;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity extends f {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_ONLINE_MODE = "online_mode";
    private static final String EXTRA_TITLE = "title";
    private static final String EXTRA_URI = "uri";
    private static final String TAG = "PolicyHtmlViewerActivity";
    private static l<? super Context, n> settingBtnCallback;
    private Bundle bundle;
    private TextView htmlContentView;
    private NestedScrollView htmlScrollView;
    private PolicySDKLoadDataView loadDataView;
    private Activity mActivity;
    private Context mContext;
    private String mUri;
    private boolean onlineMode;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ void openPolicy$default(Companion companion, Context context, String str, String str2, Bundle bundle, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                bundle = null;
            }
            companion.openPolicy(context, str, str2, bundle);
        }

        public final void openPolicy(Context context, String str, String str2) {
            g.f(context, "context");
            openPolicy$default(this, context, str, str2, null, 8, null);
        }

        public final void setSettingBtnCallback(l<? super Context, n> lVar) {
            PolicyHtmlViewerActivity.settingBtnCallback = lVar;
        }

        public final void start(Context context, String str, String str2) {
            g.f(context, "context");
            Intent intent = new Intent(context, (Class<?>) PolicyHtmlViewerActivity.class);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_URI, str);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_TITLE, str2);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }

        public final void startOnline(Context context, String str, Bundle bundle) {
            g.f(context, "context");
            Intent intent = new Intent(context, (Class<?>) PolicyHtmlViewerActivity.class);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_TITLE, str);
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

        public final void openPolicy(Context context, String str, String str2, Bundle bundle) {
            g.f(context, "context");
            if (PolicySdkConstants.isOnlinePolicyViewerUri(str)) {
                startOnline(context, str2, bundle);
            } else {
                start(context, str, str2);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1", f = "PolicyHtmlViewerActivity.kt", l = {83}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04401 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ String $uri;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04401(String str, qb.b<? super C04401> bVar) {
            super(2, bVar);
            this.$uri = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return PolicyHtmlViewerActivity.this.new C04401(this.$uri, bVar);
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
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r2 = r9.label
                r3 = 1
                if (r2 == 0) goto L1e
                if (r2 != r3) goto L16
                int r1 = r9.I$0
                kotlin.c.b(r10)     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
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
                kotlin.c.b(r10)
                r10 = 0
                kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 r4 = new com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r5 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                java.lang.String r6 = r9.$uri     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                r7 = 0
                r4.<init>(r5, r6, r7)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                r9.I$0 = r10     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                r9.label = r3     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
                java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r9)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L52
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
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r2 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch: java.lang.Throwable -> L11
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
                lb.n r9 = lb.n.f10413a
                return r9
            L8e:
                if (r1 != 0) goto L95
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r9 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$hideProgress(r9)
            L95:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.C04401.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((C04401) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private final void applyActivityTitle(String str) {
        if (str == null || q.t0(str)) {
            return;
        }
        try {
            stepos.support.v7.app.a supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.l();
            }
            stepos.support.v7.app.a supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.o(str);
            }
        } catch (Exception unused) {
        }
        setTitle(str);
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
        getWindow().setStatusBarColor(iViewerBackgroundColor);
        boolean zIsDarkMode = PolicyHtmlDisplayAdapter.isDarkMode(this);
        Window window = getWindow();
        w wVar = new w(getWindow().getDecorView());
        n0 o0Var = Build.VERSION.SDK_INT >= 35 ? new o0(window, wVar) : new n0(window, wVar);
        WindowInsetsController windowInsetsController = o0Var.f13330a;
        Window window2 = o0Var.f13331b;
        if (zIsDarkMode) {
            if (window2 != null) {
                View decorView = window2.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
            }
            windowInsetsController.setSystemBarsAppearance(0, 8);
            return;
        }
        if (window2 != null) {
            View decorView2 = window2.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | PcmDumpBudget.HARD_MAX_DIR_MB);
        }
        windowInsetsController.setSystemBarsAppearance(8, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayHtml(String str, String str2) {
        if (q.t0(str)) {
            showNoDataView();
            return;
        }
        applyActivityTitle(PolicyHtmlDisplayAdapter.resolveDisplayTitle(PolicyHtmlDisplayAdapter.extractTitle(str), getIntent().getStringExtra(EXTRA_TITLE)));
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
            PolicyHtmlLinkHandler.INSTANCE.bindHtmlLinks(textView, PolicyHtmlDisplayAdapter.prepareHtml(str, zIsDarkMode), str2, zIsDarkMode, PolicyHtmlDisplayAdapter.linkColor(this), new p<String, String, n>() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$displayHtml$1$1
                {
                    super(2);
                }

                @Override // zb.p
                public /* bridge */ /* synthetic */ n invoke(String str3, String str4) {
                    invoke2(str3, str4);
                    return n.f10413a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String url, String str3) {
                    g.f(url, "url");
                    this.this$0.openPolicyLink(url, str3);
                }
            }, new l<String, n>() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$displayHtml$1$2
                {
                    super(1);
                }

                @Override // zb.l
                public /* bridge */ /* synthetic */ n invoke(String str3) {
                    invoke2(str3);
                    return n.f10413a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String url) {
                    g.f(url, "url");
                    PolicySdkToolsUtils.Companion.startBrowser(this.this$0, url);
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
                    BuildersKt__Builders_commonKt.launch$default(r.a(PolicyHtmlViewerActivity.this), null, null, new PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(PolicyHtmlViewerActivity.this, policySdkResultBean, string2, null), 3, null);
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
    public final void loadPolicyHtml(String str) {
        showProgress();
        BuildersKt__Builders_commonKt.launch$default(r.a(this), null, null, new C04401(str, null), 3, null);
    }

    public static final void openPolicy(Context context, String str, String str2) {
        Companion.openPolicy(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openPolicyLink(String str, String str2) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[PolicyHtmlLinkHandler.resolveInPageCloudPolicyTarget(str, new l<String, Boolean>() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$openPolicyLink$target$1
            {
                super(1);
            }

            @Override // zb.l
            public final Boolean invoke(String cat) {
                g.f(cat, "cat");
                return Boolean.valueOf(this.this$0.resolveLocalPolicyContentUri(cat) != null);
            }
        }, !PolicySdkNetworkGate.shouldBlock() && PolicySdkNetworkUtil.isNetworkAvailable(this)).ordinal()];
        if (i10 == 1) {
            Companion.start(this, str, str2);
            return;
        }
        if (i10 == 2) {
            String strResolveLocalCategoryForInPageLink = PolicyHtmlLinkHandler.resolveLocalCategoryForInPageLink(str, new l<String, Boolean>() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$openPolicyLink$category$1
                {
                    super(1);
                }

                @Override // zb.l
                public final Boolean invoke(String cat) {
                    g.f(cat, "cat");
                    return Boolean.valueOf(this.this$0.resolveLocalPolicyContentUri(cat) != null);
                }
            });
            String strResolveLocalPolicyContentUri = strResolveLocalCategoryForInPageLink != null ? resolveLocalPolicyContentUri(strResolveLocalCategoryForInPageLink) : null;
            if (strResolveLocalPolicyContentUri != null) {
                Companion.start(this, strResolveLocalPolicyContentUri, str2);
                return;
            } else {
                PolicySdkToolsUtils.Companion.startBrowser(this, str);
                return;
            }
        }
        if (i10 != 3) {
            return;
        }
        PolicySdkLogUtils.Companion.d(TAG, "in-page cloud policy has no local file and SDK cannot use network, open browser url=" + str);
        PolicySdkToolsUtils.Companion.startBrowser(this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveLocalPolicyContentUri(String str) {
        String policyNewestPath;
        Context context;
        Context contextCreateDeviceProtectedStorageContext;
        PolicySdkResultBean policyNewestPath2 = PolicySdk.getPolicyNewestPath(this.mActivity, str);
        if (policyNewestPath2.getCode() != 0 && (context = this.mContext) != null && (contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext()) != null) {
            policyNewestPath2 = PolicySdk.getPolicyNewestPath(contextCreateDeviceProtectedStorageContext, str);
        }
        if (policyNewestPath2.getCode() != 0 || (policyNewestPath = policyNewestPath2.getPolicyNewestPath()) == null || policyNewestPath.length() == 0) {
            return null;
        }
        return androidx.core.content.b.getUriForFile(this, getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath2.getPolicyNewestPath())).toString();
    }

    public static final void setSettingBtnCallback(l<? super Context, n> lVar) {
        Companion.setSettingBtnCallback(lVar);
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
    public static final void showNetWorkErrorView$lambda$6(PolicyHtmlViewerActivity this$0, View view) {
        g.f(this$0, "this$0");
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
        final l<? super Context, n> lVar = settingBtnCallback;
        View.OnClickListener onClickListener = lVar != null ? new View.OnClickListener() { // from class: com.stepos.policy.sdk.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyHtmlViewerActivity.showNotNetWorkView$lambda$9$lambda$8(this.f7956a, lVar, view);
            }
        } : null;
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showEmptyView(R.string.policy_sdk_network_error, R.drawable.policy_mz_ic_empty_view_no_network, onClickListener == null ? new a(this, 1) : onClickListener, onClickListener == null, R.string.policy_sdk_btn_setting_network);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$10(PolicyHtmlViewerActivity this$0, View view) {
        g.f(this$0, "this$0");
        this$0.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$9$lambda$8(PolicyHtmlViewerActivity this$0, l callback, View view) {
        g.f(this$0, "this$0");
        g.f(callback, "$callback");
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
        Companion.start(context, str, str2);
    }

    public static final void startOnline(Context context, String str, Bundle bundle) {
        Companion.startOnline(context, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryLoadLocalPolicy(String str) {
        if (str == null || str.length() == 0) {
            showNoDataView();
            return false;
        }
        String strResolveLocalPolicyContentUri = resolveLocalPolicyContentUri(str);
        if (strResolveLocalPolicyContentUri != null) {
            loadPolicyHtml(strResolveLocalPolicyContentUri);
            return true;
        }
        showNoDataView();
        return false;
    }

    @Override // stepos.support.v7.app.f, androidx.fragment.app.o, b.k, androidx.core.app.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        n nVar = null;
        if (this.onlineMode) {
            Bundle bundle2 = this.bundle;
            if (bundle2 != null) {
                fetchOnlinePolicy(bundle2);
                nVar = n.f10413a;
            }
            if (nVar == null) {
                showNoDataView();
                return;
            }
            return;
        }
        String str = this.mUri;
        if (str != null) {
            loadPolicyHtml(str);
            nVar = n.f10413a;
        }
        if (nVar == null) {
            showNoDataView();
        }
    }

    @Override // stepos.support.v7.app.f, androidx.fragment.app.o, android.app.Activity
    public void onDestroy() {
        if (isFinishing()) {
            settingBtnCallback = null;
        }
        super.onDestroy();
    }

    @Override // stepos.support.v7.app.f
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public final void setHomeAsUpEnabled() {
        try {
            stepos.support.v7.app.a supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.k();
            }
            stepos.support.v7.app.a supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.j(true);
            }
            stepos.support.v7.app.a supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.m(true);
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
        Companion.openPolicy(context, str, str2, bundle);
    }
}
