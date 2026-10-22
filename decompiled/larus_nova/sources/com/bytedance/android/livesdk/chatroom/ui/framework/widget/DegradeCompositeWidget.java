package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.animation.ValueAnimator;
import android.provider.Settings;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.kw0;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/DegradeCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DegradeCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.a f113085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f113086c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f113087a = null;

        static {
            f113087a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = com.bytedance.android.livesdk.performance.degrade.f.f154550a;     // Catch: Throwable -> L4
            ALogger.i("DeviceDegrade", "LivePlayFragment observePlayerEventHub reSetHasFirstFrame false");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DegradeCompositeWidget() {
        this.f113086c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.f113084a = ho1.a.d(getComponentContext());
        this.f113085b = ho1.a.c(getComponentContext());
        if (kw0.f120634a.getValue().booleanValue() == true) goto L26;
    L15:
        int r100 = com.bytedance.android.live.room.y.f100451a;
        com.bytedance.android.live.room.y.a(this.dataCenter, this.f113086c, "DegradeCompositeWidget->LiveRoomDegradeReminder", a.f113087a);
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L18;
        r101.observe("interaction_on_first_frame", this, true);
    L18:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r102 = this.f113085b;
        if (r102 == null) goto L28;
        PropertyOwner r103 = r102.getLoadState();
        if (r103 == null) goto L29;
        Disposable r104 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r103, new AnonymousClass2(this));
        if (r104 == null) goto L30;
        RxUtilKt.c(r104, this.f113086c);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L26:
        Reflect r105 = Reflect.on(ValueAnimator.class);     // Catch: Throwable -> L11
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L11
        if (getContext() != null) goto L9;
    L12:
        Float r107 = (Float) r105.get("sDurationScale", new Class[0]);     // Catch: Throwable -> L11 Throwable -> L11
        com.bytedance.android.livesdk.log.b0.o().getClass();     // Catch: Throwable -> L11 Throwable -> L11
        com.bytedance.android.live.core.log.g.i("LiveAnimator", "sDurationScale: " + r107);     // Catch: Throwable -> L11 Throwable -> L11
        if (r107.floatValue() > 0.0f) goto L15;
        r106.put("sDurationScale", r107.floatValue());     // Catch: Throwable -> L11 Throwable -> L11
        LiveTracingMonitor.f("ttlive_value_animator_duration_scale_error", LiveTracingMonitor.EventModule.common, r106, new JSONObject(), new JSONObject());     // Catch: Throwable -> L11 Throwable -> L11
        r105.call("setDurationScale", new Class[]{Float.TYPE}, new Object[]{Float.valueOf(1.0f)});     // Catch: Throwable -> L11 Throwable -> L11
        goto L15
    L9:
        if (getContext().getContentResolver() == null) goto L12;
        float r108 = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);     // Catch: Throwable -> L11 Throwable -> L11
        r106.put("globalAnimatorDurationScale", r108);     // Catch: Throwable -> L11 Throwable -> L11
        com.bytedance.android.livesdk.log.b0.o().getClass();     // Catch: Throwable -> L11 Throwable -> L11
        com.bytedance.android.live.core.log.g.i("LiveAnimator", "globalAnimatorDurationScale: " + r108);     // Catch: Throwable -> L11 Throwable -> L11
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r100 = this.dataCenter;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        this.f113084a = null;
        this.f113086c.dispose();
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r102 = this.f113084a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.hq() != true) goto L24;
        if (r101 == null) goto L9;
        String r103 = r101.getKey();
    L10:
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.hashCode() == 1922181771) goto L16;
        return;
    L16:
        if (r103.equals("interaction_on_first_frame") == false) goto L22;
        Boolean r104 = (Boolean) this.dataCenter.get("interaction_on_first_frame", Boolean.FALSE);
        ALogger.i("DeviceDegrade", "AbsInteractionFragment setHasFirstFrame = " + r104);
        if (r104.booleanValue() == false) goto L23;
        int r105 = com.bytedance.android.livesdk.performance.degrade.f.f154550a;
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r103 = null;
        goto L10
    }
}
