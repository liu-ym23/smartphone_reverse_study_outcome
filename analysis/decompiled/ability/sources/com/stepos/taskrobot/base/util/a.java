package com.stepos.taskrobot.base.util;

import android.graphics.Bitmap;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import s9.C1923c;
import u9.c;
import u9.d;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C1923c f4028a;

    static {
        d dVar = AbstractC1691I.f5315a;
        f4028a = AbstractC1683A.b(c.f6743a);
    }

    public static Object a(String str, Bitmap bitmap, H7.c cVar) {
        d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(c.f6743a, new FileUtil$saveScreenshotToTaskDir2$2(str, bitmap, null), cVar);
    }
}
