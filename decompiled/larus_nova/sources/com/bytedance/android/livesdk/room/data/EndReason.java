package com.bytedance.android.livesdk.room.data;

import com.bytedance.android.livesdkapi.room.error.IEndReason;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\b\u0017\u0018\u00002\u00020\u0001:\u001f\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason;", "Lcom/bytedance/android/livesdkapi/room/error/IEndReason;", "()V", "AUDIENCE_BAN", "BACKGROUND_TIMEOUT", "BACK_TO_PREVIEW", "DETAIL_SCROLL", "DISLILE", "EMPTY_URL", "ENTER_FAILED", "FETCH_FAILED", "FINAL_CLEANUP", "FORCE_LOGIN_CANCEL", "HOST_INTERCEPTED", "JUMP_TO_OTHER", "JUMP_TO_OTHER_MIX_ROOM", "KICK_OUT_AFTER_LOGIN", "LIVE_DISTRIBUTION_EXIT", "LIVE_END", "LIVE_END_NO_INTERCEPT", "MEDIA_END", "NEW_ROOM_CREATE", "PAD_SPLIT_REPEAT", "PING_KICK_OUT", "PING_LOST_FOCUS", "PLAYER_ERROR", "PREVIEW_LIVE_MIX_SCROLL", "ROOM_CRASH", "SECRET_KICK_OUT", "SLIDE_OUT", "STOP_WITHOUT_RELEASE_PLAYER", "USER_CLOSE", "USER_KICK_OUT", "WATCHER_KIT_OUT", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class EndReason implements IEndReason {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$AUDIENCE_BAN;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class AUDIENCE_BAN extends EndReason {
        public static final AUDIENCE_BAN INSTANCE = null;

        static {
            INSTANCE = new AUDIENCE_BAN();
        }

        private AUDIENCE_BAN() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$BACKGROUND_TIMEOUT;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class BACKGROUND_TIMEOUT extends EndReason {
        public static final BACKGROUND_TIMEOUT INSTANCE = null;

        static {
            INSTANCE = new BACKGROUND_TIMEOUT();
        }

        private BACKGROUND_TIMEOUT() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$BACK_TO_PREVIEW;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "jumpToLiveTab", "", "(Z)V", "getJumpToLiveTab", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class BACK_TO_PREVIEW extends EndReason {
        private final boolean jumpToLiveTab;

        public BACK_TO_PREVIEW() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public static /* synthetic */ BACK_TO_PREVIEW copy$default(BACK_TO_PREVIEW r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.jumpToLiveTab;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.jumpToLiveTab;
        }

        public final BACK_TO_PREVIEW copy(boolean r100) {
            return new BACK_TO_PREVIEW(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof BACK_TO_PREVIEW) == true) goto L6;
            return false;
        L6:
            if (this.jumpToLiveTab == ((BACK_TO_PREVIEW) r100).jumpToLiveTab) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            boolean r100 = this.jumpToLiveTab;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public String toString() {
            return "BACK_TO_PREVIEW(jumpToLiveTab=" + this.jumpToLiveTab + ")";
        }

        public final boolean getJumpToLiveTab() {
            return this.jumpToLiveTab;
        }

        public BACK_TO_PREVIEW(boolean r100) {
            this.jumpToLiveTab = r100;
        }

        public /* synthetic */ BACK_TO_PREVIEW(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$DETAIL_SCROLL;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class DETAIL_SCROLL extends EndReason {
        public static final DETAIL_SCROLL INSTANCE = null;

        static {
            INSTANCE = new DETAIL_SCROLL();
        }

        private DETAIL_SCROLL() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$DISLILE;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class DISLILE extends EndReason {
        public static final DISLILE INSTANCE = null;

        static {
            INSTANCE = new DISLILE();
        }

        private DISLILE() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$EMPTY_URL;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class EMPTY_URL extends EndReason {
        public static final EMPTY_URL INSTANCE = null;

        static {
            INSTANCE = new EMPTY_URL();
        }

        private EMPTY_URL() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$ENTER_FAILED;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ENTER_FAILED extends EndReason {
        public static final ENTER_FAILED INSTANCE = null;

        static {
            INSTANCE = new ENTER_FAILED();
        }

        private ENTER_FAILED() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$FETCH_FAILED;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "errorCode", "", "(I)V", "getErrorCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class FETCH_FAILED extends EndReason {
        private final int errorCode;

        public static /* synthetic */ FETCH_FAILED copy$default(FETCH_FAILED r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.errorCode;
        L6:
            return r100.copy(r101);
        }

        public final int component1() {
            return this.errorCode;
        }

        public final FETCH_FAILED copy(int r100) {
            return new FETCH_FAILED(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof FETCH_FAILED) == true) goto L6;
            return false;
        L6:
            if (this.errorCode == ((FETCH_FAILED) r100).errorCode) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            return this.errorCode;
        }

        public String toString() {
            return "FETCH_FAILED(errorCode=" + this.errorCode + ")";
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public FETCH_FAILED(int r100) {
            this.errorCode = r100;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$FINAL_CLEANUP;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class FINAL_CLEANUP extends EndReason {
        public static final FINAL_CLEANUP INSTANCE = null;

        static {
            INSTANCE = new FINAL_CLEANUP();
        }

        private FINAL_CLEANUP() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$FORCE_LOGIN_CANCEL;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class FORCE_LOGIN_CANCEL extends EndReason {
        public static final FORCE_LOGIN_CANCEL INSTANCE = null;

        static {
            INSTANCE = new FORCE_LOGIN_CANCEL();
        }

        private FORCE_LOGIN_CANCEL() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$HOST_INTERCEPTED;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class HOST_INTERCEPTED extends EndReason {
        public static final HOST_INTERCEPTED INSTANCE = null;

        static {
            INSTANCE = new HOST_INTERCEPTED();
        }

        private HOST_INTERCEPTED() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$JUMP_TO_OTHER;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class JUMP_TO_OTHER extends EndReason {
        public static final JUMP_TO_OTHER INSTANCE = null;

        static {
            INSTANCE = new JUMP_TO_OTHER();
        }

        private JUMP_TO_OTHER() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$JUMP_TO_OTHER_MIX_ROOM;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class JUMP_TO_OTHER_MIX_ROOM extends EndReason {
        public static final JUMP_TO_OTHER_MIX_ROOM INSTANCE = null;

        static {
            INSTANCE = new JUMP_TO_OTHER_MIX_ROOM();
        }

        private JUMP_TO_OTHER_MIX_ROOM() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$KICK_OUT_AFTER_LOGIN;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class KICK_OUT_AFTER_LOGIN extends EndReason {
        public static final KICK_OUT_AFTER_LOGIN INSTANCE = null;

        static {
            INSTANCE = new KICK_OUT_AFTER_LOGIN();
        }

        private KICK_OUT_AFTER_LOGIN() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$LIVE_DISTRIBUTION_EXIT;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "type", "", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class LIVE_DISTRIBUTION_EXIT extends EndReason {
        private final String type;

        public static /* synthetic */ LIVE_DISTRIBUTION_EXIT copy$default(LIVE_DISTRIBUTION_EXIT r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.type;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.type;
        }

        public final LIVE_DISTRIBUTION_EXIT copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return new LIVE_DISTRIBUTION_EXIT(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof LIVE_DISTRIBUTION_EXIT) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.type, ((LIVE_DISTRIBUTION_EXIT) r100).type) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.type;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "LIVE_DISTRIBUTION_EXIT(type=" + this.type + ")";
        }

        public final String getType() {
            return this.type;
        }

        public LIVE_DISTRIBUTION_EXIT(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$LIVE_END;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "showEndPage", "", "(Z)V", "getShowEndPage", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class LIVE_END extends EndReason {
        private final boolean showEndPage;

        public LIVE_END() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public static /* synthetic */ LIVE_END copy$default(LIVE_END r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.showEndPage;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.showEndPage;
        }

        public final LIVE_END copy(boolean r100) {
            return new LIVE_END(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof LIVE_END) == true) goto L6;
            return false;
        L6:
            if (this.showEndPage == ((LIVE_END) r100).showEndPage) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            boolean r100 = this.showEndPage;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public String toString() {
            return "LIVE_END(showEndPage=" + this.showEndPage + ")";
        }

        public final boolean getShowEndPage() {
            return this.showEndPage;
        }

        public LIVE_END(boolean r100) {
            this.showEndPage = r100;
        }

        public /* synthetic */ LIVE_END(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = true;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$LIVE_END_NO_INTERCEPT;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "showEndPage", "", "(Z)V", "getShowEndPage", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class LIVE_END_NO_INTERCEPT extends EndReason {
        private final boolean showEndPage;

        public LIVE_END_NO_INTERCEPT() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public static /* synthetic */ LIVE_END_NO_INTERCEPT copy$default(LIVE_END_NO_INTERCEPT r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.showEndPage;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.showEndPage;
        }

        public final LIVE_END_NO_INTERCEPT copy(boolean r100) {
            return new LIVE_END_NO_INTERCEPT(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof LIVE_END_NO_INTERCEPT) == true) goto L6;
            return false;
        L6:
            if (this.showEndPage == ((LIVE_END_NO_INTERCEPT) r100).showEndPage) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            boolean r100 = this.showEndPage;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public String toString() {
            return "LIVE_END_NO_INTERCEPT(showEndPage=" + this.showEndPage + ")";
        }

        public final boolean getShowEndPage() {
            return this.showEndPage;
        }

        public LIVE_END_NO_INTERCEPT(boolean r100) {
            this.showEndPage = r100;
        }

        public /* synthetic */ LIVE_END_NO_INTERCEPT(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = true;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$MEDIA_END;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class MEDIA_END extends EndReason {
        public static final MEDIA_END INSTANCE = null;

        static {
            INSTANCE = new MEDIA_END();
        }

        private MEDIA_END() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$NEW_ROOM_CREATE;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class NEW_ROOM_CREATE extends EndReason {
        public static final NEW_ROOM_CREATE INSTANCE = null;

        static {
            INSTANCE = new NEW_ROOM_CREATE();
        }

        private NEW_ROOM_CREATE() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$PAD_SPLIT_REPEAT;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PAD_SPLIT_REPEAT extends EndReason {
        public static final PAD_SPLIT_REPEAT INSTANCE = null;

        static {
            INSTANCE = new PAD_SPLIT_REPEAT();
        }

        private PAD_SPLIT_REPEAT() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$PING_KICK_OUT;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PING_KICK_OUT extends EndReason {
        public static final PING_KICK_OUT INSTANCE = null;

        static {
            INSTANCE = new PING_KICK_OUT();
        }

        private PING_KICK_OUT() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$PING_LOST_FOCUS;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PING_LOST_FOCUS extends EndReason {
        public static final PING_LOST_FOCUS INSTANCE = null;

        static {
            INSTANCE = new PING_LOST_FOCUS();
        }

        private PING_LOST_FOCUS() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$PLAYER_ERROR;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PLAYER_ERROR extends EndReason {
        public static final PLAYER_ERROR INSTANCE = null;

        static {
            INSTANCE = new PLAYER_ERROR();
        }

        private PLAYER_ERROR() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$PREVIEW_LIVE_MIX_SCROLL;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "type", "", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PREVIEW_LIVE_MIX_SCROLL extends EndReason {
        private final String type;

        public static /* synthetic */ PREVIEW_LIVE_MIX_SCROLL copy$default(PREVIEW_LIVE_MIX_SCROLL r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.type;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.type;
        }

        public final PREVIEW_LIVE_MIX_SCROLL copy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return new PREVIEW_LIVE_MIX_SCROLL(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof PREVIEW_LIVE_MIX_SCROLL) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.type, ((PREVIEW_LIVE_MIX_SCROLL) r100).type) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.type;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "PREVIEW_LIVE_MIX_SCROLL(type=" + this.type + ")";
        }

        public final String getType() {
            return this.type;
        }

        public PREVIEW_LIVE_MIX_SCROLL(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$ROOM_CRASH;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ROOM_CRASH extends EndReason {
        public static final ROOM_CRASH INSTANCE = null;

        static {
            INSTANCE = new ROOM_CRASH();
        }

        private ROOM_CRASH() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$SECRET_KICK_OUT;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class SECRET_KICK_OUT extends EndReason {
        public static final SECRET_KICK_OUT INSTANCE = null;

        static {
            INSTANCE = new SECRET_KICK_OUT();
        }

        private SECRET_KICK_OUT() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$SLIDE_OUT;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class SLIDE_OUT extends EndReason {
        public static final SLIDE_OUT INSTANCE = null;

        static {
            INSTANCE = new SLIDE_OUT();
        }

        private SLIDE_OUT() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$STOP_WITHOUT_RELEASE_PLAYER;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class STOP_WITHOUT_RELEASE_PLAYER extends EndReason {
        public static final STOP_WITHOUT_RELEASE_PLAYER INSTANCE = null;

        static {
            INSTANCE = new STOP_WITHOUT_RELEASE_PLAYER();
        }

        private STOP_WITHOUT_RELEASE_PLAYER() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$USER_CLOSE;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class USER_CLOSE extends EndReason {
        public static final USER_CLOSE INSTANCE = null;

        static {
            INSTANCE = new USER_CLOSE();
        }

        private USER_CLOSE() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$USER_KICK_OUT;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class USER_KICK_OUT extends EndReason {
        public static final USER_KICK_OUT INSTANCE = null;

        static {
            INSTANCE = new USER_KICK_OUT();
        }

        private USER_KICK_OUT() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/room/data/EndReason$WATCHER_KIT_OUT;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class WATCHER_KIT_OUT extends EndReason {
        public static final WATCHER_KIT_OUT INSTANCE = null;

        static {
            INSTANCE = new WATCHER_KIT_OUT();
        }

        private WATCHER_KIT_OUT() {
        }
    }

    public EndReason() {
    }
}
