package com.obric.autogui.agents.vlm.models.omni.a;

import com.obric.autogui.agents.vlm.models.omni.a.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DataFeedbackUploadFileName.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g<R extends h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28168a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.o.k f28169d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28171c;

    /* JADX INFO: compiled from: DataFeedbackUploadFileName.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public abstract R a(File r1, String r2, String r3, String r4, Integer r5, long r6, long r8);

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public abstract List<String> d();

    public g() {
        this.f28170b = "_tool_";
        this.f28171c = "_step_";
    }

    public static /* synthetic */ String a(g r6, String r7, String r8, String r9, String r10, String r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 16) == 0) goto L7;
        r11 = null;
    L7:
        return r6.a(r7, r8, r9, r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
    }

    public final String a(String r2, String r3, String r4, String r5, String r6) {
        o.e(r2, "fileNamePrefix");
        o.e(r3, DBDefinition.TASK_ID);
        o.e(r4, "toolId");
        o.e(r5, "stepId");
        StringBuilder r7 = new StringBuilder().append(r2).append(b()).append(a(r3)).append(this.f28170b).append(a(r4)).append(this.f28171c).append(a(r5));
        if (r6 != null) goto L6;
        r6 = c();
    L6:
        return r7.append(r6).toString();
    }

    public final String a(String r2) {
        o.e(r2, "value");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        return f28169d.a(r1, "_");
    }

    public final File a(File r2) {
        o.e(r2, "journalDir");
        return new File(r2, a());
    }

    public final R b(File r16) {
        o.e(r16, "file");
        String r1 = r16.getName();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        o.a(r1);
        if (d.o.o.c(r1, r7, true) == false) goto L4;
    L9:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        if (r16.isFile() == false) goto L36;
        if (r5 == null) goto L36;
        o.a(r1);
        int r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), b(), 0, false, 6, null);
        if (r6 > 0) goto L16;
        return null;
    L16:
        int r8 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), this.f28171c, 0, false, 6, null);
        if (r8 >= 0) goto L19;
        return null;
    L19:
        int r9 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), this.f28170b, r8 - 1, false, 4, null);
        if (r9 >= 0) goto L22;
        return null;
    L22:
        int r10 = b().length() + r6;
        int r11 = this.f28170b.length() + r9;
        int r12 = this.f28171c.length() + r8;
        int r13 = r1.length() - r5.length();
        if (r10 >= r9) goto L36;
        if (r11 >= r8) goto L36;
        if (r12 >= r13) goto L36;
        String r14 = r1.substring(0, r6);
        o.c(r14, "substring(...)");
        String r15 = r1.substring(r10, r9);
        o.c(r15, "substring(...)");
        String r17 = r1.substring(r11, r8);
        o.c(r17, "substring(...)");
        String r18 = r1.substring(r12, r13);
        o.c(r18, "substring(...)");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L36;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L36;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L36;
        return (R) a(r16, r15, r17, r18, d.o.o.d(r14), r16.lastModified(), r16.length());
    L36:
        return null;
    L8:
        r4 = null;
        goto L9
    }

    static {
        f28168a = new a(null);
        f28169d = new d.o.k("[^A-Za-z0-9._-]");
    }
}
