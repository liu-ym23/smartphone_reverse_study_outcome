package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
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
    static final String LOG_TAG = "ActivityChooserModel";
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = null;
    private static final Object sRegistryLock = null;
    private final List<a> mActivities;
    private e mActivityChoserModelPolicy;
    private b mActivitySorter;
    boolean mCanReadHistoricalData;
    final Context mContext;
    private final List<d> mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ ActivityChooserModel this$0;

        public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(Object[] r1) {
            return doInBackground2(r1);
        }

        PersistHistoryAsyncTask(ActivityChooserModel r1) {
            this.this$0 = r1;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Object... r18) {
            int r4 = 0;
            List r5 = (List) ZeusTransformUtils.preCheckCast(r18[0], List.class, "com.obric.aiagent.plugin");
            String r8 = (String) ZeusTransformUtils.preCheckCast(r18[1], String.class, "com.obric.aiagent.plugin");
            FileOutputStream r9 = this.this$0.mContext.openFileOutput(r8, 0);     // Catch: FileNotFoundException -> L35
            XmlSerializer r10 = Xml.newSerializer();
            r10.setOutput(r9, null);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r10.startDocument("UTF-8", true);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r10.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            int r11 = r5.size();     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L8;
            d r13 = (d) ZeusTransformUtils.preCheckCast(r5.remove(r4), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r10.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r10.attribute(null, ActivityChooserModel.ATTRIBUTE_ACTIVITY, r13.f351a.flattenToString());     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r10.attribute(null, ActivityChooserModel.ATTRIBUTE_TIME, String.valueOf(r13.f352b));     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r10.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(r13.f353c));     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r10.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r12 = r12 + 1;     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r5 = r5;
            r4 = 0;
            goto L6
        L8:
            r10.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            r10.endDocument();     // Catch: Throwable -> L13 IOException -> L15 IllegalStateException -> L20 IllegalArgumentException -> L25
            this.this$0.mCanReadHistoricalData = true;
            if (r9 != null) goto L42;
        L30:
            return null;
        L42:
            r9.close();     // Catch: IOException -> L38
            goto L30
        L13:
            th = move-exception;
            this.this$0.mCanReadHistoricalData = true;
            if (r9 != null) goto L44;
        L34:
            throw th;
        L44:
            r9.close();     // Catch: IOException -> L39
        L15:
            e = move-exception;
            INVOKESTATIC_androidx_appcompat_widget_ActivityChooserModel$PersistHistoryAsyncTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L13
            this.this$0.mCanReadHistoricalData = true;
            if (r9 == null) goto L30;
        L25:
            e = move-exception;
            INVOKESTATIC_androidx_appcompat_widget_ActivityChooserModel$PersistHistoryAsyncTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L13
            this.this$0.mCanReadHistoricalData = true;
            if (r9 == null) goto L30;
        L20:
            e = move-exception;
            INVOKESTATIC_androidx_appcompat_widget_ActivityChooserModel$PersistHistoryAsyncTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + this.this$0.mHistoryFileName, e);     // Catch: Throwable -> L13
            this.this$0.mCanReadHistoricalData = true;
            if (r9 == null) goto L30;
        L35:
            e = move-exception;
            INVOKESTATIC_androidx_appcompat_widget_ActivityChooserModel$PersistHistoryAsyncTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + r8, e);
            return null;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_androidx_appcompat_widget_ActivityChooserModel$PersistHistoryAsyncTask_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public static final class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResolveInfo f348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f349b;

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(a r3) {
            return a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
        }

        public a(ResolveInfo r1) {
            this.f348a = r1;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f349b) + 31;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (getClass() == r5.getClass()) goto L11;
            return false;
        L11:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (Float.floatToIntBits(this.f349b) == Float.floatToIntBits(r6.f349b)) goto L14;
            return false;
        L14:
            return true;
        }

        public int a(a r1) {
            return Float.floatToIntBits(r1.f349b) - Float.floatToIntBits(this.f349b);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("[");
            r0.append("resolveInfo:").append(this.f348a.toString());
            r0.append("; weight:").append(new BigDecimal(this.f349b));
            r0.append("]");
            return r0.toString();
        }
    }

    public interface b {
        void a(Intent r1, List<a> r2, List<d> r3);
    }

    private static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<ComponentName, a> f350a;

        c() {
            this.f350a = new HashMap();
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.b
        public void a(Intent r7, List<a> r8, List<d> r9) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
            Map<ComponentName, a> r6 = this.f350a;
            r6.clear();
            int r12 = r10.size();
            int r1 = 0;
        L3:
            if (r1 >= r12) goto L5;
            a r2 = (a) ZeusTransformUtils.preCheckCast(r10.get(r1), a.class, "com.obric.aiagent.plugin");
            r2.f349b = 0.0f;
            r6.put(new ComponentName(r2.f348a.activityInfo.packageName, r2.f348a.activityInfo.name), r2);
            r1 = r1 + 1;
            goto L3
        L5:
            int r13 = r11.size() - 1;
            float r3 = ActivityChooserModel.DEFAULT_HISTORICAL_RECORD_WEIGHT;
        L6:
            if (r13 < 0) goto L11;
            d r4 = (d) ZeusTransformUtils.preCheckCast(r11.get(r13), d.class, "com.obric.aiagent.plugin");
            a r5 = (a) ZeusTransformUtils.preCheckCast(r6.get(r4.f351a), a.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L10;
            r5.f349b += r4.f353c * r3;
            r3 = r3 * 0.95f;
        L10:
            r13 = r13 - 1;
            goto L6
        L11:
            Collections.sort(r10);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f353c;

        public d(String r1, long r2, float r4) {
            this(ComponentName.unflattenFromString(r1), r2, r4);
        }

        public d(ComponentName r1, long r2, float r4) {
            this.f351a = r1;
            this.f352b = r2;
            this.f353c = r4;
        }

        public int hashCode() {
            ComponentName r0 = this.f351a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            long r2 = this.f352b;
            return ((((r1 + 31) * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + Float.floatToIntBits(this.f353c);
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (r7 != null) goto L9;
            return false;
        L9:
            if (getClass() == r7.getClass()) goto L11;
            return false;
        L11:
            d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.aiagent.plugin");
            ComponentName r2 = this.f351a;
            if (r2 != null) goto L17;
            if (r8.f351a == null) goto L20;
            return false;
        L20:
            if (this.f352b == r8.f352b) goto L23;
            return false;
        L23:
            if (Float.floatToIntBits(this.f353c) == Float.floatToIntBits(r8.f353c)) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r2.equals(r8.f351a) == true) goto L20;
            return false;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("[");
            r0.append("; activity:").append(this.f351a);
            r0.append("; time:").append(this.f352b);
            r0.append("; weight:").append(new BigDecimal(this.f353c));
            r0.append("]");
            return r0.toString();
        }
    }

    public interface e {
        boolean a(ActivityChooserModel r1, Intent r2);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    static {
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
    }

    public static ActivityChooserModel get(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        Object r0 = sRegistryLock;
        monitor-enter(r0);
        Map<String, ActivityChooserModel> r1 = sDataModelRegistry;     // Catch: Throwable -> L9
        ActivityChooserModel r2 = (ActivityChooserModel) ZeusTransformUtils.preCheckCast(r1.get(r6), ActivityChooserModel.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        r2 = new ActivityChooserModel(r7, r6);     // Catch: Throwable -> L9
        r1.put(r6, r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    private ActivityChooserModel(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.mInstanceLock = new Object();
        this.mActivities = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new c();
        this.mHistoryMaxSize = 50;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = true;
        this.mReloadActivities = false;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L7:
        this.mHistoryFileName = r5;
        return;
    L5:
        if (r5.endsWith(HISTORY_FILE_EXTENSION) == true) goto L7;
        this.mHistoryFileName = r5 + HISTORY_FILE_EXTENSION;
    }

    public void setIntent(Intent r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != r3) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mIntent = r3;     // Catch: Throwable -> L11
        this.mReloadActivities = true;     // Catch: Throwable -> L11
        ensureConsistentState();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public Intent getIntent() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        Intent r1 = this.mIntent;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityCount() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r1 = this.mActivities.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public ResolveInfo getActivity(int r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        ResolveInfo r2 = ((a) ZeusTransformUtils.preCheckCast(this.mActivities.get(r3), a.class, "com.obric.aiagent.plugin")).f348a;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public int getActivityIndex(ResolveInfo r7) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L14
        List<a> r6 = this.mActivities;     // Catch: Throwable -> L14
        int r1 = r6.size();     // Catch: Throwable -> L14
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L12;
        if (((a) ZeusTransformUtils.preCheckCast(r6.get(r2), a.class, "com.obric.aiagent.plugin")).f348a == r7) goto L8;
        r2 = r2 + 1;     // Catch: Throwable -> L14
        goto L5
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return -1;
    L14:
        th = move-exception;
        throw th;
    }

    public Intent chooseActivity(int r7) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mIntent != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L8:
        ensureConsistentState();     // Catch: Throwable -> L17
        a r8 = (a) ZeusTransformUtils.preCheckCast(this.mActivities.get(r7), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        ComponentName r1 = new ComponentName(r8.f348a.activityInfo.packageName, r8.f348a.activityInfo.name);     // Catch: Throwable -> L17
        Intent r9 = new Intent(this.mIntent);     // Catch: Throwable -> L17
        r9.setComponent(r1);     // Catch: Throwable -> L17
        if (this.mActivityChoserModelPolicy == null) goto L14;
        Intent r3 = new Intent(r9);     // Catch: Throwable -> L17
        if (this.mActivityChoserModelPolicy.a(this, r3) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L14:
        addHistoricalRecord(new d(r1, System.currentTimeMillis(), DEFAULT_HISTORICAL_RECORD_WEIGHT));     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r9;
    }

    public void setOnChooseActivityListener(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        this.mActivityChoserModelPolicy = r4;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ResolveInfo getDefaultActivity() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L12
        if (this.mActivities.isEmpty() == true) goto L9;
        ResolveInfo r3 = ((a) ZeusTransformUtils.preCheckCast(this.mActivities.get(0), a.class, "com.obric.aiagent.plugin")).f348a;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public void setDefaultActivity(int r6) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L11
        a r7 = (a) ZeusTransformUtils.preCheckCast(this.mActivities.get(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.mActivities.get(0), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        float r2 = (r1.f349b - r7.f349b) + 5.0f;     // Catch: Throwable -> L11
    L8:
        addHistoricalRecord(new d(new ComponentName(r7.f348a.activityInfo.packageName, r7.f348a.activityInfo.name), System.currentTimeMillis(), r2));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r2 = DEFAULT_HISTORICAL_RECORD_WEIGHT;
    L11:
        th = move-exception;
        throw th;
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

    public void setActivitySorter(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mActivitySorter != r4) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        this.mActivitySorter = r4;     // Catch: Throwable -> L13
        if (sortActivitiesIfNeeded() == false) goto L11;
        notifyChanged();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public void setHistoryMaxSize(int r3) {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mHistoryMaxSize != r3) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        this.mHistoryMaxSize = r3;     // Catch: Throwable -> L13
        pruneExcessiveHistoricalRecordsIfNeeded();     // Catch: Throwable -> L13
        if (sortActivitiesIfNeeded() == false) goto L11;
        notifyChanged();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public int getHistoryMaxSize() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        int r1 = this.mHistoryMaxSize;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getHistorySize() {
        Object r0 = this.mInstanceLock;
        monitor-enter(r0);
        ensureConsistentState();     // Catch: Throwable -> L7
        int r1 = this.mHistoricalRecords.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void ensureConsistentState() {
        boolean r0 = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (r0 == false) goto L6;
        sortActivitiesIfNeeded();
        notifyChanged();
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
        this.mActivitySorter.a(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    L16:
        return false;
    }

    private boolean loadActivitiesIfNeeded() {
        int r1 = 0;
        if (this.mReloadActivities == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mIntent == null) goto L11;
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> r0 = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int r2 = r0.size();
    L7:
        if (r1 >= r2) goto L9;
        ResolveInfo r3 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r0.get(r1), ResolveInfo.class, "com.obric.aiagent.plugin");
        this.mActivities.add(new a(r3));
        r1 = r1 + 1;
        goto L7
    L9:
        return true;
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

    private boolean addHistoricalRecord(d r2) {
        boolean r3 = this.mHistoricalRecords.add(r2);
        if (r3 == false) goto L5;
        this.mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsIfNeeded();
        persistHistoricalDataIfNeeded();
        sortActivitiesIfNeeded();
        notifyChanged();
    L5:
        return r3;
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int r0 = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (r0 > 0) goto L5;
        return;
    L5:
        this.mHistoricalRecordsChanged = true;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        d r3 = (d) ZeusTransformUtils.preCheckCast(this.mHistoricalRecords.remove(0), d.class, "com.obric.aiagent.plugin");
        r2 = r2 + 1;
        goto L6
    }

    private void readHistoricalDataImpl() {
        FileInputStream r1 = this.mContext.openFileInput(this.mHistoryFileName);     // Catch: FileNotFoundException -> L44
        XmlPullParser r2 = Xml.newPullParser();     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        r2.setInput(r1, "UTF-8");     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        int r3 = 0;
    L6:
        if (r3 == 1) goto L11;
        if (r3 == 2) goto L11;
        r3 = r2.next();     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
    L11:
        if (TAG_HISTORICAL_RECORDS.equals(r2.getName()) == false) goto L29;
        List<d> r4 = this.mHistoricalRecords;     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        r4.clear();     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
    L13:
        int r5 = r2.next();     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        if (r5 == 1) goto L15;
        if (r5 == 3) goto L13;
        if (r5 == 4) goto L13;
        if (TAG_HISTORICAL_RECORD.equals(r2.getName()) == false) goto L27;
        r4.add(new d(r2.getAttributeValue(null, ATTRIBUTE_ACTIVITY), Long.parseLong(r2.getAttributeValue(null, ATTRIBUTE_TIME)), Float.parseFloat(r2.getAttributeValue(null, ATTRIBUTE_WEIGHT))));     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
        goto L13
    L27:
        throw new XmlPullParserException("Share records file not well-formed.");     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
    L15:
        if (r1 != null) goto L50;
        return;
    L50:
        r1.close();     // Catch: IOException -> L45
        return;
    L67:
        return;
    L29:
        throw new XmlPullParserException("Share records file does not start with historical-records tag.");     // Catch: Throwable -> L30 IOException -> L32 XmlPullParserException -> L36
    L30:
        th = move-exception;
        if (r1 != null) goto L47;
    L43:
        throw th;
    L47:
        r1.close();     // Catch: IOException -> L46
    L32:
        e = move-exception;
        INVOKESTATIC_androidx_appcompat_widget_ActivityChooserModel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e);     // Catch: Throwable -> L30
        if (r1 != null) goto L50;
        return;
    L36:
        e = move-exception;
        INVOKESTATIC_androidx_appcompat_widget_ActivityChooserModel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e);     // Catch: Throwable -> L30
        if (r1 != null) goto L50;
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_appcompat_widget_ActivityChooserModel_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
