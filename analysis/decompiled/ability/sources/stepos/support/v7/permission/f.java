package stepos.support.v7.permission;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemProperties;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.os.EnvironmentCompat;
import com.stepos.ability.R;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6374a;
    public e e;
    public boolean b = true;
    public boolean c = false;
    public boolean d = true;
    public int f = 0;
    public int g = 0;
    public String h = null;
    public String i = null;

    public f(Context context) {
        this.f6374a = context;
    }

    public static String a(String str) {
        return !"zh".equals(Locale.getDefault().getLanguage()) ? B7.a.m("\"", str, "\"") : B7.a.m("《", str, "》");
    }

    public static boolean c() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", EnvironmentCompat.MEDIA_UNKNOWN).contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    public final SpannableString b() throws Resources.NotFoundException {
        final String strA;
        String string;
        if (this.e == null) {
            throw new IllegalStateException("mOnClickListener can't be null");
        }
        boolean z10 = this.b;
        if (!z10 && !this.c && !this.d) {
            throw new IllegalStateException("mHasPermission mPrivacyPolicy and mUserAgreement can't be false at the same time");
        }
        final String strA2 = null;
        final Context context = this.f6374a;
        if (z10) {
            String string2 = this.h;
            if (string2 == null) {
                string2 = context.getResources().getString(R.string.stepos_privacy_policy);
            }
            strA = a(string2);
        } else {
            strA = null;
        }
        if (this.c) {
            String string3 = this.i;
            if (string3 == null) {
                string3 = context.getResources().getString(R.string.stepos_user_agreement);
            }
            strA2 = a(string3);
        }
        boolean z11 = this.b;
        if (z11 && this.c) {
            String strB = "zh".equals(Locale.getDefault().getLanguage()) ? B7.a.B(strA, "和", strA2) : B7.a.B(strA, " and ", strA2);
            string = this.g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strB) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strB);
        } else {
            string = z11 ? this.g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strA) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strA) : this.c ? this.g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strA2) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strA2) : context.getResources().getString(R.string.stepos_permission_policy_description_noly_internet);
        }
        if (this.d) {
            if (!TextUtils.isEmpty(string)) {
                if ("zh".equals(Locale.getDefault().getLanguage())) {
                    StringBuilder sbV = androidx.compose.foundation.b.v(string);
                    sbV.append((this.b || this.c) ? "。" : "，");
                    string = sbV.toString();
                } else {
                    StringBuilder sbV2 = androidx.compose.foundation.b.v(string);
                    sbV2.append((this.b || this.c) ? ". " : ", ");
                    string = sbV2.toString();
                }
            }
            int i = this.f;
            if (i == 0) {
                StringBuilder sbV3 = androidx.compose.foundation.b.v(string);
                sbV3.append(context.getResources().getString(R.string.stepos_permission_inform_f9));
                string = sbV3.toString();
            } else if (i == 1) {
                StringBuilder sbV4 = androidx.compose.foundation.b.v(string);
                sbV4.append(context.getResources().getString(R.string.stepos_permission_inform_f9_only_internet));
                string = sbV4.toString();
            } else if (i == 2) {
                StringBuilder sbV5 = androidx.compose.foundation.b.v(string);
                sbV5.append(context.getResources().getString(R.string.stepos_permission_inform_f9_no_internet));
                string = sbV5.toString();
            }
        }
        SpannableString spannableString = new SpannableString(string);
        if (!TextUtils.isEmpty(strA)) {
            int iIndexOf = string.indexOf(strA);
            spannableString.setSpan(new TermsStringBuilder$PermissionClickableSpan(strA, context) { // from class: stepos.support.v7.permission.TermsStringBuilder$1
                @Override // stepos.support.v7.permission.TermsStringBuilder$PermissionClickableSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    super.onClick(view);
                    this.this$0.e.onPrivacyPolicyClick(view.getContext());
                }
            }, iIndexOf, strA.length() + iIndexOf, 18);
        }
        if (!TextUtils.isEmpty(strA2)) {
            int iIndexOf2 = string.indexOf(strA2);
            spannableString.setSpan(new TermsStringBuilder$PermissionClickableSpan(strA2, context) { // from class: stepos.support.v7.permission.TermsStringBuilder$2
                @Override // stepos.support.v7.permission.TermsStringBuilder$PermissionClickableSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    super.onClick(view);
                    this.this$0.e.onUserAgreementClick(view.getContext());
                }
            }, iIndexOf2, strA2.length() + iIndexOf2, 18);
        }
        return spannableString;
    }
}
