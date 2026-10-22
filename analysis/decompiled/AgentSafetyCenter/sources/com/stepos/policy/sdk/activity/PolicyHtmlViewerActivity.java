package com.stepos.policy.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.s0;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.R;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicyHtmlLinkHandler;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkNetworkUtil;
import com.stepos.policy.sdk.util.SmartBarPaddingUtil;
import com.stepos.policy.sdk.widget.PolicySDKLoadDataView;
import hc.h;
import java.io.File;
import java.lang.invoke.VarHandle;
import jb.v;
import kc.e0;
import kc.t;
import kc.w;
import nb.c;
import od.f;
import pb.e;
import pb.i;
import rc.d;
import stepos.support.v7.app.j;
import xb.l;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyHtmlViewerActivity extends j {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_ONLINE_MODE = "online_mode";
    private static final String EXTRA_TITLE = "title";
    private static final String EXTRA_URI = "uri";
    private static final String TAG = "PolicyHtmlViewerActivity";
    private static l settingBtnCallback;
    private Bundle bundle;
    private TextView htmlContentView;
    private NestedScrollView htmlScrollView;
    private PolicySDKLoadDataView loadDataView;
    private Activity mActivity;
    private Context mContext;
    private String mUri;
    private boolean onlineMode;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1", f = "PolicyHtmlViewerActivity.kt", l = {78}, m = "invokeSuspend")
    /* renamed from: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity$loadPolicyHtml$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00501 extends i implements p {
        final /* synthetic */ String $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00501(String str, c cVar) {
            super(2, cVar);
            this.$uri = str;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return PolicyHtmlViewerActivity.this.new C00501(this.$uri, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((C00501) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            ob.a aVar = ob.a.f9351c;
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        id.c.I(obj);
                        rc.e eVar = e0.f7430a;
                        d dVar = d.f10552f;
                        PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1 policyHtmlViewerActivity$loadPolicyHtml$1$html$1 = new PolicyHtmlViewerActivity$loadPolicyHtml$1$html$1(PolicyHtmlViewerActivity.this, this.$uri, null);
                        this.label = 1;
                        obj = w.E(dVar, policyHtmlViewerActivity$loadPolicyHtml$1$html$1, this);
                        if (obj == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i != 1) {
                            f.e("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        id.c.I(obj);
                    }
                    PolicyHtmlViewerActivity.this.displayHtml((String) obj, this.$uri);
                } catch (Exception e10) {
                    PolicySdkLogUtils.Companion.e(PolicyHtmlViewerActivity.TAG, "loadPolicyHtml failed: " + e10.getMessage());
                    PolicyHtmlViewerActivity.this.showNoDataView();
                }
                return v.f6774a;
            } finally {
                PolicyHtmlViewerActivity.this.hideProgress();
            }
        }
    }

    private final void applyActivityTitle(String str) {
        if (str == null || h.g0(str)) {
            return;
        }
        try {
            stepos.support.v7.app.c supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.l();
            }
            stepos.support.v7.app.c supportActionBar2 = getSupportActionBar();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayHtml(String str, String str2) {
        if (h.g0(str)) {
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

    public static /* synthetic */ void displayHtml$default(PolicyHtmlViewerActivity policyHtmlViewerActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = policyHtmlViewerActivity.mUri;
        }
        policyHtmlViewerActivity.displayHtml(str, str2);
    }

    private final void fetchOnlinePolicy(Bundle bundle) {
        String string = bundle.getString(PolicySdkConstants.BUNDLE_KEY_LANGUAGE);
        final String string2 = bundle.getString(PolicySdkConstants.BUNDLE_KEY_CATEGORY);
        long j10 = bundle.getLong(PolicySdkConstants.BUNDLE_KEY_VERSION);
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
            PolicySdk.getPolicy(string, string2, Long.valueOf(j10), new PolicySdk.PolicySdkCallback() { // from class: com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity.fetchOnlinePolicy.1
                @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
                public void getResult(PolicySdkResultBean policySdkResultBean) {
                    w.u(s0.f(PolicyHtmlViewerActivity.this), null, null, new PolicyHtmlViewerActivity$fetchOnlinePolicy$1$getResult$1(PolicyHtmlViewerActivity.this, policySdkResultBean, string2, null), 3);
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
        w.u(s0.f(this), null, null, new C00501(str, null), 3);
    }

    public static final void openPolicy(Context context, String str, String str2) {
        Companion.openPolicy(context, str, str2);
    }

    public static final void setSettingBtnCallback(l lVar) {
        Companion.setSettingBtnCallback(lVar);
    }

    private final void showNetWorkErrorView() {
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            int i = R.string.policy_sdk_network_error;
            int i3 = R.drawable.policy_mz_ic_empty_view_no_network;
            a aVar = new a(0);
            aVar.f2781f = this;
            VarHandle.storeStoreFence();
            PolicySDKLoadDataView.showEmptyView$default(policySDKLoadDataView, i, i3, aVar, false, 0, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNetWorkErrorView$lambda$5(PolicyHtmlViewerActivity policyHtmlViewerActivity, View view) {
        policyHtmlViewerActivity.getClass();
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
            PolicySDKLoadDataView.showEmptyView$default(policySDKLoadDataView, R.string.policy_sdk_no_data, R.drawable.policy_mz_ic_empty_view_no_network, null, false, 0, 16, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showNotNetWorkView() {
        b bVar;
        b bVar2;
        NestedScrollView nestedScrollView = this.htmlScrollView;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
        l lVar = settingBtnCallback;
        int i = 0;
        if (lVar != null) {
            bVar = new b(i);
            bVar.f2783f = this;
            bVar.f2784g = lVar;
            VarHandle.storeStoreFence();
        } else {
            bVar = null;
        }
        PolicySDKLoadDataView policySDKLoadDataView = this.loadDataView;
        if (policySDKLoadDataView != null) {
            int i3 = R.string.policy_sdk_network_error;
            int i10 = R.drawable.policy_mz_ic_empty_view_no_network;
            int i11 = 1;
            if (bVar == null) {
                a aVar = new a(i11);
                aVar.f2781f = this;
                VarHandle.storeStoreFence();
                bVar2 = aVar;
            } else {
                bVar2 = bVar;
            }
            policySDKLoadDataView.showEmptyView(i3, i10, bVar2, bVar == null, R.string.policy_sdk_btn_setting_network);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$8$lambda$7(PolicyHtmlViewerActivity policyHtmlViewerActivity, l lVar, View view) {
        policyHtmlViewerActivity.getClass();
        lVar.getClass();
        Context context = policyHtmlViewerActivity.mContext;
        if (context != null) {
            lVar.invoke(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotNetWorkView$lambda$9(PolicyHtmlViewerActivity policyHtmlViewerActivity, View view) {
        policyHtmlViewerActivity.getClass();
        policyHtmlViewerActivity.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
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
    public final void tryLoadLocalPolicy(String str) {
        String policyNewestPath;
        Context context;
        Context contextCreateDeviceProtectedStorageContext;
        if (str == null || str.length() == 0) {
            showNoDataView();
            return;
        }
        PolicySdkResultBean policyNewestPath2 = PolicySdk.getPolicyNewestPath(this.mActivity, str);
        if (policyNewestPath2.getCode() != 0 && (context = this.mContext) != null && (contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext()) != null) {
            policyNewestPath2 = PolicySdk.getPolicyNewestPath(contextCreateDeviceProtectedStorageContext, str);
        }
        if (policyNewestPath2.getCode() != 0 || (policyNewestPath = policyNewestPath2.getPolicyNewestPath()) == null || policyNewestPath.length() == 0) {
            showNoDataView();
            return;
        }
        String string = androidx.core.content.c.getUriForFile(this, getPackageName() + ".PolicySdk.FileProvider", new File(policyNewestPath2.getPolicyNewestPath())).toString();
        string.getClass();
        loadPolicyHtml(string);
    }

    @Override // stepos.support.v7.app.j, androidx.fragment.app.j, androidx.activity.p, d3.c, android.app.Activity
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
        boolean z10 = this.onlineMode;
        v vVar = null;
        v vVar2 = v.f6774a;
        if (z10) {
            Bundle bundle2 = this.bundle;
            if (bundle2 != null) {
                fetchOnlinePolicy(bundle2);
                vVar = vVar2;
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
            vVar = vVar2;
        }
        if (vVar == null) {
            showNoDataView();
        }
    }

    @Override // stepos.support.v7.app.j, androidx.fragment.app.j, android.app.Activity
    public void onDestroy() {
        if (isFinishing()) {
            settingBtnCallback = null;
        }
        super.onDestroy();
    }

    @Override // stepos.support.v7.app.j
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public final void setHomeAsUpEnabled() {
        try {
            stepos.support.v7.app.c supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.k();
            }
            stepos.support.v7.app.c supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.j(true);
            }
            stepos.support.v7.app.c supportActionBar3 = getSupportActionBar();
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Companion {
        public /* synthetic */ Companion(yb.f fVar) {
            this();
        }

        public static /* synthetic */ void openPolicy$default(Companion companion, Context context, String str, String str2, Bundle bundle, int i, Object obj) {
            if ((i & 8) != 0) {
                bundle = null;
            }
            companion.openPolicy(context, str, str2, bundle);
        }

        public final void openPolicy(Context context, String str, String str2, Bundle bundle) {
            context.getClass();
            if (PolicySdkConstants.isOnlinePolicyViewerUri(str)) {
                startOnline(context, str2, bundle);
            } else {
                start(context, str, str2);
            }
        }

        public final void setSettingBtnCallback(l lVar) {
            PolicyHtmlViewerActivity.settingBtnCallback = lVar;
        }

        public final void start(Context context, String str, String str2) {
            context.getClass();
            Intent intent = new Intent(context, (Class<?>) PolicyHtmlViewerActivity.class);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_URI, str);
            intent.putExtra(PolicyHtmlViewerActivity.EXTRA_TITLE, str2);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }

        public final void startOnline(Context context, String str, Bundle bundle) {
            context.getClass();
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

        public final void openPolicy(Context context, String str, String str2) {
            context.getClass();
            openPolicy$default(this, context, str, str2, null, 8, null);
        }
    }

    public static final void openPolicy(Context context, String str, String str2, Bundle bundle) {
        Companion.openPolicy(context, str, str2, bundle);
    }
}
