package com.byted.cast.sdk.render.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.sdk.RTCAudioProfile;
import com.byted.cast.sdk.utils.HexDump;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import fna.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes43.dex */
public class AudioPassivePlayer implements AudioJitterBufferCallback {
    private static int AAC_PROFILE = 1;
    private static int CHAN_COUNT = 2;
    private static int SAMPLE_IDX = 3;
    private static final String TAG = "AudioPassivePlayer";
    private static String mMineType = "audio/mp4a-latm";
    private int mAACProfile;
    private int mAudioFormat;
    private IAudioListener mAudioListener;
    private RTCAudioProfile mAudioProfile;
    private Boolean mAutoPlayAudio;
    private MediaCodec.BufferInfo mBufferInfo;
    private ContextManager.CastContext mCastContext;
    private int mChannel;
    private MediaCodec mDecoder;
    private ByteBuffer[] mInputBuffers;
    private volatile boolean mIsPlayStarted;
    private CastLogger mLogger;
    private ByteBuffer[] mOutputBuffers;
    private SortedSet<Long> mPtsSet;
    private int mSampleFrame;
    private int mSampleRate;
    private ExecutorService mSingleExecutor;
    private AudioTrack mTrack;
    private String mUserId;

    public static /* synthetic */ void a(AudioPassivePlayer r100, byte[] r101, long r102) {
        r100.lambda$callbackAudioData$0(r101, r102);
    }

    private void releaseDecoder() {
        MediaCodec r100 = this.mDecoder;
        if (r100 == null) goto L5;
        r100.stop();
        this.mDecoder.release();
    L5:
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
    }

    public int getAudioSessionId() {
        AudioTrack r100 = this.mTrack;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getAudioSessionId();
    }

    @Override // com.byted.cast.sdk.render.audio.AudioJitterBufferCallback
    public void onAudioReadyToPlay() {
        if (this.mTrack == null) goto L6;
        this.mLogger.i(TAG, "Start to play");
        INVOKEVIRTUAL_com_byted_cast_sdk_render_audio_AudioPassivePlayer_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(this.mTrack);
        return;
    }

    public boolean prepareDecoder() {
        this.mLogger.i(TAG, "prepareDecoder audio");
        this.mBufferInfo = new MediaCodec.BufferInfo();
        this.mDecoder = MediaCodec.createDecoderByType(mMineType);     // Catch: IOException -> L9
        MediaFormat r100 = new MediaFormat();     // Catch: IOException -> L9
        r100.setString("mime", mMineType);     // Catch: IOException -> L9
        r100.setInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT, 2);     // Catch: IOException -> L9
        r100.setInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE, 48000);     // Catch: IOException -> L9
        r100.setInteger("is-adts", 1);     // Catch: IOException -> L9
        this.mLogger.i(TAG, "prepareDecoder, before dump");     // Catch: IOException -> L9
        byte[] r101 = {17, -112};     // Catch: IOException -> L9
        this.mLogger.i(TAG, "prepareDecoder, csd-0:" + HexDump.toHexString(r101[0]) + " " + HexDump.toHexString(r101[1]));     // Catch: IOException -> L9
        r100.setByteBuffer("csd-0", ByteBuffer.wrap(r101));     // Catch: IOException -> L9
        this.mDecoder.configure(r100, null, null, 0);     // Catch: IOException -> L9
        MediaCodec r102 = this.mDecoder;
        if (r102 != null) goto L7;
        return false;
    L7:
        r102.start();
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void startPlay() {
        this.mLogger.i(TAG, "AudioTrack start !");
        this.mIsPlayStarted = true;
        this.mSampleFrame = (RTCAudioProfile.getFrameSize(this.mSampleRate) / 2) / 2;
        AudioJitterBuffer.getInstance().setJitterCallback(this).setAudioFormat(this.mSampleRate, 2, 2);
        AudioJitterBuffer.getInstance().start();
        prepareDecoder();
    }

    public void stopPlay() {
        this.mLogger.i(TAG, "AudioTrack stop !");
        if (this.mIsPlayStarted == true) goto L5;
        return;
    L5:
        releaseDecoder();
        AudioJitterBuffer.getInstance().stop();
        AudioTrack r100 = this.mTrack;
        if (r100 == null) goto L8;
        r100.release();
        this.mTrack = null;
    L8:
        this.mIsPlayStarted = false;
    }

    public static void INVOKEVIRTUAL_com_byted_cast_sdk_render_audio_AudioPassivePlayer_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(AudioTrack r100) {
        if (g.d() == true) goto L6;
        r100.play();
        return;
    L6:
        r100.play();
        gna.a.c(r100.hashCode());
    }

    @Override // com.byted.cast.sdk.render.audio.AudioJitterBufferCallback
    public void onAudioSmoothOutput(byte[] r100) {
        AudioTrack r101 = this.mTrack;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.write(r100, 0, r100.length) == r100.length) goto L9;
        this.mLogger.e(TAG, "onAudioSmoothOutput output len invalid：" + r100.length);
        return;
    }

    public void setVolume(float r100) {
        if (this.mTrack == null) goto L6;
        this.mLogger.i(TAG, "setVolume:" + r100);
        this.mTrack.setVolume(r100);
        return;
    }

    private void callbackAudioData(final byte[] r100, final long r101) {
        if (this.mAudioListener == null) goto L6;
        this.mSingleExecutor.execute(new b(this, r100, r101));
        return;
    }

    private void decode(byte[] r110, long r111) {
        int r100 = this.mDecoder.dequeueInputBuffer(10000);
        if (Build.VERSION.SDK_INT <= 21) goto L15;
        if (r100 < 0) goto L9;
        ByteBuffer r101 = this.mDecoder.getInputBuffer(r100);
        if (r101 != null) goto L8;
        return;
    L8:
        r101.clear();
        r101.put(r110, 0, r110.length);
        this.mDecoder.queueInputBuffer(r100, 0, r110.length, r111, 0);
    L9:
        int r112 = this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, 10000);
        if (r112 < 0) goto L26;
        ByteBuffer r113 = this.mDecoder.getOutputBuffer(r112);
        int r114 = this.mBufferInfo.size;
        byte[] r102 = new byte[r114];
        r113.get(r102, 0, r114);
        r113.clear();
        callbackAudioData(r102, this.mBufferInfo.presentationTimeUs);
        if (this.mAutoPlayAudio.booleanValue() == false) goto L14;
        AudioJitterBuffer.getInstance().append(r102, this.mBufferInfo.presentationTimeUs);
    L14:
        this.mDecoder.releaseOutputBuffer(r112, false);
        goto L9
    L26:
        return;
    L15:
        if (r100 < 0) goto L20;
        ByteBuffer r103 = this.mInputBuffers[r100];
        if (r103 != null) goto L19;
        return;
    L19:
        r103.clear();
        r103.put(r110, 0, r110.length);
        this.mDecoder.queueInputBuffer(r100, 0, r110.length, r111, 0);
    L20:
        int r115 = this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, 10000);
        if (r115 < 0) goto L35;
        ByteBuffer r116 = this.mOutputBuffers[r115];
        int r117 = this.mBufferInfo.size;
        byte[] r104 = new byte[r117];
        r116.get(r104, 0, r117);
        r116.clear();
        callbackAudioData(r104, this.mBufferInfo.presentationTimeUs);
        if (this.mAutoPlayAudio.booleanValue() == false) goto L25;
        AudioJitterBuffer.getInstance().append(r104, this.mBufferInfo.presentationTimeUs);
    L25:
        this.mDecoder.releaseOutputBuffer(r115, false);
        goto L20
    }

    private /* synthetic */ void lambda$callbackAudioData$0(byte[] r110, long r111) {
        this.mAudioListener.onAudioOutput(this.mUserId, r110, this.mSampleRate, this.mChannel, this.mAudioFormat, this.mAudioProfile.getBitrate(), r111);
    }

    public void addFrame(byte[] r100, long r101) {
        if (this.mPtsSet.contains(Long.valueOf(r101)) == true) goto L8;
        this.mLogger.i(TAG, "addFrame...New...frame.length=" + r100.length + " timestamp=" + r101);
        this.mPtsSet.add(Long.valueOf(r101));
        decode(r100, r101);
        Iterator<Long> r102 = this.mPtsSet.headSet(Long.valueOf(r101 - ((long) (this.mSampleFrame * 5)))).iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        long r103 = r102.next().longValue();
        this.mLogger.i(TAG, "addFrame...Flush...timestamp=" + r103);
        this.mPtsSet.remove(Long.valueOf(r103));
        goto L6
    L11:
        return;
    L8:
        this.mLogger.i(TAG, "addFrame...Skip...frame.length=" + r100.length + " timestamp=" + r101);
    }

    public void addPcm(byte[] r100, long r101) {
        if (this.mAutoPlayAudio.booleanValue() == false) goto L6;
        AudioJitterBuffer.getInstance().append(r100, r101);
        return;
    }

    public AudioPassivePlayer(String r110, ContextManager.CastContext r111, Boolean r112, RTCAudioProfile r113, IAudioListener r114) {
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
        this.mAACProfile = 2;
        this.mChannel = 12;
        this.mSampleRate = 48000;
        this.mSampleFrame = 1024;
        this.mIsPlayStarted = false;
        this.mAudioFormat = 2;
        this.mSingleExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory(TAG));
        this.mPtsSet = new ConcurrentSkipListSet();
        this.mUserId = r110;
        this.mCastContext = r111;
        this.mAutoPlayAudio = r112;
        this.mAudioListener = r114;
        this.mAudioProfile = r113;
        CastLogger r115 = ContextManager.getLogger(r111);
        this.mLogger = r115;
        r115.i(TAG, "AudioPassivePlayer, mUserId: " + this.mUserId + ", autoplay: " + this.mAutoPlayAudio + ", mAudioListener: " + this.mAudioListener);
        int r116 = AudioTrack.getMinBufferSize(this.mSampleRate, this.mChannel, this.mAudioFormat);
        if (r116 != (-2)) goto L5;
        this.mLogger.e(TAG, "Invalid parameter !");
    L5:
        int r100 = r116 * 4;
        this.mLogger.i(TAG, "AudioTrack init...minBufferSize=" + r100);
        if (Build.VERSION.SDK_INT < 26) goto L8;
        this.mTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setPerformanceMode(1).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.mSampleRate).setEncoding(this.mAudioFormat).setChannelMask(this.mChannel).build()).setTransferMode(1).setBufferSizeInBytes(r100).build();
        return;
    L8:
        this.mTrack = new AudioTrack(3, this.mSampleRate, this.mChannel, this.mAudioFormat, r100, 1);
    }
}
