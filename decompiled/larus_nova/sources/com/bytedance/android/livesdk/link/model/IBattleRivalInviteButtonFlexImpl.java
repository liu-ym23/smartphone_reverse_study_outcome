package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleRival.InviteButton")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRivalInviteButtonFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/n2;", "", "description$delegate", "Ljava/lang/Object;", "getDescription", "()Ljava/lang/String;", "description", "", "forbidden$delegate", "getForbidden", "()Z", "forbidden", "", "type$delegate", "getType", "()J", "type", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleRivalInviteButtonFlexImpl extends FlexModelBase<n2> implements n2, vh7.h {

    @SerializedName("description")
    protected String _$$description;

    @SerializedName("forbidden")
    protected boolean _$$forbidden;

    @SerializedName("type")
    protected long _$$type;

    public IBattleRivalInviteButtonFlexImpl() {
        super(n2.class);
        this._$$description = "";
        this._$$forbidden = false;
    }

    @Override // com.bytedance.android.livesdk.link.model.n2
    public final String getDescription() {
        return this._$$description;
    }

    @Override // com.bytedance.android.livesdk.link.model.n2
    public final boolean getForbidden() {
        return this._$$forbidden;
    }

    @Override // com.bytedance.android.livesdk.link.model.n2
    public final long getType() {
        return this._$$type;
    }

    public IBattleRivalInviteButtonFlexImpl(am3.g r100) {
        super(n2.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$description = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$forbidden = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this._$$type = r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$description != null) goto L19;
        this._$$description = "";
    L19:
        if ((r102 & 1) != 0) goto L34;
        this._$$forbidden = false;
        return;
    }
}
