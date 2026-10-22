package q2;

import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.WorkInfo$State;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: y, reason: collision with root package name */
    public static final String f11504y;

    /* renamed from: a, reason: collision with root package name */
    public final String f11505a;

    /* renamed from: b, reason: collision with root package name */
    public WorkInfo$State f11506b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11507c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11508d;

    /* renamed from: e, reason: collision with root package name */
    public Data f11509e;

    /* renamed from: f, reason: collision with root package name */
    public final Data f11510f;

    /* renamed from: g, reason: collision with root package name */
    public long f11511g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public long f11512i;

    /* renamed from: j, reason: collision with root package name */
    public h2.c f11513j;

    /* renamed from: k, reason: collision with root package name */
    public final int f11514k;

    /* renamed from: l, reason: collision with root package name */
    public final BackoffPolicy f11515l;

    /* renamed from: m, reason: collision with root package name */
    public final long f11516m;

    /* renamed from: n, reason: collision with root package name */
    public long f11517n;

    /* renamed from: o, reason: collision with root package name */
    public final long f11518o;

    /* renamed from: p, reason: collision with root package name */
    public final long f11519p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11520q;
    public final OutOfQuotaPolicy r;

    /* renamed from: s, reason: collision with root package name */
    public final int f11521s;

    /* renamed from: t, reason: collision with root package name */
    public final int f11522t;

    /* renamed from: u, reason: collision with root package name */
    public final long f11523u;

    /* renamed from: v, reason: collision with root package name */
    public final int f11524v;

    /* renamed from: w, reason: collision with root package name */
    public final int f11525w;

    /* renamed from: x, reason: collision with root package name */
    public String f11526x;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f11527a;

        /* renamed from: b, reason: collision with root package name */
        public WorkInfo$State f11528b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.g.b(this.f11527a, aVar.f11527a) && this.f11528b == aVar.f11528b;
        }

        public final int hashCode() {
            return this.f11528b.hashCode() + (this.f11527a.hashCode() * 31);
        }

        public final String toString() {
            return "IdAndState(id=" + this.f11527a + ", state=" + this.f11528b + ')';
        }
    }

    static {
        String strF = h2.j.f("WorkSpec");
        kotlin.jvm.internal.g.e(strF, "tagWithPrefix(\"WorkSpec\")");
        f11504y = strF;
    }

    public p(String id2, WorkInfo$State state, String workerClassName, String inputMergerClassName, Data input, Data output, long j10, long j11, long j12, h2.c constraints, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i11, int i12, long j17, int i13, int i14, String str) {
        kotlin.jvm.internal.g.f(id2, "id");
        kotlin.jvm.internal.g.f(state, "state");
        kotlin.jvm.internal.g.f(workerClassName, "workerClassName");
        kotlin.jvm.internal.g.f(inputMergerClassName, "inputMergerClassName");
        kotlin.jvm.internal.g.f(input, "input");
        kotlin.jvm.internal.g.f(output, "output");
        kotlin.jvm.internal.g.f(constraints, "constraints");
        kotlin.jvm.internal.g.f(backoffPolicy, "backoffPolicy");
        kotlin.jvm.internal.g.f(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.f11505a = id2;
        this.f11506b = state;
        this.f11507c = workerClassName;
        this.f11508d = inputMergerClassName;
        this.f11509e = input;
        this.f11510f = output;
        this.f11511g = j10;
        this.h = j11;
        this.f11512i = j12;
        this.f11513j = constraints;
        this.f11514k = i10;
        this.f11515l = backoffPolicy;
        this.f11516m = j13;
        this.f11517n = j14;
        this.f11518o = j15;
        this.f11519p = j16;
        this.f11520q = z;
        this.r = outOfQuotaPolicy;
        this.f11521s = i11;
        this.f11522t = i12;
        this.f11523u = j17;
        this.f11524v = i13;
        this.f11525w = i14;
        this.f11526x = str;
    }

    public final long a() {
        WorkInfo$State workInfo$State = this.f11506b;
        WorkInfo$State workInfo$State2 = WorkInfo$State.f2792a;
        int i10 = this.f11514k;
        boolean z = workInfo$State == workInfo$State2 && i10 > 0;
        long j10 = this.f11517n;
        boolean zC = c();
        long j11 = this.f11511g;
        long j12 = this.f11512i;
        long j13 = this.h;
        BackoffPolicy backoffPolicy = this.f11515l;
        kotlin.jvm.internal.g.f(backoffPolicy, "backoffPolicy");
        long j14 = this.f11523u;
        int i11 = this.f11521s;
        if (j14 != Long.MAX_VALUE && zC) {
            if (i11 != 0) {
                long j15 = j10 + 900000;
                if (j14 < j15) {
                    return j15;
                }
            }
            return j14;
        }
        if (z) {
            BackoffPolicy backoffPolicy2 = BackoffPolicy.f2760b;
            long j16 = this.f11516m;
            long jScalb = backoffPolicy == backoffPolicy2 ? j16 * i10 : (long) Math.scalb(j16, i10 - 1);
            if (jScalb > 18000000) {
                jScalb = 18000000;
            }
            return j10 + jScalb;
        }
        if (zC) {
            long j17 = i11 == 0 ? j10 + j11 : j10 + j13;
            return (j12 == j13 || i11 != 0) ? j17 : (j13 - j12) + j17;
        }
        if (j10 == -1) {
            return Long.MAX_VALUE;
        }
        return j10 + j11;
    }

    public final boolean b() {
        return !kotlin.jvm.internal.g.b(h2.c.f9255j, this.f11513j);
    }

    public final boolean c() {
        return this.h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return kotlin.jvm.internal.g.b(this.f11505a, pVar.f11505a) && this.f11506b == pVar.f11506b && kotlin.jvm.internal.g.b(this.f11507c, pVar.f11507c) && kotlin.jvm.internal.g.b(this.f11508d, pVar.f11508d) && kotlin.jvm.internal.g.b(this.f11509e, pVar.f11509e) && kotlin.jvm.internal.g.b(this.f11510f, pVar.f11510f) && this.f11511g == pVar.f11511g && this.h == pVar.h && this.f11512i == pVar.f11512i && kotlin.jvm.internal.g.b(this.f11513j, pVar.f11513j) && this.f11514k == pVar.f11514k && this.f11515l == pVar.f11515l && this.f11516m == pVar.f11516m && this.f11517n == pVar.f11517n && this.f11518o == pVar.f11518o && this.f11519p == pVar.f11519p && this.f11520q == pVar.f11520q && this.r == pVar.r && this.f11521s == pVar.f11521s && this.f11522t == pVar.f11522t && this.f11523u == pVar.f11523u && this.f11524v == pVar.f11524v && this.f11525w == pVar.f11525w && kotlin.jvm.internal.g.b(this.f11526x, pVar.f11526x);
    }

    public final int hashCode() {
        int iD = ai.onnxruntime.a.d(this.f11525w, ai.onnxruntime.a.d(this.f11524v, a0.a.c(ai.onnxruntime.a.d(this.f11522t, ai.onnxruntime.a.d(this.f11521s, (this.r.hashCode() + ai.onnxruntime.a.f(a0.a.c(a0.a.c(a0.a.c(a0.a.c((this.f11515l.hashCode() + ai.onnxruntime.a.d(this.f11514k, (this.f11513j.hashCode() + a0.a.c(a0.a.c(a0.a.c((this.f11510f.hashCode() + ((this.f11509e.hashCode() + v1.d.a(v1.d.a((this.f11506b.hashCode() + (this.f11505a.hashCode() * 31)) * 31, 31, this.f11507c), 31, this.f11508d)) * 31)) * 31, this.f11511g, 31), this.h, 31), this.f11512i, 31)) * 31, 31)) * 31, this.f11516m, 31), this.f11517n, 31), this.f11518o, 31), this.f11519p, 31), 31, this.f11520q)) * 31, 31), 31), this.f11523u, 31), 31), 31);
        String str = this.f11526x;
        return iD + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return ai.onnxruntime.a.n(new StringBuilder("{WorkSpec: "), this.f11505a, '}');
    }

    public /* synthetic */ p(String str, WorkInfo$State workInfo$State, String str2, String str3, Data data, Data data2, long j10, long j11, long j12, h2.c cVar, int i10, BackoffPolicy backoffPolicy, long j13, long j14, long j15, long j16, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i11, long j17, int i12, int i13, String str4, int i14) {
        this(str, (i14 & 2) != 0 ? WorkInfo$State.f2792a : workInfo$State, str2, (i14 & 8) != 0 ? OverwritingInputMerger.class.getName() : str3, (i14 & 16) != 0 ? Data.f2768b : data, (i14 & 32) != 0 ? Data.f2768b : data2, (i14 & 64) != 0 ? 0L : j10, (i14 & TraceIdKeys.MAX_LENGTH) != 0 ? 0L : j11, (i14 & 256) != 0 ? 0L : j12, (i14 & VadSessionManager.FRAME_BYTES) != 0 ? h2.c.f9255j : cVar, (i14 & 1024) != 0 ? 0 : i10, (i14 & 2048) != 0 ? BackoffPolicy.f2759a : backoffPolicy, (i14 & 4096) != 0 ? AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS : j13, (i14 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? -1L : j14, (i14 & 16384) == 0 ? j15 : 0L, (32768 & i14) != 0 ? -1L : j16, (65536 & i14) != 0 ? false : z, (131072 & i14) != 0 ? OutOfQuotaPolicy.f2789a : outOfQuotaPolicy, (262144 & i14) != 0 ? 0 : i11, 0, (1048576 & i14) != 0 ? Long.MAX_VALUE : j17, (2097152 & i14) != 0 ? 0 : i12, (4194304 & i14) != 0 ? -256 : i13, (i14 & 8388608) != 0 ? null : str4);
    }
}
