package com.bytedance.android.livesdkapi.depend.live;

import jm1.d;

/* JADX INFO: loaded from: classes12.dex */
public interface IRoomAction {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.depend.live.IRoomAction$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$delegateDislike(IRoomAction r100, long r101) {
            return false;
        }

        public static boolean $default$delegateUserClose(IRoomAction r100, boolean r101, String r102) {
            return false;
        }
    }

    public static class ReplayDelegate implements IRoomAction {
        private final d mReplayRoomAction;

        @Override // com.bytedance.android.livesdkapi.depend.live.IRoomAction
        public final /* synthetic */ boolean delegateDislike(long r100) {
            return CC.$default$delegateDislike(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.IRoomAction
        public final /* synthetic */ boolean delegateUserClose(boolean r100, String r101) {
            return CC.$default$delegateUserClose(this, r100, r101);
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.IRoomAction
        public void exitRoom() {
            this.mReplayRoomAction.exitRoom();
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.IRoomAction
        public boolean interceptRoomClose() {
            return this.mReplayRoomAction.interceptRoomClose();
        }

        public ReplayDelegate(d r100) {
            this.mReplayRoomAction = r100;
        }
    }

    boolean delegateDislike(long r100);

    boolean delegateUserClose(boolean r100, String r101);

    void exitRoom();

    boolean interceptRoomClose();
}
