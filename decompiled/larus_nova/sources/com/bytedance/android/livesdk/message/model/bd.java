package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ItemShareMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0003B\u0007¢\u0006\u0004\b5\u00106J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013H\u0016J\u001e\u0010\u0017\u001a\u00020\u00162\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\fH\u0016J-\u0010&\u001a\u00028\u0000\"\u000e\b\u0000\u0010#*\b\u0012\u0004\u0012\u00020\u00030\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0016¢\u0006\u0004\b&\u0010'J/\u0010(\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010#*\b\u0012\u0004\u0012\u00020\u00030\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0016¢\u0006\u0004\b(\u0010'J\n\u0010*\u001a\u0004\u0018\u00010)H\u0016R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030+8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u00100R\u0018\u0010\u0019\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u00102R(\u0010\u0015\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u00103R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u00104¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/bd;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lvh7/c$a;", "Lcom/bytedance/android/live/base/model/message/m1;", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "getOrInitPublicAreaCommon", "Lcom/bytedance/android/live/base/model/user/User;", "getChatUserInfo", "", "getChatContent", "Lcom/bytedance/android/live/base/model/message/a5;", "getRichText", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "getCommonArea", "", "getPinBaseMessageId", "", "canPin", "getPinCommenterId", "", "getTrackingParams", "trackingParams", "", "setTrackingParams", "getShareText", "shareText", "setShareText", "Lcom/bytedance/android/live/base/model/data/m;", "itemStyle", "setItemStyle", "getItemStyle", "publicAreaCommon", "setPublicAreaCommon", "getPublicAreaCommon", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUserInMessage", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "Lcom/bytedance/android/live/base/model/data/m;", "Lcom/bytedance/android/livesdkapi/message/Text;", "Lcom/bytedance/android/livesdkapi/message/Text;", "Ljava/util/Map;", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class bd extends o0 implements vh7.c.a<com.bytedance.android.live.base.model.message.m1>, com.bytedance.android.live.base.model.message.m1, vh7.h {
    private final transient FlexModelDelegate<com.bytedance.android.live.base.model.message.m1> delegate;

    @SerializedName("item_style")
    public com.bytedance.android.live.base.model.data.m itemStyle;

    @SerializedName("public_area_common")
    public PublicAreaCommon publicAreaCommon;

    @SerializedName("share_text")
    public Text shareText;

    @SerializedName("tracking_params")
    public Map<String, String> trackingParams;

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.q3
    public /* bridge */ /* synthetic */ Map getBuriedPoint() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public PublicAreaCommon getCommonArea() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.q3
    public long getPinCommenterId() {
        return 0;
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.q3
    public /* bridge */ /* synthetic */ long getPinMessageShowArea() {
        return 2;
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.h0, com.bytedance.android.live.base.model.message.x3
    public com.bytedance.android.live.base.model.message.a5 getRichText() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.q3
    public boolean canPin() {
        PublicAreaCommon r100 = this.publicAreaCommon;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.canPin();
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.h0
    public String getChatContent() {
        com.bytedance.android.live.base.model.data.m r100 = this.itemStyle;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.name;
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.h0
    public User getChatUserInfo() {
        Intrinsics.checkNotNullParameter(this, "$this$userInfo");
        Text r100 = this.shareText;
        IBaseUser r101 = null;
        if (r100 == null) goto L22;
        List<com.bytedance.android.live.base.model.message.c5> r102 = r100.getPieces();
        if (r102 == null) goto L22;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if (((com.bytedance.android.live.base.model.message.c5) r104).getType() != PieceType.USER.getPieceType()) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L8;
    L16:
        com.bytedance.android.live.base.model.message.c5 r106 = (com.bytedance.android.live.base.model.message.c5) r104;
        if (r106 == null) goto L22;
        com.bytedance.android.live.base.model.message.i5 r107 = r106.getUserValue();
        if (r107 == null) goto L22;
        r101 = r107.getUser();
        goto L22
    L12:
        r105 = false;
        goto L13
    L15:
        r104 = null;
    L22:
        return (User) r101;
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.u3
    public IPublicAreaCommon getOrInitPublicAreaCommon() {
        if (this.publicAreaCommon != null) goto L6;
        this.publicAreaCommon = new PublicAreaCommon();
    L6:
        return this.publicAreaCommon;
    }

    public bd() {
        this.delegate = new FlexModelDelegate(com.bytedance.android.live.base.model.message.m1.class, this);
        this.type = MessageType.ITEM_SHARE_MESSAGE;
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public /* bridge */ /* synthetic */ IPublicAreaCommon getCommonArea() {
        return getCommonArea();
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.h0, com.bytedance.android.live.base.model.message.q3
    public long getPinBaseMessageId() {
        return getMessageId();
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.q3
    public IBaseUser getPinUser() {
        return getChatUserInfo();
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public /* bridge */ /* synthetic */ IPublicAreaCommon getPublicAreaCommon() {
        return getPublicAreaCommon();
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.u3
    public IBaseUser getUserInMessage() {
        return getChatUserInfo();
    }

    @Override // vh7.c.a
    public FlexModelDelegate<com.bytedance.android.live.base.model.message.m1> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public com.bytedance.android.live.base.model.data.m getItemStyle() {
        return this.itemStyle;
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public com.bytedance.android.live.base.model.message.a5 getShareText() {
        return this.shareText;
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public Map<String, String> getTrackingParams() {
        return this.trackingParams;
    }

    @Override // com.bytedance.android.live.base.model.message.m1, com.bytedance.android.live.base.model.message.h0
    public /* bridge */ /* synthetic */ IBaseUser getChatUserInfo() {
        return getChatUserInfo();
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public PublicAreaCommon getPublicAreaCommon() {
        return this.publicAreaCommon;
    }

    public bd(am3.g r110) {
        this.trackingParams = new HashMap();
        this.delegate = new FlexModelDelegate(com.bytedance.android.live.base.model.message.m1.class, this);
        getDelegate().setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L36;
        am3.g.a r102 = getDelegate().decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.itemStyle = com.bytedance.android.live.base.model.data.q.a(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.shareText = _Text_ProtoDecoder.decodeStatic(r110);
        goto L3
    L12:
        if (r101 != 4) goto L14;
        this.publicAreaCommon = new PublicAreaCommon(r110);
        goto L3
    L14:
        if (r101 != 30) goto L15;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L17:
        int r106 = r110.f();
        if (r106 == (-1)) goto L24;
        if (r106 != 1) goto L20;
        r104 = am3.h.c(r110);
        goto L17
    L20:
        if (r106 != 2) goto L21;
        r105 = am3.h.c(r110);
        goto L17
    L21:
        am3.h.e(r110);
        goto L17
    L24:
        r110.d(r103);
        Map<String, String> r107 = this.trackingParams;
        if (r104 == null) goto L31;
        if (r105 == null) goto L29;
        r107.put(r104, r105);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L15:
        am3.h.d(r102, r110);
        goto L3
    L36:
        r110.d(r100);
        getDelegate().setThreadSafe(true);
        this.type = MessageType.ITEM_SHARE_MESSAGE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.m1>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<com.bytedance.android.live.base.model.message.m1>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castToOrNull(r100);
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public void setItemStyle(com.bytedance.android.live.base.model.data.m r100) {
        this.itemStyle = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public void setPublicAreaCommon(IPublicAreaCommon r100) {
        this.publicAreaCommon = (PublicAreaCommon) com.bytedance.android.live.base.model.m.b(r100, PublicAreaCommon.class);
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public void setShareText(com.bytedance.android.live.base.model.message.a5 r100) {
        this.shareText = (Text) com.bytedance.android.live.base.model.m.b(r100, Text.class);
    }

    @Override // com.bytedance.android.live.base.model.message.m1
    public void setTrackingParams(Map<String, String> r100) {
        this.trackingParams = r100;
    }
}
