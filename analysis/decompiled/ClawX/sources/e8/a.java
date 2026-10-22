package e8;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends b {
    static {
        z7.d.b(a.class);
    }

    @Override // e8.i
    public final void a() throws e {
        g();
        throw new e("Context must be initialized by calling setContext");
    }

    @Override // e8.i
    public final boolean isEnabled() {
        return System.getProperty("java.vendor").contains("Android");
    }
}
