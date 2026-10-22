package org.tensorflow.lite.task.vision.classifier;

import android.content.Context;
import android.graphics.Rect;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tensorflow.lite.support.b.g;
import org.tensorflow.lite.task.core.TaskJniUtils;
import org.tensorflow.lite.task.core.a.b;
import org.tensorflow.lite.task.core.c;
import org.tensorflow.lite.task.vision.core.BaseVisionTaskApi;

/* JADX INFO: loaded from: classes5.dex */
public final class ImageClassifier extends BaseVisionTaskApi {

    public static class ImageClassifierOptions {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f40649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f40650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f40651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f40652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f40653e;
        private final List<String> f;
        private final List<String> g;
        private final int h;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private c f40654a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f40655b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f40656c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private float f40657d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f40658e;
            private List<String> f;
            private List<String> g;
            private int h;

            static /* synthetic */ String a(a r0) {
                return r0.f40655b;
            }

            static /* synthetic */ int b(a r0) {
                return r0.f40656c;
            }

            static /* synthetic */ float c(a r0) {
                return r0.f40657d;
            }

            static /* synthetic */ boolean d(a r0) {
                return r0.f40658e;
            }

            static /* synthetic */ List e(a r0) {
                return r0.f;
            }

            static /* synthetic */ List f(a r0) {
                return r0.g;
            }

            static /* synthetic */ int g(a r0) {
                return r0.h;
            }

            static /* synthetic */ c h(a r0) {
                return r0.f40654a;
            }

            a() {
                this.f40654a = c.c().a();
                this.f40655b = Segment.JsonKey.END;
                this.f40656c = -1;
                this.f40658e = false;
                this.f = new ArrayList();
                this.g = new ArrayList();
                this.h = -1;
            }

            public a a(c r1) {
                this.f40654a = r1;
                return this;
            }

            public a a(String r1) {
                this.f40655b = r1;
                return this;
            }

            public a a(int r1) {
                if (r1 == 0) goto L6;
                this.f40656c = r1;
                return this;
            L6:
                throw new IllegalArgumentException("maxResults cannot be 0.");
            }

            public a a(float r1) {
                this.f40657d = r1;
                this.f40658e = true;
                return this;
            }

            public a a(List<String> r3) {
                this.f = Collections.unmodifiableList(new ArrayList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")));
                return this;
            }

            public a b(List<String> r3) {
                this.g = Collections.unmodifiableList(new ArrayList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")));
                return this;
            }

            @Deprecated
            public a b(int r1) {
                this.h = r1;
                return this;
            }

            public ImageClassifierOptions a() {
                return new ImageClassifierOptions(this);
            }
        }

        public static a a() {
            return new a();
        }

        public String getDisplayNamesLocale() {
            return this.f40650b;
        }

        public int getMaxResults() {
            return this.f40651c;
        }

        public float getScoreThreshold() {
            return this.f40652d;
        }

        public boolean getIsScoreThresholdSet() {
            return this.f40653e;
        }

        public List<String> getLabelAllowList() {
            return new ArrayList(this.f);
        }

        public List<String> getLabelDenyList() {
            return new ArrayList(this.g);
        }

        public int getNumThreads() {
            return this.h;
        }

        public c b() {
            return this.f40649a;
        }

        ImageClassifierOptions(a r2) {
            this.f40650b = a.a(r2);
            this.f40651c = a.b(r2);
            this.f40652d = a.c(r2);
            this.f40653e = a.d(r2);
            this.f = a.e(r2);
            this.g = a.f(r2);
            this.h = a.g(r2);
            this.f40649a = a.h(r2);
        }
    }

    private static native List<Classifications> classifyNative(long r0, long r2, int[] r4);

    private native void deinitJni(long r1);

    private static native long initJniWithByteBuffer(ByteBuffer r0, ImageClassifierOptions r1, long r2);

    private static native long initJniWithModelFdAndOptions(int r0, long r1, long r3, ImageClassifierOptions r5, long r6);

    static /* synthetic */ long a(int r0, long r1, long r3, ImageClassifierOptions r5, long r6) {
        return initJniWithModelFdAndOptions(r0, r1, r3, r5, r6);
    }

    static /* synthetic */ List a(ImageClassifier r0, long r1, int r3, int r4, b r5) {
        return r0.a(r1, r3, r4, r5);
    }

    public static ImageClassifier a(Context r3, String r4, ImageClassifierOptions r5) {
        return new ImageClassifier(TaskJniUtils.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), new AnonymousClass1(), "task_vision_jni", r4, r5));
    }

    ImageClassifier(long r1) {
        super(r1);
    }

    public List<Classifications> a(g r2, b r3) {
        return (List) ZeusTransformUtils.preCheckCast(a(new AnonymousClass2(this), r2, r3), List.class, "com.obric.aiagent.plugin");
    }

    private List<Classifications> a(long r3, int r5, int r6, b r7) {
        c();
        if (r7.a().isEmpty() == false) goto L5;
        Rect r8 = new Rect(0, 0, r5, r6);
    L7:
        return classifyNative(b(), r3, new int[]{r8.left, r8.top, r8.width(), r8.height()});
    L5:
        r8 = r7.a();
        goto L7
    }

    @Override // org.tensorflow.lite.task.core.d
    public void a(long r1) {
        deinitJni(r1);
    }
}
