package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.databind.node.ContainerNode;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ContainerNode<T extends ContainerNode<T>> extends BaseJsonNode {

    /* renamed from: a, reason: collision with root package name */
    public final JsonNodeFactory f4262a;

    public ContainerNode(JsonNodeFactory jsonNodeFactory) {
        this.f4262a = jsonNodeFactory;
    }
}
