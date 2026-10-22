package org.fusesource.jansi.internal;

import hc.C4153b;

/* loaded from: classes5.dex */
public class Kernel32 {

    public static class CHAR_INFO {
        static {
            C4153b.g();
            init();
        }

        private static native void init();
    }

    public static class CONSOLE_SCREEN_BUFFER_INFO {

        /* renamed from: a, reason: collision with root package name */
        public COORD f37788a = new COORD();

        /* renamed from: b, reason: collision with root package name */
        public COORD f37789b = new COORD();

        /* renamed from: c, reason: collision with root package name */
        public SMALL_RECT f37790c = new SMALL_RECT();

        /* renamed from: d, reason: collision with root package name */
        public COORD f37791d = new COORD();

        static {
            C4153b.g();
            init();
        }

        private static native void init();
    }

    public static class COORD {
        static {
            C4153b.g();
            init();
        }

        private static native void init();
    }

    public static class FOCUS_EVENT_RECORD {
        static {
            C4153b.g();
            init();
        }

        private static native void init();
    }

    public static class INPUT_RECORD {

        /* renamed from: a, reason: collision with root package name */
        public KEY_EVENT_RECORD f37792a = new KEY_EVENT_RECORD();

        /* renamed from: b, reason: collision with root package name */
        public MOUSE_EVENT_RECORD f37793b = new MOUSE_EVENT_RECORD();

        /* renamed from: c, reason: collision with root package name */
        public WINDOW_BUFFER_SIZE_RECORD f37794c = new WINDOW_BUFFER_SIZE_RECORD();

        /* renamed from: d, reason: collision with root package name */
        public MENU_EVENT_RECORD f37795d = new MENU_EVENT_RECORD();

        /* renamed from: e, reason: collision with root package name */
        public FOCUS_EVENT_RECORD f37796e = new FOCUS_EVENT_RECORD();

        static {
            C4153b.g();
            init();
        }

        private static native void init();

        public static native void memmove(INPUT_RECORD input_record, long j10, long j11);
    }

    public static class KEY_EVENT_RECORD {

        /* renamed from: a, reason: collision with root package name */
        public boolean f37797a;

        /* renamed from: b, reason: collision with root package name */
        public short f37798b;

        /* renamed from: c, reason: collision with root package name */
        public short f37799c;

        /* renamed from: d, reason: collision with root package name */
        public short f37800d;

        /* renamed from: e, reason: collision with root package name */
        public char f37801e;

        /* renamed from: f, reason: collision with root package name */
        public int f37802f;

        static {
            C4153b.g();
            init();
        }

        private static native void init();

        public String toString() {
            return "KEY_EVENT_RECORD{keyDown=" + this.f37797a + ", repeatCount=" + ((int) this.f37798b) + ", keyCode=" + ((int) this.f37799c) + ", scanCode=" + ((int) this.f37800d) + ", uchar=" + this.f37801e + ", controlKeyState=" + this.f37802f + '}';
        }
    }

    public static class MENU_EVENT_RECORD {
        static {
            C4153b.g();
            init();
        }

        private static native void init();
    }

    public static class MOUSE_EVENT_RECORD {

        /* renamed from: a, reason: collision with root package name */
        public COORD f37803a = new COORD();

        /* renamed from: b, reason: collision with root package name */
        public int f37804b;

        /* renamed from: c, reason: collision with root package name */
        public int f37805c;

        /* renamed from: d, reason: collision with root package name */
        public int f37806d;

        static {
            C4153b.g();
            init();
        }

        private static native void init();

        public String toString() {
            return "MOUSE_EVENT_RECORD{mousePosition=" + this.f37803a + ", buttonState=" + this.f37804b + ", controlKeyState=" + this.f37805c + ", eventFlags=" + this.f37806d + '}';
        }
    }

    public static class SMALL_RECT {
        static {
            C4153b.g();
            init();
        }

        private static native void init();
    }

    public static class WINDOW_BUFFER_SIZE_RECORD {

        /* renamed from: a, reason: collision with root package name */
        public COORD f37807a = new COORD();

        static {
            C4153b.g();
            init();
        }

        private static native void init();

        public String toString() {
            return "WINDOW_BUFFER_SIZE_RECORD{size=" + this.f37807a + '}';
        }
    }

    static {
        if (C4153b.g()) {
            init();
        }
    }

    public static native int CloseHandle(long j10);

    public static native int FillConsoleOutputAttribute(long j10, short s10, int i10, COORD coord, int[] iArr);

    public static native int FillConsoleOutputCharacterW(long j10, char c10, int i10, COORD coord, int[] iArr);

    public static native int FlushConsoleInputBuffer(long j10);

    public static native int FormatMessageW(int i10, long j10, int i11, int i12, byte[] bArr, int i13, long[] jArr);

    public static native int GetConsoleMode(long j10, int[] iArr);

    public static native int GetConsoleOutputCP();

    public static native int GetConsoleScreenBufferInfo(long j10, CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info);

    public static native int GetLastError();

    public static native int GetNumberOfConsoleInputEvents(long j10, int[] iArr);

    public static native long GetStdHandle(int i10);

    private static native int PeekConsoleInputW(long j10, long j11, int i10, int[] iArr);

    private static native int ReadConsoleInputW(long j10, long j11, int i10, int[] iArr);

    public static native int ScrollConsoleScreenBuffer(long j10, SMALL_RECT small_rect, SMALL_RECT small_rect2, COORD coord, CHAR_INFO char_info);

    public static native int SetConsoleCursorPosition(long j10, COORD coord);

    public static native int SetConsoleMode(long j10, int i10);

    public static native int SetConsoleOutputCP(int i10);

    public static native int SetConsoleTextAttribute(long j10, short s10);

    public static native int SetConsoleTitle(String str);

    public static native int WaitForSingleObject(long j10, int i10);

    public static native int WriteConsoleW(long j10, char[] cArr, int i10, int[] iArr, long j11);

    public static native int _getch();

    public static native void free(long j10);

    private static native void init();

    public static native long malloc(long j10);
}
