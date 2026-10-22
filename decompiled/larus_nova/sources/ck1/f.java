package ck1;

import android.os.Bundle;
import com.bytedance.android.livesdk.ability.IAbility;

/* JADX INFO: loaded from: classes7.dex */
public interface f extends IAbility {
    void c4(String r100, boolean r101);

    void cc(String r100, String r101, Bundle r102, long r103, hi1.a r104);

    void ia();

    void iq();

    void jh(Long r100);

    void prePrepare(String r100);

    void prePullStream(boolean r100, String r101);

    void stopPrePullStream();

    void stopRoom(String r100);

    void updateRoomSession(long r100);

    void updateStartTimeForLog(long r100);

    void zc();

    void zf();
}
