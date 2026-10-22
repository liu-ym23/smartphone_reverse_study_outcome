package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonParser;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class InvalidFormatException extends MismatchedInputException {

    /* renamed from: e, reason: collision with root package name */
    public final Object f4104e;

    public InvalidFormatException(JsonParser jsonParser, String str, Object obj) {
        super(jsonParser, str);
        this.f4104e = obj;
    }
}
