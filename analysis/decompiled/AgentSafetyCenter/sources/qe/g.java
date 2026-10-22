package qe;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemProperties;
import android.text.SpannableString;
import android.text.TextUtils;
import com.stepos.agentsafetycenter.R;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10233a;

    /* renamed from: e, reason: collision with root package name */
    public f f10237e;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10234b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10235c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10236d = true;

    /* renamed from: f, reason: collision with root package name */
    public int f10238f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f10239g = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f10240h = null;
    public String i = null;

    public g(Context context) {
        this.f10233a = context;
    }

    public static String a(String str) {
        return !"zh".equals(Locale.getDefault().getLanguage()) ? k0.a.C("\"", str, "\"") : k0.a.C("《", str, "》");
    }

    public static boolean c() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    public final SpannableString b() throws Resources.NotFoundException {
        String strA;
        String string;
        String strA2 = null;
        if (this.f10237e == null) {
            od.f.e("mOnClickListener can't be null");
            return null;
        }
        boolean z10 = this.f10234b;
        if (!z10 && !this.f10235c && !this.f10236d) {
            od.f.e("mHasPermission mPrivacyPolicy and mUserAgreement can't be false at the same time");
            return null;
        }
        Context context = this.f10233a;
        if (z10) {
            String string2 = this.f10240h;
            if (string2 == null) {
                string2 = context.getResources().getString(R.string.stepos_privacy_policy);
            }
            strA = a(string2);
        } else {
            strA = null;
        }
        if (this.f10235c) {
            String string3 = this.i;
            if (string3 == null) {
                string3 = context.getResources().getString(R.string.stepos_user_agreement);
            }
            strA2 = a(string3);
        }
        boolean z11 = this.f10234b;
        if (z11 && this.f10235c) {
            String strO = "zh".equals(Locale.getDefault().getLanguage()) ? k0.a.o(strA, "和", strA2) : k0.a.o(strA, " and ", strA2);
            string = this.f10239g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strO) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strO);
        } else {
            string = z11 ? this.f10239g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strA) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strA) : this.f10235c ? this.f10239g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strA2) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strA2) : context.getResources().getString(R.string.stepos_permission_policy_description_noly_internet);
        }
        if (this.f10236d) {
            if (!TextUtils.isEmpty(string)) {
                if ("zh".equals(Locale.getDefault().getLanguage())) {
                    StringBuilder sbC = w2.c.c(string);
                    sbC.append((this.f10234b || this.f10235c) ? "。" : "，");
                    string = sbC.toString();
                } else {
                    StringBuilder sbC2 = w2.c.c(string);
                    sbC2.append((this.f10234b || this.f10235c) ? ". " : ", ");
                    string = sbC2.toString();
                }
            }
            int i = this.f10238f;
            if (i == 0) {
                StringBuilder sbC3 = w2.c.c(string);
                sbC3.append(context.getResources().getString(R.string.stepos_permission_inform_f9));
                string = sbC3.toString();
            } else if (i == 1) {
                StringBuilder sbC4 = w2.c.c(string);
                sbC4.append(context.getResources().getString(R.string.stepos_permission_inform_f9_only_internet));
                string = sbC4.toString();
            } else if (i == 2) {
                StringBuilder sbC5 = w2.c.c(string);
                sbC5.append(context.getResources().getString(R.string.stepos_permission_inform_f9_no_internet));
                string = sbC5.toString();
            }
        }
        SpannableString spannableString = new SpannableString(string);
        if (!TextUtils.isEmpty(strA)) {
            int iIndexOf = string.indexOf(strA);
            spannableString.setSpan(new e(this, strA, 0), iIndexOf, strA.length() + iIndexOf, 18);
        }
        if (!TextUtils.isEmpty(strA2)) {
            int iIndexOf2 = string.indexOf(strA2);
            spannableString.setSpan(new e(this, strA2, 1), iIndexOf2, strA2.length() + iIndexOf2, 18);
        }
        return spannableString;
    }
}
