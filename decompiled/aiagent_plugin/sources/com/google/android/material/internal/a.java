package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.internal.MaterialCheckable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: CheckableGroup.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<T extends MaterialCheckable<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, T> f13430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f13431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0277a f13432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13434e;

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CheckableGroup.java */
    public interface InterfaceC0277a {
        void a(Set<Integer> r1);
    }

    public a() {
        this.f13430a = new HashMap();
        this.f13431b = new HashSet();
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.f13434e;
    }

    static /* synthetic */ boolean a(a r2, MaterialCheckable r3) {
        return r2.c((MaterialCheckable) ZeusTransformUtils.wrapperContextForParams(r3, MaterialCheckable.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ boolean a(a r2, MaterialCheckable r3, boolean r4) {
        return r2.a((MaterialCheckable) ZeusTransformUtils.wrapperContextForParams(r3, MaterialCheckable.class, "com.obric.aiagent.plugin"), r4);
    }

    static /* synthetic */ void b(a r0) {
        r0.f();
    }

    public void a(boolean r2) {
        if (this.f13433d == r2) goto L6;
        this.f13433d = r2;
        c();
        return;
    }

    public boolean a() {
        return this.f13433d;
    }

    public void b(boolean r1) {
        this.f13434e = r1;
    }

    public boolean b() {
        return this.f13434e;
    }

    public void a(InterfaceC0277a r3) {
        this.f13432c = (InterfaceC0277a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0277a.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(T r3) {
        MaterialCheckable r4 = (MaterialCheckable) ZeusTransformUtils.wrapperContextForParams(r3, MaterialCheckable.class, "com.obric.aiagent.plugin");
        this.f13430a.put(Integer.valueOf(r4.getId()), (T) r4);
        if (r4.isChecked() == false) goto L5;
        c(r4);
    L5:
        r4.setInternalOnCheckedChangeListener(new AnonymousClass1(this));
    }

    public void b(T r3) {
        MaterialCheckable r4 = (MaterialCheckable) ZeusTransformUtils.wrapperContextForParams(r3, MaterialCheckable.class, "com.obric.aiagent.plugin");
        r4.setInternalOnCheckedChangeListener(null);
        this.f13430a.remove(Integer.valueOf(r4.getId()));
        this.f13431b.remove(Integer.valueOf(r4.getId()));
    }

    public void a(int r3) {
        MaterialCheckable<T> r4 = (MaterialCheckable) ZeusTransformUtils.preCheckCast(this.f13430a.get(Integer.valueOf(r3)), MaterialCheckable.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (c(r4) == false) goto L9;
        f();
        return;
    }

    public void c() {
        boolean r0 = !this.f13431b.isEmpty();
        Iterator<T> r1 = this.f13430a.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        a((MaterialCheckable) ZeusTransformUtils.preCheckCast(r1.next(), MaterialCheckable.class, "com.obric.aiagent.plugin"), false);
        goto L4
    L6:
        if (r0 == false) goto L10;
        f();
        return;
    }

    public int d() {
        if (this.f13433d == true) goto L5;
    L7:
        return -1;
    L5:
        if (this.f13431b.isEmpty() == true) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(this.f13431b.iterator().next(), Integer.class, "com.obric.aiagent.plugin")).intValue();
    }

    public Set<Integer> e() {
        return new HashSet(this.f13431b);
    }

    public List<Integer> a(ViewGroup r5) {
        Set<Integer> r4 = e();
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r5.getChildCount()) goto L11;
        View r2 = r5.getChildAt(r1);
        if (ZeusTransformUtils.instanceOf(r2, MaterialCheckable.class) == false) goto L10;
        if (r4.contains(Integer.valueOf(r2.getId())) == false) goto L10;
        r0.add(Integer.valueOf(r2.getId()));
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return r0;
    }

    private boolean c(MaterialCheckable<T> r6) {
        MaterialCheckable r7 = (MaterialCheckable) ZeusTransformUtils.wrapperContextForParams(r6, MaterialCheckable.class, "com.obric.aiagent.plugin");
        int r0 = r7.getId();
        if (this.f13431b.contains(Integer.valueOf(r0)) == false) goto L5;
        return false;
    L5:
        MaterialCheckable<T> r1 = (MaterialCheckable) ZeusTransformUtils.preCheckCast(this.f13430a.get(Integer.valueOf(d())), MaterialCheckable.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        a(r1, false);
    L8:
        boolean r5 = this.f13431b.add(Integer.valueOf(r0));
        if (r7.isChecked() == true) goto L11;
        r7.setChecked(true);
    L11:
        return r5;
    }

    private boolean a(MaterialCheckable<T> r5, boolean r6) {
        MaterialCheckable r7 = (MaterialCheckable) ZeusTransformUtils.wrapperContextForParams(r5, MaterialCheckable.class, "com.obric.aiagent.plugin");
        int r0 = r7.getId();
        if (this.f13431b.contains(Integer.valueOf(r0)) == true) goto L5;
        return false;
    L5:
        if (r6 == true) goto L7;
    L12:
        boolean r4 = this.f13431b.remove(Integer.valueOf(r0));
        if (r7.isChecked() == false) goto L15;
        r7.setChecked(false);
    L15:
        return r4;
    L7:
        if (this.f13431b.size() != 1) goto L12;
        if (this.f13431b.contains(Integer.valueOf(r0)) == false) goto L12;
        r7.setChecked(true);
        return false;
    }

    private void f() {
        InterfaceC0277a r0 = this.f13432c;
        if (r0 == null) goto L6;
        r0.a(e());
        return;
    }
}
