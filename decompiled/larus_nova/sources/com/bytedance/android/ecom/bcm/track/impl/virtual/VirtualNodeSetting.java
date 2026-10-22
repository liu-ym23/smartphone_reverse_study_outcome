package com.bytedance.android.ecom.bcm.track.impl.virtual;

import com.bytedance.android.btm.impl.util.SharedPreferenceUtil;
import com.bytedance.android.ecom.bcm.track.api.TrackHostDependManager;
import com.bytedance.android.ecom.bcm.track.impl.setting.Setting;
import com.bytedance.android.ecom.bcm.track.impl.setting.a0;
import com.google.gson.Gson;
import cr.b;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class VirtualNodeSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f51162a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f51163b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f51164c = null;

    static {
        f51162a = LazyKt.lazy(VirtualNodeSetting$gson$2.INSTANCE);
        f51163b = LazyKt.lazy(VirtualNodeSetting$sharePreference$2.INSTANCE);
        f51164c = LazyKt.lazy(VirtualNodeSetting$localSetting$2.INSTANCE);
    }

    public static a0 a() {
        TrackHostDependManager r100 = TrackHostDependManager.f51063d;
        r100.getClass();
        b r101 = (b) TrackHostDependManager.f51062c.getValue(r100, TrackHostDependManager.f51060a[1]);
        if (r101 == null) goto L12;
        if (r101.a() != true) goto L12;
        a0 r102 = (a0) f51164c.getValue();
        if (r102 == null) goto L10;
        return r102;
    L10:
        return new a0();
    L12:
        return Setting.f51149a.s();
    }

    public static void b(a0 r100) {
        TrackHostDependManager r101 = TrackHostDependManager.f51063d;
        r101.getClass();
        b r102 = (b) TrackHostDependManager.f51062c.getValue(r101, TrackHostDependManager.f51060a[1]);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.a() != true) goto L14;
        SharedPreferenceUtil r103 = (SharedPreferenceUtil) f51163b.getValue();     // Catch: Exception -> L10
        if (r103 == null) goto L15;
        r103.a("virtual_node_setting", ((Gson) f51162a.getValue()).toJson(r100));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L16:
        return;
    }
}
