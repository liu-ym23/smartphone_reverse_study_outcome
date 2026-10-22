package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i extends InfoItemAnim<Pair<? extends CharSequence, ? extends String>> {
    public i(Query r100, Query r101) {
        super(r100, r101, 0.5f);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.InfoItemAnim
    public final void a(Pair<? extends CharSequence, ? extends String> r100, Query r101) {
        Pair<? extends CharSequence, ? extends String> r102 = r100;
        Intrinsics.checkNotNullParameter(r101, "query");
        Query r103 = r101.b(R.id.iv_info_user_head);
        r103.g(8);
        Query r104 = r101.b(R.id.tv_info_text);
        r104.g(8);
        if (r102 == null) goto L7;
        CharSequence r105 = r102.getFirst();
        if (r105 == null) goto L7;
        r104.g(0);
        r104.e(r105);
    L7:
        if (r102 == null) goto L19;
        String r106 = r102.getSecond();
        if (r106 == null) goto L19;
        if (r106.length() <= 0) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == true) goto L17;
        r106 = null;
    L17:
        if (r106 == null) goto L19;
        r103.g(0);
        ECNetImageView r108 = (ECNetImageView) r103.f();
        r108.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        r108.setImageURI(r106);
        return;
    L13:
        r107 = false;
    L19:
        r103.c();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.InfoItemAnim
    public final boolean b(Pair<? extends CharSequence, ? extends String> r100, Pair<? extends CharSequence, ? extends String> r101) {
        Pair<? extends CharSequence, ? extends String> r102 = r100;
        Pair<? extends CharSequence, ? extends String> r103 = r101;
        if (r102 == null) goto L11;
        if (r103 == null) goto L11;
        if (Intrinsics.areEqual(r102.getFirst(), r103.getFirst()) == false) goto L11;
        if (Intrinsics.areEqual(r102.getSecond(), r103.getSecond()) == false) goto L11;
        return false;
    L11:
        return true;
    }
}
