package i3;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements Iterable<AnnotatedMethod> {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashMap f9492a;

    @Override // java.lang.Iterable
    public final Iterator<AnnotatedMethod> iterator() {
        LinkedHashMap linkedHashMap = this.f9492a;
        return linkedHashMap == null ? Collections.emptyIterator() : linkedHashMap.values().iterator();
    }
}
