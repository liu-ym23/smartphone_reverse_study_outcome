package k6;

import Z8.C1173v;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001!Bk\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b#\u0010\"R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b)\u0010\u0019R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b*\u0010\u0019R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b+\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b,\u0010\u001fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b-\u0010\u001f¨\u0006/"}, d2 = {"Lk6/d;", "", "", "id", "", x5.d.EXTRA_ENABLED, "oneshot", "", "", "days", "startHour", "startMinute", "endHour", "endMinute", "startTimeMs", "endTimeMs", "<init>", "(JZZLjava/util/List;IIIIJJ)V", "timeMs", Const.INTENT_KEY_PKGNAME, "(J)Z", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getId", "()J", "Z", Const.INTENT_KEY_APIKEY, "()Z", "getOneshot", "Ljava/util/List;", "getDays", "()Ljava/util/List;", "I", "getStartHour", "getStartMinute", "getEndHour", "getEndMinute", "getStartTimeMs", "getEndTimeMs", "Companion", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: k6.d, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SleepSchedule {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "SleepSchedule";
    private final List<Integer> days;
    private final boolean enabled;
    private final int endHour;
    private final int endMinute;
    private final long endTimeMs;
    private final long id;
    private final boolean oneshot;
    private final int startHour;
    private final int startMinute;
    private final long startTimeMs;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lk6/d$a;", "", "<init>", "()V", "", "json", "", "Lk6/d;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/util/List;", "TAG", "Ljava/lang/String;", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: k6.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v2, types: [java.util.ArrayList] */
        public final List<SleepSchedule> a(String json) throws JSONException {
            List listM;
            if (json == null || json.length() == 0) {
                return C1173v.m();
            }
            try {
                JSONArray jSONArray = new JSONArray(json);
                ArrayList arrayList = new ArrayList(jSONArray.length());
                int length = jSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    if (jSONObject.optBoolean("oneshot", false)) {
                        arrayList.add(new SleepSchedule(jSONObject.optLong("id"), jSONObject.optBoolean(x5.d.EXTRA_ENABLED, false), true, null, 0, 0, 0, 0, jSONObject.optLong("startTimeMs"), jSONObject.optLong("endTimeMs"), 248, null));
                    } else {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("days");
                        if (jSONArrayOptJSONArray != null) {
                            int length2 = jSONArrayOptJSONArray.length();
                            listM = new ArrayList(length2);
                            for (int i11 = 0; i11 < length2; i11++) {
                                listM.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i11)));
                            }
                        } else {
                            listM = C1173v.m();
                        }
                        arrayList.add(new SleepSchedule(jSONObject.optLong("id"), jSONObject.optBoolean(x5.d.EXTRA_ENABLED, false), false, listM, jSONObject.optInt("startHour"), jSONObject.optInt("startMinute"), jSONObject.optInt("endHour"), jSONObject.optInt("endMinute"), 0L, 0L, 768, null));
                    }
                }
                return arrayList;
            } catch (JSONException e10) {
                Log.w(SleepSchedule.TAG, "parse schedules failed: " + json, e10);
                return C1173v.m();
            }
        }

        public Companion() {
        }
    }

    public SleepSchedule(long j10, boolean z10, boolean z11, List<Integer> days, int i10, int i11, int i12, int i13, long j11, long j12) {
        p.i(days, "days");
        this.id = j10;
        this.enabled = z10;
        this.oneshot = z11;
        this.days = days;
        this.startHour = i10;
        this.startMinute = i11;
        this.endHour = i12;
        this.endMinute = i13;
        this.startTimeMs = j11;
        this.endTimeMs = j12;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean b(long timeMs) {
        if (this.oneshot) {
            return timeMs < this.endTimeMs && this.startTimeMs <= timeMs;
        }
        if (this.days.isEmpty()) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMs);
        int i10 = (calendar.get(11) * 60) + calendar.get(12);
        int i11 = calendar.get(7);
        int i12 = (this.startHour * 60) + this.startMinute;
        int i13 = (this.endHour * 60) + this.endMinute;
        if (i13 > i12) {
            return this.days.contains(Integer.valueOf(i11)) && i12 <= i10 && i10 < i13;
        }
        return (this.days.contains(Integer.valueOf(i11)) && i10 >= i12) || (this.days.contains(Integer.valueOf(i11 != 1 ? i11 + (-1) : 7)) && i10 < i13);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SleepSchedule)) {
            return false;
        }
        SleepSchedule sleepSchedule = (SleepSchedule) other;
        return this.id == sleepSchedule.id && this.enabled == sleepSchedule.enabled && this.oneshot == sleepSchedule.oneshot && p.d(this.days, sleepSchedule.days) && this.startHour == sleepSchedule.startHour && this.startMinute == sleepSchedule.startMinute && this.endHour == sleepSchedule.endHour && this.endMinute == sleepSchedule.endMinute && this.startTimeMs == sleepSchedule.startTimeMs && this.endTimeMs == sleepSchedule.endTimeMs;
    }

    public int hashCode() {
        return (((((((((((((((((Long.hashCode(this.id) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.oneshot)) * 31) + this.days.hashCode()) * 31) + Integer.hashCode(this.startHour)) * 31) + Integer.hashCode(this.startMinute)) * 31) + Integer.hashCode(this.endHour)) * 31) + Integer.hashCode(this.endMinute)) * 31) + Long.hashCode(this.startTimeMs)) * 31) + Long.hashCode(this.endTimeMs);
    }

    public String toString() {
        return "SleepSchedule(id=" + this.id + ", enabled=" + this.enabled + ", oneshot=" + this.oneshot + ", days=" + this.days + ", startHour=" + this.startHour + ", startMinute=" + this.startMinute + ", endHour=" + this.endHour + ", endMinute=" + this.endMinute + ", startTimeMs=" + this.startTimeMs + ", endTimeMs=" + this.endTimeMs + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SleepSchedule(long r17, boolean r19, boolean r20, java.util.List r21, int r22, int r23, int r24, int r25, long r26, long r28, int r30, kotlin.jvm.internal.i r31) {
        /*
            r16 = this;
            r0 = r30
            r1 = r0 & 8
            if (r1 == 0) goto Lc
            java.util.List r1 = Z8.C1173v.m()
            r7 = r1
            goto Le
        Lc:
            r7 = r21
        Le:
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L15
            r8 = r2
            goto L17
        L15:
            r8 = r22
        L17:
            r1 = r0 & 32
            if (r1 == 0) goto L1d
            r9 = r2
            goto L1f
        L1d:
            r9 = r23
        L1f:
            r1 = r0 & 64
            if (r1 == 0) goto L25
            r10 = r2
            goto L27
        L25:
            r10 = r24
        L27:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L2d
            r11 = r2
            goto L2f
        L2d:
            r11 = r25
        L2f:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L37
            r12 = r2
            goto L39
        L37:
            r12 = r26
        L39:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L47
            r14 = r2
            r5 = r19
            r6 = r20
            r2 = r16
            r3 = r17
            goto L51
        L47:
            r14 = r28
            r2 = r16
            r3 = r17
            r5 = r19
            r6 = r20
        L51:
            r2.<init>(r3, r5, r6, r7, r8, r9, r10, r11, r12, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.SleepSchedule.<init>(long, boolean, boolean, java.util.List, int, int, int, int, long, long, int, kotlin.jvm.internal.i):void");
    }
}
