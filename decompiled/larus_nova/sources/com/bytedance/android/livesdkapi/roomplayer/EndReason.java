package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00052\u00020\u0001:\u0019\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0018\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "()V", "AUDIENCE_BAN", "BACKGROUND_TIMEOUT", "Companion", "DETAIL_SCROLL", "EMPTY_URL", "ENTER_FAILED", "FETCH_FAILED", "FINAL_CLEANUP", "FORCE_LOGIN_CANCEL", "JUMP_TO_OTHER", "JUMP_TO_OTHER_MIX_ROOM", "KICK_OUT_AFTER_LOGIN", "LIVE_END", "LIVE_END_NO_INTERCEPT", "MEDIA_END", "PAD_SPLIT_REPEAT", "PING_KICK_OUT", "PING_LOST_FOCUS", "PLAYER_ERROR", "SECRET_KICK_OUT", "SLIDE_OUT", "STOP_WITHOUT_RELEASE_PLAYER", "USER_CLOSE", "USER_KICK_OUT", "WATCHER_KIT_OUT", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$AUDIENCE_BAN;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$BACKGROUND_TIMEOUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$DETAIL_SCROLL;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$EMPTY_URL;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$ENTER_FAILED;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$FETCH_FAILED;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$FINAL_CLEANUP;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$FORCE_LOGIN_CANCEL;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$JUMP_TO_OTHER;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$JUMP_TO_OTHER_MIX_ROOM;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$KICK_OUT_AFTER_LOGIN;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$LIVE_END;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$LIVE_END_NO_INTERCEPT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$MEDIA_END;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$PAD_SPLIT_REPEAT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$PING_KICK_OUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$PING_LOST_FOCUS;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$PLAYER_ERROR;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$SECRET_KICK_OUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$SLIDE_OUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$STOP_WITHOUT_RELEASE_PLAYER;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$USER_CLOSE;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$USER_KICK_OUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$WATCHER_KIT_OUT;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class EndReason extends com.bytedance.android.livesdk.room.data.EndReason {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$AUDIENCE_BAN;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AUDIENCE_BAN extends EndReason {
        public static final AUDIENCE_BAN INSTANCE = null;

        private AUDIENCE_BAN() {
            super(null);
        }

        static {
            INSTANCE = new AUDIENCE_BAN();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$BACKGROUND_TIMEOUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BACKGROUND_TIMEOUT extends EndReason {
        public static final BACKGROUND_TIMEOUT INSTANCE = null;

        private BACKGROUND_TIMEOUT() {
            super(null);
        }

        static {
            INSTANCE = new BACKGROUND_TIMEOUT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$Companion;", "", "()V", "convertFromV2", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "reason", "Lcom/bytedance/android/livesdk/room/data/EndReason;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final EndReason convertFromV2(com.bytedance.android.livesdk.room.data.EndReason r100) {
            if ((r100 instanceof EndReason) == false) goto L7;
            return (EndReason) r100;
        L7:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.ENTER_FAILED.INSTANCE) == false) goto L10;
            return ENTER_FAILED.INSTANCE;
        L10:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.EMPTY_URL.INSTANCE) == false) goto L13;
            return EMPTY_URL.INSTANCE;
        L13:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.PING_KICK_OUT.INSTANCE) == false) goto L16;
            return PING_KICK_OUT.INSTANCE;
        L16:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.PING_LOST_FOCUS.INSTANCE) == false) goto L19;
            return PING_LOST_FOCUS.INSTANCE;
        L19:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.AUDIENCE_BAN.INSTANCE) == false) goto L22;
            return AUDIENCE_BAN.INSTANCE;
        L22:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.MEDIA_END.INSTANCE) == false) goto L25;
            return MEDIA_END.INSTANCE;
        L25:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.USER_CLOSE.INSTANCE) == false) goto L28;
            return USER_CLOSE.INSTANCE;
        L28:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.USER_KICK_OUT.INSTANCE) == false) goto L31;
            return USER_KICK_OUT.INSTANCE;
        L31:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.WATCHER_KIT_OUT.INSTANCE) == false) goto L34;
            return WATCHER_KIT_OUT.INSTANCE;
        L34:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.JUMP_TO_OTHER.INSTANCE) == false) goto L37;
            return JUMP_TO_OTHER.INSTANCE;
        L37:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.PLAYER_ERROR.INSTANCE) == false) goto L40;
            return PLAYER_ERROR.INSTANCE;
        L40:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.JUMP_TO_OTHER_MIX_ROOM.INSTANCE) == false) goto L43;
            return JUMP_TO_OTHER_MIX_ROOM.INSTANCE;
        L43:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.STOP_WITHOUT_RELEASE_PLAYER.INSTANCE) == false) goto L46;
            return STOP_WITHOUT_RELEASE_PLAYER.INSTANCE;
        L46:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.BACKGROUND_TIMEOUT.INSTANCE) == false) goto L49;
            return BACKGROUND_TIMEOUT.INSTANCE;
        L49:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.FINAL_CLEANUP.INSTANCE) == false) goto L52;
            return FINAL_CLEANUP.INSTANCE;
        L52:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.SECRET_KICK_OUT.INSTANCE) == false) goto L55;
            return SECRET_KICK_OUT.INSTANCE;
        L55:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.PAD_SPLIT_REPEAT.INSTANCE) == false) goto L58;
            return PAD_SPLIT_REPEAT.INSTANCE;
        L58:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.FORCE_LOGIN_CANCEL.INSTANCE) == false) goto L61;
            return FORCE_LOGIN_CANCEL.INSTANCE;
        L61:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.KICK_OUT_AFTER_LOGIN.INSTANCE) == false) goto L64;
            return KICK_OUT_AFTER_LOGIN.INSTANCE;
        L64:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.SLIDE_OUT.INSTANCE) == false) goto L67;
            return SLIDE_OUT.INSTANCE;
        L67:
            if (Intrinsics.areEqual(r100, com.bytedance.android.livesdk.room.data.EndReason.DETAIL_SCROLL.INSTANCE) == false) goto L70;
            return DETAIL_SCROLL.INSTANCE;
        L70:
            if ((r100 instanceof com.bytedance.android.livesdk.room.data.EndReason.FETCH_FAILED) == false) goto L74;
            EndReason r101 = new FETCH_FAILED(((com.bytedance.android.livesdk.room.data.EndReason.FETCH_FAILED) r100).getErrorCode());
        L102:
            return r101;
        L74:
            if ((r100 instanceof com.bytedance.android.livesdk.room.data.EndReason.LIVE_END) == false) goto L77;
            r101 = new LIVE_END(((com.bytedance.android.livesdk.room.data.EndReason.LIVE_END) r100).getShowEndPage());
            goto L102
        L77:
            if ((r100 instanceof com.bytedance.android.livesdk.room.data.EndReason.LIVE_END_NO_INTERCEPT) == false) goto L80;
            r101 = new LIVE_END_NO_INTERCEPT(((com.bytedance.android.livesdk.room.data.EndReason.LIVE_END_NO_INTERCEPT) r100).getShowEndPage());
            goto L102
        L80:
            return FINAL_CLEANUP.INSTANCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$DETAIL_SCROLL;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DETAIL_SCROLL extends EndReason {
        public static final DETAIL_SCROLL INSTANCE = null;

        private DETAIL_SCROLL() {
            super(null);
        }

        static {
            INSTANCE = new DETAIL_SCROLL();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$EMPTY_URL;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EMPTY_URL extends EndReason {
        public static final EMPTY_URL INSTANCE = null;

        private EMPTY_URL() {
            super(null);
        }

        static {
            INSTANCE = new EMPTY_URL();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$ENTER_FAILED;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ENTER_FAILED extends EndReason {
        public static final ENTER_FAILED INSTANCE = null;

        private ENTER_FAILED() {
            super(null);
        }

        static {
            INSTANCE = new ENTER_FAILED();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$FETCH_FAILED;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "errorCode", "", "(I)V", "getErrorCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
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
            super(null);
            this.errorCode = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$FINAL_CLEANUP;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FINAL_CLEANUP extends EndReason {
        public static final FINAL_CLEANUP INSTANCE = null;

        private FINAL_CLEANUP() {
            super(null);
        }

        static {
            INSTANCE = new FINAL_CLEANUP();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$FORCE_LOGIN_CANCEL;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FORCE_LOGIN_CANCEL extends EndReason {
        public static final FORCE_LOGIN_CANCEL INSTANCE = null;

        private FORCE_LOGIN_CANCEL() {
            super(null);
        }

        static {
            INSTANCE = new FORCE_LOGIN_CANCEL();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$JUMP_TO_OTHER;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class JUMP_TO_OTHER extends EndReason {
        public static final JUMP_TO_OTHER INSTANCE = null;

        private JUMP_TO_OTHER() {
            super(null);
        }

        static {
            INSTANCE = new JUMP_TO_OTHER();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$JUMP_TO_OTHER_MIX_ROOM;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class JUMP_TO_OTHER_MIX_ROOM extends EndReason {
        public static final JUMP_TO_OTHER_MIX_ROOM INSTANCE = null;

        private JUMP_TO_OTHER_MIX_ROOM() {
            super(null);
        }

        static {
            INSTANCE = new JUMP_TO_OTHER_MIX_ROOM();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$KICK_OUT_AFTER_LOGIN;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class KICK_OUT_AFTER_LOGIN extends EndReason {
        public static final KICK_OUT_AFTER_LOGIN INSTANCE = null;

        private KICK_OUT_AFTER_LOGIN() {
            super(null);
        }

        static {
            INSTANCE = new KICK_OUT_AFTER_LOGIN();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$LIVE_END;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "showEndPage", "", "(Z)V", "getShowEndPage", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
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
            super(null);
            this.showEndPage = r100;
        }

        public /* synthetic */ LIVE_END(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = true;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$LIVE_END_NO_INTERCEPT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "showEndPage", "", "(Z)V", "getShowEndPage", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
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
            super(null);
            this.showEndPage = r100;
        }

        public /* synthetic */ LIVE_END_NO_INTERCEPT(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = true;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$MEDIA_END;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MEDIA_END extends EndReason {
        public static final MEDIA_END INSTANCE = null;

        private MEDIA_END() {
            super(null);
        }

        static {
            INSTANCE = new MEDIA_END();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$PAD_SPLIT_REPEAT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PAD_SPLIT_REPEAT extends EndReason {
        public static final PAD_SPLIT_REPEAT INSTANCE = null;

        private PAD_SPLIT_REPEAT() {
            super(null);
        }

        static {
            INSTANCE = new PAD_SPLIT_REPEAT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$PING_KICK_OUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PING_KICK_OUT extends EndReason {
        public static final PING_KICK_OUT INSTANCE = null;

        private PING_KICK_OUT() {
            super(null);
        }

        static {
            INSTANCE = new PING_KICK_OUT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$PING_LOST_FOCUS;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PING_LOST_FOCUS extends EndReason {
        public static final PING_LOST_FOCUS INSTANCE = null;

        private PING_LOST_FOCUS() {
            super(null);
        }

        static {
            INSTANCE = new PING_LOST_FOCUS();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$PLAYER_ERROR;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PLAYER_ERROR extends EndReason {
        public static final PLAYER_ERROR INSTANCE = null;

        private PLAYER_ERROR() {
            super(null);
        }

        static {
            INSTANCE = new PLAYER_ERROR();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$SECRET_KICK_OUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SECRET_KICK_OUT extends EndReason {
        public static final SECRET_KICK_OUT INSTANCE = null;

        private SECRET_KICK_OUT() {
            super(null);
        }

        static {
            INSTANCE = new SECRET_KICK_OUT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$SLIDE_OUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SLIDE_OUT extends EndReason {
        public static final SLIDE_OUT INSTANCE = null;

        private SLIDE_OUT() {
            super(null);
        }

        static {
            INSTANCE = new SLIDE_OUT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$STOP_WITHOUT_RELEASE_PLAYER;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class STOP_WITHOUT_RELEASE_PLAYER extends EndReason {
        public static final STOP_WITHOUT_RELEASE_PLAYER INSTANCE = null;

        private STOP_WITHOUT_RELEASE_PLAYER() {
            super(null);
        }

        static {
            INSTANCE = new STOP_WITHOUT_RELEASE_PLAYER();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$USER_CLOSE;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class USER_CLOSE extends EndReason {
        public static final USER_CLOSE INSTANCE = null;

        private USER_CLOSE() {
            super(null);
        }

        static {
            INSTANCE = new USER_CLOSE();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$USER_KICK_OUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class USER_KICK_OUT extends EndReason {
        public static final USER_KICK_OUT INSTANCE = null;

        private USER_KICK_OUT() {
            super(null);
        }

        static {
            INSTANCE = new USER_KICK_OUT();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EndReason$WATCHER_KIT_OUT;", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WATCHER_KIT_OUT extends EndReason {
        public static final WATCHER_KIT_OUT INSTANCE = null;

        private WATCHER_KIT_OUT() {
            super(null);
        }

        static {
            INSTANCE = new WATCHER_KIT_OUT();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final EndReason convertFromV2(com.bytedance.android.livesdk.room.data.EndReason r100) {
        return Companion.convertFromV2(r100);
    }

    private EndReason() {
    }

    public /* synthetic */ EndReason(DefaultConstructorMarker r100) {
        this();
    }
}
