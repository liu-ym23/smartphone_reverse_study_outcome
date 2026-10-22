package M8;

import O8.h;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final h f4652a;

    /* renamed from: b, reason: collision with root package name */
    public final c f4653b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4654c;

    public a(h hVar, c cVar, String str) {
        this.f4652a = hVar;
        this.f4653b = cVar;
        this.f4654c = str;
    }

    public static a b(h hVar, c cVar, String str) {
        return new a(hVar, cVar, str);
    }

    @Override // M8.d
    public CharSequence a(String str, String str2) {
        return str2.isEmpty() ? str2 : str == null ? d(str2) : e(str, str2);
    }

    public CharSequence c(String str, h.a aVar, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        new b(str, this.f4653b, spannableStringBuilder).a(this.f4652a.m(str2, aVar));
        return spannableStringBuilder;
    }

    public CharSequence d(String str) {
        return str;
    }

    public CharSequence e(String str, String str2) {
        h.a aVarA = this.f4652a.a(str);
        if (aVarA == null && !TextUtils.isEmpty(this.f4654c)) {
            str = this.f4654c;
            aVarA = this.f4652a.a(str);
        }
        return aVarA != null ? c(str, aVarA, str2) : str2;
    }
}
