package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.PhraseRecognitionEvent;
import android.media.soundtrigger.PhraseRecognitionExtra;
import android.media.soundtrigger.RecognitionEvent;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;

/* JADX INFO: loaded from: classes3.dex */
public class AidlUtil {
    public AidlUtil() {
    }

    static RecognitionEvent newEmptyRecognitionEvent() {
        RecognitionEvent result = new RecognitionEvent();
        result.data = new byte[0];
        return result;
    }

    static PhraseRecognitionEvent newEmptyPhraseRecognitionEvent() {
        PhraseRecognitionEvent result = new PhraseRecognitionEvent();
        result.common = newEmptyRecognitionEvent();
        result.phraseExtras = new PhraseRecognitionExtra[0];
        return result;
    }

    static RecognitionEventSys newAbortEvent() {
        RecognitionEvent recognitionEvent = newEmptyRecognitionEvent();
        recognitionEvent.type = 1;
        recognitionEvent.status = 1;
        RecognitionEventSys recognitionEventSys = new RecognitionEventSys();
        recognitionEventSys.recognitionEvent = recognitionEvent;
        return recognitionEventSys;
    }

    static PhraseRecognitionEventSys newAbortPhraseEvent() {
        PhraseRecognitionEvent recognitionEvent = newEmptyPhraseRecognitionEvent();
        recognitionEvent.common.type = 0;
        recognitionEvent.common.status = 1;
        PhraseRecognitionEventSys phraseRecognitionEventSys = new PhraseRecognitionEventSys();
        phraseRecognitionEventSys.phraseRecognitionEvent = recognitionEvent;
        return phraseRecognitionEventSys;
    }
}
