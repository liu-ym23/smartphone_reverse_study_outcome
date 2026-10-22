package com.bytedance.android.livesdk.asr.aio;

import com.bytedance.android.livesdk.asr.GiftSpeechSdkManager;
import com.bytedance.android.livesdk.asr.c;
import com.bytedance.android.scope.o;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ASRManagerService implements nc6.b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f103956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BehaviorSubject<nc6.a> f103957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PthreadTimer f103958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Timer f103959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f103960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f103961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f103962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.asr.b f103963h;

    public final GiftSpeechSdkManager c() {
        return (GiftSpeechSdkManager) this.f103956a.getValue();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // nc6.b
    public final void stopASREngine() {
        this.f103961f = false;
        this.f103963h.d("stopASREngine", "final result " + this.f103960e);
        c().d();
        c().h();
        PthreadTimer r100 = this.f103958c;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f103958c = null;
        Timer r101 = this.f103959d;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f103959d = null;
    }

    public final void a() {
        this.f103963h.f103967a.clear();
        BehaviorSubject<nc6.a> r100 = this.f103957b;
        if (r100 == null) goto L5;
        r100.onComplete();
    L5:
        this.f103957b = null;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        stopASREngine();
        a();
        c().b();
    }

    public ASRManagerService(com.bytedance.android.livesdk.asr.b r100) {
        Intrinsics.checkNotNullParameter(r100, "giftASREventTracker");
        this.f103963h = r100;
        this.f103956a = LazyKt.lazy(new ASRManagerService$giftSpeechSdkManager$2(this));
        this.f103962g = new AtomicBoolean(true);
    }

    @Override // nc6.b
    public final Observable<nc6.a> startASREngine(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "hotWordsList");
        if (this.f103961f == false) goto L9;
        BehaviorSubject<nc6.a> r101 = this.f103957b;
        if (r101 == null) goto L8;
        return r101;
    L8:
        return Observable.empty();
    L9:
        this.f103961f = true;
        if (this.f103957b == null) goto L12;
        a();
    L12:
        c r102 = null;
        this.f103960e = null;
        this.f103957b = BehaviorSubject.create();
        GiftSpeechSdkManager r103 = c();
        if (this.f103957b == null) goto L15;
        r102 = new ASRManagerService$createSpeechSdkListener$1(this);
    L15:
        r103.f103948d = r102;
        c().g();
        PthreadTimer r104 = this.f103958c;
        if (r104 == null) goto L18;
        r104.cancel();
    L18:
        PthreadTimer r105 = new PthreadTimer("ASRManagerService");
        this.f103958c = r105;
        r105.schedule(new b(this), oe1.b.a().d());
        c().j(r100);
        BehaviorSubject<nc6.a> r106 = this.f103957b;
        if (r106 == null) goto L22;
        return r106;
    L22:
        return Observable.empty();
    }

    @Override // nc6.b
    public final void updateASRHotWords(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "hotWordsList");
        c().j(r100);
    }
}
