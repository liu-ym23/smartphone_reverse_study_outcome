package stepai.android.llm.base;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0003¨\u0006\u0016"}, d2 = {"Lstepai/android/llm/base/ImageDescriptorsContextManager;", "", AppAgent.CONSTRUCT, "()V", "", "", "Landroid/os/ParcelFileDescriptor;", "descriptors", "LC7/r;", "set", "(Ljava/util/Map;)V", "Landroid/os/Bundle;", "get", "()Landroid/os/Bundle;", "imageId", "descriptor", "add", "(Ljava/lang/String;Landroid/os/ParcelFileDescriptor;)V", "setAll", "(Landroid/os/Bundle;)V", "addAll", "clear", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageDescriptorsContextManager {
    public static final ImageDescriptorsContextManager INSTANCE = new ImageDescriptorsContextManager();

    private ImageDescriptorsContextManager() {
    }

    public final void add(String imageId, ParcelFileDescriptor descriptor) {
        k.f(imageId, "imageId");
        k.f(descriptor, "descriptor");
        LLMGsonKt.getImageDescriptorsContext().putParcelable(imageId, descriptor);
    }

    public final void addAll(Bundle descriptors) {
        LLMGsonKt.getImageDescriptorsContext().putAll(descriptors);
    }

    public final void clear() {
        LLMGsonKt.getImageDescriptorsContext().clear();
    }

    public final Bundle get() {
        return LLMGsonKt.getImageDescriptorsContext();
    }

    public final void set(Map<String, ? extends ParcelFileDescriptor> descriptors) {
        if (descriptors != null) {
            for (Map.Entry<String, ? extends ParcelFileDescriptor> entry : descriptors.entrySet()) {
                LLMGsonKt.getImageDescriptorsContext().putParcelable(entry.getKey(), entry.getValue());
            }
        }
    }

    public final void setAll(Bundle descriptors) {
        LLMGsonKt.getImageDescriptorsContext().clear();
        LLMGsonKt.getImageDescriptorsContext().putAll(descriptors);
    }
}
