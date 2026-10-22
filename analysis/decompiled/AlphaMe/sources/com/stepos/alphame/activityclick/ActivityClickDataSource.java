package com.stepos.alphame.activityclick;

import B0.g;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.app.AppEventDataItem;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.utils.PrimaryUtils;
import com.stepos.alphame.utils.Utils;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import java.util.HashSet;

/* loaded from: classes.dex */
public class ActivityClickDataSource extends DataSource {
    private static final byte[] ARGS_TYPE = {6, 6, 4, 4};
    private b mEventReceiver;
    private int mSize;
    private final HashSet<String> mSkipPkgs;

    public ActivityClickDataSource(String str) {
        super(str);
        this.mSize = 0;
        this.mSkipPkgs = new HashSet<>();
        this.mEventReceiver = new b("APP_EVENT") { // from class: com.stepos.alphame.activityclick.ActivityClickDataSource.1
            private String mForegroundActivity = "";

            @Override // com.stepos.common.alphame.b
            public void onReceiver(String str2, Object obj) throws NumberFormatException {
                if (obj != null) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length == 4) {
                        String str3 = strArr[0];
                        String str4 = strArr[1];
                        if (!"resume".equals(str4)) {
                            if (AppEventDataItem.APP_HOME.equals(str4)) {
                                ActivityClickDataSource.this.setSkipPkgs(str3);
                                return;
                            }
                            return;
                        }
                        String str5 = strArr[2];
                        if (this.mForegroundActivity.equals(str5)) {
                            return;
                        }
                        if (!ActivityClickDataSource.this.mSkipPkgs.contains(str3)) {
                            int i4 = Integer.parseInt(strArr[3]);
                            int currentMode = PrimaryUtils.getCurrentMode();
                            if (Utils.DEBUG.get()) {
                                StringBuilder sbX = g.x("ActivityClickDataSource:", str5, AwarenessDataItem.PERMISSION_SPLITTER, str3, AwarenessDataItem.PERMISSION_SPLITTER);
                                sbX.append(i4);
                                sbX.append(AwarenessDataItem.PERMISSION_SPLITTER);
                                sbX.append(currentMode);
                                Log.d("AlphaMe", sbX.toString());
                            }
                            ActivityClickDataItem activityClickDataItem = (ActivityClickDataItem) ActivityClickDataSource.this.itemCache().pop();
                            activityClickDataItem.fill(str3, str5, currentMode, i4);
                            ActivityClickDataSource.this.collect(activityClickDataItem);
                        }
                        this.mForegroundActivity = str5;
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collect(DataItem dataItem) {
        synchronized (this.mSyncObject) {
            try {
                ActivityClickDataItem activityClickDataItem = (ActivityClickDataItem) dataItem;
                if (TextUtils.isEmpty(activityClickDataItem.getActivityName())) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i4 = 0;
                while (true) {
                    if (i4 >= this.mHistory.size()) {
                        activityClickDataItem.setClickCount("1,0,0,0,0,0,0,");
                        activityClickDataItem.setTotalClickCount(1L);
                        activityClickDataItem.setLastClickTime(Long.valueOf(jCurrentTimeMillis));
                        this.mHistory.add(activityClickDataItem);
                        break;
                    }
                    ActivityClickDataItem activityClickDataItem2 = (ActivityClickDataItem) this.mHistory.get(i4);
                    if (activityClickDataItem.getActivityName().equals(activityClickDataItem2.getActivityName()) && activityClickDataItem.getCurrentMode() == activityClickDataItem2.getCurrentMode() && activityClickDataItem.getCloneId() == activityClickDataItem2.getCloneId()) {
                        if (Utils.DEBUG.get()) {
                            Log.d("AlphaMe", "history.getClickCount():" + activityClickDataItem2.getClickCount());
                        }
                        String[] strArrSplitText = Utils.ClickUtils.splitText(activityClickDataItem2.getClickCount());
                        int dayOffset = Utils.ClickUtils.getDayOffset(jCurrentTimeMillis, activityClickDataItem2.getLastClickTime().longValue());
                        if (dayOffset <= 0) {
                            strArrSplitText[0] = String.valueOf(Integer.parseInt(strArrSplitText[0]) + 1);
                        } else {
                            String[] strArr = new String[7];
                            strArr[0] = "1";
                            for (int i5 = 1; i5 < Math.min(dayOffset, 7); i5++) {
                                strArr[i5] = "0";
                            }
                            for (int i6 = dayOffset; i6 < 7; i6++) {
                                strArr[i6] = strArrSplitText[i6 - dayOffset];
                            }
                            strArrSplitText = strArr;
                        }
                        String strJoinText = Utils.ClickUtils.joinText(strArrSplitText);
                        int totalClicks = Utils.ClickUtils.getTotalClicks(strArrSplitText);
                        activityClickDataItem2.setClickCount(strJoinText);
                        activityClickDataItem2.setTotalClickCount(Long.valueOf(totalClicks));
                        activityClickDataItem2.setLastClickTime(Long.valueOf(jCurrentTimeMillis));
                    } else {
                        i4++;
                    }
                }
                int i7 = this.mSize + 1;
                this.mSize = i7;
                if (i7 >= 10) {
                    store();
                    this.mSize = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkipPkgs(String str) {
        this.mSkipPkgs.clear();
        if (str != null) {
            this.mSkipPkgs.add(str);
        } else {
            this.mSkipPkgs.add("com.android.launcher3");
        }
    }

    @Override // com.stepos.alphame.data.DataSource
    public Storable createStorable() {
        return new ActivityClickStorable();
    }

    @Override // com.stepos.alphame.data.DataSource
    public Class<? extends DataItem> getDataItemClass() {
        return ActivityClickDataItem.class;
    }

    @Override // com.stepos.alphame.data.DataSource
    public byte[] getFillArgsType() {
        return ARGS_TYPE;
    }

    @Override // com.stepos.alphame.data.DataSource
    public void onStart() {
        super.onStart();
        c.f11224a.f(this.mEventReceiver);
        setSkipPkgs(null);
    }

    @Override // com.stepos.alphame.data.DataSource
    public void onStop() {
        super.onStop();
        c.f11224a.g(this.mEventReceiver);
    }

    @Override // com.stepos.alphame.data.DataSource
    public void process(DataItem dataItem) {
    }
}
