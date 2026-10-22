package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.utils.g;
import d3.a0;
import k2.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.floatinginput.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0688a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35512a = null;

        static {
            int[] r100 = new int[ContainerType.values().length];
            r100[ContainerType.PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f35512a = r100;
        }
    }

    public static final j a(AIBridgeMethod r100, e3.d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        a0 r102 = r101.getContainerContext();
        j r103 = null;
        if (r102 == null) goto L5;
        ContainerType r104 = r102.getContainerType();
    L6:
        if (r104 != null) goto L8;
        int r105 = -1;
    L10:
        if (r105 != 1) goto L12;
        r103 = (j) r101.d(j.class);
    L12:
        g.f37637a.d("FloatingSpeaker", r100.getName() + " getAIContainerView " + r103);
        return r103;
    L8:
        r105 = C0688a.f35512a[r104.ordinal()];
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
