package com.bytedanceos.common.ui.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.android.volley.VolleyError;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.core.ImageLoader;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.widget.image.PhotoView;

/* JADX INFO: loaded from: classes2.dex */
public class ImageDetailFragment extends Fragment {
    private static final String IMAGE_DATA_EXTRA = "image_url";
    private static final String KEY_APP_INFO = "app_info";
    private static final String KEY_IMAGE_POSITION = "image_position";
    private AppInfo mAppInfo;
    private Context mContext;
    private ImageLoader.ImageContainer mImageContainer;
    private ImageLoader.ImageContainer mImageContainerSmallPreview;
    private String mImageUrl;
    private PhotoView mImageView;
    private View mPlayBtn;
    private int mPosition;
    private ProgressBar mProgressBar;

    public class DetailImageListener implements ImageLoader.ImageListener {
        private boolean isSmallImage;
        final /* synthetic */ ImageDetailFragment this$0;

        public DetailImageListener(ImageDetailFragment r10, boolean r11) {
            this.this$0 = r10;
            this.isSmallImage = r11;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError r10) {
            ImageDetailFragment.access$100(this.this$0, this.isSmallImage, false, null);
        }

        @Override // com.bytedanceos.common.network.core.ImageLoader.ImageListener
        public void onResponse(ImageLoader.ImageContainer r10, boolean r11) {
            r10.e();
            ImageDetailFragment.access$100(this.this$0, this.isSmallImage, r11, r10.d());
        }
    }

    public ImageDetailFragment() {
    }

    public static /* synthetic */ AppInfo access$000(ImageDetailFragment r10) {
        return r10.mAppInfo;
    }

    public static /* synthetic */ void access$100(ImageDetailFragment r10, boolean r11, boolean r12, Bitmap r13) {
        r10.updateView(r11, r12, r13);
    }

    public static ImageDetailFragment newInstance(String r10, AppInfo r11, int r12) {
        ImageDetailFragment r13 = new ImageDetailFragment();
        Bundle r14 = new Bundle();
        r14.putString(IMAGE_DATA_EXTRA, r10);
        if (r11 == null) goto L5;
        r14.putSerializable("app_info", r11);
    L5:
        if (r12 <= 0) goto L7;
        r14.putInt(KEY_IMAGE_POSITION, r12);
    L7:
        r13.setArguments(r14);
        return r13;
    }

    private void preloadSmallImage() {
        AppInfo r10 = this.mAppInfo;
        if (r10 != null) goto L5;
    L8:
        int r11 = getResources().getDimensionPixelSize(R$dimen.appinfo_image_hsv_width);
        int r12 = getResources().getDimensionPixelSize(R$dimen.appinfo_image_hsv_height);
    L7:
        int r13 = r12;
        int r14 = r11;
        String r15 = e.B(this.mImageUrl, r14);
        ImageLoader.ImageContainer r16 = this.mImageContainerSmallPreview;
        if (r16 == null) goto L12;
        r16.c();
    L12:
        this.mImageContainerSmallPreview = ImageLoader.l(0.0f).h(r15, new DetailImageListener(this, true), r14, r13, false);
        return;
    L5:
        if (r10.mAppVideoType != 2) goto L8;
        int r17 = getResources().getDimensionPixelOffset(R$dimen.video_landscape_margin);
        r11 = getResources().getDisplayMetrics().widthPixels - (r17 * 2);
        r12 = getResources().getDimensionPixelOffset(R$dimen.video_landscape_height);
        goto L7
    }

    private void updateView(boolean r10, boolean r11, Bitmap r12) {
        if (r10 == true) goto L4;
        if (r11 == true) goto L4;
    L6:
        if (r10 == true) goto L8;
    L10:
        this.mProgressBar.setVisibility(8);
        this.mImageView.setVisibility(0);
        if (r12 == null) goto L13;
        this.mImageView.setImageBitmap(r12);
    L13:
        View r13 = this.mPlayBtn;
        if (r13 == null) goto L17;
        r13.setVisibility(0);
        return;
    L17:
        return;
    L8:
        if (this.mImageView.getVisibility() != 0) goto L10;
        return;
    L4:
        if (r12 != null) goto L6;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        this.mAppInfo = (AppInfo) getArguments().getSerializable("app_info");
        if (getArguments() == null) goto L5;
        String r11 = getArguments().getString(IMAGE_DATA_EXTRA);
    L6:
        this.mImageUrl = r11;
        if (getArguments() == null) goto L9;
        int r12 = getArguments().getInt(KEY_IMAGE_POSITION);
    L10:
        this.mPosition = r12;
        this.mContext = getActivity();
        return;
    L9:
        r12 = 0;
        goto L10
    L5:
        r11 = "";
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        View r13 = r10.inflate(R$layout.image_detail_fragment, r11, false);
        ProgressBar r14 = (ProgressBar) r13.findViewById(R$id.progressBar);
        this.mProgressBar = r14;
        r14.setVisibility(0);
        PhotoView r15 = (PhotoView) r13.findViewById(R$id.imageView);
        this.mImageView = r15;
        r15.setVisibility(8);
        DisplayMetrics r16 = this.mContext.getApplicationContext().getResources().getDisplayMetrics();
        preloadSmallImage();
        if (e.o0() == false) goto L8;
        ImageLoader.ImageContainer r17 = this.mImageContainer;
        if (r17 == null) goto L7;
        r17.c();
    L7:
        this.mImageContainer = ImageLoader.l(0.0f).h(this.mImageUrl, new DetailImageListener(this, false), r16.widthPixels, r16.heightPixels, true);
    L8:
        this.mImageView.setContentDescription(getString(R$string.app_image_des_x, new Object[]{Integer.valueOf(this.mPosition + 1)}));
        this.mImageView.setOnViewTapListener(new AnonymousClass1(this));
        if (this.mAppInfo == null) goto L11;
        View r18 = r13.findViewById(R$id.app_video_play);
        this.mPlayBtn = r18;
        r18.setVisibility(0);
        this.mPlayBtn.setOnClickListener(new AnonymousClass2(this));
    L11:
        return r13;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ImageLoader.ImageContainer r10 = this.mImageContainer;
        if (r10 == null) goto L5;
        r10.c();
        this.mImageContainer = null;
    L5:
        ImageLoader.ImageContainer r11 = this.mImageContainerSmallPreview;
        if (r11 == null) goto L9;
        r11.c();
        this.mImageContainerSmallPreview = null;
        return;
    }
}
