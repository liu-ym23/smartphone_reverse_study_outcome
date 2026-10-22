package com.obric.oui.calendar;

import android.graphics.drawable.Drawable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: DayViewFacade.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f34378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f34379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f34380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedList<a> f34381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f34382e;

    /* JADX INFO: compiled from: DayViewFacade.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f34383a;
    }

    e() {
        this.f34379b = null;
        this.f34380c = null;
        this.f34381d = new LinkedList();
        this.f34382e = false;
        this.f34378a = false;
    }

    public void a(Drawable r1) {
        if (r1 == null) goto L6;
        this.f34379b = r1;
        this.f34378a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    public void b(Drawable r1) {
        if (r1 == null) goto L6;
        this.f34380c = r1;
        this.f34378a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    void a() {
        this.f34379b = null;
        this.f34380c = null;
        this.f34381d.clear();
        this.f34378a = false;
        this.f34382e = false;
    }

    void a(e r3) {
        Drawable r0 = this.f34380c;
        if (r0 == null) goto L5;
        r3.b(r0);
    L5:
        Drawable r1 = this.f34379b;
        if (r1 == null) goto L8;
        r3.a(r1);
    L8:
        r3.f34381d.addAll(this.f34381d);
        r3.f34378a |= this.f34378a;
        r3.f34382e = this.f34382e;
    }

    boolean b() {
        return this.f34378a;
    }

    Drawable c() {
        return this.f34380c;
    }

    Drawable d() {
        return this.f34379b;
    }

    List<a> e() {
        return Collections.unmodifiableList(this.f34381d);
    }

    public boolean f() {
        return this.f34382e;
    }
}
