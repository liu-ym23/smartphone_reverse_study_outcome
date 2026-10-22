package ap4;

import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ETableType f15858a;

    @Override // ap4.b
    public final boolean c() {
        if (this.f15858a != ETableType.CARD) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ap4.b
    public final String l() {
        if (this.f15858a != ETableType.FORM) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        return "form";
    L10:
        if (c() == false) goto L13;
        return "record";
    L13:
        return null;
    L5:
        r100 = false;
        goto L6
    }

    public c() {
        this.f15858a = ETableType.CARD;
    }

    @Override // ap4.b
    public final void k(ETableType r100) {
        this.f15858a = r100;
    }
}
