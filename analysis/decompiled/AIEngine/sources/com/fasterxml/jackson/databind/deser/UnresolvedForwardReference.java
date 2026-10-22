package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.a;
import e3.k;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class UnresolvedForwardReference extends JsonMappingException {

    /* renamed from: e, reason: collision with root package name */
    public final a f3900e;
    public ArrayList h;

    public UnresolvedForwardReference(JsonParser jsonParser, String str, JsonLocation jsonLocation, a aVar) {
        super(jsonParser, str, jsonLocation);
        this.f3900e = aVar;
    }

    @Override // com.fasterxml.jackson.databind.JsonMappingException, com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public final String getMessage() {
        String strD = d();
        ArrayList arrayList = this.h;
        if (arrayList == null) {
            return strD;
        }
        StringBuilder sb2 = new StringBuilder(strD);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append(((k) it.next()).toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append('.');
        return sb2.toString();
    }
}
