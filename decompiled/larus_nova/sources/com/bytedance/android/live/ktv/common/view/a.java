package com.bytedance.android.live.ktv.common.view;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.view.a$a, reason: collision with other inner class name */
    public static final class C1144a implements TypeEvaluator<PointF> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PointF f70770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f70771b;

        public C1144a(PointF r100, PointF r101) {
            Intrinsics.checkNotNullParameter(r100, "controlPointF1");
            Intrinsics.checkNotNullParameter(r101, "controlPointF2");
            this.f70770a = r100;
            this.f70771b = r101;
        }

        @Override // android.animation.TypeEvaluator
        public final PointF evaluate(float r110, PointF r111, PointF r112) {
            PointF r113 = r111;
            PointF r114 = r112;
            Intrinsics.checkNotNullParameter(r113, "startValue");
            Intrinsics.checkNotNullParameter(r114, "endValue");
            PointF r100 = new PointF();
            float r101 = 1 - r110;
            float r102 = r101 * r101;
            float r103 = r102 * r101;
            float r104 = r110 * r110;
            float r105 = r104 * r110;
            float r106 = r113.x * r103;
            float r107 = 3;
            float r108 = (r102 * r107) * r110;
            PointF r115 = this.f70770a;
            float r109 = r106 + (r115.x * r108);
            float r116 = (r107 * r101) * r104;
            PointF r117 = this.f70771b;
            r100.x = (r109 + (r117.x * r116)) + (r114.x * r105);
            r100.y = (((r103 * r113.y) + (r108 * r115.y)) + (r116 * r117.y)) + (r105 * r114.y);
            return r100;
        }
    }
}
