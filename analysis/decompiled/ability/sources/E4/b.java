package E4;

import j9.t;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import kotlin.Result;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {
    public static String a(int i, Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        String name;
        String strA;
        String name2;
        String strA2;
        if (i > 6) {
            return null;
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        k.e(declaredFields, "getDeclaredFields(...)");
        for (Field field : declaredFields) {
            try {
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                if (obj2 != null) {
                    if (k.b(field.getName(), "keywordPhrase") && (obj2 instanceof String) && ((CharSequence) obj2).length() > 0) {
                        return (String) obj2;
                    }
                    if (obj2 instanceof Object[]) {
                        for (Object obj3 : (Object[]) obj2) {
                            if (obj3 != null) {
                                Package r10 = obj3.getClass().getPackage();
                                if (r10 == null || (name2 = r10.getName()) == null) {
                                    name2 = "";
                                }
                                if ((t.e0(name2, "com.qualcomm", false) || t.e0(name2, "vendor.qti", false)) && (strA2 = a(i + 1, obj3)) != null) {
                                    return strA2;
                                }
                            }
                        }
                    } else {
                        Package r42 = obj2.getClass().getPackage();
                        if (r42 != null && (name = r42.getName()) != null && ((t.e0(name, "com.qualcomm", false) || t.e0(name, "vendor.qti", false)) && (strA = a(i + 1, obj2)) != null)) {
                            return strA;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static final void b(StringBuilder sb, Object obj, String str) {
        Field[] fieldArr;
        Object obj2;
        String name;
        int i;
        String name2;
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        k.e(declaredFields, "getDeclaredFields(...)");
        int length = declaredFields.length;
        int i6 = 0;
        while (i6 < length) {
            Field field = declaredFields[i6];
            try {
                field.setAccessible(true);
            } catch (Throwable th) {
                th = th;
            }
            try {
                obj2 = field.get(obj);
            } catch (Throwable th2) {
                th = th2;
                fieldArr = declaredFields;
                kotlin.b.a(th);
                i6++;
                declaredFields = fieldArr;
            }
            if (obj2 != null) {
                if (obj2 instanceof Object[]) {
                    sb.append(str + field.getName() + " [" + field.getType().getSimpleName() + ", len=" + ((Object[]) obj2).length + "]:\n");
                    Object[] objArr = (Object[]) obj2;
                    int length2 = objArr.length;
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < length2) {
                        Object obj3 = objArr[i10];
                        int i12 = i11 + 1;
                        if (obj3 != null) {
                            Package r17 = obj3.getClass().getPackage();
                            if (r17 == null || (name2 = r17.getName()) == null) {
                                name2 = "";
                            }
                            i = length2;
                            String str2 = name2;
                            fieldArr = declaredFields;
                            if (t.e0(str2, "com.qualcomm", false)) {
                                sb.append(str + "  [" + i11 + "]:\n");
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("    ");
                                b(sb, obj3, sb2.toString());
                            } else {
                                try {
                                    if (t.e0(str2, "vendor.qti", false)) {
                                        sb.append(str + "  [" + i11 + "]:\n");
                                        StringBuilder sb22 = new StringBuilder();
                                        sb22.append(str);
                                        sb22.append("    ");
                                        b(sb, obj3, sb22.toString());
                                    } else {
                                        sb.append(str + "  [" + i11 + "] = " + obj3 + "\n");
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    kotlin.b.a(th);
                                    i6++;
                                    declaredFields = fieldArr;
                                }
                            }
                        } else {
                            i = length2;
                            fieldArr = declaredFields;
                        }
                        i10++;
                        i11 = i12;
                        length2 = i;
                        declaredFields = fieldArr;
                    }
                } else {
                    fieldArr = declaredFields;
                    Package r42 = obj2.getClass().getPackage();
                    if (r42 == null || (name = r42.getName()) == null || !(t.e0(name, "com.qualcomm", false) || t.e0(name, "vendor.qti", false))) {
                        sb.append(str + field.getName() + " = " + obj2 + "\n");
                    } else {
                        sb.append(str + field.getName() + " (" + field.getType().getSimpleName() + "):\n");
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append("  ");
                        b(sb, obj2, sb3.toString());
                    }
                    i6++;
                    declaredFields = fieldArr;
                }
            }
            fieldArr = declaredFields;
            i6++;
            declaredFields = fieldArr;
        }
    }

    public static int c(ByteBuffer byteBuffer) {
        Object objA;
        Object objInvoke;
        Field declaredField;
        a aVar = a.f472a;
        Class clsB = a.b("com.qualcomm.listen.ListenSoundModel");
        if (clsB != null) {
            try {
                objInvoke = clsB.getMethod("query", ByteBuffer.class).invoke(null, d(byteBuffer));
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (objInvoke != null) {
                Class<?> superclass = objInvoke.getClass();
                while (true) {
                    if (superclass == null) {
                        declaredField = null;
                        break;
                    }
                    try {
                        declaredField = superclass.getDeclaredField("userNames");
                        break;
                    } catch (NoSuchFieldException unused) {
                        superclass = superclass.getSuperclass();
                    }
                }
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(objInvoke);
                    Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                    objA = Integer.valueOf(objArr != null ? objArr.length : 0);
                    if (objA instanceof Result.Failure) {
                        objA = 0;
                    }
                    return ((Number) objA).intValue();
                }
            }
        }
        return 0;
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity();
        byte[] bArr = new byte[iCapacity];
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.rewind();
        byteBufferDuplicate.get(bArr);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.position(iCapacity);
        return byteBufferWrap;
    }
}
