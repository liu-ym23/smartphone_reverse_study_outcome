package bga;

import com.obric.assistant.session.model.ISessionMaintaining;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes33.dex */
public final class j {
    public static final ISessionMaintaining b() {
        return (ISessionMaintaining) ServiceManager.get().getService(ISessionMaintaining.class);
    }

    public static final String a() {
        ISessionMaintaining r100 = b();
        if (r100 == null) goto L6;
        String r101 = r100.w();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "other";
    }

    public static final String c() {
        ISessionMaintaining r100 = b();
        if (r100 == null) goto L6;
        String r101 = r100.o();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }
}
