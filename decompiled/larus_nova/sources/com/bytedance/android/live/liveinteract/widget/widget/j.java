package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkDistributeSettingDialog f81068a;

    public j(LinkDistributeSettingDialog r100) {
        this.f81068a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "curItemView");
        LinkDistributeSettingDialog r101 = this.f81068a;
        int r102 = LinkDistributeSettingDialog.f80982i;
        r101.getClass();
        ImageView r103 = (ImageView) r100.findViewById(R.id.item_right_icon);
        Iterator r104 = ((ArrayList) r101.f80984b).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((ImageView) ((View) r104.next()).findViewById(R.id.item_right_icon)).setImageResource(0);
        goto L4
    L6:
        r103.setImageResource(R.drawable.ic_ttlive_dialog_item_selected);
        this.f81068a.getClass();
        View r105 = r100.findViewById(R.id.tv_link_distribute_setting_item_title);
        String r106 = null;
        if ((r105 instanceof TextView) == true) goto L9;
        r105 = null;
    L9:
        TextView r107 = (TextView) r105;
        if (r107 == null) goto L14;
        CharSequence r108 = r107.getText();
        if (r108 == null) goto L14;
        r106 = r108.toString();
    L14:
        if (r106 == null) goto L16;
        this.f81068a.getContext().getString(R.string.ttlive_content_description_selected);
        r3.g(r100, r106);
        Objects.toString(Unit.INSTANCE);
    L16:
        int r109 = r100.getId();
        if (r109 != R.id.link_distribute_setting_every) goto L20;
        this.f81068a.N0(ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE);
    L25:
        LinkDistributeSettingDialog r110 = this.f81068a;
        Handler r111 = DialogLancet.resolveDialogHandler(r110);
        if (r111 != null) goto L28;
    L30:
        DialogLancet.beforeDialogDismiss(r110);
        r110.dismiss();     // Catch: Throwable -> L33 Exception -> L35
    L39:
        DialogLancet.afterDialogDismiss(r110);
        return;
    L35:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L33
        Throwable r112 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L33
        if (r112 == null) goto L39;
        com.bytedance.crash.d.d(r112, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r110);
        throw th;
    L28:
        if (Looper.myLooper() == r111.getLooper()) goto L30;
        r111.post(DialogLancet.createDismissRunnable(r110));
        return;
    L20:
        if (r109 != R.id.link_distribute_setting_friends) goto L23;
        this.f81068a.N0(ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN);
        goto L25
    L23:
        if (r109 != R.id.link_distribute_setting_off) goto L25;
        this.f81068a.N0(ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF);
        goto L25
    }
}
