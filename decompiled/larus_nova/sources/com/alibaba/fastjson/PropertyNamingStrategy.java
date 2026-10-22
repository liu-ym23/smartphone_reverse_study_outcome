package com.alibaba.fastjson;

import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public final enum PropertyNamingStrategy extends Enum<PropertyNamingStrategy> {
    private static final /* synthetic */ PropertyNamingStrategy[] $VALUES = null;
    public static final PropertyNamingStrategy CamelCase = null;
    public static final PropertyNamingStrategy KebabCase = null;
    public static final PropertyNamingStrategy NeverUseThisValueExceptDefaultValue = null;
    public static final PropertyNamingStrategy NoChange = null;
    public static final PropertyNamingStrategy PascalCase = null;
    public static final PropertyNamingStrategy SnakeCase = null;

    /* JADX INFO: renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = null;

        static {
            int[] r100 = new int[PropertyNamingStrategy.values().length];
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = r100;
            r100[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.KebabCase.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.PascalCase.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.CamelCase.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.NoChange.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        PropertyNamingStrategy r100 = new PropertyNamingStrategy("CamelCase", 0);
        CamelCase = r100;
        PropertyNamingStrategy r101 = new PropertyNamingStrategy("PascalCase", 1);
        PascalCase = r101;
        PropertyNamingStrategy r102 = new PropertyNamingStrategy("SnakeCase", 2);
        SnakeCase = r102;
        PropertyNamingStrategy r103 = new PropertyNamingStrategy("KebabCase", 3);
        KebabCase = r103;
        PropertyNamingStrategy r104 = new PropertyNamingStrategy("NoChange", 4);
        NoChange = r104;
        PropertyNamingStrategy r105 = new PropertyNamingStrategy("NeverUseThisValueExceptDefaultValue", 5);
        NeverUseThisValueExceptDefaultValue = r105;
        $VALUES = new PropertyNamingStrategy[]{r100, r101, r102, r103, r104, r105};
    }

    public static PropertyNamingStrategy[] values() {
        return (PropertyNamingStrategy[]) $VALUES.clone();
    }

    public static PropertyNamingStrategy valueOf(String r100) {
        return (PropertyNamingStrategy) a.a(PropertyNamingStrategy.class, r100);
    }

    public String translate(String r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[ordinal()];
        int r102 = 0;
        if (r101 != 1) goto L5;
        StringBuilder r103 = new StringBuilder();
    L40:
        if (r102 >= r100.length()) goto L51;
        char r104 = r100.charAt(r102);
        if (r104 < 'A') goto L48;
        if (r104 > 'Z') goto L48;
        char r105 = (char) (r104 + ' ');
        if (r102 <= 0) goto L47;
        r103.append('_');
    L47:
        r103.append(r105);
    L49:
        r102 = r102 + 1;
    L48:
        r103.append(r104);
        goto L49
    L51:
        return r103.toString();
    L5:
        if (r101 != 2) goto L7;
        StringBuilder r106 = new StringBuilder();
    L26:
        if (r102 >= r100.length()) goto L37;
        char r107 = r100.charAt(r102);
        if (r107 < 'A') goto L34;
        if (r107 > 'Z') goto L34;
        char r108 = (char) (r107 + ' ');
        if (r102 <= 0) goto L33;
        r106.append('-');
    L33:
        r106.append(r108);
    L35:
        r102 = r102 + 1;
    L34:
        r106.append(r107);
        goto L35
    L37:
        return r106.toString();
    L7:
        if (r101 != 3) goto L9;
        char r109 = r100.charAt(0);
        if (r109 >= 'a') goto L20;
    L23:
        return r100;
    L20:
        if (r109 > 'z') goto L23;
        char[] r110 = r100.toCharArray();
        r110[0] = (char) (r110[0] - ' ');
        return new String(r110);
    L9:
        if (r101 == 4) goto L11;
        return r100;
    L11:
        char r111 = r100.charAt(0);
        if (r111 < 'A') goto L16;
        if (r111 > 'Z') goto L16;
        char[] r112 = r100.toCharArray();
        r112[0] = (char) (r112[0] + ' ');
        return new String(r112);
    L16:
        return r100;
    }

    private PropertyNamingStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
