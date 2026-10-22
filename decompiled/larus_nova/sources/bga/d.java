package bga;

import com.obric.assistant.session.model.IAssistActivateOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes33.dex */
public final class d {
    public static final IAssistActivateOperation a() {
        return (IAssistActivateOperation) ServiceManager.get().getService(IAssistActivateOperation.class);
    }
}
