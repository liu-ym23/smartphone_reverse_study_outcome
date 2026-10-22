package com.obric.network;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: NetWorkClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u00012B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u0013\u001a\u0002H\u0014\"\u0006\b\u0000\u0010\u0014\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\u0015J\u0087\u0001\u0010\u0016\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u00142\u0014\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u001a0\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00170\u001c2O\u0010\u001d\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110$¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00170\u001eJ)\u0010&\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0014\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u001a0\u0019¢\u0006\u0002\u0010'J6\u0010(\u001a\u00020\u0017\"\b\b\u0000\u0010\u0014*\u00020)2\u0016\u0010\u0018\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0018\u00010\u001a0\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00140+J$\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u00063"}, d2 = {"Lcom/obric/network/NetWorkClient;", "", "baseUrl", "", "handlerThread", "Landroid/os/HandlerThread;", "interceptors", "", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "(Ljava/lang/String;Landroid/os/HandlerThread;Ljava/util/List;)V", "handler", "Landroid/os/Handler;", "retrofit", "Lcom/bytedance/retrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getRetrofit", "()Lcom/bytedance/retrofit2/Retrofit;", "retrofit$delegate", "Lkotlin/Lazy;", "createService", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "executeAsyncRequest", "", "callFactory", "Lkotlin/Function0;", "Lcom/bytedance/retrofit2/Call;", "success", "Lkotlin/Function1;", "failure", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", AccountConst.KEY_ERROR_CODE, AccountConst.KEY_ERROR_MSG, "", NotificationCompat.CATEGORY_ERROR, "executeRequest", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "executeStreamingRequest", "Lcom/bytedance/retrofit2/mime/TypedInput;", "callback", "Lcom/obric/network/StreamingCallback;", "uploadFile", "Lokhttp3/MultipartBody$Part;", "file", "Ljava/io/File;", "partName", "mediaType", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NetWorkClient {
    public static final Companion Companion = null;
    public static final String HEADER_TT_ENV = "x-tt-env";
    public static final String HEADER_USE_PPE = "x-use-ppe";
    public static final String HEADER_VALUE_NOT_USE = "0";
    public static final String HEADER_VALUE_USE = "1";
    public static final String TAG = "NetWorkClient";
    private final String baseUrl;
    private final Handler handler;
    private final HandlerThread handlerThread;
    private final List<Interceptor> interceptors;
    private final Lazy retrofit$delegate;

    /* JADX INFO: compiled from: NetWorkClient.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/network/NetWorkClient$Companion;", "", "()V", "HEADER_TT_ENV", "", "HEADER_USE_PPE", "HEADER_VALUE_NOT_USE", "HEADER_VALUE_USE", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$4W896bUXEAmK6dCfhTzgmFkx7is(Function0 r0, Function1 r1, Function3 r2) {
        executeAsyncRequest$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$BofcBu5hAxJ1NVQkXqXv4nmzGjc(Function0 r0, StreamingCallback r1) {
        executeStreamingRequest$lambda$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$E1IZ2n8MBwb6DKXAl2FdlIOSyfw(Ref.ObjectRef r0, String r1, File r2) {
        uploadFile$lambda$1(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetWorkClient(String r2, HandlerThread r3, List<? extends Interceptor> r4) {
        Intrinsics.checkNotNullParameter(r2, "baseUrl");
        Intrinsics.checkNotNullParameter(r3, "handlerThread");
        Intrinsics.checkNotNullParameter(r4, "interceptors");
        this.baseUrl = r2;
        this.handlerThread = r3;
        this.interceptors = r4;
        this.handler = new Handler(r3.getLooper());
        this.retrofit$delegate = LazyKt.lazy(new NetWorkClient$retrofit$2(this));
    }

    public static final /* synthetic */ String access$getBaseUrl$p(NetWorkClient r0) {
        return r0.baseUrl;
    }

    public static final /* synthetic */ List access$getInterceptors$p(NetWorkClient r0) {
        return r0.interceptors;
    }

    public /* synthetic */ NetWorkClient(String r1, HandlerThread r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = CollectionsKt.emptyList();
    L5:
        this(r1, r2, r3);
    }

    public final Retrofit getRetrofit() {
        return (Retrofit) this.retrofit$delegate.getValue();
    }

    public final /* synthetic */ <T> T createService() {
        Retrofit r2 = getRetrofit();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) r2.create(Object.class);
    }

    public final <T> T executeRequest(Function0<? extends Call<T>> r5) {
        Intrinsics.checkNotNullParameter(r5, "callFactory");
        final CountDownLatch r0 = new CountDownLatch(1);
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        executeAsyncRequest(r5, new AnonymousClass1(r0, r1), new AnonymousClass2(r0));
        r0.await();
        return r1.element;
    }

    public final <T> void executeAsyncRequest(final Function0<? extends Call<T>> r2, final Function1<? super T, Unit> r3, final Function3<? super Integer, ? super String, ? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "callFactory");
        Intrinsics.checkNotNullParameter(r3, "success");
        Intrinsics.checkNotNullParameter(r4, "failure");
        this.handler.post(new NetWorkClient$$ExternalSyntheticLambda0(r2, r3, r4));
    }

    private static final void executeAsyncRequest$lambda$0(Function0 r5, Function1 r6, Function3 r7) {
        Intrinsics.checkNotNullParameter(r5, "$callFactory");
        Intrinsics.checkNotNullParameter(r6, "$success");
        Intrinsics.checkNotNullParameter(r7, "$failure");
        Call r8 = (Call) r5.invoke();     // Catch: Exception -> L28
        if (r8 == null) goto L6;
        SsResponse r9 = r8.execute();     // Catch: Exception -> L28
    L7:
        boolean r2 = false;
        if (r9 != null) goto L10;
    L12:
        if (r2 == false) goto L14;
        Object r10 = r9.body();     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L28
        r6.invoke(r10);     // Catch: Exception -> L28
        return;
    L14:
        if (r9 == null) goto L16;
        Integer r11 = Integer.valueOf(r9.code());     // Catch: Exception -> L28
    L17:
        if (r9 == null) goto L21;
        TypedInput r3 = r9.errorBody();     // Catch: Exception -> L28
        if (r3 == null) goto L21;
        String r4 = r3.toString();     // Catch: Exception -> L28
    L22:
        StringBuilder r12 = new StringBuilder("executeAsyncRequest exception: ");     // Catch: Exception -> L28
        if (r9 == null) goto L25;
        Integer r13 = Integer.valueOf(r9.code());     // Catch: Exception -> L28
    L26:
        r7.invoke(r11, r4, new Throwable(r12.append(r13).toString()));     // Catch: Exception -> L28
        return;
    L25:
        r13 = null;
    L21:
        r4 = null;
        goto L22
    L16:
        r11 = null;
        goto L17
    L10:
        if (r9.isSuccessful() != true) goto L12;
        r2 = true;
        goto L12
    L6:
        r9 = null;
    L28:
        e = move-exception;
        r7.invoke(null, null, e);
    }

    public static /* synthetic */ MultipartBody.Part uploadFile$default(NetWorkClient r0, File r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "file";
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = "audio/mpeg";
    L9:
        return r0.uploadFile(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final MultipartBody.Part uploadFile(final File r4, String r5, final String r6) {
        Intrinsics.checkNotNullParameter(r4, "file");
        Intrinsics.checkNotNullParameter(r5, "partName");
        Intrinsics.checkNotNullParameter(r6, "mediaType");
        CountDownLatch r0 = new CountDownLatch(1);
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        this.handler.post(new NetWorkClient$$ExternalSyntheticLambda2(r1, r6, r4));
        r0.await();
        RequestBody r3 = (RequestBody) r1.element;
        if (r3 != null) goto L7;
        return null;
    L7:
        return MultipartBody.Part.createFormData(r5, r4.getName(), r3);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, okhttp3.RequestBody] */
    private static final void uploadFile$lambda$1(Ref.ObjectRef r1, String r2, File r3) {
        Intrinsics.checkNotNullParameter(r1, "$requestFile");
        Intrinsics.checkNotNullParameter(r2, "$mediaType");
        Intrinsics.checkNotNullParameter(r3, "$file");
        r1.element = RequestBody.create(MediaType.parse(r2), r3);
    }

    public final <T extends TypedInput> void executeStreamingRequest(final Function0<? extends Call<T>> r2, final StreamingCallback<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "callFactory");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.handler.post(new NetWorkClient$$ExternalSyntheticLambda1(r2, r3));
    }

    private static final void executeStreamingRequest$lambda$3(Function0 r1, final StreamingCallback r2) {
        Intrinsics.checkNotNullParameter(r1, "$callFactory");
        Intrinsics.checkNotNullParameter(r2, "$callback");
        Call r3 = (Call) r1.invoke();
        if (r3 == null) goto L6;
        r3.enqueue(new NetWorkClient$executeStreamingRequest$1$1(r2));
        return;
    }
}
