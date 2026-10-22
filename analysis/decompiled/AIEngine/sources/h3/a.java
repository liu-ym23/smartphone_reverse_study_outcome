package h3;

import com.fasterxml.jackson.databind.ext.NioPathDeserializer;
import com.fasterxml.jackson.databind.ext.NioPathSerializer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9290a;

    static {
        a aVar;
        try {
            aVar = (a) com.fasterxml.jackson.databind.util.a.h(b.class, false);
        } catch (Throwable unused) {
            aVar = null;
        }
        f9290a = aVar;
    }

    public abstract NioPathDeserializer a(Class cls);

    public abstract NioPathSerializer b(Class cls);
}
