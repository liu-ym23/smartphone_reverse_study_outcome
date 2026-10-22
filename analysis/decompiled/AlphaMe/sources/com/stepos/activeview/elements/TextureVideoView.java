package com.stepos.activeview.elements;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.MediaController;
import com.stepos.activeview.utils.LogUtil;
import com.stepos.alphame.utils.Property;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl, ActiveAnimation {
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private String LOG_TAG;
    private int mAudioSession;
    private boolean mAutoPlay;
    private boolean mAutoRelease;
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    private Context mContext;
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private MediaPlayer.OnErrorListener mErrorListener;
    private Handler mHandler;
    private Map<String, String> mHeaders;
    private MediaPlayer.OnInfoListener mInfoListener;
    private long mIntervalDelay;
    private boolean mLooping;
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;
    private MediaPlayer.OnErrorListener mOnErrorListener;
    private MediaPlayer.OnInfoListener mOnInfoListener;
    private MediaPlayer.OnPreparedListener mOnPreparedListener;
    private boolean mPlayAudio;
    MediaPlayer.OnPreparedListener mPreparedListener;
    private int mSeekWhenPrepared;
    MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener;
    private long mStartPlayTime;
    private Surface mSurface;
    private int mSurfaceHeight;
    private SurfaceTexture mSurfaceTexture;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private int mSurfaceWidth;
    private int mTargetState;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;

    public TextureVideoView(Context context) {
        super(context);
        this.LOG_TAG = "TextureVideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurface = null;
        this.mMediaPlayer = null;
        this.mLooping = true;
        this.mAutoPlay = true;
        this.mPlayAudio = false;
        this.mStartPlayTime = 0L;
        this.mIntervalDelay = 0L;
        this.mAutoRelease = true;
        this.mSurfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.stepos.activeview.elements.TextureVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                if (TextureVideoView.this.mSurfaceTexture == null) {
                    TextureVideoView.this.mSurfaceTexture = surfaceTexture;
                    TextureVideoView.this.mSurface = new Surface(surfaceTexture);
                    TextureVideoView.this.openVideo();
                } else {
                    TextureVideoView.this.initMediaPlayer();
                    TextureVideoView textureVideoView = TextureVideoView.this;
                    textureVideoView.setSurfaceTexture(textureVideoView.mSurfaceTexture);
                }
                TextureVideoView.this.start();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TextureVideoView.this.mAutoRelease) {
                    TextureVideoView.this.release(true);
                    return true;
                }
                TextureVideoView.this.mMediaPlayer.reset();
                return TextureVideoView.this.mSurfaceTexture != surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) throws IllegalStateException {
                LogUtil.e(TextureVideoView.this.LOG_TAG, "onSurfaceTextureSizeChanged , width=" + i4 + " height = : " + i5);
                TextureVideoView.this.mSurfaceWidth = i4;
                TextureVideoView.this.mSurfaceHeight = i5;
                boolean z4 = TextureVideoView.this.mTargetState == 3;
                if (TextureVideoView.this.mMediaPlayer == null || !z4) {
                    return;
                }
                if (TextureVideoView.this.mSeekWhenPrepared != 0) {
                    TextureVideoView textureVideoView = TextureVideoView.this;
                    textureVideoView.seekTo(textureVideoView.mSeekWhenPrepared);
                }
                TextureVideoView.this.start();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.stepos.activeview.elements.TextureVideoView.2
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i4, int i5) {
                TextureVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                TextureVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                LogUtil.e(TextureVideoView.this.LOG_TAG, "onVideoSizeChanged , mVideoWidth=" + TextureVideoView.this.mVideoWidth + ", mVideoHeight = : " + TextureVideoView.this.mVideoHeight);
                if (TextureVideoView.this.mVideoWidth == 0 || TextureVideoView.this.mVideoHeight == 0) {
                    return;
                }
                TextureVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: com.stepos.activeview.elements.TextureVideoView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                TextureVideoView.this.mCurrentState = 2;
                TextureVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                TextureVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                LogUtil.e(TextureVideoView.this.LOG_TAG, "onPrepared , mVideoWidth=" + TextureVideoView.this.mVideoWidth + ", mVideoHeight = : " + TextureVideoView.this.mVideoHeight);
                int i4 = TextureVideoView.this.mSeekWhenPrepared;
                if (i4 != 0) {
                    TextureVideoView.this.seekTo(i4);
                }
                if (TextureVideoView.this.mTargetState == 3 && TextureVideoView.this.mAutoPlay) {
                    TextureVideoView.this.mStartPlayTime = 10L;
                    if (TextureVideoView.this.mStartPlayTime > 0) {
                        TextureVideoView.this.getPostHandler().postDelayed(new Runnable() { // from class: com.stepos.activeview.elements.TextureVideoView.3.1
                            @Override // java.lang.Runnable
                            public void run() throws IllegalStateException {
                                TextureVideoView.this.start();
                            }
                        }, TextureVideoView.this.mStartPlayTime);
                    } else {
                        TextureVideoView.this.start();
                    }
                }
                if (TextureVideoView.this.mOnPreparedListener != null) {
                    TextureVideoView.this.mOnPreparedListener.onPrepared(TextureVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.stepos.activeview.elements.TextureVideoView.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException {
                TextureVideoView.this.mCurrentState = 5;
                TextureVideoView.this.mTargetState = 5;
                if (TextureVideoView.this.mLooping) {
                    if (TextureVideoView.this.mIntervalDelay > 0) {
                        TextureVideoView.this.getPostHandler().postDelayed(new Runnable() { // from class: com.stepos.activeview.elements.TextureVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() throws IllegalStateException {
                                TextureVideoView.this.start();
                            }
                        }, TextureVideoView.this.mIntervalDelay);
                    } else {
                        TextureVideoView.this.start();
                    }
                }
                if (TextureVideoView.this.mOnCompletionListener != null) {
                    TextureVideoView.this.mOnCompletionListener.onCompletion(TextureVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new MediaPlayer.OnInfoListener() { // from class: com.stepos.activeview.elements.TextureVideoView.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i4, int i5) {
                if (TextureVideoView.this.mOnInfoListener == null) {
                    return true;
                }
                TextureVideoView.this.mOnInfoListener.onInfo(mediaPlayer, i4, i5);
                return true;
            }
        };
        this.mErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.stepos.activeview.elements.TextureVideoView.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
                LogUtil.e(TextureVideoView.this.LOG_TAG, "Error: " + i4 + "," + i5);
                TextureVideoView.this.mCurrentState = -1;
                TextureVideoView.this.mTargetState = -1;
                if (TextureVideoView.this.mOnErrorListener != null) {
                    TextureVideoView.this.mOnErrorListener.onError(TextureVideoView.this.mMediaPlayer, i4, i5);
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.stepos.activeview.elements.TextureVideoView.7
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i4) {
                TextureVideoView.this.mCurrentBufferPercentage = i4;
            }
        };
        this.mContext = context;
        initVideoView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getPostHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        return this.mHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMediaPlayer() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mMediaPlayer = mediaPlayer;
            mediaPlayer.reset();
            if (this.mPlayAudio) {
                int i4 = this.mAudioSession;
                if (i4 != 0) {
                    this.mMediaPlayer.setAudioSessionId(i4);
                } else {
                    this.mAudioSession = this.mMediaPlayer.getAudioSessionId();
                }
            } else {
                this.mMediaPlayer.setVolume(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
            }
            this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
            this.mCurrentBufferPercentage = 0;
            this.mMediaPlayer.setDataSource(this.mContext, this.mUri, this.mHeaders);
            this.mMediaPlayer.setSurface(this.mSurface);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
            this.mMediaPlayer.prepareAsync();
            this.mCurrentState = 1;
        } catch (IOException e4) {
            LogUtil.e(this.LOG_TAG, "Unable to open content: " + this.mUri + ", err=" + e4);
            this.mCurrentState = -1;
            this.mTargetState = -1;
            MediaPlayer.OnErrorListener onErrorListener = this.mErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError(this.mMediaPlayer, 1, 0);
            }
        } catch (IllegalArgumentException e5) {
            LogUtil.e(this.LOG_TAG, "Unable to open content: " + this.mUri + ", err=" + e5);
            this.mCurrentState = -1;
            this.mTargetState = -1;
            MediaPlayer.OnErrorListener onErrorListener2 = this.mErrorListener;
            if (onErrorListener2 != null) {
                onErrorListener2.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    private void initVideoView() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.mSurfaceTextureListener);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mHandler = new Handler();
    }

    private boolean isInPlaybackState() {
        int i4;
        return (this.mMediaPlayer == null || (i4 = this.mCurrentState) == -1 || i4 == 0 || i4 == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.mUri == null || this.mSurface == null) {
            return;
        }
        release(false);
        initMediaPlayer();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.mCanPause;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        if (!this.mPlayAudio) {
            return 0;
        }
        if (this.mAudioSession == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mAudioSession = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.mAudioSession;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public long getIntervalDelay() {
        return this.mIntervalDelay;
    }

    public long getStartPlayTime() {
        return this.mStartPlayTime;
    }

    public String getUri() {
        Uri uri = this.mUri;
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public boolean isAutoPlay() {
        return this.mAutoPlay;
    }

    public boolean isLooping() {
        return this.mLooping;
    }

    public boolean isPlayAudio() {
        return this.mPlayAudio;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.mVideoWidth
            int r0 = android.view.View.getDefaultSize(r0, r6)
            int r1 = r5.mVideoHeight
            int r1 = android.view.View.getDefaultSize(r1, r7)
            int r2 = r5.mVideoWidth
            if (r2 <= 0) goto L64
            int r2 = r5.mVideoHeight
            if (r2 <= 0) goto L64
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L2b
            if (r1 != r2) goto L2b
            goto L49
        L2b:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L3d
            int r0 = r5.mVideoHeight
            int r0 = r0 * r6
            int r2 = r5.mVideoWidth
            int r0 = r0 / r2
            if (r1 != r3) goto L3a
            if (r0 <= r7) goto L3a
            goto L49
        L3a:
            r1 = r0
        L3b:
            r0 = r6
            goto L64
        L3d:
            if (r1 != r2) goto L4e
            int r1 = r5.mVideoWidth
            int r1 = r1 * r7
            int r2 = r5.mVideoHeight
            int r1 = r1 / r2
            if (r0 != r3) goto L4c
            if (r1 <= r6) goto L4c
        L49:
            r0 = r6
        L4a:
            r1 = r7
            goto L64
        L4c:
            r0 = r1
            goto L4a
        L4e:
            int r2 = r5.mVideoWidth
            int r4 = r5.mVideoHeight
            if (r1 != r3) goto L5a
            if (r4 <= r7) goto L5a
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L5c
        L5a:
            r1 = r2
            r7 = r4
        L5c:
            if (r0 != r3) goto L4c
            if (r1 <= r6) goto L4c
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L3b
        L64:
            r5.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.elements.TextureVideoView.onMeasure(int, int):void");
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() throws IllegalStateException {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void pauseAnimation() throws IllegalStateException {
        pause();
    }

    public void release(boolean z4) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (z4) {
                this.mTargetState = 0;
                Surface surface = this.mSurface;
                if (surface != null) {
                    surface.release();
                    this.mSurface = null;
                }
                SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    this.mSurfaceTexture = null;
                }
            }
            if (this.mPlayAudio) {
                ((AudioManager) this.mContext.getSystemService("audio")).abandonAudioFocus(null);
            }
            LogUtil.i(this.LOG_TAG, "release success , mMediaPlayer=" + this.mMediaPlayer + ", mSurface = " + this.mSurface + ", mSurfaceTexture = " + this.mSurfaceTexture);
        }
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void resumeAnimation() throws IllegalStateException {
        start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i4) throws IllegalStateException {
        if (!isInPlaybackState()) {
            this.mSeekWhenPrepared = i4;
        } else {
            this.mMediaPlayer.seekTo(i4);
            this.mSeekWhenPrepared = 0;
        }
    }

    public void setAutoPlay(boolean z4) {
        this.mAutoPlay = z4;
    }

    public void setAutoRelease(boolean z4) {
        this.mAutoRelease = z4;
    }

    public void setIntervalDelay(long j4) {
        this.mIntervalDelay = j4;
    }

    public void setLooping(boolean z4) {
        this.mLooping = z4;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setPlayAudio(boolean z4) {
        this.mPlayAudio = z4;
    }

    public void setStartPlayTime(long j4) {
        this.mStartPlayTime = j4;
    }

    public void setVideoPath(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            this.mUri = Uri.fromFile(new File(str));
        } catch (Exception e4) {
            LogUtil.e(this.LOG_TAG, "Exception e=" + e4.toString());
        }
        this.mHeaders = null;
        this.mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    public void setVideoURI(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        setVideoURI(uri, null);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() throws IllegalStateException {
        if (isInPlaybackState()) {
            try {
                this.mMediaPlayer.start();
            } catch (IllegalStateException e4) {
                LogUtil.e(this.LOG_TAG, "IllegalStateException e=" + e4.toString());
            }
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void startAnimation() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.mCurrentState == 0 && this.mTargetState == 0) {
            openVideo();
        }
        start();
    }

    @Override // com.stepos.activeview.elements.ActiveAnimation
    public void stopAnimation() {
    }

    public void stopPlayback() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
            if (this.mPlayAudio) {
                ((AudioManager) this.mContext.getSystemService("audio")).abandonAudioFocus(null);
            }
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
    }

    public void setVideoURI(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LOG_TAG = "TextureVideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurface = null;
        this.mMediaPlayer = null;
        this.mLooping = true;
        this.mAutoPlay = true;
        this.mPlayAudio = false;
        this.mStartPlayTime = 0L;
        this.mIntervalDelay = 0L;
        this.mAutoRelease = true;
        this.mSurfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.stepos.activeview.elements.TextureVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                if (TextureVideoView.this.mSurfaceTexture == null) {
                    TextureVideoView.this.mSurfaceTexture = surfaceTexture;
                    TextureVideoView.this.mSurface = new Surface(surfaceTexture);
                    TextureVideoView.this.openVideo();
                } else {
                    TextureVideoView.this.initMediaPlayer();
                    TextureVideoView textureVideoView = TextureVideoView.this;
                    textureVideoView.setSurfaceTexture(textureVideoView.mSurfaceTexture);
                }
                TextureVideoView.this.start();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TextureVideoView.this.mAutoRelease) {
                    TextureVideoView.this.release(true);
                    return true;
                }
                TextureVideoView.this.mMediaPlayer.reset();
                return TextureVideoView.this.mSurfaceTexture != surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) throws IllegalStateException {
                LogUtil.e(TextureVideoView.this.LOG_TAG, "onSurfaceTextureSizeChanged , width=" + i4 + " height = : " + i5);
                TextureVideoView.this.mSurfaceWidth = i4;
                TextureVideoView.this.mSurfaceHeight = i5;
                boolean z4 = TextureVideoView.this.mTargetState == 3;
                if (TextureVideoView.this.mMediaPlayer == null || !z4) {
                    return;
                }
                if (TextureVideoView.this.mSeekWhenPrepared != 0) {
                    TextureVideoView textureVideoView = TextureVideoView.this;
                    textureVideoView.seekTo(textureVideoView.mSeekWhenPrepared);
                }
                TextureVideoView.this.start();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.stepos.activeview.elements.TextureVideoView.2
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i4, int i5) {
                TextureVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                TextureVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                LogUtil.e(TextureVideoView.this.LOG_TAG, "onVideoSizeChanged , mVideoWidth=" + TextureVideoView.this.mVideoWidth + ", mVideoHeight = : " + TextureVideoView.this.mVideoHeight);
                if (TextureVideoView.this.mVideoWidth == 0 || TextureVideoView.this.mVideoHeight == 0) {
                    return;
                }
                TextureVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: com.stepos.activeview.elements.TextureVideoView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                TextureVideoView.this.mCurrentState = 2;
                TextureVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                TextureVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                LogUtil.e(TextureVideoView.this.LOG_TAG, "onPrepared , mVideoWidth=" + TextureVideoView.this.mVideoWidth + ", mVideoHeight = : " + TextureVideoView.this.mVideoHeight);
                int i4 = TextureVideoView.this.mSeekWhenPrepared;
                if (i4 != 0) {
                    TextureVideoView.this.seekTo(i4);
                }
                if (TextureVideoView.this.mTargetState == 3 && TextureVideoView.this.mAutoPlay) {
                    TextureVideoView.this.mStartPlayTime = 10L;
                    if (TextureVideoView.this.mStartPlayTime > 0) {
                        TextureVideoView.this.getPostHandler().postDelayed(new Runnable() { // from class: com.stepos.activeview.elements.TextureVideoView.3.1
                            @Override // java.lang.Runnable
                            public void run() throws IllegalStateException {
                                TextureVideoView.this.start();
                            }
                        }, TextureVideoView.this.mStartPlayTime);
                    } else {
                        TextureVideoView.this.start();
                    }
                }
                if (TextureVideoView.this.mOnPreparedListener != null) {
                    TextureVideoView.this.mOnPreparedListener.onPrepared(TextureVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.stepos.activeview.elements.TextureVideoView.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException {
                TextureVideoView.this.mCurrentState = 5;
                TextureVideoView.this.mTargetState = 5;
                if (TextureVideoView.this.mLooping) {
                    if (TextureVideoView.this.mIntervalDelay > 0) {
                        TextureVideoView.this.getPostHandler().postDelayed(new Runnable() { // from class: com.stepos.activeview.elements.TextureVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() throws IllegalStateException {
                                TextureVideoView.this.start();
                            }
                        }, TextureVideoView.this.mIntervalDelay);
                    } else {
                        TextureVideoView.this.start();
                    }
                }
                if (TextureVideoView.this.mOnCompletionListener != null) {
                    TextureVideoView.this.mOnCompletionListener.onCompletion(TextureVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new MediaPlayer.OnInfoListener() { // from class: com.stepos.activeview.elements.TextureVideoView.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i4, int i5) {
                if (TextureVideoView.this.mOnInfoListener == null) {
                    return true;
                }
                TextureVideoView.this.mOnInfoListener.onInfo(mediaPlayer, i4, i5);
                return true;
            }
        };
        this.mErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.stepos.activeview.elements.TextureVideoView.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i4, int i5) {
                LogUtil.e(TextureVideoView.this.LOG_TAG, "Error: " + i4 + "," + i5);
                TextureVideoView.this.mCurrentState = -1;
                TextureVideoView.this.mTargetState = -1;
                if (TextureVideoView.this.mOnErrorListener != null) {
                    TextureVideoView.this.mOnErrorListener.onError(TextureVideoView.this.mMediaPlayer, i4, i5);
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.stepos.activeview.elements.TextureVideoView.7
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i4) {
                TextureVideoView.this.mCurrentBufferPercentage = i4;
            }
        };
        this.mContext = context;
        initVideoView();
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.LOG_TAG = "TextureVideoView";
        this.mCurrentState = 0;
        this.mTargetState = 0;
        this.mSurface = null;
        this.mMediaPlayer = null;
        this.mLooping = true;
        this.mAutoPlay = true;
        this.mPlayAudio = false;
        this.mStartPlayTime = 0L;
        this.mIntervalDelay = 0L;
        this.mAutoRelease = true;
        this.mSurfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.stepos.activeview.elements.TextureVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i42, int i5) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                if (TextureVideoView.this.mSurfaceTexture == null) {
                    TextureVideoView.this.mSurfaceTexture = surfaceTexture;
                    TextureVideoView.this.mSurface = new Surface(surfaceTexture);
                    TextureVideoView.this.openVideo();
                } else {
                    TextureVideoView.this.initMediaPlayer();
                    TextureVideoView textureVideoView = TextureVideoView.this;
                    textureVideoView.setSurfaceTexture(textureVideoView.mSurfaceTexture);
                }
                TextureVideoView.this.start();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TextureVideoView.this.mAutoRelease) {
                    TextureVideoView.this.release(true);
                    return true;
                }
                TextureVideoView.this.mMediaPlayer.reset();
                return TextureVideoView.this.mSurfaceTexture != surfaceTexture;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i42, int i5) throws IllegalStateException {
                LogUtil.e(TextureVideoView.this.LOG_TAG, "onSurfaceTextureSizeChanged , width=" + i42 + " height = : " + i5);
                TextureVideoView.this.mSurfaceWidth = i42;
                TextureVideoView.this.mSurfaceHeight = i5;
                boolean z4 = TextureVideoView.this.mTargetState == 3;
                if (TextureVideoView.this.mMediaPlayer == null || !z4) {
                    return;
                }
                if (TextureVideoView.this.mSeekWhenPrepared != 0) {
                    TextureVideoView textureVideoView = TextureVideoView.this;
                    textureVideoView.seekTo(textureVideoView.mSeekWhenPrepared);
                }
                TextureVideoView.this.start();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.stepos.activeview.elements.TextureVideoView.2
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i42, int i5) {
                TextureVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                TextureVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                LogUtil.e(TextureVideoView.this.LOG_TAG, "onVideoSizeChanged , mVideoWidth=" + TextureVideoView.this.mVideoWidth + ", mVideoHeight = : " + TextureVideoView.this.mVideoHeight);
                if (TextureVideoView.this.mVideoWidth == 0 || TextureVideoView.this.mVideoHeight == 0) {
                    return;
                }
                TextureVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: com.stepos.activeview.elements.TextureVideoView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                TextureVideoView.this.mCurrentState = 2;
                TextureVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                TextureVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                LogUtil.e(TextureVideoView.this.LOG_TAG, "onPrepared , mVideoWidth=" + TextureVideoView.this.mVideoWidth + ", mVideoHeight = : " + TextureVideoView.this.mVideoHeight);
                int i42 = TextureVideoView.this.mSeekWhenPrepared;
                if (i42 != 0) {
                    TextureVideoView.this.seekTo(i42);
                }
                if (TextureVideoView.this.mTargetState == 3 && TextureVideoView.this.mAutoPlay) {
                    TextureVideoView.this.mStartPlayTime = 10L;
                    if (TextureVideoView.this.mStartPlayTime > 0) {
                        TextureVideoView.this.getPostHandler().postDelayed(new Runnable() { // from class: com.stepos.activeview.elements.TextureVideoView.3.1
                            @Override // java.lang.Runnable
                            public void run() throws IllegalStateException {
                                TextureVideoView.this.start();
                            }
                        }, TextureVideoView.this.mStartPlayTime);
                    } else {
                        TextureVideoView.this.start();
                    }
                }
                if (TextureVideoView.this.mOnPreparedListener != null) {
                    TextureVideoView.this.mOnPreparedListener.onPrepared(TextureVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.stepos.activeview.elements.TextureVideoView.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException {
                TextureVideoView.this.mCurrentState = 5;
                TextureVideoView.this.mTargetState = 5;
                if (TextureVideoView.this.mLooping) {
                    if (TextureVideoView.this.mIntervalDelay > 0) {
                        TextureVideoView.this.getPostHandler().postDelayed(new Runnable() { // from class: com.stepos.activeview.elements.TextureVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() throws IllegalStateException {
                                TextureVideoView.this.start();
                            }
                        }, TextureVideoView.this.mIntervalDelay);
                    } else {
                        TextureVideoView.this.start();
                    }
                }
                if (TextureVideoView.this.mOnCompletionListener != null) {
                    TextureVideoView.this.mOnCompletionListener.onCompletion(TextureVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new MediaPlayer.OnInfoListener() { // from class: com.stepos.activeview.elements.TextureVideoView.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i42, int i5) {
                if (TextureVideoView.this.mOnInfoListener == null) {
                    return true;
                }
                TextureVideoView.this.mOnInfoListener.onInfo(mediaPlayer, i42, i5);
                return true;
            }
        };
        this.mErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.stepos.activeview.elements.TextureVideoView.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i42, int i5) {
                LogUtil.e(TextureVideoView.this.LOG_TAG, "Error: " + i42 + "," + i5);
                TextureVideoView.this.mCurrentState = -1;
                TextureVideoView.this.mTargetState = -1;
                if (TextureVideoView.this.mOnErrorListener != null) {
                    TextureVideoView.this.mOnErrorListener.onError(TextureVideoView.this.mMediaPlayer, i42, i5);
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.stepos.activeview.elements.TextureVideoView.7
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i42) {
                TextureVideoView.this.mCurrentBufferPercentage = i42;
            }
        };
        this.mContext = context;
        initVideoView();
    }
}
