package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.luckybox.RushedListResponse.ResponseData")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/g2;", "", "", "succeed", "Z", "getSucceed", "()Z", "setSucceed", "(Z)V", AiBotPollingAuthResult.STATUS_EXPIRED, "getExpired", "setExpired", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "diamondCount", "I", "getDiamondCount", "()I", "setDiamondCount", "(I)V", "", "Lcom/bytedance/android/livesdk/chatroom/model/g2$a;", "rushedList", "Ljava/util/List;", "getRushedList", "()Ljava/util/List;", "setRushedList", "(Ljava/util/List;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g2 implements vh7.h {

    @SerializedName("diamond_count")
    protected int diamondCount;

    @SerializedName(AiBotPollingAuthResult.STATUS_EXPIRED)
    protected boolean expired;

    @SerializedName("image")
    protected ImageModel image;

    @SerializedName("rushed_list")
    protected List<a> rushedList;

    @SerializedName("succeed")
    protected boolean succeed;

    @SerializedName("text")
    protected String text;

    @ProtoMessage("webcast.api.luckybox.RushedListResponse.RushedData")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/g2$a;", "", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "getUser", "()Lcom/bytedance/android/live/base/model/user/User;", "setUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "nickName", "getNickName", "setNickName", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("image")
        protected ImageModel image;

        @SerializedName("nick_name")
        protected String nickName;

        @SerializedName("text")
        protected String text;

        @SerializedName("user")
        protected User user;

        public a() {
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.text = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.user = new User(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.image = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.nickName = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }
    }

    public g2() {
    }

    public g2(am3.g r100) {
        this.rushedList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.succeed = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.expired = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.diamondCount = (int) r100.j();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.image = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.text = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 7) goto L17;
        this.rushedList.add(new a(r100));
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
    }
}
