package com.bytedance.android.livesdk.interactivity.comment.input;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoCommentPreviewFragment f135175a;

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback
    public final void onDismiss() {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback
    public final void onPlayCompletedFirstTime(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback
    public final void onPlayFailed(String r100, String r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback
    public final void onPlaying(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback
    public final void onRenderFirstFrame(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback
    public final void onShow() {
    }

    public j(VideoCommentPreviewFragment r100) {
        this.f135175a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback
    public final void onResumePlay(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f135175a.f135093v = true;
        if ("click".equals(r101) == false) goto L6;
        VideoCommentPreviewFragment.U90(this.f135175a);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback
    public final void onPausePlay(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f135175a.f135093v = false;
        if ("click".equals(r102) == false) goto L6;
        VideoCommentPreviewFragment.U90(this.f135175a);
        return;
    }
}
