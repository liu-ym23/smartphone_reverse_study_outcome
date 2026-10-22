package reactor.core.publisher;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public enum SignalType {
    SUBSCRIBE,
    REQUEST,
    CANCEL,
    ON_SUBSCRIBE,
    ON_NEXT,
    ON_ERROR,
    ON_COMPLETE,
    AFTER_TERMINATE,
    CURRENT_CONTEXT,
    ON_CONTEXT;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: reactor.core.publisher.SignalType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$reactor$core$publisher$SignalType;

        static {
            int[] iArr = new int[SignalType.values().length];
            $SwitchMap$reactor$core$publisher$SignalType = iArr;
            try {
                iArr[SignalType.ON_SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.ON_NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.ON_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.ON_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.CURRENT_CONTEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.ON_CONTEXT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$reactor$core$publisher$SignalType[SignalType.AFTER_TERMINATE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$reactor$core$publisher$SignalType[ordinal()]) {
            case 1:
                return "onSubscribe";
            case 2:
                return "onNext";
            case 3:
                return "onError";
            case 4:
                return "onComplete";
            case 5:
                return "request";
            case 6:
                return "cancel";
            case 7:
                return "currentContext";
            case 8:
                return "onContextUpdate";
            case 9:
                return "afterTerminate";
            default:
                return "subscribe";
        }
    }
}
