package com.obric.oui.calendar;

import android.graphics.drawable.Drawable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f12709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f12710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList f12711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12712e;

    public e() {
        this.f12709b = null;
        this.f12710c = null;
        this.f12711d = new LinkedList();
        this.f12712e = false;
        this.f12708a = false;
    }

    public void a(e r10) {
        Drawable r11 = this.f12710c;
        if (r11 == null) goto L5;
        r10.i(r11);
    L5:
        Drawable r12 = this.f12709b;
        if (r12 == null) goto L8;
        r10.h(r12);
    L8:
        r10.f12711d.addAll(this.f12711d);
        r10.f12708a |= this.f12708a;
        r10.f12712e = this.f12712e;
    }

    public boolean b() {
        return this.f12712e;
    }

    public Drawable c() {
        return this.f12709b;
    }

    public Drawable d() {
        return this.f12710c;
    }

    public List e() {
        return Collections.unmodifiableList(this.f12711d);
    }

    public boolean f() {
        return this.f12708a;
    }

    public void g() {
        this.f12709b = null;
        this.f12710c = null;
        this.f12711d.clear();
        this.f12708a = false;
        this.f12712e = false;
    }

    public void h(Drawable r10) {
        if (r10 == null) goto L6;
        this.f12709b = r10;
        this.f12708a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    public void i(Drawable r10) {
        if (r10 == null) goto L6;
        this.f12710c = r10;
        this.f12708a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }
}
