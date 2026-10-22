package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001a\u00020\nH\u0016R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R \u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomInfo;", "", "()V", "isMainRoom", "", "()Ljava/lang/Boolean;", "setMainRoom", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "pattern", "", "getPattern", "()I", "setPattern", "(I)V", "projectName", "", "getProjectName", "()Ljava/lang/String;", "setProjectName", "(Ljava/lang/String;)V", "rooms", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomNode;", "getRooms", "()Ljava/util/List;", "setRooms", "(Ljava/util/List;)V", "tabTitle", "getTabTitle", "setTabTitle", "title", "getTitle", d.f25925o, "equals", "other", "hashCode", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLinkedRoomInfo implements h {

    @SerializedName("is_main_room")
    protected Boolean isMainRoom;

    @SerializedName("pattern")
    protected int pattern;

    @SerializedName("project_name")
    protected String projectName;

    @SerializedName("rooms")
    protected List<VSLinkedRoomNode> rooms;

    @SerializedName("tab_title")
    protected String tabTitle;

    @SerializedName("title")
    protected String title;

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.tabTitle;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<VSLinkedRoomNode> r107 = this.rooms;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.pattern) * 31;
        String r110 = this.projectName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isMainRoom;
        if (r113 == null) goto L25;
        if (r113.booleanValue() == false) goto L23;
        r101 = 1231;
        goto L25
    L23:
        r101 = 1237;
    L25:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public VSLinkedRoomInfo() {
        this.isMainRoom = Boolean.FALSE;
    }

    public final int getPattern() {
        return this.pattern;
    }

    public final String getProjectName() {
        return this.projectName;
    }

    public final List<VSLinkedRoomNode> getRooms() {
        return this.rooms;
    }

    public final String getTabTitle() {
        return this.tabTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isMainRoom() {
        return this.isMainRoom;
    }

    public VSLinkedRoomInfo(g r100) {
        this.rooms = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.isMainRoom = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        this.projectName = am3.h.c(r100);
        goto L3
    L9:
        this.pattern = r100.i();
        goto L3
    L10:
        this.rooms.add(new VSLinkedRoomNode(r100));
        goto L3
    L11:
        this.tabTitle = am3.h.c(r100);
        goto L3
    L12:
        this.title = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.isMainRoom != null) goto L33;
        this.isMainRoom = Boolean.FALSE;
        return;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(VSLinkedRoomInfo.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L33;
        VSLinkedRoomInfo r102 = (VSLinkedRoomInfo) r100;
        if ((!Intrinsics.areEqual(this.title, r102.title)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.tabTitle, r102.tabTitle)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.rooms, r102.rooms)) == false) goto L23;
        return false;
    L23:
        if (this.pattern == r102.pattern) goto L26;
        return false;
    L26:
        if ((!Intrinsics.areEqual(this.projectName, r102.projectName)) == false) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(this.isMainRoom, r102.isMainRoom)) == false) goto L31;
        return false;
    L31:
        return true;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo");
    L8:
        r101 = null;
        goto L10
    }

    public final void setMainRoom(Boolean r100) {
        this.isMainRoom = r100;
    }

    public final void setPattern(int r100) {
        this.pattern = r100;
    }

    public final void setProjectName(String r100) {
        this.projectName = r100;
    }

    public final void setRooms(List<VSLinkedRoomNode> r100) {
        this.rooms = r100;
    }

    public final void setTabTitle(String r100) {
        this.tabTitle = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
