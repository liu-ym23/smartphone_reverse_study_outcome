package com.bytedance.android.live.liveinteract.api;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.ui.c;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import gd0.k;

/* JADX INFO: loaded from: classes46.dex */
public abstract class BaseLinkMultiControlWidget extends BaseMultiLinkWidget implements ILinkControlWidget, k {

    public interface a {
        void A4();

        View c();

        View j();

        void k(Widget r100);

        c y4();

        Widget z4(int r100, String r101);
    }

    @Override // gd0.k
    public void a(View r100, MotionEvent r101) {
    }

    public abstract void h0(IRoom r100);

    @Override // gd0.k
    public abstract void k(String r100, ye1.a r101);

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    public abstract void p3(IRoom r100);

    @Override // gd0.k
    public abstract void pi();

    @Override // kf1.a
    public String tag() {
        return "BaseLinkMultiControlWidget";
    }

    public abstract void wq();

    public BaseLinkMultiControlWidget() {
    }

    @Override // kf1.a
    public CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }
}
