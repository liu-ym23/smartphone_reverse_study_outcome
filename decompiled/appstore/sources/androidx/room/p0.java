package androidx.room;

/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f4635a = null;

    static {
        f4635a = new p0();
    }

    public p0() {
    }

    public static final String a(String r10) {
        kotlin.jvm.internal.q.g(r10, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + r10 + "')";
    }
}
