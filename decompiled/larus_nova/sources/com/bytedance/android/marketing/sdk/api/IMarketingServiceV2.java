package com.bytedance.android.marketing.sdk.api;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/marketing/sdk/api/IMarketingServiceV2;", "", "ec-biz-marketing-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMarketingServiceV2 {

    public static final class a {
        public static /* synthetic */ void b(IMarketingServiceV2 r100, String r101, Object r102, String r110, String r111, String r112, int r113) {
            if ((r113 & 8) == 0) goto L5;
            String r103 = null;
        L7:
            if ((r113 & 16) == 0) goto L9;
            String r104 = null;
        L11:
            if ((r113 & 32) == 0) goto L13;
            String r105 = null;
        L14:
            r100.b(null, r101, r102, r103, r104, r105);
            return;
        L13:
            r105 = r112;
            goto L14
        L9:
            r104 = r111;
            goto L11
        L5:
            r103 = r110;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ String a(IMarketingServiceV2 r110, c r111, long r112, Map r113, String r114, String r115, com.bytedance.android.marketing.sdk.api.a r116, String r117, int r210) {
            if ((r210 & 2) == 0) goto L5;
            long r100 = System.currentTimeMillis();
        L7:
            if ((r210 & 4) == 0) goto L9;
            Map r101 = null;
        L11:
            if ((r210 & 8) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r210 & 16) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r210 & 32) == 0) goto L21;
            com.bytedance.android.marketing.sdk.api.a r104 = null;
        L23:
            if ((r210 & 64) == 0) goto L25;
            String r118 = null;
        L27:
            return r110.g(r111, r100, r101, r102, r103, r104, r118);
        L25:
            r118 = r117;
            goto L27
        L21:
            r104 = r116;
            goto L23
        L17:
            r103 = r115;
            goto L19
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    String a();

    void b(Context r100, String r101, Object r102, String r103, String r104, String r105);

    String c();

    Function1<Map<String, ? extends Object>, Map<String, Object>> d();

    String e(c r100, Function2<? super String, ? super String, Unit> r101);

    void f(String r100, FrameLayout r101, com.bytedance.android.marketing.sdk.api.a r102, String r103, String r104, Map<String, ? extends Object> r105);

    String g(c r100, long r101, Map<String, ? extends Object> r102, String r103, String r104, com.bytedance.android.marketing.sdk.api.a r105, String r106);

    void h(Function1<? super Map<String, ? extends Object>, ? extends Map<String, ? extends Object>> r100);
}
