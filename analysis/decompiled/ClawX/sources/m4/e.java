package m4;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a5.e f3906a;

    static {
        String property = System.getProperty("ktor.internal.cio.disable.chararray.pooling");
        f3906a = property != null ? Boolean.parseBoolean(property) : false ? new d() : new a5.a(4096, 3);
    }
}
