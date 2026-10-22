package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
public class CameraCaptureFailure {
    private final Reason mReason;

    public static final enum Reason extends Enum<Reason> {
        private static final /* synthetic */ Reason[] $VALUES = null;
        public static final Reason ERROR = null;

        private static /* synthetic */ Reason[] $values() {
            return new Reason[]{ERROR};
        }

        static {
            ERROR = new Reason("ERROR", 0);
            $VALUES = $values();
        }

        public static Reason[] values() {
            return (Reason[]) $VALUES.clone();
        }

        public static Reason valueOf(String r100) {
            return (Reason) r27.a.a(Reason.class, r100);
        }

        private Reason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public Object getCaptureFailure() {
        return null;
    }

    public Reason getReason() {
        return this.mReason;
    }

    public CameraCaptureFailure(Reason r100) {
        this.mReason = r100;
    }
}
