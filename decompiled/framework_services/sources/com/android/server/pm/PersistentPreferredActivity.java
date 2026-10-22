package com.android.server.pm;

import android.content.ComponentName;
import android.content.IntentFilter;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.utils.SnapshotCache;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class PersistentPreferredActivity extends WatchedIntentFilter {
    private static final String ATTR_FILTER = "filter";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_SET_BY_DPM = "set-by-dpm";
    private static final boolean DEBUG_FILTERS = false;
    private static final String TAG = "PersistentPreferredActivity";
    final ComponentName mComponent;
    final boolean mIsSetByDpm;
    final SnapshotCache<PersistentPreferredActivity> mSnapshot;

    /* synthetic */ PersistentPreferredActivity(PersistentPreferredActivity r1, PersistentPreferredActivityIA r2) {
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

    PersistentPreferredActivity(IntentFilter filter, ComponentName activity, boolean isSetByDpm) {
        super(filter);
        this.mComponent = activity;
        this.mIsSetByDpm = isSetByDpm;
        this.mSnapshot = makeCache();
    }

    PersistentPreferredActivity(WatchedIntentFilter filter, ComponentName activity, boolean isSetByDpm) {
        this(filter.mFilter, activity, isSetByDpm);
    }

    private PersistentPreferredActivity(PersistentPreferredActivity f) {
        super(f);
        this.mComponent = f.mComponent;
        this.mIsSetByDpm = f.mIsSetByDpm;
        this.mSnapshot = new SnapshotCache.Sealed();
    }

    PersistentPreferredActivity(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        String shortComponent = parser.getAttributeValue(null, "name");
        this.mComponent = ComponentName.unflattenFromString(shortComponent);
        if (this.mComponent != null) goto L5;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: Bad activity name " + shortComponent + " at " + parser.getPositionDescription());
    L5:
        this.mIsSetByDpm = parser.getAttributeBoolean(null, ATTR_SET_BY_DPM, false);
        int outerDepth = parser.getDepth();
        String tagName = parser.getName();
    L6:
        int type = parser.next();
        if (type == 1) goto L24;
        if (type == 3) goto L11;
    L12:
        tagName = parser.getName();
        if (type == 3) goto L6;
        if (type == 4) goto L6;
        if (type != 2) goto L6;
        if (tagName.equals("filter") == true) goto L24;
        PackageManagerService.reportSettingsProblem(5, "Unknown element: " + tagName + " at " + parser.getPositionDescription());
        XmlUtils.skipCurrentTag(parser);
        goto L6
    L11:
        if (parser.getDepth() > outerDepth) goto L12;
    L24:
        if (tagName.equals("filter") == false) goto L26;
        this.mFilter.readFromXml(parser);
    L27:
        this.mSnapshot = makeCache();
        return;
    L26:
        PackageManagerService.reportSettingsProblem(5, "Missing element filter at " + parser.getPositionDescription());
        XmlUtils.skipCurrentTag(parser);
        goto L27
    }

    public void writeToXml(TypedXmlSerializer serializer) throws IOException {
        serializer.attribute(null, "name", this.mComponent.flattenToShortString());
        serializer.attributeBoolean(null, ATTR_SET_BY_DPM, this.mIsSetByDpm);
        serializer.startTag(null, "filter");
        this.mFilter.writeToXml(serializer);
        serializer.endTag(null, "filter");
    }

    @Override // com.android.server.pm.WatchedIntentFilter
    public IntentFilter getIntentFilter() {
        return this.mFilter;
    }

    public String toString() {
        return "PersistentPreferredActivity{0x" + Integer.toHexString(System.identityHashCode(this)) + " " + this.mComponent.flattenToShortString() + ", mIsSetByDpm=" + this.mIsSetByDpm + "}";
    }

    @Override // com.android.server.pm.WatchedIntentFilter, com.android.server.utils.Snappable
    public PersistentPreferredActivity snapshot() {
        return this.mSnapshot.snapshot();
    }
}
