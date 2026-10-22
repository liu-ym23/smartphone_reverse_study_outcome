package a37;

import android.speech.tts.Voice;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1590a;

    public /* synthetic */ c(x r100) {
        this.f1590a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Set<Voice> r100 = this.f1590a.f1653j.getVoices();     // Catch: Throwable -> L7
        if (r100 != null) goto L11;
        return Collections.emptySet();
    L11:
        return r100;
    L8:
        return Collections.emptySet();
    }
}
