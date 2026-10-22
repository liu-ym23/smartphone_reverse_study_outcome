package org.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: State.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f40249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f40250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Character, b> f40251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f40252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f40253e;

    public b() {
        this(0);
    }

    public b(int r2) {
        this.f40251c = new HashMap();
        b r0 = null;
        this.f40252d = null;
        this.f40253e = null;
        this.f40249a = r2;
        if (r2 != 0) goto L5;
        r0 = this;
    L5:
        this.f40250b = r0;
    }

    private b a(Character r3, boolean r4) {
        b r5 = (b) ZeusTransformUtils.preCheckCast(this.f40251c.get(r3), b.class, "com.obric.aiagent.plugin");
        if (r4 == true) goto L9;
        if (r5 != null) goto L10;
        b r2 = this.f40250b;
        if (r2 != null) goto L8;
        return r5;
    L8:
        return r2;
    L10:
        return r5;
    L9:
        return r5;
    }

    public b a(Character r2) {
        return a(r2, false);
    }

    public b b(Character r2) {
        return a(r2, true);
    }

    public b c(Character r3) {
        b r0 = b(r3);
        if (r0 != null) goto L6;
        b r1 = new b(this.f40249a + 1);
        this.f40251c.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public void a(String r2) {
        if (this.f40253e != null) goto L5;
        this.f40253e = new TreeSet();
    L5:
        this.f40253e.add(r2);
    }

    public void a(Collection<String> r4) {
        Iterator r5 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        a((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    public Collection<String> a() {
        Set<String> r0 = this.f40253e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Collections.emptyList();
    }

    public b b() {
        return this.f40252d;
    }

    public void a(b r1) {
        this.f40252d = r1;
    }

    public Collection<b> c() {
        return this.f40251c.values();
    }

    public Collection<Character> d() {
        return this.f40251c.keySet();
    }
}
