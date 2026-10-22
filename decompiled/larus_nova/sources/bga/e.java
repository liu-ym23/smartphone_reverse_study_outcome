package bga;

import com.obric.assistant.session.model.IAutoMicOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes33.dex */
public final class e {
    public static final IAutoMicOperation a() {
        return (IAutoMicOperation) ServiceManager.get().getService(IAutoMicOperation.class);
    }
}
