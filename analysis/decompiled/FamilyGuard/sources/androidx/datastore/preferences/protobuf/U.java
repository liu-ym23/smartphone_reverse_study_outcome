package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0504y;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
final class U {
    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    private static boolean b(Object obj) {
        return obj instanceof Boolean ? !((Boolean) obj).booleanValue() : obj instanceof Integer ? ((Integer) obj).intValue() == 0 : obj instanceof Float ? ((Float) obj).floatValue() == 0.0f : obj instanceof Double ? ((Double) obj).doubleValue() == 0.0d : obj instanceof String ? obj.equals(BuildConfig.FLAVOR) : obj instanceof AbstractC0488h ? obj.equals(AbstractC0488h.f10009b) : obj instanceof S ? obj == ((S) obj).b() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
    }

    static final void c(StringBuilder sb, int i5, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                c(sb, i5, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                c(sb, i5, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(m0.c((String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC0488h) {
            sb.append(": \"");
            sb.append(m0.a((AbstractC0488h) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC0504y) {
            sb.append(" {");
            d((AbstractC0504y) obj, sb, i5 + 2);
            sb.append("\n");
            while (i6 < i5) {
                sb.append(' ');
                i6++;
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
        int i8 = i5 + 2;
        c(sb, i8, "key", entry.getKey());
        c(sb, i8, "value", entry.getValue());
        sb.append("\n");
        while (i6 < i5) {
            sb.append(' ');
            i6++;
        }
        sb.append("}");
    }

    private static void d(S s5, StringBuilder sb, int i5) throws SecurityException {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : s5.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strReplaceFirst = str.replaceFirst("get", BuildConfig.FLAVOR);
            boolean zBooleanValue = true;
            if (strReplaceFirst.endsWith("List") && !strReplaceFirst.endsWith("OrBuilderList") && !strReplaceFirst.equals("List")) {
                String str2 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 4);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    c(sb, i5, a(str2), AbstractC0504y.A(method2, s5, new Object[0]));
                }
            }
            if (strReplaceFirst.endsWith("Map") && !strReplaceFirst.equals("Map")) {
                String str3 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    c(sb, i5, a(str3), AbstractC0504y.A(method3, s5, new Object[0]));
                }
            }
            if (((Method) map2.get("set" + strReplaceFirst)) != null) {
                if (strReplaceFirst.endsWith("Bytes")) {
                    if (map.containsKey("get" + strReplaceFirst.substring(0, strReplaceFirst.length() - 5))) {
                    }
                }
                String str4 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1);
                Method method4 = (Method) map.get("get" + strReplaceFirst);
                Method method5 = (Method) map.get("has" + strReplaceFirst);
                if (method4 != null) {
                    Object objA = AbstractC0504y.A(method4, s5, new Object[0]);
                    if (method5 != null) {
                        zBooleanValue = ((Boolean) AbstractC0504y.A(method5, s5, new Object[0])).booleanValue();
                    } else if (b(objA)) {
                        zBooleanValue = false;
                    }
                    if (zBooleanValue) {
                        c(sb, i5, a(str4), objA);
                    }
                }
            }
        }
        if (s5 instanceof AbstractC0504y.c) {
            Iterator<Map.Entry<T, Object>> itS = ((AbstractC0504y.c) s5).extensions.s();
            while (itS.hasNext()) {
                Map.Entry entry = (Map.Entry) itS.next();
                c(sb, i5, "[" + ((AbstractC0504y.d) entry.getKey()).a() + "]", entry.getValue());
            }
        }
        p0 p0Var = ((AbstractC0504y) s5).unknownFields;
        if (p0Var != null) {
            p0Var.m(sb, i5);
        }
    }

    static String e(S s5, String str) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(s5, sb, 0);
        return sb.toString();
    }
}
