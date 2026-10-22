package androidx.appcompat.widget;

import android.content.Intent;
import android.database.DataSetObservable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityChooserModel extends DataSetObservable {

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel r10);
    }

    public interface ActivitySorter {
        void sort(Intent r10, List<Object> r11, List<Object> r12);
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel r10, Intent r11);
    }
}
