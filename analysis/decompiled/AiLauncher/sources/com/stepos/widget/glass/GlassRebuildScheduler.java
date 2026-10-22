package com.stepos.widget.glass;

import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.view.View;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/widget/glass/GlassRebuildScheduler;", "", "Landroid/view/View;", "view", "Lkotlin/Function0;", "LY8/t;", "rebuild", "<init>", "(Landroid/view/View;Lp9/a;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged$StepOSWidget_release", "(Landroid/content/res/Configuration;)V", "onConfigurationChanged", "cancel$StepOSWidget_release", "()V", "cancel", "Landroid/view/View;", "Lp9/a;", "", "lastNight", "Z", "", "lastRebuildUptimeMs", "J", "trailingScheduled", "Ljava/lang/Runnable;", "trailingRunnable", "Ljava/lang/Runnable;", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GlassRebuildScheduler {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long DEBOUNCE_WINDOW_MS = 300;
    private boolean lastNight;
    private long lastRebuildUptimeMs;
    private final InterfaceC5063a<Y8.t> rebuild;
    private final Runnable trailingRunnable;
    private boolean trailingScheduled;
    private final View view;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/widget/glass/GlassRebuildScheduler$Companion;", "", "<init>", "()V", "DEBOUNCE_WINDOW_MS", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    public GlassRebuildScheduler(View view, InterfaceC5063a<Y8.t> rebuild) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(rebuild, "rebuild");
        this.view = view;
        this.rebuild = rebuild;
        Context context = view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        this.lastNight = GlassThemeKt.isVisuallyDark(context);
        this.trailingRunnable = new Runnable() { // from class: com.stepos.widget.glass.f
            @Override // java.lang.Runnable
            public final void run() {
                GlassRebuildScheduler.trailingRunnable$lambda$0(this.f31226a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trailingRunnable$lambda$0(GlassRebuildScheduler glassRebuildScheduler) {
        glassRebuildScheduler.trailingScheduled = false;
        glassRebuildScheduler.lastRebuildUptimeMs = SystemClock.uptimeMillis();
        glassRebuildScheduler.rebuild.invoke();
    }

    public final void cancel$StepOSWidget_release() {
        this.view.removeCallbacks(this.trailingRunnable);
        this.trailingScheduled = false;
    }

    public final void onConfigurationChanged$StepOSWidget_release(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        boolean z10 = (newConfig.uiMode & 48) == 32;
        if (z10 == this.lastNight) {
            return;
        }
        this.lastNight = z10;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j10 = jUptimeMillis - this.lastRebuildUptimeMs;
        if (j10 >= 300) {
            this.lastRebuildUptimeMs = jUptimeMillis;
            this.rebuild.invoke();
        } else {
            if (this.trailingScheduled) {
                return;
            }
            this.trailingScheduled = true;
            this.view.postDelayed(this.trailingRunnable, 300 - j10);
        }
    }
}
