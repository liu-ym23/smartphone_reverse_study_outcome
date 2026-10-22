package stepai.android.llm.base;

import D7.w;
import M0.i;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import androidx.core.view.PointerIconCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import j9.t;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.LLMRequestContent;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lstepai/android/llm/base/ImageTransferHelper;", "", AppAgent.CONSTRUCT, "()V", "processImageUrl", "Lstepai/android/llm/base/LLMRequest;", "request", "readImageAsBase64", "", "pfd", "Landroid/os/ParcelFileDescriptor;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageTransferHelper {
    public static final ImageTransferHelper INSTANCE = new ImageTransferHelper();

    private ImageTransferHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [stepai.android.llm.base.LLMRequestContent] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v6, types: [stepai.android.llm.base.LLMRequestContent$Image] */
    /* JADX WARN: Type inference failed for: r6v7, types: [stepai.android.llm.base.LLMRequestContent$Image] */
    public final LLMRequest processImageUrl(LLMRequest request) {
        ParcelFileDescriptor parcelFileDescriptor;
        String imageAsBase64;
        k.f(request, "request");
        Bundle bundle = ImageDescriptorsContextManager.INSTANCE.get();
        List<LLMRequestMessage> messages = request.getMessages();
        ArrayList arrayList = new ArrayList(w.c0(messages, 10));
        for (LLMRequestMessage lLMRequestMessage : messages) {
            List<LLMRequestContent> contentList = lLMRequestMessage.getContentList();
            ArrayList arrayList2 = new ArrayList(w.c0(contentList, 10));
            Iterator it = contentList.iterator();
            while (it.hasNext()) {
                ?? Copy$default = (LLMRequestContent) it.next();
                if (Copy$default instanceof LLMRequestContent.Image) {
                    Copy$default = (LLMRequestContent.Image) Copy$default;
                    LLMRequestImageContent imageUrl = Copy$default.getImageUrl();
                    String url = imageUrl.getUrl();
                    if (t.e0(url, "image_id://", false)) {
                        String strY0 = m.y0("image_id://", url);
                        if (!m.s0(strY0) && bundle.containsKey(strY0) && (parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable(strY0, ParcelFileDescriptor.class)) != null && (imageAsBase64 = INSTANCE.readImageAsBase64(parcelFileDescriptor)) != null) {
                            Copy$default = LLMRequestContent.Image.copy$default(Copy$default, imageUrl.copy(imageAsBase64), null, 2, null);
                        }
                    }
                }
                arrayList2.add(Copy$default);
            }
            arrayList.add(LLMRequestMessage.copy$default(lLMRequestMessage, null, arrayList2, 1, null));
        }
        return LLMRequest.copy$default(request, null, null, arrayList, null, false, 0, null, null, null, null, PointerIconCompat.TYPE_ZOOM_OUT, null);
    }

    public final String readImageAsBase64(ParcelFileDescriptor pfd) {
        k.f(pfd, "pfd");
        try {
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(pfd);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, autoCloseInputStream.available()));
            i.s(autoCloseInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            k.e(byteArray, "toByteArray(...)");
            return "data:image/jpeg;base64," + Base64.encodeToString(byteArray, 2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
