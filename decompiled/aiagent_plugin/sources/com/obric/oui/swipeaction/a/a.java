package com.obric.oui.swipeaction.a;

import android.view.View;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SwipeItemMangerImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f36281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f36282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Set<Integer> f36283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Set<OSwipeLayout> f36284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.obric.oui.swipeaction.b.a f36285e;
    private com.obric.oui.swipeaction.c.a.EnumC0996a f;

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SwipeItemMangerImpl.java */
    class C0995a implements OSwipeLayout.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f36286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f36287b;

        C0995a(a r1, int r2) {
            this.f36286a = r1;
            this.f36287b = r2;
        }

        public void a(int r1) {
            this.f36287b = r1;
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.c
        public void a(OSwipeLayout r2) {
            if (this.f36286a.c(this.f36287b) == false) goto L5;
            r2.open(false, false);
            return;
        L5:
            r2.close(false, false);
        }
    }

    /* JADX INFO: compiled from: SwipeItemMangerImpl.java */
    class b extends com.obric.oui.swipeaction.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f36288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f36289b;

        b(a r1, int r2) {
            this.f36288a = r1;
            this.f36289b = r2;
        }

        @Override // com.obric.oui.swipeaction.b, com.obric.oui.swipeaction.OSwipeLayout.i
        public void d(OSwipeLayout r2) {
            if (a.a(this.f36288a) != com.obric.oui.swipeaction.c.a.EnumC0996a.f36295b) goto L5;
            this.f36288a.f36283c.remove(Integer.valueOf(this.f36289b));
            return;
        L5:
            this.f36288a.f36282b = -1;
        }

        @Override // com.obric.oui.swipeaction.b, com.obric.oui.swipeaction.OSwipeLayout.i
        public void a(OSwipeLayout r3) {
            if (a.a(this.f36288a) != com.obric.oui.swipeaction.c.a.EnumC0996a.f36294a) goto L6;
            this.f36288a.a(r3);
            return;
        }

        @Override // com.obric.oui.swipeaction.b, com.obric.oui.swipeaction.OSwipeLayout.i
        public void b(OSwipeLayout r3) {
            if (a.a(this.f36288a) != com.obric.oui.swipeaction.c.a.EnumC0996a.f36295b) goto L5;
            this.f36288a.f36283c.add(Integer.valueOf(this.f36289b));
            return;
        L5:
            this.f36288a.a(r3);
            a r4 = this.f36288a;
            r4.f36282b = this.f36289b;
        }

        public void a(int r1) {
            this.f36289b = r1;
        }
    }

    /* JADX INFO: compiled from: SwipeItemMangerImpl.java */
    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        C0995a f36290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        b f36291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f36292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f36293d;

        c(a r1, int r2, b r3, C0995a r4) {
            this.f36293d = r1;
            this.f36291b = r3;
            this.f36290a = r4;
            this.f36292c = r2;
        }
    }

    static /* synthetic */ com.obric.oui.swipeaction.c.a.EnumC0996a a(a r0) {
        return r0.f;
    }

    public a(com.obric.oui.swipeaction.b.a r3) {
        com.obric.oui.swipeaction.b.a r4 = (com.obric.oui.swipeaction.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.swipeaction.b.a.class, "com.obric.aiagent.plugin");
        this.f = com.obric.oui.swipeaction.c.a.EnumC0996a.f36294a;
        this.f36281a = -1;
        this.f36282b = -1;
        this.f36283c = new HashSet();
        this.f36284d = new HashSet();
        if (r4 == null) goto L7;
        this.f36285e = r4;
        return;
    L7:
        throw new IllegalArgumentException("SwipeAdapterInterface can not be null");
    }

    public com.obric.oui.swipeaction.c.a.EnumC0996a a() {
        return this.f;
    }

    public void a(com.obric.oui.swipeaction.c.a.EnumC0996a r1) {
        this.f = r1;
        this.f36283c.clear();
        this.f36284d.clear();
        this.f36282b = -1;
    }

    public void a(View r5, int r6) {
        int r0 = this.f36285e.getSwipeLayoutResourceId(r6);
        OSwipeLayout r7 = (OSwipeLayout) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OSwipeLayout.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L10;
        if (r7.getTag(r0) != null) goto L7;
        C0995a r1 = new C0995a(this, r6);
        b r2 = new b(this, r6);
        r7.addSwipeListener(r2);
        r7.addOnLayoutListener(r1);
        r7.setTag(r0, new c(this, r6, r2, r1));
        this.f36284d.add(r7);
        return;
    L7:
        c r4 = (c) ZeusTransformUtils.preCheckCast(r7.getTag(r0), c.class, "com.obric.aiagent.plugin");
        r4.f36291b.a(r6);
        r4.f36290a.a(r6);
        r4.f36292c = r6;
        return;
    L10:
        throw new IllegalStateException("can not find SwipeLayout in target view");
    }

    public void a(int r3) {
        if (this.f == com.obric.oui.swipeaction.c.a.EnumC0996a.f36295b) goto L5;
        this.f36282b = r3;
    L8:
        this.f36285e.notifyDatasetChanged();
        return;
    L5:
        if (this.f36283c.contains(Integer.valueOf(r3)) == true) goto L8;
        this.f36283c.add(Integer.valueOf(r3));
        goto L8
    }

    public void b(int r3) {
        if (this.f != com.obric.oui.swipeaction.c.a.EnumC0996a.f36295b) goto L6;
        this.f36283c.remove(Integer.valueOf(r3));
    L8:
        this.f36285e.notifyDatasetChanged();
        return;
    L6:
        if (this.f36282b != r3) goto L8;
        this.f36282b = -1;
        goto L8
    }

    public void a(OSwipeLayout r4) {
        Iterator<OSwipeLayout> r3 = this.f36284d.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        OSwipeLayout r0 = (OSwipeLayout) ZeusTransformUtils.preCheckCast(r3.next(), OSwipeLayout.class, "com.obric.aiagent.plugin");
        if (r0 == r4) goto L4;
        r0.close();
        goto L4
    }

    public void b() {
        if (this.f != com.obric.oui.swipeaction.c.a.EnumC0996a.f36295b) goto L5;
        this.f36283c.clear();
    L6:
        Iterator<OSwipeLayout> r3 = this.f36284d.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ((OSwipeLayout) ZeusTransformUtils.preCheckCast(r3.next(), OSwipeLayout.class, "com.obric.aiagent.plugin")).close();
        goto L8
    L10:
        return;
    L5:
        this.f36282b = -1;
        goto L6
    }

    public void b(OSwipeLayout r1) {
        this.f36284d.remove(r1);
    }

    public List<Integer> c() {
        if (this.f != com.obric.oui.swipeaction.c.a.EnumC0996a.f36295b) goto L7;
        return new ArrayList(this.f36283c);
    L7:
        return Collections.singletonList(Integer.valueOf(this.f36282b));
    }

    public List<OSwipeLayout> d() {
        return new ArrayList(this.f36284d);
    }

    public boolean c(int r3) {
        if (this.f != com.obric.oui.swipeaction.c.a.EnumC0996a.f36295b) goto L7;
        return this.f36283c.contains(Integer.valueOf(r3));
    L7:
        if (this.f36282b != r3) goto L9;
        return true;
    L9:
        return false;
    }
}
