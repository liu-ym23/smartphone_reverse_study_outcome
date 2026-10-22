package com.bytedance.android.livesdk.link.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.TeamTask.Info")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\u001b\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u000fR\u001b\u0010 \u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTaskInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/r9;", "", "targetUserCount$delegate", "Ljava/lang/Object;", "getTargetUserCount", "()J", "targetUserCount", "finishUserCount$delegate", "getFinishUserCount", "finishUserCount", "", "teamTaskResult$delegate", "getTeamTaskResult", "()I", "teamTaskResult", "Lcom/bytedance/android/livesdk/link/model/ITeamTaskRewardFlexImpl;", "teamTaskReward$delegate", "getTeamTaskReward", "()Lcom/bytedance/android/livesdk/link/model/ITeamTaskRewardFlexImpl;", "teamTaskReward", "ratio$delegate", "getRatio", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "role$delegate", "getRole", "role", "", "progressText$delegate", "getProgressText", "()Ljava/lang/String;", "progressText", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITeamTaskInfoFlexImpl extends FlexModelBase<r9> implements r9, vh7.h {

    @SerializedName("finish_user_count")
    protected long _$$finishUserCount;

    @SerializedName("progress_blur_text")
    protected String _$$progressText;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    protected long _$$ratio;

    @SerializedName("role")
    protected int _$$role;

    @SerializedName("target_user_count")
    protected long _$$targetUserCount;

    @SerializedName("result")
    protected int _$$teamTaskResult;

    @SerializedName("reward")
    protected ITeamTaskRewardFlexImpl _$$teamTaskReward;

    public ITeamTaskInfoFlexImpl() {
        super(r9.class);
        this._$$progressText = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.r9
    public /* bridge */ /* synthetic */ t9 getTeamTaskReward() {
        return getTeamTaskReward();
    }

    @Override // com.bytedance.android.livesdk.link.model.r9
    public final long getFinishUserCount() {
        return this._$$finishUserCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.r9
    public final String getProgressText() {
        return this._$$progressText;
    }

    @Override // com.bytedance.android.livesdk.link.model.r9
    public final long getRatio() {
        return this._$$ratio;
    }

    @Override // com.bytedance.android.livesdk.link.model.r9
    public final int getRole() {
        return this._$$role;
    }

    @Override // com.bytedance.android.livesdk.link.model.r9
    public final long getTargetUserCount() {
        return this._$$targetUserCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.r9
    public final int getTeamTaskResult() {
        return this._$$teamTaskResult;
    }

    @Override // com.bytedance.android.livesdk.link.model.r9
    public final ITeamTaskRewardFlexImpl getTeamTaskReward() {
        return this._$$teamTaskReward;
    }

    public ITeamTaskInfoFlexImpl(am3.g r100) {
        super(r9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 9) goto L7;
        this._$$progressText = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        this._$$role = r100.i();
        goto L3
    L10:
        this._$$ratio = r100.j();
        goto L3
    L11:
        this._$$teamTaskReward = new ITeamTaskRewardFlexImpl(r100);
        goto L3
    L12:
        this._$$teamTaskResult = r100.i();
        goto L3
    L13:
        this._$$finishUserCount = r100.j();
        goto L3
    L14:
        this._$$targetUserCount = r100.j();
        goto L3
    L8:
        am3.h.d(r103, r100);
        goto L3
    L16:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$progressText != null) goto L39;
        this._$$progressText = "";
        return;
    }
}
