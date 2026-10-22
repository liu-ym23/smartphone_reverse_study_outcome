package com.obric.autogui.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IOAutoStateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IOAutoStateManager {

    /* JADX INFO: compiled from: IOAutoStateManager.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f28913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Integer f28914b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f28913a == r6.f28913a) goto L12;
            return false;
        L12:
            if (o.a(this.f28914b, r6.f28914b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.f28913a) * 31;
            Integer r1 = this.f28914b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "CurrentStateResult(code=" + this.f28913a + ", state=" + this.f28914b + ')';
        }

        public a(int r1, Integer r2) {
            this.f28913a = r1;
            this.f28914b = r2;
        }

        public /* synthetic */ a(int r1, Integer r2, int r3, h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final int a() {
            return this.f28913a;
        }

        public final Integer b() {
            return this.f28914b;
        }
    }

    /* JADX INFO: compiled from: IOAutoStateManager.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f28916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f28917c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f28918d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f28919e;
        private final boolean f;
        private final Integer g;

        public b() {
            this(null, null, null, null, null, false, null, 127, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28915a, r6.f28915a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f28916b, r6.f28916b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f28917c, r6.f28917c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f28918d, r6.f28918d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f28919e, r6.f28919e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (o.a(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            String r0 = this.f28915a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.f28916b.hashCode()) * 31;
            String r4 = this.f28917c;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f28918d;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.f28919e;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (((r9 + r11) * 31) + Boolean.hashCode(this.f)) * 31;
            Integer r13 = this.g;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return r12 + r1;
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "OmniUploadFeedbackInfo(content=" + this.f28915a + ", tags=" + this.f28916b + ", type=" + this.f28917c + ", source=" + this.f28918d + ", score=" + this.f28919e + ", needUploadImage=" + this.f + ", amount=" + this.g + ')';
        }

        public b(String r3, List<String> r4, String r5, String r6, String r7, boolean r8, Integer r9) {
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            o.e(r10, "tags");
            this.f28915a = r3;
            this.f28916b = r10;
            this.f28917c = r5;
            this.f28918d = r6;
            this.f28919e = r7;
            this.f = r8;
            this.g = r9;
        }

        public final String a() {
            return this.f28915a;
        }

        public /* synthetic */ b(String r9, List r10, String r11, String r12, String r13, boolean r14, Integer r15, int r16, h r17) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
            Integer r2 = null;
            if ((r16 & 1) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r16 & 2) == 0) goto L10;
            r0 = p.b();
        L10:
            if ((r16 & 4) == 0) goto L12;
            String r3 = null;
        L14:
            if ((r16 & 8) == 0) goto L16;
            String r4 = null;
        L18:
            if ((r16 & 16) == 0) goto L20;
            String r5 = null;
        L22:
            if ((r16 & 32) == 0) goto L24;
            boolean r6 = true;
        L26:
            if ((r16 & 64) != 0) goto L29;
            r2 = r15;
        L29:
            this(r1, r0, r3, r4, r5, r6, r2);
            return;
        L24:
            r6 = r14;
            goto L26
        L20:
            r5 = r13;
            goto L22
        L16:
            r4 = r12;
            goto L18
        L12:
            r3 = r11;
            goto L14
        L5:
            r1 = r9;
            goto L7
        }

        public final List<String> b() {
            return this.f28916b;
        }

        public final String getType() {
            return this.f28917c;
        }

        public final String c() {
            return this.f28918d;
        }

        public final String d() {
            return this.f28919e;
        }

        public final boolean e() {
            return this.f;
        }

        public final Integer f() {
            return this.g;
        }
    }

    void drainOmniUploadImagesForFeedback(String r1);

    void drainOmniUploadImagesForFeedback(String r1, b r2);

    com.obric.autogui.api.a fetchTopDisplayed();

    a getCurrentState(String r1);

    Map<String, Object> getOmniExtraLog(String r1);

    List<String> getOmniJournalPath(String r1);

    void onOmniInferenceImageUploadFinished(String r1);

    void onOmniInferenceImageUploadStarted(String r1);

    boolean stopTask(String r1, String r2, int r3, Map<String, String> r4);
}
