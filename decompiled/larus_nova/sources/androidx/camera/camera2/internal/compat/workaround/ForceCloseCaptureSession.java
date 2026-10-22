package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ForceCloseCaptureSession {
    private final CaptureSessionOnClosedNotCalledQuirk mCaptureSessionOnClosedNotCalledQuirk;

    @FunctionalInterface
    public interface OnConfigured {
        void run(SynchronizedCaptureSession r100);
    }

    public boolean shouldForceClose() {
        if (this.mCaptureSessionOnClosedNotCalledQuirk == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ForceCloseCaptureSession(Quirks r100) {
        this.mCaptureSessionOnClosedNotCalledQuirk = (CaptureSessionOnClosedNotCalledQuirk) r100.get(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    private void forceOnClosed(Set<SynchronizedCaptureSession> r100) {
        Iterator<SynchronizedCaptureSession> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        SynchronizedCaptureSession r102 = r101.next();
        r102.getStateCallback().onClosed(r102);
        goto L4
    }

    private void forceOnConfigureFailed(Set<SynchronizedCaptureSession> r100) {
        Iterator<SynchronizedCaptureSession> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        SynchronizedCaptureSession r102 = r101.next();
        r102.getStateCallback().onConfigureFailed(r102);
        goto L4
    }

    public void onSessionConfigured(SynchronizedCaptureSession r100, List<SynchronizedCaptureSession> r101, List<SynchronizedCaptureSession> r102, OnConfigured r103) {
        if (shouldForceClose() == false) goto L12;
        LinkedHashSet r104 = new LinkedHashSet();
        Iterator<SynchronizedCaptureSession> r105 = r101.iterator();
    L6:
        if (r105.hasNext() == false) goto L11;
        SynchronizedCaptureSession r106 = r105.next();
        if (r106 == r100) goto L11;
        r104.add(r106);
    L11:
        forceOnConfigureFailed(r104);
    L12:
        r103.run(r100);
        if (shouldForceClose() == false) goto L27;
        LinkedHashSet r107 = new LinkedHashSet();
        Iterator<SynchronizedCaptureSession> r108 = r102.iterator();
    L16:
        if (r108.hasNext() == false) goto L21;
        SynchronizedCaptureSession r109 = r108.next();
        if (r109 == r100) goto L21;
        r107.add(r109);
    L21:
        forceOnClosed(r107);
        return;
    }
}
