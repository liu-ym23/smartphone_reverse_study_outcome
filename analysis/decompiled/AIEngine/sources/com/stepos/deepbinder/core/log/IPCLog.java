package com.stepos.deepbinder.core.log;

import android.util.Log;
import f.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class IPCLog {
    public static final IPCLog INSTANCE = new IPCLog();
    private static final String PRE_TAG = "DBD.";

    private IPCLog() {
    }

    private final String buildLogMsg(String str, Object... objArr) {
        if (str == null && objArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(64);
        if (str != null) {
            sb2.append(str);
        }
        ArrayList arrayListM0 = kotlin.collections.a.m0(l.q0(objArr));
        int size = arrayListM0.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayListM0.get(i10);
            i10++;
            List list = (List) obj;
            sb2.append(" ");
            Object objW0 = kotlin.collections.a.w0(0, list);
            if (objW0 != null) {
                sb2.append(objW0);
            }
            if (list.size() > 1) {
                sb2.append(":");
                Object objW02 = kotlin.collections.a.w0(1, list);
                if (objW02 != null) {
                    sb2.append(objW02);
                }
            }
        }
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    private final String buildLogTag(String str) {
        return ai.onnxruntime.a.k(PRE_TAG, str);
    }

    @a
    public final void d(String tag, String str, Object... args) {
        g.f(tag, "tag");
        g.f(args, "args");
        Log.d(buildLogTag(tag), buildLogMsg(str, Arrays.copyOf(args, args.length)));
    }

    @a
    public final void e(String tag, String str, Object... args) {
        g.f(tag, "tag");
        g.f(args, "args");
        Log.e(buildLogTag(tag), buildLogMsg(str, Arrays.copyOf(args, args.length)));
    }

    @a
    public final void i(String tag, String str, Object... args) {
        g.f(tag, "tag");
        g.f(args, "args");
        Log.i(buildLogTag(tag), buildLogMsg(str, Arrays.copyOf(args, args.length)));
    }

    @a
    public final void w(String tag, String str, Object... args) {
        g.f(tag, "tag");
        g.f(args, "args");
        Log.w(buildLogTag(tag), buildLogMsg(str, Arrays.copyOf(args, args.length)));
    }

    @a
    public final void e(String tag, String str, Throwable th, Object... args) {
        g.f(tag, "tag");
        g.f(args, "args");
        Log.e(buildLogTag(tag), buildLogMsg(str, Arrays.copyOf(args, args.length)), th);
    }
}
