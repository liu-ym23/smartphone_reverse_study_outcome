package com.bytedance.android.livesdkapi.eventbus;

import android.os.Bundle;

/* JADX INFO: loaded from: classes12.dex */
public class JumpToOtherRoomEvent {
    public Bundle enterExtra;
    public String enterLiveSource;
    public boolean forceNewActivityWhenJumpRoom;
    public boolean isBackPreRoom;
    public boolean isMicRoomJump;
    public String jumpSource;
    public long roomId;
    public boolean sameRoomRefresh;
    public String source;
    public String sourceBtmToken;

    public JumpToOtherRoomEvent(long r100) {
        this.sameRoomRefresh = false;
        this.isMicRoomJump = false;
        this.forceNewActivityWhenJumpRoom = false;
        this.roomId = r100;
    }

    public JumpToOtherRoomEvent(long r100, Bundle r101) {
        this.sameRoomRefresh = false;
        this.isMicRoomJump = false;
        this.forceNewActivityWhenJumpRoom = false;
        this.roomId = r100;
        this.enterExtra = r101;
    }

    public JumpToOtherRoomEvent(long r100, Bundle r101, boolean r102) {
        this.sameRoomRefresh = false;
        this.isMicRoomJump = false;
        this.forceNewActivityWhenJumpRoom = false;
        this.roomId = r100;
        this.enterExtra = r101;
        this.isBackPreRoom = r102;
    }

    public JumpToOtherRoomEvent(long r100, String r101, Bundle r102) {
        this.sameRoomRefresh = false;
        this.isMicRoomJump = false;
        this.forceNewActivityWhenJumpRoom = false;
        this.roomId = r100;
        this.enterLiveSource = r101;
        this.enterExtra = r102;
    }

    public JumpToOtherRoomEvent(long r100, String r101, Bundle r102, String r103) {
        this.sameRoomRefresh = false;
        this.isMicRoomJump = false;
        this.forceNewActivityWhenJumpRoom = false;
        this.roomId = r100;
        this.enterLiveSource = r101;
        this.enterExtra = r102;
        this.jumpSource = r103;
    }

    public JumpToOtherRoomEvent(long r100, Bundle r101, boolean r102, boolean r103) {
        this.isMicRoomJump = false;
        this.forceNewActivityWhenJumpRoom = false;
        this.roomId = r100;
        this.enterExtra = r101;
        this.isBackPreRoom = r102;
        this.sameRoomRefresh = r103;
    }
}
