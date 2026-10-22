package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.SecondLevelTabViewSelectedType;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes45.dex */
public interface c {
    String Ms();

    void O0();

    void W30(Function0<Unit> r100);

    Function3<List<MusicPanel>, List<Object>, y, Unit> ms(List<? extends Object> r100);

    void ok(y r100, Function3<? super List<MusicPanel>, ? super List<Object>, ? super y, Unit> r101);

    void rs(SecondLevelTabViewSelectedType r100, y r101);

    boolean yf();
}
