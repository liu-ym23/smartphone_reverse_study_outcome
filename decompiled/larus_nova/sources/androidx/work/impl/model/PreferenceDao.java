package androidx.work.impl.model;

import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: classes3.dex */
public interface PreferenceDao {
    Long getLongValue(String r100);

    LiveData<Long> getObservableLongValue(String r100);

    void insertPreference(Preference r100);
}
