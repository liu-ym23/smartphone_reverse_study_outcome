package com.fasterxml.jackson.databind.node;

import b3.d;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ArrayNode extends ContainerNode<ArrayNode> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4255b;

    public ArrayNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
        this.f4255b = new ArrayList();
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        ArrayList arrayList = this.f4255b;
        int size = arrayList.size();
        jsonGenerator.b1(this);
        for (int i10 = 0; i10 < size; i10++) {
            ((BaseJsonNode) ((d) arrayList.get(i10))).a(jsonGenerator, hVar);
        }
        jsonGenerator.C0();
    }

    @Override // b3.e
    public final void b(JsonGenerator jsonGenerator, h hVar, e eVar) {
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.START_ARRAY, this));
        ArrayList arrayList = this.f4255b;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((BaseJsonNode) ((d) obj)).a(jsonGenerator, hVar);
        }
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    @Override // b3.d
    public final Iterator<d> c() {
        return this.f4255b.iterator();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ArrayNode)) {
            return false;
        }
        return this.f4255b.equals(((ArrayNode) obj).f4255b);
    }

    @Override // b3.d
    public final d f(String str) {
        return null;
    }

    @Override // b3.d
    public final JsonNodeType g() {
        return JsonNodeType.f4270a;
    }

    public final void h(d dVar) {
        if (dVar == null) {
            this.f4262a.getClass();
            dVar = NullNode.f4282a;
        }
        this.f4255b.add(dVar);
    }

    public final int hashCode() {
        return this.f4255b.hashCode();
    }

    @Override // b3.e.a
    public final boolean isEmpty() {
        return this.f4255b.isEmpty();
    }
}
