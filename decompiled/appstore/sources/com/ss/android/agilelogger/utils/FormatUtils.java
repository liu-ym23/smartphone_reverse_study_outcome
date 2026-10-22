package com.ss.android.agilelogger.utils;

import android.content.Intent;
import android.os.Bundle;
import com.ss.android.agilelogger.formatter.Formatter;
import java.util.concurrent.ConcurrentHashMap;
import te.a;
import ve.b;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FormatUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap f18186a;

    public static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE BORDER = null;
        public static final TYPE BUNDLE = null;
        public static final TYPE INTENT = null;
        public static final TYPE JSON = null;
        public static final TYPE MSG = null;
        public static final TYPE STACKTRACE = null;
        public static final TYPE STACKTRACE_STR = null;
        public static final TYPE THREAD = null;
        public static final TYPE THROWABLE = null;

        static {
            TYPE r10 = new TYPE("MSG", 0);
            MSG = r10;
            TYPE r11 = new TYPE("JSON", 1);
            JSON = r11;
            TYPE r12 = new TYPE("BUNDLE", 2);
            BUNDLE = r12;
            TYPE r13 = new TYPE("INTENT", 3);
            INTENT = r13;
            TYPE r14 = new TYPE("THROWABLE", 4);
            THROWABLE = r14;
            TYPE r15 = new TYPE("BORDER", 5);
            BORDER = r15;
            TYPE r16 = new TYPE("STACKTRACE", 6);
            STACKTRACE = r16;
            TYPE r17 = new TYPE("THREAD", 7);
            THREAD = r17;
            TYPE r18 = new TYPE("STACKTRACE_STR", 8);
            STACKTRACE_STR = r18;
            $VALUES = new TYPE[]{r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        private TYPE(String r10, int r11) {
            super(r10, r11);
        }

        public static TYPE valueOf(String r10) {
            return (TYPE) Enum.valueOf(TYPE.class, r10);
        }

        public static TYPE[] values() {
            return (TYPE[]) $VALUES.clone();
        }
    }

    static {
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        f18186a = r10;
        r10.put(TYPE.MSG, new a());
        f18186a.put(TYPE.JSON, new ue.a());
        f18186a.put(TYPE.BUNDLE, new ve.a());
        f18186a.put(TYPE.INTENT, new b());
        f18186a.put(TYPE.BORDER, new se.a());
        f18186a.put(TYPE.STACKTRACE, new xe.a());
        f18186a.put(TYPE.THREAD, new ye.a());
        f18186a.put(TYPE.THROWABLE, new we.a());
    }

    public static String a(TYPE r10, Intent r11) {
        return ((b) ((Formatter) f18186a.get(r10))).a(r11);
    }

    public static String b(TYPE r10, Bundle r11) {
        return ((ve.a) ((Formatter) f18186a.get(r10))).a(r11);
    }

    public static String c(TYPE r10, String r11) {
        Formatter r12 = (Formatter) f18186a.get(r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        if (r10 != TYPE.BORDER) goto L9;
        return r12.format(new String[]{r11});
    L9:
        return r12.format(r11);
    }

    public static String d(TYPE r10, Thread r11) {
        return ((Formatter) f18186a.get(r10)).format(r11);
    }

    public static String e(TYPE r10, Throwable r11) {
        return ((Formatter) f18186a.get(r10)).format(r11);
    }

    public static String f(TYPE r10, StackTraceElement[] r11) {
        return ((Formatter) f18186a.get(r10)).format(r11);
    }
}
