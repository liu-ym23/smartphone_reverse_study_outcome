package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.store.utils.taskmanager.ExecutorType;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Url;
import com.larus.apm.impl.protector.RunnableProtector;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedLottieUrlLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f173622a = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bb\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/lottie/DeepFeedLottieUrlLoader$DeepFeedLottieUrlApi;", "", "getRawJson", "Lcom/bytedance/retrofit2/Call;", "", "url", "maxLength", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface DeepFeedLottieUrlApi {
        @GET
        Call<String> getRawJson(@Url String r100, @MaxLength int r101);
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Call<String> f173623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f173624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<String, Unit> f173625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<Throwable, Unit> f173626d;

        public final void a() {
            n r100 = n.f48128a;     // Catch: Throwable -> L13
            int r101 = DeepFeedLottieUrlLoader.f173622a;     // Catch: Throwable -> L13
            Call<String> r102 = ((DeepFeedLottieUrlApi) r100.create(DeepFeedLottieUrlLoader.a(this.f173624b), DeepFeedLottieUrlApi.class)).getRawJson(this.f173624b, Integer.MAX_VALUE);     // Catch: Throwable -> L13
            this.f173623a = r102;     // Catch: Throwable -> L13
            SsResponse<String> r103 = r102.execute();     // Catch: Throwable -> L13
            int r104 = r103.code();     // Catch: Throwable -> L13
            if (200 > r104) goto L12;
            if (299 < r104) goto L12;
            String r105 = r103.body();     // Catch: Throwable -> L13
            if (r105 != null) goto L10;
            r105 = "";
        L10:
            this.f173625c.invoke(r105);     // Catch: Throwable -> L13
            return;
        L12:
            throw new IllegalStateException("unexpected response code=" + r103.code());     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            this.f173626d.invoke(th);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, Function1<? super String, Unit> r101, Function1<? super Throwable, Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "onSuccess");
            Intrinsics.checkNotNullParameter(r102, "onFailure");
            this.f173624b = r100;
            this.f173625c = r101;
            this.f173626d = r102;
        }
    }

    public DeepFeedLottieUrlLoader() {
    }

    static {
    }

    public static final String a(String r100) {
        URI r101 = new URI(r100);
        String r102 = r101.getScheme();
        if (r102 == null) goto L11;
        String r103 = r101.getAuthority();
        if (r103 == null) goto L9;
        return r102 + "://" + r103 + '/';
    L9:
        throw new IllegalArgumentException("authority is null");
    L11:
        throw new IllegalArgumentException("scheme is null");
    }

    public static a b(String r100, Function1 r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "onFailure");
        final a r103 = new a(r100, r101, r102);
        int r104 = com.bytedance.android.ec.store.utils.taskmanager.c.f48696c;
        com.bytedance.android.ec.store.utils.taskmanager.c.b.f48699a.a(ExecutorType.IO, new DeepFeedLottieUrlLoader$loadRawJsonFromUrl$1(r103));
        return r103;
    }
}
