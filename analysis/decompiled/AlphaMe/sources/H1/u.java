package H1;

import F1.A;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class u extends A {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f761a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f762b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f763c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f764d;

    public u(F1.n nVar, A a4, Type type) {
        this.f761a = 0;
        this.f762b = nVar;
        this.f763c = a4;
        this.f764d = type;
    }

    @Override // F1.A
    public final Object b(JsonReader jsonReader) throws IOException {
        int i4 = this.f761a;
        Object obj = this.f763c;
        switch (i4) {
            case 0:
                return ((A) obj).b(jsonReader);
            default:
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString = jsonReader.nextString();
                Enum r32 = (Enum) ((Map) this.f762b).get(strNextString);
                return r32 == null ? (Enum) ((Map) obj).get(strNextString) : r32;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.reflect.Type] */
    @Override // F1.A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(com.google.gson.stream.JsonWriter r4, java.lang.Object r5) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.f761a
            java.lang.Object r1 = r3.f764d
            switch(r0) {
                case 0: goto L19;
                default: goto L7;
            }
        L7:
            java.lang.Enum r5 = (java.lang.Enum) r5
            if (r5 != 0) goto Ld
            r3 = 0
            goto L15
        Ld:
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r3 = r1.get(r5)
            java.lang.String r3 = (java.lang.String) r3
        L15:
            r4.value(r3)
            return
        L19:
            java.lang.Object r0 = r3.f763c
            F1.A r0 = (F1.A) r0
            java.lang.reflect.Type r1 = (java.lang.reflect.Type) r1
            if (r5 == 0) goto L2e
            boolean r2 = r1 instanceof java.lang.Class
            if (r2 != 0) goto L29
            boolean r2 = r1 instanceof java.lang.reflect.TypeVariable
            if (r2 == 0) goto L2e
        L29:
            java.lang.Class r2 = r5.getClass()
            goto L2f
        L2e:
            r2 = r1
        L2f:
            if (r2 == r1) goto L63
            java.lang.Object r3 = r3.f762b
            F1.n r3 = (F1.n) r3
            com.google.gson.reflect.TypeToken r1 = com.google.gson.reflect.TypeToken.get(r2)
            F1.A r3 = r3.e(r1)
            boolean r1 = r3 instanceof H1.p
            if (r1 != 0) goto L42
            goto L62
        L42:
            r1 = r0
        L43:
            boolean r2 = r1 instanceof H1.t
            if (r2 == 0) goto L5d
            r2 = r1
            H1.t r2 = (H1.t) r2
            F1.m r2 = (F1.m) r2
            F1.A r2 = r2.f437a
            if (r2 == 0) goto L55
            if (r2 != r1) goto L53
            goto L5d
        L53:
            r1 = r2
            goto L43
        L55:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Adapter for type with cyclic dependency has been used before dependency has been resolved"
            r3.<init>(r4)
            throw r3
        L5d:
            boolean r1 = r1 instanceof H1.p
            if (r1 != 0) goto L62
            goto L63
        L62:
            r0 = r3
        L63:
            r0.c(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: H1.u.c(com.google.gson.stream.JsonWriter, java.lang.Object):void");
    }

    public u(Class cls) {
        this.f761a = 1;
        this.f762b = new HashMap();
        this.f763c = new HashMap();
        this.f764d = new HashMap();
        try {
            for (Field field : (Field[]) AccessController.doPrivileged(new y(cls))) {
                Enum r4 = (Enum) field.get(null);
                String strName = r4.name();
                String string = r4.toString();
                SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                Object obj = this.f762b;
                if (serializedName != null) {
                    strName = serializedName.value();
                    for (String str : serializedName.alternate()) {
                        ((Map) obj).put(str, r4);
                    }
                }
                ((Map) obj).put(strName, r4);
                ((Map) this.f763c).put(string, r4);
                ((Map) this.f764d).put(r4, strName);
            }
        } catch (IllegalAccessException e4) {
            throw new AssertionError(e4);
        }
    }
}
