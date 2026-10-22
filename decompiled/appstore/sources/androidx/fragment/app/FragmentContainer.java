package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentContainer {
    public FragmentContainer() {
    }

    public Fragment a(Context r10, String r11, Bundle r12) {
        return Fragment.instantiate(r10, r11, r12);
    }

    public abstract View b(int r10);

    public abstract boolean c();
}
