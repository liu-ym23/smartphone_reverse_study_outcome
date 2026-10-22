package com.google.android.material.internal;

import android.opengl.GLES20;
import s.AbstractC0831a;
import z2.InterfaceC1006a;

/* loaded from: classes.dex */
public final class o implements InterfaceC1006a, u2.c {

    /* renamed from: a, reason: collision with root package name */
    public int f10865a;

    /* renamed from: b, reason: collision with root package name */
    public int f10866b;

    /* renamed from: c, reason: collision with root package name */
    public int f10867c;

    public o(int i4, int i5) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i6 = iArr[0];
        this.f10865a = i6;
        if (i6 == 0) {
            throw new IllegalStateException("glGenTextures failed");
        }
        this.f10866b = i4;
        this.f10867c = i5;
        GLES20.glBindTexture(3553, i6);
        int iA = AbstractC0831a.a(5);
        GLES20.glTexImage2D(3553, 0, iA, i4, i5, 0, iA, AbstractC0831a.b(5), null);
    }

    @Override // u2.c
    public int a() {
        return this.f10867c;
    }

    @Override // u2.c
    public void b(int i4) {
        int i5 = this.f10865a;
        if (i5 == 0) {
            return;
        }
        u2.c.c(i5, i4);
    }

    @Override // u2.c
    public int d() {
        return this.f10866b;
    }

    @Override // z2.InterfaceC1006a
    public void dispose() {
        int i4 = this.f10865a;
        if (i4 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i4}, 0);
            this.f10865a = 0;
        }
    }
}
