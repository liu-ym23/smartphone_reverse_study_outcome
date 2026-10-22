package com.obric.aiagent.assistant.common.ui.icon;

import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.l.n;
import d.o.o;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: TaskResolvedIcon.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {
    public static final e A = null;
    public static final e B = null;
    public static final e C = null;
    public static final e D = null;
    public static final e E = null;
    public static final e F = null;
    public static final e G = null;
    public static final e H = null;
    public static final e I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final e f16142J = null;
    public static final e K = null;
    public static final e L = null;
    public static final e M = null;
    public static final e N = null;
    public static final e O = null;
    public static final e P = null;
    public static final e Q = null;
    public static final e R = null;
    public static final e S = null;
    public static final e T = null;
    public static final e U = null;
    public static final e V = null;
    public static final e W = null;
    public static final e X = null;
    public static final e Y = null;
    public static final e Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16143a = null;
    public static final e aa = null;
    public static final e ab = null;
    public static final e ac = null;
    public static final e ad = null;
    public static final e ae = null;
    private static final Map<String, e> ah = null;
    private static final /* synthetic */ e[] ai = null;
    private static final /* synthetic */ d.d.a aj = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f16144b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f16145c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f16146d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f16147e = null;
    public static final e f = null;
    public static final e g = null;
    public static final e h = null;
    public static final e i = null;
    public static final e j = null;
    public static final e k = null;
    public static final e l = null;
    public static final e m = null;
    public static final e n = null;
    public static final e o = null;
    public static final e p = null;
    public static final e q = null;
    public static final e r = null;
    public static final e s = null;
    public static final e t = null;
    public static final e u = null;
    public static final e v = null;
    public static final e w = null;
    public static final e x = null;
    public static final e y = null;
    public static final e z = null;
    private final String af;
    private final int ag;

    /* JADX INFO: compiled from: TaskResolvedIcon.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final e a(String r2) {
            String r1 = b(r2);
            if (r1 != null) goto L7;
            return null;
        L7:
            return (e) ZeusTransformUtils.preCheckCast(e.c().get(r1), e.class, "com.obric.aiagent.plugin");
        }

        public final String b(String r2) {
            if (r2 == null) goto L6;
            String r1 = o.a((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r1 == null) goto L6;
            String r3 = r1.toLowerCase(Locale.ROOT);
            d.h.b.o.c(r3, "toLowerCase(...)");
            return r3;
        L6:
            return null;
        }
    }

    private static final /* synthetic */ e[] d() {
        return new e[]{f16144b, f16145c, f16146d, f16147e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, f16142J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae};
    }

    private e(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.af = r3;
        this.ag = r4;
    }

    public static final /* synthetic */ Map c() {
        return ah;
    }

    public final String a() {
        return this.af;
    }

    public final int b() {
        return this.ag;
    }

    static {
        int r4 = 0;
        f16144b = new e("GENERAL_1", 0, "general_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_general_1, "drawable", "ic_task_icon_general_1"));
        f16145c = new e("GENERAL_2", 1, "general_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_general_2, "drawable", "ic_task_icon_general_2"));
        f16146d = new e("GENERAL_3", 2, "general_3", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_general_3, "drawable", "ic_task_icon_general_3"));
        f16147e = new e("GENERAL_4", 3, "general_4", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_general_4, "drawable", "ic_task_icon_general_4"));
        f = new e("GENERAL_5", 4, "general_5", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_general_5, "drawable", "ic_task_icon_general_5"));
        g = new e("EMOTION_SMILE", 5, "emotion_smile", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_emotion_smile, "drawable", "ic_task_icon_emotion_smile"));
        h = new e("EMOTION_SAD", 6, "emotion_sad", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_emotion_sad, "drawable", "ic_task_icon_emotion_sad"));
        i = new e("EMOTION_ANGRY", 7, "emotion_angry", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_emotion_angry, "drawable", "ic_task_icon_emotion_angry"));
        j = new e("EMOTION_SURPRISED", 8, "emotion_surprised", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_emotion_surprised, "drawable", "ic_task_icon_emotion_surprised"));
        k = new e("EMOTION_LAUGH", 9, "emotion_laugh", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_emotion_laugh, "drawable", "ic_task_icon_emotion_laugh"));
        l = new e("MEDIA_MOVIE", 10, "media_movie", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_media_movie, "drawable", "ic_task_icon_media_movie"));
        m = new e("MEDIA_GAME_1", 11, "media_game_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_media_game_1, "drawable", "ic_task_icon_media_game_1"));
        n = new e("MEDIA_GAME_2", 12, "media_game_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_media_game_2, "drawable", "ic_task_icon_media_game_2"));
        o = new e("MEDIA_MUSIC", 13, "media_music", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_media_music, "drawable", "ic_task_icon_media_music"));
        p = new e("MEDIA_PHOTO", 14, "media_photo", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_media_photo, "drawable", "ic_task_icon_media_photo"));
        q = new e("MEDIA_VIDEO", 15, "media_video", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_media_video, "drawable", "ic_task_icon_media_video"));
        r = new e("RELATIONSHIP_RUNNING_1", 16, "relationship_running_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_running_1, "drawable", "ic_task_icon_relationship_running_1"));
        s = new e("RELATIONSHIP_RUNNING_2", 17, "relationship_running_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_running_2, "drawable", "ic_task_icon_relationship_running_2"));
        t = new e("RELATIONSHIP_FITNESS_1", 18, "relationship_fitness_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_fitness_1, "drawable", "ic_task_icon_relationship_fitness_1"));
        u = new e("RELATIONSHIP_FITNESS_2", 19, "relationship_fitness_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_fitness_2, "drawable", "ic_task_icon_relationship_fitness_2"));
        v = new e("RELATIONSHIP_FITNESS_3", 20, "relationship_fitness_3", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_fitness_3, "drawable", "ic_task_icon_relationship_fitness_3"));
        w = new e("RELATIONSHIP_FITNESS_4", 21, "relationship_fitness_4", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_fitness_4, "drawable", "ic_task_icon_relationship_fitness_4"));
        x = new e("RELATIONSHIP_EXERCISE_1", 22, "relationship_exercise_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_exercise_1, "drawable", "ic_task_icon_relationship_exercise_1"));
        y = new e("RELATIONSHIP_FIGURE", 23, "relationship_exercise_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_exercise_2, "drawable", "ic_task_icon_relationship_exercise_2"));
        z = new e("RELATIONSHIP_PARTY_1", 24, "relationship_party_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_party_1, "drawable", "ic_task_icon_relationship_party_1"));
        A = new e("RELATIONSHIP_PARTY_2", 25, "relationship_party_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_party_2, "drawable", "ic_task_icon_relationship_party_2"));
        B = new e("RELATIONSHIP_PARTY_3", 26, "relationship_party_3", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_party_3, "drawable", "ic_task_icon_relationship_party_3"));
        C = new e("RELATIONSHIP_PARTY_4", 27, "relationship_party_4", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_party_4, "drawable", "ic_task_icon_relationship_party_4"));
        D = new e("RELATIONSHIP_SUPPORT", 28, "relationship_support", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_support, "drawable", "ic_task_icon_relationship_support"));
        E = new e("RELATIONSHIP_PROFILE", 29, "relationship_profile", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_profile, "drawable", "ic_task_icon_relationship_profile"));
        F = new e("RELATIONSHIP_PRIVATE", 30, "relationship_private", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_relationship_private, "drawable", "ic_task_icon_relationship_private"));
        G = new e("CALENDAR_1", 31, "calendar_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_calendar_1, "drawable", "ic_task_icon_calendar_1"));
        H = new e("CALENDAR_2", 32, "calendar_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_calendar_2, "drawable", "ic_task_icon_calendar_2"));
        I = new e("CALENDAR_3", 33, "calendar_3", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_calendar_3, "drawable", "ic_task_icon_calendar_3"));
        f16142J = new e("MATERIALS_1", 34, "materials_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_materials_1, "drawable", "ic_task_icon_materials_1"));
        K = new e("MATERIALS_2", 35, "materials_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_materials_2, "drawable", "ic_task_icon_materials_2"));
        L = new e("MATERIALS_3", 36, "materials_3", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_materials_3, "drawable", "ic_task_icon_materials_3"));
        M = new e("MATERIALS_4", 37, "materials_4", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_materials_4, "drawable", "ic_task_icon_materials_4"));
        N = new e("HEALTH_1", 38, "health_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_health_1, "drawable", "ic_task_icon_health_1"));
        O = new e("HEALTH_2", 39, "health_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_health_2, "drawable", "ic_task_icon_health_2"));
        P = new e("STUDY_1", 40, "study_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_study_1, "drawable", "ic_task_icon_study_1"));
        Q = new e("FINANCE_1", 41, "finance_1", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_finance_1, "drawable", "ic_task_icon_finance_1"));
        R = new e("FINANCE_2", 42, "finance_2", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_finance_2, "drawable", "ic_task_icon_finance_2"));
        S = new e("FOOD", 43, "food", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_food, "drawable", "ic_task_icon_life_food"));
        T = new e("SHOPPING", 44, "shopping", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_shopping, "drawable", "ic_task_icon_life_shopping"));
        U = new e("TRAVEL_FLY", 45, "travel_fly", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_travel_fly, "drawable", "ic_task_icon_life_travel_fly"));
        V = new e("BEER", 46, "beer", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_beer, "drawable", "ic_task_icon_life_beer"));
        W = new e("TRAVEL_TRAIN", 47, "travel_train", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_train, "drawable", "ic_task_icon_life_train"));
        X = new e("TRAVEL_CAR", 48, "travel_car", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_car, "drawable", "ic_task_icon_life_car"));
        Y = new e("DRINK", 49, "drink", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_drink, "drawable", "ic_task_icon_life_drink"));
        Z = new e("VACATION", 50, "vacation", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_vacation, "drawable", "ic_task_icon_life_vacation"));
        aa = new e("CAKE", 51, "cake", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_cake, "drawable", "ic_task_icon_life_cake"));
        ab = new e("CLOTHES", 52, "clothes", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_clothes, "drawable", "ic_task_icon_life_clothes"));
        ac = new e("BAG", 53, "bag", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_bag, "drawable", "ic_task_icon_life_bag"));
        ad = new e("MILESTONE", 54, "milestone", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_milestone, "drawable", "ic_task_icon_life_milestone"));
        ae = new e("GIFT", 55, "gift", ZeusTransformUtils.mapRes(R.drawable.ic_task_icon_life_gift, "drawable", "ic_task_icon_life_gift"));
        e[] r0 = d();
        ai = r0;
        aj = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f16143a = new a(null);
        e[] r1 = values();
        Map<String, e> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(n.c(ao.a(r1.length), 16)), Map.class, "com.obric.aiagent.plugin");
        int r3 = r1.length;
    L3:
        if (r4 >= r3) goto L5;
        e r5 = r1[r4];
        r2.put(r5.af, r5);
        r4 = r4 + 1;
        goto L3
    L5:
        ah = r2;
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(ai.clone(), e[].class, "com.obric.aiagent.plugin");
    }
}
