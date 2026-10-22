package com.bytedance.android.marketing.sdk.impl.hybrid.bridge;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements XBaseResultModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f162809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f162810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f162811c;

    @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("data", toJSON());
        return r100;
    }

    @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
    public final JSONObject toJSON() {
        JSONObject r100 = new JSONObject();
        r100.put("state", this.f162809a);
        r100.put(LocationMonitorConst.ERR_MSG, this.f162810b);
        r100.put("data", this.f162811c);
        return r100;
    }

    public b(int r100, String r101, JSONObject r102) {
        this.f162809a = r100;
        this.f162810b = r101;
        this.f162811c = r102;
    }
}
