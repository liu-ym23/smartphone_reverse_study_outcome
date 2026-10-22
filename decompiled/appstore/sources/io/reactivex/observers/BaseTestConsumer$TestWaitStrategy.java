package io.reactivex.observers;

/* JADX INFO: loaded from: classes4.dex */
public abstract enum BaseTestConsumer$TestWaitStrategy extends Enum<BaseTestConsumer$TestWaitStrategy> implements Runnable {
    private static final /* synthetic */ BaseTestConsumer$TestWaitStrategy[] $VALUES = null;
    public static final BaseTestConsumer$TestWaitStrategy SLEEP_1000MS = null;
    public static final BaseTestConsumer$TestWaitStrategy SLEEP_100MS = null;
    public static final BaseTestConsumer$TestWaitStrategy SLEEP_10MS = null;
    public static final BaseTestConsumer$TestWaitStrategy SLEEP_1MS = null;
    public static final BaseTestConsumer$TestWaitStrategy SPIN = null;
    public static final BaseTestConsumer$TestWaitStrategy YIELD = null;

    static {
        final String r10 = "SPIN";
        final int r11 = 0;
        BaseTestConsumer$TestWaitStrategy r12 = new AnonymousClass1(r10, r11);
        SPIN = r12;
        final String r13 = "YIELD";
        final int r14 = 1;
        BaseTestConsumer$TestWaitStrategy r15 = new AnonymousClass2(r13, r14);
        YIELD = r15;
        final String r16 = "SLEEP_1MS";
        final int r17 = 2;
        BaseTestConsumer$TestWaitStrategy r18 = new AnonymousClass3(r16, r17);
        SLEEP_1MS = r18;
        final String r19 = "SLEEP_10MS";
        final int r20 = 3;
        BaseTestConsumer$TestWaitStrategy r21 = new AnonymousClass4(r19, r20);
        SLEEP_10MS = r21;
        final String r22 = "SLEEP_100MS";
        final int r110 = 4;
        BaseTestConsumer$TestWaitStrategy r23 = new AnonymousClass5(r22, r110);
        SLEEP_100MS = r23;
        final String r111 = "SLEEP_1000MS";
        final int r112 = 5;
        BaseTestConsumer$TestWaitStrategy r24 = new AnonymousClass6(r111, r112);
        SLEEP_1000MS = r24;
        $VALUES = new BaseTestConsumer$TestWaitStrategy[]{r12, r15, r18, r21, r23, r24};
    }

    private BaseTestConsumer$TestWaitStrategy(String r10, int r11) {
        super(r10, r11);
    }

    public static void sleep(int r10) {
        Thread.sleep(r10);     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static BaseTestConsumer$TestWaitStrategy valueOf(String r10) {
        return (BaseTestConsumer$TestWaitStrategy) Enum.valueOf(BaseTestConsumer$TestWaitStrategy.class, r10);
    }

    public static BaseTestConsumer$TestWaitStrategy[] values() {
        return (BaseTestConsumer$TestWaitStrategy[]) $VALUES.clone();
    }

    @Override // java.lang.Runnable
    public abstract void run();

    public /* synthetic */ BaseTestConsumer$TestWaitStrategy(String r10, int r11, a r12) {
        this(r10, r11);
    }
}
