package com.bytedance.android.ec.core.utils;

import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes43.dex */
public final class s0 {
    public static void a(Object r100) {
        EventBus.getDefault().post(r100);
    }

    public static void b(Object r100) {
        EventBus.getDefault().postSticky(r100);
    }

    public static void c(Object r100) {
        if (EventBus.getDefault().isRegistered(r100) == true) goto L6;
        EventBus.getDefault().register(r100);
        return;
    }

    public static <T> void d(Class<T> r100) {
        Object r101 = EventBus.getDefault().getStickyEvent(r100);
        if (r101 == null) goto L6;
        EventBus.getDefault().removeStickyEvent(r101);
        return;
    }

    public static void e(Object r100) {
        if (EventBus.getDefault().isRegistered(r100) == false) goto L6;
        EventBus.getDefault().unregister(r100);
        return;
    }
}
