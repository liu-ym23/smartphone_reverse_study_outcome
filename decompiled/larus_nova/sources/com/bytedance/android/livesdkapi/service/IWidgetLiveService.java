package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.provideservices.WidgetLiveServiceImpl")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007H&J\b\u0010\t\u001a\u00020\u0005H&J\u0012\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0007H&J\u0012\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0007H&J\u0010\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007H&J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007H&J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007H&J\u0010\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IWidgetLiveService;", "Lcom/bytedance/android/live/base/IService;", "clearWidgetCache", "", "getBarrageWidget", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;", "getBarrageWidgetClass", "Ljava/lang/Class;", "getCardPlaceWidget", "getCardPlaceWidgetInstance", "getDiggWidget", "getIInteractivityResourceServiceWidget", "getPreviewAnswerQuestionServiceWidget", "getPreviewMsgWinBottomRightWidget", "getPreviewMsgWinTopLeftWidget", "getToolBarWidget", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IWidgetLiveService extends IService {
    void clearWidgetCache();

    AbsMergeWidget getBarrageWidget();

    Class<? extends AbsMergeWidget> getBarrageWidgetClass();

    Class<? extends AbsMergeWidget> getCardPlaceWidget();

    AbsMergeWidget getCardPlaceWidgetInstance();

    Class<? extends AbsMergeWidget> getDiggWidget();

    Class<? extends AbsMergeWidget> getIInteractivityResourceServiceWidget();

    Class<? extends AbsMergeWidget> getPreviewAnswerQuestionServiceWidget();

    Class<? extends AbsMergeWidget> getPreviewMsgWinBottomRightWidget();

    Class<? extends AbsMergeWidget> getPreviewMsgWinTopLeftWidget();

    Class<? extends AbsMergeWidget> getToolBarWidget();
}
