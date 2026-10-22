package com.bytedance.android.live.saas.middleware.monitor;

import android.app.Application;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.BDLiveSdkSubject;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.base.IConfiguration;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.android.live.saas.middleware.di.Dagger_BDComponent;
import com.bytedance.android.live.saas.middleware.di.FuncType;
import com.bytedance.android.live.saas.middleware.di._BDComponent;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010R6\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b0\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/MonitorProxy;", "Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;", "Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;", "Lcom/bytedance/android/live/saas/middleware/monitor/MonitorConfig;", "()V", "mFunctionMap", "", "Lcom/bytedance/android/live/saas/middleware/di/FuncType;", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "getMFunctionMap", "()Ljava/util/Map;", "setMFunctionMap", "(Ljava/util/Map;)V", "create", "conf", "getMonitorInitTask", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Companion", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class MonitorProxy implements IConfiguration<IMonitorReport, MonitorConfig> {
    public static final Companion Companion = null;
    private static final _BDComponent diComponent = null;

    @Inject
    @Named("monitor")
    public Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>> mFunctionMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/MonitorProxy$Companion;", "", "()V", "diComponent", "Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "getDiComponent", "()Lcom/bytedance/android/live/saas/middleware/di/_BDComponent;", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final _BDComponent getDiComponent() {
            return MonitorProxy.access$getDiComponent$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.saas.middleware.monitor.MonitorProxy$getMonitorInitTask$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"com/bytedance/android/live/saas/middleware/monitor/MonitorProxy$getMonitorInitTask$1", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/monitor/MonitorConfig;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "setCompositeDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "initialized", "", "getInitialized", "()Z", "setInitialized", "(Z)V", "init", "", "app", "Landroid/app/Application;", "params", "unInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
    public static final class C99591 implements ISdkInitTask<MonitorConfig> {
        private CompositeDisposable compositeDisposable;
        private boolean initialized;

        @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
        public void unInit() {
            this.compositeDisposable.dispose();
        }

        public C99591() {
            this.compositeDisposable = new CompositeDisposable();
        }

        public final CompositeDisposable getCompositeDisposable() {
            return this.compositeDisposable;
        }

        public final boolean getInitialized() {
            return this.initialized;
        }

        public final void setCompositeDisposable(CompositeDisposable r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.compositeDisposable = r100;
        }

        public final void setInitialized(boolean r100) {
            this.initialized = r100;
        }

        /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
        public void init2(final Application r100, final MonitorConfig r101) {
            Intrinsics.checkNotNullParameter(r100, "app");
            Intrinsics.checkNotNullParameter(r101, "params");
            IAppLog r102 = BDLiveSdk.appLog();
            Intrinsics.checkNotNull(r102);
            String r103 = r102.getDid();
            if (r103 != null) goto L5;
        L13:
            Disposable r104 = BDLiveSdkSubject.INSTANCE.getIdSubject().observeOn(AndroidSchedulers.mainThread()).subscribe(new MonitorProxy$getMonitorInitTask$1$init$disposable$1(this, r101, r100));
            this.compositeDisposable.add(r104);
            return;
        L5:
            if (r103.length() <= 0) goto L7;
            boolean r105 = true;
        L8:
            if (r105 != true) goto L13;
            IMonitorReport r106 = r101.getMonitorReport();
            if (r106 == null) goto L12;
            r106.callInit(r100);
        L12:
            this.initialized = true;
            return;
        L7:
            r105 = false;
            goto L8
        }

        @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
        public /* bridge */ /* synthetic */ void init(Application r100, MonitorConfig r101) {
            init2(r100, r101);
        }
    }

    public MonitorProxy() {
    }

    static {
        Companion = new Companion(null);
        diComponent = Dagger_BDComponent.create();
    }

    public final Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>> getMFunctionMap() {
        Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>> r100 = this.mFunctionMap;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionMap");
    L5:
        return r100;
    }

    public final ISdkInitTask<MonitorConfig> getMonitorInitTask() {
        return new C99591();
    }

    public static final /* synthetic */ _BDComponent access$getDiComponent$cp() {
        return diComponent;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public BaseFunction<IMonitorReport, MonitorConfig> create2(final MonitorConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "conf");
        if (r100.getStandalone() == false) goto L5;
    L8:
        diComponent.inject(this);
        if (r100.isToBVersion() == false) goto L14;
        Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>> r101 = this.mFunctionMap;
        if (r101 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionMap");
    L13:
        BaseFunction<IMonitorReport, MonitorConfig> r102 = r101.get(FuncType.TYPE_TOB);
        Intrinsics.checkNotNull(r102);
        return r102;
    L14:
        Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>> r103 = this.mFunctionMap;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionMap");
    L17:
        BaseFunction<IMonitorReport, MonitorConfig> r104 = r103.get(FuncType.TYPE_INHOUSE);
        Intrinsics.checkNotNull(r104);
        return r104;
    L5:
        if (r100.isToBVersion() == true) goto L8;
        return new AnonymousClass1(this, r100);
    }

    public final void setMFunctionMap(Map<FuncType, BaseFunction<IMonitorReport, MonitorConfig>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mFunctionMap = r100;
    }

    @Override // com.bytedance.android.live.saas.middleware.base.IConfiguration
    public /* bridge */ /* synthetic */ BaseFunction<IMonitorReport, MonitorConfig> create(MonitorConfig r100) {
        return create2(r100);
    }
}
