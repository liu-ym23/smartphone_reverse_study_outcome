package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public a f1214a;

    /* renamed from: b, reason: collision with root package name */
    public String f1215b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f1216c;

    /* renamed from: d, reason: collision with root package name */
    public int f1217d;

    public final int a() {
        int i = this.f1217d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}
