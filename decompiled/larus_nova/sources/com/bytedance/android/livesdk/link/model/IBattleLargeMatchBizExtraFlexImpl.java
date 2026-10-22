package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.im.LargeMatchBizExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleLargeMatchBizExtraFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/o1;", "", "Lcom/bytedance/android/livesdk/link/model/IBattleLargeMatchUserFlexImpl;", "inviteUsers$delegate", "Ljava/lang/Object;", "getInviteUsers", "()Ljava/util/List;", "inviteUsers", "", "matchType$delegate", "getMatchType", "()J", "matchType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleLargeMatchBizExtraFlexImpl extends FlexModelBase<o1> implements o1, vh7.h {

    @SerializedName("users")
    protected List<IBattleLargeMatchUserFlexImpl> _$$inviteUsers;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    protected long _$$matchType;

    public IBattleLargeMatchBizExtraFlexImpl() {
        super(o1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.o1
    public final List<IBattleLargeMatchUserFlexImpl> getInviteUsers() {
        return this._$$inviteUsers;
    }

    @Override // com.bytedance.android.livesdk.link.model.o1
    public final long getMatchType() {
        return this._$$matchType;
    }

    public IBattleLargeMatchBizExtraFlexImpl(am3.g r100) {
        super(o1.class);
        this._$$inviteUsers = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$inviteUsers.add(new IBattleLargeMatchUserFlexImpl(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$matchType = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }
}
