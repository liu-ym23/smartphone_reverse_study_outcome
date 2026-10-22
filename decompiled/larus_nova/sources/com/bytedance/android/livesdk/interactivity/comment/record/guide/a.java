package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f136126a;

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public void a(RecordGuideContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public final void onDialogDismiss() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public void b() {
        this.f136126a.clear();
    }

    public a() {
        this.f136126a = new CompositeDisposable();
    }
}
