package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.model.live.CommentPinContent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.PinService")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IPinService;", "Lcom/bytedance/android/live/base/IService;", "Lp32/d;", "getPinContainerHighlightProcessor", "getPSPinContainerHighlightProcessor", "Lcom/bytedance/android/livesdkapi/depend/model/live/CommentPinContent;", "commentPinContent", "", "pinComment", "", "isAnchor", "hasPinPermission", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPinService extends IService {
    p32.d getPSPinContainerHighlightProcessor();

    p32.d getPinContainerHighlightProcessor();

    boolean hasPinPermission(boolean r100);

    void pinComment(CommentPinContent r100);
}
