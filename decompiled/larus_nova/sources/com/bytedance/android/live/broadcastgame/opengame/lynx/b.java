package com.bytedance.android.live.broadcastgame.opengame.lynx;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.crypto.CryptoServicesPermission;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f60146d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<C0988b> f60147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f60148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f60149c;

    public static final class a {
        public static b a(JSONObject r100) throws JSONException {
            Intrinsics.checkNotNullParameter(r100, "json");
            b r101 = new b();
            Intrinsics.checkNotNullParameter(JSONObjectProtectorUtils.getString(r100, "version"), "<set-?>");
            Intrinsics.checkNotNullParameter(JSONObjectProtectorUtils.getString(r100, "appid"), "<set-?>");
            Intrinsics.checkNotNullParameter(r100.optString("cli_version"), "<set-?>");
            JSONObject r102 = r100.optJSONObject(CryptoServicesPermission.GLOBAL_CONFIG);
            if (r102 == null) goto L6;
            String r103 = r102.optString("panelHeightType");
            if (r103 == null) goto L6;
        L7:
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r101.f60148b = r103;
            if (r102 == null) goto L10;
            long r104 = r102.optLong("networkTimeout");
        L11:
            r101.f60149c = r104;
            JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(r100, "views");
            int r106 = r105.length();
            ArrayList r107 = new ArrayList();
            int r108 = 0;
        L12:
            if (r108 >= r106) goto L14;
            r107.add(JSONArrayProtectorUtils.getJSONObject(r105, r108));
            r108 = r108 + 1;
            goto L12
        L14:
            ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
            Iterator r110 = r107.iterator();
        L16:
            if (r110.hasNext() == false) goto L29;
            JSONObject r111 = (JSONObject) r110.next();
            C0988b r112 = new C0988b();
            String r113 = r111.optString("type");
            Intrinsics.checkNotNullParameter(r113, "<set-?>");
            r112.f60150a = r113;
            String r114 = r112.getType();
            int r115 = r114.hashCode();
            if (r115 == (-2094363978)) goto L26;
            if (r115 != 106433028) goto L28;
            if (r114.equals("panel") == false) goto L28;
            r112.f60152c = r111.optString("entry");
            String r116 = r111.optString("alias");
            Intrinsics.checkNotNullParameter(r116, "<set-?>");
            r112.f60151b = r116;
        L28:
            r109.add(r112);
            goto L16
        L26:
            if (r114.equals(SoloKtvContext.SOLO_PAGE_ENTRANCE) == false) goto L28;
            r111.optJSONObject("icon");
            goto L28
        L29:
            Intrinsics.checkNotNullParameter(r109, "<set-?>");
            r101.f60147a = r109;
            return r101;
        L10:
            r104 = 60000;
        L6:
            r103 = "";
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.lynx.b$b, reason: collision with other inner class name */
    public static final class C0988b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f60150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f60151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f60152c;

        public C0988b() {
            this.f60150a = "";
            this.f60151b = "";
        }

        public final String getType() {
            return this.f60150a;
        }
    }

    static {
    }

    public b() {
        this.f60147a = CollectionsKt.emptyList();
        this.f60148b = "";
        this.f60149c = 60000;
    }
}
