package com.bytedance.android.shopping.anchorv3.commentv2.model;

import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.anchorv3.commentv2.api.CommentResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p53.g;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f164729c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p53.b f164730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p53.b f164731b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv3.commentv2.model.a$a, reason: collision with other inner class name */
    public static final class C2508a {
    }

    static {
    }

    public final List<CommentNodeVO> a(boolean r100, p53.b r101, CommentResponse r102, boolean r103) {
        if (r102 == null) goto L7;
        String r104 = r102.getNoticeDesc();
        if (r104 == null) goto L7;
        com.bytedance.android.shopping.anchorv3.a.b(r104);
    L7:
        if (r102 == null) goto L9;
        r102.getNoticePopUp();
    L9:
        if (r102 == null) goto L12;
        r102.getProductName();
    L12:
        if (r102 == null) goto L23;
        List<PromotionProductSkuStruct> r105 = r102.getSkuInfo();
        if (r105 == null) goto L23;
        if ((!r105.isEmpty()) == true) goto L19;
        r105 = null;
    L19:
        if (r105 == null) goto L23;
        Intrinsics.checkNotNullParameter(r105, "skuInfoList");
        throw null;
    L23:
        if (r102 != null) goto L25;
    L28:
        if (r102 == null) goto L40;
        List<PromotionProductCommentDTO> r106 = r102.getComments();
        if (r106 == null) goto L40;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L33:
        if (r108.hasNext() == false) goto L37;
        Long r109 = ((PromotionProductCommentDTO) r108.next()).getId();
        if (r109 == null) goto L33;
        r107.add(r109);
        goto L33
    L37:
        if (r103 == false) goto L39;
        r107.toString();
        goto L40
    L39:
        r107.toString();
    L40:
        ArrayList r110 = new ArrayList();
        if (r100 == true) goto L46;
        if (r101 == null) goto L46;
        List<CommentNodeVO> r111 = r101.f527768a;
        if (r111 == null) goto L46;
        r110.addAll(r111);
    L46:
        if (r102 == null) goto L58;
        List<PromotionProductCommentDTO> r112 = r102.getComments();
        if (r112 == null) goto L58;
        List<PromotionProductCommentDTO> r113 = r112;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r115 = r113.iterator();
    L51:
        if (r115.hasNext() == false) goto L57;
        PromotionProductCommentDTO r116 = (PromotionProductCommentDTO) r115.next();
        Map<String, String> r117 = r102.getExtraInfo();
        if (r117 == null) goto L55;
        String r118 = r117.get("gold_card_schema");
    L56:
        r114.add(g.b(r116, true, r118, 6));
        goto L51
    L55:
        r118 = null;
        goto L56
    L57:
        r110.addAll(r114);
    L58:
        return r110;
    L25:
        if (r102.getToastData() == null) goto L28;
        throw null;
    }
}
