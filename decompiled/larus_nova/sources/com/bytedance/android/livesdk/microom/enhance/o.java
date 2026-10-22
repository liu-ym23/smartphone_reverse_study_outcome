package com.bytedance.android.livesdk.microom.enhance;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f153875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f153876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f153877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f153878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f153879e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f153880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f153881b;

        public a(o r100, boolean r101) {
            this.f153880a = r100;
            this.f153881b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            o r102 = this.f153880a;
            boolean r103 = this.f153881b;
            r102.getClass();
            q4.b r104 = u4.c(new MicRoomRowOneFollowEnhance$startAnimation$animator$1(r102, r103));
            CompositeDisposable r105 = r102.f153879e;
            if (r105 == null) goto L5;
            RxUtilKt.c(Disposables.fromAction(new n(r104)), r105);
        L5:
            r104.c();
        }
    }

    public o() {
    }

    public final void a(boolean r100) {
        int r101 = s1.h(R.color.ttlive_white_70);
        if (r100 == false) goto L7;
        int r102 = z.f153896a;
        z.a(this.f153877c, r101);
        TextView r103 = this.f153878d;
        if (r103 == null) goto L11;
        r103.setTextColor(-1);
        return;
    L11:
        return;
    L7:
        int r104 = z.f153896a;
        z.a(this.f153877c, -1);
        TextView r105 = this.f153878d;
        if (r105 == null) goto L13;
        r105.setTextColor(r101);
        return;
    }

    public final void b(boolean r100) {
        CompositeDisposable r101 = this.f153879e;
        if (r101 == null) goto L6;
        RxUtilKt.c(Observable.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r100)), r101);
        return;
    }
}
