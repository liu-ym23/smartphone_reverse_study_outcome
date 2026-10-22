package com.bytedance.android.live.liveinteract.linksecurity;

import android.util.Log;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.y;
import com.bytedance.android.live.core.utils.rxutils.z;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.texturerender.VideoSurfaceTexture;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class LinkSecurityMonitor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f75420f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f75421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f75422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f75423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkSecurityMonitor$anchorBroadcastEndObserver$1 f75424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Integer> f75425e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f75427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f75428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f75429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f75430d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f75427a, r101.f75427a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f75428b, r101.f75428b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f75429c, r101.f75429c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f75430d, r101.f75430d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f75427a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f75428b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Map<String, String> r107 = this.f75429c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f75430d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "SecurityMonitorInfo(biz=" + this.f75427a + ", sense=" + this.f75428b + ", params=" + this.f75429c + ", timeStamp=" + this.f75430d + ")";
        }

        public b(String r100, String r101, Map<String, String> r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "biz");
            Intrinsics.checkNotNullParameter(r101, "sense");
            Intrinsics.checkNotNullParameter(r102, "params");
            Intrinsics.checkNotNullParameter(r103, VideoSurfaceTexture.KEY_TIME);
            this.f75427a = r100;
            this.f75428b = r101;
            this.f75429c = r102;
            this.f75430d = r103;
        }
    }

    public static final class c extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public final DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA);
        }

        public c() {
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataCenter f75431a;

        public static final class a implements ttc.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f75432a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Observer f75433b;

            public a(d r100, b r101) {
                this.f75432a = r100;
                this.f75433b = r101;
            }

            @Override // ttc.c
            public final void cancel() {
                DataCenter r100 = this.f75432a.f75431a;
                if (r100 == null) goto L6;
                r100.removeObserver(this.f75433b);
                return;
            }
        }

        public static final class b<T> implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ObservableEmitter f75434a;

            public b(ObservableEmitter r100) {
                this.f75434a = r100;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object r100) {
                KVData r101 = (KVData) r100;
                if (r101 == null) goto L6;
                Iterable r102 = (List) r101.getData();
                if (r102 == null) goto L6;
            L7:
                Iterator<T> r103 = r102.iterator();
            L8:
                Object r104 = null;
                if (r103.hasNext() == false) goto L16;
                T r105 = r103.next();
                IBaseUser r106 = ((ILinkPlayerInfoBridge) r105).getUser();
                if (r106 == null) goto L14;
                r104 = r106.getIdString();
            L14:
                if (Intrinsics.areEqual(r104, ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n()) == false) goto L8;
                r104 = r105;
            L16:
                ILinkPlayerInfoBridge r107 = (ILinkPlayerInfoBridge) r104;
                if (r107 == null) goto L19;
                this.f75434a.onNext(r107);
                return;
            L19:
                ALogger.e("LinkSecurityMonitor", "can not find self in online list info");
                return;
            L6:
                r102 = new ArrayList();
                goto L7
            }
        }

        public d(DataCenter r100) {
            this.f75431a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<ILinkPlayerInfoBridge> r100) {
            Intrinsics.checkNotNullParameter(r100, "emmiter");
            b r101 = new b(r100);
            DataCenter r102 = this.f75431a;
            if (r102 == null) goto L5;
            r102.observe("data_online_changed_list", r101);
        L5:
            r100.setCancellable(new a(this, r101));
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkSecurityMonitor f75435a;

        public e(LinkSecurityMonitor r100) {
            this.f75435a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            y r101 = (y) r100;
            ILinkPlayerInfoBridge r102 = (ILinkPlayerInfoBridge) r101.f66382a;
            ILinkPlayerInfoBridge r103 = (ILinkPlayerInfoBridge) r101.f66383b;
            Set<Integer> r104 = this.f75435a.f75425e;
            if (r102 == null) goto L5;
            Integer r105 = Integer.valueOf(r102.getSilenceStatus());
        L7:
            if (CollectionsKt.contains(r104, r105) == true) goto L12;
            if (this.f75435a.f75425e.contains(Integer.valueOf(r103.getSilenceStatus())) == false) goto L12;
            LinkSecurityMonitor r106 = this.f75435a;
            r106.i(r102, r103, r106.f75421a);
        L12:
            if (r102 == null) goto L16;
            if (r102.getLinkType() != 2) goto L16;
            return;
        L16:
            if (r103.getLinkType() != 2) goto L20;
            LinkSecurityMonitor r107 = this.f75435a;
            r107.h(r102, r103, r107.f75421a);
            return;
        L20:
            return;
        L5:
            r105 = null;
            goto L7
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f75436a = null;

        static {
            f75436a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("LinkSecurityMonitor", (Throwable) r100);
        }
    }

    static {
    }

    public abstract String f();

    public abstract void g();

    public abstract void h(ILinkPlayerInfoBridge r100, ILinkPlayerInfoBridge r101, b r102);

    public abstract void i(ILinkPlayerInfoBridge r100, ILinkPlayerInfoBridge r101, b r102);

    public static boolean b() {
        return ((Boolean) vm2.d.f555900m3.getValue(null, vm2.d.f555776a[218(0xda, float:3.05E-43)])).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor$anchorBroadcastEndObserver$1] */
    public LinkSecurityMonitor() {
        this.f75422b = new CompositeDisposable();
        this.f75423c = new c();
        this.f75424d = new LinkSecurityMonitor$anchorBroadcastEndObserver$1(this);
        this.f75425e = SetsKt.setOf(new Integer[]{1, 2, 3, 4});
    }

    public final void j() {
        if (b() == true) goto L5;
        return;
    L5:
        DataCenter r100 = m.i().getDataCenter();
        if (r100 == null) goto L9;
        r100.observe("cmd_anchor_broadcast_end", this.f75424d);
        return;
    }

    public final void l() {
        if (b() == true) goto L6;
        return;
    L6:
        if (((Boolean) vm2.d.f555910n3.getValue(null, vm2.d.f555776a[219(0xdb, float:3.07E-43)])).booleanValue() == true) goto L8;
        return;
    L8:
        this.f75422b.clear();
    }

    public static void a(Map r100) {
        if (b() == true) goto L5;
        return;
    L5:
        r100.put("scene", String.valueOf(je0.d.f()));
        Integer r101 = je0.d.h();
        if (r101 == null) goto L8;
        r100.put("ui_layout", String.valueOf(r101.intValue()));
    L8:
        r100.put(FastStartLiveConfig.PLAY_MODE, u0.b());
        r100.put("stack_track", Log.getStackTraceString(new Throwable()));
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L12;
        String r102 = "anchor";
    L15:
        r100.put("role", r102);
        r100.put("is_self_singer", String.valueOf(je0.d.G()));
        return;
    L12:
        if (hd0.c.f().h() == false) goto L14;
        r102 = "guest";
        goto L15
    L14:
        r102 = "user";
        goto L15
    }

    public final void k(DataCenter r100) {
        if (b() == true) goto L6;
        return;
    L6:
        if (((Boolean) vm2.d.f555910n3.getValue(null, vm2.d.f555776a[219(0xdb, float:3.07E-43)])).booleanValue() == true) goto L8;
        return;
    L8:
        l();
        RxUtilKt.c(Observable.create(new d(r100)).compose(new z()).subscribe(new e(this), f.f75436a), this.f75422b);
    }

    public final void c(String r110, Map<String, String> r111, com.bytedance.android.live.core.privacy.av.api.b r112, com.bytedance.android.live.core.privacy.av.api.a r113) {
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r113, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r111);
        String r100 = f();
        DateFormat r101 = this.f75423c.get();
        if (r101 == null) goto L8;
        String r102 = r101.format(new Date());
    L9:
        this.f75421a = new b(r100, r110, r111, String.valueOf(r102));
        q60.a.f531757d.d(f(), r110, r111, r112, r113);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void d(String r110, Map<String, String> r111, com.bytedance.android.live.core.privacy.av.api.b r112, com.bytedance.android.live.core.privacy.av.api.a r113) {
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r113, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r111);
        String r100 = f();
        DateFormat r101 = this.f75423c.get();
        if (r101 == null) goto L8;
        String r102 = r101.format(new Date());
    L9:
        this.f75421a = new b(r100, r110, r111, String.valueOf(r102));
        q60.a.f531757d.c(f(), r110, r111, r112, r113);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void e(String r110, Map<String, String> r111, com.bytedance.android.live.core.privacy.av.api.b r112, com.bytedance.android.live.core.privacy.av.api.a r113) {
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r113, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r111);
        String r100 = f();
        DateFormat r101 = this.f75423c.get();
        if (r101 == null) goto L8;
        String r102 = r101.format(new Date());
    L9:
        this.f75421a = new b(r100, r110, r111, String.valueOf(r102));
        q60.a.f531757d.e(f(), r110, r111, r112, r113);
        return;
    L8:
        r102 = null;
        goto L9
    }
}
