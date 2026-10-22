package com.stepos.ailauncher.taskstore.audio;

import Xa.d;
import Xa.j;
import Xa.k;
import Xa.o;
import Xa.p;
import Xa.t;
import Xa.u;
import com.stepos.ailauncher.taskstore.audio.AudioWaveformClient;
import com.stepos.ailauncher.taskstore.audio.b;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u001f\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00138\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\tR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\n8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000eR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/taskstore/audio/a;", "", "<init>", "()V", "LY8/t;", "c", "LXa/j;", "Lcom/stepos/ailauncher/taskstore/audio/b$a;", "_amplitudes", "LXa/j;", "LXa/o;", "amplitudes", "LXa/o;", "getAmplitudes", "()LXa/o;", "LXa/k;", "", "_connection", "LXa/k;", "LXa/t;", "connection", "LXa/t;", "getConnection", "()LXa/t;", "Lcom/stepos/ailauncher/taskstore/audio/b$c;", "_recordingState", "recordingState", "getRecordingState", "Lcom/stepos/ailauncher/taskstore/audio/b$d;", "_summaryState", "summaryState", "getSummaryState", "installed", "Z", "Lcom/stepos/ailauncher/taskstore/audio/AudioWaveformClient$a;", "listener", "Lcom/stepos/ailauncher/taskstore/audio/AudioWaveformClient$a;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final j<b.Amplitude> _amplitudes;
    private static final k<Boolean> _connection;
    private static final k<b.StateChanged> _recordingState;
    private static final j<b.SummaryStateChanged> _summaryState;
    private static final o<b.Amplitude> amplitudes;
    private static final t<Boolean> connection;
    private static volatile boolean installed;
    private static final AudioWaveformClient.a listener;
    private static final t<b.StateChanged> recordingState;
    private static final o<b.SummaryStateChanged> summaryState;

    static {
        BufferOverflow bufferOverflow = BufferOverflow.DROP_OLDEST;
        j<b.Amplitude> jVarA = p.a(0, 64, bufferOverflow);
        _amplitudes = jVarA;
        amplitudes = d.b(jVarA);
        k<Boolean> kVarA = u.a(Boolean.FALSE);
        _connection = kVarA;
        connection = d.c(kVarA);
        k<b.StateChanged> kVarA2 = u.a(null);
        _recordingState = kVarA2;
        recordingState = d.c(kVarA2);
        j<b.SummaryStateChanged> jVarA2 = p.a(1, 8, bufferOverflow);
        _summaryState = jVarA2;
        summaryState = d.b(jVarA2);
        listener = new AudioWaveformClient.a() { // from class: t6.a
            @Override // com.stepos.ailauncher.taskstore.audio.AudioWaveformClient.a
            public final void a(com.stepos.ailauncher.taskstore.audio.b bVar) {
                com.stepos.ailauncher.taskstore.audio.a.b(bVar);
            }
        };
    }

    public static final void b(b event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (event instanceof b.Amplitude) {
            _amplitudes.a(event);
            return;
        }
        if (event instanceof b.StateChanged) {
            _recordingState.setValue(event);
            return;
        }
        if (event instanceof b.SummaryStateChanged) {
            _summaryState.a(event);
            return;
        }
        if (!(event instanceof b.ConnectionChanged)) {
            throw new NoWhenBranchMatchedException();
        }
        b.ConnectionChanged connectionChanged = (b.ConnectionChanged) event;
        _connection.setValue(Boolean.valueOf(connectionChanged.getConnected()));
        if (connectionChanged.getConnected()) {
            return;
        }
        _recordingState.setValue(null);
    }

    public final void c() {
        if (installed) {
            return;
        }
        synchronized (this) {
            if (installed) {
                return;
            }
            AudioWaveformClient.INSTANCE.t(listener);
            installed = true;
            Y8.t tVar = Y8.t.f7040a;
        }
    }
}
