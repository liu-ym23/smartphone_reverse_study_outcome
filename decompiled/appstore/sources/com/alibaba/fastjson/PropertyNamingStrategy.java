package com.alibaba.fastjson;

import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final enum PropertyNamingStrategy extends Enum<PropertyNamingStrategy> {
    private static final /* synthetic */ PropertyNamingStrategy[] $VALUES = null;
    public static final PropertyNamingStrategy CamelCase = null;
    public static final PropertyNamingStrategy KebabCase = null;
    public static final PropertyNamingStrategy PascalCase = null;
    public static final PropertyNamingStrategy SnakeCase = null;

    /* JADX INFO: renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = null;

        static {
            int[] r10 = new int[PropertyNamingStrategy.values().length];
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = r10;
            r10[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.KebabCase.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.PascalCase.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.CamelCase.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        PropertyNamingStrategy r10 = new PropertyNamingStrategy("CamelCase", 0);
        CamelCase = r10;
        PropertyNamingStrategy r11 = new PropertyNamingStrategy("PascalCase", 1);
        PascalCase = r11;
        PropertyNamingStrategy r12 = new PropertyNamingStrategy("SnakeCase", 2);
        SnakeCase = r12;
        PropertyNamingStrategy r13 = new PropertyNamingStrategy("KebabCase", 3);
        KebabCase = r13;
        $VALUES = new PropertyNamingStrategy[]{r10, r11, r12, r13};
    }

    private PropertyNamingStrategy(String r10, int r11) {
        super(r10, r11);
    }

    public static PropertyNamingStrategy valueOf(String r10) {
        return (PropertyNamingStrategy) Enum.valueOf(PropertyNamingStrategy.class, r10);
    }

    public static PropertyNamingStrategy[] values() {
        return (PropertyNamingStrategy[]) $VALUES.clone();
    }

    public String translate(String r10) {
        int r11 = AnonymousClass1.$SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[ordinal()];
        int r12 = 0;
        if (r11 != 1) goto L5;
        StringBuilder r13 = new StringBuilder();
    L38:
        if (r12 >= r10.length()) goto L49;
        char r14 = r10.charAt(r12);
        if (r14 < 'A') goto L46;
        if (r14 > 'Z') goto L46;
        char r15 = (char) (r14 + TokenParser.SP);
        if (r12 <= 0) goto L45;
        r13.append('_');
    L45:
        r13.append(r15);
    L47:
        r12 = r12 + 1;
    L46:
        r13.append(r14);
        goto L47
    L49:
        return r13.toString();
    L5:
        if (r11 != 2) goto L7;
        StringBuilder r16 = new StringBuilder();
    L24:
        if (r12 >= r10.length()) goto L35;
        char r17 = r10.charAt(r12);
        if (r17 < 'A') goto L32;
        if (r17 > 'Z') goto L32;
        char r18 = (char) (r17 + TokenParser.SP);
        if (r12 <= 0) goto L31;
        r16.append('-');
    L31:
        r16.append(r18);
    L33:
        r12 = r12 + 1;
    L32:
        r16.append(r17);
        goto L33
    L35:
        return r16.toString();
    L7:
        if (r11 != 3) goto L9;
        char r19 = r10.charAt(0);
        if (r19 >= 'a') goto L19;
        return r10;
    L19:
        if (r19 > 'z') goto L59;
        char[] r20 = r10.toCharArray();
        r20[0] = (char) (r20[0] - ' ');
        return new String(r20);
    L59:
        return r10;
    L9:
        if (r11 == 4) goto L11;
        return r10;
    L11:
        char r21 = r10.charAt(0);
        if (r21 < 'A') goto L56;
        if (r21 > 'Z') goto L57;
        char[] r22 = r10.toCharArray();
        r22[0] = (char) (r22[0] + TokenParser.SP);
        return new String(r22);
    L57:
        return r10;
    L56:
        return r10;
    }
}
