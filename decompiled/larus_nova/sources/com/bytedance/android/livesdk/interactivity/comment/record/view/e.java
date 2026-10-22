package com.bytedance.android.livesdk.interactivity.comment.record.view;

import com.bytedance.android.livesdk.interactivity.comment.record.event.HighlightRecordEvent;
import com.bytedance.android.livesdk.interactivity.comment.record.viewmodel.HighlightRecordContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHighlightRecordTetris f136215a;

    public e(LiveHighlightRecordTetris r100) {
        this.f136215a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        HighlightRecordEvent r101 = (HighlightRecordEvent) r100;
        LiveHighlightRecordTetris r102 = this.f136215a;
        r102.getClass();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getType() != HighlightRecordEvent.Type.START) goto L11;
        HighlightRecordContext r103 = r102.V();
        if (r103 == null) goto L14;
        r103.reqRecord(true);
        return;
    L14:
        return;
    L11:
        if (r101.getType() != HighlightRecordEvent.Type.STOP) goto L16;
        LiveHighlightRecordTetris.StopType r104 = LiveHighlightRecordTetris.StopType.OverTime;
        r102.Z();
        return;
    }
}
