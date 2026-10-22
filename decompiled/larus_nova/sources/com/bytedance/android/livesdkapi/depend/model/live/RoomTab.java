package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomTab")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomTab;", "", "()V", "mRoomTabType", "", "getMRoomTabType", "()I", "setMRoomTabType", "(I)V", "mTabName", "", "getMTabName", "()Ljava/lang/String;", "setMTabName", "(Ljava/lang/String;)V", "mTabUrl", "getMTabUrl", "setMTabUrl", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomTab implements h {
    public static final Companion Companion = null;
    public static final int TAB_CHAT = 1;
    public static final int TAB_COMMON_H5 = 6;
    public static final int TAB_FANSCLUB = 4;
    public static final int TAB_ILLEGAL = 0;
    public static final int TAB_INTRO = 3;
    public static final int TAB_NOBLE_RANK = 7;
    public static final int TAB_RACE_SCHEDULE = 5;
    public static final int TAB_RANK = 2;

    @SerializedName("tab_type")
    protected int mRoomTabType;

    @SerializedName(a.KEY_TAB_NAME)
    protected String mTabName;

    @SerializedName("tab_url")
    protected String mTabUrl;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomTab$Companion;", "", "()V", "TAB_CHAT", "", "TAB_COMMON_H5", "TAB_FANSCLUB", "TAB_ILLEGAL", "TAB_INTRO", "TAB_NOBLE_RANK", "TAB_RACE_SCHEDULE", "TAB_RANK", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RoomTab() {
    }

    public final int getMRoomTabType() {
        return this.mRoomTabType;
    }

    public final String getMTabName() {
        return this.mTabName;
    }

    public final String getMTabUrl() {
        return this.mTabUrl;
    }

    public RoomTab(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.mRoomTabType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.mTabName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.mTabUrl = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setMRoomTabType(int r100) {
        this.mRoomTabType = r100;
    }

    public final void setMTabName(String r100) {
        this.mTabName = r100;
    }

    public final void setMTabUrl(String r100) {
        this.mTabUrl = r100;
    }
}
