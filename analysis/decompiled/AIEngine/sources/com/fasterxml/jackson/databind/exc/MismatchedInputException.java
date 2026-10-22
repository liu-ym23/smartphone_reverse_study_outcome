package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.a;
import java.lang.annotation.Annotation;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MismatchedInputException extends JsonMappingException {
    public MismatchedInputException(JsonParser jsonParser, String str, int i10) {
        super(jsonParser, str);
        Annotation[] annotationArr = a.f4529a;
    }
}
