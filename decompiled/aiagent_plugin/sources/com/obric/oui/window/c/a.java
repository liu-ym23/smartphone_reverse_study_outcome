package com.obric.oui.window.c;

import com.obric.oui.window.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: AdaptedWindowSize.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "AdaptedWindowSize";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36875a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile f f36876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f36877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static float f36878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static com.obric.oui.window.a.a f36879e;
    private static com.obric.oui.window.a.a f;
    private static int g;
    private static Set<Integer> h;
    private static ArrayList<Object> i;

    private a() {
    }

    static {
        f36875a = new a();
        f36876b = f.f36863a;
        f36877c = 1;
        com.obric.oui.window.a.a r0 = new com.obric.oui.window.a.a(0.0f, 0.0f);
        f36879e = r0;
        f = r0;
        g = -1;
        h = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        i = new ArrayList();
    }

    public final f a() {
        return f36876b;
    }

    public final com.obric.oui.window.a.a b() {
        return f36879e;
    }

    public final float c() {
        if (o.a(f, f36879e) == true) goto L6;
        f = f36879e;
        int r0 = f36876b.a().c().a();
        int r1 = f36876b.a().a().a();
        f36878d = ((b().b() - (r0 * 2)) - ((r1 - 1) * f36876b.a().b().a())) / r1;
    L6:
        return f36878d;
    }
}
