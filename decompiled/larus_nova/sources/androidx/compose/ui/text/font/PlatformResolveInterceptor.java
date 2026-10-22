package androidx.compose.ui.text.font;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0017\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "", "interceptFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "interceptFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "interceptFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "interceptFontStyle-T2F_aPo", "(I)I", "interceptFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontSynthesis", "interceptFontSynthesis-Mscr08Y", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PlatformResolveInterceptor {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.PlatformResolveInterceptor$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static FontFamily $default$interceptFontFamily(PlatformResolveInterceptor r100, FontFamily r101) {
            return r101;
        }

        /* JADX INFO: renamed from: $default$interceptFontStyle-T2F_aPo, reason: not valid java name */
        public static int m7137$default$interceptFontStyleT2F_aPo(PlatformResolveInterceptor r100, int r101) {
            return r101;
        }

        /* JADX INFO: renamed from: $default$interceptFontSynthesis-Mscr08Y, reason: not valid java name */
        public static int m7138$default$interceptFontSynthesisMscr08Y(PlatformResolveInterceptor r100, int r101) {
            return r101;
        }

        public static FontWeight $default$interceptFontWeight(PlatformResolveInterceptor r100, FontWeight r101) {
            return r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/font/PlatformResolveInterceptor$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "getDefault$ui_text", "()Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final PlatformResolveInterceptor Default = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            Default = new PlatformResolveInterceptor$Companion$Default$1();
        }

        public final PlatformResolveInterceptor getDefault$ui_text() {
            return Default;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    FontFamily interceptFontFamily(FontFamily r100);

    /* JADX INFO: renamed from: interceptFontStyle-T2F_aPo */
    int mo7061interceptFontStyleT2F_aPo(int r100);

    /* JADX INFO: renamed from: interceptFontSynthesis-Mscr08Y */
    int mo7062interceptFontSynthesisMscr08Y(int r100);

    FontWeight interceptFontWeight(FontWeight r100);
}
