package com.lynx.markdown;

import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX INFO: compiled from: MarkdownRunDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements com.lynx.markdown.a.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f13905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f13906e;

    public void a(Canvas r1, Rect r2) {
    }

    @Override // com.lynx.markdown.a.c
    public float c() {
        return 0.0f;
    }

    i(int r2, int r3) {
        this.f13905d = 0;
        this.f13906e = 0;
        this.f13905d = r2;
        this.f13906e = r3;
    }

    @Override // com.lynx.markdown.a.c
    public float a() {
        return -this.f13906e;
    }

    @Override // com.lynx.markdown.a.c
    public float b() {
        return this.f13905d;
    }
}
