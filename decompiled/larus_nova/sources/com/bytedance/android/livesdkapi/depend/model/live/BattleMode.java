package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BattleMode")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMode;", "", "()V", "mode", "", "getMode", "()I", "setMode", "(I)V", "stealTowerData", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMode$StealTowerData;", "getStealTowerData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMode$StealTowerData;", "setStealTowerData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMode$StealTowerData;)V", "Companion", "StealTowerData", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleMode implements h {
    public static final Companion Companion = null;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_STEAL_TOWER = 1;

    @SerializedName("mode")
    protected int mode;

    @SerializedName("steal_tower_data")
    protected StealTowerData stealTowerData;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMode$Companion;", "", "()V", "MODE_NORMAL", "", "MODE_STEAL_TOWER", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @ProtoMessage("webcast.data.BattleMode.StealTowerData")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001e\u0010'\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\u001e\u0010*\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000f¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMode$StealTowerData;", "", "()V", "mAttackerId", "", "getMAttackerId", "()Ljava/lang/Long;", "setMAttackerId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mCount", "", "getMCount", "()I", "setMCount", "(I)V", "mDuration", "getMDuration", "setMDuration", "mFinishTime", "getMFinishTime", "()J", "setMFinishTime", "(J)V", "mIsAttackerWon", "getMIsAttackerWon", "setMIsAttackerWon", "mIsFinished", "", "getMIsFinished", "()Z", "setMIsFinished", "(Z)V", "mOpenScore", "getMOpenScore", "setMOpenScore", "mStartTime", "getMStartTime", "setMStartTime", "mTargetScore", "getMTargetScore", "setMTargetScore", "mTriggerTime", "getMTriggerTime", "setMTriggerTime", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    @IgnoreProtoFieldCheck
    public static final class StealTowerData implements h {

        @SerializedName("attacker_id")
        protected Long mAttackerId;

        @SerializedName("count")
        protected int mCount;

        @SerializedName("duration")
        protected int mDuration;

        @SerializedName("finish_time")
        protected long mFinishTime;

        @SerializedName("win")
        protected int mIsAttackerWon;

        @SerializedName(VideoEventOneOutSync.END_TYPE_FINISH)
        protected boolean mIsFinished;

        @SerializedName("open_score")
        protected int mOpenScore;

        @SerializedName(ILoadStallMonitor.START_TIME)
        protected long mStartTime;

        @SerializedName("target_score")
        protected int mTargetScore;

        @SerializedName("trigger_time")
        protected int mTriggerTime;

        public StealTowerData() {
        }

        public final Long getMAttackerId() {
            return this.mAttackerId;
        }

        public final int getMCount() {
            return this.mCount;
        }

        public final int getMDuration() {
            return this.mDuration;
        }

        public final long getMFinishTime() {
            return this.mFinishTime;
        }

        public final int getMIsAttackerWon() {
            return this.mIsAttackerWon;
        }

        public final boolean getMIsFinished() {
            return this.mIsFinished;
        }

        public final int getMOpenScore() {
            return this.mOpenScore;
        }

        public final long getMStartTime() {
            return this.mStartTime;
        }

        public final int getMTargetScore() {
            return this.mTargetScore;
        }

        public final int getMTriggerTime() {
            return this.mTriggerTime;
        }

        public StealTowerData(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L17;
            switch(r102) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            this.mIsFinished = am3.h.a(r100);
            goto L3
        L8:
            this.mOpenScore = (int) r100.j();
            goto L3
        L9:
            this.mCount = (int) r100.j();
            goto L3
        L10:
            this.mIsAttackerWon = (int) r100.j();
            goto L3
        L11:
            this.mFinishTime = r100.j();
            goto L3
        L12:
            this.mAttackerId = Long.valueOf(r100.j());
            goto L3
        L13:
            this.mStartTime = r100.j();
            goto L3
        L14:
            this.mTargetScore = (int) r100.j();
            goto L3
        L15:
            this.mDuration = (int) r100.j();
            goto L3
        L16:
            this.mTriggerTime = (int) r100.j();
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L17:
            r100.d(r101);
        }

        public final void setMAttackerId(Long r100) {
            this.mAttackerId = r100;
        }

        public final void setMCount(int r100) {
            this.mCount = r100;
        }

        public final void setMDuration(int r100) {
            this.mDuration = r100;
        }

        public final void setMFinishTime(long r100) {
            this.mFinishTime = r100;
        }

        public final void setMIsAttackerWon(int r100) {
            this.mIsAttackerWon = r100;
        }

        public final void setMIsFinished(boolean r100) {
            this.mIsFinished = r100;
        }

        public final void setMOpenScore(int r100) {
            this.mOpenScore = r100;
        }

        public final void setMStartTime(long r100) {
            this.mStartTime = r100;
        }

        public final void setMTargetScore(int r100) {
            this.mTargetScore = r100;
        }

        public final void setMTriggerTime(int r100) {
            this.mTriggerTime = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BattleMode() {
    }

    public final int getMode() {
        return this.mode;
    }

    public final StealTowerData getStealTowerData() {
        return this.stealTowerData;
    }

    public BattleMode(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.mode = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.stealTowerData = new StealTowerData(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setMode(int r100) {
        this.mode = r100;
    }

    public final void setStealTowerData(StealTowerData r100) {
        this.stealTowerData = r100;
    }
}
