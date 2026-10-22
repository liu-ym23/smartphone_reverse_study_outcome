package K1;

import com.alibaba.fastjson.PropertyNamingStrategy;
import io.ktor.util.date.GMTDateParser;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class n implements t {

    /* renamed from: f, reason: collision with root package name */
    public static final char[] f4062f = {'t', 'r', 'u', 'e'};

    /* renamed from: g, reason: collision with root package name */
    public static final char[] f4063g = {'f', 'a', 'l', GMTDateParser.SECONDS, 'e'};

    /* renamed from: a, reason: collision with root package name */
    public final j[] f4064a;

    /* renamed from: b, reason: collision with root package name */
    public final j[] f4065b;

    /* renamed from: c, reason: collision with root package name */
    public int f4066c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4067d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4068e;

    public n(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, propertyNamingStrategy);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01b5 A[Catch: all -> 0x0388, Exception -> 0x038c, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x038c, all -> 0x0388, blocks: (B:101:0x0158, B:110:0x0186, B:126:0x01b5, B:234:0x034f, B:142:0x021c), top: B:382:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x024d A[Catch: all -> 0x0091, Exception -> 0x0095, TryCatch #7 {Exception -> 0x0095, all -> 0x0091, blocks: (B:39:0x0081, B:41:0x0089, B:43:0x008d, B:48:0x0099, B:49:0x009d, B:51:0x00a8, B:53:0x00b1, B:54:0x00b7, B:56:0x00c2, B:59:0x00c9, B:61:0x00d0, B:74:0x00fa, B:76:0x00fe, B:77:0x0102, B:79:0x0108, B:83:0x0118, B:85:0x0121, B:89:0x012b, B:94:0x0138, B:98:0x0142, B:99:0x0155, B:104:0x0174, B:106:0x0178, B:112:0x018a, B:116:0x0193, B:117:0x0197, B:119:0x019d, B:132:0x01cb, B:147:0x0227, B:155:0x0243, B:156:0x0247, B:158:0x024d, B:171:0x027c, B:175:0x0287, B:177:0x028e, B:178:0x0293, B:179:0x029a, B:181:0x02a0, B:189:0x02c0, B:192:0x02c9, B:194:0x02d0, B:195:0x02d5, B:196:0x02db, B:198:0x02e1, B:204:0x02fe, B:206:0x0302, B:212:0x0315, B:214:0x0319, B:218:0x0321, B:220:0x0325, B:228:0x0339, B:230:0x033d, B:222:0x0329, B:224:0x032d, B:151:0x0234, B:153:0x023b, B:136:0x01e2, B:138:0x01f7, B:139:0x0208, B:63:0x00d6, B:65:0x00dc, B:69:0x00e5, B:71:0x00ec, B:72:0x00f4, B:68:0x00e1), top: B:378:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x043c A[Catch: all -> 0x0362, Exception -> 0x0367, TryCatch #6 {Exception -> 0x0367, all -> 0x0362, blocks: (B:342:0x04e9, B:236:0x0355, B:238:0x035a, B:240:0x035e, B:245:0x036c, B:246:0x0371, B:248:0x0384, B:256:0x0396, B:257:0x039b, B:262:0x03a7, B:263:0x03aa, B:266:0x03b2, B:268:0x03bd, B:270:0x03c1, B:272:0x03c6, B:276:0x03e5, B:284:0x0405, B:289:0x0411, B:291:0x0417, B:293:0x041b, B:294:0x041d, B:296:0x0425, B:298:0x0429, B:299:0x042d, B:302:0x043c, B:303:0x0446, B:305:0x044b, B:308:0x0458, B:309:0x0463, B:314:0x0476, B:316:0x047f, B:319:0x0485, B:320:0x048a, B:321:0x0491, B:323:0x0495, B:324:0x049a, B:325:0x04a1, B:328:0x04a7, B:330:0x04b0, B:335:0x04c4, B:336:0x04c9, B:337:0x04ce, B:338:0x04d9, B:339:0x04de, B:340:0x04e3, B:277:0x03f1, B:343:0x0505, B:348:0x0516, B:349:0x051a, B:351:0x0520, B:352:0x052b, B:354:0x0530, B:356:0x0539, B:357:0x053f, B:359:0x054a, B:361:0x054e, B:362:0x0552, B:364:0x0559), top: B:380:0x04e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x054a A[Catch: all -> 0x0362, Exception -> 0x0367, TryCatch #6 {Exception -> 0x0367, all -> 0x0362, blocks: (B:342:0x04e9, B:236:0x0355, B:238:0x035a, B:240:0x035e, B:245:0x036c, B:246:0x0371, B:248:0x0384, B:256:0x0396, B:257:0x039b, B:262:0x03a7, B:263:0x03aa, B:266:0x03b2, B:268:0x03bd, B:270:0x03c1, B:272:0x03c6, B:276:0x03e5, B:284:0x0405, B:289:0x0411, B:291:0x0417, B:293:0x041b, B:294:0x041d, B:296:0x0425, B:298:0x0429, B:299:0x042d, B:302:0x043c, B:303:0x0446, B:305:0x044b, B:308:0x0458, B:309:0x0463, B:314:0x0476, B:316:0x047f, B:319:0x0485, B:320:0x048a, B:321:0x0491, B:323:0x0495, B:324:0x049a, B:325:0x04a1, B:328:0x04a7, B:330:0x04b0, B:335:0x04c4, B:336:0x04c9, B:337:0x04ce, B:338:0x04d9, B:339:0x04de, B:340:0x04e3, B:277:0x03f1, B:343:0x0505, B:348:0x0516, B:349:0x051a, B:351:0x0520, B:352:0x052b, B:354:0x0530, B:356:0x0539, B:357:0x053f, B:359:0x054a, B:361:0x054e, B:362:0x0552, B:364:0x0559), top: B:380:0x04e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x056a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d6 A[Catch: all -> 0x0091, Exception -> 0x0095, TryCatch #7 {Exception -> 0x0095, all -> 0x0091, blocks: (B:39:0x0081, B:41:0x0089, B:43:0x008d, B:48:0x0099, B:49:0x009d, B:51:0x00a8, B:53:0x00b1, B:54:0x00b7, B:56:0x00c2, B:59:0x00c9, B:61:0x00d0, B:74:0x00fa, B:76:0x00fe, B:77:0x0102, B:79:0x0108, B:83:0x0118, B:85:0x0121, B:89:0x012b, B:94:0x0138, B:98:0x0142, B:99:0x0155, B:104:0x0174, B:106:0x0178, B:112:0x018a, B:116:0x0193, B:117:0x0197, B:119:0x019d, B:132:0x01cb, B:147:0x0227, B:155:0x0243, B:156:0x0247, B:158:0x024d, B:171:0x027c, B:175:0x0287, B:177:0x028e, B:178:0x0293, B:179:0x029a, B:181:0x02a0, B:189:0x02c0, B:192:0x02c9, B:194:0x02d0, B:195:0x02d5, B:196:0x02db, B:198:0x02e1, B:204:0x02fe, B:206:0x0302, B:212:0x0315, B:214:0x0319, B:218:0x0321, B:220:0x0325, B:228:0x0339, B:230:0x033d, B:222:0x0329, B:224:0x032d, B:151:0x0234, B:153:0x023b, B:136:0x01e2, B:138:0x01f7, B:139:0x0208, B:63:0x00d6, B:65:0x00dc, B:69:0x00e5, B:71:0x00ec, B:72:0x00f4, B:68:0x00e1), top: B:378:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fe A[Catch: all -> 0x0091, Exception -> 0x0095, TryCatch #7 {Exception -> 0x0095, all -> 0x0091, blocks: (B:39:0x0081, B:41:0x0089, B:43:0x008d, B:48:0x0099, B:49:0x009d, B:51:0x00a8, B:53:0x00b1, B:54:0x00b7, B:56:0x00c2, B:59:0x00c9, B:61:0x00d0, B:74:0x00fa, B:76:0x00fe, B:77:0x0102, B:79:0x0108, B:83:0x0118, B:85:0x0121, B:89:0x012b, B:94:0x0138, B:98:0x0142, B:99:0x0155, B:104:0x0174, B:106:0x0178, B:112:0x018a, B:116:0x0193, B:117:0x0197, B:119:0x019d, B:132:0x01cb, B:147:0x0227, B:155:0x0243, B:156:0x0247, B:158:0x024d, B:171:0x027c, B:175:0x0287, B:177:0x028e, B:178:0x0293, B:179:0x029a, B:181:0x02a0, B:189:0x02c0, B:192:0x02c9, B:194:0x02d0, B:195:0x02d5, B:196:0x02db, B:198:0x02e1, B:204:0x02fe, B:206:0x0302, B:212:0x0315, B:214:0x0319, B:218:0x0321, B:220:0x0325, B:228:0x0339, B:230:0x033d, B:222:0x0329, B:224:0x032d, B:151:0x0234, B:153:0x023b, B:136:0x01e2, B:138:0x01f7, B:139:0x0208, B:63:0x00d6, B:65:0x00dc, B:69:0x00e5, B:71:0x00ec, B:72:0x00f4, B:68:0x00e1), top: B:378:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0141  */
    @Override // K1.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(K1.m r38, java.lang.Object r39, java.lang.Object r40, java.lang.reflect.Type r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K1.n.a(K1.m, java.lang.Object, java.lang.Object, java.lang.reflect.Type):void");
    }

    public Map<String, Object> b(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f4065b.length);
        for (j jVar : this.f4065b) {
            linkedHashMap.put(jVar.f4038a.f4261a, jVar.b(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n(java.lang.Class<?> r13, int r14, java.util.Map<java.lang.String, java.lang.String> r15, boolean r16, boolean r17, boolean r18, boolean r19, com.alibaba.fastjson.PropertyNamingStrategy r20) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K1.n.<init>(java.lang.Class, int, java.util.Map, boolean, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):void");
    }
}
