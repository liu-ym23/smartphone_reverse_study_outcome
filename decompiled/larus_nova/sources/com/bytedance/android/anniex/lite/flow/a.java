package com.bytedance.android.anniex.lite.flow;

import com.bytedance.ies.bullet.service.base.utils.KitType;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f40917a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.flow.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0760a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40918a = null;

        static {
            int[] r100 = new int[KitType.values().length];
            r100[KitType.WEB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[KitType.LYNX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f40918a = r100;
        }
    }

    static {
    }
}
