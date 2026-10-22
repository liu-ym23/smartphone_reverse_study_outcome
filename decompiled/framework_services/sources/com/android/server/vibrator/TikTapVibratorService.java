package com.android.server.vibrator;

import android.content.Context;
import android.hardware.vibrator.IVibrator;
import android.os.Binder;
import android.os.CombinedVibration;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.ServiceManager;
import android.os.TikTapVibrationEffect;
import android.os.VibrationEffect;
import android.telephony.TelephonyManager;
import android.util.Slog;
import com.android.server.autofill.HintsHelper;
import vendor.awinic.hardware.tiktap.vibrator.ITiktapCallback;
import vendor.awinic.hardware.tiktap.vibrator.ITiktapVibrator;

/* JADX INFO: loaded from: classes3.dex */
public class TikTapVibratorService {
    private static final boolean DEBUG = true;
    private static final String TAG = "TikTapVibratorService";
    static SenderId mCurrentSenderId;
    private final int SDK_HAL_NEW_FORMAT_DATA_VERSION;
    private ITiktapCallback mCallback;
    private VibHalDeathRecipient mHalDeathLinker;
    private boolean mSupportTikTap;
    private ParcelFileDescriptor rtpFD;
    private volatile ITiktapVibrator sTiktapVibratorService;

    static class SenderId {
        int mPid;
        int mSeq;

        SenderId(int pid, int seq) {
            this.mPid = pid;
            this.mSeq = seq;
        }

        void setPid(int pid) {
            this.mPid = pid;
        }

        int getPid() {
            return this.mPid;
        }

        void setSeq(int seq) {
            this.mSeq = seq;
        }

        int getSeq() {
            return this.mSeq;
        }

        void reset() {
            this.mPid = 0;
            this.mSeq = 0;
        }
    }

    private static final class VibHalDeathRecipient implements IBinder.DeathRecipient {
        TikTapVibratorService mTikTapService;

        VibHalDeathRecipient(TikTapVibratorService tiktapService) {
            this.mTikTapService = tiktapService;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.d(TikTapVibratorService.TAG, "vibrator hal died,should reset hal proxy!!");
            monitor-enter(VibHalDeathRecipient.class);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mTikTapService == null) goto L9;
            Slog.d(TikTapVibratorService.TAG, "vibrator hal reset hal proxy");     // Catch: Throwable -> L7
            this.mTikTapService.resetHalServiceProxy();     // Catch: Throwable -> L7
        L9:
            monitor-exit(VibHalDeathRecipient.class);     // Catch: Throwable -> L7
        }
    }

    static {
        mCurrentSenderId = new SenderId(0, 0);
    }

    private ITiktapVibrator getTiktapService() {
        monitor-enter(TikTapVibratorService.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.sTiktapVibratorService != null) goto L28;
        String vibratorDescriptor = "android$hardware$vibrator$IVibrator".replace('$', '.') + "/default";     // Catch: Throwable -> L11
        Slog.d(TAG, "vibratorDescriptor:" + vibratorDescriptor);     // Catch: Throwable -> L11
        IVibrator vibratorHalService = IVibrator.Stub.asInterface(ServiceManager.getService(vibratorDescriptor));     // Catch: Throwable -> L11
        if (vibratorHalService != null) goto L13;
        Slog.d(TAG, "can not get hal service");     // Catch: Throwable -> L11
        monitor-exit(TikTapVibratorService.class);     // Catch: Throwable -> L11
        return null;
    L13:
        Slog.d(TAG, "vibratorHalService:" + vibratorHalService);     // Catch: Throwable -> L11
        Slog.d(TAG, "Capabilities:" + vibratorHalService.getCapabilities());     // Catch: Throwable -> L11 Exception -> L16
    L34:
        IBinder binder = vibratorHalService.asBinder().getExtension();     // Catch: Throwable -> L11 Exception -> L22
        if (binder == null) goto L24;
        this.sTiktapVibratorService = ITiktapVibrator.Stub.asInterface(Binder.allowBlocking(binder));     // Catch: Throwable -> L11 Exception -> L22
        this.mHalDeathLinker = new VibHalDeathRecipient(this);     // Catch: Throwable -> L11 Exception -> L22
        mCurrentSenderId.reset();     // Catch: Throwable -> L11 Exception -> L22
        binder.linkToDeath(this.mHalDeathLinker, 0);     // Catch: Throwable -> L11 Exception -> L22
    L33:
    L24:
        this.sTiktapVibratorService = null;     // Catch: Throwable -> L11 Exception -> L22
        Slog.e(TAG, "getExtension == null");     // Catch: Throwable -> L11 Exception -> L22
    L22:
        e = move-exception;
        Slog.e(TAG, "getExtension fail", e);     // Catch: Throwable -> L11
    L16:
        e = move-exception;
        Slog.d(TAG, "getCapabilities faile", e);     // Catch: Throwable -> L11
    L28:
        monitor-exit(TikTapVibratorService.class);     // Catch: Throwable -> L11
        return this.sTiktapVibratorService;
    }

    TikTapVibratorService(boolean supportTikTap, ITiktapCallback callback) {
        this.mSupportTikTap = false;
        this.sTiktapVibratorService = null;
        this.mHalDeathLinker = null;
        this.SDK_HAL_NEW_FORMAT_DATA_VERSION = 2;
        this.mSupportTikTap = supportTikTap;
        this.mCallback = callback;
    }

    public boolean disposeTelephonyCallState(Context context) {
        boolean calling = false;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
        if (2 != telephonyManager.getCallState()) goto L5;
    L6:
        calling = true;
    L7:
        if (calling == false) goto L11;
        Slog.i(TAG, "current is calling state, stop tiktap effect loop");
        tikTapVibratorStop();
        return false;
    L11:
        return false;
    L5:
        if (1 != telephonyManager.getCallState()) goto L7;
        goto L6
    }

    public boolean disposeTiktapEffectParams(CombinedVibration combEffect) {
        if ((combEffect instanceof CombinedVibration.Mono) == true) goto L5;
        return false;
    L5:
        TikTapVibrationEffect.PatternHeParameter r0 = ((CombinedVibration.Mono) combEffect).getEffect();
        if ((r0 instanceof TikTapVibrationEffect.PatternHeParameter) == false) goto L18;
        TikTapVibrationEffect.PatternHeParameter param = r0;
        int interval = param.getInterval();
        int amplitude = param.getAmplitude();
        int freq = param.getFreq();
        Slog.d(TAG, "recive data  interval:" + interval + " amplitude:" + amplitude + " freq:" + freq);
        ITiktapVibrator service = getTiktapService();     // Catch: Exception -> L12
        if (service == null) goto L22;
        Slog.d(TAG, "awinic tiktap performHeParam");     // Catch: Exception -> L12
        service.performHeParam(interval, amplitude, freq, this.mCallback);     // Catch: Exception -> L12
        return true;
    L22:
        return true;
    L12:
        e = move-exception;
        Slog.e(TAG, "awinic tiktap performHeParam fail.", e);
        return true;
    L18:
        Slog.d(TAG, "none tiktap effect, do nothing!!");
        return false;
    }

    public void tikTapVibratorOn(long millis) {
        ITiktapVibrator service = getTiktapService();     // Catch: Exception -> L7
        if (service == null) goto L14;
        Slog.d(TAG, "awinic tiktap doVibratorOn");     // Catch: Exception -> L7
        service.on((int) millis, this.mCallback);     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "awinic tiktap doVibratorOn fail.", e);
    }

    public void tikTapVibratorOff() {
        ITiktapVibrator service = getTiktapService();     // Catch: Exception -> L7
        if (service == null) goto L14;
        Slog.d(TAG, "awinic tiktap doVibratorOff");     // Catch: Exception -> L7
        service.off(this.mCallback);     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "awinic tiktap doVibratorOff fail.", e);
    }

    public void tikTapVibratorSetAmplitude(int amplitude) {
        ITiktapVibrator service = getTiktapService();     // Catch: Exception -> L7
        if (service == null) goto L14;
        Slog.d(TAG, "awinic tiktap doVibratorSetAmplitude");     // Catch: Exception -> L7
        service.setAmplitude(amplitude, this.mCallback);     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "awinic tiktap doVibratorSetAmplitude fail.", e);
    }

    public int tikTapVibratorPerform(int id, byte scale) {
        int timeout = 0;
        ITiktapVibrator service = getTiktapService();     // Catch: Exception -> L7
        if (service == null) goto L11;
        Slog.d(TAG, "perform tiktap vibrator");     // Catch: Exception -> L7
        timeout = service.perform(id, scale, this.mCallback);     // Catch: Exception -> L7
        Slog.d(TAG, "awinic tiktap perform timeout:" + timeout);     // Catch: Exception -> L7
        return timeout;
    L11:
        return timeout;
    L7:
        e = move-exception;
        Slog.e(TAG, "awinic tiktap perform fail.", e);
        goto L11
    }

    public int getTikTapPrebakStrength(int effectStrength) {
        switch(effectStrength) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        Slog.d(TAG, "wrong Effect Strength!!");
        return 0;
    L5:
        return 99;
    L6:
        return 89;
    L7:
        return 69;
    }

    public void tikTapVibratorOnEnvelope(int[] relativeTime, int[] scaleArr, int[] freqArr, boolean steepMode, int amplitude) {
        int[] params = new int[12];
        int i = 0;
    L4:
        if (i >= relativeTime.length) goto L6;
        params[i * 3] = relativeTime[i];
        params[(i * 3) + 1] = scaleArr[i];
        params[(i * 3) + 2] = freqArr[i];
        String temp = String.format("relativeTime, scale, freq = { %d, %d, %d }", new Object[]{Integer.valueOf(params[i * 3]), Integer.valueOf(params[(i * 3) + 1]), Integer.valueOf(params[(i * 3) + 2])});
        Slog.d(TAG, temp);
        i = i + 1;
        goto L4
    L6:
        Slog.d(TAG, "vibrator perform envelope");
        tikTapVibratorSetAmplitude(amplitude);
        ITiktapVibrator service = getTiktapService();     // Catch: Exception -> L11
        if (service == null) goto L19;
        Slog.d(TAG, "awinic tiktap performEnvelope");     // Catch: Exception -> L11
        service.performEnvelope(params, steepMode, this.mCallback);     // Catch: Exception -> L11
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Slog.e(TAG, "awinic tiktap performEnvelope fail.", e);
    }

    public void tikTapVibratorOnPatternHe(VibrationEffect effect) {
        TikTapVibrationEffect.PatternHe newEffect = (TikTapVibrationEffect.PatternHe) effect;
        int[] pattern = newEffect.getPatternInfo();
        int looper = newEffect.getLooper();
        int interval = newEffect.getInterval();
        int amplitude = newEffect.getAmplitude();
        int freq = newEffect.getFreq();
        ITiktapVibrator service = getTiktapService();     // Catch: Exception -> L7
        if (service == null) goto L14;
        service.performHe(looper, interval, amplitude, freq, pattern, this.mCallback);     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "awinic tiktap doVibratorOnPatternHe fail.", e);
    }

    public void tikTapVibratorOnRawPattern(int[] pattern, int amplitude, int freq) {
        ITiktapVibrator service = getTiktapService();     // Catch: Exception -> L10
        if (service == null) goto L20;
        service.performHe(1, 0, amplitude, freq, pattern, this.mCallback);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Exception e = e;
    L14:
        Slog.e(TAG, "awinic tiktap doVibratorOnPatternHe fail.", e);
        return;
    L20:
        return;
    L10:
        e = move-exception;
        e = e;
        goto L14
    }

    public void tikTapVibratorStop() {
        ITiktapVibrator service = getTiktapService();     // Catch: Exception -> L7
        if (service == null) goto L14;
        Slog.d(TAG, "awinic tiktap doVibratorStop");     // Catch: Exception -> L7
        Slog.d(TAG, "tiktap service stop!!");     // Catch: Exception -> L7
        service.stop(this.mCallback);     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "awinic tiktap doVibratorStop fail.", e);
    }

    void resetHalServiceProxy() {
        this.sTiktapVibratorService = null;
    }

    public boolean checkIfPrevPatternData(SenderId senderId) {
        if (senderId.getPid() == mCurrentSenderId.getPid()) goto L5;
        return false;
    L5:
        if (senderId.getSeq() != mCurrentSenderId.getSeq()) goto L10;
        return true;
    L10:
        return false;
    }

    public void setCurrentSenderId(SenderId senderId) {
        mCurrentSenderId.setPid(senderId.getPid());
        mCurrentSenderId.setSeq(senderId.getSeq());
    }

    public void resetCurrentSenderId() {
        mCurrentSenderId.reset();
    }

    public SenderId getSenderId(VibrationEffect effect) {
        if ((effect instanceof TikTapVibrationEffect.PatternHe) == false) goto L12;
        TikTapVibrationEffect.PatternHe patternHe = (TikTapVibrationEffect.PatternHe) effect;
        int[] patternData = patternHe.getPatternInfo();
        if (patternData != null) goto L7;
        return null;
    L7:
        if (patternData.length <= 0) goto L15;
        int versionOrType = patternData[0];
        if (versionOrType != 2) goto L16;
        int pid = patternData[2];
        int seq = patternData[3];
        Slog.d(TAG, "get sender id pid:" + pid + " seq:" + seq);
        return new SenderId(pid, seq);
    L16:
        return null;
    L15:
        return null;
    L12:
        return null;
    }

    public boolean checkIfEffectHe2_0(VibrationEffect effect) {
        if ((effect instanceof TikTapVibrationEffect.PatternHe) == false) goto L8;
        TikTapVibrationEffect.PatternHe patternHe = (TikTapVibrationEffect.PatternHe) effect;
        int[] patternData = patternHe.getPatternInfo();
        int versionOrType = patternData[0];
        if (versionOrType != 2) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean checkIfFirstHe2_0Package(VibrationEffect effect) {
        if ((effect instanceof TikTapVibrationEffect.PatternHe) == false) goto L8;
        TikTapVibrationEffect.PatternHe patternHe = (TikTapVibrationEffect.PatternHe) effect;
        int[] patternData = patternHe.getPatternInfo();
        int firstPatternIndexInPackage = patternData[5];
        Slog.d(TAG, "checkIfFirstHe2_0Package firstPatternIndexInPackage: " + firstPatternIndexInPackage);
        if (firstPatternIndexInPackage != 0) goto L10;
        return true;
    L10:
        return false;
    L8:
        return false;
    }
}
