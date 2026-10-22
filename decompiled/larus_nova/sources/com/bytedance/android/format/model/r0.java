package com.bytedance.android.format.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast_avatar_device_render.MotionFrame")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\b¨\u00069"}, d2 = {"Lcom/bytedance/android/format/model/r0;", "", "", "sequenceId", "Ljava/lang/String;", "getSequenceId", "()Ljava/lang/String;", "setSequenceId", "(Ljava/lang/String;)V", "", "idx", "J", "getIdx", "()J", "setIdx", "(J)V", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "", "", "faceAnim", "Ljava/util/List;", "getFaceAnim", "()Ljava/util/List;", "setFaceAnim", "(Ljava/util/List;)V", "Lcom/bytedance/android/format/model/w0;", "bodyAnim", "getBodyAnim", "setBodyAnim", "Lcom/bytedance/android/format/model/b1;", "rootPosition", "Lcom/bytedance/android/format/model/b1;", "getRootPosition", "()Lcom/bytedance/android/format/model/b1;", "setRootPosition", "(Lcom/bytedance/android/format/model/b1;)V", "timestamp", "getTimestamp", "setTimestamp", "", "needPlayedAck", "Z", "getNeedPlayedAck", "()Z", "setNeedPlayedAck", "(Z)V", "animationId", "getAnimationId", "setAnimationId", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r0 implements vh7.h {

    @SerializedName("animation_id")
    protected String animationId;

    @SerializedName("body_anim")
    protected List<w0> bodyAnim;

    @SerializedName("face_anim")
    protected List<Float> faceAnim;

    @SerializedName("idx")
    protected long idx;

    @SerializedName("need_played_ack")
    protected boolean needPlayedAck;

    @SerializedName("root_position")
    protected b1 rootPosition;

    @SerializedName("sequence_id")
    protected String sequenceId;

    @SerializedName("status")
    protected int status;

    @SerializedName("timestamp")
    protected long timestamp;

    public r0() {
        this.faceAnim = CollectionsKt.emptyList();
        this.bodyAnim = CollectionsKt.emptyList();
    }

    public r0(am3.g r100) {
        this.faceAnim = new ArrayList();
        this.bodyAnim = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L6;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.animationId = am3.h.c(r100);
        goto L3
    L8:
        this.needPlayedAck = am3.h.a(r100);
        goto L3
    L9:
        this.timestamp = r100.j();
        goto L3
    L10:
        this.rootPosition = new b1(r100);
        goto L3
    L11:
        List r103 = this.bodyAnim;
        Object r104 = new w0(r100);
    L13:
        r103.add(r104);
        goto L3
    L12:
        r103 = this.faceAnim;
        r104 = Float.valueOf(Float.intBitsToFloat(r100.g()));
        goto L13
    L14:
        this.status = r100.i();
        goto L3
    L15:
        this.idx = r100.j();
        goto L3
    L16:
        this.sequenceId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.faceAnim.isEmpty() == false) goto L21;
        this.faceAnim = CollectionsKt.emptyList();
    L21:
        if (this.bodyAnim.isEmpty() == false) goto L45;
        this.bodyAnim = CollectionsKt.emptyList();
        return;
    }
}
