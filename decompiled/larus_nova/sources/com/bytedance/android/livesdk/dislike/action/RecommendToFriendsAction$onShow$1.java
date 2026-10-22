package com.bytedance.android.livesdk.dislike.action;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class RecommendToFriendsAction$onShow$1 implements ILiveRecommendToFriendsCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecommendToFriendsAction f122056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f122057b;

    @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
    public final void onFailed() {
        Function1 r100 = this.f122057b;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke(new HashMap());
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
    public final void onLiveRecommendSuccess(long r100) {
        int r101 = RecommendLiveHelper.f122216a;
        final boolean r102 = RecommendLiveHelper.b(r100);
        Pair[] r103 = new Pair[2];
        if (r102 == false) goto L5;
        int r104 = R.string.ttlive_recommend_live_to_friends_cancel;
    L6:
        r103[0] = TuplesKt.to("title", s1.B(r104));
        r103[1] = TuplesKt.to("option_action", new RecommendToFriendsAction$onShow$1$onLiveRecommendSuccess$reloadMap$1(this, r102));
        HashMap r105 = MapsKt.hashMapOf(r103);
        Function1 r106 = this.f122057b;
        if (r106 == null) goto L10;
        Unit r107 = (Unit) r106.invoke(r105);
        return;
    L10:
        return;
    L5:
        r104 = R.string.ttlive_recommend_to_friends_item_title;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback
    public final void onSuccess(long r100) {
        int r101 = RecommendLiveHelper.f122216a;
        final boolean r102 = RecommendLiveHelper.b(r100);
        Pair[] r103 = new Pair[2];
        if (r102 == false) goto L5;
        int r104 = R.string.ttlive_recommend_live_to_friends_cancel;
    L6:
        r103[0] = TuplesKt.to("title", s1.B(r104));
        r103[1] = TuplesKt.to("option_action", new RecommendToFriendsAction$onShow$1$onSuccess$reloadMap$1(this, r102));
        HashMap r105 = MapsKt.hashMapOf(r103);
        Function1 r106 = this.f122057b;
        if (r106 == null) goto L10;
        Unit r107 = (Unit) r106.invoke(r105);
        return;
    L10:
        return;
    L5:
        r104 = R.string.ttlive_recommend_to_friends_item_title;
        goto L6
    }

    public RecommendToFriendsAction$onShow$1(RecommendToFriendsAction r100, Function1 r101) {
        this.f122056a = r100;
        this.f122057b = r101;
    }
}
