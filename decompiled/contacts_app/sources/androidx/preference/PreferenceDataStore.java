package androidx.preference;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceDataStore {
    public boolean getBoolean(String r1, boolean r2) {
        return r2;
    }

    public float getFloat(String r1, float r2) {
        return r2;
    }

    public int getInt(String r1, int r2) {
        return r2;
    }

    public long getLong(String r1, long r2) {
        return r2;
    }

    public String getString(String r1, String r2) {
        return r2;
    }

    public Set<String> getStringSet(String r1, Set<String> r2) {
        return r2;
    }

    public PreferenceDataStore() {
    }

    public void putString(String r1, String r2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putStringSet(String r1, Set<String> r2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putInt(String r1, int r2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putLong(String r1, long r2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putFloat(String r1, float r2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putBoolean(String r1, boolean r2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }
}
