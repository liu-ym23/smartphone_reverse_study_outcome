package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.InitializationException;

/* loaded from: classes.dex */
public interface UseCaseConfigFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final UseCaseConfigFactory f11371a = new a();

    public enum CaptureType {
        IMAGE_CAPTURE,
        PREVIEW,
        IMAGE_ANALYSIS,
        VIDEO_CAPTURE,
        STREAM_SHARING,
        METERING_REPEATING
    }

    public class a implements UseCaseConfigFactory {
        @Override // androidx.camera.core.impl.UseCaseConfigFactory
        public Config a(CaptureType captureType, int i10) {
            return null;
        }
    }

    public interface b {
        UseCaseConfigFactory a(Context context) throws InitializationException;
    }

    Config a(CaptureType captureType, int i10);
}
