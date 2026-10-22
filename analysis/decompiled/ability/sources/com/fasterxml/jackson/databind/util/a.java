package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.function.BinaryOperator;
import reactor.core.Scannable;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements BinaryOperator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2270a;

    public /* synthetic */ a(int i) {
        this.f2270a = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f2270a) {
            case 0:
                return ((ArrayNode) obj).addAll((ArrayNode) obj2);
            default:
                return Scannable.lambda$tagsDeduplicated$2((String) obj, (String) obj2);
        }
    }
}
