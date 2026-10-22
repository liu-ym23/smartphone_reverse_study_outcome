package androidx.compose.ui.text;

import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/DeprecatedBridgeFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "<init>", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "load", "", LynxResourceModule.FONT_TYPE, "Landroidx/compose/ui/text/font/Font;", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DeprecatedBridgeFontResourceLoader implements Font.ResourceLoader {
    public static final Companion Companion = null;
    private static Map<FontFamily.Resolver, Font.ResourceLoader> cache;
    private static final SynchronizedObject lock = null;
    private final FontFamily.Resolver fontFamilyResolver;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0006R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/DeprecatedBridgeFontResourceLoader$Companion;", "", "<init>", "()V", "cache", "", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getCache", "()Ljava/util/Map;", "setCache", "(Ljava/util/Map;)V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "from", "fontFamilyResolver", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Map<FontFamily.Resolver, Font.ResourceLoader> getCache() {
            return DeprecatedBridgeFontResourceLoader.access$getCache$cp();
        }

        public final SynchronizedObject getLock() {
            return DeprecatedBridgeFontResourceLoader.access$getLock$cp();
        }

        public final Font.ResourceLoader from(FontFamily.Resolver r100) {
            SynchronizedObject r101 = getLock();
            monitor-enter(r101);
            Companion r102 = DeprecatedBridgeFontResourceLoader.Companion;     // Catch: Throwable -> L11
            Font.ResourceLoader r103 = r102.getCache().get(r100);     // Catch: Throwable -> L11
            if (r103 == null) goto L8;
            monitor-exit(r101);
            return r103;
        L8:
            DeprecatedBridgeFontResourceLoader r104 = new DeprecatedBridgeFontResourceLoader(r100, null);     // Catch: Throwable -> L11
            r102.getCache().put(r100, r104);     // Catch: Throwable -> L11
            monitor-exit(r101);
            return r104;
        L11:
            th = move-exception;
            throw th;
        }

        public final void setCache(Map<FontFamily.Resolver, Font.ResourceLoader> r100) {
            DeprecatedBridgeFontResourceLoader.access$setCache$cp(r100);
        }
    }

    public /* synthetic */ DeprecatedBridgeFontResourceLoader(FontFamily.Resolver r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    static {
        Companion = new Companion(null);
        cache = new LinkedHashMap();
        lock = new SynchronizedObject();
    }

    public static final /* synthetic */ Map access$getCache$cp() {
        return cache;
    }

    public static final /* synthetic */ SynchronizedObject access$getLock$cp() {
        return lock;
    }

    private DeprecatedBridgeFontResourceLoader(FontFamily.Resolver r100) {
        this.fontFamilyResolver = r100;
    }

    public static final /* synthetic */ void access$setCache$cp(Map r100) {
        cache = r100;
    }

    @Override // androidx.compose.ui.text.font.Font.ResourceLoader
    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
    public Object load(Font r100) {
        return FontFamily.Resolver.CC.m7085resolveDPcqOEQ$default(this.fontFamilyResolver, FontKt.toFontFamily(r100), r100.getWeight(), r100.mo7064getStyle_LCdwA(), 0, 8, null).getValue();
    }
}
