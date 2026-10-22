package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes17.dex */
public final class ContentUriTriggers {
    private final Set<Trigger> mTriggers;

    public static final class Trigger {
        private final boolean mTriggerForDescendants;
        private final Uri mUri;

        public int hashCode() {
            return (this.mUri.hashCode() * 31) + (this.mTriggerForDescendants ? 1 : 0);
        }

        public Uri getUri() {
            return this.mUri;
        }

        public boolean shouldTriggerForDescendants() {
            return this.mTriggerForDescendants;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (Trigger.class != r100.getClass()) goto L17;
            Trigger r101 = (Trigger) r100;
            if (this.mTriggerForDescendants == r101.mTriggerForDescendants) goto L13;
        L15:
            return false;
        L13:
            if (this.mUri.equals(r101.mUri) == false) goto L15;
            return true;
        }

        public Trigger(Uri r100, boolean r101) {
            this.mUri = r100;
            this.mTriggerForDescendants = r101;
        }
    }

    public int hashCode() {
        return this.mTriggers.hashCode();
    }

    public int size() {
        return this.mTriggers.size();
    }

    public ContentUriTriggers() {
        this.mTriggers = new HashSet();
    }

    public Set<Trigger> getTriggers() {
        return this.mTriggers;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (ContentUriTriggers.class == r100.getClass()) goto L10;
        return false;
    L10:
        return this.mTriggers.equals(((ContentUriTriggers) r100).mTriggers);
    }

    public void add(Uri r100, boolean r101) {
        Trigger r102 = new Trigger(r100, r101);
        this.mTriggers.add(r102);
    }
}
