package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.AndroidColor_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0010J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u000b\u0010\u0016J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001aJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b\u000b\u0010$J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b\u000b\u0010'J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b\u000b\u0010*J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b\u000b\u0010-J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b\u000b\u0010\u001aJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u00101\u001a\u000200¢\u0006\u0004\b\u000b\u0010!J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u0010\u0010J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "reset", "", "encodedString", "()Ljava/lang/String;", "Landroidx/compose/ui/text/SpanStyle;", "spanStyle", "encode", "(Landroidx/compose/ui/text/SpanStyle;)V", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "encode-8_81llA", "(J)V", "Landroidx/compose/ui/unit/TextUnit;", "textUnit", "encode--R2X_6o", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "(Landroidx/compose/ui/text/font/FontWeight;)V", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "encode-nzbMABs", "(I)V", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontSynthesis", "encode-6p3vJLY", "Landroidx/compose/ui/text/style/BaselineShift;", "baselineShift", "encode-4Dl_Bck", "(F)V", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textGeometricTransform", "(Landroidx/compose/ui/text/style/TextGeometricTransform;)V", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "(Landroidx/compose/ui/text/style/TextDecoration;)V", "Landroidx/compose/ui/graphics/Shadow;", "shadow", "(Landroidx/compose/ui/graphics/Shadow;)V", "", "byte", "(B)V", "", "int", "", TypedValues.Custom.S_FLOAT, "LC7/m;", "uLong", "encode-VKZWuLQ", TypedValues.Custom.S_STRING, "(Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "Landroid/os/Parcel;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel = Parcel.obtain();

    public final void encode(SpanStyle spanStyle) {
        long jM6252getColor0d7_KjU = spanStyle.m6252getColor0d7_KjU();
        Color.Companion companion = Color.INSTANCE;
        if (!Color.m4140equalsimpl0(jM6252getColor0d7_KjU, companion.m4175getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m6012encode8_81llA(spanStyle.m6252getColor0d7_KjU());
        }
        long fontSize = spanStyle.getFontSize();
        TextUnit.Companion companion2 = TextUnit.INSTANCE;
        if (!TextUnit.m7035equalsimpl0(fontSize, companion2.m7049getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m6009encodeR2X_6o(spanStyle.getFontSize());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        if (fontStyle != null) {
            int iM6425unboximpl = fontStyle.m6425unboximpl();
            encode((byte) 4);
            m6014encodenzbMABs(iM6425unboximpl);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        if (fontSynthesis != null) {
            int value = fontSynthesis.getValue();
            encode((byte) 5);
            m6011encode6p3vJLY(value);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m7035equalsimpl0(spanStyle.getLetterSpacing(), companion2.m7049getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m6009encodeR2X_6o(spanStyle.getLetterSpacing());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        if (baselineShift != null) {
            float fM6606unboximpl = baselineShift.m6606unboximpl();
            encode((byte) 8);
            m6010encode4Dl_Bck(fM6606unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m4140equalsimpl0(spanStyle.getBackground(), companion.m4175getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m6012encode8_81llA(spanStyle.getBackground());
        }
        TextDecoration background = spanStyle.getBackground();
        if (background != null) {
            encode((byte) 11);
            encode(background);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m6009encodeR2X_6o(long textUnit) {
        long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(textUnit);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        byte b = 0;
        if (!TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7072getUnspecifiedUIouoOA())) {
            if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(textUnit), companion.m7072getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m7038getValueimpl(textUnit));
    }

    /* renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m6010encode4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    /* renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m6011encode6p3vJLY(int fontSynthesis) {
        FontSynthesis.Companion companion = FontSynthesis.INSTANCE;
        byte b = 0;
        if (!FontSynthesis.m6433equalsimpl0(fontSynthesis, companion.m6440getNoneGVVA2EU())) {
            if (FontSynthesis.m6433equalsimpl0(fontSynthesis, companion.m6439getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m6433equalsimpl0(fontSynthesis, companion.m6442getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m6433equalsimpl0(fontSynthesis, companion.m6441getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-8_81llA, reason: not valid java name */
    public final void m6012encode8_81llA(long color) {
        m6013encodeVKZWuLQ(AndroidColor_androidKt.m4003toColorLong8_81llA(color));
    }

    /* renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m6013encodeVKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    /* renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m6014encodenzbMABs(int fontStyle) {
        FontStyle.Companion companion = FontStyle.INSTANCE;
        byte b = 0;
        if (!FontStyle.m6422equalsimpl0(fontStyle, companion.m6429getNormal_LCdwA()) && FontStyle.m6422equalsimpl0(fontStyle, companion.m6428getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m6012encode8_81llA(shadow.getColor());
        encode(Float.intBitsToFloat((int) (shadow.getOffset() >> 32)));
        encode(Float.intBitsToFloat((int) (shadow.getOffset() & 4294967295L)));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    public final void encode(String string) {
        this.parcel.writeString(string);
    }
}
