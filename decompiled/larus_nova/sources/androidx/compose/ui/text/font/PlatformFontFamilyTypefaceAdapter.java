package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.AndroidTypeface;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "<init>", "()V", "platformTypefaceResolver", "Landroidx/compose/ui/text/font/PlatformTypefaces;", JSEventListener.ACTION_RESOLVE, "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "createDefaultTypeface", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    public static final int $stable = 8;
    private final PlatformTypefaces platformTypefaceResolver;

    public PlatformFontFamilyTypefaceAdapter() {
        this.platformTypefaceResolver = PlatformTypefaces_androidKt.PlatformTypefaces();
    }

    @Override // androidx.compose.ui.text.font.FontFamilyTypefaceAdapter
    public TypefaceResult resolve(TypefaceRequest r100, PlatformFontLoader r101, Function1<? super TypefaceResult.Immutable, Unit> r102, Function1<? super TypefaceRequest, ? extends Object> r103) {
        FontFamily r104 = r100.getFontFamily();
        if (r104 != null) goto L5;
    L14:
        android.graphics.Typeface r105 = this.platformTypefaceResolver.mo7139createDefaultFO1MlWM(r100.getFontWeight(), r100.m7157getFontStyle_LCdwA());
    L16:
        return new TypefaceResult.Immutable(r105, false, 2, null);
    L5:
        if ((r104 instanceof DefaultFontFamily) == true) goto L14;
        if ((r104 instanceof GenericFontFamily) == false) goto L11;
        r105 = this.platformTypefaceResolver.mo7140createNamedRetOiIg((GenericFontFamily) r100.getFontFamily(), r100.getFontWeight(), r100.m7157getFontStyle_LCdwA());
        goto L16
    L11:
        if ((r104 instanceof LoadedFontFamily) == false) goto L13;
        Typeface r106 = ((LoadedFontFamily) r100.getFontFamily()).getTypeface();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
        r105 = ((AndroidTypeface) r106).mo7252getNativeTypefacePYhJU0U(r100.getFontWeight(), r100.m7157getFontStyle_LCdwA(), r100.m7158getFontSynthesisGVVA2EU());
        goto L16
    L13:
        return null;
    }
}
