package ia;

import java.io.IOException;

/* renamed from: ia.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4183c {

    /* renamed from: a, reason: collision with root package name */
    public AbstractC4182b f33093a;

    /* renamed from: b, reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.protobuf.d f33094b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f33095c;

    /* renamed from: d, reason: collision with root package name */
    public volatile kotlin.reflect.jvm.internal.impl.protobuf.h f33096d;

    public void a(kotlin.reflect.jvm.internal.impl.protobuf.h hVar) {
        if (this.f33096d != null) {
            return;
        }
        synchronized (this) {
            if (this.f33096d != null) {
                return;
            }
            try {
                if (this.f33093a != null) {
                    this.f33096d = hVar.getParserForType().b(this.f33093a, this.f33094b);
                } else {
                    this.f33096d = hVar;
                }
            } catch (IOException unused) {
            }
        }
    }

    public int b() {
        return this.f33095c ? this.f33096d.getSerializedSize() : this.f33093a.size();
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.h c(kotlin.reflect.jvm.internal.impl.protobuf.h hVar) {
        a(hVar);
        return this.f33096d;
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.h d(kotlin.reflect.jvm.internal.impl.protobuf.h hVar) {
        kotlin.reflect.jvm.internal.impl.protobuf.h hVar2 = this.f33096d;
        this.f33096d = hVar;
        this.f33093a = null;
        this.f33095c = true;
        return hVar2;
    }
}
