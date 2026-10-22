package an4;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class e {
    private final Integer iconRes;
    private final d toolbarIconDecoration;

    public e() {
    }

    public abstract ItemIdV2 getItemId();

    public void onHostDestroy(b r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarContext");
    }

    public Integer getIconRes() {
        return this.iconRes;
    }

    public d getToolbarIconDecoration() {
        return this.toolbarIconDecoration;
    }
}
