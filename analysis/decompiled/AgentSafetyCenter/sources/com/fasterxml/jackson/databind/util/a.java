package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.function.BinaryOperator;
import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements BinaryOperator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2307c;

    public /* synthetic */ a(int i) {
        this.f2307c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f2307c) {
            case 0:
                return ((ArrayNode) obj).addAll((ArrayNode) obj2);
            default:
                return Scannable.lambda$tagsDeduplicated$2((String) obj, (String) obj2);
        }
    }
}
