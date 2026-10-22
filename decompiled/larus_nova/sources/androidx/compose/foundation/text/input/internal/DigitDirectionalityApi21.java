package androidx.compose.foundation.text.input.internal;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/internal/DigitDirectionalityApi21;", "", "<init>", "()V", JSEventListener.ACTION_RESOLVE, "", "locale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DigitDirectionalityApi21 {
    public static final DigitDirectionalityApi21 INSTANCE = null;

    static {
        INSTANCE = new DigitDirectionalityApi21();
    }

    private DigitDirectionalityApi21() {
    }

    public final byte resolve(Locale r100) {
        return Character.getDirectionality(DecimalFormatSymbols.getInstance(r100).getZeroDigit());
    }
}
