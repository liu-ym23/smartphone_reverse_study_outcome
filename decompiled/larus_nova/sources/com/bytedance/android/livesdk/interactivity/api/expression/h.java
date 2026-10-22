package com.bytedance.android.livesdk.interactivity.api.expression;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.w;
import com.bytedance.android.livesdk.interactivity.service.emoji.recent.EmojiLocalRecentManager;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133214a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v8 */
    @JvmStatic
    public static final List<BaseEmoji> b(int r110) {
        com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r100 = null;
        com.bytedance.android.livesdk.interactivity.api.h r101 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r101 == null) goto L8;
        m<w> r102 = r101.getRecommendShortcutEmoji();
        if (r102 == null) goto L8;
        w r103 = r102.getValue();
        if (r103 == null) goto L8;
    L9:
        if (r103 == null) goto L16;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.f> r104 = r103.emojiItems;
        if (r104 == null) goto L16;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.f> r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.f r108 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.api.f) r107.next();
        r106.add(new fb2.b(r108.content, r108.score));
    L17:
        IMiddlewareHostBusiness r109 = (IMiddlewareHostBusiness) jc1.k.f(IMiddlewareHostBusiness.class);
        if (r109 == null) goto L20;
        ?? r111 = r109.getRecommendEmojiList();
    L21:
        int r112 = ab2.a.f2469a;
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.interactivity.service.emoji.recent.c> r113 = EmojiLocalRecentManager.f140846a;
        IMiddlewareHostBusiness r114 = (IMiddlewareHostBusiness) jc1.k.f(IMiddlewareHostBusiness.class);
        int r115 = 0;
        if (r114 != null) goto L24;
    L55:
        if (r111 != 0) goto L57;
    L61:
        if (r111 != 0) goto L78;
        r111 = new ArrayList();
        Iterator r116 = EmojiLocalRecentManager.b().iterator();
    L64:
        if (r116.hasNext() == false) goto L78;
        com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r117 = (com.bytedance.android.livesdk.interactivity.service.emoji.recent.b) r116.next();
        ab2.b r118 = ab2.b.a();
        String r119 = r117.b();
        r118.f2471a.getClass();
        IMiddleWareHostEmoji r120 = (IMiddleWareHostEmoji) jc1.k.f(IMiddleWareHostEmoji.class);
        if (r120 == null) goto L68;
        List<BaseEmoji> r121 = r120.loadAllBaseEmoji();
    L69:
        Iterator<BaseEmoji> r122 = r121.iterator();
    L71:
        if (r122.hasNext() == false) goto L75;
        BaseEmoji r123 = r122.next();
        if (r119.equals(r123.getDescription()) == false) goto L71;
    L76:
        if (r123 == null) goto L64;
        r111.add(r123);
        goto L64
    L75:
        r123 = null;
        goto L76
    L68:
        r121 = new ArrayList();
    L78:
        ?? r124 = r111;
        Iterator r125 = ((Iterable) r124).iterator();
    L80:
        if (r125.hasNext() == false) goto L89;
        Object r126 = r125.next();
        int r127 = r115 + 1;
        if (r115 >= 0) goto L84;
        CollectionsKt.throwIndexOverflow();
    L84:
        BaseEmoji r128 = (BaseEmoji) r126;
        r128.isLatestUseEmoji = true;
        r128.position = r115;
        BaseEmoji r129 = (BaseEmoji) ((HashMap) EmojiLocalRecentManager.f140848c).get(r128.getDescription());
        if (r129 == null) goto L87;
        r128.recommendScore = r129.recommendScore;
    L87:
        r115 = r127;
    L89:
        return CollectionsKt.take((Iterable) r124, r110);
    L57:
        if ((!((Collection) r111).isEmpty()) != true) goto L61;
        if (r111.size() <= 8) goto L61;
        r111 = r111.subList(0, 8);
        goto L61
    L24:
        if (r114.isEnablePersonalRecommend() != true) goto L55;
        if (r106 != null) goto L27;
    L30:
        boolean r130 = true;
    L31:
        if (r130 == true) goto L55;
        EmojiLocalRecentManager.c();
        LinkedHashMap<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b> r131 = EmojiLocalRecentManager.f140850e;
        int r132 = fb2.e.f476259a;
        if (r131 != null) goto L35;
        r124 = CollectionsKt.emptyList();
        goto L89
    L35:
        Iterator<Map.Entry<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b>> r133 = r131.entrySet().iterator();
    L37:
        if (r133.hasNext() == false) goto L43;
        Map.Entry<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b> r134 = r133.next();
        if (r100 == null) goto L42;
        if (r134.getValue().d() <= r100.d()) goto L37;
    L42:
        r100 = r134.getValue();
        goto L37
    L43:
        if (r100 == null) goto L45;
        long r135 = r100.d();
    L46:
        long r136 = Math.max(1, r135);
        HashMap r137 = new HashMap();
        if (r106 == null) goto L54;
        Iterator r138 = r106.iterator();
    L50:
        if (r138.hasNext() == false) goto L54;
        fb2.b r139 = (fb2.b) r138.next();
        String r140 = r139.f476251a;
        if (r140 == null) goto L50;
        r137.put(r140, r139);
    L54:
        r124 = new ArrayList();
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.interactivity.service.emoji.recent.c> r141 = EmojiLocalRecentManager.f140846a;
        r124.addAll(EmojiLocalRecentManager.a());
        CollectionsKt.sortWith(r124, new fb2.d(r131, r137, r136, com.bytedance.android.livesdk.interactivity.service.settings.h.f140996a.getValue()));
        goto L89
    L45:
        r135 = 0;
        goto L46
    L27:
        if (r106.isEmpty() == true) goto L30;
        r130 = false;
        goto L31
    L20:
        r111 = 0;
    L16:
        r106 = null;
    L8:
        r103 = l42.a.f507323j.getValue();
        goto L9
    }

    public static com.bytedance.android.live.core.widget.j a(Context r100, com.bytedance.android.live.base.model.message.h r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "guideChat");
        Intrinsics.checkNotNullParameter(r102, "text");
        com.bytedance.android.live.core.widget.j r103 = new com.bytedance.android.live.core.widget.j(r100);
        r103.setText(r102);
        r103.setTextColor(s1.h(R.color.ttlive_guide_chat_text_color));
        return r103;
    }
}
