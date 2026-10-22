package d;

import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2927a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ String f2928b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ e.b f2929c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ h f2930d;

    @Override // d.c
    public final void a(Cloneable cloneable) throws Exception {
        switch (this.f2927a) {
            case 0:
                e.b bVar = this.f2929c;
                h hVar = this.f2930d;
                HashMap map = hVar.f2936b;
                String str = this.f2928b;
                Integer num = (Integer) map.get(str);
                if (num != null) {
                    hVar.f2938d.add(str);
                    try {
                        hVar.b(num.intValue(), bVar, cloneable);
                        return;
                    } catch (Exception e10) {
                        hVar.f2938d.remove(str);
                        throw e10;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + bVar + " and input " + cloneable + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                e.b bVar2 = this.f2929c;
                h hVar2 = this.f2930d;
                HashMap map2 = hVar2.f2936b;
                String str2 = this.f2928b;
                Integer num2 = (Integer) map2.get(str2);
                if (num2 != null) {
                    hVar2.f2938d.add(str2);
                    try {
                        hVar2.b(num2.intValue(), bVar2, cloneable);
                        return;
                    } catch (Exception e11) {
                        hVar2.f2938d.remove(str2);
                        throw e11;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + bVar2 + " and input " + cloneable + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }

    public void b() {
        this.f2930d.e(this.f2928b);
    }
}
