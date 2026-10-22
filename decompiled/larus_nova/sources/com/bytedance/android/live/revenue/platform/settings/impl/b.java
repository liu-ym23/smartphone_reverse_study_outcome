package com.bytedance.android.live.revenue.platform.settings.impl;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.facebook.keyframes.model.KFAnimation;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f91654a;

    public static final class a implements com.bytedance.tools.kcp.ultrasettings.runtime.b {
        public a() {
        }

        @Override // com.bytedance.tools.kcp.ultrasettings.runtime.b
        public final <T> ReadOnlyProperty<Object, T> a(final String r100, final T r101, final Type r102, final boolean r103, KProperty<?> r104) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r102, "type");
            Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Boolean r105 = f.f91656a;
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r102, "type");
            return new d(new UltraSettingsServiceImpl$createUltraSettings$1(r100, r101, r102, r103));
        }
    }

    public static void a() {
        if (f91654a == false) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, com.bytedance.tools.kcp.ultrasettings.runtime.c> r100 = UltraSettingsManager.f271014a;
        a r101 = new a();
        Intrinsics.checkNotNullParameter(r101, "factory");
        UltraSettingsManager.f271015b = r101;
        f91654a = true;
    }

    static {
    }
}
