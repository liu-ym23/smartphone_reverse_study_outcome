package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f80723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f80724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f80725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Boolean> f80726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f80727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f80728f;

    public s() {
        this.f80725c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ksong", 0L), TuplesKt.to("clean_screen", 0L), TuplesKt.to("record", 0L), TuplesKt.to("key_board", 0L)});
        Boolean r100 = Boolean.FALSE;
        this.f80726d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ksong", r100), TuplesKt.to("clean_screen", r100), TuplesKt.to("record", r100), TuplesKt.to("key_board", r100)});
        this.f80727e = "auto";
        this.f80728f = "more";
    }
}
