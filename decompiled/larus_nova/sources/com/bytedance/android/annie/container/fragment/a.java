package com.bytedance.android.annie.container.fragment;

import android.net.Uri;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, WeakReference<IHybridComponent>> f39339a = null;

    static {
        f39339a = new LinkedHashMap();
    }

    public static String a(String r100) {
        String r101 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        Uri r102 = UriProtector.parse(r100);
        String r103 = UriProtector.getQueryParameter(r102, "card_cache_key");
        String r104 = null;
        if (r103 != null) goto L8;
    L13:
        String r105 = UriProtector.getQueryParameter(r102, "url");
        if (r105 == null) goto L17;
        r101 = r105;
    L17:
        Uri r106 = UriProtector.parse(r101);
        StringBuilder r107 = new StringBuilder();
        if (r106 == null) goto L20;
        String r108 = r106.getHost();
    L21:
        r107.append(r108);
        if (r106 == null) goto L24;
        r104 = r106.getPath();
    L24:
        r107.append(r104);
        r107.append("?&room_id=");
        r107.append(UriProtector.getQueryParameter(r102, "room_id"));
        return r107.toString();
    L20:
        r108 = null;
        goto L21
    L8:
        if (com.bytedance.forest.utils.h.a(r103) == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L13;
        return r103;
    }

    public static IHybridComponent b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Map<String, WeakReference<IHybridComponent>> r101 = f39339a;
        r101.size();
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100);
        if (r102 == null) goto L7;
        IHybridComponent r103 = (IHybridComponent) r102.get();
        if (r103 == null) goto L7;
        r103.toString();
        return r103;
    L7:
        return null;
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Map<String, WeakReference<IHybridComponent>> r101 = f39339a;
        WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100);
        if (r102 == null) goto L7;
        IHybridComponent r103 = (IHybridComponent) r102.get();
        if (r103 == null) goto L7;
        r103.release();
    L7:
        r101.remove(r100);
        r101.size();
    }

    public static void c(String r100, IHybridComponent r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "component");
        Objects.toString(r101);
        Map<String, WeakReference<IHybridComponent>> r102 = f39339a;
        r102.put(r100, new WeakReference(r101));
        r102.size();
    }
}
