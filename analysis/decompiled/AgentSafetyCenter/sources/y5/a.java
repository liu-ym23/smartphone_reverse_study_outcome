package y5;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15898a;

    public /* synthetic */ a(int i) {
        this.f15898a = i;
    }

    @Override // y5.f
    public final g a(Object obj, e6.m mVar) {
        switch (this.f15898a) {
            case 0:
                Uri uri = (Uri) obj;
                if (!i6.d.c(uri)) {
                    return null;
                }
                b bVar = new b(0);
                bVar.f15900b = uri;
                bVar.f15901c = mVar;
                VarHandle.storeStoreFence();
                return bVar;
            case 1:
                c cVar = new c(0);
                cVar.f15904c = (Bitmap) obj;
                cVar.f15903b = mVar;
                VarHandle.storeStoreFence();
                return cVar;
            case 2:
                c cVar2 = new c(1);
                cVar2.f15904c = (ByteBuffer) obj;
                cVar2.f15903b = mVar;
                VarHandle.storeStoreFence();
                return cVar2;
            case 3:
                Uri uri2 = (Uri) obj;
                if (!yb.k.a(uri2.getScheme(), "content")) {
                    return null;
                }
                b bVar2 = new b(1);
                bVar2.f15900b = uri2;
                bVar2.f15901c = mVar;
                VarHandle.storeStoreFence();
                return bVar2;
            case 4:
                c cVar3 = new c(2);
                cVar3.f15904c = (Drawable) obj;
                cVar3.f15903b = mVar;
                VarHandle.storeStoreFence();
                return cVar3;
            case 5:
                h hVar = new h();
                hVar.f15908a = (File) obj;
                VarHandle.storeStoreFence();
                return hVar;
            default:
                Uri uri3 = (Uri) obj;
                if (!yb.k.a(uri3.getScheme(), "android.resource")) {
                    return null;
                }
                b bVar3 = new b(2);
                bVar3.f15900b = uri3;
                bVar3.f15901c = mVar;
                VarHandle.storeStoreFence();
                return bVar3;
        }
    }
}
