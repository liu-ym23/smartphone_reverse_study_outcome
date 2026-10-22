package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.AssetIdList")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/IAssetIdListFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/j6;", "", "", "ids$delegate", "Ljava/lang/Object;", "getIds", "()Ljava/util/List;", "ids", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAssetIdListFlexImpl extends FlexModelBase<j6> implements j6, vh7.h {

    @SerializedName("ids")
    protected List<Long> _$$ids;

    public IAssetIdListFlexImpl() {
        super(j6.class);
        this._$$ids = $defaultValue_ids$();
    }

    public final List<Long> $defaultValue_ids$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.message.model.j6
    public final List<Long> getIds() {
        return this._$$ids;
    }

    public IAssetIdListFlexImpl(am3.g r100) {
        super(j6.class);
        this._$$ids = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._$$ids.add(Long.valueOf(r100.j()));
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$ids.isEmpty() == false) goto L19;
        this._$$ids = $defaultValue_ids$();
        return;
    }
}
