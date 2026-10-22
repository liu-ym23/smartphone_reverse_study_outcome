package org.brotli.wrapper.dec;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class DecoderJNI {

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status DONE = null;
        public static final Status ERROR = null;
        public static final Status NEEDS_MORE_INPUT = null;
        public static final Status NEEDS_MORE_OUTPUT = null;
        public static final Status OK = null;

        private static /* synthetic */ Status[] $values() {
            return new Status[]{ERROR, DONE, NEEDS_MORE_INPUT, NEEDS_MORE_OUTPUT, OK};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String name) {
            return (Status) Enum.valueOf(Status.class, name);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            ERROR = new Status("ERROR", 0);
            DONE = new Status("DONE", 1);
            NEEDS_MORE_INPUT = new Status("NEEDS_MORE_INPUT", 2);
            NEEDS_MORE_OUTPUT = new Status("NEEDS_MORE_OUTPUT", 3);
            OK = new Status("OK", 4);
            $VALUES = $values();
        }
    }

    public static class Wrapper {
        private final long[] context;
        private boolean fresh;
        private final ByteBuffer inputBuffer;
        private Status lastStatus;

        public Wrapper(int inputBufferSize) throws IOException {
            this.context = new long[3];
            this.lastStatus = Status.NEEDS_MORE_INPUT;
            this.fresh = true;
            this.context[1] = inputBufferSize;
            this.inputBuffer = DecoderJNI.m10579$$Nest$smnativeCreate(this.context);
            if (this.context[0] == 0) goto L6;
            return;
        L6:
            throw new IOException("failed to initialize native brotli decoder");
        }

        public void push(int length) {
            if (length < 0) goto L23;
            if (this.context[0] == 0) goto L21;
            if (this.lastStatus == Status.NEEDS_MORE_INPUT) goto L13;
            if (this.lastStatus == Status.OK) goto L13;
            throw new IllegalStateException("pushing input to decoder in " + this.lastStatus + " state");
        L13:
            if (this.lastStatus != Status.OK) goto L18;
            if (length == 0) goto L18;
            throw new IllegalStateException("pushing input to decoder in OK state");
        L18:
            this.fresh = false;
            DecoderJNI.m10582$$Nest$smnativePush(this.context, length);
            parseStatus();
            return;
        L21:
            throw new IllegalStateException("brotli decoder is already destroyed");
        L23:
            throw new IllegalArgumentException("negative block length");
        }

        private void parseStatus() {
            long status = this.context[1];
            if (status != 1) goto L6;
            this.lastStatus = Status.DONE;
            return;
        L6:
            if (status != 2) goto L9;
            this.lastStatus = Status.NEEDS_MORE_INPUT;
            return;
        L9:
            if (status != 3) goto L12;
            this.lastStatus = Status.NEEDS_MORE_OUTPUT;
            return;
        L12:
            if (status != 4) goto L14;
            this.lastStatus = Status.OK;
            return;
        L14:
            this.lastStatus = Status.ERROR;
        }

        public Status getStatus() {
            return this.lastStatus;
        }

        public ByteBuffer getInputBuffer() {
            return this.inputBuffer;
        }

        public boolean hasOutput() {
            if (this.context[2] == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public ByteBuffer pull() {
            if (this.context[0] == 0) goto L14;
            if (this.lastStatus != Status.NEEDS_MORE_OUTPUT) goto L7;
        L11:
            this.fresh = false;
            ByteBuffer result = DecoderJNI.m10581$$Nest$smnativePull(this.context);
            parseStatus();
            return result;
        L7:
            if (hasOutput() == true) goto L11;
            throw new IllegalStateException("pulling output from decoder in " + this.lastStatus + " state");
        L14:
            throw new IllegalStateException("brotli decoder is already destroyed");
        }

        public void destroy() {
            if (this.context[0] == 0) goto L7;
            DecoderJNI.m10580$$Nest$smnativeDestroy(this.context);
            this.context[0] = 0;
            return;
        L7:
            throw new IllegalStateException("brotli decoder is already destroyed");
        }

        protected void finalize() throws Throwable {
            if (this.context[0] == 0) goto L5;
            destroy();
        L5:
            super.finalize();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeCreate, reason: not valid java name */
    static /* bridge */ /* synthetic */ ByteBuffer m10579$$Nest$smnativeCreate(long[] r0) {
        return nativeCreate(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeDestroy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10580$$Nest$smnativeDestroy(long[] r0) {
        nativeDestroy(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativePull, reason: not valid java name */
    static /* bridge */ /* synthetic */ ByteBuffer m10581$$Nest$smnativePull(long[] r0) {
        return nativePull(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativePush, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10582$$Nest$smnativePush(long[] r0, int r1) {
        nativePush(r0, r1);
    }

    private static native ByteBuffer nativeCreate(long[] r0);

    private static native void nativeDestroy(long[] r0);

    private static native ByteBuffer nativePull(long[] r0);

    private static native void nativePush(long[] r0, int r1);

    public DecoderJNI() {
    }
}
