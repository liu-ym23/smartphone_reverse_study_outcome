package com.stepos.policy.sdk.activity;

import V3.v;
import Z3.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.C0540u;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.o;
import com.stepos.policy.sdk.q;
import com.stepos.policy.sdk.r;
import com.stepos.policy.sdk.s;
import com.stepos.policy.sdk.util.InPageCloudPolicyTarget;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicyHtmlLinkHandler;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkGate;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SmartBarPaddingUtil;
import com.stepos.policy.sdk.widget.PolicySDKLoadDataView;
import i4.InterfaceC0772l;
import i4.p;
import j4.g;
import j4.k;
import java.io.File;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import r4.C1031n;
import s4.C1076i;
import s4.I;
import stepos.support.v7.app.d;

/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity extends d {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_ONLINE_MODE = "online_mode";
    private static final String EXTRA_TITLE = "title";
    private static final String EXTRA_URI = "uri";
    private static final String TAG = "PolicyHtmlViewerActivity";
    private static InterfaceC0772l<? super Context, v> settingBtnCallback;
    private Bundle bundle;
    private TextView htmlContentView;
    private NestedScrollView htmlScrollView;
    private PolicySDKLoadDataView loadDataView;
    private Activity mActivity;
    private Context mContext;
    private String mUri;
    private boolean onlineMode;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ void openPolicy$default(Companion companion, Context context, String str, String str2, Bundle bundle, int i5, Object obj) {
            if ((i5 & 8) != 0) {
                bundle = null;
            }
            companion.openPolicy(context, str, str2, bundle);
        }

        public final void openPolicy(Context context, String str, String str2) {
            k.g(context, "context");
            openPolicy$default(this, context, str, str2, null, 8, null);
        }

        public final void setSettingBtnCallback(InterfaceC0772l<? super Context, v> interfaceC0772l) {
            PolicyHtmlViewerActivity.settingBtnCallback = interfaceC0772l;
        }

        public final void start(Context context, String str, String str2) {
            k.g(context, "context");
            Intent intent = new Intent(context, (Class<?>) PolicyHtmlViewerActivity.class);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_URI, str);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_TITLE, str2);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }

        public final void startOnline(Context context, String str, Bundle bundle) {
            k.g(context, "context");
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
            k.g(context, "context");
            if (PolicySdkConstants.isOnlinePolicyViewerUri(str)) {
                startOnline(context, str2, bundle);
            } else {
                start(context, str, str2);
            }
        }
    }

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

    @f(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1", f = "PolicyHtmlViewerActivity.kt", l = {81}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1, reason: invalid class name and case insensitive filesystem */
    static final class C06391 extends l implements p<I, e<? super v>, Object> {
        final /* synthetic */ String $uri;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06391(String str, e<? super C06391> eVar) {
            super(2, eVar);
            this.$uri = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final e<v> create(Object obj, e<?> eVar) {
            return PolicyHtmlViewerActivity.this.new C06391(this.$uri, eVar);
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
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = a4.C0428b.e()
                int r1 = r8.label
                r2 = 1
                if (r1 == 0) goto L1e
                if (r1 != r2) goto L16
                int r0 = r8.I$0
                V3.o.b(r9)     // Catch: java.lang.Throwable -> L11 java.lang.Exception -> L14
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
                V3.o.b(r9)
                r9 = 0
                s4.E r1 = s4.W.b()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 r3 = new com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r4 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                java.lang.String r5 = r8.$uri     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                r6 = 0
                r3.<init>(r4, r5, r6)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                r8.I$0 = r9     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                r8.label = r2     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
                java.lang.Object r1 = s4.C1072g.e(r1, r3, r8)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
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
                com.stepos.policy.sdk.util.PolicySdkLogUtils$Companion r1 = com.stepos.policy.sdk.util.PolicySdkLogUtils.Companion     // Catch: java.lang.Throwable -> L11
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
                V3.v r8 = V3.v.f5542a
                return r8
            L94:
                if (r0 != 0) goto L9b
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity r8 = com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.this
                com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.access$hideProgress(r8)
            L9b:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.C06391.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i4.p
        public final Object invoke(I i5, e<? super v> eVar) {
            return ((C06391) create(i5, eVar)).invokeSuspend(v.f5542a);
        }
    }

    private final void applyActivityTitle(String str) {
        if (str == null || C1031n.E(str)) {
            return;
        }
        try {
            stepos.support.v7.app.a supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.J(true);
            }
            stepos.support.v7.app.a supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.Q(str);
            }
        } catch (Exception unused) {
        }
        setTitle(str);
    }

    private final void applyBottomContentPadding() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            SmartBarPaddingUtil.applyBottomNavigationPadding(nestedScrollView, getResources().getDimensionPixelSize(o.f15794a));
        }
    }

    private final void applyViewerTheme() {
        int iViewerBackgroundColor = PolicyHtmlDisplayAdapter.viewerBackgroundColor(this);
        View viewFindViewById = findViewById(q.f15810m);
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
    public final void displayHtml(String str, String str2) {
        if (C1031n.E(str)) {
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
            PolicyHtmlLinkHandler.INSTANCE.bindHtmlLinks(textView, PolicyHtmlDisplayAdapter.prepareHtml(str, zIsDarkMode), str2, zIsDarkMode, PolicyHtmlDisplayAdapter.linkColor(this), new PolicyHtmlViewerActivity$displayHtml$1$1(this), new PolicyHtmlViewerActivity$displayHtml$1$2(this));
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.hideEmptyView();
        }
    }

    static /* synthetic */ void displayHtml$default(PolicyHtmlViewerActivity policyHtmlViewerActivity, String str, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = policyHtmlViewerActivity.mUri;
        }
        policyHtmlViewerActivity.displayHtml(str, str2);
    }

    private final void fetchOnlinePolicy(Bundle bundle) {
        String string = bundle.getString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE);
        final String string2 = bundle.getString(PolicySdkConstants.BUNDLE_KEY_CATEGORY);
        long j5 = bundle.getLong(PolicySdkConstants.BUNDLE_KEY_VERSION);
        int i5 = bundle.getInt(PolicySdkConstants.ONLINE_POLICY_WEB_VIEW_BUNDLE_KEY, 0);
        if (i5 == -10004) {
            showNetWorkErrorView();
            return;
        }
        if (i5 == -10003) {
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
                    C1076i.b(C0540u.a(PolicyHtmlViewerActivity.this), null, null, new PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(PolicyHtmlViewerActivity.this, policySdkResultBean, string2, null), 3, null);
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
        C1076i.b(C0540u.a(this), null, null, new C06391(str, null), 3, null);
    }

    public static final void openPolicy(Context context, String str, String str2) {
        Companion.openPolicy(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openPolicyLink(String str, String str2) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[PolicyHtmlLinkHandler.resolveInPageCloudPolicyTarget(str, new PolicyHtmlViewerActivity$openPolicyLink$target$1(this), !PolicySdkNetworkGate.shouldBlock() && PolicySdkNetworkUtil.isNetworkAvailable(this)).ordinal()];
        if (i5 == 1) {
            Companion.start(this, str, str2);
            return;
        }
        if (i5 == 2) {
            String strResolveLocalCategoryForInPageLink = PolicyHtmlLinkHandler.resolveLocalCategoryForInPageLink(str, new PolicyHtmlViewerActivity$openPolicyLink$category$1(this));
            String strResolveLocalPolicyContentUri = strResolveLocalCategoryForInPageLink != null ? resolveLocalPolicyContentUri(strResolveLocalCategoryForInPageLink) : null;
            if (strResolveLocalPolicyContentUri != null) {
                Companion.start(this, strResolveLocalPolicyContentUri, str2);
                return;
            } else {
                PolicySdkToolsUtils.Companion.startBrowser(this, str);
                return;
            }
        }
        if (i5 != 3) {
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
        return FileProvider.getUriForFile(this, getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath2.getPolicyNewestPath())).toString();
    }

    public static final void setSettingBtnCallback(InterfaceC0772l<? super Context, v> interfaceC0772l) {
        Companion.setSettingBtnCallback(interfaceC0772l);
    }

    private final void showNetWorkErrorView() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            PolicySDKLoadDataView.showEmptyView$default(policySDKLoadDataView, s.f15830h, com.stepos.policy.sdk.p.f15796a, new View.OnClickListener() { // from class: com.stepos.policy.sdk.activity.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PolicyHtmlViewerActivity.showNetWorkErrorView$lambda$6(this.f15760a, view);
                }
            }, false, 0, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNetWorkErrorView$lambda$6(PolicyHtmlViewerActivity policyHtmlViewerActivity, View view) {
        k.g(policyHtmlViewerActivity, "this$0");
        Bundle bundle = policyHtmlViewerActivity.bundle;
        if (bundle != null) {
            policyHtmlViewerActivity.fetchOnlinePolicy(bundle);
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
            PolicySDKLoadDataView.showEmptyView$default(policySDKLoadDataView, s.f15831i, com.stepos.policy.sdk.p.f15796a, null, false, 0, 16, null);
        }
    }

    private final void showNotNetWorkView() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        final InterfaceC0772l<? super Context, v> interfaceC0772l = settingBtnCallback;
        View.OnClickListener onClickListener = interfaceC0772l != null ? new View.OnClickListener() { // from class: com.stepos.policy.sdk.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PolicyHtmlViewerActivity.showNotNetWorkView$lambda$9$lambda$8(this.f15761a, interfaceC0772l, view);
            }
        } : null;
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            policySDKLoadDataView.showEmptyView(s.f15830h, com.stepos.policy.sdk.p.f15796a, onClickListener == null ? new View.OnClickListener() { // from class: com.stepos.policy.sdk.activity.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PolicyHtmlViewerActivity.showNotNetWorkView$lambda$10(this.f15763a, view);
                }
            } : onClickListener, onClickListener == null, s.f15829g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$10(PolicyHtmlViewerActivity policyHtmlViewerActivity, View view) {
        k.g(policyHtmlViewerActivity, "this$0");
        policyHtmlViewerActivity.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$9$lambda$8(PolicyHtmlViewerActivity policyHtmlViewerActivity, InterfaceC0772l interfaceC0772l, View view) {
        k.g(policyHtmlViewerActivity, "this$0");
        k.g(interfaceC0772l, "$callback");
        Context context = policyHtmlViewerActivity.mContext;
        if (context != null) {
            interfaceC0772l.invoke(context);
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

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.f15813a);
        setViewContainerPadding((ViewGroup) findViewById(q.f15810m));
        setHomeAsUpEnabled();
        this.mActivity = this;
        this.mContext = this;
        this.loadDataView = (PolicySDKLoadDataView) findViewById(q.f15803f);
        this.htmlScrollView = (NestedScrollView) findViewById(q.f15801d);
        this.htmlContentView = (TextView) findViewById(q.f15800c);
        applyBottomContentPadding();
        applyViewerTheme();
        this.bundle = getIntent().getExtras();
        this.mUri = getIntent().getStringExtra(EXTRA_URI);
        this.onlineMode = getIntent().getBooleanExtra(EXTRA_ONLINE_MODE, false);
        applyActivityTitle(getIntent().getStringExtra(EXTRA_TITLE));
        v vVar = null;
        if (this.onlineMode) {
            Bundle bundle2 = this.bundle;
            if (bundle2 != null) {
                fetchOnlinePolicy(bundle2);
                vVar = v.f5542a;
            }
            if (vVar == null) {
                showNoDataView();
                return;
            }
            return;
        }
        String str = this.mUri;
        if (str != null) {
            loadPolicyHtml(str);
            vVar = v.f5542a;
        }
        if (vVar == null) {
            showNoDataView();
        }
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
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
                supportActionBar.H(false);
            }
            stepos.support.v7.app.a supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.E(true);
            }
            stepos.support.v7.app.a supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.K(true);
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
