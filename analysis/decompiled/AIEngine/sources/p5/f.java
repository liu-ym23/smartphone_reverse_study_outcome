package p5;

import com.google.re2j.Pattern;
import com.google.re2j.PatternSyntaxException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11413a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Pattern f11414a;

        /* renamed from: b, reason: collision with root package name */
        public final q5.b f11415b;

        public a(Pattern pattern, q5.b bVar) {
            this.f11414a = pattern;
            this.f11415b = bVar;
        }
    }

    public f(List<q5.b> list) {
        ArrayList arrayList = new ArrayList();
        for (q5.b bVar : list) {
            try {
                arrayList.add(new a(Pattern.a(bVar.f11622a), bVar));
            } catch (PatternSyntaxException unused) {
            }
        }
        this.f11413a = arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02e0, code lost:
    
        if (r8 != 10) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02e8, code lost:
    
        r24 = r1;
        r41 = r7;
        r21 = r11;
        r11 = r17;
        r3 = r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02fa, code lost:
    
        if (r8 == r0.f10242d[0]) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x043a, code lost:
    
        r4 = r42;
        r0 = r16;
        r1 = r26;
        r3 = r27;
        r5 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015a, code lost:
    
        r33 = r10;
        r34 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x015e, code lost:
    
        r11 = r17;
        r3 = r32;
        r0 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x015e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03d0 A[SYNTHETIC] */
    @Override // p5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<q5.a> a(java.lang.String r43, java.lang.String r44) {
        /*
            Method dump skipped, instructions count: 1218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.f.a(java.lang.String, java.lang.String):java.util.List");
    }
}
