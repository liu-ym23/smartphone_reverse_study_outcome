package com.zyql.ai.selector;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import com.zyql.ai.crop.UCrop;
import com.zyql.ai.selector.adapter.PictureImageGridAdapter;
import com.zyql.ai.selector.animators.AlphaInAnimationAdapter;
import com.zyql.ai.selector.animators.SlideInBottomAnimationAdapter;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.decoration.GridSpacingItemDecoration;
import com.zyql.ai.selector.dialog.PhotoItemSelectedDialog;
import com.zyql.ai.selector.dialog.PictureCustomDialog;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.entity.LocalMediaFolder;
import com.zyql.ai.selector.listener.OnAlbumItemClickListener;
import com.zyql.ai.selector.listener.OnCustomCameraInterfaceListener;
import com.zyql.ai.selector.listener.OnCustomImagePreviewCallback;
import com.zyql.ai.selector.listener.OnItemClickListener;
import com.zyql.ai.selector.listener.OnPermissionDialogOptionCallback;
import com.zyql.ai.selector.listener.OnPermissionsObtainCallback;
import com.zyql.ai.selector.listener.OnPhotoSelectChangedListener;
import com.zyql.ai.selector.listener.OnQueryDataResultListener;
import com.zyql.ai.selector.listener.OnRecyclerViewPreloadMoreListener;
import com.zyql.ai.selector.listener.OnResultCallbackListener;
import com.zyql.ai.selector.listener.OnVideoSelectedPlayCallback;
import com.zyql.ai.selector.manager.UCropManager;
import com.zyql.ai.selector.model.LocalMediaLoader;
import com.zyql.ai.selector.model.LocalMediaPageLoader;
import com.zyql.ai.selector.observable.ImagesObservable;
import com.zyql.ai.selector.permissions.PermissionChecker;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import com.zyql.ai.selector.thread.PictureThreadUtils;
import com.zyql.ai.selector.tools.AttrsUtils;
import com.zyql.ai.selector.tools.DateUtils;
import com.zyql.ai.selector.tools.DoubleUtils;
import com.zyql.ai.selector.tools.JumpUtils;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.tools.ScreenUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.StringUtils;
import com.zyql.ai.selector.tools.ToastUtils;
import com.zyql.ai.selector.tools.ValueOf;
import com.zyql.ai.selector.widget.FolderPopWindow;
import com.zyql.ai.selector.widget.RecyclerPreloadView;
import d.AbstractC3936b;
import d.InterfaceC3935a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class PictureSelectorActivity extends PictureBaseActivity implements View.OnClickListener, OnAlbumItemClickListener, OnPhotoSelectChangedListener<LocalMedia>, OnItemClickListener, OnRecyclerViewPreloadMoreListener {
    private static final String TAG = "PictureSelectorActivity";
    private AbstractC3936b activityResultLauncher;
    private int allFolderSize;
    protected PictureCustomDialog audioDialog;
    protected FolderPopWindow folderWindow;
    protected boolean isEnterSetting;
    protected PictureImageGridAdapter mAdapter;
    protected RelativeLayout mBottomLayout;
    protected CheckBox mCbOriginal;
    protected ImageView mIvArrow;
    protected ImageView mIvPictureLeftBack;
    private int mOpenCameraCount;
    protected RecyclerPreloadView mRecyclerView;
    protected View mTitleBar;
    protected TextView mTvEmpty;
    protected TextView mTvMusicStatus;
    protected TextView mTvMusicTime;
    protected TextView mTvMusicTotal;
    protected TextView mTvPictureImgNum;
    protected TextView mTvPictureOk;
    protected TextView mTvPicturePreview;
    protected TextView mTvPictureRight;
    protected TextView mTvPictureTitle;
    protected TextView mTvPlayPause;
    protected TextView mTvQuit;
    protected TextView mTvStop;
    protected MediaPlayer mediaPlayer;
    protected SeekBar musicSeekBar;
    protected int oldCurrentListSize;
    protected View viewClickMask;
    protected Animation animation = null;
    protected boolean isStartAnimation = false;
    protected boolean isPlayAudio = false;
    private long intervalClickTime = 0;
    public Runnable mRunnable = new Runnable() { // from class: com.zyql.ai.selector.PictureSelectorActivity.6
        @Override // java.lang.Runnable
        public void run() {
            try {
                PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
                if (pictureSelectorActivity.mediaPlayer != null) {
                    pictureSelectorActivity.mTvMusicTime.setText(DateUtils.formatDurationTime(r1.getCurrentPosition()));
                    PictureSelectorActivity pictureSelectorActivity2 = PictureSelectorActivity.this;
                    pictureSelectorActivity2.musicSeekBar.setProgress(pictureSelectorActivity2.mediaPlayer.getCurrentPosition());
                    PictureSelectorActivity pictureSelectorActivity3 = PictureSelectorActivity.this;
                    pictureSelectorActivity3.musicSeekBar.setMax(pictureSelectorActivity3.mediaPlayer.getDuration());
                    PictureSelectorActivity.this.mTvMusicTotal.setText(DateUtils.formatDurationTime(r0.mediaPlayer.getDuration()));
                    PictureSelectorActivity pictureSelectorActivity4 = PictureSelectorActivity.this;
                    pictureSelectorActivity4.mHandler.postDelayed(pictureSelectorActivity4.mRunnable, 200L);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    };

    public class onAudioOnClick implements View.OnClickListener {
        private String path;

        public onAudioOnClick(String str) {
            this.path = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
            PictureSelectorActivity.this.stop(this.path);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
            int id = view.getId();
            if (id == R.id.tv_PlayPause) {
                PictureSelectorActivity.this.playAudio();
            }
            if (id == R.id.tv_Stop) {
                PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
                pictureSelectorActivity.mTvMusicStatus.setText(pictureSelectorActivity.getString(R.string.picture_stop_audio));
                PictureSelectorActivity pictureSelectorActivity2 = PictureSelectorActivity.this;
                pictureSelectorActivity2.mTvPlayPause.setText(pictureSelectorActivity2.getString(R.string.picture_play_audio));
                PictureSelectorActivity.this.stop(this.path);
            }
            if (id == R.id.tv_Quit) {
                PictureSelectorActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.zyql.ai.selector.A
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                        this.f31945a.lambda$onClick$0();
                    }
                }, 30L);
                try {
                    PictureCustomDialog pictureCustomDialog = PictureSelectorActivity.this.audioDialog;
                    if (pictureCustomDialog != null && pictureCustomDialog.isShowing()) {
                        PictureSelectorActivity.this.audioDialog.dismiss();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                PictureSelectorActivity pictureSelectorActivity3 = PictureSelectorActivity.this;
                pictureSelectorActivity3.mHandler.removeCallbacks(pictureSelectorActivity3.mRunnable);
            }
        }
    }

    public static /* synthetic */ void A(Map map) {
        String[] storagePermissions = PermissionAdapter.INSTANCE.getStoragePermissions();
        if (storagePermissions == null || storagePermissions.length <= 0) {
            return;
        }
        for (String str : storagePermissions) {
            ((Boolean) map.get(str)).getClass();
            Log.w("PictureSelector", "user deny permission request :" + str);
        }
    }

    private void bothMimeTypeWith(boolean z10, List<LocalMedia> list) {
        int i10 = 0;
        LocalMedia localMedia = list.size() > 0 ? list.get(0) : null;
        if (localMedia == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.enableCrop || pictureSelectionConfig.isCheckOriginalImage) {
            if (!pictureSelectionConfig.isCompress) {
                onResult(list);
                return;
            }
            int size = list.size();
            while (i10 < size) {
                if (PictureMimeType.isHasImage(list.get(i10).getMimeType())) {
                    compressImage(list);
                    return;
                }
                i10++;
            }
            onResult(list);
            return;
        }
        if (pictureSelectionConfig.selectionMode == 1 && z10) {
            pictureSelectionConfig.originalPath = localMedia.getPath();
            UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType());
            return;
        }
        int size2 = list.size();
        int i11 = 0;
        while (i10 < size2) {
            LocalMedia localMedia2 = list.get(i10);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && PictureMimeType.isHasImage(localMedia2.getMimeType())) {
                i11++;
            }
            i10++;
        }
        if (i11 <= 0) {
            onResult(list);
        } else {
            UCropManager.ofCrop(this, (ArrayList) list);
        }
    }

    private boolean checkVideoLegitimacy(LocalMedia localMedia) {
        if (!PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            return true;
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        int i10 = pictureSelectionConfig.videoMinSecond;
        if (i10 > 0 && pictureSelectionConfig.videoMaxSecond > 0) {
            if (localMedia.getDuration() >= this.config.videoMinSecond && localMedia.getDuration() <= this.config.videoMaxSecond) {
                return true;
            }
            showPromptDialog(getString(R.string.picture_choose_limit_seconds, Integer.valueOf(this.config.videoMinSecond / 1000), Integer.valueOf(this.config.videoMaxSecond / 1000)));
            return false;
        }
        if (i10 > 0) {
            long duration = localMedia.getDuration();
            int i11 = this.config.videoMinSecond;
            if (duration >= i11) {
                return true;
            }
            showPromptDialog(getString(R.string.picture_choose_min_seconds, Integer.valueOf(i11 / 1000)));
            return false;
        }
        if (pictureSelectionConfig.videoMaxSecond <= 0) {
            return true;
        }
        long duration2 = localMedia.getDuration();
        int i12 = this.config.videoMaxSecond;
        if (duration2 <= i12) {
            return true;
        }
        showPromptDialog(getString(R.string.picture_choose_max_seconds, Integer.valueOf(i12 / 1000)));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad A[Catch: Exception -> 0x02e2, TryCatch #4 {Exception -> 0x02e2, blocks: (B:4:0x0003, B:7:0x000f, B:8:0x0011, B:10:0x001b, B:13:0x0037, B:30:0x007f, B:32:0x0085, B:40:0x0097, B:42:0x009d, B:43:0x00a0, B:36:0x008e, B:44:0x00a1, B:47:0x00ad, B:49:0x00bc, B:51:0x00ed, B:58:0x0149, B:60:0x0157, B:62:0x0166, B:64:0x016e, B:65:0x0174, B:76:0x0215, B:78:0x0225, B:80:0x022f, B:82:0x023a, B:85:0x025e, B:87:0x0268, B:89:0x0272, B:91:0x0278, B:92:0x0286, B:93:0x029c, B:95:0x02a2, B:97:0x02c5, B:99:0x02cf, B:101:0x02da, B:96:0x02b0, B:81:0x0235, B:52:0x0108, B:54:0x010e, B:55:0x0130, B:57:0x0136, B:66:0x0179, B:68:0x019e, B:75:0x0207, B:69:0x01c6, B:71:0x01cc, B:72:0x01ee, B:74:0x01f4), top: B:109:0x0003 }] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.io.Closeable, java.nio.channels.Channel] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void dispatchHandleCamera(android.content.Intent r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 743
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.PictureSelectorActivity.dispatchHandleCamera(android.content.Intent):void");
    }

    private void dispatchHandleMultiple(LocalMedia localMedia) {
        int i10;
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        int size = selectedData.size();
        String mimeType = size > 0 ? selectedData.get(0).getMimeType() : "";
        boolean zIsMimeTypeSame = PictureMimeType.isMimeTypeSame(mimeType, localMedia.getMimeType());
        if (!this.config.isWithVideoImage) {
            if (!PictureMimeType.isHasVideo(mimeType) || (i10 = this.config.maxVideoSelectNum) <= 0) {
                if (size >= this.config.maxSelectNum) {
                    showPromptDialog(StringUtils.getMsg(getContext(), mimeType, this.config.maxSelectNum));
                    return;
                } else {
                    if (zIsMimeTypeSame || size == 0) {
                        selectedData.add(localMedia);
                        this.mAdapter.bindSelectData(selectedData);
                        return;
                    }
                    return;
                }
            }
            if (size >= i10) {
                showPromptDialog(StringUtils.getMsg(getContext(), mimeType, this.config.maxVideoSelectNum));
                return;
            } else {
                if ((zIsMimeTypeSame || size == 0) && selectedData.size() < this.config.maxVideoSelectNum) {
                    selectedData.add(localMedia);
                    this.mAdapter.bindSelectData(selectedData);
                    return;
                }
                return;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            if (PictureMimeType.isHasVideo(selectedData.get(i12).getMimeType())) {
                i11++;
            }
        }
        if (!PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            if (selectedData.size() >= this.config.maxSelectNum) {
                showPromptDialog(StringUtils.getMsg(getContext(), localMedia.getMimeType(), this.config.maxSelectNum));
                return;
            } else {
                selectedData.add(localMedia);
                this.mAdapter.bindSelectData(selectedData);
                return;
            }
        }
        int i13 = this.config.maxVideoSelectNum;
        if (i13 <= 0) {
            showPromptDialog(getString(R.string.picture_rule));
        } else if (i11 >= i13) {
            showPromptDialog(getString(R.string.picture_message_max_num, Integer.valueOf(i13)));
        } else {
            selectedData.add(localMedia);
            this.mAdapter.bindSelectData(selectedData);
        }
    }

    private void dispatchHandleSingle(LocalMedia localMedia) {
        if (this.config.isSingleDirectReturn) {
            List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
            selectedData.add(localMedia);
            this.mAdapter.bindSelectData(selectedData);
            singleDirectReturnCameraHandleResult(localMedia.getMimeType());
            return;
        }
        List<LocalMedia> selectedData2 = this.mAdapter.getSelectedData();
        if (PictureMimeType.isMimeTypeSame(selectedData2.size() > 0 ? selectedData2.get(0).getMimeType() : "", localMedia.getMimeType()) || selectedData2.size() == 0) {
            singleRadioMediaImage();
            selectedData2.add(localMedia);
            this.mAdapter.bindSelectData(selectedData2);
        }
    }

    private int getPageLimit() {
        if (ValueOf.toInt(this.mTvPictureTitle.getTag(R.id.view_tag)) != -1) {
            return this.config.pageSize;
        }
        int i10 = this.mOpenCameraCount;
        int i11 = i10 > 0 ? this.config.pageSize - i10 : this.config.pageSize;
        this.mOpenCameraCount = 0;
        return i11;
    }

    private void hideDataNull() {
        if (this.mTvEmpty.getVisibility() == 0) {
            this.mTvEmpty.setVisibility(8);
        }
    }

    private void initPageModel(List<LocalMediaFolder> list) {
        if (list == null) {
            showDataNull(getString(R.string.picture_data_exception), R.drawable.picture_icon_data_error);
            dismissDialog();
            return;
        }
        this.folderWindow.bindFolder(list);
        this.mPage = 1;
        LocalMediaFolder folder = this.folderWindow.getFolder(0);
        this.mTvPictureTitle.setTag(R.id.view_count_tag, Integer.valueOf(folder != null ? folder.getImageNum() : 0));
        this.mTvPictureTitle.setTag(R.id.view_index_tag, 0);
        long bucketId = folder != null ? folder.getBucketId() : -1L;
        this.mRecyclerView.setEnabledLoadMore(true);
        LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(bucketId, this.mPage, new OnQueryDataResultListener() { // from class: com.zyql.ai.selector.u
            @Override // com.zyql.ai.selector.listener.OnQueryDataResultListener
            public final void onComplete(List list2, int i10, boolean z10) {
                this.f32008a.lambda$initPageModel$4(list2, i10, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPlayer(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
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
    public void initStandardModel(List<LocalMediaFolder> list) {
        if (list == null) {
            showDataNull(getString(R.string.picture_data_exception), R.drawable.picture_icon_data_error);
        } else if (list.size() > 0) {
            this.folderWindow.bindFolder(list);
            LocalMediaFolder localMediaFolder = list.get(0);
            localMediaFolder.setChecked(true);
            this.mTvPictureTitle.setTag(R.id.view_count_tag, Integer.valueOf(localMediaFolder.getImageNum()));
            List<LocalMedia> data = localMediaFolder.getData();
            PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
            if (pictureImageGridAdapter != null) {
                int size = pictureImageGridAdapter.getSize();
                int size2 = data.size();
                int i10 = this.oldCurrentListSize + size;
                this.oldCurrentListSize = i10;
                if (size2 >= size) {
                    if (size <= 0 || size >= size2 || i10 == size2) {
                        this.mAdapter.bindData(data);
                    } else {
                        this.mAdapter.getData().addAll(data);
                        LocalMedia localMedia = this.mAdapter.getData().get(0);
                        localMediaFolder.setFirstImagePath(localMedia.getPath());
                        localMediaFolder.getData().add(0, localMedia);
                        localMediaFolder.setCheckedNum(1);
                        localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                        updateMediaFolder(this.folderWindow.getFolderData(), localMedia);
                    }
                }
                if (this.mAdapter.isDataEmpty()) {
                    showDataNull(getString(R.string.picture_empty), R.drawable.picture_icon_no_data);
                } else {
                    hideDataNull();
                }
            }
        } else {
            showDataNull(getString(R.string.picture_empty), R.drawable.picture_icon_no_data);
        }
        dismissDialog();
    }

    private boolean isAddSameImp(int i10) {
        int i11;
        return i10 != 0 && (i11 = this.allFolderSize) > 0 && i11 < i10;
    }

    private boolean isCurrentCacheFolderData(int i10) {
        this.mTvPictureTitle.setTag(R.id.view_index_tag, Integer.valueOf(i10));
        LocalMediaFolder folder = this.folderWindow.getFolder(i10);
        if (folder == null || folder.getData() == null || folder.getData().size() <= 0) {
            return false;
        }
        this.mAdapter.bindData(folder.getData());
        this.mPage = folder.getCurrentDataPage();
        this.isHasMore = folder.isHasMore();
        this.mRecyclerView.smoothScrollToPosition(0);
        return true;
    }

    private boolean isLocalMediaSame(LocalMedia localMedia) {
        LocalMedia item = this.mAdapter.getItem(0);
        if (item != null && localMedia != null) {
            if (item.getPath().equals(localMedia.getPath())) {
                return true;
            }
            if (PictureMimeType.isContent(localMedia.getPath()) && PictureMimeType.isContent(item.getPath()) && !TextUtils.isEmpty(localMedia.getPath()) && !TextUtils.isEmpty(item.getPath())) {
                return localMedia.getPath().substring(localMedia.getPath().lastIndexOf("/") + 1).equals(item.getPath().substring(item.getPath().lastIndexOf("/") + 1));
            }
        }
        return false;
    }

    private void isNumComplete(boolean z10) {
        if (z10) {
            initCompleteText(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPageModel$4(List list, int i10, boolean z10) {
        if (isFinishing()) {
            return;
        }
        dismissDialog();
        if (this.mAdapter != null) {
            this.isHasMore = true;
            if (z10 && list.size() == 0) {
                onRecyclerViewPreloadMore();
                return;
            }
            int size = this.mAdapter.getSize();
            int size2 = list.size();
            int i11 = this.oldCurrentListSize + size;
            this.oldCurrentListSize = i11;
            if (size2 >= size) {
                if (size <= 0 || size >= size2 || i11 == size2 || isLocalMediaSame((LocalMedia) list.get(0))) {
                    this.mAdapter.bindData(list);
                } else {
                    this.mAdapter.getData().addAll(list);
                }
            }
            if (this.mAdapter.isDataEmpty()) {
                showDataNull(getString(R.string.picture_empty), R.drawable.picture_icon_no_data);
            } else {
                hideDataNull();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initWidgets$1(CompoundButton compoundButton, boolean z10) {
        this.config.isCheckOriginalImage = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMoreData$2(long j10, List list, int i10, boolean z10) {
        if (isFinishing()) {
            return;
        }
        this.isHasMore = z10;
        if (!z10) {
            if (this.mAdapter.isDataEmpty()) {
                showDataNull(getString(j10 == -1 ? R.string.picture_empty : R.string.picture_data_null), R.drawable.picture_icon_no_data);
                return;
            }
            return;
        }
        hideDataNull();
        int size = list.size();
        if (size > 0) {
            int size2 = this.mAdapter.getSize();
            this.mAdapter.getData().addAll(list);
            this.mAdapter.notifyItemRangeChanged(size2, this.mAdapter.getItemCount());
        } else {
            onRecyclerViewPreloadMore();
        }
        if (size < 10) {
            RecyclerPreloadView recyclerPreloadView = this.mRecyclerView;
            recyclerPreloadView.onScrolled(recyclerPreloadView.getScrollX(), this.mRecyclerView.getScrollY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onItemClick$6(List list, int i10, boolean z10) {
        this.isHasMore = z10;
        if (isFinishing()) {
            return;
        }
        if (list.size() == 0) {
            this.mAdapter.clear();
        }
        this.mAdapter.bindData(list);
        this.mRecyclerView.onScrolled(0, 0);
        this.mRecyclerView.smoothScrollToPosition(0);
        dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readLocalMedia$3(List list, int i10, boolean z10) {
        if (isFinishing()) {
            return;
        }
        this.isHasMore = true;
        initPageModel(list);
        if (this.config.isSyncCover) {
            synchronousCover();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionsDialog$7(PictureCustomDialog pictureCustomDialog, boolean z10, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        if (z10) {
            return;
        }
        OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onCancel();
        }
        exit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionsDialog$8(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        PermissionChecker.launchAppDetailsSettings(getContext());
        this.isEnterSetting = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPlayAudioDialog$5(final String str, DialogInterface dialogInterface) {
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mHandler.postDelayed(new Runnable() { // from class: com.zyql.ai.selector.PictureSelectorActivity.5
            @Override // java.lang.Runnable
            public void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                PictureSelectorActivity.this.stop(str);
            }
        }, 30L);
        try {
            PictureCustomDialog pictureCustomDialog = this.audioDialog;
            if (pictureCustomDialog == null || !pictureCustomDialog.isShowing()) {
                return;
            }
            this.audioDialog.dismiss();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void loadAllMediaData() {
        if (PermissionAdapter.INSTANCE.checkMediaPermission(this)) {
            readLocalMedia();
        } else {
            showPermissionsDialog(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, getString(R.string.picture_jurisdiction));
        }
    }

    private void loadMoreData() {
        if (this.mAdapter == null || !this.isHasMore) {
            return;
        }
        this.mPage++;
        final long j10 = ValueOf.toLong(this.mTvPictureTitle.getTag(R.id.view_tag));
        LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(j10, this.mPage, getPageLimit(), new OnQueryDataResultListener() { // from class: com.zyql.ai.selector.s
            @Override // com.zyql.ai.selector.listener.OnQueryDataResultListener
            public final void onComplete(List list, int i10, boolean z10) {
                this.f32005a.lambda$loadMoreData$2(j10, list, i10, z10);
            }
        });
    }

    private void manualSaveFolder(LocalMedia localMedia) {
        LocalMediaFolder localMediaFolder;
        try {
            boolean zIsEmpty = this.folderWindow.isEmpty();
            int imageNum = this.folderWindow.getFolder(0) != null ? this.folderWindow.getFolder(0).getImageNum() : 0;
            if (zIsEmpty) {
                createNewFolder(this.folderWindow.getFolderData());
                localMediaFolder = this.folderWindow.getFolderData().size() > 0 ? this.folderWindow.getFolderData().get(0) : null;
                if (localMediaFolder == null) {
                    localMediaFolder = new LocalMediaFolder();
                    this.folderWindow.getFolderData().add(0, localMediaFolder);
                }
            } else {
                localMediaFolder = this.folderWindow.getFolderData().get(0);
            }
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder.setData(this.mAdapter.getData());
            localMediaFolder.setBucketId(-1L);
            localMediaFolder.setImageNum(isAddSameImp(imageNum) ? localMediaFolder.getImageNum() : localMediaFolder.getImageNum() + 1);
            LocalMediaFolder imageFolder = getImageFolder(localMedia.getPath(), localMedia.getRealPath(), localMedia.getMimeType(), this.folderWindow.getFolderData());
            if (imageFolder != null) {
                imageFolder.setImageNum(isAddSameImp(imageNum) ? imageFolder.getImageNum() : imageFolder.getImageNum() + 1);
                if (!isAddSameImp(imageNum)) {
                    imageFolder.getData().add(0, localMedia);
                }
                imageFolder.setBucketId(localMedia.getBucketId());
                imageFolder.setFirstImagePath(this.config.cameraPath);
                imageFolder.setFirstMimeType(localMedia.getMimeType());
            }
            FolderPopWindow folderPopWindow = this.folderWindow;
            folderPopWindow.bindFolder(folderPopWindow.getFolderData());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void manualSaveFolderForPageModel(LocalMedia localMedia) {
        if (localMedia == null) {
            return;
        }
        int size = this.folderWindow.getFolderData().size();
        LocalMediaFolder localMediaFolder = size > 0 ? this.folderWindow.getFolderData().get(0) : new LocalMediaFolder();
        if (localMediaFolder != null) {
            int imageNum = localMediaFolder.getImageNum();
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder.setImageNum(isAddSameImp(imageNum) ? localMediaFolder.getImageNum() : localMediaFolder.getImageNum() + 1);
            if (size == 0) {
                localMediaFolder.setName(getString(this.config.chooseMode == PictureMimeType.ofAudio() ? R.string.picture_all_audio : R.string.picture_camera_roll));
                localMediaFolder.setOfAllType(this.config.chooseMode);
                localMediaFolder.setCameraFolder(true);
                localMediaFolder.setChecked(true);
                localMediaFolder.setBucketId(-1L);
                this.folderWindow.getFolderData().add(0, localMediaFolder);
                LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
                localMediaFolder2.setName(localMedia.getParentFolderName());
                localMediaFolder2.setImageNum(isAddSameImp(imageNum) ? localMediaFolder2.getImageNum() : localMediaFolder2.getImageNum() + 1);
                localMediaFolder2.setFirstImagePath(localMedia.getPath());
                localMediaFolder2.setFirstMimeType(localMedia.getMimeType());
                localMediaFolder2.setBucketId(localMedia.getBucketId());
                this.folderWindow.getFolderData().add(this.folderWindow.getFolderData().size(), localMediaFolder2);
            } else {
                String str = (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isHasVideo(localMedia.getMimeType())) ? Environment.DIRECTORY_MOVIES : PictureMimeType.CAMERA;
                int i10 = 0;
                while (true) {
                    if (i10 < size) {
                        LocalMediaFolder localMediaFolder3 = this.folderWindow.getFolderData().get(i10);
                        if (TextUtils.isEmpty(localMediaFolder3.getName()) || !localMediaFolder3.getName().startsWith(str)) {
                            i10++;
                        } else {
                            localMedia.setBucketId(localMediaFolder3.getBucketId());
                            localMediaFolder3.setFirstImagePath(this.config.cameraPath);
                            localMediaFolder3.setFirstMimeType(localMedia.getMimeType());
                            localMediaFolder3.setImageNum(isAddSameImp(imageNum) ? localMediaFolder3.getImageNum() : localMediaFolder3.getImageNum() + 1);
                            if (localMediaFolder3.getData() != null && localMediaFolder3.getData().size() > 0) {
                                localMediaFolder3.getData().add(0, localMedia);
                            }
                        }
                    } else {
                        LocalMediaFolder localMediaFolder4 = new LocalMediaFolder();
                        localMediaFolder4.setName(localMedia.getParentFolderName());
                        localMediaFolder4.setImageNum(isAddSameImp(imageNum) ? localMediaFolder4.getImageNum() : localMediaFolder4.getImageNum() + 1);
                        localMediaFolder4.setFirstImagePath(localMedia.getPath());
                        localMediaFolder4.setFirstMimeType(localMedia.getMimeType());
                        localMediaFolder4.setBucketId(localMedia.getBucketId());
                        this.folderWindow.getFolderData().add(localMediaFolder4);
                        sortFolder(this.folderWindow.getFolderData());
                    }
                }
            }
            FolderPopWindow folderPopWindow = this.folderWindow;
            folderPopWindow.bindFolder(folderPopWindow.getFolderData());
        }
    }

    private void notifyAdapterData(LocalMedia localMedia) {
        if (this.mAdapter != null) {
            if (!isAddSameImp(this.folderWindow.getFolder(0) != null ? this.folderWindow.getFolder(0).getImageNum() : 0)) {
                this.mAdapter.getData().add(0, localMedia);
                this.mOpenCameraCount++;
            }
            if (checkVideoLegitimacy(localMedia)) {
                if (this.config.selectionMode == 1) {
                    dispatchHandleSingle(localMedia);
                } else {
                    dispatchHandleMultiple(localMedia);
                }
            }
            this.mAdapter.notifyItemInserted(this.config.isCamera ? 1 : 0);
            PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
            pictureImageGridAdapter.notifyItemRangeChanged(this.config.isCamera ? 1 : 0, pictureImageGridAdapter.getSize());
            if (this.config.isPageStrategy) {
                manualSaveFolderForPageModel(localMedia);
            } else {
                manualSaveFolder(localMedia);
            }
            this.mTvEmpty.setVisibility((this.mAdapter.getSize() > 0 || this.config.isSingleDirectReturn) ? 8 : 0);
            if (this.folderWindow.getFolder(0) != null) {
                this.mTvPictureTitle.setTag(R.id.view_count_tag, Integer.valueOf(this.folderWindow.getFolder(0).getImageNum()));
            }
            this.allFolderSize = 0;
        }
    }

    private void onComplete() {
        int i10;
        int i11;
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        int size = selectedData.size();
        LocalMedia localMedia = selectedData.size() > 0 ? selectedData.get(0) : null;
        String mimeType = localMedia != null ? localMedia.getMimeType() : "";
        boolean zIsHasImage = PictureMimeType.isHasImage(mimeType);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isWithVideoImage) {
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                if (PictureMimeType.isHasVideo(selectedData.get(i14).getMimeType())) {
                    i13++;
                } else {
                    i12++;
                }
            }
            PictureSelectionConfig pictureSelectionConfig2 = this.config;
            if (pictureSelectionConfig2.selectionMode == 2) {
                int i15 = pictureSelectionConfig2.minSelectNum;
                if (i15 > 0 && i12 < i15) {
                    showPromptDialog(getString(R.string.picture_min_img_num, Integer.valueOf(i15)));
                    return;
                }
                int i16 = pictureSelectionConfig2.minVideoSelectNum;
                if (i16 > 0 && i13 < i16) {
                    showPromptDialog(getString(R.string.picture_min_video_num, Integer.valueOf(i16)));
                    return;
                }
            }
        } else if (pictureSelectionConfig.selectionMode == 2) {
            if (PictureMimeType.isHasImage(mimeType) && (i11 = this.config.minSelectNum) > 0 && size < i11) {
                showPromptDialog(getString(R.string.picture_min_img_num, Integer.valueOf(i11)));
                return;
            } else if (PictureMimeType.isHasVideo(mimeType) && (i10 = this.config.minVideoSelectNum) > 0 && size < i10) {
                showPromptDialog(getString(R.string.picture_min_video_num, Integer.valueOf(i10)));
                return;
            }
        }
        PictureSelectionConfig pictureSelectionConfig3 = this.config;
        if (!pictureSelectionConfig3.returnEmpty || size != 0) {
            if (pictureSelectionConfig3.chooseMode == PictureMimeType.ofAll() && this.config.isWithVideoImage) {
                bothMimeTypeWith(zIsHasImage, selectedData);
                return;
            } else {
                separateMimeTypeWith(zIsHasImage, selectedData);
                return;
            }
        }
        if (pictureSelectionConfig3.selectionMode == 2) {
            int i17 = pictureSelectionConfig3.minSelectNum;
            if (i17 > 0 && size < i17) {
                showPromptDialog(getString(R.string.picture_min_img_num, Integer.valueOf(i17)));
                return;
            }
            int i18 = pictureSelectionConfig3.minVideoSelectNum;
            if (i18 > 0 && size < i18) {
                showPromptDialog(getString(R.string.picture_min_video_num, Integer.valueOf(i18)));
                return;
            }
        }
        OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onResult(selectedData);
        } else {
            setResult(-1, PictureSelector.putIntentResult(selectedData));
        }
        exit();
    }

    private void onPreview() {
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        int size = selectedData.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(selectedData.get(i10));
        }
        OnCustomImagePreviewCallback<LocalMedia> onCustomImagePreviewCallback = PictureSelectionConfig.onCustomImagePreviewCallback;
        if (onCustomImagePreviewCallback != null) {
            onCustomImagePreviewCallback.onCustomPreviewCallback(getContext(), selectedData, 0);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, arrayList);
        bundle.putParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) selectedData);
        bundle.putBoolean(PictureConfig.EXTRA_BOTTOM_PREVIEW, true);
        bundle.putBoolean(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
        bundle.putBoolean(PictureConfig.EXTRA_SHOW_CAMERA, this.mAdapter.isShowCamera());
        bundle.putString(PictureConfig.EXTRA_IS_CURRENT_DIRECTORY, this.mTvPictureTitle.getText().toString());
        Context context = getContext();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        JumpUtils.startPicturePreviewActivity(context, pictureSelectionConfig.isWeChatStyle, bundle, pictureSelectionConfig.selectionMode == 1 ? 69 : UCrop.REQUEST_MULTI_CROP);
        overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation, R.anim.picture_anim_fade_in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAudio() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            this.musicSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            this.musicSeekBar.setMax(this.mediaPlayer.getDuration());
        }
        String string = this.mTvPlayPause.getText().toString();
        int i10 = R.string.picture_play_audio;
        if (string.equals(getString(i10))) {
            this.mTvPlayPause.setText(getString(R.string.picture_pause_audio));
            this.mTvMusicStatus.setText(getString(i10));
        } else {
            this.mTvPlayPause.setText(getString(i10));
            this.mTvMusicStatus.setText(getString(R.string.picture_pause_audio));
        }
        playOrPause();
        if (this.isPlayAudio) {
            return;
        }
        this.mHandler.post(this.mRunnable);
        this.isPlayAudio = true;
    }

    private void previewCallback(Intent intent) {
        if (intent == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isOriginalControl) {
            pictureSelectionConfig.isCheckOriginalImage = intent.getBooleanExtra(PictureConfig.EXTRA_CHANGE_ORIGINAL, pictureSelectionConfig.isCheckOriginalImage);
            this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST);
        if (this.mAdapter == null || parcelableArrayListExtra == null) {
            return;
        }
        int i10 = 0;
        if (intent.getBooleanExtra(PictureConfig.EXTRA_COMPLETE_SELECTED, false)) {
            onChangeData(parcelableArrayListExtra);
            if (this.config.isWithVideoImage) {
                int size = parcelableArrayListExtra.size();
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    if (!PictureMimeType.isHasImage(parcelableArrayListExtra.get(i10).getMimeType())) {
                        i10++;
                    } else if (!this.config.isCompress) {
                        break;
                    } else {
                        compressImage(parcelableArrayListExtra);
                    }
                }
                onResult(parcelableArrayListExtra);
            } else {
                String mimeType = parcelableArrayListExtra.size() > 0 ? parcelableArrayListExtra.get(0).getMimeType() : "";
                if (this.config.isCompress && PictureMimeType.isHasImage(mimeType)) {
                    compressImage(parcelableArrayListExtra);
                } else {
                    onResult(parcelableArrayListExtra);
                }
            }
        } else {
            this.isStartAnimation = true;
        }
        this.mAdapter.bindSelectData(parcelableArrayListExtra);
        this.mAdapter.notifyDataSetChanged();
    }

    private void separateMimeTypeWith(boolean z10, List<LocalMedia> list) {
        LocalMedia localMedia = list.size() > 0 ? list.get(0) : null;
        if (localMedia == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enableCrop && !pictureSelectionConfig.isCheckOriginalImage && z10) {
            if (pictureSelectionConfig.selectionMode != 1) {
                UCropManager.ofCrop(this, (ArrayList) list);
                return;
            } else {
                pictureSelectionConfig.originalPath = localMedia.getPath();
                UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType());
                return;
            }
        }
        if (pictureSelectionConfig.isCompress && z10) {
            compressImage(list);
        } else {
            onResult(list);
        }
    }

    private void setLastCacheFolderData() {
        LocalMediaFolder folder = this.folderWindow.getFolder(ValueOf.toInt(this.mTvPictureTitle.getTag(R.id.view_index_tag)));
        folder.setData(this.mAdapter.getData());
        folder.setCurrentDataPage(this.mPage);
        folder.setHasMore(this.isHasMore);
    }

    private void showDataNull(String str, int i10) {
        if (this.mTvEmpty.getVisibility() == 8 || this.mTvEmpty.getVisibility() == 4) {
            this.mTvEmpty.setCompoundDrawablesRelativeWithIntrinsicBounds(0, i10, 0, 0);
            this.mTvEmpty.setText(str);
            this.mTvEmpty.setVisibility(0);
        }
    }

    private void singleCropHandleResult(Intent intent) {
        Uri output;
        if (intent == null || (output = UCrop.getOutput(intent)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String path = output.getPath();
        if (this.mAdapter != null) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST);
            if (parcelableArrayListExtra != null) {
                this.mAdapter.bindSelectData(parcelableArrayListExtra);
                this.mAdapter.notifyDataSetChanged();
            }
            List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
            LocalMedia localMedia = null;
            LocalMedia localMedia2 = (selectedData == null || selectedData.size() <= 0) ? null : selectedData.get(0);
            if (localMedia2 != null) {
                this.config.originalPath = localMedia2.getPath();
                localMedia2.setCutPath(path);
                localMedia2.setChooseModel(this.config.chooseMode);
                boolean z10 = !TextUtils.isEmpty(path);
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(localMedia2.getPath())) {
                    localMedia2.setAndroidQToPath(path);
                }
                localMedia2.setCut(z10);
                arrayList.add(localMedia2);
                handlerResult(arrayList);
                return;
            }
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                localMedia = (LocalMedia) parcelableArrayListExtra.get(0);
            }
            if (localMedia != null) {
                this.config.originalPath = localMedia.getPath();
                localMedia.setCutPath(path);
                localMedia.setChooseModel(this.config.chooseMode);
                boolean z11 = !TextUtils.isEmpty(path);
                if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(localMedia.getPath())) {
                    localMedia.setAndroidQToPath(path);
                }
                localMedia.setCut(z11);
                arrayList.add(localMedia);
                handlerResult(arrayList);
            }
        }
    }

    private void singleDirectReturnCameraHandleResult(String str) {
        boolean zIsHasImage = PictureMimeType.isHasImage(str);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enableCrop && !pictureSelectionConfig.isCheckOriginalImage && zIsHasImage) {
            String str2 = pictureSelectionConfig.cameraPath;
            pictureSelectionConfig.originalPath = str2;
            UCropManager.ofCrop(this, str2, str);
        } else if (pictureSelectionConfig.isCompress && zIsHasImage) {
            compressImage(this.mAdapter.getSelectedData());
        } else {
            onResult(this.mAdapter.getSelectedData());
        }
    }

    private void singleRadioMediaImage() {
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        if (selectedData == null || selectedData.size() <= 0) {
            return;
        }
        int position = selectedData.get(0).getPosition();
        selectedData.clear();
        this.mAdapter.notifyItemChanged(position);
    }

    private void startCustomCamera() {
        if (!PermissionChecker.checkSelfPermission(this, PolicySdkPermissionManifestUtils.RECORD_AUDIO)) {
            PermissionChecker.requestPermissions(this, new String[]{PolicySdkPermissionManifestUtils.RECORD_AUDIO}, 4);
        } else {
            startActivityForResult(new Intent(this, (Class<?>) PictureCustomCameraActivity.class), PictureConfig.REQUEST_CAMERA);
            overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityEnterAnimation, R.anim.picture_anim_fade_in);
        }
    }

    private void startPlayAudioDialog(final String str) {
        if (isFinishing()) {
            return;
        }
        PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_audio_dialog);
        this.audioDialog = pictureCustomDialog;
        pictureCustomDialog.getWindow().setWindowAnimations(R.style.Picture_Theme_Dialog_AudioStyle);
        this.mTvMusicStatus = (TextView) this.audioDialog.findViewById(R.id.tv_musicStatus);
        this.mTvMusicTime = (TextView) this.audioDialog.findViewById(R.id.tv_musicTime);
        this.musicSeekBar = (SeekBar) this.audioDialog.findViewById(R.id.musicSeekBar);
        this.mTvMusicTotal = (TextView) this.audioDialog.findViewById(R.id.tv_musicTotal);
        this.mTvPlayPause = (TextView) this.audioDialog.findViewById(R.id.tv_PlayPause);
        this.mTvStop = (TextView) this.audioDialog.findViewById(R.id.tv_Stop);
        this.mTvQuit = (TextView) this.audioDialog.findViewById(R.id.tv_Quit);
        this.mHandler.postDelayed(new Runnable() { // from class: com.zyql.ai.selector.PictureSelectorActivity.3
            @Override // java.lang.Runnable
            public void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                PictureSelectorActivity.this.initPlayer(str);
            }
        }, 30L);
        this.mTvPlayPause.setOnClickListener(new onAudioOnClick(str));
        this.mTvStop.setOnClickListener(new onAudioOnClick(str));
        this.mTvQuit.setOnClickListener(new onAudioOnClick(str));
        this.musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.zyql.ai.selector.PictureSelectorActivity.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) throws IllegalStateException {
                if (z10) {
                    PictureSelectorActivity.this.mediaPlayer.seekTo(i10);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.audioDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zyql.ai.selector.z
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f32016a.lambda$startPlayAudioDialog$5(str, dialogInterface);
            }
        });
        this.mHandler.post(this.mRunnable);
        this.audioDialog.show();
    }

    private void synchronousCover() {
        if (this.config.chooseMode == PictureMimeType.ofAll()) {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<Boolean>() { // from class: com.zyql.ai.selector.PictureSelectorActivity.2
                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public void onSuccess(Boolean bool) {
                }

                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public Boolean doInBackground() {
                    int size = PictureSelectorActivity.this.folderWindow.getFolderData().size();
                    for (int i10 = 0; i10 < size; i10++) {
                        LocalMediaFolder folder = PictureSelectorActivity.this.folderWindow.getFolder(i10);
                        if (folder != null) {
                            folder.setFirstImagePath(LocalMediaPageLoader.getInstance(PictureSelectorActivity.this.getContext()).getFirstCover(folder.getBucketId()));
                        }
                    }
                    return Boolean.TRUE;
                }
            });
        }
    }

    private void updateMediaFolder(List<LocalMediaFolder> list, LocalMedia localMedia) {
        File parentFile = new File(localMedia.getRealPath()).getParentFile();
        if (parentFile == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            LocalMediaFolder localMediaFolder = list.get(i10);
            String name = localMediaFolder.getName();
            if (!TextUtils.isEmpty(name) && name.equals(parentFile.getName())) {
                localMediaFolder.setFirstImagePath(this.config.cameraPath);
                localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                localMediaFolder.setCheckedNum(1);
                localMediaFolder.getData().add(0, localMedia);
                return;
            }
        }
    }

    public void changeImageNumber(List<LocalMedia> list) {
        if (list.size() == 0) {
            this.mTvPictureOk.setEnabled(this.config.returnEmpty);
            this.mTvPictureOk.setSelected(false);
            this.mTvPicturePreview.setEnabled(false);
            this.mTvPicturePreview.setSelected(false);
            PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle != null) {
                int i10 = pictureSelectorUIStyle.picture_bottom_previewDefaultText;
                if (i10 != 0) {
                    this.mTvPicturePreview.setText(getString(i10));
                } else {
                    this.mTvPicturePreview.setText(getString(R.string.picture_preview));
                }
            } else {
                PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
                if (pictureParameterStyle != null) {
                    int i11 = pictureParameterStyle.pictureUnCompleteTextColor;
                    if (i11 != 0) {
                        this.mTvPictureOk.setTextColor(i11);
                    }
                    int i12 = PictureSelectionConfig.style.pictureUnPreviewTextColor;
                    if (i12 != 0) {
                        this.mTvPicturePreview.setTextColor(i12);
                    }
                    if (TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnPreviewText)) {
                        this.mTvPicturePreview.setText(getString(R.string.picture_preview));
                    } else {
                        this.mTvPicturePreview.setText(PictureSelectionConfig.style.pictureUnPreviewText);
                    }
                }
            }
            if (this.numComplete) {
                initCompleteText(list.size());
                return;
            }
            this.mTvPictureImgNum.setVisibility(4);
            PictureSelectorUIStyle pictureSelectorUIStyle2 = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle2 != null) {
                int i13 = pictureSelectorUIStyle2.picture_bottom_completeDefaultText;
                if (i13 != 0) {
                    this.mTvPictureOk.setText(getString(i13));
                    return;
                }
                return;
            }
            PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
            if (pictureParameterStyle2 == null) {
                this.mTvPictureOk.setText(getString(R.string.picture_please_select));
                return;
            } else {
                if (TextUtils.isEmpty(pictureParameterStyle2.pictureUnCompleteText)) {
                    return;
                }
                this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureUnCompleteText);
                return;
            }
        }
        this.mTvPictureOk.setEnabled(true);
        this.mTvPictureOk.setSelected(true);
        this.mTvPicturePreview.setEnabled(true);
        this.mTvPicturePreview.setSelected(true);
        PictureSelectorUIStyle pictureSelectorUIStyle3 = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle3 != null) {
            int i14 = pictureSelectorUIStyle3.picture_bottom_previewNormalText;
            if (i14 == 0) {
                this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, Integer.valueOf(list.size())));
            } else if (pictureSelectorUIStyle3.isCompleteReplaceNum) {
                this.mTvPicturePreview.setText(String.format(getString(i14), Integer.valueOf(list.size())));
            } else {
                this.mTvPicturePreview.setText(i14);
            }
        } else {
            PictureParameterStyle pictureParameterStyle3 = PictureSelectionConfig.style;
            if (pictureParameterStyle3 != null) {
                int i15 = pictureParameterStyle3.pictureCompleteTextColor;
                if (i15 != 0) {
                    this.mTvPictureOk.setTextColor(i15);
                }
                int i16 = PictureSelectionConfig.style.picturePreviewTextColor;
                if (i16 != 0) {
                    this.mTvPicturePreview.setTextColor(i16);
                }
                if (TextUtils.isEmpty(PictureSelectionConfig.style.picturePreviewText)) {
                    this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, Integer.valueOf(list.size())));
                } else {
                    this.mTvPicturePreview.setText(PictureSelectionConfig.style.picturePreviewText);
                }
            }
        }
        if (this.numComplete) {
            initCompleteText(list.size());
            return;
        }
        if (!this.isStartAnimation) {
            this.mTvPictureImgNum.startAnimation(this.animation);
        }
        this.mTvPictureImgNum.setVisibility(0);
        this.mTvPictureImgNum.setText(ValueOf.toString(Integer.valueOf(list.size())));
        PictureSelectorUIStyle pictureSelectorUIStyle4 = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle4 != null) {
            int i17 = pictureSelectorUIStyle4.picture_bottom_completeNormalText;
            if (i17 != 0) {
                this.mTvPictureOk.setText(getString(i17));
            }
        } else {
            PictureParameterStyle pictureParameterStyle4 = PictureSelectionConfig.style;
            if (pictureParameterStyle4 == null) {
                this.mTvPictureOk.setText(getString(R.string.picture_completed));
            } else if (!TextUtils.isEmpty(pictureParameterStyle4.pictureCompleteText)) {
                this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureCompleteText);
            }
        }
        this.isStartAnimation = false;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_selector;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initCompleteText(int i10) {
        if (this.config.selectionMode == 1) {
            if (i10 <= 0) {
                PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
                if (pictureSelectorUIStyle == null) {
                    PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
                    if (pictureParameterStyle != null) {
                        if (!pictureParameterStyle.isCompleteReplaceNum || TextUtils.isEmpty(pictureParameterStyle.pictureUnCompleteText)) {
                            this.mTvPictureOk.setText(!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : getString(R.string.picture_done));
                            return;
                        } else {
                            this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureUnCompleteText, Integer.valueOf(i10), 1));
                            return;
                        }
                    }
                    return;
                }
                if (pictureSelectorUIStyle.isCompleteReplaceNum) {
                    TextView textView = this.mTvPictureOk;
                    int i11 = pictureSelectorUIStyle.picture_bottom_completeDefaultText;
                    textView.setText(i11 != 0 ? String.format(getString(i11), Integer.valueOf(i10), 1) : getString(R.string.picture_please_select));
                    return;
                } else {
                    TextView textView2 = this.mTvPictureOk;
                    int i12 = pictureSelectorUIStyle.picture_bottom_completeDefaultText;
                    if (i12 == 0) {
                        i12 = R.string.picture_please_select;
                    }
                    textView2.setText(getString(i12));
                    return;
                }
            }
            PictureSelectorUIStyle pictureSelectorUIStyle2 = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle2 == null) {
                PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
                if (pictureParameterStyle2 != null) {
                    if (!pictureParameterStyle2.isCompleteReplaceNum || TextUtils.isEmpty(pictureParameterStyle2.pictureCompleteText)) {
                        this.mTvPictureOk.setText(!TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText) ? PictureSelectionConfig.style.pictureCompleteText : getString(R.string.picture_done));
                        return;
                    } else {
                        this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(i10), 1));
                        return;
                    }
                }
                return;
            }
            if (pictureSelectorUIStyle2.isCompleteReplaceNum) {
                TextView textView3 = this.mTvPictureOk;
                int i13 = pictureSelectorUIStyle2.picture_bottom_completeNormalText;
                textView3.setText(i13 != 0 ? String.format(getString(i13), Integer.valueOf(i10), 1) : getString(R.string.picture_done));
                return;
            } else {
                TextView textView4 = this.mTvPictureOk;
                int i14 = pictureSelectorUIStyle2.picture_bottom_completeNormalText;
                if (i14 == 0) {
                    i14 = R.string.picture_done;
                }
                textView4.setText(getString(i14));
                return;
            }
        }
        if (i10 <= 0) {
            PictureSelectorUIStyle pictureSelectorUIStyle3 = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle3 == null) {
                PictureParameterStyle pictureParameterStyle3 = PictureSelectionConfig.style;
                if (pictureParameterStyle3 != null) {
                    if (pictureParameterStyle3.isCompleteReplaceNum) {
                        this.mTvPictureOk.setText(!TextUtils.isEmpty(pictureParameterStyle3.pictureUnCompleteText) ? String.format(PictureSelectionConfig.style.pictureUnCompleteText, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)) : getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                        return;
                    } else {
                        this.mTvPictureOk.setText(!TextUtils.isEmpty(pictureParameterStyle3.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                        return;
                    }
                }
                return;
            }
            if (pictureSelectorUIStyle3.isCompleteReplaceNum) {
                TextView textView5 = this.mTvPictureOk;
                int i15 = pictureSelectorUIStyle3.picture_bottom_completeDefaultText;
                textView5.setText(i15 != 0 ? String.format(getString(i15), Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)) : getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                return;
            } else {
                TextView textView6 = this.mTvPictureOk;
                int i16 = pictureSelectorUIStyle3.picture_bottom_completeDefaultText;
                textView6.setText(i16 != 0 ? getString(i16) : getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                return;
            }
        }
        PictureSelectorUIStyle pictureSelectorUIStyle4 = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle4 != null) {
            if (pictureSelectorUIStyle4.isCompleteReplaceNum) {
                int i17 = pictureSelectorUIStyle4.picture_bottom_completeNormalText;
                if (i17 != 0) {
                    this.mTvPictureOk.setText(String.format(getString(i17), Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                } else {
                    this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                }
            }
            int i18 = pictureSelectorUIStyle4.picture_bottom_completeNormalText;
            if (i18 != 0) {
                this.mTvPictureOk.setText(getString(i18));
                return;
            } else {
                this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                return;
            }
        }
        PictureParameterStyle pictureParameterStyle4 = PictureSelectionConfig.style;
        if (pictureParameterStyle4 != null) {
            if (pictureParameterStyle4.isCompleteReplaceNum) {
                if (TextUtils.isEmpty(pictureParameterStyle4.pictureCompleteText)) {
                    this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                } else {
                    this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                }
            }
            if (TextUtils.isEmpty(pictureParameterStyle4.pictureCompleteText)) {
                this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
            } else {
                this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureCompleteText);
            }
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initPictureSelectorStyle() throws Resources.NotFoundException {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle != null) {
            int i10 = pictureSelectorUIStyle.picture_top_titleArrowDownDrawable;
            if (i10 != 0) {
                this.mIvArrow.setImageDrawable(androidx.core.content.a.e(this, i10));
            }
            int i11 = PictureSelectionConfig.uiStyle.picture_top_titleTextColor;
            if (i11 != 0) {
                this.mTvPictureTitle.setTextColor(i11);
            }
            int i12 = PictureSelectionConfig.uiStyle.picture_top_titleTextSize;
            if (i12 != 0) {
                this.mTvPictureTitle.setTextSize(i12);
            }
            int[] iArr = PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor;
            if (iArr.length > 0 && (colorStateList3 = AttrsUtils.getColorStateList(iArr)) != null) {
                this.mTvPictureRight.setTextColor(colorStateList3);
            }
            int i13 = PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize;
            if (i13 != 0) {
                this.mTvPictureRight.setTextSize(i13);
            }
            int i14 = PictureSelectionConfig.uiStyle.picture_top_leftBack;
            if (i14 != 0) {
                this.mIvPictureLeftBack.setImageResource(i14);
            }
            int[] iArr2 = PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor;
            if (iArr2.length > 0 && (colorStateList2 = AttrsUtils.getColorStateList(iArr2)) != null) {
                this.mTvPicturePreview.setTextColor(colorStateList2);
            }
            int i15 = PictureSelectionConfig.uiStyle.picture_bottom_previewTextSize;
            if (i15 != 0) {
                this.mTvPicturePreview.setTextSize(i15);
            }
            int i16 = PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground;
            if (i16 != 0) {
                this.mTvPictureImgNum.setBackgroundResource(i16);
            }
            int i17 = PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextSize;
            if (i17 != 0) {
                this.mTvPictureImgNum.setTextSize(i17);
            }
            int i18 = PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotTextColor;
            if (i18 != 0) {
                this.mTvPictureImgNum.setTextColor(i18);
            }
            int[] iArr3 = PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor;
            if (iArr3.length > 0 && (colorStateList = AttrsUtils.getColorStateList(iArr3)) != null) {
                this.mTvPictureOk.setTextColor(colorStateList);
            }
            int i19 = PictureSelectionConfig.uiStyle.picture_bottom_completeTextSize;
            if (i19 != 0) {
                this.mTvPictureOk.setTextSize(i19);
            }
            int i20 = PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor;
            if (i20 != 0) {
                this.mBottomLayout.setBackgroundColor(i20);
            }
            int i21 = PictureSelectionConfig.uiStyle.picture_container_backgroundColor;
            if (i21 != 0) {
                this.container.setBackgroundColor(i21);
            }
            int i22 = PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText;
            if (i22 != 0) {
                this.mTvPictureRight.setText(i22);
            }
            int i23 = PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText;
            if (i23 != 0) {
                this.mTvPictureOk.setText(i23);
            }
            int i24 = PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText;
            if (i24 != 0) {
                this.mTvPicturePreview.setText(i24);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleArrowLeftPadding != 0) {
                ((RelativeLayout.LayoutParams) this.mIvArrow.getLayoutParams()).leftMargin = PictureSelectionConfig.uiStyle.picture_top_titleArrowLeftPadding;
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_top_titleBarHeight;
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barHeight > 0) {
                this.mBottomLayout.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_bottom_barHeight;
            }
            if (this.config.isOriginalControl) {
                int i25 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle;
                if (i25 != 0) {
                    this.mCbOriginal.setButtonDrawable(i25);
                } else {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_checkbox));
                }
                int i26 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor;
                if (i26 != 0) {
                    this.mCbOriginal.setTextColor(i26);
                } else {
                    this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_white));
                }
                int i27 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize;
                if (i27 != 0) {
                    this.mCbOriginal.setTextSize(i27);
                }
                int i28 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText;
                if (i28 != 0) {
                    this.mCbOriginal.setText(i28);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_white));
            }
        } else {
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle != null) {
                int i29 = pictureParameterStyle.pictureTitleDownResId;
                if (i29 != 0) {
                    this.mIvArrow.setImageDrawable(androidx.core.content.a.e(this, i29));
                }
                int i30 = PictureSelectionConfig.style.pictureTitleTextColor;
                if (i30 != 0) {
                    this.mTvPictureTitle.setTextColor(i30);
                }
                int i31 = PictureSelectionConfig.style.pictureTitleTextSize;
                if (i31 != 0) {
                    this.mTvPictureTitle.setTextSize(i31);
                }
                PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
                int i32 = pictureParameterStyle2.pictureRightDefaultTextColor;
                if (i32 != 0) {
                    this.mTvPictureRight.setTextColor(i32);
                } else {
                    int i33 = pictureParameterStyle2.pictureCancelTextColor;
                    if (i33 != 0) {
                        this.mTvPictureRight.setTextColor(i33);
                    }
                }
                int i34 = PictureSelectionConfig.style.pictureRightTextSize;
                if (i34 != 0) {
                    this.mTvPictureRight.setTextSize(i34);
                }
                int i35 = PictureSelectionConfig.style.pictureLeftBackIcon;
                if (i35 != 0) {
                    this.mIvPictureLeftBack.setImageResource(i35);
                }
                int i36 = PictureSelectionConfig.style.pictureUnPreviewTextColor;
                if (i36 != 0) {
                    this.mTvPicturePreview.setTextColor(i36);
                }
                int i37 = PictureSelectionConfig.style.picturePreviewTextSize;
                if (i37 != 0) {
                    this.mTvPicturePreview.setTextSize(i37);
                }
                int i38 = PictureSelectionConfig.style.pictureCheckNumBgStyle;
                if (i38 != 0) {
                    this.mTvPictureImgNum.setBackgroundResource(i38);
                }
                int i39 = PictureSelectionConfig.style.pictureUnCompleteTextColor;
                if (i39 != 0) {
                    this.mTvPictureOk.setTextColor(i39);
                }
                int i40 = PictureSelectionConfig.style.pictureCompleteTextSize;
                if (i40 != 0) {
                    this.mTvPictureOk.setTextSize(i40);
                }
                int i41 = PictureSelectionConfig.style.pictureBottomBgColor;
                if (i41 != 0) {
                    this.mBottomLayout.setBackgroundColor(i41);
                }
                int i42 = PictureSelectionConfig.style.pictureContainerBackgroundColor;
                if (i42 != 0) {
                    this.container.setBackgroundColor(i42);
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureRightDefaultText)) {
                    this.mTvPictureRight.setText(PictureSelectionConfig.style.pictureRightDefaultText);
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                    this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureUnCompleteText);
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnPreviewText)) {
                    this.mTvPicturePreview.setText(PictureSelectionConfig.style.pictureUnPreviewText);
                }
                if (PictureSelectionConfig.style.pictureTitleRightArrowLeftPadding != 0) {
                    ((RelativeLayout.LayoutParams) this.mIvArrow.getLayoutParams()).leftMargin = PictureSelectionConfig.style.pictureTitleRightArrowLeftPadding;
                }
                if (PictureSelectionConfig.style.pictureTitleBarHeight > 0) {
                    this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.style.pictureTitleBarHeight;
                }
                if (this.config.isOriginalControl) {
                    int i43 = PictureSelectionConfig.style.pictureOriginalControlStyle;
                    if (i43 != 0) {
                        this.mCbOriginal.setButtonDrawable(i43);
                    } else {
                        this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_checkbox));
                    }
                    int i44 = PictureSelectionConfig.style.pictureOriginalFontColor;
                    if (i44 != 0) {
                        this.mCbOriginal.setTextColor(i44);
                    } else {
                        this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_white));
                    }
                    int i45 = PictureSelectionConfig.style.pictureOriginalTextSize;
                    if (i45 != 0) {
                        this.mCbOriginal.setTextSize(i45);
                    }
                } else {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_checkbox));
                    this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_white));
                }
            } else {
                int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_title_textColor);
                if (typeValueColor != 0) {
                    this.mTvPictureTitle.setTextColor(typeValueColor);
                }
                int typeValueColor2 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_right_textColor);
                if (typeValueColor2 != 0) {
                    this.mTvPictureRight.setTextColor(typeValueColor2);
                }
                int typeValueColor3 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_container_backgroundColor);
                if (typeValueColor3 != 0) {
                    this.container.setBackgroundColor(typeValueColor3);
                }
                this.mIvPictureLeftBack.setImageDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_leftBack_icon, R.drawable.picture_icon_back));
                int i46 = this.config.downResId;
                if (i46 != 0) {
                    this.mIvArrow.setImageDrawable(androidx.core.content.a.e(this, i46));
                } else {
                    this.mIvArrow.setImageDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_arrow_down_icon, R.drawable.picture_icon_arrow_down));
                }
                int typeValueColor4 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_bottom_bg);
                if (typeValueColor4 != 0) {
                    this.mBottomLayout.setBackgroundColor(typeValueColor4);
                }
                ColorStateList typeValueColorStateList = AttrsUtils.getTypeValueColorStateList(getContext(), R.attr.picture_complete_textColor);
                if (typeValueColorStateList != null) {
                    this.mTvPictureOk.setTextColor(typeValueColorStateList);
                }
                ColorStateList typeValueColorStateList2 = AttrsUtils.getTypeValueColorStateList(getContext(), R.attr.picture_preview_textColor);
                if (typeValueColorStateList2 != null) {
                    this.mTvPicturePreview.setTextColor(typeValueColorStateList2);
                }
                int typeValueSizeForInt = AttrsUtils.getTypeValueSizeForInt(getContext(), R.attr.picture_titleRightArrow_LeftPadding);
                if (typeValueSizeForInt != 0) {
                    ((RelativeLayout.LayoutParams) this.mIvArrow.getLayoutParams()).leftMargin = typeValueSizeForInt;
                }
                this.mTvPictureImgNum.setBackground(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_num_style, R.drawable.picture_num_oval));
                int typeValueSizeForInt2 = AttrsUtils.getTypeValueSizeForInt(getContext(), R.attr.picture_titleBar_height);
                if (typeValueSizeForInt2 > 0) {
                    this.mTitleBar.getLayoutParams().height = typeValueSizeForInt2;
                }
                if (this.config.isOriginalControl) {
                    this.mCbOriginal.setButtonDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_original_check_style, R.drawable.picture_original_wechat_checkbox));
                    int typeValueColor5 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_original_text_color);
                    if (typeValueColor5 != 0) {
                        this.mCbOriginal.setTextColor(typeValueColor5);
                    }
                }
            }
        }
        this.mTitleBar.setBackgroundColor(this.colorPrimary);
        this.mAdapter.bindSelectData(this.selectionMedias);
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initWidgets() {
        super.initWidgets();
        this.container = findViewById(R.id.container);
        this.mTitleBar = findViewById(R.id.titleBar);
        this.mIvPictureLeftBack = (ImageView) findViewById(R.id.pictureLeftBack);
        this.mTvPictureTitle = (TextView) findViewById(R.id.picture_title);
        this.mTvPictureRight = (TextView) findViewById(R.id.picture_right);
        this.mTvPictureOk = (TextView) findViewById(R.id.picture_tv_ok);
        this.mCbOriginal = (CheckBox) findViewById(R.id.cb_original);
        this.mIvArrow = (ImageView) findViewById(R.id.ivArrow);
        this.viewClickMask = findViewById(R.id.viewClickMask);
        this.mTvPicturePreview = (TextView) findViewById(R.id.picture_id_preview);
        this.mTvPictureImgNum = (TextView) findViewById(R.id.tv_media_num);
        this.mRecyclerView = (RecyclerPreloadView) findViewById(R.id.picture_recycler);
        this.mBottomLayout = (RelativeLayout) findViewById(R.id.select_bar_layout);
        this.mTvEmpty = (TextView) findViewById(R.id.tv_empty);
        isNumComplete(this.numComplete);
        if (!this.numComplete) {
            this.animation = AnimationUtils.loadAnimation(this, R.anim.picture_anim_modal_in);
        }
        this.mTvPicturePreview.setOnClickListener(this);
        if (this.config.isAutomaticTitleRecyclerTop) {
            this.mTitleBar.setOnClickListener(this);
        }
        this.mTvPicturePreview.setVisibility((this.config.chooseMode == PictureMimeType.ofAudio() || !this.config.enablePreview) ? 8 : 0);
        RelativeLayout relativeLayout = this.mBottomLayout;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        relativeLayout.setVisibility((pictureSelectionConfig.selectionMode == 1 && pictureSelectionConfig.isSingleDirectReturn) ? 8 : 0);
        this.mIvPictureLeftBack.setOnClickListener(this);
        this.mTvPictureRight.setOnClickListener(this);
        this.mTvPictureOk.setOnClickListener(this);
        this.viewClickMask.setOnClickListener(this);
        this.mTvPictureImgNum.setOnClickListener(this);
        this.mTvPictureTitle.setOnClickListener(this);
        this.mIvArrow.setOnClickListener(this);
        this.mTvPictureTitle.setText(getString(this.config.chooseMode == PictureMimeType.ofAudio() ? R.string.picture_all_audio : R.string.picture_camera_roll));
        this.mTvPictureTitle.setTag(R.id.view_tag, -1);
        FolderPopWindow folderPopWindow = new FolderPopWindow(this);
        this.folderWindow = folderPopWindow;
        folderPopWindow.setArrowImageView(this.mIvArrow);
        this.folderWindow.setOnAlbumItemClickListener(this);
        RecyclerPreloadView recyclerPreloadView = this.mRecyclerView;
        int i10 = this.config.imageSpanCount;
        if (i10 <= 0) {
            i10 = 4;
        }
        recyclerPreloadView.addItemDecoration(new GridSpacingItemDecoration(i10, ScreenUtils.dip2px(this, 2.0f), false));
        RecyclerPreloadView recyclerPreloadView2 = this.mRecyclerView;
        Context context = getContext();
        int i11 = this.config.imageSpanCount;
        recyclerPreloadView2.setLayoutManager(new GridLayoutManager(context, i11 > 0 ? i11 : 4));
        if (this.config.isPageStrategy) {
            this.mRecyclerView.setReachBottomRow(2);
            this.mRecyclerView.setOnRecyclerViewPreloadListener(this);
        } else {
            this.mRecyclerView.setHasFixedSize(true);
        }
        RecyclerView.ItemAnimator itemAnimator = this.mRecyclerView.getItemAnimator();
        if (itemAnimator != null) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            this.mRecyclerView.setItemAnimator(null);
        }
        loadAllMediaData();
        this.mTvEmpty.setText(this.config.chooseMode == PictureMimeType.ofAudio() ? getString(R.string.picture_audio_empty) : getString(R.string.picture_empty));
        StringUtils.tempTextFont(this.mTvEmpty, this.config.chooseMode);
        PictureImageGridAdapter pictureImageGridAdapter = new PictureImageGridAdapter(getContext(), this.config);
        this.mAdapter = pictureImageGridAdapter;
        pictureImageGridAdapter.setOnPhotoSelectChangedListener(this);
        int i12 = this.config.animationMode;
        if (i12 == 1) {
            this.mRecyclerView.setAdapter(new AlphaInAnimationAdapter(this.mAdapter));
        } else if (i12 != 2) {
            this.mRecyclerView.setAdapter(this.mAdapter);
        } else {
            this.mRecyclerView.setAdapter(new SlideInBottomAnimationAdapter(this.mAdapter));
        }
        if (this.config.isOriginalControl) {
            this.mCbOriginal.setVisibility(0);
            this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
            this.mCbOriginal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zyql.ai.selector.v
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    this.f32009a.lambda$initWidgets$1(compoundButton, z10);
                }
            });
        }
    }

    public void multiCropHandleResult(Intent intent) {
        ArrayList<LocalMedia> multipleOutput;
        if (intent == null || (multipleOutput = UCrop.getMultipleOutput(intent)) == null || multipleOutput.size() <= 0) {
            return;
        }
        this.mAdapter.bindSelectData(multipleOutput);
        this.mAdapter.notifyDataSetChanged();
        handlerResult(multipleOutput);
    }

    @Override // androidx.fragment.app.r, b.q, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws Throwable {
        Throwable th;
        ArrayList parcelableArrayListExtra;
        super.onActivityResult(i10, i11, intent);
        if (i11 != -1) {
            if (i11 == 0) {
                previewCallback(intent);
                if (i10 == 909) {
                    MediaUtils.deleteCamera(this, this.config.cameraPath);
                    return;
                }
                return;
            }
            if (i11 != 96 || intent == null || (th = (Throwable) intent.getSerializableExtra(UCrop.EXTRA_ERROR)) == null) {
                return;
            }
            ToastUtils.s(getContext(), th.getMessage());
            return;
        }
        if (i10 == 69) {
            singleCropHandleResult(intent);
            return;
        }
        if (i10 == 166) {
            if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST)) == null || parcelableArrayListExtra.size() <= 0) {
                return;
            }
            onResult(parcelableArrayListExtra);
            return;
        }
        if (i10 == 609) {
            multiCropHandleResult(intent);
        } else {
            if (i10 != 909) {
                return;
            }
            dispatchHandleCamera(intent);
        }
    }

    @Override // b.q, android.app.Activity
    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onCancel();
        }
        exit();
    }

    @Override // com.zyql.ai.selector.listener.OnPhotoSelectChangedListener
    public void onChange(List<LocalMedia> list) {
        changeImageNumber(list);
    }

    public void onChangeData(List<LocalMedia> list) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pictureLeftBack || id == R.id.picture_right) {
            FolderPopWindow folderPopWindow = this.folderWindow;
            if (folderPopWindow == null || !folderPopWindow.isShowing()) {
                onBackPressed();
                return;
            } else {
                this.folderWindow.dismiss();
                return;
            }
        }
        if (id == R.id.picture_title || id == R.id.ivArrow || id == R.id.viewClickMask) {
            if (this.folderWindow.isShowing()) {
                this.folderWindow.dismiss();
                return;
            }
            if (this.folderWindow.isEmpty()) {
                return;
            }
            this.folderWindow.showAsDropDown(this.mTitleBar);
            if (this.config.isSingleDirectReturn) {
                return;
            }
            this.folderWindow.updateFolderCheckStatus(this.mAdapter.getSelectedData());
            return;
        }
        if (id == R.id.picture_id_preview) {
            onPreview();
            return;
        }
        if (id == R.id.picture_tv_ok || id == R.id.tv_media_num) {
            onComplete();
            return;
        }
        if (id == R.id.titleBar && this.config.isAutomaticTitleRecyclerTop) {
            if (SystemClock.uptimeMillis() - this.intervalClickTime >= 500) {
                this.intervalClickTime = SystemClock.uptimeMillis();
            } else if (this.mAdapter.getItemCount() > 0) {
                this.mRecyclerView.scrollToPosition(0);
            }
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.allFolderSize = bundle.getInt(PictureConfig.EXTRA_ALL_FOLDER_SIZE);
            this.oldCurrentListSize = bundle.getInt(PictureConfig.EXTRA_OLD_CURRENT_LIST_SIZE, 0);
            List<LocalMedia> listObtainSelectorList = PictureSelector.obtainSelectorList(bundle);
            if (listObtainSelectorList == null) {
                listObtainSelectorList = this.selectionMedias;
            }
            this.selectionMedias = listObtainSelectorList;
            PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
            if (pictureImageGridAdapter != null) {
                this.isStartAnimation = true;
                pictureImageGridAdapter.bindSelectData(listObtainSelectorList);
            }
        }
        this.activityResultLauncher = registerForActivityResult(new e.c(), new InterfaceC3935a() { // from class: com.zyql.ai.selector.w
            @Override // d.InterfaceC3935a
            public final void a(Object obj) {
                PictureSelectorActivity.A((Map) obj);
            }
        });
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Animation animation = this.animation;
        if (animation != null) {
            animation.cancel();
            this.animation = null;
        }
        if (this.mediaPlayer != null) {
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    @Override // com.zyql.ai.selector.listener.OnAlbumItemClickListener
    public void onItemClick(int i10, boolean z10, long j10, String str, List<LocalMedia> list) {
        this.mAdapter.setShowCamera(this.config.isCamera && z10);
        this.mTvPictureTitle.setText(str);
        TextView textView = this.mTvPictureTitle;
        int i11 = R.id.view_tag;
        long j11 = ValueOf.toLong(textView.getTag(i11));
        this.mTvPictureTitle.setTag(R.id.view_count_tag, Integer.valueOf(this.folderWindow.getFolder(i10) != null ? this.folderWindow.getFolder(i10).getImageNum() : 0));
        if (!this.config.isPageStrategy) {
            this.mAdapter.bindData(list);
            this.mRecyclerView.smoothScrollToPosition(0);
        } else if (j11 != j10) {
            setLastCacheFolderData();
            if (!isCurrentCacheFolderData(i10)) {
                this.mPage = 1;
                showPleaseDialog();
                LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(j10, this.mPage, new OnQueryDataResultListener() { // from class: com.zyql.ai.selector.r
                    @Override // com.zyql.ai.selector.listener.OnQueryDataResultListener
                    public final void onComplete(List list2, int i12, boolean z11) {
                        this.f32004a.lambda$onItemClick$6(list2, i12, z11);
                    }
                });
            }
        }
        this.mTvPictureTitle.setTag(i11, Long.valueOf(j10));
        this.folderWindow.dismiss();
    }

    @Override // com.zyql.ai.selector.listener.OnRecyclerViewPreloadMoreListener
    public void onRecyclerViewPreloadMore() {
        loadMoreData();
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, getString(R.string.picture_jurisdiction));
                return;
            } else {
                readLocalMedia();
                return;
            }
        }
        if (i10 == 2) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(true, new String[]{"android.permission.CAMERA"}, getString(R.string.picture_camera));
                return;
            } else {
                onTakePhoto();
                return;
            }
        }
        if (i10 == 4) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(false, new String[]{PolicySdkPermissionManifestUtils.RECORD_AUDIO}, getString(R.string.picture_audio));
                return;
            } else {
                startCustomCamera();
                return;
            }
        }
        if (i10 != 5) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            showPermissionsDialog(false, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, getString(R.string.picture_jurisdiction));
        } else {
            startCamera();
        }
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        CheckBox checkBox;
        super.onResume();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.isOriginalControl || (checkBox = this.mCbOriginal) == null) {
            return;
        }
        checkBox.setChecked(pictureSelectionConfig.isCheckOriginalImage);
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
        if (pictureImageGridAdapter != null) {
            bundle.putInt(PictureConfig.EXTRA_OLD_CURRENT_LIST_SIZE, pictureImageGridAdapter.getSize());
            if (this.folderWindow.getFolderData().size() > 0) {
                bundle.putInt(PictureConfig.EXTRA_ALL_FOLDER_SIZE, this.folderWindow.getFolder(0).getImageNum());
            }
            if (this.mAdapter.getSelectedData() != null) {
                PictureSelector.saveSelectorList(bundle, this.mAdapter.getSelectedData());
            }
        }
    }

    @Override // com.zyql.ai.selector.listener.OnPhotoSelectChangedListener
    public void onTakePhoto() {
        if (!PermissionChecker.checkSelfPermission(this, "android.permission.CAMERA")) {
            PermissionChecker.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 2);
            return;
        }
        PermissionAdapter permissionAdapter = PermissionAdapter.INSTANCE;
        if (permissionAdapter.checkMediaPermission(this)) {
            startCamera();
        } else {
            permissionAdapter.requestMediaPermission(this, this.activityResultLauncher);
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

    public void readLocalMedia() {
        showPleaseDialog();
        if (this.config.isPageStrategy) {
            LocalMediaPageLoader.getInstance(getContext()).loadAllMedia(new OnQueryDataResultListener() { // from class: com.zyql.ai.selector.t
                @Override // com.zyql.ai.selector.listener.OnQueryDataResultListener
                public final void onComplete(List list, int i10, boolean z10) {
                    this.f32007a.lambda$readLocalMedia$3(list, i10, z10);
                }
            });
        } else {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() { // from class: com.zyql.ai.selector.PictureSelectorActivity.1
                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public List<LocalMediaFolder> doInBackground() {
                    return new LocalMediaLoader(PictureSelectorActivity.this.getContext()).loadAllMedia();
                }

                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public void onSuccess(List<LocalMediaFolder> list) {
                    PictureSelectorActivity.this.initStandardModel(list);
                }
            });
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void showPermissionsDialog(final boolean z10, String[] strArr, String str) {
        if (isFinishing()) {
            return;
        }
        OnPermissionsObtainCallback onPermissionsObtainCallback = PictureSelectionConfig.onPermissionsObtainCallback;
        if (onPermissionsObtainCallback != null) {
            onPermissionsObtainCallback.onPermissionsIntercept(getContext(), z10, strArr, str, new OnPermissionDialogOptionCallback() { // from class: com.zyql.ai.selector.PictureSelectorActivity.7
                @Override // com.zyql.ai.selector.listener.OnPermissionDialogOptionCallback
                public void onCancel() {
                    OnResultCallbackListener<LocalMedia> onResultCallbackListener = PictureSelectionConfig.listener;
                    if (onResultCallbackListener != null) {
                        onResultCallbackListener.onCancel();
                    }
                    PictureSelectorActivity.this.exit();
                }

                @Override // com.zyql.ai.selector.listener.OnPermissionDialogOptionCallback
                public void onSetting() {
                    PictureSelectorActivity.this.isEnterSetting = true;
                }
            });
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_wind_base_dialog);
        pictureCustomDialog.setCancelable(false);
        pictureCustomDialog.setCanceledOnTouchOutside(false);
        Button button = (Button) pictureCustomDialog.findViewById(R.id.btn_cancel);
        Button button2 = (Button) pictureCustomDialog.findViewById(R.id.btn_commit);
        button2.setText(getString(R.string.picture_go_setting));
        TextView textView = (TextView) pictureCustomDialog.findViewById(R.id.tvTitle);
        TextView textView2 = (TextView) pictureCustomDialog.findViewById(R.id.tv_content);
        textView.setText(getString(R.string.picture_prompt));
        textView2.setText(str);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f32011a.lambda$showPermissionsDialog$7(pictureCustomDialog, z10, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f32014a.lambda$showPermissionsDialog$8(pictureCustomDialog, view);
            }
        });
        pictureCustomDialog.show();
    }

    public void startCamera() {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        OnCustomCameraInterfaceListener onCustomCameraInterfaceListener = PictureSelectionConfig.onCustomCameraInterfaceListener;
        if (onCustomCameraInterfaceListener != null) {
            if (this.config.chooseMode == 0) {
                PhotoItemSelectedDialog photoItemSelectedDialogNewInstance = PhotoItemSelectedDialog.newInstance();
                photoItemSelectedDialogNewInstance.setOnItemClickListener(this);
                photoItemSelectedDialogNewInstance.show(getSupportFragmentManager(), "PhotoItemSelectedDialog");
                return;
            } else {
                Context context = getContext();
                PictureSelectionConfig pictureSelectionConfig = this.config;
                onCustomCameraInterfaceListener.onCameraClick(context, pictureSelectionConfig, pictureSelectionConfig.chooseMode);
                PictureSelectionConfig pictureSelectionConfig2 = this.config;
                pictureSelectionConfig2.cameraMimeType = pictureSelectionConfig2.chooseMode;
                return;
            }
        }
        if (this.config.chooseMode != PictureMimeType.ofAudio() && this.config.isUseCustomCamera) {
            startCustomCamera();
            return;
        }
        int i10 = this.config.chooseMode;
        if (i10 == 0) {
            PhotoItemSelectedDialog photoItemSelectedDialogNewInstance2 = PhotoItemSelectedDialog.newInstance();
            photoItemSelectedDialogNewInstance2.setOnItemClickListener(this);
            photoItemSelectedDialogNewInstance2.show(getSupportFragmentManager(), "PhotoItemSelectedDialog");
        } else if (i10 == 1) {
            startOpenCamera();
        } else if (i10 == 2) {
            startOpenCameraVideo();
        } else {
            if (i10 != 3) {
                return;
            }
            startOpenCameraAudio();
        }
    }

    public void startPreview(List<LocalMedia> list, int i10) {
        LocalMedia localMedia = list.get(i10);
        String mimeType = localMedia.getMimeType();
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        if (PictureMimeType.isHasVideo(mimeType)) {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            if (pictureSelectionConfig.selectionMode == 1 && !pictureSelectionConfig.enPreviewVideo) {
                arrayList.add(localMedia);
                onResult(arrayList);
                return;
            }
            OnVideoSelectedPlayCallback<LocalMedia> onVideoSelectedPlayCallback = PictureSelectionConfig.customVideoPlayCallback;
            if (onVideoSelectedPlayCallback != null) {
                onVideoSelectedPlayCallback.startPlayVideo(localMedia);
                return;
            } else {
                bundle.putParcelable(PictureConfig.EXTRA_MEDIA_KEY, localMedia);
                JumpUtils.startPictureVideoPlayActivity(getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
                return;
            }
        }
        if (PictureMimeType.isHasAudio(mimeType)) {
            if (this.config.selectionMode != 1) {
                startPlayAudioDialog(localMedia.getPath());
                return;
            } else {
                arrayList.add(localMedia);
                onResult(arrayList);
                return;
            }
        }
        OnCustomImagePreviewCallback<LocalMedia> onCustomImagePreviewCallback = PictureSelectionConfig.onCustomImagePreviewCallback;
        if (onCustomImagePreviewCallback != null) {
            onCustomImagePreviewCallback.onCustomPreviewCallback(getContext(), list, i10);
            return;
        }
        List<LocalMedia> selectedData = this.mAdapter.getSelectedData();
        ImagesObservable.getInstance().savePreviewMediaData(new ArrayList(list));
        bundle.putParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) selectedData);
        bundle.putInt("position", i10);
        bundle.putBoolean(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
        bundle.putBoolean(PictureConfig.EXTRA_SHOW_CAMERA, this.mAdapter.isShowCamera());
        bundle.putLong(PictureConfig.EXTRA_BUCKET_ID, ValueOf.toLong(this.mTvPictureTitle.getTag(R.id.view_tag)));
        bundle.putInt("page", this.mPage);
        bundle.putParcelable(PictureConfig.EXTRA_CONFIG, this.config);
        bundle.putInt("count", ValueOf.toInt(this.mTvPictureTitle.getTag(R.id.view_count_tag)));
        bundle.putString(PictureConfig.EXTRA_IS_CURRENT_DIRECTORY, this.mTvPictureTitle.getText().toString());
        Context context = getContext();
        PictureSelectionConfig pictureSelectionConfig2 = this.config;
        JumpUtils.startPicturePreviewActivity(context, pictureSelectionConfig2.isWeChatStyle, bundle, pictureSelectionConfig2.selectionMode == 1 ? 69 : UCrop.REQUEST_MULTI_CROP);
        overridePendingTransition(PictureSelectionConfig.windowAnimationStyle.activityPreviewEnterAnimation, R.anim.picture_anim_fade_in);
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

    @Override // com.zyql.ai.selector.listener.OnPhotoSelectChangedListener
    public void onPictureClick(LocalMedia localMedia, int i10) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.selectionMode != 1 || !pictureSelectionConfig.isSingleDirectReturn) {
            startPreview(this.mAdapter.getData(), i10);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(localMedia);
        if (!this.config.enableCrop || !PictureMimeType.isHasImage(localMedia.getMimeType()) || this.config.isCheckOriginalImage) {
            handlerResult(arrayList);
        } else {
            this.mAdapter.bindSelectData(arrayList);
            UCropManager.ofCrop(this, localMedia.getPath(), localMedia.getMimeType());
        }
    }

    @Override // com.zyql.ai.selector.listener.OnItemClickListener
    public void onItemClick(View view, int i10) {
        if (i10 == 0) {
            OnCustomCameraInterfaceListener onCustomCameraInterfaceListener = PictureSelectionConfig.onCustomCameraInterfaceListener;
            if (onCustomCameraInterfaceListener != null) {
                onCustomCameraInterfaceListener.onCameraClick(getContext(), this.config, 1);
                this.config.cameraMimeType = PictureMimeType.ofImage();
                return;
            }
            startOpenCamera();
            return;
        }
        if (i10 != 1) {
            return;
        }
        OnCustomCameraInterfaceListener onCustomCameraInterfaceListener2 = PictureSelectionConfig.onCustomCameraInterfaceListener;
        if (onCustomCameraInterfaceListener2 != null) {
            onCustomCameraInterfaceListener2.onCameraClick(getContext(), this.config, 1);
            this.config.cameraMimeType = PictureMimeType.ofVideo();
            return;
        }
        startOpenCameraVideo();
    }
}
