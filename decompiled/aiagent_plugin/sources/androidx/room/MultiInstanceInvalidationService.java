package androidx.room;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import com.volcengine.zeus.service.PluginService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationService extends PluginService {
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

    public IBinder onBind(Intent r1) {
        return this.mBinder;
    }
}
