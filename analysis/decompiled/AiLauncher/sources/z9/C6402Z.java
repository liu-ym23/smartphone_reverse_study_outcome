package z9;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;

/* renamed from: z9.Z, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6402Z implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final p9.p f45336a;

    public C6402Z(p9.p pVar) {
        this.f45336a = pVar;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return KDeclarationContainerImpl.F(this.f45336a, obj, obj2);
    }
}
