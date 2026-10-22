package androidx.constraintlayout.core;

import com.stepos.core.common.telemetry.FailStage;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SolverVariable implements Comparable<SolverVariable> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1032a;

    /* renamed from: e, reason: collision with root package name */
    public float f1036e;

    /* renamed from: l, reason: collision with root package name */
    public Type f1039l;

    /* renamed from: b, reason: collision with root package name */
    public int f1033b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f1034c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f1035d = 0;
    public boolean h = false;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f1037j = new float[9];

    /* renamed from: k, reason: collision with root package name */
    public final float[] f1038k = new float[9];

    /* renamed from: m, reason: collision with root package name */
    public b[] f1040m = new b[16];

    /* renamed from: n, reason: collision with root package name */
    public int f1041n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f1042o = 0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f1043a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f1044b;

        /* renamed from: c, reason: collision with root package name */
        public static final Type f1045c;

        /* renamed from: d, reason: collision with root package name */
        public static final Type f1046d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1047e;

        static {
            Type type = new Type("UNRESTRICTED", 0);
            f1043a = type;
            Type type2 = new Type("CONSTANT", 1);
            Type type3 = new Type("SLACK", 2);
            f1044b = type3;
            Type type4 = new Type("ERROR", 3);
            f1045c = type4;
            Type type5 = new Type(FailStage.UNKNOWN, 4);
            f1046d = type5;
            f1047e = new Type[]{type, type2, type3, type4, type5};
        }

        public Type() {
            throw null;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1047e.clone();
        }
    }

    public SolverVariable(Type type) {
        this.f1039l = type;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f1041n;
            if (i10 >= i11) {
                b[] bVarArr = this.f1040m;
                if (i11 >= bVarArr.length) {
                    this.f1040m = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f1040m;
                int i12 = this.f1041n;
                bVarArr2[i12] = bVar;
                this.f1041n = i12 + 1;
                return;
            }
            if (this.f1040m[i10] == bVar) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void b(b bVar) {
        int i10 = this.f1041n;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f1040m[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f1040m;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f1041n--;
                return;
            }
            i11++;
        }
    }

    public final void c() {
        this.f1039l = Type.f1046d;
        this.f1035d = 0;
        this.f1033b = -1;
        this.f1034c = -1;
        this.f1036e = 0.0f;
        this.h = false;
        int i10 = this.f1041n;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1040m[i11] = null;
        }
        this.f1041n = 0;
        this.f1042o = 0;
        this.f1032a = false;
        Arrays.fill(this.f1038k, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(SolverVariable solverVariable) {
        return this.f1033b - solverVariable.f1033b;
    }

    public final void d(c cVar, float f8) {
        this.f1036e = f8;
        this.h = true;
        int i10 = this.f1041n;
        this.f1034c = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1040m[i11].h(cVar, this, false);
        }
        this.f1041n = 0;
    }

    public final void e(c cVar, b bVar) {
        int i10 = this.f1041n;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1040m[i11].i(cVar, bVar, false);
        }
        this.f1041n = 0;
    }

    public final String toString() {
        return "" + this.f1033b;
    }
}
