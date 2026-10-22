package com.zyql.ai.selector;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureWindowAnimationStyle;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class PictureVideoPlayActivity extends PictureBaseActivity implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, View.OnClickListener {
    private ImageButton ibLeftBack;
    private ImageView iv_play;
    private MediaController mMediaController;
    private int mPositionWhenPaused = -1;
    private VideoView mVideoView;
    private String videoPath;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onPrepared$0(MediaPlayer mediaPlayer, int i10, int i11) {
        if (i10 != 3) {
            return false;
        }
        this.mVideoView.setBackgroundColor(0);
        return true;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.appcompat.app.d, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(new ContextWrapper(context) { // from class: com.zyql.ai.selector.PictureVideoPlayActivity.1
            @Override // android.content.ContextWrapper, android.content.Context
            public Object getSystemService(String str) {
                return "audio".equals(str) ? getApplicationContext().getSystemService(str) : super.getSystemService(str);
            }
        });
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_activity_video_play;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initPictureSelectorStyle() {
        int i10;
        PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
        if (pictureParameterStyle == null || (i10 = pictureParameterStyle.pictureLeftBackIcon) == 0) {
            return;
        }
        this.ibLeftBack.setImageResource(i10);
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initWidgets() {
        super.initWidgets();
        this.videoPath = getIntent().getStringExtra(PictureConfig.EXTRA_VIDEO_PATH);
        boolean booleanExtra = getIntent().getBooleanExtra(PictureConfig.EXTRA_PREVIEW_VIDEO, false);
        if (TextUtils.isEmpty(this.videoPath)) {
            LocalMedia localMedia = (LocalMedia) getIntent().getParcelableExtra(PictureConfig.EXTRA_MEDIA_KEY);
            if (localMedia == null || TextUtils.isEmpty(localMedia.getPath())) {
                finish();
                return;
            }
            this.videoPath = localMedia.getPath();
        }
        if (TextUtils.isEmpty(this.videoPath)) {
            exit();
            return;
        }
        this.ibLeftBack = (ImageButton) findViewById(R.id.pictureLeftBack);
        this.mVideoView = (VideoView) findViewById(R.id.video_view);
        TextView textView = (TextView) findViewById(R.id.tv_confirm);
        this.mVideoView.setBackgroundColor(-16777216);
        this.iv_play = (ImageView) findViewById(R.id.iv_play);
        this.mMediaController = new MediaController(this);
        this.mVideoView.setOnCompletionListener(this);
        this.mVideoView.setOnPreparedListener(this);
        this.mVideoView.setMediaController(this.mMediaController);
        this.ibLeftBack.setOnClickListener(this);
        this.iv_play.setOnClickListener(this);
        textView.setOnClickListener(this);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        textView.setVisibility((pictureSelectionConfig.selectionMode == 1 && pictureSelectionConfig.enPreviewVideo && !booleanExtra) ? 0 : 8);
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, android.app.Activity
    public boolean isImmersive() {
        return false;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public boolean isRequestedOrientation() {
        return false;
    }

    @Override // b.q, android.app.Activity
    public void onBackPressed() {
        PictureWindowAnimationStyle pictureWindowAnimationStyle = PictureSelectionConfig.windowAnimationStyle;
        if (pictureWindowAnimationStyle == null || pictureWindowAnimationStyle.activityPreviewExitAnimation == 0) {
            exit();
        } else {
            finish();
            overridePendingTransition(0, PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pictureLeftBack) {
            onBackPressed();
            return;
        }
        if (id == R.id.iv_play) {
            this.mVideoView.start();
            this.iv_play.setVisibility(4);
        } else if (id == R.id.tv_confirm) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add((LocalMedia) getIntent().getParcelableExtra(PictureConfig.EXTRA_MEDIA_KEY));
            setResult(-1, new Intent().putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, arrayList));
            onBackPressed();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        ImageView imageView = this.iv_play;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().addFlags(67108864);
        super.onCreate(bundle);
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        this.mMediaController = null;
        this.mVideoView = null;
        this.iv_play = null;
        super.onDestroy();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        return false;
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        this.mPositionWhenPaused = this.mVideoView.getCurrentPosition();
        this.mVideoView.stopPlayback();
        super.onPause();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.zyql.ai.selector.D
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer2, int i10, int i11) {
                return this.f31947a.lambda$onPrepared$0(mediaPlayer2, i10, i11);
            }
        });
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        int i10 = this.mPositionWhenPaused;
        if (i10 >= 0) {
            this.mVideoView.seekTo(i10);
            this.mPositionWhenPaused = -1;
        }
        super.onResume();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStart() {
        if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(this.videoPath)) {
            this.mVideoView.setVideoURI(Uri.parse(this.videoPath));
        } else {
            this.mVideoView.setVideoPath(this.videoPath);
        }
        this.mVideoView.start();
        super.onStart();
    }
}
