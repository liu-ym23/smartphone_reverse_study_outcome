package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0016J\u0016\u0010\u0010\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle;", "", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "alpha", "", "getAlpha", "()F", "merge", "other", "takeOrElse", "Lkotlin/Function0;", "Unspecified", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TextForegroundStyle {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: androidx.compose.ui.text.style.TextForegroundStyle$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Companion r100 = TextForegroundStyle.Companion;
        }

        public static TextForegroundStyle merge$lambda$1(TextForegroundStyle r100) {
            return r100;
        }

        public static float merge$lambda$0(TextForegroundStyle r100) {
            return ((BrushStyle) r100).getAlpha();
        }

        public static TextForegroundStyle $default$merge(final TextForegroundStyle r100, TextForegroundStyle r101) {
            boolean r102 = r101 instanceof BrushStyle;
            if (r102 == true) goto L5;
        L7:
            if (r102 == true) goto L9;
        L11:
            if (r102 == true) goto L16;
            if ((r100 instanceof BrushStyle) == false) goto L16;
            return r100;
        L16:
            return r101.takeOrElse(new b(r100));
        L9:
            if ((r100 instanceof BrushStyle) == true) goto L11;
            return r101;
        L5:
            if ((r100 instanceof BrushStyle) == false) goto L7;
            BrushStyle r103 = (BrushStyle) r101;
            return new BrushStyle(r103.getValue(), TextDrawStyleKt.access$takeOrElse(r103.getAlpha(), new a(r100)));
        }

        public static TextForegroundStyle $default$takeOrElse(TextForegroundStyle r100, Function0 r101) {
            if (Intrinsics.areEqual(r100, Unspecified.INSTANCE) == true) goto L6;
            return r100;
        L6:
            return (TextForegroundStyle) r101.invoke();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle$Companion;", "", "<init>", "()V", "from", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "from-8_81llA", "(J)Landroidx/compose/ui/text/style/TextForegroundStyle;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: from-8_81llA, reason: not valid java name */
        public final TextForegroundStyle m7439from8_81llA(long r100) {
            if (r100 == 16) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L9;
            return new ColorStyle(r100, null);
        L9:
            return Unspecified.INSTANCE;
        L5:
            r101 = false;
            goto L6
        }

        public final TextForegroundStyle from(Brush r100, float r101) {
            if (r100 != null) goto L5;
            return Unspecified.INSTANCE;
        L5:
            if ((r100 instanceof SolidColor) == false) goto L8;
            return m7439from8_81llA(TextDrawStyleKt.m7438modulateDxMtmZc(((SolidColor) r100).m5188getValue0d7_KjU(), r101));
        L8:
            if ((r100 instanceof ShaderBrush) == false) goto L12;
            return new BrushStyle((ShaderBrush) r100, r101);
        L12:
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle$Unspecified;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "<init>", "()V", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "alpha", "", "getAlpha", "()F", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Unspecified implements TextForegroundStyle {
        public static final int $stable = 0;
        public static final Unspecified INSTANCE = null;

        static {
            INSTANCE = new Unspecified();
        }

        private Unspecified() {
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public float getAlpha() {
            return Float.NaN;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public final /* synthetic */ TextForegroundStyle merge(TextForegroundStyle r100) {
            return CC.$default$merge(this, r100);
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public final /* synthetic */ TextForegroundStyle takeOrElse(Function0 r100) {
            return CC.$default$takeOrElse(this, r100);
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        /* JADX INFO: renamed from: getColor-0d7_KjU */
        public long mo7304getColor0d7_KjU() {
            return Color.Companion.m4863getUnspecified0d7_KjU();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    float getAlpha();

    Brush getBrush();

    /* JADX INFO: renamed from: getColor-0d7_KjU */
    long mo7304getColor0d7_KjU();

    TextForegroundStyle merge(TextForegroundStyle r100);

    TextForegroundStyle takeOrElse(Function0<? extends TextForegroundStyle> r100);
}
