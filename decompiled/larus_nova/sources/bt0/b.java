package bt0;

import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.livesdk.common.LiveViewStub;

/* JADX INFO: loaded from: classes47.dex */
public interface b extends com.bytedance.android.live.profile.profilecontext.c {
    void f();

    void g();

    void h(ProfileText r100, HonorWallElement r101, NewProfileUser r102, h r103);

    void onViewShow();

    void p(LiveViewStub r100);

    void update(ProfileText r100, HonorWallElement r101, NewProfileUser r102, h r103);
}
