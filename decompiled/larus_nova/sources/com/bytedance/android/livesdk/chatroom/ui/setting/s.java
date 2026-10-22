package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s extends mx.j {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListDialogAbility f114149a;

        public a(ListDialogAbility r100) {
            this.f114149a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f114149a.jumpSubpage(6);
        }
    }

    public s(ListDialogAbility r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        if (tb1.c.f545229a == false) goto L5;
        String r101 = "拉黑与禁言设置";
    L6:
        super(r101, null, false, 14);
        this.f516144l = new a(r100);
        return;
    L5:
        r101 = s1.B(R.string.ttlive_live_profile_live_room_manage);
        goto L6
    }
}
