package androidx.camera.core;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CameraState {
    public static final int ERROR_CAMERA_DISABLED = 5;
    public static final int ERROR_CAMERA_FATAL_ERROR = 6;
    public static final int ERROR_CAMERA_IN_USE = 2;
    public static final int ERROR_DO_NOT_DISTURB_MODE_ENABLED = 7;
    public static final int ERROR_MAX_CAMERAS_IN_USE = 1;
    public static final int ERROR_OTHER_RECOVERABLE_ERROR = 3;
    public static final int ERROR_STREAM_CONFIG = 4;

    public static final enum ErrorType extends Enum<ErrorType> {
        private static final /* synthetic */ ErrorType[] $VALUES = null;
        public static final ErrorType CRITICAL = null;
        public static final ErrorType RECOVERABLE = null;

        private static /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{RECOVERABLE, CRITICAL};
        }

        static {
            RECOVERABLE = new ErrorType("RECOVERABLE", 0);
            CRITICAL = new ErrorType("CRITICAL", 1);
            $VALUES = $values();
        }

        public static ErrorType[] values() {
            return (ErrorType[]) $VALUES.clone();
        }

        public static ErrorType valueOf(String r100) {
            return (ErrorType) r27.a.a(ErrorType.class, r100);
        }

        private ErrorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class StateError {
        public StateError() {
        }

        public abstract Throwable getCause();

        public abstract int getCode();

        public ErrorType getType() {
            int r100 = getCode();
            if (r100 == 2) goto L12;
            if (r100 == 1) goto L12;
            if (r100 == 3) goto L12;
            return ErrorType.CRITICAL;
        L12:
            return ErrorType.RECOVERABLE;
        }

        public static StateError create(int r100) {
            return create(r100, null);
        }

        public static StateError create(int r100, Throwable r101) {
            return new AutoValue_CameraState_StateError(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CLOSED = null;
        public static final Type CLOSING = null;
        public static final Type OPEN = null;
        public static final Type OPENING = null;
        public static final Type PENDING_OPEN = null;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{PENDING_OPEN, OPENING, OPEN, CLOSING, CLOSED};
        }

        static {
            PENDING_OPEN = new Type("PENDING_OPEN", 0);
            OPENING = new Type("OPENING", 1);
            OPEN = new Type("OPEN", 2);
            CLOSING = new Type("CLOSING", 3);
            CLOSED = new Type(ErrorCode.CLOSED, 4);
            $VALUES = $values();
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public CameraState() {
    }

    public abstract StateError getError();

    public abstract Type getType();

    public static CameraState create(Type r100) {
        return create(r100, null);
    }

    public static CameraState create(Type r100, StateError r101) {
        return new AutoValue_CameraState(r100, r101);
    }
}
