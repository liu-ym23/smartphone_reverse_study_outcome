package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public abstract class FragmentContainer {
    public FragmentContainer() {
    }

    public abstract View onFindViewById(int r100);

    public abstract boolean onHasView();

    public Fragment instantiate(Context r100, String r101, Bundle r102) {
        return Fragment.instantiate(r100, r101, r102);
    }
}
