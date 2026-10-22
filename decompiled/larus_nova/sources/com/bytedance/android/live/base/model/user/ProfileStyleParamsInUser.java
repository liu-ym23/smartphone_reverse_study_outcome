package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/base/model/user/ProfileStyleParamsInUser;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/d0;", "", "profileStyle", "J", "getProfileStyle", "()J", "setProfileStyle", "(J)V", "smartSwitch", "getSmartSwitch", "setSmartSwitch", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProfileStyleParamsInUser extends FlexModelBase<d0> implements d0, vh7.h {

    @SerializedName("profile_style")
    protected long profileStyle;

    @SerializedName("smart_switch")
    protected long smartSwitch;

    public ProfileStyleParamsInUser() {
        super(d0.class);
    }

    @Override // com.bytedance.android.live.base.model.user.d0
    public long getProfileStyle() {
        return this.profileStyle;
    }

    @Override // com.bytedance.android.live.base.model.user.d0
    public long getSmartSwitch() {
        return this.smartSwitch;
    }

    public ProfileStyleParamsInUser(am3.g r100) {
        super(d0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.profileStyle = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.smartSwitch = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.user.d0
    public void setProfileStyle(long r100) {
        this.profileStyle = r100;
    }

    @Override // com.bytedance.android.live.base.model.user.d0
    public void setSmartSwitch(long r100) {
        this.smartSwitch = r100;
    }
}
