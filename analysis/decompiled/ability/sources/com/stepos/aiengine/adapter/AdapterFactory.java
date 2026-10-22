package com.stepos.aiengine.adapter;

import Z7.d;
import android.os.Bundle;
import com.stepos.core.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001JA\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/aiengine/adapter/AdapterFactory;", "", "I", "LZ7/d;", "interfaceClass", "Lcom/stepos/core/c;", "handle", "", "algorithmId", "Landroid/os/Bundle;", "params", "create", "(LZ7/d;Lcom/stepos/core/c;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AdapterFactory {
    public static final AdapterFactory INSTANCE = new AdapterFactory();

    public static /* synthetic */ Object create$default(AdapterFactory adapterFactory, d dVar, c cVar, String str, Bundle bundle, int i, Object obj) {
        if ((i & 8) != 0) {
            bundle = null;
        }
        return adapterFactory.create(dVar, cVar, str, bundle);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0150, code lost:
    
        if (r3.equals("vision-chat-qnn-vlm") == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x015a, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_MOBILE_CHAT) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0163, code lost:
    
        if (r3.equals("embedding") == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x016b, code lost:
    
        return (I) new com.stepos.aiengine.adapter.EmbeddingAbilityAdapter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0172, code lost:
    
        if (r3.equals("speech-qnn-tts") == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x017a, code lost:
    
        return (I) new com.stepos.aiengine.adapter.SpeechRecognitionAbilityAdapter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x019f, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_SMS_PARSE) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01a8, code lost:
    
        if (r3.equals("chat-qnn-llm") == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if (r3.equals("image/super_resolve") == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01b2, code lost:
    
        return (I) new com.stepos.aiengine.adapter.ChatAbilityAdapter(r2, com.stepos.aiengine.session.SessionManager.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_CHAT) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_SPEECH_RECOGNITION) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_IMAGE_INPAINT) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
    
        return (I) new com.stepos.aiengine.adapter.ImageInpaintAbilityAdapter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_EMBEDDING) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0102, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_SUPER_RESOLUTION) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010b, code lost:
    
        return (I) new com.stepos.aiengine.adapter.SuperResolutionStubAdapter();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0122, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_CHAT_VISION) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x012c, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_BGE_EMBEDDING) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0136, code lost:
    
        if (r3.equals("chat-llama-cpp") == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
    
        if (r3.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_IMAGE_INPAINT_AIGC) == false) goto L135;
     */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <I> I create(Z7.d r1, com.stepos.core.c r2, java.lang.String r3, android.os.Bundle r4) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.adapter.AdapterFactory.create(Z7.d, com.stepos.core.c, java.lang.String, android.os.Bundle):java.lang.Object");
    }
}
