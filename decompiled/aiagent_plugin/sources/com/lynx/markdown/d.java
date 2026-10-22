package com.lynx.markdown;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: MarkdownImageRunDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Drawable f13879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f13880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f13881c;

    public d(Drawable r1, int r2, int r3, int r4, int r5) {
        super(r4, r5);
        this.f13879a = r1;
        this.f13880b = r2;
        this.f13881c = r3;
    }

    @Override // com.lynx.markdown.i
    public void a(Canvas r4, Rect r5) {
        if (this.f13879a != null) goto L5;
        return;
    L5:
        r4.save();
        if (this.f13905d > 0) goto L8;
    L10:
        this.f13879a.setBounds(0, 0, this.f13880b, this.f13881c);
    L11:
        this.f13879a.draw(r4);
        r4.restore();
        return;
    L8:
        if (this.f13906e <= 0) goto L10;
        this.f13879a.setBounds(0, 0, this.f13905d, this.f13906e);
        r4.clipRect(0, 0, this.f13905d, this.f13906e);
        goto L11
    }

    @Override // com.lynx.markdown.i, com.lynx.markdown.a.c
    public float a() {
        if (this.f13906e <= 0) goto L5;
    L8:
        int r1 = this.f13906e;
    L10:
        return -r1;
    L5:
        if (this.f13879a == null) goto L8;
        r1 = this.f13881c;
        goto L10
    }

    @Override // com.lynx.markdown.i, com.lynx.markdown.a.c
    public float b() {
        if (this.f13905d <= 0) goto L5;
    L8:
        int r1 = this.f13905d;
    L10:
        return r1;
    L5:
        if (this.f13879a == null) goto L8;
        r1 = this.f13880b;
        goto L10
    }
}
