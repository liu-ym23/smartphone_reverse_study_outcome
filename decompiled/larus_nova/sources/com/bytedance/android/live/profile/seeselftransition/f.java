package com.bytedance.android.live.profile.seeselftransition;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f86166a;

    public static final class a implements OfflineResourceClient.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f86167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f86168b;

        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.a
        public final void onError(Throwable r100) {
            StringBuilder r101 = new StringBuilder("load file: ");
            r101.append(this.f86167a.f86166a);
            r101.append(" error: ");
            if (r100 == null) goto L5;
            String r102 = r100.getMessage();
        L6:
            r101.append(r102);
            ALogger.e("TransitionDialogManager", r101.toString());
            this.f86168b.onNext(sh6.a.f541970a);
            this.f86168b.onComplete();
            return;
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.a
        public final void onSuccess(String r100) {
            this.f86168b.onNext(sh6.c.a(r100));
            this.f86168b.onComplete();
        }

        public a(f r100, ObservableEmitter r101) {
            this.f86167a = r100;
            this.f86168b = r101;
        }
    }

    public f(String r100) {
        this.f86166a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<sh6.b<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        String r101 = this.f86166a;
        a r102 = new a(this, r100);
        String r103 = i2.f114501a;
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "callback");
        boolean r104 = OfflineResourceClient.f125824a;
        OfflineResourceClient.c(i2.b(r101), r102);
    }
}
