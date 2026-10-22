package com.fasterxml.jackson.databind;

import ai.onnxruntime.a;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.stepos.core.common.telemetry.FailStage;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import u2.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JsonMappingException extends JsonProcessingException {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f3695d = 0;

    /* renamed from: b, reason: collision with root package name */
    public LinkedList<Reference> f3696b;

    /* renamed from: c, reason: collision with root package name */
    public final transient Closeable f3697c;

    public JsonMappingException(Closeable closeable, String str) {
        super(str);
        this.f3697c = closeable;
        if (closeable instanceof JsonParser) {
            this.f3580a = ((JsonParser) closeable).Z0();
        }
    }

    public static JsonMappingException e(IOException iOException) {
        return new JsonMappingException(null, a.l("Unexpected IOException (of type ", iOException.getClass().getName(), "): ", com.fasterxml.jackson.databind.util.a.i(iOException)));
    }

    public static JsonMappingException g(Throwable th, Reference reference) {
        JsonMappingException jsonMappingException;
        Object objC;
        if (th instanceof JsonMappingException) {
            jsonMappingException = (JsonMappingException) th;
        } else {
            String strI = com.fasterxml.jackson.databind.util.a.i(th);
            if (strI == null || strI.isEmpty()) {
                strI = "(was " + th.getClass().getName() + ")";
            }
            jsonMappingException = new JsonMappingException((!(th instanceof JsonProcessingException) || (objC = ((JsonProcessingException) th).c()) == null) ? null : (Closeable) objC, strI, th);
        }
        jsonMappingException.f(reference);
        return jsonMappingException;
    }

    public static JsonMappingException h(Throwable th, Object obj, int i10) {
        Reference reference = new Reference();
        reference.f3698a = obj;
        reference.f3700c = i10;
        return g(th, reference);
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    @k
    public final Object c() {
        return this.f3697c;
    }

    public final String d() {
        String message = super.getMessage();
        if (this.f3696b == null) {
            return message;
        }
        StringBuilder sb2 = message == null ? new StringBuilder() : new StringBuilder(message);
        sb2.append(" (through reference chain: ");
        LinkedList<Reference> linkedList = this.f3696b;
        if (linkedList != null) {
            Iterator<Reference> it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().a());
                if (it.hasNext()) {
                    sb2.append("->");
                }
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public final void f(Reference reference) {
        if (this.f3696b == null) {
            this.f3696b = new LinkedList<>();
        }
        if (this.f3696b.size() < 1000) {
            this.f3696b.addFirst(reference);
        }
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return d();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return d();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public final String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Reference implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public transient Object f3698a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3699b;

        /* renamed from: c, reason: collision with root package name */
        public int f3700c = -1;

        /* renamed from: d, reason: collision with root package name */
        public String f3701d;

        public Reference() {
        }

        public final String a() {
            if (this.f3701d == null) {
                StringBuilder sb2 = new StringBuilder();
                Object obj = this.f3698a;
                if (obj != null) {
                    Class<?> componentType = obj instanceof Class ? (Class) obj : obj.getClass();
                    int i10 = 0;
                    while (componentType.isArray()) {
                        componentType = componentType.getComponentType();
                        i10++;
                    }
                    sb2.append(componentType.getName());
                    while (true) {
                        i10--;
                        if (i10 < 0) {
                            break;
                        }
                        sb2.append("[]");
                    }
                } else {
                    sb2.append(FailStage.UNKNOWN);
                }
                sb2.append('[');
                String str = this.f3699b;
                if (str != null) {
                    sb2.append('\"');
                    sb2.append(str);
                    sb2.append('\"');
                } else {
                    int i11 = this.f3700c;
                    if (i11 >= 0) {
                        sb2.append(i11);
                    } else {
                        sb2.append('?');
                    }
                }
                sb2.append(']');
                this.f3701d = sb2.toString();
            }
            return this.f3701d;
        }

        public final String toString() {
            return a();
        }

        public Object writeReplace() {
            a();
            return this;
        }

        public Reference(Object obj, String str) {
            this.f3698a = obj;
            if (str != null) {
                this.f3699b = str;
                return;
            }
            throw new NullPointerException("Cannot pass null fieldName");
        }
    }

    public JsonMappingException(JsonParser jsonParser, String str, JsonLocation jsonLocation) {
        super(str, jsonLocation, null);
        this.f3697c = jsonParser;
    }

    public JsonMappingException(Closeable closeable, String str, Throwable th) {
        super(str, null, th);
        this.f3697c = closeable;
        if (th instanceof JsonProcessingException) {
            this.f3580a = ((JsonProcessingException) th).f3580a;
        } else if (closeable instanceof JsonParser) {
            this.f3580a = ((JsonParser) closeable).Z0();
        }
    }
}
