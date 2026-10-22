package androidx.compose.ui.text;

import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bo\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bBe\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001cBe\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001dJ\u007f\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0004\b9\u0010:J\u0013\u0010;\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010=\u001a\u00020\u000bH\u0016J\b\u0010>\u001a\u00020?H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010)\u001a\u0004\b(\u0010%R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0018\u001a\u00020\u0019¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0010\u00103\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006@"}, d2 = {"Landroidx/compose/ui/text/TextLayoutInput;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getPlaceholders", "()Ljava/util/List;", "getMaxLines", "()I", "getSoftWrap", "()Z", "getOverflow-gIe3tQ8", "I", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getConstraints-msEJaDk", "()J", "J", "_developerSuppliedResourceLoader", "getResourceLoader$annotations", "()V", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "copy", "copy-hu-1Yfo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;J)Landroidx/compose/ui/text/TextLayoutInput;", "equals", "other", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextLayoutInput {
    public static final int $stable = 8;
    private Font.ResourceLoader _developerSuppliedResourceLoader;
    private final long constraints;
    private final Density density;
    private final FontFamily.Resolver fontFamilyResolver;
    private final LayoutDirection layoutDirection;
    private final int maxLines;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    @Deprecated(message = "Font.ResourceLoader is replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "TextLayoutInput(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, fontFamilyResolver, constraints", imports = {}))
    public /* synthetic */ TextLayoutInput(AnnotatedString r100, TextStyle r101, List r102, int r103, boolean r104, int r105, Density r106, LayoutDirection r107, Font.ResourceLoader r108, long r110, DefaultConstructorMarker r111) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110);
    }

    public /* synthetic */ TextLayoutInput(AnnotatedString r100, TextStyle r101, List r102, int r103, boolean r104, int r105, Density r106, LayoutDirection r107, FontFamily.Resolver r108, long r110, DefaultConstructorMarker r111) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110);
    }

    @Deprecated(message = "Replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getResourceLoader$annotations() {
    }

    public final Font.ResourceLoader getResourceLoader() {
        Font.ResourceLoader r100 = this._developerSuppliedResourceLoader;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return DeprecatedBridgeFontResourceLoader.Companion.from(this.fontFamilyResolver);
    }

    public int hashCode() {
        int r100 = ((((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.placeholders.hashCode()) * 31) + this.maxLines) * 31;
        if (this.softWrap == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((((((r100 + r101) * 31) + TextOverflow.m7461hashCodeimpl(this.overflow)) * 31) + this.density.hashCode()) * 31) + this.layoutDirection.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31) + Constraints.m7490hashCodeimpl(this.constraints);
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "TextLayoutInput(text=" + this.text + ", style=" + this.style + ", placeholders=" + this.placeholders + ", maxLines=" + this.maxLines + ", softWrap=" + this.softWrap + ", overflow=" + TextOverflow.m7462toStringimpl(this.overflow) + ", density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.m7492toStringimpl(this.constraints) + ')';
    }

    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public final long m6964getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: renamed from: getOverflow-gIe3tQ8, reason: not valid java name */
    public final int m6965getOverflowgIe3tQ8() {
        return this.overflow;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextLayoutInput) == true) goto L8;
        return false;
    L8:
        TextLayoutInput r101 = (TextLayoutInput) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.placeholders, r101.placeholders) == true) goto L18;
        return false;
    L18:
        if (this.maxLines == r101.maxLines) goto L21;
        return false;
    L21:
        if (this.softWrap == r101.softWrap) goto L24;
        return false;
    L24:
        if (TextOverflow.m7460equalsimpl0(this.overflow, r101.overflow) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.density, r101.density) == true) goto L30;
        return false;
    L30:
        if (this.layoutDirection == r101.layoutDirection) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fontFamilyResolver, r101.fontFamilyResolver) == true) goto L36;
        return false;
    L36:
        if (Constraints.m7480equalsimpl0(this.constraints, r101.constraints) == true) goto L38;
        return false;
    L38:
        return true;
    }

    private TextLayoutInput(AnnotatedString r110, TextStyle r111, List<AnnotatedString.Range<Placeholder>> r112, int r113, boolean r114, int r115, Density r210, LayoutDirection r211, Font.ResourceLoader r212, long r213) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(r212), r213);
    }

    @Deprecated(message = "Font.ResourceLoader is deprecated", replaceWith = @ReplaceWith(expression = "TextLayoutInput(text, style, placeholders, maxLines, softWrap, overFlow, density, layoutDirection, fontFamilyResolver, constraints)", imports = {}))
    /* JADX INFO: renamed from: copy-hu-1Yfo, reason: not valid java name */
    public final TextLayoutInput m6963copyhu1Yfo(AnnotatedString r110, TextStyle r111, List<AnnotatedString.Range<Placeholder>> r112, int r113, boolean r210, int r211, Density r212, LayoutDirection r213, Font.ResourceLoader r214, long r215) {
        return new TextLayoutInput(r110, r111, r112, r113, r210, r211, r212, r213, r214, this.fontFamilyResolver, r215);
    }

    private TextLayoutInput(AnnotatedString r110, TextStyle r111, List<AnnotatedString.Range<Placeholder>> r112, int r113, boolean r114, int r115, Density r210, LayoutDirection r211, FontFamily.Resolver r212, long r213) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, null, r212, r213);
    }

    private TextLayoutInput(AnnotatedString r100, TextStyle r101, List<AnnotatedString.Range<Placeholder>> r102, int r103, boolean r104, int r105, Density r106, LayoutDirection r107, Font.ResourceLoader r108, FontFamily.Resolver r110, long r111) {
        this.text = r100;
        this.style = r101;
        this.placeholders = r102;
        this.maxLines = r103;
        this.softWrap = r104;
        this.overflow = r105;
        this.density = r106;
        this.layoutDirection = r107;
        this.fontFamilyResolver = r110;
        this.constraints = r111;
        this._developerSuppliedResourceLoader = r108;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-hu-1Yfo$default, reason: not valid java name */
    public static /* synthetic */ TextLayoutInput m6962copyhu1Yfo$default(TextLayoutInput r110, AnnotatedString r111, TextStyle r112, List r113, int r114, boolean r115, int r116, Density r210, LayoutDirection r211, Font.ResourceLoader r212, long r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        AnnotatedString r100 = r110.text;
    L7:
        if ((r214 & 2) == 0) goto L9;
        TextStyle r101 = r110.style;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List r102 = r110.placeholders;
    L15:
        if ((r214 & 8) == 0) goto L17;
        int r103 = r110.maxLines;
    L19:
        if ((r214 & 16) == 0) goto L21;
        boolean r104 = r110.softWrap;
    L23:
        if ((r214 & 32) == 0) goto L25;
        int r105 = r110.overflow;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Density r106 = r110.density;
    L31:
        if ((r214 & 128) == 0) goto L33;
        LayoutDirection r107 = r110.layoutDirection;
    L35:
        if ((r214 & 256) == 0) goto L37;
        Font.ResourceLoader r117 = r110.getResourceLoader();
    L39:
        if ((r214 & 512) == 0) goto L41;
        long r118 = r110.constraints;
    L43:
        return r110.m6963copyhu1Yfo(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118);
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
