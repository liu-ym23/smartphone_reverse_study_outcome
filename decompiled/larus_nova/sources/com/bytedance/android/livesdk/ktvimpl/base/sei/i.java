package com.bytedance.android.livesdk.ktvimpl.base.sei;

import android.text.TextUtils;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR \u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001a\u0010\u001e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/i;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "", "tone", FaceService.girlLabel, ce.f26395j, "()F", "standardTone", RXScreenCaptureService.KEY_INDEX, com.bytedance.android.ec.core.event.a.KEY_SCORE, ce.f26391f, "", "index", "I", "f", "()I", "hitType", "e", "", "senderUserID", "J", "getSenderUserID", "()J", "getSenderUserID$annotations", "()V", "anchorId", "getAnchorId", "getAnchorId$annotations", "comboTimes", "c", "forwardByAnchor", "d", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i extends com.bytedance.android.livesdk.ktvimpl.base.sei.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f143311a;

    @SerializedName("anchor_id")
    private final long anchorId;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f143312b;

    @SerializedName("combo")
    private final int comboTimes;

    @SerializedName("forward")
    private final int forwardByAnchor;

    @SerializedName("hit_type")
    private final int hitType;

    @SerializedName("sentence_index")
    private final int index;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private final float score;

    @SerializedName("sender_user_id")
    private final long senderUserID;

    @SerializedName("standard_tone")
    private final float standardTone;

    @SerializedName("cur_tone")
    private final float tone;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L24;
        i r101 = (i) r100;
        if (Float.compare(this.tone, r101.tone) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.standardTone, r101.standardTone) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.score, r101.score) == 0) goto L12;
        return false;
    L12:
        if (this.index == r101.index) goto L14;
        return false;
    L14:
        if (this.hitType == r101.hitType) goto L16;
        return false;
    L16:
        if (this.senderUserID == r101.senderUserID) goto L18;
        return false;
    L18:
        if (this.anchorId == r101.anchorId) goto L20;
        return false;
    L20:
        if (this.comboTimes == r101.comboTimes) goto L22;
        return false;
    L22:
        if (this.forwardByAnchor == r101.forwardByAnchor) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((((Float.floatToIntBits(this.tone) * 31) + Float.floatToIntBits(this.standardTone)) * 31) + Float.floatToIntBits(this.score)) * 31) + this.index) * 31) + this.hitType) * 31;
        long r101 = this.senderUserID;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.anchorId;
        return ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.comboTimes) * 31) + this.forwardByAnchor;
    }

    public final String toString() {
        return "KtvMultiMidiSeiModel(tone=" + this.tone + ", standardTone=" + this.standardTone + ", score=" + this.score + ", index=" + this.index + ", hitType=" + this.hitType + ", senderUserID=" + this.senderUserID + ", anchorId=" + this.anchorId + ", comboTimes=" + this.comboTimes + ", forwardByAnchor=" + this.forwardByAnchor + ")";
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f143311a) == false) goto L6;
        this.f143311a = t.k(this.anchorId);
    L6:
        return this.f143311a;
    }

    public final String h() {
        if (TextUtils.isEmpty(this.f143312b) == false) goto L6;
        this.f143312b = t.k(this.senderUserID);
    L6:
        return this.f143312b;
    }

    public i() {
        this.tone = 0.0f;
        this.standardTone = 0.0f;
        this.score = 0.0f;
        this.index = 0;
        this.hitType = -1;
        this.senderUserID = 0;
        this.anchorId = 0;
        this.comboTimes = -1;
        this.forwardByAnchor = 0;
        this.f143311a = "";
        this.f143312b = "";
    }

    public final int c() {
        return this.comboTimes;
    }

    public final int d() {
        return this.forwardByAnchor;
    }

    public final int e() {
        return this.hitType;
    }

    public final int f() {
        return this.index;
    }

    public final float g() {
        return this.score;
    }

    public final float i() {
        return this.standardTone;
    }

    public final float j() {
        return this.tone;
    }
}
