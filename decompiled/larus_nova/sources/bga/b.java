package bga;

import com.obric.assistant.session.model.IAiKeyOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes33.dex */
public final class b {
    public static final IAiKeyOperation a() {
        return (IAiKeyOperation) ServiceManager.get().getService(IAiKeyOperation.class);
    }
}
