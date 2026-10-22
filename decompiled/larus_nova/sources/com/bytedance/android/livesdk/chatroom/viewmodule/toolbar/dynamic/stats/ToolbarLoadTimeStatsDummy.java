package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats;

import androidx.lifecycle.ViewModel;
import ap1.a;
import com.bytedance.android.livesdk.chatroom.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/stats/ToolbarLoadTimeStatsDummy;", "Landroidx/lifecycle/ViewModel;", "Lap1/a;", "", "status", "", "recordStatus", "tag", "recordTime", "", "isAnchor", "printStatsTime", "Lcom/bytedance/android/livesdk/chatroom/o;", "roomContext", "isEnterFinished", "", "id", "recordComponentStart", "recordComponentEnd", "<init>", "()V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarLoadTimeStatsDummy extends ViewModel implements a {
    @Override // ap1.a
    public boolean isEnterFinished(o r100) {
        return true;
    }

    @Override // ap1.a
    public void printStatsTime(boolean r100) {
    }

    @Override // ap1.a
    public void recordComponentEnd(int r100) {
    }

    @Override // ap1.a
    public void recordComponentStart(int r100) {
    }

    @Override // ap1.a
    public void recordStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
    }

    @Override // ap1.a
    public void recordTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    public ToolbarLoadTimeStatsDummy() {
    }
}
