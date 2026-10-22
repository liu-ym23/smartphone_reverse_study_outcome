package com.stepos.policy.sdk.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.stepos.alphame.R;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import com.stepos.policy.sdk.util.SmartBarPaddingUtil;
import com.stepos.policy.sdk.widget.PolicyBasicRecyclerViewAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import stepos.support.v7.app.AbstractActivityC0866k;
import stepos.support.v7.app.AbstractC0860e;
import stepos.support.v7.permission.b;
import stepos.support.v7.permission.c;
import stepos.support.v7.permission.d;
import stepos.support.v7.widget.StepOSRecyclerView;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/policy/sdk/activity/PolicyPermissionDesActivity;", "Lstepos/support/v7/app/k;", "<init>", "()V", "policysdk_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPolicyPermissionDesActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicyPermissionDesActivity.kt\ncom/stepos/policy/sdk/activity/PolicyPermissionDesActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,239:1\n1#2:240\n*E\n"})
/* loaded from: classes.dex */
public final class PolicyPermissionDesActivity extends AbstractActivityC0866k {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f12107k = 0;

    /* renamed from: a, reason: collision with root package name */
    public Context f12108a;

    /* renamed from: e, reason: collision with root package name */
    public String[] f12112e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f12113f;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f12114g;

    /* renamed from: h, reason: collision with root package name */
    public StepOSRecyclerView f12115h;

    /* renamed from: j, reason: collision with root package name */
    public d f12117j;

    /* renamed from: b, reason: collision with root package name */
    public String f12109b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f12110c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f12111d = "";

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f12116i = new ArrayList();

    public final void f() {
        String str;
        PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.INSTANCE;
        companion.d("PolicyPermissionDesActivity", "init");
        this.f12117j = d.a(this.f12108a);
        this.f12115h = (StepOSRecyclerView) findViewById(R.id.rv_permission);
        ArrayList arrayList = this.f12116i;
        arrayList.add(new PolicyBasicListVO.Builder(this.f12109b).setTypeId(100).build());
        arrayList.add(new PolicyBasicListVO.Builder(this.f12111d).isHeader(true).build());
        companion.d("PolicyPermissionDesActivity", "initPermissionData");
        String[] strArr = this.f12112e;
        if (strArr != null && this.f12113f != null) {
            Context context = this.f12108a;
            if (context != null) {
                this.f12112e = PolicySdkToolsUtils.INSTANCE.getCustomPermissionKey(context, strArr);
            }
            HashMap map = new HashMap();
            String[] strArr2 = this.f12112e;
            if (strArr2 != null) {
                int length = strArr2.length;
                for (int i4 = 0; i4 < length; i4++) {
                    String str2 = strArr2[i4];
                    String[] strArr3 = this.f12113f;
                    if (strArr3 == null || (str = strArr3[i4]) == null) {
                        str = "";
                    }
                    map.put(str2, str);
                }
            }
            d dVar = this.f12117j;
            List<c> listB = dVar != null ? dVar.b(this.f12112e, false) : null;
            if (listB != null) {
                for (c cVar : listB) {
                    if (cVar.f14648d.size() > 0 && map.containsKey(cVar.f14646b)) {
                        cVar.f14648d.clear();
                    }
                }
                for (c cVar2 : listB) {
                    if (cVar2.f14648d.size() > 0) {
                        Iterator it = cVar2.f14648d.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            Log.d("permissiontest", "bindData: perssiongetIdentifier " + bVar.f14643b + " | perssion name" + bVar.a());
                            PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils = PolicySdkPermissionManifestUtils.INSTANCE;
                            Context context2 = this.f12108a;
                            Intrinsics.checkNotNull(context2);
                            String str3 = bVar.f14643b;
                            Intrinsics.checkNotNullExpressionValue(str3, "permission.identifier");
                            String policyModifyPerKey = policySdkPermissionManifestUtils.getPolicyModifyPerKey(context2, str3);
                            if (Intrinsics.areEqual(policyModifyPerKey, str3)) {
                                policyModifyPerKey = bVar.a();
                                Intrinsics.checkNotNullExpressionValue(policyModifyPerKey, "permission.getDisplayName(mContext)");
                            }
                            arrayList.add(new PolicyBasicListVO.Builder(policyModifyPerKey).setSubTitle((String) map.get(str3)).setTypeId(17).build());
                        }
                    } else {
                        StringBuilder sb = new StringBuilder("bindData: perssion group getIdentifier ");
                        String str4 = cVar2.f14646b;
                        sb.append(str4);
                        sb.append(" | perssion name");
                        sb.append(cVar2.a(this.f12108a));
                        Log.d("permissiontest", sb.toString());
                        PolicySdkPermissionManifestUtils policySdkPermissionManifestUtils2 = PolicySdkPermissionManifestUtils.INSTANCE;
                        Context context3 = this.f12108a;
                        Intrinsics.checkNotNull(context3);
                        Intrinsics.checkNotNullExpressionValue(str4, "permissionGroup.identifier");
                        String policyModifyPerKey2 = policySdkPermissionManifestUtils2.getPolicyModifyPerKey(context3, str4);
                        if (Intrinsics.areEqual(policyModifyPerKey2, str4)) {
                            policyModifyPerKey2 = cVar2.a(this.f12108a);
                            Intrinsics.checkNotNullExpressionValue(policyModifyPerKey2, "permissionGroup.getDisplayName(mContext)");
                        }
                        arrayList.add(new PolicyBasicListVO.Builder(policyModifyPerKey2).setSubTitle((String) map.get(str4)).setTypeId(17).build());
                    }
                }
            }
        }
        arrayList.add(new PolicyBasicListVO.Builder("").setSubTitle("").setTypeId(17).build());
        StepOSRecyclerView stepOSRecyclerView = this.f12115h;
        if (stepOSRecyclerView != null) {
            stepOSRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        StepOSRecyclerView stepOSRecyclerView2 = this.f12115h;
        if (stepOSRecyclerView2 == null) {
            return;
        }
        stepOSRecyclerView2.setAdapter(new PolicyBasicRecyclerViewAdapter(arrayList, this));
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k, androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_policysdk_permission);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.root_layout);
            if (viewGroup != null) {
                SmartBarPaddingUtil.setPaddingActionBar(this, viewGroup);
            }
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
            WeakReference weakReference = new WeakReference(this);
            this.f12108a = (Context) weakReference.get();
            Bundle extras = getIntent().getExtras();
            this.f12114g = extras;
            if (extras != null) {
                String string = extras.getString("head_title");
                String str = "";
                if (string == null) {
                    string = "";
                }
                this.f12109b = string;
                Bundle bundle2 = this.f12114g;
                String string2 = bundle2 != null ? bundle2.getString("banner_title") : null;
                if (string2 == null) {
                    string2 = "";
                }
                this.f12110c = string2;
                Bundle bundle3 = this.f12114g;
                String string3 = bundle3 != null ? bundle3.getString("list_head_title") : null;
                if (string3 != null) {
                    str = string3;
                }
                this.f12111d = str;
                Bundle bundle4 = this.f12114g;
                this.f12112e = bundle4 != null ? bundle4.getStringArray("permission_key") : null;
                Bundle bundle5 = this.f12114g;
                this.f12113f = bundle5 != null ? bundle5.getStringArray("permission_summary") : null;
            }
            PolicySdkLogUtils.INSTANCE.d("PolicyPermissionDesActivity", "oncreate mBannerTitle: " + this.f12110c + " | mTitle = " + this.f12109b);
            AbstractC0860e supportActionBar4 = getSupportActionBar();
            if (supportActionBar4 != null && !TextUtils.isEmpty(this.f12110c)) {
                supportActionBar4.r(this.f12110c);
            }
            f();
        } catch (Exception e4) {
            PolicySdkLogUtils.INSTANCE.e("PolicyPermissionDesActivity", "oncreate Exception: " + e4.getMessage());
        }
    }

    @Override // stepos.support.v7.app.AbstractActivityC0866k
    public final boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
