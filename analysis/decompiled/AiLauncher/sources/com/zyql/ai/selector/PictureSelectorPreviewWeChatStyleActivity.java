package com.zyql.ai.selector;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zyql.ai.selector.adapter.PictureWeChatPreviewGalleryAdapter;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;

/* loaded from: classes4.dex */
public class PictureSelectorPreviewWeChatStyleActivity extends PicturePreviewActivity {
    private static final int ALPHA_DURATION = 300;
    private View bottomLine;
    private PictureWeChatPreviewGalleryAdapter mGalleryAdapter;
    private RecyclerView mRvGallery;
    private TextView mTvSelected;

    private void goneParent() {
        if (this.tvMediaNum.getVisibility() == 0) {
            this.tvMediaNum.setVisibility(8);
        }
        if (this.mTvPictureOk.getVisibility() == 0) {
            this.mTvPictureOk.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.check.getText())) {
            return;
        }
        this.check.setText("");
    }

    private boolean isEqualsDirectory(String str, String str2) {
        return this.isBottomPreview || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.equals(getString(R.string.picture_camera_roll)) || str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initWidgets$0(int i10, LocalMedia localMedia, View view) throws Resources.NotFoundException {
        if (this.viewPager == null || localMedia == null || !isEqualsDirectory(localMedia.getParentFolderName(), this.currentDirectory)) {
            return;
        }
        if (!this.isBottomPreview) {
            i10 = this.isShowCamera ? localMedia.position - 1 : localMedia.position;
        }
        this.viewPager.setCurrentItem(i10);
    }

    private void onChangeMediaStatus(LocalMedia localMedia) {
        int itemCount;
        PictureWeChatPreviewGalleryAdapter pictureWeChatPreviewGalleryAdapter = this.mGalleryAdapter;
        if (pictureWeChatPreviewGalleryAdapter == null || (itemCount = pictureWeChatPreviewGalleryAdapter.getItemCount()) <= 0) {
            return;
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < itemCount; i10++) {
            LocalMedia item = this.mGalleryAdapter.getItem(i10);
            if (item != null && !TextUtils.isEmpty(item.getPath())) {
                boolean zIsChecked = item.isChecked();
                boolean z11 = item.getPath().equals(localMedia.getPath()) || item.getId() == localMedia.getId();
                if (!z10) {
                    z10 = (zIsChecked && !z11) || (!zIsChecked && z11);
                }
                item.setChecked(z11);
            }
        }
        if (z10) {
            this.mGalleryAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.zyql.ai.selector.PicturePreviewActivity, com.zyql.ai.selector.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_wechat_style_preview;
    }

    @Override // com.zyql.ai.selector.PicturePreviewActivity, com.zyql.ai.selector.PictureBaseActivity
    public void initCompleteText(int i10) {
        int i11;
        PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
        boolean z10 = pictureParameterStyle != null;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isWithVideoImage) {
            if (pictureSelectionConfig.selectionMode != 1) {
                if (z10 && pictureParameterStyle.isCompleteReplaceNum && !TextUtils.isEmpty(pictureParameterStyle.pictureCompleteText)) {
                    this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(this.selectData.size()), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                } else {
                    this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) ? getString(R.string.picture_send_num, Integer.valueOf(this.selectData.size()), Integer.valueOf(this.config.maxSelectNum)) : PictureSelectionConfig.style.pictureUnCompleteText);
                    return;
                }
            }
            if (i10 <= 0) {
                this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(pictureParameterStyle.pictureUnCompleteText)) ? getString(R.string.picture_send) : PictureSelectionConfig.style.pictureUnCompleteText);
                return;
            } else if (z10 && pictureParameterStyle.isCompleteReplaceNum && !TextUtils.isEmpty(pictureParameterStyle.pictureCompleteText)) {
                this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(this.selectData.size()), 1));
                return;
            } else {
                this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) ? getString(R.string.picture_send) : PictureSelectionConfig.style.pictureCompleteText);
                return;
            }
        }
        if (!PictureMimeType.isHasVideo(this.selectData.size() > 0 ? this.selectData.get(0).getMimeType() : "") || (i11 = this.config.maxVideoSelectNum) <= 0) {
            i11 = this.config.maxSelectNum;
        }
        if (this.config.selectionMode != 1) {
            if (z10) {
                PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
                if (pictureParameterStyle2.isCompleteReplaceNum && !TextUtils.isEmpty(pictureParameterStyle2.pictureCompleteText)) {
                    this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(this.selectData.size()), Integer.valueOf(i11)));
                    return;
                }
            }
            this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) ? getString(R.string.picture_send_num, Integer.valueOf(this.selectData.size()), Integer.valueOf(i11)) : PictureSelectionConfig.style.pictureUnCompleteText);
            return;
        }
        if (i10 <= 0) {
            this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) ? getString(R.string.picture_send) : PictureSelectionConfig.style.pictureUnCompleteText);
            return;
        }
        if (z10) {
            PictureParameterStyle pictureParameterStyle3 = PictureSelectionConfig.style;
            if (pictureParameterStyle3.isCompleteReplaceNum && !TextUtils.isEmpty(pictureParameterStyle3.pictureCompleteText)) {
                this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(this.selectData.size()), 1));
                return;
            }
        }
        this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) ? getString(R.string.picture_send) : PictureSelectionConfig.style.pictureCompleteText);
    }

    @Override // com.zyql.ai.selector.PicturePreviewActivity, com.zyql.ai.selector.PictureBaseActivity
    public void initPictureSelectorStyle() throws Resources.NotFoundException {
        super.initPictureSelectorStyle();
        PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle != null) {
            int i10 = pictureSelectorUIStyle.picture_top_titleRightDefaultText;
            if (i10 != 0) {
                this.mTvPictureRight.setText(getString(i10));
            }
            int i11 = PictureSelectionConfig.uiStyle.picture_top_titleRightTextNormalBackground;
            if (i11 != 0) {
                this.mTvPictureRight.setBackgroundResource(i11);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
            }
            int i12 = PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize;
            if (i12 != 0) {
                this.mTvPictureRight.setTextSize(i12);
            }
            int i13 = PictureSelectionConfig.uiStyle.picture_bottom_selectedText;
            if (i13 != 0) {
                this.mTvSelected.setText(getString(i13));
            }
            int i14 = PictureSelectionConfig.uiStyle.picture_bottom_selectedTextSize;
            if (i14 != 0) {
                this.mTvSelected.setTextSize(i14);
            }
            int i15 = PictureSelectionConfig.uiStyle.picture_bottom_selectedTextColor;
            if (i15 != 0) {
                this.mTvSelected.setTextColor(i15);
            }
            int i16 = PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor;
            if (i16 != 0) {
                this.selectBarLayout.setBackgroundColor(i16);
            } else {
                this.selectBarLayout.setBackgroundColor(androidx.core.content.a.c(getContext(), R.color.picture_color_half_grey));
            }
            this.mTvPictureRight.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_white));
            int i17 = PictureSelectionConfig.uiStyle.picture_bottom_selectedCheckStyle;
            if (i17 != 0) {
                this.check.setBackgroundResource(i17);
            } else {
                this.check.setBackgroundResource(R.drawable.picture_wechat_select_cb);
            }
            int i18 = PictureSelectionConfig.uiStyle.picture_top_leftBack;
            if (i18 != 0) {
                this.pictureLeftBack.setImageResource(i18);
            } else {
                this.pictureLeftBack.setImageResource(R.drawable.picture_icon_back);
            }
            int i19 = PictureSelectionConfig.uiStyle.picture_bottom_gallery_dividerColor;
            if (i19 != 0) {
                this.bottomLine.setBackgroundColor(i19);
            }
            int i20 = PictureSelectionConfig.uiStyle.picture_bottom_gallery_backgroundColor;
            if (i20 != 0) {
                this.mRvGallery.setBackgroundColor(i20);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_gallery_height > 0) {
                this.mRvGallery.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_bottom_gallery_height;
            }
            if (this.config.isOriginalControl) {
                int i21 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText;
                if (i21 != 0) {
                    this.mCbOriginal.setText(getString(i21));
                } else {
                    this.mCbOriginal.setText(getString(R.string.picture_original_image));
                }
                int i22 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize;
                if (i22 != 0) {
                    this.mCbOriginal.setTextSize(i22);
                } else {
                    this.mCbOriginal.setTextSize(14.0f);
                }
                int i23 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor;
                if (i23 != 0) {
                    this.mCbOriginal.setTextColor(i23);
                } else {
                    this.mCbOriginal.setTextColor(Color.parseColor("#FFFFFF"));
                }
                int i24 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle;
                if (i24 != 0) {
                    this.mCbOriginal.setButtonDrawable(i24);
                } else {
                    this.mCbOriginal.setButtonDrawable(R.drawable.picture_original_wechat_checkbox);
                }
            }
        } else {
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle != null) {
                int i25 = pictureParameterStyle.pictureCompleteBackgroundStyle;
                if (i25 != 0) {
                    this.mTvPictureRight.setBackgroundResource(i25);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
                }
                int i26 = PictureSelectionConfig.style.pictureRightTextSize;
                if (i26 != 0) {
                    this.mTvPictureRight.setTextSize(i26);
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureWeChatPreviewSelectedText)) {
                    this.mTvSelected.setText(PictureSelectionConfig.style.pictureWeChatPreviewSelectedText);
                }
                int i27 = PictureSelectionConfig.style.pictureWeChatPreviewSelectedTextSize;
                if (i27 != 0) {
                    this.mTvSelected.setTextSize(i27);
                }
                int i28 = PictureSelectionConfig.style.picturePreviewBottomBgColor;
                if (i28 != 0) {
                    this.selectBarLayout.setBackgroundColor(i28);
                } else {
                    this.selectBarLayout.setBackgroundColor(androidx.core.content.a.c(getContext(), R.color.picture_color_half_grey));
                }
                PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
                int i29 = pictureParameterStyle2.pictureCompleteTextColor;
                if (i29 != 0) {
                    this.mTvPictureRight.setTextColor(i29);
                } else {
                    int i30 = pictureParameterStyle2.pictureCancelTextColor;
                    if (i30 != 0) {
                        this.mTvPictureRight.setTextColor(i30);
                    } else {
                        this.mTvPictureRight.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_white));
                    }
                }
                if (PictureSelectionConfig.style.pictureOriginalFontColor == 0) {
                    this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_white));
                }
                int i31 = PictureSelectionConfig.style.pictureWeChatChooseStyle;
                if (i31 != 0) {
                    this.check.setBackgroundResource(i31);
                } else {
                    this.check.setBackgroundResource(R.drawable.picture_wechat_select_cb);
                }
                if (this.config.isOriginalControl && PictureSelectionConfig.style.pictureOriginalControlStyle == 0) {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_wechat_checkbox));
                }
                int i32 = PictureSelectionConfig.style.pictureWeChatLeftBackStyle;
                if (i32 != 0) {
                    this.pictureLeftBack.setImageResource(i32);
                } else {
                    this.pictureLeftBack.setImageResource(R.drawable.picture_icon_back);
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                    this.mTvPictureRight.setText(PictureSelectionConfig.style.pictureUnCompleteText);
                }
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
                TextView textView = this.mTvPictureRight;
                Context context = getContext();
                int i33 = R.color.picture_color_white;
                textView.setTextColor(androidx.core.content.a.c(context, i33));
                this.selectBarLayout.setBackgroundColor(androidx.core.content.a.c(getContext(), R.color.picture_color_half_grey));
                this.check.setBackgroundResource(R.drawable.picture_wechat_select_cb);
                this.pictureLeftBack.setImageResource(R.drawable.picture_icon_back);
                this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, i33));
                if (this.config.isOriginalControl) {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_wechat_checkbox));
                }
            }
        }
        onSelectNumChange(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00d9, code lost:
    
        r5 = true;
     */
    @Override // com.zyql.ai.selector.PicturePreviewActivity, com.zyql.ai.selector.PictureBaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initWidgets() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.PictureSelectorPreviewWeChatStyleActivity.initWidgets():void");
    }

    @Override // com.zyql.ai.selector.PicturePreviewActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.picture_right) {
            if (this.selectData.size() != 0) {
                this.mTvPictureOk.performClick();
                return;
            }
            this.btnCheck.performClick();
            if (this.selectData.size() != 0) {
                this.mTvPictureOk.performClick();
            }
        }
    }

    @Override // com.zyql.ai.selector.PicturePreviewActivity
    public void onPageSelectedChange(LocalMedia localMedia) {
        super.onPageSelectedChange(localMedia);
        goneParent();
        if (this.config.previewEggs) {
            return;
        }
        onChangeMediaStatus(localMedia);
    }

    @Override // com.zyql.ai.selector.PicturePreviewActivity
    public void onSelectNumChange(boolean z10) {
        goneParent();
        if (this.selectData.size() == 0) {
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle == null || TextUtils.isEmpty(pictureParameterStyle.pictureUnCompleteText)) {
                this.mTvPictureRight.setText(getString(R.string.picture_send));
            } else {
                this.mTvPictureRight.setText(PictureSelectionConfig.style.pictureUnCompleteText);
            }
            this.mRvGallery.animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.mRvGallery.setVisibility(8);
            this.bottomLine.animate().alpha(0.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.bottomLine.setVisibility(8);
            return;
        }
        initCompleteText(this.selectData.size());
        if (this.mRvGallery.getVisibility() == 8) {
            this.mRvGallery.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.mRvGallery.setVisibility(0);
            this.bottomLine.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            this.bottomLine.setVisibility(0);
            this.mGalleryAdapter.setNewData(this.selectData);
        }
        PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
        if (pictureParameterStyle2 == null) {
            this.mTvPictureRight.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_white));
            this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
            return;
        }
        int i10 = pictureParameterStyle2.pictureCompleteTextColor;
        if (i10 != 0) {
            this.mTvPictureRight.setTextColor(i10);
        }
        int i11 = PictureSelectionConfig.style.pictureCompleteBackgroundStyle;
        if (i11 != 0) {
            this.mTvPictureRight.setBackgroundResource(i11);
        }
    }

    @Override // com.zyql.ai.selector.PicturePreviewActivity
    public void onSelectedChange(boolean z10, LocalMedia localMedia) {
        if (z10) {
            localMedia.setChecked(true);
            if (this.config.selectionMode == 1) {
                this.mGalleryAdapter.addSingleMediaToData(localMedia);
            }
        } else {
            localMedia.setChecked(false);
            this.mGalleryAdapter.removeMediaToData(localMedia);
            if (this.isBottomPreview) {
                int size = this.selectData.size();
                int i10 = this.position;
                if (size > i10) {
                    this.selectData.get(i10).setChecked(true);
                }
                if (this.mGalleryAdapter.isDataEmpty()) {
                    onActivityBackPressed();
                } else {
                    int currentItem = this.viewPager.getCurrentItem();
                    this.adapter.remove(currentItem);
                    this.adapter.removeCacheView(currentItem);
                    this.position = currentItem;
                    this.tvTitle.setText(getString(R.string.picture_preview_image_num, Integer.valueOf(currentItem + 1), Integer.valueOf(this.adapter.getSize())));
                    this.check.setSelected(true);
                    this.adapter.notifyDataSetChanged();
                }
            }
        }
        int itemCount = this.mGalleryAdapter.getItemCount();
        if (itemCount > 5) {
            this.mRvGallery.smoothScrollToPosition(itemCount - 1);
        }
    }

    @Override // com.zyql.ai.selector.PicturePreviewActivity
    public void onUpdateSelectedChange(LocalMedia localMedia) {
        onChangeMediaStatus(localMedia);
    }
}
