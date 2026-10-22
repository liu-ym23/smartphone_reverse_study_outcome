package android.view;

import android.app.asyncinflate.AsyncInflateControl;
import android.app.asyncinflate.AsyncInflateStub;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Slog;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public class StepOSLayoutInflaterExtImpl implements IStepOSLayoutInflaterExt {
    private static final String TAG = "StepOSLayoutInflaterExtImpl";
    private LayoutInflater mHost;
    private final ThreadLocal<Boolean> mIsMainThrad = ThreadLocal.withInitial(new Supplier() { // from class: android.view.StepOSLayoutInflaterExtImpl$$ExternalSyntheticLambda0
        @Override // java.util.function.Supplier
        public final Object get() {
            return StepOSLayoutInflaterExtImpl.lambda$new$0();
        }
    });

    static /* synthetic */ Boolean lambda$new$0() {
        return true;
    }

    public void onAttach(LayoutInflater host) {
        this.mHost = host;
    }

    public void onDetach() {
        this.mHost = null;
    }

    public View steposInflate(int resId) {
        this.mIsMainThrad.set(false);
        try {
            return this.mHost.inflate(resId, (ViewGroup) null);
        } finally {
            this.mIsMainThrad.set(true);
        }
    }

    public View inflateHook(Context context, int resId, ViewGroup root, boolean attachToRoot) throws Resources.NotFoundException {
        int resId2;
        Exception e;
        if (!AsyncInflateStub.get().shouldHook()) {
            return null;
        }
        View view = null;
        if (this.mIsMainThrad.get().booleanValue()) {
            try {
                Resources res = context.getResources();
                XmlResourceParser parser = res.getLayout(resId);
                resId2 = resId;
                try {
                    view = AsyncInflateStub.get().findView(context, parser, resId2, root, attachToRoot);
                    parser.close();
                    if (AsyncInflateControl.isDebug()) {
                        Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "findView " + resId2 + (view != null ? "success" : "failed"));
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (AsyncInflateControl.isDebug()) {
                        Slog.w(AsyncInflateControl.ASYNC_INFLATE_TAG, "inflateHook exception, fallback: 0x" + Integer.toHexString(resId2), e);
                    }
                    return null;
                }
            } catch (Exception e3) {
                resId2 = resId;
                e = e3;
            }
        }
        return view;
    }

    public void recordId(int resId) {
        if (AsyncInflateStub.get().shouldHook() && this.mIsMainThrad.get().booleanValue()) {
            AsyncInflateStub.get().recordId(resId);
        }
    }
}
