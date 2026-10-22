package p2;

import N1.h;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.UserManager;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.familyguard.FamilyGuardApp;
import com.stepos.familyguard.R;
import com.stepos.familyguard.db.FamilyGuardDatabase;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.policy.sdk.bean.DeleteInfoBean;
import com.stepos.policy.sdk.bean.DeleteInfoEncryptMultiBean;
import com.stepos.policy.sdk.bean.PolicySdkResultBean;
import com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder;
import com.stepos.policy.sdk.util.PolicySdkStringUtils;
import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import f2.C0702g;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l2.C0832a;
import org.libpag.BuildConfig;
import p2.g;
import stepos.support.v7.app.c;
import stepos.support.v7.app.r;
import x3.r;
import x3.t;
import x3.u;
import z3.C1347a;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final Typeface f19366a = Typeface.create("sans-serif-medium", 0);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f19367b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f19368c = false;

    /* renamed from: d, reason: collision with root package name */
    private static String f19369d;

    /* renamed from: e, reason: collision with root package name */
    private static List<DeleteInfoBean> f19370e;

    class a extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f19371a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19372b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19373c;

        a(Context context, String str, String str2) {
            this.f19371a = context;
            this.f19372b = str;
            this.f19373c = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            g.C(this.f19371a, this.f19372b, this.f19373c, PolicySdkToolsUtils.Companion.getLanguage(), false);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f19371a.getResources().getColor(R.color.fg_permission_custom_terms_color));
            textPaint.setTypeface(g.f19366a);
        }
    }

    class b extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f19374a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19375b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19376c;

        b(Context context, String str, String str2) {
            this.f19374a = context;
            this.f19375b = str;
            this.f19376c = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            g.C(this.f19374a, this.f19375b, this.f19376c, PolicySdkToolsUtils.Companion.getLanguage(), false);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f19374a.getResources().getColor(R.color.fg_permission_custom_terms_color));
            textPaint.setTypeface(g.f19366a);
        }
    }

    class c implements PolicySdk.PolicySdkCallback {
        c() {
        }

        @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
        public void getResult(PolicySdkResultBean policySdkResultBean) {
        }
    }

    class d implements PolicySdk.PolicySdkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f19377a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f19378b;

        d(r rVar, Context context) {
            this.f19377a = rVar;
            this.f19378b = context;
        }

        @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkCallback
        public void getResult(PolicySdkResultBean policySdkResultBean) {
            Log.d("PermissionUtils", "withdrawalCleanCustomUploadRecord =" + policySdkResultBean.getCode());
            if (policySdkResultBean.getCode() == 0) {
                C0702g.b("PermissionUtils", "getResult: success");
                this.f19377a.c(Boolean.TRUE);
                return;
            }
            g.l(this.f19378b).show();
            C0702g.b("PermissionUtils", "getResult: fail");
            this.f19377a.onError(new Exception("policySdkResultBean = " + policySdkResultBean));
        }
    }

    class e implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f19379a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f19380b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f19381c;

        e(m mVar, Activity activity, k kVar) {
            this.f19379a = mVar;
            this.f19380b = activity;
            this.f19381c = kVar;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            this.f19379a.j(false);
            if (z6) {
                g.B(this.f19380b);
                ((FamilyGuardApp) P1.a.a()).f();
                C2.n.a(this.f19380b, true);
            }
            k kVar = this.f19381c;
            if (kVar != null) {
                kVar.a(z6);
            }
        }
    }

    class f implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f19382a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f19383b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f19384c;

        f(m mVar, Activity activity, k kVar) {
            this.f19382a = mVar;
            this.f19383b = activity;
            this.f19384c = kVar;
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            this.f19382a.j(false);
            if (z6) {
                g.B(this.f19383b);
                ((FamilyGuardApp) P1.a.a()).f();
                C2.n.a(this.f19383b, true);
            }
            k kVar = this.f19384c;
            if (kVar != null) {
                kVar.a(z6);
            }
        }
    }

    class i implements PolicyPermissionDialogBuilder.OnPermissionClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f19387a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f19388b;

        i(Activity activity, l lVar) {
            this.f19387a = activity;
            this.f19388b = lVar;
        }

        public static /* synthetic */ u a(String str, Activity activity, List list) {
            String str2 = "000000";
            if (list != null && !list.isEmpty()) {
                String str3 = ((C0832a) list.get(0)).f18161d;
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str3;
                }
            }
            return g.X(activity, str2, TextUtils.equals("1", str));
        }

        public static /* synthetic */ void b(Activity activity, l lVar, Boolean bool) throws IOException {
            if (bool.booleanValue()) {
                Application applicationA = P1.a.a();
                g.I(applicationA);
                g.H(applicationA);
            } else {
                g.l(activity).show();
            }
            if (lVar != null) {
                lVar.a(bool.booleanValue());
            }
        }

        @Override // com.stepos.policy.sdk.dialog.PolicyPermissionDialogBuilder.OnPermissionClickListener
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, final String str) {
            if (!z5) {
                this.f19388b.a(false);
                return;
            }
            x3.q<List<C0832a>> qVarN = FamilyGuardDatabase.x().t().a().n(T3.a.c());
            final Activity activity = this.f19387a;
            x3.q qVarK = qVarN.f(new D3.h() { // from class: p2.p
                @Override // D3.h
                public final Object apply(Object obj) {
                    return g.i.a(str, activity, (List) obj);
                }
            }).k(C1347a.a());
            final Activity activity2 = this.f19387a;
            final l lVar = this.f19388b;
            qVarK.l(new D3.c() { // from class: p2.q
                @Override // D3.c
                public final void accept(Object obj) throws IOException {
                    g.i.b(activity2, lVar, (Boolean) obj);
                }
            }, S1.a.b());
        }
    }

    class j extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f19389a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19390b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19391c;

        j(Context context, String str, String str2) {
            this.f19389a = context;
            this.f19390b = str;
            this.f19391c = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            g.C(this.f19389a, this.f19390b, this.f19391c, PolicySdkToolsUtils.Companion.getLanguage(), true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f19389a.getResources().getColor(R.color.fg_permission_custom_terms_color));
            textPaint.setTypeface(g.f19366a);
        }
    }

    public interface k {
        void a(boolean z5);
    }

    public interface l {
        void a(boolean z5);
    }

    public interface m {
        boolean g();

        void j(boolean z5);

        Activity k();
    }

    public static void A(Context context) {
        if (context == null) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("app_list_permission_request_denied", true).apply();
    }

    public static void B(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (PreferenceManager.getDefaultSharedPreferences(applicationContext).edit().putBoolean("digital_wellbeing_permission_granted", true).commit()) {
            o(applicationContext).edit().putBoolean("digital_wellbeing_permission_granted", true).commit();
        } else {
            Log.e("PermissionUtils", "markDigitalWellbeingPermissionsGranted: default prefs commit failed");
        }
        f19367b = true;
        AppWidgetManagerService.n(context);
    }

    public static void C(Context context, String str, String str2, String str3, boolean z5) {
        if (z5) {
            PolicySdk.openPolicyByMethod(context, Boolean.TRUE, str, str2);
        } else {
            PolicySdk.getOnlinePolicyMethod(context, str3, str2, str, Boolean.TRUE, new c());
        }
    }

    private static boolean D(Context context) {
        SharedPreferences sharedPreferencesO = o(context);
        boolean z5 = false;
        if (sharedPreferencesO.contains("digital_wellbeing_permission_granted")) {
            return sharedPreferencesO.getBoolean("digital_wellbeing_permission_granted", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean zContains = defaultSharedPreferences.contains("digital_wellbeing_permission_granted");
        if (defaultSharedPreferences.getBoolean("digital_wellbeing_permission_granted", true) && zContains) {
            z5 = true;
        }
        if (z5) {
            sharedPreferencesO.edit().putBoolean("digital_wellbeing_permission_granted", true).apply();
        }
        return z5;
    }

    public static boolean E(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            androidx.core.app.a.q(activity, new String[]{"com.android.permission.GET_INSTALLED_APPS"}, 19415);
            return true;
        } catch (Exception e6) {
            C0702g.p("PermissionUtils", "app list request failed");
            C0702g.r("PermissionUtils", e6);
            return false;
        }
    }

    public static void F() {
        f19367b = false;
    }

    public static void G(Context context) {
        C2.n.a(context, false);
        j(context);
        Context applicationContext = context.getApplicationContext();
        o(applicationContext).edit().putBoolean("digital_wellbeing_permission_granted", false).apply();
        PreferenceManager.getDefaultSharedPreferences(applicationContext).edit().putBoolean("digital_wellbeing_permission_granted", false).apply();
        f19367b = false;
        AppWidgetManagerService.n(context);
    }

    public static void H(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("family_guard_permission_granted", false).apply();
        if (!x(context)) {
            C2.n.a(context, false);
        }
        f19368c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(Context context) throws IOException {
        String strConcat = context.getDataDir().toString().concat("/").concat("app_policy").concat("/");
        String strConcat2 = strConcat.concat("pp").concat("/");
        String strConcat3 = strConcat.concat("up").concat("/");
        File file = new File(strConcat2);
        File file2 = new File(strConcat3);
        File file3 = new File(strConcat2.concat("pp_0.html"));
        File file4 = new File(strConcat3.concat("pp_0.html"));
        File[] fileArrListFiles = file.listFiles();
        File[] fileArrListFiles2 = file2.listFiles();
        if (fileArrListFiles != null) {
            for (File file5 : fileArrListFiles) {
                if (file5 != null && file5.isFile()) {
                    C0702g.b("PermissionUtils", " delete res = " + file5.delete());
                }
            }
        }
        if (fileArrListFiles2 != null) {
            for (File file6 : fileArrListFiles2) {
                if (file6 != null && file6.isFile()) {
                    C0702g.b("PermissionUtils", " delete res = " + file6.delete());
                }
            }
        }
        try {
            if (!file3.exists()) {
                C0702g.b("PermissionUtils", "create res = " + file3.createNewFile());
            }
            if (!file4.exists()) {
                C0702g.b("PermissionUtils", "create res = " + file4.createNewFile());
            }
            T1.b.a(context, "pp_0.html", file3);
            T1.b.a(context, "pp_0.html", file4);
        } catch (IOException e6) {
            C0702g.b("PermissionUtils", "e = " + e6);
        }
    }

    private static void J(boolean z5) {
        PackageManager packageManager = P1.a.a().getPackageManager();
        int i5 = z5 ? 1 : 2;
        try {
            packageManager.setApplicationEnabledSetting("com.stepos.alphame", i5, 1);
        } catch (Exception e6) {
            C0702g.O("PermissionUtils", "setApplicationEnabledSetting failed");
            C0702g.r("PermissionUtils", e6);
        }
        if (!z5 || u()) {
            return;
        }
        int iMyUid = Process.myUid() / 100000;
        L("com.stepos.alphame", i5, iMyUid);
        K("com.stepos.alphame", i5, iMyUid);
        if (u()) {
            return;
        }
        L("com.stepos.alphame", i5, 0);
        K("com.stepos.alphame", i5, 0);
        m(0);
    }

    private static void K(String str, int i5, int i6) {
        try {
            PackageManager packageManager = P1.a.a().getPackageManager();
            h.g gVarB = N1.h.b(packageManager);
            Class cls = Integer.TYPE;
            gVarB.a("setApplicationEnabledSetting", String.class, cls, cls, cls).a(packageManager, str, Integer.valueOf(i5), 1, Integer.valueOf(i6));
        } catch (Exception e6) {
            C0702g.O("PermissionUtils", "PackageManager#setApplicationEnabledSetting(user) failed, userId=" + i6);
            C0702g.r("PermissionUtils", e6);
        }
    }

    private static void L(String str, int i5, int i6) {
        try {
            PackageManager packageManager = P1.a.a().getPackageManager();
            Object obj = N1.h.b(packageManager).b("mPM").get(packageManager);
            h.g gVarA = N1.h.a(obj.getClass());
            Class cls = Integer.TYPE;
            gVarA.a("setApplicationEnabledSetting", String.class, cls, cls, cls, String.class).a(obj, str, Integer.valueOf(i5), 1, Integer.valueOf(i6), P1.a.a().getPackageName());
        } catch (Exception e6) {
            C0702g.O("PermissionUtils", "IPackageManager#setApplicationEnabledSetting failed, userId=" + i6);
            C0702g.r("PermissionUtils", e6);
        }
    }

    public static boolean M(Context context) {
        return !u();
    }

    public static boolean N(Context context) {
        return (context == null || v(context) || !w(context)) ? false : true;
    }

    public static boolean O(m mVar) {
        Activity activityK = mVar.k();
        if (activityK == null || activityK.isFinishing() || activityK.isDestroyed() || mVar.g()) {
            return false;
        }
        return !x(activityK);
    }

    public static boolean P(m mVar) {
        Activity activityK = mVar.k();
        if (activityK == null || activityK.isFinishing() || activityK.isDestroyed() || mVar.g()) {
            return false;
        }
        return !z(activityK);
    }

    public static void Q(m mVar, k kVar) {
        Activity activityK = mVar.k();
        try {
            PolicySdk.showCustomPolicyDialogRecord(activityK, Boolean.FALSE, new String[0], new String[0], activityK.getString(R.string.us_usage_statistics), BuildConfig.FLAVOR, p(activityK, R.string.us_permission_policy_description), new String[]{"pp"}, BuildConfig.FLAVOR, new e(mVar, activityK, kVar)).show();
            mVar.j(true);
        } catch (Exception e6) {
            C0702g.r("PermissionUtils", e6);
        }
    }

    public static void R(m mVar, k kVar) {
        Activity activityK = mVar.k();
        try {
            PolicySdk.showCustomPolicyDialogRecord(activityK, Boolean.FALSE, new String[0], new String[0], activityK.getString(R.string.us_usage_statistics), BuildConfig.FLAVOR, p(activityK, R.string.mm_permission_policy_description), new String[]{"pp"}, BuildConfig.FLAVOR, new f(mVar, activityK, kVar)).show();
            mVar.j(true);
        } catch (Exception e6) {
            C0702g.r("PermissionUtils", e6);
        }
    }

    public static void S(Activity activity, l lVar) {
        stepos.support.v7.app.c cVarShowWithdrawalDialogRecord = PolicySdk.showWithdrawalDialogRecord((Activity) new WeakReference(activity).get(), activity.getString(R.string.fg_revoke_policy_title), q(activity), activity.getString(R.string.fg_common_cancel), activity.getString(R.string.fg_revoke_agree), new String[]{"pp"}, BuildConfig.FLAVOR, new C0230g(lVar));
        cVarShowWithdrawalDialogRecord.setHighLightButton(-1, 2);
        cVarShowWithdrawalDialogRecord.show();
    }

    public static void T(Activity activity) {
        U(activity, null);
    }

    public static void U(Activity activity, l lVar) {
        Activity activity2 = (Activity) new WeakReference(activity).get();
        if (T1.b.j(activity)) {
            PolicySdkStringUtils policySdkStringUtils = PolicySdkStringUtils.INSTANCE;
            stepos.support.v7.app.c cVarShowWithdrawalCleanDialog = PolicySdk.showWithdrawalCleanDialog(activity, policySdkStringUtils.withdrawMessage(activity), policySdkStringUtils.withdrawCheckMessage(activity), new i(activity2, lVar));
            if (cVarShowWithdrawalCleanDialog == null || cVarShowWithdrawalCleanDialog.isShowing()) {
                return;
            }
            cVarShowWithdrawalCleanDialog.show();
            return;
        }
        stepos.support.v7.app.c cVarShowWithdrawalDialogRecord = PolicySdk.showWithdrawalDialogRecord(activity2, activity.getString(R.string.fg_revoke_policy_title), q(activity), activity.getString(R.string.fg_common_cancel), activity.getString(R.string.fg_revoke_agree), new String[]{"pp"}, BuildConfig.FLAVOR, new h(lVar));
        cVarShowWithdrawalDialogRecord.setHighLightButton(-1, 2);
        cVarShowWithdrawalDialogRecord.show();
    }

    public static void V(Context context) {
        Context applicationContext = context.getApplicationContext();
        UserManager userManager = (UserManager) applicationContext.getSystemService("user");
        if (userManager != null && !userManager.isUserUnlocked()) {
            F();
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        SharedPreferences sharedPreferencesO = o(applicationContext);
        boolean zContains = defaultSharedPreferences.contains("digital_wellbeing_permission_granted");
        if (sharedPreferencesO.contains("digital_wellbeing_permission_granted") && !zContains) {
            Log.w("PermissionUtils", "syncPermissionStateAfterAppDataClear: default prefs lost the consent key, dropping DE copy");
            sharedPreferencesO.edit().remove("digital_wellbeing_permission_granted").apply();
        }
        F();
    }

    public static boolean W(boolean z5) throws InterruptedException {
        J(z5);
        if (!z5 || u() == z5) {
            return u() == z5;
        }
        for (int i5 = 0; i5 < 5; i5++) {
            try {
                Thread.sleep(200L);
                J(z5);
                if (u() == z5) {
                    return true;
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        return u() == z5;
    }

    public static x3.q<Boolean> X(final Context context, final String str, final boolean z5) {
        return n(context).f(new D3.h() { // from class: p2.a
            @Override // D3.h
            public final Object apply(Object obj) {
                return g.f(str, context, z5, (Boolean) obj);
            }
        });
    }

    public static /* synthetic */ void a(r rVar, ArrayList arrayList) {
        C0702g.b("PermissionUtils", "ensurePrivateDeleteInfoLoaded getResult: arrayList = " + C0702g.k(arrayList));
        if (arrayList == null || arrayList.isEmpty()) {
            C0702g.p("PermissionUtils", "ensurePrivateDeleteInfoLoaded: empty result");
            rVar.c(Boolean.FALSE);
        } else {
            f19369d = ((DeleteInfoBean) arrayList.get(0)).getServiceId();
            f19370e = arrayList;
            rVar.c(Boolean.TRUE);
        }
    }

    public static /* synthetic */ void b(String str, final Context context, final boolean z5, final r rVar) {
        ArrayList arrayList = new ArrayList();
        for (DeleteInfoBean deleteInfoBean : f19370e) {
            DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = new DeleteInfoEncryptMultiBean();
            deleteInfoEncryptMultiBean.setServiceId(deleteInfoBean.getServiceId());
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("IMEI_ID", T1.b.b());
            linkedHashMap.put("PHONE", str);
            deleteInfoEncryptMultiBean.setBindMap(linkedHashMap);
            arrayList.add(deleteInfoEncryptMultiBean);
        }
        PolicySdk.encryptMultiDeleteListBySecure(context, arrayList, new PolicySdk.PolicySdkEncryptCallback() { // from class: p2.f
            @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkEncryptCallback
            public final void getResult(ArrayList arrayList2) {
                g.c(context, z5, rVar, arrayList2);
            }
        });
    }

    public static /* synthetic */ void c(Context context, boolean z5, r rVar, ArrayList arrayList) {
        C0702g.b("PermissionUtils", "getResult: encryptList = " + C0702g.k(arrayList));
        PolicySdk.withdrawalCleanCustomUploadRecord(context, z5 ? "1" : "0", arrayList, new String[]{"pp"}, BuildConfig.FLAVOR, "3", new d(rVar, context));
    }

    public static /* synthetic */ u f(final String str, final Context context, final boolean z5, Boolean bool) {
        if (bool.booleanValue()) {
            return x3.q.c(new t() { // from class: p2.d
                @Override // x3.t
                public final void a(r rVar) {
                    g.b(str, context, z5, rVar);
                }
            });
        }
        C0702g.p("PermissionUtils", "updateWithdrawalAndCleanDataDefault: sDeleteInfoBeanList = empty");
        return x3.q.i(Boolean.FALSE);
    }

    public static void j(Context context) {
        if (context == null) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove("app_list_permission_request_denied").apply();
    }

    public static void k(Context context) {
        Context applicationContext = context.getApplicationContext();
        o(applicationContext).edit().remove("digital_wellbeing_permission_granted").apply();
        PreferenceManager.getDefaultSharedPreferences(applicationContext).edit().remove("digital_wellbeing_permission_granted").apply();
        j(applicationContext);
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static stepos.support.v7.app.c l(Context context) {
        return new c.a(context).x(R.string.fg_service_error).r(context.getString(R.string.stepos_permission_i_know), new DialogInterface.OnClickListener() { // from class: p2.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                dialogInterface.cancel();
            }
        }).c();
    }

    private static void m(int i5) {
        try {
            if (Runtime.getRuntime().exec(new String[]{"pm", "enable", "--user", String.valueOf(i5), "com.stepos.alphame"}).waitFor() != 0) {
                C0702g.O("PermissionUtils", "pm enable failed, userId=" + i5);
            }
        } catch (Exception e6) {
            C0702g.O("PermissionUtils", "pm enable shell failed, userId=" + i5);
            C0702g.r("PermissionUtils", e6);
        }
    }

    private static x3.q<Boolean> n(Context context) {
        List<DeleteInfoBean> list = f19370e;
        if (list != null && !list.isEmpty()) {
            return x3.q.i(Boolean.TRUE);
        }
        final Context applicationContext = context.getApplicationContext();
        return x3.q.c(new t() { // from class: p2.b
            @Override // x3.t
            public final void a(r rVar) {
                PolicySdk.getPrivateDeleteInfoListBySecure(applicationContext, new PolicySdk.PolicySdkEncryptCallback() { // from class: p2.e
                    @Override // com.stepos.policy.sdk.PolicySdk.PolicySdkEncryptCallback
                    public final void getResult(ArrayList arrayList) {
                        g.a(rVar, arrayList);
                    }
                });
            }
        });
    }

    private static SharedPreferences o(Context context) {
        return context.getApplicationContext().createDeviceProtectedStorageContext().getSharedPreferences("permission_state_de", 0);
    }

    private static CharSequence p(Context context, int i5) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getString(R.string.fg_privacy_policy_title);
        String string2 = context.getString(R.string.fg_privacy_policy_text);
        String str = String.format(context.getString(i5), string2);
        spannableStringBuilder.append((CharSequence) str);
        int iIndexOf = str.indexOf(string2);
        spannableStringBuilder.setSpan(new j(context, string, "pp"), iIndexOf, string2.length() + iIndexOf, 34);
        return spannableStringBuilder;
    }

    private static CharSequence q(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = context.getString(R.string.fg_privacy_policy_title);
        String string2 = context.getString(R.string.fg_privacy_policy_text);
        String str = String.format(context.getString(R.string.fg_revoke_policy_message), string2, string2);
        spannableStringBuilder.append((CharSequence) str);
        int iIndexOf = str.indexOf(string2);
        spannableStringBuilder.setSpan(new a(context, string, "pp"), iIndexOf, string2.length() + iIndexOf, 34);
        int iIndexOf2 = str.indexOf(string2, iIndexOf + string2.length());
        spannableStringBuilder.setSpan(new b(context, string, "pp"), iIndexOf2, string2.length() + iIndexOf2, 34);
        return spannableStringBuilder;
    }

    public static int r(Context context, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("stepos.intent.extra.PACKAGE_NAME", context.getPackageName());
            bundle.putString("stepos.intent.extra.PERMISSION_NAME", str);
            Bundle bundleCall = context.getContentResolver().call(Uri.parse("content://com.stepos.safe.newpermission.StepOSPermProvider"), "getCustomPermissionState", BuildConfig.FLAVOR, bundle);
            if (bundleCall == null) {
                return 3;
            }
            int i5 = bundleCall.getInt("stepos.intent.extra.PERMISSION_STATE");
            Log.d("PermissionUtils", "result_state:" + i5);
            return i5;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public static void s(Activity activity, String str) {
        if (activity == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "stepos:read_app_list";
        }
        PackageManager packageManager = activity.getPackageManager();
        Intent intentPutExtra = new Intent("com.stepos.permissioncontroller.SHOW_APPSEC_FULL").putExtra("style_full_lite", true).putExtra("packageName", activity.getPackageName()).putExtra("permission", str);
        try {
            if (intentPutExtra.resolveActivity(packageManager) != null) {
                activity.startActivityForResult(intentPutExtra, 1);
                return;
            }
        } catch (Exception e6) {
            C0702g.r("PermissionUtils", e6);
        }
        ComponentName componentName = new ComponentName("com.android.permissioncontroller", "com.stepos.safe.newpermission.ui.AppPermissionsActivity");
        Intent intent = new Intent();
        intent.setComponent(componentName).putExtra("style_full_lite", false).putExtra("packageName", activity.getPackageName()).putExtra("permission", str);
        try {
            if (intent.resolveActivity(packageManager) == null) {
                C0702g.p("PermissionUtils", "Permission controller activity not found: " + componentName);
            } else {
                activity.startActivityForResult(intent, 1);
            }
        } catch (ActivityNotFoundException e7) {
            C0702g.r("PermissionUtils", e7);
        } catch (Exception e8) {
            C0702g.r("PermissionUtils", e8);
        }
    }

    public static synchronized void t(Context context) {
        V(context);
        D(context);
        PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit().remove("alpha_me_consent_accepted").apply();
        HashMap map = new HashMap();
        map.put("up", "file:////android_asset/pp_0.html");
        map.put("pp", "file:////android_asset/pp_0.html");
        map.put("pcpi", "file:////android_asset/pcpi_0.html");
        map.put("picl", "file:////android_asset/picl_0.html");
        map.put("per", "file:////android_asset/per_0.html");
        HashMap map2 = new HashMap();
        map2.put("8a60718649104275b94d697ab125bb0e", "picl");
        map2.put("74f13dc466d241fd8f92ec013650fb01", "per");
        map2.put("1fc85872a3d849289a89936263e3669f", "pcpi");
        PolicySdk.setCloudPolicyUidCategoryMap(map2);
        PolicySdk.initSDK(context, "44842110026241323030", "1.0.0_20260928_173807", map);
    }

    public static boolean u() {
        try {
            try {
                int applicationEnabledSetting = P1.a.a().getPackageManager().getApplicationEnabledSetting("com.stepos.alphame");
                return applicationEnabledSetting == 0 || applicationEnabledSetting == 1;
            } catch (PackageManager.NameNotFoundException unused) {
                C0702g.O("PermissionUtils", "AlphaMe package not found");
                return false;
            }
        } catch (IllegalArgumentException unused2) {
            return P1.a.a().getPackageManager().getApplicationInfo("com.stepos.alphame", 512).enabled;
        } catch (Exception e6) {
            C0702g.r("PermissionUtils", e6);
            return false;
        }
    }

    public static boolean v(Context context) {
        int iR;
        return (context != null && androidx.core.content.a.a(context, "com.android.permission.GET_INSTALLED_APPS") == 0) || (iR = r(context, "stepos:read_app_list")) == 0 || iR == 4 || iR == 5;
    }

    public static boolean w(Context context) {
        if (context == null) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("app_list_permission_request_denied", false);
    }

    public static boolean x(Context context) {
        if (f19367b) {
            return true;
        }
        boolean zD = D(context);
        if (zD) {
            f19367b = true;
        }
        return zD;
    }

    public static boolean y(Context context) {
        if (f19368c) {
            return true;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean z5 = defaultSharedPreferences.getBoolean("family_guard_permission_granted", true) && defaultSharedPreferences.contains("family_guard_permission_granted");
        if (z5) {
            f19368c = true;
        }
        return z5;
    }

    public static boolean z(Context context) {
        return x(context);
    }

    /* renamed from: p2.g$g, reason: collision with other inner class name */
    class C0230g implements r.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f19385a;

        C0230g(l lVar) {
            this.f19385a = lVar;
        }

        public static /* synthetic */ x3.f c(Application application) throws IOException {
            g.I(application);
            g.G(application);
            return x3.f.D(Boolean.TRUE);
        }

        public static /* synthetic */ x3.f d(Application application) throws IOException {
            g.I(application);
            g.H(application);
            return x3.f.D(Boolean.TRUE);
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            super.onPermissionClick(dialogInterface, z5, z6);
            if (z6) {
                x3.f fVarG = x3.f.D(P1.a.a()).X(T3.a.c()).E(new D3.h() { // from class: p2.j
                    @Override // D3.h
                    public final Object apply(Object obj) {
                        return g.C0230g.c((Application) obj);
                    }
                }).G(C1347a.a());
                final l lVar = this.f19385a;
                fVarG.S(new D3.c() { // from class: p2.k
                    @Override // D3.c
                    public final void accept(Object obj) {
                        lVar.a(true);
                    }
                });
            } else {
                l lVar2 = this.f19385a;
                if (lVar2 != null) {
                    lVar2.a(z6);
                }
            }
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6, Map<String, Boolean> map) {
            super.onPermissionClick(dialogInterface, z5, z6, map);
            if (z6) {
                x3.f fVarG = x3.f.D(P1.a.a()).X(T3.a.c()).E(new D3.h() { // from class: p2.h
                    @Override // D3.h
                    public final Object apply(Object obj) {
                        return g.C0230g.d((Application) obj);
                    }
                }).G(C1347a.a());
                final l lVar = this.f19385a;
                fVarG.S(new D3.c() { // from class: p2.i
                    @Override // D3.c
                    public final void accept(Object obj) {
                        lVar.a(true);
                    }
                });
            } else {
                l lVar2 = this.f19385a;
                if (lVar2 != null) {
                    lVar2.a(z6);
                }
            }
        }
    }

    class h implements r.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f19386a;

        h(l lVar) {
            this.f19386a = lVar;
        }

        public static /* synthetic */ x3.f a(Application application) throws IOException {
            g.I(application);
            g.H(application);
            return x3.f.D(Boolean.TRUE);
        }

        public static /* synthetic */ x3.f c(Application application) throws IOException {
            g.I(application);
            g.H(application);
            return x3.f.D(Boolean.TRUE);
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
            super.onPermissionClick(dialogInterface, z5, z6);
            if (z6) {
                x3.f fVarG = x3.f.D(P1.a.a()).X(T3.a.c()).E(new D3.h() { // from class: p2.n
                    @Override // D3.h
                    public final Object apply(Object obj) {
                        return g.h.c((Application) obj);
                    }
                }).G(C1347a.a());
                final l lVar = this.f19386a;
                fVarG.S(new D3.c() { // from class: p2.o
                    @Override // D3.c
                    public final void accept(Object obj) {
                        lVar.a(true);
                    }
                });
            } else {
                l lVar2 = this.f19386a;
                if (lVar2 != null) {
                    lVar2.a(z6);
                }
            }
        }

        @Override // stepos.support.v7.app.r.h
        public void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6, Map<String, Boolean> map) {
            super.onPermissionClick(dialogInterface, z5, z6, map);
            if (z6) {
                x3.f fVarG = x3.f.D(P1.a.a()).X(T3.a.c()).E(new D3.h() { // from class: p2.l
                    @Override // D3.h
                    public final Object apply(Object obj) {
                        return g.h.a((Application) obj);
                    }
                }).G(C1347a.a());
                final l lVar = this.f19386a;
                fVarG.S(new D3.c() { // from class: p2.m
                    @Override // D3.c
                    public final void accept(Object obj) {
                        lVar.a(true);
                    }
                });
            } else {
                l lVar2 = this.f19386a;
                if (lVar2 != null) {
                    lVar2.a(z6);
                }
            }
        }
    }
}
