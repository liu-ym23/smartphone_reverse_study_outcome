package androidx.camera.core;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_SurfaceOutput_Event extends SurfaceOutput.Event {
    private final int eventCode;
    private final SurfaceOutput surfaceOutput;

    public int hashCode() {
        return ((this.eventCode ^ 1000003) * 1000003) ^ this.surfaceOutput.hashCode();
    }

    public String toString() {
        return "Event{eventCode=" + this.eventCode + ", surfaceOutput=" + this.surfaceOutput + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.SurfaceOutput.Event
    public int getEventCode() {
        return this.eventCode;
    }

    @Override // androidx.camera.core.SurfaceOutput.Event
    public SurfaceOutput getSurfaceOutput() {
        return this.surfaceOutput;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SurfaceOutput.Event) == false) goto L14;
        SurfaceOutput.Event r101 = (SurfaceOutput.Event) r100;
        if (this.eventCode == r101.getEventCode()) goto L10;
    L12:
        return false;
    L10:
        if (this.surfaceOutput.equals(r101.getSurfaceOutput()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_SurfaceOutput_Event(int r100, SurfaceOutput r101) {
        this.eventCode = r100;
        if (r101 == null) goto L7;
        this.surfaceOutput = r101;
        return;
    L7:
        throw new NullPointerException("Null surfaceOutput");
    }
}
