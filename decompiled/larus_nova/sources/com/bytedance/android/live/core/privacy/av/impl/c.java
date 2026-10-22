package com.bytedance.android.live.core.privacy.av.impl;

import android.content.Context;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements com.bytedance.android.live.core.privacy.av.api.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ArrayList<Integer> f65155j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f65156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f65157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f65158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Boolean> f65159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f65160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f65161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.core.privacy.av.api.f f65162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PrivacyConfig f65163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.core.privacy.av.api.h f65164i;

    public static final class a {
    }

    static {
        f65155j = CollectionsKt.arrayListOf(new Integer[]{1});
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class e() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.media.AudioSystem");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.media.AudioSystem");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.media.AudioSystem");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.media.AudioSystem");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.media.AudioSystem");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.media.AudioSystem");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.media.AudioSystem");
    }

    public final boolean g() {
        Iterator<Integer> r100 = f65155j.iterator();
    L4:
        if (r100.hasNext() == false) goto L23;
        Integer r101 = r100.next();
        Object r102 = e().getDeclaredMethod("isSourceActive", new Class[]{Integer.TYPE}).invoke(null, new Object[]{r101});     // Catch: Exception -> L13
        if (r102 == null) goto L12;
        if (((Boolean) r102).booleanValue() == false) goto L4;
        this.f65164i.a("check mic by audioSourceList; i=" + r101);     // Catch: Exception -> L13
        return true;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        this.f65164i.b("check mic failed", e);
        goto L4
    L23:
        return false;
    }

    public final Context getContext() {
        return this.f65161f;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.d
    public final boolean a(boolean r100) {
        if (LiveInfraSettingKeys.MOCK_DISABLE_STOP_AUDIO_CAPTURE.getValue().booleanValue() == false) goto L6;
        this.f65164i.b("call stopVideoCapture, but mock disable", null);
        return false;
    L6:
        if (r100 == false) goto L10;
        return !g();
    L10:
        return this.f65162g.a();
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.d
    public final boolean b(boolean r100) {
        if (LiveInfraSettingKeys.MOCK_DISABLE_STOP_VIDEO_CAPTURE.getValue().booleanValue() == false) goto L6;
        this.f65164i.b("call stopVideoCapture, but mock disable", null);
        return false;
    L6:
        if (r100 == false) goto L10;
        return !this.f65157b;
    L10:
        return this.f65162g.b();
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.d
    public final boolean c(boolean r100) {
        if (LiveInfraSettingKeys.MOCK_DISABLE_STOP_VIDEO_CAPTURE.getValue().booleanValue() == false) goto L6;
        this.f65164i.b("call stopVideoCapture, but mock disable", null);
        return true;
    L6:
        if (r100 == false) goto L10;
        return this.f65157b;
    L10:
        return this.f65162g.c();
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.d
    public final boolean d(boolean r100) {
        if (LiveInfraSettingKeys.MOCK_DISABLE_STOP_AUDIO_CAPTURE.getValue().booleanValue() == false) goto L6;
        this.f65164i.b("call stopVideoCapture, but mock disable", null);
        return true;
    L6:
        if (r100 == false) goto L10;
        return g();
    L10:
        return this.f65162g.d();
    }

    public c(Context r100, PrivacyConfig r101, com.bytedance.android.live.core.privacy.av.api.h r102) {
        g r103 = g.f65190g;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "liveCore");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "logger");
        this.f65161f = r100;
        this.f65162g = r103;
        this.f65163h = r101;
        this.f65164i = r102;
        this.f65159d = new HashMap();
        this.f65160e = LazyKt.lazy(new AudioAndVideoCheckerImpl$releaseHandler$2(this));
        this.f65156a = new b(this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        this.f65157b = false;
        this.f65164i.b("camera registerSystemCallBack onCameraUnavailable cameraId Exception = " + e, null);
    }

    public static final void f(c r100, String r101, boolean r102) {
        r100.f65159d.put(r101, Boolean.valueOf(r102));
        Iterator<T> r103 = r100.f65159d.values().iterator();
        boolean r104 = false;
    L4:
        if (r103.hasNext() == false) goto L8;
        if (((Boolean) r103.next()).booleanValue() == false) goto L4;
        r104 = true;
        goto L4
    L8:
        r100.f65157b = r104;
    }
}
