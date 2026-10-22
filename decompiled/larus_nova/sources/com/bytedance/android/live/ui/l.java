package com.bytedance.android.live.ui;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public interface l {
    void a(List<Pair<Float, Float>> r100);

    void b(IVoiceLiveTheme r100);

    void c(IVoiceLiveTheme r100);

    void d(boolean r100);

    void onThemeChanged(IVoiceLiveTheme r100);
}
