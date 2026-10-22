package ms.bd.c;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class e1 implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f39491a;

    public e1(IBinder r3) {
        this.f39491a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f39491a;
    }
}
