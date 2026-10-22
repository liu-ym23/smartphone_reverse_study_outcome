package com.bytedance.android.live.core.privacy.av.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements com.bytedance.android.live.core.privacy.av.api.e, com.bytedance.android.live.core.privacy.av.api.g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f65165i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f65166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, List<Integer>> f65167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f65168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, String> f65169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f65170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.core.privacy.av.api.d f65171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.core.privacy.av.api.b f65172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PrivacyConfig f65173h;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65174a;

        public b() {
            this(-1);
        }

        public b(int r100) {
            this.f65174a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f65176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f65177c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, String> f65178d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.bytedance.android.live.core.privacy.av.api.b f65179e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.bytedance.android.live.core.privacy.av.api.a f65180f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f65181g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f65182h;

        public c() {
            throw null;
        }

        public final int getType() {
            return this.f65181g;
        }

        public c(int r100, String r101, String r102, Map r103, com.bytedance.android.live.core.privacy.av.api.b r104, com.bytedance.android.live.core.privacy.av.api.a r105, int r106) {
            Intrinsics.checkNotNullParameter(r101, "biz");
            Intrinsics.checkNotNullParameter(r102, "sense");
            Intrinsics.checkNotNullParameter(r103, "params");
            Intrinsics.checkNotNullParameter(r104, "callback");
            Intrinsics.checkNotNullParameter(r105, "config");
            this.f65175a = r100;
            this.f65176b = r101;
            this.f65177c = r102;
            this.f65178d = r103;
            this.f65179e = r104;
            this.f65180f = r105;
            this.f65181g = r106;
            this.f65182h = false;
        }
    }

    static {
        f65165i = -1;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.g
    public final void a() {
        Handler r100 = this.f65170e;
        r100.sendMessageAtFrontOfQueue(Message.obtain(r100, 2, new b(-1)));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.g
    public final void b() {
        Handler r100 = this.f65170e;
        r100.sendMessageAtFrontOfQueue(Message.obtain(r100, 4, new b(-1)));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.g
    public final void f() {
        Handler r100 = this.f65170e;
        r100.sendMessageAtFrontOfQueue(Message.obtain(r100, 1, new b(-1)));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final void g() {
        if (LiveInfraSettingKeys.LIVE_AV_PRIVACY_DETECT_SYS_AUDIO_OPT.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        int r100 = f65165i;
        if (r100 <= (-1)) goto L9;
        Handler r101 = this.f65170e;
        r101.sendMessageAtFrontOfQueue(Message.obtain(r101, 5, new b(r100)));
        f65165i = -1;
        return;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.g
    public final void h() {
        Handler r100 = this.f65170e;
        r100.sendMessageAtFrontOfQueue(Message.obtain(r100, 3, new b(-1)));
    }

    public e(com.bytedance.android.live.core.privacy.av.impl.c r100, AudioAndVideoCallbackSystemImpl r101, PrivacyConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "checker");
        Intrinsics.checkNotNullParameter(r101, "systemCallback");
        Intrinsics.checkNotNullParameter(r102, "privacyConfig");
        this.f65171f = r100;
        this.f65172g = r101;
        this.f65173h = r102;
        this.f65166a = new AtomicInteger(1);
        this.f65167b = new ConcurrentHashMap();
        this.f65168c = new CopyOnWriteArrayList();
        this.f65169d = MapsKt.mapOf(new Pair[]{new Pair(4, "audio_open"), new Pair(1, "audio_release"), new Pair(2, "video_release"), new Pair(3, "video_open")});
        this.f65170e = new Handler(Looper.getMainLooper(), new f(this));
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int c(String r110, String r111, Map<String, String> r112, com.bytedance.android.live.core.privacy.av.api.b r210, com.bytedance.android.live.core.privacy.av.api.a r211) {
        Intrinsics.checkNotNullParameter(r110, "biz");
        Intrinsics.checkNotNullParameter(r111, "sense");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r210, "callback");
        Intrinsics.checkNotNullParameter(r211, "config");
        int r113 = this.f65166a.getAndIncrement();
        if (r211.f65133a >= 0) goto L6;
        r211.f65133a = r113;
    L6:
        if (r211.b() == false) goto L8;
        f65165i = r113;
    L8:
        c r114 = new c(r113, r110, r111, r112, r210, r211, 1);
        Message r100 = Message.obtain(this.f65170e, 1, r114);
        ((CopyOnWriteArrayList) this.f65168c).add(r114);
        if (r211.a() > 0) goto L11;
        int r101 = this.f65173h.a();
    L12:
        this.f65170e.sendMessageDelayed(r100, r101);
        r210.b(r110, r111, "audio_release", r112, r211);
        this.f65172g.b(r110, r111, "audio_release", r112, r211);
        return r113;
    L11:
        r101 = r211.a();
        goto L12
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int d(String r100, String r101, Map<String, String> r102, com.bytedance.android.live.core.privacy.av.api.b r103, com.bytedance.android.live.core.privacy.av.api.a r104) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r104, "config");
        int r105 = this.f65166a.getAndIncrement();
        r104.f65133a = r105;
        int r106 = c(r100, r101, r102, r103, r104);
        int r107 = e(r100, r101, r102, r103, r104);
        Map<Integer, List<Integer>> r108 = this.f65167b;
        ConcurrentHashMap r109 = (ConcurrentHashMap) r108;
        r109.put(Integer.valueOf(r105), CollectionsKt.listOf(new Integer[]{Integer.valueOf(r106), Integer.valueOf(r107)}));
        return r105;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int e(String r110, String r111, Map<String, String> r112, com.bytedance.android.live.core.privacy.av.api.b r210, com.bytedance.android.live.core.privacy.av.api.a r211) {
        Intrinsics.checkNotNullParameter(r110, "biz");
        Intrinsics.checkNotNullParameter(r111, "sense");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r210, "callback");
        Intrinsics.checkNotNullParameter(r211, "config");
        int r113 = this.f65166a.getAndIncrement();
        if (r211.f65133a >= 0) goto L5;
        r211.f65133a = r113;
    L5:
        c r114 = new c(r113, r110, r111, r112, r210, r211, 2);
        Message r100 = Message.obtain(this.f65170e, 2, r114);
        ((CopyOnWriteArrayList) this.f65168c).add(r114);
        if (r211.a() > 0) goto L8;
        int r101 = this.f65173h.a();
    L9:
        this.f65170e.sendMessageDelayed(r100, r101);
        r210.b(r110, r111, "video_release", r112, r211);
        this.f65172g.b(r110, r111, "video_release", r112, r211);
        return r113;
    L8:
        r101 = r211.a();
        goto L9
    }
}
