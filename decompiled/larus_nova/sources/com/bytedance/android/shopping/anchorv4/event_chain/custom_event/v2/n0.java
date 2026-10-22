package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryViewerPlayerBlockCompat;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n0 extends AbsCommonChainEventImpl<fi3.v> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f166677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f166678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j73.d f166679g;

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<fi3.v> c(Map<String, ? extends Object> r110) {
        int r100 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        if (r110 == null) goto L5;
        Object r101 = r110.get("image_url_array");
    L7:
        if ((r101 instanceof List) == true) goto L9;
        r101 = null;
    L9:
        List r102 = (List) r101;
        if (r102 != null) goto L12;
        r102 = CollectionsKt.emptyList();
    L12:
        if (r110 == null) goto L14;
        Object r103 = r110.get("image_index");
    L16:
        if ((r103 instanceof Number) == true) goto L18;
        r103 = null;
    L18:
        Number r104 = (Number) r103;
        if (r104 != null) goto L21;
        r104 = 0;
    L21:
        int r105 = r104.intValue();
        if (r110 == null) goto L24;
        Object r106 = r110.get(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);
    L26:
        if ((r106 instanceof String) == true) goto L28;
        r106 = null;
    L28:
        String r107 = (String) r106;
        if (r107 != null) goto L31;
        r107 = "";
    L31:
        int r108 = di3.c.f468736a;
        if (r110 == null) goto L34;
        Object r109 = r110.get("video");
    L36:
        if ((r109 instanceof Map) == true) goto L38;
        r109 = null;
    L38:
        VideoModel r111 = (VideoModel) di3.c.a((Map) r109, VideoModel.class);
        if (r110 == null) goto L41;
        Object r112 = r110.get(com.bytedance.android.ec.core.event.a.KEY_COMMENT_RANK);
    L43:
        if ((r112 instanceof Number) == true) goto L45;
        r112 = null;
    L45:
        Number r113 = (Number) r112;
        if (r113 == null) goto L48;
        Long r114 = Long.valueOf(r113.longValue());
    L49:
        if (r110 == null) goto L51;
        Object r115 = r110.get("comment_id");
    L53:
        if ((r115 instanceof Number) == true) goto L55;
        r115 = null;
    L55:
        Number r116 = (Number) r115;
        if (r116 == null) goto L58;
        Long r117 = Long.valueOf(r116.longValue());
    L60:
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(new fi3.v(r102, r105, r107, r111, r114, r117, 32));
    L58:
        r117 = null;
        goto L60
    L51:
        r115 = null;
        goto L53
    L48:
        r114 = null;
        goto L49
    L41:
        r112 = null;
        goto L43
    L34:
        r109 = null;
        goto L36
    L24:
        r106 = null;
        goto L26
    L14:
        r103 = null;
        goto L16
    L5:
        r101 = null;
        goto L7
    }

    public n0(com.bytedance.android.ecom.arch.slice.action.v r100, Context r101, j73.d r102) {
        Intrinsics.checkNotNullParameter("PDPOpenCommentItemPreview", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorV4VM");
        super("PDPOpenCommentItemPreview", r100, r101);
        this.f166679g = r102;
        this.f166678f = true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r310, fi3.v r311, Function1 r312) {
        fi3.v r100 = r311;
        Intrinsics.checkNotNullParameter(r310, "eventContext");
        Intrinsics.checkNotNullParameter(r312, "completion");
        if (r100 != null) goto L5;
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        com.bytedance.kmp.ec.yata.chain.event.b r102 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "PDPOpenCommentItemPreviewActionEvent onHandle failed, eventFields is null", null, null, 57);
    L44:
        r312.invoke(r102);
        return;
    L5:
        View r103 = yp.a.c(r310);
        if (r103 != null) goto L8;
        int r104 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "PDPOpenCommentItemPreviewActionEvent onHandle failed, view is null", null, null, 57);
        goto L44
    L8:
        Context r105 = r103.getContext();
        int r106 = Math.max(0, r100.f477330b);
        ArrayList r107 = new ArrayList();
        VideoModel r108 = r100.f477332d;
        if (r108 != null) goto L11;
        fj.d r109 = null;
    L17:
        if (r109 == null) goto L20;
        r107.add(r109);
    L20:
        if ((r100.f477329a.size() + (!r107.isEmpty() ? 1 : 0)) != 0) goto L23;
        int r110 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "PDPOpenCommentItemPreviewActionEvent onHandle failed, sourceCount is 0", null, null, 57);
        goto L44
    L23:
        if ((!r107.isEmpty()) == false) goto L31;
        fj.d r111 = (fj.d) CollectionsKt.getOrNull(r107, 0);
        VideoHolder r112 = new VideoHolder(r105, false, true, 14);
        if (r111 == null) goto L30;
        ECUrlModel r113 = new ECUrlModel();
        String r114 = r111.f477440g;
        if (r114 != null) goto L29;
        r114 = "";
    L29:
        r113.setUrlList(CollectionsKt.listOf(r114));
        Unit r115 = Unit.INSTANCE;
        r112.f(r111, r113, PDPOpenCommentItemPreviewActionEvent$onHandleInternal$videoHolder$1$2.INSTANCE);
    L30:
        r112.b();
    L32:
        GalleryViewerPlayerBlockCompat r116 = new GalleryViewerPlayerBlockCompat(r105);
        if ((!r107.isEmpty()) == true) goto L35;
    L39:
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r100.f477329a.iterator();
    L41:
        if (r118.hasNext() == false) goto L43;
        String r119 = (String) r118.next();
        int r120 = com.bytedance.android.ec.model.k.f47871n;
        r117.add(com.bytedance.android.ec.model.k.a.c(r119, null));
        goto L41
    L43:
        Unit r121 = Unit.INSTANCE;
        r116.a(r117, true);
        r116.setOnDismissListener(new l0(this, r107, r112, r103));
        r116.setOnPageSelectedListener(new m0(this, r107, r100, r103));
        r116.showAnimated(r106, r103);
        int r122 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L44
    L35:
        if ((r112 instanceof ee3.c) == true) goto L37;
        ee3.c r123 = null;
    L38:
        r116.b(r123);
        goto L39
    L37:
        r123 = r112;
        goto L38
    L31:
        r112 = null;
        goto L32
    L11:
        String r124 = r108.getMainUrl();
        String r125 = r108.getBackupUrl();
        String r126 = r108.getVid();
        long r127 = r108.getWidth();
        long r128 = r108.getHeight();
        Integer r129 = r108.getDuration();
        if (r129 == null) goto L14;
        long r130 = r129.intValue();
    L15:
        r109 = new fj.d(r124, r125, r126, r127, r128, r130, r108.getPosterUrl(), false, false, false, false, false, null, false, 0, null, null, 130944);
        goto L17
    L14:
        r130 = 0;
        goto L15
    }
}
