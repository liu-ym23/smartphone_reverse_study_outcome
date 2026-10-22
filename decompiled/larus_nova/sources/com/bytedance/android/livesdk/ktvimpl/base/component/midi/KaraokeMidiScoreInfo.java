package com.bytedance.android.livesdk.ktvimpl.base.component.midi;

import com.bef.effectsdk.RequirementDefine;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u008b\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0004HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0010HÖ\u0001J\b\u00104\u001a\u000205H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/component/midi/KaraokeMidiScoreInfo;", "", "()V", RequirementDefine.REQUIREMENT_AUDIO_SENTENCE_SCORE_TAG, "", "songScore", "userPitch", "userNote", "userCent", "userOctave", "userFrequency", "refPitch", "refNote", "refCent", "refFrequency", "sentenceIndex", "", "timeMilliseconds", "(FFFFFFFFFFFIF)V", "getRefCent", "()F", "getRefFrequency", "getRefNote", "getRefPitch", "getSentenceIndex", "()I", "getSentenceScore", "getSongScore", "getTimeMilliseconds", "getUserCent", "getUserFrequency", "getUserNote", "getUserOctave", "getUserPitch", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KaraokeMidiScoreInfo {

    @SerializedName("refCent")
    private final float refCent;

    @SerializedName("refFrequency")
    private final float refFrequency;

    @SerializedName("refNote")
    private final float refNote;

    @SerializedName("refPitch")
    private final float refPitch;

    @SerializedName("sentenceIndex")
    private final int sentenceIndex;

    @SerializedName(RequirementDefine.REQUIREMENT_AUDIO_SENTENCE_SCORE_TAG)
    private final float sentenceScore;

    @SerializedName("songScore")
    private final float songScore;

    @SerializedName("timeMilliseconds")
    private final float timeMilliseconds;

    @SerializedName("userCent")
    private final float userCent;

    @SerializedName("userFrequency")
    private final float userFrequency;

    @SerializedName("userNote")
    private final float userNote;

    @SerializedName("userOctave")
    private final float userOctave;

    @SerializedName("userPitch")
    private final float userPitch;

    public KaraokeMidiScoreInfo() {
        this(0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, -1, 0.0f);
    }

    public static /* synthetic */ KaraokeMidiScoreInfo copy$default(KaraokeMidiScoreInfo r110, float r111, float r112, float r113, float r114, float r115, float r210, float r211, float r212, float r213, float r214, float r215, int r216, float r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        float r100 = r110.sentenceScore;
    L7:
        if ((r218 & 2) == 0) goto L9;
        float r101 = r110.songScore;
    L11:
        if ((r218 & 4) == 0) goto L13;
        float r102 = r110.userPitch;
    L15:
        if ((r218 & 8) == 0) goto L17;
        float r103 = r110.userNote;
    L19:
        if ((r218 & 16) == 0) goto L21;
        float r104 = r110.userCent;
    L23:
        if ((r218 & 32) == 0) goto L25;
        float r105 = r110.userOctave;
    L27:
        if ((r218 & 64) == 0) goto L29;
        float r106 = r110.userFrequency;
    L31:
        if ((r218 & 128) == 0) goto L33;
        float r107 = r110.refPitch;
    L35:
        if ((r218 & 256) == 0) goto L37;
        float r116 = r110.refNote;
    L39:
        if ((r218 & 512) == 0) goto L41;
        float r117 = r110.refCent;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        float r118 = r110.refFrequency;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        int r119 = r110.sentenceIndex;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        float r108 = r110.timeMilliseconds;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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

    public final float component1() {
        return this.sentenceScore;
    }

    public final float component10() {
        return this.refCent;
    }

    public final float component11() {
        return this.refFrequency;
    }

    public final int component12() {
        return this.sentenceIndex;
    }

    public final float component13() {
        return this.timeMilliseconds;
    }

    public final float component2() {
        return this.songScore;
    }

    public final float component3() {
        return this.userPitch;
    }

    public final float component4() {
        return this.userNote;
    }

    public final float component5() {
        return this.userCent;
    }

    public final float component6() {
        return this.userOctave;
    }

    public final float component7() {
        return this.userFrequency;
    }

    public final float component8() {
        return this.refPitch;
    }

    public final float component9() {
        return this.refNote;
    }

    public final KaraokeMidiScoreInfo copy(float r110, float r111, float r112, float r113, float r210, float r211, float r212, float r213, float r214, float r215, float r216, int r217, float r218) {
        return new KaraokeMidiScoreInfo(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof KaraokeMidiScoreInfo) == false) goto L32;
        KaraokeMidiScoreInfo r101 = (KaraokeMidiScoreInfo) r100;
        if (Float.compare(this.sentenceScore, r101.sentenceScore) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.songScore, r101.songScore) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.userPitch, r101.userPitch) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.userNote, r101.userNote) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.userCent, r101.userCent) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.userOctave, r101.userOctave) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.userFrequency, r101.userFrequency) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.refPitch, r101.refPitch) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.refNote, r101.refNote) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.refCent, r101.refCent) == 0) goto L26;
        return false;
    L26:
        if (Float.compare(this.refFrequency, r101.refFrequency) == 0) goto L28;
        return false;
    L28:
        if (this.sentenceIndex == r101.sentenceIndex) goto L30;
        return false;
    L30:
        if (Float.compare(this.timeMilliseconds, r101.timeMilliseconds) == 0) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Float.floatToIntBits(this.sentenceScore) * 31) + Float.floatToIntBits(this.songScore)) * 31) + Float.floatToIntBits(this.userPitch)) * 31) + Float.floatToIntBits(this.userNote)) * 31) + Float.floatToIntBits(this.userCent)) * 31) + Float.floatToIntBits(this.userOctave)) * 31) + Float.floatToIntBits(this.userFrequency)) * 31) + Float.floatToIntBits(this.refPitch)) * 31) + Float.floatToIntBits(this.refNote)) * 31) + Float.floatToIntBits(this.refCent)) * 31) + Float.floatToIntBits(this.refFrequency)) * 31) + this.sentenceIndex) * 31) + Float.floatToIntBits(this.timeMilliseconds);
    }

    public String toString() {
        return "KaraokeMidiScoreInfo(sentenceScore=" + this.sentenceScore + ", songScore=" + this.songScore + ", userPitch=" + this.userPitch + ", userNote=" + this.userNote + ", userCent=" + this.userCent + ", userOctave=" + this.userOctave + ", userFrequency=" + this.userFrequency + ", refPitch=" + this.refPitch + ", refNote=" + this.refNote + ", refCent=" + this.refCent + ", refFrequency=" + this.refFrequency + ", sentenceIndex=" + this.sentenceIndex + ", timeMilliseconds=" + this.timeMilliseconds + ')';
    }

    public final float getRefCent() {
        return this.refCent;
    }

    public final float getRefFrequency() {
        return this.refFrequency;
    }

    public final float getRefNote() {
        return this.refNote;
    }

    public final float getRefPitch() {
        return this.refPitch;
    }

    public final int getSentenceIndex() {
        return this.sentenceIndex;
    }

    public final float getSentenceScore() {
        return this.sentenceScore;
    }

    public final float getSongScore() {
        return this.songScore;
    }

    public final float getTimeMilliseconds() {
        return this.timeMilliseconds;
    }

    public final float getUserCent() {
        return this.userCent;
    }

    public final float getUserFrequency() {
        return this.userFrequency;
    }

    public final float getUserNote() {
        return this.userNote;
    }

    public final float getUserOctave() {
        return this.userOctave;
    }

    public final float getUserPitch() {
        return this.userPitch;
    }

    public KaraokeMidiScoreInfo(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108, float r110, float r111, int r112, float r113) {
        this.sentenceScore = r100;
        this.songScore = r101;
        this.userPitch = r102;
        this.userNote = r103;
        this.userCent = r104;
        this.userOctave = r105;
        this.userFrequency = r106;
        this.refPitch = r107;
        this.refNote = r108;
        this.refCent = r110;
        this.refFrequency = r111;
        this.sentenceIndex = r112;
        this.timeMilliseconds = r113;
    }
}
