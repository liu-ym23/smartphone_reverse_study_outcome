package androidx.transition;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WindowIdApi14.java */
/* JADX INFO: loaded from: classes.dex */
class am implements ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f2805a;

    am(IBinder r3) {
        this.f2805a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, am.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin")).f2805a.equals(this.f2805a) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.f2805a.hashCode();
    }
}
