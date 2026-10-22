package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomToolbarContainerDataManager f116069a;

    public a(BottomToolbarContainerDataManager r100) {
        this.f116069a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.f116069a.s(((s) r101).f116196f)), Integer.valueOf(this.f116069a.s(((s) r100).f116196f)));
    }
}
