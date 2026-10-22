package com.obric.autogui.agents.vlm.cocreation;

import com.obric.autogui.common.api.cocreation.IOmniLabelingUserStopRecorder;
import com.obric.autogui.common.api.logging.Loog;
import d.h.b.h;

/* JADX INFO: compiled from: OmniLabelingUserStopRecorderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniLabelingUserStopRecorderImpl implements IOmniLabelingUserStopRecorder {
    private static final a Companion = null;
    private static final String TAG = "OmniLabelingUserStopRecorder";

    /* JADX INFO: compiled from: OmniLabelingUserStopRecorderImpl.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OmniLabelingUserStopRecorderImpl() {
    }

    @Override // com.obric.autogui.common.api.cocreation.IOmniLabelingUserStopRecorder
    public void onUserStopped(String r6, String r7) {
        com.obric.autogui.session.a r5 = com.obric.autogui.session.c.f30777a.b();
        if (r5 != null) goto L6;
        Loog.INSTANCE.w(TAG, "skip user stop, no ongoing session, messageId=" + r6 + ", reason=" + r7);
        return;
    L6:
        Loog.INSTANCE.i(TAG, "record user stop from complex task, messageId=" + r6 + ", reason=" + r7 + ", sessionId=" + r5.b() + ", sessionKey=" + r5.a() + ", isOmni=" + r5.c());
        com.obric.autogui.agents.vlm.cocreation.a.f27230a.a(r5, r7);
    }
}
