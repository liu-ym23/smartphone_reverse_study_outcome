package S0;

import H.h;
import H4.o;
import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import g1.AbstractC1451a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import v0.C2054a;

/* loaded from: classes2.dex */
public final class g implements N0.c {
    public static volatile g c;

    /* renamed from: a, reason: collision with root package name */
    public C5.b f1169a;
    public volatile boolean b;

    static {
        g gVar = new g();
        gVar.b = false;
        c = gVar;
    }

    public static void d(JSONObject jSONObject, boolean z10) {
        try {
            AbstractC1451a.c.getClass();
            Application application = h.f711a;
            if (!TextUtils.isEmpty(null)) {
                AbstractC1451a.c.getClass();
                jSONObject.put("session_id", (Object) null);
            }
            if (jSONObject.isNull("network_type")) {
                jSONObject.put("network_type", D2.b.c(AbstractC1451a.b).f2214a);
            }
            if (jSONObject.isNull("timestamp") || jSONObject.optLong("timestamp") <= 0) {
                jSONObject.put("timestamp", System.currentTimeMillis());
            }
            if (jSONObject.isNull("sid")) {
                jSONObject.put("sid", AbstractC1451a.L());
            }
            jSONObject.put("process_name", AbstractC1451a.A());
            if (z10) {
                jSONObject.put("seq_no", f.f1168a.e());
            }
        } catch (Exception e) {
            Log.e(a.f1163a, "addExtension", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:204:0x0462 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x000f, B:8:0x0015, B:10:0x0019, B:13:0x0024, B:15:0x005e, B:17:0x0066, B:95:0x024e, B:98:0x0288, B:111:0x02a5, B:112:0x02a6, B:115:0x02c4, B:128:0x02e1, B:129:0x02e2, B:132:0x02f9, B:145:0x0312, B:146:0x0313, B:147:0x0324, B:149:0x0333, B:152:0x033b, B:154:0x0343, B:155:0x0348, B:157:0x0350, B:158:0x0355, B:160:0x035d, B:161:0x0362, B:163:0x036a, B:166:0x0385, B:168:0x0391, B:171:0x039d, B:172:0x03a5, B:189:0x0416, B:191:0x042d, B:194:0x0433, B:197:0x043d, B:202:0x0455, B:204:0x0462, B:205:0x0469, B:206:0x0471, B:225:0x04f4, B:226:0x04f5, B:227:0x0504, B:229:0x050a, B:230:0x050b, B:231:0x050f, B:233:0x0512, B:237:0x051a, B:241:0x0534, B:240:0x0526, B:236:0x0519, B:245:0x054e, B:246:0x054f, B:248:0x0551, B:249:0x0552, B:250:0x0553, B:251:0x0554, B:201:0x0452, B:175:0x03c0, B:178:0x03c7, B:188:0x0413, B:253:0x0556, B:254:0x0559, B:165:0x0370, B:19:0x006a, B:23:0x0077, B:27:0x0084, B:94:0x024c, B:28:0x00a2, B:30:0x00ac, B:33:0x00b8, B:35:0x00be, B:38:0x00d0, B:40:0x00d6, B:43:0x00e8, B:44:0x0104, B:46:0x010c, B:48:0x011c, B:50:0x0133, B:53:0x013c, B:55:0x0148, B:60:0x015d, B:61:0x017f, B:63:0x0185, B:68:0x019a, B:69:0x01b6, B:80:0x01ea, B:81:0x0205, B:83:0x0211, B:85:0x022e, B:88:0x0235, B:72:0x01cc, B:74:0x01dc, B:90:0x0239, B:25:0x0080, B:21:0x0073, B:133:0x02fa, B:135:0x02fe, B:137:0x0307, B:141:0x030d, B:142:0x030f, B:235:0x0514, B:228:0x0505, B:187:0x0400, B:116:0x02c5, B:118:0x02cd, B:120:0x02d6, B:124:0x02dc, B:125:0x02de, B:207:0x0472, B:209:0x0476, B:211:0x04a1, B:216:0x04bf, B:218:0x04ce, B:219:0x04d1, B:221:0x04d7, B:224:0x04f2, B:223:0x04eb, B:99:0x0289, B:101:0x0291, B:103:0x029a, B:107:0x02a0, B:108:0x02a2), top: B:257:0x000f, inners: #1, #2, #3, #4, #5, #6, #8, #9, #10, #12, #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x042d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0472 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ea A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x000f, B:8:0x0015, B:10:0x0019, B:13:0x0024, B:15:0x005e, B:17:0x0066, B:95:0x024e, B:98:0x0288, B:111:0x02a5, B:112:0x02a6, B:115:0x02c4, B:128:0x02e1, B:129:0x02e2, B:132:0x02f9, B:145:0x0312, B:146:0x0313, B:147:0x0324, B:149:0x0333, B:152:0x033b, B:154:0x0343, B:155:0x0348, B:157:0x0350, B:158:0x0355, B:160:0x035d, B:161:0x0362, B:163:0x036a, B:166:0x0385, B:168:0x0391, B:171:0x039d, B:172:0x03a5, B:189:0x0416, B:191:0x042d, B:194:0x0433, B:197:0x043d, B:202:0x0455, B:204:0x0462, B:205:0x0469, B:206:0x0471, B:225:0x04f4, B:226:0x04f5, B:227:0x0504, B:229:0x050a, B:230:0x050b, B:231:0x050f, B:233:0x0512, B:237:0x051a, B:241:0x0534, B:240:0x0526, B:236:0x0519, B:245:0x054e, B:246:0x054f, B:248:0x0551, B:249:0x0552, B:250:0x0553, B:251:0x0554, B:201:0x0452, B:175:0x03c0, B:178:0x03c7, B:188:0x0413, B:253:0x0556, B:254:0x0559, B:165:0x0370, B:19:0x006a, B:23:0x0077, B:27:0x0084, B:94:0x024c, B:28:0x00a2, B:30:0x00ac, B:33:0x00b8, B:35:0x00be, B:38:0x00d0, B:40:0x00d6, B:43:0x00e8, B:44:0x0104, B:46:0x010c, B:48:0x011c, B:50:0x0133, B:53:0x013c, B:55:0x0148, B:60:0x015d, B:61:0x017f, B:63:0x0185, B:68:0x019a, B:69:0x01b6, B:80:0x01ea, B:81:0x0205, B:83:0x0211, B:85:0x022e, B:88:0x0235, B:72:0x01cc, B:74:0x01dc, B:90:0x0239, B:25:0x0080, B:21:0x0073, B:133:0x02fa, B:135:0x02fe, B:137:0x0307, B:141:0x030d, B:142:0x030f, B:235:0x0514, B:228:0x0505, B:187:0x0400, B:116:0x02c5, B:118:0x02cd, B:120:0x02d6, B:124:0x02dc, B:125:0x02de, B:207:0x0472, B:209:0x0476, B:211:0x04a1, B:216:0x04bf, B:218:0x04ce, B:219:0x04d1, B:221:0x04d7, B:224:0x04f2, B:223:0x04eb, B:99:0x0289, B:101:0x0291, B:103:0x029a, B:107:0x02a0, B:108:0x02a2), top: B:257:0x000f, inners: #1, #2, #3, #4, #5, #6, #8, #9, #10, #12, #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0205 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x000f, B:8:0x0015, B:10:0x0019, B:13:0x0024, B:15:0x005e, B:17:0x0066, B:95:0x024e, B:98:0x0288, B:111:0x02a5, B:112:0x02a6, B:115:0x02c4, B:128:0x02e1, B:129:0x02e2, B:132:0x02f9, B:145:0x0312, B:146:0x0313, B:147:0x0324, B:149:0x0333, B:152:0x033b, B:154:0x0343, B:155:0x0348, B:157:0x0350, B:158:0x0355, B:160:0x035d, B:161:0x0362, B:163:0x036a, B:166:0x0385, B:168:0x0391, B:171:0x039d, B:172:0x03a5, B:189:0x0416, B:191:0x042d, B:194:0x0433, B:197:0x043d, B:202:0x0455, B:204:0x0462, B:205:0x0469, B:206:0x0471, B:225:0x04f4, B:226:0x04f5, B:227:0x0504, B:229:0x050a, B:230:0x050b, B:231:0x050f, B:233:0x0512, B:237:0x051a, B:241:0x0534, B:240:0x0526, B:236:0x0519, B:245:0x054e, B:246:0x054f, B:248:0x0551, B:249:0x0552, B:250:0x0553, B:251:0x0554, B:201:0x0452, B:175:0x03c0, B:178:0x03c7, B:188:0x0413, B:253:0x0556, B:254:0x0559, B:165:0x0370, B:19:0x006a, B:23:0x0077, B:27:0x0084, B:94:0x024c, B:28:0x00a2, B:30:0x00ac, B:33:0x00b8, B:35:0x00be, B:38:0x00d0, B:40:0x00d6, B:43:0x00e8, B:44:0x0104, B:46:0x010c, B:48:0x011c, B:50:0x0133, B:53:0x013c, B:55:0x0148, B:60:0x015d, B:61:0x017f, B:63:0x0185, B:68:0x019a, B:69:0x01b6, B:80:0x01ea, B:81:0x0205, B:83:0x0211, B:85:0x022e, B:88:0x0235, B:72:0x01cc, B:74:0x01dc, B:90:0x0239, B:25:0x0080, B:21:0x0073, B:133:0x02fa, B:135:0x02fe, B:137:0x0307, B:141:0x030d, B:142:0x030f, B:235:0x0514, B:228:0x0505, B:187:0x0400, B:116:0x02c5, B:118:0x02cd, B:120:0x02d6, B:124:0x02dc, B:125:0x02de, B:207:0x0472, B:209:0x0476, B:211:0x04a1, B:216:0x04bf, B:218:0x04ce, B:219:0x04d1, B:221:0x04d7, B:224:0x04f2, B:223:0x04eb, B:99:0x0289, B:101:0x0291, B:103:0x029a, B:107:0x02a0, B:108:0x02a2), top: B:257:0x000f, inners: #1, #2, #3, #4, #5, #6, #8, #9, #10, #12, #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a() {
        /*
            Method dump skipped, instructions count: 1372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S0.g.a():void");
    }

    public final void b(N0.b bVar) {
        if (!this.b) {
            a();
        }
        JSONObject jSONObjectB = bVar.b();
        if (a.b.contains(bVar.c()) || "tracing".equals(bVar.c())) {
            d(jSONObjectB, false);
        } else {
            if (!U7.a.f1277a.b(AbstractC1451a.q(), jSONObjectB)) {
                if (AbstractC1451a.f4467a) {
                    o.f(a.f1163a, "push failed: event(aid=" + AbstractC1451a.q() + " is downgraded: " + jSONObjectB.toString());
                    return;
                }
                return;
            }
            d(jSONObjectB, true);
        }
        if (AbstractC1451a.f4467a) {
            String strC = bVar.c();
            AtomicInteger atomicInteger = k0.a.f4791a;
            JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("DATA_DOCTOR");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            try {
                if (jSONObjectOptJSONObject.optInt("DATA_ID", -1) == -1) {
                    jSONObjectOptJSONObject.put("DATA_ID", k0.a.f4791a.incrementAndGet());
                }
                jSONObjectOptJSONObject.put("DATA_PROCESS", k0.a.a());
                jSONObjectOptJSONObject.put("DATA_TYPE", strC);
                jSONObjectOptJSONObject.put("DATA_SAMPLE", true);
                jSONObjectOptJSONObject.put("DATA_SAVE_DB_IMMEDIATE", false);
                jSONObjectOptJSONObject.put("DATA_UPLOAD_IMMEDIATE", false);
                jSONObjectOptJSONObject.put("DATA_AID", AbstractC1451a.q());
                jSONObjectB.put("DATA_DOCTOR", jSONObjectOptJSONObject);
                JSONObject jSONObject = new JSONObject(jSONObjectB.toString());
                C2054a c2054a = H2.b.f731a;
                c2054a.f("DATA_RECEIVE", jSONObject);
                c2054a.f("DATA_CACHE", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        C5.b bVar2 = this.f1169a;
        synchronized (bVar2) {
            if (jSONObjectB != null) {
                String string = jSONObjectB.toString();
                if (AbstractC1451a.f4467a) {
                    AtomicInteger atomicInteger2 = k0.a.f4791a;
                    try {
                        H2.b.f731a.f("DATA_SAVE_TO_DB", new JSONObject(jSONObjectB.toString()));
                    } catch (Exception unused) {
                    }
                }
                byte[] bytes = string.getBytes();
                int length = bytes.length + 4;
                if (length > 262144) {
                    N0.a.a(new V0.c());
                    return;
                }
                if (length > ((ByteBuffer) bVar2.d).remaining()) {
                    bVar2.c();
                }
                ((ByteBuffer) bVar2.d).putInt(bytes.length);
                ((ByteBuffer) bVar2.d).put(bytes);
                ((ByteBuffer) bVar2.d).putInt(10, ((ByteBuffer) bVar2.d).getInt(10) + 1);
                ((ByteBuffer) bVar2.d).putInt(14, ((ByteBuffer) bVar2.d).getInt(14) + length);
                if (AbstractC1451a.f4467a) {
                    o.f(a.f1163a, "push success: totalCount=" + ((ByteBuffer) bVar2.d).getInt(10) + ", totalBytes=" + ((ByteBuffer) bVar2.d).getInt(14) + ", logItem=" + string);
                }
                if (((ByteBuffer) bVar2.d).position() >= 262134 || ((ByteBuffer) bVar2.d).getInt(10) >= 256) {
                    bVar2.c();
                }
            }
        }
    }

    public final synchronized void c(T0.a aVar) {
        if (aVar != null) {
            try {
                W0.f.f1476a.l = aVar;
                e eVar = d.f1166a;
                long j5 = aVar.g;
                synchronized (eVar) {
                    try {
                        if (AbstractC1451a.f4467a) {
                            o.f(a.f1163a, "setLoopInterval:" + eVar.f1167a);
                        }
                        if (j5 > 0 && eVar.f1167a != j5) {
                            eVar.f1167a = j5;
                            if (eVar.e != null) {
                                cc.dd.ee.kk.ff.c cVar = cc.dd.ee.kk.ff.c.f2142a;
                                s1.b.a(cVar).b(eVar.e);
                                eVar.e = new c(eVar, eVar.f1167a, eVar.f1167a);
                                s1.b.a(cVar).c(eVar.e);
                            }
                        }
                    } finally {
                    }
                }
                long j6 = aVar.f1194a;
                if (j6 > 0) {
                    eVar.b = j6;
                }
                Y0.b bVar = Y0.b.f;
                int i = aVar.h;
                int i6 = aVar.i;
                bVar.getClass();
                if (i > 0 && i6 > 0) {
                    bVar.c = i;
                    bVar.d = i6;
                    bVar.e = Math.max(0, 80);
                    if (AbstractC1451a.f4467a) {
                        o.f(a.f1163a, "weed out config:maxSizeMB:" + i + " keepDays:" + i6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (AbstractC1451a.f4467a) {
            o.f(a.f1163a, "setSlardarHandlerConfig:" + aVar);
        }
    }
}
