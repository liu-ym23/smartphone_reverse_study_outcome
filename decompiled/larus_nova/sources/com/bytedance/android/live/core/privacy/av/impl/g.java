package com.bytedance.android.live.core.privacy.av.impl;

import android.util.Log;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements com.bytedance.android.live.core.privacy.av.api.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f65184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f65185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.bytedance.android.live.core.privacy.av.api.g f65186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PrivacyConfig f65187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Boolean> f65188e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Boolean> f65189f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f65190g = null;

    public g() {
    }

    static {
        f65190g = new g();
        f65188e = new ConcurrentHashMap();
        f65189f = new ConcurrentHashMap();
    }

    public static boolean e() {
        if (f65186c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.f
    public final boolean a() {
        return !f65184a;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.f
    public final boolean b() {
        return !f65185b;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.f
    public final boolean c() {
        return f65185b;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.f
    public final boolean d() {
        return f65184a;
    }

    public static void f(int r110) {
        if (e() == true) goto L5;
        return;
    L5:
        ConcurrentHashMap<Integer, Boolean> r100 = f65188e;
        r100.put(Integer.valueOf(r110), false);
        Iterator<T> r101 = r100.values().iterator();
    L6:
        boolean r102 = false;
    L8:
        if (r101.hasNext() == false) goto L15;
        Boolean r103 = (Boolean) r101.next();
        if (r102 == true) goto L13;
        if (r103.booleanValue() == false) goto L6;
    L13:
        r102 = true;
        goto L8
    L15:
        if (f65184a != r102) goto L17;
    L53:
        q60.a.f531755b.a("onAudioStatusChanged; isAudioActing=" + f65184a + ", instanceHashCode=" + r110 + ", code=0");
        PrivacyConfig r104 = f65187d;
        if (r104 != null) goto L56;
        return;
    L56:
        if (r104.h() != true) goto L70;
        PrivacyConfig r105 = f65187d;
        if (r105 == null) goto L71;
        List<String> r106 = r105.d();
        if (r106 != null) goto L62;
        return;
    L62:
        if (r106.contains("av_status_change") != true) goto L73;
        q60.a.f531755b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_status_change", "onAudioStatusChanged", 0, "", "", "", "", MapsKt.mapOf(new Pair[]{new Pair("code", String.valueOf(0)), new Pair("isAudioActing", String.valueOf(f65184a)), new Pair("instanceHashCode", String.valueOf(r110))})));
        return;
    L73:
        return;
    L71:
        return;
    L70:
        return;
    L17:
        if (r102 == false) goto L36;
        if (e() == false) goto L52;
        q60.a.f531755b.a("onStartAudioCapture");
        com.bytedance.android.live.core.privacy.av.api.g r107 = f65186c;
        if (r107 == null) goto L24;
        r107.f();
    L24:
        PrivacyConfig r108 = f65187d;
        if (r108 == null) goto L52;
        if (r108.h() != true) goto L52;
        PrivacyConfig r109 = f65187d;
        if (r109 == null) goto L52;
        List<String> r111 = r109.d();
        if (r111 == null) goto L52;
        if (r111.contains("av_operation") != true) goto L52;
        q60.a.f531755b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_operation", "onStartAudioCapture", 0, String.valueOf(Log.getStackTraceString(new Exception("onStartAudioCapture"))), "", "", "", Collections.emptyMap()));
    L52:
        f65184a = r102;
        goto L53
    L36:
        if (e() == false) goto L52;
        q60.a.f531755b.a("onStopAudioCapture");
        com.bytedance.android.live.core.privacy.av.api.g r112 = f65186c;
        if (r112 == null) goto L41;
        r112.b();
    L41:
        PrivacyConfig r113 = f65187d;
        if (r113 == null) goto L52;
        if (r113.h() != true) goto L52;
        PrivacyConfig r114 = f65187d;
        if (r114 == null) goto L52;
        List<String> r115 = r114.d();
        if (r115 == null) goto L52;
        if (r115.contains("av_operation") != true) goto L52;
        q60.a.f531755b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_operation", "onStopAudioCapture", 0, String.valueOf(Log.getStackTraceString(new Exception("onStopAudioCapture"))), "", "", "", Collections.emptyMap()));
        goto L52
    }

    public static void g(int r110, int r111) {
        if (e() == true) goto L6;
        return;
    L6:
        if (r111 != 1) goto L8;
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        f65189f.clear();
    L11:
        ConcurrentHashMap<Integer, Boolean> r101 = f65189f;
        r101.put(Integer.valueOf(r110), Boolean.valueOf(r100));
        Iterator<T> r102 = r101.values().iterator();
    L12:
        boolean r103 = false;
    L14:
        if (r102.hasNext() == false) goto L21;
        Boolean r104 = (Boolean) r102.next();
        if (r103 == true) goto L19;
        if (r104.booleanValue() == false) goto L12;
    L19:
        r103 = true;
        goto L14
    L21:
        if (f65185b != r103) goto L23;
    L59:
        q60.a.f531755b.a("onVideoStatusChanged; isVideoActing=" + f65185b + ", instanceHashCode=" + r110 + ", code=" + r111);
        PrivacyConfig r105 = f65187d;
        if (r105 != null) goto L62;
        return;
    L62:
        if (r105.h() != true) goto L76;
        PrivacyConfig r106 = f65187d;
        if (r106 == null) goto L77;
        List<String> r107 = r106.d();
        if (r107 != null) goto L68;
        return;
    L68:
        if (r107.contains("av_status_change") != true) goto L79;
        q60.a.f531755b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_status_change", "onVideoStatusChanged", 0, "", "", "", "", MapsKt.mapOf(new Pair[]{new Pair("code", String.valueOf(r111)), new Pair("isVideoActing", String.valueOf(f65184a)), new Pair("instanceHashCode", String.valueOf(r110))})));
        return;
    L79:
        return;
    L77:
        return;
    L76:
        return;
    L23:
        if (r103 == false) goto L42;
        if (e() == false) goto L58;
        q60.a.f531755b.a("onStartVideoCapture");
        com.bytedance.android.live.core.privacy.av.api.g r108 = f65186c;
        if (r108 == null) goto L30;
        r108.a();
    L30:
        PrivacyConfig r109 = f65187d;
        if (r109 == null) goto L58;
        if (r109.h() != true) goto L58;
        PrivacyConfig r112 = f65187d;
        if (r112 == null) goto L58;
        List<String> r113 = r112.d();
        if (r113 == null) goto L58;
        if (r113.contains("av_operation") != true) goto L58;
        q60.a.f531755b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_operation", "onStartVideoCapture", 0, String.valueOf(Log.getStackTraceString(new Exception("onStartVideoCapture"))), "", "", "", Collections.emptyMap()));
    L58:
        f65185b = r103;
        goto L59
    L42:
        if (e() == false) goto L58;
        q60.a.f531755b.a("onStopVideoCapture");
        com.bytedance.android.live.core.privacy.av.api.g r114 = f65186c;
        if (r114 == null) goto L47;
        r114.h();
    L47:
        PrivacyConfig r115 = f65187d;
        if (r115 == null) goto L58;
        if (r115.h() != true) goto L58;
        PrivacyConfig r116 = f65187d;
        if (r116 == null) goto L58;
        List<String> r117 = r116.d();
        if (r117 == null) goto L58;
        if (r117.contains("av_operation") != true) goto L58;
        q60.a.f531755b.c(new com.bytedance.android.live.core.privacy.av.api.i("av_operation", "onStopVideoCapture", 0, String.valueOf(Log.getStackTraceString(new Exception("onStopVideoCapture"))), "", "", "", Collections.emptyMap()));
        goto L58
    L8:
        r100 = false;
        goto L9
    }
}
