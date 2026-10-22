package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.LinkmicProfitEggInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/q9;", "", "eggId", "Ljava/lang/String;", "getEggId", "()Ljava/lang/String;", "setEggId", "(Ljava/lang/String;)V", "", "eggType", "I", "getEggType", "()I", "setEggType", "(I)V", "status", "getStatus", "setStatus", "Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggTaskInfo;", "taskInfo", "Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggTaskInfo;", "getTaskInfo", "()Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggTaskInfo;", "setTaskInfo", "(Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggTaskInfo;)V", "Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggRewardInfo;", "rewardInfo", "Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggRewardInfo;", "getRewardInfo", "()Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggRewardInfo;", "setRewardInfo", "(Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggRewardInfo;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicProfitEggInfo extends FlexModelBase<q9> implements q9, vh7.h {
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

    @SerializedName("egg_id")
    protected String eggId;

    @SerializedName("egg_type")
    protected int eggType;

    @SerializedName("reward_info")
    protected LinkmicProfitEggRewardInfo rewardInfo;

    @SerializedName("status")
    protected int status;

    @SerializedName("task_info")
    protected LinkmicProfitEggTaskInfo taskInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LinkmicProfitEggInfo() {
        super(q9.class);
        this.eggId = "";
    }

    @Override // com.bytedance.android.livesdk.message.model.q9
    public /* bridge */ /* synthetic */ s9 getRewardInfo() {
        return getRewardInfo();
    }

    @Override // com.bytedance.android.livesdk.message.model.q9
    public /* bridge */ /* synthetic */ t9 getTaskInfo() {
        return getTaskInfo();
    }

    @Override // com.bytedance.android.livesdk.message.model.q9
    public String getEggId() {
        return this.eggId;
    }

    @Override // com.bytedance.android.livesdk.message.model.q9
    public int getEggType() {
        return this.eggType;
    }

    @Override // com.bytedance.android.livesdk.message.model.q9
    public int getStatus() {
        return this.status;
    }

    @Override // com.bytedance.android.livesdk.message.model.q9
    public LinkmicProfitEggRewardInfo getRewardInfo() {
        return this.rewardInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.q9
    public LinkmicProfitEggTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public LinkmicProfitEggInfo(am3.g r100) {
        super(q9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.eggId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.eggType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.status = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.taskInfo = new LinkmicProfitEggTaskInfo(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.rewardInfo = new LinkmicProfitEggRewardInfo(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this.eggId != null) goto L43;
        this.eggId = "";
        return;
    }

    public void setEggId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eggId = r100;
    }

    public void setEggType(int r100) {
        this.eggType = r100;
    }

    public void setRewardInfo(LinkmicProfitEggRewardInfo r100) {
        this.rewardInfo = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public void setTaskInfo(LinkmicProfitEggTaskInfo r100) {
        this.taskInfo = r100;
    }
}
