package com.stepos.common.widget;

/* loaded from: classes.dex */
public final class A implements y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11433a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScrollTextView f11434b;

    public /* synthetic */ A(ScrollTextView scrollTextView, int i4) {
        this.f11433a = i4;
        this.f11434b = scrollTextView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A(ScrollTextView scrollTextView, int i4, int i5) {
        this(scrollTextView, 0);
        this.f11433a = i4;
        int i6 = 1;
        if (i4 != 1) {
        } else {
            this(scrollTextView, i6);
        }
    }
}
