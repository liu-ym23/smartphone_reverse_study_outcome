package com.bytedance.android.live.core.resources;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.gift.DynamicControl")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eRC\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/core/resources/DynamicControlFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/core/resources/d;", "", "", "<set-?>", "downloadTypeMap$delegate", "Ljava/lang/Object;", "getDownloadTypeMap", "()Ljava/util/Map;", "setDownloadTypeMap", "(Ljava/util/Map;)V", "downloadTypeMap", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicControlFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("download_type")
    protected Map<Integer, Integer> _$$downloadTypeMap;

    public DynamicControlFlexImpl() {
        super(d.class);
        this._$$downloadTypeMap = $defaultValue_downloadTypeMap$();
    }

    public final Map<Integer, Integer> $defaultValue_downloadTypeMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.live.core.resources.d
    public final Map<Integer, Integer> getDownloadTypeMap() {
        return this._$$downloadTypeMap;
    }

    public DynamicControlFlexImpl(am3.g r110) {
        super(d.class);
        this._$$downloadTypeMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L7;
        long r103 = r110.c();
        Integer r104 = null;
        Integer r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = Integer.valueOf(r110.i());
        goto L9
    L13:
        if (r106 != 2) goto L14;
        r105 = Integer.valueOf(r110.i());
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r103);
        Map<Integer, Integer> r107 = this._$$downloadTypeMap;
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r107.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r102, r110);
        goto L3
    L25:
        r110.d(r100);
        setThreadSafe(true);
        if (this._$$downloadTypeMap != null) goto L46;
        this._$$downloadTypeMap = $defaultValue_downloadTypeMap$();
        return;
    }

    @Override // com.bytedance.android.live.core.resources.d
    public final void setDownloadTypeMap(Map<Integer, Integer> r100) {
        this._$$downloadTypeMap = r100;
    }
}
