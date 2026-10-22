package Q4;

import android.os.Bundle;
import com.stepos.aiengine.algorithm.asr.AsrStreamRecognitionListener;
import com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.core.callback.a;
import com.stepos.core.callback.b;
import com.stepos.core.callback.c;
import com.stepos.core.data.AudioContent;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a implements IAsrStreamingRecognizer {

    /* renamed from: a, reason: collision with root package name */
    public final com.stepos.core.c f1105a;
    public final Bundle b;
    public final AtomicReference c = new AtomicReference(null);
    public volatile boolean d;

    public a(com.stepos.core.c cVar, Bundle bundle) {
        this.f1105a = cVar;
        this.b = bundle;
        new AtomicInteger(0);
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer
    public final void closeChannel() {
        String str = (String) this.c.getAndSet(null);
        if (str == null) {
            return;
        }
        this.f1105a.b(str);
        this.d = false;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer
    public final boolean isOpen() {
        return this.d;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer
    public final boolean openChannel(final AsrStreamRecognitionListener listener) {
        kotlin.jvm.internal.k.f(listener, "listener");
        if (this.d) {
            return false;
        }
        AudioContent audioContent = new AudioContent(new byte[0], 16000, 1, 2, null, 16, null);
        Bundle bundle = this.b;
        if (bundle != null) {
            ExecutionBundle.Companion companion = ExecutionBundle.INSTANCE;
            if (companion.hasExecutionParams(bundle)) {
                d5.b bVar = new d5.b();
                companion.fromBundle(this.b).applyTo(bVar);
                audioContent.setParams(bVar.a());
            }
        }
        this.c.set(this.f1105a.f(audioContent, new com.stepos.core.d(this) { // from class: com.stepos.aiengine.adapter.AsrAbilityAdapter$AsrStreamingRecognizerImpl$openChannel$inferId$1
            @Override // com.stepos.core.d
            public void onNext(String inferId, c result) {
                k.f(inferId, "inferId");
                k.f(result, "result");
                boolean z10 = result instanceof b;
                AsrStreamRecognitionListener asrStreamRecognitionListener = listener;
                if (z10) {
                    b bVar2 = (b) result;
                    asrStreamRecognitionListener.onError(bVar2.f3827a, bVar2.b);
                } else {
                    if (!result.equals(a.f3826a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    asrStreamRecognitionListener.onComplete();
                }
            }
        }));
        this.d = true;
        return true;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer
    public final boolean writePcmData(byte[] pcmData, int i, int i6) {
        kotlin.jvm.internal.k.f(pcmData, "pcmData");
        String str = (String) this.c.get();
        if (str == null) {
            return false;
        }
        this.f1105a.e(str, new AudioContent(pcmData, i, i6, 2, null, 16, null));
        return true;
    }
}
