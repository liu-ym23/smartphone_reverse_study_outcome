package org.tensorflow.lite.task.vision.segmenter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ColoredLabel {
    public abstract String a();

    public abstract String b();

    public abstract int c();

    public ColoredLabel() {
    }

    public static ColoredLabel create(String r1, String r2, int r3) {
        return new a(r1, r2, r3);
    }
}
