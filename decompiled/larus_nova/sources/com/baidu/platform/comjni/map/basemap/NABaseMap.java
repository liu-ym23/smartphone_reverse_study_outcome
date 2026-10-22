package com.baidu.platform.comjni.map.basemap;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.NativeComponent;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class NABaseMap extends NativeComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f33444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f33445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f33446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f33447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ReadWriteLock f33448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<Long> f33449f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f33450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f33451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33452c;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$a__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33452c).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L14 Throwable -> L17
            if (r100 == false) goto L15;
            Bundle r101 = this.f33450a;     // Catch: Exception -> L14 Throwable -> L17
            if (r101 == null) goto L12;
            long r102 = r101.getLong("itemaddr", 0);     // Catch: Exception -> L14 Throwable -> L17
            if (NABaseMap.a(this.f33452c, r102) == false) goto L12;
            if (r100 == false) goto L26;
            NABaseMap.a(this.f33452c).readLock().unlock();
            return;
        L26:
            return;
        L12:
            NABaseMap r103 = this.f33452c;     // Catch: Exception -> L14 Throwable -> L17
            NABaseMap.a(r103, NABaseMap.d(r103), this.f33450a, this.f33451b);     // Catch: Exception -> L14 Throwable -> L17
        L15:
            if (r100 == false) goto L27;
        L22:
            NABaseMap.a(this.f33452c).readLock().unlock();
            return;
        L27:
            return;
        L17:
            th = move-exception;
            if (r100 == false) goto L20;
            NABaseMap.a(this.f33452c).readLock().unlock();
        L20:
            throw th;
        L21:
            if (r100 == true) goto L22;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(NABaseMap r100, Bundle r101, boolean r102) {
            this.f33452c = r100;
            this.f33450a = r101;
            this.f33451b = r102;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f33453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33454b;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$b__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33454b).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L14 Throwable -> L17
            if (r100 == false) goto L15;
            Bundle r101 = this.f33453a;     // Catch: Exception -> L14 Throwable -> L17
            if (r101 == null) goto L12;
            long r102 = r101.getLong("itemaddr", 0);     // Catch: Exception -> L14 Throwable -> L17
            if (NABaseMap.a(this.f33454b, r102) == false) goto L12;
            if (r100 == false) goto L26;
            NABaseMap.a(this.f33454b).readLock().unlock();
            return;
        L26:
            return;
        L12:
            NABaseMap r103 = this.f33454b;     // Catch: Exception -> L14 Throwable -> L17
            NABaseMap.a(r103, NABaseMap.d(r103), this.f33453a);     // Catch: Exception -> L14 Throwable -> L17
        L15:
            if (r100 == false) goto L27;
        L22:
            NABaseMap.a(this.f33454b).readLock().unlock();
            return;
        L27:
            return;
        L17:
            th = move-exception;
            if (r100 == false) goto L20;
            NABaseMap.a(this.f33454b).readLock().unlock();
        L20:
            throw th;
        L21:
            if (r100 == true) goto L22;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(NABaseMap r100, Bundle r101) {
            this.f33454b = r100;
            this.f33453a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f33455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33456b;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$c__run$___twin___() {
            if (NABaseMap.b(this.f33456b) == true) goto L5;
            return;
        L5:
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33456b).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L10 Throwable -> L13
            if (r100 == false) goto L11;
            NABaseMap r101 = this.f33456b;     // Catch: Exception -> L10 Throwable -> L13
            r101.nativeAddOneOverlayItem(NABaseMap.d(r101), this.f33455a);     // Catch: Exception -> L10 Throwable -> L13
        L11:
            if (r100 == false) goto L22;
        L18:
            NABaseMap.a(this.f33456b).readLock().unlock();
            return;
        L22:
            return;
        L13:
            th = move-exception;
            if (r100 == false) goto L16;
            NABaseMap.a(this.f33456b).readLock().unlock();
        L16:
            throw th;
        L17:
            if (r100 == true) goto L18;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(NABaseMap r100, Bundle r101) {
            this.f33456b = r100;
            this.f33455a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle[] f33457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f33458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33459c;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$d__run$___twin___() {
            if (NABaseMap.b(this.f33459c) == true) goto L5;
            return;
        L5:
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33459c).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L10 Throwable -> L13
            if (r100 == false) goto L11;
            NABaseMap r101 = this.f33459c;     // Catch: Exception -> L10 Throwable -> L13
            r101.nativeAddOverlayItems(NABaseMap.d(r101), this.f33457a, this.f33458b);     // Catch: Exception -> L10 Throwable -> L13
        L11:
            if (r100 == false) goto L22;
        L18:
            NABaseMap.a(this.f33459c).readLock().unlock();
            return;
        L22:
            return;
        L13:
            th = move-exception;
            if (r100 == false) goto L16;
            NABaseMap.a(this.f33459c).readLock().unlock();
        L16:
            throw th;
        L17:
            if (r100 == true) goto L18;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$d_com_larus_apm_impl_protector_RunnableLancet_run(d r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$d__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(NABaseMap r100, Bundle[] r101, int r102) {
            this.f33459c = r100;
            this.f33457a = r101;
            this.f33458b = r102;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f33460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33461b;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$e_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$e__run$___twin___() {
            if (NABaseMap.b(this.f33461b) == true) goto L5;
            return;
        L5:
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33461b).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L10 Throwable -> L13
            if (r100 == false) goto L11;
            NABaseMap r101 = this.f33461b;     // Catch: Exception -> L10 Throwable -> L13
            r101.nativeUpdateOneOverlayItem(NABaseMap.d(r101), this.f33460a);     // Catch: Exception -> L10 Throwable -> L13
        L11:
            if (r100 == false) goto L22;
        L18:
            NABaseMap.a(this.f33461b).readLock().unlock();
            return;
        L22:
            return;
        L13:
            th = move-exception;
            if (r100 == false) goto L16;
            NABaseMap.a(this.f33461b).readLock().unlock();
        L16:
            throw th;
        L17:
            if (r100 == true) goto L18;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$e_com_larus_apm_impl_protector_RunnableLancet_run(e r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$e__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(NABaseMap r100, Bundle r101) {
            this.f33461b = r100;
            this.f33460a = r101;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f33462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33463b;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$f_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$f__run$___twin___() {
            if (NABaseMap.b(this.f33463b) == true) goto L5;
            return;
        L5:
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33463b).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L10 Throwable -> L13
            if (r100 == false) goto L11;
            NABaseMap r101 = this.f33463b;     // Catch: Exception -> L10 Throwable -> L13
            r101.nativeRemoveOneOverlayItem(NABaseMap.d(r101), this.f33462a);     // Catch: Exception -> L10 Throwable -> L13
        L11:
            if (r100 == false) goto L22;
        L18:
            NABaseMap.a(this.f33463b).readLock().unlock();
            return;
        L22:
            return;
        L13:
            th = move-exception;
            if (r100 == false) goto L16;
            NABaseMap.a(this.f33463b).readLock().unlock();
        L16:
            throw th;
        L17:
            if (r100 == true) goto L18;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$f_com_larus_apm_impl_protector_RunnableLancet_run(f r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$f__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(NABaseMap r100, Bundle r101) {
            this.f33463b = r100;
            this.f33462a = r101;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle[] f33464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33465b;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$g_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$g__run$___twin___() {
            if (NABaseMap.b(this.f33465b) == true) goto L5;
            return;
        L5:
            boolean r100 = false;
            int r101 = 0;
            boolean r102 = NABaseMap.a(this.f33465b).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L20 Exception -> L25
            if (r102 == true) goto L31;
        L18:
            if (r102 == false) goto L35;
        L27:
            NABaseMap.a(this.f33465b).readLock().unlock();
            return;
        L35:
            return;
        L31:
            Bundle[] r103 = this.f33464a;     // Catch: Throwable -> L15 Exception -> L17
            int r104 = r103.length;     // Catch: Throwable -> L15 Exception -> L17
        L9:
            if (r101 >= r104) goto L18;
            Bundle r105 = r103[r101];     // Catch: Throwable -> L15 Exception -> L17
            if (NABaseMap.c(this.f33465b) == true) goto L18;
            NABaseMap r106 = this.f33465b;     // Catch: Throwable -> L15 Exception -> L17
            r106.nativeRemoveOneOverlayItem(NABaseMap.d(r106), r105);     // Catch: Throwable -> L15 Exception -> L17
            r101 = r101 + 1;
            goto L9
        L17:
            r100 = r102;
        L15:
            Throwable th10 = th;
        L22:
            if (r102 == false) goto L24;
            NABaseMap.a(this.f33465b).readLock().unlock();
        L24:
            throw th10;
        L20:
            th = move-exception;
            th10 = th;
            r102 = false;
        L26:
            if (r100 == true) goto L27;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$g_com_larus_apm_impl_protector_RunnableLancet_run(g r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$g__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(NABaseMap r100, Bundle[] r101) {
            this.f33465b = r100;
            this.f33464a = r101;
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33466a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$h_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$h__run$___twin___() {
            this.f33466a.dispose();
        }

        public h(NABaseMap r100) {
            this.f33466a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$h_com_larus_apm_impl_protector_RunnableLancet_run(h r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$h__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f33468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33469c;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$i__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33469c).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L14 Throwable -> L17
            if (r100 == true) goto L6;
        L15:
            if (r100 == false) goto L27;
        L22:
            NABaseMap.a(this.f33469c).readLock().unlock();
            return;
        L27:
            return;
        L6:
            if (NABaseMap.a(this.f33469c, this.f33467a) == true) goto L15;
            if (NABaseMap.c(this.f33469c) == false) goto L12;
            if (r100 == false) goto L26;
            NABaseMap.a(this.f33469c).readLock().unlock();
            return;
        L26:
            return;
        L12:
            NABaseMap r101 = this.f33469c;     // Catch: Exception -> L14 Throwable -> L17
            NABaseMap.a(r101, NABaseMap.d(r101), this.f33467a, this.f33468b);     // Catch: Exception -> L14 Throwable -> L17
        L17:
            th = move-exception;
            if (r100 == false) goto L20;
            NABaseMap.a(this.f33469c).readLock().unlock();
        L20:
            throw th;
        L21:
            if (r100 == true) goto L22;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$i_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$i_com_larus_apm_impl_protector_RunnableLancet_run(i r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$i__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public i(NABaseMap r100, long r101, boolean r102) {
            this.f33469c = r100;
            this.f33467a = r101;
            this.f33468b = r102;
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f33471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33472c;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$j__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33472c).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L9 Throwable -> L12
            if (r100 == true) goto L6;
        L10:
            if (r100 == false) goto L21;
        L17:
            NABaseMap.a(this.f33472c).readLock().unlock();
            return;
        L21:
            return;
        L6:
            if (NABaseMap.a(this.f33472c, this.f33470a) == true) goto L10;
            NABaseMap r101 = this.f33472c;     // Catch: Exception -> L9 Throwable -> L12
            NABaseMap.b(r101, NABaseMap.d(r101), this.f33470a, this.f33471b);     // Catch: Exception -> L9 Throwable -> L12
        L12:
            th = move-exception;
            if (r100 == false) goto L15;
            NABaseMap.a(this.f33472c).readLock().unlock();
        L15:
            throw th;
        L16:
            if (r100 == true) goto L17;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$j_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$j_com_larus_apm_impl_protector_RunnableLancet_run(j r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$j__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(NABaseMap r100, long r101, boolean r102) {
            this.f33472c = r100;
            this.f33470a = r101;
            this.f33471b = r102;
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33474b;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$k__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33474b).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L9 Throwable -> L12
            if (r100 == true) goto L6;
        L10:
            if (r100 == false) goto L21;
        L17:
            NABaseMap.a(this.f33474b).readLock().unlock();
            return;
        L21:
            return;
        L6:
            if (NABaseMap.a(this.f33474b, this.f33473a) == true) goto L10;
            NABaseMap r101 = this.f33474b;     // Catch: Exception -> L9 Throwable -> L12
            NABaseMap.c(r101, NABaseMap.d(r101), this.f33473a);     // Catch: Exception -> L9 Throwable -> L12
        L12:
            th = move-exception;
            if (r100 == false) goto L15;
            NABaseMap.a(this.f33474b).readLock().unlock();
        L15:
            throw th;
        L16:
            if (r100 == true) goto L17;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$k_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$k_com_larus_apm_impl_protector_RunnableLancet_run(k r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$k__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public k(NABaseMap r100, long r101) {
            this.f33474b = r100;
            this.f33473a = r101;
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33476b;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$l__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33476b).writeLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L7 Throwable -> L10
            if (r100 == false) goto L8;
            NABaseMap.e(this.f33476b).add(Long.valueOf(this.f33475a));     // Catch: Exception -> L7 Throwable -> L10
            NABaseMap r101 = this.f33476b;     // Catch: Exception -> L7 Throwable -> L10
            NABaseMap.d(r101, NABaseMap.d(r101), this.f33475a);     // Catch: Exception -> L7 Throwable -> L10
        L8:
            if (r100 == false) goto L19;
        L15:
            NABaseMap.a(this.f33476b).writeLock().unlock();
            return;
        L19:
            return;
        L10:
            th = move-exception;
            if (r100 == false) goto L13;
            NABaseMap.a(this.f33476b).writeLock().unlock();
        L13:
            throw th;
        L14:
            if (r100 == true) goto L15;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$l_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$l_com_larus_apm_impl_protector_RunnableLancet_run(l r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$l__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public l(NABaseMap r100, long r101) {
            this.f33476b = r100;
            this.f33475a = r101;
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f33478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33479c;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$m__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33479c).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L11 Throwable -> L14
            if (r100 == true) goto L6;
        L12:
            if (r100 == false) goto L23;
        L19:
            NABaseMap.a(this.f33479c).readLock().unlock();
            return;
        L23:
            return;
        L6:
            if (NABaseMap.a(this.f33479c, this.f33477a) == true) goto L12;
            if (NABaseMap.a(this.f33479c, this.f33478b) == true) goto L12;
            NABaseMap r101 = this.f33479c;     // Catch: Exception -> L11 Throwable -> L14
            NABaseMap.a(r101, NABaseMap.d(r101), this.f33477a, this.f33478b);     // Catch: Exception -> L11 Throwable -> L14
        L14:
            th = move-exception;
            if (r100 == false) goto L17;
            NABaseMap.a(this.f33479c).readLock().unlock();
        L17:
            throw th;
        L18:
            if (r100 == true) goto L19;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$m_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$m_com_larus_apm_impl_protector_RunnableLancet_run(m r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$m__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public m(NABaseMap r100, long r101, long r102) {
            this.f33479c = r100;
            this.f33477a = r101;
            this.f33478b = r102;
        }
    }

    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33481b;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$n__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33481b).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L13 Throwable -> L16
            if (r100 == true) goto L6;
        L14:
            if (r100 == false) goto L25;
        L21:
            NABaseMap.a(this.f33481b).readLock().unlock();
            return;
        L25:
            return;
        L6:
            if (NABaseMap.a(this.f33481b, this.f33480a) == true) goto L14;
            if (NABaseMap.c(this.f33481b) == true) goto L14;
            if (NABaseMap.d(this.f33481b) == 0) goto L14;
            NABaseMap r101 = this.f33481b;     // Catch: Exception -> L13 Throwable -> L16
            NABaseMap.a(r101, NABaseMap.d(r101), this.f33480a);     // Catch: Exception -> L13 Throwable -> L16
        L16:
            th = move-exception;
            if (r100 == false) goto L19;
            NABaseMap.a(this.f33481b).readLock().unlock();
        L19:
            throw th;
        L20:
            if (r100 == true) goto L21;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$n_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$n_com_larus_apm_impl_protector_RunnableLancet_run(n r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$n__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public n(NABaseMap r100, long r101) {
            this.f33481b = r100;
            this.f33480a = r101;
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33483b;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$o__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33483b).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L9 Throwable -> L12
            if (r100 == true) goto L6;
        L10:
            if (r100 == false) goto L21;
        L17:
            NABaseMap.a(this.f33483b).readLock().unlock();
            return;
        L21:
            return;
        L6:
            if (NABaseMap.a(this.f33483b, this.f33482a) == true) goto L10;
            NABaseMap r101 = this.f33483b;     // Catch: Exception -> L9 Throwable -> L12
            NABaseMap.b(r101, NABaseMap.d(r101), this.f33482a);     // Catch: Exception -> L9 Throwable -> L12
        L12:
            th = move-exception;
            if (r100 == false) goto L15;
            NABaseMap.a(this.f33483b).readLock().unlock();
        L15:
            throw th;
        L16:
            if (r100 == true) goto L17;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$o_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$o_com_larus_apm_impl_protector_RunnableLancet_run(o r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$o__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public o(NABaseMap r100, long r101) {
            this.f33483b = r100;
            this.f33482a = r101;
        }
    }

    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f33484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f33485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f33486c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f33487d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ NABaseMap f33488e;

        public void com_baidu_platform_comjni_map_basemap_NABaseMap$p__run$___twin___() {
            boolean r100 = false;
            r100 = NABaseMap.a(this.f33488e).readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L9 Throwable -> L12
            if (r100 == true) goto L6;
        L10:
            if (r100 == false) goto L21;
        L17:
            NABaseMap.a(this.f33488e).readLock().unlock();
            return;
        L21:
            return;
        L6:
            if (NABaseMap.a(this.f33488e, this.f33484a) == true) goto L10;
            NABaseMap r101 = this.f33488e;     // Catch: Exception -> L9 Throwable -> L12
            NABaseMap.a(r101, NABaseMap.d(r101), this.f33484a, this.f33485b, this.f33486c, this.f33487d);     // Catch: Exception -> L9 Throwable -> L12
        L12:
            th = move-exception;
            if (r100 == false) goto L15;
            NABaseMap.a(this.f33488e).readLock().unlock();
        L15:
            throw th;
        L16:
            if (r100 == true) goto L17;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_platform_comjni_map_basemap_NABaseMap$p_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comjni_map_basemap_NABaseMap$p_com_larus_apm_impl_protector_RunnableLancet_run(p r100) {
            r100.com_baidu_platform_comjni_map_basemap_NABaseMap$p__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public p(NABaseMap r100, long r101, long r102, boolean r103, Bundle r104) {
            this.f33488e = r100;
            this.f33484a = r101;
            this.f33485b = r102;
            this.f33486c = r103;
            this.f33487d = r104;
        }
    }

    private native void nativSetAuto3DEnter3DByZoomIn(long r100, boolean r101);

    private native void nativeAdd3DModelIDForFilterList(long r100, String r101);

    private native boolean nativeAddBmLayerBelow(long r100, long r101, long r102, int r103, int r104);

    private native void nativeAddHexagonMapData(long r100, long r101, Bundle r102);

    private native void nativeAddItemData(long r100, Bundle r101, boolean r102);

    private native long nativeAddLayer(long r100, int r101, int r102, String r103);

    private native void nativeAddPopupData(long r100, Bundle r101);

    private native void nativeAddRtPopData(long r100, Bundle r101);

    private native void nativeAddStreetCustomMarker(long r100, Bundle r101, Bitmap r102);

    private native void nativeAttachDC(long r100, long r101);

    private native boolean nativeBeginLocationLayerAnimation(long r100);

    private native void nativeCancelPreload(long r100, int r101);

    private native boolean nativeCleanCache(long r100, int r101, boolean r102);

    private native void nativeClearFullscreenMaskColor(long r100);

    private native void nativeClearHeatMapLayerCache(long r100, long r101);

    private native void nativeClearHexagonLayerCache(long r100, long r101);

    private native void nativeClearLayer(long r100, long r101);

    private native void nativeClearLocationLayerData(long r100, Bundle r101);

    private native void nativeClearMistmapLayer(long r100);

    private native void nativeClearParticleSystemMemory(long r100);

    private native void nativeClearUniversalLayer(long r100);

    private native boolean nativeCloseCache(long r100);

    private native void nativeCloseParticleEffect(long r100, String r101);

    private native void nativeCloseParticleEffectByType(long r100, int r101);

    private native long nativeCreate();

    private native long nativeCreateDuplicate(long r100);

    private native boolean nativeCustomParticleEffectByType(long r100, int r101, Bundle r102);

    private native boolean nativeDownloadMapStyle(long r100, String r101);

    private native int nativeDraw(long r100);

    private native void nativeEnablePOIAnimation(long r100, boolean r101);

    private native void nativeEntrySearchTopic(long r100, int r101, String r102, String r103);

    private native void nativeExitSearchTopic(long r100);

    private native void nativeFocusTrafficUGCLabel(long r100);

    private native String nativeGeoPt3ToScrPoint(long r100, int r101, int r102, int r103);

    private native String nativeGeoPtToScrPoint(long r100, int r101, int r102);

    private static native boolean nativeGet3DModelEnable(long r100);

    private native float nativeGetAdapterZoomUnitsEx(long r100);

    private native long nativeGetBackGroundColorByLevel(long r100, int r101);

    private native Bundle nativeGetBaseRoadData(long r100);

    private native int nativeGetCacheSize(long r100, int r101);

    private native boolean nativeGetCityInfoByBound(long r100, Bundle r101);

    private native String nativeGetCityInfoByID(long r100, int r101);

    private native String nativeGetCurDrawPoiInfo(long r100, int r101);

    private native boolean nativeGetCustomTrafficColorEnable(long r100);

    private static native boolean nativeGetDEMEnable(long r100);

    private native float nativeGetDpiScale(long r100);

    private static native boolean nativeGetDrawHouseHeightEnable(long r100);

    private native Bundle nativeGetDrawingMapStatus(long r100);

    private native float nativeGetFZoomToBoundF(long r100, Bundle r101, Bundle r102);

    private native String nativeGetFocusedBaseIndoorMapInfo(long r100);

    private native int nativeGetFontSizeLevel(long r100);

    private static native int nativeGetHouseSmoothLevel(long r100);

    private native int nativeGetIndoorMapShowMode(long r100, String r101);

    private static native long nativeGetLayerIDByTag(long r100, String r101);

    private native int nativeGetLayerPos(long r100, long r101);

    private native boolean nativeGetMapBarData(long r100, Bundle r101);

    private native int nativeGetMapLanguage(long r100);

    private native int nativeGetMapRenderType(long r100);

    private native int nativeGetMapScene(long r100);

    private native int nativeGetMapSceneAttr(long r100);

    private native Bundle nativeGetMapStatus(long r100, boolean r101);

    private static native Bundle nativeGetMapStatusLimits(long r100);

    private native boolean nativeGetMapStatusLimitsLevel(long r100, int[] r101);

    private native int nativeGetMapTheme(long r100);

    private native String nativeGetNearlyObjID(long r100, long r101, int r102, int r103, int r104);

    private native String nativeGetPoiMarkData(long r100, int r101, int r102, int r103, int r104, boolean r105);

    private static native boolean nativeGetPoiTagEnable(long r100, int r101);

    private static native void nativeGetProjectionMatrix(long r100, float[] r101);

    private native String nativeGetProjectionPt(long r100, String r101);

    private native int nativeGetScaleLevel(long r100, int r101, int r102);

    private native int nativeGetSkyOffset(long r100);

    private static native int nativeGetSkyboxStyle(long r100);

    private native String nativeGetStreetRoadNearPointFromCenter(long r100, double r101, double r102, int r103);

    private native int nativeGetVMPMapCityInfo(long r100, Bundle r101);

    private static native void nativeGetViewMatrix(long r100, float[] r101);

    private native boolean nativeGetVirtualPoiShowEnable(long r100);

    private native float nativeGetZoomToBound(long r100, Bundle r101, int r102, int r103);

    private native float nativeGetZoomToBoundF(long r100, Bundle r101);

    private native boolean nativeImportMapTheme(long r100, int r101);

    private native boolean nativeInit(long r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, int r110, int r111, int r112, int r113, int r114, int r115, int r116, boolean r117, boolean r118);

    private native boolean nativeInitCustomStyle(long r100, String r101, String r102);

    private native void nativeInitHeatMapData(long r100, long r101, Bundle r102);

    private native int nativeInitLayerCallback(long r100);

    private native boolean nativeInitWithBundle(long r100, Bundle r101, boolean r102);

    private native long nativeInsertLayerAt(long r100, int r101, int r102, int r103, String r104);

    private native void nativeInterruptDraw(long r100, boolean r101);

    private native boolean nativeIsAnimationRunning(long r100);

    private native boolean nativeIsBaseIndoorMapMode(long r100);

    private native boolean nativeIsBaseIndoorMapShow(long r100);

    private native boolean nativeIsEnableIndoor3D(long r100);

    private native boolean nativeIsNaviMode(long r100);

    private native boolean nativeIsPointInFocusBarBorder(long r100, double r101, double r102, double r103);

    private native boolean nativeIsPointInFocusIDRBorder(long r100, double r101, double r102);

    private native boolean nativeIsStreetArrowShown(long r100);

    private native boolean nativeIsStreetCustomMarkerShown(long r100);

    private native boolean nativeIsStreetPOIMarkerShown(long r100);

    private native boolean nativeIsStreetRoadClickable(long r100);

    private native boolean nativeIsSupBackgroundDraw(long r100);

    private native boolean nativeLayersIsShow(long r100, long r101);

    private native boolean nativeMoveLayerBelow(long r100, long r101, String r102);

    private native boolean nativeMoveLayerBelowTo(long r100, long r101, int r102);

    private native void nativeMoveToScrPoint(long r100, int r101, int r102);

    private native void nativeNewSetMapStatus(long r100, Bundle r101);

    private native void nativeOnBackground(long r100);

    private native void nativeOnForeground(long r100);

    private native void nativeOnGestureFinish(long r100);

    private native void nativeOnGestureStart(long r100);

    private native String nativeOnHotcityGet(long r100);

    private native void nativeOnPause(long r100);

    private native boolean nativeOnRecordAdd(long r100, int r101);

    private native String nativeOnRecordGetAll(long r100);

    private native String nativeOnRecordGetAt(long r100, int r101);

    private native boolean nativeOnRecordImport(long r100, boolean r101, boolean r102);

    private native boolean nativeOnRecordReload(long r100, int r101, boolean r102);

    private native boolean nativeOnRecordRemove(long r100, int r101, boolean r102);

    private native boolean nativeOnRecordStart(long r100, int r101, boolean r102, int r103);

    private native boolean nativeOnRecordSuspend(long r100, int r101, boolean r102, int r103);

    private native void nativeOnResume(long r100);

    private native String nativeOnSchcityGet(long r100, String r101);

    private native boolean nativeOnUsrcityMsgInterval(long r100, int r101);

    private native int nativeOnWifiRecordAdd(long r100, int r101);

    private native boolean nativePerformAction(long r100, String r101);

    private native void nativePreLoadParticleFile(long r100, String r101);

    private native boolean nativePreload(long r100, Bundle r101, int r102);

    private native int nativeQueryInterface(long r100);

    private native byte[] nativeReadMapResData(long r100, String r101);

    private native void nativeRecycleMemory(long r100, int r101);

    private native int nativeRelease(long r100);

    private native void nativeRemove3DModelIDForFilterList(long r100, String r101);

    private native boolean nativeRemoveBmLayer(long r100, long r101);

    private native boolean nativeRemoveItemData(long r100, Bundle r101);

    private native int nativeRemoveLayer(long r100, long r101);

    private native void nativeRemoveStreetAllCustomMarker(long r100);

    private native void nativeRemoveStreetCustomMaker(long r100, String r101);

    private static native void nativeRenderClearShaderCache(String r100);

    private static native void nativeRenderInit(long r100, int r101, int r102, Surface r103, int r104);

    private native void nativeRenderResize(long r100, int r101, int r102);

    private native void nativeResetImageRes(long r100);

    private native boolean nativeResumeCache(long r100);

    private native boolean nativeSaveCache(long r100);

    private native void nativeSaveScreenToLocal(long r100, String r101, String r102);

    private native String nativeScr2GeoInGesture(long r100, int r101, int r102);

    private native String nativeScrPtToGeoPoint(long r100, int r101, int r102);

    private static native void nativeSet3DModelEnable(long r100, boolean r101);

    private native void nativeSetAllStreetCustomMarkerVisibility(long r100, boolean r101);

    private native void nativeSetBackgroundColor(long r100, int r101);

    private native void nativeSetCustomStyleEnable(long r100, boolean r101);

    private native void nativeSetCustomTrafficColor(long r100, int r101, int r102, int r103, int r104);

    private native void nativeSetCustomTrafficColorEnable(long r100, boolean r101);

    private native void nativeSetCustomVMPDataRoot(long r100, String r101);

    private static native void nativeSetDEMEnable(long r100, boolean r101);

    private native void nativeSetDotPoiShowEnable(long r100, boolean r101);

    private native void nativeSetDpiScale(long r100, float r101);

    private static native void nativeSetDrawHouseHeightEnable(long r100, boolean r101);

    private native void nativeSetEnableIndoor3D(long r100, boolean r101);

    private native void nativeSetFeatureConfig(long r100, String r101);

    private native String nativeSetFocus(long r100, long r101, long r102, boolean r103, Bundle r104);

    private native void nativeSetFontSizeLevel(long r100, int r101);

    private native void nativeSetFullscreenMaskColor(long r100, int r101);

    private native void nativeSetGlobalLightEnable(long r100, boolean r101);

    private native void nativeSetHeatMapFrameAnimationIndex(long r100, long r101, int r102);

    private static native void nativeSetHouseSmoothLevel(long r100, int r101);

    private native void nativeSetIndoorMapShowMode(long r100, String r101, int r102);

    private native boolean nativeSetItsPreTime(long r100, int r101, int r102, int r103);

    private native boolean nativeSetLayerSceneMode(long r100, long r101, int r102);

    private native void nativeSetLayersClickable(long r100, long r101, boolean r102);

    private static native void nativeSetLittle3DEnable(long r100, boolean r101);

    private native void nativeSetLocationLayerData(long r100, Bundle r101);

    private native void nativeSetMapBackgroundImage(long r100, Bundle r101);

    private native int nativeSetMapControlMode(long r100, int r101);

    private native void nativeSetMapLanguage(long r100, int r101, boolean r102);

    private native boolean nativeSetMapScene(long r100, int r101);

    private native boolean nativeSetMapSceneAttr(long r100, int r101);

    private native void nativeSetMapStatus(long r100, Bundle r101);

    private static native void nativeSetMapStatusLimits(long r100, Bundle r101);

    private native boolean nativeSetMapStatusLimitsLevel(long r100, int r101, int r102);

    private native boolean nativeSetMapTheme(long r100, int r101, Bundle r102);

    private native boolean nativeSetMapThemeScene(long r100, int r101, int r102, Bundle r103);

    private static native void nativeSetMaxAndMinZoomLevel(long r100, Bundle r101);

    private native void nativeSetPoiTagEnable(long r100, int r101, boolean r102);

    private native void nativeSetRecommendPOIScene(long r100, int r101);

    private static native void nativeSetSkyboxStyle(long r100, int r101);

    private native void nativeSetStreetArrowShow(long r100, boolean r101);

    private static native void nativeSetStreetLayerNewDesignFlag(long r100, boolean r101);

    private native void nativeSetStreetMarkerClickable(long r100, String r101, boolean r102);

    private native void nativeSetStreetRoadClickable(long r100, boolean r101);

    private native void nativeSetStyleMode(long r100, int r101);

    private native void nativeSetSupBackgroundDraw(long r100, boolean r101);

    private native void nativeSetTargetStreetCustomMarkerVisibility(long r100, boolean r101, String r102);

    private native boolean nativeSetTestSwitch(long r100, boolean r101);

    private native void nativeSetTrafficUGCData(long r100, String r101);

    private native void nativeSetUniversalFilter(long r100, String r101);

    private native void nativeSetUseCustomVMP(long r100, boolean r101);

    private native void nativeSetVirtualPoiShowEnable(long r100, boolean r101);

    private native void nativeShowBaseIndoorMap(long r100, boolean r101);

    private native void nativeShowFootMarkGrid(long r100, boolean r101, String r102);

    private native void nativeShowHotMap(long r100, boolean r101, int r102);

    private native void nativeShowHotMapWithUid(long r100, boolean r101, int r102, String r103);

    private native void nativeShowLayers(long r100, long r101, boolean r102);

    private native void nativeShowMistMap(long r100, boolean r101, String r102);

    private native void nativeShowOperatorDataByType(long r100, boolean r101, int r102);

    private native boolean nativeShowParticleEffect(long r100, int r101);

    private native boolean nativeShowParticleEffectByFileName(long r100, String r101);

    private native boolean nativeShowParticleEffectByFilenameAndPos(long r100, String r101, float r102, float r103, float r104);

    private native boolean nativeShowParticleEffectByName(long r100, String r101, boolean r102);

    private native boolean nativeShowParticleEffectByType(long r100, int r101);

    private native boolean nativeShowParticleEffectByTypeAndPos(long r100, int r101, float r102, float r103, float r104);

    private native boolean nativeShowParticleEffectByTypeAndStyleID(long r100, int r101, int r102);

    private native void nativeShowSatelliteMap(long r100, boolean r101);

    private native void nativeShowStreetPOIMarker(long r100, boolean r101);

    private native void nativeShowStreetPopup(long r100, boolean r101);

    private native void nativeShowStreetRoadMap(long r100, boolean r101);

    private native void nativeShowTopicPOI(long r100, String r101, boolean r102, String r103, boolean r104);

    private native void nativeShowTrafficMap(long r100, boolean r101);

    private native void nativeShowTrafficUGCMap(long r100, boolean r101);

    private native void nativeShowUniversalLayer(long r100, Bundle r101);

    private native void nativeStartHeatMapFrameAnimation(long r100, long r101);

    private native void nativeStartIndoorAnimation(long r100);

    private native void nativeStopHeatMapFrameAnimation(long r100, long r101);

    private native void nativeSurfaceDestroyed(long r100, Surface r101);

    private native boolean nativeSwitchBaseIndoorMapFloor(long r100, String r101, String r102);

    private native void nativeSwitchDayOrDarkTheme(long r100, int r101, boolean r102);

    private native boolean nativeSwitchLayer(long r100, long r101, long r102);

    private native void nativeSyncClearLayer(long r100, long r101);

    private native void nativeUnFocusTrafficUGCLabel(long r100);

    private native void nativeUpdateBaseLayers(long r100);

    private native void nativeUpdateDrawFPS(long r100);

    private native void nativeUpdateFootMarkGrid(long r100);

    private native void nativeUpdateHeatMapData(long r100, long r101, Bundle r102);

    private native void nativeUpdateLayers(long r100, long r101);

    private native String nativeworldPointToScreenPoint(long r100, float r101, float r102, float r103);

    public native void nativeAddOneOverlayItem(long r100, Bundle r101);

    public native void nativeAddOverlayItems(long r100, Bundle[] r101, int r102);

    public native boolean nativeAddTileOverlay(long r100, Bundle r101);

    public native boolean nativeCleanSDKTileDataCache(long r100, long r101);

    public native void nativeRemoveOneOverlayItem(long r100, Bundle r101);

    public native void nativeUpdateOneOverlayItem(long r100, Bundle r101);

    public native boolean nativeUpdateSDKTile(long r100, Bundle r101);

    public void renderDone() {
    }

    private boolean a() {
        if (this.f33444a.isShutdown() == false) goto L5;
        return false;
    L5:
        if (this.f33444a.isTerminated() == true) goto L11;
        return true;
    L11:
        return false;
    }

    private void b() {
        ThreadPoolExecutor r100 = this.f33444a;     // Catch: Exception -> L9
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getQueue() == null) goto L7;
        this.f33444a.getQueue().clear();     // Catch: Exception -> L9
    L7:
        this.f33444a.shutdown();     // Catch: Exception -> L9
        this.f33444a.awaitTermination(100, TimeUnit.MILLISECONDS);     // Catch: Exception -> L9
        this.f33444a.shutdownNow();     // Catch: Exception -> L9
        return;
    }

    public void beginLocationLayerAnimation() {
        nativeBeginLocationLayerAnimation(this.f33445b);
    }

    public void clearFullscreenMaskColor() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeClearFullscreenMaskColor(r100);
        return;
    }

    public void clearMistmapLayer() {
        nativeClearMistmapLayer(this.f33445b);
    }

    public void clearParticleSystemMemory() {
        nativeClearParticleSystemMemory(this.f33445b);
    }

    public void clearUniversalLayer() {
        nativeClearUniversalLayer(this.f33445b);
    }

    public boolean closeCache() {
        return nativeCloseCache(this.f33445b);
    }

    public long createDuplicate() {
        return nativeCreateDuplicate(this.f33445b);
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        boolean r100 = false;
        if (this.f33447d < 5) goto L6;
        return 0;
    L6:
        if (this.f33445b == 0) goto L32;
        this.f33446c = true;
        b();
    L32:
        boolean r101 = this.f33448e.writeLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L23 Exception -> L27
        if (r101 == false) goto L16;
        long r102 = this.f33445b;     // Catch: Throwable -> L20 Exception -> L22
        if (r102 == 0) goto L17;
        int r103 = nativeRelease(r102);     // Catch: Throwable -> L20 Exception -> L22
        this.f33445b = 0;     // Catch: Throwable -> L20 Exception -> L22
        if (r101 == false) goto L15;
        this.f33448e.writeLock().unlock();
    L15:
        return r103;
    L17:
        if (r101 == false) goto L19;
        this.f33448e.writeLock().unlock();
    L19:
        return 0;
    L16:
        this.f33447d++;     // Catch: Throwable -> L20 Exception -> L22
        new Handler(Looper.getMainLooper()).postDelayed(new h(this), 200);     // Catch: Throwable -> L20 Exception -> L22
    L20:
        th = th;
        r100 = r101;
    L24:
        if (r100 == false) goto L26;
        this.f33448e.writeLock().unlock();
    L26:
        throw th;
    L28:
        if (r101 == false) goto L30;
        this.f33448e.writeLock().unlock();
    L30:
        return 0;
    L27:
        r101 = false;
    L23:
        th = th;
        goto L24
    }

    public int draw() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return 0;
    L5:
        return nativeDraw(r100);
    }

    public void exitSearchTopic() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeExitSearchTopic(r100);
        return;
    }

    public void focusTrafficUGCLabel() {
        nativeFocusTrafficUGCLabel(this.f33445b);
    }

    public boolean get3DModelEnable() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return false;
    L5:
        return nativeGet3DModelEnable(r100);
    }

    public float getAdapterZoomUnitsEx() {
        return nativeGetAdapterZoomUnitsEx(this.f33445b);
    }

    public Bundle getBaseRoadData() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return nativeGetBaseRoadData(r100);
    }

    public boolean getCustomTrafficColorEnable() {
        long r100 = this.f33445b;
        if (0 != r100) goto L7;
        return false;
    L7:
        return nativeGetCustomTrafficColorEnable(r100);
    }

    public boolean getDEMEnable() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return false;
    L5:
        return nativeGetDEMEnable(r100);
    }

    public float getDpiScale() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return 1.0f;
    L5:
        return nativeGetDpiScale(r100);
    }

    public boolean getDrawHouseHeightEnable() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return false;
    L5:
        return nativeGetDrawHouseHeightEnable(r100);
    }

    public Bundle getDrawingMapStatus() {
        return nativeGetDrawingMapStatus(this.f33445b);
    }

    public String getFocusedBaseIndoorMapInfo() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return null;
    L5:
        return nativeGetFocusedBaseIndoorMapInfo(r100);
    }

    public int getFontSizeLevel() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return 1;
    L5:
        return nativeGetFontSizeLevel(r100);
    }

    public int getHouseSmoothLevel() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return -1;
    L5:
        return nativeGetHouseSmoothLevel(r100);
    }

    public int getMapLanguage() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return 0;
    L5:
        return nativeGetMapLanguage(r100);
    }

    public int getMapRenderType() {
        return nativeGetMapRenderType(this.f33445b);
    }

    public int getMapScene() {
        return nativeGetMapScene(this.f33445b);
    }

    public int getMapSceneAttr() {
        return nativeGetMapSceneAttr(this.f33445b);
    }

    public Bundle getMapStatusLimits() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return null;
    L5:
        return nativeGetMapStatusLimits(r100);
    }

    public int getMapTheme() {
        return nativeGetMapTheme(this.f33445b);
    }

    public int getSkyOffset() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return 0;
    L5:
        return nativeGetSkyOffset(r100);
    }

    public int getSkyboxStyle() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return 0;
    L5:
        return nativeGetSkyboxStyle(r100);
    }

    public boolean getVirtualPoiShowEnable() {
        return nativeGetVirtualPoiShowEnable(this.f33445b);
    }

    public boolean isAnimationRunning() {
        return nativeIsAnimationRunning(this.f33445b);
    }

    public boolean isBaseIndoorMapMode() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
    L7:
        return false;
    L5:
        if (nativeIsBaseIndoorMapMode(r100) == false) goto L7;
        return true;
    }

    public boolean isBaseIndoorMapShow() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
    L7:
        return false;
    L5:
        if (nativeIsBaseIndoorMapShow(r100) == false) goto L7;
        return true;
    }

    public boolean isEnableIndoor3D() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return true;
    L5:
        return nativeIsEnableIndoor3D(r100);
    }

    public boolean isNaviMode() {
        return nativeIsNaviMode(this.f33445b);
    }

    public boolean isStreetArrowShown() {
        return nativeIsStreetArrowShown(this.f33445b);
    }

    public boolean isStreetCustomMarkerShown() {
        return nativeIsStreetCustomMarkerShown(this.f33445b);
    }

    public boolean isStreetPOIMarkerShown() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
    L7:
        return false;
    L5:
        if (nativeIsStreetPOIMarkerShown(r100) == false) goto L7;
        return true;
    }

    public boolean isStreetRoadClickable() {
        return nativeIsStreetRoadClickable(this.f33445b);
    }

    public boolean isSupBackgroundDraw() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L7;
        return false;
    L7:
        return nativeIsSupBackgroundDraw(r100);
    }

    public void onBackground() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeOnBackground(r100);
        return;
    }

    public void onForeground() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeOnForeground(r100);
        return;
    }

    public void onGestureFinish() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeOnGestureFinish(r100);
        return;
    }

    public void onGestureStart() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeOnGestureStart(r100);
        return;
    }

    public String onHotcityGet() {
        return nativeOnHotcityGet(this.f33445b);
    }

    public void onPause() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeOnPause(r100);
        return;
    }

    public String onRecordGetAll() {
        return nativeOnRecordGetAll(this.f33445b);
    }

    public void onResume() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeOnResume(r100);
        return;
    }

    public void removeStreetAllCustomMarker() {
        nativeRemoveStreetAllCustomMarker(this.f33445b);
    }

    public int renderRender() {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
        return 0;
    L5:
        return nativeDraw(r100);
    }

    public void resetImageRes() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeResetImageRes(r100);
        return;
    }

    public boolean resumeCache() {
        return nativeResumeCache(this.f33445b);
    }

    public boolean saveCache() {
        return nativeSaveCache(this.f33445b);
    L4:
        return false;
    }

    public void startIndoorAnimation() {
        nativeStartIndoorAnimation(this.f33445b);
    }

    public void unFocusTrafficUGCLabel() {
        nativeUnFocusTrafficUGCLabel(this.f33445b);
    }

    public void updateBaseLayers() {
        nativeUpdateBaseLayers(this.f33445b);
    }

    public void updateDrawFPS() {
        long r100 = this.f33445b;
        if (r100 == 0) goto L6;
        nativeUpdateDrawFPS(r100);
        return;
    }

    public void updateFootMarkGrid() {
        nativeUpdateFootMarkGrid(this.f33445b);
    }

    public NABaseMap() {
        this.f33444a = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("map/NABaseMap"));
        this.f33446c = false;
        this.f33447d = 0;
        this.f33448e = new ReentrantReadWriteLock(true);
        this.f33449f = new CopyOnWriteArraySet();
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        long r100 = nativeCreate();
        this.f33445b = r100;
        nativeInitLayerCallback(r100);
        return this.f33445b;
    }

    public long getNativeMapPointer() {
        return this.f33445b;
    }

    private boolean a(long r100) {
        if (this.f33449f.contains(Long.valueOf(r100)) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100 == 0) goto L7;
        return true;
    }

    public static /* synthetic */ boolean b(NABaseMap r100) {
        return r100.a();
    }

    public static /* synthetic */ boolean c(NABaseMap r100) {
        return r100.f33446c;
    }

    public static /* synthetic */ long d(NABaseMap r100) {
        return r100.f33445b;
    }

    public static /* synthetic */ Set e(NABaseMap r100) {
        return r100.f33449f;
    }

    public static void renderClearShaderCache(String r100) {
        nativeRenderClearShaderCache(r100);
    }

    public void add3DModelIDForFilterList(String r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeAdd3DModelIDForFilterList(r101, r100);
        return;
    }

    public void addOneOverlayItem(Bundle r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new c(this, r100));
    }

    public void addPopupData(Bundle r100) {
        nativeAddPopupData(this.f33445b, r100);
    }

    public void addRtPopData(Bundle r100) {
        nativeAddRtPopData(this.f33445b, r100);
    }

    public void cancelPreload(int r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeCancelPreload(r101, r100);
        return;
    }

    public void clearHeatMapLayerCache(long r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeClearHeatMapLayerCache(r101, r100);
        return;
    }

    public void clearHexagonLayerCache(long r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeClearHexagonLayerCache(r101, r100);
        return;
    }

    public void clearLayer(long r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new o(this, r100));
    }

    public void clearLocationLayerData(Bundle r100) {
        nativeClearLocationLayerData(this.f33445b, r100);
    }

    public void clearSDKLayer(long r100) {
        if (a() == true) goto L5;
        return;
    L5:
        if (this.f33446c == true) goto L10;
        this.f33444a.submit(new n(this, r100));
        return;
    }

    public void closeParticleEffect(String r100) {
        nativeCloseParticleEffect(this.f33445b, r100);
    }

    public void closeParticleEffectByType(int r100) {
        nativeCloseParticleEffectByType(this.f33445b, r100);
    }

    public long createByDuplicate(long r100) {
        long r101 = nativeCreateDuplicate(r100);
        this.f33445b = r101;
        if (r101 == 0) goto L6;
        nativeInitLayerCallback(r101);
    L6:
        return this.f33445b;
    }

    public boolean downloadMapStyle(String r100) {
        long r101 = this.f33445b;
        if (r101 != 0) goto L5;
        return false;
    L5:
        return nativeDownloadMapStyle(r101, r100);
    }

    public void enablePOIAnimation(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeEnablePOIAnimation(r101, r100);
        return;
    }

    public long getBackGroundColorByLevel(int r100) {
        long r101 = this.f33445b;
        if (r101 != 0) goto L5;
        return 0;
    L5:
        return nativeGetBackGroundColorByLevel(r101, r100);
    }

    public int getCacheSize(int r100) {
        return nativeGetCacheSize(this.f33445b, r100);
    }

    public boolean getCityInfoByBound(Bundle r100) {
        return nativeGetCityInfoByBound(this.f33445b, r100);
    }

    public String getCityInfoByID(int r100) {
        return nativeGetCityInfoByID(this.f33445b, r100);
    }

    public String getCurDrawPoiInfo(int r100) {
        long r101 = this.f33445b;
        if (r101 != 0) goto L5;
        return "";
    L5:
        return nativeGetCurDrawPoiInfo(r101, r100);
    }

    public int getIndoorMapShowMode(String r100) {
        long r101 = this.f33445b;
        if (r101 != 0) goto L5;
        return 0;
    L5:
        return nativeGetIndoorMapShowMode(r101, r100);
    }

    public long getLayerIDByTag(String r100) {
        if (this.f33445b != 0) goto L5;
    L8:
        return 0;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L8;
        return nativeGetLayerIDByTag(this.f33445b, r100);
    }

    public boolean getMapBarData(Bundle r100) {
        return nativeGetMapBarData(this.f33445b, r100);
    }

    public Bundle getMapStatus(boolean r100) {
        return nativeGetMapStatus(this.f33445b, r100);
    }

    public boolean getMapStatusLimitsLevel(int[] r100) {
        long r101 = this.f33445b;
        if (r101 != 0) goto L5;
        return false;
    L5:
        return nativeGetMapStatusLimitsLevel(r101, r100);
    }

    public boolean getPoiTagEnable(int r100) {
        long r101 = this.f33445b;
        if (r101 != 0) goto L5;
        return false;
    L5:
        return nativeGetPoiTagEnable(r101, r100);
    }

    public void getProjectMatrix(float[] r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeGetProjectionMatrix(r101, r100);
        return;
    }

    public String getProjectionPt(String r100) {
        return nativeGetProjectionPt(this.f33445b, r100);
    }

    public int getVMPMapCityInfo(Bundle r100) {
        return nativeGetVMPMapCityInfo(this.f33445b, r100);
    }

    public void getViewMatrix(float[] r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeGetViewMatrix(r101, r100);
        return;
    }

    public float getZoomToBoundF(Bundle r100) {
        return nativeGetZoomToBoundF(this.f33445b, r100);
    }

    public boolean importMapTheme(int r100) {
        return nativeImportMapTheme(this.f33445b, r100);
    }

    public void interruptDraw(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeInterruptDraw(r101, r100);
        return;
    }

    public boolean layersIsShow(long r100) {
        boolean r101 = false;
        boolean r102 = this.f33448e.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L20 Exception -> L24
        if (r102 == true) goto L28;
        if (r102 == false) goto L19;
        this.f33448e.readLock().unlock();
    L19:
        return false;
    L28:
    L14:
        th = th;
        r101 = r102;
    L21:
        if (r101 == false) goto L23;
        this.f33448e.readLock().unlock();
    L23:
        throw th;
    L6:
        if (a(r100) == false) goto L10;
        if (r102 == false) goto L9;
        this.f33448e.readLock().unlock();
    L9:
        return false;
    L10:
        boolean r103 = nativeLayersIsShow(this.f33445b, r100);     // Catch: Throwable -> L14 Exception -> L16
        if (r102 == false) goto L13;
        this.f33448e.readLock().unlock();
    L13:
        return r103;
    L25:
        if (r102 == false) goto L27;
        this.f33448e.readLock().unlock();
    L27:
        return false;
    L24:
        r102 = false;
    L20:
        th = th;
        goto L21
    }

    public boolean onRecordAdd(int r100) {
        return nativeOnRecordAdd(this.f33445b, r100);
    }

    public String onRecordGetAt(int r100) {
        return nativeOnRecordGetAt(this.f33445b, r100);
    }

    public String onSchcityGet(String r100) {
        return nativeOnSchcityGet(this.f33445b, r100);
    }

    public boolean onUsrcityMsgInterval(int r100) {
        return nativeOnUsrcityMsgInterval(this.f33445b, r100);
    }

    public int onWifiRecordAdd(int r100) {
        return nativeOnWifiRecordAdd(this.f33445b, r100);
    }

    public boolean performAction(String r100) {
        return nativePerformAction(this.f33445b, r100);
    }

    public void preLoadParticleFile(String r100) {
        nativePreLoadParticleFile(this.f33445b, r100);
    }

    public byte[] readMapResData(String r100) {
        long r101 = this.f33445b;
        if (r101 != 0) goto L5;
        return null;
    L5:
        return nativeReadMapResData(r101, r100);
    }

    public void recycleMemory(int r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeRecycleMemory(r101, r100);
        return;
    }

    public void remove3DModelIDForFilterList(String r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeRemove3DModelIDForFilterList(r101, r100);
        return;
    }

    public void removeBmLayer(long r100) {
        nativeRemoveBmLayer(this.f33445b, r100);
    }

    public boolean removeItemData(Bundle r100) {
        if (a() == true) goto L6;
        return false;
    L6:
        this.f33444a.submit(new b(this, r100));
        return true;
    }

    public void removeLayer(long r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new l(this, r100));
    }

    public void removeOneOverlayItem(Bundle r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new f(this, r100));
    }

    public void removeOneOverlayItems(Bundle[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (a() == true) goto L6;
        return;
    L6:
        if (this.f33446c == true) goto L12;
        this.f33444a.submit(new g(this, r100));
        return;
    }

    public void removeStreetCustomMaker(String r100) {
        nativeRemoveStreetCustomMaker(this.f33445b, r100);
    }

    public void set3DModelEnable(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSet3DModelEnable(r101, r100);
        return;
    }

    public void setAllStreetCustomMarkerVisibility(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetAllStreetCustomMarkerVisibility(r101, r100);
        return;
    }

    public void setAutoEnter3DByZoomIn(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativSetAuto3DEnter3DByZoomIn(r101, r100);
        return;
    }

    public void setBackgroundColor(int r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetBackgroundColor(r101, r100);
        return;
    }

    public void setCallback(com.baidu.platform.comapi.map.p r100) {
        BaseMapCallback.setMapCallback(this.f33445b, r100);
    }

    public void setCustomStyleEnable(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetCustomStyleEnable(r101, r100);
        return;
    }

    public void setCustomTrafficColorEnable(boolean r100) {
        long r101 = this.f33445b;
        if (0 != r101) goto L5;
        return;
    L5:
        nativeSetCustomTrafficColorEnable(r101, r100);
    }

    public void setDEMEnable(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetDEMEnable(r101, r100);
        return;
    }

    public void setDotPoiShowEnable(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetDotPoiShowEnable(r101, r100);
        return;
    }

    public void setDpiScale(float r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetDpiScale(r101, r100);
        return;
    }

    public void setDrawHouseHeightEnable(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetDrawHouseHeightEnable(r101, r100);
        return;
    }

    public void setEnableIndoor3D(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetEnableIndoor3D(r101, r100);
        return;
    }

    public void setFeatureConfig(String r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetFeatureConfig(r101, r100);
        return;
    }

    public void setFontSizeLevel(int r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetFontSizeLevel(r101, r100);
        return;
    }

    public void setFullscreenMaskColor(int r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetFullscreenMaskColor(r101, r100);
        return;
    }

    public void setGlobalLightEnable(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetGlobalLightEnable(r101, r100);
        return;
    }

    public void setHouseSmoothLevel(int r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetHouseSmoothLevel(r101, r100);
        return;
    }

    public void setLittle3DEnable(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetLittle3DEnable(r101, r100);
        return;
    }

    public void setLocationLayerData(Bundle r100) {
        nativeSetLocationLayerData(this.f33445b, r100);
    }

    public void setMapBackgroundImage(Bundle r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetMapBackgroundImage(r101, r100);
        return;
    }

    public int setMapControlMode(int r100) {
        return nativeSetMapControlMode(this.f33445b, r100);
    }

    public void setMapScene(int r100) {
        nativeSetMapScene(this.f33445b, r100);
    }

    public boolean setMapSceneAttr(int r100) {
        return nativeSetMapSceneAttr(this.f33445b, r100);
    }

    public void setMapStatus(Bundle r100) {
        nativeSetMapStatus(this.f33445b, r100);
    }

    public void setMapStatusLimits(Bundle r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetMapStatusLimits(r101, r100);
        return;
    }

    public void setMaxAndMinZoomLevel(Bundle r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetMaxAndMinZoomLevel(r101, r100);
        return;
    }

    public void setNewMapStatus(Bundle r100) {
        nativeNewSetMapStatus(this.f33445b, r100);
    }

    public void setRecommendPOIScene(int r100) {
        nativeSetRecommendPOIScene(this.f33445b, r100);
    }

    public void setSkyboxStyle(int r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetSkyboxStyle(r101, r100);
        return;
    }

    public void setStreetArrowShow(boolean r100) {
        nativeSetStreetArrowShow(this.f33445b, r100);
    }

    public void setStreetLayerNewDesignFlag(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSetStreetLayerNewDesignFlag(r101, r100);
        return;
    }

    public void setStreetRoadClickable(boolean r100) {
        nativeSetStreetRoadClickable(this.f33445b, r100);
    }

    public void setStyleMode(int r100) {
        nativeSetStyleMode(this.f33445b, r100);
    }

    public void setSupBackgroundDraw(boolean r100) {
        long r101 = this.f33445b;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeSetSupBackgroundDraw(r101, r100);
    }

    public boolean setTestSwitch(boolean r100) {
        return nativeSetTestSwitch(this.f33445b, r100);
    }

    public void setTrafficUGCData(String r100) {
        nativeSetTrafficUGCData(this.f33445b, r100);
    }

    public void setUniversalFilter(String r100) {
        nativeSetUniversalFilter(this.f33445b, r100);
    }

    public void setVirtualPoiShowEnable(boolean r100) {
        nativeSetVirtualPoiShowEnable(this.f33445b, r100);
    }

    public void showBaseIndoorMap(boolean r100) {
        nativeShowBaseIndoorMap(this.f33445b, r100);
    }

    public boolean showParticleEffect(int r100) {
        return nativeShowParticleEffect(this.f33445b, r100);
    }

    public boolean showParticleEffectByFileName(String r100) {
        return nativeShowParticleEffectByFileName(this.f33445b, r100);
    }

    public boolean showParticleEffectByType(int r100) {
        return nativeShowParticleEffectByType(this.f33445b, r100);
    }

    public void showSatelliteMap(boolean r100) {
        nativeShowSatelliteMap(this.f33445b, r100);
    }

    public void showStreetPOIMarker(boolean r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeShowStreetPOIMarker(r101, r100);
        return;
    }

    public void showStreetPopup(boolean r100) {
        nativeShowStreetPopup(this.f33445b, r100);
    }

    public void showStreetRoadMap(boolean r100) {
        nativeShowStreetRoadMap(this.f33445b, r100);
    }

    public void showTrafficMap(boolean r100) {
        nativeShowTrafficMap(this.f33445b, r100);
    }

    public void showTrafficUGCMap(boolean r100) {
        nativeShowTrafficUGCMap(this.f33445b, r100);
    }

    public void showUniversalLayer(Bundle r100) {
        nativeShowUniversalLayer(this.f33445b, r100);
    }

    public void startHeatMapFrameAnimation(long r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeStartHeatMapFrameAnimation(r101, r100);
        return;
    }

    public void stopHeatMapFrameAnimation(long r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeStopHeatMapFrameAnimation(r101, r100);
        return;
    }

    public void surfaceDestroyed(Surface r100) {
        long r101 = this.f33445b;
        if (r101 == 0) goto L6;
        nativeSurfaceDestroyed(r101, r100);
        return;
    }

    public void updateLayers(long r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new k(this, r100));
    }

    public void updateOneOverlayItem(Bundle r100) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new e(this, r100));
    }

    public static /* synthetic */ ReadWriteLock a(NABaseMap r100) {
        return r100.f33448e;
    }

    public static /* synthetic */ boolean a(NABaseMap r100, long r101) {
        return r100.a(r101);
    }

    public String Scr2GeoInGesture(int r100, int r101) {
        long r102 = this.f33445b;
        if (r102 != 0) goto L5;
        return "";
    L5:
        return nativeScr2GeoInGesture(r102, r100, r101);
    }

    public void addHexagonMapData(long r100, Bundle r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeAddHexagonMapData(r102, r100, r101);
        return;
    }

    public void addItemData(Bundle r100, boolean r101) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new a(this, r100, r101));
    }

    public void addOverlayItems(Bundle[] r100, int r101) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new d(this, r100, r101));
    }

    public void addStreetCustomMarker(Bundle r100, Bitmap r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeAddStreetCustomMarker(r102, r100, r101);
        return;
    }

    public boolean cleanCache(int r100, boolean r101) {
        return nativeCleanCache(this.f33445b, r100, r101);
    }

    public boolean customParticleEffectByType(int r100, Bundle r101) {
        return nativeCustomParticleEffectByType(this.f33445b, r100, r101);
    }

    public String geoPtToScrPoint(int r100, int r101) {
        return nativeGeoPtToScrPoint(this.f33445b, r100, r101);
    }

    public float getFZoomToBoundF(Bundle r100, Bundle r101) {
        return nativeGetFZoomToBoundF(this.f33445b, r100, r101);
    }

    public int getScaleLevel(int r100, int r101) {
        long r102 = this.f33445b;
        if (r102 != 0) goto L5;
        return -1;
    L5:
        return nativeGetScaleLevel(r102, r100, r101);
    }

    public boolean initCustomStyle(String r100, String r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L7;
        nativeInitCustomStyle(r102, r100, r101);
        return true;
    L7:
        return true;
    }

    public void initHeatMapData(long r100, Bundle r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeInitHeatMapData(r102, r100, r101);
        return;
    }

    public boolean initWithOptions(Bundle r100, boolean r101) {
        long r102 = this.f33445b;
        if (r102 != 0) goto L5;
    L7:
        return false;
    L5:
        if (nativeInitWithBundle(r102, r100, r101) == false) goto L7;
        return true;
    }

    public boolean isPointInFocusIDRBorder(double r100, double r110) {
        long r101 = this.f33445b;
        if (r101 != 0) goto L5;
    L7:
        return false;
    L5:
        if (nativeIsPointInFocusIDRBorder(r101, r100, r110) == false) goto L7;
        return true;
    }

    public boolean moveLayerBelow(long r100, String r101) {
        long r102 = this.f33445b;
        if (r102 != 0) goto L5;
        return false;
    L5:
        return nativeMoveLayerBelow(r102, r100, r101);
    }

    public boolean moveLayerBelowTo(long r100, int r101) {
        long r102 = this.f33445b;
        if (r102 != 0) goto L5;
        return false;
    L5:
        return nativeMoveLayerBelowTo(r102, r100, r101);
    }

    public void moveToScrPoint(int r100, int r101) {
        nativeMoveToScrPoint(this.f33445b, r100, r101);
    }

    public boolean onRecordImport(boolean r100, boolean r101) {
        return nativeOnRecordImport(this.f33445b, r100, r101);
    }

    public boolean onRecordReload(int r100, boolean r101) {
        return nativeOnRecordReload(this.f33445b, r100, r101);
    }

    public boolean onRecordRemove(int r100, boolean r101) {
        return nativeOnRecordRemove(this.f33445b, r100, r101);
    }

    public boolean preLoad(int r110, List<com.baidu.platform.comapi.map.i> r111) {
        int r100 = 0;
        if (this.f33445b != 0) goto L5;
        return false;
    L5:
        if (r111 != null) goto L7;
    L21:
        return false;
    L7:
        if (r111.size() <= 0) goto L21;
        Bundle r101 = new Bundle();
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L11:
        if (r103 >= r111.size()) goto L14;
        com.baidu.platform.comapi.map.i r104 = (com.baidu.platform.comapi.map.i) ListProtector.get(r111, r103);
        ParcelItem r105 = new ParcelItem();
        Bundle r106 = new Bundle();
        r106.putDouble("x", r104.f33315d);
        r106.putDouble("y", r104.f33316e);
        r106.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, r104.f33317f);
        r106.putFloat("level", r104.f33312a);
        r106.putInt("rotation", r104.f33313b);
        r106.putDouble("overlooking", r104.f33314c);
        r105.setBundle(r106);
        r102.add(r105);
        r103 = r103 + 1;
        goto L11
    L14:
        if (r102.size() <= 0) goto L21;
        ParcelItem[] r112 = new ParcelItem[r102.size()];
    L17:
        if (r100 >= r102.size()) goto L19;
        r112[r100] = (ParcelItem) ListProtector.get(r102, r100);
        r100 = r100 + 1;
        goto L17
    L19:
        r101.putParcelableArray("points", r112);
        return nativePreload(this.f33445b, r101, r110);
    }

    public void renderResize(int r100, int r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeRenderResize(r102, r100, r101);
        return;
    }

    public void saveScreenToLocal(String r100, String r101) {
        nativeSaveScreenToLocal(this.f33445b, r100, r101);
    }

    public String scrPtToGeoPoint(int r100, int r101) {
        return nativeScrPtToGeoPoint(this.f33445b, r100, r101);
    }

    public void setHeatMapFrameAnimationIndex(long r100, int r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeSetHeatMapFrameAnimationIndex(r102, r100, r101);
        return;
    }

    public void setIndoorMapShowMode(String r100, int r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeSetIndoorMapShowMode(r102, r100, r101);
        return;
    }

    public boolean setLayerSceneMode(long r100, int r101) {
        return nativeSetLayerSceneMode(this.f33445b, r100, r101);
    }

    public void setLayersClickable(long r100, boolean r101) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new j(this, r100, r101));
    }

    public void setMapLanguage(int r100, boolean r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeSetMapLanguage(r102, r100, r101);
        return;
    }

    public boolean setMapStatusLimitsLevel(int r100, int r101) {
        long r102 = this.f33445b;
        if (r102 != 0) goto L5;
        return false;
    L5:
        return nativeSetMapStatusLimitsLevel(r102, r100, r101);
    }

    public boolean setMapTheme(int r100, Bundle r101) {
        return nativeSetMapTheme(this.f33445b, r100, r101);
    }

    public void setPoiTagEnable(int r100, boolean r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeSetPoiTagEnable(r102, r100, r101);
        return;
    }

    public void setStreetMarkerClickable(String r100, boolean r101) {
        nativeSetStreetMarkerClickable(this.f33445b, r100, r101);
    }

    public void setTargetStreetCustomMarkerVisibility(boolean r100, String r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeSetTargetStreetCustomMarkerVisibility(r102, r100, r101);
        return;
    }

    public void showFootMarkGrid(boolean r100, String r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeShowFootMarkGrid(r102, r100, r101);
        return;
    }

    public void showHotMap(boolean r100, int r101) {
        nativeShowHotMap(this.f33445b, r100, r101);
    }

    public void showLayers(long r100, boolean r101) {
        if (a() == true) goto L5;
        return;
    L5:
        if (this.f33446c == true) goto L10;
        this.f33444a.submit(new i(this, r100, r101));
        return;
    }

    public void showMistMap(boolean r100, String r101) {
        nativeShowMistMap(this.f33445b, r100, r101);
    }

    public void showOperatorDataByType(boolean r100, int r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeShowOperatorDataByType(r102, r100, r101);
        return;
    }

    public boolean showParticleEffectByName(String r100, boolean r101) {
        return nativeShowParticleEffectByName(this.f33445b, r100, r101);
    }

    public boolean showParticleEffectByTypeAndStyleID(int r100, int r101) {
        return nativeShowParticleEffectByTypeAndStyleID(this.f33445b, r100, r101);
    }

    public boolean switchBaseIndoorMapFloor(String r100, String r101) {
        return nativeSwitchBaseIndoorMapFloor(this.f33445b, r100, r101);
    }

    public void switchDayOrDarkTheme(int r100, boolean r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeSwitchDayOrDarkTheme(r102, r100, r101);
        return;
    }

    public boolean switchLayer(long r100, long r110) {
        if (a() == true) goto L6;
        return false;
    L6:
        this.f33444a.submit(new m(this, r100, r110));
        return true;
    }

    public void updateHeatMapData(long r100, Bundle r101) {
        long r102 = this.f33445b;
        if (r102 == 0) goto L6;
        nativeUpdateHeatMapData(r102, r100, r101);
        return;
    }

    public static /* synthetic */ boolean a(NABaseMap r100, long r101, Bundle r102) {
        return r100.nativeRemoveItemData(r101, r102);
    }

    public static /* synthetic */ void b(NABaseMap r100, long r101, long r102) {
        r100.nativeClearLayer(r101, r102);
    }

    public static /* synthetic */ void c(NABaseMap r100, long r101, long r102) {
        r100.nativeUpdateLayers(r101, r102);
    }

    public static /* synthetic */ int d(NABaseMap r100, long r101, long r102) {
        return r100.nativeRemoveLayer(r101, r102);
    }

    public long addLayer(int r100, int r101, String r102) {
        long r103 = nativeAddLayer(this.f33445b, r100, r101, r102);
        this.f33449f.remove(Long.valueOf(r103));
        return r103;
    }

    public void entrySearchTopic(int r100, String r101, String r102) {
        long r103 = this.f33445b;
        if (r103 == 0) goto L6;
        nativeEntrySearchTopic(r103, r100, r101, r102);
        return;
    }

    public String geoPt3ToScrPoint(int r100, int r101, int r102) {
        return nativeGeoPt3ToScrPoint(this.f33445b, r100, r101, r102);
    }

    public String getStreetRoadNearPointFromCenter(double r100, double r110, int r111) {
        return nativeGetStreetRoadNearPointFromCenter(this.f33445b, r100, r110, r111);
    }

    public float getZoomToBound(Bundle r100, int r101, int r102) {
        return nativeGetZoomToBound(this.f33445b, r100, r101, r102);
    }

    public boolean isPointInFocusBarBorder(double r110, double r111, double r112) {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
    L7:
        return false;
    L5:
        if (nativeIsPointInFocusBarBorder(r100, r110, r111, r112) == false) goto L7;
        return true;
    }

    public boolean onRecordStart(int r100, boolean r101, int r102) {
        return nativeOnRecordStart(this.f33445b, r100, r101, r102);
    }

    public boolean onRecordSuspend(int r100, boolean r101, int r102) {
        return nativeOnRecordSuspend(this.f33445b, r100, r101, r102);
    }

    public boolean setItsPreTime(int r100, int r101, int r102) {
        return nativeSetItsPreTime(this.f33445b, r100, r101, r102);
    }

    public boolean setMapThemeScene(int r100, int r101, Bundle r102) {
        return nativeSetMapThemeScene(this.f33445b, r100, r101, r102);
    }

    public void showHotMap(boolean r100, int r101, String r102) {
        nativeShowHotMapWithUid(this.f33445b, r100, r101, r102);
    }

    public String worldPointToScreenPoint(float r100, float r101, float r102) {
        return nativeworldPointToScreenPoint(this.f33445b, r100, r101, r102);
    }

    public static /* synthetic */ void a(NABaseMap r100, long r101, long r102) {
        r100.nativeSyncClearLayer(r101, r102);
    }

    public static /* synthetic */ boolean a(NABaseMap r100, long r101, long r102, long r103) {
        return r100.nativeSwitchLayer(r101, r102, r103);
    }

    public static /* synthetic */ void b(NABaseMap r100, long r101, long r102, boolean r103) {
        r100.nativeSetLayersClickable(r101, r102, r103);
    }

    public boolean addBmLayerBelow(long r110, long r111, int r112, int r113) {
        return nativeAddBmLayerBelow(this.f33445b, r110, r111, r112, r113);
    }

    public String getNearlyObjID(long r110, int r111, int r112, int r113) {
        boolean r100 = false;
        r100 = this.f33448e.readLock().tryLock(2000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L14 Throwable -> L18
        if (r100 == true) goto L6;
        if (r100 == false) goto L17;
        this.f33448e.readLock().unlock();
    L17:
        return "";
    L6:
        if (a(r110) == false) goto L10;
        if (r100 == false) goto L9;
        this.f33448e.readLock().unlock();
    L9:
        return "";
    L10:
        String r114 = nativeGetNearlyObjID(this.f33445b, r110, r111, r112, r113);     // Catch: Exception -> L14 Throwable -> L18
        if (r100 == false) goto L13;
        this.f33448e.readLock().unlock();
    L13:
        return r114;
    L18:
        th = move-exception;
        if (r100 == false) goto L21;
        this.f33448e.readLock().unlock();
    L21:
        throw th;
    L22:
        if (r100 == false) goto L24;
        this.f33448e.readLock().unlock();
    L24:
        return "";
    }

    public float getZoomToBound(long r100, Bundle r101, int r102, int r103) {
        return nativeGetZoomToBound(r100, r101, r102, r103);
    }

    public void renderInit(int r100, int r101, Surface r102, int r110) {
        long r103 = this.f33445b;
        if (r103 == 0) goto L6;
        nativeRenderInit(r103, r100, r101, r102, r110);
        return;
    }

    public void setCustomTrafficColor(int r100, int r101, int r110, int r111) {
        long r102 = this.f33445b;
        if (0 != r102) goto L5;
        return;
    L5:
        nativeSetCustomTrafficColor(r102, r100, r101, r110, r111);
    }

    public void setFocus(long r110, long r111, boolean r112, Bundle r113) {
        if (a() == true) goto L5;
        return;
    L5:
        this.f33444a.submit(new p(this, r110, r111, r112, r113));
    }

    public boolean showParticleEffectByFilenameAndPos(String r100, float r101, float r110, float r111) {
        return nativeShowParticleEffectByFilenameAndPos(this.f33445b, r100, r101, r110, r111);
    }

    public boolean showParticleEffectByTypeAndPos(int r100, float r101, float r110, float r111) {
        return nativeShowParticleEffectByTypeAndPos(this.f33445b, r100, r101, r110, r111);
    }

    public void showTopicPOI(String r100, boolean r101, String r110, boolean r111) {
        nativeShowTopicPOI(this.f33445b, r100, r101, r110, r111);
    }

    public static /* synthetic */ void a(NABaseMap r100, long r101, long r102, boolean r103) {
        r100.nativeShowLayers(r101, r102, r103);
    }

    public static /* synthetic */ void a(NABaseMap r100, long r101, Bundle r102, boolean r103) {
        r100.nativeAddItemData(r101, r102, r103);
    }

    public String getPoiMarkData(int r100, int r110, int r111, int r112, boolean r113) {
        return nativeGetPoiMarkData(this.f33445b, r100, r110, r111, r112, r113);
    }

    public static /* synthetic */ String a(NABaseMap r100, long r101, long r102, long r103, boolean r104, Bundle r105) {
        return r100.nativeSetFocus(r101, r102, r103, r104, r105);
    }

    public boolean init(String r210, String r211, String r212, String r213, String r214, String r215, String r216, int r217, int r218, int r219, int r310, int r311, int r312, int r313, boolean r314, boolean r315) {
        long r100 = this.f33445b;
        if (r100 != 0) goto L5;
    L7:
        return false;
    L5:
        if (nativeInit(r100, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315) == false) goto L7;
        return true;
    }
}
