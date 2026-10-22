package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillChatLauncher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f20808a = null;

    /* JADX INFO: compiled from: SkillChatLauncher.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aiagent.skill.manager.api.e f20809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f20811c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20809a, r6.f20809a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20810b, r6.f20810b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f20811c, r6.f20811c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f20809a.hashCode() * 31) + this.f20810b.hashCode()) * 31) + this.f20811c.hashCode();
        }

        public String toString() {
            return "ResolvedUsageExample(skill=" + this.f20809a + ", skillDisplayName=" + this.f20810b + ", content=" + this.f20811c + ')';
        }

        public a(com.obric.aiagent.skill.manager.api.e r2, String r3, String r4) {
            d.h.b.o.e(r2, "skill");
            d.h.b.o.e(r3, "skillDisplayName");
            d.h.b.o.e(r4, "content");
            this.f20809a = r2;
            this.f20810b = r3;
            this.f20811c = r4;
        }

        public final com.obric.aiagent.skill.manager.api.e a() {
            return this.f20809a;
        }

        public final String b() {
            return this.f20810b;
        }

        public final String c() {
            return this.f20811c;
        }
    }

    static {
        f20808a = new r();
    }

    public static /* synthetic */ d.x lambda$KvPM0lIUb8caXeCgyGxK2VkHK2A() {
        return a();
    }

    public static /* synthetic */ d.x lambda$gRBNDFW0_I46lU67B7SemyMjZrc(com.obric.aiagent.skill.manager.api.e r0, FragmentActivity r1, d.h.a.b r2, a r3, d.h.a.a r4) {
        return a(r0, r1, r2, r3, r4);
    }

    private r() {
    }

    public static /* synthetic */ boolean a(r r7, Context r8, ISkillManagerService r9, String r10, String r11, d.h.a.b r12, int r13, Object r14) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        ISkillManagerService r3 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r9, ISkillManagerService.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super String, d.x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r13 & 8) == 0) goto L6;
        r11 = null;
    L6:
        return r7.a(r2, r3, r10, r11, r6);
    }

    public final boolean a(Context r9, ISkillManagerService r10, String r11, String r12, d.h.a.b<? super String, d.x> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        ISkillManagerService r4 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r10, ISkillManagerService.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super String, d.x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        d.h.b.o.e(r7, "onError");
        return b(r3, r4, r11, r12, r7);
    }

    private static final d.x a() {
        return d.x.f38692a;
    }

    public static /* synthetic */ void a(r r10, FragmentActivity r11, ISkillManagerService r12, e r13, com.obric.aiagent.skill.manager.api.e r14, List r15, d.h.a.b r16, d.h.a.a r17, int r18, Object r19) {
        FragmentActivity r3 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r11, FragmentActivity.class, "com.obric.aiagent.plugin");
        ISkillManagerService r4 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r12, ISkillManagerService.class, "com.obric.aiagent.plugin");
        List<com.obric.aiagent.skill.manager.api.e> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super String, d.x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r17, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r18 & 64) == 0) goto L5;
        r0 = $$Lambda$r$KvPM0lIUb8caXeCgyGxK2VkHK2A.INSTANCE;
    L5:
        r10.a(r3, r4, r13, r14, r7, r8, r0);
    }

    public final void a(FragmentActivity r9, ISkillManagerService r10, e r11, com.obric.aiagent.skill.manager.api.e r12, List<com.obric.aiagent.skill.manager.api.e> r13, d.h.a.b<? super String, d.x> r14, d.h.a.a<d.x> r15) {
        final FragmentActivity r16 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r9, FragmentActivity.class, "com.obric.aiagent.plugin");
        ISkillManagerService r17 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r10, ISkillManagerService.class, "com.obric.aiagent.plugin");
        List<com.obric.aiagent.skill.manager.api.e> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        final d.h.a.b<? super String, d.x> r18 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        final d.h.a.a r19 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "activity");
        d.h.b.o.e(r11, "example");
        d.h.b.o.e(r6, "candidateSkills");
        d.h.b.o.e(r18, "onError");
        d.h.b.o.e(r19, "onOpened");
        final a r110 = a((Context) ZeusTransformUtils.preCheckCast(r16, Context.class, "com.obric.aiagent.plugin"), r11, r12, r6, r18);
        if (r110 != null) goto L6;
        return;
    L6:
        if (r17 != null) goto L28;
        String r8 = r16.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_open_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_open_failed"));
        d.h.b.o.c(r8, "getString(...)");
        r18.invoke(r8);
        return;
    L28:
        List r111 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r17.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r111 != null) goto L12;
        r111 = d.a.p.b();     // Catch: Throwable -> L25
    L12:
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L25
    L14:
        if (r112.hasNext() == false) goto L18;
        Object r2 = r112.next();     // Catch: Throwable -> L25
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r110.a().a()) == false) goto L14;
    L19:
        final com.obric.aiagent.skill.manager.api.e r3 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r3 != null) goto L23;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r16, Activity.class, "com.obric.aiagent.plugin"), cm.a.h);
        String r20 = r16.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_not_installed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_not_installed"));
        d.h.b.o.c(r20, "getString(...)");
        r18.invoke(r20);
        return;
    L23:
        co.a(r16, r3, new $$Lambda$r$gRBNDFW0_I46lU67B7SemyMjZrc(r3, r16, r18, r110, r19));
        return;
    L18:
        r2 = null;
    L25:
        th = move-exception;
        a("read installed skill", th);
        String r21 = r16.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_open_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_open_failed"));
        d.h.b.o.c(r21, "getString(...)");
        r18.invoke(r21);
    }

    private static final d.x a(com.obric.aiagent.skill.manager.api.e r9, FragmentActivity r10, d.h.a.b r11, a r12, d.h.a.a r13) {
        FragmentActivity r14 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r10, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super String, d.x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r9.l() == true) goto L6;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r14, Activity.class, "com.obric.aiagent.plugin"), cm.a.i);
        String r16 = r14.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_not_enabled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_not_enabled"));
        d.h.b.o.c(r16, "getString(...)");
        r8.invoke(r16);
        return d.x.f38692a;
    L6:
        r r2 = f20808a;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r14, Context.class, "com.obric.aiagent.plugin");
        String r4 = r9.a();
        String r5 = r12.b();
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.f(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r17) == false) goto L10;
        r17 = r12.a().f();
    L10:
        if (r2.a(r3, r4, r5, (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.aiagent.plugin"), r12.c(), r8) == false) goto L13;
        r15.invoke();
    L13:
        return d.x.f38692a;
    }

    private final boolean b(Context r16, ISkillManagerService r17, String r18, String r19, d.h.a.b<? super String, d.x> r20) {
        CharSequence r0 = r18;
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        ISkillManagerService r3 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r17, ISkillManagerService.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super String, d.x> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L46;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r5 = true;
        if (r4 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == true) goto L46;
        List r7 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r3.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (r7 != null) goto L16;
        r7 = d.a.p.b();     // Catch: Throwable -> L43
    L16:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L43
    L18:
        if (r8.hasNext() == false) goto L22;
        Object r9 = r8.next();     // Catch: Throwable -> L43
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r0) == false) goto L18;
    L23:
        com.obric.aiagent.skill.manager.api.e r11 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (r11 != null) goto L26;
    L28:
        r5 = false;
    L29:
        if (r5 == false) goto L32;
        String r2 = r1.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_security_failed_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_security_failed_toast"));     // Catch: Throwable -> L43
        d.h.b.o.c(r2, "getString(...)");     // Catch: Throwable -> L43
        r10.invoke(r2);     // Catch: Throwable -> L43
        return false;
    L32:
        if (r11 != null) goto L34;
    L41:
        String r12 = r1.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_unavailable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_unavailable"));     // Catch: Throwable -> L43
        d.h.b.o.c(r12, "getString(...)");     // Catch: Throwable -> L43
        r10.invoke(r12);     // Catch: Throwable -> L43
        return false;
    L34:
        if (r11.l() == false) goto L41;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (d.o.o.d(r13) == true) goto L52;
        r0 = r13;
    L52:
        return a(r1, (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin"), com.obric.aiagent.skill.manager.impl.az.d(r11), r11.f(), r19, r10);
    L26:
        if (com.obric.aiagent.skill.manager.impl.az.a(r11) != true) goto L28;
    L22:
        r9 = null;
    L43:
        th = move-exception;
        a("read installed skill", th);
        String r14 = r1.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_open_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_open_failed"));
        d.h.b.o.c(r14, "getString(...)");
        r10.invoke(r14);
        return false;
    L7:
        if (d.o.o.d(r4) == true) goto L10;
        r6 = false;
    L46:
        String r15 = r1.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_open_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_open_failed"));
        d.h.b.o.c(r15, "getString(...)");
        r10.invoke(r15);
        return false;
    }

    private final boolean a(Context r6, String r7, String r8, String r9, String r10, d.h.a.b<? super String, d.x> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super String, d.x> r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L19:
        String r5 = r12.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_info_incomplete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_info_incomplete"));
        d.h.b.o.c(r5, "getString(...)");
        r13.invoke(r5);
        return false;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L19;
        Intent r0 = a(r12);
        r0.putExtra("obric_auto_mention", "1");
        r0.putExtra("obric_skill_slug", r7);
        r0.putExtra("obric_skill_display_name", r8);
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L10;
        r0.putExtra("obric_skill_cover_url", r9);
    L10:
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L13;
    L14:
        r2 = true;
    L15:
        if (r2 == true) goto L17;
        r0.putExtra("obric_auto_mention_content", r10);
    L17:
        d.x r15 = d.x.f38692a;
        return a(r12, r0, r13);
    L13:
        if (d.o.o.d(r14) == false) goto L15;
        goto L14
    }

    private final a a(Context r10, e r11, com.obric.aiagent.skill.manager.api.e r12, List<com.obric.aiagent.skill.manager.api.e> r13, d.h.a.b<? super String, d.x> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r17 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r9 = a(r11.a());
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        String r18 = r15.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_example_empty, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_example_empty"));
        d.h.b.o.c(r18, "getString(...)");
        r17.invoke(r18);
        return null;
    L7:
        if (r11.d() == false) goto L10;
        String r19 = r15.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_example_invalid, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_example_invalid"));
        d.h.b.o.c(r19, "getString(...)");
        r17.invoke(r19);
        return null;
    L10:
        List r110 = d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(r11.c(), Iterable.class, "com.obric.aiagent.plugin"));
        if (r110.size() <= 1) goto L15;
        String r20 = r15.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_example_multiple_skills, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_example_multiple_skills"));
        d.h.b.o.c(r20, "getString(...)");
        r17.invoke(r20);
        return null;
    L15:
        if (r110.isEmpty() == false) goto L28;
        if (r12 != null) goto L19;
        String r21 = r15.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_example_missing_skill, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_example_missing_skill"));
        d.h.b.o.c(r21, "getString(...)");
        r17.invoke(r21);
        return null;
    L19:
        String r111 = com.obric.aiagent.skill.manager.impl.az.d(r12);
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L22;
    L26:
        String r22 = r15.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_info_incomplete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_info_incomplete"));
        d.h.b.o.c(r22, "getString(...)");
        r17.invoke(r22);
        return null;
    L22:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L26;
        return new a(r12, r111, '@' + r111 + ' ' + r9);
    L28:
        String r112 = (String) ZeusTransformUtils.preCheckCast(d.a.p.o(r110), String.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L31;
    L33:
        r12 = null;
    L34:
        Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r114 = r113.iterator();
    L36:
        if (r114.hasNext() == false) goto L40;
        Object r6 = r114.next();
        if (d.h.b.o.a(com.obric.aiagent.skill.manager.impl.az.d((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")), r112) == false) goto L36;
        r0.add(r6);
        goto L36
    L40:
        Iterable r115 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        HashSet r1 = new HashSet();
        ArrayList r7 = new ArrayList();
        Iterator r116 = r115.iterator();
    L42:
        if (r116.hasNext() == false) goto L46;
        Object r8 = r116.next();
        if (r1.add(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a()) == false) goto L42;
        r7.add(r8);
        goto L42
    L46:
        List r117 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L49;
        r12 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(d.a.p.p(r117), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
    L49:
        if (r12 != null) goto L57;
        if (r117.isEmpty() == false) goto L53;
        String r23 = r15.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_example_skill_not_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_example_skill_not_found"));
    L54:
        d.h.b.o.a(r23);
        r17.invoke(r23);
        return null;
    L53:
        r23 = r15.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_example_skill_name_ambiguous, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_example_skill_name_ambiguous"));
        goto L54
    L57:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L61;
        String r24 = r15.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_info_incomplete, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_info_incomplete"));
        d.h.b.o.c(r24, "getString(...)");
        r17.invoke(r24);
        return null;
    L61:
        return new a(r12, r112, r9);
    L31:
        if (d.h.b.o.a(com.obric.aiagent.skill.manager.impl.az.d(r12), r112) == false) goto L33;
        goto L33
    }

    private final String a(String r7) {
        if (r7.length() >= 2) goto L5;
        return r7;
    L5:
        boolean r1 = false;
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == '\"') goto L8;
    L10:
        boolean r6 = false;
    L12:
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) != 8220) goto L16;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) != 8221) goto L16;
    L19:
        r1 = true;
    L20:
        if (r6 == true) goto L22;
        if (r1 == true) goto L22;
        return r7;
    L22:
        String r8 = r7.substring(1, d.o.o.e((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")));
        d.h.b.o.c(r8, "substring(...)");
        return r8;
    L16:
        if (d.o.o.h((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) != 8221) goto L20;
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) != 8220) goto L20;
    L8:
        if (d.o.o.j((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) != '\"') goto L10;
        r6 = true;
        goto L12
    }

    private final boolean a(Context r3, Intent r4, d.h.a.b<? super String, d.x> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.startActivity(r6, r4, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        a("start chat activity", th);
        String r2 = r6.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_chat_open_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_chat_open_failed"));
        d.h.b.o.c(r2, "getString(...)");
        r7.invoke(r2);
        return false;
    }

    private final void a(String r3, Throwable r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        a("SkillManager", "Open skill chat failed stage=" + r3, r4);
        return;
    L5:
        a("SkillManager", "Open skill chat failed");
    }

    private final Intent a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Intent r4 = new Intent();
        r4.setComponent(new ComponentName(r2.getPackageName(), "com.larus.bmhome.chat.ChatActivity"));
        r4.setFlags(335544320);
        r4.putExtra("bot_id", "7234781073513644036");
        r4.putExtra("as_container", "O");
        r4.putExtra("obric_allow_show_when_locked", true);
        return r4;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
