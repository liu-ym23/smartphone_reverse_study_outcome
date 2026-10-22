package com.stepos.policy.sdk.activity;

import Z4.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import com.stepos.policy.sdk.n;
import com.stepos.policy.sdk.q;
import com.stepos.policy.sdk.r;
import com.stepos.policy.sdk.util.PolicyHtmlDisplayAdapter;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SmartBarPaddingUtil;
import com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter;
import j4.g;
import j4.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.libpag.BuildConfig;
import stepos.support.v7.app.d;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
public final class PolicyPermissionDesActivity extends d {
    public static final Companion Companion = new Companion(null);
    private Bundle bundle;
    private Activity mActivity;
    private Context mContext;
    private String[] mCustomPermissionNames;
    private String[] mCustomPermissionSummaries;
    private String[] mPermissionKey;
    private e mPermissionManager;
    private String[] mPermissionSummary;
    private StepOSRecyclerView mRecyclerView;
    private List<? extends Z4.d> permissions;
    private String mTitle = BuildConfig.FLAVOR;
    private String mBannerTitle = BuildConfig.FLAVOR;
    private String mListHeadTitle = BuildConfig.FLAVOR;
    private final ArrayList<PolicyBasicListVO> mData = new ArrayList<>();

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final void startActivity(Context context, Intent intent) {
            k.g(context, "context");
            k.g(intent, "intent");
            try {
                intent.setClass(context, PolicyPermissionDesActivity.class);
                context.startActivity(intent);
            } catch (Exception e6) {
                PolicySdkLogUtils.Companion.e("PolicyPermissionDesActivity", "startPermissionDesActivity Exception: " + e6.getMessage());
                intent.addFlags(268435456);
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
        for (int i5 = 0; i5 < iMin; i5++) {
            this.mData.add(new PolicyBasicListVO.Builder(strArr[i5]).setSubTitle(strArr2[i5]).setTypeId(17).build());
        }
    }

    public final void initPermissionData() throws PackageManager.NameNotFoundException {
        String str;
        PolicySdkLogUtils.Companion.d("PolicyPermissionDesActivity", "initPermissionData");
        String[] strArr = this.mPermissionKey;
        if (strArr == null || this.mPermissionSummary == null) {
            return;
        }
        Context context = this.mContext;
        if (context != null && strArr != null) {
            this.mPermissionKey = PolicySdkToolsUtils.Companion.getCustomPermissionKey(context, strArr);
        }
        HashMap map = new HashMap();
        String[] strArr2 = this.mPermissionKey;
        if (strArr2 != null) {
            int length = strArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                String str2 = strArr2[i5];
                String[] strArr3 = this.mPermissionSummary;
                if (strArr3 == null || (str = strArr3[i5]) == null) {
                    str = BuildConfig.FLAVOR;
                }
                map.put(str2, str);
            }
        }
        e eVar = this.mPermissionManager;
        List<Z4.d> listE = eVar != null ? eVar.e(this.mPermissionKey, false) : null;
        this.permissions = listE;
        if (listE != null) {
            for (Z4.d dVar : listE) {
                if (dVar.i().size() > 0 && map.containsKey(dVar.g())) {
                    dVar.i().clear();
                }
            }
            for (Z4.d dVar2 : listE) {
                if (dVar2.i().size() > 0) {
                    for (Z4.c cVar : dVar2.i()) {
                        Log.d("permissiontest", "bindData: perssiongetIdentifier " + cVar.e() + " | perssion name" + cVar.d(this.mContext));
                        PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils = PolicySdkPermissionManifestUtils.INSTANCE;
                        Context context2 = this.mContext;
                        k.d(context2);
                        String strE = cVar.e();
                        k.f(strE, "permission.identifier");
                        String policyModifyPerKey = policySdkPermissionManifestUtils.getPolicyModifyPerKey(context2, strE);
                        if (k.b(policyModifyPerKey, cVar.e())) {
                            policyModifyPerKey = cVar.d(this.mContext);
                            k.f(policyModifyPerKey, "permission.getDisplayName(mContext)");
                        }
                        this.mData.add(new PolicyBasicListVO.Builder(policyModifyPerKey).setSubTitle((String) map.get(cVar.e())).setTypeId(17).build());
                    }
                } else {
                    Log.d("permissiontest", "bindData: perssion group getIdentifier " + dVar2.g() + " | perssion name" + dVar2.e(this.mContext));
                    PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils2 = PolicySdkPermissionManifestUtils.INSTANCE;
                    Context context3 = this.mContext;
                    k.d(context3);
                    String strG = dVar2.g();
                    k.f(strG, "permissionGroup.identifier");
                    String policyModifyPerKey2 = policySdkPermissionManifestUtils2.getPolicyModifyPerKey(context3, strG);
                    if (k.b(policyModifyPerKey2, dVar2.g())) {
                        policyModifyPerKey2 = dVar2.e(this.mContext);
                        k.f(policyModifyPerKey2, "permissionGroup.getDisplayName(mContext)");
                    }
                    this.mData.add(new PolicyBasicListVO.Builder(policyModifyPerKey2).setSubTitle((String) map.get(dVar2.g())).setTypeId(17).build());
                }
            }
        }
    }

    public final void initView() throws PackageManager.NameNotFoundException {
        PolicySdkLogUtils.Companion.d("PolicyPermissionDesActivity", "init");
        this.mPermissionManager = e.b(this.mContext);
        this.mRecyclerView = (StepOSRecyclerView) findViewById(q.f15811n);
        this.mData.add(new PolicyBasicListVO.Builder(this.mTitle).setTypeId(100).build());
        this.mData.add(new PolicyBasicListVO.Builder(this.mListHeadTitle).isHeader(true).build());
        initPermissionData();
        initCustomPermissionData();
        this.mData.add(new PolicyBasicListVO.Builder(BuildConfig.FLAVOR).setSubTitle(BuildConfig.FLAVOR).setTypeId(17).build());
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

    @Override // stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(r.f15814b);
            setViewContainerPadding((ViewGroup) findViewById(q.f15810m));
            setHomeAsUpEnabled();
            SmartBarPaddingUtil.applyNavigationBarContrast(this, androidx.core.content.a.c(this, n.f15793c), !PolicyHtmlDisplayAdapter.isDarkMode(this));
            WeakReference weakReference = new WeakReference(this);
            this.mActivity = (Activity) new WeakReference(this).get();
            this.mContext = (Context) weakReference.get();
            Bundle extras = getIntent().getExtras();
            this.bundle = extras;
            if (extras != null) {
                String string = extras != null ? extras.getString("head_title") : null;
                String str = BuildConfig.FLAVOR;
                if (string == null) {
                    string = BuildConfig.FLAVOR;
                }
                this.mTitle = string;
                Bundle bundle2 = this.bundle;
                String string2 = bundle2 != null ? bundle2.getString("banner_title") : null;
                if (string2 == null) {
                    string2 = BuildConfig.FLAVOR;
                }
                this.mBannerTitle = string2;
                Bundle bundle3 = this.bundle;
                String string3 = bundle3 != null ? bundle3.getString("list_head_title") : null;
                if (string3 != null) {
                    str = string3;
                }
                this.mListHeadTitle = str;
                Bundle bundle4 = this.bundle;
                this.mPermissionKey = bundle4 != null ? bundle4.getStringArray("permission_key") : null;
                Bundle bundle5 = this.bundle;
                this.mPermissionSummary = bundle5 != null ? bundle5.getStringArray("permission_summary") : null;
                Bundle bundle6 = this.bundle;
                this.mCustomPermissionNames = bundle6 != null ? bundle6.getStringArray("custom_permission_names") : null;
                Bundle bundle7 = this.bundle;
                this.mCustomPermissionSummaries = bundle7 != null ? bundle7.getStringArray("custom_permission_summaries") : null;
            }
            PolicySdkLogUtils.Companion.d("PolicyPermissionDesActivity", "oncreate mBannerTitle: " + this.mBannerTitle + " | mTitle = " + this.mTitle);
            stepos.support.v7.app.a supportActionBar = getSupportActionBar();
            if (supportActionBar != null && !TextUtils.isEmpty(this.mBannerTitle)) {
                supportActionBar.Q(this.mBannerTitle);
            }
            initView();
        } catch (Exception e6) {
            PolicySdkLogUtils.Companion.e("PolicyPermissionDesActivity", "oncreate Exception: " + e6.getMessage());
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
}
