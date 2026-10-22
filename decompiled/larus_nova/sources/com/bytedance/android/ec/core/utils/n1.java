package com.bytedance.android.ec.core.utils;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f45652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f45653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f45654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f45655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f45656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f45657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f45658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f45659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f45660i = null;

    public static final class a {
        public a() {
        }

        public static int b() {
            if (n1.f45654c != 0) goto L6;
            n1.f45660i.getClass();
            e(ECAppInfoService.f48114e.getApplicationContext());
        L6:
            return n1.f45654c;
        }

        public static int c() {
            if (n1.f45653b != 0) goto L6;
            n1.f45660i.getClass();
            e(ECAppInfoService.f48114e.getApplicationContext());
        L6:
            return n1.f45653b;
        }

        public static int d() {
            if (n1.f45652a != 0) goto L6;
            n1.f45660i.getClass();
            e(ECAppInfoService.f48114e.getApplicationContext());
        L6:
            return n1.f45652a;
        }

        @JvmStatic
        public static void e(Context r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            int r101 = com.bytedance.common.utility.UIUtils.getScreenWidth(r100);
            if (r101 != 0) goto L7;
            return;
        L7:
            n1.f45652a = r101;
            n1.f45653b = k1.j(r100);
            d();
            com.bytedance.common.utility.UIUtils.dip2Px(r100, 32.0f);
            n1.f45657f = d() - ((int) com.bytedance.common.utility.UIUtils.dip2Px(r100, 40.0f));
            int r102 = (d() - ((int) com.bytedance.common.utility.UIUtils.dip2Px(r100, 44.0f))) / 2;
            n1.f45654c = (int) (((double) k1.j(r100)) * 0.73d);
            k1.j(r100);
            n1.f45655d = (int) (((double) k1.j(r100)) * 0.9d);
            k1.j(r100);
            n1.f45656e = (int) (((double) k1.j(r100)) * 0.86d);
        }

        @JvmStatic
        public static int a(Integer r100, int r101) {
            if (r100 != null) goto L4;
            return r101;
        L4:
            if (r100.intValue() > 0) goto L6;
            return r101;
        L6:
            if (c() > 0) goto L9;
            return r101;
        L9:
            return (int) (c() * (r100.intValue() / 100.0f));
        }
    }

    static {
        f45660i = new a();
        f45659h = true;
    }
}
