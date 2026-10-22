package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.ak;
import com.google.protobuf.DescriptorProtos;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class l2 extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.retrofit2.d.b f39547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f39548b;

    final class a implements com.bytedance.retrofit2.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l2 f39549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, String> f39550b;

        /* JADX INFO: renamed from: ms.bd.c.l2$a$a, reason: collision with other inner class name */
        final class C1067a extends HashMap<String, String> {
            C1067a() {
                put("cashloan", "caijing_apl_cashloan");
                put("transfer", "caijing_apl_transfer");
                put("redpacket", "caijing_apl_redpacket");
            }
        }

        a(l2 r1) {
            this.f39549a = r1;
            this.f39550b = new C1067a();
        }

        private void a(String r5, String r6) {
            String r7 = a(r6);     // Catch: Exception -> L14
            if (TextUtils.isEmpty(r7) == true) goto L20;
            com.bytedance.mobsec.metasec.ml.c r8 = com.bytedance.mobsec.metasec.ml.d.a(r7);     // Catch: Exception -> L14
            if (r8 == null) goto L21;
            Iterator r1 = ((HashMap) ZeusTransformUtils.preCheckCast(this.f39550b, HashMap.class, "com.obric.aiagent.plugin")).keySet().iterator();     // Catch: Exception -> L14
        L9:
            if (r1.hasNext() == false) goto L23;
            String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
            if (r5.contains(r2) == false) goto L9;
            r8.d((String) ZeusTransformUtils.preCheckCast(((HashMap) ZeusTransformUtils.preCheckCast(this.f39550b, HashMap.class, "com.obric.aiagent.plugin")).get(r2), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L14
            return;
        L23:
            return;
        L21:
            return;
        L20:
            return;
        }

        @Override // com.bytedance.retrofit2.d.b
        public final ak a(com.bytedance.retrofit2.d.b.a r14) {
            com.bytedance.retrofit2.d.b.a r15 = (com.bytedance.retrofit2.d.b.a) ZeusTransformUtils.wrapperContextForParams(r14, com.bytedance.retrofit2.d.b.a.class, "com.obric.aiagent.plugin");
            com.bytedance.retrofit2.b.c r0 = r15.a();
            if (l2.a(this.f39549a) == (-1)) goto L31;
            Object r2 = com.bytedance.mobsec.matrix.a.a(50331651, 0, l2.a(this.f39549a), null, null);
            if (r2 == null) goto L31;
            i.a r4 = i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r0.b());
            if (r4 == null) goto L31;
            if ("off".equals(r4.b()) == true) goto L31;
            if ("async".equals(r4.b()) == false) goto L17;
            com.bytedance.mobsec.matrix.a.a(33554433, 0, ((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.aiagent.plugin")).longValue(), "report-async_" + (System.currentTimeMillis() / 1000), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            goto L31
        L17:
            if ("sync".equals(r4.b()) == false) goto L31;
            HashMap r5 = new HashMap();
            Long r3 = (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.aiagent.plugin");
            String r6 = ((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(33554444, 0, r3.longValue(), null, null), String.class, "com.obric.aiagent.plugin")) + "&cdi=0.3&sh=report_sync";
            Object r7 = com.bytedance.mobsec.matrix.a.a(33554440, DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE, r3.longValue(), "report_sync", null);
            if (r7 != null) goto L21;
        L29:
            String r8 = "";
        L30:
            r5.put("x-bdms-payload", h.a(h.a(r6.getBytes())) + ";;" + h.a(r8));
            r0 = y1.a(r0, r5);
            goto L31
        L21:
            if ((r7 instanceof Object[]) == false) goto L29;
            Object[] r9 = (Object[]) ZeusTransformUtils.preCheckCast(r7, Object[].class, "com.obric.aiagent.plugin");
            if (r9.length < 2) goto L29;
            if (r9[0] == null) goto L29;
            Object r10 = r9[1];
            if (r10 == null) goto L29;
            r8 = r10.toString();
        L31:
            ak r16 = r15.a(r0);
            Iterator<com.bytedance.retrofit2.b.b> r11 = r16.d().iterator();
        L33:
            if (r11.hasNext() == false) goto L61;
            com.bytedance.retrofit2.b.b r12 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r11.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");
            String r13 = r12.a();
            String r17 = r12.b();
            if ("x-bdms-dy".equals(r13) == false) goto L39;
            if (r17 == null) goto L39;
            u r18 = u.a();
            String r19 = r0.o();
            r18.getClass();
            u.a(r17, r19);
        L39:
            if ("x-bdms-dy-sw".equals(r13) == false) goto L44;
            if (r17 == null) goto L44;
            u.a().getClass();
            Integer.parseInt(r17);     // Catch: Exception -> L63
        L44:
            if ("x-bdms-cj".equals(r13) == false) goto L52;
            if (r17 == null) goto L52;
            if (r0 == null) goto L52;
            if (Integer.parseInt(r17.trim()) != 1) goto L33;
            a(r0.o(), r0.b());     // Catch: Exception -> L62
        L52:
            if ("x-bdms-ctrl".equals(r13) == false) goto L33;
            if (r17 == null) goto L33;
            Object r20 = com.bytedance.mobsec.matrix.a.a(33554445, 4, 0, null, null);
            if (r20 == null) goto L33;
            if (((Integer) ZeusTransformUtils.preCheckCast(r20, Integer.class, "com.obric.aiagent.plugin")).intValue() != 1) goto L33;
            if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L33;
            i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(q0.a().b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(new String(h.c(h.b(r12.b()))), true);
            goto L33
        L61:
            return r16;
        }

        private static String a(String r8) {
            String r9 = new URL(r8).getQuery();     // Catch: Exception -> L19
            HashMap r1 = new HashMap();     // Catch: Exception -> L19
            if (r9 == null) goto L12;
            String[] r10 = r9.split("&");     // Catch: Exception -> L19
            int r2 = r10.length;     // Catch: Exception -> L19
            int r4 = 0;
        L6:
            if (r4 >= r2) goto L12;
            String[] r5 = r10[r4].split("=");     // Catch: Exception -> L19
            if (r5.length != 2) goto L10;
            r1.put(r5[0], r5[1]);     // Catch: Exception -> L19
        L10:
            r4 = r4 + 1;     // Catch: Exception -> L19
        L12:
            if (r1.isEmpty() == false) goto L14;
            return "";
        L14:
            if (r1.containsKey(WsConstants.KEY_APP_ID) == false) goto L25;
            return (String) ZeusTransformUtils.preCheckCast(r1.get(WsConstants.KEY_APP_ID), String.class, "com.obric.aiagent.plugin");
        L25:
            return "";
        L26:
            return "";
        }
    }

    public l2() {
    }

    static /* synthetic */ long a(l2 r2) {
        return r2.f39548b;
    }

    @Override // ms.bd.c.t0
    public final Boolean a(long r1) {
        this.f39548b = r1;
        a r2 = new a(this);
        this.f39547a = r2;
        com.bytedance.ttnet.utils.d.a(r2);
        return Boolean.TRUE;
    }

    public final void finalize() {
        com.bytedance.ttnet.utils.d.b(this.f39547a);
        super.finalize();
    }
}
