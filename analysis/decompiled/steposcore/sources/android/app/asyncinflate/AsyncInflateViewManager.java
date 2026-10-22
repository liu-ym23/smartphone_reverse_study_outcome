package android.app.asyncinflate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Trace;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Slog;
import android.util.SparseArray;
import android.util.StepOSDateTimeUrlHelper;
import android.util.Xml;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class AsyncInflateViewManager {
    private static final boolean IS_DEBUG = AsyncInflateControl.isDebug();
    private static final int MSG_DESTROY = 4;
    private static final int MSG_FINISHED = 2;
    private static final int MSG_INIT = 3;
    private static final int MSG_RECORD_ID = 6;
    private static final int MSG_SET_ACTIVITY_NAME = 1;
    private static final int MSG_SET_THEME = 5;
    private static final String PREINFLATE = "preInflate";
    private static final String TAG_MERGE = "merge";
    private static final int THEME_UNSET = -1;
    private static final int UI_CHANGE_UNCHECKED = 255;
    private static final int UI_MODE_INVALID = -1;
    private static volatile AsyncInflateViewManager sInstance;
    private volatile String mActivityName;
    private Context mAppContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private String mPkg;
    private AsyncInflate mPreInflate;
    private int mUiMode;
    private volatile AtomicBoolean mBootComplete = new AtomicBoolean(false);
    public final Object mLock = new Object();
    private int mUiChange = 255;
    private int mTheme = -1;
    private final int MAX_ACTIVITY_NUM = AsyncInflateControl.getMaxActivityNum();
    private final ArrayMap<String, AsyncInflate> mAsyncInflate = new ArrayMap<>();

    public static AsyncInflateViewManager getInstance(Context appContext) {
        if (sInstance == null) {
            synchronized (AsyncInflateViewManager.class) {
                if (sInstance == null) {
                    sInstance = new AsyncInflateViewManager(appContext);
                }
            }
        }
        return sInstance;
    }

    private AsyncInflateViewManager(Context appContext) {
        Trace.traceBegin(8L, "AsyncInflateViewManager#constructor");
        this.mHandlerThread = new HandlerThread(AsyncInflateControl.ASYNC_INFLATE_TAG, -10);
        this.mHandlerThread.start();
        this.mHandler = new AsyncInflateViewManagerHandler(this.mHandlerThread.getLooper());
        this.mAppContext = appContext;
        this.mUiMode = appContext.getResources().getConfiguration().uiMode;
        this.mPkg = appContext.getPackageName();
        Message msg = this.mHandler.obtainMessage(3);
        msg.sendToTarget();
        Trace.traceEnd(8L);
    }

    public void recordId(int id) {
        if (this.mBootComplete.get()) {
            return;
        }
        Message msg = this.mHandler.obtainMessage(6);
        msg.arg1 = id;
        msg.sendToTarget();
    }

    public View findView(Context activityContext, XmlResourceParser parser, int id, ViewGroup root, boolean attachToRoot) {
        int type;
        if (this.mBootComplete.get()) {
            return null;
        }
        View v = null;
        if (this.mUiMode == -1) {
            return null;
        }
        int currentUiMode = activityContext.getResources().getConfiguration().uiMode;
        if (currentUiMode == this.mUiMode) {
            Trace.traceBegin(8L, "AsyncInflateViewManager#findView: " + id);
            synchronized (this.mLock) {
                if (this.mPreInflate != null && this.mPreInflate.mActivityName != null && this.mPreInflate.mActivityName.equals(this.mActivityName) && this.mPreInflate.mIsPreInflate.get()) {
                    v = this.mPreInflate.findView(id);
                }
            }
            if (root != null && v != null) {
                AttributeSet attrs = Xml.asAttributeSet(parser);
                do {
                    try {
                        type = parser.next();
                        if (type == 2) {
                            break;
                        }
                    } catch (XmlPullParserException e) {
                        Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "XmlPullParserException： " + e);
                    } catch (Exception e2) {
                        Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "Exception： " + e2);
                    }
                } while (type != 1);
                if (type != 2) {
                    throw new InflateException(parser.getPositionDescription() + ": No start tag found!");
                }
                String name = parser.getName();
                if (TAG_MERGE.equals(name)) {
                    Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "merge, just return v");
                } else {
                    Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "name: " + name);
                    if (!"RecyclerView".equals(name) && !name.endsWith(".RecyclerView")) {
                        ViewGroup.LayoutParams params = root.generateLayoutParams(attrs);
                        if (attachToRoot) {
                            root.addView(v, params);
                        } else {
                            v.setLayoutParams(params);
                        }
                    }
                    Trace.traceEnd(8L);
                    return null;
                }
            }
            Trace.traceEnd(8L);
            return v;
        }
        this.mUiChange = -1;
        if (IS_DEBUG) {
            Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManager#findView: ui change, clear");
        }
        if (this.mPreInflate != null) {
            this.mPreInflate.clear();
        }
        return null;
    }

    public void setActivityName(String activityName, Context activityContext) {
        if (this.mBootComplete.get()) {
            if (IS_DEBUG) {
                Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "setActivityName: Boot Complete, return");
            }
        } else {
            if (IS_DEBUG) {
                Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManager#setActivityName: " + activityName);
            }
            this.mActivityName = activityName;
            Message msg = this.mHandler.obtainMessage(1, new Object[]{activityName, activityContext});
            msg.sendToTarget();
        }
    }

    public void setTheme(int theme) {
        if (this.mBootComplete.get()) {
            if (IS_DEBUG) {
                Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "setTheme: Boot Complete, return");
                return;
            }
            return;
        }
        if (IS_DEBUG) {
            Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManager#setTheme: " + theme);
        }
        synchronized (this.mLock) {
            this.mTheme = theme;
        }
        Message msg = this.mHandler.obtainMessage(5);
        msg.arg1 = theme;
        msg.sendToTarget();
    }

    public void finished(String activityName) {
        if (this.mBootComplete.get()) {
            if (IS_DEBUG) {
                Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "finished: Boot Complete, return");
            }
        } else {
            if (IS_DEBUG) {
                Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManager#finished: " + activityName);
            }
            this.mActivityName = activityName;
            Message msg = this.mHandler.obtainMessage(2, activityName);
            msg.sendToTarget();
        }
    }

    public void destroy(String activityName) {
        this.mActivityName = activityName;
        Message msg = this.mHandler.obtainMessage(4, activityName);
        msg.sendToTarget();
    }

    public void notifyDoFrame() {
        if (!this.mBootComplete.get()) {
            Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "Boot Completed: " + this.mPkg);
            this.mBootComplete.set(true);
        }
    }

    public boolean shouldHook() {
        return !this.mBootComplete.get();
    }

    private final class AsyncInflateViewManagerHandler extends Handler {
        public AsyncInflateViewManagerHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            AsyncInflate localAsyncInflate;
            AsyncInflate localAsyncInflate2;
            AsyncInflate localAsyncInflate3;
            AsyncInflate localAsyncInflate4;
            AsyncInflate localAsyncInflate5;
            switch (msg.what) {
                case 1:
                    if (AsyncInflateViewManager.IS_DEBUG) {
                        Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManagerHandler#handleMessage: MSG_SET_ACTIVITY_NAME");
                    }
                    Object[] params = (Object[]) msg.obj;
                    String activityName = (String) params[0];
                    Context activityContext = (Context) params[1];
                    synchronized (AsyncInflateViewManager.this.mLock) {
                        localAsyncInflate = (AsyncInflate) AsyncInflateViewManager.this.mAsyncInflate.get(AsyncInflateViewManager.PREINFLATE);
                    }
                    if (localAsyncInflate != null) {
                        localAsyncInflate.setPreInflate(activityName, activityContext);
                        return;
                    }
                    return;
                case 2:
                    if (AsyncInflateViewManager.IS_DEBUG) {
                        Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManagerHandler#handleMessage: MSG_FINISHED");
                    }
                    String activityName2 = (String) msg.obj;
                    synchronized (AsyncInflateViewManager.this.mLock) {
                        localAsyncInflate2 = (AsyncInflate) AsyncInflateViewManager.this.mAsyncInflate.get(AsyncInflateViewManager.PREINFLATE);
                    }
                    if (localAsyncInflate2 != null) {
                        localAsyncInflate2.finished(activityName2);
                        return;
                    }
                    return;
                case 3:
                    if (AsyncInflateViewManager.IS_DEBUG) {
                        Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManagerHandler#handleMessage: MSG_INIT");
                    }
                    synchronized (AsyncInflateViewManager.this.mLock) {
                        AsyncInflateViewManager.this.mPreInflate = new AsyncInflate(AsyncInflateViewManager.this, AsyncInflateViewManager.this.mAppContext);
                        AsyncInflateViewManager.this.mAsyncInflate.put(AsyncInflateViewManager.PREINFLATE, AsyncInflateViewManager.this.mPreInflate);
                    }
                    return;
                case 4:
                    if (AsyncInflateViewManager.IS_DEBUG) {
                        Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManagerHandler#handleMessage: MSG_DESTROY");
                    }
                    String activityName3 = (String) msg.obj;
                    synchronized (AsyncInflateViewManager.this.mLock) {
                        localAsyncInflate3 = (AsyncInflate) AsyncInflateViewManager.this.mAsyncInflate.get(AsyncInflateViewManager.PREINFLATE);
                    }
                    if (localAsyncInflate3 != null) {
                        localAsyncInflate3.destroy(activityName3);
                        return;
                    }
                    return;
                case 5:
                    if (AsyncInflateViewManager.IS_DEBUG) {
                        Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManagerHandler#handleMessage: MSG_SET_THEME");
                    }
                    int theme = msg.arg1;
                    synchronized (AsyncInflateViewManager.this.mLock) {
                        localAsyncInflate4 = (AsyncInflate) AsyncInflateViewManager.this.mAsyncInflate.get(AsyncInflateViewManager.PREINFLATE);
                    }
                    if (localAsyncInflate4 != null) {
                        localAsyncInflate4.setTheme(theme);
                        return;
                    }
                    return;
                case 6:
                    if (AsyncInflateViewManager.IS_DEBUG) {
                        Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflateViewManagerHandler#handleMessage: MSG_RECORD_ID");
                    }
                    int id = msg.arg1;
                    synchronized (AsyncInflateViewManager.this.mLock) {
                        localAsyncInflate5 = (AsyncInflate) AsyncInflateViewManager.this.mAsyncInflate.get(AsyncInflateViewManager.PREINFLATE);
                    }
                    if (localAsyncInflate5 != null) {
                        localAsyncInflate5.recordId(id);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private class AsyncInflate {
        private static final String ACTIVITY = "activity";
        private static final String SP_SHEET = "async_sp";
        private static final String THEME = "theme";
        private final int MAX_RES_NUM;
        private Context mActivityContext;
        private String mActivityName;
        private Context mAppContext;
        private String mCurrentActivityName;
        private int mCurrentTheme;
        private LayoutInflater mInflater;
        private int mInflatingId;
        public AtomicBoolean mIsPreInflate;
        private boolean mIsfinished;
        private Map<String, ?> mMap;
        private long mStartTime;
        private String mTempResId;
        private int mTheme;
        private long mTotalTime;
        private final SparseArray<ViewInfo> mViewInfo;
        private final SparseArray<ViewState> mViewStateMap;

        private enum ViewState {
            ERROR,
            LOADING,
            FINISHED
        }

        public AsyncInflate(AsyncInflateViewManager asyncInflateViewManager, Context appContext) {
            this(null, appContext);
        }

        public AsyncInflate(String activityName, Context appContext) throws Throwable {
            this.mIsPreInflate = new AtomicBoolean(false);
            this.mInflatingId = 0;
            this.mTheme = -1;
            this.mCurrentTheme = -1;
            this.mStartTime = 0L;
            this.mTotalTime = 0L;
            this.MAX_RES_NUM = AsyncInflateControl.getMaxResNum();
            this.mViewStateMap = new SparseArray<>(this.MAX_RES_NUM);
            this.mViewInfo = new SparseArray<>(this.MAX_RES_NUM);
            this.mActivityName = activityName;
            this.mAppContext = appContext;
            init();
        }

        private void init() throws Throwable {
            try {
                SharedPreferences sp = this.mAppContext.getSharedPreferences(SP_SHEET, 0);
                this.mMap = sp.getAll();
            } catch (IllegalStateException e) {
                Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "getAll IllegalStateException: " + e);
            } catch (NullPointerException e2) {
                Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "getAll NullPointerException: " + e2);
            }
            if (this.mMap == null) {
                Slog.i(AsyncInflateControl.ASYNC_INFLATE_TAG, "init: getSharedPreferences is null.");
                return;
            }
            if (this.mActivityName == null) {
                if (AsyncInflateViewManager.IS_DEBUG) {
                    Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflate#init: mActivityName is null.");
                }
                synchronized (AsyncInflateViewManager.this.mLock) {
                    this.mActivityName = (String) this.mMap.get(ACTIVITY);
                    if (this.mActivityName != null) {
                        this.mIsPreInflate.set(true);
                    }
                }
            }
            String key = THEME + this.mActivityName;
            String theme = (String) this.mMap.get(key);
            if (!TextUtils.isEmpty(theme)) {
                try {
                    synchronized (AsyncInflateViewManager.this.mLock) {
                        this.mTheme = Integer.parseInt(theme);
                    }
                    this.mAppContext.setTheme(this.mTheme);
                } catch (NumberFormatException e3) {
                    Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "NumberFormatException: " + e3);
                }
            }
            String resId = getResId(this.mActivityName);
            inflate(resId);
        }

        private void inflate(String id) throws Throwable {
            View retView;
            Throwable th;
            RuntimeException e;
            StringBuilder sb;
            String successResId;
            if (AsyncInflateViewManager.IS_DEBUG) {
                Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "inflate id: " + id);
            }
            View retView2 = null;
            String errorResId = null;
            String successResId2 = null;
            if (TextUtils.isEmpty(id)) {
                if (AsyncInflateViewManager.IS_DEBUG) {
                    Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflate#inflate: id is empty, return");
                    return;
                }
                return;
            }
            String[] resourceArray = id.split(StepOSDateTimeUrlHelper.COMMA_STRING);
            if (resourceArray.length == 0) {
                if (AsyncInflateViewManager.IS_DEBUG) {
                    Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflate#inflate: resourceArray is empty, return");
                    return;
                }
                return;
            }
            if (this.mInflater == null) {
                if (this.mActivityContext != null) {
                    this.mInflater = LayoutInflater.from(this.mActivityContext);
                } else {
                    this.mInflater = LayoutInflater.from(this.mAppContext);
                }
            }
            Trace.traceBegin(8L, "AsyncInflate#inflate: " + id);
            for (int i = 0; i < resourceArray.length && i < this.MAX_RES_NUM; i++) {
                String tmpResId = resourceArray[i];
                if (tmpResId == null || tmpResId.isEmpty()) {
                    this.mInflatingId = 0;
                } else {
                    int resId = Integer.parseInt(tmpResId);
                    synchronized (AsyncInflateViewManager.this.mLock) {
                        if (!this.mViewInfo.contains(resId)) {
                            this.mViewStateMap.put(resId, ViewState.LOADING);
                            this.mInflatingId = resId;
                            this.mStartTime = System.currentTimeMillis();
                            try {
                                retView = this.mInflater.mStepOSExt.steposInflate(this.mInflatingId);
                                if (retView != null) {
                                    try {
                                        try {
                                            boolean isViewStub = retView instanceof ViewStub;
                                            addView(resId, retView, isViewStub);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (retView == null) {
                                                String errorResId2 = TextUtils.isEmpty(errorResId) ? tmpResId : errorResId + StepOSDateTimeUrlHelper.COMMA_STRING + tmpResId;
                                                synchronized (AsyncInflateViewManager.this.mLock) {
                                                    this.mViewStateMap.put(resId, ViewState.ERROR);
                                                }
                                            } else if (!TextUtils.isEmpty(successResId2)) {
                                                String str = successResId2 + StepOSDateTimeUrlHelper.COMMA_STRING + tmpResId;
                                            }
                                            throw th;
                                        }
                                    } catch (RuntimeException e2) {
                                        e = e2;
                                        Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "Failed to inflate resource in the background! id:" + resId + " " + e.toString());
                                        if (retView != null) {
                                            if (!TextUtils.isEmpty(successResId2)) {
                                                sb = new StringBuilder();
                                                successResId = sb.append(successResId2).append(StepOSDateTimeUrlHelper.COMMA_STRING).append(tmpResId).toString();
                                                successResId2 = successResId;
                                                retView2 = null;
                                            }
                                            successResId = tmpResId;
                                            successResId2 = successResId;
                                            retView2 = null;
                                        } else {
                                            String errorResId3 = TextUtils.isEmpty(errorResId) ? tmpResId : errorResId + StepOSDateTimeUrlHelper.COMMA_STRING + tmpResId;
                                            synchronized (AsyncInflateViewManager.this.mLock) {
                                                this.mViewStateMap.put(resId, ViewState.ERROR);
                                            }
                                            errorResId = errorResId3;
                                            retView2 = retView;
                                        }
                                    }
                                }
                            } catch (RuntimeException e3) {
                                retView = retView2;
                                e = e3;
                            } catch (Throwable th3) {
                                retView = retView2;
                                th = th3;
                            }
                            if (retView != null) {
                                if (!TextUtils.isEmpty(successResId2)) {
                                    sb = new StringBuilder();
                                    successResId = sb.append(successResId2).append(StepOSDateTimeUrlHelper.COMMA_STRING).append(tmpResId).toString();
                                    successResId2 = successResId;
                                    retView2 = null;
                                }
                                successResId = tmpResId;
                                successResId2 = successResId;
                                retView2 = null;
                            } else {
                                String errorResId4 = TextUtils.isEmpty(errorResId) ? tmpResId : errorResId + StepOSDateTimeUrlHelper.COMMA_STRING + tmpResId;
                                synchronized (AsyncInflateViewManager.this.mLock) {
                                    this.mViewStateMap.put(resId, ViewState.ERROR);
                                }
                                retView2 = retView;
                                errorResId = errorResId4;
                            }
                        }
                    }
                }
            }
            this.mInflatingId = 0;
            Trace.traceEnd(8L);
        }

        private void addView(int resId, View view, boolean isViewStub) {
            synchronized (AsyncInflateViewManager.this.mLock) {
                if (view != null) {
                    long time = System.currentTimeMillis() - this.mStartTime;
                    ViewInfo viewInfo = new ViewInfo(resId, false);
                    viewInfo.view = view;
                    viewInfo.isViewStub = isViewStub;
                    viewInfo.durTime = time;
                    this.mViewInfo.put(resId, viewInfo);
                    this.mViewStateMap.put(resId, ViewState.FINISHED);
                    AsyncInflateViewManager.this.mLock.notifyAll();
                    if (AsyncInflateViewManager.IS_DEBUG) {
                        Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflate#inflate: addView: " + resId + "success");
                    }
                } else if (AsyncInflateViewManager.IS_DEBUG) {
                    Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflate#inflate: addView: " + resId + " failed");
                }
            }
        }

        private String getResId(String activityName) {
            if (this.mMap == null) {
                return null;
            }
            return (String) this.mMap.get(activityName);
        }

        public void setPreInflate(String activityName, Context activityContext) {
            synchronized (AsyncInflateViewManager.this.mLock) {
                this.mCurrentActivityName = activityName;
                this.mActivityContext = activityContext;
            }
            setValue(this.mAppContext, SP_SHEET, ACTIVITY, activityName);
        }

        public void recordId(int id) {
            if (AsyncInflateViewManager.IS_DEBUG) {
                Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "recordId: " + id);
            }
            String temp = String.valueOf(id);
            if (TextUtils.isEmpty(this.mTempResId)) {
                this.mTempResId = temp;
            } else {
                this.mTempResId += StepOSDateTimeUrlHelper.COMMA_STRING + temp;
            }
        }

        public void setTheme(int theme) {
            String targetActivityName;
            synchronized (AsyncInflateViewManager.this.mLock) {
                this.mCurrentTheme = theme;
                targetActivityName = !TextUtils.isEmpty(this.mCurrentActivityName) ? this.mCurrentActivityName : this.mActivityName;
            }
            if (theme != this.mTheme && !TextUtils.isEmpty(targetActivityName)) {
                String key = THEME + targetActivityName;
                setValue(this.mAppContext, SP_SHEET, key, String.valueOf(theme));
            }
        }

        public void finished(String activityName) {
            String targetActivityName;
            AsyncInflate localPreInflate;
            int[] ids;
            long[] durTimes;
            Trace.traceBegin(8L, "AsyncInflate#finished");
            if (AsyncInflateViewManager.IS_DEBUG) {
                Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "finished: " + activityName);
            }
            synchronized (AsyncInflateViewManager.this.mLock) {
                targetActivityName = !TextUtils.isEmpty(this.mCurrentActivityName) ? this.mCurrentActivityName : this.mActivityName;
            }
            if (TextUtils.equals(activityName, targetActivityName)) {
                synchronized (AsyncInflateViewManager.this.mLock) {
                    this.mIsfinished = true;
                }
                if (this.mTotalTime > 0) {
                    Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "pkg " + AsyncInflateViewManager.this.mPkg + " activity " + targetActivityName + " time " + this.mTotalTime);
                } else {
                    synchronized (AsyncInflateViewManager.this.mLock) {
                        localPreInflate = AsyncInflateViewManager.this.mPreInflate;
                    }
                    if (localPreInflate != null && TextUtils.equals(this.mActivityName, localPreInflate.mActivityName) && localPreInflate.mIsPreInflate.get()) {
                        this.mTotalTime = localPreInflate.mTotalTime;
                        if (this.mTotalTime > 0) {
                            Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "pkg " + AsyncInflateViewManager.this.mPkg + " activity " + targetActivityName + " time " + this.mTotalTime);
                        }
                    }
                }
                setValue(this.mAppContext, SP_SHEET, activityName, this.mTempResId);
                synchronized (AsyncInflateViewManager.this.mLock) {
                    int size = this.mViewInfo.size();
                    ids = new int[size];
                    durTimes = new long[size];
                    for (int i = 0; i < size; i++) {
                        ViewInfo viewInfo = this.mViewInfo.valueAt(i);
                        if (viewInfo != null) {
                            ids[i] = viewInfo.id;
                            durTimes[i] = viewInfo.durTime;
                        }
                    }
                }
                setBatchValue(this.mAppContext, SP_SHEET, ids, durTimes);
            }
            Trace.traceEnd(8L);
        }

        private void setBatchValue(Context context, String sheet, int[] keys, long[] values) {
            try {
                SharedPreferences sp = context.getSharedPreferences(sheet, 0);
                SharedPreferences.Editor editor = sp.edit();
                for (int i = 0; i < keys.length; i++) {
                    editor.putString(String.valueOf(keys[i]), String.valueOf(values[i]));
                }
                editor.apply();
            } catch (IllegalStateException e) {
                Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "IllegalStateException: " + e);
            } catch (NullPointerException e2) {
                Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "NullPointerException: " + e2);
            }
        }

        private void setValue(Context context, String sheet, String key, String value) {
            Trace.traceBegin(8L, "AsyncInflate#setValue");
            try {
                SharedPreferences sp = context.getSharedPreferences(sheet, 0);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(key, value);
                editor.apply();
            } catch (IllegalStateException e) {
                Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "IllegalStateException: " + e);
            } catch (NullPointerException e2) {
                Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "NullPointerException: " + e2);
            }
            Trace.traceEnd(8L);
        }

        public void destroy(String activityName) {
            String targetActivityName;
            synchronized (AsyncInflateViewManager.this.mLock) {
                targetActivityName = !TextUtils.isEmpty(this.mCurrentActivityName) ? this.mCurrentActivityName : this.mActivityName;
            }
            if (TextUtils.equals(activityName, targetActivityName)) {
                clear();
            }
        }

        public View findView(int id) throws InterruptedException {
            if (this.mIsfinished) {
                if (AsyncInflateViewManager.IS_DEBUG) {
                    Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflate#findView: mIsfinished, return");
                }
                return null;
            }
            if (this.mTheme != -1 && this.mCurrentTheme != -1 && this.mCurrentTheme != this.mTheme) {
                if (AsyncInflateViewManager.IS_DEBUG) {
                    Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "AsyncInflate#findView: theme changed, return");
                }
                clear();
                return null;
            }
            View realView = null;
            long waitTime = 0;
            if (this.mViewStateMap.get(id) == null || this.mViewStateMap.get(id) == ViewState.ERROR) {
                return null;
            }
            Trace.traceBegin(8L, "AsyncInflate#findView: " + id);
            for (int count = 0; count < 10 && this.mViewStateMap.get(id) == ViewState.LOADING; count++) {
                try {
                    AsyncInflateViewManager.this.mLock.wait(5L, 0);
                } catch (Exception e) {
                    Slog.e(AsyncInflateControl.ASYNC_INFLATE_TAG, "Exception: " + e);
                }
                waitTime += 5;
            }
            if (this.mViewStateMap.get(id) != ViewState.FINISHED) {
                Trace.traceEnd(8L);
                return null;
            }
            if (this.mViewInfo.contains(id)) {
                ViewInfo viewInfo = this.mViewInfo.get(id);
                if (viewInfo != null && viewInfo.id == id && !viewInfo.isUsed) {
                    viewInfo.isUsed = true;
                    realView = viewInfo.view;
                    if (viewInfo.isViewStub) {
                        ViewStub viewStub = (ViewStub) realView;
                        Context inflaterContext = this.mActivityContext != null ? this.mActivityContext : this.mAppContext;
                        viewStub.setLayoutInflater(LayoutInflater.from(inflaterContext));
                    }
                }
            } else {
                Slog.d(AsyncInflateControl.ASYNC_INFLATE_TAG, "mViewInfo not find id: " + id);
            }
            if (realView != null) {
                long time = getDurTime(id);
                this.mTotalTime = (this.mTotalTime + time) - waitTime;
            }
            Trace.traceEnd(8L);
            return realView;
        }

        private long getDurTime(int id) {
            ViewInfo viewInfo;
            if (this.mViewInfo.contains(id) && (viewInfo = this.mViewInfo.get(id)) != null) {
                return viewInfo.durTime;
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            synchronized (AsyncInflateViewManager.this.mLock) {
                this.mViewInfo.clear();
                this.mViewStateMap.clear();
                this.mIsPreInflate.set(false);
                this.mIsfinished = false;
                this.mActivityContext = null;
                this.mCurrentActivityName = null;
                this.mTempResId = null;
                this.mTotalTime = 0L;
                this.mStartTime = 0L;
                this.mInflatingId = 0;
                this.mCurrentTheme = -1;
            }
        }
    }

    private static final class ViewInfo {
        private long durTime;
        private int id;
        private boolean isUsed;
        private boolean isViewStub;
        private View view;

        public ViewInfo(int id, boolean isUsed) {
            this.id = id;
            this.isUsed = isUsed;
        }
    }
}
