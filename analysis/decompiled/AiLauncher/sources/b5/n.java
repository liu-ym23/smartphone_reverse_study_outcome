package b5;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$color;
import kotlin.Metadata;
import stepos.support.v7.appcompat.R$attr;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\bR\u0017\u0010\u001a\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\bR\u0017\u0010\u001c\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\b¨\u0006 "}, d2 = {"Lb5/n;", "", "<init>", "()V", "Lb5/c;", "BtnInstallText", "Lb5/c;", Const.INTENT_KEY_PKGNAME, "()Lb5/c;", "BtnRetryText", "c", "BtnBg", Const.INTENT_KEY_APIKEY, "Spinner", "f", "Lb5/a;", "Refresh", "Lb5/a;", "e", "()Lb5/a;", "Divider", Const.INTENT_KEY_UMID, "TabActive", Const.INTENT_KEY_BACKGROUND_COMMAND, "TabInactive", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "SwitchTrackOn", "getSwitchTrackOn", "SwitchTrackOff", "getSwitchTrackOff", "SwitchThumb", "getSwitchThumb", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class n {
    public static final n INSTANCE = new n();
    private static final C1451c BtnInstallText = new C1451c(R$color.skill_btn_text_value);
    private static final C1451c BtnRetryText = new C1451c(R$color.skill_btn_text_retry_value);
    private static final C1451c BtnBg = new C1451c(R$color.skill_btn_bg_value);
    private static final C1451c Spinner = new C1451c(R$color.skill_spinner_accent);
    private static final C1449a Refresh = new C1449a(R$attr.colorSurfaceContainerHigh);
    private static final C1451c Divider = new C1451c(R$color.skill_divider_value);
    private static final C1451c TabActive = new C1451c(R$color.skill_tab_active_value);
    private static final C1451c TabInactive = new C1451c(R$color.skill_text_secondary);
    private static final C1451c SwitchTrackOn = new C1451c(R$color.skill_switch_track_on);
    private static final C1451c SwitchTrackOff = new C1451c(R$color.skill_switch_track_off);
    private static final C1451c SwitchThumb = new C1451c(R$color.skill_switch_thumb);

    public final C1451c a() {
        return BtnBg;
    }

    public final C1451c b() {
        return BtnInstallText;
    }

    public final C1451c c() {
        return BtnRetryText;
    }

    public final C1451c d() {
        return Divider;
    }

    public final C1449a e() {
        return Refresh;
    }

    public final C1451c f() {
        return Spinner;
    }

    public final C1451c g() {
        return TabActive;
    }

    public final C1451c h() {
        return TabInactive;
    }
}
