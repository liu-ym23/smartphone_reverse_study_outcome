package com.bytedance.android.gamecp.common.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57216a = 0;

    static {
    }

    public static List a(JSONObject r110, JSONObject r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "obj1");
        Intrinsics.checkNotNullParameter(r111, "obj2");
        Intrinsics.checkNotNullParameter(r112, "path");
        ArrayList r100 = new ArrayList();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L29
        Set r102 = SequencesKt.toSet(SequencesKt.asSequence(r110.keys()));     // Catch: Throwable -> L29
        Set r103 = SequencesKt.toSet(SequencesKt.asSequence(r111.keys()));     // Catch: Throwable -> L29
        Iterator r104 = SetsKt.minus(r102, r103).iterator();     // Catch: Throwable -> L29
    L5:
        if (r104.hasNext() == false) goto L7;
        String r105 = (String) r104.next();     // Catch: Throwable -> L29
        r100.add(new c0(r112 + '.' + r105, "deleted", r110.opt(r105), null));     // Catch: Throwable -> L29
        goto L5
    L7:
        Iterator r106 = SetsKt.minus(r103, r102).iterator();     // Catch: Throwable -> L29
    L9:
        if (r106.hasNext() == false) goto L11;
        String r107 = (String) r106.next();     // Catch: Throwable -> L29
        r100.add(new c0(r112 + '.' + r107, "added", null, r111.opt(r107)));     // Catch: Throwable -> L29
        goto L9
    L11:
        Iterator r108 = CollectionsKt.intersect(r102, r103).iterator();     // Catch: Throwable -> L29
    L13:
        if (r108.hasNext() == false) goto L27;
        String r109 = (String) r108.next();     // Catch: Throwable -> L29
        Object r113 = r110.opt(r109);     // Catch: Throwable -> L29
        Object r114 = r111.opt(r109);     // Catch: Throwable -> L29
        if ((r113 instanceof JSONObject) == false) goto L20;
        if ((r114 instanceof JSONObject) == false) goto L20;
        r100.addAll(a((JSONObject) r113, (JSONObject) r114, r112 + '.' + r109));     // Catch: Throwable -> L29
    L20:
        if ((r113 instanceof JSONArray) == false) goto L25;
        if ((r114 instanceof JSONArray) == false) goto L25;
        r100.addAll(b((JSONArray) r113, (JSONArray) r114, r112 + '.' + r109));     // Catch: Throwable -> L29
    L25:
        if ((!Intrinsics.areEqual(r113, r114)) == false) goto L13;
        r100.add(new c0(r112 + '.' + r109, "modified", r113, r114));     // Catch: Throwable -> L29
        goto L13
    L27:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        return r100;
    L29:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    public static List b(JSONArray r110, JSONArray r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "arr1");
        Intrinsics.checkNotNullParameter(r111, "arr2");
        Intrinsics.checkNotNullParameter(r112, "path");
        ArrayList r100 = new ArrayList();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L27
        int r102 = r110.length();     // Catch: Throwable -> L27
        int r103 = r111.length();     // Catch: Throwable -> L27
        int r104 = Math.max(r102, r103);     // Catch: Throwable -> L27
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L25;
        Object r106 = null;
        if (r105 >= r102) goto L8;
        Object r107 = r110.opt(r105);     // Catch: Throwable -> L27
    L9:
        if (r105 >= r103) goto L12;
        r106 = r111.opt(r105);     // Catch: Throwable -> L27
    L12:
        if ((r107 instanceof JSONObject) == false) goto L17;
        if ((r106 instanceof JSONObject) == false) goto L17;
        r100.addAll(a((JSONObject) r107, (JSONObject) r106, r112 + '[' + r105 + ']'));     // Catch: Throwable -> L27
    L24:
        r105 = r105 + 1;     // Catch: Throwable -> L27
    L17:
        if ((r107 instanceof JSONArray) == false) goto L22;
        if ((r106 instanceof JSONArray) == false) goto L22;
        r100.addAll(b((JSONArray) r107, (JSONArray) r106, r112 + '[' + r105 + ']'));     // Catch: Throwable -> L27
    L22:
        if ((!Intrinsics.areEqual(r107, r106)) == false) goto L24;
        r100.add(new c0(r112 + '[' + r105 + ']', "modified", r107, r106));     // Catch: Throwable -> L27
        goto L24
    L8:
        r107 = null;
        goto L9
    L25:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        return r100;
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }
}
