package obric.api;

import android.util.Singleton;
import android.widget.Spinner;

/* JADX INFO: loaded from: classes5.dex */
public class SpinnerSmt {
    static final String TAG = "SpinnerSmt";
    static final Singleton<SpinnerSmt> sSpinnerSmt = null;

    public void setBytedanceBottomSelector(Spinner r1, boolean r2) {
    }

    public void setBytedanceTopSelector(Spinner r1, boolean r2) {
    }

    /* synthetic */ SpinnerSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sSpinnerSmt = new AnonymousClass1();
    }

    public static SpinnerSmt getInstance() {
        return (SpinnerSmt) sSpinnerSmt.get();
    }

    private SpinnerSmt() {
    }
}
