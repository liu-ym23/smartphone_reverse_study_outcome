package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.PullStreamChangeMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ri;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "subScene", "getSubScene", "", "random", "J", ExifInterface.LONGITUDE_EAST, "()J", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ri extends o0 implements vh7.h {

    @SerializedName("random_milliseconds")
    protected long random;

    @SerializedName("scene")
    protected String scene;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
    protected String subScene;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ri) == false) goto L12;
        ri r101 = (ri) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subScene, r101.subScene) == true) goto L10;
        return false;
    L10:
        if (this.random == r101.random) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.scene;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.subScene;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.random;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PullStreamChangeMessage(scene=" + this.scene + ", subScene=" + this.subScene + ", random=" + this.random + ")";
    }

    public ri() {
        this.scene = null;
        this.subScene = null;
        this.random = 0;
        this.type = MessageType.PULL_STREAM_CHANGE;
    }

    public final long E() {
        return this.random;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSubScene() {
        return this.subScene;
    }

    public ri(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.scene = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.subScene = am3.h.c(r100);
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.random = r100.i();
        r102 = r102 | true;
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.scene != null) goto L21;
        this.scene = null;
    L21:
        if (this.subScene != null) goto L24;
        this.subScene = null;
    L24:
        if ((r102 & true) == true) goto L26;
        this.random = 0;
    L26:
        this.type = MessageType.PULL_STREAM_CHANGE;
    }
}
