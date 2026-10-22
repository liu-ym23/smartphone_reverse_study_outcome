package com.fasterxml.jackson.databind.node;

import b3.d;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ObjectNode extends ContainerNode<ObjectNode> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4283b;

    public ObjectNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
        this.f4283b = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.fasterxml.jackson.core.JsonGenerator r5, b3.h r6) {
        /*
            r4 = this;
            if (r6 == 0) goto Le
            com.fasterxml.jackson.databind.SerializationFeature r0 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_EMPTY_JSON_ARRAYS
            com.fasterxml.jackson.databind.SerializationConfig r1 = r6.f3044a
            boolean r0 = r1.q(r0)
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            r5.d1(r4)
            java.util.LinkedHashMap r4 = r4.f4283b
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L1c:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L4b
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            com.fasterxml.jackson.databind.node.BaseJsonNode r2 = (com.fasterxml.jackson.databind.node.BaseJsonNode) r2
            if (r0 == 0) goto L3e
            r2.getClass()
            boolean r3 = r2 instanceof com.fasterxml.jackson.databind.node.ArrayNode
            if (r3 == 0) goto L3e
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L3e
            goto L1c
        L3e:
            java.lang.Object r1 = r1.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r5.H0(r1)
            r2.a(r5, r6)
            goto L1c
        L4b:
            r5.G0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.node.ObjectNode.a(com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    @Override // b3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.fasterxml.jackson.core.JsonGenerator r6, b3.h r7, k3.e r8) {
        /*
            r5 = this;
            if (r7 == 0) goto Le
            com.fasterxml.jackson.databind.SerializationFeature r0 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_EMPTY_JSON_ARRAYS
            com.fasterxml.jackson.databind.SerializationConfig r1 = r7.f3044a
            boolean r0 = r1.q(r0)
            if (r0 != 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            com.fasterxml.jackson.core.type.WritableTypeId r1 = r8.d(r1, r5)
            com.fasterxml.jackson.core.type.WritableTypeId r1 = r8.e(r6, r1)
            java.util.LinkedHashMap r5 = r5.f4283b
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L23:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L52
            java.lang.Object r2 = r5.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            com.fasterxml.jackson.databind.node.BaseJsonNode r3 = (com.fasterxml.jackson.databind.node.BaseJsonNode) r3
            if (r0 == 0) goto L45
            r3.getClass()
            boolean r4 = r3 instanceof com.fasterxml.jackson.databind.node.ArrayNode
            if (r4 == 0) goto L45
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L45
            goto L23
        L45:
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r6.H0(r2)
            r3.a(r6, r7)
            goto L23
        L52:
            r8.f(r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.node.ObjectNode.b(com.fasterxml.jackson.core.JsonGenerator, b3.h, k3.e):void");
    }

    @Override // b3.d
    public final Iterator<d> c() {
        return this.f4283b.values().iterator();
    }

    @Override // b3.d
    public final Iterator<Map.Entry<String, d>> d() {
        return this.f4283b.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ObjectNode)) {
            return this.f4283b.equals(((ObjectNode) obj).f4283b);
        }
        return false;
    }

    @Override // b3.d
    public final d f(String str) {
        return (d) this.f4283b.get(str);
    }

    @Override // b3.d
    public final JsonNodeType g() {
        return JsonNodeType.f4275j;
    }

    public final d h(String str, d dVar) {
        if (dVar == null) {
            this.f4262a.getClass();
            dVar = NullNode.f4282a;
        }
        return (d) this.f4283b.put(str, dVar);
    }

    public final int hashCode() {
        return this.f4283b.hashCode();
    }

    @Override // b3.e.a
    public final boolean isEmpty() {
        return this.f4283b.isEmpty();
    }
}
