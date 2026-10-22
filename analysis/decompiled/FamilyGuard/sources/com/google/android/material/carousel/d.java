package com.google.android.material.carousel;

import a1.C0411d;
import android.content.Context;
import com.google.android.material.carousel.e;

/* loaded from: classes.dex */
final class d {
    static float a(float f5, float f6, int i5) {
        return f5 + (Math.max(0, i5 - 1) * f6);
    }

    static float b(float f5, float f6, int i5) {
        return i5 > 0 ? f5 + (f6 / 2.0f) : f5;
    }

    static e c(Context context, float f5, int i5, a aVar) {
        float f6;
        float f7;
        float fMin = Math.min(f(context) + f5, aVar.f12504f);
        float f8 = fMin / 2.0f;
        float f9 = 0.0f - f8;
        float fB = b(0.0f, aVar.f12500b, aVar.f12501c);
        float fJ = j(0.0f, a(fB, aVar.f12500b, (int) Math.floor(aVar.f12501c / 2.0f)), aVar.f12500b, aVar.f12501c);
        float fB2 = b(fJ, aVar.f12503e, aVar.f12502d);
        float fJ2 = j(fJ, a(fB2, aVar.f12503e, (int) Math.floor(aVar.f12502d / 2.0f)), aVar.f12503e, aVar.f12502d);
        float fB3 = b(fJ2, aVar.f12504f, aVar.f12505g);
        float fJ3 = j(fJ2, a(fB3, aVar.f12504f, aVar.f12505g), aVar.f12504f, aVar.f12505g);
        float fB4 = b(fJ3, aVar.f12503e, aVar.f12502d);
        float fB5 = b(j(fJ3, a(fB4, aVar.f12503e, (int) Math.ceil(aVar.f12502d / 2.0f)), aVar.f12503e, aVar.f12502d), aVar.f12500b, aVar.f12501c);
        float f10 = i5 + f8;
        float fB6 = c.b(fMin, aVar.f12504f, f5);
        float fB7 = c.b(aVar.f12500b, aVar.f12504f, f5);
        float fB8 = c.b(aVar.f12503e, aVar.f12504f, f5);
        e.b bVarA = new e.b(aVar.f12504f, i5).a(f9, fB6, fMin);
        if (aVar.f12501c > 0) {
            f6 = 2.0f;
            f7 = fB6;
            bVarA.g(fB, fB7, aVar.f12500b, (int) Math.floor(r7 / 2.0f));
        } else {
            f6 = 2.0f;
            f7 = fB6;
        }
        if (aVar.f12502d > 0) {
            bVarA.g(fB2, fB8, aVar.f12503e, (int) Math.floor(r4 / f6));
        }
        bVarA.h(fB3, 0.0f, aVar.f12504f, aVar.f12505g, true);
        if (aVar.f12502d > 0) {
            bVarA.g(fB4, fB8, aVar.f12503e, (int) Math.ceil(r4 / f6));
        }
        if (aVar.f12501c > 0) {
            bVarA.g(fB5, fB7, aVar.f12500b, (int) Math.ceil(r0 / f6));
        }
        bVarA.a(f10, f7, fMin);
        return bVarA.i();
    }

    static e d(Context context, float f5, int i5, a aVar, int i6) {
        return i6 == 1 ? c(context, f5, i5, aVar) : e(context, f5, i5, aVar);
    }

    static e e(Context context, float f5, int i5, a aVar) {
        float fMin = Math.min(f(context) + f5, aVar.f12504f);
        float f6 = fMin / 2.0f;
        float f7 = 0.0f - f6;
        float fB = b(0.0f, aVar.f12504f, aVar.f12505g);
        float fJ = j(0.0f, a(fB, aVar.f12504f, aVar.f12505g), aVar.f12504f, aVar.f12505g);
        float fB2 = b(fJ, aVar.f12503e, aVar.f12502d);
        float fB3 = b(j(fJ, fB2, aVar.f12503e, aVar.f12502d), aVar.f12500b, aVar.f12501c);
        float f8 = i5 + f6;
        float fB4 = c.b(fMin, aVar.f12504f, f5);
        float fB5 = c.b(aVar.f12500b, aVar.f12504f, f5);
        float fB6 = c.b(aVar.f12503e, aVar.f12504f, f5);
        e.b bVarH = new e.b(aVar.f12504f, i5).a(f7, fB4, fMin).h(fB, 0.0f, aVar.f12504f, aVar.f12505g, true);
        if (aVar.f12502d > 0) {
            bVarH.b(fB2, fB6, aVar.f12503e);
        }
        int i6 = aVar.f12501c;
        if (i6 > 0) {
            bVarH.g(fB3, fB5, aVar.f12500b, i6);
        }
        bVarH.a(f8, fB4, fMin);
        return bVarH.i();
    }

    static float f(Context context) {
        return context.getResources().getDimension(C0411d.f6796p);
    }

    static float g(Context context) {
        return context.getResources().getDimension(C0411d.f6797q);
    }

    static float h(Context context) {
        return context.getResources().getDimension(C0411d.f6798r);
    }

    static int i(int[] iArr) {
        int i5 = Integer.MIN_VALUE;
        for (int i6 : iArr) {
            if (i6 > i5) {
                i5 = i6;
            }
        }
        return i5;
    }

    static float j(float f5, float f6, float f7, int i5) {
        return i5 > 0 ? f6 + (f7 / 2.0f) : f5;
    }
}
