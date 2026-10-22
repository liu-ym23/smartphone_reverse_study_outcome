package com.stepos.policy.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.stepos.policy.sdk.R;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SmartBarPaddingUtil;
import com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qe.c;
import qe.d;
import stepos.support.v7.app.j;
import stepos.support.v7.widget.StepOSRecyclerView;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyPermissionDesActivity extends j {
    public static final Companion Companion = new Companion(null);
    private Bundle bundle;
    private Activity mActivity;
    private Context mContext;
    private String[] mCustomPermissionNames;
    private String[] mCustomPermissionSummaries;
    private String[] mPermissionKey;
    private d mPermissionManager;
    private String[] mPermissionSummary;
    private StepOSRecyclerView mRecyclerView;
    private List<? extends c> permissions;
    private String mTitle = "";
    private String mBannerTitle = "";
    private String mListHeadTitle = "";
    private final ArrayList<PolicyBasicListVO> mData = new ArrayList<>();

    private final void initCustomPermissionData() {
        String[] strArr = this.mCustomPermissionNames;
        String[] strArr2 = this.mCustomPermissionSummaries;
        if (strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return;
        }
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < iMin; i++) {
            this.mData.add(new PolicyBasicListVO.Builder(strArr[i]).setSubTitle(strArr2[i]).setTypeId(17).build());
        }
    }

    public final void initPermissionData() throws Resources.NotFoundException {
        String str;
        PolicySdkLogUtils.Companion.d("PolicyPermissionDesActivity", "initPermissionData");
        String[] strArr = this.mPermissionKey;
        if (strArr == null || this.mPermissionSummary == null) {
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            this.mPermissionKey = PolicySdkToolsUtils.Companion.getCustomPermissionKey(context, strArr);
        }
        HashMap map = new HashMap();
        String[] strArr2 = this.mPermissionKey;
        if (strArr2 != null) {
            int length = strArr2.length;
            for (int i = 0; i < length; i++) {
                String str2 = strArr2[i];
                String[] strArr3 = this.mPermissionSummary;
                if (strArr3 == null || (str = strArr3[i]) == null) {
                    str = "";
                }
                map.put(str2, str);
            }
        }
        d dVar = this.mPermissionManager;
        List<? extends c> listC = dVar != null ? dVar.c(this.mPermissionKey, false) : null;
        this.permissions = listC;
        if (listC != null) {
            for (c cVar : listC) {
                if (cVar.f10226h.size() > 0 && map.containsKey(cVar.f10224f)) {
                    cVar.f10226h.clear();
                }
            }
            for (c cVar2 : listC) {
                ArrayList arrayList = cVar2.f10226h;
                String str3 = cVar2.f10224f;
                if (arrayList.size() > 0) {
                    ArrayList arrayList2 = cVar2.f10226h;
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList2.get(i3);
                        i3++;
                        qe.b bVar = (qe.b) obj;
                        StringBuilder sb2 = new StringBuilder("bindData: perssiongetIdentifier ");
                        String str4 = bVar.f10221f;
                        sb2.append(str4);
                        sb2.append(" | perssion name");
                        sb2.append(bVar.a());
                        Log.d("permissiontest", sb2.toString());
                        PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils = PolicySdkPermissionManifestUtils.INSTANCE;
                        Context context2 = this.mContext;
                        context2.getClass();
                        str4.getClass();
                        String policyModifyPerKey = policySdkPermissionManifestUtils.getPolicyModifyPerKey(context2, str4);
                        if (k.a(policyModifyPerKey, str4)) {
                            policyModifyPerKey = bVar.a();
                            policyModifyPerKey.getClass();
                        }
                        this.mData.add(new PolicyBasicListVO.Builder(policyModifyPerKey).setSubTitle((String) map.get(str4)).setTypeId(17).build());
                    }
                } else {
                    StringBuilder sbO = androidx.activity.b.o("bindData: perssion group getIdentifier ", str3, " | perssion name");
                    sbO.append(cVar2.a(this.mContext));
                    Log.d("permissiontest", sbO.toString());
                    PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils2 = PolicySdkPermissionManifestUtils.INSTANCE;
                    Context context3 = this.mContext;
                    context3.getClass();
                    str3.getClass();
                    String policyModifyPerKey2 = policySdkPermissionManifestUtils2.getPolicyModifyPerKey(context3, str3);
                    if (k.a(policyModifyPerKey2, str3)) {
                        policyModifyPerKey2 = cVar2.a(this.mContext);
                        policyModifyPerKey2.getClass();
                    }
                    this.mData.add(new PolicyBasicListVO.Builder(policyModifyPerKey2).setSubTitle((String) map.get(str3)).setTypeId(17).build());
                }
            }
        }
    }

    public final void initView() throws Resources.NotFoundException {
        PolicySdkLogUtils.Companion.d("PolicyPermissionDesActivity", "init");
        this.mPermissionManager = d.a(this.mContext);
        this.mRecyclerView = (StepOSRecyclerView) findViewById(R.id.rv_permission);
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

    @Override // stepos.support.v7.app.j, androidx.fragment.app.j, androidx.activity.p, d3.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_policysdk_permission);
            setViewContainerPadding((ViewGroup) findViewById(R.id.root_layout));
            setHomeAsUpEnabled();
            WeakReference weakReference = new WeakReference(this);
            this.mActivity = (Activity) new WeakReference(this).get();
            this.mContext = (Context) weakReference.get();
            Bundle extras = getIntent().getExtras();
            this.bundle = extras;
            if (extras != null) {
                String string = extras.getString("head_title");
                String str = "";
                if (string == null) {
                    string = "";
                }
                this.mTitle = string;
                Bundle bundle2 = this.bundle;
                String string2 = bundle2 != null ? bundle2.getString("banner_title") : null;
                if (string2 == null) {
                    string2 = "";
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
            stepos.support.v7.app.c supportActionBar = getSupportActionBar();
            if (supportActionBar != null && !TextUtils.isEmpty(this.mBannerTitle)) {
                supportActionBar.o(this.mBannerTitle);
            }
            initView();
        } catch (Exception e10) {
            PolicySdkLogUtils.Companion.e("PolicyPermissionDesActivity", "oncreate Exception: " + e10.getMessage());
        }
    }

    @Override // stepos.support.v7.app.j
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
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
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void startActivity(Context context, Intent intent) {
            context.getClass();
            intent.getClass();
            try {
                intent.setClass(context, PolicyPermissionDesActivity.class);
                context.startActivity(intent);
            } catch (Exception e10) {
                PolicySdkLogUtils.Companion.e("PolicyPermissionDesActivity", "startPermissionDesActivity Exception: " + e10.getMessage());
                intent.addFlags(268435456);
                intent.setClass(context, PolicyPermissionDesActivity.class);
                context.startActivity(intent);
            }
        }

        private Companion() {
        }
    }
}
