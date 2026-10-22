package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    private static class Api33Impl {
        private Api33Impl() {
        }

        static void setExcludedFromSurfaces(ShortcutInfo.Builder r0, int r1) {
            r0.setExcludedFromSurfaces(r1);
        }
    }

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder(Context r2, String r3) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r2;
            r0.mId = r3;
        }

        public Builder(ShortcutInfoCompat r4) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r4.mContext;
            r0.mId = r4.mId;
            r0.mPackageName = r4.mPackageName;
            r0.mIntents = (Intent[]) Arrays.copyOf(r4.mIntents, r4.mIntents.length);
            r0.mActivity = r4.mActivity;
            r0.mLabel = r4.mLabel;
            r0.mLongLabel = r4.mLongLabel;
            r0.mDisabledMessage = r4.mDisabledMessage;
            r0.mDisabledReason = r4.mDisabledReason;
            r0.mIcon = r4.mIcon;
            r0.mIsAlwaysBadged = r4.mIsAlwaysBadged;
            r0.mUser = r4.mUser;
            r0.mLastChangedTimestamp = r4.mLastChangedTimestamp;
            r0.mIsCached = r4.mIsCached;
            r0.mIsDynamic = r4.mIsDynamic;
            r0.mIsPinned = r4.mIsPinned;
            r0.mIsDeclaredInManifest = r4.mIsDeclaredInManifest;
            r0.mIsImmutable = r4.mIsImmutable;
            r0.mIsEnabled = r4.mIsEnabled;
            r0.mLocusId = r4.mLocusId;
            r0.mIsLongLived = r4.mIsLongLived;
            r0.mHasKeyFieldsOnly = r4.mHasKeyFieldsOnly;
            r0.mRank = r4.mRank;
            if (r4.mPersons == null) goto L6;
            r0.mPersons = (Person[]) Arrays.copyOf(r4.mPersons, r4.mPersons.length);
        L6:
            if (r4.mCategories == null) goto L9;
            r0.mCategories = new HashSet(r4.mCategories);
        L9:
            if (r4.mExtras == null) goto L11;
            r0.mExtras = r4.mExtras;
        L11:
            r0.mExcludedSurfaces = r4.mExcludedSurfaces;
        }

        public Builder(Context r2, ShortcutInfo r3) {
            ShortcutInfoCompat r0 = new ShortcutInfoCompat();
            this.mInfo = r0;
            r0.mContext = r2;
            r0.mId = r3.getId();
            r0.mPackageName = r3.getPackage();
            Intent[] r1 = r3.getIntents();
            r0.mIntents = (Intent[]) Arrays.copyOf(r1, r1.length);
            r0.mActivity = r3.getActivity();
            r0.mLabel = r3.getShortLabel();
            r0.mLongLabel = r3.getLongLabel();
            r0.mDisabledMessage = r3.getDisabledMessage();
            r0.mDisabledReason = r3.getDisabledReason();
            r0.mCategories = r3.getCategories();
            r0.mPersons = ShortcutInfoCompat.getPersonsFromExtra(r3.getExtras());
            r0.mUser = r3.getUserHandle();
            r0.mLastChangedTimestamp = r3.getLastChangedTimestamp();
            r0.mIsCached = r3.isCached();
            r0.mIsDynamic = r3.isDynamic();
            r0.mIsPinned = r3.isPinned();
            r0.mIsDeclaredInManifest = r3.isDeclaredInManifest();
            r0.mIsImmutable = r3.isImmutable();
            r0.mIsEnabled = r3.isEnabled();
            r0.mHasKeyFieldsOnly = r3.hasKeyFieldsOnly();
            r0.mLocusId = ShortcutInfoCompat.getLocusId(r3);
            r0.mRank = r3.getRank();
            r0.mExtras = r3.getExtras();
        }

        public Builder setShortLabel(CharSequence r2) {
            this.mInfo.mLabel = r2;
            return this;
        }

        public Builder setLongLabel(CharSequence r2) {
            this.mInfo.mLongLabel = r2;
            return this;
        }

        public Builder setDisabledMessage(CharSequence r2) {
            this.mInfo.mDisabledMessage = r2;
            return this;
        }

        public Builder setIntent(Intent r3) {
            return setIntents(new Intent[]{r3});
        }

        public Builder setIntents(Intent[] r2) {
            this.mInfo.mIntents = r2;
            return this;
        }

        public Builder setIcon(IconCompat r2) {
            this.mInfo.mIcon = r2;
            return this;
        }

        public Builder setLocusId(LocusIdCompat r2) {
            this.mInfo.mLocusId = r2;
            return this;
        }

        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        public Builder setActivity(ComponentName r2) {
            this.mInfo.mActivity = r2;
            return this;
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public Builder setPerson(Person r3) {
            return setPersons(new Person[]{r3});
        }

        public Builder setPersons(Person[] r2) {
            this.mInfo.mPersons = r2;
            return this;
        }

        public Builder setCategories(Set<String> r2) {
            this.mInfo.mCategories = r2;
            return this;
        }

        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        public Builder setLongLived(boolean r2) {
            this.mInfo.mIsLongLived = r2;
            return this;
        }

        public Builder setExcludedFromSurfaces(int r2) {
            this.mInfo.mExcludedSurfaces = r2;
            return this;
        }

        public Builder setRank(int r2) {
            this.mInfo.mRank = r2;
            return this;
        }

        public Builder setExtras(PersistableBundle r2) {
            this.mInfo.mExtras = r2;
            return this;
        }

        public Builder setTransientExtras(Bundle r2) {
            ShortcutInfoCompat r0 = this.mInfo;
            r0.mTransientExtras = (Bundle) Preconditions.checkNotNull(r2);
            return this;
        }

        public Builder addCapabilityBinding(String r2) {
            if (this.mCapabilityBindings != null) goto L5;
            this.mCapabilityBindings = new HashSet();
        L5:
            this.mCapabilityBindings.add(r2);
            return this;
        }

        public Builder addCapabilityBinding(String r3, String r4, List<String> r5) {
            addCapabilityBinding(r3);
            if (r5.isEmpty() == false) goto L5;
        L11:
            return this;
        L5:
            if (this.mCapabilityBindingParams != null) goto L8;
            this.mCapabilityBindingParams = new HashMap();
        L8:
            if (this.mCapabilityBindingParams.get(r3) != null) goto L10;
            this.mCapabilityBindingParams.put(r3, new HashMap());
        L10:
            this.mCapabilityBindingParams.get(r3).put(r4, r5);
            goto L11
        }

        public Builder setSliceUri(Uri r1) {
            this.mSliceUri = r1;
            return this;
        }

        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel) == true) goto L47;
            if (this.mInfo.mIntents == null) goto L45;
            if (this.mInfo.mIntents.length == 0) goto L45;
            if (this.mIsConversation == false) goto L15;
            if (this.mInfo.mLocusId != null) goto L13;
            this.mInfo.mLocusId = new LocusIdCompat(this.mInfo.mId);
        L13:
            this.mInfo.mIsLongLived = true;
        L15:
            if (this.mCapabilityBindings == null) goto L21;
            if (this.mInfo.mCategories != null) goto L19;
            this.mInfo.mCategories = new HashSet();
        L19:
            this.mInfo.mCategories.addAll(this.mCapabilityBindings);
        L21:
            if (this.mCapabilityBindingParams == null) goto L37;
            if (this.mInfo.mExtras != null) goto L25;
            this.mInfo.mExtras = new PersistableBundle();
        L25:
            Iterator<String> r0 = this.mCapabilityBindingParams.keySet().iterator();
        L27:
            if (r0.hasNext() == false) goto L37;
            String r1 = r0.next();
            Map<String, List<String>> r2 = this.mCapabilityBindingParams.get(r1);
            this.mInfo.mExtras.putStringArray(r1, (String[]) r2.keySet().toArray(new String[0]));
            Iterator<String> r3 = r2.keySet().iterator();
        L30:
            if (r3.hasNext() == false) goto L27;
            String r4 = r3.next();
            List<String> r6 = r2.get(r4);
            PersistableBundle r7 = this.mInfo.mExtras;
            String r5 = r1 + LibrarianImpl.Constants.SEPARATOR + r4;
            if (r6 != null) goto L34;
            String[] r8 = new String[0];
        L35:
            r7.putStringArray(r5, r8);
            goto L30
        L34:
            r8 = (String[]) r6.toArray(new String[0]);
        L37:
            if (this.mSliceUri == null) goto L43;
            if (this.mInfo.mExtras != null) goto L41;
            this.mInfo.mExtras = new PersistableBundle();
        L41:
            this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
        L43:
            return this.mInfo;
        L45:
            throw new IllegalArgumentException("Shortcut must have an intent");
        L47:
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }

    ShortcutInfoCompat() {
        this.mIsEnabled = true;
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder r0 = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat r1 = this.mIcon;
        if (r1 == null) goto L6;
        r0.setIcon(r1.toIcon(this.mContext));
    L6:
        if (TextUtils.isEmpty(this.mLongLabel) == true) goto L9;
        r0.setLongLabel(this.mLongLabel);
    L9:
        if (TextUtils.isEmpty(this.mDisabledMessage) == true) goto L11;
        r0.setDisabledMessage(this.mDisabledMessage);
    L11:
        ComponentName r2 = this.mActivity;
        if (r2 == null) goto L14;
        r0.setActivity(r2);
    L14:
        Set<String> r3 = this.mCategories;
        if (r3 == null) goto L17;
        r0.setCategories(r3);
    L17:
        r0.setRank(this.mRank);
        PersistableBundle r4 = this.mExtras;
        if (r4 == null) goto L20;
        r0.setExtras(r4);
    L20:
        Person[] r5 = this.mPersons;
        if (r5 != null) goto L23;
    L28:
        LocusIdCompat r6 = this.mLocusId;
        if (r6 == null) goto L31;
        r0.setLocusId(r6.toLocusId());
    L31:
        r0.setLongLived(this.mIsLongLived);
        if (Build.VERSION.SDK_INT < 33) goto L35;
        Api33Impl.setExcludedFromSurfaces(r0, this.mExcludedSurfaces);
    L35:
        return r0.build();
    L23:
        if (r5.length <= 0) goto L28;
        int r7 = r5.length;
        android.app.Person[] r8 = new android.app.Person[r7];
        int r9 = 0;
    L25:
        if (r9 >= r7) goto L27;
        r8[r9] = this.mPersons[r9].toAndroidPerson();
        r9 = r9 + 1;
        goto L25
    L27:
        r0.setPersons(r8);
        goto L28
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras != null) goto L5;
        this.mExtras = new PersistableBundle();
    L5:
        Person[] r0 = this.mPersons;
        if (r0 != null) goto L8;
    L13:
        LocusIdCompat r1 = this.mLocusId;
        if (r1 == null) goto L16;
        this.mExtras.putString(EXTRA_LOCUS_ID, r1.getId());
    L16:
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    L8:
        if (r0.length <= 0) goto L13;
        this.mExtras.putInt(EXTRA_PERSON_COUNT, r0.length);
        int r2 = 0;
    L11:
        if (r2 >= this.mPersons.length) goto L13;
        int r3 = r2 + 1;
        this.mExtras.putPersistableBundle(EXTRA_PERSON_ + r3, this.mPersons[r2].toPersistableBundle());
        r2 = r3;
        goto L11
    }

    Intent addToIntent(Intent r4) {
        Intent[] r0 = this.mIntents;
        r4.putExtra("android.intent.extra.shortcut.INTENT", r0[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon == null) goto L12;
        Drawable r1 = null;
        if (this.mIsAlwaysBadged == false) goto L11;
        PackageManager r2 = this.mContext.getPackageManager();
        ComponentName r3 = this.mActivity;
        if (r3 != null) goto L14;
    L9:
        if (r1 != null) goto L11;
        r1 = this.mContext.getApplicationInfo().loadIcon(r2);
        goto L11
    L14:
        r1 = r2.getActivityIcon(r3);     // Catch: PackageManager.NameNotFoundException -> L13
    L11:
        this.mIcon.addToShortcutIntent(r4, r1, this.mContext);
    L12:
        return r4;
    }

    public String getId() {
        return this.mId;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public Intent getIntent() {
        Intent[] r1 = this.mIntents;
        return r1[r1.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] r1 = this.mIntents;
        return (Intent[]) Arrays.copyOf(r1, r1.length);
    }

    public Set<String> getCategories() {
        return this.mCategories;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    public int getRank() {
        return this.mRank;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    static Person[] getPersonsFromExtra(PersistableBundle r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.containsKey(EXTRA_PERSON_COUNT) == false) goto L13;
        int r0 = r5.getInt(EXTRA_PERSON_COUNT);
        Person[] r1 = new Person[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        int r4 = r2 + 1;
        r1[r2] = Person.fromPersistableBundle(r5.getPersistableBundle(EXTRA_PERSON_ + r4));
        r2 = r4;
        goto L7
    L9:
        return r1;
    L13:
        return null;
    }

    static boolean getLongLivedFromExtra(PersistableBundle r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.containsKey(EXTRA_LONG_LIVED) == true) goto L7;
        return false;
    L7:
        return r2.getBoolean(EXTRA_LONG_LIVED);
    }

    static List<ShortcutInfoCompat> fromShortcuts(Context r3, List<ShortcutInfo> r4) {
        ArrayList r0 = new ArrayList(r4.size());
        Iterator<ShortcutInfo> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(new Builder(r3, r5.next()).build());
        goto L4
    L6:
        return r0;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    static LocusIdCompat getLocusId(ShortcutInfo r1) {
        if (r1.getLocusId() != null) goto L7;
        return null;
    L7:
        return LocusIdCompat.toLocusIdCompat(r1.getLocusId());
    }

    public boolean isExcludedFromSurfaces(int r1) {
        if ((this.mExcludedSurfaces & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r3 = r2.getString(EXTRA_LOCUS_ID);
        if (r3 != null) goto L9;
        return null;
    L9:
        return new LocusIdCompat(r3);
    }
}
