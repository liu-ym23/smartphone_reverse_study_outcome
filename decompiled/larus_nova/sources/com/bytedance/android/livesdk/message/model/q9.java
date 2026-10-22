package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bR\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/q9;", "Lvh7/c;", "", "getEggId", "()Ljava/lang/String;", "getEggId$annotations", "()V", "eggId", "", "getEggType", "()I", "getEggType$annotations", "eggType", "getStatus", "getStatus$annotations", "status", "Lcom/bytedance/android/livesdk/message/model/t9;", "getTaskInfo", "()Lcom/bytedance/android/livesdk/message/model/t9;", "getTaskInfo$annotations", "taskInfo", "Lcom/bytedance/android/livesdk/message/model/s9;", "getRewardInfo", "()Lcom/bytedance/android/livesdk/message/model/s9;", "getRewardInfo$annotations", "rewardInfo", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q9 extends vh7.c<q9> {
    public static final a Companion = null;
    public static final int LinkmicProfitEggType_Score = 1;
    public static final int LinkmicProfitEggType_UV = 2;
    public static final int LinkmicProfitEggType_Unknown = 0;
    public static final int StatusProfitEgg_Challenging = 2;
    public static final int StatusProfitEgg_Fail = 5;
    public static final int StatusProfitEgg_Finish = 7;
    public static final int StatusProfitEgg_Rewarding = 6;
    public static final int StatusProfitEgg_Success = 4;
    public static final int StatusProfitEgg_Unknown = 0;
    public static final int StatusProfitEgg_WaitingForSettle = 3;
    public static final int StatusProfitEgg_WaitingForStart = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f153684a = null;

        public a() {
        }

        static {
            f153684a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f153684a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "egg_id")
    String getEggId();

    @FieldName(name = "egg_type")
    int getEggType();

    @FieldName(name = "reward_info")
    s9 getRewardInfo();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "task_info")
    t9 getTaskInfo();
}
