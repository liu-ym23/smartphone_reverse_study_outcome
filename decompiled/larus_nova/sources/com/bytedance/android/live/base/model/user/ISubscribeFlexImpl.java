package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User.Subscribe")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\f\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u000bR\u001b\u0010\u0015\u001a\u00020\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/model/user/ISubscribeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/g0;", "", "isMember$delegate", "Ljava/lang/Object;", "isMember", "()Z", "", "level$delegate", "getLevel", "()J", "level", "identityType$delegate", "getIdentityType", "identityType", "buyType$delegate", "getBuyType", "buyType", "open$delegate", "getOpen", "open", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ISubscribeFlexImpl extends FlexModelBase<g0> implements g0, vh7.h {

    @SerializedName("buy_type")
    protected long _$$buyType;

    @SerializedName("identity_type")
    protected long _$$identityType;

    @SerializedName("is_member")
    protected boolean _$$isMember;

    @SerializedName("level")
    protected long _$$level;

    @SerializedName("open")
    protected long _$$open;

    public ISubscribeFlexImpl() {
        super(g0.class);
        this._$$isMember = false;
    }

    @Override // com.bytedance.android.live.base.model.user.g0
    public final long getBuyType() {
        return this._$$buyType;
    }

    @Override // com.bytedance.android.live.base.model.user.g0
    public final long getIdentityType() {
        return this._$$identityType;
    }

    @Override // com.bytedance.android.live.base.model.user.g0
    public final long getLevel() {
        return this._$$level;
    }

    @Override // com.bytedance.android.live.base.model.user.g0
    public final long getOpen() {
        return this._$$open;
    }

    @Override // com.bytedance.android.live.base.model.user.g0
    public final boolean isMember() {
        return this._$$isMember;
    }

    public ISubscribeFlexImpl(am3.g r100) {
        super(g0.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$isMember = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$level = r100.j();
        r102 = r102 | 2;
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this._$$identityType = r100.j();
        r102 = r102 | 4;
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this._$$buyType = r100.j();
        r102 = r102 | 8;
        goto L3
    L14:
        if (r103 != 5) goto L15;
        this._$$open = r100.j();
        r102 = r102 | 16;
        goto L3
    L15:
        am3.h.d(r104, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L43;
        this._$$isMember = false;
        return;
    }
}
