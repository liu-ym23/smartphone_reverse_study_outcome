package bw;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.gamecp.host_api.service.IBaseHostService;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public interface b extends IBaseHostService {
    Activity A1();

    void G1(Context r100, String r101, String r102, Map r103, Map r104, Map r105, com.bytedance.android.gamecp.business.props.k r106);

    void M0(Activity r100);

    String P();

    void V1(Context r100, String r101, int r102);

    void X1(com.bytedance.android.gamecp.host_api.model.i r100);

    Activity c0();

    void centerToast(Context r100, String r101, int r102);

    void f1();

    Activity[] getActivityStack();

    Activity getCurrentActivity();

    float getDeviceScore();

    void getFontScale();

    Activity getMainActivity();

    Map<String, String> getNQEParams();

    String getSessionId();

    Activity getTopActivity();

    void h0(Context r100, dw.l r101);

    boolean isAppBackground();

    void m2(Function1 r100);

    void y0(dw.d r100);
}
