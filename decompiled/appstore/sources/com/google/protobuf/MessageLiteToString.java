package com.google.protobuf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final String LIST_SUFFIX = "List";

    public MessageLiteToString() {
    }

    private static final String camelCaseToSnakeCase(String r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L10;
        char r13 = r10.charAt(r12);
        if (Character.isUpperCase(r13) == false) goto L8;
        r11.append("_");
    L8:
        r11.append(Character.toLowerCase(r13));
        r12 = r12 + 1;
        goto L4
    L10:
        return r11.toString();
    }

    private static boolean isDefaultValue(Object r10) {
        if ((r10 instanceof Boolean) == false) goto L7;
        return !((Boolean) r10).booleanValue();
    L7:
        if ((r10 instanceof Integer) == false) goto L14;
        if (((Integer) r10).intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    L14:
        if ((r10 instanceof Float) == false) goto L21;
        if (((Float) r10).floatValue() != 0.0f) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ((r10 instanceof Double) == false) goto L28;
        if (((Double) r10).doubleValue() != 0.0d) goto L26;
        return true;
    L26:
        return false;
    L28:
        if ((r10 instanceof String) == false) goto L32;
        return r10.equals("");
    L32:
        if ((r10 instanceof ByteString) == false) goto L36;
        return r10.equals(ByteString.EMPTY);
    L36:
        if ((r10 instanceof MessageLite) == false) goto L43;
        if (r10 != ((MessageLite) r10).getDefaultInstanceForType()) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((r10 instanceof java.lang.Enum) == true) goto L45;
        return false;
    L45:
        if (((java.lang.Enum) r10).ordinal() != 0) goto L48;
        return true;
    L48:
        return false;
    }

    public static final void printField(StringBuilder r10, int r11, String r12, Object r13) {
        if ((r13 instanceof List) == false) goto L9;
        Iterator r14 = ((List) r13).iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        printField(r10, r11, r12, r14.next());
        goto L6
    L8:
        return;
    L9:
        r10.append('\n');
        int r15 = 0;
        int r16 = 0;
    L11:
        if (r16 >= r11) goto L13;
        r10.append(TokenParser.SP);
        r16 = r16 + 1;
        goto L11
    L13:
        r10.append(r12);
        if ((r13 instanceof String) == false) goto L17;
        r10.append(": \"");
        r10.append(TextFormatEscaper.escapeText((String) r13));
        r10.append(TokenParser.DQUOTE);
        return;
    L17:
        if ((r13 instanceof ByteString) == false) goto L20;
        r10.append(": \"");
        r10.append(TextFormatEscaper.escapeBytes((ByteString) r13));
        r10.append(TokenParser.DQUOTE);
        return;
    L20:
        if ((r13 instanceof GeneratedMessageLite) == false) goto L25;
        r10.append(" {");
        reflectivePrintWithIndent((GeneratedMessageLite) r13, r10, r11 + 2);
        r10.append("\n");
    L22:
        if (r15 >= r11) goto L24;
        r10.append(TokenParser.SP);
        r15 = r15 + 1;
        goto L22
    L24:
        r10.append("}");
        return;
    L25:
        r10.append(": ");
        r10.append(r13.toString());
    }

    private static void reflectivePrintWithIndent(MessageLite r11, StringBuilder r12, int r13) {
        HashMap r10 = new HashMap();
        HashMap r14 = new HashMap();
        TreeSet r15 = new TreeSet();
        java.lang.reflect.Method[] r16 = r11.getClass().getDeclaredMethods();
        int r17 = r16.length;
        int r18 = 0;
    L4:
        if (r18 >= r17) goto L11;
        java.lang.reflect.Method r19 = r16[r18];
        r14.put(r19.getName(), r19);
        if (r19.getParameterTypes().length != 0) goto L10;
        r10.put(r19.getName(), r19);
        if (r19.getName().startsWith("get") == false) goto L10;
        r15.add(r19.getName());
    L10:
        r18 = r18 + 1;
        goto L4
    L11:
        Iterator r20 = r15.iterator();
    L13:
        if (r20.hasNext() == false) goto L41;
        String r21 = ((String) r20.next()).replaceFirst("get", "");
        boolean r22 = true;
        if (r21.endsWith(LIST_SUFFIX) == false) goto L22;
        if (r21.endsWith(BUILDER_LIST_SUFFIX) == true) goto L22;
        String r23 = r21.substring(0, 1).toLowerCase() + r21.substring(1, r21.length() - 4);
        java.lang.reflect.Method r24 = (java.lang.reflect.Method) r10.get("get" + r21);
        if (r24 == null) goto L22;
        printField(r12, r13, camelCaseToSnakeCase(r23), GeneratedMessageLite.invokeOrDie(r24, r11, new Object[0]));
    L22:
        if (((java.lang.reflect.Method) r14.get("set" + r21)) == null) goto L13;
        if (r21.endsWith(BYTES_SUFFIX) == false) goto L29;
        if (r10.containsKey("get" + r21.substring(0, r21.length() - 5)) == true) goto L13;
    L29:
        String r25 = r21.substring(0, 1).toLowerCase() + r21.substring(1);
        java.lang.reflect.Method r26 = (java.lang.reflect.Method) r10.get("get" + r21);
        java.lang.reflect.Method r27 = (java.lang.reflect.Method) r10.get("has" + r21);
        if (r26 == null) goto L13;
        Object r28 = GeneratedMessageLite.invokeOrDie(r26, r11, new Object[0]);
        if (r27 == null) goto L34;
        r22 = ((Boolean) GeneratedMessageLite.invokeOrDie(r27, r11, new Object[0])).booleanValue();
    L38:
        if (r22 == false) goto L13;
        printField(r12, r13, camelCaseToSnakeCase(r25), r28);
        goto L13
    L34:
        if (isDefaultValue(r28) == false) goto L38;
        r22 = false;
        goto L38
    L41:
        if ((r11 instanceof GeneratedMessageLite.ExtendableMessage) == false) goto L46;
        Iterator<Map.Entry<FieldDescriptorType, Object>> r29 = ((GeneratedMessageLite.ExtendableMessage) r11).extensions.iterator();
    L44:
        if (r29.hasNext() == false) goto L46;
        Map.Entry r30 = (Map.Entry) r29.next();
        printField(r12, r13, "[" + ((GeneratedMessageLite.ExtensionDescriptor) r30.getKey()).getNumber() + "]", r30.getValue());
    L46:
        UnknownFieldSetLite r110 = ((GeneratedMessageLite) r11).unknownFields;
        if (r110 == null) goto L72;
        r110.printWithIndent(r12, r13);
        return;
    }

    public static String toString(MessageLite r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append("# ");
        r12.append(r11);
        reflectivePrintWithIndent(r10, r12, 0);
        return r12.toString();
    }
}
