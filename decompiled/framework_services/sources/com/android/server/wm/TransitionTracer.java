package com.android.server.wm;

import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
interface TransitionTracer {
    boolean isTracing();

    void logAbortedTransition(Transition r1);

    void logFinishedTransition(Transition r1);

    void logRemovingStartingWindow(StartingData r1);

    void logSentTransition(Transition r1, ArrayList<Transition.ChangeInfo> r2);

    void saveForBugreport(PrintWriter r1);

    void startTrace(PrintWriter r1);

    void stopTrace(PrintWriter r1);
}
