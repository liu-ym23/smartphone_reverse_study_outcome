package stepai.android.llm.base;

import B7.a;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.deepbinder.core.constant.Constants;
import j9.m;
import j9.t;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lstepai/android/llm/base/ImageContentBuilder;", "", AppAgent.CONSTRUCT, "()V", BffConstant.Type.Url, "", "detail", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "getFileDescriptor$llmbase_release", "()Landroid/os/ParcelFileDescriptor;", "setFileDescriptor$llmbase_release", "(Landroid/os/ParcelFileDescriptor;)V", "urlOrBase64", SingleFileBundle.KEY_FILE_DESCRIPTOR, "base64ByFD", "base64", "createMemoryFileFD", "imageBytes", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lstepai/android/llm/base/LLMRequestImageContent;", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageContentBuilder {
    private ParcelFileDescriptor fileDescriptor;
    private String url = "";
    private String detail = "";

    private final ParcelFileDescriptor createMemoryFileFD(byte[] imageBytes) throws IllegalAccessException, NoSuchMethodException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            MemoryFile memoryFile = new MemoryFile("image_" + UUID.randomUUID(), imageBytes.length);
            memoryFile.writeBytes(imageBytes, 0, 0, imageBytes.length);
            Method declaredMethod = memoryFile.getClass().getDeclaredMethod(Constants.GET_FILE_DESCRIPTOR, null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(memoryFile, null);
            k.d(objInvoke, "null cannot be cast to non-null type java.io.FileDescriptor");
            return ParcelFileDescriptor.dup((FileDescriptor) objInvoke);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final ImageContentBuilder base64ByFD(String base64) {
        k.f(base64, "base64");
        try {
            String strH0 = t.e0(base64, "data:", false) ? m.H0(base64, "base64,", "") : base64;
            if (strH0.length() == 0) {
                this.url = base64;
                return this;
            }
            byte[] bArrDecode = Base64.decode(strH0, 0);
            k.c(bArrDecode);
            ParcelFileDescriptor parcelFileDescriptorCreateMemoryFileFD = createMemoryFileFD(bArrDecode);
            if (parcelFileDescriptorCreateMemoryFileFD == null) {
                this.url = t.e0(base64, "data:", false) ? base64 : "data:image/jpeg;base64,".concat(base64);
                return this;
            }
            this.fileDescriptor = parcelFileDescriptorCreateMemoryFileFD;
            String str = "image_" + UUID.randomUUID();
            this.url = "image_id://" + str;
            ImageDescriptorsContextManager.INSTANCE.add(str, parcelFileDescriptorCreateMemoryFileFD);
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            if (!t.e0(base64, "data:", false)) {
                base64 = "data:image/jpeg;base64,".concat(base64);
            }
            this.url = base64;
            return this;
        }
    }

    public final LLMRequestImageContent build() {
        return new LLMRequestImageContent(this.url);
    }

    public final ImageContentBuilder detail(String detail) {
        k.f(detail, "detail");
        this.detail = detail;
        return this;
    }

    public final ImageContentBuilder fileDescriptor(ParcelFileDescriptor fd) {
        k.f(fd, "fd");
        this.fileDescriptor = fd;
        this.url = a.k("image_id://", "image_" + UUID.randomUUID());
        return this;
    }

    /* renamed from: getFileDescriptor$llmbase_release, reason: from getter */
    public final ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public final void setFileDescriptor$llmbase_release(ParcelFileDescriptor parcelFileDescriptor) {
        this.fileDescriptor = parcelFileDescriptor;
    }

    public final ImageContentBuilder urlOrBase64(String url) {
        k.f(url, "url");
        this.url = url;
        return this;
    }
}
