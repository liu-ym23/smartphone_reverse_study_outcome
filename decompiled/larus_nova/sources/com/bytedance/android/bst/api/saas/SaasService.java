package com.bytedance.android.bst.api.saas;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.api.ext.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class SaasService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f41926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<c<Activity>, List<b>> f41927b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f41928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41929b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f41928a, r101.f41928a) == true) goto L8;
            return false;
        L8:
            if (this.f41929b == r101.f41929b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f41928a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.f41929b;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "SimpleNode(itemHash=" + this.f41928a + ", businessTag=" + this.f41929b + ")";
        }

        public b(String r100, int r101) {
            this.f41928a = r100;
            this.f41929b = r101;
        }
    }

    static {
    }

    public SaasService() {
        this.f41927b = new LinkedHashMap();
    }

    public final synchronized void b(View r100) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (this.f41926a == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f41926a = true;     // Catch: Throwable -> L24
        Context r101 = r100.getContext().getApplicationContext();     // Catch: Throwable -> L24
        if (r101 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        if ((r101 instanceof Application) == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        com.bytedance.android.bst.api.ext.b r102 = new com.bytedance.android.bst.api.ext.b(null);     // Catch: Throwable -> L24
        ((Application) r101).registerActivityLifecycleCallbacks(r102.f41922c);     // Catch: Throwable -> L24
        Function1<Activity, Unit> r103 = new SaasService$registerActivityMonitorIfNeed$1(this);     // Catch: Throwable -> L24
        HashMap<String, ArrayList<Function1<Activity, Unit>>> r104 = r102.f41920a;     // Catch: Throwable -> L24
        ArrayList<Function1<Activity, Unit>> r105 = r104.get("onActivityCreated");     // Catch: Throwable -> L24
        if (r105 != null) goto L17;
        r105 = new ArrayList();     // Catch: Throwable -> L24
        r104.put("onActivityCreated", r105);     // Catch: Throwable -> L24
    L17:
        r105.add(r103);     // Catch: Throwable -> L24
        Function1<Activity, Boolean> r106 = new SaasService$registerActivityMonitorIfNeed$2(this);     // Catch: Throwable -> L24
        if (r102.f41921b.contains(r106) == true) goto L20;
        r102.f41921b.add(r106);     // Catch: Throwable -> L24
    L20:
        monitor-exit(this);
    }

    public final void a(RecyclerView r100, final int r101) {
        boolean r102 = false;
        if ((r101 >>> 24) < 2) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L20;
        if (r101 == (-1)) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L18;
        ExtKt.b("SaasService", "--clearViewStatusCache--\n businessTag:" + r100.getResources().getResourceEntryName(r101));
        Activity r104 = ExtKt.getActivity(r100);
        if (r104 == null) goto L21;
        List r105 = (List) ((LinkedHashMap) this.f41927b).get(new c(r104));
        if (r105 == null) goto L22;
        CollectionsKt.removeAll(r105, new SaasService$clearViewStatusCache$3(r101));
        return;
    L22:
        return;
    L21:
        return;
    L18:
        throw new IllegalArgumentException("The key must can not be empty business tag".toString());
    L20:
        throw new IllegalArgumentException("The key must be an application-specific resource id.".toString());
    L5:
        r103 = false;
        goto L6
    }
}
