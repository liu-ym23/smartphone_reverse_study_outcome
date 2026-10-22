package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.alipay.sdk.m.u.i;
import i0.c;
import i0.s;
import o0.b;

/* JADX INFO: loaded from: classes28.dex */
public final class ShapeTrimPath implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f24847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0.b f24848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0.b f24849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n0.b f24850d;

    public static final enum Type extends Enum<Type> {
        public static final Type Individually = null;
        public static final Type Simultaneously = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f24851a = null;

        static {
            Type r100 = new Type("Simultaneously", 0);
            Simultaneously = r100;
            Type r101 = new Type("Individually", 1);
            Individually = r101;
            f24851a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f24851a.clone();
        }

        public static Type forId(int r100) {
            if (r100 == 1) goto L11;
            if (r100 != 2) goto L9;
            return Individually;
        L9:
            throw new IllegalArgumentException("Unknown trim path type " + r100);
        L11:
            return Simultaneously;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return "Trim Path: {start: " + this.f24848b + ", end: " + this.f24849c + ", offset: " + this.f24850d + i.f25855d;
    }

    public Type getType() {
        return this.f24847a;
    }

    @Override // o0.b
    public final c a(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101) {
        return new s(r101, this);
    }

    public ShapeTrimPath(String r100, Type r101, n0.b r102, n0.b r103, n0.b r104) {
        this.f24847a = r101;
        this.f24848b = r102;
        this.f24849c = r103;
        this.f24850d = r104;
    }
}
