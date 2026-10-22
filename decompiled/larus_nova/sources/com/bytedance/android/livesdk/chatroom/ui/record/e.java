package com.bytedance.android.livesdk.chatroom.ui.record;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragContainer;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragParentView;
import com.bytedance.android.livesdk.config.wx0;
import com.bytedance.android.livesdk.utils.q6;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow;
import com.bytedance.android.uicomponent.loading.CircularProgressView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.text.SimpleDateFormat;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends PopupWindow implements IQuickRecordPopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CircularProgressView f113988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f113989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecordDragParentView f113990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecordDragContainer f113991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f113992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f113993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f113994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Activity f113995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f113996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f113997j;

    public static final class a {
    }

    public static final class b implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f113998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f113999b;

        public b(e r100, Function1 r101) {
            this.f113998a = r100;
            this.f113999b = r101;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            e r100 = this.f113998a;
            if (r100.f113994g > 0) goto L5;
            r100.f113994g = r100.f113993f;
        L5:
            this.f113999b.invoke(Long.valueOf(r100.f113994g));
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f114000a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f114001a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f114002b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f114003c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f114004d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Handler f114005e;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.record.e$c$a$a, reason: collision with other inner class name */
            public static final class RunnableC1682a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f114006a;

                public RunnableC1682a(a r100) {
                    this.f114006a = r100;
                }

                public final void a() {
                    a r100 = this.f114006a;
                    long r101 = Math.round(r100.f114001a.f114000a.f113993f / r100.f114004d);
                    a r102 = this.f114006a;
                    long r103 = r101 * r102.f114004d;
                    TextView r104 = r102.f114001a.f114000a.f113989b;
                    if (r104 == null) goto L5;
                    r104.setText(q6.b(r103));
                L5:
                    a r105 = this.f114006a;
                    e r106 = r105.f114001a.f114000a;
                    CircularProgressView r107 = r106.f113988a;
                    if (r107 == null) goto L9;
                    r107.setProgress(r106.f113993f / r105.f114003c);
                    return;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public static final class b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f114007a;

                public b(a r100) {
                    this.f114007a = r100;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e r100 = this.f114007a.f114001a.f114000a;     // Catch: Throwable -> L4
                    PopupWindowLancet.handleDismissBeforeOrigin(r100);     // Catch: Throwable -> L4
                    r100.dismiss();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public final void a() {
                this.f114001a.f114000a.f113993f = System.currentTimeMillis() - this.f114002b;
                ALogger.e("QuickRecordPopupWindow", "record time:" + this.f114001a.f114000a.f113993f);
                e r100 = this.f114001a.f114000a;
                if (r100.f113993f > this.f114003c) goto L9;
                r100.f113989b.post(new RunnableC1682a(this));
                long r101 = this.f114001a.f114000a.f113993f;
                long r102 = this.f114004d;
                long r103 = r101 % r102;
                if (r103 > (r102 / ((long) 2))) goto L8;
                r103 = r102 - r103;
            L8:
                this.f114005e.postDelayed(this, r103);
                return;
            L9:
                Looper r104 = Looper.myLooper();
                if (r104 == null) goto L12;
                ThreadMethodProxy.quit(r104);
            L12:
                View r105 = this.f114001a.f114000a.getContentView();
                if (r105 == null) goto L17;
                r105.post(new b(this));
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(c r100, long r101, long r102, long r103, Handler r104) {
                this.f114001a = r100;
                this.f114002b = r101;
                this.f114003c = r102;
                this.f114004d = r103;
                this.f114005e = r104;
            }
        }

        public c(e r100) {
            this.f114000a = r100;
        }

        public final void a() {
            if (Looper.myLooper() != null) goto L5;
            Looper.prepare();
        L5:
            Handler r100 = new Handler();
            e r101 = this.f114000a;
            long r102 = (r101.f113996i + 1) * ((long) 1000);
            r101.getClass();
            boolean r103 = false;
            float r104 = z0.b(false);
            if (r104 > 0) goto L8;
        L9:
            r103 = true;
        L10:
            if (r103 == false) goto L12;
            long r105 = 200;
        L13:
            long r110 = r105;
            r100.postDelayed(new a(this, System.currentTimeMillis(), r102, r110, r100), r110);
            Looper.loop();
            return;
        L12:
            r105 = 1000;
            goto L13
        L8:
            if (r104 < wx0.f121560a.getValue().floatValue()) goto L10;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final Activity getContext() {
        return this.f113995h;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow
    public final long getRecordTimes() {
        return this.f113993f;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow
    public final void setDismissListener(Function1<? super Long, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        setOnDismissListener(new b(this, r100));
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow
    public final void setRecordTimes(long r100) {
        this.f113993f = r100;
    }

    public e(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "ownerDisplayName");
        this.f113995h = r100;
        this.f113996i = 15;
        this.f113997j = r101;
        setContentView(LayoutInflater.from(r100).inflate(R.layout.ttlive_quick_recording_process_container, null));
        View r102 = getContentView();
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        r102.setSystemUiVisibility(1024);
        this.f113992e = (FrameLayout) getContentView().findViewById(R.id.ttlive_quick_record_watermark);
        RecordDragParentView r103 = (RecordDragParentView) getContentView().findViewById(R.id.root_view);
        this.f113990c = r103;
        View r104 = LayoutInflater.from(r100).inflate(R.layout.ttlive_quick_recording_process_dialog, null);
        CircularProgressView r105 = (CircularProgressView) r104.findViewById(R.id.ttlive_quick_recording_process);
        this.f113988a = r105;
        this.f113989b = (TextView) r104.findViewById(R.id.ttlive_quick_recording_time);
        RecordDragContainer r106 = (RecordDragContainer) r104.findViewById(R.id.ttlive_vs_quick_record_drag_view);
        this.f113991d = r106;
        setAnimationStyle(R.style.ttlive_quick_record_anim);
        setWidth(-1);
        setHeight(-1);
        r103.a(0, UtilityKotlinExtentionsKt.i(12), 0);
        r106.setDragParentView(r103);
        r105.setOnClickListener(new d(this));
    }

    @Override // android.widget.PopupWindow, com.bytedance.android.livesdkapi.depend.live.IQuickRecordPopupWindow
    public final void showAtLocation(View r100, int r101, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L6;
    L12:
        View r102 = ((IHostShare) k.n(IHostShare.class)).getQuickRecordWatermark(this.f113995h, this.f113997j);
        if (r102 == null) goto L15;
        this.f113992e.addView(r102);
    L15:
        this.f113988a.setProgress(0.0f);
        TextView r103 = this.f113989b;
        SimpleDateFormat r104 = q6.f159142a;
        r103.setText(q6.b(this.f113996i));
        this.f113990c.b(this.f113991d);
        this.f113991d.setX(r110 - s1.f(52.0f));
        this.f113991d.setY(s1.r() - s1.f(50.0f));
        this.f113993f = 0;
        ThreadMethodProxy.start(new PthreadThreadV2(new c(this), "QuickRecordPopupWindow"));
        return;
    L6:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L8;
        super.showAtLocation(r100, r101, r110, r111);
        goto L12
    L8:
        OverlaySource r105 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r100, r105, r101, r110, r111) == true) goto L12;
        super.showAtLocation(r100, r101, r110, r111);
        PopupWindowLancet.trackAfterShow(this, r105, r100);
        goto L12
    }
}
