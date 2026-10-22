package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/SameTypePKStrategy;", "", "()V", "judgeActionDefeated", "", "getJudgeActionDefeated", "()Ljava/lang/Long;", "setJudgeActionDefeated", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "judgeActionHigher", "getJudgeActionHigher", "setJudgeActionHigher", "judgeActionLower", "getJudgeActionLower", "setJudgeActionLower", "judgeActionSame", "getJudgeActionSame", "setJudgeActionSame", "priority", "getPriority", "()J", "setPriority", "(J)V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SameTypePKStrategy implements h {
    public static final Companion Companion = null;
    public static final long JUDGE_ACTION_DELAY = 0;
    public static final long JUDGE_ACTION_INTERRUPT = 1;
    public static final long JUDGE_ACTION_THROW = 2;

    @SerializedName("judge_action_defeated")
    protected Long judgeActionDefeated;

    @SerializedName("judge_action_higher")
    protected Long judgeActionHigher;

    @SerializedName("judge_action_lower")
    protected Long judgeActionLower;

    @SerializedName("judge_action_same")
    protected Long judgeActionSame;

    @SerializedName("priority")
    protected long priority;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/SameTypePKStrategy$Companion;", "", "()V", "JUDGE_ACTION_DELAY", "", "JUDGE_ACTION_INTERRUPT", "JUDGE_ACTION_THROW", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    public SameTypePKStrategy() {
        this.priority = -1990;
    }

    public final Long getJudgeActionDefeated() {
        return this.judgeActionDefeated;
    }

    public final Long getJudgeActionHigher() {
        return this.judgeActionHigher;
    }

    public final Long getJudgeActionLower() {
        return this.judgeActionLower;
    }

    public final Long getJudgeActionSame() {
        return this.judgeActionSame;
    }

    public final long getPriority() {
        return this.priority;
    }

    public SameTypePKStrategy(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this.priority = r100.j();
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.judgeActionHigher = Long.valueOf(r100.j());
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.judgeActionSame = Long.valueOf(r100.j());
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.judgeActionLower = Long.valueOf(r100.j());
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this.judgeActionDefeated = Long.valueOf(r100.j());
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if ((r102 & true) == true) goto L42;
        this.priority = -1990;
        return;
    }

    public final void setJudgeActionDefeated(Long r100) {
        this.judgeActionDefeated = r100;
    }

    public final void setJudgeActionHigher(Long r100) {
        this.judgeActionHigher = r100;
    }

    public final void setJudgeActionLower(Long r100) {
        this.judgeActionLower = r100;
    }

    public final void setJudgeActionSame(Long r100) {
        this.judgeActionSame = r100;
    }

    public final void setPriority(long r100) {
        this.priority = r100;
    }
}
