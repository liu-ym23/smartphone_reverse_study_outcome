package androidx.work;

import androidx.work.impl.model.o;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class j extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f5903e = null;

    public static final class a extends l.a {
        public a(Class r10) {
            q.g(r10, "workerClass");
            super(r10);
            o r11 = g();
            r11.f5673d = OverwritingInputMerger.class.getName();
        }

        @Override // androidx.work.l.a
        public /* bridge */ /* synthetic */ l b() {
            return k();
        }

        @Override // androidx.work.l.a
        public /* bridge */ /* synthetic */ l.a f() {
            return l();
        }

        public j k() {
            if (c() == false) goto L10;
            if (g().f5679j.h() == false) goto L10;
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        L10:
            return new j(this);
        }

        public a l() {
            return this;
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final j a(Class r10) {
            q.g(r10, "workerClass");
            return (j) new a(r10).a();
        }

        public b() {
        }
    }

    static {
        f5903e = new b(null);
    }

    public j(a r10) {
        q.g(r10, "builder");
        super(r10.d(), r10.g(), r10.e());
    }

    public static final j e(Class r10) {
        return f5903e.a(r10);
    }
}
