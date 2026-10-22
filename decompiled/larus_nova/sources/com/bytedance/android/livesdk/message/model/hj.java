package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RecommendUsersMessage")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b2\u00103R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u001b\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001f¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/hj;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "aliveScene", "Ljava/lang/String;", "getAliveScene", "()Ljava/lang/String;", "setAliveScene", "(Ljava/lang/String;)V", "aliveIds", "getAliveIds", "setAliveIds", "listTitle", FaceService.neutralLabel, "setListTitle", "Lcom/bytedance/android/live/base/model/ImageModel;", "imageModel", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImageModel", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImageModel", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "horizontalImage", "G", "setHorizontalImage", "", "displayTime", "J", ExifInterface.LONGITUDE_EAST, "()J", "setDisplayTime", "(J)V", "", "isCheckAlive", "Z", "Q", "()Z", "setCheckAlive", "(Z)V", "", "Lcom/bytedance/android/livesdk/message/model/dj;", "users", "Ljava/util/List;", "getUsers", "()Ljava/util/List;", "setUsers", "(Ljava/util/List;)V", "maxPushDelayTime", "P", "setMaxPushDelayTime", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hj extends o0 implements vh7.h {

    @SerializedName("alive_ids")
    protected String aliveIds;

    @SerializedName("alive_scene")
    protected String aliveScene;

    @SerializedName("display_time")
    protected long displayTime;

    @SerializedName("img_horizontal")
    protected ImageModel horizontalImage;

    @SerializedName("img_vertical")
    protected ImageModel imageModel;

    @SerializedName("check_alive")
    protected boolean isCheckAlive;

    @SerializedName("list_title")
    protected String listTitle;

    @SerializedName("max_push_delay_time")
    protected long maxPushDelayTime;

    @SerializedName("users")
    protected List<dj> users;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "RecommendUserMessage{listTitle='" + this.listTitle + "', imageModel=" + this.imageModel + ", horizontalImage=" + this.horizontalImage + ", displayTime=" + this.displayTime + ", isCheckAlive=" + this.isCheckAlive + ", users=" + this.users + ", maxPushDelayTime=" + this.maxPushDelayTime + ", isLocalInsertMsg=" + this.isLocalInsertMsg2 + ", type=" + this.type + ", timestamp=" + this.timestamp + ", localTimestamp=" + this.localTimestamp + ", baseMessage=" + getBaseMessage() + '}';
    }

    public hj() {
        this.type = MessageType.RECOMMEND_USER_MESSAGE;
    }

    public final long E() {
        return this.displayTime;
    }

    public final ImageModel G() {
        return this.horizontalImage;
    }

    public final String H() {
        return this.listTitle;
    }

    public final long P() {
        return this.maxPushDelayTime;
    }

    public final boolean Q() {
        return this.isCheckAlive;
    }

    public final ImageModel getImageModel() {
        return this.imageModel;
    }

    public final List<dj> getUsers() {
        return this.users;
    }

    public hj(am3.g r100) {
        this.users = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 5000) goto L8;
        this.aliveScene = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 5001) goto L9;
        this.aliveIds = am3.h.c(r100);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        this.isCheckAlive = am3.h.a(r100);
        goto L3
    L12:
        this.maxPushDelayTime = r100.j();
        goto L3
    L13:
        this.displayTime = r100.j();
        goto L3
    L14:
        this.horizontalImage = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L15:
        this.imageModel = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L16:
        this.users.add(new dj(r100));
        goto L3
    L17:
        this.listTitle = am3.h.c(r100);
        goto L3
    L18:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        this.type = MessageType.RECOMMEND_USER_MESSAGE;
    }
}
