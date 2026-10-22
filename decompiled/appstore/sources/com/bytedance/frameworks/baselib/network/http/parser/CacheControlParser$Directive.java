package com.bytedance.frameworks.baselib.network.http.parser;

/* JADX INFO: loaded from: classes.dex */
public final enum CacheControlParser$Directive extends Enum<CacheControlParser$Directive> {
    private static final /* synthetic */ CacheControlParser$Directive[] $VALUES = null;
    public static final CacheControlParser$Directive MAXAGE = null;
    public static final CacheControlParser$Directive MAXSTALE = null;
    public static final CacheControlParser$Directive MINFRESH = null;
    public static final CacheControlParser$Directive MUSTREVALIDATE = null;
    public static final CacheControlParser$Directive NOCACHE = null;
    public static final CacheControlParser$Directive NOSTORE = null;
    public static final CacheControlParser$Directive NOTRANSFORM = null;
    public static final CacheControlParser$Directive ONLYIFCACHED = null;
    public static final CacheControlParser$Directive PRIVATE = null;
    public static final CacheControlParser$Directive PROXYREVALIDATE = null;
    public static final CacheControlParser$Directive PUBLIC = null;
    public static final CacheControlParser$Directive SMAXAGE = null;
    public static final CacheControlParser$Directive UNKNOWN = null;

    static {
        CacheControlParser$Directive r10 = new CacheControlParser$Directive("MAXAGE", 0);
        MAXAGE = r10;
        CacheControlParser$Directive r11 = new CacheControlParser$Directive("MAXSTALE", 1);
        MAXSTALE = r11;
        CacheControlParser$Directive r12 = new CacheControlParser$Directive("MINFRESH", 2);
        MINFRESH = r12;
        CacheControlParser$Directive r13 = new CacheControlParser$Directive("NOCACHE", 3);
        NOCACHE = r13;
        CacheControlParser$Directive r14 = new CacheControlParser$Directive("NOSTORE", 4);
        NOSTORE = r14;
        CacheControlParser$Directive r15 = new CacheControlParser$Directive("NOTRANSFORM", 5);
        NOTRANSFORM = r15;
        CacheControlParser$Directive r16 = new CacheControlParser$Directive("ONLYIFCACHED", 6);
        ONLYIFCACHED = r16;
        CacheControlParser$Directive r17 = new CacheControlParser$Directive("MUSTREVALIDATE", 7);
        MUSTREVALIDATE = r17;
        CacheControlParser$Directive r18 = new CacheControlParser$Directive("PRIVATE", 8);
        PRIVATE = r18;
        CacheControlParser$Directive r19 = new CacheControlParser$Directive("PROXYREVALIDATE", 9);
        PROXYREVALIDATE = r19;
        CacheControlParser$Directive r110 = new CacheControlParser$Directive("PUBLIC", 10);
        PUBLIC = r110;
        CacheControlParser$Directive r111 = new CacheControlParser$Directive("SMAXAGE", 11);
        SMAXAGE = r111;
        CacheControlParser$Directive r112 = new CacheControlParser$Directive("UNKNOWN", 12);
        UNKNOWN = r112;
        $VALUES = new CacheControlParser$Directive[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112};
    }

    private CacheControlParser$Directive(String r10, int r11) {
        super(r10, r11);
    }

    public static CacheControlParser$Directive select(String r10) {
        return valueOf(r10.toUpperCase().replaceAll("-", ""));
    L5:
        return UNKNOWN;
    }

    public static CacheControlParser$Directive valueOf(String r10) {
        return (CacheControlParser$Directive) Enum.valueOf(CacheControlParser$Directive.class, r10);
    }

    public static CacheControlParser$Directive[] values() {
        return (CacheControlParser$Directive[]) $VALUES.clone();
    }
}
