package o3;

import b3.h;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import v2.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ObjectIdGenerator<?> f10751a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10752b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10753c = false;

    public d(ObjectIdGenerator<?> objectIdGenerator) {
        this.f10751a = objectIdGenerator;
    }

    public final void a(JsonGenerator jsonGenerator, h hVar, a aVar) throws JsonGenerationException {
        this.f10753c = true;
        if (jsonGenerator.w()) {
            Object obj = this.f10752b;
            jsonGenerator.S0(obj == null ? null : String.valueOf(obj));
            return;
        }
        e eVar = aVar.f10738b;
        if (eVar != null) {
            jsonGenerator.I0(eVar);
            aVar.f10740d.f(this.f10752b, jsonGenerator, hVar);
        }
    }

    public final boolean b(JsonGenerator jsonGenerator, h hVar, a aVar) throws JsonGenerationException {
        if (this.f10752b == null) {
            return false;
        }
        if (!this.f10753c && !aVar.f10741e) {
            return false;
        }
        if (jsonGenerator.w()) {
            String.valueOf(this.f10752b);
            throw new JsonGenerationException("No native support for writing Object Ids", jsonGenerator);
        }
        aVar.f10740d.f(this.f10752b, jsonGenerator, hVar);
        return true;
    }
}
