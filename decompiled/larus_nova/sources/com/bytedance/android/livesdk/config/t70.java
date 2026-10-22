package com.bytedance.android.livesdk.config;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class t70 extends SSettingKey<Map<String, ? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t70 f121276a = null;

    public t70() {
        super("live_lyric_font_size_map", "歌词字体大小", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("FZSongKeBenXiuKai", 16)}), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("FZSongKeBenXiuKai", 16)}));
    }

    static {
        f121276a = new t70();
    }
}
