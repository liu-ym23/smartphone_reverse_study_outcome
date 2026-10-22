package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomTextBg")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010+R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R/\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\u0004\u001a\u0004\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR+\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\nR/\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0011¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/RoomTextBgFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/ok;", "", "<set-?>", "id$delegate", "Ljava/lang/Object;", "getId", "()J", "setId", "(J)V", "id", "", "title$delegate", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "title", "description$delegate", "getDescription", "setDescription", "description", "Lcom/bytedance/android/livesdk/chatroom/model/h3;", "titleStyle$delegate", "getTitleStyle", "()Lcom/bytedance/android/livesdk/chatroom/model/h3;", "setTitleStyle", "(Lcom/bytedance/android/livesdk/chatroom/model/h3;)V", "titleStyle", "descriptionStyle$delegate", "getDescriptionStyle", "setDescriptionStyle", "descriptionStyle", "version$delegate", "getVersion", "setVersion", "version", "showId$delegate", "getShowId", "setShowId", "showId", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomTextBgFlexImpl extends FlexModelBase<ok> implements ok, vh7.h {

    @SerializedName("description")
    protected String _$$description;

    @SerializedName("description_style")
    protected com.bytedance.android.livesdk.chatroom.model.h3 _$$descriptionStyle;

    @SerializedName("id")
    protected long _$$id;

    @SerializedName("show_id")
    protected String _$$showId;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("title_style")
    protected com.bytedance.android.livesdk.chatroom.model.h3 _$$titleStyle;

    @SerializedName("version")
    protected long _$$version;

    public RoomTextBgFlexImpl() {
        super(ok.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final String getDescription() {
        return this._$$description;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final com.bytedance.android.livesdk.chatroom.model.h3 getDescriptionStyle() {
        return this._$$descriptionStyle;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final long getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final String getShowId() {
        return this._$$showId;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final com.bytedance.android.livesdk.chatroom.model.h3 getTitleStyle() {
        return this._$$titleStyle;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final long getVersion() {
        return this._$$version;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdk.chatroom.model.h3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.livesdk.chatroom.model.h3, java.lang.Object] */
    public RoomTextBgFlexImpl(am3.g r100) {
        super(ok.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$showId = am3.h.c(r100);
        goto L3
    L9:
        this._$$version = r100.j();
        goto L3
    L10:
        this._$$descriptionStyle = vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.model.h3.class);
        goto L3
    L11:
        this._$$titleStyle = vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.model.h3.class);
        goto L3
    L12:
        this._$$description = am3.h.c(r100);
        goto L3
    L13:
        this._$$title = am3.h.c(r100);
        goto L3
    L14:
        this._$$id = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final void setDescription(String r100) {
        this._$$description = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final void setDescriptionStyle(com.bytedance.android.livesdk.chatroom.model.h3 r100) {
        this._$$descriptionStyle = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final void setId(long r100) {
        this._$$id = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final void setShowId(String r100) {
        this._$$showId = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final void setTitle(String r100) {
        this._$$title = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final void setTitleStyle(com.bytedance.android.livesdk.chatroom.model.h3 r100) {
        this._$$titleStyle = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.ok
    public final void setVersion(long r100) {
        this._$$version = r100;
    }
}
