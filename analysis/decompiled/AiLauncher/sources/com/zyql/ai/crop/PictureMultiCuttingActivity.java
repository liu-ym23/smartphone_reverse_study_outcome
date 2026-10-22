package com.zyql.ai.crop;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.zyql.ai.crop.PicturePhotoGalleryAdapter;
import com.zyql.ai.crop.UCrop;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.tools.DateUtils;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.ScreenUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes4.dex */
public class PictureMultiCuttingActivity extends UCropActivity {
    private static final int MIN_NUM = 1;
    private int cutIndex;
    private boolean isAnimation;
    private boolean isCamera;
    private boolean isWithVideoImage;
    private final ArrayList<LocalMedia> list = new ArrayList<>();
    private PicturePhotoGalleryAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private int oldCutIndex;
    private String renameCropFilename;

    private void addPhotoRecyclerView() throws Resources.NotFoundException {
        boolean booleanExtra = getIntent().getBooleanExtra(UCrop.Options.EXTRA_SKIP_MULTIPLE_CROP, true);
        RecyclerView recyclerView = new RecyclerView(this);
        this.mRecyclerView = recyclerView;
        int i10 = R.id.id_recycler;
        recyclerView.setId(i10);
        this.mRecyclerView.setBackgroundColor(a.c(this, R.color.ucrop_color_widget_background));
        this.mRecyclerView.setLayoutParams(new RelativeLayout.LayoutParams(-1, ScreenUtils.dip2px(this, 80.0f)));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        if (this.isAnimation) {
            this.mRecyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.ucrop_layout_animation_fall_down));
        }
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = this.mRecyclerView.getItemAnimator();
        Objects.requireNonNull(itemAnimator);
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        resetCutDataStatus();
        this.list.get(this.cutIndex).setCut(true);
        PicturePhotoGalleryAdapter picturePhotoGalleryAdapter = new PicturePhotoGalleryAdapter(this.list);
        this.mAdapter = picturePhotoGalleryAdapter;
        this.mRecyclerView.setAdapter(picturePhotoGalleryAdapter);
        if (booleanExtra) {
            this.mAdapter.setOnItemClickListener(new PicturePhotoGalleryAdapter.OnItemClickListener() { // from class: com.zyql.ai.crop.PictureMultiCuttingActivity.1
                @Override // com.zyql.ai.crop.PicturePhotoGalleryAdapter.OnItemClickListener
                public void onItemClick(int i11, View view) {
                    if (PictureMimeType.isHasVideo(((LocalMedia) PictureMultiCuttingActivity.this.list.get(i11)).getMimeType()) || PictureMultiCuttingActivity.this.cutIndex == i11) {
                        return;
                    }
                    PictureMultiCuttingActivity.this.resetLastCropStatus();
                    PictureMultiCuttingActivity.this.cutIndex = i11;
                    PictureMultiCuttingActivity pictureMultiCuttingActivity = PictureMultiCuttingActivity.this;
                    pictureMultiCuttingActivity.oldCutIndex = pictureMultiCuttingActivity.cutIndex;
                    PictureMultiCuttingActivity.this.resetCutData();
                }
            });
        }
        this.uCropPhotoBox.addView(this.mRecyclerView);
        changeLayoutParams(this.mShowBottomControls);
        ((RelativeLayout.LayoutParams) ((FrameLayout) findViewById(R.id.ucrop_frame)).getLayoutParams()).addRule(2, i10);
        ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, R.id.controls_wrapper);
    }

    private void changeLayoutParams(boolean z10) {
        if (this.mRecyclerView.getLayoutParams() == null) {
            return;
        }
        if (z10) {
            ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(12, 0);
            ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, R.id.wrapper_controls);
        } else {
            ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(12);
            ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, 0);
        }
    }

    private void getIndex(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            LocalMedia localMedia = this.list.get(i11);
            if (localMedia != null && PictureMimeType.isHasImage(localMedia.getMimeType())) {
                this.cutIndex = i11;
                return;
            }
        }
    }

    private void initLoadCutData() {
        ArrayList<LocalMedia> arrayList = this.list;
        if (arrayList == null || arrayList.size() == 0) {
            onBackPressed();
            return;
        }
        int size = this.list.size();
        if (this.isWithVideoImage) {
            getIndex(size);
        }
    }

    private void refreshPhotoRecyclerData() {
        resetCutDataStatus();
        this.list.get(this.cutIndex).setCut(true);
        this.mAdapter.notifyItemChanged(this.cutIndex);
        this.uCropPhotoBox.addView(this.mRecyclerView);
        changeLayoutParams(this.mShowBottomControls);
        ((RelativeLayout.LayoutParams) ((FrameLayout) findViewById(R.id.ucrop_frame)).getLayoutParams()).addRule(2, R.id.id_recycler);
        ((RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams()).addRule(2, R.id.controls_wrapper);
    }

    private void resetCutDataStatus() {
        int size = this.list.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.list.get(i10).setCut(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetLastCropStatus() {
        int i10;
        int size = this.list.size();
        if (size <= 1 || size <= (i10 = this.oldCutIndex)) {
            return;
        }
        this.list.get(i10).setCut(false);
        this.mAdapter.notifyItemChanged(this.cutIndex);
    }

    @Override // com.zyql.ai.crop.UCropActivity, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.renameCropFilename = intent.getStringExtra(UCrop.Options.EXTRA_RENAME_CROP_FILENAME);
        this.isCamera = intent.getBooleanExtra(UCrop.Options.EXTRA_CAMERA, false);
        this.isWithVideoImage = intent.getBooleanExtra(UCrop.Options.EXTRA_WITH_VIDEO_IMAGE, false);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(UCrop.Options.EXTRA_CUT_CROP);
        this.isAnimation = getIntent().getBooleanExtra(UCrop.Options.EXTRA_MULTIPLE_RECYCLERANIMATION, true);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() == 0) {
            onBackPressed();
            return;
        }
        this.list.addAll(parcelableArrayListExtra);
        if (this.list.size() > 1) {
            initLoadCutData();
            addPhotoRecyclerView();
        }
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        PicturePhotoGalleryAdapter picturePhotoGalleryAdapter = this.mAdapter;
        if (picturePhotoGalleryAdapter != null) {
            picturePhotoGalleryAdapter.setOnItemClickListener(null);
        }
        super.onDestroy();
    }

    public void resetCutData() {
        String strRename;
        this.uCropPhotoBox.removeView(this.mRecyclerView);
        View view = this.mBlockingView;
        if (view != null) {
            this.uCropPhotoBox.removeView(view);
        }
        setContentView(R.layout.ucrop_activity_photobox);
        this.uCropPhotoBox = (RelativeLayout) findViewById(R.id.ucrop_photobox);
        addBlockingView();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        LocalMedia localMedia = this.list.get(this.cutIndex);
        String path = localMedia.getPath();
        boolean zIsHasHttp = PictureMimeType.isHasHttp(path);
        String lastImgType = PictureMimeType.getLastImgType(PictureMimeType.isContent(path) ? PictureFileUtils.getPath(this, Uri.parse(path)) : path);
        extras.putParcelable(UCrop.EXTRA_INPUT_URI, !TextUtils.isEmpty(localMedia.getAndroidQToPath()) ? Uri.fromFile(new File(localMedia.getAndroidQToPath())) : (zIsHasHttp || PictureMimeType.isContent(path)) ? Uri.parse(path) : Uri.fromFile(new File(path)));
        File externalFilesDir = Environment.getExternalStorageState().equals("mounted") ? getExternalFilesDir(Environment.DIRECTORY_PICTURES) : getCacheDir();
        if (TextUtils.isEmpty(this.renameCropFilename)) {
            strRename = DateUtils.getCreateFileName("IMG_CROP_") + lastImgType;
        } else {
            strRename = this.isCamera ? this.renameCropFilename : PictureFileUtils.rename(this.renameCropFilename);
        }
        extras.putParcelable(UCrop.EXTRA_OUTPUT_URI, Uri.fromFile(new File(externalFilesDir, strRename)));
        intent.putExtras(extras);
        setupViews(intent);
        refreshPhotoRecyclerData();
        setImageData(intent);
        setInitialState();
        double dDip2px = this.cutIndex * ScreenUtils.dip2px(this, 60.0f);
        int i10 = this.mScreenWidth;
        if (dDip2px > i10 * 0.8d) {
            this.mRecyclerView.scrollBy(ScreenUtils.dip2px(this, 60.0f), 0);
        } else if (dDip2px < i10 * 0.4d) {
            this.mRecyclerView.scrollBy(ScreenUtils.dip2px(this, -60.0f), 0);
        }
    }

    @Override // com.zyql.ai.crop.UCropActivity
    public void setResultUri(Uri uri, float f10, int i10, int i11, int i12, int i13) {
        try {
            int size = this.list.size();
            int i14 = this.cutIndex;
            if (size < i14) {
                onBackPressed();
                return;
            }
            LocalMedia localMedia = this.list.get(i14);
            localMedia.setCutPath(uri.getPath());
            localMedia.setCut(true);
            localMedia.setCropResultAspectRatio(f10);
            localMedia.setCropOffsetX(i10);
            localMedia.setCropOffsetY(i11);
            localMedia.setCropImageWidth(i12);
            localMedia.setCropImageHeight(i13);
            localMedia.setAndroidQToPath(SdkVersionUtils.checkedAndroid_Q() ? localMedia.getCutPath() : localMedia.getAndroidQToPath());
            resetLastCropStatus();
            int i15 = this.cutIndex + 1;
            this.cutIndex = i15;
            if (this.isWithVideoImage && i15 < this.list.size() && PictureMimeType.isHasVideo(this.list.get(this.cutIndex).getMimeType())) {
                while (this.cutIndex < this.list.size() && !PictureMimeType.isHasImage(this.list.get(this.cutIndex).getMimeType())) {
                    this.cutIndex++;
                }
            }
            int i16 = this.cutIndex;
            this.oldCutIndex = i16;
            if (i16 < this.list.size()) {
                resetCutData();
                return;
            }
            for (int i17 = 0; i17 < this.list.size(); i17++) {
                this.list.get(i17).setCut(!TextUtils.isEmpty(r5.getCutPath()));
            }
            setResult(-1, new Intent().putExtra(UCrop.Options.EXTRA_OUTPUT_URI_LIST, this.list));
            onBackPressed();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
