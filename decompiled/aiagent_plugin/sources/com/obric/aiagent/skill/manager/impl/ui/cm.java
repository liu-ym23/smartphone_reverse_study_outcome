package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.toast.OToast;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SkillToast.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cm f20758a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference<OToast> f20759b;

    /* JADX INFO: compiled from: SkillToast.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20760a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f20761b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f20762c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f20763d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f20764e = null;
        public static final a f = null;
        public static final a g = null;
        public static final a h = null;
        public static final a i = null;
        public static final a j = null;
        public static final a k = null;
        public static final a l = null;
        public static final a m = null;
        private static final /* synthetic */ a[] p = null;
        private static final /* synthetic */ d.d.a q = null;
        private final int n;
        private final boolean o;

        private static final /* synthetic */ a[] c() {
            return new a[]{f20760a, f20761b, f20762c, f20763d, f20764e, f, g, h, i, j, k, l, m};
        }

        private a(String r1, int r2, int r3, boolean r4) {
            super(r1, r2);
            this.n = r3;
            this.o = r4;
        }

        /* synthetic */ a(String r1, int r2, int r3, boolean r4, int r5, d.h.b.h r6) {
            if ((r5 & 2) == 0) goto L5;
            r4 = false;
        L5:
            this(r1, r2, r3, r4);
        }

        public final int a() {
            return this.n;
        }

        public final boolean b() {
            return this.o;
        }

        static {
            f20760a = new a("ADD_SUCCESS", 0, ZeusTransformUtils.mapRes(R.string.obric_skill_toast_add_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_toast_add_success"), true);
            f20761b = new a("SAVE_SUCCESS", 1, ZeusTransformUtils.mapRes(R.string.obric_skill_toast_save_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_toast_save_success"), true);
            String r7 = "SAVE_NETWORK_FAILURE";
            int r8 = 2;
            f20762c = new a(r7, r8, ZeusTransformUtils.mapRes(R.string.obric_skill_toast_save_network_failure, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_toast_save_network_failure"), false, 2, null);
            String r14 = "TEXT_LIMIT_EXCEEDED";
            int r15 = 3;
            f20763d = new a(r14, r15, ZeusTransformUtils.mapRes(R.string.obric_skill_toast_text_limit_exceeded, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_toast_text_limit_exceeded"), false, 2, null);
            String r4 = "DISPLAY_NAME_CONFLICT";
            int r5 = 4;
            boolean r9 = false;
            d.h.b.h r10 = null;
            f20764e = new a(r4, r5, ZeusTransformUtils.mapRes(R.string.obric_skill_toast_display_name_conflict, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_toast_display_name_conflict"), r9, r8, r10);
            String r11 = "SKILL_NAME_INVALID";
            int r12 = 5;
            boolean r16 = false;
            int r17 = 2;
            d.h.b.h r18 = null;
            f = new a(r11, r12, ZeusTransformUtils.mapRes(R.string.obric_skill_name_invalid, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_name_invalid"), r16, r17, r18);
            String r6 = "INSTALL_LIMIT";
            int r13 = 6;
            g = new a(r6, r13, ZeusTransformUtils.mapRes(R.string.obric_skill_toast_install_limit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_toast_install_limit"), r9, r8, r10);
            String r19 = "ADD_REQUIRED";
            int r110 = 7;
            h = new a(r19, r110, ZeusTransformUtils.mapRes(R.string.obric_skill_toast_add_required, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_toast_add_required"), r16, r17, r18);
            String r20 = "ENABLE_REQUIRED";
            int r21 = 8;
            i = new a(r20, r21, ZeusTransformUtils.mapRes(R.string.obric_skill_toast_enable_required, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_toast_enable_required"), r9, r8, r10);
            String r111 = "ENABLE_LIMIT";
            int r112 = 9;
            j = new a(r111, r112, ZeusTransformUtils.mapRes(R.string.obric_skill_enable_limit_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_enable_limit_toast"), r16, r17, r18);
            String r22 = "CREATE_POLICY_FAILURE";
            int r23 = 10;
            k = new a(r22, r23, ZeusTransformUtils.mapRes(R.string.obric_skill_toast_create_policy_failure, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_toast_create_policy_failure"), r9, r8, r10);
            String r113 = "SCAN_IN_PROGRESS";
            int r114 = 11;
            l = new a(r113, r114, ZeusTransformUtils.mapRes(R.string.obric_skill_scan_in_progress_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_scan_in_progress_toast"), r16, r17, r18);
            String r24 = "SECURITY_FAILED";
            int r25 = 12;
            m = new a(r24, r25, ZeusTransformUtils.mapRes(R.string.obric_skill_security_failed_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_security_failed_toast"), r9, r8, r10);
            a[] r0 = c();
            p = r0;
            q = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(p.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillToast.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20765a = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.manager.impl.bh.values().length];
            r0[com.obric.aiagent.skill.manager.impl.bh.f19561a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[com.obric.aiagent.skill.manager.impl.bh.f19562b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f20765a = r0;
        }
    }

    private cm() {
    }

    static {
        f20758a = new cm();
        f20759b = new WeakReference(null);
    }

    public final void a(Activity r11, a r12) {
        Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r11, Activity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "activity");
        d.h.b.o.e(r12, "type");
        OToast r13 = (OToast) ZeusTransformUtils.preCheckCast(f20759b.get(), OToast.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L5;
        r13.e();
    L5:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin");
        String r3 = r10.getString(r12.a());
        d.h.b.o.c(r3, "getString(...)");
        OToast r14 = new OToast(r2, r3, 0, true, null, 0, 20, null);
        if (r12.b() == false) goto L8;
        int r15 = ZeusTransformUtils.mapRes(R.drawable.skill_ic_toast_success, "drawable", "skill_ic_toast_success");
    L9:
        OToast r16 = r14.a(Integer.valueOf(r15));
        f20759b = new WeakReference(r16);
        r16.f();
        return;
    L8:
        r15 = ZeusTransformUtils.mapRes(R.drawable.skill_ic_toast_warning, "drawable", "skill_ic_toast_warning");
        goto L9
    }

    public final void a(Activity r3, com.obric.aiagent.skill.manager.impl.bh r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "activity");
        d.h.b.o.e(r4, "failure");
        int r6 = b.f20765a[r4.ordinal()];
        if (r6 != 1) goto L5;
        a r7 = a.j;
    L10:
        a(r5, r7);
        return;
    L5:
        if (r6 != 2) goto L8;
        r7 = a.m;
        goto L10
    L8:
        throw new d.k();
    }
}
