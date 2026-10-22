package com.obric.autogui.common.api.platform.display.capture;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.io.File;
import kotlinx.coroutines.au;

/* JADX INFO: compiled from: HeifScreenshotAttachment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HeifScreenshotAttachment {
    public static final String CACHE_DIR_NAME = "oauto_heif_screenshot";
    public static final Companion Companion = null;
    private volatile au<Boolean> encodingComplete;
    private final File file;

    /* JADX INFO: compiled from: HeifScreenshotAttachment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final File cacheDir(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            return new File(r1.getCacheDir(), HeifScreenshotAttachment.CACHE_DIR_NAME);
        }

        public final void clearCacheDir(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            File r5 = cacheDir(r4);
            if (r5.exists() == true) goto L17;
            return;
        L17:
            n.a r0 = n.f38560a;     // Catch: Throwable -> L14
            Companion r2 = (Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            File[] r6 = r5.listFiles();     // Catch: Throwable -> L14
            if (r6 == null) goto L11;
            int r7 = 0;
            int r1 = r6.length;     // Catch: Throwable -> L14
        L8:
            if (r7 >= r1) goto L10;
            r6[r7].delete();     // Catch: Throwable -> L14
            r7 = r7 + 1;     // Catch: Throwable -> L14
            goto L8
        L10:
            x r8 = x.f38692a;     // Catch: Throwable -> L14
        L12:
            n.f(r8);     // Catch: Throwable -> L14
            return;
        L11:
            r8 = null;
        L14:
            th = move-exception;
            n.a r9 = n.f38560a;
            n.f(d.o.a(th));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment$awaitEncodingComplete$1, reason: invalid class name */
    /* JADX INFO: compiled from: HeifScreenshotAttachment.kt */
    @f(b = "HeifScreenshotAttachment.kt", c = {30}, d = "awaitEncodingComplete", e = "com.obric.autogui.common.api.platform.display.capture.HeifScreenshotAttachment")
    static final class AnonymousClass1 extends d {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HeifScreenshotAttachment this$0;

        AnonymousClass1(HeifScreenshotAttachment r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitEncodingComplete((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ HeifScreenshotAttachment copy$default(HeifScreenshotAttachment r0, File r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.file;
    L6:
        return r0.copy(r1);
    }

    public final File component1() {
        return this.file;
    }

    public final HeifScreenshotAttachment copy(File r1) {
        o.e(r1, "file");
        return new HeifScreenshotAttachment(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HeifScreenshotAttachment.class) == true) goto L8;
        return false;
    L8:
        HeifScreenshotAttachment r6 = (HeifScreenshotAttachment) ZeusTransformUtils.preCheckCast(r5, HeifScreenshotAttachment.class, "com.obric.aiagent.plugin");
        if (o.a(this.file, r6.file) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    public String toString() {
        return "HeifScreenshotAttachment(file=" + this.file + ')';
    }

    public HeifScreenshotAttachment(File r2) {
        o.e(r2, "file");
        this.file = r2;
    }

    public final File getFile() {
        return this.file;
    }

    public final au<Boolean> getEncodingComplete() {
        return this.encodingComplete;
    }

    public final void setEncodingComplete(au<Boolean> r3) {
        this.encodingComplete = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
    }

    public final boolean isValid() {
        if (this.file.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.file.length() <= 0) goto L7;
        return true;
    }

    public final Object awaitEncodingComplete(d.c.d<? super Boolean> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r7, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        d.o.a(r8);     // Catch: Throwable -> L13
    L24:
        Object r5 = n.f(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L13
    L27:
        Boolean r9 = d.c.b.a.b.a(false);
        if (n.b(r5) == true) goto L30;
        return r5;
    L30:
        return r9;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r8);
        au<Boolean> r10 = this.encodingComplete;
        if (r10 == null) goto L20;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L13
        HeifScreenshotAttachment r11 = (HeifScreenshotAttachment) ZeusTransformUtils.preCheckCast(this, HeifScreenshotAttachment.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r8 = r10.a(r0);     // Catch: Throwable -> L13
        if (r8 != r2) goto L24;
        return r2;
    L20:
        return d.c.b.a.b.a(true);
    L13:
        th = move-exception;
        n.a r12 = n.f38560a;
        r5 = n.f(d.o.a(th));
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    public final ParcelFileDescriptor openReadOnlyFd() {
        ParcelFileDescriptor r1 = ParcelFileDescriptor.open(this.file, 268435456);
        o.c(r1, "open(...)");
        return r1;
    }

    public final boolean delete() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        Object r3 = n.f(Boolean.valueOf(((HeifScreenshotAttachment) ZeusTransformUtils.preCheckCast(this, HeifScreenshotAttachment.class, "com.obric.aiagent.plugin")).file.delete()));     // Catch: Throwable -> L5
    L8:
        if (n.b(r3) == false) goto L11;
        r3 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        n.a r2 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L8
    }
}
