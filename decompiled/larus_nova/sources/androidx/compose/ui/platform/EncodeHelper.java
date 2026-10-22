package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
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
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.ULong;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.¢\u0006\u0004\b/\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u00100\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "<init>", "()V", "parcel", "Landroid/os/Parcel;", BasicTestActionHandler.TEST_ACTION_RESET, "", "encodedString", "", "encode", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/Shadow;", "byte", "", "int", "", "float", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "string", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel;

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public EncodeHelper() {
        this.parcel = Parcel.obtain();
    }

    public final void encode(SpanStyle r100) {
        long r101 = r100.m6939getColor0d7_KjU();
        Color.Companion r102 = Color.Companion;
        if (Color.m4828equalsimpl0(r101, r102.m4863getUnspecified0d7_KjU()) == true) goto L5;
        encode((byte) 1);
        m6703encode8_81llA(r100.m6939getColor0d7_KjU());
    L5:
        long r103 = r100.m6940getFontSizeXSAIIZE();
        TextUnit.Companion r104 = TextUnit.Companion;
        if (TextUnit.m7739equalsimpl0(r103, r104.m7753getUnspecifiedXSAIIZE()) == true) goto L8;
        encode((byte) 2);
        m6700encodeR2X_6o(r100.m6940getFontSizeXSAIIZE());
    L8:
        FontWeight r105 = r100.getFontWeight();
        if (r105 == null) goto L11;
        encode((byte) 3);
        encode(r105);
    L11:
        FontStyle r106 = r100.m6941getFontStyle4Lr2A7w();
        if (r106 == null) goto L14;
        int r107 = r106.m7115unboximpl();
        encode((byte) 4);
        m6705encodenzbMABs(r107);
    L14:
        FontSynthesis r108 = r100.m6942getFontSynthesisZQGJjVo();
        if (r108 == null) goto L17;
        int r109 = r108.m7128unboximpl();
        encode((byte) 5);
        m6702encode6p3vJLY(r109);
    L17:
        String r110 = r100.getFontFeatureSettings();
        if (r110 == null) goto L21;
        encode((byte) 6);
        encode(r110);
    L21:
        if (TextUnit.m7739equalsimpl0(r100.m6943getLetterSpacingXSAIIZE(), r104.m7753getUnspecifiedXSAIIZE()) == true) goto L23;
        encode((byte) 7);
        m6700encodeR2X_6o(r100.m6943getLetterSpacingXSAIIZE());
    L23:
        BaselineShift r111 = r100.m6938getBaselineShift5SSeXJ0();
        if (r111 == null) goto L26;
        float r112 = r111.m7296unboximpl();
        encode((byte) 8);
        m6701encode4Dl_Bck(r112);
    L26:
        TextGeometricTransform r113 = r100.getTextGeometricTransform();
        if (r113 == null) goto L30;
        encode((byte) 9);
        encode(r113);
    L30:
        if (Color.m4828equalsimpl0(r100.m6937getBackground0d7_KjU(), r102.m4863getUnspecified0d7_KjU()) == true) goto L32;
        encode((byte) 10);
        m6703encode8_81llA(r100.m6937getBackground0d7_KjU());
    L32:
        TextDecoration r114 = r100.getTextDecoration();
        if (r114 == null) goto L35;
        encode((byte) 11);
        encode(r114);
    L35:
        Shadow r115 = r100.getShadow();
        if (r115 == null) goto L39;
        encode((byte) 12);
        encode(r115);
        return;
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m6700encodeR2X_6o(long r100) {
        long r101 = TextUnit.m7741getTypeUIouoOA(r100);
        TextUnitType.Companion r102 = TextUnitType.Companion;
        byte r103 = 0;
        if (TextUnitType.m7770equalsimpl0(r101, r102.m7776getUnspecifiedUIouoOA()) == false) goto L6;
    L11:
        encode(r103);
        if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r100), r102.m7776getUnspecifiedUIouoOA()) == true) goto L15;
        encode(TextUnit.m7742getValueimpl(r100));
        return;
    L15:
        return;
    L6:
        if (TextUnitType.m7770equalsimpl0(r101, r102.m7775getSpUIouoOA()) == false) goto L9;
        r103 = 1;
        goto L11
    L9:
        if (TextUnitType.m7770equalsimpl0(r101, r102.m7774getEmUIouoOA()) == false) goto L11;
        r103 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m6701encode4Dl_Bck(float r100) {
        encode(r100);
    }

    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m6702encode6p3vJLY(int r100) {
        FontSynthesis.Companion r101 = FontSynthesis.Companion;
        byte r102 = 0;
        if (FontSynthesis.m7123equalsimpl0(r100, r101.m7130getNoneGVVA2EU()) == false) goto L6;
    L14:
        encode(r102);
        return;
    L6:
        if (FontSynthesis.m7123equalsimpl0(r100, r101.m7129getAllGVVA2EU()) == false) goto L9;
        r102 = 1;
        goto L14
    L9:
        if (FontSynthesis.m7123equalsimpl0(r100, r101.m7132getWeightGVVA2EU()) == false) goto L12;
        r102 = 2;
        goto L14
    L12:
        if (FontSynthesis.m7123equalsimpl0(r100, r101.m7131getStyleGVVA2EU()) == false) goto L14;
        r102 = 3;
        goto L14
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m6703encode8_81llA(long r100) {
        m6704encodeVKZWuLQ(ULong.m9623constructorimpl(AndroidColor_androidKt.m4691toColorLong8_81llA(r100)));
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m6704encodeVKZWuLQ(long r100) {
        this.parcel.writeLong(r100);
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m6705encodenzbMABs(int r100) {
        FontStyle.Companion r101 = FontStyle.Companion;
        byte r102 = 0;
        if (FontStyle.m7112equalsimpl0(r100, r101.m7119getNormal_LCdwA()) == false) goto L6;
    L8:
        encode(r102);
        return;
    L6:
        if (FontStyle.m7112equalsimpl0(r100, r101.m7118getItalic_LCdwA()) == false) goto L8;
        r102 = 1;
        goto L8
    }

    public final void encode(Shadow r100) {
        m6703encode8_81llA(r100.m5176getColor0d7_KjU());
        encode(Float.intBitsToFloat((int) (r100.m5177getOffsetF1C5BW0() >> 32)));
        encode(Float.intBitsToFloat((int) (r100.m5177getOffsetF1C5BW0() & BodyPartID.bodyIdMax)));
        encode(r100.getBlurRadius());
    }

    public final void encode(TextGeometricTransform r100) {
        encode(r100.getScaleX());
        encode(r100.getSkewX());
    }

    public final void encode(FontWeight r100) {
        encode(r100.getWeight());
    }

    public final void encode(TextDecoration r100) {
        encode(r100.getMask());
    }

    public final void encode(byte r100) {
        this.parcel.writeByte(r100);
    }

    public final void encode(float r100) {
        this.parcel.writeFloat(r100);
    }

    public final void encode(int r100) {
        this.parcel.writeInt(r100);
    }

    public final void encode(String r100) {
        this.parcel.writeString(r100);
    }
}
