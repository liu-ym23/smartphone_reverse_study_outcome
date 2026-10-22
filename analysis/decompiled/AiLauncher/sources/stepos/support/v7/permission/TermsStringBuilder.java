package stepos.support.v7.permission;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemProperties;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import java.util.Locale;
import stepos.support.v7.appcompat.R$string;

/* loaded from: classes5.dex */
public class TermsStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f40832a;

    /* renamed from: e, reason: collision with root package name */
    public a f40836e;

    /* renamed from: b, reason: collision with root package name */
    public boolean f40833b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f40834c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f40835d = true;

    /* renamed from: f, reason: collision with root package name */
    public int f40837f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f40838g = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f40839h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f40840i = null;

    public static class PermissionClickableSpan extends URLSpan {
        private static final int POLE_STAR_COLOR = -35584;
        private static final int STEP_OS_COLOR = -15505157;

        public PermissionClickableSpan(String str, Context context) {
            super(str);
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            view.cancelPendingInputEvents();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            int i10 = TermsStringBuilder.f() ? POLE_STAR_COLOR : STEP_OS_COLOR;
            textPaint.setUnderlineText(false);
            textPaint.setColor(i10);
        }
    }

    public interface a {
        void onPrivacyPolicyClick(Context context);

        void onUserAgreementClick(Context context);
    }

    public TermsStringBuilder(Context context) {
        this.f40832a = context;
    }

    public static boolean f() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g() {
        return "zh".equals(Locale.getDefault().getLanguage());
    }

    public final String c(String str) {
        if (g()) {
            return "《" + str + "》";
        }
        return "\"" + str + "\"";
    }

    public final String d(String str, String str2) {
        if (g()) {
            return str + "和" + str2;
        }
        return str + " and " + str2;
    }

    public SpannableString e() throws Resources.NotFoundException {
        String strC;
        String string;
        if (this.f40836e == null) {
            throw new IllegalStateException("mOnClickListener can't be null");
        }
        boolean z10 = this.f40833b;
        if (!z10 && !this.f40834c && !this.f40835d) {
            throw new IllegalStateException("mHasPermission mPrivacyPolicy and mUserAgreement can't be false at the same time");
        }
        String strC2 = null;
        if (z10) {
            String string2 = this.f40839h;
            if (string2 == null) {
                string2 = this.f40832a.getResources().getString(R$string.stepos_privacy_policy);
            }
            strC = c(string2);
        } else {
            strC = null;
        }
        if (this.f40834c) {
            String string3 = this.f40840i;
            if (string3 == null) {
                string3 = this.f40832a.getResources().getString(R$string.stepos_user_agreement);
            }
            strC2 = c(string3);
        }
        boolean z11 = this.f40833b;
        if (z11 && this.f40834c) {
            String strD = d(strC, strC2);
            string = this.f40838g == 0 ? this.f40832a.getResources().getString(R$string.stepos_permission_policy_description_f9, strD) : this.f40832a.getResources().getString(R$string.stepos_permission_policy_description_update, strD);
        } else {
            string = z11 ? this.f40838g == 0 ? this.f40832a.getResources().getString(R$string.stepos_permission_policy_description_f9, strC) : this.f40832a.getResources().getString(R$string.stepos_permission_policy_description_update, strC) : this.f40834c ? this.f40838g == 0 ? this.f40832a.getResources().getString(R$string.stepos_permission_policy_description_f9, strC2) : this.f40832a.getResources().getString(R$string.stepos_permission_policy_description_update, strC2) : this.f40832a.getResources().getString(R$string.stepos_permission_policy_description_noly_internet);
        }
        if (this.f40835d) {
            if (!TextUtils.isEmpty(string)) {
                if (g()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append((this.f40833b || this.f40834c) ? "。" : "，");
                    string = sb2.toString();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(string);
                    sb3.append((this.f40833b || this.f40834c) ? ". " : ", ");
                    string = sb3.toString();
                }
            }
            int i10 = this.f40837f;
            if (i10 == 0) {
                string = string + this.f40832a.getResources().getString(R$string.stepos_permission_inform_f9);
            } else if (i10 == 1) {
                string = string + this.f40832a.getResources().getString(R$string.stepos_permission_inform_f9_only_internet);
            } else if (i10 == 2) {
                string = string + this.f40832a.getResources().getString(R$string.stepos_permission_inform_f9_no_internet);
            }
        }
        SpannableString spannableString = new SpannableString(string);
        if (!TextUtils.isEmpty(strC)) {
            int iIndexOf = string.indexOf(strC);
            spannableString.setSpan(new PermissionClickableSpan(strC, this.f40832a) { // from class: stepos.support.v7.permission.TermsStringBuilder.1
                @Override // stepos.support.v7.permission.TermsStringBuilder.PermissionClickableSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(View view) {
                    super.onClick(view);
                    TermsStringBuilder.this.f40836e.onPrivacyPolicyClick(view.getContext());
                }
            }, iIndexOf, strC.length() + iIndexOf, 18);
        }
        if (!TextUtils.isEmpty(strC2)) {
            int iIndexOf2 = string.indexOf(strC2);
            spannableString.setSpan(new PermissionClickableSpan(strC2, this.f40832a) { // from class: stepos.support.v7.permission.TermsStringBuilder.2
                @Override // stepos.support.v7.permission.TermsStringBuilder.PermissionClickableSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(View view) {
                    super.onClick(view);
                    TermsStringBuilder.this.f40836e.onUserAgreementClick(view.getContext());
                }
            }, iIndexOf2, strC2.length() + iIndexOf2, 18);
        }
        return spannableString;
    }

    public TermsStringBuilder h(int i10) {
        this.f40838g = i10;
        return this;
    }

    public TermsStringBuilder i(boolean z10) {
        this.f40835d = z10;
        return this;
    }

    public TermsStringBuilder j(int i10) {
        this.f40837f = i10;
        return this;
    }

    public TermsStringBuilder k(a aVar) {
        this.f40836e = aVar;
        return this;
    }

    public TermsStringBuilder l(boolean z10) {
        this.f40833b = z10;
        return this;
    }

    public TermsStringBuilder m(String str) {
        this.f40839h = str;
        return this;
    }

    public TermsStringBuilder n(boolean z10) {
        this.f40834c = z10;
        return this;
    }

    public TermsStringBuilder o(String str) {
        this.f40840i = str;
        return this;
    }
}
