package K9;

import Z9.InterfaceC1178a;
import Z9.InterfaceC1180c;
import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
public final class i extends h implements InterfaceC1180c {

    /* renamed from: c, reason: collision with root package name */
    public final Annotation f4178c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ga.e eVar, Annotation annotation) {
        super(eVar, null);
        kotlin.jvm.internal.p.i(annotation, "annotation");
        this.f4178c = annotation;
    }

    @Override // Z9.InterfaceC1180c
    public InterfaceC1178a a() {
        return new C0926g(this.f4178c);
    }
}
