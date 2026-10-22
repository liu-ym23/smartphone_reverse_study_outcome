package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import i0.c;
import i0.n;
import n0.m;
import o0.b;

/* JADX INFO: loaded from: classes28.dex */
public final class PolystarShape implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f24825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0.b f24826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m<PointF, PointF> f24827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n0.b f24828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n0.b f24829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n0.b f24830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n0.b f24831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n0.b f24832i;

    public static final enum Type extends Enum<Type> {
        public static final Type Polygon = null;
        public static final Type Star = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f24833a = null;
        private final int value;

        static {
            Type r100 = new Type(WikiFolderPushPlugin.STAR, 0, 1);
            Star = r100;
            Type r101 = new Type("Polygon", 1, 2);
            Polygon = r101;
            f24833a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f24833a.clone();
        }

        public static Type forValue(int r100) {
            Type[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            Type r104 = r101[r103];
            if (r104.value == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L8:
            return null;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public Type getType() {
        return this.f24825b;
    }

    @Override // o0.b
    public final c a(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101) {
        return new n(r100, r101, this);
    }

    public PolystarShape(String r100, Type r101, n0.b r102, m<PointF, PointF> r103, n0.b r104, n0.b r105, n0.b r106, n0.b r107, n0.b r108) {
        this.f24824a = r100;
        this.f24825b = r101;
        this.f24826c = r102;
        this.f24827d = r103;
        this.f24828e = r104;
        this.f24829f = r105;
        this.f24830g = r106;
        this.f24831h = r107;
        this.f24832i = r108;
    }
}
