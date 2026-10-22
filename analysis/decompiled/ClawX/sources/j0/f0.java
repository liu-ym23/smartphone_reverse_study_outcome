package j0;

import java.io.File;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f0 extends kotlin.jvm.internal.q implements p5.l {

    /* renamed from: b, reason: collision with root package name */
    public static final f0 f3342b = new f0(1);

    @Override // p5.l
    public final Object invoke(Object obj) {
        File it = (File) obj;
        kotlin.jvm.internal.p.e(it, "it");
        String absolutePath = it.getCanonicalFile().getAbsolutePath();
        kotlin.jvm.internal.p.d(absolutePath, "file.canonicalFile.absolutePath");
        return new u0(absolutePath);
    }
}
