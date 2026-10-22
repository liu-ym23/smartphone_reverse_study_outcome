package stepos.support.v7.permission;

import B0.g;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemProperties;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.R;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14653a;

    /* renamed from: e, reason: collision with root package name */
    public e f14657e;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14654b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14655c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14656d = true;

    /* renamed from: f, reason: collision with root package name */
    public int f14658f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f14659g = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f14660h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f14661i = null;

    public f(Context context) {
        this.f14653a = context;
    }

    public static String a(String str) {
        return !"zh".equals(Locale.getDefault().getLanguage()) ? g.n("\"", str, "\"") : g.n("《", str, "》");
    }

    public static boolean c() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    public final SpannableString b() throws Resources.NotFoundException {
        final String strA;
        String string;
        if (this.f14657e == null) {
            throw new IllegalStateException("mOnClickListener can't be null");
        }
        boolean z4 = this.f14654b;
        if (!z4 && !this.f14655c && !this.f14656d) {
            throw new IllegalStateException("mHasPermission mPrivacyPolicy and mUserAgreement can't be false at the same time");
        }
        final String strA2 = null;
        Context context = this.f14653a;
        if (z4) {
            String string2 = this.f14660h;
            if (string2 == null) {
                string2 = context.getResources().getString(R.string.stepos_privacy_policy);
            }
            strA = a(string2);
        } else {
            strA = null;
        }
        if (this.f14655c) {
            String string3 = this.f14661i;
            if (string3 == null) {
                string3 = context.getResources().getString(R.string.stepos_user_agreement);
            }
            strA2 = a(string3);
        }
        boolean z5 = this.f14654b;
        if (z5 && this.f14655c) {
            String strQ = "zh".equals(Locale.getDefault().getLanguage()) ? AbstractC0351g.q(strA, "和", strA2) : AbstractC0351g.q(strA, " and ", strA2);
            string = this.f14659g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strQ) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strQ);
        } else {
            string = z5 ? this.f14659g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strA) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strA) : this.f14655c ? this.f14659g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strA2) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strA2) : context.getResources().getString(R.string.stepos_permission_policy_description_noly_internet);
        }
        if (this.f14656d) {
            if (!TextUtils.isEmpty(string)) {
                if ("zh".equals(Locale.getDefault().getLanguage())) {
                    StringBuilder sbS = g.s(string);
                    sbS.append((this.f14654b || this.f14655c) ? "。" : "，");
                    string = sbS.toString();
                } else {
                    StringBuilder sbS2 = g.s(string);
                    sbS2.append((this.f14654b || this.f14655c) ? ". " : ", ");
                    string = sbS2.toString();
                }
            }
            int i4 = this.f14658f;
            if (i4 == 0) {
                StringBuilder sbS3 = g.s(string);
                sbS3.append(context.getResources().getString(R.string.stepos_permission_inform_f9));
                string = sbS3.toString();
            } else if (i4 == 1) {
                StringBuilder sbS4 = g.s(string);
                sbS4.append(context.getResources().getString(R.string.stepos_permission_inform_f9_only_internet));
                string = sbS4.toString();
            } else if (i4 == 2) {
                StringBuilder sbS5 = g.s(string);
                sbS5.append(context.getResources().getString(R.string.stepos_permission_inform_f9_no_internet));
                string = sbS5.toString();
            }
        }
        SpannableString spannableString = new SpannableString(string);
        if (!TextUtils.isEmpty(strA)) {
            int iIndexOf = string.indexOf(strA);
            spannableString.setSpan(new TermsStringBuilder$PermissionClickableSpan(strA) { // from class: stepos.support.v7.permission.TermsStringBuilder$1
                @Override // stepos.support.v7.permission.TermsStringBuilder$PermissionClickableSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
                public final void onClick(View view) {
                    view.cancelPendingInputEvents();
                    this.f14638a.f14657e.onPrivacyPolicyClick(view.getContext());
                }
            }, iIndexOf, strA.length() + iIndexOf, 18);
        }
        if (!TextUtils.isEmpty(strA2)) {
            int iIndexOf2 = string.indexOf(strA2);
            spannableString.setSpan(new TermsStringBuilder$PermissionClickableSpan(strA2) { // from class: stepos.support.v7.permission.TermsStringBuilder$2
                @Override // stepos.support.v7.permission.TermsStringBuilder$PermissionClickableSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
                public final void onClick(View view) {
                    view.cancelPendingInputEvents();
                    this.f14639a.f14657e.onUserAgreementClick(view.getContext());
                }
            }, iIndexOf2, strA2.length() + iIndexOf2, 18);
        }
        return spannableString;
    }
}
