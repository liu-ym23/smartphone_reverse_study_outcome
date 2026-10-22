package com.stepos.core.ability.speech;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrCloudSegmenter {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "AsrCloudSegmenter";
    private int committedCodePoints;
    private final int maxChars;
    private final int punctWindow;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Cut {
        private final int committedCodePointsAfter;
        private final String text;

        public Cut(String text, int i10) {
            kotlin.jvm.internal.g.f(text, "text");
            this.text = text;
            this.committedCodePointsAfter = i10;
        }

        public static /* synthetic */ Cut copy$default(Cut cut, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cut.text;
            }
            if ((i11 & 2) != 0) {
                i10 = cut.committedCodePointsAfter;
            }
            return cut.copy(str, i10);
        }

        public final String component1() {
            return this.text;
        }

        public final int component2() {
            return this.committedCodePointsAfter;
        }

        public final Cut copy(String text, int i10) {
            kotlin.jvm.internal.g.f(text, "text");
            return new Cut(text, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Cut)) {
                return false;
            }
            Cut cut = (Cut) obj;
            return kotlin.jvm.internal.g.b(this.text, cut.text) && this.committedCodePointsAfter == cut.committedCodePointsAfter;
        }

        public final int getCommittedCodePointsAfter() {
            return this.committedCodePointsAfter;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return Integer.hashCode(this.committedCodePointsAfter) + (this.text.hashCode() * 31);
        }

        public String toString() {
            return ai.onnxruntime.a.i("Cut(text=", this.committedCodePointsAfter, this.text, ", committedCodePointsAfter=", ")");
        }
    }

    public AsrCloudSegmenter(int i10, int i11) {
        this.maxChars = i10;
        int iMax = 0;
        if (i10 > 0) {
            int i12 = i10 / 2;
            if (i11 > i12) {
                LogModule logModule = LogModule.ABILITY;
                StringBuilder sbD = h0.e.d(i11, "punctWindow=", i12, " >= maxChars/2 (", ") for maxChars=");
                sbD.append(i10);
                sbD.append("; clamped to ");
                sbD.append(i12);
                sbD.append(" (window 应为 max_chars 的小邻域，避免段长方差失控)");
                AIEngineLogger.w(logModule, TAG, sbD.toString());
                iMax = i12;
            } else {
                iMax = Math.max(0, i11);
            }
        }
        this.punctWindow = iMax;
    }

    private final Integer computeCut(String str, int i10) {
        int iAbs;
        int iMax = Math.max(1, this.maxChars - this.punctWindow);
        int i11 = this.maxChars + this.punctWindow;
        int iMin = Math.min(i10, i11);
        int length = str.length();
        int i12 = Integer.MAX_VALUE;
        int iCharCount = 0;
        int i13 = -1;
        int i14 = 0;
        while (iCharCount < length && i14 < iMin) {
            int iCodePointAt = str.codePointAt(iCharCount);
            i14++;
            if (iMax <= i14 && i14 <= iMin && isBoundaryChar(iCodePointAt) && (iAbs = Math.abs(i14 - this.maxChars)) < i12) {
                i13 = i14;
                i12 = iAbs;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        if (i13 != -1) {
            return Integer.valueOf(i13);
        }
        if (i10 >= i11) {
            return Integer.valueOf(i11);
        }
        return null;
    }

    private final String dropCodePoints(String str, int i10) {
        if (i10 <= 0) {
            return str;
        }
        if (i10 >= str.codePointCount(0, str.length())) {
            return "";
        }
        String strSubstring = str.substring(str.offsetByCodePoints(0, i10));
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final boolean isBoundaryChar(int i10) {
        if (Character.isWhitespace(i10)) {
            return true;
        }
        if (i10 > 65535) {
            return false;
        }
        switch ((char) i10) {
            case '!':
            case ErrorCodes.NOT_SET_VERSION_CODE_ERROR /* 44 */:
            case ';':
            case '?':
            case 12289:
            case 12290:
            case 65281:
            case 65292:
            case 65307:
            case 65311:
                return true;
            default:
                return false;
        }
    }

    private final String takeCodePoints(String str, int i10) {
        String strSubstring = str.substring(0, str.offsetByCodePoints(0, i10));
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final int committedCodePoints() {
        return this.committedCodePoints;
    }

    public final boolean getEnabled() {
        return this.maxChars > 0;
    }

    public final List<Cut> onCumulative(String cumulativeConfirmed) {
        Integer numComputeCut;
        kotlin.jvm.internal.g.f(cumulativeConfirmed, "cumulativeConfirmed");
        if (!getEnabled()) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strDropCodePoints = dropCodePoints(cumulativeConfirmed, this.committedCodePoints);
            int iCodePointCount = strDropCodePoints.codePointCount(0, strDropCodePoints.length());
            if (iCodePointCount < this.maxChars || (numComputeCut = computeCut(strDropCodePoints, iCodePointCount)) == null) {
                break;
            }
            int iIntValue = numComputeCut.intValue();
            this.committedCodePoints += iIntValue;
            arrayList.add(new Cut(takeCodePoints(strDropCodePoints, iIntValue), this.committedCodePoints));
        }
        return arrayList;
    }

    public final String onFinal(String fullText) {
        kotlin.jvm.internal.g.f(fullText, "fullText");
        String strStripCommitted = stripCommitted(fullText);
        reset();
        return strStripCommitted;
    }

    public final void reset() {
        this.committedCodePoints = 0;
    }

    public final String stripCommitted(String cumulative) {
        kotlin.jvm.internal.g.f(cumulative, "cumulative");
        return !getEnabled() ? cumulative : dropCodePoints(cumulative, this.committedCodePoints);
    }
}
