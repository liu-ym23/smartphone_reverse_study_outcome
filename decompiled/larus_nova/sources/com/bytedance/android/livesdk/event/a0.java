package com.bytedance.android.livesdk.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<l> f123317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<l> f123318b;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f123319a = null;

        static {
            f123319a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return Intrinsics.compare(((l) r100).getStart(), ((l) r101).getStart());
        }
    }

    public final String a() {
        JSONArray r100 = new JSONArray();
        ArrayList r101 = new ArrayList();
        List<l> r102 = this.f123317a;
        if (r102 == null) goto L5;
        r101.addAll(r102);
    L5:
        List<l> r103 = this.f123318b;
        if (r103 == null) goto L8;
        r101.addAll(r103);
    L8:
        Collections.sort(r101, a.f123319a);
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L13;
        l r105 = (l) r104.next();
        JSONObject r106 = new JSONObject();
        r106.put("type", r105.getType());
        r106.put("value", r105.getValue());
        r106.put("start", r105.getStart());
        r106.put("length", r105.getLength());
        r100.put(r106);
        goto L10
    L13:
        if (r100.length() != 0) goto L17;
        return null;
    L17:
        return r100.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a0(List<? extends l> r100, List<? extends l> r101) {
        this.f123317a = r100;
        this.f123318b = r101;
    }
}
