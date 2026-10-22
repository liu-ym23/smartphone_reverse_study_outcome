package com.bytedance.android.livesdk.interactivity.comment.utils;

import am2.x;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Long f136256a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f136257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f136258c;

    static {
        f136256a = (Long) new SettingKey("live_comment_entry_expose_report_delay_ms", "", 3000L, 3000L).getValue();
    }

    @JvmStatic
    public static final void a(x22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "curHint");
        if (f136258c == true) goto L5;
        return;
    L5:
        j0.l().sendLog("livesdk_live_bottom_comment_default_text_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("default_text", r100.f562221a), TuplesKt.to("default_text_type", r100.getType().getTypeName())}), new Object[]{Room.class, x.class});
    }
}
