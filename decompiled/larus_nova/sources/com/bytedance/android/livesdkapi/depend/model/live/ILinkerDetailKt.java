package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdk.link.model.z5;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\"!\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0019\u0010\n\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\b\u0010\t*\n\u0010\u000b\"\u00020\u00002\u00020\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/z5;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkerDetailKt;", "", "", "getPlayModesEx", "(Lcom/bytedance/android/livesdk/link/model/z5;)Ljava/util/List;", "playModesEx", "", "getUiLayoutExt", "(Lcom/bytedance/android/livesdk/link/model/z5;)I", "uiLayoutExt", "ILinkerDetailKt", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class ILinkerDetailKt {
    public static final List<Long> getPlayModesEx(z5 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$playModesEx");
        return r100.getPlayModes();
    }

    public static final int getUiLayoutExt(z5 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$uiLayoutExt");
        return r100.getUiLayout();
    }
}
