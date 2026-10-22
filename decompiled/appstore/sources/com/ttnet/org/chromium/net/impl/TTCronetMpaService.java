package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTMpaService;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("cronet")
public final class TTCronetMpaService extends TTMpaService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f18734c = "TTCronetMpaService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TTMpaService.ICallback f18735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TTMpaService.ICallback f18736b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTCronetMpaService f18739c;

        public a(TTCronetMpaService r10, boolean r11, String r12) {
            this.f18739c = r10;
            this.f18737a = r11;
            this.f18738b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTCronetMpaService.a(this.f18739c).onFinish(this.f18737a, this.f18738b);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(TTCronetMpaService.b(), "Exception in callback: ", new Object[]{e});
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TTCronetMpaService f18742c;

        public b(TTCronetMpaService r10, boolean r11, String r12) {
            this.f18742c = r10;
            this.f18740a = r11;
            this.f18741b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTCronetMpaService.c(this.f18742c).onFinish(this.f18740a, this.f18741b);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(TTCronetMpaService.b(), "Exception in callback: ", new Object[]{e});
        }
    }

    static {
    }

    public static /* synthetic */ TTMpaService.ICallback a(TTCronetMpaService r10) {
        return r10.f18735a;
    }

    public static /* synthetic */ String b() {
        return f18734c;
    }

    public static /* synthetic */ TTMpaService.ICallback c(TTCronetMpaService r10) {
        return r10.f18736b;
    }

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeCommand(long r10, String r11, String r12);

    private native long nativeCreateMpaServiceAdapter(long r10);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeInit(long r10);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeSetAccAddress(long r10, String[] r11);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStart(long r10);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStop(long r10);

    @CalledByNative
    private void onInitFinish(boolean r10, String r11) {
        d(new a(this, r10, r11));
    }

    @CalledByNative
    private void onSetAccAddressFinish(boolean r10, String r11) {
        d(new b(this, r10, r11));
    }

    public final void d(Runnable r10) {
        Thread r11 = new Thread(r10);
        r11.setName("TTCronetMpaService_Thread");
        r11.start();
    }
}
