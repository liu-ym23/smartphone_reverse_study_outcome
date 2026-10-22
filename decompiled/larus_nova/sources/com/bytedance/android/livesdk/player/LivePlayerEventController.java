package com.bytedance.android.livesdk.player;

import android.hardware.HardwareBuffer;
import android.os.SystemClock;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.player.ILivePlayerEventController;
import com.bytedance.android.livesdkapi.player.ILivePlayerEventListener;
import com.bytedance.android.livesdkapi.view.IRenderView;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePlayerEventController implements ILivePlayerEventController, ILivePlayerEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentSkipListSet<a> f154951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f154952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f154953c;

    public static final class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ILivePlayerEventListener f154954a;

        public final int hashCode() {
            return this.f154954a.hashCode();
        }

        public a(ILivePlayerEventListener r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f154954a = r100;
        }

        @Override // java.lang.Comparable
        public final int compareTo(a r100) {
            a r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "other");
            return this.f154954a.hashCode() - r101.f154954a.hashCode();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
            return false;
        L12:
            if (r100 == null) goto L18;
            if ((!Intrinsics.areEqual(this.f154954a, ((a) r100).f154954a)) == false) goto L16;
            return false;
        L16:
            return true;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.player.LivePlayerEventController.ListenerInfo");
        L8:
            r101 = null;
            goto L10
        }
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onFirstFrame() {
        Iterator<T> r100 = this.f154951a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).f154954a.onFirstFrame();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onMute() {
        Iterator<T> r100 = this.f154951a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).f154954a.onMute();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final String onMuteIssueWarning() {
        Iterator<T> r100 = this.f154951a.iterator();
        String r101 = null;
    L4:
        if (r100.hasNext() == false) goto L7;
        r101 = ((a) r100.next()).f154954a.onMuteIssueWarning();
        if (r2.a(r101) == false) goto L4;
    L7:
        return r101;
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onPlaying() {
        Iterator<T> r100 = this.f154951a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).f154954a.onPlaying();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onPrepare() {
        Iterator<T> r100 = this.f154951a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).f154954a.onPrepare();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onRelease() {
        this.f154953c = 0;
        com.bytedance.android.livesdk.player.utils.g.e(0, false, false, new AnonymousClass1(this), 7);
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStop() {
        this.f154953c = 0;
        Iterator<T> r100 = this.f154951a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).f154954a.onStop();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onSurfaceReady() {
        Iterator<T> r100 = this.f154951a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).f154954a.onSurfaceReady();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onUnMute() {
        Iterator<T> r100 = this.f154951a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).f154954a.onUnMute();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void openHardwareBufferOutput() {
        Iterator<T> r100 = this.f154951a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).f154954a.openHardwareBufferOutput();
        goto L4
    }

    public LivePlayerEventController() {
        this.f154951a = new ConcurrentSkipListSet();
        this.f154952b = LazyKt.lazy(LivePlayerEventController$enable$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStartPul() {
        this.f154953c = SystemClock.elapsedRealtime();
        com.bytedance.android.livesdk.player.utils.g.e(0, false, false, new C102411(this), 7);
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onBindRenderView(IRenderView r100) {
        Iterator<T> r101 = this.f154951a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).f154954a.onBindRenderView(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onSei(String r100) {
        Iterator<T> r101 = this.f154951a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).f154954a.onSei(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onStallEvent(int r100) {
        Iterator<T> r101 = this.f154951a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).f154954a.onStallEvent(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onVideoSizeChange(Pair<Integer, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        Iterator<T> r101 = this.f154951a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) r101.next()).f154954a.onVideoSizeChange(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventController
    public final void removeEventListener(ILivePlayerEventListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((Boolean) this.f154952b.getValue()).booleanValue() == false) goto L6;
        this.f154951a.remove(new a(r100));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventController
    public final void addEventListener(ILivePlayerEventListener r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((Boolean) this.f154952b.getValue()).booleanValue() == false) goto L6;
        this.f154951a.add(new a(r100));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.player.ILivePlayerEventListener
    public final void onHWBDrawFrame(HardwareBuffer r100, int[] r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "hardwareBuffer");
        Intrinsics.checkNotNullParameter(r101, "roi");
        Iterator<T> r103 = this.f154951a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((a) r103.next()).f154954a.onHWBDrawFrame(r100, r101, r102);
        goto L4
    }
}
