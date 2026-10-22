package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInitChatRoomContent;", "", "()V", "initSource", "", "getInitSource", "()I", "setInitSource", "(I)V", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "scene", "getScene", "setScene", "uiLayout", "getUiLayout", "setUiLayout", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerInitChatRoomContent implements h {

    @SerializedName("init_source")
    protected int initSource;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("scene")
    protected int scene;

    @SerializedName("ui_layout")
    protected int uiLayout;

    public LinkerInitChatRoomContent() {
    }

    public String toString() {
        return "LinkerInitChatRoomContent(roomId=" + this.roomId + ", initSource=" + this.initSource + ", scene=" + this.scene + ", uiLayout=" + this.uiLayout + ')';
    }

    public final int getInitSource() {
        return this.initSource;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final int getScene() {
        return this.scene;
    }

    public final int getUiLayout() {
        return this.uiLayout;
    }

    public LinkerInitChatRoomContent(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.roomId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.scene = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.initSource = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.uiLayout = r100.i();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setInitSource(int r100) {
        this.initSource = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setScene(int r100) {
        this.scene = r100;
    }

    public final void setUiLayout(int r100) {
        this.uiLayout = r100;
    }
}
