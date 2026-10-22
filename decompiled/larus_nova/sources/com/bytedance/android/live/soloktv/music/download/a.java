package com.bytedance.android.live.soloktv.music.download;

import android.content.Context;
import com.bytedance.android.live.ktv.common.music.control.IMusicControlNode;
import com.bytedance.android.live.ktv.common.music.control.KtvMusicControlManager;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.music.download.m;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.viewmodel.PracticeSongViewModel;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements IMusicControlNode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.ktv.common.music.download.e f101407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f101408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PublishSubject<Boolean> f101409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PublishSubject<Boolean> f101410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PublishSubject<Boolean> f101411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f101412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.live.ktv.common.music.control.b f101413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f101414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f101415i;

    /* JADX INFO: renamed from: com.bytedance.android.live.soloktv.music.download.a$a, reason: collision with other inner class name */
    public static final class C1542a {
    }

    static {
    }

    public a() {
    }

    public final void c() {
        Lazy r100 = KtvMusicControlManager.f70003d;
        KtvMusicControlManager.a.a().e();
        com.bytedance.android.live.ktv.common.music.control.b r101 = this.f101413g;
        if ((r101 instanceof gb1.a) == true) goto L5;
        r101 = null;
    L5:
        gb1.a r102 = (gb1.a) r101;
        if (r102 == null) goto L8;
        r102.f480665o = null;
        r102.f480662l = null;
        r102.f480663m = null;
    L8:
        SoloKtvContext.Companion.getClass();
        SoloKtvContext.a.c(null);
        m r103 = KtvMusicManager.f70032a;
        KtvMusicManager.d();
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.IMusicControlNode.a
    public final void a(IMusicControlNode.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        c();
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.IMusicControlNode.a
    public final void b(IMusicControlNode.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        c();
    }

    public final void d(PracticeSongViewModel.AnonymousClass3 r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        com.bytedance.android.live.ktv.common.music.control.b r100 = this.f101413g;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f101407a = r110;
        Intrinsics.checkNotNull(r100);
        MusicPanel r111 = r100.f70024d;
        Disposable r101 = this.f101408b;
        if (r101 != null) goto L8;
    L10:
        this.f101409c = PublishSubject.create();
        this.f101410d = PublishSubject.create();
        this.f101411e = PublishSubject.create();
        m r102 = KtvMusicManager.f70032a;
        KtvMusicManager.f70033b = System.currentTimeMillis();
        this.f101408b = Observable.zip(this.f101409c, this.f101411e, e.f101423a).subscribe(new c(this, r111), new d(this, r111));
        final long r103 = System.currentTimeMillis();
        SoloKtvContext.Companion.getClass();
        com.bytedance.android.live.soloktv.model.d r112 = SoloKtvContext.a.a().getModel();
        if (r112 == null) goto L13;
        r112.d(new DownloadServiceImpl$listenLiveCoreParamsDownLoad$1(this, r103));
    L13:
        com.bytedance.android.live.ktv.common.music.control.b r104 = this.f101413g;
        if ((r104 instanceof gb1.a) == true) goto L16;
        com.bytedance.android.live.ktv.common.music.control.b r113 = null;
    L17:
        gb1.a r114 = (gb1.a) r113;
        if (r114 == null) goto L20;
        r114.f480664n = this.f101409c;
        r114.f480665o = this.f101407a;
    L20:
        if (r104 == null) goto L25;
        Context r105 = this.f101412f;
        String r115 = this.f101414h;
        if (r115 != null) goto L24;
        r115 = "";
    L24:
        com.bytedance.android.live.ktv.common.music.control.b.e(r104, r105, r115, this.f101415i, false, 20);
    L25:
        Lazy r116 = KtvMusicControlManager.f70003d;
        KtvMusicControlManager r117 = KtvMusicControlManager.a.a();
        com.bytedance.android.live.ktv.common.music.control.b r106 = this.f101413g;
        Intrinsics.checkNotNull(r106);
        r117.getClass();
        Intrinsics.checkNotNullParameter(r106, "node");
        r117.g(r106, this);
        r117.f70005b.b(r106);
        Function1<? super IMusicControlNode, Unit> r118 = r117.f70006c;
        if (r118 == null) goto L29;
        Unit r119 = r118.invoke(r106);
        return;
    L29:
        return;
    L16:
        r113 = r104;
        goto L17
    L8:
        if (r101.isDisposed() == true) goto L10;
        r101.dispose();
        goto L10
    }
}
