package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes6.dex */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static LocusId create(String r100) {
            return new LocusId(r100);
        }

        public static String getId(LocusId r100) {
            return r100.getId();
        }
    }

    private String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    public int hashCode() {
        String r100 = this.mId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return 31 + r101;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "LocusIdCompat[" + getSanitizedId() + "]";
    }

    public String getId() {
        return this.mId;
    }

    public LocusId toLocusId() {
        return this.mWrapped;
    }

    public LocusIdCompat(String r100) {
        this.mId = (String) Preconditions.checkStringNotEmpty(r100, "id cannot be empty");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        this.mWrapped = Api29Impl.create(r100);
        return;
    L5:
        this.mWrapped = null;
    }

    public static LocusIdCompat toLocusIdCompat(LocusId r100) {
        Preconditions.checkNotNull(r100, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(Api29Impl.getId(r100), "id cannot be empty"));
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (LocusIdCompat.class == r100.getClass()) goto L11;
        return false;
    L11:
        LocusIdCompat r101 = (LocusIdCompat) r100;
        String r102 = this.mId;
        if (r102 != null) goto L19;
        if (r101.mId == null) goto L20;
        return false;
    L20:
        return true;
    L19:
        return r102.equals(r101.mId);
    }
}
