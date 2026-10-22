package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.Tab")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRivalTabFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/q2;", "", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", "title$delegate", "getTitle", "title", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleRivalTabFlexImpl extends FlexModelBase<q2> implements q2, vh7.h {

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("title")
    protected String _$$title;

    public IBattleRivalTabFlexImpl() {
        super(q2.class);
        this._$$name = "";
        this._$$title = "";
    }

    public IBattleRivalTabFlexImpl(am3.g r100) {
        super(q2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$name = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$title = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$name != null) goto L16;
        this._$$name = "";
    L16:
        if (this._$$title != null) goto L28;
        this._$$title = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.q2
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.link.model.q2
    public final String getTitle() {
        return this._$$title;
    }
}
