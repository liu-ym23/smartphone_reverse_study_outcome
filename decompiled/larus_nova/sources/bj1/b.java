package bj1;

import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.android.livesdkapi.distribution.config.OrientationAction;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IExternalConfigJudger f19207a;

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // bj1.c
    public final boolean Zd() {
        IExternalConfigJudger r100 = this.f19207a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.disable(EXTERNAL_CONFIG_TYPE.OrientationChange, OrientationAction.gravitySensing) == false) goto L7;
        return true;
    }

    @Override // bj1.c
    public final ILivePlayerScene getPlayerScene() {
        IExternalConfigJudger r100 = this.f19207a;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getPlayerScene() != null) goto L7;
        return null;
    L7:
        return this.f19207a.getPlayerScene();
    }

    @Override // bj1.c
    public final boolean isInExternalMode() {
        IExternalConfigJudger r100 = this.f19207a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isInExternalMode() == false) goto L7;
        return true;
    }

    @Override // bj1.c
    public final boolean yh() {
        IExternalConfigJudger r100 = this.f19207a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.disable(EXTERNAL_CONFIG_TYPE.Gesture, GestureAction.longPress) == false) goto L7;
        return true;
    }

    @Override // bj1.c
    public final IExternalConfigJudger getExternalConfigJudger() {
        return this.f19207a;
    }

    public b(IExternalConfigJudger r100) {
        this.f19207a = r100;
    }
}
