package androidx.work;

/* JADX INFO: loaded from: classes3.dex */
public abstract class InputMergerFactory {
    public InputMergerFactory() {
    }

    public abstract InputMerger createInputMerger(String r100);

    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new AnonymousClass1();
    }

    public final InputMerger createInputMergerWithDefaultFallback(String r100) {
        InputMerger r101 = createInputMerger(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return InputMerger.fromClassName(r100);
    }
}
