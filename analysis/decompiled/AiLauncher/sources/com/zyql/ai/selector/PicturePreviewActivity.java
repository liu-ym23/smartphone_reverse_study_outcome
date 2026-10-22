package com.zyql.ai.selector;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.zyql.ai.crop.UCrop;
import com.zyql.ai.selector.adapter.PictureSimpleFragmentAdapter;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnQueryDataResultListener;
import com.zyql.ai.selector.manager.UCropManager;
import com.zyql.ai.selector.model.LocalMediaPageLoader;
import com.zyql.ai.selector.observable.ImagesObservable;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import com.zyql.ai.selector.tools.AttrsUtils;
import com.zyql.ai.selector.tools.ScreenUtils;
import com.zyql.ai.selector.tools.StringUtils;
import com.zyql.ai.selector.tools.ToastUtils;
import com.zyql.ai.selector.tools.ValueOf;
import com.zyql.ai.selector.tools.VoiceUtils;
import com.zyql.ai.selector.widget.PreviewViewPager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PicturePreviewActivity extends PictureBaseActivity implements View.OnClickListener, PictureSimpleFragmentAdapter.OnCallBackActivity {
    private static final String TAG = "PicturePreviewActivity";
    protected PictureSimpleFragmentAdapter adapter;
    protected Animation animation;
    protected View btnCheck;
    protected TextView check;
    protected String currentDirectory;
    protected int index;
    protected boolean isBottomPreview;
    protected boolean isChangeSelectedData;
    protected boolean isCompleteOrSelected;
    protected boolean isShowCamera;
    protected CheckBox mCbOriginal;
    protected Handler mHandler;
    protected ImageView mIvArrow;
    protected View mPicturePreview;
    protected ViewGroup mTitleBar;
    protected TextView mTvPictureOk;
    protected TextView mTvPictureRight;
    protected ImageView pictureLeftBack;
    protected int position;
    protected boolean refresh;
    protected int screenWidth;
    protected RelativeLayout selectBarLayout;
    private int totalNumber;
    protected TextView tvMediaNum;
    protected TextView tvTitle;
    protected PreviewViewPager viewPager;
    protected List<LocalMedia> selectData = new ArrayList();
    private int mPage = 0;

    private void bothMimeTypeWith(String str, LocalMedia localMedia) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.enableCrop || pictureSelectionConfig.isCheckOriginalImage) {
            onBackPressed();
            return;
        }
        this.isCompleteOrSelected = false;
        boolean zIsHasImage = PictureMimeType.isHasImage(str);
        PictureSelectionConfig pictureSelectionConfig2 = this.config;
        if (pictureSelectionConfig2.selectionMode == 1 && zIsHasImage) {
            pictureSelectionConfig2.originalPath = localMedia.getPath();
            UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType());
            return;
        }
        int size = this.selectData.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            LocalMedia localMedia2 = this.selectData.get(i11);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && PictureMimeType.isHasImage(localMedia2.getMimeType())) {
                i10++;
            }
        }
        if (i10 > 0) {
            UCropManager.ofCrop(this, (ArrayList) this.selectData);
        } else {
            this.isCompleteOrSelected = true;
            onBackPressed();
        }
    }

    private void initViewPageAdapterData(List<LocalMedia> list) throws Resources.NotFoundException {
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter = new PictureSimpleFragmentAdapter(getContext(), this.config, this);
        this.adapter = pictureSimpleFragmentAdapter;
        pictureSimpleFragmentAdapter.bindData(list);
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.setCurrentItem(this.position);
        setTitle();
        onImageChecked(this.position);
        LocalMedia item = this.adapter.getItem(this.position);
        if (item != null) {
            this.index = item.getPosition();
            if (this.config.checkNumMode) {
                this.tvMediaNum.setSelected(true);
                this.check.setText(ValueOf.toString(Integer.valueOf(item.getNum())));
                notifyCheckChanged(item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isPreviewEggs(boolean z10, int i10, int i11) {
        if (!z10 || this.adapter.getSize() <= 0) {
            return;
        }
        if (i11 < this.screenWidth / 2) {
            LocalMedia item = this.adapter.getItem(i10);
            if (item != null) {
                this.check.setSelected(isSelected(item));
                PictureSelectionConfig pictureSelectionConfig = this.config;
                if (pictureSelectionConfig.isWeChatStyle) {
                    onUpdateSelectedChange(item);
                    return;
                } else {
                    if (pictureSelectionConfig.checkNumMode) {
                        this.check.setText(ValueOf.toString(Integer.valueOf(item.getNum())));
                        notifyCheckChanged(item);
                        onImageChecked(i10);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        int i12 = i10 + 1;
        LocalMedia item2 = this.adapter.getItem(i12);
        if (item2 != null) {
            this.check.setSelected(isSelected(item2));
            PictureSelectionConfig pictureSelectionConfig2 = this.config;
            if (pictureSelectionConfig2.isWeChatStyle) {
                onUpdateSelectedChange(item2);
            } else if (pictureSelectionConfig2.checkNumMode) {
                this.check.setText(ValueOf.toString(Integer.valueOf(item2.getNum())));
                notifyCheckChanged(item2);
                onImageChecked(i12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initWidgets$0(CompoundButton compoundButton, boolean z10) {
        this.config.isCheckOriginalImage = z10;
        if (this.selectData.size() == 0 && z10) {
            onCheckedComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadData$1(List list, int i10, boolean z10) {
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter;
        if (isFinishing()) {
            return;
        }
        this.isHasMore = z10;
        if (z10) {
            if (list.size() <= 0 || (pictureSimpleFragmentAdapter = this.adapter) == null) {
                loadMoreData();
            } else {
                pictureSimpleFragmentAdapter.getData().addAll(list);
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMoreData$2(List list, int i10, boolean z10) {
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter;
        if (isFinishing()) {
            return;
        }
        this.isHasMore = z10;
        if (z10) {
            if (list.size() <= 0 || (pictureSimpleFragmentAdapter = this.adapter) == null) {
                loadMoreData();
            } else {
                pictureSimpleFragmentAdapter.getData().addAll(list);
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    private void loadData() {
        long longExtra = getIntent().getLongExtra(PictureConfig.EXTRA_BUCKET_ID, -1L);
        this.mPage++;
        LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(longExtra, this.mPage, this.config.pageSize, new OnQueryDataResultListener() { // from class: com.zyql.ai.selector.o
            @Override // com.zyql.ai.selector.listener.OnQueryDataResultListener
            public final void onComplete(List list, int i10, boolean z10) {
                this.f32001a.lambda$loadData$1(list, i10, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMoreData() {
        long longExtra = getIntent().getLongExtra(PictureConfig.EXTRA_BUCKET_ID, -1L);
        this.mPage++;
        LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(longExtra, this.mPage, this.config.pageSize, new OnQueryDataResultListener() { // from class: com.zyql.ai.selector.p
            @Override // com.zyql.ai.selector.listener.OnQueryDataResultListener
            public final void onComplete(List list, int i10, boolean z10) {
                this.f32002a.lambda$loadMoreData$2(list, i10, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCheckChanged(LocalMedia localMedia) {
        if (this.config.checkNumMode) {
            this.check.setText("");
            int size = this.selectData.size();
            for (int i10 = 0; i10 < size; i10++) {
                LocalMedia localMedia2 = this.selectData.get(i10);
                if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                    localMedia.setNum(localMedia2.getNum());
                    this.check.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
                }
            }
        }
    }

    private void separateMimeTypeWith(String str, LocalMedia localMedia) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.enableCrop || pictureSelectionConfig.isCheckOriginalImage || !PictureMimeType.isHasImage(str)) {
            onBackPressed();
            return;
        }
        this.isCompleteOrSelected = false;
        PictureSelectionConfig pictureSelectionConfig2 = this.config;
        if (pictureSelectionConfig2.selectionMode != 1) {
            UCropManager.ofCrop(this, (ArrayList) this.selectData);
        } else {
            pictureSelectionConfig2.originalPath = localMedia.getPath();
            UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType());
        }
    }

    private void setNewTitle() {
        this.mPage = 0;
        this.position = 0;
        setTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle() {
        if (!this.config.isPageStrategy || this.isBottomPreview) {
            this.tvTitle.setText(getString(R.string.picture_preview_image_num, Integer.valueOf(this.position + 1), Integer.valueOf(this.adapter.getSize())));
        } else {
            this.tvTitle.setText(getString(R.string.picture_preview_image_num, Integer.valueOf(this.position + 1), Integer.valueOf(this.totalNumber)));
        }
    }

    private void subSelectPosition() {
        int size = this.selectData.size();
        int i10 = 0;
        while (i10 < size) {
            LocalMedia localMedia = this.selectData.get(i10);
            i10++;
            localMedia.setNum(i10);
        }
    }

    private void updateResult() {
        Intent intent = new Intent();
        if (this.isChangeSelectedData) {
            intent.putExtra(PictureConfig.EXTRA_COMPLETE_SELECTED, this.isCompleteOrSelected);
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) this.selectData);
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isOriginalControl) {
            intent.putExtra(PictureConfig.EXTRA_CHANGE_ORIGINAL, pictureSelectionConfig.isCheckOriginalImage);
        }
        setResult(0, intent);
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_preview;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initCompleteText(int i10) {
        int i11;
        int i12;
        int i13;
        if (this.config.selectionMode != 1) {
            if (i10 <= 0) {
                PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
                if (pictureSelectorUIStyle != null) {
                    this.mTvPictureOk.setText((!pictureSelectorUIStyle.isCompleteReplaceNum || (i12 = pictureSelectorUIStyle.picture_bottom_completeDefaultText) == 0) ? getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)) : String.format(getString(i12), Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                }
                PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
                if (pictureParameterStyle != null) {
                    this.mTvPictureOk.setText((!pictureParameterStyle.isCompleteReplaceNum || TextUtils.isEmpty(pictureParameterStyle.pictureUnCompleteText)) ? getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)) : PictureSelectionConfig.style.pictureUnCompleteText);
                    return;
                }
                return;
            }
            PictureSelectorUIStyle pictureSelectorUIStyle2 = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle2 != null) {
                if (!pictureSelectorUIStyle2.isCompleteReplaceNum || (i11 = pictureSelectorUIStyle2.picture_bottom_completeNormalText) == 0) {
                    this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                } else {
                    this.mTvPictureOk.setText(String.format(getString(i11), Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                }
            }
            PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
            if (pictureParameterStyle2 != null) {
                if (!pictureParameterStyle2.isCompleteReplaceNum || TextUtils.isEmpty(pictureParameterStyle2.pictureCompleteText)) {
                    this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                } else {
                    this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(i10), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                }
            }
            return;
        }
        if (i10 <= 0) {
            PictureSelectorUIStyle pictureSelectorUIStyle3 = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle3 == null) {
                PictureParameterStyle pictureParameterStyle3 = PictureSelectionConfig.style;
                if (pictureParameterStyle3 != null) {
                    this.mTvPictureOk.setText(!TextUtils.isEmpty(pictureParameterStyle3.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : getString(R.string.picture_please_select));
                    return;
                }
                return;
            }
            TextView textView = this.mTvPictureOk;
            int i14 = pictureSelectorUIStyle3.picture_bottom_completeDefaultText;
            if (i14 == 0) {
                i14 = R.string.picture_please_select;
            }
            textView.setText(getString(i14));
            return;
        }
        PictureSelectorUIStyle pictureSelectorUIStyle4 = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle4 == null) {
            PictureParameterStyle pictureParameterStyle4 = PictureSelectionConfig.style;
            if (pictureParameterStyle4 != null) {
                if (!pictureParameterStyle4.isCompleteReplaceNum || TextUtils.isEmpty(pictureParameterStyle4.pictureCompleteText)) {
                    this.mTvPictureOk.setText(!TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText) ? PictureSelectionConfig.style.pictureCompleteText : getString(R.string.picture_done));
                    return;
                } else {
                    this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(i10), 1));
                    return;
                }
            }
            return;
        }
        if (pictureSelectorUIStyle4.isCompleteReplaceNum && (i13 = pictureSelectorUIStyle4.picture_bottom_completeNormalText) != 0) {
            this.mTvPictureOk.setText(String.format(getString(i13), Integer.valueOf(i10), 1));
            return;
        }
        TextView textView2 = this.mTvPictureOk;
        int i15 = pictureSelectorUIStyle4.picture_bottom_completeNormalText;
        if (i15 == 0) {
            i15 = R.string.picture_done;
        }
        textView2.setText(getString(i15));
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initPictureSelectorStyle() throws Resources.NotFoundException {
        ColorStateList colorStateList;
        PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle != null) {
            int i10 = pictureSelectorUIStyle.picture_top_titleTextColor;
            if (i10 != 0) {
                this.tvTitle.setTextColor(i10);
            }
            int i11 = PictureSelectionConfig.uiStyle.picture_top_titleTextSize;
            if (i11 != 0) {
                this.tvTitle.setTextSize(i11);
            }
            int i12 = PictureSelectionConfig.uiStyle.picture_top_leftBack;
            if (i12 != 0) {
                this.pictureLeftBack.setImageResource(i12);
            }
            int i13 = PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor;
            if (i13 != 0) {
                this.selectBarLayout.setBackgroundColor(i13);
            }
            int i14 = PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground;
            if (i14 != 0) {
                this.tvMediaNum.setBackgroundResource(i14);
            }
            int i15 = PictureSelectionConfig.uiStyle.picture_check_style;
            if (i15 != 0) {
                this.check.setBackgroundResource(i15);
            }
            int[] iArr = PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor;
            if (iArr.length > 0 && (colorStateList = AttrsUtils.getColorStateList(iArr)) != null) {
                this.mTvPictureOk.setTextColor(colorStateList);
            }
            int i16 = PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText;
            if (i16 != 0) {
                this.mTvPictureOk.setText(i16);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_top_titleBarHeight;
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barHeight > 0) {
                this.selectBarLayout.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_bottom_barHeight;
            }
            if (this.config.isOriginalControl) {
                int i17 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle;
                if (i17 != 0) {
                    this.mCbOriginal.setButtonDrawable(i17);
                } else {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_checkbox));
                }
                int i18 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor;
                if (i18 != 0) {
                    this.mCbOriginal.setTextColor(i18);
                } else {
                    this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_53575e));
                }
                int i19 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize;
                if (i19 != 0) {
                    this.mCbOriginal.setTextSize(i19);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_53575e));
            }
        } else {
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle != null) {
                int i20 = pictureParameterStyle.pictureTitleTextColor;
                if (i20 != 0) {
                    this.tvTitle.setTextColor(i20);
                }
                int i21 = PictureSelectionConfig.style.pictureTitleTextSize;
                if (i21 != 0) {
                    this.tvTitle.setTextSize(i21);
                }
                int i22 = PictureSelectionConfig.style.pictureLeftBackIcon;
                if (i22 != 0) {
                    this.pictureLeftBack.setImageResource(i22);
                }
                int i23 = PictureSelectionConfig.style.picturePreviewBottomBgColor;
                if (i23 != 0) {
                    this.selectBarLayout.setBackgroundColor(i23);
                }
                int i24 = PictureSelectionConfig.style.pictureCheckNumBgStyle;
                if (i24 != 0) {
                    this.tvMediaNum.setBackgroundResource(i24);
                }
                int i25 = PictureSelectionConfig.style.pictureCheckedStyle;
                if (i25 != 0) {
                    this.check.setBackgroundResource(i25);
                }
                int i26 = PictureSelectionConfig.style.pictureUnCompleteTextColor;
                if (i26 != 0) {
                    this.mTvPictureOk.setTextColor(i26);
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                    this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureUnCompleteText);
                }
                if (PictureSelectionConfig.style.pictureTitleBarHeight > 0) {
                    this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.style.pictureTitleBarHeight;
                }
                if (this.config.isOriginalControl) {
                    int i27 = PictureSelectionConfig.style.pictureOriginalControlStyle;
                    if (i27 != 0) {
                        this.mCbOriginal.setButtonDrawable(i27);
                    } else {
                        this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_checkbox));
                    }
                    int i28 = PictureSelectionConfig.style.pictureOriginalFontColor;
                    if (i28 != 0) {
                        this.mCbOriginal.setTextColor(i28);
                    } else {
                        this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_53575e));
                    }
                    int i29 = PictureSelectionConfig.style.pictureOriginalTextSize;
                    if (i29 != 0) {
                        this.mCbOriginal.setTextSize(i29);
                    }
                } else {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_checkbox));
                    this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_53575e));
                }
            } else {
                this.check.setBackground(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_checked_style, R.drawable.picture_checkbox_selector));
                ColorStateList typeValueColorStateList = AttrsUtils.getTypeValueColorStateList(getContext(), R.attr.picture_ac_preview_complete_textColor);
                if (typeValueColorStateList != null) {
                    this.mTvPictureOk.setTextColor(typeValueColorStateList);
                }
                this.pictureLeftBack.setImageDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_preview_leftBack_icon, R.drawable.picture_icon_back));
                int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_ac_preview_title_textColor);
                if (typeValueColor != 0) {
                    this.tvTitle.setTextColor(typeValueColor);
                }
                this.tvMediaNum.setBackground(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_num_style, R.drawable.picture_num_oval));
                int typeValueColor2 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_ac_preview_bottom_bg);
                if (typeValueColor2 != 0) {
                    this.selectBarLayout.setBackgroundColor(typeValueColor2);
                }
                int typeValueSizeForInt = AttrsUtils.getTypeValueSizeForInt(getContext(), R.attr.picture_titleBar_height);
                if (typeValueSizeForInt > 0) {
                    this.mTitleBar.getLayoutParams().height = typeValueSizeForInt;
                }
                if (this.config.isOriginalControl) {
                    this.mCbOriginal.setButtonDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_original_check_style, R.drawable.picture_original_wechat_checkbox));
                    int typeValueColor3 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_original_text_color);
                    if (typeValueColor3 != 0) {
                        this.mCbOriginal.setTextColor(typeValueColor3);
                    }
                }
            }
        }
        this.mTitleBar.setBackgroundColor(this.colorPrimary);
        onSelectNumChange(false);
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initWidgets() throws Resources.NotFoundException {
        super.initWidgets();
        this.mHandler = new Handler(getMainLooper());
        this.mTitleBar = (ViewGroup) findViewById(R.id.titleBar);
        this.screenWidth = ScreenUtils.getScreenWidth(this);
        this.animation = AnimationUtils.loadAnimation(this, R.anim.picture_anim_modal_in);
        this.pictureLeftBack = (ImageView) findViewById(R.id.pictureLeftBack);
        this.mTvPictureRight = (TextView) findViewById(R.id.picture_right);
        this.mIvArrow = (ImageView) findViewById(R.id.ivArrow);
        this.viewPager = (PreviewViewPager) findViewById(R.id.preview_pager);
        this.mPicturePreview = findViewById(R.id.picture_id_preview);
        this.btnCheck = findViewById(R.id.btnCheck);
        this.check = (TextView) findViewById(R.id.check);
        this.pictureLeftBack.setOnClickListener(this);
        this.mTvPictureOk = (TextView) findViewById(R.id.picture_tv_ok);
        this.mCbOriginal = (CheckBox) findViewById(R.id.cb_original);
        this.tvMediaNum = (TextView) findViewById(R.id.tv_media_num);
        this.selectBarLayout = (RelativeLayout) findViewById(R.id.select_bar_layout);
        this.mTvPictureOk.setOnClickListener(this);
        this.tvMediaNum.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.picture_title);
        this.mPicturePreview.setVisibility(8);
        this.mIvArrow.setVisibility(8);
        this.mTvPictureRight.setVisibility(8);
        this.check.setVisibility(0);
        this.btnCheck.setVisibility(0);
        this.position = getIntent().getIntExtra("position", 0);
        if (this.numComplete) {
            initCompleteText(0);
        }
        this.tvMediaNum.setSelected(this.config.checkNumMode);
        this.btnCheck.setOnClickListener(this);
        if (getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST) != null) {
            this.selectData = getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST);
        }
        this.isBottomPreview = getIntent().getBooleanExtra(PictureConfig.EXTRA_BOTTOM_PREVIEW, false);
        this.isShowCamera = getIntent().getBooleanExtra(PictureConfig.EXTRA_SHOW_CAMERA, this.config.isCamera);
        this.currentDirectory = getIntent().getStringExtra(PictureConfig.EXTRA_IS_CURRENT_DIRECTORY);
        if (this.isBottomPreview) {
            initViewPageAdapterData(getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST));
        } else {
            ArrayList arrayList = new ArrayList(ImagesObservable.getInstance().readPreviewMediaData());
            boolean z10 = arrayList.size() == 0;
            this.totalNumber = getIntent().getIntExtra("count", 0);
            if (this.config.isPageStrategy) {
                if (z10) {
                    setNewTitle();
                } else {
                    this.mPage = getIntent().getIntExtra("page", 0);
                }
                initViewPageAdapterData(arrayList);
                loadData();
                setTitle();
            } else {
                initViewPageAdapterData(arrayList);
                if (z10) {
                    this.config.isPageStrategy = true;
                    setNewTitle();
                    loadData();
                }
            }
        }
        this.viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.zyql.ai.selector.PicturePreviewActivity.1
            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrollStateChanged(int i10) {
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrolled(int i10, float f10, int i11) {
                PicturePreviewActivity picturePreviewActivity = PicturePreviewActivity.this;
                picturePreviewActivity.isPreviewEggs(picturePreviewActivity.config.previewEggs, i10, i11);
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageSelected(int i10) {
                PicturePreviewActivity picturePreviewActivity = PicturePreviewActivity.this;
                picturePreviewActivity.position = i10;
                picturePreviewActivity.setTitle();
                PicturePreviewActivity picturePreviewActivity2 = PicturePreviewActivity.this;
                LocalMedia item = picturePreviewActivity2.adapter.getItem(picturePreviewActivity2.position);
                if (item == null) {
                    return;
                }
                PicturePreviewActivity.this.index = item.getPosition();
                PicturePreviewActivity picturePreviewActivity3 = PicturePreviewActivity.this;
                PictureSelectionConfig pictureSelectionConfig = picturePreviewActivity3.config;
                if (!pictureSelectionConfig.previewEggs) {
                    if (pictureSelectionConfig.checkNumMode) {
                        picturePreviewActivity3.check.setText(ValueOf.toString(Integer.valueOf(item.getNum())));
                        PicturePreviewActivity.this.notifyCheckChanged(item);
                    }
                    PicturePreviewActivity picturePreviewActivity4 = PicturePreviewActivity.this;
                    picturePreviewActivity4.onImageChecked(picturePreviewActivity4.position);
                }
                if (PicturePreviewActivity.this.config.isOriginalControl) {
                    PicturePreviewActivity.this.mCbOriginal.setVisibility(PictureMimeType.isHasVideo(item.getMimeType()) ? 8 : 0);
                    PicturePreviewActivity picturePreviewActivity5 = PicturePreviewActivity.this;
                    picturePreviewActivity5.mCbOriginal.setChecked(picturePreviewActivity5.config.isCheckOriginalImage);
                }
                PicturePreviewActivity.this.onPageSelectedChange(item);
                PicturePreviewActivity picturePreviewActivity6 = PicturePreviewActivity.this;
                if (picturePreviewActivity6.config.isPageStrategy && !picturePreviewActivity6.isBottomPreview && picturePreviewActivity6.isHasMore) {
                    if (picturePreviewActivity6.position != picturePreviewActivity6.adapter.getSize() - 11) {
                        if (PicturePreviewActivity.this.position != r4.adapter.getSize() - 1) {
                            return;
                        }
                    }
                    PicturePreviewActivity.this.loadMoreData();
                }
            }
        });
        if (this.config.isOriginalControl) {
            boolean booleanExtra = getIntent().getBooleanExtra(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
            this.mCbOriginal.setVisibility(0);
            this.config.isCheckOriginalImage = booleanExtra;
            this.mCbOriginal.setChecked(booleanExtra);
            this.mCbOriginal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zyql.ai.selector.q
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                    this.f32003a.lambda$initWidgets$0(compoundButton, z11);
                }
            });
        }
    }

    public boolean isSelected(LocalMedia localMedia) {
        int size = this.selectData.size();
        for (int i10 = 0; i10 < size; i10++) {
            LocalMedia localMedia2 = this.selectData.get(i10);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.zyql.ai.selector.adapter.PictureSimpleFragmentAdapter.OnCallBackActivity
    public void onActivityBackPressed() {
        onBackPressed();
    }

    @Override // androidx.fragment.app.r, b.q, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        Throwable th;
        super.onActivityResult(i10, i11, intent);
        if (i11 != -1) {
            if (i11 != 96 || (th = (Throwable) intent.getSerializableExtra(UCrop.EXTRA_ERROR)) == null) {
                return;
            }
            ToastUtils.s(getContext(), th.getMessage());
            return;
        }
        if (i10 == 69) {
            if (intent != null) {
                intent.putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) this.selectData);
                setResult(-1, intent);
            }
            finish();
            return;
        }
        if (i10 != 609) {
            return;
        }
        intent.putParcelableArrayListExtra(UCrop.Options.EXTRA_OUTPUT_URI_LIST, UCrop.getMultipleOutput(intent));
        intent.putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) this.selectData);
        setResult(-1, intent);
        finish();
    }

    @Override // b.q, android.app.Activity
    public void onBackPressed() {
        updateResult();
        finish();
        overridePendingTransition(0, PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
    }

    public void onCheckedComplete() {
        int i10;
        boolean z10;
        if (this.adapter.getSize() > 0) {
            LocalMedia item = this.adapter.getItem(this.viewPager.getCurrentItem());
            String realPath = item.getRealPath();
            if (!TextUtils.isEmpty(realPath) && !new File(realPath).exists()) {
                ToastUtils.s(getContext(), PictureMimeType.s(getContext(), item.getMimeType()));
                return;
            }
            String mimeType = this.selectData.size() > 0 ? this.selectData.get(0).getMimeType() : "";
            int size = this.selectData.size();
            if (this.config.isWithVideoImage) {
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    if (PictureMimeType.isHasVideo(this.selectData.get(i12).getMimeType())) {
                        i11++;
                    }
                }
                if (PictureMimeType.isHasVideo(item.getMimeType())) {
                    PictureSelectionConfig pictureSelectionConfig = this.config;
                    if (pictureSelectionConfig.maxVideoSelectNum <= 0) {
                        showPromptDialog(getString(R.string.picture_rule));
                        return;
                    }
                    if (size >= pictureSelectionConfig.maxSelectNum && !this.check.isSelected()) {
                        showPromptDialog(getString(R.string.picture_message_max_num, Integer.valueOf(this.config.maxSelectNum)));
                        return;
                    }
                    if (i11 >= this.config.maxVideoSelectNum && !this.check.isSelected()) {
                        showPromptDialog(StringUtils.getMsg(getContext(), item.getMimeType(), this.config.maxVideoSelectNum));
                        return;
                    }
                    if (!this.check.isSelected() && this.config.videoMinSecond > 0 && item.getDuration() < this.config.videoMinSecond) {
                        showPromptDialog(getContext().getString(R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                        return;
                    } else if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && item.getDuration() > this.config.videoMaxSecond) {
                        showPromptDialog(getContext().getString(R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                        return;
                    }
                } else if (size >= this.config.maxSelectNum && !this.check.isSelected()) {
                    showPromptDialog(getString(R.string.picture_message_max_num, Integer.valueOf(this.config.maxSelectNum)));
                    return;
                }
            } else {
                if (!TextUtils.isEmpty(mimeType) && !PictureMimeType.isMimeTypeSame(mimeType, item.getMimeType())) {
                    showPromptDialog(getString(R.string.picture_rule));
                    return;
                }
                if (!PictureMimeType.isHasVideo(mimeType) || (i10 = this.config.maxVideoSelectNum) <= 0) {
                    if (size >= this.config.maxSelectNum && !this.check.isSelected()) {
                        showPromptDialog(StringUtils.getMsg(getContext(), mimeType, this.config.maxSelectNum));
                        return;
                    }
                    if (PictureMimeType.isHasVideo(item.getMimeType())) {
                        if (!this.check.isSelected() && this.config.videoMinSecond > 0 && item.getDuration() < this.config.videoMinSecond) {
                            showPromptDialog(getContext().getString(R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                            return;
                        } else if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && item.getDuration() > this.config.videoMaxSecond) {
                            showPromptDialog(getContext().getString(R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                            return;
                        }
                    }
                } else {
                    if (size >= i10 && !this.check.isSelected()) {
                        showPromptDialog(StringUtils.getMsg(getContext(), mimeType, this.config.maxVideoSelectNum));
                        return;
                    }
                    if (!this.check.isSelected() && this.config.videoMinSecond > 0 && item.getDuration() < this.config.videoMinSecond) {
                        showPromptDialog(getContext().getString(R.string.picture_choose_min_seconds, Integer.valueOf(this.config.videoMinSecond / 1000)));
                        return;
                    } else if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && item.getDuration() > this.config.videoMaxSecond) {
                        showPromptDialog(getContext().getString(R.string.picture_choose_max_seconds, Integer.valueOf(this.config.videoMaxSecond / 1000)));
                        return;
                    }
                }
            }
            if (this.check.isSelected()) {
                this.check.setSelected(false);
                z10 = false;
            } else {
                this.check.setSelected(true);
                this.check.startAnimation(this.animation);
                z10 = true;
            }
            this.isChangeSelectedData = true;
            if (z10) {
                VoiceUtils.getInstance().play();
                if (this.config.selectionMode == 1) {
                    this.selectData.clear();
                }
                this.selectData.add(item);
                onSelectedChange(true, item);
                item.setNum(this.selectData.size());
                if (this.config.checkNumMode) {
                    this.check.setText(ValueOf.toString(Integer.valueOf(item.getNum())));
                }
            } else {
                int size2 = this.selectData.size();
                for (int i13 = 0; i13 < size2; i13++) {
                    LocalMedia localMedia = this.selectData.get(i13);
                    if (localMedia.getPath().equals(item.getPath()) || localMedia.getId() == item.getId()) {
                        this.selectData.remove(localMedia);
                        onSelectedChange(false, item);
                        subSelectPosition();
                        notifyCheckChanged(localMedia);
                        break;
                    }
                }
            }
            onSelectNumChange(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pictureLeftBack) {
            onBackPressed();
            return;
        }
        if (id == R.id.picture_tv_ok || id == R.id.tv_media_num) {
            onComplete();
        } else if (id == R.id.btnCheck) {
            onCheckedComplete();
        }
    }

    public void onComplete() {
        int i10;
        int i11;
        int size = this.selectData.size();
        LocalMedia localMedia = this.selectData.size() > 0 ? this.selectData.get(0) : null;
        String mimeType = localMedia != null ? localMedia.getMimeType() : "";
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isWithVideoImage) {
            int size2 = this.selectData.size();
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < size2; i14++) {
                if (PictureMimeType.isHasVideo(this.selectData.get(i14).getMimeType())) {
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
        this.isCompleteOrSelected = true;
        this.isChangeSelectedData = true;
        if (this.config.chooseMode == PictureMimeType.ofAll() && this.config.isWithVideoImage) {
            bothMimeTypeWith(mimeType, localMedia);
        } else {
            separateMimeTypeWith(mimeType, localMedia);
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            List<LocalMedia> listObtainSelectorList = PictureSelector.obtainSelectorList(bundle);
            if (listObtainSelectorList == null) {
                listObtainSelectorList = this.selectData;
            }
            this.selectData = listObtainSelectorList;
            this.isCompleteOrSelected = bundle.getBoolean(PictureConfig.EXTRA_COMPLETE_SELECTED, false);
            this.isChangeSelectedData = bundle.getBoolean(PictureConfig.EXTRA_CHANGE_SELECTED_DATA, false);
            onImageChecked(this.position);
            onSelectNumChange(false);
        }
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (!this.isOnSaveInstanceState) {
            ImagesObservable.getInstance().clearPreviewMediaData();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        Animation animation = this.animation;
        if (animation != null) {
            animation.cancel();
            this.animation = null;
        }
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter = this.adapter;
        if (pictureSimpleFragmentAdapter != null) {
            pictureSimpleFragmentAdapter.clear();
        }
    }

    public void onImageChecked(int i10) {
        if (this.adapter.getSize() <= 0) {
            this.check.setSelected(false);
            return;
        }
        LocalMedia item = this.adapter.getItem(i10);
        if (item != null) {
            this.check.setSelected(isSelected(item));
        }
    }

    public void onPageSelectedChange(LocalMedia localMedia) {
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity, b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PictureConfig.EXTRA_COMPLETE_SELECTED, this.isCompleteOrSelected);
        bundle.putBoolean(PictureConfig.EXTRA_CHANGE_SELECTED_DATA, this.isChangeSelectedData);
        PictureSelector.saveSelectorList(bundle, this.selectData);
    }

    public void onSelectNumChange(boolean z10) {
        this.refresh = z10;
        if (this.selectData.size() == 0) {
            this.mTvPictureOk.setEnabled(false);
            this.mTvPictureOk.setSelected(false);
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle != null) {
                int i10 = pictureParameterStyle.pictureUnCompleteTextColor;
                if (i10 != 0) {
                    this.mTvPictureOk.setTextColor(i10);
                } else {
                    this.mTvPictureOk.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_9b));
                }
            }
            if (this.numComplete) {
                initCompleteText(0);
                return;
            }
            this.tvMediaNum.setVisibility(4);
            PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle != null) {
                int i11 = pictureSelectorUIStyle.picture_bottom_completeDefaultText;
                if (i11 != 0) {
                    this.mTvPictureOk.setText(i11);
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
        PictureParameterStyle pictureParameterStyle3 = PictureSelectionConfig.style;
        if (pictureParameterStyle3 != null) {
            int i12 = pictureParameterStyle3.pictureCompleteTextColor;
            if (i12 != 0) {
                this.mTvPictureOk.setTextColor(i12);
            } else {
                this.mTvPictureOk.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_fa632d));
            }
        }
        if (this.numComplete) {
            initCompleteText(this.selectData.size());
            return;
        }
        if (this.refresh) {
            this.tvMediaNum.startAnimation(this.animation);
        }
        this.tvMediaNum.setVisibility(0);
        this.tvMediaNum.setText(ValueOf.toString(Integer.valueOf(this.selectData.size())));
        PictureSelectorUIStyle pictureSelectorUIStyle2 = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle2 != null) {
            int i13 = pictureSelectorUIStyle2.picture_bottom_completeNormalText;
            if (i13 != 0) {
                this.mTvPictureOk.setText(i13);
                return;
            }
            return;
        }
        PictureParameterStyle pictureParameterStyle4 = PictureSelectionConfig.style;
        if (pictureParameterStyle4 == null) {
            this.mTvPictureOk.setText(getString(R.string.picture_completed));
        } else {
            if (TextUtils.isEmpty(pictureParameterStyle4.pictureCompleteText)) {
                return;
            }
            this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureCompleteText);
        }
    }

    public void onSelectedChange(boolean z10, LocalMedia localMedia) {
    }

    public void onUpdateSelectedChange(LocalMedia localMedia) {
    }
}
