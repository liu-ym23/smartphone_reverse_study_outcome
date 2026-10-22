package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.BattleTask")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleTaskFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/g3;", "", "enableTask$delegate", "Ljava/lang/Object;", "getEnableTask", "()Z", "enableTask", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleTaskFlexImpl extends FlexModelBase<g3> implements g3, vh7.h {

    @SerializedName("enable_task")
    protected boolean _$$enableTask;

    public IBattleTaskFlexImpl() {
        super(g3.class);
        this._$$enableTask = false;
    }

    public IBattleTaskFlexImpl(am3.g r100) {
        super(g3.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this._$$enableTask = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & true) == true) goto L19;
        this._$$enableTask = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.g3
    public final boolean getEnableTask() {
        return this._$$enableTask;
    }
}
