package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.PluginInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRG\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/PluginInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/e3;", "", "<set-?>", "pluginId$delegate", "Ljava/lang/Object;", "getPluginId", "()J", "setPluginId", "(J)V", "pluginId", "", "", "itemPotentialValueHint$delegate", "getItemPotentialValueHint", "()Ljava/util/Map;", "setItemPotentialValueHint", "(Ljava/util/Map;)V", "itemPotentialValueHint", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PluginInfoFlexImpl extends FlexModelBase<e3> implements e3, vh7.h {

    @SerializedName(e3.KEY_ITEM_POTENTIAL_VALUE_HINT)
    protected Map<String, String> _$$itemPotentialValueHint;

    @SerializedName("plugin_id")
    protected long _$$pluginId;

    public PluginInfoFlexImpl() {
        super(e3.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.e3
    public final Map<String, String> getItemPotentialValueHint() {
        return this._$$itemPotentialValueHint;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e3
    public final long getPluginId() {
        return this._$$pluginId;
    }

    public PluginInfoFlexImpl(am3.g r110) {
        super(e3.class);
        this._$$itemPotentialValueHint = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this._$$pluginId = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L11:
        int r106 = r110.f();
        if (r106 == (-1)) goto L18;
        if (r106 != 1) goto L14;
        r104 = am3.h.c(r110);
        goto L11
    L14:
        if (r106 != 2) goto L15;
        r105 = am3.h.c(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r103);
        Map<String, String> r107 = this._$$itemPotentialValueHint;
        if (r104 == null) goto L25;
        if (r105 == null) goto L23;
        r107.put(r104, r105);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r102, r110);
        goto L3
    L27:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.e3
    public final void setItemPotentialValueHint(Map<String, String> r100) {
        this._$$itemPotentialValueHint = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e3
    public final void setPluginId(long r100) {
        this._$$pluginId = r100;
    }
}
