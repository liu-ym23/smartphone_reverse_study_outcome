package androidx.room;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DatabaseConfiguration.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.sqlite.db.d.c f2623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p.d f2626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<p.b> f2627e;
    public final p.e f;
    public final List<Object> g;
    public final List<androidx.room.a.a> h;
    public final boolean i;
    public final p.c j;
    public final Executor k;
    public final Executor l;
    public final boolean m;
    public final Intent n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final File r;
    public final Callable<InputStream> s;
    private final Set<Integer> t;

    public c(Context r14, String r15, androidx.sqlite.db.d.c r16, p.d r17, List<p.b> r18, boolean r19, p.c r20, Executor r21, Executor r22, Intent r23, boolean r24, boolean r25, Set<Integer> r26, String r27, File r28, Callable<InputStream> r29, p.e r30, List<Object> r31, List<androidx.room.a.a> r32) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        androidx.sqlite.db.d.c r4 = (androidx.sqlite.db.d.c) ZeusTransformUtils.wrapperContextForParams(r16, androidx.sqlite.db.d.c.class, "com.obric.aiagent.plugin");
        List<p.b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r21, Executor.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r22, Executor.class, "com.obric.aiagent.plugin");
        Set<Integer> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r26, Set.class, "com.obric.aiagent.plugin");
        Callable<InputStream> r9 = (Callable) ZeusTransformUtils.wrapperContextForParams(r29, Callable.class, "com.obric.aiagent.plugin");
        List<Object> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        List<androidx.room.a.a> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.aiagent.plugin");
        this.f2623a = r4;
        this.f2624b = ZeusTransformUtils.wrapperContext(r2, "com.obric.aiagent.plugin");
        this.f2625c = r15;
        this.f2626d = r17;
        this.f2627e = r5;
        this.i = r19;
        this.j = r20;
        this.k = r6;
        this.l = r7;
        this.n = r23;
        if (r23 == null) goto L5;
        boolean r1 = true;
    L6:
        this.m = r1;
        this.o = r24;
        this.p = r25;
        this.t = r8;
        this.q = r27;
        this.r = r28;
        this.s = r9;
        this.f = r30;
        if (r10 != null) goto L9;
        r10 = Collections.emptyList();
    L9:
        this.g = r10;
        if (r11 != null) goto L12;
        r11 = Collections.emptyList();
    L12:
        this.h = r11;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public boolean a(int r3, int r4) {
        if (r3 <= r4) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L11;
        if (this.p == false) goto L11;
        return false;
    L11:
        if (this.o == false) goto L18;
        Set<Integer> r2 = this.t;
        if (r2 != null) goto L15;
        return true;
    L15:
        if (r2.contains(Integer.valueOf(r3)) == true) goto L18;
        return true;
    L18:
        return false;
    L5:
        r5 = false;
        goto L6
    }
}
