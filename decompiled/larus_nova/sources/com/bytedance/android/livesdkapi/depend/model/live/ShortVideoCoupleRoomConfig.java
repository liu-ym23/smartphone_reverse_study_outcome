package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortVideoCoupleRoomConfig;", "", "()V", "chatConfig", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortVideoCoupleRoomConfig$SubConfig;", "getChatConfig", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ShortVideoCoupleRoomConfig$SubConfig;", "setChatConfig", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ShortVideoCoupleRoomConfig$SubConfig;)V", "homepageFamiliarConfig", "getHomepageFamiliarConfig", "setHomepageFamiliarConfig", "homepageHotConfig", "getHomepageHotConfig", "setHomepageHotConfig", "SubConfig", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortVideoCoupleRoomConfig {

    @SerializedName("chat")
    private SubConfig chatConfig;

    @SerializedName("homepage_familiar")
    private SubConfig homepageFamiliarConfig;

    @SerializedName(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT)
    private SubConfig homepageHotConfig;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortVideoCoupleRoomConfig$SubConfig;", "", "()V", "acquaintanceDefault", "", "getAcquaintanceDefault", "()I", "setAcquaintanceDefault", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "friendDefaultMode", "", "getFriendDefaultMode", "()J", "setFriendDefaultMode", "(J)V", "intimateMode", "getIntimateMode", "setIntimateMode", "showIntimatePanel", "getShowIntimatePanel", "setShowIntimatePanel", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SubConfig {

        @SerializedName("acquaintance_default")
        private int acquaintanceDefault;

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("friend_default_mode")
        private long friendDefaultMode;

        @SerializedName("intimate_mode")
        private long intimateMode;

        @SerializedName("show_intimate_panel")
        private boolean showIntimatePanel;

        public SubConfig() {
            this.enable = true;
            this.friendDefaultMode = 1;
            this.intimateMode = 3;
        }

        public final int getAcquaintanceDefault() {
            return this.acquaintanceDefault;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final long getFriendDefaultMode() {
            return this.friendDefaultMode;
        }

        public final long getIntimateMode() {
            return this.intimateMode;
        }

        public final boolean getShowIntimatePanel() {
            return this.showIntimatePanel;
        }

        public final void setAcquaintanceDefault(int r100) {
            this.acquaintanceDefault = r100;
        }

        public final void setEnable(boolean r100) {
            this.enable = r100;
        }

        public final void setFriendDefaultMode(long r100) {
            this.friendDefaultMode = r100;
        }

        public final void setIntimateMode(long r100) {
            this.intimateMode = r100;
        }

        public final void setShowIntimatePanel(boolean r100) {
            this.showIntimatePanel = r100;
        }
    }

    public ShortVideoCoupleRoomConfig() {
    }

    public final SubConfig getChatConfig() {
        return this.chatConfig;
    }

    public final SubConfig getHomepageFamiliarConfig() {
        return this.homepageFamiliarConfig;
    }

    public final SubConfig getHomepageHotConfig() {
        return this.homepageHotConfig;
    }

    public final void setChatConfig(SubConfig r100) {
        this.chatConfig = r100;
    }

    public final void setHomepageFamiliarConfig(SubConfig r100) {
        this.homepageFamiliarConfig = r100;
    }

    public final void setHomepageHotConfig(SubConfig r100) {
        this.homepageHotConfig = r100;
    }
}
