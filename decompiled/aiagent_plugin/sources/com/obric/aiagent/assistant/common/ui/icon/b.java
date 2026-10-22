package com.obric.aiagent.assistant.common.ui.icon;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.m;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: TaskIconPools.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, List<String>> f16139b = null;

    private b() {
    }

    static {
        b r0 = new b();
        f16138a = r0;
        f16139b = r0.a();
    }

    public static final List<String> a(String r2) {
        String r3 = e.f16143a.b(r2);
        if (r3 == null) goto L7;
        List<String> r4 = (List) ZeusTransformUtils.preCheckCast(f16139b.get(r3), List.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        return r4;
    L7:
        return p.b();
    }

    private final Map<String, List<String>> a() {
        return (Map) ZeusTransformUtils.preCheckCast(ao.d(new m[]{s.a("general", a(new e[]{e.f16144b, e.f16145c, e.f16146d, e.f16147e, e.f})), s.a("emotion_smile", a(new e[]{e.g})), s.a("emotion_sad", a(new e[]{e.h})), s.a("emotion_angry", a(new e[]{e.i})), s.a("emotion_surprised", a(new e[]{e.j})), s.a("emotion_laugh", a(new e[]{e.k})), s.a("media_movie", a(new e[]{e.l})), s.a("media_game", a(new e[]{e.m, e.n})), s.a("media_music", a(new e[]{e.o})), s.a("media_photo", a(new e[]{e.p})), s.a("media_video", a(new e[]{e.q})), s.a("relationship_running", a(new e[]{e.r, e.s})), s.a("relationship_fitness", a(new e[]{e.t, e.u, e.v, e.w})), s.a("relationship_exercise", a(new e[]{e.x, e.y})), s.a("relationship_group", a(new e[]{e.z})), s.a("relationship_person", a(new e[]{e.A, e.B})), s.a("relationship_chat", a(new e[]{e.C})), s.a("relationship_support", a(new e[]{e.D})), s.a("relationship_profile", a(new e[]{e.E})), s.a("relationship_private", a(new e[]{e.F})), s.a(IFlowAppIntentIDL.PERMISSION_CALENDAR, a(new e[]{e.G})), s.a("reminder", a(new e[]{e.H})), s.a("schedule_time", a(new e[]{e.I})), s.a("materials_document", a(new e[]{e.f16142J})), s.a("materials_book", a(new e[]{e.K})), s.a("materials_note", a(new e[]{e.L})), s.a("materials_folder", a(new e[]{e.M})), s.a("health", a(new e[]{e.N, e.O})), s.a("study", a(new e[]{e.P})), s.a("finance", a(new e[]{e.Q, e.R})), s.a("food", a(new e[]{e.S})), s.a("shopping", a(new e[]{e.T})), s.a("travel_fly", a(new e[]{e.U})), s.a("beer", a(new e[]{e.V})), s.a("travel_train", a(new e[]{e.W})), s.a("travel_car", a(new e[]{e.X})), s.a("drink", a(new e[]{e.Y})), s.a("vacation", a(new e[]{e.Z})), s.a("cake", a(new e[]{e.aa})), s.a("clothes", a(new e[]{e.ab})), s.a("bag", a(new e[]{e.ac})), s.a("milestone", a(new e[]{e.ad})), s.a("gift", a(new e[]{e.ae}))}), Map.class, "com.obric.aiagent.plugin");
    }

    private final List<String> a(e... r5) {
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r5.length), Collection.class, "com.obric.aiagent.plugin");
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r4.add(r5[r2].a());
        r2 = r2 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    }
}
