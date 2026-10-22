package bc0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes45.dex */
public interface b {
    void a(TuningButtonListAdapter r100);

    void b(LifecycleOwner r100);

    int c();

    void clearData();

    void d(TuningButtonListAdapter r100, WeakReference r101, LifecycleOwner r102);

    void e(TuningButtonListAdapter r100, ac0.a r101, boolean r102);
}
