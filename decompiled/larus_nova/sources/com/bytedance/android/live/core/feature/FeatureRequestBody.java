package com.bytedance.android.live.core.feature;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/feature/FeatureRequestBody;", "", "userInfos", "", "Lcom/bytedance/android/live/core/feature/RoomInfoItem;", "(Ljava/util/List;)V", "getUserInfos", "()Ljava/util/List;", "setUserInfos", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeatureRequestBody {

    @SerializedName("user_infos")
    private List<RoomInfoItem> userInfos;

    /* JADX WARN: Multi-variable type inference failed */
    public FeatureRequestBody() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List<RoomInfoItem> getUserInfos() {
        return this.userInfos;
    }

    public FeatureRequestBody(List<RoomInfoItem> r100) {
        this.userInfos = r100;
    }

    public final void setUserInfos(List<RoomInfoItem> r100) {
        this.userInfos = r100;
    }

    public /* synthetic */ FeatureRequestBody(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
