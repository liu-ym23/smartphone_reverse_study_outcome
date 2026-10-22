package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.live.browser.jsbridge.newmethods.ic;
import com.bytedance.android.live.browser.jsbridge.newmethods.m2;
import com.bytedance.android.live.browser.jsbridge.newmethods.p2;
import com.bytedance.android.live.browser.jsbridge.newmethods.r9;
import com.bytedance.android.live.browser.jsbridge.newmethods.z7;
import com.bytedance.android.live.browser.jsbridge.newmethods.za;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class t extends BaseJsBridgeMethodFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f63973a = null;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f63974a = null;

        static {
            f63974a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new p2();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f63975a = null;

        static {
            f63975a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new r9();
        }
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideStatefulCacheableMethods() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("doDouyinAuth", a.f63974a), TuplesKt.to("getPhoneNumber", b.f63975a)});
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> provideStatelessCacheableMethods() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("destroyRoomInfoBanner", new m2()), TuplesKt.to("setRoomInfoBannerSize", new ic()), TuplesKt.to("reportAuth", new za()), TuplesKt.to("updateUnreadCount", new z7())});
    }

    static {
        f63973a = new t();
    }

    public t() {
    }
}
