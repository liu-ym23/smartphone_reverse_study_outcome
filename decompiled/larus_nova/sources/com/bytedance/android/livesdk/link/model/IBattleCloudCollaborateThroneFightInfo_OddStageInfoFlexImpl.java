package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleCloudCollaborateThroneFightInfo.OddStageInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleCloudCollaborateThroneFightInfo_OddStageInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/w0$b;", "", "Lcom/bytedance/android/livesdk/link/model/IBattleCloudCollaborateThroneFightInfo_SettleUserInfoFlexImpl;", "users$delegate", "Ljava/lang/Object;", "getUsers", "()Ljava/util/List;", "users", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleCloudCollaborateThroneFightInfo_OddStageInfoFlexImpl extends FlexModelBase<w0.b> implements w0.b, vh7.h {

    @SerializedName("users")
    protected List<IBattleCloudCollaborateThroneFightInfo_SettleUserInfoFlexImpl> _$$users;

    public IBattleCloudCollaborateThroneFightInfo_OddStageInfoFlexImpl() {
        super(w0.b.class);
    }

    public IBattleCloudCollaborateThroneFightInfo_OddStageInfoFlexImpl(am3.g r100) {
        super(w0.b.class);
        this._$$users = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._$$users.add(new IBattleCloudCollaborateThroneFightInfo_SettleUserInfoFlexImpl(r100));
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.w0.b
    public final List<IBattleCloudCollaborateThroneFightInfo_SettleUserInfoFlexImpl> getUsers() {
        return this._$$users;
    }
}
