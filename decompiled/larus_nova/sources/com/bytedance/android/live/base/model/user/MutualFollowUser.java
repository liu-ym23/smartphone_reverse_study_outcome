package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/user/MutualFollowUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/IMutualFollowUser;", "()V", "nickName", "", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MutualFollowUser extends FlexModelBase<IMutualFollowUser> implements IMutualFollowUser, vh7.h {

    @SerializedName("nick_name")
    protected String nickName;

    public MutualFollowUser() {
        super(IMutualFollowUser.class);
    }

    public MutualFollowUser(am3.g r100) {
        super(IMutualFollowUser.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.nickName = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.user.IMutualFollowUser
    public String getNickName() {
        return this.nickName;
    }

    @Override // com.bytedance.android.live.base.model.user.IMutualFollowUser
    public void setNickName(String r100) {
        this.nickName = r100;
    }
}
