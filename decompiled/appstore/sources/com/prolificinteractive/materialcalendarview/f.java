package com.prolificinteractive.materialcalendarview;

import android.graphics.drawable.Drawable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f17802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f17803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList f17804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17805e;

    public f() {
        this.f17802b = null;
        this.f17803c = null;
        this.f17804d = new LinkedList();
        this.f17805e = false;
        this.f17801a = false;
    }

    public void a(f r10) {
        Drawable r11 = this.f17803c;
        if (r11 == null) goto L5;
        r10.i(r11);
    L5:
        Drawable r12 = this.f17802b;
        if (r12 == null) goto L8;
        r10.h(r12);
    L8:
        r10.f17804d.addAll(this.f17804d);
        r10.f17801a |= this.f17801a;
        r10.f17805e = this.f17805e;
    }

    public boolean b() {
        return this.f17805e;
    }

    public Drawable c() {
        return this.f17802b;
    }

    public Drawable d() {
        return this.f17803c;
    }

    public List e() {
        return Collections.unmodifiableList(this.f17804d);
    }

    public boolean f() {
        return this.f17801a;
    }

    public void g() {
        this.f17802b = null;
        this.f17803c = null;
        this.f17804d.clear();
        this.f17801a = false;
        this.f17805e = false;
    }

    public void h(Drawable r10) {
        if (r10 == null) goto L6;
        this.f17802b = r10;
        this.f17801a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    public void i(Drawable r10) {
        if (r10 == null) goto L6;
        this.f17803c = r10;
        this.f17801a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }
}
