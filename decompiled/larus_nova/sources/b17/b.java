package b17;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends com.lynx.tasm.behavior.ui.text.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f16934q;

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void e() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void f() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void g() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void h() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final Drawable c() {
        return this.f16934q;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void j(Drawable.Callback r100) {
        this.f383090o = r100;
        this.f16934q.setCallback(r100);
    }

    public b(int r100, int r101, int[] r102) {
        super(r100, r101, r102);
        this.f16934q = new a(r100, r101);
    }
}
