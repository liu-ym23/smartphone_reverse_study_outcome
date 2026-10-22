package androidx.preference;

import androidx.annotation.Nullable;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class PreferenceDataStore {
    public boolean getBoolean(String str, boolean z10) {
        return z10;
    }

    public float getFloat(String str, float f) {
        return f;
    }

    public int getInt(String str, int i) {
        return i;
    }

    public long getLong(String str, long j5) {
        return j5;
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        return str2;
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return set;
    }

    public void putBoolean(String str, boolean z10) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putFloat(String str, float f) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putInt(String str, int i) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putLong(String str, long j5) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putString(String str, @Nullable String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putStringSet(String str, @Nullable Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }
}
