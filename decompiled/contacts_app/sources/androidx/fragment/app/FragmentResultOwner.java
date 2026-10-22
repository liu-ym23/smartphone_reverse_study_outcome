package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(String r1);

    void clearFragmentResultListener(String r1);

    void setFragmentResult(String r1, Bundle r2);

    void setFragmentResultListener(String r1, LifecycleOwner r2, FragmentResultListener r3);
}
