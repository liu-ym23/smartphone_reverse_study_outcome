package androidx.camera.video.internal.compat.quirk;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Quirk;
import androidx.camera.video.Quality;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoQualityQuirk extends Quirk {
    boolean isProblematicVideoQuality(CameraInfoInternal r100, Quality r101);
}
