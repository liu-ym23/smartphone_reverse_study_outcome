package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: Key.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f34861a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f34862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f34863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f34864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f34865e;
    HashMap<String, com.obric.oui.constraintlayout.widget.a> f;

    static {
    }

    public abstract d a();

    abstract void a(Context r1, AttributeSet r2);

    public abstract void a(HashMap<String, com.obric.oui.constraintlayout.motion.utils.c> r1);

    abstract void a(HashSet<String> r1);

    public void b(HashMap<String, Integer> r1) {
    }

    public d() {
        int r0 = f34861a;
        this.f34862b = r0;
        this.f34863c = r0;
        this.f34864d = null;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    boolean a(String r1) {
        String r0 = this.f34864d;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.matches(r0);
    L8:
        return false;
    }

    float a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == false) goto L6;
        return ((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.aiagent.plugin")).floatValue();
    L6:
        return Float.parseFloat(r2.toString());
    }

    int b(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L6;
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L6:
        return Integer.parseInt(r2.toString());
    }

    boolean c(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L6;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        return Boolean.parseBoolean(r2.toString());
    }

    public d a(d r2) {
        this.f34862b = r2.f34862b;
        this.f34863c = r2.f34863c;
        this.f34864d = r2.f34864d;
        this.f34865e = r2.f34865e;
        this.f = r2.f;
        return this;
    }

    public d a(int r1) {
        this.f34863c = r1;
        return this;
    }

    public void b(int r1) {
        this.f34862b = r1;
    }
}
