package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import androidx.compose.ui.text.style.TextDirection;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"resolveTextDirectionForKeyboardTypePhone", "Landroidx/compose/ui/text/style/TextDirection;", "locale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "(Ljava/util/Locale;)I", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldLayoutStateCache_androidKt {
    public static final int resolveTextDirectionForKeyboardTypePhone(Locale r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 28) goto L6;
        byte r102 = DigitDirectionalityApi28.INSTANCE.resolve(r100);
    L10:
        if (r102 == 1) goto L16;
        if (r102 == 2) goto L16;
        return TextDirection.Companion.m7435getLtrs_7Xco();
    L16:
        return TextDirection.Companion.m7436getRtls_7Xco();
    L6:
        if (r101 < 24) goto L8;
        r102 = DigitDirectionalityApi24.INSTANCE.resolve(r100);
        goto L10
    L8:
        r102 = DigitDirectionalityApi21.INSTANCE.resolve(r100);
        goto L10
    }
}
