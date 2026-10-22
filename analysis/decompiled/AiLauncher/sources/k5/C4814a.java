package k5;

import Z8.X;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lk5/a;", "", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: k5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4814a {
    public static final String AI_KEY_CLICK = "ai_key_click";
    public static final String LOCK_SCREEN_CLICK = "lock_screen_click";
    public static final String LOCK_SCREEN_LONG_CLICK = "lock_screen_long_click";
    public static final String PARAM_SOURCE = "param_source";
    public static final String POWER_KEY = "power_key";
    public static final String SHARE_AGENT = "share_agent";
    public static final String VOICE_WAKEUP = "voice_wakeup";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String AI_KEY_CLICK2 = "ai_key";
    public static final String AI_KEY_LONG_CLICK_START = "ai_key_long_click_start";
    public static final String HOME_KEY_LONG_CLICK = "home_key_long_click";
    public static final String BOTTOM_BAR_KEY_LONG_CLICK = "bottom_bar_key_long_click";
    private static final Set<String> CIRCLE_SELECT_WHITELIST = Y.j("ai_key_click", AI_KEY_CLICK2, AI_KEY_LONG_CLICK_START, HOME_KEY_LONG_CLICK, BOTTOM_BAR_KEY_LONG_CLICK);
    public static final String HEADSET_WAKEUP = "headset_wakeup";
    private static final Set<String> RECORD_ON_WAKE_SOURCES = Y.j("voice_wakeup", HEADSET_WAKEUP);
    private static final Set<String> KEYBOARD_ON_WAKE_SOURCES = Y.j("ai_key_click", AI_KEY_CLICK2, HOME_KEY_LONG_CLICK, BOTTOM_BAR_KEY_LONG_CLICK);
    private static final Set<String> PERMISSION_FREE_WAKE_SOURCES = X.d(BOTTOM_BAR_KEY_LONG_CLICK);
    private static final Set<String> CANCELS_STUCK_RECENTS_PEEK_ON_WAKE = Y.j(BOTTOM_BAR_KEY_LONG_CLICK, "ai_key_click", AI_KEY_CLICK2, AI_KEY_LONG_CLICK_START);
    public static final String AI_KEY_DOUBLE_CLICK = "ai_key_double_click";
    public static final String AI_KEY_LONG_CLICK_END = "ai_key_long_click_end";
    private static final Set<String> AI_KEY_WAKE_SOURCES = Y.j("ai_key_click", AI_KEY_CLICK2, AI_KEY_DOUBLE_CLICK, AI_KEY_LONG_CLICK_START, AI_KEY_LONG_CLICK_END);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0014\u0010!\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0010R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0010R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0010R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0010¨\u0006'"}, d2 = {"Lk5/a$a;", "", "<init>", "()V", "", "source", "", "f", "(Ljava/lang/String;)Z", Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "c", "", "CIRCLE_SELECT_WHITELIST", "Ljava/util/Set;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Set;", "PARAM_SOURCE", "Ljava/lang/String;", "POWER_KEY", "AI_KEY_CLICK", "AI_KEY_CLICK2", "AI_KEY_DOUBLE_CLICK", "AI_KEY_LONG_CLICK_START", "AI_KEY_LONG_CLICK_END", "LOCK_SCREEN_CLICK", "LOCK_SCREEN_LONG_CLICK", "HOME_KEY_LONG_CLICK", "BOTTOM_BAR_KEY_LONG_CLICK", "VOICE_WAKEUP", "HEADSET_WAKEUP", "SHARE_AGENT", "RECORD_ON_WAKE_SOURCES", "KEYBOARD_ON_WAKE_SOURCES", "PERMISSION_FREE_WAKE_SOURCES", "CANCELS_STUCK_RECENTS_PEEK_ON_WAKE", "AI_KEY_WAKE_SOURCES", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: k5.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean a(String source) {
            return source != null && C4814a.CANCELS_STUCK_RECENTS_PEEK_ON_WAKE.contains(source);
        }

        public final Set<String> b() {
            return C4814a.CIRCLE_SELECT_WHITELIST;
        }

        public final boolean c(String source) {
            return source != null && C4814a.AI_KEY_WAKE_SOURCES.contains(source);
        }

        public final boolean d(String source) {
            return p.d(source, C4814a.AI_KEY_LONG_CLICK_START) || f(source);
        }

        public final boolean e(String source) {
            return source != null && C4814a.KEYBOARD_ON_WAKE_SOURCES.contains(source);
        }

        public final boolean f(String source) {
            return source != null && C4814a.RECORD_ON_WAKE_SOURCES.contains(source);
        }

        public final boolean g(String source) {
            return source != null && C4814a.PERMISSION_FREE_WAKE_SOURCES.contains(source);
        }

        public Companion() {
        }
    }
}
