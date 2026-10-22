package androidx.camera.core;

/* JADX INFO: loaded from: classes2.dex */
final class ImageReaderFormatRecommender {

    public static abstract class FormatCombo {
        public FormatCombo() {
        }

        public abstract int imageAnalysisFormat();

        public abstract int imageCaptureFormat();

        public static FormatCombo create(int r100, int r101) {
            return new AutoValue_ImageReaderFormatRecommender_FormatCombo(r100, r101);
        }
    }

    public static FormatCombo chooseCombo() {
        return FormatCombo.create(256, 35);
    }

    private ImageReaderFormatRecommender() {
    }
}
