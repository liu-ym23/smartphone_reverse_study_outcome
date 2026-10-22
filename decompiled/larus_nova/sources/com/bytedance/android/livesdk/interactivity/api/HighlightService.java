package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.pin.container.v1.HighlightDataContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/HighlightService;", "Lcom/bytedance/android/livesdk/interactivity/api/IHighlightService;", "Lo32/b;", "createHighlightContext", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HighlightService implements IHighlightService {
    public HighlightService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IHighlightService
    public o32.b createHighlightContext() {
        return new HighlightDataContext();
    }
}
