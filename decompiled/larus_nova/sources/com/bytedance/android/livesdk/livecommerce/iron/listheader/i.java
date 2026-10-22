package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import si2.r;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements QModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<com.bytedance.android.livesdk.livecommerce.iron.listheader.b> f148837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f148838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f148839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.largemode.b f148840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f148841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super String, ? super String, ? super com.bytedance.android.btm.api.model.d, Unit> f148842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gi2.a f148843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Pair<Boolean, Boolean> f148844h;

    public static final class a {
    }

    public interface b {
        ECLottieAnimationView b();
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 12;
    }

    public final List<ECRitTag> b() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r100 = this.f148837a.getValue();
        if (r100 == null) goto L9;
        Map<String, List<ECRitTag>> r101 = r100.f148780a;
        if (r101 == null) goto L9;
        List<ECRitTag> r102 = r101.get("live_room_good_list_header");
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new ArrayList();
    }

    public final List<ECRitTag> c() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r100 = this.f148837a.getValue();
        if (r100 == null) goto L9;
        Map<String, List<ECRitTag>> r101 = r100.f148780a;
        if (r101 == null) goto L9;
        List<ECRitTag> r102 = r101.get("live_room_good_list_header_before");
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new ArrayList();
    }

    public final com.bytedance.android.livesdk.livecommerce.iron.listheader.b d() {
        return this.f148837a.getValue();
    }

    public final r e() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r100 = this.f148837a.getValue();
        r r101 = new r();
        Map<String, String> r102 = null;
        if (r100 == null) goto L8;
        ECPromotionList.f r103 = r100.f148783d;
        if (r103 == null) goto L8;
        String r104 = r103.name;
        if (r104 == null) goto L8;
    L13:
        String r105 = "";
        if (r104 != null) goto L16;
        r104 = "";
    L16:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r101.f542207a = r104;
        if (r100 == null) goto L21;
        ECPromotionList.v r106 = r100.f148782c;
        if (r106 == null) goto L21;
        String r107 = r106.suffixText;
    L22:
        r101.f542208b = r107;
        boolean r108 = true;
        if (r100 == null) goto L34;
        ECPromotionList.f r109 = r100.f148783d;
        if (r109 == null) goto L34;
        Long r110 = Long.valueOf(r109.fontSize);
        if (r110.longValue() <= 0) goto L29;
        boolean r111 = true;
    L30:
        if (r111 == true) goto L33;
        r110 = null;
    L33:
        if (r110 == null) goto L34;
    L44:
        if (r110 == null) goto L46;
        long r112 = r110.longValue();
    L47:
        r101.f542209c = r112;
        if (r100 == null) goto L52;
        ECPromotionList.f r113 = r100.f148783d;
        if (r113 == null) goto L52;
        List<ECRitTag> r114 = r113.tags;
    L53:
        r101.f542210d = r114;
        if (r100 == null) goto L59;
        ECPromotionList.f r115 = r100.f148783d;
        if (r115 == null) goto L59;
        String r116 = r115.jumpUrl;
        if (r116 == null) goto L59;
    L64:
        if (r116 == null) goto L67;
        r105 = r116;
    L67:
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r101.f542211e = r105;
        if (r100 == null) goto L72;
        ECPromotionList.f r117 = r100.f148783d;
        if (r117 == null) goto L72;
        List<Integer> r118 = r117.liveParamsType;
    L73:
        r101.f542212f = r118;
        if (r100 == null) goto L78;
        ECPromotionList.f r119 = r100.f148783d;
        if (r119 == null) goto L78;
        ECPromotionList.i r120 = r119.changeStoreIcon;
    L79:
        r101.f542213g = r120;
        if (r100 == null) goto L82;
        ECPromotionList.f r121 = r100.f148783d;
    L82:
        if (r100 == null) goto L89;
        ECPromotionList.f r122 = r100.f148783d;
        if (r122 == null) goto L89;
        Map<String, String> r123 = r122.eventParams;
        if (r123 == null) goto L89;
        r102 = r123;
    L93:
        r101.f542214h = r102;
        return r101;
    L89:
        if (r100 == null) goto L93;
        ECPromotionList.v r124 = r100.f148782c;
        if (r124 == null) goto L93;
        r102 = r124.eventParams;
    L78:
        r120 = null;
    L72:
        r118 = null;
    L59:
        if (r100 == null) goto L63;
        ECPromotionList.v r125 = r100.f148782c;
        if (r125 == null) goto L63;
        r116 = r125.jumpUrl;
    L63:
        r116 = null;
    L52:
        r114 = null;
        goto L53
    L46:
        r112 = 14;
        goto L47
    L29:
        r111 = false;
    L34:
        if (r100 == null) goto L43;
        ECPromotionList.v r126 = r100.f148782c;
        if (r126 == null) goto L43;
        r110 = Long.valueOf(r126.fontSize);
        if (r110.longValue() > 0) goto L41;
        r108 = false;
    L41:
        if (r108 == true) goto L44;
    L43:
        r110 = null;
    L21:
        r107 = null;
    L8:
        if (r100 == null) goto L12;
        ECPromotionList.v r127 = r100.f148782c;
        if (r127 == null) goto L12;
        r104 = r127.text;
    L12:
        r104 = null;
        goto L13
    }

    public final boolean f() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r100 = this.f148837a.getValue();
        ECPromotionList.d r101 = null;
        if (r100 == null) goto L5;
        ECPromotionList.f r102 = r100.f148783d;
    L6:
        if (r102 != null) goto L15;
        if (r100 == null) goto L9;
        ECPromotionList.v r103 = r100.f148782c;
    L10:
        if (r103 != null) goto L15;
        if (r100 == null) goto L13;
        r101 = r100.f148781b;
    L13:
        if (r101 == null) goto L15;
        return true;
    L9:
        r103 = null;
    L15:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public final String g() {
        com.bytedance.android.livesdk.livecommerce.iron.listheader.b r100 = this.f148837a.getValue();
        ECPromotionList.v r101 = null;
        if (r100 == null) goto L5;
        ECPromotionList.f r102 = r100.f148783d;
    L6:
        if (r102 == null) goto L8;
        return "shop";
    L8:
        if (r100 == null) goto L10;
        r101 = r100.f148782c;
    L10:
        if (r101 == null) goto L12;
        return LiveEndPageData.TAG_WINDOW;
    L12:
        return "";
    L5:
        r102 = null;
        goto L6
    }

    public i() {
        this.f148837a = new MutableLiveData();
        this.f148838b = new MutableLiveData(null);
        Boolean r100 = Boolean.FALSE;
        this.f148844h = new Pair(r100, r100);
    }
}
