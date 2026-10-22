package androidx.camera.video.internal.compat;

import android.media.MediaMuxer;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class Api26Impl {
    private Api26Impl() {
    }

    public static MediaMuxer createMediaMuxer(FileDescriptor r100, int r101) throws IOException {
        return new MediaMuxer(r100, r101);
    }
}
