package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewExtendAreaSyncData.ActionConfig")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewAreaActionConfig;", "", "()V", "actionParam", "", "", "getActionParam", "()Ljava/util/Map;", "setActionParam", "(Ljava/util/Map;)V", "areaAction", "", "getAreaAction", "()Ljava/lang/Integer;", "setAreaAction", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewAreaActionConfig implements h {

    @SerializedName("actionPrams")
    protected Map<String, String> actionParam;

    @SerializedName("areaAction")
    protected Integer areaAction;

    public PreviewAreaActionConfig() {
        this.areaAction = 0;
    }

    public final Map<String, String> getActionParam() {
        return this.actionParam;
    }

    public final Integer getAreaAction() {
        return this.areaAction;
    }

    public PreviewAreaActionConfig(g r110) {
        this.actionParam = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        if (r101 != 1) goto L8;
        this.areaAction = Integer.valueOf(r110.i());
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = am3.h.c(r110);
        goto L11
    L14:
        if (r105 != 2) goto L15;
        r104 = am3.h.c(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r102);
        Map<String, String> r106 = this.actionParam;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r110);
        goto L3
    L27:
        r110.d(r100);
        if (this.areaAction != null) goto L51;
        this.areaAction = 0;
        return;
    }

    public final void setActionParam(Map<String, String> r100) {
        this.actionParam = r100;
    }

    public final void setAreaAction(Integer r100) {
        this.areaAction = r100;
    }
}
