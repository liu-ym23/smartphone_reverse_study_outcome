package org.yaml.snakeyaml.introspector;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class MissingProperty extends Property {
    public MissingProperty(String str) {
        super(str, Object.class);
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Object get(Object obj) {
        return obj;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public Class<?>[] getActualTypeArguments() {
        return new Class[0];
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public List<Annotation> getAnnotations() {
        return Collections.EMPTY_LIST;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public void set(Object obj, Object obj2) throws Exception {
    }
}
