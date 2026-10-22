package com.stepos.aiengine.adapter;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.LlmChatMessage;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "Lcom/stepos/core/data/LlmChatMessage;", "Lcom/stepos/aiengine/algorithm/chat/LlmChatMessage;", "Lcom/stepos/core/data/MixedContent;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Lcom/stepos/core/data/MixedContent;", "", "pathOrUri", "Lcom/stepos/core/data/FileContent;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/core/data/FileContent;", "aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChatAbilityAdapterKt {
    public static final FileContent a(String str) {
        try {
            return FileContent.Companion.fromPath$default(FileContent.INSTANCE, str, null, 2, null);
        } catch (Exception e10) {
            Log.e("ChatAbilityAdapter", "Failed to open file, falling back to path-only FileContent: " + str, e10);
            return new FileContent(str, "image/*", null, 4, null);
        }
    }

    public static final MixedContent b(List<LlmChatMessage> list) {
        ArrayList arrayList = new ArrayList();
        for (LlmChatMessage llmChatMessage : list) {
            int role = llmChatMessage.getRole();
            String str = role != 0 ? role != 1 ? role != 2 ? role != 3 ? "" : "<|tool|>" : "<|system|>" : "<|assistant|>" : "<|user|>";
            String content = llmChatMessage.getContent();
            if (content != null) {
                arrayList.add(new TextContent(str + content));
            }
            List<String> images = llmChatMessage.getImages();
            if (images != null) {
                Iterator<T> it = images.iterator();
                while (it.hasNext()) {
                    arrayList.add(a((String) it.next()));
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
                    arrayList.add(ImageContent.Companion.fromBitmap$default(ImageContent.INSTANCE, (Bitmap) it3.next(), 0, 0, 0, 0, 30, null));
                }
            }
        }
        return new MixedContent(arrayList);
    }
}
