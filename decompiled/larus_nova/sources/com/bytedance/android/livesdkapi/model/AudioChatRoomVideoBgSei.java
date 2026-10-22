package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AudioChatRoomVideoBgSei;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "linkMicId", "", "getLinkMicId", "()Ljava/lang/String;", "setLinkMicId", "(Ljava/lang/String;)V", "type", "", "getType", "()I", "setType", "(I)V", "uid", "getUid", "setUid", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioChatRoomVideoBgSei {
    public static final int AVATAR_TYPE = 1;
    public static final int CUSTOMIZE_STREAM_TYPE = 2;
    public static final Companion Companion = null;
    public static final String SEI_KEY = "audio_chat_room_video_bg";
    public static final int UNKNOWN_TYPE = 0;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("linkmic_uid")
    private String linkMicId;

    @SerializedName("type")
    private int type;

    @SerializedName("uid")
    private String uid;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AudioChatRoomVideoBgSei$Companion;", "", "()V", "AVATAR_TYPE", "", "CUSTOMIZE_STREAM_TYPE", "SEI_KEY", "", "UNKNOWN_TYPE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public AudioChatRoomVideoBgSei() {
        this.linkMicId = "";
        this.uid = "";
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getLinkMicId() {
        return this.linkMicId;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setLinkMicId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.linkMicId = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uid = r100;
    }
}
