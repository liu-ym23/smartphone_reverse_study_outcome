package rx.functions;

import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Actions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24145a = null;

    public static final enum NotImplemented extends Enum<NotImplemented> implements Action1<Throwable> {
        private static final /* synthetic */ NotImplemented[] $VALUES = null;
        public static final NotImplemented INSTANCE = null;

        static {
            NotImplemented r10 = new NotImplemented("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new NotImplemented[]{r10};
        }

        private NotImplemented(String r10, int r11) {
            super(r10, r11);
        }

        public static NotImplemented valueOf(String r10) {
            return (NotImplemented) Enum.valueOf(NotImplemented.class, r10);
        }

        public static NotImplemented[] values() {
            return (NotImplemented[]) $VALUES.clone();
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable r10) {
            call2(r10);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2(Throwable r10) {
            throw new OnErrorNotImplementedException(r10);
        }
    }

    public static final class a implements Action0, Action1, Action2, Action3, Action4, Action5, Action6, Action7, Action8, Action9, ActionN {
        public a() {
        }

        @Override // rx.functions.Action0
        public void call() {
        }

        @Override // rx.functions.Action1
        public void call(Object r10) {
        }

        @Override // rx.functions.Action2
        public void call(Object r10, Object r11) {
        }

        @Override // rx.functions.Action3
        public void call(Object r10, Object r11, Object r12) {
        }

        @Override // rx.functions.Action4
        public void call(Object r10, Object r11, Object r12, Object r13) {
        }

        @Override // rx.functions.Action5
        public void call(Object r10, Object r11, Object r12, Object r13, Object r14) {
        }

        @Override // rx.functions.Action6
        public void call(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        }

        @Override // rx.functions.Action7
        public void call(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        }

        @Override // rx.functions.Action8
        public void call(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17) {
        }

        @Override // rx.functions.Action9
        public void call(Object r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17, Object r18) {
        }

        @Override // rx.functions.ActionN
        public void call(Object... r10) {
        }
    }

    static {
        f24145a = new a();
    }

    public static a a() {
        return f24145a;
    }
}
