package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.TopEffectMessage.Extra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR)\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ITopEffectExtraFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/bc;", "", "", "paramsMap$delegate", "Ljava/lang/Object;", "getParamsMap", "()Ljava/util/Map;", "paramsMap", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITopEffectExtraFlexImpl extends FlexModelBase<bc> implements bc, vh7.h {

    @SerializedName("params")
    protected Map<String, String> _$$paramsMap;

    public ITopEffectExtraFlexImpl() {
        super(bc.class);
    }

    public ITopEffectExtraFlexImpl(am3.g r110) {
        super(bc.class);
        this._$$paramsMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L7;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = am3.h.c(r110);
        goto L9
    L13:
        if (r106 != 2) goto L14;
        r105 = am3.h.c(r110);
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r103);
        Map<String, String> r107 = this._$$paramsMap;
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
    }

    @Override // com.bytedance.android.livesdk.message.model.bc
    public final Map<String, String> getParamsMap() {
        return this._$$paramsMap;
    }
}
