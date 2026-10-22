package rx.internal.operators;

import rx.Producer;

/* JADX INFO: loaded from: classes4.dex */
final enum OnSubscribeDetach$TerminatedProducer extends Enum<OnSubscribeDetach$TerminatedProducer> implements Producer {
    private static final /* synthetic */ OnSubscribeDetach$TerminatedProducer[] $VALUES = null;
    public static final OnSubscribeDetach$TerminatedProducer INSTANCE = null;

    static {
        OnSubscribeDetach$TerminatedProducer r10 = new OnSubscribeDetach$TerminatedProducer("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new OnSubscribeDetach$TerminatedProducer[]{r10};
    }

    private OnSubscribeDetach$TerminatedProducer(String r10, int r11) {
        super(r10, r11);
    }

    public static OnSubscribeDetach$TerminatedProducer valueOf(String r10) {
        return (OnSubscribeDetach$TerminatedProducer) Enum.valueOf(OnSubscribeDetach$TerminatedProducer.class, r10);
    }

    public static OnSubscribeDetach$TerminatedProducer[] values() {
        return (OnSubscribeDetach$TerminatedProducer[]) $VALUES.clone();
    }

    @Override // rx.Producer
    public void request(long r10) {
    }
}
