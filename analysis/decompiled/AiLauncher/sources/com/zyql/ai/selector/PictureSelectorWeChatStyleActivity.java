package com.zyql.ai.selector;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import com.zyql.ai.selector.tools.AttrsUtils;
import com.zyql.ai.selector.widget.FolderPopWindow;
import java.util.List;

/* loaded from: classes4.dex */
public class PictureSelectorWeChatStyleActivity extends PictureSelectorActivity {
    private RelativeLayout rlAlbum;

    private void goneParentView() {
        this.mTvPictureImgNum.setVisibility(8);
        this.mTvPictureOk.setVisibility(8);
    }

    @Override // com.zyql.ai.selector.PictureSelectorActivity
    public void changeImageNumber(List<LocalMedia> list) {
        int size = list.size();
        if (size == 0) {
            this.mTvPictureRight.setEnabled(false);
            this.mTvPictureRight.setSelected(false);
            this.mTvPicturePreview.setEnabled(false);
            this.mTvPicturePreview.setSelected(false);
            PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle != null) {
                int i10 = pictureSelectorUIStyle.picture_top_titleRightTextDefaultBackground;
                if (i10 != 0) {
                    this.mTvPictureRight.setBackgroundResource(i10);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                }
                int i11 = PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText;
                if (i11 != 0) {
                    this.mTvPictureRight.setText(getString(i11));
                } else {
                    this.mTvPictureRight.setText(getString(R.string.picture_send));
                }
                int i12 = PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText;
                if (i12 != 0) {
                    this.mTvPicturePreview.setText(getString(i12));
                    return;
                } else {
                    this.mTvPicturePreview.setText(getString(R.string.picture_preview));
                    return;
                }
            }
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle == null) {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                this.mTvPictureRight.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_53575e));
                this.mTvPicturePreview.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_9b));
                this.mTvPicturePreview.setText(getString(R.string.picture_preview));
                this.mTvPictureRight.setText(getString(R.string.picture_send));
                return;
            }
            int i13 = pictureParameterStyle.pictureUnCompleteBackgroundStyle;
            if (i13 != 0) {
                this.mTvPictureRight.setBackgroundResource(i13);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            }
            int i14 = PictureSelectionConfig.style.pictureUnCompleteTextColor;
            if (i14 != 0) {
                this.mTvPictureRight.setTextColor(i14);
            } else {
                this.mTvPictureRight.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_53575e));
            }
            int i15 = PictureSelectionConfig.style.pictureUnPreviewTextColor;
            if (i15 != 0) {
                this.mTvPicturePreview.setTextColor(i15);
            } else {
                this.mTvPicturePreview.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_9b));
            }
            if (TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureRight.setText(getString(R.string.picture_send));
            } else {
                this.mTvPictureRight.setText(PictureSelectionConfig.style.pictureUnCompleteText);
            }
            if (TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnPreviewText)) {
                this.mTvPicturePreview.setText(getString(R.string.picture_preview));
                return;
            } else {
                this.mTvPicturePreview.setText(PictureSelectionConfig.style.pictureUnPreviewText);
                return;
            }
        }
        this.mTvPictureRight.setEnabled(true);
        this.mTvPictureRight.setSelected(true);
        this.mTvPicturePreview.setEnabled(true);
        this.mTvPicturePreview.setSelected(true);
        initCompleteText(list);
        PictureSelectorUIStyle pictureSelectorUIStyle2 = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle2 != null) {
            int i16 = pictureSelectorUIStyle2.picture_top_titleRightTextNormalBackground;
            if (i16 != 0) {
                this.mTvPictureRight.setBackgroundResource(i16);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
            }
            int[] iArr = PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor;
            if (iArr.length > 0) {
                ColorStateList colorStateList = AttrsUtils.getColorStateList(iArr);
                if (colorStateList != null) {
                    this.mTvPicturePreview.setTextColor(colorStateList);
                }
            } else {
                this.mTvPicturePreview.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_white));
            }
            PictureSelectorUIStyle pictureSelectorUIStyle3 = PictureSelectionConfig.uiStyle;
            int i17 = pictureSelectorUIStyle3.picture_bottom_previewNormalText;
            if (i17 == 0) {
                this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, Integer.valueOf(size)));
                return;
            } else if (pictureSelectorUIStyle3.isCompleteReplaceNum) {
                this.mTvPicturePreview.setText(String.format(getString(i17), Integer.valueOf(size)));
                return;
            } else {
                this.mTvPicturePreview.setText(i17);
                return;
            }
        }
        PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
        if (pictureParameterStyle2 == null) {
            this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
            TextView textView = this.mTvPictureRight;
            Context context = getContext();
            int i18 = R.color.picture_color_white;
            textView.setTextColor(androidx.core.content.a.c(context, i18));
            this.mTvPicturePreview.setTextColor(androidx.core.content.a.c(getContext(), i18));
            this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, Integer.valueOf(size)));
            return;
        }
        int i19 = pictureParameterStyle2.pictureCompleteBackgroundStyle;
        if (i19 != 0) {
            this.mTvPictureRight.setBackgroundResource(i19);
        } else {
            this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
        }
        int i20 = PictureSelectionConfig.style.pictureCompleteTextColor;
        if (i20 != 0) {
            this.mTvPictureRight.setTextColor(i20);
        } else {
            this.mTvPictureRight.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_white));
        }
        int i21 = PictureSelectionConfig.style.picturePreviewTextColor;
        if (i21 != 0) {
            this.mTvPicturePreview.setTextColor(i21);
        } else {
            this.mTvPicturePreview.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_white));
        }
        if (TextUtils.isEmpty(PictureSelectionConfig.style.picturePreviewText)) {
            this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, Integer.valueOf(size)));
        } else {
            this.mTvPicturePreview.setText(PictureSelectionConfig.style.picturePreviewText);
        }
    }

    @Override // com.zyql.ai.selector.PictureSelectorActivity, com.zyql.ai.selector.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_wechat_style_selector;
    }

    @Override // com.zyql.ai.selector.PictureBaseActivity
    public void initCompleteText(List<LocalMedia> list) {
        int i10;
        int size = list.size();
        PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
        boolean z10 = pictureParameterStyle != null;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isWithVideoImage) {
            if (pictureSelectionConfig.selectionMode != 1) {
                if (z10 && pictureParameterStyle.isCompleteReplaceNum && !TextUtils.isEmpty(pictureParameterStyle.pictureCompleteText)) {
                    this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(size), Integer.valueOf(this.config.maxSelectNum)));
                    return;
                } else {
                    this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) ? getString(R.string.picture_send_num, Integer.valueOf(size), Integer.valueOf(this.config.maxSelectNum)) : PictureSelectionConfig.style.pictureUnCompleteText);
                    return;
                }
            }
            if (size <= 0) {
                this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(pictureParameterStyle.pictureUnCompleteText)) ? getString(R.string.picture_send) : PictureSelectionConfig.style.pictureUnCompleteText);
                return;
            } else if (z10 && pictureParameterStyle.isCompleteReplaceNum && !TextUtils.isEmpty(pictureParameterStyle.pictureCompleteText)) {
                this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(size), 1));
                return;
            } else {
                this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) ? getString(R.string.picture_send) : PictureSelectionConfig.style.pictureCompleteText);
                return;
            }
        }
        if (!PictureMimeType.isHasVideo(list.get(0).getMimeType()) || (i10 = this.config.maxVideoSelectNum) <= 0) {
            i10 = this.config.maxSelectNum;
        }
        if (this.config.selectionMode == 1) {
            if (z10) {
                PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
                if (pictureParameterStyle2.isCompleteReplaceNum && !TextUtils.isEmpty(pictureParameterStyle2.pictureCompleteText)) {
                    this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(size), 1));
                    return;
                }
            }
            this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) ? getString(R.string.picture_send) : PictureSelectionConfig.style.pictureCompleteText);
            return;
        }
        if (z10) {
            PictureParameterStyle pictureParameterStyle3 = PictureSelectionConfig.style;
            if (pictureParameterStyle3.isCompleteReplaceNum && !TextUtils.isEmpty(pictureParameterStyle3.pictureCompleteText)) {
                this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, Integer.valueOf(size), Integer.valueOf(i10)));
                return;
            }
        }
        this.mTvPictureRight.setText((!z10 || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) ? getString(R.string.picture_send_num, Integer.valueOf(size), Integer.valueOf(i10)) : PictureSelectionConfig.style.pictureUnCompleteText);
    }

    @Override // com.zyql.ai.selector.PictureSelectorActivity, com.zyql.ai.selector.PictureBaseActivity
    public void initPictureSelectorStyle() throws Resources.NotFoundException {
        PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle != null) {
            int i10 = pictureSelectorUIStyle.picture_top_titleRightTextDefaultBackground;
            if (i10 != 0) {
                this.mTvPictureRight.setBackgroundResource(i10);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            }
            int i11 = PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor;
            if (i11 != 0) {
                this.mBottomLayout.setBackgroundColor(i11);
            } else {
                this.mBottomLayout.setBackgroundColor(androidx.core.content.a.c(getContext(), R.color.picture_color_grey));
            }
            int[] iArr = PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor;
            if (iArr.length > 0) {
                ColorStateList colorStateList = AttrsUtils.getColorStateList(iArr);
                if (colorStateList != null) {
                    this.mTvPictureRight.setTextColor(colorStateList);
                }
            } else {
                this.mTvPictureRight.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_53575e));
            }
            int i12 = PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize;
            if (i12 != 0) {
                this.mTvPictureRight.setTextSize(i12);
            }
            if (this.config.isOriginalControl) {
                int i13 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle;
                if (i13 != 0) {
                    this.mCbOriginal.setButtonDrawable(i13);
                }
                int i14 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor;
                if (i14 != 0) {
                    this.mCbOriginal.setTextColor(i14);
                }
                int i15 = PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize;
                if (i15 != 0) {
                    this.mCbOriginal.setTextSize(i15);
                }
            }
            int i16 = PictureSelectionConfig.uiStyle.picture_container_backgroundColor;
            if (i16 != 0) {
                this.container.setBackgroundColor(i16);
            }
            int i17 = PictureSelectionConfig.uiStyle.picture_top_titleAlbumBackground;
            if (i17 != 0) {
                this.rlAlbum.setBackgroundResource(i17);
            } else {
                this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
            }
            int i18 = PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText;
            if (i18 != 0) {
                this.mTvPictureRight.setText(getString(i18));
            }
        } else {
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle != null) {
                int i19 = pictureParameterStyle.pictureUnCompleteBackgroundStyle;
                if (i19 != 0) {
                    this.mTvPictureRight.setBackgroundResource(i19);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                }
                int i20 = PictureSelectionConfig.style.pictureBottomBgColor;
                if (i20 != 0) {
                    this.mBottomLayout.setBackgroundColor(i20);
                } else {
                    this.mBottomLayout.setBackgroundColor(androidx.core.content.a.c(getContext(), R.color.picture_color_grey));
                }
                PictureParameterStyle pictureParameterStyle2 = PictureSelectionConfig.style;
                int i21 = pictureParameterStyle2.pictureUnCompleteTextColor;
                if (i21 != 0) {
                    this.mTvPictureRight.setTextColor(i21);
                } else {
                    int i22 = pictureParameterStyle2.pictureCancelTextColor;
                    if (i22 != 0) {
                        this.mTvPictureRight.setTextColor(i22);
                    } else {
                        this.mTvPictureRight.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_53575e));
                    }
                }
                int i23 = PictureSelectionConfig.style.pictureRightTextSize;
                if (i23 != 0) {
                    this.mTvPictureRight.setTextSize(i23);
                }
                if (PictureSelectionConfig.style.pictureOriginalFontColor == 0) {
                    this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_white));
                }
                if (this.config.isOriginalControl && PictureSelectionConfig.style.pictureOriginalControlStyle == 0) {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_wechat_checkbox));
                }
                int i24 = PictureSelectionConfig.style.pictureContainerBackgroundColor;
                if (i24 != 0) {
                    this.container.setBackgroundColor(i24);
                }
                int i25 = PictureSelectionConfig.style.pictureWeChatTitleBackgroundStyle;
                if (i25 != 0) {
                    this.rlAlbum.setBackgroundResource(i25);
                } else {
                    this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                    this.mTvPictureRight.setText(PictureSelectionConfig.style.pictureUnCompleteText);
                }
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
                this.mTvPictureRight.setTextColor(androidx.core.content.a.c(getContext(), R.color.picture_color_53575e));
                int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_bottom_bg);
                RelativeLayout relativeLayout = this.mBottomLayout;
                if (typeValueColor == 0) {
                    typeValueColor = androidx.core.content.a.c(getContext(), R.color.picture_color_grey);
                }
                relativeLayout.setBackgroundColor(typeValueColor);
                this.mCbOriginal.setTextColor(androidx.core.content.a.c(this, R.color.picture_color_white));
                this.mIvArrow.setImageDrawable(androidx.core.content.a.e(this, R.drawable.picture_icon_wechat_down));
                if (this.config.isOriginalControl) {
                    this.mCbOriginal.setButtonDrawable(androidx.core.content.a.e(this, R.drawable.picture_original_wechat_checkbox));
                }
            }
        }
        super.initPictureSelectorStyle();
        goneParentView();
    }

    @Override // com.zyql.ai.selector.PictureSelectorActivity, com.zyql.ai.selector.PictureBaseActivity
    public void initWidgets() {
        super.initWidgets();
        this.rlAlbum = (RelativeLayout) findViewById(R.id.rlAlbum);
        this.mTvPictureRight.setOnClickListener(this);
        this.mTvPictureRight.setText(getString(R.string.picture_send));
        this.mTvPicturePreview.setTextSize(16.0f);
        this.mCbOriginal.setTextSize(16.0f);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        boolean z10 = pictureSelectionConfig.selectionMode == 1 && pictureSelectionConfig.isSingleDirectReturn;
        this.mTvPictureRight.setVisibility(z10 ? 8 : 0);
        this.mTvPictureRight.setOnClickListener(this);
        if (this.rlAlbum.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rlAlbum.getLayoutParams();
            if (z10) {
                layoutParams.addRule(14);
            } else {
                layoutParams.addRule(1, R.id.pictureLeftBack);
            }
        }
    }

    @Override // com.zyql.ai.selector.PictureSelectorActivity
    public void onChangeData(List<LocalMedia> list) {
        super.onChangeData(list);
        initCompleteText(list);
    }

    @Override // com.zyql.ai.selector.PictureSelectorActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.picture_right) {
            super.onClick(view);
            return;
        }
        FolderPopWindow folderPopWindow = this.folderWindow;
        if (folderPopWindow == null || !folderPopWindow.isShowing()) {
            this.mTvPictureOk.performClick();
        } else {
            this.folderWindow.dismiss();
        }
    }
}
