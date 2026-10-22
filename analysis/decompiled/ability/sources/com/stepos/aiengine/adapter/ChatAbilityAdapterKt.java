package com.stepos.aiengine.adapter;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import d5.m;
import d5.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatAbilityAdapterKt {
    public static final MixedContent access$toMixedContent(List list) {
        FileContent fileContent;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LlmChatMessage llmChatMessage = (LlmChatMessage) it.next();
            int role = llmChatMessage.getRole();
            String str = role != 0 ? role != 1 ? role != 2 ? role != 3 ? "" : "<|tool|>" : "<|system|>" : "<|assistant|>" : "<|user|>";
            String content = llmChatMessage.getContent();
            if (content != null) {
                arrayList.add(new TextContent(str.concat(content)));
            }
            List<String> images = llmChatMessage.getImages();
            if (images != null) {
                for (String str2 : images) {
                    try {
                        fileContent = m.a(FileContent.Companion, str2);
                    } catch (Exception e) {
                        Log.e("ChatAbilityAdapter", "Failed to open file, falling back to path-only FileContent: " + str2, e);
                        fileContent = new FileContent(str2, "image/*", null, 4, null);
                    }
                    arrayList.add(fileContent);
                }
            }
            List<ParcelFileDescriptor> imageFds = llmChatMessage.getImageFds();
            if (imageFds != null) {
                Iterator<T> it2 = imageFds.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new FileContent("", "image/*", (ParcelFileDescriptor) it2.next()));
                }
            }
            List<Bitmap> imageBitmaps = llmChatMessage.getImageBitmaps();
            if (imageBitmaps != null) {
                Iterator<T> it3 = imageBitmaps.iterator();
                while (it3.hasNext()) {
                    arrayList.add(n.b(ImageContent.Companion, (Bitmap) it3.next(), 0, 0, 0, 0, 30));
                }
            }
        }
        return new MixedContent(arrayList);
    }
}
