package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.ExceptionUtil;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class Java7Support {
    private static final Java7Support IMPL;

    static {
        Java7Support java7Support;
        try {
            java7Support = (Java7Support) ClassUtil.createInstance(Java7SupportImpl.class, false);
        } catch (IllegalAccessError unused) {
            java7Support = null;
            IMPL = java7Support;
        } catch (Throwable th) {
            ExceptionUtil.rethrowIfFatal(th);
            java7Support = null;
            IMPL = java7Support;
        }
        IMPL = java7Support;
    }

    public static Java7Support instance() {
        return IMPL;
    }

    public abstract PropertyName findConstructorName(AnnotatedParameter annotatedParameter);

    public abstract Boolean findTransient(Annotated annotated);

    public abstract Boolean hasCreatorAnnotation(Annotated annotated);
}
