package com.amap.api.col.jmsl;

import android.content.Context;

/* loaded from: classes.dex */
public class B2 {

    /* renamed from: a, reason: collision with root package name */
    public static B2 f15937a;

    public B2(Context context) {
    }

    public static B2 a(Context context) {
        if (f15937a == null) {
            synchronized (B2.class) {
                try {
                    if (f15937a == null) {
                        f15937a = new B2(context);
                    }
                } finally {
                }
            }
        }
        return f15937a;
    }
}
