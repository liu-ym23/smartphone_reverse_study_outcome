package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Stopwatch {
    private long elapsedNanos;
    private boolean isRunning;
    private long startTick;
    private final Ticker ticker;

    /* JADX INFO: renamed from: com.google.common.base.Stopwatch$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit = null;

        static {
            int[] r10 = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = r10;
            r10[TimeUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public Stopwatch() {
        this.ticker = Ticker.systemTicker();
    }

    private static String abbreviate(TimeUnit r10) {
        switch(AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[r10.ordinal()]) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return "d";
    L8:
        return "h";
    L10:
        return "min";
    L12:
        return "s";
    L14:
        return "ms";
    L16:
        return "μs";
    L18:
        return "ns";
    L5:
        throw new AssertionError();
    }

    private static TimeUnit chooseUnit(long r10) {
        TimeUnit r11 = TimeUnit.DAYS;
        TimeUnit r12 = TimeUnit.NANOSECONDS;
        if (r11.convert(r10, r12) <= 0) goto L5;
        return r11;
    L5:
        TimeUnit r13 = TimeUnit.HOURS;
        if (r13.convert(r10, r12) <= 0) goto L8;
        return r13;
    L8:
        TimeUnit r14 = TimeUnit.MINUTES;
        if (r14.convert(r10, r12) <= 0) goto L11;
        return r14;
    L11:
        TimeUnit r15 = TimeUnit.SECONDS;
        if (r15.convert(r10, r12) <= 0) goto L14;
        return r15;
    L14:
        TimeUnit r16 = TimeUnit.MILLISECONDS;
        if (r16.convert(r10, r12) <= 0) goto L17;
        return r16;
    L17:
        TimeUnit r17 = TimeUnit.MICROSECONDS;
        if (r17.convert(r10, r12) <= 0) goto L20;
        return r17;
    L20:
        return r12;
    }

    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }

    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }

    private long elapsedNanos() {
        if (this.isRunning == false) goto L6;
        return (this.ticker.read() - this.startTick) + this.elapsedNanos;
    L6:
        return this.elapsedNanos;
    }

    public long elapsed(TimeUnit r10) {
        return r10.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    @CanIgnoreReturnValue
    public Stopwatch reset() {
        this.elapsedNanos = 0;
        this.isRunning = false;
        return this;
    }

    @CanIgnoreReturnValue
    public Stopwatch start() {
        Preconditions.checkState(!this.isRunning, "This stopwatch is already running.");
        this.isRunning = true;
        this.startTick = this.ticker.read();
        return this;
    }

    @CanIgnoreReturnValue
    public Stopwatch stop() {
        long r10 = this.ticker.read();
        Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
        this.isRunning = false;
        this.elapsedNanos += r10 - this.startTick;
        return this;
    }

    public String toString() {
        long r10 = elapsedNanos();
        TimeUnit r11 = chooseUnit(r10);
        return Platform.formatCompact4Digits(r10 / TimeUnit.NANOSECONDS.convert(1, r11)) + " " + abbreviate(r11);
    }

    public static Stopwatch createStarted(Ticker r10) {
        return new Stopwatch(r10).start();
    }

    public static Stopwatch createUnstarted(Ticker r10) {
        return new Stopwatch(r10);
    }

    public Stopwatch(Ticker r10) {
        this.ticker = (Ticker) Preconditions.checkNotNull(r10, "ticker");
    }
}
