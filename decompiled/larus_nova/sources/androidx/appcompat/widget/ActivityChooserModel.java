package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Xml;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String LOG_TAG = null;
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = null;
    private static final Object sRegistryLock = null;
    private final List<ActivityResolveInfo> mActivities;
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    boolean mCanReadHistoricalData;
    final Context mContext;
    private final List<HistoricalRecord> mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel r100);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public ActivityResolveInfo(ResolveInfo r100) {
            this.resolveInfo = r100;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ActivityResolveInfo r100) {
            return Float.floatToIntBits(r100.weight) - Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (ActivityResolveInfo.class == r100.getClass()) goto L12;
            return false;
        L12:
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) r100).weight)) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ActivityResolveInfo r100) {
            return compareTo2(r100);
        }
    }

    public interface ActivitySorter {
        void sort(Intent r100, List<ActivityResolveInfo> r101, List<HistoricalRecord> r102);
    }

    public static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap;

        public DefaultSorter() {
            this.mPackageNameToActivityMap = new HashMap();
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent r100, List<ActivityResolveInfo> r101, List<HistoricalRecord> r102) {
            Map<ComponentName, ActivityResolveInfo> r103 = this.mPackageNameToActivityMap;
            r103.clear();
            int r104 = r101.size();
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L5;
            ActivityResolveInfo r106 = (ActivityResolveInfo) ListProtector.get(r101, r105);
            r106.weight = 0.0f;
            ActivityInfo r107 = r106.resolveInfo.activityInfo;
            r103.put(new ComponentName(r107.packageName, r107.name), r106);
            r105 = r105 + 1;
            goto L3
        L5:
            int r108 = r102.size() - 1;
            float r109 = 1.0f;
        L6:
            if (r108 < 0) goto L11;
            HistoricalRecord r110 = (HistoricalRecord) ListProtector.get(r102, r108);
            ActivityResolveInfo r111 = r103.get(r110.activity);
            if (r111 == null) goto L10;
            r111.weight += r110.weight * r109;
            r109 = r109 * 0.95f;
        L10:
            r108 = r108 - 1;
            goto L6
        L11:
            Collections.sort(r101);
        }
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public int hashCode() {
            ComponentName r100 = this.activity;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.time;
            return ((((r101 + 31) * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (HistoricalRecord.class == r100.getClass()) goto L11;
            return false;
        L11:
            HistoricalRecord r101 = (HistoricalRecord) r100;
            ComponentName r102 = this.activity;
            if (r102 != null) goto L17;
            if (r101.activity == null) goto L20;
            return false;
        L20:
            if (this.time == r101.time) goto L23;
            return false;
        L23:
            if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(r101.weight)) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r102.equals(r101.activity) == true) goto L20;
            return false;
        }

        public HistoricalRecord(ComponentName r100, long r101, float r102) {
            this.activity = r100;
            this.time = r101;
            this.weight = r102;
        }

        public HistoricalRecord(String r100, long r101, float r102) {
            this(ComponentName.unflattenFromString(r100), r101, r102);
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel r100, Intent r101);
    }

    public final class PersistHistoryAsyncTask extends PthreadAsyncTask<Object, Void, Void> {
        final /* synthetic */ ActivityChooserModel this$0;

        public PersistHistoryAsyncTask(ActivityChooserModel r100) {
            this.this$0 = r100;
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Object... r110) {
            List r100 = (List) r110[0];
            String r111 = (String) r110[1];
            FileOutputStream r112 = this.this$0.mContext.openFileOutput(r111, 0);     // Catch: FileNotFoundException -> L32
            XmlSerializer r101 = Xml.newSerializer();
            r101.setOutput(r112, null);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r101.startDocument("UTF-8", Boolean.TRUE);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r101.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            int r102 = r100.size();     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L8;
            HistoricalRecord r104 = (HistoricalRecord) r100.remove(0);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r101.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r101.attribute(null, "activity", r104.activity.flattenToString());     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r101.attribute(null, "time", String.valueOf(r104.time));     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r101.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(r104.weight));     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r101.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r103 = r103 + 1;     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            goto L6
        L8:
            r101.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            r101.endDocument();     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L19 IllegalArgumentException -> L23
            this.this$0.mCanReadHistoricalData = true;
            if (r112 != null) goto L36;
        L27:
            return null;
        L36:
            r112.close();     // Catch: IOException -> L34
            goto L27
        L13:
            th = move-exception;
            this.this$0.mCanReadHistoricalData = true;
            if (r112 != null) goto L40;
        L31:
            throw th;
        L40:
            r112.close();     // Catch: IOException -> L35
        L15:
            String r105 = ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;     // Catch: Throwable -> L13
            ActivityChooserModel r106 = this.this$0;     // Catch: Throwable -> L13
            String r107 = r106.mHistoryFileName;     // Catch: Throwable -> L13
            r106.mCanReadHistoricalData = true;
            if (r112 == null) goto L27;
        L23:
            String r108 = ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;     // Catch: Throwable -> L13
            ActivityChooserModel r109 = this.this$0;     // Catch: Throwable -> L13
            String r113 = r109.mHistoryFileName;     // Catch: Throwable -> L13
            r109.mCanReadHistoricalData = true;
            if (r112 == null) goto L27;
        L19:
            String r114 = ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;     // Catch: Throwable -> L13
            ActivityChooserModel r115 = this.this$0;     // Catch: Throwable -> L13
            String r116 = r115.mHistoryFileName;     // Catch: Throwable -> L13
            r115.mCanReadHistoricalData = true;
            if (r112 == null) goto L27;
        L32:
            String r117 = ActivityChooserModel.DEFAULT_HISTORY_FILE_NAME;
            return null;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r100) {
            return doInBackground(r100);
        }
    }

    static {
        LOG_TAG = "ActivityChooserModel";
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
    }

    private boolean loadActivitiesIfNeeded() {
        int r100 = 0;
        if (this.mReloadActivities == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mIntent == null) goto L11;
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> r101 = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int r102 = r101.size();
    L7:
        if (r100 >= r102) goto L9;
        ResolveInfo r103 = (ResolveInfo) ListProtector.get(r101, r100);
        this.mActivities.add(new ActivityResolveInfo(r103));
        r100 = r100 + 1;
        goto L7
    L9:
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (this.mReadShareHistoryCalled == false) goto L12;
        if (this.mHistoricalRecordsChanged == true) goto L7;
        return;
    L7:
        this.mHistoricalRecordsChanged = false;
        if (TextUtils.isEmpty(this.mHistoryFileName) == true) goto L13;
        new PersistHistoryAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName});
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int r100 = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (r100 > 0) goto L5;
        return;
    L5:
        this.mHistoricalRecordsChanged = true;
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L8;
        HistoricalRecord r102 = (HistoricalRecord) ListProtector.remove(this.mHistoricalRecords, 0);
        r101 = r101 + 1;
        goto L6
    }

    private boolean readHistoricalDataIfNeeded() {
        if (this.mCanReadHistoricalData == true) goto L5;
    L10:
        return false;
    L5:
        if (this.mHistoricalRecordsChanged == false) goto L10;
        if (TextUtils.isEmpty(this.mHistoryFileName) == true) goto L10;
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private void readHistoricalDataImpl() {
        FileInputStream r100 = this.mContext.openFileInput(this.mHistoryFileName);     // Catch: FileNotFoundException -> L41
        XmlPullParser r101 = Xml.newPullParser();     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        r101.setInput(r100, "UTF-8");     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        int r102 = 0;
    L5:
        if (r102 == 1) goto L10;
        if (r102 == 2) goto L10;
        r102 = r101.next();     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
    L10:
        if (TAG_HISTORICAL_RECORDS.equals(r101.getName()) == false) goto L28;
        List<HistoricalRecord> r103 = this.mHistoricalRecords;     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        r103.clear();     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
    L12:
        int r104 = r101.next();     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        if (r104 == 1) goto L14;
        if (r104 == 3) goto L12;
        if (r104 == 4) goto L12;
        if (TAG_HISTORICAL_RECORD.equals(r101.getName()) == false) goto L26;
        r103.add(new HistoricalRecord(r101.getAttributeValue(null, "activity"), Long.parseLong(r101.getAttributeValue(null, "time")), Float.parseFloat(r101.getAttributeValue(null, ATTRIBUTE_WEIGHT))));     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
        goto L12
    L26:
        throw new XmlPullParserException("Share records file not well-formed.");     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
    L14:
        if (r100 != null) goto L49;
        return;
    L49:
        r100.close();     // Catch: IOException -> L42
        return;
    L64:
        return;
    L28:
        throw new XmlPullParserException("Share records file does not start with historical-records tag.");     // Catch: Throwable -> L29 IOException -> L31 XmlPullParserException -> L34
    L29:
        th = move-exception;
        if (r100 != null) goto L47;
    L40:
        throw th;
    L47:
        r100.close();     // Catch: IOException -> L43
        goto L40
    L32:
        if (r100 != null) goto L49;
        return;
    L35:
        if (r100 != null) goto L49;
        return;
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter != null) goto L5;
        return false;
    L5:
        if (this.mIntent != null) goto L7;
        return false;
    L7:
        if (this.mActivities.isEmpty() == false) goto L9;
        return false;
    L9:
        if (this.mHistoricalRecords.isEmpty() == true) goto L16;
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    L16:
        return false;
    }

    public int getActivityCount() {
        Object r100 = this.mInstanceLock;
        monitor-enter(r100);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r101 = this.mActivities.size();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public ResolveInfo getDefaultActivity() {
        Object r100 = this.mInstanceLock;
        monitor-enter(r100);
        ensureConsistentState();     // Catch: Throwable -> L12
        if (this.mActivities.isEmpty() == true) goto L9;
        ResolveInfo r101 = this.mActivities.get(0).resolveInfo;     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public int getHistoryMaxSize() {
        Object r100 = this.mInstanceLock;
        monitor-enter(r100);
        int r101 = this.mHistoryMaxSize;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public int getHistorySize() {
        Object r100 = this.mInstanceLock;
        monitor-enter(r100);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r101 = this.mHistoricalRecords.size();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public Intent getIntent() {
        Object r100 = this.mInstanceLock;
        monitor-enter(r100);
        Intent r101 = this.mIntent;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private void ensureConsistentState() {
        boolean r100 = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (r100 == false) goto L6;
        sortActivitiesIfNeeded();
        notifyChanged();
        return;
    }

    private boolean addHistoricalRecord(HistoricalRecord r100) {
        boolean r101 = this.mHistoricalRecords.add(r100);
        if (r101 == false) goto L5;
        this.mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsIfNeeded();
        persistHistoricalDataIfNeeded();
        sortActivitiesIfNeeded();
        notifyChanged();
    L5:
        return r101;
    }

    public Intent chooseActivity(int r100) {
        Object r101 = this.mInstanceLock;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L17
        return null;
    L8:
        ensureConsistentState();     // Catch: Throwable -> L17
        ActivityInfo r102 = this.mActivities.get(r100).resolveInfo.activityInfo;     // Catch: Throwable -> L17
        ComponentName r103 = new ComponentName(r102.packageName, r102.name);     // Catch: Throwable -> L17
        Intent r104 = new Intent(this.mIntent);     // Catch: Throwable -> L17
        r104.setComponent(r103);     // Catch: Throwable -> L17
        if (this.mActivityChoserModelPolicy == null) goto L14;
        Intent r105 = new Intent(r104);     // Catch: Throwable -> L17
        if (this.mActivityChoserModelPolicy.onChooseActivity(this, r105) == false) goto L14;
        monitor-exit(r101);     // Catch: Throwable -> L17
        return null;
    L14:
        addHistoricalRecord(new HistoricalRecord(r103, System.currentTimeMillis(), 1.0f));     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return r104;
    }

    public ResolveInfo getActivity(int r100) {
        Object r101 = this.mInstanceLock;
        monitor-enter(r101);
        ensureConsistentState();     // Catch: Throwable -> L7
        ResolveInfo r102 = this.mActivities.get(r100).resolveInfo;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityIndex(ResolveInfo r100) {
        Object r101 = this.mInstanceLock;
        monitor-enter(r101);
        ensureConsistentState();     // Catch: Throwable -> L14
        List<ActivityResolveInfo> r102 = this.mActivities;     // Catch: Throwable -> L14
        int r103 = r102.size();     // Catch: Throwable -> L14
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L11;
        if (r102.get(r104).resolveInfo == r100) goto L8;
        r104 = r104 + 1;     // Catch: Throwable -> L14
        goto L5
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r104;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return -1;
    L14:
        th = move-exception;
        throw th;
    }

    public void setActivitySorter(ActivitySorter r100) {
        Object r101 = this.mInstanceLock;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mActivitySorter != r100) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L8:
        this.mActivitySorter = r100;     // Catch: Throwable -> L13
        if (sortActivitiesIfNeeded() == false) goto L11;
        notifyChanged();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public void setDefaultActivity(int r100) {
        Object r101 = this.mInstanceLock;
        monitor-enter(r101);
        ensureConsistentState();     // Catch: Throwable -> L11
        ActivityResolveInfo r102 = this.mActivities.get(r100);     // Catch: Throwable -> L11
        ActivityResolveInfo r103 = this.mActivities.get(0);     // Catch: Throwable -> L11
        if (r103 == null) goto L7;
        float r104 = (r103.weight - r102.weight) + 5.0f;     // Catch: Throwable -> L11
    L8:
        ActivityInfo r105 = r102.resolveInfo.activityInfo;     // Catch: Throwable -> L11
        addHistoricalRecord(new HistoricalRecord(new ComponentName(r105.packageName, r105.name), System.currentTimeMillis(), r104));     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L7:
        r104 = 1.0f;
    L11:
        th = move-exception;
        throw th;
    }

    public void setHistoryMaxSize(int r100) {
        Object r101 = this.mInstanceLock;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mHistoryMaxSize != r100) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L8:
        this.mHistoryMaxSize = r100;     // Catch: Throwable -> L13
        pruneExcessiveHistoricalRecordsIfNeeded();     // Catch: Throwable -> L13
        if (sortActivitiesIfNeeded() == false) goto L11;
        notifyChanged();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public void setIntent(Intent r100) {
        Object r101 = this.mInstanceLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != r100) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        this.mIntent = r100;     // Catch: Throwable -> L11
        this.mReloadActivities = true;     // Catch: Throwable -> L11
        ensureConsistentState();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public void setOnChooseActivityListener(OnChooseActivityListener r100) {
        Object r101 = this.mInstanceLock;
        monitor-enter(r101);
        this.mActivityChoserModelPolicy = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ActivityChooserModel(Context r100, String r101) {
        this.mInstanceLock = new Object();
        this.mActivities = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new DefaultSorter();
        this.mHistoryMaxSize = 50;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = true;
        this.mReloadActivities = false;
        this.mContext = r100.getApplicationContext();
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        this.mHistoryFileName = r101;
        return;
    L5:
        if (r101.endsWith(HISTORY_FILE_EXTENSION) == true) goto L7;
        this.mHistoryFileName = r101.concat(HISTORY_FILE_EXTENSION);
    }

    public static ActivityChooserModel get(Context r100, String r101) {
        Object r102 = sRegistryLock;
        monitor-enter(r102);
        Map<String, ActivityChooserModel> r103 = sDataModelRegistry;     // Catch: Throwable -> L9
        ActivityChooserModel r104 = r103.get(r101);     // Catch: Throwable -> L9
        if (r104 != null) goto L7;
        r104 = new ActivityChooserModel(r100, r101);     // Catch: Throwable -> L9
        r103.put(r101, r104);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
        return r104;
    L9:
        th = move-exception;
        throw th;
    }
}
