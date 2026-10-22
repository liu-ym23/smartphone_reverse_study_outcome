package bt0;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.ui.base.h;

/* JADX INFO: loaded from: classes47.dex */
public interface a extends com.bytedance.android.live.profile.profilecontext.c {
    void b(HonorWallElement r100);

    void d(Fragment r100, View r101, HonorWallElement r102, NewProfileUser r103, h r104);

    View e(h r100, Context r101);

    b i();

    void j(HonorWallElement r100);

    void k(HonorWallElement r100);

    void m();

    boolean n(HonorWallElement r100, NewProfileUser r101, h r102);

    boolean o(HonorWallElement r100, h r101);
}
