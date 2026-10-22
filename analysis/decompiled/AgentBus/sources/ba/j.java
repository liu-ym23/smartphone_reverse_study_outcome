package ba;

import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final e9.f f1608a;

    /* renamed from: b, reason: collision with root package name */
    public final ga.i f1609b;

    /* renamed from: c, reason: collision with root package name */
    public final Collection f1610c;

    /* renamed from: d, reason: collision with root package name */
    public final p7.k f1611d;

    /* renamed from: e, reason: collision with root package name */
    public final f[] f1612e;

    public j(e9.f fVar, ga.i iVar, Collection collection, p7.k kVar, f... fVarArr) {
        this.f1608a = fVar;
        this.f1609b = iVar;
        this.f1610c = collection;
        this.f1611d = kVar;
        this.f1612e = fVarArr;
    }

    public /* synthetic */ j(e9.f fVar, f[] fVarArr) {
        this(fVar, fVarArr, i.f1598h);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(e9.f fVar, f[] fVarArr, p7.k kVar) {
        this(fVar, null, null, kVar, (f[]) Arrays.copyOf(fVarArr, fVarArr.length));
        q7.k.e(fVar, "name");
    }

    public /* synthetic */ j(Collection collection, f[] fVarArr) {
        this(collection, fVarArr, i.f1600j);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Collection collection, f[] fVarArr, p7.k kVar) {
        this(null, null, collection, kVar, (f[]) Arrays.copyOf(fVarArr, fVarArr.length));
        q7.k.e(collection, "nameList");
    }
}
