package com.bytedance.android.live.profit.player;

import android.app.Activity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f88348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f88349b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f88350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f88351b;

        public a(Activity r100, String r101) {
            this.f88350a = r100;
            this.f88351b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ((com.bytedance.android.livesdk.revenue.service.interactivity.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class)).fk(this.f88350a, this.f88351b);
        }
    }

    public p(CompositeDisposable r100) {
        Intrinsics.checkNotNullParameter(r100, "cd");
        this.f88349b = r100;
        this.f88348a = 1;
    }

    public static boolean a(IBaseUser r100) {
        String r101 = r100.getIdString();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r100.getIdString(), ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId()) == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        r102 = false;
        goto L8
    }

    public final void b(IBaseUser r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "triggerUser");
        Intrinsics.checkNotNullParameter(r101, "schema");
        boolean r102 = false;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        if (a(r100) == false) goto L28;
        ALogger.i("OpenAsset", "opening schema: schema=".concat(r101));
        String r104 = UriProtector.parse(r101).getHost();
        if (r104 != null) goto L14;
    L20:
        Activity r105 = com.bytedance.android.live.core.utils.a.d();
        if (r105 == null) goto L23;
        r102 = ((pq2.a) vh6.c.b(pq2.a.class)).handleSchema(r105, r101);
    L23:
        if (r102 == true) goto L27;
        ALogger.e("OpenAsset", "open schema failed: context=" + r105 + ", schema=" + r101);
        return;
    L27:
        return;
    L14:
        if (r104.hashCode() != (-98539011)) goto L20;
        if (r104.equals(SchemaHandlerHostConstants.USER_PROFILE_SCHEMA_HOST) == false) goto L20;
        ALogger.i("OpenAsset", "is profile schema");
        ((com.bytedance.android.livesdk.revenue.service.interactivity.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class)).Xn();
        return;
    L28:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void c(IBaseUser r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "triggerUser");
        Intrinsics.checkNotNullParameter(r101, "schema");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        if (a(r100) == false) goto L25;
        ALogger.i("OpenAsset", "preparing schema: schema=".concat(r101));
        String r103 = UriProtector.parse(r101).getHost();
        if (r103 != null) goto L14;
        return;
    L14:
        if (r103.hashCode() == (-98539011)) goto L17;
        return;
    L17:
        if (r103.equals(SchemaHandlerHostConstants.USER_PROFILE_SCHEMA_HOST) == false) goto L24;
        ALogger.i("OpenAsset", "is profile schema");
        Activity r104 = com.bytedance.android.live.core.utils.a.d();
        if (r104 != null) goto L21;
        return;
    L21:
        RxUtilKt.c(Observable.timer(this.f88348a, TimeUnit.SECONDS).subscribe(new a(r104, r101)), this.f88349b);
        return;
    L24:
        return;
    L25:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
