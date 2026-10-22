package com.fasterxml.jackson.core;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JsonProcessingException extends JacksonException {

    /* renamed from: a, reason: collision with root package name */
    public JsonLocation f3580a;

    public JsonProcessingException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str, th);
        this.f3580a = jsonLocation;
    }

    public String a() {
        return null;
    }

    public final String b() {
        return super.getMessage();
    }

    public Object c() {
        return null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        JsonLocation jsonLocation = this.f3580a;
        String strA = a();
        if (jsonLocation == null && strA == null) {
            return message;
        }
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append(message);
        if (strA != null) {
            sb2.append(strA);
        }
        if (jsonLocation != null) {
            sb2.append("\n at ");
            sb2.append(jsonLocation.toString());
        }
        return sb2.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
