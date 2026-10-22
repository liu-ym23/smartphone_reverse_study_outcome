package C2;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

/* loaded from: classes.dex */
public class p {
    public static CharSequence a(String str, int i5, String str2) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.contains(str2)) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        int length = 0;
        while (length < str.length() && (iIndexOf = str.indexOf(str2, length)) != -1) {
            spannableString.setSpan(new ForegroundColorSpan(i5), iIndexOf, str2.length() + iIndexOf, 33);
            length = iIndexOf + str2.length();
        }
        return spannableString;
    }

    public static CharSequence b(Context context, int i5, String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i5), 0, spannableString.length(), 18);
        return spannableString;
    }
}
