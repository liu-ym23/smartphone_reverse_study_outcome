package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.ConfidenceLevel;
import android.media.soundtrigger.Phrase;
import android.media.soundtrigger.PhraseRecognitionExtra;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
public class ValidationUtil {
    public ValidationUtil() {
    }

    static void validateUuid(String uuid) {
        uuid.getClass();
        Matcher matcher = UuidUtil.PATTERN.matcher(uuid);
        if (matcher.matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Illegal format for UUID: " + uuid);
    }

    static void validateGenericModel(SoundModel model) {
        validateModel(model, 1);
    }

    static void validateModel(SoundModel model, int expectedType) {
        model.getClass();
        if (model.type != expectedType) goto L9;
        validateUuid(model.uuid);
        validateUuid(model.vendorUuid);
        if (model.dataSize <= 0) goto L10;
        model.data.getClass();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid type");
    }

    static void validatePhraseModel(PhraseSoundModel model) {
        model.getClass();
        int r1 = 0;
        validateModel(model.common, 0);
        model.phrases.getClass();
        Phrase[] r0 = model.phrases;
        int r2 = r0.length;
    L3:
        if (r1 >= r2) goto L9;
        Phrase phrase = r0[r1];
        phrase.getClass();
        if ((phrase.recognitionModes & (-16)) != 0) goto L8;
        phrase.users.getClass();
        phrase.locale.getClass();
        phrase.text.getClass();
        r1 = r1 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException("Invalid recognitionModes");
    }

    static void validateRecognitionConfig(RecognitionConfig config) {
        config.getClass();
        config.phraseRecognitionExtras.getClass();
        PhraseRecognitionExtra[] r0 = config.phraseRecognitionExtras;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L25;
        PhraseRecognitionExtra extra = r0[r3];
        extra.getClass();
        if ((extra.recognitionModes & (-16)) != 0) goto L24;
        if (extra.confidenceLevel < 0) goto L22;
        if (extra.confidenceLevel > 100) goto L22;
        extra.levels.getClass();
        ConfidenceLevel[] r5 = extra.levels;
        int r8 = r5.length;
        int r9 = 0;
    L12:
        if (r9 >= r8) goto L20;
        ConfidenceLevel level = r5[r9];
        level.getClass();
        if (level.levelPercent < 0) goto L19;
        if (level.levelPercent > 100) goto L19;
        r9 = r9 + 1;
    L19:
        throw new IllegalArgumentException("Invalid confidenceLevel");
    L20:
        r3 = r3 + 1;
    L22:
        throw new IllegalArgumentException("Invalid confidenceLevel");
    L24:
        throw new IllegalArgumentException("Invalid recognitionModes");
    L25:
        config.data.getClass();
    }

    static void validateModelParameter(int modelParam) {
        switch(modelParam) {
            case 0: goto L5;
            default: goto L4;
        };
    L5:
        return;
    L4:
        throw new IllegalArgumentException("Invalid model parameter");
    }
}
