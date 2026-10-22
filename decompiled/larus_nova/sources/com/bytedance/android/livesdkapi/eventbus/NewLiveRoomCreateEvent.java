package com.bytedance.android.livesdkapi.eventbus;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/eventbus/NewLiveRoomCreateEvent;", "", "()V", "fragmentCode", "", "getFragmentCode", "()Ljava/lang/Integer;", "setFragmentCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isEnternalMode", "", "()Ljava/lang/Boolean;", "setEnternalMode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "needFinishActivity", "getNeedFinishActivity", "setNeedFinishActivity", "roomId", "", "getRoomId", "()Ljava/lang/Long;", "setRoomId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewLiveRoomCreateEvent {
    private Integer fragmentCode;
    private Boolean isEnternalMode;
    private Boolean needFinishActivity;
    private Long roomId;

    public NewLiveRoomCreateEvent() {
        Boolean r100 = Boolean.FALSE;
        this.isEnternalMode = r100;
        this.needFinishActivity = r100;
    }

    public final Integer getFragmentCode() {
        return this.fragmentCode;
    }

    public final Boolean getNeedFinishActivity() {
        return this.needFinishActivity;
    }

    public final Long getRoomId() {
        return this.roomId;
    }

    public final Boolean isEnternalMode() {
        return this.isEnternalMode;
    }

    public final void setEnternalMode(Boolean r100) {
        this.isEnternalMode = r100;
    }

    public final void setFragmentCode(Integer r100) {
        this.fragmentCode = r100;
    }

    public final void setNeedFinishActivity(Boolean r100) {
        this.needFinishActivity = r100;
    }

    public final void setRoomId(Long r100) {
        this.roomId = r100;
    }
}
