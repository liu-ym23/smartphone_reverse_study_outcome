package androidx.compose.ui.platform;

import H4.o;
import android.os.Parcel;
import android.util.Base64;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\bJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0016H\u0002¢\u0006\u0004\b!\u0010\u0018J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\r\u0010'\u001a\u00020%¢\u0006\u0004\b&\u0010\u001bJ\r\u0010*\u001a\u00020(¢\u0006\u0004\b)\u0010\u001bJ\r\u0010,\u001a\u00020+¢\u0006\u0004\b,\u0010-J\r\u00100\u001a\u00020.¢\u0006\u0004\b/\u0010\u0018J\r\u00103\u001a\u000201¢\u0006\u0004\b2\u0010\u0018R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u00067"}, d2 = {"Landroidx/compose/ui/platform/DecodeHelper;", "", "", TypedValues.Custom.S_STRING, AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeBaselineShift", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "Landroidx/compose/ui/graphics/Shadow;", "decodeShadow", "()Landroidx/compose/ui/graphics/Shadow;", "", "decodeByte", "()B", "", "decodeInt", "()I", "LC7/m;", "decodeULong-s-VKNKU", "()J", "decodeULong", "", "decodeFloat", "decodeString", "()Ljava/lang/String;", "dataAvailable", "Landroidx/compose/ui/text/SpanStyle;", "decodeSpanStyle", "()Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "decodeColor", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeTextUnit", "Landroidx/compose/ui/text/font/FontWeight;", "decodeFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "decodeFontStyle", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeFontSynthesis", "Landroid/os/Parcel;", "parcel", "Landroid/os/Parcel;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DecodeHelper {
    public static final int $stable = 8;
    private final Parcel parcel;

    public DecodeHelper(String str) {
        Parcel parcelObtain = Parcel.obtain();
        this.parcel = parcelObtain;
        byte[] bArrDecode = Base64.decode(str, 0);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    /* renamed from: decodeBaselineShift-y9eOQZs, reason: not valid java name */
    private final float m5990decodeBaselineShifty9eOQZs() {
        return BaselineShift.m6601constructorimpl(decodeFloat());
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    private final Shadow decodeShadow() {
        long jM5992decodeColor0d7_KjU = m5992decodeColor0d7_KjU();
        float fDecodeFloat = decodeFloat();
        float fDecodeFloat2 = decodeFloat();
        return new Shadow(jM5992decodeColor0d7_KjU, Offset.m3887constructorimpl((Float.floatToRawIntBits(fDecodeFloat2) & 4294967295L) | (Float.floatToRawIntBits(fDecodeFloat) << 32)), decodeFloat(), null);
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final TextDecoration decodeTextDecoration() {
        int iDecodeInt = decodeInt();
        TextDecoration.Companion companion = TextDecoration.INSTANCE;
        boolean z10 = (companion.getLineThrough().getMask() & iDecodeInt) != 0;
        boolean z11 = (iDecodeInt & companion.getUnderline().getMask()) != 0;
        return (z10 && z11) ? companion.combine(o.N(companion.getLineThrough(), companion.getUnderline())) : z10 ? companion.getLineThrough() : z11 ? companion.getUnderline() : companion.getNone();
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    /* renamed from: decodeULong-s-VKNKU, reason: not valid java name */
    private final long m5991decodeULongsVKNKU() {
        return this.parcel.readLong();
    }

    /* renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public final long m5992decodeColor0d7_KjU() {
        return AndroidColor_androidKt.fromColorLong(Color.INSTANCE, this.parcel.readLong());
    }

    /* renamed from: decodeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m5993decodeFontStyle_LCdwA() {
        byte bDecodeByte = decodeByte();
        if (bDecodeByte != 0 && bDecodeByte == 1) {
            return FontStyle.INSTANCE.m6428getItalic_LCdwA();
        }
        return FontStyle.INSTANCE.m6429getNormal_LCdwA();
    }

    /* renamed from: decodeFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m5994decodeFontSynthesisGVVA2EU() {
        byte bDecodeByte = decodeByte();
        return bDecodeByte == 0 ? FontSynthesis.INSTANCE.m6440getNoneGVVA2EU() : bDecodeByte == 1 ? FontSynthesis.INSTANCE.m6439getAllGVVA2EU() : bDecodeByte == 3 ? FontSynthesis.INSTANCE.m6441getStyleGVVA2EU() : bDecodeByte == 2 ? FontSynthesis.INSTANCE.m6442getWeightGVVA2EU() : FontSynthesis.INSTANCE.m6440getNoneGVVA2EU();
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte bDecodeByte = decodeByte();
            if (bDecodeByte != 1) {
                if (bDecodeByte != 2) {
                    if (bDecodeByte != 3) {
                        if (bDecodeByte != 4) {
                            if (bDecodeByte != 5) {
                                if (bDecodeByte != 6) {
                                    if (bDecodeByte != 7) {
                                        if (bDecodeByte != 8) {
                                            if (bDecodeByte != 9) {
                                                if (bDecodeByte != 10) {
                                                    if (bDecodeByte != 11) {
                                                        if (bDecodeByte == 12) {
                                                            if (dataAvailable() < 20) {
                                                                break;
                                                            }
                                                            mutableSpanStyle.setShadow(decodeShadow());
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        if (dataAvailable() < 4) {
                                                            break;
                                                        }
                                                        mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                                                    }
                                                } else {
                                                    if (dataAvailable() < 8) {
                                                        break;
                                                    }
                                                    mutableSpanStyle.m6034setBackground8_81llA(m5992decodeColor0d7_KjU());
                                                }
                                            } else {
                                                if (dataAvailable() < 8) {
                                                    break;
                                                }
                                                mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                                            }
                                        } else {
                                            if (dataAvailable() < 4) {
                                                break;
                                            }
                                            mutableSpanStyle.m6035setBaselineShift_isdbwI(BaselineShift.m6600boximpl(m5990decodeBaselineShifty9eOQZs()));
                                        }
                                    } else {
                                        if (dataAvailable() < 5) {
                                            break;
                                        }
                                        mutableSpanStyle.m6040setLetterSpacingR2X_6o(m5995decodeTextUnitXSAIIZE());
                                    }
                                } else {
                                    mutableSpanStyle.setFontFeatureSettings(decodeString());
                                }
                            } else {
                                if (dataAvailable() < 1) {
                                    break;
                                }
                                mutableSpanStyle.m6039setFontSynthesistDdu0R4(FontSynthesis.m6430boximpl(m5994decodeFontSynthesisGVVA2EU()));
                            }
                        } else {
                            if (dataAvailable() < 1) {
                                break;
                            }
                            mutableSpanStyle.m6038setFontStylemLjRB2g(FontStyle.m6419boximpl(m5993decodeFontStyle_LCdwA()));
                        }
                    } else {
                        if (dataAvailable() < 4) {
                            break;
                        }
                        mutableSpanStyle.setFontWeight(decodeFontWeight());
                    }
                } else {
                    if (dataAvailable() < 5) {
                        break;
                    }
                    mutableSpanStyle.m6037setFontSizeR2X_6o(m5995decodeTextUnitXSAIIZE());
                }
            } else {
                if (dataAvailable() < 8) {
                    break;
                }
                mutableSpanStyle.m6036setColor8_81llA(m5992decodeColor0d7_KjU());
            }
        }
        return mutableSpanStyle.toSpanStyle();
    }

    /* renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m5995decodeTextUnitXSAIIZE() {
        byte bDecodeByte = decodeByte();
        long jM7071getSpUIouoOA = bDecodeByte == 1 ? TextUnitType.INSTANCE.m7071getSpUIouoOA() : bDecodeByte == 2 ? TextUnitType.INSTANCE.m7070getEmUIouoOA() : TextUnitType.INSTANCE.m7072getUnspecifiedUIouoOA();
        return TextUnitType.m7066equalsimpl0(jM7071getSpUIouoOA, TextUnitType.INSTANCE.m7072getUnspecifiedUIouoOA()) ? TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE() : TextUnitKt.m7050TextUnitanM5pPY(decodeFloat(), jM7071getSpUIouoOA);
    }
}
