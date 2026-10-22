package Yb;

/* renamed from: Yb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC1128b extends u {
    @Override // Yb.u
    public void j(u uVar) {
        if (!(uVar instanceof AbstractC1128b)) {
            throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
        }
        super.j(uVar);
    }

    @Override // Yb.u
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public AbstractC1128b f() {
        return (AbstractC1128b) super.f();
    }
}
