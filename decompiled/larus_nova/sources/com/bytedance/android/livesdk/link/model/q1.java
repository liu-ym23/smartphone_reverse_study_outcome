package com.bytedance.android.livesdk.link.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q1 {
    public static final void a(IBattleLinkerInviteMessageExtra r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "logMap");
        Object r102 = null;
        String r103 = "none";
        if (r100 == null) goto L20;
        List<IBattleRivalTag> r104 = r100.getSemiFriendTags();
        if (r104 == null) goto L20;
        Iterator<T> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L15;
        Object r106 = r105.next();
        if (((IBattleRivalTag) r106).getTagType() != IBattleRivalTag.TagType.TypeRelation.ordinal()) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L8;
    L16:
        IBattleRivalTag r108 = (IBattleRivalTag) r106;
        if (r108 == null) goto L20;
        String r109 = r108.getTagDesc();
        if (r109 == null) goto L20;
    L21:
        r101.put("relationship_tag_type", r109);
        if (r100 == null) goto L40;
        List<IBattleRivalTag> r110 = r100.getSemiFriendTags();
        if (r110 == null) goto L40;
        Iterator<T> r111 = r110.iterator();
    L27:
        if (r111.hasNext() == false) goto L34;
        Object r112 = r111.next();
        if (((IBattleRivalTag) r112).getTagType() != IBattleRivalTag.TagType.TypePower.ordinal()) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == false) goto L27;
        r102 = r112;
        goto L34
    L31:
        r113 = false;
    L34:
        IBattleRivalTag r114 = (IBattleRivalTag) r102;
        if (r114 == null) goto L40;
        String r115 = r114.getTagDesc();
        if (r115 == null) goto L40;
        r103 = r115;
    L40:
        r101.put("strength_tag_type", r103);
        return;
    L12:
        r107 = false;
        goto L13
    L15:
        r106 = null;
    L20:
        r109 = "none";
        goto L21
    }
}
