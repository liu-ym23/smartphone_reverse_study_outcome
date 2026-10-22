package com.bytedance.android.live.media.impl;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.media.api.IMediaService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/media/impl/MediaService;", "Lcom/bytedance/android/live/media/api/IMediaService;", "()V", "createView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isPortrait", "", "getCloseBtnView", "view", "getMediaAnchorResId", "", "getMediaDetailMaskResId", "getMediaIntroductionResId", "getMediaMoveDownCloseResId", "getMediaTitleResId", "getMediaWatchNumberResId", "hideMediaIntroduction", "", "initMediaView", "manager", "Lcom/bytedance/android/live/core/tetris/widgets/RecyclableWidgetManager;", "prepareReplayWidget", "setInteractionVisibility", KtvSubElement.CONTAINER, "visible", "immediately", "livemedia-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MediaService implements IMediaService {
    @Override // com.bytedance.android.live.media.api.IMediaService
    public View getCloseBtnView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return null;
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public int getMediaAnchorResId() {
        return R.id.media_anchor_container;
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public int getMediaDetailMaskResId() {
        return R.id.media_detail_mask;
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public int getMediaIntroductionResId() {
        return R.id.media_introduction_container;
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public int getMediaMoveDownCloseResId() {
        return R.id.media_close_view;
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public int getMediaTitleResId() {
        return R.id.media_title_container;
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public int getMediaWatchNumberResId() {
        return R.id.media_count_online_container;
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public void hideMediaIntroduction(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public void initMediaView(View r100, RecyclableWidgetManager r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "manager");
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public void prepareReplayWidget(View r100, boolean r101) {
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public void setInteractionVisibility(View r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
    }

    public MediaService() {
        k.l(IMediaService.class, this);
    }

    @Override // com.bytedance.android.live.media.api.IMediaService
    public View createView(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new View(r100);
    }
}
