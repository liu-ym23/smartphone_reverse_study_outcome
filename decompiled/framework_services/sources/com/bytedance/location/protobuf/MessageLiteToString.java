package com.bytedance.location.protobuf;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER = null;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        INDENT_BUFFER = new char[80];
        Arrays.fill(INDENT_BUFFER, ' ');
    }

    private MessageLiteToString() {
    }

    static String toString(MessageLite messageLite, String commentString) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("# ");
        buffer.append(commentString);
        reflectivePrintWithIndent(messageLite, buffer, 0);
        return buffer.toString();
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder buffer, int indent) {
        Set<String> setters = new HashSet();
        Map<String, Method> hazzers = new HashMap();
        Map<String, Method> getters = new TreeMap();
        Method[] r6 = messageLite.getClass().getDeclaredMethods();
        int r7 = r6.length;
        int r9 = 0;
    L3:
        int r13 = 3;
        if (r9 >= r7) goto L27;
        Method method = r6[r9];
        if (Modifier.isStatic(method.getModifiers()) == true) goto L26;
        if (method.getName().length() < 3) goto L26;
        if (method.getName().startsWith("set") == false) goto L15;
        setters.add(method.getName());
        goto L26
    L15:
        if (Modifier.isPublic(method.getModifiers()) == false) goto L26;
        if (method.getParameterTypes().length != 0) goto L26;
        if (method.getName().startsWith("has") == false) goto L24;
        hazzers.put(method.getName(), method);
        goto L26
    L24:
        if (method.getName().startsWith("get") == false) goto L26;
        getters.put(method.getName(), method);
    L26:
        r9 = r9 + 1;
        goto L3
    L27:
        Iterator<Map.Entry<String, Method>> r8 = getters.entrySet().iterator();
    L29:
        if (r8.hasNext() == false) goto L78;
        Map.Entry<String, Method> getter = r8.next();
        String suffix = getter.getKey().substring(r13);
        if (suffix.endsWith(LIST_SUFFIX) == false) goto L42;
        if (suffix.endsWith(BUILDER_LIST_SUFFIX) == true) goto L42;
        if (suffix.equals(LIST_SUFFIX) == true) goto L42;
        Method listMethod = getter.getValue();
        if (listMethod == null) goto L42;
        if (listMethod.getReturnType().equals(List.class) == false) goto L42;
        printField(buffer, indent, suffix.substring(0, suffix.length() - LIST_SUFFIX.length()), GeneratedMessageLite.invokeOrDie(listMethod, messageLite, new Object[0]));
        r13 = 3;
    L42:
        if (suffix.endsWith(MAP_SUFFIX) == false) goto L55;
        if (suffix.equals(MAP_SUFFIX) == true) goto L55;
        Method mapMethod = getter.getValue();
        if (mapMethod == null) goto L55;
        if (mapMethod.getReturnType().equals(Map.class) == false) goto L55;
        if (mapMethod.isAnnotationPresent(Deprecated.class) == true) goto L55;
        if (Modifier.isPublic(mapMethod.getModifiers()) == false) goto L55;
        printField(buffer, indent, suffix.substring(0, suffix.length() - MAP_SUFFIX.length()), GeneratedMessageLite.invokeOrDie(mapMethod, messageLite, new Object[0]));
        r13 = 3;
    L55:
        if (setters.contains("set" + suffix) == false) goto L56;
        if (suffix.endsWith(BYTES_SUFFIX) == false) goto L62;
        if (getters.containsKey("get" + suffix.substring(0, suffix.length() - BYTES_SUFFIX.length())) == false) goto L62;
        r13 = 3;
    L62:
        Method getMethod = getter.getValue();
        Method hasMethod = hazzers.get("has" + suffix);
        if (getMethod != null) goto L64;
        r13 = 3;
        goto L29
    L64:
        Object value = GeneratedMessageLite.invokeOrDie(getMethod, messageLite, new Object[0]);
        if (hasMethod == null) goto L67;
        setters = setters;
        boolean hasValue = ((Boolean) GeneratedMessageLite.invokeOrDie(hasMethod, messageLite, new Object[0])).booleanValue();
    L73:
        if (hasValue == true) goto L74;
        setters = setters;
        r13 = 3;
        goto L29
    L74:
        printField(buffer, indent, suffix, value);
        setters = setters;
        r13 = 3;
        goto L29
    L67:
        if (isDefaultValue(value) == true) goto L70;
        hasValue = true;
        goto L73
    L70:
        hasValue = false;
        goto L73
    L56:
        r13 = 3;
        goto L29
    L78:
        if ((messageLite instanceof GeneratedMessageLite.ExtendableMessage) == false) goto L84;
        Iterator<Map.Entry<T, Object>> r3 = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
    L81:
        if (r3.hasNext() == false) goto L84;
        Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> entry = (Map.Entry) r3.next();
        printField(buffer, indent, "[" + entry.getKey().getNumber() + "]", entry.getValue());
    L84:
        if (((GeneratedMessageLite) messageLite).unknownFields == null) goto L128;
        ((GeneratedMessageLite) messageLite).unknownFields.printWithIndent(buffer, indent);
        return;
    }

    private static boolean isDefaultValue(Object o) {
        if ((o instanceof Boolean) == false) goto L7;
        return !((Boolean) o).booleanValue();
    L7:
        if ((o instanceof Integer) == false) goto L14;
        if (((Integer) o).intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    L14:
        if ((o instanceof Float) == false) goto L21;
        if (Float.floatToRawIntBits(((Float) o).floatValue()) != 0) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ((o instanceof Double) == false) goto L28;
        if (Double.doubleToRawLongBits(((Double) o).doubleValue()) != 0) goto L26;
        return true;
    L26:
        return false;
    L28:
        if ((o instanceof String) == false) goto L32;
        return o.equals("");
    L32:
        if ((o instanceof ByteString) == false) goto L36;
        return o.equals(ByteString.EMPTY);
    L36:
        if ((o instanceof MessageLite) == false) goto L43;
        if (o != ((MessageLite) o).getDefaultInstanceForType()) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((o instanceof Enum) == true) goto L45;
        return false;
    L45:
        if (((Enum) o).ordinal() != 0) goto L48;
        return true;
    L48:
        return false;
    }

    static void printField(StringBuilder buffer, int indent, String name, Object object) {
        if ((object instanceof List) == false) goto L10;
        List<?> list = (List) object;
        Iterator<?> r1 = list.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        printField(buffer, indent, name, r1.next());
        goto L6
    L8:
        return;
    L10:
        if ((object instanceof Map) == false) goto L16;
        Map<?, ?> map = (Map) object;
        Iterator<Map.Entry<?, ?>> r2 = map.entrySet().iterator();
    L13:
        if (r2.hasNext() == false) goto L15;
        printField(buffer, indent, name, r2.next());
        goto L13
    L15:
        return;
    L16:
        buffer.append('\n');
        indent(indent, buffer);
        buffer.append(pascalCaseToSnakeCase(name));
        if ((object instanceof String) == false) goto L20;
        buffer.append(": \"");
        buffer.append(TextFormatEscaper.escapeText((String) object));
        buffer.append('\"');
        return;
    L20:
        if ((object instanceof ByteString) == false) goto L23;
        buffer.append(": \"");
        buffer.append(TextFormatEscaper.escapeBytes((ByteString) object));
        buffer.append('\"');
        return;
    L23:
        if ((object instanceof GeneratedMessageLite) == false) goto L26;
        buffer.append(" {");
        reflectivePrintWithIndent((GeneratedMessageLite) object, buffer, indent + 2);
        buffer.append("\n");
        indent(indent, buffer);
        buffer.append("}");
        return;
    L26:
        if ((object instanceof Map.Entry) == false) goto L28;
        buffer.append(" {");
        Map.Entry<?, ?> entry = (Map.Entry) object;
        printField(buffer, indent + 2, "key", entry.getKey());
        printField(buffer, indent + 2, "value", entry.getValue());
        buffer.append("\n");
        indent(indent, buffer);
        buffer.append("}");
        return;
    L28:
        buffer.append(": ");
        buffer.append(object);
    }

    private static void indent(int indent, StringBuilder buffer) {
    L2:
        if (indent <= 0) goto L7;
        int partialIndent = indent;
        if (partialIndent <= INDENT_BUFFER.length) goto L6;
        partialIndent = INDENT_BUFFER.length;
    L6:
        buffer.append(INDENT_BUFFER, 0, partialIndent);
        indent = indent - partialIndent;
        goto L2
    }

    private static String pascalCaseToSnakeCase(String pascalCase) {
        if (pascalCase.isEmpty() == false) goto L5;
        return pascalCase;
    L5:
        StringBuilder builder = new StringBuilder();
        builder.append(Character.toLowerCase(pascalCase.charAt(0)));
        int i = 1;
    L7:
        if (i >= pascalCase.length()) goto L13;
        char ch = pascalCase.charAt(i);
        if (Character.isUpperCase(ch) == false) goto L11;
        builder.append("_");
    L11:
        builder.append(Character.toLowerCase(ch));
        i = i + 1;
        goto L7
    L13:
        return builder.toString();
    }
}
