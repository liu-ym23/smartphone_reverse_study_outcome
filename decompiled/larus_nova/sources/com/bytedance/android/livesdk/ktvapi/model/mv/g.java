package com.bytedance.android.livesdk.ktvapi.model.mv;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.od;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public interface g extends c {
    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.c
    h<?> a();

    void d(od r100, k r101, boolean r102);

    void e(k r100, String r101, int r102, boolean r103);

    void g(List<MusicPanel> r100, Function1<? super Long, Boolean> r101);

    void j(vlc.d r100, boolean r101);

    od k();

    f l(long r100, String r101);

    int n();

    void o(k r100, boolean r101);
}
