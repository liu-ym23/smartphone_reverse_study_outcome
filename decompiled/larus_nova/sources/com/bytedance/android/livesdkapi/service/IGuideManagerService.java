package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IGuideManagerService;", "Lcom/bytedance/android/live/base/IService;", "isShowingAuthDialog", "", "isShowingBottomGuide", "isShowingCleanGuide", "isShowingGuide", "isShowingSlideUpGuide", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGuideManagerService extends IService {
    boolean isShowingAuthDialog();

    boolean isShowingBottomGuide();

    boolean isShowingCleanGuide();

    boolean isShowingGuide();

    boolean isShowingSlideUpGuide();
}
