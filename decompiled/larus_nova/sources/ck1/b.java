package ck1;

import android.os.Bundle;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;

/* JADX INFO: loaded from: classes7.dex */
public interface b extends IAbility {
    void mh(Bundle r100, JumpToOtherRoomEvent r101);

    void saveBackRoomInfo(Bundle r100, Bundle r101);
}
