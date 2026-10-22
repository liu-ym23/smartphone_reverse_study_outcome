package androidx.camera.core;

import D.T;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.media.Image;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface i extends AutoCloseable {

    public interface a {
        ByteBuffer a();

        int b();

        int c();
    }

    void S(Rect rect);

    T Z0();

    @Override // java.lang.AutoCloseable
    void close();

    Image g1();

    int getFormat();

    int getHeight();

    int getWidth();

    @SuppressLint({"ArrayReturn"})
    a[] w0();
}
