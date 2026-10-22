package androidx.compose.ui.text.style;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b`\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0014J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0006\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle;", "", "other", "merge", "(Landroidx/compose/ui/text/style/TextForegroundStyle;)Landroidx/compose/ui/text/style/TextForegroundStyle;", "Lkotlin/Function0;", "takeOrElse", "(LS7/a;)Landroidx/compose/ui/text/style/TextForegroundStyle;", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "brush", "", "getAlpha", "()F", "alpha", "Companion", "Unspecified", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TextForegroundStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle$Companion;", "", AppAgent.CONSTRUCT, "()V", TypedValues.TransitionType.S_FROM, "Landroidx/compose/ui/text/style/TextForegroundStyle;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "from-8_81llA", "(J)Landroidx/compose/ui/text/style/TextForegroundStyle;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final TextForegroundStyle from(Brush brush, float alpha) {
            if (brush == null) {
                return Unspecified.INSTANCE;
            }
            if (brush instanceof SolidColor) {
                return m6749from8_81llA(TextDrawStyleKt.m6748modulateDxMtmZc(((SolidColor) brush).getValue(), alpha));
            }
            if (brush instanceof ShaderBrush) {
                return new BrushStyle((ShaderBrush) brush, alpha);
            }
            throw new NoWhenBranchMatchedException();
        }

        /* renamed from: from-8_81llA, reason: not valid java name */
        public final TextForegroundStyle m6749from8_81llA(long color) {
            return color != 16 ? new ColorStyle(color, null) : Unspecified.INSTANCE;
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle$Unspecified;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", AppAgent.CONSTRUCT, "()V", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "alpha", "", "getAlpha", "()F", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Unspecified implements TextForegroundStyle {
        public static final int $stable = 0;
        public static final Unspecified INSTANCE = new Unspecified();

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
        /* renamed from: getColor-0d7_KjU */
        public long mo6614getColor0d7_KjU() {
            return Color.INSTANCE.m4175getUnspecified0d7_KjU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static float merge$lambda$0(TextForegroundStyle textForegroundStyle) {
        return ((BrushStyle) textForegroundStyle).getAlpha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static TextForegroundStyle merge$lambda$1(TextForegroundStyle textForegroundStyle) {
        return textForegroundStyle;
    }

    float getAlpha();

    Brush getBrush();

    /* renamed from: getColor-0d7_KjU */
    long mo6614getColor0d7_KjU();

    default TextForegroundStyle merge(TextForegroundStyle other) {
        boolean z10 = other instanceof BrushStyle;
        if (z10 && (this instanceof BrushStyle)) {
            BrushStyle brushStyle = (BrushStyle) other;
            final int i = 0;
            return new BrushStyle(brushStyle.getValue(), TextDrawStyleKt.takeOrElse(brushStyle.getAlpha(), new S7.a(this) { // from class: androidx.compose.ui.text.style.a
                public final /* synthetic */ TextForegroundStyle b;

                {
                    this.b = this;
                }

                @Override // S7.a
                public final Object invoke() {
                    int i6 = i;
                    TextForegroundStyle textForegroundStyle = this.b;
                    switch (i6) {
                        case 0:
                            return Float.valueOf(TextForegroundStyle.merge$lambda$0(textForegroundStyle));
                        default:
                            return TextForegroundStyle.merge$lambda$1(textForegroundStyle);
                    }
                }
            }));
        }
        if (z10 && !(this instanceof BrushStyle)) {
            return other;
        }
        if (!z10 && (this instanceof BrushStyle)) {
            return this;
        }
        final int i6 = 1;
        return other.takeOrElse(new S7.a(this) { // from class: androidx.compose.ui.text.style.a
            public final /* synthetic */ TextForegroundStyle b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i6;
                TextForegroundStyle textForegroundStyle = this.b;
                switch (i62) {
                    case 0:
                        return Float.valueOf(TextForegroundStyle.merge$lambda$0(textForegroundStyle));
                    default:
                        return TextForegroundStyle.merge$lambda$1(textForegroundStyle);
                }
            }
        });
    }

    default TextForegroundStyle takeOrElse(S7.a other) {
        return !equals(Unspecified.INSTANCE) ? this : (TextForegroundStyle) other.invoke();
    }
}
