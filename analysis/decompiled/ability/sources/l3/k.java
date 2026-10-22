package l3;

/* loaded from: classes3.dex */
public final class k extends com.google.common.cache.d {
    public final /* synthetic */ int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(com.google.common.cache.e eVar, int i) {
        super(eVar);
        this.i = i;
    }

    @Override // com.google.common.cache.d, java.util.Iterator
    public Object next() {
        switch (this.i) {
            case 1:
                return c().f5284a;
            case 2:
                return c().b;
            default:
                return super.next();
        }
    }
}
