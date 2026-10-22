package q4;

import java.nio.charset.Charset;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f4842a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4843b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f4844c;

    public a(Charset charset) {
        p.e(charset, "charset");
        this.f4842a = x.e.x0("[", charset);
        this.f4843b = x.e.x0("]", charset);
        this.f4844c = x.e.x0(",", charset);
    }
}
