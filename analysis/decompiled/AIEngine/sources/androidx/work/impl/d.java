package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.datastore.preferences.protobuf.b1;
import androidx.work.Data;
import androidx.work.WorkInfo$State;
import androidx.work.WorkerParameters;
import androidx.work.c;
import java.util.ArrayList;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.JobKt__JobKt;
import mb.m;
import q2.p;
import q2.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final p f2941a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2942b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2943c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkerParameters.a f2944d;

    /* renamed from: e, reason: collision with root package name */
    public final s2.c f2945e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.work.a f2946f;

    /* renamed from: g, reason: collision with root package name */
    public final b1 f2947g;
    public final androidx.work.impl.a h;

    /* renamed from: i, reason: collision with root package name */
    public final WorkDatabase f2948i;

    /* renamed from: j, reason: collision with root package name */
    public final q f2949j;

    /* renamed from: k, reason: collision with root package name */
    public final q2.b f2950k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f2951l;

    /* renamed from: m, reason: collision with root package name */
    public final String f2952m;

    /* renamed from: n, reason: collision with root package name */
    public final CompletableJob f2953n;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.work.a f2954a;

        /* renamed from: b, reason: collision with root package name */
        public final s2.c f2955b;

        /* renamed from: c, reason: collision with root package name */
        public final androidx.work.impl.a f2956c;

        /* renamed from: d, reason: collision with root package name */
        public final WorkDatabase f2957d;

        /* renamed from: e, reason: collision with root package name */
        public final p f2958e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f2959f;

        /* renamed from: g, reason: collision with root package name */
        public final Context f2960g;
        public WorkerParameters.a h;

        @SuppressLint({"LambdaLast"})
        public a(Context context, androidx.work.a configuration, s2.c cVar, androidx.work.impl.a aVar, WorkDatabase workDatabase, p pVar, ArrayList arrayList) {
            g.f(context, "context");
            g.f(configuration, "configuration");
            this.f2954a = configuration;
            this.f2955b = cVar;
            this.f2956c = aVar;
            this.f2957d = workDatabase;
            this.f2958e = pVar;
            this.f2959f = arrayList;
            Context applicationContext = context.getApplicationContext();
            g.e(applicationContext, "context.applicationContext");
            this.f2960g = applicationContext;
            this.h = new WorkerParameters.a();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            public final c.a f2961a = new c.a.C0022a();

            public a(int i10) {
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.work.impl.d$b$b, reason: collision with other inner class name */
        public static final class C0025b extends b {

            /* renamed from: a, reason: collision with root package name */
            public final c.a f2962a;

            public C0025b(c.a aVar) {
                this.f2962a = aVar;
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            public final int f2963a;

            public c(int i10) {
                this.f2963a = i10;
            }

            public /* synthetic */ c(Object obj) {
                this(-256);
            }
        }
    }

    public d(a aVar) {
        p pVar = aVar.f2958e;
        this.f2941a = pVar;
        this.f2942b = aVar.f2960g;
        String str = pVar.f11505a;
        this.f2943c = str;
        this.f2944d = aVar.h;
        this.f2945e = aVar.f2955b;
        androidx.work.a aVar2 = aVar.f2954a;
        this.f2946f = aVar2;
        this.f2947g = aVar2.f2817d;
        this.h = aVar.f2956c;
        WorkDatabase workDatabase = aVar.f2957d;
        this.f2948i = workDatabase;
        this.f2949j = workDatabase.w();
        this.f2950k = workDatabase.r();
        ArrayList arrayList = aVar.f2959f;
        this.f2951l = arrayList;
        this.f2952m = ai.onnxruntime.a.o(a0.a.q("Work [ id=", str, ", tags={ "), kotlin.collections.a.z0(arrayList, ",", null, null, null, 62), " } ]");
        this.f2953n = JobKt__JobKt.Job$default(null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(androidx.work.impl.d r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.d.a(androidx.work.impl.d, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void b(int i10) {
        q qVar = this.f2949j;
        WorkInfo$State workInfo$State = WorkInfo$State.f2792a;
        String str = this.f2943c;
        qVar.r(workInfo$State, str);
        this.f2947g.getClass();
        qVar.s(System.currentTimeMillis(), str);
        qVar.e(this.f2941a.f11524v, str);
        qVar.c(-1L, str);
        qVar.v(i10, str);
    }

    public final void c() {
        this.f2947g.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        q qVar = this.f2949j;
        String str = this.f2943c;
        qVar.s(jCurrentTimeMillis, str);
        qVar.r(WorkInfo$State.f2792a, str);
        qVar.x(str);
        qVar.e(this.f2941a.f11524v, str);
        qVar.b(str);
        qVar.c(-1L, str);
    }

    public final void d(c.a result) {
        g.f(result, "result");
        String str = this.f2943c;
        ArrayList arrayListC0 = m.c0(str);
        while (true) {
            boolean zIsEmpty = arrayListC0.isEmpty();
            q qVar = this.f2949j;
            if (zIsEmpty) {
                Data data = ((c.a.C0022a) result).f2829a;
                g.e(data, "failure.outputData");
                qVar.e(this.f2941a.f11524v, str);
                qVar.t(str, data);
                return;
            }
            String str2 = (String) mb.q.j0(arrayListC0);
            if (qVar.h(str2) != WorkInfo$State.h) {
                qVar.r(WorkInfo$State.f2795d, str2);
            }
            arrayListC0.addAll(this.f2950k.d(str2));
        }
    }
}
