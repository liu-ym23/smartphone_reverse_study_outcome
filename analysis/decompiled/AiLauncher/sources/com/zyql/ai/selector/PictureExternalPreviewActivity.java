package com.zyql.ai.selector;

import Mb.InterfaceC0968f;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.zyql.ai.selector.PictureExternalPreviewActivity;
import com.zyql.ai.selector.PictureMediaScannerConnection;
import com.zyql.ai.selector.broadcast.BroadcastAction;
import com.zyql.ai.selector.broadcast.BroadcastManager;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.dialog.PictureCustomDialog;
import com.zyql.ai.selector.engine.ImageEngine;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnImageCompleteCallback;
import com.zyql.ai.selector.listener.OnVideoSelectedPlayCallback;
import com.zyql.ai.selector.permissions.PermissionChecker;
import com.zyql.ai.selector.photoview.OnViewTapListener;
import com.zyql.ai.selector.photoview.PhotoView;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.thread.PictureThreadUtils;
import com.zyql.ai.selector.tools.AttrsUtils;
import com.zyql.ai.selector.tools.DateUtils;
import com.zyql.ai.selector.tools.JumpUtils;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.ScreenUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.ToastUtils;
import com.zyql.ai.selector.tools.ValueOf;
import com.zyql.ai.selector.widget.PreviewViewPager;
import com.zyql.ai.selector.widget.longimage.ImageSource;
import com.zyql.ai.selector.widget.longimage.ImageViewState;
import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public class PictureExternalPreviewActivity extends PictureBaseActivity implements View.OnClickListener {
    private SimpleFragmentAdapter adapter;
    private String downloadPath;
    private ImageButton ibDelete;
    private ImageButton ibLeftBack;
    private String mMimeType;
    private int mScreenHeight;
    private int mScreenWidth;
    private View mTitleBar;
    private TextView tvTitle;
    private PreviewViewPager viewPager;
    private final List<LocalMedia> images = new ArrayList();
    private int position = 0;

    public class SimpleFragmentAdapter extends androidx.viewpager.widget.a {
        private static final int MAX_CACHE_SIZE = 20;
        private SparseArray<View> mCacheView = new SparseArray<>();

        public SimpleFragmentAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            SparseArray<View> sparseArray = this.mCacheView;
            if (sparseArray != null) {
                sparseArray.clear();
                this.mCacheView = null;
            }
        }

        public static /* synthetic */ void d(LocalMedia localMedia, String str, ViewGroup viewGroup, View view) {
            OnVideoSelectedPlayCallback<LocalMedia> onVideoSelectedPlayCallback = PictureSelectionConfig.customVideoPlayCallback;
            if (onVideoSelectedPlayCallback != null) {
                onVideoSelectedPlayCallback.startPlayVideo(localMedia);
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(PictureConfig.EXTRA_VIDEO_PATH, str);
            intent.putExtras(bundle);
            JumpUtils.startPictureVideoPlayActivity(viewGroup.getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$instantiateItem$0(View view, float f10, float f11) {
            PictureExternalPreviewActivity.this.finish();
            PictureExternalPreviewActivity.this.exitAnimation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$instantiateItem$1(View view) {
            PictureExternalPreviewActivity.this.finish();
            PictureExternalPreviewActivity.this.exitAnimation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$instantiateItem$2(String str, LocalMedia localMedia, View view) {
            PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
            if (pictureExternalPreviewActivity.config.isNotPreviewDownload) {
                if (PermissionChecker.checkSelfPermission(pictureExternalPreviewActivity.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    PictureExternalPreviewActivity.this.downloadPath = str;
                    String imageMimeType = (PictureMimeType.isHasHttp(str) && TextUtils.isEmpty(localMedia.getMimeType())) ? PictureMimeType.getImageMimeType(localMedia.getPath()) : localMedia.getMimeType();
                    PictureExternalPreviewActivity pictureExternalPreviewActivity2 = PictureExternalPreviewActivity.this;
                    if (PictureMimeType.isJPG(imageMimeType)) {
                        imageMimeType = "image/jpeg";
                    }
                    pictureExternalPreviewActivity2.mMimeType = imageMimeType;
                    PictureExternalPreviewActivity.this.showDownLoadDialog();
                } else {
                    PermissionChecker.requestPermissions(PictureExternalPreviewActivity.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$instantiateItem$3(String str, LocalMedia localMedia, View view) {
            PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
            if (pictureExternalPreviewActivity.config.isNotPreviewDownload) {
                if (PermissionChecker.checkSelfPermission(pictureExternalPreviewActivity.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    PictureExternalPreviewActivity.this.downloadPath = str;
                    String imageMimeType = (PictureMimeType.isHasHttp(str) && TextUtils.isEmpty(localMedia.getMimeType())) ? PictureMimeType.getImageMimeType(localMedia.getPath()) : localMedia.getMimeType();
                    PictureExternalPreviewActivity pictureExternalPreviewActivity2 = PictureExternalPreviewActivity.this;
                    if (PictureMimeType.isJPG(imageMimeType)) {
                        imageMimeType = "image/jpeg";
                    }
                    pictureExternalPreviewActivity2.mMimeType = imageMimeType;
                    PictureExternalPreviewActivity.this.showDownLoadDialog();
                } else {
                    PermissionChecker.requestPermissions(PictureExternalPreviewActivity.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                }
            }
            return true;
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView((View) obj);
            if (this.mCacheView.size() > 20) {
                this.mCacheView.remove(i10);
            }
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return PictureExternalPreviewActivity.this.images.size();
        }

        @Override // androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(final ViewGroup viewGroup, int i10) {
            View viewInflate = this.mCacheView.get(i10);
            if (viewInflate == null) {
                viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_image_preview, viewGroup, false);
                this.mCacheView.put(i10, viewInflate);
            }
            PhotoView photoView = (PhotoView) viewInflate.findViewById(R.id.preview_image);
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) viewInflate.findViewById(R.id.longImg);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_play);
            final LocalMedia localMedia = (LocalMedia) PictureExternalPreviewActivity.this.images.get(i10);
            if (PictureExternalPreviewActivity.this.config.isAutoScalePreviewImage) {
                float fMin = Math.min(localMedia.getWidth(), localMedia.getHeight());
                float fMax = Math.max(localMedia.getHeight(), localMedia.getWidth());
                if (fMin > 0.0f && fMax > 0.0f) {
                    int iCeil = (int) Math.ceil((fMax * fMin) / fMin);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) photoView.getLayoutParams();
                    layoutParams.width = PictureExternalPreviewActivity.this.mScreenWidth;
                    if (iCeil < PictureExternalPreviewActivity.this.mScreenHeight) {
                        iCeil += PictureExternalPreviewActivity.this.mScreenHeight;
                    }
                    layoutParams.height = iCeil;
                    layoutParams.gravity = 17;
                }
            }
            final String compressPath = (!localMedia.isCut() || localMedia.isCompressed()) ? (localMedia.isCompressed() || (localMedia.isCut() && localMedia.isCompressed())) ? localMedia.getCompressPath() : !TextUtils.isEmpty(localMedia.getAndroidQToPath()) ? localMedia.getAndroidQToPath() : localMedia.getPath() : localMedia.getCutPath();
            boolean zIsHasHttp = PictureMimeType.isHasHttp(compressPath);
            String imageMimeType = (zIsHasHttp && TextUtils.isEmpty(localMedia.getMimeType())) ? PictureMimeType.getImageMimeType(localMedia.getPath()) : localMedia.getMimeType();
            boolean zIsHasVideo = PictureMimeType.isHasVideo(imageMimeType);
            int i11 = 8;
            imageView.setVisibility(zIsHasVideo ? 0 : 8);
            boolean zIsGif = PictureMimeType.isGif(imageMimeType);
            boolean zIsLongImg = MediaUtils.isLongImg(localMedia);
            photoView.setVisibility((!zIsLongImg || zIsGif) ? 0 : 8);
            if (zIsLongImg && !zIsGif) {
                i11 = 0;
            }
            subsamplingScaleImageView.setVisibility(i11);
            if (!zIsGif || localMedia.isCompressed()) {
                ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
                if (imageEngine != null) {
                    if (zIsHasHttp) {
                        imageEngine.loadImage(viewInflate.getContext(), compressPath, photoView, subsamplingScaleImageView, new OnImageCompleteCallback() { // from class: com.zyql.ai.selector.PictureExternalPreviewActivity.SimpleFragmentAdapter.1
                            @Override // com.zyql.ai.selector.listener.OnImageCompleteCallback
                            public void onHideLoading() {
                                PictureExternalPreviewActivity.this.dismissDialog();
                            }

                            @Override // com.zyql.ai.selector.listener.OnImageCompleteCallback
                            public void onShowLoading() {
                                PictureExternalPreviewActivity.this.showPleaseDialog();
                            }
                        });
                    } else if (zIsLongImg) {
                        PictureExternalPreviewActivity.this.displayLongPic(PictureMimeType.isContent(compressPath) ? Uri.parse(compressPath) : Uri.fromFile(new File(compressPath)), subsamplingScaleImageView);
                    } else {
                        imageEngine.loadImage(viewInflate.getContext(), compressPath, photoView);
                    }
                }
            } else {
                ImageEngine imageEngine2 = PictureSelectionConfig.imageEngine;
                if (imageEngine2 != null) {
                    imageEngine2.loadAsGifImage(PictureExternalPreviewActivity.this.getContext(), compressPath, photoView);
                }
            }
            photoView.setOnViewTapListener(new OnViewTapListener() { // from class: com.zyql.ai.selector.h
                @Override // com.zyql.ai.selector.photoview.OnViewTapListener
                public final void onViewTap(View view, float f10, float f11) {
                    this.f31988a.lambda$instantiateItem$0(view, f10, f11);
                }
            });
            subsamplingScaleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f31989a.lambda$instantiateItem$1(view);
                }
            });
            if (!zIsHasVideo) {
                subsamplingScaleImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.zyql.ai.selector.j
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return this.f31990a.lambda$instantiateItem$2(compressPath, localMedia, view);
                    }
                });
            }
            if (!zIsHasVideo) {
                photoView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.zyql.ai.selector.k
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return this.f31993a.lambda$instantiateItem$3(compressPath, localMedia, view);
                    }
                });
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PictureExternalPreviewActivity.SimpleFragmentAdapter.d(localMedia, compressPath, viewGroup, view);
                }
            });
            viewGroup.addView(viewInflate, 0);
            return viewInflate;
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void removeCacheView(int i10) {
            SparseArray<View> sparseArray = this.mCacheView;
            if (sparseArray == null || i10 >= sparseArray.size()) {
                return;
            }
            this.mCacheView.removeAt(i10);
        }
    }

    private Uri createOutImageUri() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        contentValues.put("datetaken", ValueOf.toString(Long.valueOf(System.currentTimeMillis())));
        contentValues.put("mime_type", this.mMimeType);
        contentValues.put("relative_path", PictureMimeType.DCIM);
        return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayLongPic(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(ImageSource.uri(uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitAnimation() {
        overridePendingTransition(R.anim.picture_anim_fade_in, PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
    }

    private void initViewPageAdapterData() throws Resources.NotFoundException {
        this.tvTitle.setText(getString(R.string.picture_preview_image_num, Integer.valueOf(this.position + 1), Integer.valueOf(this.images.size())));
        SimpleFragmentAdapter simpleFragmentAdapter = new SimpleFragmentAdapter();
        this.adapter = simpleFragmentAdapter;
        this.viewPager.setAdapter(simpleFragmentAdapter);
        this.viewPager.setCurrentItem(this.position);
        this.viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.zyql.ai.selector.PictureExternalPreviewActivity.1
            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrollStateChanged(int i10) {
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrolled(int i10, float f10, int i11) {
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageSelected(int i10) {
                PictureExternalPreviewActivity.this.tvTitle.setText(PictureExternalPreviewActivity.this.getString(R.string.picture_preview_image_num, Integer.valueOf(i10 + 1), Integer.valueOf(PictureExternalPreviewActivity.this.images.size())));
                PictureExternalPreviewActivity.this.position = i10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDownLoadDialog$0(PictureCustomDialog pictureCustomDialog, View view) {
        if (isFinishing()) {
            return;
        }
        pictureCustomDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDownLoadDialog$1(PictureCustomDialog pictureCustomDialog, View view) {
        boolean zIsHasHttp = PictureMimeType.isHasHttp(this.downloadPath);
        showPleaseDialog();
        if (zIsHasHttp) {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<String>() { // from class: com.zyql.ai.selector.PictureExternalPreviewActivity.2
                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public String doInBackground() {
                    PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
                    return pictureExternalPreviewActivity.showLoadingImage(pictureExternalPreviewActivity.downloadPath);
                }

                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public void onSuccess(String str) throws FileNotFoundException {
                    PictureExternalPreviewActivity.this.onSuccessful(str);
                }
            });
        } else {
            try {
                if (PictureMimeType.isContent(this.downloadPath)) {
                    savePictureAlbumAndroidQ(PictureMimeType.isContent(this.downloadPath) ? Uri.parse(this.downloadPath) : Uri.fromFile(new File(this.downloadPath)));
                } else {
                    savePictureAlbum();
                }
            } catch (Exception e10) {
                ToastUtils.s(getContext(), getString(R.string.picture_save_error) + "\n" + e10.getMessage());
                dismissDialog();
                e10.printStackTrace();
            }
        }
        if (isFinishing()) {
            return;
        }
        pictureCustomDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSuccessful(String str) throws FileNotFoundException {
        dismissDialog();
        if (TextUtils.isEmpty(str)) {
            ToastUtils.s(getContext(), getString(R.string.picture_save_error));
            return;
        }
        try {
            if (!SdkVersionUtils.checkedAndroid_Q()) {
                File file = new File(str);
                MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                new PictureMediaScannerConnection(getContext(), file.getAbsolutePath(), new PictureMediaScannerConnection.ScanListener() { // from class: com.zyql.ai.selector.e
                    @Override // com.zyql.ai.selector.PictureMediaScannerConnection.ScanListener
                    public final void onScanFinish() {
                        PictureExternalPreviewActivity.s();
                    }
                });
            }
            ToastUtils.s(getContext(), getString(R.string.picture_save_success) + "\n" + str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static /* synthetic */ void s() {
    }

    private void savePictureAlbum() throws Exception {
        String absolutePath;
        String lastImgSuffix = PictureMimeType.getLastImgSuffix(this.mMimeType);
        String externalStorageState = Environment.getExternalStorageState();
        File externalStoragePublicDirectory = externalStorageState.equals("mounted") ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) : getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalStoragePublicDirectory != null && !externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdirs();
        }
        if (SdkVersionUtils.checkedAndroid_Q() || !externalStorageState.equals("mounted")) {
            absolutePath = externalStoragePublicDirectory.getAbsolutePath();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(externalStoragePublicDirectory.getAbsolutePath());
            String str = File.separator;
            sb2.append(str);
            sb2.append(PictureMimeType.CAMERA);
            sb2.append(str);
            absolutePath = sb2.toString();
        }
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, DateUtils.getCreateFileName("IMG_") + lastImgSuffix);
        PictureFileUtils.copyFile(this.downloadPath, file2.getAbsolutePath());
        onSuccessful(file2.getAbsolutePath());
    }

    private void savePictureAlbumAndroidQ(final Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        contentValues.put("datetaken", ValueOf.toString(Long.valueOf(System.currentTimeMillis())));
        contentValues.put("mime_type", this.mMimeType);
        contentValues.put("relative_path", PictureMimeType.DCIM);
        final Uri uriInsert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            ToastUtils.s(getContext(), getString(R.string.picture_save_error));
        } else {
            PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<String>() { // from class: com.zyql.ai.selector.PictureExternalPreviewActivity.3
                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public String doInBackground() {
                    InterfaceC0968f interfaceC0968fC = null;
                    try {
                        try {
                            InputStream contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(PictureExternalPreviewActivity.this.getContext(), uri);
                            Objects.requireNonNull(contentResolverOpenInputStream);
                            interfaceC0968fC = Mb.u.c(Mb.u.l(contentResolverOpenInputStream));
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            if (interfaceC0968fC == null || !interfaceC0968fC.isOpen()) {
                                return "";
                            }
                        }
                        if (PictureFileUtils.bufferCopy(interfaceC0968fC, PictureContentResolver.getContentResolverOpenOutputStream(PictureExternalPreviewActivity.this.getContext(), uriInsert))) {
                            String path = PictureFileUtils.getPath(PictureExternalPreviewActivity.this.getContext(), uriInsert);
                            if (interfaceC0968fC != null && interfaceC0968fC.isOpen()) {
                                PictureFileUtils.close(interfaceC0968fC);
                            }
                            return path;
                        }
                        if (interfaceC0968fC == null || !interfaceC0968fC.isOpen()) {
                            return "";
                        }
                        PictureFileUtils.close(interfaceC0968fC);
                        return "";
                    } catch (Throwable th) {
                        if (interfaceC0968fC != null && interfaceC0968fC.isOpen()) {
                            PictureFileUtils.close(interfaceC0968fC);
                        }
                        throw th;
                    }
                }

                @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
                public void onSuccess(String str) throws FileNotFoundException {
                    PictureThreadUtils.cancel(PictureThreadUtils.getSinglePool());
                    PictureExternalPreviewActivity.this.onSuccessful(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownLoadDialog() {
        if (isFinishing() || TextUtils.isEmpty(this.downloadPath)) {
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_wind_base_dialog);
        Button button = (Button) pictureCustomDialog.findViewById(R.id.btn_cancel);
        Button button2 = (Button) pictureCustomDialog.findViewById(R.id.btn_commit);
        TextView textView = (TextView) pictureCustomDialog.findViewById(R.id.tvTitle);
        TextView textView2 = (TextView) pictureCustomDialog.findViewById(R.id.tv_content);
        textView.setText(getString(R.string.picture_prompt));
        textView2.setText(getString(R.string.picture_prompt_content));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31984a.lambda$showDownLoadDialog$0(pictureCustomDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31986a.lambda$showDownLoadDialog$1(pictureCustomDialog, view);
            }
        });
        pictureCustomDialog.show();
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_activity_external_preview;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initPictureSelectorStyle() throws Resources.NotFoundException {
        PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
        if (pictureParameterStyle == null) {
            int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_ac_preview_title_bg);
            if (typeValueColor != 0) {
                this.mTitleBar.setBackgroundColor(typeValueColor);
                return;
            } else {
                this.mTitleBar.setBackgroundColor(this.colorPrimary);
                return;
            }
        }
        int i10 = pictureParameterStyle.pictureTitleTextColor;
        if (i10 != 0) {
            this.tvTitle.setTextColor(i10);
        }
        int i11 = PictureSelectionConfig.style.pictureTitleTextSize;
        if (i11 != 0) {
            this.tvTitle.setTextSize(i11);
        }
        int i12 = PictureSelectionConfig.style.pictureLeftBackIcon;
        if (i12 != 0) {
            this.ibLeftBack.setImageResource(i12);
        }
        int i13 = PictureSelectionConfig.style.pictureExternalPreviewDeleteStyle;
        if (i13 != 0) {
            this.ibDelete.setImageResource(i13);
        }
        if (PictureSelectionConfig.style.pictureTitleBarBackgroundColor != 0) {
            this.mTitleBar.setBackgroundColor(this.colorPrimary);
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initWidgets() throws Resources.NotFoundException {
        super.initWidgets();
        this.mTitleBar = findViewById(R.id.titleBar);
        this.tvTitle = (TextView) findViewById(R.id.picture_title);
        this.ibLeftBack = (ImageButton) findViewById(R.id.left_back);
        this.ibDelete = (ImageButton) findViewById(R.id.ib_delete);
        this.viewPager = (PreviewViewPager) findViewById(R.id.preview_pager);
        this.position = getIntent().getIntExtra("position", 0);
        this.mScreenWidth = ScreenUtils.getScreenWidth(getContext());
        this.mScreenHeight = ScreenUtils.getScreenHeight(getContext());
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST);
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
            this.images.addAll(parcelableArrayListExtra);
        }
        this.ibLeftBack.setOnClickListener(this);
        this.ibDelete.setOnClickListener(this);
        ImageButton imageButton = this.ibDelete;
        PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
        imageButton.setVisibility((pictureParameterStyle == null || !pictureParameterStyle.pictureExternalPreviewGonePreviewDelete) ? 8 : 0);
        initViewPageAdapterData();
    }

    @Override // b.q, android.app.Activity
    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        finish();
        exitAnimation();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.left_back) {
            finish();
            exitAnimation();
            return;
        }
        if (id != R.id.ib_delete || this.images.size() <= 0) {
            return;
        }
        int currentItem = this.viewPager.getCurrentItem();
        this.images.remove(currentItem);
        this.adapter.removeCacheView(currentItem);
        Bundle bundle = new Bundle();
        bundle.putInt("position", currentItem);
        BroadcastManager.getInstance(getContext()).action(BroadcastAction.ACTION_DELETE_PREVIEW_POSITION).extras(bundle).broadcast();
        if (this.images.size() == 0) {
            onBackPressed();
            return;
        }
        this.tvTitle.setText(getString(R.string.picture_preview_image_num, Integer.valueOf(this.position + 1), Integer.valueOf(this.images.size())));
        this.position = currentItem;
        this.adapter.notifyDataSetChanged();
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SimpleFragmentAdapter simpleFragmentAdapter = this.adapter;
        if (simpleFragmentAdapter != null) {
            simpleFragmentAdapter.clear();
        }
        PictureSelectionConfig.destroy();
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 1) {
            for (int i11 : iArr) {
                if (i11 == 0) {
                    showDownLoadDialog();
                } else {
                    ToastUtils.s(getContext(), getString(R.string.picture_jurisdiction));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v18, types: [Mb.f, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable] */
    public String showLoadingImage(String str) throws Throwable {
        OutputStream contentResolverOpenOutputStream;
        Closeable closeable;
        InputStream inputStreamOpenStream;
        Uri uriFromFile;
        ?? C10;
        String string;
        InputStream inputStream = null;
        try {
            try {
                if (SdkVersionUtils.checkedAndroid_Q()) {
                    uriFromFile = createOutImageUri();
                } else {
                    String lastImgSuffix = PictureMimeType.getLastImgSuffix(this.mMimeType);
                    String externalStorageState = Environment.getExternalStorageState();
                    File externalStoragePublicDirectory = externalStorageState.equals("mounted") ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) : getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                    if (externalStoragePublicDirectory != null) {
                        if (!externalStoragePublicDirectory.exists()) {
                            externalStoragePublicDirectory.mkdirs();
                        }
                        if (externalStorageState.equals("mounted")) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(externalStoragePublicDirectory.getAbsolutePath());
                            String str2 = File.separator;
                            sb2.append(str2);
                            sb2.append(PictureMimeType.CAMERA);
                            sb2.append(str2);
                            string = sb2.toString();
                        } else {
                            string = externalStoragePublicDirectory.getAbsolutePath();
                        }
                        File file = new File(string);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        uriFromFile = Uri.fromFile(new File(file, DateUtils.getCreateFileName("IMG_") + lastImgSuffix));
                    } else {
                        uriFromFile = null;
                    }
                }
                if (uriFromFile != null) {
                    try {
                        contentResolverOpenOutputStream = PictureContentResolver.getContentResolverOpenOutputStream(getContext(), uriFromFile);
                        try {
                            inputStreamOpenStream = new URL(str).openStream();
                        } catch (Exception unused) {
                            inputStreamOpenStream = null;
                            C10 = 0;
                        } catch (Throwable th) {
                            th = th;
                            closeable = null;
                            PictureFileUtils.close(inputStream);
                            PictureFileUtils.close(contentResolverOpenOutputStream);
                            PictureFileUtils.close(closeable);
                            throw th;
                        }
                        try {
                            C10 = Mb.u.c(Mb.u.l(inputStreamOpenStream));
                            try {
                                try {
                                    if (PictureFileUtils.bufferCopy((InterfaceC0968f) C10, contentResolverOpenOutputStream)) {
                                        String path = PictureFileUtils.getPath(this, uriFromFile);
                                        PictureFileUtils.close(inputStreamOpenStream);
                                        PictureFileUtils.close(contentResolverOpenOutputStream);
                                        PictureFileUtils.close(C10);
                                        return path;
                                    }
                                } catch (Exception unused2) {
                                    if (uriFromFile != null && SdkVersionUtils.checkedAndroid_Q()) {
                                        this.getContentResolver().delete(uriFromFile, null, null);
                                    }
                                    PictureFileUtils.close(inputStreamOpenStream);
                                    PictureFileUtils.close(contentResolverOpenOutputStream);
                                    PictureFileUtils.close(C10);
                                    return null;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = inputStreamOpenStream;
                                closeable = C10;
                                PictureFileUtils.close(inputStream);
                                PictureFileUtils.close(contentResolverOpenOutputStream);
                                PictureFileUtils.close(closeable);
                                throw th;
                            }
                        } catch (Exception unused3) {
                            C10 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            C10 = 0;
                            inputStream = inputStreamOpenStream;
                            closeable = C10;
                            PictureFileUtils.close(inputStream);
                            PictureFileUtils.close(contentResolverOpenOutputStream);
                            PictureFileUtils.close(closeable);
                            throw th;
                        }
                    } catch (Exception unused4) {
                        inputStreamOpenStream = null;
                        contentResolverOpenOutputStream = null;
                        C10 = contentResolverOpenOutputStream;
                        if (uriFromFile != null) {
                            this.getContentResolver().delete(uriFromFile, null, null);
                        }
                        PictureFileUtils.close(inputStreamOpenStream);
                        PictureFileUtils.close(contentResolverOpenOutputStream);
                        PictureFileUtils.close(C10);
                        return null;
                    }
                } else {
                    inputStreamOpenStream = null;
                    contentResolverOpenOutputStream = null;
                    C10 = 0;
                }
            } catch (Exception unused5) {
                inputStreamOpenStream = null;
                uriFromFile = null;
                contentResolverOpenOutputStream = null;
            }
            PictureFileUtils.close(inputStreamOpenStream);
            PictureFileUtils.close(contentResolverOpenOutputStream);
            PictureFileUtils.close(C10);
            return null;
        } catch (Throwable th4) {
            th = th4;
            contentResolverOpenOutputStream = null;
            closeable = null;
        }
    }
}
