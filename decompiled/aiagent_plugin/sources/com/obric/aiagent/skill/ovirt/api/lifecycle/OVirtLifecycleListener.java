package com.obric.aiagent.skill.ovirt.api.lifecycle;

import com.obric.aiagent.skill.ovirt.api.b.b;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.d;
import d.h.b.o;
import d.n;
import d.x;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: OVirtLifecycleListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface OVirtLifecycleListener {
    public static final a Companion = null;

    /* JADX INFO: compiled from: OVirtLifecycleListener.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f21010a = null;

        static {
            f21010a = new a();
        }

        private a() {
        }

        public final List<OVirtLifecycleListener> a() {
            Set r2 = ServiceManager.get().getServices(OVirtLifecycleListener.class);
            o.b(r2, "ServiceManager.get().getServices(T::class.java)");
            return p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = a.f21010a;
    }

    /* JADX INFO: renamed from: afterShellReturn-gIAlu-s */
    Object mo250afterShellReturngIAlus(b.a r1, d<? super n<b.a>> r2);

    /* JADX INFO: renamed from: beforeShellStart-gIAlu-s */
    Object mo251beforeShellStartgIAlus(String r1, d<? super n<? extends Map<String, String>>> r2);

    String getId();

    /* JADX INFO: renamed from: onSkillLoaded-BWLJW6A */
    Object mo252onSkillLoadedBWLJW6A(String r1, String r2, List<String> r3, d<? super n<x>> r4);

    /* JADX INFO: renamed from: onTaskClosing-gIAlu-s */
    Object mo253onTaskClosinggIAlus(String r1, d<? super n<x>> r2);
}
