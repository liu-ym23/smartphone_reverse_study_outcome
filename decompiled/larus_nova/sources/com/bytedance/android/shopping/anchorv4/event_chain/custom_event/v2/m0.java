package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class m0 implements OnPageSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f166671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f166672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fi3.v f166673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f166674d;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener
    public final void onPageSelected(int r110) {
        n0 r100 = this.f166671a;
        if (r100.f166678f == true) goto L25;
        r100.f166677e++;
        fi3.v r101 = this.f166673c;
        j73.d r102 = r100.f166679g;
        int r103 = com.bytedance.android.shopping.extensions.k.f(Integer.valueOf(r101.f477329a.size()));
        VideoModel r104 = r101.f477332d;
        if (r104 == null) goto L7;
        int r105 = 1;
    L8:
        if (r110 != 0) goto L11;
        if (r104 == null) goto L11;
        String r106 = "video";
    L12:
        Long r107 = r101.f477333e;
        Long r108 = r101.f477334f;
        if (r108 == null) goto L15;
        long r109 = r108.longValue();
    L17:
        if (r109 < 4) goto L19;
        boolean r111 = true;
    L20:
        Pair[] r112 = new Pair[10];
        r112[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMENT_MODULE, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE);
        r112[1] = TuplesKt.to("comment_id", r101.f477335g);
        r112[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK, Integer.valueOf(r110 + 1));
        r112[3] = TuplesKt.to("picture_num", Integer.valueOf(r103));
        r112[4] = TuplesKt.to("video_num", Integer.valueOf(r105));
        r112[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_USER_COMMENT_LEVEL, r107);
        r112[6] = TuplesKt.to("page_name", com.bytedance.android.ec.core.event.a.VALUE_COMMENT_CARD);
        r112[7] = TuplesKt.to("content_type", r106);
        r112[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SLIDE_ORDER, Integer.valueOf(r100.f166677e));
        if (r111 == false) goto L23;
        String r113 = "1";
    L24:
        r112[9] = TuplesKt.to("show_selected_comment", r113);
        j73.h.a.a(r102, "comment_content_slide", MapsKt.mapOf(r112), false, null, 60);
        goto L25
    L23:
        r113 = "0";
        goto L24
    L19:
        r111 = false;
        goto L20
    L15:
        r109 = 0;
    L11:
        r106 = "photo";
        goto L12
    L7:
        r105 = 0;
    L25:
        n0 r114 = this.f166671a;
        if (r114.f166678f == false) goto L29;
        r114.f166678f = false;
        return;
    }

    public m0(n0 r100, List r101, fi3.v r102, View r103) {
        this.f166671a = r100;
        this.f166672b = r101;
        this.f166673c = r102;
        this.f166674d = r103;
    }
}
