package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ls2.e;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b)\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010&\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/RoomError;", "Lls2/e;", "", "roomErrorCode", "I", "getRoomErrorCode", "()I", "setRoomErrorCode", "(I)V", "", "errMsg", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errPrompt", "getErrPrompt", "setErrPrompt", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "reason", "Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "getReason", "()Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;", "setReason", "(Lcom/bytedance/android/livesdkapi/roomplayer/EndReason;)V", "sourceKey", "getSourceKey", "setSourceKey", "sourceValue", "getSourceValue", "setSourceValue", "end", "getEnd", "setEnd", "playerState", "getPlayerState", "setPlayerState", "errorCode", "getErrorCode", "setErrorCode", "<init>", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomError extends e {
    public static final Companion Companion = null;
    private int end;
    private String errMsg;
    private String errPrompt;
    private int errorCode;
    private String playerState;
    private EndReason reason;
    private int roomErrorCode;
    private String sourceKey;
    private String sourceValue;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/RoomError$Companion;", "", "Lls2/e;", "error", "Lcom/bytedance/android/livesdkapi/roomplayer/RoomError;", "convertFromV2", "<init>", "()V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final RoomError convertFromV2(e r100) {
            if ((r100 instanceof RoomError) == false) goto L7;
            return (RoomError) r100;
        L7:
            if (r100 == null) goto L9;
            int r101 = r100.getErrorCode();
        L10:
            RoomError r102 = new RoomError(r101);
            if (r100 == null) goto L16;
            r102.setRoomErrorCode(r100.getRoomErrorCodeV2());
            r102.setErrMsg(r100.getErrMsgV2());
            r102.setErrPrompt(r100.getErrPromptV2());
            EndReason.Companion r103 = EndReason.Companion;
            com.bytedance.android.livesdk.room.data.EndReason r104 = r100.getReasonV2();
            if (r104 != null) goto L15;
            r104 = com.bytedance.android.livesdk.room.data.EndReason.FINAL_CLEANUP.INSTANCE;
        L15:
            r102.setReason(r103.convertFromV2(r104));
            r102.setSourceKey(r100.getSourceKeyV2());
            r102.setSourceValue(r100.getSourceValueV2V2());
            r102.setEnd(r100.getEndV2());
            r102.setPlayerState(r100.getPlayerStateV2());
        L16:
            return r102;
        L9:
            r101 = -1;
            goto L10
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final RoomError convertFromV2(e r100) {
        return Companion.convertFromV2(r100);
    }

    public final int getEnd() {
        return this.end;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final String getErrPrompt() {
        return this.errPrompt;
    }

    @Override // ls2.e, com.bytedance.android.livesdkapi.room.error.IRoomError
    public int getErrorCode() {
        return this.errorCode;
    }

    public final String getPlayerState() {
        return this.playerState;
    }

    public final EndReason getReason() {
        return this.reason;
    }

    public final int getRoomErrorCode() {
        return this.roomErrorCode;
    }

    public final String getSourceKey() {
        return this.sourceKey;
    }

    public final String getSourceValue() {
        return this.sourceValue;
    }

    public RoomError(int r100) {
        super(r100);
        this.errorCode = r100;
        this.errMsg = "";
        this.errPrompt = "";
    }

    public final void setEnd(int r100) {
        this.end = r100;
    }

    public final void setErrMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errMsg = r100;
    }

    public final void setErrPrompt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errPrompt = r100;
    }

    @Override // ls2.e, com.bytedance.android.livesdkapi.room.error.IRoomError
    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setPlayerState(String r100) {
        this.playerState = r100;
    }

    public final void setReason(EndReason r100) {
        this.reason = r100;
    }

    public final void setRoomErrorCode(int r100) {
        this.roomErrorCode = r100;
    }

    public final void setSourceKey(String r100) {
        this.sourceKey = r100;
    }

    public final void setSourceValue(String r100) {
        this.sourceValue = r100;
    }
}
