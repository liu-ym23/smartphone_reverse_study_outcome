package com.baidu.platform.comapi.map;

import android.content.Context;
import android.view.SurfaceView;
import com.baidu.platform.comapi.util.EglConfigUtils;

/* JADX INFO: loaded from: classes39.dex */
public class s {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33357a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f33358b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f33359c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f33360d = null;

        static {
            a r100 = new a("OPENGL_ES", 0);
            f33357a = r100;
            a r101 = new a("VULKAN", 1);
            f33358b = r101;
            a r102 = new a("AUTO", 2);
            f33359c = r102;
            f33360d = new a[]{r100, r101, r102};
        }

        public static a[] values() {
            return (a[]) f33360d.clone();
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        private a(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static r a(SurfaceView r100, a r110, boolean r111, Context r112) {
        e r113 = new e(r100);
        r113.a(3);
        if (r111 == true) goto L5;
        int r114 = 0;
        int r101 = 0;
    L16:
    L12:
        r113.a(true);
    L13:
        r113.b(true);
        return r113;
    L8:
        if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 24, 8, r114, r101) == false) goto L10;
        r113.a(8, 8, 8, 8, 24, 8, r114, r101);     // Catch: IllegalArgumentException -> L12
    L15:
        goto L13
    L10:
        r113.a(true);     // Catch: IllegalArgumentException -> L12
        goto L15
    L5:
        r114 = 1;
        r101 = 4;
        goto L16
    }
}
