package com.bytedance.android.livesdk.action.instance;

import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.livesdk.action.ActionMethod;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@ActionMethod("webcast_inroom_showfansclub")
public class ShowFansGroupAction extends BaseActionMethod<Void> {
    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void onTerminate() {
    }

    public ShowFansGroupAction() {
    }

    @Override // com.bytedance.android.livesdk.action.BaseActionMethod
    public void invoke(Map<String, Object> r110) throws Exception {
        o r111 = yt0.c.c();
        if (r111 == null) goto L7;
        p r112 = r111.Z8(new FansClubEntranceParams(FansClubEntranceParams.Page.Default, false, "", "", "", FansClubEntranceParams.Entrance.Unspecified, false, "", null));
        if (r112 == null) goto L7;
        r112.show();
    L7:
        finishWithResult(null);
    }
}
