package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User.PoiInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\"\u0010 \u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/base/model/user/PoiInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lpy/q;", "", "isPoiPermission", "isFollowPermission", "poiPermission", "Z", "getPoiPermission", "()Z", "setPoiPermission", "(Z)V", "", "poiId", "J", "getPoiId", "()J", "setPoiId", "(J)V", "", "poiName", "Ljava/lang/String;", "getPoiName", "()Ljava/lang/String;", "setPoiName", "(Ljava/lang/String;)V", "poiIdStr", "getPoiIdStr", "setPoiIdStr", "followerCountPermission", "getFollowerCountPermission", "setFollowerCountPermission", "whiteUserPermission", "getWhiteUserPermission", "setWhiteUserPermission", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PoiInfo extends FlexModelBase<py.q> implements py.q, vh7.h {

    @SerializedName("follower_count_permission")
    protected long followerCountPermission;

    @SerializedName("poi_id")
    protected long poiId;

    @SerializedName("poi_id_str")
    protected String poiIdStr;

    @SerializedName("poi_name")
    protected String poiName;

    @SerializedName("is_poi_enabled")
    protected boolean poiPermission;

    @SerializedName("white_user_permission")
    protected long whiteUserPermission;

    public PoiInfo() {
        super(py.q.class);
    }

    @Override // py.q
    public boolean isFollowPermission() {
        if (this.followerCountPermission != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // py.q
    public boolean isPoiPermission() {
        if (this.poiPermission == false) goto L5;
    L8:
        return true;
    L5:
        if (this.whiteUserPermission == 1) goto L8;
        return false;
    }

    public final long getFollowerCountPermission() {
        return this.followerCountPermission;
    }

    @Override // py.q
    public long getPoiId() {
        return this.poiId;
    }

    @Override // py.q
    public String getPoiIdStr() {
        return this.poiIdStr;
    }

    @Override // py.q
    public String getPoiName() {
        return this.poiName;
    }

    public final boolean getPoiPermission() {
        return this.poiPermission;
    }

    public final long getWhiteUserPermission() {
        return this.whiteUserPermission;
    }

    public PoiInfo(am3.g r100) {
        super(py.q.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.whiteUserPermission = r100.j();
        goto L3
    L9:
        this.followerCountPermission = r100.j();
        goto L3
    L10:
        this.poiIdStr = am3.h.c(r100);
        goto L3
    L11:
        this.poiName = am3.h.c(r100);
        goto L3
    L12:
        this.poiId = r100.j();
        goto L3
    L13:
        this.poiPermission = am3.h.a(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setFollowerCountPermission(long r100) {
        this.followerCountPermission = r100;
    }

    @Override // py.q
    public void setPoiId(long r100) {
        this.poiId = r100;
    }

    @Override // py.q
    public void setPoiIdStr(String r100) {
        this.poiIdStr = r100;
    }

    @Override // py.q
    public void setPoiName(String r100) {
        this.poiName = r100;
    }

    public final void setPoiPermission(boolean r100) {
        this.poiPermission = r100;
    }

    public final void setWhiteUserPermission(long r100) {
        this.whiteUserPermission = r100;
    }
}
