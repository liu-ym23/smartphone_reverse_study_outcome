package by3;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.Adapter f21391a;

    public /* synthetic */ a(RecyclerView.Adapter r100) {
        this.f21391a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView.Adapter r100 = this.f21391a;
        r100.notifyDataSetChanged();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        AoLogger.c("CrashlyticsWrapper", new Object[]{r100.getClass().getName(), e});
    }
}
