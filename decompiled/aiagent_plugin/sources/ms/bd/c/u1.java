package ms.bd.c;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class u1 extends r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.framwork.core.sdkmonitor.h f39662a;

    final class a implements com.bytedance.framwork.core.sdkmonitor.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f39663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f39664b;

        a(JSONObject r1, String r2) {
            this.f39663a = r1;
            this.f39664b = r2;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.h.a
        public final String a() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.h.a
        public final Map<String, String> b() {
            HashMap r2 = new HashMap();
            String r4 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3f886d", new byte[]{45, 114, 78, 94, 26, 118, 49}), String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L9
            if (this.f39663a.getBoolean((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "03cb7a", new byte[]{46, 39, 21, 4, 27, 115, 50}), String.class, "com.obric.aiagent.plugin")) == false) goto L6;
            Object r5 = com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "072223", new byte[]{112});     // Catch: JSONException -> L9
        L7:
            r2.put(r4, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L9
        L10:
            r2.put((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "45ecee", new byte[]{45, 56, 5, 3, 101, 115, 62, 16}), String.class, "com.obric.aiagent.plugin"), this.f39664b);
            return r2;
        L6:
            r5 = com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b30388", new byte[]{35});     // Catch: JSONException -> L9
        L9:
            String r3 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "c3ae8d", new byte[]{97, 52, 31, 46, 0, 96}), String.class, "com.obric.aiagent.plugin");
            goto L10
        }
    }

    public u1() {
    }

    @Override // ms.bd.c.r0
    public final void a(long r11, long r13, String r15, String r16, int r17) {
        com.bytedance.framwork.core.sdkmonitor.h r0 = this.f39662a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r11, r13, r15, null, r16, r17, null);
    }

    @Override // ms.bd.c.r0
    public final void a(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        if (this.f39662a != null) goto L6;
        return;
    L6:
        if (r3.length() <= 0) goto L8;
    L9:
        this.f39662a.a(r2, r3, r4, r5);
        return;
    L8:
        if (r4.length() > 0) goto L9;
    }

    @Override // ms.bd.c.r0
    public final boolean a(String r30) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        String r3 = null;
        if (r30 != null) goto L36;
    L7:
        JSONObject r5 = null;
    L9:
        if (r5 != null) goto L34;
        return false;
    L34:
        String r6 = r5.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "808ae2", new byte[]{58, 54, 64, 42, 91, 44, 63}), String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L30
        r3 = r5.getString((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "3f7991", new byte[]{42, 107, 87, 89, 57, 39, 57, 67}), String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L29
        ArrayList r8 = new ArrayList();     // Catch: JSONException -> L29
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L29
        JSONArray r7 = r5.getJSONArray((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "44109a", new byte[]{38, 57, 76, 66, 15, 113, 2, 39, 76, 115}), String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L29
        JSONArray r4 = r5.getJSONArray((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e18946", new byte[]{102, 54, 91, 66, 25, 53, 83, 34, 69, 122}), String.class, "com.obric.aiagent.plugin"));     // Catch: JSONException -> L29
        int r9 = 0;
    L16:
        if (r9 >= r7.length()) goto L18;
        r8.add(r7.getString(r9));     // Catch: JSONException -> L29
        r9 = r9 + 1;     // Catch: JSONException -> L29
        goto L16
    L18:
        int r10 = 0;
    L20:
        if (r10 >= r4.length()) goto L23;
        r11.add(r4.getString(r10));     // Catch: JSONException -> L29
        r10 = r10 + 1;     // Catch: JSONException -> L29
        goto L20
    L23:
        if (r8.size() > 0) goto L25;
    L28:
        return false;
    L25:
        if (r11.size() <= 0) goto L28;
        SDKMonitorUtils.a(r6, r8);     // Catch: JSONException -> L29
        SDKMonitorUtils.b(r6, r11);     // Catch: JSONException -> L29
    L32:
        r5.remove((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b74736", new byte[]{112, 58, 73, 69, 5, 38, 84, 36, 73, 116}), String.class, "com.obric.aiagent.plugin"));
        r5.remove((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "9d21be", new byte[]{58, 99, 81, 74, 79, 102, 15, 119, 79, 114}), String.class, "com.obric.aiagent.plugin"));
        SDKMonitorUtils.a(r1, r6, r5, new a(r5, r3));
        this.f39662a = SDKMonitorUtils.a(r6);
        return true;
    L29:
        String r0 = r3;
        r3 = r6;
    L31:
        String r12 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "8f5269", new byte[]{58, 97, 75, 121, 0}), String.class, "com.obric.aiagent.plugin");
        r6 = r3;
        r3 = r0;
    L30:
        r0 = null;
        goto L31
    L36:
        r5 = new JSONObject(r30);     // Catch: JSONException -> L6
    L6:
        String r2 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "93a3d5", new byte[]{59, 52, 31}), String.class, "com.obric.aiagent.plugin");
        goto L7
    }

    @Override // ms.bd.c.r0
    public final void b(long r11, long r13, String r15, String r16, int r17) {
        com.bytedance.framwork.core.sdkmonitor.h r0 = this.f39662a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.b(r11, r13, r15, null, r16, r17, null);
    }
}
