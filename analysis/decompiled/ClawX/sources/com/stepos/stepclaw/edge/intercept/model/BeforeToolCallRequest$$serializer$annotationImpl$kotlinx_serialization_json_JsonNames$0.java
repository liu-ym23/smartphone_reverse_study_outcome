package com.stepos.stepclaw.edge.intercept.model;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.JsonNames;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class BeforeToolCallRequest$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0 implements JsonNames {
    private final /* synthetic */ String[] names;

    public BeforeToolCallRequest$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(String[] names) {
        p.e(names, "names");
        this.names = names;
    }

    @Override // java.lang.annotation.Annotation
    public final /* synthetic */ Class annotationType() {
        return JsonNames.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        return (obj instanceof JsonNames) && Arrays.equals(names(), ((JsonNames) obj).names());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return Arrays.hashCode(this.names) ^ 397397176;
    }

    @Override // kotlinx.serialization.json.JsonNames
    public final /* synthetic */ String[] names() {
        return this.names;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return f.d("@kotlinx.serialization.json.JsonNames(names=", Arrays.toString(this.names), ")");
    }
}
