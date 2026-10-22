package com.android.server.pm;

import android.content.IntentFilter;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.am.ProcessList;
import com.android.server.utils.SnapshotCache;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class CrossProfileIntentFilter extends WatchedIntentFilter {
    public static final int ACCESS_LEVEL_ALL = 0;
    public static final int ACCESS_LEVEL_SYSTEM = 10;
    public static final int ACCESS_LEVEL_SYSTEM_ADD_ONLY = 20;
    private static final String ATTR_ACCESS_CONTROL = "accessControl";
    private static final String ATTR_FILTER = "filter";
    private static final String ATTR_FLAGS = "flags";
    private static final String ATTR_OWNER_PACKAGE = "ownerPackage";
    private static final String ATTR_TARGET_USER_ID = "targetUserId";
    public static final int FLAG_ALLOW_CHAINED_RESOLUTION = 16;
    public static final int FLAG_IS_PACKAGE_FOR_FILTER = 8;
    private static final String TAG = "CrossProfileIntentFilter";
    final int mAccessControlLevel;
    final int mFlags;
    final String mOwnerPackage;
    final SnapshotCache<CrossProfileIntentFilter> mSnapshot;
    final int mTargetUserId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AccessControlLevel {
    }

    /* synthetic */ CrossProfileIntentFilter(CrossProfileIntentFilter r1, CrossProfileIntentFilterIA r2) {
        this(r1);
    }

    @Override // com.android.server.pm.WatchedIntentFilter, com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ WatchedIntentFilter snapshot() {
        return snapshot();
    }

    @Override // com.android.server.pm.WatchedIntentFilter, com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    private SnapshotCache makeCache() {
        return new AnonymousClass1(this, this, this);
    }

    CrossProfileIntentFilter(IntentFilter filter, String ownerPackage, int targetUserId, int flags) {
        this(filter, ownerPackage, targetUserId, flags, 0);
    }

    CrossProfileIntentFilter(IntentFilter filter, String ownerPackage, int targetUserId, int flags, int accessControlLevel) {
        super(filter);
        this.mTargetUserId = targetUserId;
        this.mOwnerPackage = ownerPackage;
        this.mFlags = flags;
        this.mAccessControlLevel = accessControlLevel;
        this.mSnapshot = makeCache();
    }

    CrossProfileIntentFilter(WatchedIntentFilter filter, String ownerPackage, int targetUserId, int flags) {
        this(filter.mFilter, ownerPackage, targetUserId, flags);
    }

    CrossProfileIntentFilter(WatchedIntentFilter filter, String ownerPackage, int targetUserId, int flags, int accessControlLevel) {
        this(filter.mFilter, ownerPackage, targetUserId, flags, accessControlLevel);
    }

    private CrossProfileIntentFilter(CrossProfileIntentFilter f) {
        super(f);
        this.mTargetUserId = f.mTargetUserId;
        this.mOwnerPackage = f.mOwnerPackage;
        this.mFlags = f.mFlags;
        this.mAccessControlLevel = f.mAccessControlLevel;
        this.mSnapshot = new SnapshotCache.Sealed();
    }

    public int getTargetUserId() {
        return this.mTargetUserId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public String getOwnerPackage() {
        return this.mOwnerPackage;
    }

    public int getAccessControlLevel() {
        return this.mAccessControlLevel;
    }

    CrossProfileIntentFilter(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        this.mTargetUserId = parser.getAttributeInt(null, ATTR_TARGET_USER_ID, ProcessList.INVALID_ADJ);
        this.mOwnerPackage = getStringFromXml(parser, ATTR_OWNER_PACKAGE, "");
        this.mAccessControlLevel = parser.getAttributeInt(null, ATTR_ACCESS_CONTROL, 0);
        this.mFlags = parser.getAttributeInt(null, ATTR_FLAGS, 0);
        this.mSnapshot = makeCache();
        int outerDepth = parser.getDepth();
        String tagName = parser.getName();
    L3:
        int type = parser.next();
        if (type == 1) goto L21;
        if (type == 3) goto L8;
    L9:
        tagName = parser.getName();
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        if (type != 2) goto L3;
        if (tagName.equals("filter") == true) goto L21;
        String msg = "Unknown element under crossProfile-intent-filters: " + tagName + " at " + parser.getPositionDescription();
        PackageManagerService.reportSettingsProblem(5, msg);
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L9;
    L21:
        if (tagName.equals("filter") == false) goto L23;
        this.mFilter.readFromXml(parser);
        return;
    L23:
        String msg2 = "Missing element under CrossProfileIntentFilter: filter at " + parser.getPositionDescription();
        PackageManagerService.reportSettingsProblem(5, msg2);
        XmlUtils.skipCurrentTag(parser);
    }

    private String getStringFromXml(TypedXmlPullParser parser, String attribute, String defaultValue) {
        String value = parser.getAttributeValue(null, attribute);
        if (value != null) goto L6;
        String msg = "Missing element under CrossProfileIntentFilter: " + attribute + " at " + parser.getPositionDescription();
        PackageManagerService.reportSettingsProblem(5, msg);
        return defaultValue;
    L6:
        return value;
    }

    public void writeToXml(TypedXmlSerializer serializer) throws IOException {
        serializer.attributeInt(null, ATTR_TARGET_USER_ID, this.mTargetUserId);
        serializer.attributeInt(null, ATTR_FLAGS, this.mFlags);
        serializer.attribute(null, ATTR_OWNER_PACKAGE, this.mOwnerPackage);
        serializer.attributeInt(null, ATTR_ACCESS_CONTROL, this.mAccessControlLevel);
        serializer.startTag(null, "filter");
        this.mFilter.writeToXml(serializer);
        serializer.endTag(null, "filter");
    }

    public String toString() {
        return "CrossProfileIntentFilter{0x" + Integer.toHexString(System.identityHashCode(this)) + " " + Integer.toString(this.mTargetUserId) + "}";
    }

    boolean equalsIgnoreFilter(CrossProfileIntentFilter other) {
        if (this.mTargetUserId == other.mTargetUserId) goto L5;
    L11:
        return false;
    L5:
        if (this.mOwnerPackage.equals(other.mOwnerPackage) == false) goto L11;
        if (this.mFlags != other.mFlags) goto L11;
        if (this.mAccessControlLevel != other.mAccessControlLevel) goto L11;
        return true;
    }

    @Override // com.android.server.pm.WatchedIntentFilter, com.android.server.utils.Snappable
    public CrossProfileIntentFilter snapshot() {
        return this.mSnapshot.snapshot();
    }
}
