package com.stepos.ailauncher.sla;

import Z8.Y;
import android.app.KeyguardManager;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/sla/v;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Z", "", "function", "fallback", G.LOCK_LOCKED, "Lcom/stepos/ailauncher/sla/v$a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;ZZ)Lcom/stepos/ailauncher/sla/v$a;", "TAG", "Ljava/lang/String;", "", "SLA_NO_VALID_ACTION", "I", "SLA_SCREEN_LOCKED", "SLA_UNSUPPORTED", "", "lockScreenAllowed", "Ljava/util/Set;", "slaUnsupported", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class v {
    public static final int SLA_NO_VALID_ACTION = 280001;
    public static final int SLA_SCREEN_LOCKED = 280002;
    public static final int SLA_UNSUPPORTED = 280003;
    private static final String TAG = "SLA";
    public static final v INSTANCE = new v();
    private static final Set<String> lockScreenAllowed = Y.j("alarm_clock_add", "alarm_clock_get_current_time_by_city", "alarm_clock_timer_add", "dialer_add_group", "dialer_call_contact", "dialer_call_to", "dialer_contacts_add", "evaluate_expression", "get_current_location", "maps_weather", "open_flash_light", "weatherInfo", "phone_note_add", "phone_note_todo_add", "settings_adjust_display_size", "settings_adjust_font_size", "settings_adjust_sound", "settings_choose_wifi", "settings_config_hotspot", "settings_connect_wifi", "settings_set_brightness", "settings_set_media_sound", "settings_set_screen_off_time", "settings_get_airplane_mode_state", "settings_get_app_lock_state", "settings_get_auto_brightness_state", "settings_get_auto_rotation_state", "settings_get_battery_saver_state", "settings_get_bluetooth_state", "settings_get_charging_notif_sound_state", "settings_get_dark_mode_state", "settings_get_data_state", "settings_get_dialing_keypad_sound_state", "settings_get_hotspot_state", "settings_get_liftToCheck_phone_state", "settings_get_one_handed_mode_state", "settings_get_screen_lock_sound_state", "settings_get_screen_saver_state", "settings_get_tapToCheck_phone_state", "settings_get_touch_sound_state", "settings_get_vibration_state", "settings_get_wifi_state", "sms_auto_retrieve_mms", "sms_delivery_reports", "sms_notify_sound", "sms_notify_vibration", "sms_query", "sms_schedule_send", "sms_send", "sms_send_direct", "sms_send_sound", "sms_settings_auto_retrieval", "sms_settings_delivery_reports", "sms_settings_expired_pickup", "sms_settings_expired_veri", "sms_settings_intelligent_msg", "sms_settings_notif_detail", "sms_settings_risk_url");
    private static final Set<String> slaUnsupported = Y.j("request_cloud_assist", "request_gui_assist");

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/sla/v$a;", "", "", "canExecute", "", "errorCode", "", "reason", "<init>", "(ZILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_APIKEY, "()Z", "I", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sla.v$a, reason: from toString */
    public static final /* data */ class Verdict {
        private final boolean canExecute;
        private final int errorCode;
        private final String reason;

        public Verdict(boolean z10, int i10, String str) {
            this.canExecute = z10;
            this.errorCode = i10;
            this.reason = str;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCanExecute() {
            return this.canExecute;
        }

        /* renamed from: b, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: c, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Verdict)) {
                return false;
            }
            Verdict verdict = (Verdict) other;
            return this.canExecute == verdict.canExecute && this.errorCode == verdict.errorCode && kotlin.jvm.internal.p.d(this.reason, verdict.reason);
        }

        public int hashCode() {
            int iHashCode = ((Boolean.hashCode(this.canExecute) * 31) + Integer.hashCode(this.errorCode)) * 31;
            String str = this.reason;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Verdict(canExecute=" + this.canExecute + ", errorCode=" + this.errorCode + ", reason=" + this.reason + ")";
        }
    }

    public final Verdict a(String function, boolean fallback, boolean locked) {
        if (fallback || function == null) {
            return new Verdict(false, 280001, "no valid action recognized");
        }
        if (slaUnsupported.contains(function)) {
            return new Verdict(false, 280003, "function '" + function + "' not supported by on-device SLA");
        }
        if (!locked || lockScreenAllowed.contains(function)) {
            return new Verdict(true, 0, null);
        }
        return new Verdict(false, 280002, "screen locked, function '" + function + "' not in lockscreen whitelist");
    }

    public final boolean b(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = context.getSystemService("keyguard");
            kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            objB = Result.b(Boolean.valueOf(((KeyguardManager) systemService).isKeyguardLocked()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("SLA", "isKeyguardLocked failed: " + thE.getMessage() + ", treat as unlocked", false, 4, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }
}
