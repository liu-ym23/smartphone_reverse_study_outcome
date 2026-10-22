package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/PersonalSongInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/bb;", "", "other", "", "equals", "", "hashCode", "", "midiScore", "D", "getMidiScore", "()D", "setMidiScore", "(D)V", "isHighScoreSong", "Z", "()Ljava/lang/Boolean;", "setHighScoreSong", "(Z)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PersonalSongInfo extends FlexModelBase<bb> implements bb, vh7.h {

    @SerializedName("is_high_score_song")
    protected boolean isHighScoreSong;

    @SerializedName("user_midi_score")
    protected double midiScore;

    public PersonalSongInfo() {
        super(bb.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.bb
    public Boolean isHighScoreSong() {
        return Boolean.valueOf(this.isHighScoreSong);
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(getMidiScore());
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (isHighScoreSong().booleanValue() == false) goto L5;
        int r102 = 1231;
    L7:
        return r101 + r102;
    L5:
        r102 = 1237;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.message.model.bb
    public double getMidiScore() {
        return this.midiScore;
    }

    public PersonalSongInfo(am3.g r100) {
        super(bb.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.midiScore = Double.longBitsToDouble(r100.h());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.isHighScoreSong = am3.h.a(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(PersonalSongInfo.class, r100.getClass())) == false) goto L11;
        return false;
    L11:
        PersonalSongInfo r101 = (PersonalSongInfo) r100;
        if (getMidiScore() == r101.getMidiScore()) goto L15;
        return false;
    L15:
        if (isHighScoreSong().booleanValue() == r101.isHighScoreSong().booleanValue()) goto L17;
        return false;
    L17:
        return true;
    }

    public void setHighScoreSong(boolean r100) {
        this.isHighScoreSong = r100;
    }

    public void setMidiScore(double r100) {
        this.midiScore = r100;
    }
}
