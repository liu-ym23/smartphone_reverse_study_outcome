package y9;

import com.monitor.cloudmessage.handler.IMessageHandler;
import com.monitor.cloudmessage.obversable.CloudMessageObservable;
import com.monitor.cloudmessage.obversable.CloudMessageObserver;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes3.dex */
public class k implements CloudMessageObservable, IMessageHandler {
    public k() {
    }

    @Override // com.monitor.cloudmessage.obversable.CloudMessageObservable
    public boolean dispatchCloudMessage(w9.a r10) {
        Enumeration r11 = v9.a.k().l();
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.hasMoreElements() == false) goto L20;
        CloudMessageObserver r12 = (CloudMessageObserver) r11.nextElement();
        if (r12 == null) goto L5;
        if (r12.obverseCloudMessage(r10) == false) goto L5;
        ca.a.d(new da.b(0, false, r10.b(), null));
        return true;
    L20:
        return false;
    }

    @Override // com.monitor.cloudmessage.handler.IMessageHandler
    public boolean handleCloudMessage(w9.a r10) {
        return dispatchCloudMessage(r10);
    }
}
