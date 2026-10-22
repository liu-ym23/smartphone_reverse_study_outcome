package d4;

import C7.r;
import android.content.Context;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4289a;
    public final /* synthetic */ com.stepos.ability.manager.sync.a b;
    public final /* synthetic */ Context c;

    public /* synthetic */ a(com.stepos.ability.manager.sync.a aVar, Context context, int i) {
        this.f4289a = i;
        this.b = aVar;
        this.c = context;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f4289a) {
            case 0:
                this.b.f(this.c);
                break;
            default:
                this.b.f(this.c);
                break;
        }
        return r.f317a;
    }
}
