package com.obric.oui.dropdown;

import android.app.Activity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: ODropdownTrigger.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: compiled from: ODropdownTrigger.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.dropdown.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ODropdownTrigger.kt */
        static final class C0954a extends p implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ODropdownTrigger f35236a;

            C0954a(ODropdownTrigger r1) {
                this.f35236a = r1;
                super(0);
            }

            public final void a() {
                this.f35236a.setActive(false);
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }
        }

        public static /* synthetic */ void a(b r2, ODropdownTrigger r3, Activity r4, d.h.a.a r5, d.h.a.b r6, int r7, Object r8) {
            b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
            Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
            d.h.a.a<x> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.b<? super CharSequence, x> r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 4) == 0) goto L7;
            r11 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new C0954a(r3), d.h.a.a.class, "com.obric.aiagent.plugin");
        L7:
            r9.a(r3, r10, r11, r12);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    void a(ODropdownTrigger r1, Activity r2, d.h.a.a<x> r3, d.h.a.b<? super CharSequence, x> r4);
}
