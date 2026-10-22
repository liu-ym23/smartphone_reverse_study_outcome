package org.fusesource.jansi.internal;

import hc.C4153b;

/* loaded from: classes5.dex */
public class CLibrary {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f37784a;

    /* renamed from: b, reason: collision with root package name */
    public static int f37785b;

    /* renamed from: c, reason: collision with root package name */
    public static int f37786c;

    public static class Termios {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f37787a = new byte[32];

        static {
            C4153b.g();
            init();
        }

        private static native void init();
    }

    public static class WinSize {
        static {
            C4153b.g();
            init();
        }

        private static native void init();
    }

    static {
        boolean zG = C4153b.g();
        f37784a = zG;
        if (zG) {
            init();
        }
        f37785b = 1;
        f37786c = 2;
    }

    private static native void init();

    public static native int ioctl(int i10, long j10, WinSize winSize);

    public static native int ioctl(int i10, long j10, int[] iArr);

    public static native int isatty(int i10);

    public static native int openpty(int[] iArr, int[] iArr2, byte[] bArr, Termios termios, WinSize winSize);

    public static native int tcgetattr(int i10, Termios termios);

    public static native int tcsetattr(int i10, int i11, Termios termios);

    public static native String ttyname(int i10);
}
