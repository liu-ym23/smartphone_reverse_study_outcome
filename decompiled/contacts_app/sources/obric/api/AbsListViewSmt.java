package obric.api;

import android.util.Singleton;
import android.widget.AbsListView;

/* JADX INFO: loaded from: classes5.dex */
public class AbsListViewSmt {
    static final String TAG = "AbsListViewSmt";
    static final Singleton<AbsListViewSmt> sAbsListViewSmt = null;

    public void setBytedanceBottomSelector(AbsListView r1, boolean r2) {
    }

    public void setBytedanceTopSelector(AbsListView r1, boolean r2) {
    }

    /* synthetic */ AbsListViewSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sAbsListViewSmt = new AnonymousClass1();
    }

    public static AbsListViewSmt getInstance() {
        return (AbsListViewSmt) sAbsListViewSmt.get();
    }

    private AbsListViewSmt() {
    }
}
