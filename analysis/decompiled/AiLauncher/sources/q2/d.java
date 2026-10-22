package q2;

import com.google.android.gms.common.internal.C1669j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List f38592a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5144a f38593b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f38594c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f38595a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC5144a f38596b;

        /* renamed from: c, reason: collision with root package name */
        public Executor f38597c;

        public a a(com.google.android.gms.common.api.e eVar) {
            this.f38595a.add(eVar);
            return this;
        }

        public d b() {
            return new d(this.f38595a, this.f38596b, this.f38597c, true, null);
        }
    }

    public /* synthetic */ d(List list, InterfaceC5144a interfaceC5144a, Executor executor, boolean z10, g gVar) {
        C1669j.l(list, "APIs must not be null.");
        C1669j.b(!list.isEmpty(), "APIs must not be empty.");
        if (executor != null) {
            C1669j.l(interfaceC5144a, "Listener must not be null when listener executor is set.");
        }
        this.f38592a = list;
        this.f38593b = interfaceC5144a;
        this.f38594c = executor;
    }

    public static a d() {
        return new a();
    }

    public List<com.google.android.gms.common.api.e> a() {
        return this.f38592a;
    }

    public InterfaceC5144a b() {
        return this.f38593b;
    }

    public Executor c() {
        return this.f38594c;
    }
}
