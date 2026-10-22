package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.PreviewExtendArea.ActionConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R,\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ActionConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IActionConfig;", "()V", "actionParam", "", "", "getActionParam", "()Ljava/util/Map;", "setActionParam", "(Ljava/util/Map;)V", "areaAction", "", "getAreaAction", "()Ljava/lang/Integer;", "setAreaAction", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
@IgnoreProtoFieldCheck
public final class ActionConfig extends FlexModelBase<IActionConfig> implements IActionConfig, h {

    @SerializedName("actionPrams")
    protected Map<String, String> actionParam;

    @SerializedName("areaAction")
    protected Integer areaAction;

    public ActionConfig() {
        super(IActionConfig.class);
        this.areaAction = 0;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IActionConfig
    public Map<String, String> getActionParam() {
        return this.actionParam;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IActionConfig
    public Integer getAreaAction() {
        return this.areaAction;
    }

    public ActionConfig(g r110) {
        super(IActionConfig.class);
        this.actionParam = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this.areaAction = Integer.valueOf(r110.i());
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L11:
        int r111 = r110.f();
        if (r111 == (-1)) goto L18;
        if (r111 != 1) goto L14;
        r104 = am3.h.c(r110);
        goto L11
    L14:
        if (r111 != 2) goto L15;
        r105 = am3.h.c(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r103);
        Map<String, String> r106 = this.actionParam;
        if (r104 == null) goto L25;
        if (r105 == null) goto L23;
        r106.put(r104, r105);
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
        if (this.areaAction != null) goto L51;
        this.areaAction = 0;
        return;
    }

    public void setActionParam(Map<String, String> r100) {
        this.actionParam = r100;
    }

    public void setAreaAction(Integer r100) {
        this.areaAction = r100;
    }
}
