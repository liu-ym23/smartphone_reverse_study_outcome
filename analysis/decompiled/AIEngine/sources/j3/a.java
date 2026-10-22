package j3;

import androidx.preference.c;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import i3.d;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b3.a f9684a;

    /* renamed from: b, reason: collision with root package name */
    public final DeserializationConfig f9685b;

    /* renamed from: c, reason: collision with root package name */
    public final AnnotationIntrospector f9686c;

    /* renamed from: d, reason: collision with root package name */
    public final List<AnnotatedConstructor> f9687d;

    /* renamed from: e, reason: collision with root package name */
    public final AnnotatedConstructor f9688e;

    /* renamed from: f, reason: collision with root package name */
    public final c[] f9689f;

    public a(DeserializationContext deserializationContext, b3.a aVar) {
        AnnotatedConstructor annotatedConstructor;
        this.f9684a = aVar;
        DeserializationConfig deserializationConfig = deserializationContext.f3663c;
        this.f9686c = deserializationConfig.d();
        this.f9685b = deserializationConfig;
        RuntimeException runtimeException = b.f9691e;
        if (runtimeException != null) {
            throw runtimeException;
        }
        b bVar = b.f9690d;
        Class<?> cls = aVar.f3041a.f3690a;
        Object[] objArrA = bVar.a(cls);
        int length = objArrA.length;
        c[] cVarArr = new c[length];
        int i10 = 0;
        while (true) {
            annotatedConstructor = null;
            if (i10 >= objArrA.length) {
                break;
            }
            try {
                String str = (String) bVar.f9693b.invoke(objArrA[i10], null);
                try {
                    Class cls2 = (Class) bVar.f9694c.invoke(objArrA[i10], null);
                    c cVar = new c();
                    cVar.f2400a = cls2;
                    cVar.f2401b = str;
                    cVarArr[i10] = cVar;
                    i10++;
                } catch (Exception e10) {
                    throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", Integer.valueOf(i10), Integer.valueOf(objArrA.length), com.fasterxml.jackson.databind.util.a.y(cls)), e10);
                }
            } catch (Exception e11) {
                throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i10), Integer.valueOf(objArrA.length), com.fasterxml.jackson.databind.util.a.y(cls)), e11);
            }
        }
        this.f9689f = cVarArr;
        if (length != 0) {
            List<AnnotatedConstructor> list = ((d) aVar).f9499e.g().f4188b;
            this.f9687d = list;
            Iterator<AnnotatedConstructor> it = list.iterator();
            loop1: while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AnnotatedConstructor next = it.next();
                if (next.s() == length) {
                    for (int i11 = 0; i11 < length; i11++) {
                        if (!next.u(i11).equals((Class) this.f9689f[i11].f2400a)) {
                            break;
                        }
                    }
                    annotatedConstructor = next;
                    break loop1;
                }
            }
        } else {
            annotatedConstructor = ((d) aVar).f9499e.g().f4187a;
            this.f9687d = Collections.singletonList(annotatedConstructor);
        }
        if (annotatedConstructor == null) {
            throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + com.fasterxml.jackson.databind.util.a.r(this.f9684a.f3041a));
        }
        this.f9688e = annotatedConstructor;
    }
}
