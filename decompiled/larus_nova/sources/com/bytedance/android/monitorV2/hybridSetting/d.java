package com.bytedance.android.monitorV2.hybridSetting;

import android.content.Context;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile lz2.b f163068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f163069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f163070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f163071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PthreadTimer f163072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.monitorV2.hybridSetting.a f163073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HybridSettingInitConfig f163074g;

    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f163075a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            d r100 = this.f163075a;     // Catch: Throwable -> L8
            r100.getClass();     // Catch: Throwable -> L8
            r100.f163071d.submit(new e(r100, false));     // Catch: Throwable -> L5
        L17:
            return;
        L5:
            th = move-exception;
            com.bytedance.android.monitorV2.util.f.b(th);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public a(d r100) {
            this.f163075a = r100;
        }
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final List<lz2.a> a() {
        if (this.f163068a == null) goto L12;
        if (this.f163068a.f511346a == null) goto L12;
        if (this.f163068a.f511346a.f163079b == null) goto L12;
        return this.f163068a.f511346a.f163079b;
    L12:
        return new ArrayList();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final CheckFilter b() {
        if (this.f163068a.f511353h == null) goto L7;
        return this.f163068a.f511353h;
    L7:
        return new CheckFilter();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final Map<String, Integer> c() {
        if (this.f163068a.f511351f == null) goto L7;
        return this.f163068a.f511351f;
    L7:
        return new HashMap();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final BidInfo d() {
        if (this.f163068a == null) goto L9;
        if (this.f163068a.f511346a == null) goto L9;
        return this.f163068a.f511346a;
    L9:
        return new BidInfo();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final Set<String> e() {
        if (this.f163068a.f511352g == null) goto L7;
        return this.f163068a.f511352g;
    L7:
        return new HashSet();
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final HybridSettingInitConfig getInitConfig() {
        return this.f163074g;
    }

    public d(HybridSettingInitConfig r100) {
        this.f163069b = false;
        this.f163070c = false;
        this.f163071d = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("HybridSettingManagerImpl"));
        this.f163074g = r100;
        this.f163068a = new lz2.b();
    }

    public static void f(d r100) {
        if (r100.f163073f != null) goto L17;
        HybridSettingInitConfig r101 = r100.f163074g;
        Field r102 = TTNetInit.class.getDeclaredField("sNotifiedColdStartFinsish");     // Catch: Throwable -> L10
        r102.setAccessible(true);     // Catch: Throwable -> L10
        if (r102.getBoolean(null) == false) goto L8;
        r100.f163073f = new rz2.a(r101);     // Catch: Throwable -> L10
        nz2.b.f("HybridSettingRequestService_init", "setting request use ttnet");     // Catch: Throwable -> L10
    L13:
        return;
    L8:
        r100.f163073f = new g(r101);     // Catch: Throwable -> L10
        nz2.b.f("HybridSettingRequestService_init", "setting request use default cause by ttnet not init");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.a("startup_handle", th);
        r100.f163073f = new g(r101);
        nz2.b.b("HybridSettingRequestService_init", "setting request use default cause by Throwable");
        return;
    }

    public final void g(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (this.f163072e != null) goto L6;
        this.f163072e = new PthreadTimer("HybridSettingManagerImpl");
    L6:
        nz2.b.f("HybridSettingRequestService_update", "monitor setting update after " + r100 + " secs");
        this.f163072e.schedule(new a(this), (long) (r100 * 1000));
    }

    @Override // com.bytedance.android.monitorV2.hybridSetting.h
    public final void init(Context r100) {
        if (r100 != null) goto L6;
        nz2.b.b("HybridSettingRequestService_init", "init error, no context");
        return;
    L6:
        if (this.f163069b == false) goto L8;
        return;
    L8:
        this.f163069b = true;
        this.f163070c = false;
        this.f163071d.submit(new c(this));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
    }
}
