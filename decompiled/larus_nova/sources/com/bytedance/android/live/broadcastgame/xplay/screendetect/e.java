package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f62370a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Bitmap.Config f62371b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Bitmap f62372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Pair<int[], Triple<int[], int[], int[]>> f62373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Function1<? super String, Unit> f62374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f62375f = null;

    public static final class a extends Handler {
        public a(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            r100.getCallback().run();
            return true;
        }
    }

    public e() {
    }

    static {
        f62375f = new e();
        if (Build.VERSION.SDK_INT < 24) goto L5;
        boolean r100 = true;
    L6:
        f62370a = r100;
        f62371b = Bitmap.Config.RGB_565;
        new a(Looper.getMainLooper());
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void b(Triple r100) {
        int r101 = 0;
    L4:
        if (r101 >= 256) goto L6;
        ((int[]) r100.getFirst())[r101] = 0;
        ((int[]) r100.getSecond())[r101] = 0;
        ((int[]) r100.getThird())[r101] = 0;
        r101 = r101 + 1;
        goto L4
    }

    public static boolean d(SurfaceView r100) {
        if (r100 == null) goto L4;
        SurfaceHolder r101 = r100.getHolder();
    L5:
        if (r101 != null) goto L7;
    L15:
        return false;
    L7:
        if (r100.getHolder().getSurface() == null) goto L15;
        if (r100.getHolder().getSurface().isValid() == false) goto L15;
        if (r100.getWidth() <= 0) goto L15;
        if (r100.getHeight() <= 0) goto L15;
        return true;
    L4:
        r101 = null;
        goto L5
    }

    public static Pair a(Triple r100, int r101) {
        int[] r102 = (int[]) r100.component1();
        int[] r103 = (int[]) r100.component2();
        int[] r104 = (int[]) r100.component3();
        int r105 = 0;
        Triple r106 = new Triple(new b(0), new b(0), new b(0));
        b r107 = (b) r106.component1();
        b r108 = (b) r106.component2();
        b r109 = (b) r106.component3();
    L4:
        if (r105 >= 256) goto L15;
        int r110 = r107.f62361b;
        int r111 = r102[r105];
        if (r110 >= r111) goto L8;
        r107.f62361b = r111;
        r107.f62360a = r105;
    L8:
        int r112 = r108.f62361b;
        int r113 = r103[r105];
        if (r112 >= r113) goto L11;
        r108.f62361b = r113;
        r108.f62360a = r105;
    L11:
        int r114 = r109.f62361b;
        int r115 = r104[r105];
        if (r114 >= r115) goto L14;
        r109.f62361b = r115;
        r109.f62360a = r105;
    L14:
        r105 = r105 + 1;
        goto L4
    L15:
        float r116 = r101;
        return new Pair(Float.valueOf((((r107.f62361b / r116) + (r108.f62361b / r116)) + (r109.f62361b / r116)) / 3), Integer.toHexString(Color.rgb(r107.f62360a, r108.f62360a, r109.f62360a)));
    }

    public static void c(Triple r100, int r101) {
        int[] r102 = (int[]) r100.getFirst();
        int r103 = Color.red(r101);
        r102[r103] = r102[r103] + 1;
        int[] r104 = (int[]) r100.getSecond();
        int r105 = Color.green(r101);
        r104[r105] = r104[r105] + 1;
        int[] r106 = (int[]) r100.getThird();
        int r107 = Color.blue(r101);
        r106[r107] = r106[r107] + 1;
    }
}
