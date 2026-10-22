package com.bytedance.android.livesdk.ktvimpl.base.component.lyric;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import jg4.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KaraokeLyricPresenter$2$initRequest$1 extends j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ KaraokeLyricPresenter$2 f142421n;

    @Override // jg4.j, jg4.g
    public final void b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        c.a("KaraokeLyricPresenter", "onParseSuccess, request = " + r100);
        UtilityKotlinExtentionsKt.s(0, false, false, new KaraokeLyricPresenter$2$initRequest$1$onParseSuccess$1(this), 7);
    }

    @Override // jg4.j
    public final void d(final j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super.d(r100);
        UtilityKotlinExtentionsKt.s(0, false, false, new KaraokeLyricPresenter$2$initRequest$1$onLyricTransform$1(this, r100), 7);
    }

    @Override // jg4.j, jg4.g
    public final void i(j r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        c.a("KaraokeLyricPresenter", "onParseFail, errorMsg = " + r101 + ", request = " + r100);
    }

    public KaraokeLyricPresenter$2$initRequest$1(KaraokeLyricPresenter$2 r100, String r101, String r102, String r103, LyricsDisplayConfig r104) {
        this.f142421n = r100;
        super(r101, r102, r103, r104);
    }
}
