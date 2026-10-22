package com.bytedance.android.ec.core.opt.asyncInflate;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.opt.asyncInflate.AsyncInflaterImpl;
import com.bytedance.android.ec.opt.asyncInflate.ILifecycleInflater;
import com.bytedance.android.ec.opt.asyncInflate.d;
import com.bytedance.android.ec.sdk.plugin.e;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0003\u001a\u00020\u0002H\u0017¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/opt/asyncInflate/ShoppingAsyncInflater;", "Lcom/bytedance/android/ec/opt/asyncInflate/ILifecycleInflater;", "", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShoppingAsyncInflater implements ILifecycleInflater {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Activity, ShoppingAsyncInflater> f45267d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f45268e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsyncInflaterImpl f45269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f45270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f45271c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater$a$a, reason: collision with other inner class name */
        public static final class RunnableC0809a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ShoppingAsyncInflater f45272a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Activity f45273b;

            public RunnableC0809a(ShoppingAsyncInflater r100, Activity r101) {
                this.f45272a = r100;
                this.f45273b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ((LifecycleOwner) this.f45273b).getLifecycle().addObserver(this.f45272a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a() {
        }

        public static ShoppingAsyncInflater a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Activity r101 = e.getActivity(r100);
            if ((r101 instanceof LifecycleOwner) == false) goto L8;
            Map<Activity, ShoppingAsyncInflater> r102 = ShoppingAsyncInflater.f45267d;
            ShoppingAsyncInflater r103 = (ShoppingAsyncInflater) ((LinkedHashMap) r102).get(r101);
            if (r103 != null) goto L9;
            ShoppingAsyncInflater r104 = new ShoppingAsyncInflater(new AsyncInflaterImpl(r101), r101, r100);
            new Handler(Looper.getMainLooper()).post(new RunnableC0809a(r104, r101));
            r102.put(r101, r104);
            return r104;
        L9:
            return r103;
        L8:
            return new ShoppingAsyncInflater(null, null, r100);
        }
    }

    public static final class b implements d {
        public b() {
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final d a(int r100, int r101) {
            return this;
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final d b(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "name");
            return this;
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final d c(int r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "name");
            return this;
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final void commit() {
        }

        @Override // com.bytedance.android.ec.opt.asyncInflate.d
        public final d d(int r100) {
            return this;
        }
    }

    static {
        f45268e = new a();
        f45267d = new LinkedHashMap();
    }

    public final d a() {
        AsyncInflaterImpl r100 = this.f45269a;
        if (r100 == null) goto L7;
        return new AsyncInflaterImpl.b(r100, false);
    L7:
        return new b();
    }

    @Override // com.bytedance.android.ec.opt.asyncInflate.ILifecycleInflater
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Activity r100 = this.f45270b;
        if (r100 == null) goto L6;
        f45268e.getClass();
        f45267d.remove(r100);
        return;
    }

    public final boolean b(int r100) {
        AsyncInflaterImpl r101 = this.f45269a;
        if (r101 == null) goto L14;
        LinkedList<View> r102 = r101.f48009a.get(Integer.valueOf(r100));
        if (r102 == null) goto L17;
        monitor-enter(r102);
        boolean r103 = !r102.isEmpty();
        monitor-exit(r102);
        return r103;
    L11:
        th = move-exception;
        throw th;
    L17:
        return false;
    L14:
        return false;
    }

    public ShoppingAsyncInflater(AsyncInflaterImpl r100, Activity r101, Context r102) {
        this.f45269a = r100;
        this.f45270b = r101;
        this.f45271c = r102;
    }

    public final View aU(int r100, ViewGroup r101, boolean r102) {
        AsyncInflaterImpl r103 = this.f45269a;
        if (r103 == null) goto L7;
        View r104 = r103.aU(r100, r101, r102);
        if (r104 == null) goto L7;
        return r104;
    L7:
        return th.a.c(this.f45271c, r100, r101, r102);
    }
}
