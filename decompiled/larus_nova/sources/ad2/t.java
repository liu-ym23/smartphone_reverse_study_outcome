package ad2;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bduploader.BDImageUploader;
import com.ss.bduploader.BDVideoUploader;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "uploadMedia")
public final class t extends ad2.a<c0, UploadMediaResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f2999a;

    public static final class a {
    }

    static {
    }

    public t() {
        this.f2999a = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        this.f2999a.dispose();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r210, CallContext r211) {
        c0 r100 = (c0) r210;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Intrinsics.areEqual(r100.c(), "image") == true) goto L5;
    L19:
        String r101 = null;
        if (Intrinsics.areEqual(r100.c(), "video") == false) goto L40;
        if (Intrinsics.areEqual(r100.f(), Boolean.TRUE) == false) goto L40;
        c0.a r102 = r100.a();
        k r110 = new k();
        Boolean r111 = r100.d();
        List<String> r103 = r100.b();
        if (r103 == null) goto L26;
        r101 = (String) ListProtector.get(r103, 0);
    L26:
        String r112 = r101;
        CallContext r104 = getCallContext();
        Intrinsics.checkNotNullParameter(r104, "callContext");
        if (r102 == null) goto L38;
        String r113 = r102.a();
        String r114 = r102.b();
        String r115 = r102.d();
        String r116 = r102.c();
        if (r112 == null) goto L36;
        if (r113 == null) goto L36;
        if (r114 == null) goto L36;
        if (r115 == null) goto L36;
        if (r116 == null) goto L36;
        BDVideoUploader r105 = new BDVideoUploader();
        RxUtilKt.c(RxUtilKt.i(Single.create(new r(r110, r112, r105, r113, r114, r115, r116, r111, r104)).doOnDispose(new s(r105))).subscribe(new w(this), new x(this)), this.f2999a);
        return;
    L36:
        throw new Throwable("some params is empty");
    L38:
        throw new Throwable("imageAuthInfo null");
    L40:
        if (Intrinsics.areEqual(r100.c(), "video") == false) goto L70;
        List<String> r106 = r100.b();
        if (r106 == null) goto L44;
        String r117 = (String) CollectionsKt.first(r106);
    L45:
        c0.a r107 = r100.a();
        if (r107 == null) goto L48;
        String r118 = r107.a();
    L49:
        c0.a r108 = r100.a();
        if (r108 == null) goto L52;
        String r119 = r108.b();
    L53:
        c0.a r109 = r100.a();
        if (r109 == null) goto L56;
        String r120 = r109.d();
    L57:
        c0.a r121 = r100.a();
        if (r121 == null) goto L60;
        r101 = r121.c();
    L60:
        String r122 = r101;
        String r123 = r100.g();
        if (r117 == null) goto L68;
        if (r118 == null) goto L68;
        if (r119 == null) goto L68;
        if (r120 == null) goto L68;
        if (r122 == null) goto L68;
        c r124 = new c();
        com.bytedance.android.livesdk.jsbridge.methods.upload.models.c r125 = new com.bytedance.android.livesdk.jsbridge.methods.upload.models.c(r118, r119, r120, r122, r123);
        CallContext r126 = getCallContext();
        Intrinsics.checkNotNullParameter(r117, "path");
        Intrinsics.checkNotNullParameter(r125, "videoUploadConfig");
        Intrinsics.checkNotNullParameter(r126, "callContext");
        BDVideoUploader r127 = new BDVideoUploader();
        RxUtilKt.c(RxUtilKt.h(Observable.create(new i(r124, r117, r127, r125, r126)).doOnDispose(new j(r127)).subscribeOn(Schedulers.io())).subscribe(new y(this), new z(this)), this.f2999a);
        return;
    L68:
        finishWithFailure(new Throwable("some params is empty"));
        return;
    L56:
        r120 = null;
        goto L57
    L52:
        r119 = null;
        goto L53
    L48:
        r118 = null;
        goto L49
    L44:
        r117 = null;
        goto L45
    L70:
        if (Intrinsics.areEqual(r100.c(), "image") == false) goto L77;
        String r128 = r100.e();
        List<String> r129 = r100.b();
        if (r128 == null) goto L76;
        if (r129 == null) goto L76;
        CallContext r130 = getCallContext();
        Intrinsics.checkNotNullParameter(r128, "uploadPath");
        Intrinsics.checkNotNullParameter(r129, "uploadFilePathList");
        Intrinsics.checkNotNullParameter(r130, "callContext");
        RxUtilKt.c(RxUtilKt.i(Observable.fromIterable(r129).observeOn(Schedulers.io()).flatMap(new f(r128, new AtomicInteger(0), r130, r129.size()), 3).toList().map(new h(r129))).subscribe(new a0(this), new b0(this)), this.f2999a);
        return;
    L76:
        finishWithFailure(new Throwable("some params is empty"));
        return;
    L77:
        finishWithFailure(new Throwable("unknown type"));
        return;
    L5:
        if (Intrinsics.areEqual(r100.f(), Boolean.TRUE) == false) goto L19;
        c0.a r131 = r100.a();
        k r132 = new k();
        Boolean r133 = r100.d();
        List<String> r134 = r100.b();
        CallContext r135 = getCallContext();
        Intrinsics.checkNotNullParameter(r135, "callContext");
        if (r131 == null) goto L18;
        String r136 = r131.a();
        String r137 = r131.b();
        String r138 = r131.d();
        String r139 = r131.c();
        if (r134 == null) goto L16;
        if (r136 == null) goto L16;
        if (r137 == null) goto L16;
        if (r138 == null) goto L16;
        if (r139 == null) goto L16;
        BDImageUploader r140 = new BDImageUploader();
        RxUtilKt.c(RxUtilKt.i(Observable.create(new n(r132, r140, r134, r136, r137, r138, r139, r133, r135)).doOnDispose(new o(r140)).toList().map(q.f2988a).subscribeOn(Schedulers.io())).subscribe(new u(this), new v(this)), this.f2999a);
        return;
    L16:
        throw new Throwable("some params is empty");
    L18:
        throw new Throwable("imageAuthInfo null");
    }
}
