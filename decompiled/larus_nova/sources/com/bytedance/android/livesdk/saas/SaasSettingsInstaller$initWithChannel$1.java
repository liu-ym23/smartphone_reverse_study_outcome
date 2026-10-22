package com.bytedance.android.livesdk.saas;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.services.apm.api.EnsureManager;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import wa1.c;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lwa1/c;", "", AbsMethodDelegate.TAG_INVOKE, "(Lwa1/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SaasSettingsInstaller$initWithChannel$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ Context $application;
    final /* synthetic */ String $channel;

    public static final class a implements wa1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SaasSettingsInstaller$initWithChannel$1 f157865a;

        @Override // wa1.a
        public final void b() {
        }

        @Override // wa1.a
        public final boolean a() {
            return Intrinsics.areEqual("local_test", this.f157865a.$channel);
        }

        @Override // wa1.a
        public final x60.c.a c() {
            return new x60.c.a(false, false, false, true);
        }

        @Override // wa1.a
        public Context getContext() {
            return this.f157865a.$application;
        }

        public a(SaasSettingsInstaller$initWithChannel$1 r100) {
            this.f157865a = r100;
        }

        @Override // wa1.a
        public final void e(String r100) {
            Intrinsics.checkNotNullParameter("SettingReportMonitor_MAIN", "tag");
            ALogger.e("SettingReportMonitor_MAIN", r100);
        }

        @Override // wa1.a
        public final void e(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            ALogger.e(r100, r101);
        }

        @Override // wa1.a
        public final void ensureNotReachHere(Throwable r100, String r101) {
            EnsureManager.ensureNotReachHere(r100, r101);
        }

        @Override // wa1.a
        public final void i(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            ALogger.i(r100, r101);
        }

        @Override // wa1.a
        public final void e(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
            ALogger.e(r100, r101, r102);
        }

        @Override // wa1.a
        public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            Intrinsics.checkNotNullParameter(r100, "serviceName");
            SDKMonitor r104 = SDKMonitorUtils.getInstance("1730");
            if (r104 == null) goto L6;
            r104.monitorEvent(r100, r101, r102, r103);
            return;
        }
    }

    public SaasSettingsInstaller$initWithChannel$1(Context r100, String r101) {
        this.$application = r100;
        this.$channel = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.f558802a = new a(this);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
