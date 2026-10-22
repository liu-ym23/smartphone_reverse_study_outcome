package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.lynx.textra.PlatformFontCaps;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0002\u001a\u00020\u00038G¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/font/FontFamily;", "", "canLoadSynchronously", "", "<init>", "(Z)V", "getCanLoadSynchronously$annotations", "()V", "getCanLoadSynchronously", "()Z", "Resolver", "Companion", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "Landroidx/compose/ui/text/font/LoadedFontFamily;", "Landroidx/compose/ui/text/font/SystemFontFamily;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class FontFamily {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final GenericFontFamily Cursive = null;
    private static final SystemFontFamily Default = null;
    private static final GenericFontFamily Monospace = null;
    private static final GenericFontFamily SansSerif = null;
    private static final GenericFontFamily Serif = null;
    private final boolean canLoadSynchronously;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/font/FontFamily$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/ui/text/font/SystemFontFamily;", "getDefault", "()Landroidx/compose/ui/text/font/SystemFontFamily;", "SansSerif", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getSansSerif", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "Serif", "getSerif", "Monospace", "getMonospace", "Cursive", "getCursive", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GenericFontFamily getCursive() {
            return FontFamily.access$getCursive$cp();
        }

        public final SystemFontFamily getDefault() {
            return FontFamily.access$getDefault$cp();
        }

        public final GenericFontFamily getMonospace() {
            return FontFamily.access$getMonospace$cp();
        }

        public final GenericFontFamily getSansSerif() {
            return FontFamily.access$getSansSerif$cp();
        }

        public final GenericFontFamily getSerif() {
            return FontFamily.access$getSerif$cp();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J?\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0001\u0001\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/FontFamily$Resolver;", "", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", JSEventListener.ACTION_RESOLVE, "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Resolver {

        /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamily$Resolver$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            /* JADX INFO: renamed from: resolve-DPcqOEQ$default, reason: not valid java name */
            public static /* synthetic */ State m7085resolveDPcqOEQ$default(Resolver r100, FontFamily r101, FontWeight r102, int r103, int r104, int r105, Object r106) {
                if (r106 != null) goto L18;
                if ((r105 & 1) == 0) goto L7;
                r101 = null;
            L7:
                if ((r105 & 2) == 0) goto L10;
                r102 = FontWeight.Companion.getNormal();
            L10:
                if ((r105 & 4) == 0) goto L13;
                r103 = FontStyle.Companion.m7119getNormal_LCdwA();
            L13:
                if ((r105 & 8) == 0) goto L16;
                r104 = FontSynthesis.Companion.m7129getAllGVVA2EU();
            L16:
                return r100.mo7084resolveDPcqOEQ(r101, r102, r103, r104);
            L18:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
            }
        }

        Object preload(FontFamily r100, Continuation<? super Unit> r101);

        /* JADX INFO: renamed from: resolve-DPcqOEQ, reason: not valid java name */
        State<Object> mo7084resolveDPcqOEQ(FontFamily r100, FontWeight r101, int r102, int r103);
    }

    public /* synthetic */ FontFamily(boolean r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public static /* synthetic */ void getCanLoadSynchronously$annotations() {
    }

    static {
        Companion = new Companion(null);
        Default = new DefaultFontFamily();
        SansSerif = new GenericFontFamily(PlatformFontCaps.DEFAULT_FAMILY_NAME, "FontFamily.SansSerif");
        Serif = new GenericFontFamily("serif", "FontFamily.Serif");
        Monospace = new GenericFontFamily("monospace", "FontFamily.Monospace");
        Cursive = new GenericFontFamily("cursive", "FontFamily.Cursive");
    }

    public static final /* synthetic */ GenericFontFamily access$getCursive$cp() {
        return Cursive;
    }

    public static final /* synthetic */ SystemFontFamily access$getDefault$cp() {
        return Default;
    }

    public static final /* synthetic */ GenericFontFamily access$getMonospace$cp() {
        return Monospace;
    }

    public static final /* synthetic */ GenericFontFamily access$getSansSerif$cp() {
        return SansSerif;
    }

    public static final /* synthetic */ GenericFontFamily access$getSerif$cp() {
        return Serif;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Unused property that has no meaning. Do not use.")
    public final boolean getCanLoadSynchronously() {
        return this.canLoadSynchronously;
    }

    private FontFamily(boolean r100) {
        this.canLoadSynchronously = r100;
    }
}
