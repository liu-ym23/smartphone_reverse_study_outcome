package stepos.support.v7.permission;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemProperties;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.stepos.aiengine.R;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TermsStringBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12301a;

    /* renamed from: e, reason: collision with root package name */
    public a f12305e;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12302b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12303c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12304d = true;

    /* renamed from: f, reason: collision with root package name */
    public int f12306f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f12307g = 0;
    public String h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f12308i = null;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
            boolean zContains;
            super.updateDrawState(textPaint);
            try {
                zContains = SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
            } catch (Exception unused) {
                zContains = false;
            }
            int i10 = zContains ? POLE_STAR_COLOR : STEP_OS_COLOR;
            textPaint.setUnderlineText(false);
            textPaint.setColor(i10);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void onPrivacyPolicyClick(Context context);

        void onUserAgreementClick(Context context);
    }

    public TermsStringBuilder(Context context) {
        this.f12301a = context;
    }

    public static String a(String str) {
        return !"zh".equals(Locale.getDefault().getLanguage()) ? a0.a.k("\"", str, "\"") : a0.a.k("《", str, "》");
    }

    public final SpannableString b() throws Resources.NotFoundException {
        String strA;
        String string;
        if (this.f12305e == null) {
            throw new IllegalStateException("mOnClickListener can't be null");
        }
        boolean z = this.f12302b;
        if (!z && !this.f12303c && !this.f12304d) {
            throw new IllegalStateException("mHasPermission mPrivacyPolicy and mUserAgreement can't be false at the same time");
        }
        String strA2 = null;
        Context context = this.f12301a;
        if (z) {
            String string2 = this.h;
            if (string2 == null) {
                string2 = context.getResources().getString(R.string.stepos_privacy_policy);
            }
            strA = a(string2);
        } else {
            strA = null;
        }
        if (this.f12303c) {
            String string3 = this.f12308i;
            if (string3 == null) {
                string3 = context.getResources().getString(R.string.stepos_user_agreement);
            }
            strA2 = a(string3);
        }
        boolean z3 = this.f12302b;
        if (z3 && this.f12303c) {
            String strI = "zh".equals(Locale.getDefault().getLanguage()) ? com.stepos.core.ota.d.i(strA, "和", strA2) : com.stepos.core.ota.d.i(strA, " and ", strA2);
            string = this.f12307g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strI) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strI);
        } else {
            string = z3 ? this.f12307g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strA) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strA) : this.f12303c ? this.f12307g == 0 ? context.getResources().getString(R.string.stepos_permission_policy_description_f9, strA2) : context.getResources().getString(R.string.stepos_permission_policy_description_update, strA2) : context.getResources().getString(R.string.stepos_permission_policy_description_noly_internet);
        }
        if (this.f12304d) {
            if (!TextUtils.isEmpty(string)) {
                if ("zh".equals(Locale.getDefault().getLanguage())) {
                    StringBuilder sbB = v1.d.b(string);
                    sbB.append((this.f12302b || this.f12303c) ? "。" : "，");
                    string = sbB.toString();
                } else {
                    StringBuilder sbB2 = v1.d.b(string);
                    sbB2.append((this.f12302b || this.f12303c) ? ". " : ", ");
                    string = sbB2.toString();
                }
            }
            int i10 = this.f12306f;
            if (i10 == 0) {
                StringBuilder sbB3 = v1.d.b(string);
                sbB3.append(context.getResources().getString(R.string.stepos_permission_inform_f9));
                string = sbB3.toString();
            } else if (i10 == 1) {
                StringBuilder sbB4 = v1.d.b(string);
                sbB4.append(context.getResources().getString(R.string.stepos_permission_inform_f9_only_internet));
                string = sbB4.toString();
            } else if (i10 == 2) {
                StringBuilder sbB5 = v1.d.b(string);
                sbB5.append(context.getResources().getString(R.string.stepos_permission_inform_f9_no_internet));
                string = sbB5.toString();
            }
        }
        SpannableString spannableString = new SpannableString(string);
        if (!TextUtils.isEmpty(strA)) {
            int iIndexOf = string.indexOf(strA);
            spannableString.setSpan(new PermissionClickableSpan(strA, context) { // from class: stepos.support.v7.permission.TermsStringBuilder.1
                @Override // stepos.support.v7.permission.TermsStringBuilder.PermissionClickableSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(View view) {
                    super.onClick(view);
                    TermsStringBuilder.this.f12305e.onPrivacyPolicyClick(view.getContext());
                }
            }, iIndexOf, strA.length() + iIndexOf, 18);
        }
        if (!TextUtils.isEmpty(strA2)) {
            int iIndexOf2 = string.indexOf(strA2);
            spannableString.setSpan(new PermissionClickableSpan(strA2, context) { // from class: stepos.support.v7.permission.TermsStringBuilder.2
                @Override // stepos.support.v7.permission.TermsStringBuilder.PermissionClickableSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(View view) {
                    super.onClick(view);
                    TermsStringBuilder.this.f12305e.onUserAgreementClick(view.getContext());
                }
            }, iIndexOf2, strA2.length() + iIndexOf2, 18);
        }
        return spannableString;
    }
}
