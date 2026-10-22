package com.bytedance.android.live.ktv.common.midi;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
public interface g {
    boolean A();

    int B();

    int C();

    int D();

    Pair<String, String> E();

    int F();

    py.k G();

    void H();

    List<Bitmap> I(Integer r100, boolean r101);

    String J();

    String K(int r100, boolean r101);

    boolean L();

    List<Drawable> M(Integer r100, boolean r101);

    List<Drawable> N(Integer r100, boolean r101);

    void clear();

    int getCurrentMode();

    void y(MidiSkinDressInfo r100);

    MidiSkinDressInfo z();
}
