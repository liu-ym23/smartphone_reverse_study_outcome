package ms.bd.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class a2 implements com.bytedance.frameworks.baselib.network.http.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b2 f39451a;

    a2(b2 r1) {
        this.f39451a = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.g.b
    public final Map<String, String> a(String r20, Map<String, List<String>> r21) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        HashMap r7 = new HashMap();
        if (r20 == null) goto L39;
        if (r1 == null) goto L39;
        String r2 = r20.toLowerCase();
        if (r2.contains((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "9c45b0", new byte[]{32, 117, 83, 81}), String.class, "com.obric.aiagent.plugin")) == false) goto L9;
    L15:
        v1.a().b();
        ArrayList r5 = new ArrayList();
        Iterator r3 = r1.entrySet().iterator();
    L16:
        String[] r10 = null;
        String r11 = null;
        r11 = null;
        int r12 = 0;
        if (r3.hasNext() == false) goto L27;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r9.getValue() != null) goto L21;
    L23:
        if (r13 == null) goto L16;
        if (r11 == null) goto L16;
        r5.add(r13);
        r5.add(r11);
        goto L16
    L21:
        if (((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.aiagent.plugin")).size() <= 0) goto L23;
        r11 = (String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.aiagent.plugin")).get(0), String.class, "com.obric.aiagent.plugin");
        goto L23
    L27:
        if (r2.startsWith((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1bc9cf", new byte[]{40, 116, 4, 93}), String.class, "com.obric.aiagent.plugin")) == false) goto L30;
        String[] r6 = (String[]) ZeusTransformUtils.preCheckCast(r5.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        Object r0 = com.bytedance.mobsec.matrix.a.a(50331649, 0, b2.a(this.f39451a), r20, r6);
    L32:
        r10 = (String[]) ZeusTransformUtils.preCheckCast(r0, String[].class, "com.obric.aiagent.plugin");
    L33:
        if (r10 == null) goto L39;
        HashMap r4 = new HashMap();
    L36:
        if (r12 >= r10.length) goto L38;
        r4.put(r10[r12], r10[r12 + 1]);
        r12 = r12 + 2;
        goto L36
    L38:
        return r4;
    L30:
        if (r2.startsWith((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6a166f", new byte[]{48, 112}), String.class, "com.obric.aiagent.plugin")) == false) goto L33;
        r5.add((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "acbf43", new byte[]{69, 83, 61}), String.class, "com.obric.aiagent.plugin"));
        r5.add(r20);
        String[] r17 = (String[]) ZeusTransformUtils.preCheckCast(r5.toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        r0 = com.bytedance.mobsec.matrix.a.a(100663297, 0, b2.a(this.f39451a), null, r17);
        goto L32
    L9:
        if (r2.contains((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "653837", new byte[]{47, 35, 84, 92, 31}), String.class, "com.obric.aiagent.plugin")) == true) goto L15;
        if (r2.contains((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b918b2", new byte[]{100, 40}), String.class, "com.obric.aiagent.plugin")) == true) goto L15;
        throw new RuntimeException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a767d0", new byte[]{121, 33, 5, 78, 78, 52, 118, 86, 101, 98, 48, 61, 81, 87, 75, 104, 106, 2, 115, 119, 99, 122, 82, 80, 72}), String.class, "com.obric.aiagent.plugin"));
    L39:
        return r7;
    }
}
