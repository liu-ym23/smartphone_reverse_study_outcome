package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.graphics.Rect;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.TriggerType;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: classes10.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r100, MusicPanel r101) {
            r100.G1(r101, TriggerType.Bind);
        }
    }

    void G1(MusicPanel r100, TriggerType r101);

    Rect J3();

    void v0(MusicPanel r100);
}
