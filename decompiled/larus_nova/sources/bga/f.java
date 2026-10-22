package bga;

import com.obric.assistant.session.model.IDoraOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes33.dex */
public final class f {
    public static final IDoraOperation a() {
        return (IDoraOperation) ServiceManager.get().getService(IDoraOperation.class);
    }
}
