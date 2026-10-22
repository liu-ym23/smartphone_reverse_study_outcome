package Z4;

import X4.j;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemProperties;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import java.util.Locale;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6673a;

    /* renamed from: e, reason: collision with root package name */
    private c f6677e;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6674b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6675c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6676d = true;

    /* renamed from: f, reason: collision with root package name */
    private int f6678f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f6679g = 0;

    /* renamed from: h, reason: collision with root package name */
    private String f6680h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f6681i = null;

    class a extends d {
        a(String str, Context context) {
            super(str, context);
        }

        @Override // Z4.f.d, android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            super.onClick(view);
            f.this.f6677e.onPrivacyPolicyClick(view.getContext());
        }
    }

    class b extends d {
        b(String str, Context context) {
            super(str, context);
        }

        @Override // Z4.f.d, android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            super.onClick(view);
            f.this.f6677e.onUserAgreementClick(view.getContext());
        }
    }

    public interface c {
        void onPrivacyPolicyClick(Context context);

        void onUserAgreementClick(Context context);
    }

    static class d extends URLSpan {
        public d(String str, Context context) {
            super(str);
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            view.cancelPendingInputEvents();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            int i5 = f.f() ? -35584 : -15505157;
            textPaint.setUnderlineText(false);
            textPaint.setColor(i5);
        }
    }

    public f(Context context) {
        this.f6673a = context;
    }

    private String c(String str) {
        if (g()) {
            return "《" + str + "》";
        }
        return "\"" + str + "\"";
    }

    private String d(String str, String str2) {
        if (g()) {
            return str + "和" + str2;
        }
        return str + " and " + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f() {
        try {
            return SystemProperties.get("ro.stepos.build.channel", "unknown").contains("polestar");
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean g() {
        return "zh".equals(Locale.getDefault().getLanguage());
    }

    public SpannableString e() throws Resources.NotFoundException {
        String strC;
        String string;
        if (this.f6677e == null) {
            throw new IllegalStateException("mOnClickListener can't be null");
        }
        boolean z5 = this.f6674b;
        if (!z5 && !this.f6675c && !this.f6676d) {
            throw new IllegalStateException("mHasPermission mPrivacyPolicy and mUserAgreement can't be false at the same time");
        }
        String strC2 = null;
        if (z5) {
            String string2 = this.f6680h;
            if (string2 == null) {
                string2 = this.f6673a.getResources().getString(j.f6070s);
            }
            strC = c(string2);
        } else {
            strC = null;
        }
        if (this.f6675c) {
            String string3 = this.f6681i;
            if (string3 == null) {
                string3 = this.f6673a.getResources().getString(j.f6072u);
            }
            strC2 = c(string3);
        }
        boolean z6 = this.f6674b;
        if (z6 && this.f6675c) {
            String strD = d(strC, strC2);
            string = this.f6679g == 0 ? this.f6673a.getResources().getString(j.f6062k, strD) : this.f6673a.getResources().getString(j.f6064m, strD);
        } else {
            string = z6 ? this.f6679g == 0 ? this.f6673a.getResources().getString(j.f6062k, strC) : this.f6673a.getResources().getString(j.f6064m, strC) : this.f6675c ? this.f6679g == 0 ? this.f6673a.getResources().getString(j.f6062k, strC2) : this.f6673a.getResources().getString(j.f6064m, strC2) : this.f6673a.getResources().getString(j.f6063l);
        }
        if (this.f6676d) {
            if (!TextUtils.isEmpty(string)) {
                if (g()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append((this.f6674b || this.f6675c) ? "。" : "，");
                    string = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(string);
                    sb2.append((this.f6674b || this.f6675c) ? ". " : ", ");
                    string = sb2.toString();
                }
            }
            int i5 = this.f6678f;
            if (i5 == 0) {
                string = string + this.f6673a.getResources().getString(j.f6058g);
            } else if (i5 == 1) {
                string = string + this.f6673a.getResources().getString(j.f6060i);
            } else if (i5 == 2) {
                string = string + this.f6673a.getResources().getString(j.f6059h);
            }
        }
        SpannableString spannableString = new SpannableString(string);
        if (!TextUtils.isEmpty(strC)) {
            int iIndexOf = string.indexOf(strC);
            spannableString.setSpan(new a(strC, this.f6673a), iIndexOf, strC.length() + iIndexOf, 18);
        }
        if (!TextUtils.isEmpty(strC2)) {
            int iIndexOf2 = string.indexOf(strC2);
            spannableString.setSpan(new b(strC2, this.f6673a), iIndexOf2, strC2.length() + iIndexOf2, 18);
        }
        return spannableString;
    }

    public f h(int i5) {
        this.f6679g = i5;
        return this;
    }

    public f i(boolean z5) {
        this.f6676d = z5;
        return this;
    }

    public f j(int i5) {
        this.f6678f = i5;
        return this;
    }

    public f k(c cVar) {
        this.f6677e = cVar;
        return this;
    }

    public f l(boolean z5) {
        this.f6674b = z5;
        return this;
    }

    public f m(String str) {
        this.f6680h = str;
        return this;
    }

    public f n(boolean z5) {
        this.f6675c = z5;
        return this;
    }

    public f o(String str) {
        this.f6681i = str;
        return this;
    }
}
