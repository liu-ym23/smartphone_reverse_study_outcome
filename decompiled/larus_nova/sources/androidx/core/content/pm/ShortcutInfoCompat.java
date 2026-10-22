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
import androidx.collection.ArraySet;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
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

/* JADX INFO: loaded from: classes6.dex */
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

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static void setExcludedFromSurfaces(ShortcutInfo.Builder r100, int r101) {
            r100.setExcludedFromSurfaces(r101);
        }
    }

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel) == true) goto L47;
            ShortcutInfoCompat r100 = this.mInfo;
            Intent[] r101 = r100.mIntents;
            if (r101 == null) goto L45;
            if (r101.length == 0) goto L45;
            if (this.mIsConversation == false) goto L15;
            if (r100.mLocusId != null) goto L13;
            r100.mLocusId = new LocusIdCompat(r100.mId);
        L13:
            this.mInfo.mIsLongLived = true;
        L15:
            if (this.mCapabilityBindings == null) goto L21;
            ShortcutInfoCompat r102 = this.mInfo;
            if (r102.mCategories != null) goto L19;
            r102.mCategories = new HashSet();
        L19:
            this.mInfo.mCategories.addAll(this.mCapabilityBindings);
        L21:
            if (this.mCapabilityBindingParams == null) goto L37;
            ShortcutInfoCompat r103 = this.mInfo;
            if (r103.mExtras != null) goto L25;
            r103.mExtras = new PersistableBundle();
        L25:
            Iterator<String> r104 = this.mCapabilityBindingParams.keySet().iterator();
        L27:
            if (r104.hasNext() == false) goto L37;
            String r105 = r104.next();
            Map<String, List<String>> r106 = this.mCapabilityBindingParams.get(r105);
            this.mInfo.mExtras.putStringArray(r105, (String[]) r106.keySet().toArray(new String[0]));
            Iterator<String> r107 = r106.keySet().iterator();
        L30:
            if (r107.hasNext() == false) goto L27;
            String r108 = r107.next();
            List<String> r109 = r106.get(r108);
            PersistableBundle r110 = this.mInfo.mExtras;
            String r111 = r105 + HTTP.URL_DEFAULT + r108;
            if (r109 != null) goto L34;
            String[] r112 = new String[0];
        L35:
            r110.putStringArray(r111, r112);
            goto L30
        L34:
            r112 = (String[]) r109.toArray(new String[0]);
        L37:
            if (this.mSliceUri == null) goto L43;
            ShortcutInfoCompat r113 = this.mInfo;
            if (r113.mExtras != null) goto L41;
            r113.mExtras = new PersistableBundle();
        L41:
            this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
        L43:
            return this.mInfo;
        L45:
            throw new IllegalArgumentException("Shortcut must have an intent");
        L47:
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        public Builder(ShortcutInfoCompat r100) {
            ShortcutInfoCompat r101 = new ShortcutInfoCompat();
            this.mInfo = r101;
            r101.mContext = r100.mContext;
            r101.mId = r100.mId;
            r101.mPackageName = r100.mPackageName;
            Intent[] r102 = r100.mIntents;
            r101.mIntents = (Intent[]) Arrays.copyOf(r102, r102.length);
            r101.mActivity = r100.mActivity;
            r101.mLabel = r100.mLabel;
            r101.mLongLabel = r100.mLongLabel;
            r101.mDisabledMessage = r100.mDisabledMessage;
            r101.mDisabledReason = r100.mDisabledReason;
            r101.mIcon = r100.mIcon;
            r101.mIsAlwaysBadged = r100.mIsAlwaysBadged;
            r101.mUser = r100.mUser;
            r101.mLastChangedTimestamp = r100.mLastChangedTimestamp;
            r101.mIsCached = r100.mIsCached;
            r101.mIsDynamic = r100.mIsDynamic;
            r101.mIsPinned = r100.mIsPinned;
            r101.mIsDeclaredInManifest = r100.mIsDeclaredInManifest;
            r101.mIsImmutable = r100.mIsImmutable;
            r101.mIsEnabled = r100.mIsEnabled;
            r101.mLocusId = r100.mLocusId;
            r101.mIsLongLived = r100.mIsLongLived;
            r101.mHasKeyFieldsOnly = r100.mHasKeyFieldsOnly;
            r101.mRank = r100.mRank;
            Person[] r103 = r100.mPersons;
            if (r103 == null) goto L6;
            r101.mPersons = (Person[]) Arrays.copyOf(r103, r103.length);
        L6:
            if (r100.mCategories == null) goto L8;
            r101.mCategories = new HashSet(r100.mCategories);
        L8:
            PersistableBundle r104 = r100.mExtras;
            if (r104 == null) goto L11;
            r101.mExtras = r104;
        L11:
            r101.mExcludedSurfaces = r100.mExcludedSurfaces;
        }

        public Builder addCapabilityBinding(String r100) {
            if (this.mCapabilityBindings != null) goto L5;
            this.mCapabilityBindings = new HashSet();
        L5:
            this.mCapabilityBindings.add(r100);
            return this;
        }

        public Builder setActivity(ComponentName r100) {
            this.mInfo.mActivity = r100;
            return this;
        }

        public Builder setCategories(Set<String> r100) {
            ArraySet r101 = new ArraySet();
            r101.addAll(r100);
            this.mInfo.mCategories = r101;
            return this;
        }

        public Builder setDisabledMessage(CharSequence r100) {
            this.mInfo.mDisabledMessage = r100;
            return this;
        }

        public Builder setExcludedFromSurfaces(int r100) {
            this.mInfo.mExcludedSurfaces = r100;
            return this;
        }

        public Builder setExtras(PersistableBundle r100) {
            this.mInfo.mExtras = r100;
            return this;
        }

        public Builder setIcon(IconCompat r100) {
            this.mInfo.mIcon = r100;
            return this;
        }

        public Builder setIntent(Intent r100) {
            return setIntents(new Intent[]{r100});
        }

        public Builder setIntents(Intent[] r100) {
            this.mInfo.mIntents = r100;
            return this;
        }

        public Builder setLocusId(LocusIdCompat r100) {
            this.mInfo.mLocusId = r100;
            return this;
        }

        public Builder setLongLabel(CharSequence r100) {
            this.mInfo.mLongLabel = r100;
            return this;
        }

        public Builder setLongLived(boolean r100) {
            this.mInfo.mIsLongLived = r100;
            return this;
        }

        public Builder setPerson(Person r100) {
            return setPersons(new Person[]{r100});
        }

        public Builder setPersons(Person[] r100) {
            this.mInfo.mPersons = r100;
            return this;
        }

        public Builder setRank(int r100) {
            this.mInfo.mRank = r100;
            return this;
        }

        public Builder setShortLabel(CharSequence r100) {
            this.mInfo.mLabel = r100;
            return this;
        }

        public Builder setSliceUri(Uri r100) {
            this.mSliceUri = r100;
            return this;
        }

        public Builder setTransientExtras(Bundle r100) {
            ShortcutInfoCompat r101 = this.mInfo;
            r101.mTransientExtras = (Bundle) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder(Context r100, ShortcutInfo r101) {
            ShortcutInfoCompat r102 = new ShortcutInfoCompat();
            this.mInfo = r102;
            r102.mContext = r100;
            r102.mId = r101.getId();
            r102.mPackageName = r101.getPackage();
            Intent[] r103 = r101.getIntents();
            r102.mIntents = (Intent[]) Arrays.copyOf(r103, r103.length);
            r102.mActivity = r101.getActivity();
            r102.mLabel = r101.getShortLabel();
            r102.mLongLabel = r101.getLongLabel();
            r102.mDisabledMessage = r101.getDisabledMessage();
            int r104 = Build.VERSION.SDK_INT;
            if (r104 < 28) goto L6;
            r102.mDisabledReason = r101.getDisabledReason();
        L10:
            r102.mCategories = r101.getCategories();
            r102.mPersons = ShortcutInfoCompat.getPersonsFromExtra(r101.getExtras());
            r102.mUser = r101.getUserHandle();
            r102.mLastChangedTimestamp = r101.getLastChangedTimestamp();
            if (r104 < 30) goto L13;
            r102.mIsCached = r101.isCached();
        L13:
            r102.mIsDynamic = r101.isDynamic();
            r102.mIsPinned = r101.isPinned();
            r102.mIsDeclaredInManifest = r101.isDeclaredInManifest();
            r102.mIsImmutable = r101.isImmutable();
            r102.mIsEnabled = r101.isEnabled();
            r102.mHasKeyFieldsOnly = r101.hasKeyFieldsOnly();
            r102.mLocusId = ShortcutInfoCompat.getLocusId(r101);
            r102.mRank = r101.getRank();
            r102.mExtras = r101.getExtras();
            return;
        L6:
            if (r101.isEnabled() == false) goto L8;
            int r105 = 0;
        L9:
            r102.mDisabledReason = r105;
            goto L10
        L8:
            r105 = 3;
            goto L9
        }

        public Builder(Context r100, String r101) {
            ShortcutInfoCompat r102 = new ShortcutInfoCompat();
            this.mInfo = r102;
            r102.mContext = r100;
            r102.mId = r101;
        }

        public Builder addCapabilityBinding(String r100, String r101, List<String> r102) {
            addCapabilityBinding(r100);
            if (r102.isEmpty() == false) goto L5;
        L11:
            return this;
        L5:
            if (this.mCapabilityBindingParams != null) goto L8;
            this.mCapabilityBindingParams = new HashMap();
        L8:
            if (this.mCapabilityBindingParams.get(r100) != null) goto L10;
            this.mCapabilityBindingParams.put(r100, new HashMap());
        L10:
            this.mCapabilityBindingParams.get(r100).put(r101, r102);
            goto L11
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras != null) goto L5;
        this.mExtras = new PersistableBundle();
    L5:
        Person[] r100 = this.mPersons;
        if (r100 != null) goto L8;
    L13:
        LocusIdCompat r101 = this.mLocusId;
        if (r101 == null) goto L16;
        this.mExtras.putString(EXTRA_LOCUS_ID, r101.getId());
    L16:
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    L8:
        if (r100.length <= 0) goto L13;
        this.mExtras.putInt(EXTRA_PERSON_COUNT, r100.length);
        int r102 = 0;
    L11:
        if (r102 >= this.mPersons.length) goto L13;
        PersistableBundle r103 = this.mExtras;
        StringBuilder r104 = new StringBuilder(EXTRA_PERSON_);
        int r105 = r102 + 1;
        r104.append(r105);
        r103.putPersistableBundle(r104.toString(), this.mPersons[r102].toPersistableBundle());
        r102 = r105;
        goto L11
    }

    public Intent getIntent() {
        Intent[] r100 = this.mIntents;
        return r100[r100.length - 1];
    }

    public Intent[] getIntents() {
        Intent[] r100 = this.mIntents;
        return (Intent[]) Arrays.copyOf(r100, r100.length);
    }

    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder r100 = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
        IconCompat r101 = this.mIcon;
        if (r101 == null) goto L6;
        r100.setIcon(r101.toIcon(this.mContext));
    L6:
        if (TextUtils.isEmpty(this.mLongLabel) == true) goto L9;
        r100.setLongLabel(this.mLongLabel);
    L9:
        if (TextUtils.isEmpty(this.mDisabledMessage) == true) goto L11;
        r100.setDisabledMessage(this.mDisabledMessage);
    L11:
        ComponentName r102 = this.mActivity;
        if (r102 == null) goto L14;
        r100.setActivity(r102);
    L14:
        Set<String> r103 = this.mCategories;
        if (r103 == null) goto L17;
        r100.setCategories(r103);
    L17:
        r100.setRank(this.mRank);
        PersistableBundle r104 = this.mExtras;
        if (r104 == null) goto L21;
        r100.setExtras(r104);
    L21:
        if (Build.VERSION.SDK_INT < 29) goto L34;
        Person[] r105 = this.mPersons;
        if (r105 != null) goto L25;
    L30:
        LocusIdCompat r106 = this.mLocusId;
        if (r106 == null) goto L33;
        r100.setLocusId(r106.toLocusId());
    L33:
        r100.setLongLived(this.mIsLongLived);
    L36:
        if (Build.VERSION.SDK_INT < 33) goto L39;
        Api33Impl.setExcludedFromSurfaces(r100, this.mExcludedSurfaces);
    L39:
        return r100.build();
    L25:
        if (r105.length <= 0) goto L30;
        int r107 = r105.length;
        android.app.Person[] r108 = new android.app.Person[r107];
        int r109 = 0;
    L27:
        if (r109 >= r107) goto L29;
        r108[r109] = this.mPersons[r109].toAndroidPerson();
        r109 = r109 + 1;
        goto L27
    L29:
        r100.setPersons(r108);
        goto L30
    L34:
        r100.setExtras(buildLegacyExtrasBundle());
        goto L36
    }

    public ShortcutInfoCompat() {
        this.mIsEnabled = true;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public Set<String> getCategories() {
        return this.mCategories;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public static LocusIdCompat getLocusId(ShortcutInfo r100) {
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (r100.getLocusId() != null) goto L9;
        return null;
    L9:
        return LocusIdCompat.toLocusIdCompat(r100.getLocusId());
    L11:
        return getLocusIdFromExtra(r100.getExtras());
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getString(EXTRA_LOCUS_ID);
        if (r101 != null) goto L9;
        return null;
    L9:
        return new LocusIdCompat(r101);
    }

    public static boolean getLongLivedFromExtra(PersistableBundle r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.containsKey(EXTRA_LONG_LIVED) == true) goto L7;
        return false;
    L7:
        return r100.getBoolean(EXTRA_LONG_LIVED);
    }

    public static Person[] getPersonsFromExtra(PersistableBundle r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.containsKey(EXTRA_PERSON_COUNT) == false) goto L13;
        int r101 = r100.getInt(EXTRA_PERSON_COUNT);
        Person[] r102 = new Person[r101];
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L9;
        StringBuilder r104 = new StringBuilder(EXTRA_PERSON_);
        int r105 = r103 + 1;
        r104.append(r105);
        r102[r103] = Person.fromPersistableBundle(r100.getPersistableBundle(r104.toString()));
        r103 = r105;
        goto L7
    L9:
        return r102;
    L13:
        return null;
    }

    public Intent addToIntent(Intent r100) {
        Intent[] r101 = this.mIntents;
        r100.putExtra("android.intent.extra.shortcut.INTENT", r101[r101.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon == null) goto L14;
        Drawable r102 = null;
        if (this.mIsAlwaysBadged == false) goto L13;
        PackageManager r103 = this.mContext.getPackageManager();
        ComponentName r104 = this.mActivity;
        if (r104 != null) goto L15;
    L11:
        if (r102 != null) goto L13;
        r102 = this.mContext.getApplicationInfo().loadIcon(r103);
        goto L13
    L15:
        r102 = r103.getActivityIcon(r104);     // Catch: PackageManager.NameNotFoundException -> L10
    L13:
        this.mIcon.addToShortcutIntent(r100, r102, this.mContext);
    L14:
        return r100;
    }

    public boolean isExcludedFromSurfaces(int r100) {
        if ((r100 & this.mExcludedSurfaces) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static List<ShortcutInfoCompat> fromShortcuts(Context r100, List<ShortcutInfo> r101) {
        ArrayList r102 = new ArrayList(r101.size());
        Iterator<ShortcutInfo> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(new Builder(r100, r103.next()).build());
        goto L4
    L6:
        return r102;
    }
}
