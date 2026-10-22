package com.bytedance.android.shopping.store.lifecycle;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.preload.resource.PageType;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public interface c {

    public static final class a {
        public static void b(StoreTabConfig r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "tabConfig");
            Intrinsics.checkNotNullParameter(r101, "metaInfo");
        }

        public static void c(ECStoreParam r100, com.bytedance.android.shopping.store.home.entity.n r101, CommerceBaseResponse r102) {
            Intrinsics.checkNotNullParameter(r100, "storeParam");
            Intrinsics.checkNotNullParameter(r101, "infoData");
            Intrinsics.checkNotNullParameter(r102, "response");
        }

        public static void e(ECStoreViewModel r100, ECStoreParam r101) {
            Intrinsics.checkNotNullParameter(r100, "viewModel");
            Intrinsics.checkNotNullParameter(r101, "storeParam");
        }

        public static void f(ECStoreParam r100, PageType r101) {
            Intrinsics.checkNotNullParameter(r100, "storeParam");
            Intrinsics.checkNotNullParameter(r101, "pageType");
        }

        public static void g(ECStoreViewModel r100, ECStoreParam r101) {
            Intrinsics.checkNotNullParameter(r100, "viewModel");
            Intrinsics.checkNotNullParameter(r101, "storeParam");
        }

        public static void i(Context r100, ECStoreParam r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "storeParam");
        }

        public static void j(ECStoreParam r100, ECStoreTabAreaVO r101, ECStoreHomeTabResponseTabkit r102) {
            Intrinsics.checkNotNullParameter(r100, "storeParam");
            Intrinsics.checkNotNullParameter(r101, "tabData");
            Intrinsics.checkNotNullParameter(r102, "response");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(m r100, String r101, Map r102, JSONObject r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = null;
        L8:
            r100.P(r101, r102, r103);
        }

        public static /* synthetic */ void h(m r100, ECStoreViewModel r110, StoreTabConfig r111, ECStoreParam r112, JSONObject r113, JSONObject r114, int r115) {
            if ((r115 & 8) == 0) goto L5;
            JSONObject r101 = null;
        L7:
            if ((r115 & 16) == 0) goto L9;
            JSONObject r102 = null;
        L10:
            r100.E(r110, r111, r112, r101, r102, false);
            return;
        L9:
            r102 = r114;
            goto L10
        L5:
            r101 = r113;
            goto L7
        }

        public static /* synthetic */ void d(m r110, StoreTabConfig r111, int r112, int r113, Integer r114, Integer r115, String r116, String r117, String r210, int r211) {
            if ((r211 & 8) == 0) goto L5;
            Integer r100 = null;
        L7:
            if ((r211 & 16) == 0) goto L9;
            Integer r101 = null;
        L11:
            if ((r211 & 32) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r211 & 64) == 0) goto L17;
            String r118 = null;
        L19:
            if ((r211 & 128) == 0) goto L21;
            String r119 = null;
        L22:
            r110.D(r111, r112, r113, r100, r101, r102, r118, r119);
            return;
        L21:
            r119 = r210;
            goto L22
        L17:
            r118 = r117;
            goto L19
        L13:
            r102 = r116;
            goto L15
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r114;
            goto L7
        }
    }

    void A(ECStoreParam r100);

    void B(Context r100, ECStoreParam r101, JSONObject r102, PageType r103);

    void C();

    void D(StoreTabConfig r100, int r101, int r102, Integer r103, Integer r104, String r105, String r106, String r107);

    void E(ECStoreViewModel r100, StoreTabConfig r101, ECStoreParam r102, JSONObject r103, JSONObject r104, boolean r105);

    void F(uj3.j r100, long r101);

    void G(ECStoreParam r100, ECStoreTabAreaVO r101, ECStoreHomeTabResponseTabkit r102);

    void H();

    void I(StoreTabConfig r100, Map<String, Object> r101);

    void J(ECStoreViewModel r100, ECStoreParam r101, int r102);

    void K();

    void L(f r100);

    void M(int r100, int r101);

    void N(StoreTabConfig r100);

    void O();

    void P(String r100, Map<String, ? extends Object> r101, JSONObject r102);

    void Q(ECStoreParam r100);

    void R(StoreTabConfig r100);

    void S(int r100, ECHybridListAdapter r101);

    void T();

    void a();

    void b();

    void c(StoreTabConfig r100);

    void d(Throwable r100, CommerceBaseResponse r101);

    void e(StoreTabConfig r100);

    void f();

    void g();

    void h(ECStorePreloadInfoResponse r100);

    void i(StoreTabConfig r100);

    void j();

    void k(StoreTabConfig r100);

    void l();

    void m(Context r100);

    void n();

    void o(ECShopHeadInfoBlock r100);

    void onPause();

    void onResume(Context r100);

    void p(StoreTabConfig r100, JSONObject r101, String r102);

    void q(Context r100, ECStoreParam r101);

    void r(int r100, int r101);

    void s(StoreTabConfig r100);

    void t();

    void u(ECStoreParam r100, com.bytedance.android.shopping.store.home.entity.n r101, CommerceBaseResponse r102);

    void v();

    void w();

    void x(StoreTabConfig r100);

    void y();

    void z(ECStorePreloadInfoResponse r100);
}
