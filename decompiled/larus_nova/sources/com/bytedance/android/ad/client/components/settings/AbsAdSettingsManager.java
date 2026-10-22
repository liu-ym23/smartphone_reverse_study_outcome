package com.bytedance.android.ad.client.components.settings;

import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.ies.android.base.runtime.network.RequestMethod;
import g37.c;
import g37.d;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public abstract class AbsAdSettingsManager implements h37.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f38314e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f38316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f38317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f38318d;

    public static final class a implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsAdSettingsManager f38319a;

        public a(AbsAdSettingsManager r100) {
            this.f38319a = r100;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            AbsAdSettingsManager.d(this.f38319a);
            return false;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsAdSettingsManager f38320a;

        public b(AbsAdSettingsManager r100) {
            this.f38320a = r100;
        }

        @Override // g37.c
        public final d create() {
            d.a r100 = new d.a();
            this.f38320a.getClass();
            r100.f479841a = null;
            int r101 = p06.a.f527294a;
            r100.f479844d = null;
            r100.f479843c = this.f38320a;
            return r100.a();
        }
    }

    static {
        f38314e = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsAdSettingsManager.class), "mSettingsManager", "getMSettingsManager()Lcom/bytedance/news/common/settings/IndividualManager;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsAdSettingsManager.class), "mUrlBuilder", "getMUrlBuilder()Landroid/net/Uri$Builder;"))};
    }

    public String b() {
        return "";
    }

    public abstract void c();

    public final void a() {
        if (this.f38316b.get() == true) goto L20;
        Lazy r100 = this.f38317c;
        KProperty r101 = f38314e[0];
        ((g37.a) r100.getValue()).f479824a = new b(this);
        this.f38316b.set(true);
        Looper r102 = Looper.getMainLooper();
        if (Build.VERSION.SDK_INT < 23) goto L18;
        MessageQueue r103 = r102.getQueue();
    L14:
        if (r103 == null) goto L16;
        r103.addIdleHandler(new a(this));
        return;
    L16:
        d(this);
        return;
    L18:
        Field r104 = r102.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L13
        r104.setAccessible(true);     // Catch: Throwable -> L13
        Object r105 = r104.get(r102);     // Catch: Throwable -> L13
        if ((r105 instanceof MessageQueue) == true) goto L11;
        r105 = null;
    L11:
        r103 = (MessageQueue) r105;     // Catch: Throwable -> L13
    L13:
        r103 = null;
        goto L14
    }

    @Override // h37.b
    public final h37.c request() {
        h37.c r100 = new h37.c();
        Lazy r101 = this.f38318d;
        KProperty r102 = f38314e[1];
        ((Uri.Builder) r101.getValue()).build().toString();
        RequestMethod r103 = RequestMethod.GET;
        return r100;
    }

    public AbsAdSettingsManager() {
        this.f38315a = "https://is.snssdk.com/service/settings/v3/";
        this.f38316b = new AtomicBoolean(false);
        this.f38317c = LazyKt.lazy(new AbsAdSettingsManager$mSettingsManager$2(this));
        this.f38318d = LazyKt.lazy(new AbsAdSettingsManager$mUrlBuilder$2(this));
    }

    public static void d(AbsAdSettingsManager r100) {
        r100.a();
        if (r100.f38316b.get() == false) goto L6;
        Lazy r101 = r100.f38317c;
        KProperty r102 = f38314e[0];
        ((g37.a) r101.getValue()).e(true);
        return;
    }
}
