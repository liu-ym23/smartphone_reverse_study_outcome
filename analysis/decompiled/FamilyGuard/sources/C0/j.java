package C0;

import z0.EnumC1335a;
import z0.EnumC1337c;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f394a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final j f395b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final j f396c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final j f397d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final j f398e = new e();

    class a extends j {
        a() {
        }

        @Override // C0.j
        public boolean a() {
            return true;
        }

        @Override // C0.j
        public boolean b() {
            return true;
        }

        @Override // C0.j
        public boolean c(EnumC1335a enumC1335a) {
            return enumC1335a == EnumC1335a.REMOTE;
        }

        @Override // C0.j
        public boolean d(boolean z5, EnumC1335a enumC1335a, EnumC1337c enumC1337c) {
            return (enumC1335a == EnumC1335a.RESOURCE_DISK_CACHE || enumC1335a == EnumC1335a.MEMORY_CACHE) ? false : true;
        }
    }

    class b extends j {
        b() {
        }

        @Override // C0.j
        public boolean a() {
            return false;
        }

        @Override // C0.j
        public boolean b() {
            return false;
        }

        @Override // C0.j
        public boolean c(EnumC1335a enumC1335a) {
            return false;
        }

        @Override // C0.j
        public boolean d(boolean z5, EnumC1335a enumC1335a, EnumC1337c enumC1337c) {
            return false;
        }
    }

    class c extends j {
        c() {
        }

        @Override // C0.j
        public boolean a() {
            return true;
        }

        @Override // C0.j
        public boolean b() {
            return false;
        }

        @Override // C0.j
        public boolean c(EnumC1335a enumC1335a) {
            return (enumC1335a == EnumC1335a.DATA_DISK_CACHE || enumC1335a == EnumC1335a.MEMORY_CACHE) ? false : true;
        }

        @Override // C0.j
        public boolean d(boolean z5, EnumC1335a enumC1335a, EnumC1337c enumC1337c) {
            return false;
        }
    }

    class d extends j {
        d() {
        }

        @Override // C0.j
        public boolean a() {
            return false;
        }

        @Override // C0.j
        public boolean b() {
            return true;
        }

        @Override // C0.j
        public boolean c(EnumC1335a enumC1335a) {
            return false;
        }

        @Override // C0.j
        public boolean d(boolean z5, EnumC1335a enumC1335a, EnumC1337c enumC1337c) {
            return (enumC1335a == EnumC1335a.RESOURCE_DISK_CACHE || enumC1335a == EnumC1335a.MEMORY_CACHE) ? false : true;
        }
    }

    class e extends j {
        e() {
        }

        @Override // C0.j
        public boolean a() {
            return true;
        }

        @Override // C0.j
        public boolean b() {
            return true;
        }

        @Override // C0.j
        public boolean c(EnumC1335a enumC1335a) {
            return enumC1335a == EnumC1335a.REMOTE;
        }

        @Override // C0.j
        public boolean d(boolean z5, EnumC1335a enumC1335a, EnumC1337c enumC1337c) {
            return ((z5 && enumC1335a == EnumC1335a.DATA_DISK_CACHE) || enumC1335a == EnumC1335a.LOCAL) && enumC1337c == EnumC1337c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(EnumC1335a enumC1335a);

    public abstract boolean d(boolean z5, EnumC1335a enumC1335a, EnumC1337c enumC1337c);
}
