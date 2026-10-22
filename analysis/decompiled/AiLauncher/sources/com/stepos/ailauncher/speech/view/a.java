package com.stepos.ailauncher.speech.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \b2\u00020\u0001:\u0002\t\u0006J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/speech/view/a;", "", "", "status", "reason", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(II)V", "Companion", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int REASON_CLICK_CANCEL = 1;
    public static final int REASON_DISMISS_CANCEL = 3;
    public static final int REASON_NO_SPEECH_CANCEL = 2;
    public static final int REASON_SUC = 0;
    public static final int STATUS_LISTEN = 1;
    public static final int STATUS_PRESS = 3;
    public static final int STATUS_RESET = 0;
    public static final int STATUS_TXT = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/speech/view/a$a;", "", "<init>", "()V", "", "STATUS_RESET", "I", "STATUS_LISTEN", "STATUS_TXT", "STATUS_PRESS", "REASON_SUC", "REASON_CLICK_CANCEL", "REASON_NO_SPEECH_CANCEL", "REASON_DISMISS_CANCEL", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.speech.view.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int REASON_CLICK_CANCEL = 1;
        public static final int REASON_DISMISS_CANCEL = 3;
        public static final int REASON_NO_SPEECH_CANCEL = 2;
        public static final int REASON_SUC = 0;
        public static final int STATUS_LISTEN = 1;
        public static final int STATUS_PRESS = 3;
        public static final int STATUS_RESET = 0;
        public static final int STATUS_TXT = 2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/speech/view/a$b;", "", "", "status", "reason", "LY8/t;", Const.INTENT_KEY_APIKEY, "(II)V", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void a(int status, int reason);
    }

    static /* synthetic */ void a(a aVar, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateStatus");
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        aVar.b(i10, i11);
    }

    void b(int status, int reason);
}
