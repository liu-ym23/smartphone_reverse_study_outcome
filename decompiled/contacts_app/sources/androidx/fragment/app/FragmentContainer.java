package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentContainer {
    public abstract View onFindViewById(int r1);

    public abstract boolean onHasView();

    public FragmentContainer() {
    }

    @Deprecated
    public Fragment instantiate(Context r1, String r2, Bundle r3) {
        return Fragment.instantiate(r1, r2, r3);
    }
}
