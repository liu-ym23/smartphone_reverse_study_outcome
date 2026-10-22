package com.fasterxml.jackson.databind.node;

import a3.i;
import b3.d;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.io.Serializable;
import m3.a;
import x2.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BaseJsonNode extends d implements Serializable {
    @Override // b3.e
    public abstract void a(JsonGenerator jsonGenerator, h hVar);

    public String toString() throws JsonProcessingException {
        try {
            ObjectWriter objectWriter = a.f10485b;
            objectWriter.getClass();
            f fVar = new f(objectWriter.f3738d.a());
            try {
                try {
                    objectWriter.a(objectWriter.b(fVar), this);
                    i iVar = fVar.f13730a;
                    String strH = iVar.h();
                    iVar.n();
                    return strH;
                } catch (IOException e10) {
                    throw JsonMappingException.e(e10);
                }
            } catch (JsonProcessingException e11) {
                throw e11;
            }
        } catch (IOException e12) {
            throw new RuntimeException(e12);
        }
    }

    public Object writeReplace() {
        try {
            byte[] bArrA = a.a(this);
            NodeSerialization nodeSerialization = new NodeSerialization();
            nodeSerialization.f4281a = bArrA;
            return nodeSerialization;
        } catch (IOException e10) {
            throw new IllegalArgumentException("Failed to JDK serialize `" + getClass().getSimpleName() + "` value: " + e10.getMessage(), e10);
        }
    }
}
