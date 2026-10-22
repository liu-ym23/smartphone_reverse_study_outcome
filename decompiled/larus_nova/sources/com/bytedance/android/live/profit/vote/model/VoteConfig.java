package com.bytedance.android.live.profit.vote.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.profit.vote.LiveVoteConfig;
import com.bytedance.android.live.profit.vote.l;
import com.bytedance.live.kmp.core.KmpEnv;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
public final class VoteConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f89220a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/vote/model/VoteConfig$Plan;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Plan extends Enum<Plan> {
        public static final Plan A = null;
        public static final Plan B = null;
        public static final Plan C = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Plan[] f89221a = null;

        static {
            Plan r100 = new Plan(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0);
            A = r100;
            Plan r101 = new Plan("B", 1);
            B = r101;
            Plan r102 = new Plan("C", 2);
            C = r102;
            f89221a = new Plan[]{r100, r101, r102};
        }

        public static Plan valueOf(String r100) {
            return (Plan) r27.a.a(Plan.class, r100);
        }

        public static Plan[] values() {
            return (Plan[]) f89221a.clone();
        }

        public Plan(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static String a() {
        LiveVoteConfig r100 = l.a();
        if (r100 == null) goto L13;
        String r101 = r100.g7();
        if (r101 == null) goto L13;
        if (r101.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L13;
        return r101;
    L9:
        r102 = false;
    L13:
        KmpEnv r103 = KmpEnv.f255139a;
        if (KmpEnv.a() == false) goto L16;
        return "sslocal://webcast_webview?url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Fgift_pk%2Fdetails%2Findex.html&type=popup&gravity=center&web_bg_color=%2300000000&title=&hide_more=0&hide_nav_bar=1&hide_status_bar=0&radius=4&open_animate=1&height=386&width=280";
    L16:
        return "";
    }

    public static String b() {
        LiveVoteConfig r100 = l.a();
        if (r100 == null) goto L13;
        String r101 = r100.Y2();
        if (r101 == null) goto L13;
        if (r101.length() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L13;
        return r101;
    L9:
        r102 = false;
    L13:
        KmpEnv r103 = KmpEnv.f255139a;
        if (KmpEnv.a() == false) goto L16;
        return "sslocal://webcast_webview?url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Fgift_pk%2Fdetails_v2%2Findex.html&type=popup&width_percent=100&rate_height=450&gravity=bottom&web_bg_color=%2300000000&title=&hide_more=0&hide_nav_bar=1&hide_status_bar=0&radius=8&open_animate=1";
    L16:
        return "";
    }

    public static Plan c() {
        LiveVoteConfig r100 = l.a();
        if (r100 == null) goto L5;
        Integer r101 = r100.V3();
    L6:
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L16:
        if (r101 == null) goto L22;
        if (r101.intValue() != 3) goto L22;
        return Plan.C;
    L22:
        return Plan.A;
    L14:
        if (r101.intValue() != 2) goto L16;
        return Plan.B;
    L9:
        if (r101.intValue() != 1) goto L11;
        return Plan.A;
    L5:
        r101 = null;
        goto L6
    }

    static {
    }

    public static boolean d(boolean r100) {
        if (r100 == true) goto L11;
        LiveVoteConfig r101 = l.a();
        if (r101 == null) goto L9;
        Integer r102 = r101.V3();
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L10:
        if (r103 > 0) goto L11;
        return false;
    L9:
        r103 = 0;
    L11:
        return true;
    }
}
