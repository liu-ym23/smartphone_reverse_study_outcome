package com.fasterxml.jackson.databind.node;

import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JsonNodeFactory implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonNodeFactory f4269a = new JsonNodeFactory();

    public static TextNode a(String str) {
        TextNode textNode = TextNode.f4285b;
        if (str == null) {
            return null;
        }
        return str.isEmpty() ? TextNode.f4285b : new TextNode(str);
    }
}
