package com.obric.agent.trace.omni;

import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.sharedstate.SharedState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: OmniLockscreenStateTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    private static final String TAG = "OmniLockscreenStateTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f15634a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<a> f15635b = null;

    /* JADX INFO: compiled from: OmniLockscreenStateTracker.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f15640e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15636a, r6.f15636a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15637b, r6.f15637b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15638c, r6.f15638c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15639d, r6.f15639d) == true) goto L21;
            return false;
        L21:
            if (this.f15640e == r6.f15640e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f15636a.hashCode() * 31) + this.f15637b.hashCode()) * 31) + this.f15638c.hashCode()) * 31) + this.f15639d.hashCode()) * 31) + Boolean.hashCode(this.f15640e);
        }

        public String toString() {
            return "PageEntryLockStateKey(reportKey=" + this.f15636a + ", sharedKeyguardLockedOnEnterKey=" + this.f15637b + ", sharedEnterTimeKey=" + this.f15638c + ", currentPageEntry=" + this.f15639d + ", isTaskPage=" + this.f15640e + ')';
        }

        public a(String r2, String r3, String r4, String r5, boolean r6) {
            d.h.b.o.e(r2, "reportKey");
            d.h.b.o.e(r3, "sharedKeyguardLockedOnEnterKey");
            d.h.b.o.e(r4, "sharedEnterTimeKey");
            d.h.b.o.e(r5, "currentPageEntry");
            this.f15636a = r2;
            this.f15637b = r3;
            this.f15638c = r4;
            this.f15639d = r5;
            this.f15640e = r6;
        }

        public final String a() {
            return this.f15636a;
        }

        public final String b() {
            return this.f15637b;
        }

        public final String c() {
            return this.f15638c;
        }

        public final String d() {
            return this.f15639d;
        }

        public final boolean e() {
            return this.f15640e;
        }
    }

    /* JADX INFO: compiled from: OmniLockscreenStateTracker.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f15642b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<String, Long> f15643c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15644d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15641a, r6.f15641a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f15642b, r6.f15642b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f15643c, r6.f15643c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f15644d, r6.f15644d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = this.f15641a.hashCode() * 31;
            Long r1 = this.f15642b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + this.f15643c.hashCode()) * 31) + this.f15644d.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "WithoutUnlockingState(value=" + this.f15641a + ", desktopEnterTime=" + this.f15642b + ", taskPageEnterTimesAfterDesktop=" + this.f15643c + ", reason=" + this.f15644d + ')';
        }

        public b(String r3, Long r4, Map<String, Long> r5, String r6) {
            Map<String, Long> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "value");
            d.h.b.o.e(r7, "taskPageEnterTimesAfterDesktop");
            d.h.b.o.e(r6, "reason");
            this.f15641a = r3;
            this.f15642b = r4;
            this.f15643c = r7;
            this.f15644d = r6;
        }

        public final String a() {
            return this.f15641a;
        }

        public final Long b() {
            return this.f15642b;
        }

        public final Map<String, Long> c() {
            return this.f15643c;
        }

        public final String d() {
            return this.f15644d;
        }
    }

    private final String a(int r1) {
        if (r1 != 0) goto L4;
        return "0";
    L4:
        if (r1 == 1) goto L6;
        return null;
    L6:
        return "1";
    }

    private h() {
    }

    static {
        f15634a = new h();
        f15635b = d.a.p.b(new a[]{new a("bot_keyguard_locked_on_enter", "omni_bot_keyguard_locked_on_enter", "omni_bot_enter_time", "CHAT_PAGE", true), new a("omni_detail_page_keyguard_locked_on_enter", "omni_detail_page_keyguard_locked_on_enter", "omni_detail_page_enter_time", "OMNI_DETAIL_PAGE", true), new a("virtual_screen_page_keyguard_locked_on_enter", "omni_virtual_screen_page_keyguard_locked_on_enter", "omni_virtual_screen_page_enter_time", "VIRTUAL_SCREEN_PAGE", true), new a("window_page_keyguard_locked_on_enter", "omni_window_page_keyguard_locked_on_enter", "omni_window_page_enter_time", "WINDOW_PAGE", true)});
    }

    public final Map<String, Object> a(com.obric.agent.trace.omni.a r11, Map<String, String> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L5;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.get("obric_message_position_level1"), String.class, "com.obric.aiagent.plugin");
    L6:
        String r15 = b(r14);
        String r2 = a();
        if (r2 != null) goto L9;
        r2 = r15;
    L9:
        Map r3 = ao.b(new d.m[]{d.s.a("device_locked_on_action_start", r15), d.s.a("keyguard_locked_on_task_start", r2)});
        String r4 = SharedState.INSTANCE.getString("omni_current_page_entry", "NONE");
        Map<String, String> r10 = a(r4);
        r3.putAll(r10);
        ISecureLogDepend.Companion.i(TAG, "buildStartParams: deviceLockedOnActionStart=" + r15 + ", keyguardLockedStart=" + r2 + ", currentPageEntry=" + r4 + ", currentPageEntryLockStateValues=" + r10 + ", params=" + r3);
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r17 = r3.entrySet().iterator();
    L11:
        if (r17.hasNext() == false) goto L23;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L19;
        Map<String, List<Object>> r7 = r11.b();
        if (r7 == null) goto L19;
        if (r7.containsKey(r6) != true) goto L19;
        boolean r8 = true;
    L21:
        if ((!r8) == false) goto L11;
        r16.put(r5.getKey(), r5.getValue());
    L19:
        r8 = false;
        goto L21
    L23:
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.aiagent.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r110 = r18.entrySet().iterator();
    L25:
        if (r110.hasNext() == false) goto L33;
        Map.Entry r111 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r111.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r112 = r111.getValue();
        if (r112 == null) goto L29;
        d.m r113 = d.s.a(r9, r112);
    L30:
        if (r113 == null) goto L25;
        r19.add(r113);
        goto L25
    L29:
        r113 = null;
        goto L30
    L33:
        return ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L5:
        r14 = null;
        goto L6
    }

    private final b a(String r18, long r19) {
        ISecureLogDepend.Companion.i(TAG, "OmniLockscreenTrace resolveWithoutUnlocking start: deviceLockedOnActionStart=" + r18 + ", queryStartTime=" + r19);
        String r3 = "1";
        if (d.h.b.o.a(r18, "1") == true) goto L6;
        b r0 = new b("0", null, ao.b(), "not_locked_on_action_start");
        ISecureLogDepend.Companion.i(TAG, "OmniLockscreenTrace resolveWithoutUnlocking result: reason=" + r0.d() + ", withoutUnlocking=" + r0.a());
        return r0;
    L6:
        Long r1 = b("omni_desktop_enter_time", r19);
        if (r1 == null) goto L27;
        long r9 = r1.longValue();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(f15635b, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L21;
        a r13 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.aiagent.plugin");
        if (r13.e() == true) goto L14;
    L13:
        d.m r14 = null;
    L19:
        if (r14 == null) goto L10;
        r11.add(r14);
        goto L10
    L14:
        Long r15 = f15634a.b(r13.c(), r19);
        if (r15 == null) goto L13;
        if (r15.longValue() < r9) goto L13;
        r14 = d.s.a(r13.a(), r15);
        goto L19
    L21:
        Map r5 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        if ((!r5.isEmpty()) == false) goto L24;
        String r6 = "locked_start_desktop_then_task_page";
        r3 = "0";
    L25:
        b r7 = new b(r3, Long.valueOf(r9), r5, r6);
        ISecureLogDepend.Companion.i(TAG, "OmniLockscreenTrace resolveWithoutUnlocking result: reason=" + r7.d() + ", withoutUnlocking=" + r7.a() + ", desktopEnterTime=" + r7.b() + ", taskPageEnterTimesAfterDesktop=" + r7.c());
        return r7;
    L24:
        r6 = "locked_start_desktop_without_later_task_page";
        goto L25
    L27:
        b r8 = new b("1", null, ao.b(), "locked_start_without_desktop_after_start");
        ISecureLogDepend.Companion.i(TAG, "OmniLockscreenTrace resolveWithoutUnlocking result: reason=" + r8.d() + ", withoutUnlocking=" + r8.a());
        return r8;
    }

    private final String a(com.obric.agent.trace.omni.a r1, a r2, long r3) {
        String r0 = a(r2, r3);
        List r4 = (List) ZeusTransformUtils.preCheckCast(r1.b().get(r2.a()), List.class, "com.obric.aiagent.plugin");
        String r5 = null;
        if (r4 == null) goto L10;
        Object r6 = d.a.p.n(r4);
        if (r6 == null) goto L10;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L10;
    L11:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L14;
    L16:
        if (r0 == null) goto L18;
        return r0;
    L18:
        return r5;
    L14:
        if (f15634a.c(r7) == false) goto L16;
        r5 = r7;
    L10:
        r6 = null;
        goto L11
    }

    private final String a(a r7, long r8) {
        long r0 = SharedState.INSTANCE.getLong(r7.c(), 0);
        if (r0 > 0) goto L6;
        return null;
    L6:
        if (r8 <= 0) goto L11;
        if (r0 >= r8) goto L11;
        return null;
    L11:
        return a(SharedState.INSTANCE.getInt(r7.b(), -1));
    }

    private final Map<String, String> a(String r9) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == true) goto L27;
        if (d.h.b.o.a(r9, "NONE") == true) goto L27;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(f15635b, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L25;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r12.next(), a.class, "com.obric.aiagent.plugin");
        d.m r4 = null;
        if (d.h.b.o.a(r2.d(), r9) == false) goto L22;
        String r3 = f15634a.a(SharedState.INSTANCE.getInt(r2.b(), -1));
        if (r3 == null) goto L22;
        r4 = d.s.a(r2.a(), r3);
    L22:
        if (r4 == null) goto L15;
        r1.add(r4);
        goto L15
    L25:
        return ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L27:
        return ao.b();
    L5:
        if (r8.length() == 0) goto L8;
        r10 = false;
        goto L9
    }

    private final Long b(String r9, long r10) {
        if (r10 > 0) goto L6;
        ISecureLogDepend.Companion.i(TAG, "OmniLockscreenTrace readSharedEventTimeAfterStart: key=" + r9 + ", queryStartTime=" + r10 + ", accepted=false, reason=invalid_start");
        return null;
    L6:
        long r0 = SharedState.INSTANCE.getLong(r9, 0);
        if (r0 < r10) goto L9;
        boolean r8 = true;
    L10:
        ISecureLogDepend.Companion.i(TAG, "OmniLockscreenTrace readSharedEventTimeAfterStart: key=" + r9 + ", eventTime=" + r0 + ", queryStartTime=" + r10 + ", accepted=" + r8);
        Long r11 = Long.valueOf(r0);
        ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r8 == true) goto L13;
        return null;
    L13:
        return r11;
    L9:
        r8 = false;
        goto L10
    }

    private final String a() {
        return a(SharedState.INSTANCE.getInt("omni_keyguard_locked", -1));
    }

    private final String b(String r1) {
        if (d.h.b.o.a(r1, "lock_screen") == false) goto L5;
        return "1";
    L5:
        return "0";
    }

    private final boolean c(String r1) {
        if (d.h.b.o.a(r1, "1") == false) goto L5;
    L8:
        return true;
    L5:
        if (d.h.b.o.a(r1, "0") == true) goto L8;
        return false;
    }

    public final Map<String, String> a(com.obric.agent.trace.omni.a r9, long r10) {
        d.h.b.o.e(r9, "snapshot");
        List r0 = (List) ZeusTransformUtils.preCheckCast(r9.b().get("device_locked_on_action_start"), List.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L10;
        Object r1 = d.a.p.n(r0);
        if (r1 == null) goto L10;
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L10;
    L11:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L14;
        r2 = "0";
    L14:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(f15635b, Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r6 = r4.iterator();
    L16:
        if (r6.hasNext() == false) goto L23;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.aiagent.plugin");
        String r8 = f15634a.a(r9, r7, r10);
        if (r8 == null) goto L20;
        d.m r11 = d.s.a(r7.a(), r8);
    L21:
        if (r11 == null) goto L16;
        r5.add(r11);
        goto L16
    L20:
        r11 = null;
        goto L21
    L23:
        Map<? extends String, ? extends String> r3 = ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        String r12 = b(r9, r10);
        b r13 = a(r2, r10);
        Map<String, String> r14 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r14.put("device_locked_on_action_start", r2);
        r14.put("keyguard_locked_throughout_task", r12);
        r14.putAll(r3);
        r14.put("without_unlocking", r13.a());
        ISecureLogDepend.Companion.i(TAG, "buildFinishParams: queryStartTime=" + r10 + ", deviceLockedOnActionStart=" + r2 + ", keyguardLockedThroughoutTask=" + r12 + ", pageEntryLockStateValues=" + r3 + ", desktopEnterTime=" + r13.b() + ", taskPageEnterTimesAfterDesktop=" + r13.c() + ", withoutUnlockingReason=" + r13.d() + ", withoutUnlocking=" + r13.a());
        return r14;
    L10:
        r1 = null;
        goto L11
    }

    private final String b(com.obric.agent.trace.omni.a r5, long r6) {
        List r7 = (List) ZeusTransformUtils.preCheckCast(r5.b().get("keyguard_locked_on_task_start"), List.class, "com.obric.aiagent.plugin");
        Object r0 = null;
        if (r7 == null) goto L10;
        Object r8 = d.a.p.n(r7);
        if (r8 == null) goto L10;
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L10;
        r0 = r8;
    L10:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L16;
        r9 = a();
        if (r9 != null) goto L16;
        r9 = "0";
    L16:
        if (d.h.b.o.a(r9, "1") == true) goto L19;
        return "0";
    L19:
        if (d.h.b.o.a(a(), "0") == false) goto L22;
        return "0";
    L22:
        if (r6 > 0) goto L25;
        return "1";
    L25:
        if (SharedState.INSTANCE.getLong("omni_keyguard_unlocked_time", 0) <= r6) goto L28;
        return "0";
    L28:
        return "1";
    }
}
