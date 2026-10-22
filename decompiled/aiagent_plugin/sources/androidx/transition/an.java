package androidx.transition;

import android.view.View;
import android.view.WindowId;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WindowIdApi18.java */
/* JADX INFO: loaded from: classes.dex */
class an implements ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowId f2806a;

    an(View r1) {
        this.f2806a = r1.getWindowId();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, an.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((an) ZeusTransformUtils.preCheckCast(r3, an.class, "com.obric.aiagent.plugin")).f2806a.equals(this.f2806a) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.f2806a.hashCode();
    }
}
