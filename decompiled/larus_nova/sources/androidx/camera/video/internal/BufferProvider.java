package androidx.camera.video.internal;

import androidx.camera.core.impl.Observable;
import com.google.common.util.concurrent.ListenableFuture;
import r27.a;

/* JADX INFO: loaded from: classes2.dex */
public interface BufferProvider<T> extends Observable<State> {

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State ACTIVE = null;
        public static final State INACTIVE = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{ACTIVE, INACTIVE};
        }

        static {
            ACTIVE = new State("ACTIVE", 0);
            INACTIVE = new State("INACTIVE", 1);
            $VALUES = $values();
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    ListenableFuture<T> acquireBuffer();
}
