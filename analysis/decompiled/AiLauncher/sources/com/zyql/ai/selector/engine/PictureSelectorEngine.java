package com.zyql.ai.selector.engine;

import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnResultCallbackListener;

/* loaded from: classes4.dex */
public interface PictureSelectorEngine {
    ImageEngine createEngine();

    OnResultCallbackListener<LocalMedia> getResultCallbackListener();
}
