package com.stepos.common.widget;

/* loaded from: classes3.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public int f3709a = 9;
    public int b = 10;
    public final /* synthetic */ ScrollTextView c;

    public F(ScrollTextView scrollTextView) {
        this.c = scrollTextView;
    }

    public final String a(int i) {
        C c;
        if (i < 0 || i >= this.b || (c = this.c.f3757r) == null) {
            return null;
        }
        return c.a(i);
    }
}
