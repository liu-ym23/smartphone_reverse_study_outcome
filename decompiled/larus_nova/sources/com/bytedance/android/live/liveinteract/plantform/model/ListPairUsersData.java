package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.linkmic_audience.ListPairUsersResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ListPairUsersData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/s;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/h0;", "getUsers", "", "isHasMore", "users", "Ljava/util/List;", "hasMore", "Z", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListPairUsersData extends FlexModelBase<s> implements s, vh7.h {

    @IgnoreProtoFieldCheck
    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("users")
    public List<h0> users;

    public ListPairUsersData() {
        super(s.class);
    }

    public ListPairUsersData(am3.g r100) {
        super(s.class);
        this.users = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.users.add((h0) vh7.f.a(r100, h0.class));
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.s
    public List<h0> getUsers() {
        return this.users;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.s
    public boolean isHasMore() {
        return this.hasMore;
    }
}
