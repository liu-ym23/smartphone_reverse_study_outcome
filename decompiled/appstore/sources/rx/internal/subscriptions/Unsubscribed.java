package rx.internal.subscriptions;

import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final enum Unsubscribed extends Enum<Unsubscribed> implements Subscription {
    private static final /* synthetic */ Unsubscribed[] $VALUES = null;
    public static final Unsubscribed INSTANCE = null;

    static {
        Unsubscribed r10 = new Unsubscribed("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new Unsubscribed[]{r10};
    }

    private Unsubscribed(String r10, int r11) {
        super(r10, r11);
    }

    public static Unsubscribed valueOf(String r10) {
        return (Unsubscribed) Enum.valueOf(Unsubscribed.class, r10);
    }

    public static Unsubscribed[] values() {
        return (Unsubscribed[]) $VALUES.clone();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
    }
}
