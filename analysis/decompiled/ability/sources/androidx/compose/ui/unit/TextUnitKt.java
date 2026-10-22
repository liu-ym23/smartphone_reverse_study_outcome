package androidx.compose.ui.unit;

import S7.a;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0014\u001a\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\f\u001a\u00020\u0004*\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0086\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004H\u0087\n¢\u0006\u0004\b\u000e\u0010\u0006\u001a\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\r\u001a\u00020\u0004H\u0087\n¢\u0006\u0004\b\u000e\u0010\u0011\u001a\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\u00122\u0006\u0010\r\u001a\u00020\u0004H\u0087\n¢\u0006\u0004\b\u000e\u0010\u0013\u001a\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u001f\u0010 \u001a'\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\"\u0010#\u001a'\u0010)\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0000H\u0007¢\u0006\u0004\b'\u0010(\"\u0014\u0010*\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010,\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+\"\u0014\u0010-\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010+\"\u0014\u0010.\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010+\"\u001f\u00103\u001a\u00020/*\u00020\u00048Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\u001c\u001a\u0004\b0\u00101\"\u001f\u00106\u001a\u00020/*\u00020\u00048Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u001c\u001a\u0004\b4\u00101\"\u001e\u0010;\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010:\u001a\u0004\b7\u00108\"\u001e\u0010>\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010:\u001a\u0004\b<\u00108\"\u001e\u0010;\u001a\u00020\u0004*\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010@\u001a\u0004\b7\u0010?\"\u001e\u0010>\u001a\u00020\u0004*\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010@\u001a\u0004\b<\u0010?\"\u001e\u0010;\u001a\u00020\u0004*\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b9\u0010B\u001a\u0004\b7\u0010A\"\u001e\u0010>\u001a\u00020\u0004*\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010B\u001a\u0004\b<\u0010A¨\u0006C"}, d2 = {"", "value", "Landroidx/compose/ui/unit/TextUnitType;", "type", "Landroidx/compose/ui/unit/TextUnit;", "TextUnit-anM5pPY", "(FJ)J", "TextUnit", "Lkotlin/Function0;", "block", "takeOrElse-eAf_CNQ", "(JLS7/a;)J", "takeOrElse", "other", "times-mpE4wyQ", "times", "", "(DJ)J", "", "(IJ)J", "", "unitType", "v", "pack", "(JF)J", "a", "LC7/r;", "checkArithmetic--R2X_6o", "(J)V", "checkArithmetic", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "lerp", "UNIT_MASK", "J", "UNIT_TYPE_UNSPECIFIED", "UNIT_TYPE_SP", "UNIT_TYPE_EM", "", "isSpecified--R2X_6o", "(J)Z", "isSpecified--R2X_6o$annotations", "isSpecified", "isUnspecified--R2X_6o", "isUnspecified--R2X_6o$annotations", "isUnspecified", "getSp", "(F)J", "getSp$annotations", "(F)V", "sp", "getEm", "getEm$annotations", "em", "(D)J", "(D)V", "(I)J", "(I)V", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    /* renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m7050TextUnitanM5pPY(float f, long j5) {
        return pack(j5, f);
    }

    /* renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m7051checkArithmeticR2X_6o(long j5) {
        if (TextUnit.m7036getRawTypeimpl(j5) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
    }

    /* renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    public static final void m7052checkArithmeticNB67dxo(long j5, long j6) {
        if (!((TextUnit.m7036getRawTypeimpl(j5) == 0 || TextUnit.m7036getRawTypeimpl(j6) == 0) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(j5), TextUnit.m7037getTypeUIouoOA(j6))) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + ((Object) TextUnitType.m7068toStringimpl(TextUnit.m7037getTypeUIouoOA(j5))) + " and " + ((Object) TextUnitType.m7068toStringimpl(TextUnit.m7037getTypeUIouoOA(j6))));
    }

    /* renamed from: checkArithmetic-vU-0ePk, reason: not valid java name */
    public static final void m7053checkArithmeticvU0ePk(long j5, long j6, long j10) {
        boolean z10 = false;
        if (!((TextUnit.m7036getRawTypeimpl(j5) == 0 || TextUnit.m7036getRawTypeimpl(j6) == 0 || TextUnit.m7036getRawTypeimpl(j10) == 0) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(j5), TextUnit.m7037getTypeUIouoOA(j6)) && TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(j6), TextUnit.m7037getTypeUIouoOA(j10))) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + ((Object) TextUnitType.m7068toStringimpl(TextUnit.m7037getTypeUIouoOA(j5))) + " and " + ((Object) TextUnitType.m7068toStringimpl(TextUnit.m7037getTypeUIouoOA(j6))));
    }

    public static final long getEm(float f) {
        return pack(UNIT_TYPE_EM, f);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(double d) {
    }

    public static final long getSp(float f) {
        return pack(UNIT_TYPE_SP, f);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(double d) {
    }

    /* renamed from: isSpecified--R2X_6o, reason: not valid java name */
    public static final boolean m7054isSpecifiedR2X_6o(long j5) {
        return !(TextUnit.m7036getRawTypeimpl(j5) == 0);
    }

    @Stable
    /* renamed from: isSpecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m7055isSpecifiedR2X_6o$annotations(long j5) {
    }

    /* renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m7056isUnspecifiedR2X_6o(long j5) {
        return TextUnit.m7036getRawTypeimpl(j5) == 0;
    }

    @Stable
    /* renamed from: isUnspecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m7057isUnspecifiedR2X_6o$annotations(long j5) {
    }

    @Stable
    /* renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m7058lerpC3pnCVY(long j5, long j6, float f) {
        m7052checkArithmeticNB67dxo(j5, j6);
        return pack(TextUnit.m7036getRawTypeimpl(j5), MathHelpersKt.lerp(TextUnit.m7038getValueimpl(j5), TextUnit.m7038getValueimpl(j6), f));
    }

    public static final long pack(long j5, float f) {
        return TextUnit.m7030constructorimpl(j5 | (Float.floatToRawIntBits(f) & 4294967295L));
    }

    /* renamed from: takeOrElse-eAf_CNQ, reason: not valid java name */
    public static final long m7059takeOrElseeAf_CNQ(long j5, a aVar) {
        return !((TextUnit.m7036getRawTypeimpl(j5) > 0L ? 1 : (TextUnit.m7036getRawTypeimpl(j5) == 0L ? 0 : -1)) == 0) ? j5 : ((TextUnit) aVar.invoke()).getPackedValue();
    }

    @Stable
    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m7061timesmpE4wyQ(float f, long j5) {
        m7051checkArithmeticR2X_6o(j5);
        return pack(TextUnit.m7036getRawTypeimpl(j5), TextUnit.m7038getValueimpl(j5) * f);
    }

    public static final long getEm(double d) {
        return pack(UNIT_TYPE_EM, (float) d);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(float f) {
    }

    public static final long getSp(double d) {
        return pack(UNIT_TYPE_SP, (float) d);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(float f) {
    }

    public static final long getEm(int i) {
        return pack(UNIT_TYPE_EM, i);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(int i) {
    }

    public static final long getSp(int i) {
        return pack(UNIT_TYPE_SP, i);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(int i) {
    }

    @Stable
    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m7060timesmpE4wyQ(double d, long j5) {
        m7051checkArithmeticR2X_6o(j5);
        return pack(TextUnit.m7036getRawTypeimpl(j5), TextUnit.m7038getValueimpl(j5) * ((float) d));
    }

    @Stable
    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m7062timesmpE4wyQ(int i, long j5) {
        m7051checkArithmeticR2X_6o(j5);
        return pack(TextUnit.m7036getRawTypeimpl(j5), TextUnit.m7038getValueimpl(j5) * i);
    }
}
