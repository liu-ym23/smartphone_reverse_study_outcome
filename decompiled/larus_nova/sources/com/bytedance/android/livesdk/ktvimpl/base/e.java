package com.bytedance.android.livesdk.ktvimpl.base;

import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import com.larus.nova.R;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<KtvConflictScene, List<f>> f142487a = null;

    static {
        KtvConflictScene r100 = KtvConflictScene.SCENE_ANCHOR_GAME;
        KtvConflictScene r101 = KtvConflictScene.SCENE_KSONG;
        KtvConflictScene r102 = KtvConflictScene.SCENE_SOUND_EFFECT;
        KtvConflictScene r103 = KtvConflictScene.SCENE_KTV;
        f142487a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, CollectionsKt.listOf(new f(r101, 0))), TuplesKt.to(r102, CollectionsKt.listOf(new f[]{new f(r101, R.string.ttlive_sound_effect_conflict_ksong), new f(r103, R.string.ttlive_ktv_room_mutex_sound_effect), new f(KtvConflictScene.SCENE_KTV_CHORUS, R.string.ttlive_chorus_room_mutex_sound_effect)})), TuplesKt.to(r101, CollectionsKt.listOf(new f[]{new f(r100, R.string.ttlive_ktv_start_in_game_hint), new f(r102, R.string.ttlive_ktv_conflict_sound_effect), new f(r103, 0)})), TuplesKt.to(KtvConflictScene.SCENE_INTERACTIVE_SONG, CollectionsKt.listOf(new f(r103, 0))), TuplesKt.to(r103, CollectionsKt.listOf(new f(r102, R.string.ttlive_ktv_room_mutex_sound))), TuplesKt.to(KtvConflictScene.SCENE_PAUSE_LIVE, CollectionsKt.listOf(new f[]{new f(r101, R.string.ttlive_broadcast_pause_error_in_ksong), new f(r103, R.string.ttlive_broadcast_pause_error_in_ktv)})), TuplesKt.to(KtvConflictScene.SCENE_WGAME, CollectionsKt.listOf(new f[]{new f(r101, R.string.ttlive_game_ksong_quit_close), new f(r103, R.string.ttlive_game_ktv_quit_close)}))});
    }
}
