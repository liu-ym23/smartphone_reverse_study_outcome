package com.networknt.schema.resource;

import com.networknt.schema.AbsoluteIri;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface ResourceLoader {
    InputStreamSource getResource(AbsoluteIri absoluteIri);
}
