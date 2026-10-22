package n6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final x5.l f4070b = new x5.l("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: c, reason: collision with root package name */
    public static final x5.l f4071c = new x5.l(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a, reason: collision with root package name */
    public final String f4072a;

    public o(String mediaType, String str, String str2, String[] parameterNamesAndValues) {
        kotlin.jvm.internal.p.e(mediaType, "mediaType");
        kotlin.jvm.internal.p.e(parameterNamesAndValues, "parameterNamesAndValues");
        this.f4072a = mediaType;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof o) && kotlin.jvm.internal.p.a(((o) obj).f4072a, this.f4072a);
    }

    public final int hashCode() {
        return this.f4072a.hashCode();
    }

    public final String toString() {
        return this.f4072a;
    }
}
