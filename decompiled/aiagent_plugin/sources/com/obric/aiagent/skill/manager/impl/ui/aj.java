package com.obric.aiagent.skill.manager.impl.ui;

import com.obric.autogui.common.api.agent.BizStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum aj extends Enum<aj> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aj f20529b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final aj f20530c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final aj f20531d = null;
    private static final /* synthetic */ aj[] g = null;
    private static final /* synthetic */ d.d.a h = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f20532e;
    private final com.obric.aiagent.skill.manager.impl.bw f;

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final aj a(int r4) {
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(aj.c(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L11;
            Object r0 = r3.next();
            if (((aj) ZeusTransformUtils.preCheckCast(r0, aj.class, "com.obric.aiagent.plugin")).a() != r4) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L4;
        L13:
            return (aj) ZeusTransformUtils.preCheckCast(r0, aj.class, "com.obric.aiagent.plugin");
        L8:
            r2 = false;
            goto L9
        L11:
            r0 = null;
            goto L13
        }
    }

    public static d.d.a<aj> c() {
        return h;
    }

    private static final /* synthetic */ aj[] d() {
        return new aj[]{f20529b, f20530c, f20531d};
    }

    private aj(String r1, int r2, int r3, com.obric.aiagent.skill.manager.impl.bw r4) {
        super(r1, r2);
        this.f20532e = r3;
        this.f = r4;
    }

    public final int a() {
        return this.f20532e;
    }

    public final com.obric.aiagent.skill.manager.impl.bw b() {
        return this.f;
    }

    static {
        f20529b = new aj("IMPORT_PACKAGE", 0, 1101, com.obric.aiagent.skill.manager.impl.bw.f19620a);
        f20530c = new aj("CREATE_FORM", 1, BizStatus.StatusChangedReason.TERMINATED__OTHER_REASON, com.obric.aiagent.skill.manager.impl.bw.f19621b);
        f20531d = new aj("EDIT_FORM", 2, 1103, com.obric.aiagent.skill.manager.impl.bw.f19621b);
        aj[] r0 = d();
        g = r0;
        h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f20528a = new a(null);
    }

    public static aj valueOf(String r2) {
        return (aj) ZeusTransformUtils.preCheckCast(Enum.valueOf(aj.class, r2), aj.class, "com.obric.aiagent.plugin");
    }

    public static aj[] values() {
        return (aj[]) ZeusTransformUtils.preCheckCast(g.clone(), aj[].class, "com.obric.aiagent.plugin");
    }
}
