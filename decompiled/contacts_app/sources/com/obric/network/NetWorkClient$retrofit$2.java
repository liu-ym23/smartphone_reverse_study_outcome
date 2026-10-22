package com.obric.network;

import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.settings.SettingsProviderHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: NetWorkClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/retrofit2/Retrofit;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class NetWorkClient$retrofit$2 extends Lambda implements Function0<Retrofit> {
    final /* synthetic */ NetWorkClient this$0;

    public static /* synthetic */ SsResponse $r8$lambda$EOEzF88tZrbLbLhZk44AJup0JY4(Interceptor.Chain r0) {
        return invoke$lambda$2$lambda$1(r0);
    }

    NetWorkClient$retrofit$2(NetWorkClient r1) {
        this.this$0 = r1;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Retrofit invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Retrofit invoke() {
        Retrofit r0 = RetrofitUtils.getSsRetrofit(NetWorkClient.access$getBaseUrl$p(this.this$0));
        Iterator r3 = NetWorkClient.access$getInterceptors$p(this.this$0).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Interceptor r1 = (Interceptor) r3.next();
        r0.interceptors().add(r1);
        goto L4
    L6:
        r0.interceptors().add(new NetWorkClient$retrofit$2$$ExternalSyntheticLambda0());
        return r0;
    }

    private static final SsResponse invoke$lambda$2$lambda$1(Interceptor.Chain r7) {
        Request r0 = r7.request();
        List<Header> r1 = r0.getHeaders();
        Intrinsics.checkNotNullExpressionValue(r1, "original.headers");
        List<Header> r2 = CollectionsKt.toMutableList(r1);
        SettingsProviderHelper r3 = SettingsProviderHelper.INSTANCE;
        ContactsApplication r4 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r4, "getInstance()");
        boolean r5 = false;
        boolean r6 = r3.getUsePpe(r4, false);
        SettingsProviderHelper r8 = SettingsProviderHelper.INSTANCE;
        ContactsApplication r9 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r9, "getInstance()");
        String r10 = r8.getPpeName(r9);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NetWorkClient.TAG, "isUsePpe: " + r6 + ", ppeName: " + r10);
        if (r6 == false) goto L11;
        String r11 = r10;
        if (r11 != null) goto L7;
    L8:
        r5 = true;
    L9:
        if (r5 == true) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NetWorkClient.TAG, "add header");
        r2.add(new Header(NetWorkClient.HEADER_USE_PPE, "1"));
        r2.add(new Header(NetWorkClient.HEADER_TT_ENV, r10));
    L13:
        return r7.proceed(r0.newBuilder().headers(r2).build());
    L7:
        if (r11.length() != 0) goto L9;
    L11:
        r2.add(new Header(NetWorkClient.HEADER_USE_PPE, "0"));
        goto L13
    }
}
