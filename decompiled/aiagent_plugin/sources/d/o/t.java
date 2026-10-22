package d.o;

/* JADX INFO: compiled from: StringBuilderJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class t extends s {
    public t() {
    }

    private static final StringBuilder insert(StringBuilder r1, int r2, byte r3) {
        d.h.b.o.e(r1, "<this>");
        StringBuilder r4 = r1.insert(r2, r3);
        d.h.b.o.c(r4, "insert(...)");
        return r4;
    }

    private static final StringBuilder insert(StringBuilder r1, int r2, short r3) {
        d.h.b.o.e(r1, "<this>");
        StringBuilder r4 = r1.insert(r2, r3);
        d.h.b.o.c(r4, "insert(...)");
        return r4;
    }

    public static final StringBuilder a(StringBuilder r1) {
        d.h.b.o.e(r1, "<this>");
        r1.setLength(0);
        return r1;
    }
}
