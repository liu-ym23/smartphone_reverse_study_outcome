package t5;

import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"Lt5/e;", "", "<init>", "()V", "Landroid/content/Intent;", "intent", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Intent;)Ljava/lang/String;", "MAIN", "Ljava/lang/String;", "AMOO_SPACE", "VOICE_WAKEUP", "NAVIGATION_KEY", "HEADSET_KEY", "AMOO_EXPRESS", "SUPPORTED_APPS", "SOUND", "AI_SAFETY", "PRIVACY", "PERSONAL_INFO", "THIRD_PARTY", "IMPROVE", "CHECK_UPDATE", "EXTRA_FRAGMENT_ARG_KEY", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: t5.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5512e {
    public static final String AI_SAFETY = "step_assistant_ai_safety";
    public static final String AMOO_EXPRESS = "step_assistant_amoo_express";
    public static final String AMOO_SPACE = "step_assistant_amoo_space";
    public static final String CHECK_UPDATE = "step_assistant_check_update";
    private static final String EXTRA_FRAGMENT_ARG_KEY = ":settings:fragment_args_key";
    public static final String HEADSET_KEY = "step_assistant_headset_key";
    public static final String IMPROVE = "step_assistant_improve";
    public static final C5512e INSTANCE = new C5512e();
    public static final String MAIN = "step_assistant_main";
    public static final String NAVIGATION_KEY = "step_assistant_navigation_key";
    public static final String PERSONAL_INFO = "step_assistant_personal_info";
    public static final String PRIVACY = "step_assistant_privacy";
    public static final String SOUND = "step_assistant_sound";
    public static final String SUPPORTED_APPS = "step_assistant_supported_apps";
    public static final String THIRD_PARTY = "step_assistant_third_party";
    public static final String VOICE_WAKEUP = "step_assistant_voice_wakeup";

    public final String a(Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra(EXTRA_FRAGMENT_ARG_KEY)) == null || stringExtra.length() <= 0) {
            return null;
        }
        return stringExtra;
    }
}
