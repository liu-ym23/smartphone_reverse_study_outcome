package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import com.fasterxml.jackson.databind.util.TypeKey;
import java.util.function.BiConsumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ ReadOnlyClassToSerializerMap f2305c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ReadOnlyClassToSerializerMap.Bucket[] f2306f;

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        this.f2305c.lambda$new$0(this.f2306f, (TypeKey) obj, (JsonSerializer) obj2);
    }
}
