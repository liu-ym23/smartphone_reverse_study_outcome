package com.bytedance.android.livesdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.verify.api.ZhimaVerifyApi;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.eventbus.LiveRealStartEvent;
import com.bytedance.android.livesdkapi.service.ILiveAnchorCenter;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159000a = 0;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f159001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f159002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ILiveAnchorCenter f159003c;

        public a(FragmentActivity r100, String r101, ILiveAnchorCenter r102) {
            this.f159001a = r100;
            this.f159002b = r101;
            this.f159003c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((com.bytedance.android.live.base.model.verify.c) ((Response) r100).data).isVerified == false) goto L5;
            int r101 = k.f159000a;
            k.a(this.f159001a, this.f159002b);
            return;
        L5:
            int r102 = k.f159000a;
            FragmentActivity r103 = this.f159001a;
            String r104 = this.f159002b;
            ((ObservableSubscribeProxy) xs2.b.a().b(LiveRealStartEvent.class).observeOn(AndroidSchedulers.mainThread()).compose(RxUtil.bindUntilDestroy(r103)).as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(r103, Lifecycle.Event.ON_DESTROY)))).subscribe(new m(r103, r104));
            com.bytedance.android.live.core.utils.f2.c("打开主播中心，需完成开播实名", 0);
            ((IHostContext) jc1.k.n(IHostContext.class)).getXTTicket(new n(r103));
        }
    }

    public k() {
    }

    static {
    }

    public static final void a(FragmentActivity r100, String r101) {
        String r102 = LiveSettingKeys.LIVE_SCHEMA_ANCHOR_CENTER.getValue();
        if (TextUtils.isEmpty(r102) == true) goto L17;
        ILiveService r103 = TTLiveService.getLiveService();
        if (r103 == null) goto L15;
        IHostContext r104 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r104 == null) goto L10;
        int r105 = r104.appId();
    L11:
        String r106 = UriProtector.getQueryParameter(UriProtector.parse(r102), "url");
        if (r106 == null) goto L16;
        String r107 = new UrlBuilder(r106).addParam("enter_from", r101).addParam("webcast_app_id", String.valueOf(r105)).addParam("enable_broadcast", 1).build();
        r103.handleSchema(r100, UriProtector.parse(StringsKt.replace$default(r102, Uri.encode(r106), Uri.encode(r107), false, 4, null)));
        return;
    L16:
        return;
    L10:
        r105 = 0;
        goto L11
    L15:
        return;
    }

    public static void b(FragmentActivity r100, String r101, ILiveAnchorCenter r102) {
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).getCertificationStatusForSaaS(((IHostContext) jc1.k.n(IHostContext.class)).appId(), "", "").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r100, r101, r102));
    }
}
