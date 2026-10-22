package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class h extends jg4.j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f144294n;

    @Override // jg4.j
    public final String toString() {
        return this.f144294n + ": " + super.toString();
    }

    public h(long r100, String r101, String r102, String r103, LyricsDisplayConfig r104) {
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.SAVE_PATH);
        Intrinsics.checkNotNullParameter(r103, "fileName");
        Intrinsics.checkNotNullParameter(r104, "config");
        super(r101, r102, r103, r104);
        this.f144294n = r100;
    }
}
