package com.bytedance.android;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.scope.j;
import f6.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/GiftRecyclableWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lf6/b;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GiftRecyclableWidget extends LiveRecyclableWidget implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f38112a;

    public GiftRecyclableWidget() {
    }

    @Override // f6.b
    public final void hp(j r100) {
        this.f38112a = r100;
    }
}
