package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import androidx.collection.SieveCache;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.AndroidPreloadedFont;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.core.content.res.ResourcesCompat;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "Duplicate cache")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTypefaceCache;", "", "<init>", "()V", "cache", "Landroidx/collection/SieveCache;", "", "Landroid/graphics/Typeface;", "getOrCreate", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", LynxResourceModule.FONT_TYPE, "Landroidx/compose/ui/text/font/Font;", "getKey", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidTypefaceCache {
    public static final int $stable = 0;
    public static final AndroidTypefaceCache INSTANCE = null;
    private static final SieveCache<String, Typeface> cache = null;

    private AndroidTypefaceCache() {
    }

    static {
        INSTANCE = new AndroidTypefaceCache();
        cache = new SieveCache(16, 16, null, null, null, 28, null);
        $stable = 8;
    }

    private final String getKey(Context r100, Font r101) {
        if ((r101 instanceof ResourceFont) == false) goto L10;
        TypedValue r102 = new TypedValue();
        r100.getResources().getValue(((ResourceFont) r101).getResId(), r102, true);
        StringBuilder r103 = new StringBuilder("res:");
        CharSequence r104 = r102.string;
        if (r104 == null) goto L7;
        String r105 = r104.toString();
    L8:
        Intrinsics.checkNotNull(r105);
        r103.append(r105);
        return r103.toString();
    L7:
        r105 = null;
        goto L8
    L10:
        if ((r101 instanceof AndroidPreloadedFont) == false) goto L14;
        return ((AndroidPreloadedFont) r101).getCacheKey();
    L14:
        throw new IllegalArgumentException("Unknown font type: " + r101);
    }

    public final Typeface getOrCreate(Context r100, Font r101) {
        String r102 = getKey(r100, r101);
        if (r102 == null) goto L8;
        Typeface r103 = cache.get(r102);
        if (r103 == null) goto L8;
        return r103;
    L8:
        if ((r101 instanceof ResourceFont) == false) goto L14;
        if (Build.VERSION.SDK_INT < 26) goto L12;
        Typeface r104 = AndroidResourceFontLoaderHelper.INSTANCE.create(r100, ((ResourceFont) r101).getResId());
    L16:
        if (r104 == null) goto L21;
        if (r102 == null) goto L19;
        cache.put(r102, r104);
    L19:
        return r104;
    L21:
        throw new IllegalArgumentException("Unable to load font " + r101);
    L12:
        r104 = ResourcesCompat.getFont(r100, ((ResourceFont) r101).getResId());
        Intrinsics.checkNotNull(r104);
        goto L16
    L14:
        if ((r101 instanceof AndroidFont) == false) goto L23;
        AndroidFont r105 = (AndroidFont) r101;
        r104 = r105.getTypefaceLoader().loadBlocking(r100, r105);
        goto L16
    L23:
        throw new IllegalArgumentException("Unknown font type: " + r101);
    }
}
