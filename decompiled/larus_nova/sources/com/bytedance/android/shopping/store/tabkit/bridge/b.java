package com.bytedance.android.shopping.store.tabkit.bridge;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.model.i;
import com.bytedance.android.shopping.store.tabkit.model.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public interface b {
    void C(i r100);

    void G(JSONObject r100, ECBaseBridgeMethod.a r101);

    void I();

    void N(int r100, String r101, JSONObject r102);

    void W(long r100);

    Result f0(int r100);

    int getScreenState();

    void j(z r100);

    void k(int r100);

    void l(String r100);

    void n(String r100);

    Object p(String r100);

    void q(String r100, Object r101);

    void s(boolean r100, long r101, long r102, int r103);

    void u(int r100, boolean r101, boolean r102);

    void z5(int r100, boolean r101);
}
