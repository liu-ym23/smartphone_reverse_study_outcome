package androidx.camera.camera2.pipe.compat;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import eb.InterfaceC4021a;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import x.q0;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/compat/SessionSequencer;", "", "Lx/q0;", "concurrentSequencer", "<init>", "(Lx/q0;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "()V", "Lx/q0;", "LOa/e;", "Landroidx/camera/camera2/pipe/compat/SessionSequencer$State;", "LOa/e;", VoiceWakeupReceiver.EXTRA_STATE, "State", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SessionSequencer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final q0 concurrentSequencer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<State> state;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/pipe/compat/SessionSequencer$State;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "CREATING", "CREATED", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State PENDING = new State("PENDING", 0);
        public static final State CREATING = new State("CREATING", 1);
        public static final State CREATED = new State("CREATED", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{PENDING, CREATING, CREATED};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = kotlin.enums.a.a(stateArr$values);
        }

        private State(String str, int i10) {
        }

        public static InterfaceC4149a<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public SessionSequencer(q0 concurrentSequencer) {
        kotlin.jvm.internal.p.i(concurrentSequencer, "concurrentSequencer");
        this.concurrentSequencer = concurrentSequencer;
        this.state = Oa.b.g(State.PENDING);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.camera.camera2.pipe.compat.SessionSequencer$awaitSessionLock$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.camera.camera2.pipe.compat.SessionSequencer$awaitSessionLock$1 r0 = (androidx.camera.camera2.pipe.compat.SessionSequencer$awaitSessionLock$1) r0
            int r1 = r0.f10603c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10603c = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.compat.SessionSequencer$awaitSessionLock$1 r0 = new androidx.camera.camera2.pipe.compat.SessionSequencer$awaitSessionLock$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f10601a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10603c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.C4849c.b(r6)
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.C4849c.b(r6)
            x.q0 r6 = r5.concurrentSequencer
            eb.a r6 = r6.getSharedMutex()
            r0.f10603c = r4
            java.lang.Object r6 = eb.InterfaceC4021a.C0398a.a(r6, r3, r0, r4, r3)
            if (r6 != r1) goto L44
            return r1
        L44:
            Oa.e<androidx.camera.camera2.pipe.compat.SessionSequencer$State> r6 = r5.state
            androidx.camera.camera2.pipe.compat.SessionSequencer$State r0 = androidx.camera.camera2.pipe.compat.SessionSequencer.State.PENDING
            androidx.camera.camera2.pipe.compat.SessionSequencer$State r1 = androidx.camera.camera2.pipe.compat.SessionSequencer.State.CREATING
            boolean r6 = r6.a(r0, r1)
            if (r6 != 0) goto L59
            x.q0 r5 = r5.concurrentSequencer
            eb.a r5 = r5.getSharedMutex()
            eb.InterfaceC4021a.C0398a.c(r5, r3, r4, r3)
        L59:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.SessionSequencer.a(e9.c):java.lang.Object");
    }

    public final void b() {
        if (this.state.b(State.CREATED) == State.CREATING) {
            InterfaceC4021a.i(this.concurrentSequencer.getSharedMutex(), null, 1, null);
        }
    }
}
