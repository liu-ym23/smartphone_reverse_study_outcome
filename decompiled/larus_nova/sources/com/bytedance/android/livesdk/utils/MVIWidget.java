package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.arch.mvi.widgetcompat.MVIDataWidget;
import com.bytedance.android.livesdk.utils.b2;
import com.bytedance.android.livesdk.utils.g2;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\u0014\b\u0002\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00052\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\b0\u0007B\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/utils/MVIWidget;", "Lcom/bytedance/android/livesdk/utils/g2;", "STATE", "", "INTENT", "Lcom/bytedance/android/livesdk/utils/b2;", "M", "Lcom/bytedance/android/live/core/arch/mvi/widgetcompat/MVIDataWidget;", "Lcom/bytedance/live/datacontext/DataContext;", "<init>", "()V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MVIWidget<STATE extends g2, INTENT, M extends b2<INTENT, STATE>> extends MVIDataWidget<STATE, INTENT, M, DataContext> {
    public MVIWidget() {
    }

    @Override // com.bytedance.android.live.core.arch.mvi.widgetcompat.MVIDataWidget, androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        super.wq((g2) r100);
    }

    @Override // com.bytedance.android.live.core.arch.mvi.widgetcompat.MVIDataWidget
    public final void wq(STATE r100) {
        super.wq(r100);
    }
}
