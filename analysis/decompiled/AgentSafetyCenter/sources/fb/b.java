package fb;

import aa.p;
import com.stepos.widget.toolbar.StepOSTitleBar;
import jb.v;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ float f4050c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f4051f;

    @Override // xb.l
    public final Object invoke(Object obj) {
        float f5 = this.f4050c;
        int i = this.f4051f;
        p pVar = (p) obj;
        int i3 = StepOSTitleBar.f2893c0;
        pVar.getClass();
        pVar.f315c = f5;
        int i10 = pVar.f352h;
        int i11 = pVar.i;
        int i12 = pVar.f353j;
        pVar.f352h = StepOSTitleBar.t(((i10 >>> 24) & 255) / 255.0f, i);
        pVar.i = StepOSTitleBar.t(((i11 >>> 24) & 255) / 255.0f, i);
        pVar.f353j = StepOSTitleBar.t(((i12 >>> 24) & 255) / 255.0f, i);
        return v.f6774a;
    }
}
