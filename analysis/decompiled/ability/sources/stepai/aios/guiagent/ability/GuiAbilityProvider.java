package stepai.aios.guiagent.ability;

import H7.c;
import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lstepai/aios/guiagent/ability/GuiAbilityProvider;", "", "Lstepai/aios/guiagent/ability/CaptureOptions;", "options", "Lstepai/aios/guiagent/ability/CaptureResult;", "captureScreenResult", "(Lstepai/aios/guiagent/ability/CaptureOptions;LH7/c;)Ljava/lang/Object;", "Landroid/graphics/Bitmap;", "bitmap", "", "bitmap2Base64", "(Landroid/graphics/Bitmap;LH7/c;)Ljava/lang/Object;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GuiAbilityProvider {
    Object bitmap2Base64(Bitmap bitmap, c<? super String> cVar);

    Object captureScreenResult(CaptureOptions captureOptions, c<? super CaptureResult> cVar);
}
