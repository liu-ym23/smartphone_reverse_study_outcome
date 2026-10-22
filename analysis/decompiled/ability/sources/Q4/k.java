package Q4;

import H4.o;
import com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor;
import com.stepos.aiengine.algorithm.voice.SpeechRecognitionCallback;
import com.stepos.aiengine.algorithm.voice.SpeechRecognitionSegment;
import com.stepos.core.callback.a;
import com.stepos.core.callback.b;
import com.stepos.core.callback.c;
import com.stepos.core.data.AudioContent;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class k implements ISpeechStreamingRecognizor {

    /* renamed from: a, reason: collision with root package name */
    public final com.stepos.core.c f1114a;
    public final AtomicReference b = new AtomicReference(null);
    public final StringBuilder c = new StringBuilder();
    public volatile boolean d;

    public k(com.stepos.core.c cVar) {
        this.f1114a = cVar;
    }

    @Override // com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor
    public final void closeChannel() {
        String str = (String) this.b.getAndSet(null);
        if (str == null) {
            return;
        }
        this.f1114a.b(str);
        this.d = false;
    }

    @Override // com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor
    public final boolean isOpen() {
        return this.d;
    }

    @Override // com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor
    public final boolean openChannel(final SpeechRecognitionCallback callback) {
        kotlin.jvm.internal.k.f(callback, "callback");
        if (this.d) {
            return false;
        }
        this.b.set(this.f1114a.f(new AudioContent(new byte[0], 16000, 1, 2, null, 16, null), new com.stepos.core.d() { // from class: com.stepos.aiengine.adapter.SpeechRecognitionAbilityAdapter$ASRStreamingAdapter$openChannel$inferId$1
            @Override // com.stepos.core.d
            public void onNext(String inferId, c result) {
                StringBuilder sb = this.f3475a.c;
                k.f(inferId, "inferId");
                k.f(result, "result");
                boolean z10 = result instanceof b;
                SpeechRecognitionCallback speechRecognitionCallback = callback;
                if (z10) {
                    b bVar = (b) result;
                    speechRecognitionCallback.onError(bVar.f3827a, bVar.b);
                } else {
                    if (!result.equals(a.f3826a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    String string = sb.toString();
                    k.e(string, "toString(...)");
                    speechRecognitionCallback.onFinalResult("", "", "", false, o.M(new SpeechRecognitionSegment(0L, 0L, string, null, 8, null)));
                    k.f(sb, "<this>");
                    sb.setLength(0);
                }
            }
        }));
        this.d = true;
        return true;
    }

    @Override // com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor
    public final boolean writePcmData(byte[] pcmData, int i, int i6) {
        kotlin.jvm.internal.k.f(pcmData, "pcmData");
        String str = (String) this.b.get();
        if (str == null) {
            return false;
        }
        this.f1114a.e(str, new AudioContent(pcmData, i, i6, 2, null, 16, null));
        return true;
    }
}
