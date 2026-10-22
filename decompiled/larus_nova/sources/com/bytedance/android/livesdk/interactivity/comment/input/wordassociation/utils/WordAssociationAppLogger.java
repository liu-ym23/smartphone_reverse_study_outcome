package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.utils;

import c32.d;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.interactivity.api.emoji.a;
import com.bytedance.android.livesdk.interactivity.common.utils.b;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class WordAssociationAppLogger extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f135226a = 0;

    static {
    }

    public WordAssociationAppLogger() {
    }

    public static Pair c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "str");
        List r111 = GsonHelper.fromJsonArray(r110, a.class);
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        Iterator r102 = r111.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = ((a) r102.next()).c();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r100.add(r103);
        goto L4
    L9:
        a r112 = (a) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L18;
        List<String> r113 = r112.e();
        if (r113 == null) goto L18;
        Iterator<T> r114 = r113.iterator();
    L15:
        if (r114.hasNext() == false) goto L18;
        r101.add((String) r114.next());
    L18:
        return new Pair(CollectionsKt.joinToString$default(r100, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null), CollectionsKt.joinToString$default(r101, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null));
    }

    @JvmStatic
    public static final void d(final d r100, final String r110, final String r111, final boolean r112, final String r113, final long r114) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r110, "entranceType");
        Intrinsics.checkNotNullParameter(r111, "content");
        b.a("livesdk_comment_association_entrance_click", new WordAssociationAppLogger$sendAssociationEntranceClickEvent$1(r100, r110, r112, r113, r114, r111));
    }

    @JvmStatic
    public static final void e(final List<? extends d> r110, final List<String> r111, final List<String> r112, final boolean r113, final String r114, final long r115, final long r116) {
        Intrinsics.checkNotNullParameter(r110, "associationResultList");
        Intrinsics.checkNotNullParameter(r111, "entranceTypes");
        Intrinsics.checkNotNullParameter(r112, "contents");
        b.a("livesdk_comment_association_entrance_hide", new WordAssociationAppLogger$sendAssociationEntranceDismissEvent$1(r111, r113, r114, r115, r112, r116, r110));
    }

    @JvmStatic
    public static final void f(final List<? extends d> r110, final List<String> r111, final List<String> r112, final long r113, final boolean r114, final String r115, final long r116) {
        Intrinsics.checkNotNullParameter(r110, "associationResultList");
        Intrinsics.checkNotNullParameter(r111, "entranceTypes");
        Intrinsics.checkNotNullParameter(r112, "contents");
        xs2.b r100 = xs2.b.a();
        if (r100 == null) goto L5;
        r100.post(new u22.b(r111, false));
    L5:
        b.a("livesdk_comment_association_entrance_show", new WordAssociationAppLogger$sendAssociationEntranceShowEvent$1(r110, r111, r114, r115, r116, r112, r113));
    }

    public static void g(final d r110, final a r111, final String r112, final String r113, final boolean r114, final String r115, final long r116) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r111, "fusionEmoji");
        Intrinsics.checkNotNullParameter(r112, "entranceType");
        Intrinsics.checkNotNullParameter(r113, "content");
        b.a("livesdk_comment_association_entrance_click", new WordAssociationAppLogger$sendFusionEmojiEntranceClickEvent$1(r112, r114, r115, r116, r113, r111, r110));
    }
}
