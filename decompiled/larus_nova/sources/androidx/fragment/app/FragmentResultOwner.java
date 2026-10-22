package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes3.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(String r100);

    void clearFragmentResultListener(String r100);

    void setFragmentResult(String r100, Bundle r101);

    void setFragmentResultListener(String r100, LifecycleOwner r101, FragmentResultListener r102);
}
