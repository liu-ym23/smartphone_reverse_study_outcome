package m5;

import java.io.File;
import java.util.Iterator;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j implements w5.i {

    /* renamed from: a, reason: collision with root package name */
    public final File f3920a;

    /* renamed from: b, reason: collision with root package name */
    public final k f3921b;

    /* renamed from: c, reason: collision with root package name */
    public final p f3922c;

    public j(File file, k kVar, com.stepos.stepclaw.c cVar) {
        this.f3920a = file;
        this.f3921b = kVar;
        this.f3922c = cVar;
    }

    @Override // w5.i
    public final Iterator iterator() {
        return new h(this);
    }
}
