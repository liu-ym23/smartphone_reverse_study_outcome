package org.brotli.wrapper.enc;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
class EncoderJNI {

    static final enum Operation extends Enum<Operation> {
        private static final /* synthetic */ Operation[] $VALUES = null;
        public static final Operation FINISH = null;
        public static final Operation FLUSH = null;
        public static final Operation PROCESS = null;

        private static /* synthetic */ Operation[] $values() {
            return new Operation[]{PROCESS, FLUSH, FINISH};
        }

        private Operation(String r1, int r2) {
            super(r1, r2);
        }

        public static Operation valueOf(String name) {
            return (Operation) Enum.valueOf(Operation.class, name);
        }

        public static Operation[] values() {
            return (Operation[]) $VALUES.clone();
        }

        static {
            PROCESS = new Operation("PROCESS", 0);
            FLUSH = new Operation("FLUSH", 1);
            FINISH = new Operation("FINISH", 2);
            $VALUES = $values();
        }
    }

    static class Wrapper {
        protected final long[] context;
        private boolean fresh;
        private final ByteBuffer inputBuffer;

        Wrapper(int inputBufferSize, int quality, int lgwin) throws IOException {
            this.context = new long[5];
            this.fresh = true;
            if (inputBufferSize <= 0) goto L11;
            this.context[1] = inputBufferSize;
            this.context[2] = quality;
            this.context[3] = lgwin;
            this.inputBuffer = EncoderJNI.m10585$$Nest$smnativeCreate(this.context);
            if (this.context[0] == 0) goto L9;
            this.context[1] = 1;
            this.context[2] = 0;
            this.context[3] = 0;
            return;
        L9:
            throw new IOException("failed to initialize native brotli encoder");
        L11:
            throw new IOException("buffer size must be positive");
        }

        void push(Operation op, int length) {
            if (length < 0) goto L22;
            if (this.context[0] == 0) goto L20;
            if (isSuccess() == false) goto L18;
            if (hasMoreOutput() == true) goto L18;
            if (hasRemainingInput() == false) goto L15;
            if (length == 0) goto L15;
            throw new IllegalStateException("pushing input to encoder over previous input");
        L15:
            this.context[1] = op.ordinal();
            this.fresh = false;
            EncoderJNI.m10588$$Nest$smnativePush(this.context, length);
            return;
        L18:
            throw new IllegalStateException("pushing input to encoder in unexpected state");
        L20:
            throw new IllegalStateException("brotli encoder is already destroyed");
        L22:
            throw new IllegalArgumentException("negative block length");
        }

        boolean isSuccess() {
            if (this.context[1] != 0) goto L7;
            return false;
        L7:
            return true;
        }

        boolean hasMoreOutput() {
            if (this.context[2] == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean hasRemainingInput() {
            if (this.context[3] == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isFinished() {
            if (this.context[4] == 0) goto L5;
            return true;
        L5:
            return false;
        }

        ByteBuffer getInputBuffer() {
            return this.inputBuffer;
        }

        ByteBuffer pull() {
            if (this.context[0] == 0) goto L13;
            if (isSuccess() == false) goto L11;
            if (hasMoreOutput() == false) goto L11;
            this.fresh = false;
            return EncoderJNI.m10587$$Nest$smnativePull(this.context);
        L11:
            throw new IllegalStateException("pulling while data is not ready");
        L13:
            throw new IllegalStateException("brotli encoder is already destroyed");
        }

        void destroy() {
            if (this.context[0] == 0) goto L7;
            EncoderJNI.m10586$$Nest$smnativeDestroy(this.context);
            this.context[0] = 0;
            return;
        L7:
            throw new IllegalStateException("brotli encoder is already destroyed");
        }

        protected void finalize() throws Throwable {
            if (this.context[0] == 0) goto L5;
            destroy();
        L5:
            super.finalize();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeCreate, reason: not valid java name */
    static /* bridge */ /* synthetic */ ByteBuffer m10585$$Nest$smnativeCreate(long[] r0) {
        return nativeCreate(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeDestroy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10586$$Nest$smnativeDestroy(long[] r0) {
        nativeDestroy(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativePull, reason: not valid java name */
    static /* bridge */ /* synthetic */ ByteBuffer m10587$$Nest$smnativePull(long[] r0) {
        return nativePull(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativePush, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10588$$Nest$smnativePush(long[] r0, int r1) {
        nativePush(r0, r1);
    }

    private static native ByteBuffer nativeCreate(long[] r0);

    private static native void nativeDestroy(long[] r0);

    private static native ByteBuffer nativePull(long[] r0);

    private static native void nativePush(long[] r0, int r1);

    EncoderJNI() {
    }
}
