package com.obric.autogui.agents.vlm.models.omni.upload;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: compiled from: OmniUploadTaskLifecycle.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28879a = null;

        static {
            int[] r0 = new int[x.values().length];
            r0[x.f28881b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[x.f28882c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[x.f28880a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[x.f28883d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f28879a = r0;
        }
    }

    public static final x a(x r2) {
        d.h.b.o.e(r2, "state");
        int r0 = a.f28879a[r2.ordinal()];
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L10;
        return r2;
    L10:
        return x.f28883d;
    L9:
        return x.f28880a;
    }

    public static final boolean a(x r1, boolean r2, boolean r3, int r4) {
        d.h.b.o.e(r1, "state");
        if (r1 != x.f28882c) goto L8;
        if (r2 == false) goto L8;
        if (r3 == false) goto L8;
        if (r4 != 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static final Boolean a(x r3, int r4, boolean r5, boolean r6) {
        d.h.b.o.e(r3, "state");
        int r7 = a.f28879a[r3.ordinal()];
        boolean r0 = false;
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L21;
        if (r7 != 3) goto L9;
        return null;
    L9:
        if (r7 != 4) goto L18;
        if (r5 == false) goto L14;
        if (r4 != 1) goto L22;
        if (r6 == false) goto L22;
    L15:
        r0 = true;
    L22:
        return Boolean.valueOf(r0);
    L14:
        if (r4 != 0) goto L22;
    L18:
        throw new d.k();
    L21:
        return false;
    }

    public static final String a(String r4) {
        d.h.b.o.e(r4, DBDefinition.TASK_ID);
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L17;
        String r6 = r.f28823b.a(r5);
        if (r6 != null) goto L14;
        return null;
    L14:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        return null;
    L16:
        return r6;
    L17:
        return null;
    L5:
        r0 = false;
        goto L7
    }

    public static final boolean a(String r1, String r2) {
        d.h.b.o.e(r1, "left");
        d.h.b.o.e(r2, "right");
        String r3 = a(r1);
        if (r3 != null) goto L7;
        return false;
    L7:
        return d.h.b.o.a(r3, a(r2));
    }
}
