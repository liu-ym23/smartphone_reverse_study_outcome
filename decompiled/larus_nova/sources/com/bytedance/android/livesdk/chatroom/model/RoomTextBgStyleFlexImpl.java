package com.bytedance.android.livesdk.chatroom.model;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.RoomTextBgStyle")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R+\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR+\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\n¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/RoomTextBgStyleFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/h3;", "", "<set-?>", "algin$delegate", "Ljava/lang/Object;", "getAlgin", "()J", "setAlgin", "(J)V", "algin", "fontSize$delegate", "getFontSize", "setFontSize", "fontSize", "", "fontFamily$delegate", "getFontFamily", "()Ljava/lang/String;", "setFontFamily", "(Ljava/lang/String;)V", "fontFamily", "fontColor$delegate", "getFontColor", "setFontColor", "fontColor", "scroll$delegate", "getScroll", "setScroll", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "scrollSpeed$delegate", "getScrollSpeed", "setScrollSpeed", "scrollSpeed", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomTextBgStyleFlexImpl extends FlexModelBase<h3> implements h3, vh7.h {

    @SerializedName("align")
    protected long _$$algin;

    @SerializedName("font_color")
    protected String _$$fontColor;

    @SerializedName("font_family")
    protected String _$$fontFamily;

    @SerializedName("font_size")
    protected long _$$fontSize;

    @SerializedName(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL)
    protected long _$$scroll;

    @SerializedName("scroll_speed")
    protected long _$$scrollSpeed;

    public RoomTextBgStyleFlexImpl() {
        super(h3.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final long getAlgin() {
        return this._$$algin;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final String getFontColor() {
        return this._$$fontColor;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final String getFontFamily() {
        return this._$$fontFamily;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final long getFontSize() {
        return this._$$fontSize;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final long getScroll() {
        return this._$$scroll;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final long getScrollSpeed() {
        return this._$$scrollSpeed;
    }

    public RoomTextBgStyleFlexImpl(am3.g r100) {
        super(h3.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$scrollSpeed = r100.j();
        goto L3
    L9:
        this._$$scroll = r100.j();
        goto L3
    L10:
        this._$$fontColor = am3.h.c(r100);
        goto L3
    L11:
        this._$$fontFamily = am3.h.c(r100);
        goto L3
    L12:
        this._$$fontSize = r100.j();
        goto L3
    L13:
        this._$$algin = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final void setAlgin(long r100) {
        this._$$algin = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final void setFontColor(String r100) {
        this._$$fontColor = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final void setFontFamily(String r100) {
        this._$$fontFamily = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final void setFontSize(long r100) {
        this._$$fontSize = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final void setScroll(long r100) {
        this._$$scroll = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.h3
    public final void setScrollSpeed(long r100) {
        this._$$scrollSpeed = r100;
    }
}
