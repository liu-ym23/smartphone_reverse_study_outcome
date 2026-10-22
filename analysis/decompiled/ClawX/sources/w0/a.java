package w0;

import java.util.LinkedHashSet;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f6074a = new LinkedHashSet();

    public a(e eVar) {
        Object obj;
        i.f fVar = eVar.f6076a;
        i.c cVarF = fVar.f("androidx.savedstate.Restarter");
        if (cVarF != null) {
            obj = cVarF.f3081b;
        } else {
            i.c cVar = new i.c("androidx.savedstate.Restarter", this);
            fVar.d++;
            i.c cVar2 = fVar.f3087b;
            if (cVar2 == null) {
                fVar.f3086a = cVar;
                fVar.f3087b = cVar;
            } else {
                cVar2.f3082c = cVar;
                cVar.d = cVar2;
                fVar.f3087b = cVar;
            }
            obj = null;
        }
        if (((d) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }
}
