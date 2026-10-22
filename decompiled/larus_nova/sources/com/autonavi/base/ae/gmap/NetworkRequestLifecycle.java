package com.autonavi.base.ae.gmap;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
final class NetworkRequestLifecycle {
    private boolean acceptingRequests;
    private final Object lock;
    private final int maxRequests;
    private long nextAdmissionSequence;
    private final Map<Long, RequestContext> requests;

    public static final class AdmissionResult {
        final boolean accepted;
        final String rejectionReason;
        final CompletionClaim replaced;

        public static AdmissionResult accepted(CompletionClaim r100) {
            return new AdmissionResult(true, r100, "none");
        }

        public static AdmissionResult rejected(String r100) {
            return new AdmissionResult(false, null, r100);
        }

        private AdmissionResult(boolean r100, CompletionClaim r101, String r102) {
            this.accepted = r100;
            this.replaced = r101;
            this.rejectionReason = r102;
        }
    }

    public interface CancelAction {
        void cancel();
    }

    public static final class CompletionClaim {
        final CancelAction cancelAction;
        final RequestContext context;

        public CompletionClaim(RequestContext r100, CancelAction r101) {
            this.context = r100;
            this.cancelAction = r101;
        }
    }

    public static final class RequestContext {
        private long admissionSequence;
        private CancelAction cancelAction;
        final long handler;
        final long queueStartTime;
        private State state;
        private volatile String traceEndpoint;
        private volatile String traceTileIdentifier;

        public String getTraceEndpoint() {
            return this.traceEndpoint;
        }

        public String getTraceTileIdentifier() {
            return this.traceTileIdentifier;
        }

        public static /* synthetic */ CancelAction access$000(RequestContext r100) {
            return r100.cancelAction;
        }

        public static /* synthetic */ long access$100(RequestContext r100) {
            return r100.admissionSequence;
        }

        public static /* synthetic */ State access$200(RequestContext r100) {
            return r100.state;
        }

        public void setQueuedCancelAction(CancelAction r100) {
            this.cancelAction = r100;
        }

        public RequestContext(long r100, long r101) {
            this.state = State.QUEUED;
            this.traceEndpoint = "unparsed";
            this.traceTileIdentifier = "unparsed";
            this.handler = r100;
            this.queueStartTime = r101;
        }

        public static /* synthetic */ CancelAction access$002(RequestContext r100, CancelAction r101) {
            r100.cancelAction = r101;
            return r101;
        }

        public static /* synthetic */ long access$102(RequestContext r100, long r101) {
            r100.admissionSequence = r101;
            return r101;
        }

        public static /* synthetic */ State access$202(RequestContext r100, State r101) {
            r100.state = r101;
            return r101;
        }

        public void setTraceInfo(String r100, String r101) {
            this.traceEndpoint = r100;
            this.traceTileIdentifier = r101;
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State COMPLETED = null;
        public static final State COMPLETING = null;
        public static final State QUEUED = null;
        public static final State RUNNING = null;

        static {
            State r100 = new State("QUEUED", 0);
            QUEUED = r100;
            State r101 = new State("RUNNING", 1);
            RUNNING = r101;
            State r102 = new State("COMPLETING", 2);
            COMPLETING = r102;
            State r103 = new State("COMPLETED", 3);
            COMPLETED = r103;
            $VALUES = new State[]{r100, r101, r102, r103};
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

    private List<CompletionClaim> claimAllLocked() {
        ArrayList r100 = new ArrayList();
        Iterator<RequestContext> r101 = this.requests.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        CompletionClaim r102 = claimLocked(r101.next());
        if (r102 == null) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public String describeOutstanding() {
        Object r100 = this.lock;
        monitor-enter(r100);
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L14
        Iterator<RequestContext> r102 = this.requests.values().iterator();     // Catch: Throwable -> L14
    L6:
        if (r102.hasNext() == false) goto L11;
        RequestContext r103 = r102.next();     // Catch: Throwable -> L14
        if (r101.length() <= 0) goto L10;
        r101.append(',');     // Catch: Throwable -> L14
    L10:
        r101.append(r103.handler);     // Catch: Throwable -> L14
        r101.append(':');     // Catch: Throwable -> L14
        r101.append(RequestContext.access$200(r103));     // Catch: Throwable -> L14
        goto L6
    L11:
        String r104 = r101.toString();     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r104;
    L14:
        th = move-exception;
        throw th;
    }

    public int size() {
        Object r100 = this.lock;
        monitor-enter(r100);
        int r101 = this.requests.size();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public void startAccepting() {
        Object r100 = this.lock;
        monitor-enter(r100);
        this.acceptingRequests = true;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public List<CompletionClaim> stopAcceptingAndClaimAll() {
        Object r100 = this.lock;
        monitor-enter(r100);
        this.acceptingRequests = false;     // Catch: Throwable -> L8
        List<CompletionClaim> r101 = claimAllLocked();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public NetworkRequestLifecycle(int r100) {
        this.lock = new Object();
        this.requests = new HashMap();
        this.maxRequests = r100;
    }

    private CompletionClaim claimLocked(RequestContext r100) {
        if (r100 == null) goto L10;
        State r101 = RequestContext.access$200(r100);
        State r102 = State.COMPLETING;
        if (r101 != r102) goto L6;
        return null;
    L6:
        if (RequestContext.access$200(r100) == State.COMPLETED) goto L13;
        RequestContext.access$202(r100, r102);
        return new CompletionClaim(r100, RequestContext.access$000(r100));
    L13:
        return null;
    L10:
        return null;
    }

    public boolean awaitAllTerminals(long r110) {
        long r111 = (Math.max(0, r110) * 1000) * 1000;
        long r100 = System.nanoTime() + r111;
        Object r112 = this.lock;
        monitor-enter(r112);
    L24:
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.requests.isEmpty() == true) goto L16;
        long r101 = r100 - System.nanoTime();     // Catch: Throwable -> L19
        if (r101 <= 0) goto L8;
        long r102 = r101 / 1000000;     // Catch: InterruptedException -> L13 Throwable -> L19
        int r103 = (int) (r101 % 1000000);     // Catch: InterruptedException -> L13 Throwable -> L19
        this.lock.wait(r102, r103);     // Catch: InterruptedException -> L13 Throwable -> L19
    L13:
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L19
        return false;
    L8:
        monitor-exit(r112);     // Catch: Throwable -> L19
        return false;
    L16:
        monitor-exit(r112);     // Catch: Throwable -> L19
        return true;
    }

    public CompletionClaim claim(long r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        CompletionClaim r102 = claimLocked(this.requests.get(Long.valueOf(r100)));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public void complete(CompletionClaim r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Object r101 = this.lock;
        monitor-enter(r101);
        RequestContext r102 = r100.context;     // Catch: Throwable -> L14
        if (RequestContext.access$200(r102) != State.COMPLETING) goto L12;
        RequestContext.access$202(r102, State.COMPLETED);     // Catch: Throwable -> L14
        if (this.requests.get(Long.valueOf(r102.handler)) != r102) goto L11;
        this.requests.remove(Long.valueOf(r102.handler));     // Catch: Throwable -> L14
    L11:
        this.lock.notifyAll();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public RequestContext getRunning(long r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        RequestContext r102 = this.requests.get(Long.valueOf(r100));     // Catch: Throwable -> L12
        if (r102 != null) goto L7;
    L9:
        r102 = null;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L7:
        if (RequestContext.access$200(r102) != State.RUNNING) goto L9;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean isOutstanding(long r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        RequestContext r102 = this.requests.get(Long.valueOf(r100));     // Catch: Throwable -> L14
        if (r102 != null) goto L7;
    L11:
        boolean r103 = false;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r103;
    L7:
        if (RequestContext.access$200(r102) == State.COMPLETING) goto L11;
        if (RequestContext.access$200(r102) == State.COMPLETED) goto L11;
        r103 = true;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean isRunning(RequestContext r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        if (r100 != null) goto L17;
    L12:
        boolean r102 = false;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L10:
        th = move-exception;
        throw th;
    L17:
        if (this.requests.get(Long.valueOf(r100.handler)) != r100) goto L12;
        if (RequestContext.access$200(r100) != State.RUNNING) goto L12;
        r102 = true;
        goto L13
    }

    public boolean reserve(RequestContext r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        if (r100 != null) goto L27;
    L22:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return false;
    L27:
    L20:
        th = move-exception;
        throw th;
    L6:
        if (r100.handler == 0) goto L22;
        if (RequestContext.access$000(r100) == null) goto L22;
        if (this.acceptingRequests == false) goto L22;
        if (this.requests.size() >= this.maxRequests) goto L22;
        if (this.requests.containsKey(Long.valueOf(r100.handler)) == true) goto L22;
        long r102 = this.nextAdmissionSequence + 1;     // Catch: Throwable -> L20
        this.nextAdmissionSequence = r102;     // Catch: Throwable -> L20
        RequestContext.access$102(r100, r102);     // Catch: Throwable -> L20
        this.requests.put(Long.valueOf(r100.handler), r100);     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        return true;
    }

    public AdmissionResult reserveLatest(RequestContext r110) {
        Object r100 = this.lock;
        monitor-enter(r100);
        if (r110 != null) goto L47;
    L41:
        AdmissionResult r111 = AdmissionResult.rejected("invalid_request");     // Catch: Throwable -> L44
        monitor-exit(r100);     // Catch: Throwable -> L44
        return r111;
    L47:
    L44:
        th = move-exception;
        throw th;
    L6:
        if (r110.handler == 0) goto L41;
        if (RequestContext.access$000(r110) == null) goto L41;
        if (this.acceptingRequests == true) goto L16;
        AdmissionResult r112 = AdmissionResult.rejected("not_accepting");     // Catch: Throwable -> L44
        monitor-exit(r100);     // Catch: Throwable -> L44
        return r112;
    L16:
        if (this.requests.containsKey(Long.valueOf(r110.handler)) == false) goto L20;
        AdmissionResult r113 = AdmissionResult.rejected("duplicate_handler");     // Catch: Throwable -> L44
        monitor-exit(r100);     // Catch: Throwable -> L44
        return r113;
    L20:
        RequestContext r101 = null;
        if (this.requests.size() >= this.maxRequests) goto L25;
        long r102 = this.nextAdmissionSequence + 1;     // Catch: Throwable -> L44
        this.nextAdmissionSequence = r102;     // Catch: Throwable -> L44
        RequestContext.access$102(r110, r102);     // Catch: Throwable -> L44
        this.requests.put(Long.valueOf(r110.handler), r110);     // Catch: Throwable -> L44
        AdmissionResult r114 = AdmissionResult.accepted(null);     // Catch: Throwable -> L44
        monitor-exit(r100);     // Catch: Throwable -> L44
        return r114;
    L25:
        Iterator<RequestContext> r103 = this.requests.values().iterator();     // Catch: Throwable -> L44
    L27:
        if (r103.hasNext() == false) goto L34;
        RequestContext r104 = r103.next();     // Catch: Throwable -> L44
        if (RequestContext.access$200(r104) != State.QUEUED) goto L27;
        if (r101 == null) goto L33;
        if (RequestContext.access$100(r104) >= RequestContext.access$100(r101)) goto L27;
    L33:
        r101 = r104;
        goto L27
    L34:
        if (r101 != null) goto L38;
        AdmissionResult r115 = AdmissionResult.rejected("all_capacity_running");     // Catch: Throwable -> L44
        monitor-exit(r100);     // Catch: Throwable -> L44
        return r115;
    L38:
        CompletionClaim r105 = claimLocked(r101);     // Catch: Throwable -> L44
        this.requests.remove(Long.valueOf(r101.handler));     // Catch: Throwable -> L44
        long r106 = this.nextAdmissionSequence + 1;     // Catch: Throwable -> L44
        this.nextAdmissionSequence = r106;     // Catch: Throwable -> L44
        RequestContext.access$102(r110, r106);     // Catch: Throwable -> L44
        this.requests.put(Long.valueOf(r110.handler), r110);     // Catch: Throwable -> L44
        AdmissionResult r116 = AdmissionResult.accepted(r105);     // Catch: Throwable -> L44
        monitor-exit(r100);     // Catch: Throwable -> L44
        return r116;
    }

    public boolean markRunning(RequestContext r100, CancelAction r101) {
        Object r102 = this.lock;
        monitor-enter(r102);
        RequestContext r103 = this.requests.get(Long.valueOf(r100.handler));     // Catch: Throwable -> L17
        if (r101 == null) goto L14;
        if (r103 != r100) goto L14;
        if (RequestContext.access$200(r100) != State.QUEUED) goto L14;
        RequestContext.access$002(r100, r101);     // Catch: Throwable -> L17
        RequestContext.access$202(r100, State.RUNNING);     // Catch: Throwable -> L17
        monitor-exit(r102);     // Catch: Throwable -> L17
        return true;
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return false;
    L17:
        th = move-exception;
        throw th;
    }
}
