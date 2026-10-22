package rx;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Notification {

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind OnCompleted = null;
        public static final Kind OnError = null;
        public static final Kind OnNext = null;

        static {
            Kind r10 = new Kind("OnNext", 0);
            OnNext = r10;
            Kind r11 = new Kind("OnError", 1);
            OnError = r11;
            Kind r12 = new Kind("OnCompleted", 2);
            OnCompleted = r12;
            $VALUES = new Kind[]{r10, r11, r12};
        }

        private Kind(String r10, int r11) {
            super(r10, r11);
        }

        public static Kind valueOf(String r10) {
            return (Kind) Enum.valueOf(Kind.class, r10);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }
}
