package androidx.core.provider;

import android.graphics.Typeface;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
class CallbackWrapper {
    private final FontsContractCompat.FontRequestCallback mCallback;
    private final Executor mExecutor;

    public CallbackWrapper(FontsContractCompat.FontRequestCallback r100) {
        this(r100, RequestExecutor.createHandlerExecutor(CalleeHandler.create()));
    }

    private void onTypefaceRequestFailed(final int r100) {
        final FontsContractCompat.FontRequestCallback r101 = this.mCallback;
        this.mExecutor.execute(new AnonymousClass2(this, r101, r100));
    }

    private void onTypefaceRetrieved(final Typeface r100) {
        final FontsContractCompat.FontRequestCallback r101 = this.mCallback;
        this.mExecutor.execute(new AnonymousClass1(this, r101, r100));
    }

    public void onTypefaceResult(FontRequestWorker.TypefaceResult r100) {
        if (r100.isSuccess() == false) goto L5;
        onTypefaceRetrieved(r100.mTypeface);
        return;
    L5:
        onTypefaceRequestFailed(r100.mResult);
    }

    public CallbackWrapper(FontsContractCompat.FontRequestCallback r100, Executor r101) {
        this.mCallback = r100;
        this.mExecutor = r101;
    }
}
