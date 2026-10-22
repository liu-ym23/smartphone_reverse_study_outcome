package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.view.View;
import com.bytedance.dux.radio.DuxRadio;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f61613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabPopoverFilterMenuView f61614b;

    public a(int r100, TabPopoverFilterMenuView r101) {
        this.f61613a = r100;
        this.f61614b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TabPopoverFilterMenuView r101 = this.f61614b;
        int r102 = this.f61613a;
        Iterator r103 = ((LinkedHashMap) r101.f61599k).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        int r105 = ((Number) r104.getKey()).intValue();
        DuxRadio r106 = (DuxRadio) r104.getValue();
        if (r102 != r105) goto L8;
        boolean r107 = true;
    L9:
        r106.setChecked(r107);
        goto L4
    L8:
        r107 = false;
        goto L9
    }
}
