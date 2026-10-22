package s6;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.ailauncher.container.api.IOverlayPageProvider;
import com.stepos.ailauncher.container.api.OverlayPageLoadPolicy;
import com.stepos.ailauncher.task.space.ThreeTileOverlayView;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ls6/a;", "Lcom/stepos/ailauncher/container/api/IOverlayPageProvider;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "createView", "(Landroid/view/ViewGroup;)Landroid/view/View;", "", "getPageId", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/container/api/OverlayPageLoadPolicy;", "getLoadPolicy", "()Lcom/stepos/ailauncher/container/api/OverlayPageLoadPolicy;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: s6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5445a implements IOverlayPageProvider {
    @Override // com.stepos.ailauncher.container.api.IOverlayPageProvider
    public View createView(ViewGroup parent) {
        p.i(parent, "parent");
        Context context = parent.getContext();
        p.h(context, "getContext(...)");
        ThreeTileOverlayView threeTileOverlayView = new ThreeTileOverlayView(context, null, 0, 6, null);
        threeTileOverlayView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return threeTileOverlayView;
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageProvider
    public OverlayPageLoadPolicy getLoadPolicy() {
        return OverlayPageLoadPolicy.LAZY_ON_RESUME;
    }

    @Override // com.stepos.ailauncher.container.api.IOverlayPageProvider
    public String getPageId() {
        return "home_space";
    }
}
