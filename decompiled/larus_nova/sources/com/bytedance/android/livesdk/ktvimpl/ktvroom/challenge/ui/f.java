package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f144638a = null;

    static {
        f144638a = new f();
    }

    public f() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KtvChallengeDataContext.a r101 = KtvChallengeDataContext.Companion;
        if (r101 == null) goto L14;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r102 = r101.a();
        if (r102 == null) goto L15;
        me2.a r103 = r102.getChallengeConfig();
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.f513459f != KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L17;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r104 = r101.a();
        if (r104 == null) goto L18;
        r104.openGiftDialog();
        return;
    L18:
        return;
    L17:
        return;
    L15:
        return;
    }
}
