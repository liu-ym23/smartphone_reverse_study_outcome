package com.bytedance.frameworks.baselib.network.http.parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class CacheControlParser {
    private static final String REGEX = "\\s*([\\w\\-]+)\\s*(=)?\\s*(\\d+|\\\"([^\"\\\\]*(\\\\.[^\"\\\\]*)*)+\\\")?\\s*";
    private static final Pattern pattern = null;
    private HashMap<Directive, String> values;

    public static final enum Directive extends Enum<Directive> {
        private static final /* synthetic */ Directive[] $VALUES = null;
        public static final Directive MAXAGE = null;
        public static final Directive MAXSTALE = null;
        public static final Directive MINFRESH = null;
        public static final Directive MUSTREVALIDATE = null;
        public static final Directive NOCACHE = null;
        public static final Directive NOSTORE = null;
        public static final Directive NOTRANSFORM = null;
        public static final Directive ONLYIFCACHED = null;
        public static final Directive PRIVATE = null;
        public static final Directive PROXYREVALIDATE = null;
        public static final Directive PUBLIC = null;
        public static final Directive SMAXAGE = null;
        public static final Directive UNKNOWN = null;

        private Directive(String r1, int r2) {
            super(r1, r2);
        }

        public static Directive valueOf(String r1) {
            return (Directive) Enum.valueOf(Directive.class, r1);
        }

        public static Directive[] values() {
            return (Directive[]) $VALUES.clone();
        }

        static {
            Directive r0 = new Directive("MAXAGE", 0);
            MAXAGE = r0;
            Directive r1 = new Directive("MAXSTALE", 1);
            MAXSTALE = r1;
            Directive r3 = new Directive("MINFRESH", 2);
            MINFRESH = r3;
            Directive r5 = new Directive("NOCACHE", 3);
            NOCACHE = r5;
            Directive r7 = new Directive("NOSTORE", 4);
            NOSTORE = r7;
            Directive r9 = new Directive("NOTRANSFORM", 5);
            NOTRANSFORM = r9;
            Directive r11 = new Directive("ONLYIFCACHED", 6);
            ONLYIFCACHED = r11;
            Directive r13 = new Directive("MUSTREVALIDATE", 7);
            MUSTREVALIDATE = r13;
            Directive r15 = new Directive("PRIVATE", 8);
            PRIVATE = r15;
            Directive r14 = new Directive("PROXYREVALIDATE", 9);
            PROXYREVALIDATE = r14;
            Directive r12 = new Directive("PUBLIC", 10);
            PUBLIC = r12;
            Directive r10 = new Directive("SMAXAGE", 11);
            SMAXAGE = r10;
            Directive r8 = new Directive("UNKNOWN", 12);
            UNKNOWN = r8;
            $VALUES = new Directive[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        }

        public static Directive select(String r2) {
            return valueOf(r2.toUpperCase().replaceAll("-", ""));
        L5:
            return UNKNOWN;
        }
    }

    static {
        pattern = Pattern.compile(REGEX);
    }

    public CacheControlParser(String r4) {
        this.values = new HashMap();
        Matcher r5 = pattern.matcher(r4);     // Catch: IllegalArgumentException -> L11
    L5:
        if (r5.find() == false) goto L19;
        Directive r0 = Directive.select(r5.group(1));     // Catch: IllegalArgumentException -> L11
        if (r0 == Directive.UNKNOWN) goto L5;
        this.values.put(r0, r5.group(3));     // Catch: IllegalArgumentException -> L11
    L19:
        return;
    }

    public Map<Directive, String> getValues() {
        return this.values;
    }

    public String getValue(Directive r1) {
        return this.values.get(r1);
    }

    public Iterator<Directive> iterator() {
        return this.values.keySet().iterator();
    }
}
