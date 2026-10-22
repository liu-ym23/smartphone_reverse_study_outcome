package com.bytedance.android.livesdk.ktvimpl.base.component.lyric;

import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import jg4.i;
import jg4.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KaraokeLyricPresenter$2 implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f142420a;

    public KaraokeLyricPresenter$2(b r100) {
        this.f142420a = r100;
    }

    @Override // jg4.i
    public final j a(String r100, String r101, String r110, LyricsDisplayConfig r111) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.SAVE_PATH);
        Intrinsics.checkNotNullParameter(r110, "fileName");
        Intrinsics.checkNotNullParameter(r111, "config");
        return new KaraokeLyricPresenter$2$initRequest$1(this, r100, r101, r110, r111);
    }
}
