package q0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l0.AbstractC0822a;
import m0.InterfaceC0856d;
import u0.C1154d;

/* renamed from: q0.J, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0947J extends d0 implements U {

    /* renamed from: j, reason: collision with root package name */
    protected final C0938A[] f19686j;

    /* renamed from: k, reason: collision with root package name */
    protected final C0938A[] f19687k;

    /* renamed from: l, reason: collision with root package name */
    protected final a0 f19688l;

    /* renamed from: m, reason: collision with root package name */
    private volatile transient long[] f19689m;

    /* renamed from: n, reason: collision with root package name */
    private volatile transient short[] f19690n;

    public C0947J(a0 a0Var) {
        C0938A[] c0938aArr;
        this.f19688l = a0Var;
        this.f19687k = new C0938A[a0Var.f19753f.length];
        int i5 = 0;
        while (true) {
            c0938aArr = this.f19687k;
            if (i5 >= c0938aArr.length) {
                break;
            }
            c0938aArr[i5] = new C0938A(a0Var.f19748a, a0Var.f19753f[i5]);
            i5++;
        }
        C1154d[] c1154dArr = a0Var.f19752e;
        if (c1154dArr == a0Var.f19753f) {
            this.f19686j = c0938aArr;
        } else {
            this.f19686j = new C0938A[c1154dArr.length];
            int i6 = 0;
            while (true) {
                if (i6 >= this.f19686j.length) {
                    break;
                }
                C0938A c0938aT = t(a0Var.f19752e[i6].f22730a);
                if (c0938aT == null) {
                    C0938A[] c0938aArr2 = this.f19687k;
                    System.arraycopy(c0938aArr2, 0, this.f19686j, 0, c0938aArr2.length);
                    break;
                } else {
                    this.f19686j[i6] = c0938aT;
                    i6++;
                }
            }
        }
        InterfaceC0856d interfaceC0856d = a0Var.f19751d;
        if (interfaceC0856d != null) {
            for (Class<? extends c0> cls : interfaceC0856d.serialzeFilters()) {
                try {
                    d(cls.getConstructor(null).newInstance(null));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(5:423|59|(1:63)(1:62)|(4:73|(4:(1:80)|96|97|427)(1:78)|81|(1:(5:87|94|(1:96)(8:98|(7:100|(0)(2:103|104)|107|108|(6:110|111|(1:113)(1:114)|(3:116|(1:118)|(6:212|(2:274|(2:281|(1:283))(3:280|221|129))(1:284)|(2:(1:287)(1:288)|289)(2:291|(2:(1:294)|295)(4:(3:297|(1:304)(1:303)|(1:(1:311)(1:312)))|(2:314|(3:320|338|(1:345)(2:344|428))(1:(4:322|(1:324)|325|(1:333)(1:332))(2:334|(1:336)(1:337))))(1:346)|347|(2:361|431)(2:351|(2:354|(3:356|(3:359|(3:432|361|431)(1:433)|357)|430)(0))(2:353|429))))|290|347|(3:349|361|431)(0))(9:204|(7:206|(0)(0)|(0)(0)|(0)(0)|290|347|(0)(0))|213|214|414|215|(5:(0)(0)|(0)(0)|290|347|(0)(0))|221|129))(1:119)|120|(5:122|(1:130)(1:126)|131|(1:133)(2:134|(0)(1:138))|(0)(0))(1:(5:140|(1:147)(2:144|(3:146|128|129))|148|(0)(1:150)|(0)(0))(2:156|(5:158|(1:165)(2:162|(3:164|128|129))|166|(0)(1:168)|(0)(0))(2:174|(5:176|(1:183)(2:180|(3:182|128|129))|184|(1:186)(2:187|(0)(1:191))|(0)(0))(1:(2:195|(2:197|198)))))))(1:201)|202|(0)(0))(1:105)|106|107|108|(0)(0)|202|(0)(0))|97|427)(6:408|88|94|(0)(0)|97|427))(0))(0)|368)|420|57) */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01d3, code lost:
    
        if ((r11.f19798c & r32) == 0) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x02a8, code lost:
    
        if ((r31 & r3.f19849a) == 0) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f9, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02b2 A[Catch: all -> 0x036d, Exception -> 0x0372, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x036d, blocks: (B:59:0x00c7, B:73:0x0103, B:81:0x0118, B:94:0x013f, B:107:0x0170, B:204:0x02b2, B:213:0x02d1, B:91:0x0134), top: B:423:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0379 A[Catch: all -> 0x02e8, Exception -> 0x02ed, TryCatch #3 {Exception -> 0x02ed, blocks: (B:215:0x02d5, B:217:0x02d9, B:219:0x02dd, B:227:0x02f4, B:229:0x02f8, B:231:0x02fc, B:234:0x0306, B:236:0x030a, B:238:0x030e, B:241:0x0318, B:243:0x031c, B:245:0x0320, B:248:0x032e, B:250:0x0332, B:252:0x0336, B:255:0x0344, B:257:0x0348, B:259:0x034c, B:262:0x035a, B:264:0x035e, B:266:0x0362, B:274:0x0379, B:276:0x037d, B:278:0x0381, B:281:0x038c, B:283:0x0399, B:287:0x03a3, B:289:0x03a9, B:347:0x0468, B:349:0x046c, B:351:0x0470, B:354:0x0479, B:356:0x0481, B:357:0x0489, B:359:0x048f, B:294:0x03b4, B:295:0x03b7, B:297:0x03bd, B:299:0x03c9, B:306:0x03de, B:311:0x03e8, B:312:0x03f0, B:314:0x03f5, B:317:0x03fd, B:322:0x040a, B:324:0x0412, B:325:0x041b, B:327:0x0424, B:329:0x042b, B:330:0x0430, B:332:0x0433, B:333:0x0438, B:334:0x043d, B:336:0x0442, B:337:0x0447, B:338:0x044c, B:340:0x0450, B:342:0x0454, B:345:0x0460, B:346:0x0464, B:375:0x04c4, B:377:0x04cc, B:379:0x04d4), top: B:414:0x02d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x046c A[Catch: all -> 0x02e8, Exception -> 0x02ed, TryCatch #3 {Exception -> 0x02ed, blocks: (B:215:0x02d5, B:217:0x02d9, B:219:0x02dd, B:227:0x02f4, B:229:0x02f8, B:231:0x02fc, B:234:0x0306, B:236:0x030a, B:238:0x030e, B:241:0x0318, B:243:0x031c, B:245:0x0320, B:248:0x032e, B:250:0x0332, B:252:0x0336, B:255:0x0344, B:257:0x0348, B:259:0x034c, B:262:0x035a, B:264:0x035e, B:266:0x0362, B:274:0x0379, B:276:0x037d, B:278:0x0381, B:281:0x038c, B:283:0x0399, B:287:0x03a3, B:289:0x03a9, B:347:0x0468, B:349:0x046c, B:351:0x0470, B:354:0x0479, B:356:0x0481, B:357:0x0489, B:359:0x048f, B:294:0x03b4, B:295:0x03b7, B:297:0x03bd, B:299:0x03c9, B:306:0x03de, B:311:0x03e8, B:312:0x03f0, B:314:0x03f5, B:317:0x03fd, B:322:0x040a, B:324:0x0412, B:325:0x041b, B:327:0x0424, B:329:0x042b, B:330:0x0430, B:332:0x0433, B:333:0x0438, B:334:0x043d, B:336:0x0442, B:337:0x0447, B:338:0x044c, B:340:0x0450, B:342:0x0454, B:345:0x0460, B:346:0x0464, B:375:0x04c4, B:377:0x04cc, B:379:0x04d4), top: B:414:0x02d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x04d4 A[Catch: all -> 0x02e8, Exception -> 0x02ed, TRY_LEAVE, TryCatch #3 {Exception -> 0x02ed, blocks: (B:215:0x02d5, B:217:0x02d9, B:219:0x02dd, B:227:0x02f4, B:229:0x02f8, B:231:0x02fc, B:234:0x0306, B:236:0x030a, B:238:0x030e, B:241:0x0318, B:243:0x031c, B:245:0x0320, B:248:0x032e, B:250:0x0332, B:252:0x0336, B:255:0x0344, B:257:0x0348, B:259:0x034c, B:262:0x035a, B:264:0x035e, B:266:0x0362, B:274:0x0379, B:276:0x037d, B:278:0x0381, B:281:0x038c, B:283:0x0399, B:287:0x03a3, B:289:0x03a9, B:347:0x0468, B:349:0x046c, B:351:0x0470, B:354:0x0479, B:356:0x0481, B:357:0x0489, B:359:0x048f, B:294:0x03b4, B:295:0x03b7, B:297:0x03bd, B:299:0x03c9, B:306:0x03de, B:311:0x03e8, B:312:0x03f0, B:314:0x03f5, B:317:0x03fd, B:322:0x040a, B:324:0x0412, B:325:0x041b, B:327:0x0424, B:329:0x042b, B:330:0x0430, B:332:0x0433, B:333:0x0438, B:334:0x043d, B:336:0x0442, B:337:0x0447, B:338:0x044c, B:340:0x0450, B:342:0x0454, B:345:0x0460, B:346:0x0464, B:375:0x04c4, B:377:0x04cc, B:379:0x04d4), top: B:414:0x02d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0505 A[Catch: all -> 0x0059, TRY_ENTER, TryCatch #8 {all -> 0x0059, blocks: (B:26:0x0055, B:31:0x0061, B:33:0x0064, B:35:0x006c, B:36:0x0072, B:38:0x007f, B:40:0x0083, B:51:0x00a5, B:55:0x00b3, B:57:0x00c4, B:65:0x00f4, B:75:0x0109, B:83:0x0122, B:100:0x0154, B:103:0x0162, B:111:0x0186, B:113:0x0194, B:116:0x01a3, B:118:0x01af, B:206:0x02b6, B:208:0x02c2, B:384:0x04e3, B:387:0x0505, B:395:0x0555, B:397:0x055b, B:398:0x0573, B:400:0x0577, B:404:0x0580, B:405:0x0585, B:389:0x051c, B:391:0x0520, B:393:0x0524, B:394:0x053f, B:122:0x01bb, B:124:0x01c9, B:126:0x01cd, B:131:0x01dc, B:133:0x01e0, B:134:0x01e4, B:136:0x01ea, B:138:0x01ee, B:140:0x01f4, B:142:0x0202, B:144:0x0206, B:148:0x0211, B:151:0x0218, B:153:0x021e, B:156:0x0223, B:158:0x022b, B:160:0x0239, B:162:0x023d, B:166:0x0248, B:169:0x024f, B:171:0x0255, B:174:0x025a, B:176:0x0262, B:178:0x0270, B:180:0x0274, B:184:0x0280, B:186:0x0284, B:187:0x0287, B:189:0x028d, B:191:0x0291, B:193:0x0296, B:195:0x029a, B:197:0x02a4, B:88:0x012e, B:42:0x0089, B:44:0x008f, B:46:0x0093, B:49:0x009b), top: B:416:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x055b A[Catch: all -> 0x0059, TryCatch #8 {all -> 0x0059, blocks: (B:26:0x0055, B:31:0x0061, B:33:0x0064, B:35:0x006c, B:36:0x0072, B:38:0x007f, B:40:0x0083, B:51:0x00a5, B:55:0x00b3, B:57:0x00c4, B:65:0x00f4, B:75:0x0109, B:83:0x0122, B:100:0x0154, B:103:0x0162, B:111:0x0186, B:113:0x0194, B:116:0x01a3, B:118:0x01af, B:206:0x02b6, B:208:0x02c2, B:384:0x04e3, B:387:0x0505, B:395:0x0555, B:397:0x055b, B:398:0x0573, B:400:0x0577, B:404:0x0580, B:405:0x0585, B:389:0x051c, B:391:0x0520, B:393:0x0524, B:394:0x053f, B:122:0x01bb, B:124:0x01c9, B:126:0x01cd, B:131:0x01dc, B:133:0x01e0, B:134:0x01e4, B:136:0x01ea, B:138:0x01ee, B:140:0x01f4, B:142:0x0202, B:144:0x0206, B:148:0x0211, B:151:0x0218, B:153:0x021e, B:156:0x0223, B:158:0x022b, B:160:0x0239, B:162:0x023d, B:166:0x0248, B:169:0x024f, B:171:0x0255, B:174:0x025a, B:176:0x0262, B:178:0x0270, B:180:0x0274, B:184:0x0280, B:186:0x0284, B:187:0x0287, B:189:0x028d, B:191:0x0291, B:193:0x0296, B:195:0x029a, B:197:0x02a4, B:88:0x012e, B:42:0x0089, B:44:0x008f, B:46:0x0093, B:49:0x009b), top: B:416:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0577 A[Catch: all -> 0x0059, TryCatch #8 {all -> 0x0059, blocks: (B:26:0x0055, B:31:0x0061, B:33:0x0064, B:35:0x006c, B:36:0x0072, B:38:0x007f, B:40:0x0083, B:51:0x00a5, B:55:0x00b3, B:57:0x00c4, B:65:0x00f4, B:75:0x0109, B:83:0x0122, B:100:0x0154, B:103:0x0162, B:111:0x0186, B:113:0x0194, B:116:0x01a3, B:118:0x01af, B:206:0x02b6, B:208:0x02c2, B:384:0x04e3, B:387:0x0505, B:395:0x0555, B:397:0x055b, B:398:0x0573, B:400:0x0577, B:404:0x0580, B:405:0x0585, B:389:0x051c, B:391:0x0520, B:393:0x0524, B:394:0x053f, B:122:0x01bb, B:124:0x01c9, B:126:0x01cd, B:131:0x01dc, B:133:0x01e0, B:134:0x01e4, B:136:0x01ea, B:138:0x01ee, B:140:0x01f4, B:142:0x0202, B:144:0x0206, B:148:0x0211, B:151:0x0218, B:153:0x021e, B:156:0x0223, B:158:0x022b, B:160:0x0239, B:162:0x023d, B:166:0x0248, B:169:0x024f, B:171:0x0255, B:174:0x025a, B:176:0x0262, B:178:0x0270, B:180:0x0274, B:184:0x0280, B:186:0x0284, B:187:0x0287, B:189:0x028d, B:191:0x0291, B:193:0x0296, B:195:0x029a, B:197:0x02a4, B:88:0x012e, B:42:0x0089, B:44:0x008f, B:46:0x0093, B:49:0x009b), top: B:416:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0145 A[PHI: r21
      0x0145: PHI (r21v8 q0.A) = (r21v1 q0.A), (r21v4 q0.A), (r21v1 q0.A), (r21v1 q0.A), (r21v1 q0.A) binds: [B:79:0x0114, B:95:0x0143, B:84:0x0126, B:71:0x0100, B:66:0x00f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void A(q0.C0946I r36, java.lang.Object r37, java.lang.Object r38, java.lang.reflect.Type r39, int r40, boolean r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.C0947J.A(q0.I, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    protected char B(C0946I c0946i, Object obj, char c6) {
        List<AbstractC0956c> list = c0946i.f19781b;
        if (list != null) {
            Iterator<AbstractC0956c> it = list.iterator();
            while (it.hasNext()) {
                c6 = it.next().f(c0946i, obj, c6);
            }
        }
        List<AbstractC0956c> list2 = this.f19781b;
        if (list2 != null) {
            Iterator<AbstractC0956c> it2 = list2.iterator();
            while (it2.hasNext()) {
                c6 = it2.next().f(c0946i, obj, c6);
            }
        }
        return c6;
    }

    protected char C(C0946I c0946i, Object obj, char c6) {
        List<AbstractC0964k> list = c0946i.f19780a;
        if (list != null) {
            Iterator<AbstractC0964k> it = list.iterator();
            while (it.hasNext()) {
                c6 = it.next().f(c0946i, obj, c6);
            }
        }
        List<AbstractC0964k> list2 = this.f19780a;
        if (list2 != null) {
            Iterator<AbstractC0964k> it2 = list2.iterator();
            while (it2.hasNext()) {
                c6 = it2.next().f(c0946i, obj, c6);
            }
        }
        return c6;
    }

    protected void D(C0946I c0946i, String str, Object obj) {
        if (str == null) {
            str = c0946i.f19675j.f19765c;
        }
        c0946i.f19676k.E(str, false);
        String name = this.f19688l.f19749b;
        if (name == null) {
            Class<?> superclass = obj.getClass();
            if (u0.o.w0(superclass)) {
                superclass = superclass.getSuperclass();
            }
            name = superclass.getName();
        }
        c0946i.H(name);
    }

    public void E(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws Throwable {
        A(c0946i, obj, obj2, type, i5, false);
    }

    public boolean F(C0946I c0946i, Object obj, int i5) {
        IdentityHashMap<Object, Z> identityHashMap;
        Z z5 = c0946i.f19683r;
        int i6 = f0.DisableCircularReferenceDetect.f19849a;
        if (z5 == null || (z5.f19726d & i6) != 0 || (i5 & i6) != 0 || (identityHashMap = c0946i.f19682q) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        c0946i.J(obj);
        return true;
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws Throwable {
        A(c0946i, obj, obj2, type, i5, false);
    }

    protected boolean q(C0946I c0946i, String str) {
        List<InterfaceC0949L> list = c0946i.f19786g;
        if (list != null) {
            Iterator<InterfaceC0949L> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().c(str)) {
                    return false;
                }
            }
        }
        List<InterfaceC0949L> list2 = this.f19786g;
        if (list2 == null) {
            return true;
        }
        Iterator<InterfaceC0949L> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().c(str)) {
                return false;
            }
        }
        return true;
    }

    public Set<String> r(Object obj) {
        HashSet hashSet = new HashSet();
        for (C0938A c0938a : this.f19687k) {
            if (c0938a.e(obj) != null) {
                hashSet.add(c0938a.f19651a.f22730a);
            }
        }
        return hashSet;
    }

    public C0938A s(long j5) {
        l0.m[] mVarArrValues;
        int iBinarySearch;
        if (this.f19689m == null) {
            mVarArrValues = l0.m.values();
            long[] jArr = new long[this.f19687k.length * mVarArrValues.length];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                C0938A[] c0938aArr = this.f19687k;
                if (i5 >= c0938aArr.length) {
                    break;
                }
                String str = c0938aArr[i5].f19651a.f22730a;
                jArr[i6] = u0.o.I(str);
                i6++;
                for (l0.m mVar : mVarArrValues) {
                    String strB = mVar.b(str);
                    if (!str.equals(strB)) {
                        jArr[i6] = u0.o.I(strB);
                        i6++;
                    }
                }
                i5++;
            }
            Arrays.sort(jArr, 0, i6);
            this.f19689m = new long[i6];
            System.arraycopy(jArr, 0, this.f19689m, 0, i6);
        } else {
            mVarArrValues = null;
        }
        int iBinarySearch2 = Arrays.binarySearch(this.f19689m, j5);
        if (iBinarySearch2 < 0) {
            return null;
        }
        if (this.f19690n == null) {
            if (mVarArrValues == null) {
                mVarArrValues = l0.m.values();
            }
            short[] sArr = new short[this.f19689m.length];
            Arrays.fill(sArr, (short) -1);
            int i7 = 0;
            while (true) {
                C0938A[] c0938aArr2 = this.f19687k;
                if (i7 >= c0938aArr2.length) {
                    break;
                }
                String str2 = c0938aArr2[i7].f19651a.f22730a;
                int iBinarySearch3 = Arrays.binarySearch(this.f19689m, u0.o.I(str2));
                if (iBinarySearch3 >= 0) {
                    sArr[iBinarySearch3] = (short) i7;
                }
                for (l0.m mVar2 : mVarArrValues) {
                    String strB2 = mVar2.b(str2);
                    if (!str2.equals(strB2) && (iBinarySearch = Arrays.binarySearch(this.f19689m, u0.o.I(strB2))) >= 0) {
                        sArr[iBinarySearch] = (short) i7;
                    }
                }
                i7++;
            }
            this.f19690n = sArr;
        }
        short s5 = this.f19690n[iBinarySearch2];
        if (s5 != -1) {
            return this.f19687k[s5];
        }
        return null;
    }

    public C0938A t(String str) {
        if (str == null) {
            return null;
        }
        int length = this.f19687k.length - 1;
        int i5 = 0;
        while (i5 <= length) {
            int i6 = (i5 + length) >>> 1;
            int iCompareTo = this.f19687k[i6].f19651a.f22730a.compareTo(str);
            if (iCompareTo < 0) {
                i5 = i6 + 1;
            } else {
                if (iCompareTo <= 0) {
                    return this.f19687k[i6];
                }
                length = i6 - 1;
            }
        }
        return null;
    }

    public Object u(Object obj, String str, long j5, boolean z5) {
        C0938A c0938aS = s(j5);
        if (c0938aS == null) {
            if (!z5) {
                return null;
            }
            throw new l0.d("field not found. " + str);
        }
        try {
            return c0938aS.d(obj);
        } catch (IllegalAccessException e6) {
            throw new l0.d("getFieldValue error." + str, e6);
        } catch (InvocationTargetException e7) {
            throw new l0.d("getFieldValue error." + str, e7);
        }
    }

    public List<Object> v(Object obj) {
        ArrayList arrayList = new ArrayList(this.f19687k.length);
        for (C0938A c0938a : this.f19687k) {
            arrayList.add(c0938a.d(obj));
        }
        return arrayList;
    }

    public Map<String, Object> w(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f19687k.length);
        for (C0938A c0938a : this.f19687k) {
            boolean zE = f0.e(c0938a.f19653c, f0.SkipTransientField);
            C1154d c1154d = c0938a.f19651a;
            if (!zE || c1154d == null || !c1154d.f22744o) {
                if (c1154d.f22748s) {
                    Object objD = AbstractC0822a.D(c0938a.d(obj));
                    if (objD instanceof Map) {
                        linkedHashMap.putAll((Map) objD);
                    } else {
                        linkedHashMap.put(c0938a.f19651a.f22730a, c0938a.d(obj));
                    }
                } else {
                    linkedHashMap.put(c1154d.f22730a, c0938a.d(obj));
                }
            }
        }
        return linkedHashMap;
    }

    public InterfaceC0856d x() {
        return this.f19688l.f19751d;
    }

    public int y(Object obj) {
        int i5 = 0;
        for (C0938A c0938a : this.f19687k) {
            if (c0938a.e(obj) != null) {
                i5++;
            }
        }
        return i5;
    }

    protected boolean z(C0946I c0946i, int i5) {
        int i6 = f0.BeanToArray.f19849a;
        return ((this.f19688l.f19754g & i6) == 0 && !c0946i.f19676k.f19804i && (i5 & i6) == 0) ? false : true;
    }
}
