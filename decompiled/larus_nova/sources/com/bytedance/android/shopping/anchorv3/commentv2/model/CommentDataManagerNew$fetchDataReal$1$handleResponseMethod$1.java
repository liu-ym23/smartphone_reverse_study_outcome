package com.bytedance.android.shopping.anchorv3.commentv2.model;

import com.bytedance.android.ec.model.response.f1;
import com.bytedance.android.shopping.anchorv3.comment.LoadState;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.anchorv3.commentv2.api.CommentResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "p1", "", "p2", "Lcom/bytedance/android/shopping/anchorv3/commentv2/api/CommentResponse;", "p3", "Lcom/bytedance/android/shopping/anchorv3/commentv2/model/CommentRefreshFrom;", "p4", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CommentDataManagerNew$fetchDataReal$1$handleResponseMethod$1 extends FunctionReferenceImpl implements Function4<Boolean, CommentResponse, CommentRefreshFrom, Long, Unit> {
    public CommentDataManagerNew$fetchDataReal$1$handleResponseMethod$1(a r100) {
        super(4, r100, a.class, "handleSimilarResponse", "handleSimilarResponse(ZLcom/bytedance/android/shopping/anchorv3/commentv2/api/CommentResponse;Lcom/bytedance/android/shopping/anchorv3/commentv2/model/CommentRefreshFrom;J)V", 0);
    }

    public final void invoke(boolean r210, CommentResponse r211, CommentRefreshFrom r212, long r213) {
        Intrinsics.checkNotNullParameter(r211, "p2");
        Intrinsics.checkNotNullParameter(r212, "p3");
        a r110 = (a) this.receiver;
        if (r210 == false) goto L7;
        r110.getClass();
        r110.f164731b = null;
        if (r211.getCommentNpsData() == null) goto L9;
        r110.getClass();
    L9:
        if (r212.needFetchTab() == true) goto L21;
        List<CommentNodeVO> r100 = r110.a(r210, r110.f164731b, r211, true);
        boolean r101 = r211.getHasMore();
        LoadState r102 = LoadState.LOADED;
        if (r210 == true) goto L16;
        p53.b r103 = r110.f164731b;
        if (r103 == null) goto L15;
        f1 r104 = r103.f527770c;
    L17:
        f1 r111 = r104;
    L18:
        r110.f164731b = new p53.b(r100, r101, r102, 1, r212, false, 0, r111, 0, MediaPlayer.MEDIA_PLAYER_OPTION_OUT_OF_SYNC_WHEN_PROGRESS_AHEAD);
        r211.getHasMore();
        Intrinsics.checkNotNullParameter(r212, "refreshFrom");
        throw null;
    L15:
        r111 = null;
        goto L18
    L16:
        r104 = r211.getSurveyV2();
        goto L17
    L21:
        throw null;
    L7:
        int r105 = a.f164729c;
        r110.getClass();
        goto L9
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, CommentResponse r101, CommentRefreshFrom r102, Long r110) {
        invoke(r100.booleanValue(), r101, r102, r110.longValue());
        return Unit.INSTANCE;
    }
}
