package androidx.datastore.preferences.protobuf;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import com.stepos.alphame.utils.Property;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes.dex */
public abstract class X {

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f3441a = new l0();

    /* renamed from: b, reason: collision with root package name */
    public static final m0 f3442b = new m0();

    public static void a(byte b4, byte b5, byte b6, byte b7, char[] cArr, int i4) throws F {
        if (!g(b5)) {
            if ((((b5 + 112) + (b4 << 28)) >> 30) == 0 && !g(b6) && !g(b7)) {
                int i5 = ((b4 & 7) << 18) | ((b5 & 63) << 12) | ((b6 & 63) << 6) | (b7 & 63);
                cArr[i4] = (char) ((i5 >>> 10) + 55232);
                cArr[i4 + 1] = (char) ((i5 & 1023) + 56320);
                return;
            }
        }
        throw F.a();
    }

    public static boolean b(byte b4) {
        return b4 >= 0;
    }

    public static void c(byte b4, byte b5, char[] cArr, int i4) throws F {
        if (b4 < -62 || g(b5)) {
            throw F.a();
        }
        cArr[i4] = (char) (((b4 & 31) << 6) | (b5 & 63));
    }

    public static void d(byte b4, byte b5, byte b6, char[] cArr, int i4) throws F {
        if (g(b5) || ((b4 == -32 && b5 < -96) || ((b4 == -19 && b5 >= -96) || g(b6)))) {
            throw F.a();
        }
        cArr[i4] = (char) (((b4 & 15) << 12) | ((b5 & 63) << 6) | (b6 & 63));
    }

    public static final String e(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    public static String f(AbstractC0259h abstractC0259h) {
        StringBuilder sb = new StringBuilder(abstractC0259h.size());
        for (int i4 = 0; i4 < abstractC0259h.size(); i4++) {
            byte bA = abstractC0259h.a(i4);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append(CoreConstants.ESCAPE_CHAR);
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bA);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static boolean g(byte b4) {
        return b4 > -65;
    }

    public static final void h(StringBuilder sb, int i4, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                h(sb, i4, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                h(sb, i4, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            C0261i c0261i = AbstractC0259h.f3480b;
            sb.append(f(new C0261i(((String) obj).getBytes(D.f3396a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC0259h) {
            sb.append(": \"");
            sb.append(f((AbstractC0259h) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof A) {
            sb.append(" {");
            i((A) obj, sb, i4 + 2);
            sb.append("\n");
            while (i5 < i4) {
                sb.append(' ');
                i5++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj.toString());
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i7 = i4 + 2;
        h(sb, i7, Action.KEY_ATTRIBUTE, entry.getKey());
        h(sb, i7, "value", entry.getValue());
        sb.append("\n");
        while (i5 < i4) {
            sb.append(' ');
            i5++;
        }
        sb.append("}");
    }

    public static void i(AbstractC0247b abstractC0247b, StringBuilder sb, int i4) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (Method method : abstractC0247b.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String strReplaceFirst = str.replaceFirst("get", "");
            if (strReplaceFirst.endsWith("List") && !strReplaceFirst.endsWith("OrBuilderList") && !strReplaceFirst.equals("List")) {
                String str2 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 4);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    h(sb, i4, e(str2), A.f(abstractC0247b, method2, new Object[0]));
                }
            }
            if (strReplaceFirst.endsWith("Map") && !strReplaceFirst.equals("Map")) {
                String str3 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    h(sb, i4, e(str3), A.f(abstractC0247b, method3, new Object[0]));
                }
            }
            if (((Method) map2.get("set".concat(strReplaceFirst))) != null) {
                if (strReplaceFirst.endsWith("Bytes")) {
                    if (map.containsKey("get" + strReplaceFirst.substring(0, strReplaceFirst.length() - 5))) {
                    }
                }
                String str4 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1);
                Method method4 = (Method) map.get("get".concat(strReplaceFirst));
                Method method5 = (Method) map.get("has".concat(strReplaceFirst));
                if (method4 != null) {
                    Object objF = A.f(abstractC0247b, method4, new Object[0]);
                    if (method5 == null) {
                        if (objF instanceof Boolean) {
                            zEquals = !((Boolean) objF).booleanValue();
                        } else if (objF instanceof Integer) {
                            if (((Integer) objF).intValue() != 0) {
                                h(sb, i4, e(str4), objF);
                            }
                        } else if (objF instanceof Float) {
                            if (((Float) objF).floatValue() != Property.DEFAULT_FLOAT_VALUE) {
                                h(sb, i4, e(str4), objF);
                            }
                        } else if (objF instanceof Double) {
                            if (((Double) objF).doubleValue() != 0.0d) {
                                h(sb, i4, e(str4), objF);
                            }
                        } else if (objF instanceof String) {
                            zEquals = objF.equals("");
                        } else if (objF instanceof AbstractC0259h) {
                            zEquals = objF.equals(AbstractC0259h.f3480b);
                        } else if (objF instanceof AbstractC0247b) {
                            if (objF != ((A) ((A) ((AbstractC0247b) objF)).d(6))) {
                                h(sb, i4, e(str4), objF);
                            }
                        } else if (!(objF instanceof Enum) || ((Enum) objF).ordinal() != 0) {
                            h(sb, i4, e(str4), objF);
                        }
                        if (!zEquals) {
                            h(sb, i4, e(str4), objF);
                        }
                    } else if (((Boolean) A.f(abstractC0247b, method5, new Object[0])).booleanValue()) {
                        h(sb, i4, e(str4), objF);
                    }
                }
            }
        }
        q0 q0Var = ((A) abstractC0247b).unknownFields;
        if (q0Var != null) {
            for (int i5 = 0; i5 < q0Var.f3527a; i5++) {
                h(sb, i4, String.valueOf(q0Var.f3528b[i5] >>> 3), q0Var.f3529c[i5]);
            }
        }
    }

    public abstract void j(int i4, int i5, byte[] bArr);
}
