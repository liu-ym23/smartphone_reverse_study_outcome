package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/* loaded from: classes2.dex */
public interface JsonGeneratorDecorator {
    JsonGenerator decorate(JsonFactory jsonFactory, JsonGenerator jsonGenerator);
}
