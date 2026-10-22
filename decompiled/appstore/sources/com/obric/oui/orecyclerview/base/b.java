package com.obric.oui.orecyclerview.base;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15353a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final float a(float r10, float r11) {
            if (r10 >= 0.0f) goto L5;
        L9:
            return 0.0f;
        L5:
            if (r11 <= 0.0f) goto L9;
            float r12 = bg.h.f(r10, r11 - 1.0E-5f);
            return ((r11 * r12) / (r11 - r12)) / 0.55f;
        }

        public final float b(float r10, float r11) {
            if (r10 >= 0.0f) goto L5;
            return 0.0f;
        L5:
            if (r11 > 0.0f) goto L8;
            return 0.0f;
        L8:
            return (1.0f - (1.0f / (((r10 / r11) * 0.55f) + 1.0f))) * r11;
        }

        public a() {
        }
    }

    static {
        f15353a = new a(null);
    }
}
