package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdk.message.model.t;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends CommonTabHolder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f99949i = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f99950h;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.a$a, reason: collision with other inner class name */
    public static final class C1528a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final w91.a g() {
        return new r91.c();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        View r100 = this.f99933f.findViewById(R.id.tv_common_text);
        if ((r100 instanceof TextView) == true) goto L5;
        r100 = null;
    L5:
        this.f99950h = (TextView) r100;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r100) {
        if (r100 == null) goto L5;
        tlc.d r101 = r100.f549202e;
    L7:
        if ((r101 instanceof t) == true) goto L9;
        r101 = null;
    L9:
        t r102 = (t) r101;
        if (r102 != null) goto L13;
        return;
    L13:
        if (r100.f549200c != 1) goto L18;
        Text r103 = r102.topText;
        if (r103 == null) goto L24;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.f141015a.getClass();
        r.f141035g.d(r103, null, new y(0.0f), new b(this));
        return;
    L24:
        return;
    L18:
        Text r104 = r102.bottomText;
        if (r104 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.f141015a.getClass();
        r.f141035g.d(r104, null, new y(0.0f), new b(this));
        return;
    L25:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public a(IRoom r100, DataCenter r101, View r102) {
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "itemView");
        super(r100, r101, r102);
    }
}
