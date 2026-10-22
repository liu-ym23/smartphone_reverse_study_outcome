package com.zyql.ai.selector.engine;

import android.content.Context;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnCallbackListener;
import java.util.List;

/* loaded from: classes4.dex */
public interface CompressEngine {
    void onCompress(Context context, List<LocalMedia> list, OnCallbackListener<List<LocalMedia>> onCallbackListener);
}
