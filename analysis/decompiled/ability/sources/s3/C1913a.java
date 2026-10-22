package s3;

import android.os.RemoteException;
import com.mdisdk.capability.framework.FrameworkRegister;
import com.mdisdk.observer.FrameworkObserverBridge;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/* renamed from: s3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1913a implements FrameworkRegister.OnAppDiedListener {
    @Override // com.mdisdk.capability.framework.FrameworkRegister.OnAppDiedListener
    public final void onAppDied(int i, String str, int i6, boolean z10) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        FrameworkObserverBridge.appDiedListener$lambda$0(i, str, i6, z10);
    }
}
