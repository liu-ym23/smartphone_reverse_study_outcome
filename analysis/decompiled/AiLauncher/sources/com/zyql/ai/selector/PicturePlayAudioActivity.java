package com.zyql.ai.selector;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.tools.DateUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import java.io.IOException;

@Deprecated
/* loaded from: classes4.dex */
public class PicturePlayAudioActivity extends PictureBaseActivity implements View.OnClickListener {
    private String audio_path;
    private MediaPlayer mediaPlayer;
    private SeekBar musicSeekBar;
    private TextView tv_PlayPause;
    private TextView tv_musicStatus;
    private TextView tv_musicTime;
    private TextView tv_musicTotal;
    private boolean isPlayAudio = false;
    public Runnable runnable = new Runnable() { // from class: com.zyql.ai.selector.PicturePlayAudioActivity.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (PicturePlayAudioActivity.this.mediaPlayer != null) {
                    PicturePlayAudioActivity.this.tv_musicTime.setText(DateUtils.formatDurationTime(PicturePlayAudioActivity.this.mediaPlayer.getCurrentPosition()));
                    PicturePlayAudioActivity.this.musicSeekBar.setProgress(PicturePlayAudioActivity.this.mediaPlayer.getCurrentPosition());
                    PicturePlayAudioActivity.this.musicSeekBar.setMax(PicturePlayAudioActivity.this.mediaPlayer.getDuration());
                    PicturePlayAudioActivity.this.tv_musicTotal.setText(DateUtils.formatDurationTime(PicturePlayAudioActivity.this.mediaPlayer.getDuration()));
                    PicturePlayAudioActivity picturePlayAudioActivity = PicturePlayAudioActivity.this;
                    picturePlayAudioActivity.mHandler.postDelayed(picturePlayAudioActivity.runnable, 200L);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    };

    private void initPlayer(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.mediaPlayer = new MediaPlayer();
        try {
            if (PictureMimeType.isContent(str)) {
                this.mediaPlayer.setDataSource(getContext(), Uri.parse(str));
            } else {
                this.mediaPlayer.setDataSource(str);
            }
            this.mediaPlayer.prepare();
            this.mediaPlayer.setLooping(true);
            playAudio();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initWidgets$0() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        initPlayer(this.audio_path);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$1() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        stop(this.audio_path);
    }

    private void playAudio() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            this.musicSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            this.musicSeekBar.setMax(this.mediaPlayer.getDuration());
        }
        String string = this.tv_PlayPause.getText().toString();
        int i10 = R.string.picture_play_audio;
        if (string.equals(getString(i10))) {
            this.tv_PlayPause.setText(getString(R.string.picture_pause_audio));
            this.tv_musicStatus.setText(getString(i10));
        } else {
            this.tv_PlayPause.setText(getString(i10));
            this.tv_musicStatus.setText(getString(R.string.picture_pause_audio));
        }
        playOrPause();
        if (this.isPlayAudio) {
            return;
        }
        this.mHandler.post(this.runnable);
        this.isPlayAudio = true;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_play_audio;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initWidgets() {
        super.initWidgets();
        this.audio_path = getIntent().getStringExtra(PictureConfig.EXTRA_AUDIO_PATH);
        this.tv_musicStatus = (TextView) findViewById(R.id.tv_musicStatus);
        this.tv_musicTime = (TextView) findViewById(R.id.tv_musicTime);
        this.musicSeekBar = (SeekBar) findViewById(R.id.musicSeekBar);
        this.tv_musicTotal = (TextView) findViewById(R.id.tv_musicTotal);
        this.tv_PlayPause = (TextView) findViewById(R.id.tv_PlayPause);
        TextView textView = (TextView) findViewById(R.id.tv_Stop);
        TextView textView2 = (TextView) findViewById(R.id.tv_Quit);
        this.mHandler.postDelayed(new Runnable() { // from class: com.zyql.ai.selector.m
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                this.f31999a.lambda$initWidgets$0();
            }
        }, 30L);
        this.tv_PlayPause.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        this.musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.zyql.ai.selector.PicturePlayAudioActivity.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) throws IllegalStateException {
                if (z10) {
                    PicturePlayAudioActivity.this.mediaPlayer.seekTo(i10);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override // b.q, android.app.Activity
    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        exit();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        int id = view.getId();
        if (id == R.id.tv_PlayPause) {
            playAudio();
        }
        if (id == R.id.tv_Stop) {
            this.tv_musicStatus.setText(getString(R.string.picture_stop_audio));
            this.tv_PlayPause.setText(getString(R.string.picture_play_audio));
            stop(this.audio_path);
        }
        if (id == R.id.tv_Quit) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mHandler.postDelayed(new Runnable() { // from class: com.zyql.ai.selector.n
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                    this.f32000a.lambda$onClick$1();
                }
            }, 30L);
            try {
                exit();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mediaPlayer != null) {
            this.mHandler.removeCallbacks(this.runnable);
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    public void playOrPause() throws IllegalStateException {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.mediaPlayer.pause();
                } else {
                    this.mediaPlayer.start();
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void stop(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.mediaPlayer.reset();
                if (PictureMimeType.isContent(str)) {
                    this.mediaPlayer.setDataSource(getContext(), Uri.parse(str));
                } else {
                    this.mediaPlayer.setDataSource(str);
                }
                this.mediaPlayer.prepare();
                this.mediaPlayer.seekTo(0);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
