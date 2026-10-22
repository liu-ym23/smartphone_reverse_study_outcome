package com.bytedance.android.livesdk.interactivity.api.comment.data;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R$\u0010'\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\b¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/data/g;", "", "", RemoteMessageConst.MSGID, "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "setMsgId", "(Ljava/lang/Long;)V", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "f", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "itemId", "b", "setItemId", "", "title", "Ljava/lang/String;", "e", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "itemType", "c", "setItemType", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "itemIdStr", "getItemIdStr", "setItemIdStr", "itemTypeStr", "getItemTypeStr", "setItemTypeStr", "authorId", "getAuthorId", "setAuthorId", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g implements vh7.h {

    @SerializedName("author_id")
    protected Long authorId;

    @SerializedName("display_text")
    protected a5 displayText;

    @SerializedName("item_id")
    protected Long itemId;

    @SerializedName("item_id_str")
    protected String itemIdStr;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    protected Long itemType;

    @SerializedName("item_type_str")
    protected String itemTypeStr;

    @SerializedName("msg_id")
    protected Long msgId;

    @SerializedName("title")
    protected String title;

    @SerializedName("user")
    protected IBaseUser user;

    public g() {
        this.msgId = 0L;
        this.itemId = 0L;
        this.title = "";
        this.itemType = 0L;
        this.itemIdStr = "";
        this.itemTypeStr = "";
        this.authorId = 0L;
    }

    public final a5 a() {
        return this.displayText;
    }

    public final Long b() {
        return this.itemId;
    }

    public final Long c() {
        return this.itemType;
    }

    public final Long d() {
        return this.msgId;
    }

    public final String e() {
        return this.title;
    }

    public final IBaseUser f() {
        return this.user;
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public g(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.authorId = Long.valueOf(r100.j());
        goto L3
    L8:
        this.itemTypeStr = am3.h.c(r100);
        goto L3
    L9:
        this.itemIdStr = am3.h.c(r100);
        goto L3
    L10:
        this.displayText = vh7.f.a(r100, a5.class);
        goto L3
    L11:
        this.itemType = Long.valueOf(r100.j());
        goto L3
    L12:
        this.title = am3.h.c(r100);
        goto L3
    L13:
        this.itemId = Long.valueOf(r100.j());
        goto L3
    L14:
        this.user = vh7.f.a(r100, IBaseUser.class);
        goto L3
    L15:
        this.msgId = Long.valueOf(r100.j());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        if (this.msgId != null) goto L20;
        this.msgId = 0L;
    L20:
        if (this.itemId != null) goto L23;
        this.itemId = 0L;
    L23:
        if (this.title != null) goto L26;
        this.title = "";
    L26:
        if (this.itemType != null) goto L29;
        this.itemType = 0L;
    L29:
        if (this.itemIdStr != null) goto L32;
        this.itemIdStr = "";
    L32:
        if (this.itemTypeStr != null) goto L35;
        this.itemTypeStr = "";
    L35:
        if (this.authorId != null) goto L60;
        this.authorId = 0L;
        return;
    }
}
