package com.bytedance.android.livesdk.interactivity.interactive;

import android.content.Context;
import com.bytedance.android.live.base.model.message.o5;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.g2;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class LiveInteractivePresenter extends com.bytedance.android.livesdk.chatroom.presenter.n<IView> implements vlc.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f137135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f137136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f137137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m0 f137138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IRoomEventHub f137139i;

    public interface IView extends IWidget {
        void HR(com.bytedance.android.live.base.model.message.n r100);

        void Nj(long r100);

        void b20(String r100, long r101, float r102, JSONObject r103);

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();

        void jP(long r100);

        void ux(o5 r100);

        void wz(ku2.b r100);

        void zP(String r100);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.android.livesdk.interactivity.interactive.m0] */
    public LiveInteractivePresenter() {
        this.f137135e = "";
        this.f137136f = new CompositeDisposable();
        this.f137137g = g2.f125379a.getValue();
        this.f137138h = new m0(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n, q46.b
    public void detachView() {
        super.detachView();
        this.f137136f.clear();
        IRoomEventHub r100 = this.f137139i;
        if (r100 == null) goto L5;
        r100.getSeiUpdate().removeObserver(this.f137138h);
    L5:
        this.f137139i = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public /* bridge */ /* synthetic */ void c0(IWidget r100) {
        g0((IView) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.livesdk.interactivity.interactive.j0] */
    public void g0(IView r100) {
        super.c0(r100);
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().f(new j0(this));
        vlc.d r101 = this.f107665d;
        if (r101 == null) goto L5;
        r101.addMessageListener(xq1.b.a(ku2.e.f506197i), this);
    L5:
        IRoomEventHub r102 = this.f137139i;
        if (r102 == null) goto L8;
        r102.getSeiUpdate().observeForever(this.f137138h);
    L8:
        Disposable r103 = Observable.interval(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new k0(this), new l0(this));
        this.f137136f.add(r103);
    }

    public final void h0(boolean r100) {
        this.f137135e = "";
        T r101 = this.f531633a;
        if (r101 == 0) goto L7;
        if (r100 == false) goto L8;
        ((IView) r101).jP(p6.b() / 1000);
        return;
    L8:
        return;
    }

    @Override // vlc.l
    public void onMessage(tlc.d r100) {
        if (this.f531633a != 0) goto L6;
        return;
    L6:
        if ((r100 instanceof com.bytedance.android.live.base.model.message.n) == false) goto L9;
        o82.h.b("receive activity interactive message");
        ((IView) this.f531633a).HR((com.bytedance.android.live.base.model.message.n) r100);
        return;
    }
}
