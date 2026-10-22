package z2;

import com.fasterxml.jackson.core.JsonFactory;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final b f14239a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference<C0180b> f14240b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14241c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14242d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14243e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f14244f;

    /* renamed from: g, reason: collision with root package name */
    public a[] f14245g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f14246i;

    /* renamed from: j, reason: collision with root package name */
    public int f14247j;

    /* renamed from: k, reason: collision with root package name */
    public int f14248k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14249l;

    /* renamed from: m, reason: collision with root package name */
    public BitSet f14250m;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f14251a;

        /* renamed from: b, reason: collision with root package name */
        public final a f14252b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14253c;

        public a(String str, a aVar) {
            this.f14251a = str;
            this.f14252b = aVar;
            this.f14253c = aVar != null ? 1 + aVar.f14253c : 1;
        }
    }

    public b(int i10) {
        this.f14239a = null;
        this.f14241c = i10;
        this.f14243e = true;
        this.f14242d = -1;
        this.f14249l = false;
        this.f14248k = 0;
        this.f14240b = new AtomicReference<>(new C0180b(new String[64], new a[32]));
    }

    public final int a(int i10) {
        int i11 = i10 + (i10 >>> 15);
        int i12 = i11 ^ (i11 << 7);
        return this.f14247j & (i12 + (i12 >>> 3));
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0085 A[EDGE_INSN: B:128:0x0085->B:48:0x0085 BREAK  A[LOOP:1: B:34:0x0062->B:46:0x0081], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081 A[LOOP:1: B:34:0x0062->B:46:0x0081, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(int r20, int r21, int r22, char[] r23) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.b.b(int, int, int, char[]):java.lang.String");
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: z2.b$b, reason: collision with other inner class name */
    public static final class C0180b {

        /* renamed from: a, reason: collision with root package name */
        public final int f14254a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14255b;

        /* renamed from: c, reason: collision with root package name */
        public final String[] f14256c;

        /* renamed from: d, reason: collision with root package name */
        public final a[] f14257d;

        public C0180b(String[] strArr, a[] aVarArr) {
            this.f14254a = 0;
            this.f14255b = 0;
            this.f14256c = strArr;
            this.f14257d = aVarArr;
        }

        public C0180b(b bVar) {
            this.f14254a = bVar.h;
            this.f14255b = bVar.f14248k;
            this.f14256c = bVar.f14244f;
            this.f14257d = bVar.f14245g;
        }
    }

    public b(b bVar, int i10, int i11, C0180b c0180b) {
        this.f14239a = bVar;
        this.f14241c = i11;
        this.f14240b = null;
        this.f14242d = i10;
        this.f14243e = JsonFactory.Feature.f3535b.c(i10);
        String[] strArr = c0180b.f14256c;
        this.f14244f = strArr;
        this.f14245g = c0180b.f14257d;
        this.h = c0180b.f14254a;
        this.f14248k = c0180b.f14255b;
        int length = strArr.length;
        this.f14246i = length - (length >> 2);
        this.f14247j = length - 1;
        this.f14249l = true;
    }
}
