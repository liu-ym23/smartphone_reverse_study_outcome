package com.obric.aiagent.assistant_card.provider_core.bean;

import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DialogBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16364a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f16368e;
    private final IHostApiCallback f;
    private final IHostApiCallback g;

    /* JADX INFO: compiled from: DialogBean.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f16364a = new a(null);
    }

    public b() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f16365b, r6.f16365b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f16366c, r6.f16366c) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f16367d, r6.f16367d) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f16368e, r6.f16368e) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (o.a(this.g, r6.g) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.f16365b;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f16366c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f16367d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f16368e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        IHostApiCallback r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        IHostApiCallback r16 = this.g;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
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
        return "DialogBean(title=" + this.f16365b + ", message=" + this.f16366c + ", cancelText=" + this.f16367d + ", confirmText=" + this.f16368e + ", cancelClickListener=" + this.f + ", confirmClickListener=" + this.g + ')';
    }

    public b(String r3, String r4, String r5, String r6, IHostApiCallback r7, IHostApiCallback r8) {
        IHostApiCallback r9 = (IHostApiCallback) ZeusTransformUtils.wrapperContextForParams(r7, IHostApiCallback.class, "com.obric.aiagent.plugin");
        IHostApiCallback r10 = (IHostApiCallback) ZeusTransformUtils.wrapperContextForParams(r8, IHostApiCallback.class, "com.obric.aiagent.plugin");
        this.f16365b = r3;
        this.f16366c = r4;
        this.f16367d = r5;
        this.f16368e = r6;
        this.f = r9;
        this.g = r10;
    }

    public /* synthetic */ b(String r9, String r10, String r11, String r12, IHostApiCallback r13, IHostApiCallback r14, int r15, h r16) {
        IHostApiCallback r0 = (IHostApiCallback) ZeusTransformUtils.wrapperContextForParams(r13, IHostApiCallback.class, "com.obric.aiagent.plugin");
        IHostApiCallback r1 = (IHostApiCallback) ZeusTransformUtils.wrapperContextForParams(r14, IHostApiCallback.class, "com.obric.aiagent.plugin");
        if ((r15 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r15 & 16) == 0) goto L22;
        r0 = null;
    L22:
        if ((r15 & 32) == 0) goto L24;
        r1 = null;
    L24:
        this(r2, r4, r5, r6, r0, r1);
        return;
    L17:
        r6 = r12;
        goto L19
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r2 = r9;
        goto L7
    }

    public final Bundle a() {
        Bundle r0 = new Bundle();
        r0.putString(DBDefinition.TITLE, this.f16365b);
        r0.putString("message", this.f16366c);
        r0.putString("cancelText", this.f16367d);
        r0.putString("confirmText", this.f16368e);
        IHostApiCallback r1 = this.f;
        IBinder r2 = null;
        if (r1 == null) goto L5;
        IBinder r3 = r1.asBinder();
    L6:
        r0.putBinder("cancelClickListener", r3);
        IHostApiCallback r4 = this.g;
        if (r4 == null) goto L9;
        r2 = r4.asBinder();
    L9:
        r0.putBinder("confirmClickListener", r2);
        return r0;
    L5:
        r3 = null;
        goto L6
    }
}
