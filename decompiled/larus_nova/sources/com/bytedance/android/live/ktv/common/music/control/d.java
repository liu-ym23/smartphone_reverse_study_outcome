package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.model.ModeType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class d implements IMusicControlNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f70021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f70022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f70023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MusicPanel f70024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ModeType f70025e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f70026a;

        public a(d r100) {
            this.f70026a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            Disposable r102 = this.f70026a.f70022b;
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            this.f70026a.d();
            String r103 = null;
            this.f70026a.f70023c = null;
            StringBuilder r104 = new StringBuilder("BaseMusicControlNode#process, handleProcessOverTime, songId ");
            MusicPanel r105 = this.f70026a.f70024d;
            if (r105 == null) goto L10;
            KtvMusic r106 = r105.f153577a;
            if (r106 == null) goto L10;
            Long r107 = Long.valueOf(r106.getMId());
        L11:
            r104.append(r107.longValue());
            r104.append(", title: ");
            MusicPanel r108 = this.f70026a.f70024d;
            if (r108 == null) goto L16;
            KtvMusic r109 = r108.f153577a;
            if (r109 == null) goto L16;
            r103 = r109.getMTitle();
        L16:
            r104.append(r103);
            r104.append(", type: ");
            r104.append(this.f70026a.getType());
            com.bytedance.android.live.ktv.common.util.g.a(r104.toString());
            return;
        L10:
            r107 = null;
            goto L11
        }
    }

    public abstract void c();

    @Override // com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public abstract /* synthetic */ IMusicControlNode.OperationType getType();

    @Override // com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public void a() {
        this.f70021a.clear();
        this.f70023c = null;
        if (vm2.h.q() == false) goto L12;
        Disposable r100 = this.f70022b;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isDisposed() == true) goto L14;
        Disposable r101 = this.f70022b;
        if (r101 == null) goto L15;
        r101.dispose();
        return;
    L15:
        return;
    L14:
        return;
    }

    public void d() {
        g r100 = this.f70023c;
        if (r100 == null) goto L6;
        r100.a(this);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.IMusicControlNode
    public void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f70023c = r100;
        Disposable r101 = Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        RxUtilKt.c(r101, this.f70021a);
        this.f70022b = r101;
        c();
    }

    public d(MusicPanel r100, ModeType r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r101, "modeType");
        this.f70024d = r100;
        this.f70025e = r101;
        this.f70021a = new CompositeDisposable();
    }
}
