package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.home.entity.FansClubInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f183607a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f183608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f183609b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f183608a, r101.f183608a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f183609b, r101.f183609b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f183608a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f183609b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ShopFollowState(followState=" + this.f183608a + ", fansLevel=" + this.f183609b + ")";
        }

        public a(String r100, Integer r101) {
            this.f183608a = r100;
            this.f183609b = r101;
        }
    }

    static {
    }

    public static a b(com.bytedance.android.shopping.store.home.entity.d r100) {
        Integer r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        Integer r102 = r100.f183677c;
        boolean r103 = false;
        if (r102 == null) goto L11;
        boolean r104 = true;
        if (r102.intValue() != 1) goto L11;
    L12:
        FansClubInfo r105 = r100.f183682h;
        if (r105 == null) goto L15;
        boolean r106 = r105.getOpenFansClub();
    L16:
        FansClubInfo r107 = r100.f183682h;
        if (r107 == null) goto L19;
        r103 = r107.getJoinStatus();
    L19:
        FansClubInfo r108 = r100.f183682h;
        if (r108 == null) goto L22;
        r101 = r108.getFansClubLevel();
    L22:
        if (r106 == false) goto L27;
        if (r104 == false) goto L27;
        if (r103 == false) goto L26;
        String r109 = "fans_level";
    L31:
        return new a(r109, r101);
    L26:
        r109 = "join_fans";
    L27:
        if (r104 == false) goto L29;
        r109 = "follow";
        goto L31
    L29:
        r109 = "unfollow";
        goto L31
    L15:
        r106 = false;
    L11:
        r104 = false;
        goto L12
    }

    public static void a(Map r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "sliceItemStates");
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = r101.f183608a;
        if (r102 == null) goto L8;
        r100.put("shop_follow_state", r102);
    L8:
        Integer r103 = r101.f183609b;
        if (r103 == null) goto L12;
        r100.put("shop_fans_level", Integer.valueOf(r103.intValue()));
        return;
    }
}
