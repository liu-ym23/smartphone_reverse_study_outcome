package D9;

import C9.AbstractC0200b;
import C9.x;
import android.os.RemoteException;
import g1.AbstractC1451a;
import java.lang.annotation.Annotation;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptyList;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.JsonEncodingException;
import kotlinx.serialization.json.internal.WriteMode;
import x9.InterfaceC2123a;
import z9.AbstractC2202d;

/* loaded from: classes4.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final k f440a = new k();

    public static final JsonEncodingException a(String str, Number number) {
        return new JsonEncodingException("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) m(str, -1)));
    }

    public static final JsonEncodingException b(z9.g keyDescriptor) {
        kotlin.jvm.internal.k.f(keyDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + keyDescriptor.h() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonDecodingException c(int i, String message) {
        kotlin.jvm.internal.k.f(message, "message");
        if (i >= 0) {
            message = androidx.constraintlayout.core.dsl.a.c(i, "Unexpected JSON token at offset ", ": ", message);
        }
        return new JsonDecodingException(message);
    }

    public static final JsonDecodingException d(String message, CharSequence input, int i) {
        kotlin.jvm.internal.k.f(message, "message");
        kotlin.jvm.internal.k.f(input, "input");
        return c(i, message + "\nJSON input: " + ((Object) m(input, i)));
    }

    public static final z9.g e(z9.g gVar, E9.e module) {
        z9.g gVarE;
        x9.b bVarB;
        kotlin.jvm.internal.k.f(gVar, "<this>");
        kotlin.jvm.internal.k.f(module, "module");
        if (!kotlin.jvm.internal.k.b(gVar.getKind(), z9.i.c)) {
            return gVar.isInline() ? e(gVar.g(0), module) : gVar;
        }
        Z7.d dVarD = AbstractC1451a.D(gVar);
        z9.g descriptor = null;
        if (dVarD != null && (bVarB = module.b(dVarD, EmptyList.f4893a)) != null) {
            descriptor = bVarB.getDescriptor();
        }
        return (descriptor == null || (gVarE = e(descriptor, module)) == null) ? gVar : gVarE;
    }

    public static final byte f(char c) {
        if (c < '~') {
            return e.b[c];
        }
        return (byte) 0;
    }

    public static final String g(AbstractC0200b json, z9.g gVar) {
        kotlin.jvm.internal.k.f(gVar, "<this>");
        kotlin.jvm.internal.k.f(json, "json");
        for (Annotation annotation : gVar.getAnnotations()) {
            if (annotation instanceof C9.h) {
                return ((C9.h) annotation).discriminator();
            }
        }
        return json.f321a.h;
    }

    public static final void h(AbstractC0200b abstractC0200b, B1.b bVar, x9.f serializer, Object obj) {
        kotlin.jvm.internal.k.f(serializer, "serializer");
        new r(abstractC0200b.f321a.d ? new h(bVar, abstractC0200b) : new C4.a(bVar), abstractC0200b, WriteMode.c, new r[WriteMode.h.size()]).encodeSerializableValue(serializer, obj);
    }

    public static final int i(z9.g gVar, AbstractC0200b json, String name) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        kotlin.jvm.internal.k.f(gVar, "<this>");
        kotlin.jvm.internal.k.f(json, "json");
        kotlin.jvm.internal.k.f(name, "name");
        n(json, gVar);
        int iC = gVar.c(name);
        if (iC != -3 || !json.f321a.i) {
            return iC;
        }
        O0.a aVar = json.c;
        A6.i iVar = new A6.i(5, gVar, json);
        aVar.getClass();
        k kVar = f440a;
        Object objC = aVar.c(gVar, kVar);
        if (objC == null) {
            objC = iVar.invoke();
            ConcurrentHashMap concurrentHashMap = aVar.f1031a;
            Object concurrentHashMap2 = concurrentHashMap.get(gVar);
            if (concurrentHashMap2 == null) {
                concurrentHashMap2 = new ConcurrentHashMap(2);
                concurrentHashMap.put(gVar, concurrentHashMap2);
            }
            ((Map) concurrentHashMap2).put(kVar, objC);
        }
        Integer num = (Integer) ((Map) objC).get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int j(z9.g gVar, AbstractC0200b json, String name, String suffix) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        kotlin.jvm.internal.k.f(gVar, "<this>");
        kotlin.jvm.internal.k.f(json, "json");
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(suffix, "suffix");
        int i = i(gVar, json, name);
        if (i != -3) {
            return i;
        }
        throw new SerializationException(gVar.h() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static final boolean k(AbstractC0200b json, z9.g gVar) {
        kotlin.jvm.internal.k.f(gVar, "<this>");
        kotlin.jvm.internal.k.f(json, "json");
        if (json.f321a.b) {
            return true;
        }
        List annotations = gVar.getAnnotations();
        if ((annotations instanceof Collection) && annotations.isEmpty()) {
            return false;
        }
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            if (((Annotation) it.next()) instanceof C9.p) {
                return true;
            }
        }
        return false;
    }

    public static final void l(t tVar, String str) {
        tVar.n(tVar.c - 1, "Trailing comma before the end of JSON ".concat(str), "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingComma = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static final CharSequence m(CharSequence charSequence, int i) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i != -1) {
                int i6 = i - 30;
                int i10 = i + 30;
                String str = i6 <= 0 ? "" : ".....";
                String str2 = i10 >= charSequence.length() ? "" : ".....";
                StringBuilder sbV = androidx.compose.foundation.b.v(str);
                if (i6 < 0) {
                    i6 = 0;
                }
                int length = charSequence.length();
                if (i10 > length) {
                    i10 = length;
                }
                sbV.append(charSequence.subSequence(i6, i10).toString());
                sbV.append(str2);
                return sbV.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static final void n(AbstractC0200b json, z9.g gVar) {
        kotlin.jvm.internal.k.f(gVar, "<this>");
        kotlin.jvm.internal.k.f(json, "json");
        kotlin.jvm.internal.k.b(gVar.getKind(), z9.k.c);
    }

    public static final Object o(AbstractC0200b abstractC0200b, String discriminator, x xVar, InterfaceC2123a interfaceC2123a) {
        kotlin.jvm.internal.k.f(abstractC0200b, "<this>");
        kotlin.jvm.internal.k.f(discriminator, "discriminator");
        return new o(abstractC0200b, xVar, discriminator, interfaceC2123a.getDescriptor()).decodeSerializableValue(interfaceC2123a);
    }

    public static final WriteMode p(AbstractC0200b abstractC0200b, z9.g desc) {
        kotlin.jvm.internal.k.f(desc, "desc");
        H4.o kind = desc.getKind();
        if (kind instanceof AbstractC2202d) {
            return WriteMode.f;
        }
        if (kotlin.jvm.internal.k.b(kind, z9.k.d)) {
            return WriteMode.d;
        }
        if (!kotlin.jvm.internal.k.b(kind, z9.k.e)) {
            return WriteMode.c;
        }
        z9.g gVarE = e(desc.g(0), abstractC0200b.b);
        H4.o kind2 = gVarE.getKind();
        if ((kind2 instanceof z9.f) || kotlin.jvm.internal.k.b(kind2, z9.j.c)) {
            return WriteMode.e;
        }
        throw b(gVarE);
    }

    public static final void q(t tVar, Number number) {
        t.o(tVar, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static final String r(byte b) {
        return b == 1 ? "quotation mark '\"'" : b == 2 ? "string escape sequence '\\'" : b == 4 ? "comma ','" : b == 5 ? "colon ':'" : b == 6 ? "start of the object '{'" : b == 7 ? "end of the object '}'" : b == 8 ? "start of the array '['" : b == 9 ? "end of the array ']'" : b == 10 ? "end of the input" : b == 127 ? "invalid token" : "valid token";
    }

    public static final String s(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) m(str2, -1));
    }
}
