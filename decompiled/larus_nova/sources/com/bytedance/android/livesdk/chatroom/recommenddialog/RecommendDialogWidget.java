package com.bytedance.android.livesdk.chatroom.recommenddialog;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.f;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.message.model.c2;
import com.bytedance.android.livesdk.message.model.hj;
import com.bytedance.android.livesdk.message.model.vm;
import com.bytedance.android.livesdk.official.feed.OfficialActivityDialog;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import sk1.a;

/* JADX INFO: loaded from: classes7.dex */
public class RecommendDialogWidget extends LiveRecyclableWidget implements IRecommendDialogView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f108003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f108004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OfficialActivityDialog f108005c;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a216";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        f.d(this);
        this.f108003a.detachView();
    }

    public RecommendDialogWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.recommenddialog.IRecommendDialogView
    public final void Tx(hj r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Lists.isEmpty(r100.getUsers()) == false) goto L7;
        return;
    L7:
        if (r100.getUsers().size() > 0) goto L10;
        return;
    L10:
        if (this.f108004b != null) goto L12;
        return;
    L12:
        OfficialActivityDialog r101 = this.f108005c;
        if (r101 != null) goto L15;
    L17:
        boolean r102 = true;
        if (this.f108004b.getRequestedOrientation() == 1) goto L21;
        r102 = false;
    L21:
        DataCenter r103 = this.dataCenter;
        OfficialActivityDialog r104 = new OfficialActivityDialog();
        r104.f154139i = r100;
        r104.f154136f = r102;
        r104.f154134d = 2;
        r104.f154137g = r103;
        r104.setVertical(r102);
        this.f108005c = r104;
        DataCenter r105 = this.dataCenter;
        if (r105 == null) goto L24;
        r105.put("cmd_official_hide", Boolean.TRUE);
    L24:
        wq(this.f108005c, ((FragmentActivity) this.f108004b).getSupportFragmentManager());
        return;
    L15:
        if (r101.isShowing() == false) goto L17;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f108004b = (Activity) getContext();
        this.f108003a = new a();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        f.c(this);
        this.f108003a.g0(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.recommenddialog.IRecommendDialogView
    public final void r00(c2 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Lists.isEmpty(r100.E()) == false) goto L7;
        return;
    L7:
        if (r100.E().size() > 0) goto L10;
        return;
    L10:
        if (this.f108004b != null) goto L12;
        return;
    L12:
        OfficialActivityDialog r101 = this.f108005c;
        if (r101 != null) goto L15;
    L17:
        boolean r102 = true;
        if (this.f108004b.getRequestedOrientation() == 1) goto L21;
        r102 = false;
    L21:
        List<vm> r103 = r100.E();
        DataCenter r104 = this.dataCenter;
        OfficialActivityDialog r105 = new OfficialActivityDialog();
        r105.f154138h = r103;
        r105.f154136f = r102;
        r105.f154134d = 2;
        r105.f154137g = r104;
        r105.setVertical(r102);
        this.f108005c = r105;
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L24;
        r106.put("cmd_official_hide", Boolean.TRUE);
    L24:
        wq(this.f108005c, ((FragmentActivity) this.f108004b).getSupportFragmentManager());
        return;
    L15:
        if (r101.isShowing() == false) goto L17;
    }

    public static void wq(LiveDialogFragment r100, FragmentManager r101) {
        if ((r100 instanceof Fragment) == false) goto L5;
        LiveDialogFragment r102 = r100;
    L6:
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, "recommend_live", r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r102, r103) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, "recommend_live");
        return;
    L5:
        r102 = null;
        goto L6
    }
}
