package com.obric.autoaction.app.launcherpage.discovery.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final String f23588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("instruction_type")
    private final Integer f23589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName(DownloadConstants.QUERY_KEY)
    private final String f23590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("execute_type")
    private final Integer f23591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("icon")
    private final String f23592e;

    @SerializedName("color")
    private final String f;

    @SerializedName("short_command")
    private final String g;

    @SerializedName("is_short_command")
    private final Boolean h;

    @SerializedName("show_hint_before_start")
    private final Boolean i;

    @SerializedName("condition_group")
    private final h j;

    @SerializedName("periodic_policy")
    private final o k;

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23588a, r6.f23588a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23589b, r6.f23589b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23590c, r6.f23590c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f23591d, r6.f23591d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f23592e, r6.f23592e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r0 = this.f23588a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.f23589b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f23590c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.f23591d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f23592e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        h r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        o r31 = this.k;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Instruction(instructionId=").append(this.f23588a).append(", instructionType=").append(this.f23589b).append(", query=").append(this.f23590c).append(", executeType=").append(this.f23591d).append(", iconKey=").append(this.f23592e).append(", colorKey=").append(this.f).append(", shortCommand=").append(this.g).append(", isShortCommand=").append(this.h).append(", showHintBeforeStart=").append(this.i).append(", conditionGroup=").append(this.j).append(", periodicPolicy=").append(this.k).append(')');
        return r0.toString();
    }

    public e(String r1, Integer r2, String r3, Integer r4, String r5, String r6, String r7, Boolean r8, Boolean r9, h r10, o r11) {
        this.f23588a = r1;
        this.f23589b = r2;
        this.f23590c = r3;
        this.f23591d = r4;
        this.f23592e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }

    public /* synthetic */ e(String r2, Integer r3, String r4, Integer r5, String r6, String r7, String r8, Boolean r9, Boolean r10, h r11, o r12, int r13, d.h.b.h r14) {
        if ((r13 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r9 = null;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r10 = null;
    L30:
        if ((r13 & 512) == 0) goto L33;
        r11 = null;
    L33:
        if ((r13 & 1024) == 0) goto L35;
        r12 = null;
    L35:
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public final String a() {
        return this.f23588a;
    }

    public final Integer b() {
        return this.f23589b;
    }

    public final String c() {
        return this.f23590c;
    }

    public final Integer d() {
        return this.f23591d;
    }

    public final String e() {
        return this.f23592e;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final Boolean h() {
        return this.h;
    }

    public final h i() {
        return this.j;
    }

    public final ConditionTaskAction j() {
        return new ConditionTaskAction("System_AutoAction", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(this.f23590c, null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin"));
    }

    public final ShortcutTaskAction k() {
        return new ShortcutTaskAction("System_AutoAction", (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(this.f23590c, null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin"));
    }

    public final PeriodicPolicy l() {
        o r0 = this.k;
        int[] r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.f() == false) goto L9;
        return new PeriodicPolicy(false, null, 0, null, false, false, r0.e(), true, null, 319, null);
    L9:
        if (r0.a() == true) goto L11;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r0.b(), Collection.class, "com.obric.aiagent.plugin");
        boolean r3 = false;
        if (r2 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == true) goto L26;
        List<Integer> r5 = r0.b();
        if (r5 == null) goto L24;
        r1 = d.a.p.e((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
    L24:
        return new PeriodicPolicy(false, r1, 0, null, false, false, r0.e(), false, null, 445, null);
    L26:
        if (r0.c() > 0) goto L28;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r0.d(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L32;
    L33:
        r3 = true;
    L34:
        if (r3 == false) goto L36;
        return null;
    L36:
        return new PeriodicPolicy(false, null, 0, r0.d(), false, false, r0.e(), false, null, 439, null);
    L32:
        if (r6.length() != 0) goto L34;
    L28:
        return new PeriodicPolicy(false, null, r0.c(), null, false, false, r0.e(), false, null, 443, null);
    L15:
        if (r2.isEmpty() == true) goto L18;
        r4 = false;
        goto L19
    L11:
        return new PeriodicPolicy(true, null, 0, null, false, false, r0.e(), false, null, 446, null);
    }
}
