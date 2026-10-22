package h3;

import com.fasterxml.jackson.databind.ext.NioPathDeserializer;
import com.fasterxml.jackson.databind.ext.NioPathSerializer;
import java.nio.file.Path;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f9291b = Path.class;

    @Override // h3.a
    public final NioPathDeserializer a(Class cls) {
        if (cls == this.f9291b) {
            return new NioPathDeserializer();
        }
        return null;
    }

    @Override // h3.a
    public final NioPathSerializer b(Class cls) {
        if (this.f9291b.isAssignableFrom(cls)) {
            return new NioPathSerializer();
        }
        return null;
    }
}
