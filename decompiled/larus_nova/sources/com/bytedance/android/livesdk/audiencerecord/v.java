package com.bytedance.android.livesdk.audiencerecord;

import com.bytedance.android.livesdk.audiencerecord.api.LiveAudienceBackRecordApi;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.utils.RetrofitUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class v<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f104076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f104077b;

    public static final class a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Call f104078a;

        public a(Call r100) {
            this.f104078a = r100;
        }

        @Override // ttc.c
        public final void cancel() {
            this.f104078a.cancel();
        }
    }

    public static final class b implements Callback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f104079a;

        public b(ObservableEmitter r100) {
            this.f104079a = r100;
        }

        @Override // com.bytedance.retrofit2.Callback
        public final void onFailure(Call<String> r100, Throwable r101) {
            this.f104079a.onError(new Throwable());
        }

        @Override // com.bytedance.retrofit2.Callback
        public final void onResponse(Call<String> r100, SsResponse<String> r101) {
            ObservableEmitter r102 = this.f104079a;
            if (r101 == null) goto L6;
            String r103 = r101.body();
            if (r103 == null) goto L6;
        L7:
            r102.onNext(r103);
            this.f104079a.onComplete();
            return;
        L6:
            r103 = "";
            goto L7
        }
    }

    public v(Ref.ObjectRef r100, String r101) {
        this.f104076a = r100;
        this.f104077b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        Call<String> r101 = ((LiveAudienceBackRecordApi) RetrofitUtils.createSsService((String) this.f104076a.element, LiveAudienceBackRecordApi.class)).queryM3U8(this.f104077b);
        r100.setCancellable(new a(r101));
        r101.enqueue(new b(r100));
    }
}
