package com.stepos.aiengine.adapter;

import android.os.Bundle;
import com.stepos.core.AbilityHandle;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/aiengine/adapter/AdapterFactory;", "", "<init>", "()V", "I", "Lw9/d;", "interfaceClass", "Lcom/stepos/core/AbilityHandle;", "handle", "", "algorithmId", "Landroid/os/Bundle;", "params", "create", "(Lw9/d;Lcom/stepos/core/AbilityHandle;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AdapterFactory {
    public static final AdapterFactory INSTANCE = new AdapterFactory();

    public static /* synthetic */ Object create$default(AdapterFactory adapterFactory, InterfaceC5745d interfaceC5745d, AbilityHandle abilityHandle, String str, Bundle bundle, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            bundle = null;
        }
        return adapterFactory.create(interfaceC5745d, abilityHandle, str, bundle);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0164, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_CHAT_VISION) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x017e, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_BGE_EMBEDDING) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0188, code lost:
    
        if (r5.equals("chat-llama-cpp") == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01b2, code lost:
    
        if (r5.equals("vision-chat-qnn-vlm") == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01cc, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_MOBILE_CHAT) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01d6, code lost:
    
        if (r5.equals("embedding") == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01df, code lost:
    
        return (I) new com.stepos.aiengine.adapter.EmbeddingAbilityAdapter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01e6, code lost:
    
        if (r5.equals("speech-qnn-tts") == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01ee, code lost:
    
        return (I) new com.stepos.aiengine.adapter.TTSAbilityAdapter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0213, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_SMS_PARSE) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x021c, code lost:
    
        if (r5.equals("chat-qnn-llm") == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0226, code lost:
    
        return (I) new com.stepos.aiengine.adapter.ChatAbilityAdapter(r4, com.stepos.aiengine.session.SessionManager.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_EMBEDDING) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_IMAGE_INPAINT_AIGC) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        if (r5.equals("image/super_resolve") == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_CHAT) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ca, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_IMAGE_INPAINT) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d3, code lost:
    
        return (I) new com.stepos.aiengine.adapter.ImageInpaintAbilityAdapter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011a, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_TTS) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0144, code lost:
    
        if (r5.equals(com.stepos.aiengine.api.IAlgorithmSet.ALGORITHM_SUPER_RESOLUTION) == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x014d, code lost:
    
        return (I) new com.stepos.aiengine.adapter.SuperResolutionStubAdapter();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x025c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <I> I create(w9.InterfaceC5745d<I> r3, com.stepos.core.AbilityHandle r4, java.lang.String r5, android.os.Bundle r6) {
        /*
            Method dump skipped, instructions count: 808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.adapter.AdapterFactory.create(w9.d, com.stepos.core.AbilityHandle, java.lang.String, android.os.Bundle):java.lang.Object");
    }
}
