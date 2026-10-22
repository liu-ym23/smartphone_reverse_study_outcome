package com.byted.cast.render.render.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Build;
import com.byted.cast.mediacommon.render.parameters.MediaParameter;
import com.byted.cast.mediacommon.render.parameters.MediaRenderErrorCode;
import com.byted.cast.render.utils.Logger;
import fna.g;
import gna.a;

/* JADX INFO: loaded from: classes43.dex */
public class AudioTrackRender implements IAudioRender {
    private static final String TAG = "AudioTrackRender";
    private AudioTrack audioTrack;
    private int bitWidth;
    private int channels;
    private float gain;
    private final float max_vol;
    private final float min_vol;
    private AudioRouting.OnRoutingChangedListener routingChangedListener;
    private int sampleRate;
    private int streamType;
    private final String userId;

    @Override // com.byted.cast.render.render.IRender
    public boolean start() {
        Logger.i(TAG, "AudioTrackRender start");
        if (this.audioTrack == null) goto L7;
        Logger.w(TAG, "Render started");
        return false;
    L7:
        if (this.channels != 1) goto L9;
        int r100 = 4;
    L11:
        if (this.bitWidth != 8) goto L13;
        int r101 = 3;
    L14:
        int r102 = AudioTrack.getMinBufferSize(this.sampleRate, r100, r101);
        if (r102 != (-2)) goto L44;
        Logger.e(TAG, "Invalid parameter !");
        MediaRenderErrorCode.onError(this.userId, MediaRenderErrorCode.MEDIARENDER_RENDER_ERROR, "Invalid parameter");
        return false;
    L44:
        int r103 = Build.VERSION.SDK_INT;     // Catch: Exception -> L41
        if (r103 < 26) goto L22;
        this.audioTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setPerformanceMode(1).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.sampleRate).setEncoding(r101).setChannelMask(r100).build()).setTransferMode(1).setBufferSizeInBytes(r102).build();     // Catch: Exception -> L41
    L26:
        if (this.audioTrack.getState() == 1) goto L29;
        Logger.e(TAG, "audioTrack init failed");
        MediaRenderErrorCode.onError(this.userId, MediaRenderErrorCode.MEDIARENDER_RENDER_ERROR, "audioTrack init failed");
        return false;
    L29:
        AudioTrack r104 = this.audioTrack;
        if (r104 != null) goto L32;
    L45:
        AudioTrack r105 = this.audioTrack;     // Catch: IllegalStateException -> L38
        if (r105 == null) goto L37;
        INVOKEVIRTUAL_com_byted_cast_render_render_audio_AudioTrackRender_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(r105);     // Catch: IllegalStateException -> L38
    L37:
        return true;
    L38:
        e = move-exception;
        e.printStackTrace();
        Logger.e(TAG, "audioTrack play failed");
        MediaRenderErrorCode.onError(this.userId, MediaRenderErrorCode.MEDIARENDER_RENDER_ERROR, "audioTrack play failed");
        return false;
    L32:
        if (r103 < 24) goto L45;
        r104.addOnRoutingChangedListener(this.routingChangedListener, null);
        goto L45
    L22:
        if (r103 < 23) goto L24;
        this.audioTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.sampleRate).setEncoding(r101).setChannelMask(r100).build()).setTransferMode(1).setBufferSizeInBytes(r102).build();     // Catch: Exception -> L41
        goto L26
    L24:
        this.audioTrack = new AudioTrack(this.streamType, this.sampleRate, r100, r101, r102, 1);     // Catch: Exception -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
        Logger.e(TAG, "audioTrack build failed");
        MediaRenderErrorCode.onError(this.userId, MediaRenderErrorCode.MEDIARENDER_RENDER_ERROR, "audioTrack build failed");
        return false;
    L13:
        r101 = 2;
        goto L14
    L9:
        r100 = 12;
        goto L11
    }

    @Override // com.byted.cast.render.render.IRender
    public boolean stop() {
        Logger.i(TAG, "AudioTrackRender stop");
        AudioTrack r100 = this.audioTrack;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getState() != 1) goto L9;
        Logger.w(TAG, "render is stopped");
        return false;
    L9:
        this.audioTrack.flush();
        INVOKEVIRTUAL_com_byted_cast_render_render_audio_AudioTrackRender_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(this.audioTrack);
        this.audioTrack.release();
        this.audioTrack = null;
        return true;
    }

    @Override // com.byted.cast.render.render.audio.IAudioRender
    public float getMaxVol() {
        return this.max_vol;
    }

    public float getMaxVolume() {
        return this.max_vol;
    }

    @Override // com.byted.cast.render.render.audio.IAudioRender
    public float getMinVol() {
        return this.min_vol;
    }

    public float getMinVolume() {
        return this.min_vol;
    }

    public AudioTrackRender(String r100) {
        this.audioTrack = null;
        this.channels = 2;
        this.sampleRate = 48000;
        this.bitWidth = 16;
        this.gain = 1.0f;
        this.streamType = 3;
        this.max_vol = AudioTrack.getMaxVolume();
        this.min_vol = AudioTrack.getMinVolume();
        this.userId = r100;
    }

    public static void INVOKEVIRTUAL_com_byted_cast_render_render_audio_AudioTrackRender_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(AudioTrack r100) {
        if (g.d() == true) goto L6;
        r100.play();
        return;
    L6:
        r100.play();
        a.c(r100.hashCode());
    }

    public static void INVOKEVIRTUAL_com_byted_cast_render_render_audio_AudioTrackRender_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(AudioTrack r100) {
        if (g.d() == true) goto L6;
        r100.stop();
        return;
    L6:
        r100.stop();
        a.a(r100.hashCode());
    }

    @Override // com.byted.cast.render.render.IRender
    public Object getParameter(MediaParameter r100) {
        if (r100 != MediaParameter.Audio_Render_SessionId) goto L9;
        AudioTrack r101 = this.audioTrack;
        if (r101 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r101.getAudioSessionId());
    L9:
        if (r100 == MediaParameter.Audio_Render_volume) goto L11;
        Logger.e(TAG, "setParameter failed, key not found");
        return null;
    L11:
        return Float.valueOf(this.gain);
    }

    @Override // com.byted.cast.render.render.audio.IAudioRender
    public void setVolume(float r100) {
        float r101 = this.max_vol;
        if (r100 <= r101) goto L5;
    L4:
        r100 = r101;
    L8:
        this.gain = r100;
        AudioTrack r102 = this.audioTrack;
        if (r102 == null) goto L12;
        r102.setVolume(r100);
        Logger.i(TAG, "AudioTrack setVolume: " + r100);
        return;
    L12:
        return;
    L5:
        r101 = this.min_vol;
        if (r100 >= r101) goto L8;
        goto L8
    }

    @Override // com.byted.cast.render.render.IRender
    public void render(byte[] r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        AudioTrack r102 = this.audioTrack;
        if (r102 == null) goto L8;
        r102.write(r100, 0, r101);
        return;
    }

    @Override // com.byted.cast.render.render.IRender
    public void setParameter(MediaParameter r100, Object r101) {
        if (r100 == MediaParameter.Audio_Render_routingChangedListener) goto L5;
        Logger.e(TAG, "[AudioTrackRender]: setParameter key not found! key: " + r100);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L9;
        this.routingChangedListener = (AudioRouting.OnRoutingChangedListener) r101;
        return;
    }

    @Override // com.byted.cast.render.render.audio.IAudioRender
    public void config_audio_parameters(int r100, int r101, int r102) {
        this.sampleRate = r100;
        this.channels = r101;
        this.bitWidth = r102;
    }
}
