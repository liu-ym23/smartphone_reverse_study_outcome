package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FragmentContainer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public abstract View a(int r1);

    public abstract boolean a();

    public c() {
    }

    @Deprecated
    public Fragment a(Context r2, String r3, Bundle r4) {
        return Fragment.instantiate((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4);
    }
}
