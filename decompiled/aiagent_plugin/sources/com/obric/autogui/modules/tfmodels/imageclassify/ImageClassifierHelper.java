package com.obric.autogui.modules.tfmodels.imageclassify;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;
import org.tensorflow.lite.a;
import org.tensorflow.lite.support.b.f;
import org.tensorflow.lite.support.b.g;
import org.tensorflow.lite.task.core.a.b;
import org.tensorflow.lite.task.core.c;
import org.tensorflow.lite.task.vision.classifier.Classifications;
import org.tensorflow.lite.task.vision.classifier.ImageClassifier;

/* JADX INFO: compiled from: ImageClassifierHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ImageClassifierHelper {
    private ImageClassifier classifier;
    private boolean isInitialized;
    private final String modelPath;

    public ImageClassifierHelper(String r2) {
        o.e(r2, "modelPath");
        this.modelPath = r2;
    }

    public final String getModelPath() {
        return this.modelPath;
    }

    public final void initialize(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        if (this.isInitialized == false) goto L11;
        return;
    L11:
        ImageClassifier.ImageClassifierOptions.a r0 = ImageClassifier.ImageClassifierOptions.a();     // Catch: Exception -> L8
        c.a r2 = c.c();     // Catch: Exception -> L8
        r2.a(2);     // Catch: Exception -> L8
        ImageClassifier.ImageClassifierOptions r1 = r0.a(r2.a()).a(Segment.JsonKey.END).a(3).b(p.b()).a(p.b()).b(-1).a(0.5f).a();     // Catch: Exception -> L8
        ImageClassifier r7 = ImageClassifier.a(r6, this.modelPath, r1);     // Catch: Exception -> L8
        o.c(r7, "createFromFileAndOptions(...)");     // Catch: Exception -> L8
        this.classifier = r7;     // Catch: Exception -> L8
        this.isInitialized = true;
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("Failed to initialize image classifier", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final List<Classifications> classify(Bitmap r4) {
        o.e(r4, "bitmap");
        if (this.classifier == null) goto L10;
        SystemClock.uptimeMillis();
        f r0 = new f.a().a();
        g r1 = new g(a.f40581c);
        r1.a(r4);
        g r5 = r0.a2(r1);
        b.a r2 = b.c();
        r2.a(b.EnumC1100b.f40631a);
        b r3 = r2.c();
        ImageClassifier r6 = this.classifier;
        if (r6 != null) goto L7;
        o.c("classifier");
        r6 = null;
    L7:
        List<Classifications> r7 = r6.a(r5, r3);
        o.a(r7);
        return r7;
    L10:
        throw new IllegalStateException("ImageClassifier is not initialized");
    }

    public final void close() {
        ImageClassifier r0 = this.classifier;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        o.c("classifier");
        r0 = null;
    L6:
        r0.close();
        return;
    }
}
