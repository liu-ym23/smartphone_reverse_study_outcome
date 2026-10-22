package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f;
import com.bytedance.android.livesdk.interactivity.api.settings.config.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import np1.g;

/* JADX INFO: loaded from: classes8.dex */
public final class PublicScreenConfigItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f116739a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f116743a = 0;

        static {
        }
    }

    static {
        f116739a = f.a();
    }

    public static np1.b a(final np1.c r100) {
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        boolean r101 = false;
        if (z.e(r100.getDataCenter(), false) == true) goto L12;
        x r102 = f116739a;
        if (r102.enable == true) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
        r101 = true;
        goto L12
    L7:
        if (r102.settingEntryPos != 2) goto L9;
        r103 = true;
    L12:
        if (r101 == true) goto L15;
        return null;
    L15:
        np1.b.a r104 = np1.b.f520007a;
        Function0<g> r105 = new PublicScreenConfigItem$provide$1(r100);
        PublicScreenConfigItem$provide$2 r106 = PublicScreenConfigItem$provide$2.INSTANCE;
        r104.getClass();
        return np1.b.a.a(r105, r106);
    }
}
