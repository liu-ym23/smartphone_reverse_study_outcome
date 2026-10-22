package com.bytedance.android.latch.internal.util;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f58388a = null;

    static {
        f58388a = new Handler(Looper.getMainLooper());
    }

    public static final JSONObject a(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair<String, ? extends Object> r104 = r100[r103];
        r101.put(r104.getFirst(), r104.getSecond());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final JSONObject b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == false) goto L9;
        r104 = b((JSONObject) r104);
    L10:
        r101.put(r103, r104);
        goto L4
    L9:
        if ((r104 instanceof JSONArray) == false) goto L10;
        throw new IllegalStateException("copy operation to JSONArray is not supported".toString());
    L13:
        return r101;
    }

    public static final void c(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        Iterator<String> r102 = r101.keys();
    L4:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();
        if (r100.has(r103) == true) goto L7;
        r100.put(r103, r101.get(r103));
        goto L4
    L7:
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == true) goto L9;
        if ((r104 instanceof JSONArray) == false) goto L4;
        throw new IllegalStateException("merging operation to JSONArray is not supported".toString());
    L9:
        c((JSONObject) r104, JSONObjectProtectorUtils.getJSONObject(r101, r103));
        goto L4
    }

    public static final void d(Disposable r100, CompositeDisposable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "compositeDisposable");
        r101.add(r100);
    }
}
