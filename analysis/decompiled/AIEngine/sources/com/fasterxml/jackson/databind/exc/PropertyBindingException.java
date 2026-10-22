package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class PropertyBindingException extends MismatchedInputException {

    /* renamed from: e, reason: collision with root package name */
    public final Collection<Object> f4106e;
    public transient String h;

    public PropertyBindingException(JsonParser jsonParser, String str, JsonLocation jsonLocation, Collection collection) {
        super(jsonParser, str, jsonLocation);
        this.f4106e = collection;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    public final String a() {
        Collection<Object> collection;
        String str = this.h;
        if (str != null || (collection = this.f4106e) == null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(100);
        int size = collection.size();
        if (size != 1) {
            sb2.append(" (");
            sb2.append(size);
            sb2.append(" known properties: ");
            Iterator<Object> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                sb2.append('\"');
                sb2.append(String.valueOf(it.next()));
                sb2.append('\"');
                if (sb2.length() > 1000) {
                    sb2.append(" [truncated]");
                    break;
                }
                if (it.hasNext()) {
                    sb2.append(", ");
                }
            }
        } else {
            sb2.append(" (one known property: \"");
            sb2.append(String.valueOf(collection.iterator().next()));
            sb2.append('\"');
        }
        sb2.append("])");
        String string = sb2.toString();
        this.h = string;
        return string;
    }
}
