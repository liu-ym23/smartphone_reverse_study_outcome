package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements LiveSwitchButton.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentSettingDialog f132853a;

    public e(CommentSettingDialog r100) {
        this.f132853a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
    public final void d0(LiveSwitchButton r100, boolean r101) {
        if (r101 == false) goto L7;
        ((LinearLayout) this.f132853a.S90(R.id.comment_setting_detail)).setVisibility(0);
        CommentSettingDialog r102 = this.f132853a;
        r102.f132820q = 9;
        Integer r103 = r102.f132818o.get(9);
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
        ((RadioGroup) this.f132853a.S90(R.id.group_follow)).check(r104);
        return;
    L9:
        return;
    L7:
        ((LinearLayout) this.f132853a.S90(R.id.comment_setting_detail)).setVisibility(8);
        this.f132853a.f132820q = 1;
    }
}
