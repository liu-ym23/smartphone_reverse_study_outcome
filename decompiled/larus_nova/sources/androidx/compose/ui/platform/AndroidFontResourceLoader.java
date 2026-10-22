package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.core.content.res.ResourcesCompat;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "Replaced with PlatformFontLoader during the introduction of async fonts, all usages should be replaced", replaceWith = @ReplaceWith(expression = "PlatformFontLoader", imports = {}))
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "load", "Landroid/graphics/Typeface;", LynxResourceModule.FONT_TYPE, "Landroidx/compose/ui/text/font/Font;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidFontResourceLoader implements Font.ResourceLoader {
    public static final int $stable = 8;
    private final Context context;

    public AndroidFontResourceLoader(Context r100) {
        this.context = r100;
    }

    @Override // androidx.compose.ui.text.font.Font.ResourceLoader
    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
    public Typeface load(Font r100) {
        if ((r100 instanceof ResourceFont) == false) goto L10;
        if (Build.VERSION.SDK_INT >= 26) goto L11;
        Typeface r101 = ResourcesCompat.getFont(this.context, ((ResourceFont) r100).getResId());
        Intrinsics.checkNotNull(r101);
        return r101;
    L11:
        return AndroidFontResourceLoaderHelper.INSTANCE.create(this.context, ((ResourceFont) r100).getResId());
    L10:
        throw new IllegalArgumentException("Unknown font type: " + r100);
    }

    @Override // androidx.compose.ui.text.font.Font.ResourceLoader
    public /* bridge */ /* synthetic */ Object load(Font r100) {
        return load(r100);
    }
}
