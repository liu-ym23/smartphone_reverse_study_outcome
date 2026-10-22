package com.bytedance.android.livesdkapi.feed;

import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IPreviewMultiLinkEffectService;", "", "insertEffectView", "", "view", "Landroid/view/View;", GXTemplateKey.GAIAX_LAYER, "", "removeEffectView", "setFeedViewProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IPreviewMultiLinkEffectProvider;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPreviewMultiLinkEffectService {
    void insertEffectView(View r100, int r101);

    void removeEffectView();

    void setFeedViewProvider(ILivePreviewMultiLinkCommonWidget.IPreviewMultiLinkEffectProvider r100);
}
