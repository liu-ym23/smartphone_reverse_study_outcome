package com.stepos.core.ability.text;

import com.stepos.core.data.FileContent;
import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ServerSessionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final MixedContent toMixedContent(List<LlmChatMessage> list) {
        ArrayList arrayList = new ArrayList();
        for (LlmChatMessage llmChatMessage : list) {
            int role = llmChatMessage.getRole();
            String str = role != 0 ? role != 1 ? role != 2 ? role != 3 ? "" : "<|tool|>" : "<|system|>" : "<|assistant|>" : "<|user|>";
            String content = llmChatMessage.getContent();
            if (content != null) {
                arrayList.add(new TextContent(str.concat(content)));
            }
            List<String> images = llmChatMessage.getImages();
            if (images != null) {
                Iterator<T> it = images.iterator();
                while (it.hasNext()) {
                    arrayList.add(new FileContent((String) it.next(), null, null, 6, null));
                }
            }
        }
        return new MixedContent(arrayList);
    }
}
