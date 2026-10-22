package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader;

/* loaded from: classes5.dex */
public final class c<A, C> extends AbstractBinaryClassAnnotationLoader.a<A> {

    /* renamed from: a, reason: collision with root package name */
    public final Map<g, List<A>> f35167a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<g, C> f35168b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<g, C> f35169c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Map<g, ? extends List<? extends A>> memberAnnotations, Map<g, ? extends C> propertyConstants, Map<g, ? extends C> annotationParametersDefaultValues) {
        p.i(memberAnnotations, "memberAnnotations");
        p.i(propertyConstants, "propertyConstants");
        p.i(annotationParametersDefaultValues, "annotationParametersDefaultValues");
        this.f35167a = memberAnnotations;
        this.f35168b = propertyConstants;
        this.f35169c = annotationParametersDefaultValues;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.a
    public Map<g, List<A>> a() {
        return this.f35167a;
    }

    public final Map<g, C> b() {
        return this.f35169c;
    }

    public final Map<g, C> c() {
        return this.f35168b;
    }
}
