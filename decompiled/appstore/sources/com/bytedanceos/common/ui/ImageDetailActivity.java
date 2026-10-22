package com.bytedanceos.common.ui;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.t;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import androidx.viewpager.widget.ViewPager;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.core.ImageLoader;
import com.bytedanceos.common.ui.fragment.ImageDetailFragment;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.bytedanceos.common.utils.o;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ImageDetailActivity extends FragmentActivity {
    public static final String EXTRA_IMAGE_INDEX = "extra_image_index";
    public static final String EXTRA_IMAGE_URLS = "extra_image_urls";
    private static final String TAG = "ImageDetailActivity";
    private ViewGroup dotGroup;
    private String[] imageUrls;
    private ImagePagerAdapter mAdapter;
    private String mAppImage;
    private AppInfo mAppInfo;
    private ViewPager mPager;
    private ImageView[] tips;

    public class ImagePagerAdapter extends b0 {
        private final int mSize;
        final /* synthetic */ ImageDetailActivity this$0;

        public ImagePagerAdapter(ImageDetailActivity r10, FragmentManager r11, int r12) {
            this.this$0 = r10;
            super(r11);
            this.mSize = r12;
        }

        @Override // androidx.fragment.app.b0, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup r10, int r11, Object r12) {
            super.destroyItem(r10, r11, r12);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mSize;
        }

        @Override // androidx.fragment.app.b0
        public Fragment getItem(int r10) {
            com.bytedanceos.common.toolbox.j.a(ImageDetailActivity.access$100(this.this$0)[r10]);
            if (r10 != 0) goto L7;
            return ImageDetailFragment.newInstance(ImageDetailActivity.access$100(this.this$0)[r10], ImageDetailActivity.access$200(this.this$0), r10);
        L7:
            return ImageDetailFragment.newInstance(ImageDetailActivity.access$100(this.this$0)[r10], null, r10);
        }
    }

    public ImageDetailActivity() {
    }

    public static /* synthetic */ ImageView[] access$000(ImageDetailActivity r10) {
        return r10.tips;
    }

    public static /* synthetic */ String[] access$100(ImageDetailActivity r10) {
        return r10.imageUrls;
    }

    public static /* synthetic */ AppInfo access$200(ImageDetailActivity r10) {
        return r10.mAppInfo;
    }

    private static /* synthetic */ Map lambda$onCreate$0() {
        HashMap r10 = new HashMap();
        r10.put("name", "app_detail_gallery");
        r10.put("from", "");
        return r10;
    }

    public static /* synthetic */ Map s() {
        return lambda$onCreate$0();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        ActivityUtilKt.a(this);
        super.onCreate(r10);
        t.a(getWindow(), getWindow().getDecorView()).d(2);
        t.a(getWindow(), getWindow().getDecorView()).a(WindowInsetsCompat.Type.c());
        o.a("appstore_page_show", new j());
        setContentView(R$layout.image_detail_pager);
        this.imageUrls = (String[]) getIntent().getSerializableExtra(EXTRA_IMAGE_URLS);     // Catch: Exception -> L5
        this.mAppInfo = (AppInfo) getIntent().getSerializableExtra(CommonConfirmDialog.ARGS_DIALOG_APP);     // Catch: Exception -> L5
        int r11 = getIntent().getIntExtra(EXTRA_IMAGE_INDEX, -1);     // Catch: Exception -> L5
    L8:
        if (this.imageUrls == null) goto L15;
        this.mAdapter = new ImagePagerAdapter(this, getSupportFragmentManager(), this.imageUrls.length);
        ViewPager r12 = (ViewPager) findViewById(R$id.pager);
        this.mPager = r12;
        r12.setAdapter(this.mAdapter);
        this.mPager.setImportantForAccessibility(2);
        this.dotGroup = (ViewGroup) findViewById(R$id.dot_group);
        setDot(this.imageUrls.length);
        this.mPager.setOnPageChangeListener(new AnonymousClass1(this));
        if (r11 == (-1)) goto L16;
        this.mPager.setCurrentItem(r11);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r11 = -1;
        goto L8
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        String[] r10 = this.imageUrls;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length <= 0) goto L11;
        DisplayMetrics r11 = getResources().getDisplayMetrics();
        String[] r12 = this.imageUrls;
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L12;
        String r15 = ImageLoader.j(r12[r14], r11.widthPixels, r11.heightPixels);
        x8.b.c().remove(r15);
        r14 = r14 + 1;
        goto L7
    L12:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        d9.b.b().h();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ImagePagerAdapter r10 = this.mAdapter;
        if (r10 == null) goto L5;
        r10.notifyDataSetChanged();
    L5:
        d9.b.b().i();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle r10) {
        r10.putString("language", Locale.getDefault().getCountry());
        super.onSaveInstanceState(r10);
    }

    public void setDot(int r10) {
        this.dotGroup.removeAllViews();
        this.tips = new ImageView[r10];
        int r11 = 0;
    L4:
        if (r11 >= this.tips.length) goto L10;
        ImageView r12 = new ImageView(this);
        r12.setLayoutParams(new ViewGroup.LayoutParams(5, 5));
        this.tips[r11] = r12;
        if (r11 != 0) goto L8;
        r12.setBackgroundResource(R$drawable.dot_active);
    L9:
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r13.leftMargin = 5;
        r13.rightMargin = 5;
        this.dotGroup.addView(r12, r13);
        r11 = r11 + 1;
        goto L4
    L8:
        r12.setBackgroundResource(R$drawable.dot_dark);
        goto L9
    }
}
