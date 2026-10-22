package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends mx.j {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListDialogAbility f114106a;

        public a(ListDialogAbility r100) {
            this.f114106a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r101 = com.bytedance.android.livesdk.sharedpref.b.f158164j1;
            Boolean r102 = Boolean.TRUE;
            r101.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
            r100.getContext();
            this.f114106a.dismissDialog();
            xs2.b.a().post(new jd0.i());
        }
    }

    public f(ListDialogAbility r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        super(s1.B(R.string.ttlive_live_audience_linkmic_setting), null, false, 14);
        this.f516144l = new a(r100);
    }
}
