package com.bytedance.android.live.revlink.impl.service.internal;

import com.bytedance.android.live.revlink.impl.control.launchcontext.RevLinkSwitchExtraContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, int r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            r102 = false;
        L5:
            r100.ui(r101, r102, false);
        }
    }

    void Ak(String r100);

    void Gp(int r100, RevLinkSwitchExtraContext r101);

    void Pg();

    void Rg(String r100);

    void Sa();

    int Wp();

    boolean dc();

    int getCurrentMode();

    JSONObject hn(List<String> r100);

    boolean k0(int r100);

    void m();

    void onMultiAnchorStateChange(int r100);

    void onPrecisionMatchEvent(int r100);

    void startSwitchPk(g r100);

    void tn(Function0<Unit> r100, String r101, boolean r102);

    void ui(int r100, boolean r101, boolean r102);
}
