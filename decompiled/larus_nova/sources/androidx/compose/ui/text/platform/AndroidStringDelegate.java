package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.PlatformStringDelegate;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u001c\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u001c\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidStringDelegate;", "Landroidx/compose/ui/text/PlatformStringDelegate;", "<init>", "()V", "toUpperCase", "", "string", "locale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "toLowerCase", "capitalize", "decapitalize", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidStringDelegate implements PlatformStringDelegate {
    public static final int $stable = 0;

    public AndroidStringDelegate() {
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String capitalize(String r100, Locale r101) {
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L13;
        StringBuilder r103 = new StringBuilder();
        char r104 = r100.charAt(0);
        if (Character.isLowerCase(r104) == false) goto L10;
        String r105 = CharsKt.titlecase(r104, r101);
    L11:
        r103.append(r105);
        r103.append(r100.substring(1));
        return r103.toString();
    L10:
        r105 = String.valueOf(r104);
        goto L11
    L13:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String decapitalize(String r100, Locale r101) {
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return r100;
    L8:
        return CharsKt.lowercase(r100.charAt(0), r101) + r100.substring(1);
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toLowerCase(String r100, Locale r101) {
        return r100.toLowerCase(r101);
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toUpperCase(String r100, Locale r101) {
        return r100.toUpperCase(r101);
    }
}
