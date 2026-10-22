package com.bytedance.android.ec.hybrid.card.util;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes44.dex */
public final class p {
    public static Object a(Object r100, String r101) throws NoSuchFieldException, IllegalAccessException {
        Field r102 = r100.getClass().getDeclaredField(r101);
        r102.setAccessible(true);
        return r102.get(r100);
    }
}
