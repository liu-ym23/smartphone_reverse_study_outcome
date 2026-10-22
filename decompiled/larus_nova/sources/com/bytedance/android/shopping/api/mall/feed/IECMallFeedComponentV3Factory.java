package com.bytedance.android.shopping.api.mall.feed;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\r\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/feed/IECMallFeedComponentV3Factory;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/shopping/api/mall/feed/b;", "config", "Lcom/bytedance/android/shopping/api/mall/feed/e;", "containerAbility", "Lcom/bytedance/android/shopping/api/mall/feed/f;", "stateListener", "Lcom/bytedance/android/shopping/api/mall/feed/d;", "createFeedComponent", "Lcom/bytedance/android/shopping/api/mall/feed/g;", "homepagePrefetch", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallFeedComponentV3Factory {
    d createFeedComponent(Context r100, b r101, e r102, f r103);

    g homepagePrefetch();
}
