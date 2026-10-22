package com.stepos.alphame.app.state;

import B0.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.AppData;
import com.stepos.alphame.utils.AppUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class MultiMediaState extends StateBase {
    private static final String TAG = "MultiMediaState";

    @SuppressLint({"StaticFieldLeak"})
    private static MultiMediaState mInstance;
    private Context mContext;
    private PackageManager mPackageManager;
    private HashMap<String, Long> mHistoryMap = null;
    private AudioManager mLocalAudioManager = null;
    private PowerManager mPowerManager = null;
    private AppData mAppData = null;
    private long mPlayMusicTime = 0;
    private List<String> mWorkDetail = new ArrayList();

    private MultiMediaState(Context context) {
        this.mContext = context;
        initVariable();
    }

    public static synchronized MultiMediaState getInstance(Context context) {
        try {
            if (mInstance == null) {
                mInstance = new MultiMediaState(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private void initVariable() {
        this.mHistoryMap = new HashMap<>();
        this.mPackageManager = this.mContext.getPackageManager();
        this.mLocalAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mAppData = AppData.getInstance(this.mContext);
    }

    private boolean isMuiscTypeApp(String str) {
        return this.mAppData.isMusicTypeApp(str);
    }

    private boolean isPlayMusic() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z4 = jElapsedRealtime - this.mPlayMusicTime < 25000;
        if (StateBase.DEBUG) {
            StringBuilder sbE = AbstractC0831a.e("isPlayMusic currentTime = ", jElapsedRealtime, " mPlayMusicTime = ");
            sbE.append(this.mPlayMusicTime);
            sbE.append(" isMusic = ");
            sbE.append(z4);
            Log.d(TAG, sbE.toString());
        }
        return z4;
    }

    private boolean isPluggedHeadPhone() {
        AudioManager audioManager = this.mLocalAudioManager;
        if (audioManager != null) {
            return audioManager.isWiredHeadsetOn();
        }
        return true;
    }

    public boolean getMultiMediaState(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (StateBase.DEBUG) {
            Log.d(TAG, "getMutilMediaState packageName = " + str + " currentTime = " + jElapsedRealtime);
        }
        if (this.mHistoryMap.containsKey(str)) {
            long jLongValue = this.mHistoryMap.get(str).longValue();
            if (StateBase.DEBUG) {
                StringBuilder sb = new StringBuilder("mHistoryMap contains package ");
                sb.append(str);
                sb.append(" musicTime = ");
                sb.append(jLongValue);
                sb.append(" isMusic = ");
                sb.append(jElapsedRealtime - jLongValue < 25000);
                Log.d(TAG, sb.toString());
            }
            if (jElapsedRealtime - jLongValue < 25000) {
                return true;
            }
            this.mHistoryMap.remove(str);
        }
        return false;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int getState(String str) {
        return getMultiMediaState(str) ? 2 : 0;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public List<String> getWorkDetail() {
        return this.mWorkDetail;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public List<String> getWorkList() {
        ArrayList arrayList = new ArrayList();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mWorkDetail.clear();
        for (String str : this.mHistoryMap.keySet()) {
            if (jElapsedRealtime - this.mHistoryMap.get(str).longValue() <= 25000) {
                arrayList.add(str);
                List<String> list = this.mWorkDetail;
                StringBuilder sbV = g.v(str, "#");
                sbV.append(String.valueOf(2));
                list.add(sbV.toString());
            }
        }
        return arrayList;
    }

    public boolean isInteractive() {
        return AppUtils.isInteractive(this.mPowerManager);
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int isWorking(long j4) {
        return isPlayMusic() ? 2 : 0;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void pause() {
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void run() {
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void startCheck(List<String> list) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            boolean zIsPluggedHeadPhone = isPluggedHeadPhone();
            isInteractive();
            List<String> musicPlayingList = AppUtils.getMusicPlayingList(list, this.mPackageManager, this.mAppData);
            Iterator<String> it = musicPlayingList.iterator();
            while (it.hasNext()) {
                this.mHistoryMap.put(it.next(), Long.valueOf(jElapsedRealtime));
                this.mPlayMusicTime = jElapsedRealtime;
            }
            if (StateBase.DEBUG) {
                Log.d(TAG, "startCheck musicList = " + musicPlayingList.toString() + " currentTime = " + jElapsedRealtime + " isMusicPlaying = true  isPluggedHeadPhone = " + zIsPluggedHeadPhone + " isInteractive = " + isInteractive());
            }
            list.removeAll(musicPlayingList);
            if (StateBase.DEBUG) {
                Log.d(TAG, "startCheck  otherList = " + list.toString() + " currentTime = " + jElapsedRealtime + " isMusicPlaying = false  isPluggedHeadPhone = " + zIsPluggedHeadPhone + " isInteractive = " + isInteractive());
            }
        } catch (Exception e4) {
            AbstractC0351g.B("startCheck exception: ", e4, TAG);
        }
    }
}
