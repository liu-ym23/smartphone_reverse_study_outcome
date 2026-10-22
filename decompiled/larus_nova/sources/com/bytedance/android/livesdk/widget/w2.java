package com.bytedance.android.livesdk.widget;

import com.bytedance.android.livesdk.message.model.vn;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class w2<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vlc.d f162220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MessageType f162221b;

    public static final class a implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f162222a;

        public a(ObservableEmitter r100) {
            this.f162222a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            if ((r100 instanceof vn) == false) goto L6;
            this.f162222a.onNext(r100);
            return;
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w2 f162223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vlc.l f162224b;

        public b(w2 r100, a r101) {
            this.f162223a = r100;
            this.f162224b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            w2 r100 = this.f162223a;
            r100.f162220a.removeMessageListener(r100.f162221b.getIntType(), this.f162224b);
        }
    }

    public w2(vlc.d r100, MessageType r101) {
        this.f162220a = r100;
        this.f162221b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        a r101 = new a(r100);
        r100.setDisposable(Disposables.fromAction(new b(this, r101)));
        this.f162220a.addMessageListener(this.f162221b.getIntType(), r101);
    }
}
