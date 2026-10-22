package a8b;

import java.util.BitSet;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitSet f2208a;

    /* JADX INFO: renamed from: a8b.a$a, reason: collision with other inner class name */
    public static class C0027a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BitSet f2209a;

        public C0027a(BitSet r100) {
            this.f2209a = r100;
        }

        public final void a(char r100) {
            if (r100 > 127) goto L7;
            this.f2209a.set(r100);
            return;
        L7:
            throw new IllegalArgumentException("Can only match ASCII characters");
        }

        public final void b(char r100, char r101) {
        L2:
            if (r100 > r101) goto L4;
            a(r100);
            r100 = (char) (r100 + 1);
            goto L2
        }
    }

    public static C0027a a() {
        return new C0027a(new BitSet());
    }

    public final C0027a b() {
        return new C0027a((BitSet) this.f2208a.clone());
    }

    public a(C0027a r100) {
        this.f2208a = r100.f2209a;
    }
}
