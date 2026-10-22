package com.bytedance.android.live.broadcastgame.api.toolbar;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/toolbar/GameExitBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameExitBehavior implements c0.b, Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f59429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f59430b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public GameExitBehavior(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f59430b = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == (-1755796428)) goto L12;
        return;
    L12:
        if (r102.equals("cmd_hide_other_toolbar") == false) goto L28;
        if (r101 == null) goto L16;
        Boolean r103 = (Boolean) r101.getData(Boolean.FALSE);
        if (r103 == null) goto L16;
    L18:
        if (r103.booleanValue() == false) goto L23;
        View r104 = this.f59429a;
        if (r104 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L22:
        r104.setVisibility(0);
        return;
    L23:
        View r105 = this.f59429a;
        if (r105 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L26:
        r105.setVisibility(8);
        return;
    L16:
        r103 = Boolean.FALSE;
        goto L18
    L28:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ALogger.i("GameExitBehavior", "click to exit game");
        this.f59430b.put("cmd_broadcast_game_finish", 0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        r101.removeObserver("cmd_hide_other_toolbar", this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        r101.observe("cmd_hide_other_toolbar", this);
        r100.setVisibility(8);
        this.f59429a = r100;
    }
}
