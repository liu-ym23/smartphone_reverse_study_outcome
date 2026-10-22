package com.bytedance.android.livesdkapi.depend.model.live.room;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/room/EnterRoomInfo;", "", "()V", "enterMerge", "", "getEnterMerge", "()Ljava/lang/String;", "setEnterMerge", "(Ljava/lang/String;)V", "enterMethod", "getEnterMethod", "setEnterMethod", "enterRoomSource", "getEnterRoomSource", "setEnterRoomSource", "enterRoomType", "getEnterRoomType", "setEnterRoomType", "enterType", "getEnterType", "setEnterType", "linkerMap", "getLinkerMap", "setLinkerMap", "uiLayout", "", "getUiLayout", "()I", "setUiLayout", "(I)V", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterRoomInfo {
    private String enterMerge;
    private String enterMethod;
    private String enterRoomSource;
    private String enterRoomType;
    private String enterType;
    private String linkerMap;
    private int uiLayout;

    public EnterRoomInfo() {
        this.enterRoomSource = "";
        this.enterRoomType = "";
        this.linkerMap = "";
        this.enterMerge = "";
        this.enterMethod = "";
        this.enterType = "";
    }

    public final String getEnterMerge() {
        return this.enterMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEnterRoomSource() {
        return this.enterRoomSource;
    }

    public final String getEnterRoomType() {
        return this.enterRoomType;
    }

    public final String getEnterType() {
        return this.enterType;
    }

    public final String getLinkerMap() {
        return this.linkerMap;
    }

    public final int getUiLayout() {
        return this.uiLayout;
    }

    public final void setEnterMerge(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMerge = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setEnterRoomSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterRoomSource = r100;
    }

    public final void setEnterRoomType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterRoomType = r100;
    }

    public final void setEnterType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterType = r100;
    }

    public final void setLinkerMap(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.linkerMap = r100;
    }

    public final void setUiLayout(int r100) {
        this.uiLayout = r100;
    }
}
