package I1;

import K1.A;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final n f3254a;

    /* renamed from: b, reason: collision with root package name */
    public l f3255b;

    /* renamed from: c, reason: collision with root package name */
    public String f3256c;

    /* renamed from: d, reason: collision with root package name */
    public DateFormat f3257d;

    /* renamed from: e, reason: collision with root package name */
    public final d f3258e;

    /* renamed from: f, reason: collision with root package name */
    public k f3259f;

    /* renamed from: g, reason: collision with root package name */
    public k[] f3260g;

    /* renamed from: h, reason: collision with root package name */
    public int f3261h;

    /* renamed from: i, reason: collision with root package name */
    public List<a> f3262i;

    /* renamed from: j, reason: collision with root package name */
    public int f3263j;

    /* renamed from: k, reason: collision with root package name */
    public List<J1.c> f3264k;

    /* renamed from: l, reason: collision with root package name */
    public List<J1.b> f3265l;

    /* renamed from: m, reason: collision with root package name */
    public J1.e f3266m;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final k f3267a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3268b;

        /* renamed from: c, reason: collision with root package name */
        public J1.d f3269c;

        /* renamed from: d, reason: collision with root package name */
        public k f3270d;

        public a(k kVar, String str) {
            this.f3267a = kVar;
            this.f3268b = str;
        }
    }

    public b(String str, l lVar) {
        this(new d(str, G1.a.f2774c), lVar);
    }

    public a A() {
        return this.f3262i.get(r1.size() - 1);
    }

    public <T> T D0(Type type) {
        return (T) I0(type, null);
    }

    public void G(Object obj) {
        List<a> list = this.f3262i;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = this.f3262i.get(i10);
            J1.d dVar = aVar.f3269c;
            if (dVar != null) {
                k kVar = aVar.f3270d;
                Object obj2 = null;
                Object obj3 = kVar != null ? kVar.f3326a : null;
                String str = aVar.f3268b;
                if (str.startsWith("$")) {
                    for (int i11 = 0; i11 < this.f3261h; i11++) {
                        if (str.equals(this.f3260g[i11].toString())) {
                            obj2 = this.f3260g[i11].f3326a;
                        }
                    }
                } else {
                    obj2 = aVar.f3267a.f3326a;
                }
                dVar.g(obj3, obj2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T I0(Type type, Object obj) {
        d dVar = this.f3258e;
        int i10 = dVar.f3280a;
        if (i10 == 8) {
            dVar.s();
            return null;
        }
        if (i10 == 4) {
            if (type == byte[].class) {
                T t10 = (T) dVar.a();
                this.f3258e.s();
                return t10;
            }
            if (type == char[].class) {
                String strX = dVar.X();
                this.f3258e.s();
                return (T) strX.toCharArray();
            }
        }
        try {
            return (T) this.f3255b.c(type).b(this, type, obj);
        } catch (JSONException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public Object J() {
        return U(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x023e, code lost:
    
        r4.t(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0245, code lost:
    
        if (r4.f3280a != 13) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0247, code lost:
    
        r4.t(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x024a, code lost:
    
        r0 = r20.f3255b.c(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0252, code lost:
    
        if ((r0 instanceof I1.f) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0254, code lost:
    
        r0 = ((I1.f) r0).a(r20, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x025b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x025d, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x025e, code lost:
    
        if (r0 != null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0262, code lost:
    
        if (r7 != java.lang.Cloneable.class) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0264, code lost:
    
        r0 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0270, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0272, code lost:
    
        r0 = java.util.Collections.EMPTY_MAP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0275, code lost:
    
        r0 = r7.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0279, code lost:
    
        if (r14 != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x027b, code lost:
    
        r20.f3259f = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x027d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0285, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0286, code lost:
    
        r20.f3263j = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x028b, code lost:
    
        if (r20.f3259f == null) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x028f, code lost:
    
        if ((r22 instanceof java.lang.Integer) != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0291, code lost:
    
        Y0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0298, code lost:
    
        if (r21.size() <= 0) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x029a, code lost:
    
        r0 = L1.d.a(r21, r7, r20.f3255b);
        R0(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02a3, code lost:
    
        if (r14 != false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02a5, code lost:
    
        r20.f3259f = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02a7, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02a8, code lost:
    
        r0 = r20.f3255b.c(r7).b(r20, r7, r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x02b2, code lost:
    
        if (r14 != false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02b4, code lost:
    
        r20.f3259f = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02b6, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x05fc, code lost:
    
        return r21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01d0 A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0066, B:24:0x0070, B:30:0x007f, B:34:0x0092, B:36:0x009c, B:39:0x00a4, B:40:0x00c2, B:104:0x01d0, B:108:0x01e4, B:124:0x0203, B:128:0x0212, B:130:0x0218, B:132:0x0220, B:134:0x0232, B:135:0x023e, B:137:0x0247, B:138:0x024a, B:140:0x0254, B:147:0x0264, B:148:0x026a, B:150:0x0272, B:151:0x0275, B:155:0x027e, B:156:0x0285, B:157:0x0286, B:159:0x028d, B:161:0x0291, B:162:0x0294, B:164:0x029a, B:168:0x02a8, B:175:0x02be, B:177:0x02c6, B:179:0x02cd, B:181:0x02dc, B:183:0x02e4, B:186:0x02e9, B:188:0x02ed, B:207:0x0337, B:209:0x033b, B:213:0x0345, B:214:0x035d, B:189:0x02f0, B:191:0x02f8, B:194:0x02fe, B:195:0x030a, B:198:0x0313, B:201:0x0319, B:204:0x031f, B:205:0x032b, B:215:0x035e, B:216:0x037a, B:219:0x037f, B:225:0x038e, B:227:0x0394, B:229:0x03a0, B:230:0x03a6, B:232:0x03ab, B:332:0x0542, B:336:0x054c, B:339:0x0555, B:343:0x056a, B:342:0x0564, B:346:0x0574, B:350:0x0589, B:352:0x0592, B:356:0x05a7, B:373:0x05f3, B:355:0x05a1, B:359:0x05b2, B:363:0x05c7, B:362:0x05c1, B:366:0x05d2, B:370:0x05e7, B:369:0x05e1, B:371:0x05ee, B:349:0x0583, B:377:0x05fd, B:378:0x0615, B:233:0x03af, B:241:0x03c2, B:244:0x03ce, B:248:0x03e7, B:250:0x03f0, B:254:0x03fc, B:256:0x0406, B:258:0x040d, B:260:0x0411, B:269:0x0427, B:270:0x043f, B:257:0x040a, B:253:0x03f9, B:247:0x03e1, B:273:0x0444, B:277:0x0459, B:279:0x046a, B:283:0x047e, B:285:0x0484, B:288:0x048a, B:291:0x0493, B:293:0x049b, B:297:0x04ad, B:300:0x04b5, B:301:0x04b7, B:303:0x04bc, B:305:0x04c5, B:308:0x04ce, B:309:0x04d1, B:311:0x04d7, B:313:0x04de, B:320:0x04eb, B:321:0x0503, B:306:0x04c9, B:280:0x0475, B:276:0x0453, B:324:0x050a, B:326:0x0516, B:329:0x0529, B:331:0x0535, B:379:0x0616, B:381:0x0628, B:382:0x062c, B:384:0x0635, B:391:0x064c, B:392:0x0664, B:107:0x01de, B:127:0x020d, B:44:0x00ca, B:48:0x00db, B:47:0x00d5, B:54:0x00ee, B:56:0x00f8, B:57:0x00fb, B:60:0x0100, B:61:0x0116, B:73:0x012d, B:74:0x0132, B:76:0x0137, B:79:0x0145, B:80:0x0149, B:83:0x014f, B:84:0x0167, B:77:0x013c, B:85:0x0168, B:86:0x0180, B:92:0x018a, B:95:0x0199, B:96:0x019f, B:97:0x01bd, B:98:0x01be, B:100:0x01c7, B:393:0x0665, B:394:0x067d, B:395:0x067e, B:396:0x0696), top: B:403:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x020d A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0066, B:24:0x0070, B:30:0x007f, B:34:0x0092, B:36:0x009c, B:39:0x00a4, B:40:0x00c2, B:104:0x01d0, B:108:0x01e4, B:124:0x0203, B:128:0x0212, B:130:0x0218, B:132:0x0220, B:134:0x0232, B:135:0x023e, B:137:0x0247, B:138:0x024a, B:140:0x0254, B:147:0x0264, B:148:0x026a, B:150:0x0272, B:151:0x0275, B:155:0x027e, B:156:0x0285, B:157:0x0286, B:159:0x028d, B:161:0x0291, B:162:0x0294, B:164:0x029a, B:168:0x02a8, B:175:0x02be, B:177:0x02c6, B:179:0x02cd, B:181:0x02dc, B:183:0x02e4, B:186:0x02e9, B:188:0x02ed, B:207:0x0337, B:209:0x033b, B:213:0x0345, B:214:0x035d, B:189:0x02f0, B:191:0x02f8, B:194:0x02fe, B:195:0x030a, B:198:0x0313, B:201:0x0319, B:204:0x031f, B:205:0x032b, B:215:0x035e, B:216:0x037a, B:219:0x037f, B:225:0x038e, B:227:0x0394, B:229:0x03a0, B:230:0x03a6, B:232:0x03ab, B:332:0x0542, B:336:0x054c, B:339:0x0555, B:343:0x056a, B:342:0x0564, B:346:0x0574, B:350:0x0589, B:352:0x0592, B:356:0x05a7, B:373:0x05f3, B:355:0x05a1, B:359:0x05b2, B:363:0x05c7, B:362:0x05c1, B:366:0x05d2, B:370:0x05e7, B:369:0x05e1, B:371:0x05ee, B:349:0x0583, B:377:0x05fd, B:378:0x0615, B:233:0x03af, B:241:0x03c2, B:244:0x03ce, B:248:0x03e7, B:250:0x03f0, B:254:0x03fc, B:256:0x0406, B:258:0x040d, B:260:0x0411, B:269:0x0427, B:270:0x043f, B:257:0x040a, B:253:0x03f9, B:247:0x03e1, B:273:0x0444, B:277:0x0459, B:279:0x046a, B:283:0x047e, B:285:0x0484, B:288:0x048a, B:291:0x0493, B:293:0x049b, B:297:0x04ad, B:300:0x04b5, B:301:0x04b7, B:303:0x04bc, B:305:0x04c5, B:308:0x04ce, B:309:0x04d1, B:311:0x04d7, B:313:0x04de, B:320:0x04eb, B:321:0x0503, B:306:0x04c9, B:280:0x0475, B:276:0x0453, B:324:0x050a, B:326:0x0516, B:329:0x0529, B:331:0x0535, B:379:0x0616, B:381:0x0628, B:382:0x062c, B:384:0x0635, B:391:0x064c, B:392:0x0664, B:107:0x01de, B:127:0x020d, B:44:0x00ca, B:48:0x00db, B:47:0x00d5, B:54:0x00ee, B:56:0x00f8, B:57:0x00fb, B:60:0x0100, B:61:0x0116, B:73:0x012d, B:74:0x0132, B:76:0x0137, B:79:0x0145, B:80:0x0149, B:83:0x014f, B:84:0x0167, B:77:0x013c, B:85:0x0168, B:86:0x0180, B:92:0x018a, B:95:0x0199, B:96:0x019f, B:97:0x01bd, B:98:0x01be, B:100:0x01c7, B:393:0x0665, B:394:0x067d, B:395:0x067e, B:396:0x0696), top: B:403:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x038e A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0066, B:24:0x0070, B:30:0x007f, B:34:0x0092, B:36:0x009c, B:39:0x00a4, B:40:0x00c2, B:104:0x01d0, B:108:0x01e4, B:124:0x0203, B:128:0x0212, B:130:0x0218, B:132:0x0220, B:134:0x0232, B:135:0x023e, B:137:0x0247, B:138:0x024a, B:140:0x0254, B:147:0x0264, B:148:0x026a, B:150:0x0272, B:151:0x0275, B:155:0x027e, B:156:0x0285, B:157:0x0286, B:159:0x028d, B:161:0x0291, B:162:0x0294, B:164:0x029a, B:168:0x02a8, B:175:0x02be, B:177:0x02c6, B:179:0x02cd, B:181:0x02dc, B:183:0x02e4, B:186:0x02e9, B:188:0x02ed, B:207:0x0337, B:209:0x033b, B:213:0x0345, B:214:0x035d, B:189:0x02f0, B:191:0x02f8, B:194:0x02fe, B:195:0x030a, B:198:0x0313, B:201:0x0319, B:204:0x031f, B:205:0x032b, B:215:0x035e, B:216:0x037a, B:219:0x037f, B:225:0x038e, B:227:0x0394, B:229:0x03a0, B:230:0x03a6, B:232:0x03ab, B:332:0x0542, B:336:0x054c, B:339:0x0555, B:343:0x056a, B:342:0x0564, B:346:0x0574, B:350:0x0589, B:352:0x0592, B:356:0x05a7, B:373:0x05f3, B:355:0x05a1, B:359:0x05b2, B:363:0x05c7, B:362:0x05c1, B:366:0x05d2, B:370:0x05e7, B:369:0x05e1, B:371:0x05ee, B:349:0x0583, B:377:0x05fd, B:378:0x0615, B:233:0x03af, B:241:0x03c2, B:244:0x03ce, B:248:0x03e7, B:250:0x03f0, B:254:0x03fc, B:256:0x0406, B:258:0x040d, B:260:0x0411, B:269:0x0427, B:270:0x043f, B:257:0x040a, B:253:0x03f9, B:247:0x03e1, B:273:0x0444, B:277:0x0459, B:279:0x046a, B:283:0x047e, B:285:0x0484, B:288:0x048a, B:291:0x0493, B:293:0x049b, B:297:0x04ad, B:300:0x04b5, B:301:0x04b7, B:303:0x04bc, B:305:0x04c5, B:308:0x04ce, B:309:0x04d1, B:311:0x04d7, B:313:0x04de, B:320:0x04eb, B:321:0x0503, B:306:0x04c9, B:280:0x0475, B:276:0x0453, B:324:0x050a, B:326:0x0516, B:329:0x0529, B:331:0x0535, B:379:0x0616, B:381:0x0628, B:382:0x062c, B:384:0x0635, B:391:0x064c, B:392:0x0664, B:107:0x01de, B:127:0x020d, B:44:0x00ca, B:48:0x00db, B:47:0x00d5, B:54:0x00ee, B:56:0x00f8, B:57:0x00fb, B:60:0x0100, B:61:0x0116, B:73:0x012d, B:74:0x0132, B:76:0x0137, B:79:0x0145, B:80:0x0149, B:83:0x014f, B:84:0x0167, B:77:0x013c, B:85:0x0168, B:86:0x0180, B:92:0x018a, B:95:0x0199, B:96:0x019f, B:97:0x01bd, B:98:0x01be, B:100:0x01c7, B:393:0x0665, B:394:0x067d, B:395:0x067e, B:396:0x0696), top: B:403:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04ad A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0066, B:24:0x0070, B:30:0x007f, B:34:0x0092, B:36:0x009c, B:39:0x00a4, B:40:0x00c2, B:104:0x01d0, B:108:0x01e4, B:124:0x0203, B:128:0x0212, B:130:0x0218, B:132:0x0220, B:134:0x0232, B:135:0x023e, B:137:0x0247, B:138:0x024a, B:140:0x0254, B:147:0x0264, B:148:0x026a, B:150:0x0272, B:151:0x0275, B:155:0x027e, B:156:0x0285, B:157:0x0286, B:159:0x028d, B:161:0x0291, B:162:0x0294, B:164:0x029a, B:168:0x02a8, B:175:0x02be, B:177:0x02c6, B:179:0x02cd, B:181:0x02dc, B:183:0x02e4, B:186:0x02e9, B:188:0x02ed, B:207:0x0337, B:209:0x033b, B:213:0x0345, B:214:0x035d, B:189:0x02f0, B:191:0x02f8, B:194:0x02fe, B:195:0x030a, B:198:0x0313, B:201:0x0319, B:204:0x031f, B:205:0x032b, B:215:0x035e, B:216:0x037a, B:219:0x037f, B:225:0x038e, B:227:0x0394, B:229:0x03a0, B:230:0x03a6, B:232:0x03ab, B:332:0x0542, B:336:0x054c, B:339:0x0555, B:343:0x056a, B:342:0x0564, B:346:0x0574, B:350:0x0589, B:352:0x0592, B:356:0x05a7, B:373:0x05f3, B:355:0x05a1, B:359:0x05b2, B:363:0x05c7, B:362:0x05c1, B:366:0x05d2, B:370:0x05e7, B:369:0x05e1, B:371:0x05ee, B:349:0x0583, B:377:0x05fd, B:378:0x0615, B:233:0x03af, B:241:0x03c2, B:244:0x03ce, B:248:0x03e7, B:250:0x03f0, B:254:0x03fc, B:256:0x0406, B:258:0x040d, B:260:0x0411, B:269:0x0427, B:270:0x043f, B:257:0x040a, B:253:0x03f9, B:247:0x03e1, B:273:0x0444, B:277:0x0459, B:279:0x046a, B:283:0x047e, B:285:0x0484, B:288:0x048a, B:291:0x0493, B:293:0x049b, B:297:0x04ad, B:300:0x04b5, B:301:0x04b7, B:303:0x04bc, B:305:0x04c5, B:308:0x04ce, B:309:0x04d1, B:311:0x04d7, B:313:0x04de, B:320:0x04eb, B:321:0x0503, B:306:0x04c9, B:280:0x0475, B:276:0x0453, B:324:0x050a, B:326:0x0516, B:329:0x0529, B:331:0x0535, B:379:0x0616, B:381:0x0628, B:382:0x062c, B:384:0x0635, B:391:0x064c, B:392:0x0664, B:107:0x01de, B:127:0x020d, B:44:0x00ca, B:48:0x00db, B:47:0x00d5, B:54:0x00ee, B:56:0x00f8, B:57:0x00fb, B:60:0x0100, B:61:0x0116, B:73:0x012d, B:74:0x0132, B:76:0x0137, B:79:0x0145, B:80:0x0149, B:83:0x014f, B:84:0x0167, B:77:0x013c, B:85:0x0168, B:86:0x0180, B:92:0x018a, B:95:0x0199, B:96:0x019f, B:97:0x01bd, B:98:0x01be, B:100:0x01c7, B:393:0x0665, B:394:0x067d, B:395:0x067e, B:396:0x0696), top: B:403:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04bc A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0066, B:24:0x0070, B:30:0x007f, B:34:0x0092, B:36:0x009c, B:39:0x00a4, B:40:0x00c2, B:104:0x01d0, B:108:0x01e4, B:124:0x0203, B:128:0x0212, B:130:0x0218, B:132:0x0220, B:134:0x0232, B:135:0x023e, B:137:0x0247, B:138:0x024a, B:140:0x0254, B:147:0x0264, B:148:0x026a, B:150:0x0272, B:151:0x0275, B:155:0x027e, B:156:0x0285, B:157:0x0286, B:159:0x028d, B:161:0x0291, B:162:0x0294, B:164:0x029a, B:168:0x02a8, B:175:0x02be, B:177:0x02c6, B:179:0x02cd, B:181:0x02dc, B:183:0x02e4, B:186:0x02e9, B:188:0x02ed, B:207:0x0337, B:209:0x033b, B:213:0x0345, B:214:0x035d, B:189:0x02f0, B:191:0x02f8, B:194:0x02fe, B:195:0x030a, B:198:0x0313, B:201:0x0319, B:204:0x031f, B:205:0x032b, B:215:0x035e, B:216:0x037a, B:219:0x037f, B:225:0x038e, B:227:0x0394, B:229:0x03a0, B:230:0x03a6, B:232:0x03ab, B:332:0x0542, B:336:0x054c, B:339:0x0555, B:343:0x056a, B:342:0x0564, B:346:0x0574, B:350:0x0589, B:352:0x0592, B:356:0x05a7, B:373:0x05f3, B:355:0x05a1, B:359:0x05b2, B:363:0x05c7, B:362:0x05c1, B:366:0x05d2, B:370:0x05e7, B:369:0x05e1, B:371:0x05ee, B:349:0x0583, B:377:0x05fd, B:378:0x0615, B:233:0x03af, B:241:0x03c2, B:244:0x03ce, B:248:0x03e7, B:250:0x03f0, B:254:0x03fc, B:256:0x0406, B:258:0x040d, B:260:0x0411, B:269:0x0427, B:270:0x043f, B:257:0x040a, B:253:0x03f9, B:247:0x03e1, B:273:0x0444, B:277:0x0459, B:279:0x046a, B:283:0x047e, B:285:0x0484, B:288:0x048a, B:291:0x0493, B:293:0x049b, B:297:0x04ad, B:300:0x04b5, B:301:0x04b7, B:303:0x04bc, B:305:0x04c5, B:308:0x04ce, B:309:0x04d1, B:311:0x04d7, B:313:0x04de, B:320:0x04eb, B:321:0x0503, B:306:0x04c9, B:280:0x0475, B:276:0x0453, B:324:0x050a, B:326:0x0516, B:329:0x0529, B:331:0x0535, B:379:0x0616, B:381:0x0628, B:382:0x062c, B:384:0x0635, B:391:0x064c, B:392:0x0664, B:107:0x01de, B:127:0x020d, B:44:0x00ca, B:48:0x00db, B:47:0x00d5, B:54:0x00ee, B:56:0x00f8, B:57:0x00fb, B:60:0x0100, B:61:0x0116, B:73:0x012d, B:74:0x0132, B:76:0x0137, B:79:0x0145, B:80:0x0149, B:83:0x014f, B:84:0x0167, B:77:0x013c, B:85:0x0168, B:86:0x0180, B:92:0x018a, B:95:0x0199, B:96:0x019f, B:97:0x01bd, B:98:0x01be, B:100:0x01c7, B:393:0x0665, B:394:0x067d, B:395:0x067e, B:396:0x0696), top: B:403:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04c5 A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0066, B:24:0x0070, B:30:0x007f, B:34:0x0092, B:36:0x009c, B:39:0x00a4, B:40:0x00c2, B:104:0x01d0, B:108:0x01e4, B:124:0x0203, B:128:0x0212, B:130:0x0218, B:132:0x0220, B:134:0x0232, B:135:0x023e, B:137:0x0247, B:138:0x024a, B:140:0x0254, B:147:0x0264, B:148:0x026a, B:150:0x0272, B:151:0x0275, B:155:0x027e, B:156:0x0285, B:157:0x0286, B:159:0x028d, B:161:0x0291, B:162:0x0294, B:164:0x029a, B:168:0x02a8, B:175:0x02be, B:177:0x02c6, B:179:0x02cd, B:181:0x02dc, B:183:0x02e4, B:186:0x02e9, B:188:0x02ed, B:207:0x0337, B:209:0x033b, B:213:0x0345, B:214:0x035d, B:189:0x02f0, B:191:0x02f8, B:194:0x02fe, B:195:0x030a, B:198:0x0313, B:201:0x0319, B:204:0x031f, B:205:0x032b, B:215:0x035e, B:216:0x037a, B:219:0x037f, B:225:0x038e, B:227:0x0394, B:229:0x03a0, B:230:0x03a6, B:232:0x03ab, B:332:0x0542, B:336:0x054c, B:339:0x0555, B:343:0x056a, B:342:0x0564, B:346:0x0574, B:350:0x0589, B:352:0x0592, B:356:0x05a7, B:373:0x05f3, B:355:0x05a1, B:359:0x05b2, B:363:0x05c7, B:362:0x05c1, B:366:0x05d2, B:370:0x05e7, B:369:0x05e1, B:371:0x05ee, B:349:0x0583, B:377:0x05fd, B:378:0x0615, B:233:0x03af, B:241:0x03c2, B:244:0x03ce, B:248:0x03e7, B:250:0x03f0, B:254:0x03fc, B:256:0x0406, B:258:0x040d, B:260:0x0411, B:269:0x0427, B:270:0x043f, B:257:0x040a, B:253:0x03f9, B:247:0x03e1, B:273:0x0444, B:277:0x0459, B:279:0x046a, B:283:0x047e, B:285:0x0484, B:288:0x048a, B:291:0x0493, B:293:0x049b, B:297:0x04ad, B:300:0x04b5, B:301:0x04b7, B:303:0x04bc, B:305:0x04c5, B:308:0x04ce, B:309:0x04d1, B:311:0x04d7, B:313:0x04de, B:320:0x04eb, B:321:0x0503, B:306:0x04c9, B:280:0x0475, B:276:0x0453, B:324:0x050a, B:326:0x0516, B:329:0x0529, B:331:0x0535, B:379:0x0616, B:381:0x0628, B:382:0x062c, B:384:0x0635, B:391:0x064c, B:392:0x0664, B:107:0x01de, B:127:0x020d, B:44:0x00ca, B:48:0x00db, B:47:0x00d5, B:54:0x00ee, B:56:0x00f8, B:57:0x00fb, B:60:0x0100, B:61:0x0116, B:73:0x012d, B:74:0x0132, B:76:0x0137, B:79:0x0145, B:80:0x0149, B:83:0x014f, B:84:0x0167, B:77:0x013c, B:85:0x0168, B:86:0x0180, B:92:0x018a, B:95:0x0199, B:96:0x019f, B:97:0x01bd, B:98:0x01be, B:100:0x01c7, B:393:0x0665, B:394:0x067d, B:395:0x067e, B:396:0x0696), top: B:403:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04c9 A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0066, B:24:0x0070, B:30:0x007f, B:34:0x0092, B:36:0x009c, B:39:0x00a4, B:40:0x00c2, B:104:0x01d0, B:108:0x01e4, B:124:0x0203, B:128:0x0212, B:130:0x0218, B:132:0x0220, B:134:0x0232, B:135:0x023e, B:137:0x0247, B:138:0x024a, B:140:0x0254, B:147:0x0264, B:148:0x026a, B:150:0x0272, B:151:0x0275, B:155:0x027e, B:156:0x0285, B:157:0x0286, B:159:0x028d, B:161:0x0291, B:162:0x0294, B:164:0x029a, B:168:0x02a8, B:175:0x02be, B:177:0x02c6, B:179:0x02cd, B:181:0x02dc, B:183:0x02e4, B:186:0x02e9, B:188:0x02ed, B:207:0x0337, B:209:0x033b, B:213:0x0345, B:214:0x035d, B:189:0x02f0, B:191:0x02f8, B:194:0x02fe, B:195:0x030a, B:198:0x0313, B:201:0x0319, B:204:0x031f, B:205:0x032b, B:215:0x035e, B:216:0x037a, B:219:0x037f, B:225:0x038e, B:227:0x0394, B:229:0x03a0, B:230:0x03a6, B:232:0x03ab, B:332:0x0542, B:336:0x054c, B:339:0x0555, B:343:0x056a, B:342:0x0564, B:346:0x0574, B:350:0x0589, B:352:0x0592, B:356:0x05a7, B:373:0x05f3, B:355:0x05a1, B:359:0x05b2, B:363:0x05c7, B:362:0x05c1, B:366:0x05d2, B:370:0x05e7, B:369:0x05e1, B:371:0x05ee, B:349:0x0583, B:377:0x05fd, B:378:0x0615, B:233:0x03af, B:241:0x03c2, B:244:0x03ce, B:248:0x03e7, B:250:0x03f0, B:254:0x03fc, B:256:0x0406, B:258:0x040d, B:260:0x0411, B:269:0x0427, B:270:0x043f, B:257:0x040a, B:253:0x03f9, B:247:0x03e1, B:273:0x0444, B:277:0x0459, B:279:0x046a, B:283:0x047e, B:285:0x0484, B:288:0x048a, B:291:0x0493, B:293:0x049b, B:297:0x04ad, B:300:0x04b5, B:301:0x04b7, B:303:0x04bc, B:305:0x04c5, B:308:0x04ce, B:309:0x04d1, B:311:0x04d7, B:313:0x04de, B:320:0x04eb, B:321:0x0503, B:306:0x04c9, B:280:0x0475, B:276:0x0453, B:324:0x050a, B:326:0x0516, B:329:0x0529, B:331:0x0535, B:379:0x0616, B:381:0x0628, B:382:0x062c, B:384:0x0635, B:391:0x064c, B:392:0x0664, B:107:0x01de, B:127:0x020d, B:44:0x00ca, B:48:0x00db, B:47:0x00d5, B:54:0x00ee, B:56:0x00f8, B:57:0x00fb, B:60:0x0100, B:61:0x0116, B:73:0x012d, B:74:0x0132, B:76:0x0137, B:79:0x0145, B:80:0x0149, B:83:0x014f, B:84:0x0167, B:77:0x013c, B:85:0x0168, B:86:0x0180, B:92:0x018a, B:95:0x0199, B:96:0x019f, B:97:0x01bd, B:98:0x01be, B:100:0x01c7, B:393:0x0665, B:394:0x067d, B:395:0x067e, B:396:0x0696), top: B:403:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04ce A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0066, B:24:0x0070, B:30:0x007f, B:34:0x0092, B:36:0x009c, B:39:0x00a4, B:40:0x00c2, B:104:0x01d0, B:108:0x01e4, B:124:0x0203, B:128:0x0212, B:130:0x0218, B:132:0x0220, B:134:0x0232, B:135:0x023e, B:137:0x0247, B:138:0x024a, B:140:0x0254, B:147:0x0264, B:148:0x026a, B:150:0x0272, B:151:0x0275, B:155:0x027e, B:156:0x0285, B:157:0x0286, B:159:0x028d, B:161:0x0291, B:162:0x0294, B:164:0x029a, B:168:0x02a8, B:175:0x02be, B:177:0x02c6, B:179:0x02cd, B:181:0x02dc, B:183:0x02e4, B:186:0x02e9, B:188:0x02ed, B:207:0x0337, B:209:0x033b, B:213:0x0345, B:214:0x035d, B:189:0x02f0, B:191:0x02f8, B:194:0x02fe, B:195:0x030a, B:198:0x0313, B:201:0x0319, B:204:0x031f, B:205:0x032b, B:215:0x035e, B:216:0x037a, B:219:0x037f, B:225:0x038e, B:227:0x0394, B:229:0x03a0, B:230:0x03a6, B:232:0x03ab, B:332:0x0542, B:336:0x054c, B:339:0x0555, B:343:0x056a, B:342:0x0564, B:346:0x0574, B:350:0x0589, B:352:0x0592, B:356:0x05a7, B:373:0x05f3, B:355:0x05a1, B:359:0x05b2, B:363:0x05c7, B:362:0x05c1, B:366:0x05d2, B:370:0x05e7, B:369:0x05e1, B:371:0x05ee, B:349:0x0583, B:377:0x05fd, B:378:0x0615, B:233:0x03af, B:241:0x03c2, B:244:0x03ce, B:248:0x03e7, B:250:0x03f0, B:254:0x03fc, B:256:0x0406, B:258:0x040d, B:260:0x0411, B:269:0x0427, B:270:0x043f, B:257:0x040a, B:253:0x03f9, B:247:0x03e1, B:273:0x0444, B:277:0x0459, B:279:0x046a, B:283:0x047e, B:285:0x0484, B:288:0x048a, B:291:0x0493, B:293:0x049b, B:297:0x04ad, B:300:0x04b5, B:301:0x04b7, B:303:0x04bc, B:305:0x04c5, B:308:0x04ce, B:309:0x04d1, B:311:0x04d7, B:313:0x04de, B:320:0x04eb, B:321:0x0503, B:306:0x04c9, B:280:0x0475, B:276:0x0453, B:324:0x050a, B:326:0x0516, B:329:0x0529, B:331:0x0535, B:379:0x0616, B:381:0x0628, B:382:0x062c, B:384:0x0635, B:391:0x064c, B:392:0x0664, B:107:0x01de, B:127:0x020d, B:44:0x00ca, B:48:0x00db, B:47:0x00d5, B:54:0x00ee, B:56:0x00f8, B:57:0x00fb, B:60:0x0100, B:61:0x0116, B:73:0x012d, B:74:0x0132, B:76:0x0137, B:79:0x0145, B:80:0x0149, B:83:0x014f, B:84:0x0167, B:77:0x013c, B:85:0x0168, B:86:0x0180, B:92:0x018a, B:95:0x0199, B:96:0x019f, B:97:0x01bd, B:98:0x01be, B:100:0x01c7, B:393:0x0665, B:394:0x067d, B:395:0x067e, B:396:0x0696), top: B:403:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0555 A[Catch: all -> 0x0078, TryCatch #2 {all -> 0x0078, blocks: (B:21:0x0066, B:24:0x0070, B:30:0x007f, B:34:0x0092, B:36:0x009c, B:39:0x00a4, B:40:0x00c2, B:104:0x01d0, B:108:0x01e4, B:124:0x0203, B:128:0x0212, B:130:0x0218, B:132:0x0220, B:134:0x0232, B:135:0x023e, B:137:0x0247, B:138:0x024a, B:140:0x0254, B:147:0x0264, B:148:0x026a, B:150:0x0272, B:151:0x0275, B:155:0x027e, B:156:0x0285, B:157:0x0286, B:159:0x028d, B:161:0x0291, B:162:0x0294, B:164:0x029a, B:168:0x02a8, B:175:0x02be, B:177:0x02c6, B:179:0x02cd, B:181:0x02dc, B:183:0x02e4, B:186:0x02e9, B:188:0x02ed, B:207:0x0337, B:209:0x033b, B:213:0x0345, B:214:0x035d, B:189:0x02f0, B:191:0x02f8, B:194:0x02fe, B:195:0x030a, B:198:0x0313, B:201:0x0319, B:204:0x031f, B:205:0x032b, B:215:0x035e, B:216:0x037a, B:219:0x037f, B:225:0x038e, B:227:0x0394, B:229:0x03a0, B:230:0x03a6, B:232:0x03ab, B:332:0x0542, B:336:0x054c, B:339:0x0555, B:343:0x056a, B:342:0x0564, B:346:0x0574, B:350:0x0589, B:352:0x0592, B:356:0x05a7, B:373:0x05f3, B:355:0x05a1, B:359:0x05b2, B:363:0x05c7, B:362:0x05c1, B:366:0x05d2, B:370:0x05e7, B:369:0x05e1, B:371:0x05ee, B:349:0x0583, B:377:0x05fd, B:378:0x0615, B:233:0x03af, B:241:0x03c2, B:244:0x03ce, B:248:0x03e7, B:250:0x03f0, B:254:0x03fc, B:256:0x0406, B:258:0x040d, B:260:0x0411, B:269:0x0427, B:270:0x043f, B:257:0x040a, B:253:0x03f9, B:247:0x03e1, B:273:0x0444, B:277:0x0459, B:279:0x046a, B:283:0x047e, B:285:0x0484, B:288:0x048a, B:291:0x0493, B:293:0x049b, B:297:0x04ad, B:300:0x04b5, B:301:0x04b7, B:303:0x04bc, B:305:0x04c5, B:308:0x04ce, B:309:0x04d1, B:311:0x04d7, B:313:0x04de, B:320:0x04eb, B:321:0x0503, B:306:0x04c9, B:280:0x0475, B:276:0x0453, B:324:0x050a, B:326:0x0516, B:329:0x0529, B:331:0x0535, B:379:0x0616, B:381:0x0628, B:382:0x062c, B:384:0x0635, B:391:0x064c, B:392:0x0664, B:107:0x01de, B:127:0x020d, B:44:0x00ca, B:48:0x00db, B:47:0x00d5, B:54:0x00ee, B:56:0x00f8, B:57:0x00fb, B:60:0x0100, B:61:0x0116, B:73:0x012d, B:74:0x0132, B:76:0x0137, B:79:0x0145, B:80:0x0149, B:83:0x014f, B:84:0x0167, B:77:0x013c, B:85:0x0168, B:86:0x0180, B:92:0x018a, B:95:0x0199, B:96:0x019f, B:97:0x01bd, B:98:0x01be, B:100:0x01c7, B:393:0x0665, B:394:0x067d, B:395:0x067e, B:396:0x0696), top: B:403:0x0066, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:418:0x04d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0570 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r20v0, types: [I1.b] */
    /* JADX WARN: Type inference failed for: r7v64, types: [java.util.Date] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N0(java.util.Map r21, java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 1692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.b.N0(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void R0(Object obj) {
        Object objB;
        Class<?> cls = obj.getClass();
        J1.f fVarC = this.f3255b.c(cls);
        f fVar = fVarC instanceof f ? (f) fVarC : null;
        int i10 = this.f3258e.f3280a;
        if (i10 != 12 && i10 != 16) {
            throw new JSONException("syntax error, expect {, actual " + e.a(i10));
        }
        while (true) {
            String strR = this.f3258e.R(this.f3254a);
            if (strR == null) {
                d dVar = this.f3258e;
                int i11 = dVar.f3280a;
                if (i11 == 13) {
                    dVar.t(16);
                    return;
                } else if (i11 == 16) {
                    continue;
                }
            }
            J1.d dVarF = fVar != null ? fVar.f(strR) : null;
            if (dVarF == null) {
                d dVar2 = this.f3258e;
                if ((dVar2.f3282c & Feature.IgnoreNotMatch.mask) == 0) {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + strR);
                }
                dVar2.u(':');
                J();
                d dVar3 = this.f3258e;
                if (dVar3.f3280a == 13) {
                    dVar3.s();
                    return;
                }
            } else {
                L1.a aVar = dVarF.f3694a;
                Class<?> cls2 = aVar.f4267g;
                Type type = aVar.f4268h;
                if (cls2 == Integer.TYPE) {
                    this.f3258e.u(':');
                    objB = K1.k.f4046a.b(this, type, null);
                } else if (cls2 == String.class) {
                    this.f3258e.u(':');
                    objB = T0();
                } else if (cls2 == Long.TYPE) {
                    this.f3258e.u(':');
                    objB = K1.k.f4046a.b(this, type, null);
                } else {
                    J1.f fVarB = this.f3255b.b(cls2, type);
                    this.f3258e.u(':');
                    objB = fVarB.b(this, type, null);
                }
                dVarF.g(obj, objB);
                d dVar4 = this.f3258e;
                int i12 = dVar4.f3280a;
                if (i12 != 16 && i12 == 13) {
                    dVar4.t(16);
                    return;
                }
            }
        }
    }

    public String T0() {
        d dVar = this.f3258e;
        int i10 = dVar.f3280a;
        if (i10 != 4) {
            if (i10 == 2) {
                String strV = dVar.v();
                this.f3258e.t(16);
                return strV;
            }
            Object objJ = J();
            if (objJ == null) {
                return null;
            }
            return objJ.toString();
        }
        String strX = dVar.X();
        d dVar2 = this.f3258e;
        char c10 = dVar2.f3283d;
        if (c10 == ',') {
            int i11 = dVar2.f3284e + 1;
            dVar2.f3284e = i11;
            dVar2.f3283d = i11 < dVar2.f3297r ? dVar2.f3296q.charAt(i11) : (char) 26;
            this.f3258e.f3280a = 16;
            return strX;
        }
        if (c10 == ']') {
            int i12 = dVar2.f3284e + 1;
            dVar2.f3284e = i12;
            dVar2.f3283d = i12 < dVar2.f3297r ? dVar2.f3296q.charAt(i12) : (char) 26;
            this.f3258e.f3280a = 15;
            return strX;
        }
        if (c10 != '}') {
            dVar2.s();
            return strX;
        }
        int i13 = dVar2.f3284e + 1;
        dVar2.f3284e = i13;
        dVar2.f3283d = i13 < dVar2.f3297r ? dVar2.f3296q.charAt(i13) : (char) 26;
        this.f3258e.f3280a = 13;
        return strX;
    }

    public Object U(Object obj) {
        d dVar = this.f3258e;
        int i10 = dVar.f3280a;
        if (i10 == 2) {
            Number numberK = dVar.k();
            this.f3258e.s();
            return numberK;
        }
        if (i10 == 3) {
            Number numberF = dVar.f((dVar.f3282c & Feature.UseBigDecimal.mask) != 0);
            this.f3258e.s();
            return numberF;
        }
        if (i10 == 4) {
            String strX = dVar.X();
            this.f3258e.t(16);
            if ((this.f3258e.f3282c & Feature.AllowISO8601DateFormat.mask) == 0) {
                return strX;
            }
            d dVar2 = new d(strX);
            try {
                return dVar2.K(true) ? dVar2.f3294o.getTime() : strX;
            } finally {
                dVar2.e();
            }
        }
        if (i10 == 12) {
            return N0((dVar.f3282c & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), obj);
        }
        if (i10 == 14) {
            JSONArray jSONArray = new JSONArray();
            g0(jSONArray, obj);
            return jSONArray;
        }
        switch (i10) {
            case 6:
                dVar.t(16);
                return Boolean.TRUE;
            case 7:
                dVar.t(16);
                return Boolean.FALSE;
            case 8:
                break;
            case 9:
                dVar.t(18);
                d dVar3 = this.f3258e;
                if (dVar3.f3280a != 18) {
                    throw new JSONException("syntax error, " + this.f3258e.i());
                }
                dVar3.t(10);
                b(10);
                long jLongValue = this.f3258e.k().longValue();
                b(2);
                b(11);
                return new Date(jLongValue);
            default:
                switch (i10) {
                    case 20:
                        if (dVar.l()) {
                            return null;
                        }
                        throw new JSONException("syntax error, " + this.f3258e.i());
                    case 21:
                        dVar.s();
                        HashSet hashSet = new HashSet();
                        g0(hashSet, obj);
                        return hashSet;
                    case 22:
                        dVar.s();
                        TreeSet treeSet = new TreeSet();
                        g0(treeSet, obj);
                        return treeSet;
                    case 23:
                        break;
                    default:
                        throw new JSONException("syntax error, " + this.f3258e.i());
                }
        }
        dVar.s();
        return null;
    }

    public void V(Type type, Collection collection) {
        Y(type, collection, null);
    }

    public void Y(Type type, Collection collection, Object obj) {
        J1.f fVarC;
        String strX;
        d dVar = this.f3258e;
        int i10 = dVar.f3280a;
        if (i10 == 21 || i10 == 22) {
            dVar.s();
        }
        d dVar2 = this.f3258e;
        if (dVar2.f3280a != 14) {
            throw new JSONException("exepct '[', but " + e.a(this.f3258e.f3280a) + ", " + this.f3258e.i());
        }
        Class cls = Integer.TYPE;
        if (cls == type) {
            fVarC = K1.k.f4046a;
            dVar2.t(2);
        } else if (String.class == type) {
            fVarC = A.f4024a;
            dVar2.t(4);
        } else {
            fVarC = this.f3255b.c(type);
            this.f3258e.t(12);
        }
        k kVar = this.f3259f;
        if (!this.f3258e.f3299t) {
            a1(kVar, collection, obj);
        }
        int i11 = 0;
        while (true) {
            try {
                d dVar3 = this.f3258e;
                int i12 = dVar3.f3280a;
                if (i12 == 16) {
                    dVar3.s();
                } else {
                    if (i12 == 15) {
                        this.f3259f = kVar;
                        dVar3.t(16);
                        return;
                    }
                    Object objB = null;
                    String string = null;
                    if (cls == type) {
                        collection.add(K1.k.f4046a.b(this, null, null));
                    } else if (String.class == type) {
                        if (i12 == 4) {
                            strX = dVar3.X();
                            this.f3258e.t(16);
                        } else {
                            Object objJ = J();
                            if (objJ != null) {
                                string = objJ.toString();
                            }
                            strX = string;
                        }
                        collection.add(strX);
                    } else {
                        if (i12 == 8) {
                            dVar3.s();
                        } else {
                            objB = fVarC.b(this, type, Integer.valueOf(i11));
                        }
                        collection.add(objB);
                        if (this.f3263j == 1) {
                            g(collection);
                        }
                    }
                    d dVar4 = this.f3258e;
                    if (dVar4.f3280a == 16) {
                        dVar4.s();
                    }
                    i11++;
                }
            } catch (Throwable th) {
                this.f3259f = kVar;
                throw th;
            }
        }
    }

    public void Y0() {
        this.f3259f = this.f3259f.f3327b;
        k[] kVarArr = this.f3260g;
        int i10 = this.f3261h;
        kVarArr[i10 - 1] = null;
        this.f3261h = i10 - 1;
    }

    public k a1(k kVar, Object obj, Object obj2) {
        if (this.f3258e.f3299t) {
            return null;
        }
        this.f3259f = new k(kVar, obj, obj2);
        int i10 = this.f3261h;
        this.f3261h = i10 + 1;
        k[] kVarArr = this.f3260g;
        if (kVarArr == null) {
            this.f3260g = new k[8];
        } else if (i10 >= kVarArr.length) {
            k[] kVarArr2 = new k[(kVarArr.length * 3) / 2];
            System.arraycopy(kVarArr, 0, kVarArr2, 0, kVarArr.length);
            this.f3260g = kVarArr2;
        }
        k[] kVarArr3 = this.f3260g;
        k kVar2 = this.f3259f;
        kVarArr3[i10] = kVar2;
        return kVar2;
    }

    public final void b(int i10) {
        d dVar = this.f3258e;
        if (dVar.f3280a == i10) {
            dVar.s();
            return;
        }
        throw new JSONException("syntax error, expect " + e.a(i10) + ", actual " + e.a(this.f3258e.f3280a));
    }

    public void b1(k kVar) {
        if (this.f3258e.f3299t) {
            return;
        }
        this.f3259f = kVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            d dVar = this.f3258e;
            if (dVar.f3280a == 20) {
                dVar.e();
                return;
            }
            throw new JSONException("not close json text, token : " + e.a(this.f3258e.f3280a));
        } catch (Throwable th) {
            this.f3258e.e();
            throw th;
        }
    }

    public void e(a aVar) {
        if (this.f3262i == null) {
            this.f3262i = new ArrayList(2);
        }
        this.f3262i.add(aVar);
    }

    public final void e0(Collection collection) {
        g0(collection, null);
    }

    public void g(Collection collection) {
        if (collection instanceof List) {
            a aVarA = A();
            aVarA.f3269c = new m(this, (List) collection, collection.size() - 1);
            aVarA.f3270d = this.f3259f;
            this.f3263j = 0;
            return;
        }
        a aVarA2 = A();
        aVarA2.f3269c = new m(collection);
        aVarA2.f3270d = this.f3259f;
        this.f3263j = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01d9 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0028, B:15:0x003c, B:22:0x004e, B:26:0x0060, B:35:0x007e, B:37:0x0084, B:39:0x0090, B:43:0x00a2, B:45:0x00ab, B:48:0x00b3, B:42:0x009c, B:50:0x00bc, B:54:0x00ce, B:56:0x00d7, B:57:0x00da, B:53:0x00c8, B:61:0x00e4, B:62:0x00e7, B:64:0x00ed, B:85:0x011c, B:115:0x01e7, B:117:0x01ee, B:118:0x01f1, B:120:0x01f7, B:122:0x01fb, B:127:0x020b, B:130:0x0217, B:134:0x022b, B:133:0x0225, B:135:0x022e, B:87:0x0124, B:91:0x012e, B:92:0x013b, B:93:0x0143, B:94:0x014a, B:95:0x014b, B:97:0x0158, B:99:0x0168, B:98:0x0163, B:100:0x0171, B:101:0x0179, B:102:0x0183, B:103:0x018d, B:105:0x01a5, B:107:0x01b0, B:108:0x01b6, B:109:0x01bb, B:111:0x01c8, B:113:0x01d3, B:112:0x01ce, B:114:0x01d9, B:25:0x005a, B:27:0x0067, B:29:0x006c, B:32:0x0077), top: B:142:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ee A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0028, B:15:0x003c, B:22:0x004e, B:26:0x0060, B:35:0x007e, B:37:0x0084, B:39:0x0090, B:43:0x00a2, B:45:0x00ab, B:48:0x00b3, B:42:0x009c, B:50:0x00bc, B:54:0x00ce, B:56:0x00d7, B:57:0x00da, B:53:0x00c8, B:61:0x00e4, B:62:0x00e7, B:64:0x00ed, B:85:0x011c, B:115:0x01e7, B:117:0x01ee, B:118:0x01f1, B:120:0x01f7, B:122:0x01fb, B:127:0x020b, B:130:0x0217, B:134:0x022b, B:133:0x0225, B:135:0x022e, B:87:0x0124, B:91:0x012e, B:92:0x013b, B:93:0x0143, B:94:0x014a, B:95:0x014b, B:97:0x0158, B:99:0x0168, B:98:0x0163, B:100:0x0171, B:101:0x0179, B:102:0x0183, B:103:0x018d, B:105:0x01a5, B:107:0x01b0, B:108:0x01b6, B:109:0x01bb, B:111:0x01c8, B:113:0x01d3, B:112:0x01ce, B:114:0x01d9, B:25:0x005a, B:27:0x0067, B:29:0x006c, B:32:0x0077), top: B:142:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f7 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0028, B:15:0x003c, B:22:0x004e, B:26:0x0060, B:35:0x007e, B:37:0x0084, B:39:0x0090, B:43:0x00a2, B:45:0x00ab, B:48:0x00b3, B:42:0x009c, B:50:0x00bc, B:54:0x00ce, B:56:0x00d7, B:57:0x00da, B:53:0x00c8, B:61:0x00e4, B:62:0x00e7, B:64:0x00ed, B:85:0x011c, B:115:0x01e7, B:117:0x01ee, B:118:0x01f1, B:120:0x01f7, B:122:0x01fb, B:127:0x020b, B:130:0x0217, B:134:0x022b, B:133:0x0225, B:135:0x022e, B:87:0x0124, B:91:0x012e, B:92:0x013b, B:93:0x0143, B:94:0x014a, B:95:0x014b, B:97:0x0158, B:99:0x0168, B:98:0x0163, B:100:0x0171, B:101:0x0179, B:102:0x0183, B:103:0x018d, B:105:0x01a5, B:107:0x01b0, B:108:0x01b6, B:109:0x01bb, B:111:0x01c8, B:113:0x01d3, B:112:0x01ce, B:114:0x01d9, B:25:0x005a, B:27:0x0067, B:29:0x006c, B:32:0x0077), top: B:142:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0231 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0028, B:15:0x003c, B:22:0x004e, B:26:0x0060, B:35:0x007e, B:37:0x0084, B:39:0x0090, B:43:0x00a2, B:45:0x00ab, B:48:0x00b3, B:42:0x009c, B:50:0x00bc, B:54:0x00ce, B:56:0x00d7, B:57:0x00da, B:53:0x00c8, B:61:0x00e4, B:62:0x00e7, B:64:0x00ed, B:85:0x011c, B:115:0x01e7, B:117:0x01ee, B:118:0x01f1, B:120:0x01f7, B:122:0x01fb, B:127:0x020b, B:130:0x0217, B:134:0x022b, B:133:0x0225, B:135:0x022e, B:87:0x0124, B:91:0x012e, B:92:0x013b, B:93:0x0143, B:94:0x014a, B:95:0x014b, B:97:0x0158, B:99:0x0168, B:98:0x0163, B:100:0x0171, B:101:0x0179, B:102:0x0183, B:103:0x018d, B:105:0x01a5, B:107:0x01b0, B:108:0x01b6, B:109:0x01bb, B:111:0x01c8, B:113:0x01d3, B:112:0x01ce, B:114:0x01d9, B:25:0x005a, B:27:0x0067, B:29:0x006c, B:32:0x0077), top: B:142:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e7 A[Catch: all -> 0x0049, PHI: r5
      0x00e7: PHI (r5v4 boolean) = (r5v3 boolean), (r5v3 boolean), (r5v3 boolean), (r5v8 boolean) binds: [B:34:0x007c, B:36:0x0082, B:61:0x00e4, B:48:0x00b3] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0028, B:15:0x003c, B:22:0x004e, B:26:0x0060, B:35:0x007e, B:37:0x0084, B:39:0x0090, B:43:0x00a2, B:45:0x00ab, B:48:0x00b3, B:42:0x009c, B:50:0x00bc, B:54:0x00ce, B:56:0x00d7, B:57:0x00da, B:53:0x00c8, B:61:0x00e4, B:62:0x00e7, B:64:0x00ed, B:85:0x011c, B:115:0x01e7, B:117:0x01ee, B:118:0x01f1, B:120:0x01f7, B:122:0x01fb, B:127:0x020b, B:130:0x0217, B:134:0x022b, B:133:0x0225, B:135:0x022e, B:87:0x0124, B:91:0x012e, B:92:0x013b, B:93:0x0143, B:94:0x014a, B:95:0x014b, B:97:0x0158, B:99:0x0168, B:98:0x0163, B:100:0x0171, B:101:0x0179, B:102:0x0183, B:103:0x018d, B:105:0x01a5, B:107:0x01b0, B:108:0x01b6, B:109:0x01bb, B:111:0x01c8, B:113:0x01d3, B:112:0x01ce, B:114:0x01d9, B:25:0x005a, B:27:0x0067, B:29:0x006c, B:32:0x0077), top: B:142:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed A[Catch: all -> 0x0049, LOOP:1: B:63:0x00eb->B:64:0x00ed, LOOP_END, TryCatch #0 {all -> 0x0049, blocks: (B:12:0x0028, B:15:0x003c, B:22:0x004e, B:26:0x0060, B:35:0x007e, B:37:0x0084, B:39:0x0090, B:43:0x00a2, B:45:0x00ab, B:48:0x00b3, B:42:0x009c, B:50:0x00bc, B:54:0x00ce, B:56:0x00d7, B:57:0x00da, B:53:0x00c8, B:61:0x00e4, B:62:0x00e7, B:64:0x00ed, B:85:0x011c, B:115:0x01e7, B:117:0x01ee, B:118:0x01f1, B:120:0x01f7, B:122:0x01fb, B:127:0x020b, B:130:0x0217, B:134:0x022b, B:133:0x0225, B:135:0x022e, B:87:0x0124, B:91:0x012e, B:92:0x013b, B:93:0x0143, B:94:0x014a, B:95:0x014b, B:97:0x0158, B:99:0x0168, B:98:0x0163, B:100:0x0171, B:101:0x0179, B:102:0x0183, B:103:0x018d, B:105:0x01a5, B:107:0x01b0, B:108:0x01b6, B:109:0x01bb, B:111:0x01c8, B:113:0x01d3, B:112:0x01ce, B:114:0x01d9, B:25:0x005a, B:27:0x0067, B:29:0x006c, B:32:0x0077), top: B:142:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g0(java.util.Collection r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I1.b.g0(java.util.Collection, java.lang.Object):void");
    }

    public void i(Map map, Object obj) {
        m mVar = new m(map, obj);
        a aVarA = A();
        aVarA.f3269c = mVar;
        aVarA.f3270d = this.f3259f;
        this.f3263j = 0;
    }

    public JSONObject k0() {
        return (JSONObject) N0((this.f3258e.f3282c & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), null);
    }

    public DateFormat l() {
        if (this.f3257d == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f3256c, this.f3258e.f3293n);
            this.f3257d = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f3258e.f3292m);
        }
        return this.f3257d;
    }

    public List<J1.b> m() {
        if (this.f3265l == null) {
            this.f3265l = new ArrayList(2);
        }
        return this.f3265l;
    }

    public List<J1.c> n() {
        if (this.f3264k == null) {
            this.f3264k = new ArrayList(2);
        }
        return this.f3264k;
    }

    public <T> T v0(Class<T> cls) {
        return (T) I0(cls, null);
    }

    public b(String str, l lVar, int i10) {
        this(new d(str, i10), lVar);
    }

    public b(d dVar, l lVar) {
        this.f3256c = G1.a.f2775d;
        this.f3261h = 0;
        this.f3263j = 0;
        this.f3264k = null;
        this.f3265l = null;
        this.f3266m = null;
        this.f3258e = dVar;
        this.f3255b = lVar;
        this.f3254a = lVar.f3333b;
        char c10 = dVar.f3283d;
        if (c10 == '{') {
            int i10 = dVar.f3284e + 1;
            dVar.f3284e = i10;
            dVar.f3283d = i10 < dVar.f3297r ? dVar.f3296q.charAt(i10) : (char) 26;
            dVar.f3280a = 12;
            return;
        }
        if (c10 == '[') {
            int i11 = dVar.f3284e + 1;
            dVar.f3284e = i11;
            dVar.f3283d = i11 < dVar.f3297r ? dVar.f3296q.charAt(i11) : (char) 26;
            dVar.f3280a = 14;
            return;
        }
        dVar.s();
    }
}
