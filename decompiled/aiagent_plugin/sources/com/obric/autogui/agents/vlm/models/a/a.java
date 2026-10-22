package com.obric.autogui.agents.vlm.models.a;

import android.content.ComponentName;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotTaskInfo;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: IScreenshotProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IScreenshotProvider.kt */
    public static final class C0681a {
        public static /* synthetic */ Object a(a r2, String r3, AOOperatingSpace r4, boolean r5, boolean r6, d.c.d r7, int r8, Object r9) {
            a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            AOOperatingSpace r11 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            d.c.d<? super ScreenshotResult> r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L18;
            if ((r8 & 2) == 0) goto L7;
            r11 = null;
        L7:
            AOOperatingSpace r12 = r11;
            if ((r8 & 4) == 0) goto L10;
            boolean r1 = false;
        L12:
            if ((r8 & 8) == 0) goto L14;
            boolean r13 = false;
        L16:
            return r10.a(r3, r12, r1, r13, r0);
        L14:
            r13 = r6;
            goto L16
        L10:
            r1 = r5;
            goto L12
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: acquireScreenshot");
        }

        public static /* synthetic */ Object a(a r2, String r3, ScreenshotConfig r4, boolean r5, d.c.d r6, int r7, Object r8) {
            a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            d.c.d<? super ScreenshotResult> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L13;
            if ((r7 & 2) == 0) goto L8;
            r4 = null;
        L8:
            if ((r7 & 4) == 0) goto L11;
            r5 = false;
        L11:
            return r9.a(r3, r4, r5, r10);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: acquireMDScreenshot");
        }
    }

    /* JADX INFO: compiled from: IScreenshotProvider.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IScreenshot f27238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ComponentName f27239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<ViewHierarchyDump> f27240c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ScreenshotTaskInfo f27241d;

        public b() {
            this(null, null, null, null, 15, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f27238a, r6.f27238a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f27239b, r6.f27239b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f27240c, r6.f27240c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f27241d, r6.f27241d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            IScreenshot r0 = this.f27238a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            ComponentName r4 = this.f27239b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            List<ViewHierarchyDump> r7 = this.f27240c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            ScreenshotTaskInfo r10 = this.f27241d;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
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
            return "ScreenStateRecord(screenshot=" + this.f27238a + ", topComponent=" + this.f27239b + ", viewTree=" + this.f27240c + ", taskInfo=" + this.f27241d + ')';
        }

        public b(IScreenshot r3, ComponentName r4, List<ViewHierarchyDump> r5, ScreenshotTaskInfo r6) {
            IScreenshot r7 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshot.class, "com.obric.aiagent.plugin");
            List<ViewHierarchyDump> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            this.f27238a = r7;
            this.f27239b = r4;
            this.f27240c = r8;
            this.f27241d = r6;
        }

        public /* synthetic */ b(IScreenshot r2, ComponentName r3, List r4, ScreenshotTaskInfo r5, int r6, d.h.b.h r7) {
            IScreenshot r8 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r2, IScreenshot.class, "com.obric.aiagent.plugin");
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            if ((r6 & 1) == 0) goto L6;
            r8 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r9 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r8, r3, r9, r5);
        }

        public final IScreenshot a() {
            return this.f27238a;
        }

        public final ComponentName b() {
            return this.f27239b;
        }

        public final List<ViewHierarchyDump> c() {
            return this.f27240c;
        }

        public final ScreenshotTaskInfo d() {
            return this.f27241d;
        }

        public final void e() {
            IScreenshot r0 = this.f27238a;
            if (r0 == null) goto L6;
            r0.release();
            return;
        }
    }

    IScreenshot a(String r1);

    Object a(String r1, ScreenshotConfig r2, boolean r3, d.c.d<? super ScreenshotResult> r4);

    Object a(String r1, AOOperatingSpace r2, boolean r3, boolean r4, d.c.d<? super ScreenshotResult> r5);

    void e();
}
