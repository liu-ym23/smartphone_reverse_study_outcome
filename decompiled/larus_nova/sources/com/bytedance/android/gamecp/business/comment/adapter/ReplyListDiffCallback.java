package com.bytedance.android.gamecp.business.comment.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/adapter/ReplyListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplyListDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.comment.data.k> f51968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.business.comment.data.k> f51969b;

    public static final class a {
    }

    static {
    }

    public ReplyListDiffCallback() {
        this(null, null);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        List<com.bytedance.android.gamecp.business.comment.data.k> r100 = this.f51969b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        List<com.bytedance.android.gamecp.business.comment.data.k> r100 = this.f51968a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public ReplyListDiffCallback(List<com.bytedance.android.gamecp.business.comment.data.k> r100, List<com.bytedance.android.gamecp.business.comment.data.k> r101) {
        this.f51968a = r100;
        this.f51969b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        List<com.bytedance.android.gamecp.business.comment.data.k> r102 = this.f51968a;
        Long r103 = null;
        if (r102 == null) goto L5;
        com.bytedance.android.gamecp.business.comment.data.k r104 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r102, r100);
    L6:
        List<com.bytedance.android.gamecp.business.comment.data.k> r105 = this.f51969b;
        if (r105 == null) goto L9;
        com.bytedance.android.gamecp.business.comment.data.k r106 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r105, r101);
    L11:
        if (r106 != null) goto L13;
    L33:
        if (r106 != null) goto L35;
    L44:
        if (r106 != null) goto L46;
    L55:
        if (r104 != null) goto L57;
    L99:
        if (r104 == null) goto L103;
        com.bytedance.android.gamecp.business.comment.data.s r107 = r104.replyInfo;
        if (r107 == null) goto L103;
        Long r108 = Long.valueOf(r107.likeCount);
    L104:
        if (r106 == null) goto L108;
        com.bytedance.android.gamecp.business.comment.data.s r109 = r106.replyInfo;
        if (r109 == null) goto L108;
        Long r110 = Long.valueOf(r109.likeCount);
    L109:
        boolean r111 = Intrinsics.areEqual(r108, r110);
        if (r104 == null) goto L114;
        com.bytedance.android.gamecp.business.comment.data.s r112 = r104.replyInfo;
        if (r112 == null) goto L114;
        Long r113 = Long.valueOf(r112.relationTypeFlag);
    L115:
        if (r106 == null) goto L120;
        com.bytedance.android.gamecp.business.comment.data.s r114 = r106.replyInfo;
        if (r114 == null) goto L120;
        r103 = Long.valueOf(r114.relationTypeFlag);
    L120:
        if (Intrinsics.areEqual(r113, r103) == false) goto L123;
        boolean r115 = false;
    L122:
        boolean r116 = true;
    L125:
        if (r111 == false) goto L129;
        if (r116 == false) goto L129;
        if (r115 == false) goto L129;
        return true;
    L129:
        return false;
    L123:
        r115 = false;
    L124:
        r116 = false;
    L114:
        r113 = null;
    L108:
        r110 = null;
    L103:
        r108 = null;
        goto L104
    L57:
        if (r104.f52043a != 0) goto L99;
        if (r106 == null) goto L99;
        if (r106.f52043a != 0) goto L99;
        com.bytedance.android.gamecp.business.comment.data.b r117 = r104.f52044b;
        if (r117 == null) goto L66;
        com.bytedance.android.gamecp.business.comment.data.o r118 = r117.evaluationInfo;
        if (r118 == null) goto L66;
        Long r119 = Long.valueOf(r118.likeCount);
    L67:
        com.bytedance.android.gamecp.business.comment.data.b r120 = r106.f52044b;
        if (r120 == null) goto L72;
        com.bytedance.android.gamecp.business.comment.data.o r121 = r120.evaluationInfo;
        if (r121 == null) goto L72;
        Long r122 = Long.valueOf(r121.likeCount);
    L73:
        r111 = Intrinsics.areEqual(r119, r122);
        com.bytedance.android.gamecp.business.comment.data.b r123 = r104.f52044b;
        if (r123 == null) goto L78;
        com.bytedance.android.gamecp.business.comment.data.o r124 = r123.evaluationInfo;
        if (r124 == null) goto L78;
        Long r125 = Long.valueOf(r124.dislikeCount);
    L79:
        com.bytedance.android.gamecp.business.comment.data.b r126 = r106.f52044b;
        if (r126 == null) goto L84;
        com.bytedance.android.gamecp.business.comment.data.o r127 = r126.evaluationInfo;
        if (r127 == null) goto L84;
        Long r128 = Long.valueOf(r127.dislikeCount);
    L85:
        r115 = Intrinsics.areEqual(r125, r128);
        com.bytedance.android.gamecp.business.comment.data.b r129 = r104.f52044b;
        if (r129 == null) goto L90;
        com.bytedance.android.gamecp.business.comment.data.o r130 = r129.evaluationInfo;
        if (r130 == null) goto L90;
        Long r131 = Long.valueOf(r130.relationTypeFlag);
    L91:
        com.bytedance.android.gamecp.business.comment.data.b r132 = r106.f52044b;
        if (r132 == null) goto L97;
        com.bytedance.android.gamecp.business.comment.data.o r133 = r132.evaluationInfo;
        if (r133 == null) goto L97;
        r103 = Long.valueOf(r133.relationTypeFlag);
    L97:
        if (Intrinsics.areEqual(r131, r103) == false) goto L124;
    L90:
        r131 = null;
    L84:
        r128 = null;
    L78:
        r125 = null;
    L72:
        r122 = null;
    L66:
        r119 = null;
        goto L67
    L46:
        if (r106.f52043a != 4) goto L55;
        if (r104 == null) goto L55;
        if (r104.f52043a != 4) goto L55;
        if (r106.f52047e == r104.f52047e) goto L53;
    L54:
        return false;
    L53:
        if (r106.f52050h == r104.f52050h) goto L55;
    L35:
        if (r106.f52043a != 5) goto L44;
        if (r104 == null) goto L44;
        if (r104.f52043a != 5) goto L44;
        if (r106.f52046d == r104.f52046d) goto L42;
    L43:
        return false;
    L42:
        if (r106.f52051i == r104.f52051i) goto L44;
    L13:
        if (r106.f52043a != 3) goto L33;
        if (r104 != null) goto L16;
        return true;
    L16:
        if (r104.f52043a != 3) goto L132;
        List<com.bytedance.android.gamecp.business.comment.data.k> r134 = this.f51969b;
        if (r134 == null) goto L22;
        com.bytedance.android.gamecp.business.comment.data.k r135 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r134, r101);
        if (r135 == null) goto L22;
        Long r136 = Long.valueOf(r135.f52045c);
    L23:
        List<com.bytedance.android.gamecp.business.comment.data.k> r137 = this.f51968a;
        if (r137 == null) goto L29;
        com.bytedance.android.gamecp.business.comment.data.k r138 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r137, r100);
        if (r138 == null) goto L29;
        r103 = Long.valueOf(r138.f52045c);
    L29:
        if ((!Intrinsics.areEqual(r136, r103)) == false) goto L133;
        return false;
    L133:
        return true;
    L22:
        r136 = null;
        goto L23
    L132:
        return true;
    L9:
        r106 = null;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r110) {
        List<com.bytedance.android.gamecp.business.comment.data.k> r101 = this.f51969b;
        String r102 = null;
        if (r101 == null) goto L7;
        com.bytedance.android.gamecp.business.comment.data.k r103 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r101, r110);
        if (r103 == null) goto L7;
        Integer r104 = Integer.valueOf(r103.f52043a);
    L8:
        List<com.bytedance.android.gamecp.business.comment.data.k> r105 = this.f51968a;
        if (r105 == null) goto L13;
        com.bytedance.android.gamecp.business.comment.data.k r106 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r105, r100);
        if (r106 == null) goto L13;
        Integer r107 = Integer.valueOf(r106.f52043a);
    L15:
        if ((!Intrinsics.areEqual(r104, r107)) == false) goto L17;
        return false;
    L17:
        if (r104 != null) goto L20;
    L21:
        if (r104 != null) goto L24;
    L25:
        if (r104 != null) goto L28;
    L30:
        if (r104 != null) goto L33;
    L60:
        List<com.bytedance.android.gamecp.business.comment.data.k> r108 = this.f51968a;
        if (r108 == null) goto L67;
        com.bytedance.android.gamecp.business.comment.data.k r109 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r108, r100);
        if (r109 == null) goto L67;
        com.bytedance.android.gamecp.business.comment.data.s r111 = r109.replyInfo;
        if (r111 == null) goto L67;
        String r112 = r111.replyId;
    L68:
        List<com.bytedance.android.gamecp.business.comment.data.k> r113 = this.f51969b;
        if (r113 == null) goto L76;
        com.bytedance.android.gamecp.business.comment.data.k r114 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r113, r110);
        if (r114 == null) goto L76;
        com.bytedance.android.gamecp.business.comment.data.s r115 = r114.replyInfo;
        if (r115 == null) goto L76;
        r102 = r115.replyId;
    L76:
        if (TextUtils.equals(r112, r102) == false) goto L78;
        return true;
    L78:
        return false;
    L67:
        r112 = null;
        goto L68
    L33:
        if (r104.intValue() != 0) goto L60;
        if (r107 == null) goto L60;
        if (r107.intValue() != 0) goto L60;
        List<com.bytedance.android.gamecp.business.comment.data.k> r116 = this.f51968a;
        long r117 = 0;
        if (r116 == null) goto L47;
        com.bytedance.android.gamecp.business.comment.data.k r118 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r116, r100);
        if (r118 == null) goto L47;
        com.bytedance.android.gamecp.business.comment.data.b r119 = r118.f52044b;
        if (r119 == null) goto L47;
        com.bytedance.android.gamecp.business.comment.data.o r120 = r119.evaluationInfo;
        if (r120 == null) goto L47;
        long r121 = r120.evaluationId;
    L48:
        List<com.bytedance.android.gamecp.business.comment.data.k> r122 = this.f51969b;
        if (r122 == null) goto L58;
        com.bytedance.android.gamecp.business.comment.data.k r123 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r122, r110);
        if (r123 == null) goto L58;
        com.bytedance.android.gamecp.business.comment.data.b r124 = r123.f52044b;
        if (r124 == null) goto L58;
        com.bytedance.android.gamecp.business.comment.data.o r125 = r124.evaluationInfo;
        if (r125 == null) goto L58;
        r117 = r125.evaluationId;
    L58:
        if (r121 != r117) goto L60;
        return true;
    L47:
        r121 = 0;
        goto L48
    L28:
        if (r104.intValue() != 5) goto L30;
    L79:
        return true;
    L24:
        if (r104.intValue() == 3) goto L79;
    L20:
        if (r104.intValue() == 4) goto L79;
    L13:
        r107 = null;
    L7:
        r104 = null;
        goto L8
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int r110, int r111) {
        List<com.bytedance.android.gamecp.business.comment.data.k> r100 = this.f51968a;
        if (r100 == null) goto L5;
        com.bytedance.android.gamecp.business.comment.data.k r112 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r100, r110);
    L6:
        List<com.bytedance.android.gamecp.business.comment.data.k> r101 = this.f51969b;
        if (r101 == null) goto L9;
        com.bytedance.android.gamecp.business.comment.data.k r113 = (com.bytedance.android.gamecp.business.comment.data.k) ListProtector.get(r101, r111);
    L10:
        Bundle r102 = new Bundle();
        if (r112 != null) goto L13;
    L22:
        if (r112 != null) goto L24;
    L31:
        if (r112 != null) goto L33;
    L43:
        long r103 = 0;
        if (r112 != null) goto L46;
    L112:
        if (r112 == null) goto L116;
        com.bytedance.android.gamecp.business.comment.data.s r104 = r112.replyInfo;
        if (r104 == null) goto L116;
        Long r105 = Long.valueOf(r104.likeCount);
    L117:
        if (r113 == null) goto L121;
        com.bytedance.android.gamecp.business.comment.data.s r106 = r113.replyInfo;
        if (r106 == null) goto L121;
        Long r107 = Long.valueOf(r106.likeCount);
    L123:
        if ((!Intrinsics.areEqual(r105, r107)) == false) goto L130;
        if (r113 == null) goto L128;
        com.bytedance.android.gamecp.business.comment.data.s r108 = r113.replyInfo;
        if (r108 == null) goto L128;
        long r109 = r108.likeCount;
    L129:
        r102.putLong("comment_like_count", r109);
    L128:
        r109 = 0;
    L130:
        if (r112 == null) goto L134;
        com.bytedance.android.gamecp.business.comment.data.s r114 = r112.replyInfo;
        if (r114 == null) goto L134;
        Long r115 = Long.valueOf(r114.relationTypeFlag);
    L135:
        if (r113 == null) goto L139;
        com.bytedance.android.gamecp.business.comment.data.s r116 = r113.replyInfo;
        if (r116 == null) goto L139;
        Long r117 = Long.valueOf(r116.relationTypeFlag);
    L141:
        if ((!Intrinsics.areEqual(r115, r117)) == false) goto L148;
        if (r113 == null) goto L146;
        com.bytedance.android.gamecp.business.comment.data.s r118 = r113.replyInfo;
        if (r118 == null) goto L146;
        r103 = r118.relationTypeFlag;
    L146:
        r102.putLong("comment_like_status", r103);
    L148:
        if (r102.size() != 0) goto L150;
        return null;
    L150:
        return r102;
    L139:
        r117 = null;
    L134:
        r115 = null;
    L121:
        r107 = null;
    L116:
        r105 = null;
        goto L117
    L46:
        if (r112.f52043a != 0) goto L112;
        if (r113 == null) goto L112;
        if (r113.f52043a != 0) goto L112;
        com.bytedance.android.gamecp.business.comment.data.b r119 = r112.f52044b;
        if (r119 == null) goto L55;
        com.bytedance.android.gamecp.business.comment.data.o r120 = r119.evaluationInfo;
        if (r120 == null) goto L55;
        Long r121 = Long.valueOf(r120.likeCount);
    L56:
        com.bytedance.android.gamecp.business.comment.data.b r122 = r113.f52044b;
        if (r122 == null) goto L61;
        com.bytedance.android.gamecp.business.comment.data.o r123 = r122.evaluationInfo;
        if (r123 == null) goto L61;
        Long r124 = Long.valueOf(r123.likeCount);
    L63:
        if ((!Intrinsics.areEqual(r121, r124)) == false) goto L71;
        com.bytedance.android.gamecp.business.comment.data.b r125 = r113.f52044b;
        if (r125 == null) goto L69;
        com.bytedance.android.gamecp.business.comment.data.o r126 = r125.evaluationInfo;
        if (r126 == null) goto L69;
        long r127 = r126.likeCount;
    L70:
        r102.putLong("comment_like_count", r127);
    L69:
        r127 = 0;
    L71:
        com.bytedance.android.gamecp.business.comment.data.b r128 = r112.f52044b;
        if (r128 == null) goto L76;
        com.bytedance.android.gamecp.business.comment.data.o r129 = r128.evaluationInfo;
        if (r129 == null) goto L76;
        Long r130 = Long.valueOf(r129.dislikeCount);
    L77:
        com.bytedance.android.gamecp.business.comment.data.b r131 = r113.f52044b;
        if (r131 == null) goto L82;
        com.bytedance.android.gamecp.business.comment.data.o r132 = r131.evaluationInfo;
        if (r132 == null) goto L82;
        Long r133 = Long.valueOf(r132.dislikeCount);
    L84:
        if ((!Intrinsics.areEqual(r130, r133)) == false) goto L92;
        com.bytedance.android.gamecp.business.comment.data.b r134 = r113.f52044b;
        if (r134 == null) goto L90;
        com.bytedance.android.gamecp.business.comment.data.o r135 = r134.evaluationInfo;
        if (r135 == null) goto L90;
        long r136 = r135.dislikeCount;
    L91:
        r102.putLong("comment_dislike_count", r136);
    L90:
        r136 = 0;
    L92:
        com.bytedance.android.gamecp.business.comment.data.b r137 = r112.f52044b;
        if (r137 == null) goto L97;
        com.bytedance.android.gamecp.business.comment.data.o r138 = r137.evaluationInfo;
        if (r138 == null) goto L97;
        Long r139 = Long.valueOf(r138.relationTypeFlag);
    L98:
        com.bytedance.android.gamecp.business.comment.data.b r140 = r113.f52044b;
        if (r140 == null) goto L103;
        com.bytedance.android.gamecp.business.comment.data.o r141 = r140.evaluationInfo;
        if (r141 == null) goto L103;
        Long r142 = Long.valueOf(r141.relationTypeFlag);
    L105:
        if ((!Intrinsics.areEqual(r139, r142)) == false) goto L148;
        com.bytedance.android.gamecp.business.comment.data.b r143 = r113.f52044b;
        if (r143 == null) goto L111;
        com.bytedance.android.gamecp.business.comment.data.o r144 = r143.evaluationInfo;
        if (r144 == null) goto L111;
        r103 = r144.relationTypeFlag;
    L111:
        r102.putLong("comment_like_status", r103);
    L103:
        r142 = null;
    L97:
        r139 = null;
    L82:
        r133 = null;
    L76:
        r130 = null;
    L61:
        r124 = null;
    L55:
        r121 = null;
        goto L56
    L33:
        if (r112.f52043a != 4) goto L43;
        if (r113 == null) goto L43;
        if (r113.f52043a != 4) goto L43;
        boolean r145 = r112.f52047e;
        boolean r146 = r113.f52047e;
        if (r145 == r146) goto L40;
        r102.putBoolean("comment_child_has_more", r146);
    L40:
        boolean r147 = r112.f52050h;
        boolean r148 = r113.f52050h;
        if (r147 == r148) goto L43;
        r102.putBoolean("comment_child_loading", r148);
        goto L43
    L24:
        if (r112.f52043a != 3) goto L31;
        if (r113 == null) goto L31;
        if (r113.f52043a != 3) goto L31;
        long r149 = r112.f52045c;
        long r150 = r113.f52045c;
        if (r149 == r150) goto L31;
        r102.putLong("comment_title_total", r150);
        goto L31
    L13:
        if (r112.f52043a != 5) goto L22;
        if (r113 == null) goto L22;
        if (r113.f52043a != 5) goto L22;
        boolean r151 = r112.f52046d;
        boolean r152 = r113.f52046d;
        if (r151 == r152) goto L20;
    L21:
        r102.putBoolean("comment_has_more", r152);
        r113.f52051i = false;
        goto L22
    L20:
        if (r112.f52051i == r113.f52051i) goto L22;
    L9:
        r113 = null;
        goto L10
    L5:
        r112 = null;
        goto L6
    }
}
