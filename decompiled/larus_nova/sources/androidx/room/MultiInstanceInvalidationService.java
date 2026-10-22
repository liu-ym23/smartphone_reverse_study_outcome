package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class MultiInstanceInvalidationService extends Service {
    private final IMultiInstanceInvalidationService.Stub mBinder;
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList;
    final HashMap<Integer, String> mClientNames;
    int mMaxClientId;

    public MultiInstanceInvalidationService() {
        this.mMaxClientId = 0;
        this.mClientNames = new HashMap();
        this.mCallbackList = new AnonymousClass1(this);
        this.mBinder = new AnonymousClass2(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return this.mBinder;
    }
}
