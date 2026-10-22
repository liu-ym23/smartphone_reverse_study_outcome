package com.bytedance.android.ec.model.order;

import com.bytedance.android.ec.common.impl.order.OrderSchema;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.shopping.buynow.cache.a;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import nl.c;
import nl.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/model/order/IOrderSchema;", "Lnl/c;", "Lcom/bytedance/android/ec/model/abscontainer/ISkuBuySchemaModel;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public interface IOrderSchema extends c, ISkuBuySchemaModel {
    JSONObject A0();

    JSONObject B();

    boolean C();

    void G(Function0<Unit> r100);

    @Deprecated(message = "pass_through下线")
    String H();

    OrderSchema.b P();

    OrderSchema.b P0();

    Object Q();

    boolean Q0();

    void T(JSONObject r100);

    EntranceInfoScene W0();

    void X(a r100);

    void Y0(f r100);

    String getHost();

    void h0();

    f i1();

    void j1();

    @Deprecated(message = "pass_through下线")
    void k0(String r100, String r101, int r102);

    String m0();

    void m1(JSONObject r100);

    JSONObject q1();

    String r0(Set<String> r100);

    void t0(String r100, Object r101);

    boolean u();

    JSONObject u0();

    @Deprecated(message = "pass_through下线")
    void v1(List<String> r100, String r101);

    boolean x1();

    void z0();
}
