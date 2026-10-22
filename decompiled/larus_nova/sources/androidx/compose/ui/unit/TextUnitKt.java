package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000f\u001a\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0016\u001a\u00020\u0006*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010)\u001a\u00020\u0006*\u00020\b2\u0006\u0010*\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010\f\u001a\u001c\u0010)\u001a\u00020\u0006*\u00020#2\u0006\u0010*\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010)\u001a\u00020\u0006*\u00020&2\u0006\u0010*\u001a\u00020\u0006H\u0087\n¢\u0006\u0004\b+\u0010-\u001a\u001d\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\bH\u0001¢\u0006\u0002\u00101\u001a\u0017\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0006H\u0001¢\u0006\u0004\b5\u0010\u0010\u001a\u001f\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0001¢\u0006\u0004\b7\u00108\u001a'\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H\u0001¢\u0006\u0004\b:\u0010;\u001a'\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\bH\u0007¢\u0006\u0004\b@\u0010A\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001f\u0010\r\u001a\u00020\u000e*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u001e\u0010 \u001a\u00020\u0006*\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010$\u001a\u0004\b\u001e\u0010%\"\u001e\u0010 \u001a\u00020\u0006*\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010$\u001a\u0004\b\"\u0010%\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020&8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010'\u001a\u0004\b\u001e\u0010(\"\u001e\u0010 \u001a\u00020\u0006*\u00020&8FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010'\u001a\u0004\b\"\u0010(¨\u0006B"}, d2 = {"UNIT_MASK", "", "UNIT_TYPE_UNSPECIFIED", "UNIT_TYPE_SP", "UNIT_TYPE_EM", "TextUnit", "Landroidx/compose/ui/unit/TextUnit;", "value", "", "type", "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", CloudControlInf.SP, "getSp$annotations", "(F)V", "getSp", "(F)J", "em", "getEm$annotations", "getEm", "", "(D)V", "(D)J", "", "(I)V", "(I)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "pack", "unitType", BaseSwitches.V, "(JF)J", "checkArithmetic", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    public static /* synthetic */ void getEm$annotations(double r100) {
    }

    public static /* synthetic */ void getEm$annotations(float r100) {
    }

    public static /* synthetic */ void getEm$annotations(int r100) {
    }

    public static /* synthetic */ void getSp$annotations(double r100) {
    }

    public static /* synthetic */ void getSp$annotations(float r100) {
    }

    public static /* synthetic */ void getSp$annotations(int r100) {
    }

    /* JADX INFO: renamed from: isSpecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m7759isSpecifiedR2X_6o$annotations(long r100) {
    }

    /* JADX INFO: renamed from: isUnspecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m7761isUnspecifiedR2X_6o$annotations(long r100) {
    }

    /* JADX INFO: renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m7755checkArithmeticR2X_6o(long r100) {
        if (TextUnit.m7740getRawTypeimpl(r100) != 0) goto L5;
        boolean r101 = true;
    L7:
        if ((!r101) == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L7
    }

    public static final long getEm(double r100) {
        return pack(UNIT_TYPE_EM, (float) r100);
    }

    public static final long getSp(double r100) {
        return pack(UNIT_TYPE_SP, (float) r100);
    }

    /* JADX INFO: renamed from: isSpecified--R2X_6o, reason: not valid java name */
    public static final boolean m7758isSpecifiedR2X_6o(long r100) {
        if (TextUnit.m7740getRawTypeimpl(r100) != 0) goto L5;
        boolean r101 = true;
    L7:
        return !r101;
    L5:
        r101 = false;
        goto L7
    }

    /* JADX INFO: renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m7760isUnspecifiedR2X_6o(long r100) {
        if (TextUnit.m7740getRawTypeimpl(r100) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final long getEm(int r100) {
        return pack(UNIT_TYPE_EM, r100);
    }

    public static final long getSp(int r100) {
        return pack(UNIT_TYPE_SP, r100);
    }

    public static final long getEm(float r100) {
        return pack(UNIT_TYPE_EM, r100);
    }

    public static final long getSp(float r100) {
        return pack(UNIT_TYPE_SP, r100);
    }

    /* JADX INFO: renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m7754TextUnitanM5pPY(float r100, long r101) {
        return pack(r101, r100);
    }

    /* JADX INFO: renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    public static final void m7756checkArithmeticNB67dxo(long r100, long r101) {
        boolean r102 = true;
        if (TextUnit.m7740getRawTypeimpl(r100) != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L13:
        r102 = false;
    L14:
        if (r102 == true) goto L17;
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
    L17:
        if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r100), TextUnit.m7741getTypeUIouoOA(r101)) == true) goto L20;
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + TextUnitType.m7772toStringimpl(TextUnit.m7741getTypeUIouoOA(r100)) + " and " + TextUnitType.m7772toStringimpl(TextUnit.m7741getTypeUIouoOA(r101)));
        return;
    L20:
        return;
    L8:
        if (TextUnit.m7740getRawTypeimpl(r101) != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L13;
    L10:
        r104 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    public static final long pack(long r100, float r101) {
        return TextUnit.m7734constructorimpl(r100 | (((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: takeOrElse-eAf_CNQ, reason: not valid java name */
    public static final long m7763takeOrElseeAf_CNQ(long r100, Function0<TextUnit> r101) {
        if (TextUnit.m7740getRawTypeimpl(r100) != 0) goto L5;
        boolean r102 = true;
    L7:
        if ((!r102) == false) goto L10;
        return r100;
    L10:
        return r101.invoke().m7751unboximpl();
    L5:
        r102 = false;
        goto L7
    }

    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m7764timesmpE4wyQ(double r100, long r101) {
        m7755checkArithmeticR2X_6o(r101);
        return pack(TextUnit.m7740getRawTypeimpl(r101), ((float) r100) * TextUnit.m7742getValueimpl(r101));
    }

    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m7766timesmpE4wyQ(int r100, long r101) {
        m7755checkArithmeticR2X_6o(r101);
        return pack(TextUnit.m7740getRawTypeimpl(r101), r100 * TextUnit.m7742getValueimpl(r101));
    }

    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m7765timesmpE4wyQ(float r100, long r101) {
        m7755checkArithmeticR2X_6o(r101);
        return pack(TextUnit.m7740getRawTypeimpl(r101), r100 * TextUnit.m7742getValueimpl(r101));
    }

    /* JADX INFO: renamed from: checkArithmetic-vU-0ePk, reason: not valid java name */
    public static final void m7757checkArithmeticvU0ePk(long r100, long r101, long r110) {
        boolean r102 = true;
        if (TextUnit.m7740getRawTypeimpl(r100) != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == true) goto L22;
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
    L22:
        if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r100), TextUnit.m7741getTypeUIouoOA(r101)) == true) goto L24;
    L26:
        r102 = false;
    L27:
        if (r102 == true) goto L30;
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + TextUnitType.m7772toStringimpl(TextUnit.m7741getTypeUIouoOA(r100)) + " and " + TextUnitType.m7772toStringimpl(TextUnit.m7741getTypeUIouoOA(r101)));
        return;
    L30:
        return;
    L24:
        if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r101), TextUnit.m7741getTypeUIouoOA(r110)) == false) goto L26;
    L8:
        if (TextUnit.m7740getRawTypeimpl(r101) != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L18;
        if (TextUnit.m7740getRawTypeimpl(r110) != 0) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L18;
        r104 = true;
        goto L19
    L15:
        r106 = false;
        goto L16
    L10:
        r105 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m7762lerpC3pnCVY(long r100, long r101, float r102) {
        m7756checkArithmeticNB67dxo(r100, r101);
        return pack(TextUnit.m7740getRawTypeimpl(r100), MathHelpersKt.lerp(TextUnit.m7742getValueimpl(r100), TextUnit.m7742getValueimpl(r101), r102));
    }
}
