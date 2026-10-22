package com.bytedance.android.livesdk.performance.gc.opt.controller;

import android.app.Activity;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.performance.event.EventType;
import com.bytedance.android.livesdk.performance.gc.opt.blocker.GcBlockScene;
import com.bytedance.android.livesdk.t1;
import com.bytedance.android.livesdkapi.model.LiveGcControllerConfig;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.aweme.debug.tag.global.open.StrictModeTag;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultLiveGcController implements com.bytedance.android.livesdk.performance.gc.opt.controller.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f154636d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveGcControllerConfig f154637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f154638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f154639c;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.performance.event.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultLiveGcController f154640a;

        public b(DefaultLiveGcController r100) {
            this.f154640a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v27 */
        /* JADX WARN: Type inference failed for: r6v28 */
        /* JADX WARN: Type inference failed for: r6v29 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v30 */
        /* JADX WARN: Type inference failed for: r6v6 */
        @Override // com.bytedance.android.livesdk.performance.event.b
        public final <T> void a(EventType<T> r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (DefaultLiveGcController.f154636d == false) goto L5;
            Objects.toString(r100);
            Objects.toString(r101);
        L5:
            DefaultLiveGcController r102 = this.f154640a;
            r102.getClass();
            if (Intrinsics.areEqual(r100, EventType.k.f154587e) == false) goto L18;
            if (r102.f154637a.getGcScrollStrategy() != 0) goto L16;
            if (r101 == 0) goto L15;
            if (((Boolean) r101).booleanValue() == false) goto L13;
            r102.b().a(GcBlockScene.SCROLL);
            return;
        L13:
            r102.b().b(GcBlockScene.SCROLL);
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        L16:
            r102.b().requestBlockGc(r102.f154637a.getRequestGcBlockDuration());
            return;
        L18:
            if (Intrinsics.areEqual(r100, EventType.j.f154586e) == false) goto L21;
            r102.b().requestBlockGc(r102.f154637a.getRequestGcBlockDuration());
            return;
        L21:
            if (Intrinsics.areEqual(r100, EventType.b.f154579e) == false) goto L24;
            r102.b().requestBlockGc(r102.f154637a.getRequestGcBlockDuration());
            return;
        L24:
            if (Intrinsics.areEqual(r100, EventType.g.f154583e) == false) goto L27;
            r102.b().requestBlockGc(r102.f154637a.getRequestGcBlockDuration());
            return;
        L27:
            if (Intrinsics.areEqual(r100, EventType.m.f154589e) == false) goto L30;
            r102.b().requestBlockGc(r102.f154637a.getRequestGcBlockDuration());
            return;
        L30:
            if (Intrinsics.areEqual(r100, EventType.h.f154584e) == false) goto L33;
            r102.b().requestBlockGc(r102.f154637a.getRequestGcBlockDuration());
            return;
        L33:
            if (Intrinsics.areEqual(r100, EventType.d.f154581e) == false) goto L43;
            boolean r103 = r101 instanceof Activity;
            ?? r104 = r101;
            if (r103 == true) goto L37;
            r104 = (T) null;
        L37:
            Activity r105 = (Activity) r104;
            if (r105 != null) goto L40;
            return;
        L40:
            if (r105.isFinishing() != true) goto L69;
            r102.a(0);
            return;
        L69:
            return;
        L43:
            if (Intrinsics.areEqual(r100, EventType.e.f154582e) == false) goto L53;
            boolean r106 = r101 instanceof Activity;
            ?? r107 = r101;
            if (r106 == true) goto L47;
            r107 = (T) null;
        L47:
            Activity r108 = (Activity) r107;
            if (r108 != null) goto L50;
            return;
        L50:
            if (r108.isFinishing() != true) goto L72;
            r102.a(1);
            return;
        L72:
            return;
        L53:
            if (Intrinsics.areEqual(r100, EventType.i.f154585e) == true) goto L55;
            return;
        L55:
            if (r102.f154637a.getEnableExitGcInhibit() == true) goto L57;
            return;
        L57:
            if ((r102.f154637a.getExitGcInhibitStrategy() & 2) != 0) goto L76;
            r102.b().b(GcBlockScene.EXIT);
            return;
        }
    }

    public final com.bytedance.android.livesdk.performance.gc.opt.blocker.b b() {
        return (com.bytedance.android.livesdk.performance.gc.opt.blocker.b) this.f154638b.getValue();
    }

    static {
        f154636d = LocalTestManager.b(new Class[]{StrictModeTag.class});
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.controller.a
    public final void stop() {
        boolean r100 = com.bytedance.android.livesdk.performance.event.c.f154591a;
        b r101 = this.f154639c;
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        EventType.f154576d.getClass();
        Object[] r102 = ((List) EventType.f154574b.getValue()).toArray(new EventType[0]);
        if (r102 == null) goto L13;
        EventType[] r103 = (EventType[]) r102;
        com.bytedance.android.livesdk.performance.event.c.e(r101, (EventType[]) Arrays.copyOf(r103, r103.length));
        b().release();
        if (this.f154637a.getAdjustJatoConfig() == true) goto L7;
        return;
    L7:
        if (this.f154637a.getJatoMaxHeapLimitReset() <= 0) goto L15;
        IMiddlewareHostAction r104 = (IMiddlewareHostAction) k.f(IMiddlewareHostAction.class);
        if (r104 == null) goto L16;
        r104.setJatoConfig(-1, this.f154637a.getJatoMaxHeapLimitReset(), 0);
        return;
    L16:
        return;
    L15:
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public DefaultLiveGcController() {
        this.f154637a = t1.f158504a.getValue();
        this.f154638b = LazyKt.lazy(DefaultLiveGcController$gcBlocker$2.INSTANCE);
        this.f154639c = new b(this);
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.controller.a
    public final void start() {
        b().prepare();
        boolean r100 = com.bytedance.android.livesdk.performance.event.c.f154591a;
        b r101 = this.f154639c;
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        EventType.f154576d.getClass();
        int r102 = 0;
        Object[] r103 = ((List) EventType.f154574b.getValue()).toArray(new EventType[0]);
        if (r103 == null) goto L27;
        EventType[] r104 = (EventType[]) r103;
        com.bytedance.android.livesdk.performance.event.c.b(r101, (EventType[]) Arrays.copyOf(r104, r104.length));
        if (this.f154637a.getAdjustJatoConfig() == true) goto L7;
        return;
    L7:
        if (this.f154637a.getJatoEnableMaxHeapSize() == false) goto L9;
        int r105 = (int) (Runtime.getRuntime().maxMemory() / ((long) 1048576));
    L11:
        if (this.f154637a.getJatoMaxHeapLimit() <= 0) goto L14;
        r102 = this.f154637a.getJatoMaxHeapLimit();
    L19:
        if (this.f154637a.getRemoveHeapSizeLimit() == false) goto L21;
        long r106 = Long.MAX_VALUE;
    L22:
        IMiddlewareHostAction r107 = (IMiddlewareHostAction) k.f(IMiddlewareHostAction.class);
        if (r107 == null) goto L29;
        r107.setJatoConfig(r105, r102, r106);
        return;
    L29:
        return;
    L21:
        r106 = 0;
        goto L22
    L14:
        if (this.f154637a.getJatoMaxHeapLimitPercent() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        if (this.f154637a.getJatoMaxHeapLimitPercent() >= 1.0d) goto L19;
        r102 = (int) ((Runtime.getRuntime().maxMemory() / ((long) 1048576)) * this.f154637a.getJatoMaxHeapLimitPercent());
        goto L19
    L9:
        r105 = -1;
        goto L11
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final void a(int r100) {
        if (this.f154637a.getEnableExitGcInhibit() == true) goto L5;
        return;
    L5:
        int r101 = this.f154637a.getExitGcInhibitStrategy();
        if ((r101 & 1) == r100) goto L8;
        return;
    L8:
        if ((r101 & 2) != 0) goto L10;
        b().a(GcBlockScene.EXIT);
        return;
    L10:
        b().requestBlockGc(this.f154637a.getExitGcInhibitDuration());
    }
}
