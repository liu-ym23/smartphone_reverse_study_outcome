package androidx.camera.core.processing;

import androidx.camera.core.ImageCaptureException;

/* JADX INFO: loaded from: classes2.dex */
public interface Operation<I, O> {
    O apply(I r100) throws ImageCaptureException;
}
