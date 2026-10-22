package bj1;

import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;

/* JADX INFO: loaded from: classes7.dex */
public interface c extends IAbility {
    boolean Zd();

    IExternalConfigJudger getExternalConfigJudger();

    ILivePlayerScene getPlayerScene();

    boolean isInExternalMode();

    boolean yh();
}
