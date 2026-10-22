package v;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class l extends C0944d {

    /* renamed from: q0, reason: collision with root package name */
    public ArrayList f15674q0;

    @Override // v.C0944d
    public void D() {
        this.f15674q0.clear();
        super.D();
    }

    @Override // v.C0944d
    public final void G(t.d dVar) {
        super.G(dVar);
        int size = this.f15674q0.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((C0944d) this.f15674q0.get(i4)).G(dVar);
        }
    }

    public abstract void S();
}
