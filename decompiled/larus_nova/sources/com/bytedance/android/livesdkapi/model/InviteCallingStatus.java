package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InviteCallingStatus;", "", "state", "", "leftTime", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "anchor", "Lcom/bytedance/android/live/base/model/user/User;", SourceType.DEFAULT, "(IILcom/bytedance/android/livesdkapi/depend/model/live/Room;Lcom/bytedance/android/live/base/model/user/User;Lcom/bytedance/android/live/base/model/user/User;)V", "getAnchor", "()Lcom/bytedance/android/live/base/model/user/User;", "setAnchor", "(Lcom/bytedance/android/live/base/model/user/User;)V", "getAudience", "setAudience", "getLeftTime", "()I", "setLeftTime", "(I)V", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "getState", "setState", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InviteCallingStatus {
    public static final Companion Companion = null;
    public static final int STATE_HANG_UP = 2;
    public static final int STATE_LINK_SUCCESS = 3;
    public static final int STATE_LINK_TIME_OUT = 4;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PACK_UP = 1;
    private User anchor;
    private User audience;
    private int leftTime;
    private Room room;
    private int state;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/InviteCallingStatus$Companion;", "", "()V", "STATE_HANG_UP", "", "STATE_LINK_SUCCESS", "STATE_LINK_TIME_OUT", "STATE_NORMAL", "STATE_PACK_UP", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final User getAnchor() {
        return this.anchor;
    }

    public final User getAudience() {
        return this.audience;
    }

    public final int getLeftTime() {
        return this.leftTime;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final int getState() {
        return this.state;
    }

    public final void setAnchor(User r100) {
        this.anchor = r100;
    }

    public final void setAudience(User r100) {
        this.audience = r100;
    }

    public final void setLeftTime(int r100) {
        this.leftTime = r100;
    }

    public final void setRoom(Room r100) {
        this.room = r100;
    }

    public final void setState(int r100) {
        this.state = r100;
    }

    public InviteCallingStatus(int r100, int r101, Room r102, User r103, User r104) {
        this.state = r100;
        this.leftTime = r101;
        this.room = r102;
        this.anchor = r103;
        this.audience = r104;
    }
}
