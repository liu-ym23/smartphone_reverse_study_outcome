package h2;

import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import mb.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f9283a;

    /* renamed from: b, reason: collision with root package name */
    public final q2.p f9284b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<String> f9285c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a<B extends a<B, ?>, W extends s> {

        /* renamed from: a, reason: collision with root package name */
        public UUID f9286a;

        /* renamed from: b, reason: collision with root package name */
        public q2.p f9287b;

        /* renamed from: c, reason: collision with root package name */
        public final Set<String> f9288c;

        public a(Class<? extends androidx.work.c> cls) {
            UUID uuidRandomUUID = UUID.randomUUID();
            kotlin.jvm.internal.g.e(uuidRandomUUID, "randomUUID()");
            this.f9286a = uuidRandomUUID;
            String string = this.f9286a.toString();
            kotlin.jvm.internal.g.e(string, "id.toString()");
            this.f9287b = new q2.p(string, (WorkInfo$State) null, cls.getName(), (String) null, (Data) null, (Data) null, 0L, 0L, 0L, (c) null, 0, (BackoffPolicy) null, 0L, 0L, 0L, 0L, false, (OutOfQuotaPolicy) null, 0, 0L, 0, 0, (String) null, 16777210);
            this.f9288c = x.U(cls.getName());
        }

        public final W a() {
            W w6 = (W) b();
            c cVar = this.f9287b.f11513j;
            boolean z = cVar.b() || cVar.f9260e || cVar.f9258c || cVar.f9259d;
            q2.p pVar = this.f9287b;
            if (pVar.f11520q) {
                if (z) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (pVar.f11511g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            if (pVar.f11526x == null) {
                List listD0 = gc.q.D0(pVar.f11507c, new String[]{"."}, 6);
                String strR0 = listD0.size() == 1 ? (String) listD0.get(0) : (String) kotlin.collections.a.A0(listD0);
                if (strR0.length() > 127) {
                    strR0 = gc.r.R0(127, strR0);
                }
                pVar.f11526x = strR0;
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            kotlin.jvm.internal.g.e(uuidRandomUUID, "randomUUID()");
            this.f9286a = uuidRandomUUID;
            String string = uuidRandomUUID.toString();
            kotlin.jvm.internal.g.e(string, "id.toString()");
            q2.p other = this.f9287b;
            kotlin.jvm.internal.g.f(other, "other");
            this.f9287b = new q2.p(string, other.f11506b, other.f11507c, other.f11508d, new Data(other.f11509e), new Data(other.f11510f), other.f11511g, other.h, other.f11512i, new c(other.f11513j), other.f11514k, other.f11515l, other.f11516m, other.f11517n, other.f11518o, other.f11519p, other.f11520q, other.r, other.f11521s, other.f11523u, other.f11524v, other.f11525w, other.f11526x, 524288);
            return w6;
        }

        public abstract W b();
    }

    public s(UUID id2, q2.p workSpec, Set<String> tags) {
        kotlin.jvm.internal.g.f(id2, "id");
        kotlin.jvm.internal.g.f(workSpec, "workSpec");
        kotlin.jvm.internal.g.f(tags, "tags");
        this.f9283a = id2;
        this.f9284b = workSpec;
        this.f9285c = tags;
    }
}
