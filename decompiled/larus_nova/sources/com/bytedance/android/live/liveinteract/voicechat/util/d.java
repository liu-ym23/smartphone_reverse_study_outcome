package com.bytedance.android.live.liveinteract.voicechat.util;

import kotlin.jvm.JvmStatic;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f80851a = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static int a() {
            ReadOnlyProperty r100 = vm2.d.R;
            KProperty<?>[] r101 = vm2.d.f555776a;
            if (((Boolean) r100.getValue(null, r101[41])).booleanValue() == false) goto L7;
            return 2;
        L7:
            if (((Boolean) vm2.d.f556033z6.getValue(null, r101[387(0x183, float:5.42E-43)])).booleanValue() == false) goto L10;
            return 1;
        L10:
            return 0;
        }
    }

    static {
        f80851a = new a();
    }
}
