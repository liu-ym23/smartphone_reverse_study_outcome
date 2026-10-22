package com.stepos.policy.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.stepos.policy.sdk.R$color;
import com.stepos.policy.sdk.R$id;
import com.stepos.policy.sdk.R$layout;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SmartBarPaddingUtil;
import com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import net.sqlcipher.database.SQLiteDatabase;
import stepos.support.v7.app.d;
import stepos.support.v7.permission.e;
import stepos.support.v7.widget.StepOSRecyclerView;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020+0*j\b\u0012\u0004\u0012\u00020+`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001e\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/stepos/policy/sdk/activity/PolicyPermissionDesActivity;", "Lstepos/support/v7/app/d;", "<init>", "()V", "LY8/t;", "initCustomPermissionData", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initView", "initPermissionData", "Landroid/view/ViewGroup;", "viewGroup", "setViewContainerPadding", "(Landroid/view/ViewGroup;)V", "setHomeAsUpEnabled", "", "onSupportNavigateUp", "()Z", "Landroid/app/Activity;", "mActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "", "mTitle", "Ljava/lang/String;", "mBannerTitle", "mListHeadTitle", "", "mPermissionKey", "[Ljava/lang/String;", "mPermissionSummary", "mCustomPermissionNames", "mCustomPermissionSummaries", "bundle", "Landroid/os/Bundle;", "Lstepos/support/v7/widget/StepOSRecyclerView;", "mRecyclerView", "Lstepos/support/v7/widget/StepOSRecyclerView;", "Ljava/util/ArrayList;", "Lcom/stepos/policy/sdk/bean/PolicyBasicListVO;", "Lkotlin/collections/ArrayList;", "mData", "Ljava/util/ArrayList;", "", "Lstepos/support/v7/permission/d;", "permissions", "Ljava/util/List;", "Lstepos/support/v7/permission/e;", "mPermissionManager", "Lstepos/support/v7/permission/e;", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicyPermissionDesActivity extends d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Bundle bundle;
    private Activity mActivity;
    private Context mContext;
    private String[] mCustomPermissionNames;
    private String[] mCustomPermissionSummaries;
    private String[] mPermissionKey;
    private e mPermissionManager;
    private String[] mPermissionSummary;
    private StepOSRecyclerView mRecyclerView;
    private List<? extends stepos.support.v7.permission.d> permissions;
    private String mTitle = "";
    private String mBannerTitle = "";
    private String mListHeadTitle = "";
    private final ArrayList<PolicyBasicListVO> mData = new ArrayList<>();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/policy/sdk/activity/PolicyPermissionDesActivity$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final void startActivity(Context context, Intent intent) {
            p.i(context, "context");
            p.i(intent, "intent");
            try {
                intent.setClass(context, PolicyPermissionDesActivity.class);
                context.startActivity(intent);
            } catch (Exception e10) {
                PolicySdkLogUtils.INSTANCE.e("PolicyPermissionDesActivity", "startPermissionDesActivity Exception: " + e10.getMessage());
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.setClass(context, PolicyPermissionDesActivity.class);
                context.startActivity(intent);
            }
        }

        private Companion() {
        }
    }

    private final void initCustomPermissionData() {
        String[] strArr = this.mCustomPermissionNames;
        String[] strArr2 = this.mCustomPermissionSummaries;
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return;
        }
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            this.mData.add(new PolicyBasicListVO.Builder(strArr[i10]).setSubTitle(strArr2[i10]).setTypeId(17).build());
        }
    }

    public final void initPermissionData() throws PackageManager.NameNotFoundException {
        String str;
        PolicySdkLogUtils.INSTANCE.d("PolicyPermissionDesActivity", "initPermissionData");
        String[] strArr = this.mPermissionKey;
        if (strArr == null || this.mPermissionSummary == null) {
            return;
        }
        Context context = this.mContext;
        if (context != null && strArr != null) {
            this.mPermissionKey = PolicySdkToolsUtils.INSTANCE.getCustomPermissionKey(context, strArr);
        }
        HashMap map = new HashMap();
        String[] strArr2 = this.mPermissionKey;
        if (strArr2 != null) {
            int length = strArr2.length;
            for (int i10 = 0; i10 < length; i10++) {
                String str2 = strArr2[i10];
                String[] strArr3 = this.mPermissionSummary;
                if (strArr3 == null || (str = strArr3[i10]) == null) {
                    str = "";
                }
                map.put(str2, str);
            }
        }
        e eVar = this.mPermissionManager;
        List<stepos.support.v7.permission.d> listE = eVar != null ? eVar.e(this.mPermissionKey, false) : null;
        this.permissions = listE;
        if (listE != null) {
            for (stepos.support.v7.permission.d dVar : listE) {
                if (dVar.i().size() > 0 && map.containsKey(dVar.e())) {
                    dVar.i().clear();
                }
            }
            for (stepos.support.v7.permission.d dVar2 : listE) {
                if (dVar2.i().size() > 0) {
                    for (stepos.support.v7.permission.c cVar : dVar2.i()) {
                        Log.d("permissiontest", "bindData: perssiongetIdentifier " + cVar.c() + " | perssion name" + cVar.b(this.mContext));
                        PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils = PolicySdkPermissionManifestUtils.INSTANCE;
                        Context context2 = this.mContext;
                        p.f(context2);
                        String strC = cVar.c();
                        p.h(strC, "permission.identifier");
                        String policyModifyPerKey = policySdkPermissionManifestUtils.getPolicyModifyPerKey(context2, strC);
                        if (p.d(policyModifyPerKey, cVar.c())) {
                            policyModifyPerKey = cVar.b(this.mContext);
                            p.h(policyModifyPerKey, "permission.getDisplayName(mContext)");
                        }
                        this.mData.add(new PolicyBasicListVO.Builder(policyModifyPerKey).setSubTitle((String) map.get(cVar.c())).setTypeId(17).build());
                    }
                } else {
                    Log.d("permissiontest", "bindData: perssion group getIdentifier " + dVar2.e() + " | perssion name" + dVar2.c(this.mContext));
                    PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils2 = PolicySdkPermissionManifestUtils.INSTANCE;
                    Context context3 = this.mContext;
                    p.f(context3);
                    String strE = dVar2.e();
                    p.h(strE, "permissionGroup.identifier");
                    String policyModifyPerKey2 = policySdkPermissionManifestUtils2.getPolicyModifyPerKey(context3, strE);
                    if (p.d(policyModifyPerKey2, dVar2.e())) {
                        policyModifyPerKey2 = dVar2.c(this.mContext);
                        p.h(policyModifyPerKey2, "permissionGroup.getDisplayName(mContext)");
                    }
                    this.mData.add(new PolicyBasicListVO.Builder(policyModifyPerKey2).setSubTitle((String) map.get(dVar2.e())).setTypeId(17).build());
                }
            }
        }
    }

    public final void initView() throws PackageManager.NameNotFoundException {
        PolicySdkLogUtils.INSTANCE.d("PolicyPermissionDesActivity", "init");
        this.mPermissionManager = e.b(this.mContext);
        this.mRecyclerView = (StepOSRecyclerView) findViewById(R$id.rv_permission);
        this.mData.add(new PolicyBasicListVO.Builder(this.mTitle).setTypeId(100).build());
        this.mData.add(new PolicyBasicListVO.Builder(this.mListHeadTitle).isHeader(true).build());
        initPermissionData();
        initCustomPermissionData();
        this.mData.add(new PolicyBasicListVO.Builder("").setSubTitle("").setTypeId(17).build());
        StepOSRecyclerView stepOSRecyclerView = this.mRecyclerView;
        if (stepOSRecyclerView != null) {
            stepOSRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        StepOSRecyclerView stepOSRecyclerView2 = this.mRecyclerView;
        if (stepOSRecyclerView2 == null) {
            return;
        }
        stepOSRecyclerView2.setAdapter(new PolicyBasicRecyclerViewAdapter(this.mData, this));
    }

    @Override // stepos.support.v7.app.d, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R$layout.activity_policysdk_permission);
            setViewContainerPadding((ViewGroup) findViewById(R$id.root_layout));
            setHomeAsUpEnabled();
            SmartBarPaddingUtil.applyNavigationBarContrast(this, androidx.core.content.a.c(this, R$color.policy_sdk_html_viewer_bg), !PolicyHtmlDisplayAdapter.isDarkMode(this));
            WeakReference weakReference = new WeakReference(this);
            this.mActivity = (Activity) new WeakReference(this).get();
            this.mContext = (Context) weakReference.get();
            Bundle extras = getIntent().getExtras();
            this.bundle = extras;
            if (extras != null) {
                String string = extras != null ? extras.getString("head_title") : null;
                String str = "";
                if (string == null) {
                    string = "";
                }
                this.mTitle = string;
                Bundle bundle = this.bundle;
                String string2 = bundle != null ? bundle.getString("banner_title") : null;
                if (string2 == null) {
                    string2 = "";
                }
                this.mBannerTitle = string2;
                Bundle bundle2 = this.bundle;
                String string3 = bundle2 != null ? bundle2.getString("list_head_title") : null;
                if (string3 != null) {
                    str = string3;
                }
                this.mListHeadTitle = str;
                Bundle bundle3 = this.bundle;
                this.mPermissionKey = bundle3 != null ? bundle3.getStringArray("permission_key") : null;
                Bundle bundle4 = this.bundle;
                this.mPermissionSummary = bundle4 != null ? bundle4.getStringArray("permission_summary") : null;
                Bundle bundle5 = this.bundle;
                this.mCustomPermissionNames = bundle5 != null ? bundle5.getStringArray("custom_permission_names") : null;
                Bundle bundle6 = this.bundle;
                this.mCustomPermissionSummaries = bundle6 != null ? bundle6.getStringArray("custom_permission_summaries") : null;
            }
            PolicySdkLogUtils.INSTANCE.d("PolicyPermissionDesActivity", "oncreate mBannerTitle: " + this.mBannerTitle + " | mTitle = " + this.mTitle);
            stepos.support.v7.app.a supportActionBar = getSupportActionBar();
            if (supportActionBar != null && !TextUtils.isEmpty(this.mBannerTitle)) {
                supportActionBar.u(this.mBannerTitle);
            }
            initView();
        } catch (Exception e10) {
            PolicySdkLogUtils.INSTANCE.e("PolicyPermissionDesActivity", "oncreate Exception: " + e10.getMessage());
        }
    }

    @Override // stepos.support.v7.app.d
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
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
}
