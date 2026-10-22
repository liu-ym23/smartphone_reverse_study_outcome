package J4;

import C7.r;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f872a;
    public final /* synthetic */ com.stepos.ability.voicewakeup.ui.d b;
    public final /* synthetic */ com.stepos.ability.voicewakeup.ui.c c;

    public /* synthetic */ d(com.stepos.ability.voicewakeup.ui.d dVar, com.stepos.ability.voicewakeup.ui.c cVar, int i) {
        this.f872a = i;
        this.b = dVar;
        this.c = cVar;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f872a;
        r rVar = r.f317a;
        com.stepos.ability.voicewakeup.ui.c cVar = this.c;
        com.stepos.ability.voicewakeup.ui.d dVar = this.b;
        switch (i) {
            case 0:
                AtomicLong atomicLong = com.stepos.ability.voicewakeup.ui.d.g;
                if (dVar.h(cVar) && !cVar.f3439q) {
                    dVar.i("sdk_start", cVar, "");
                    break;
                }
                break;
            case 1:
                AtomicLong atomicLong2 = com.stepos.ability.voicewakeup.ui.d.g;
                if (dVar.h(cVar) && !cVar.f3439q) {
                    dVar.i("sdk_cancel", cVar, "");
                    break;
                }
                break;
            default:
                AtomicLong atomicLong3 = com.stepos.ability.voicewakeup.ui.d.g;
                if (dVar.h(cVar) && !cVar.f3439q) {
                    dVar.i("first_update", cVar, "");
                    break;
                }
                break;
        }
        return rVar;
    }
}
