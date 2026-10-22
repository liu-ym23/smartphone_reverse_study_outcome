package androidx.compose.ui.text.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.PlatformStringDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u001c\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidStringDelegate;", "Landroidx/compose/ui/text/PlatformStringDelegate;", AppAgent.CONSTRUCT, "()V", "toUpperCase", "", TypedValues.Custom.S_STRING, "locale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "toLowerCase", "capitalize", "decapitalize", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidStringDelegate implements PlatformStringDelegate {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String capitalize(String string, Locale locale) {
        String strValueOf;
        if (string.length() <= 0) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = string.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            k.f(locale, "locale");
            String strValueOf2 = String.valueOf(cCharAt);
            k.d(strValueOf2, "null cannot be cast to non-null type java.lang.String");
            strValueOf = strValueOf2.toUpperCase(locale);
            k.e(strValueOf, "toUpperCase(...)");
            if (strValueOf.length() <= 1) {
                String strValueOf3 = String.valueOf(cCharAt);
                k.d(strValueOf3, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf3.toUpperCase(Locale.ROOT);
                k.e(upperCase, "toUpperCase(...)");
                if (strValueOf.equals(upperCase)) {
                    strValueOf = String.valueOf(Character.toTitleCase(cCharAt));
                }
            } else if (cCharAt != 329) {
                char cCharAt2 = strValueOf.charAt(0);
                String strSubstring = strValueOf.substring(1);
                k.e(strSubstring, "substring(...)");
                String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
                k.e(lowerCase, "toLowerCase(...)");
                strValueOf = cCharAt2 + lowerCase;
            }
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        String strSubstring2 = string.substring(1);
        k.e(strSubstring2, "substring(...)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String decapitalize(String string, Locale locale) {
        if (string.length() <= 0) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = string.charAt(0);
        k.f(locale, "locale");
        String strValueOf = String.valueOf(cCharAt);
        k.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        k.e(lowerCase, "toLowerCase(...)");
        sb.append((Object) lowerCase);
        String strSubstring = string.substring(1);
        k.e(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toLowerCase(String string, Locale locale) {
        String lowerCase = string.toLowerCase(locale);
        k.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toUpperCase(String string, Locale locale) {
        String upperCase = string.toUpperCase(locale);
        k.e(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
