package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59380a = 0;

    public static final class a {
        public static String a(int r100, String r101, r r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "title");
            if (r100 != InteractID.OpenGame.getValue()) goto L5;
        L38:
            StringBuilder r104 = new StringBuilder();
            r104.append(r100);
            r104.append('_');
            r104.append(r101);
            r104.append('_');
            if (r102 == null) goto L41;
            Long r105 = Long.valueOf(r102.p());
        L42:
            r104.append(r105);
            return r104.toString();
        L41:
            r105 = null;
            goto L42
        L5:
            if (r100 == InteractID.SonicMiniGame.getValue()) goto L38;
            if (r100 == InteractID.EffectGame.getValue()) goto L38;
            if (r100 == InteractID.Zhufen.getValue()) goto L38;
            if (r100 != InteractID.OpenMicroApp.getValue()) goto L18;
            if (r102 == null) goto L37;
            String r106 = r102.b();
            if (r106 == null) goto L37;
            return r106;
        L37:
            return "";
        L18:
            if (r100 != InteractID.InteractGamePlus.getValue()) goto L20;
        L33:
            JSONObject r107 = ln1.a.C6715a.b(r103);
            if (r107 == null) goto L37;
            String r108 = JSONObjectProtectorUtils.getString(r107, "app_id");
            if (r108 == null) goto L37;
            return r108;
        L20:
            if (r100 == InteractID.InteractLoki.getValue()) goto L33;
            if (r100 == InteractID.InteractMiniApp.getValue()) goto L33;
            if (r100 != InteractID.OpenMicroGame.getValue()) goto L46;
            if (r102 == null) goto L37;
            c0 r109 = r102.x();
            if (r109 == null) goto L37;
            String r110 = r109.gameId;
            if (r110 == null) goto L37;
            return r110;
        L46:
            return r100 + '_' + r101;
        }
    }

    static {
    }
}
