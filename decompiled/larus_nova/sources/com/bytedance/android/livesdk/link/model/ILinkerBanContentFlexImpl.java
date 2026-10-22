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
@ProtoMessage("webcast.im.LinkerBanContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerBanContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/w5;", "", "Lcom/bytedance/android/livesdk/link/model/IBanUserFlexImpl;", "banUsers$delegate", "Ljava/lang/Object;", "getBanUsers", "()Ljava/util/List;", "banUsers", "", "banType$delegate", "getBanType", "()I", "banType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkerBanContentFlexImpl extends FlexModelBase<w5> implements w5, vh7.h {

    @SerializedName("linkmic_ban_type")
    protected int _$$banType;

    @SerializedName("ban_users")
    protected List<IBanUserFlexImpl> _$$banUsers;

    public ILinkerBanContentFlexImpl() {
        super(w5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.w5
    public final int getBanType() {
        return this._$$banType;
    }

    @Override // com.bytedance.android.livesdk.link.model.w5
    public final List<IBanUserFlexImpl> getBanUsers() {
        return this._$$banUsers;
    }

    public ILinkerBanContentFlexImpl(am3.g r100) {
        super(w5.class);
        this._$$banUsers = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$banUsers.add(new IBanUserFlexImpl(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$banType = r100.i();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }
}
