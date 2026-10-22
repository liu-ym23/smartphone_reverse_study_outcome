package com.bytedance.android.harmony.channel.js;

import com.bytedance.android.harmony.channel.c;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import xw.b;
import xw.d;
import xw.f;
import xw.g;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.harmony.channel.a<JsonObject, JsonObject, JsonObject> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [xw.b] */
    /* JADX WARN: Type inference failed for: r3v5, types: [xw.f] */
    /* JADX WARN: Type inference failed for: r3v6, types: [xw.a] */
    /* JADX WARN: Type inference failed for: r3v7, types: [xw.g] */
    /* JADX WARN: Type inference failed for: r3v8, types: [xw.g] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
    @Override // com.bytedance.android.harmony.channel.a
    public final void b(List<? extends c<? extends JsonObject, ? extends JsonObject>> r100) {
        d r101 = new d();
        List<? extends c<? extends JsonObject, ? extends JsonObject>> r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L30;
        c r105 = (c) r104.next();
        if ((r105 instanceof c.b) == false) goto L9;
        ?? r106 = new b();
        r106.e(r105.a());
        c.b r107 = (c.b) r105;
        r106.g(r107.f58185b);
        r106.h(r107.f58186c);
        r106.f();
    L27:
        r103.add(r106);
        goto L4
    L9:
        if ((r105 instanceof c.d.a) == false) goto L12;
        r106 = new g();
        r106.d(r105.a());
        r106.e(((c.d.a) r105).f58189b);
        goto L27
    L12:
        if ((r105 instanceof c.d.b) == false) goto L15;
        r106 = new g();
        r106.d(r105.a());
        com.bytedance.android.harmony.channel.b r108 = ((c.d.b) r105).f58191b;
        xw.c r109 = new xw.c();
        r109.e(r108.f58178a);
        r109.h(r108.f58179b);
        r109.g(r108.f58180c);
        r109.f();
        r106.f(r109);
        goto L27
    L15:
        if ((r105 instanceof c.a) == false) goto L25;
        r106 = new xw.a();
        r106.c(r105.a());
        c.a r110 = (c.a) r105;
        if (r110.f58182b == false) goto L19;
        int r111 = 2;
    L21:
        if (r110.f58183c == false) goto L23;
        r111 = r111 | 1;
    L23:
        r106.d(r111);
        goto L27
    L19:
        r111 = 0;
        goto L21
    L25:
        if ((r105 instanceof c.C0923c) == false) goto L29;
        r106 = new f();
        r106.b(((c.C0923c) r105).f58187a);
        goto L27
    L29:
        throw new NoWhenBranchMatchedException();
    L30:
        r101.b(r103);
        throw null;
    }
}
