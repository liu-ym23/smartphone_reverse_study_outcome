package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e r100) {
            r100.a(FirstLevelTab.OrderSongTab.getValue(), "");
        }
    }

    void a(int r100, String r101);

    com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r100);

    void c(Integer r100, String r101);

    void clearData();
}
