package com.bytedance.android.livesdk.announcement.time;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.f2;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementTimeSelectWidget f103585a;

    public a(AnnouncementTimeSelectWidget r100) {
        this.f103585a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if ((r100 instanceof TextView) == false) goto L24;
        TextView r101 = (TextView) r100;
        if ((r101.getTag() instanceof com.bytedance.android.livesdk.announce.d) == false) goto L25;
        Object r102 = r101.getTag();
        if ((r102 instanceof com.bytedance.android.livesdk.announce.d) == true) goto L9;
        r102 = null;
    L9:
        com.bytedance.android.livesdk.announce.d r103 = (com.bytedance.android.livesdk.announce.d) r102;
        if (r103 == null) goto L20;
        r103.f103140b = !r103.f103140b;
        if (((ArrayList) this.f103585a.f103553h).isEmpty() == false) goto L17;
        if (r103.f103140b == false) goto L17;
        f2.c("已选周期性开播，单场日期选择失效", 0);
    L17:
        if (r103.f103140b == false) goto L19;
        ((ArrayList) this.f103585a.f103553h).add(r103);
        goto L20
    L19:
        ((ArrayList) this.f103585a.f103553h).remove(r103);
    L20:
        this.f103585a.zq(r101);
        this.f103585a.yq();
        AnnouncementTimeSelectWidget.a r104 = this.f103585a.f103550e;
        if (r104 == null) goto L26;
        r104.a();
        return;
    L26:
        return;
    L25:
        return;
    }
}
