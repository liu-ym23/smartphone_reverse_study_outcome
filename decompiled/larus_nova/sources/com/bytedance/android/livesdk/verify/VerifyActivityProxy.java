package com.bytedance.android.livesdk.verify;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import b30.g0;
import b30.h0;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJDyPayResult;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.verify.api.ZhimaVerifyApi;
import com.bytedance.android.live.core.verify.responbean.CertificationQuery;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.service.f;
import com.bytedance.android.livesdk.service.l;
import com.bytedance.android.livesdkapi.LiveActivityProxy;
import com.bytedance.android.livesdkapi.base.ILiveBrowserFragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.URLEncoder;
import java.util.List;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated(message = "using for ppx")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/verify/VerifyActivityProxy;", "Lcom/bytedance/android/livesdkapi/LiveActivityProxy;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerifyActivityProxy extends LiveActivityProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILiveBrowserFragment f159247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Fragment f159248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f159249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f159250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g0 f159251e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerifyActivityProxy f159252a;

        public a(VerifyActivityProxy r100) {
            this.f159252a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            g0 r101 = (g0) r100;
            this.f159252a.f159251e = r101;
            Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            r102.setData(UriProtector.parse("alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(r101.b())));
            VerifyActivityProxy.a(this.f159252a).startActivity(r102);
            this.f159252a.getClass();
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerifyActivityProxy f159253a;

        public b(VerifyActivityProxy r100) {
            this.f159253a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((CertificationQuery) ((Response) r100).data).getPassed() == false) goto L5;
            VerifyActivityProxy.a(this.f159253a).setResult(-1);
            VerifyActivityProxy.a(this.f159253a).finish();
            xs2.b.a().post(new h0(true));
            return;
        L5:
            xs2.b.a().post(new h0(false));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f159254a = null;

        static {
            f159254a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            xs2.b.a().post(new h0(false));
        }
    }

    @Override // com.bytedance.android.livesdkapi.LiveActivityProxy
    public final boolean onBackPressed() {
        Fragment r100 = this.f159248b;
        if (r100 == null) goto L5;
        FragmentActivity r101 = r100.getActivity();
    L6:
        if (r101 == null) goto L9;
        ILiveBrowserFragment r102 = this.f159247a;
        Intrinsics.checkNotNull(r102);
        r102.onBackPressed();
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdkapi.LiveActivityProxy
    public final void onCreate() {
        super.onCreate();
        this.mActivity.setContentView(R.layout.ttlive_activity_proxy_container);
        l.d().getClass();
        ((ObservableSubscribeProxy) ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).getCertificationEntrance().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.mActivity))).subscribe(new hu2.b(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(g0.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.mActivity))).subscribe(new a(this));
    }

    @Override // com.bytedance.android.livesdkapi.LiveActivityProxy
    public final void onResume() {
        super.onResume();
        l.d().getClass();
        ZhimaVerifyApi r100 = (ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class);
        Pair[] r101 = new Pair[2];
        g0 r102 = this.f159251e;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.c();
    L6:
        r101[0] = TuplesKt.to("zhima_token", r104);
        g0 r105 = this.f159251e;
        if (r105 == null) goto L9;
        r103 = r105.a();
    L9:
        r101[1] = TuplesKt.to(CommonCode.MapKey.TRANSACTION_ID, r103);
        ((ObservableSubscribeProxy) r100.queryCertificationResult(MapsKt.mapOf(r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.mActivity))).subscribe(new b(this), c.f159254a);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public VerifyActivityProxy(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100);
    }

    public static final /* synthetic */ FragmentActivity a(VerifyActivityProxy r100) {
        return r100.mActivity;
    }

    public static final void b(VerifyActivityProxy r100) {
        r100.getClass();
        Bundle r101 = new Bundle();
        PackageManager r102 = r100.mActivity.getPackageManager();
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r103.setData(UriProtector.parse("alipays://"));
        List<ResolveInfo> r104 = r102.queryIntentActivities(r103, 64);
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == true) goto L10;
    L12:
        String r106 = r100.f159250d;
    L13:
        r101.putBoolean("hide_nav_bar", true);
        r101.putString("url", r106);
        ILiveBrowserFragment r107 = ((IBrowserService) k.n(IBrowserService.class)).createAnnieFragmentProxy(r101);
        r100.f159247a = r107;
        Intrinsics.checkNotNull(r107);
        Fragment r108 = r107.getFragment();
        r108.setArguments(r101);
        Unit r109 = Unit.INSTANCE;
        r100.f159248b = r108;
        FragmentTransaction r110 = r100.mActivity.getSupportFragmentManager().beginTransaction();
        Fragment r111 = r100.f159248b;
        Intrinsics.checkNotNull(r111);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r110, r111, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.content_container) == true) goto L17;
        r110.replace(R.id.content_container, r111);
    L17:
        r110.commitAllowingStateLoss();
        return;
    L10:
        if (TextUtils.isEmpty(r100.f159249c) == true) goto L12;
        r106 = UriProtector.parse(r100.f159249c).buildUpon().appendQueryParameter(CJDyPayResult.EXT_K_RETURN_URL, ((f) TTLiveSDKContext.getHostService()).i().getReturnUrl()).build().toString();
        goto L13
    L5:
        if (r104.size() <= 0) goto L7;
        r105 = true;
        goto L8
    }
}
