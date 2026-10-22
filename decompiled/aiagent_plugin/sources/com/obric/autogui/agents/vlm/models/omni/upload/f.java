package com.obric.autogui.agents.vlm.models.omni.upload;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
    @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {DownloadErrorCode.ERROR_CHUNK_COUNT_ERROR}, d = "cleanupVersionedFeedbackTasks", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenterKt")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28775c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28776d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28777e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        int i;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.h = r7;
            this.i |= Integer.MIN_VALUE;
            return f.a(null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final boolean a(Boolean r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        return false;
    }

    public static final boolean a(x r1) {
        d.h.b.o.e(r1, "state");
        if (r1 != x.f28880a) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a(Set<String> r3, Set<String> r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "outboundFilePaths");
        d.h.b.o.e(r6, "storedFilePaths");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.containsAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0105 -> B:27:0x010e). Please report as a decompilation issue!!! */
    public static final Object a(Map<String, String> r9, Set<String> r10, Set<String> r11, d.h.a.m<? super String, ? super d.c.d<? super Boolean>, ? extends Object> r12, d.h.a.m<? super String, ? super String, Boolean> r13, d.c.d<? super d.x> r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Set r16 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.aiagent.plugin");
        Set r17 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        d.h.a.m r18 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.m r19 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r110 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r110, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r110, a.class, "com.obric.aiagent.plugin");
        if ((r0.i & Integer.MIN_VALUE) == 0) goto L7;
        r0.i -= Integer.MIN_VALUE;
    L8:
        Object r111 = r0.h;
        Object r2 = d.c.a.b.a();
        int r3 = r0.i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r0.g, String.class, "com.obric.aiagent.plugin");
        String r112 = (String) ZeusTransformUtils.preCheckCast(r0.f, String.class, "com.obric.aiagent.plugin");
        Iterator r113 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f28777e, Iterator.class, "com.obric.aiagent.plugin");
        d.h.a.m r114 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r0.f28776d, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.m r115 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r0.f28775c, d.h.a.m.class, "com.obric.aiagent.plugin");
        Set r4 = (Set) ZeusTransformUtils.preCheckCast(r0.f28774b, Set.class, "com.obric.aiagent.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r0.f28773a, Map.class, "com.obric.aiagent.plugin");
        d.o.a(r111);
    L28:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r111, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L30;
        r114.invoke(r112, r20);
    L30:
        Set r116 = r4;
        r15 = r5;
        d.h.a.m r7 = r115;
        r19 = r114;
        r18 = r7;
    L16:
        if (r113.hasNext() == false) goto L32;
        String r117 = (String) ZeusTransformUtils.preCheckCast(r113.next(), String.class, "com.obric.aiagent.plugin");
        if (r116.contains(r117) == true) goto L16;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r15.get(r117), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L16;
        r0.f28773a = r15;
        r0.f28774b = r116;
        r0.f28775c = r18;
        r0.f28776d = r19;
        r0.f28777e = r113;
        r0.f = r117;
        r0.g = r6;
        r0.i = 1;
        Object r8 = r18.invoke(r117, r0);
        if (r8 != r2) goto L26;
        return r2;
    L26:
        r5 = r15;
        r20 = r6;
        r4 = r116;
        r112 = r117;
        r111 = r8;
        d.h.a.m r21 = r19;
        r115 = r18;
        r114 = r21;
        goto L28
    L32:
        return d.x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r111);
        r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r116 = r17;
    L7:
        r0 = new a(r110);
        goto L8
    }
}
