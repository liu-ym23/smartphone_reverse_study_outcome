package b8a;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class n extends l {
    public n(HashMap<String, Object> r110) {
        super(r110);
        m.d(r110, LocationMonitorConst.IDENTIFIER);
        Double r100 = Double.valueOf(-1.0d);
        m.b(r110, "pipelineStart", r100).doubleValue();
        m.b(r110, "pipelineEnd", r100).doubleValue();
        m.b(r110, "mtsRenderStart", r100).doubleValue();
        m.b(r110, "mtsRenderEnd", r100).doubleValue();
        m.b(r110, "resolveStart", r100).doubleValue();
        m.b(r110, "resolveEnd", r100).doubleValue();
        m.b(r110, "layoutStart", r100).doubleValue();
        m.b(r110, "layoutEnd", r100).doubleValue();
        m.b(r110, "paintingUiOperationExecuteStart", r100).doubleValue();
        m.b(r110, "paintingUiOperationExecuteEnd", r100).doubleValue();
        m.b(r110, "layoutUiOperationExecuteStart", r100).doubleValue();
        m.b(r110, "layoutUiOperationExecuteEnd", r100).doubleValue();
        m.b(r110, "paintEnd", r100).doubleValue();
        if (r110.get("frameworkRenderingTiming") == null) goto L5;
        HashMap r101 = (HashMap) r110.get("frameworkRenderingTiming");
    L7:
        if (r110.get("hostPlatformTiming") == null) goto L9;
        HashMap r102 = (HashMap) r110.get("hostPlatformTiming");
    L10:
        m.d(r102, "hostPlatformType");
        m.b(r102, "measureStart", r100).doubleValue();
        m.b(r102, "measureEnd", r100).doubleValue();
        m.b(r102, "layoutStart", r100).doubleValue();
        m.b(r102, "layoutEnd", r100).doubleValue();
        m.b(r102, "drawStart", r100).doubleValue();
        m.b(r102, "drawEnd", r100).doubleValue();
        if (r110.get("actualFmp") == null) goto L14;
        HashMap r103 = (HashMap) r110.get("actualFmp");
        m.d(r103, "name");
        m.b(r103, "duration", r100).doubleValue();
        m.d(r103, "startTimestampName");
        m.b(r103, "startTimestamp", r100).doubleValue();
        m.d(r103, "endTimestampName");
        m.b(r103, "endTimestamp", r100).doubleValue();
    L14:
        if (r110.get("lynxActualFmp") == null) goto L17;
        HashMap r104 = (HashMap) r110.get("lynxActualFmp");
        m.d(r104, "name");
        m.b(r104, "duration", r100).doubleValue();
        m.d(r104, "startTimestampName");
        m.b(r104, "startTimestamp", r100).doubleValue();
        m.d(r104, "endTimestampName");
        m.b(r104, "endTimestamp", r100).doubleValue();
    L17:
        if (r110.get("totalActualFmp") == null) goto L20;
        HashMap r111 = (HashMap) r110.get("totalActualFmp");
        m.d(r111, "name");
        m.b(r111, "duration", r100).doubleValue();
        m.d(r111, "startTimestampName");
        m.b(r111, "startTimestamp", r100).doubleValue();
        m.d(r111, "endTimestampName");
        m.b(r111, "endTimestamp", r100).doubleValue();
        return;
    L20:
        return;
    L9:
        r102 = new HashMap();
        goto L10
    L5:
        new HashMap();
        goto L7
    }
}
