package com.bytedance.android.livesdk.utils;

import com.ss.android.ugc.aweme.debug.tag.base.LocalTestTag;
import com.ss.android.ugc.aweme.live.ILiveUtils4Plugin;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/utils/LiveUtils4Plugin;", "Lcom/ss/android/ugc/aweme/live/ILiveUtils4Plugin;", "()V", "getLiveTag", "Ljava/lang/Class;", "Lcom/ss/android/ugc/aweme/debug/tag/base/LocalTestTag;", "isSaas", "", "live-utils_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveUtils4Plugin implements ILiveUtils4Plugin {
    public LiveUtils4Plugin() {
    }

    @Override // com.ss.android.ugc.aweme.live.ILiveUtils4Plugin
    public boolean isSaas() {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.live.ILiveUtils4Plugin
    public Class<? extends LocalTestTag> getLiveTag() {
        return wy.a.class;
    }
}
