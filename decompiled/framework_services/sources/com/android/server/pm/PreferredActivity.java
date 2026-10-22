package com.android.server.pm;

import android.content.ComponentName;
import android.content.IntentFilter;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.utils.SnapshotCache;
import java.io.IOException;
import java.io.PrintWriter;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class PreferredActivity extends WatchedIntentFilter implements PreferredComponent.Callbacks {
    private static final boolean DEBUG_FILTERS = false;
    private static final String TAG = "PreferredActivity";
    final PreferredComponent mPref;
    final SnapshotCache<PreferredActivity> mSnapshot;

    /* synthetic */ PreferredActivity(PreferredActivity r1, PreferredActivityIA r2) {
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

    PreferredActivity(IntentFilter filter, int match, ComponentName[] set, ComponentName activity, boolean always) {
        super(filter);
        this.mPref = new PreferredComponent(this, match, set, activity, always);
        this.mSnapshot = makeCache();
    }

    PreferredActivity(WatchedIntentFilter filter, int match, ComponentName[] set, ComponentName activity, boolean always) {
        this(filter.mFilter, match, set, activity, always);
    }

    private PreferredActivity(PreferredActivity f) {
        super(f);
        this.mPref = f.mPref;
        this.mSnapshot = new SnapshotCache.Sealed();
    }

    PreferredActivity(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        this.mPref = new PreferredComponent(this, parser);
        this.mSnapshot = makeCache();
    }

    public void writeToXml(TypedXmlSerializer serializer, boolean full) throws IOException {
        this.mPref.writeToXml(serializer, full);
        serializer.startTag(null, DomainVerificationPersistence.ATTR_FILTER);
        this.mFilter.writeToXml(serializer);
        serializer.endTag(null, DomainVerificationPersistence.ATTR_FILTER);
    }

    @Override // com.android.server.pm.PreferredComponent.Callbacks
    public boolean onReadTag(String tagName, TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        if (tagName.equals(DomainVerificationPersistence.ATTR_FILTER) == false) goto L5;
        this.mFilter.readFromXml(parser);
        return true;
    L5:
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <preferred-activities>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        return true;
    }

    public void dumpPref(PrintWriter out, String prefix, PreferredActivity filter) {
        this.mPref.dump(out, prefix, filter);
    }

    public String toString() {
        return "PreferredActivity{0x" + Integer.toHexString(System.identityHashCode(this)) + " " + this.mPref.mComponent.flattenToShortString() + "}";
    }

    @Override // com.android.server.pm.WatchedIntentFilter, com.android.server.utils.Snappable
    public PreferredActivity snapshot() {
        return this.mSnapshot.snapshot();
    }
}
