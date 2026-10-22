package com.zyql.ai.selector.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.dialog.PictureCustomDialog;
import com.zyql.ai.selector.engine.ImageEngine;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.listener.OnChooseLimitCallback;
import com.zyql.ai.selector.listener.OnPhotoSelectChangedListener;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import com.zyql.ai.selector.tools.AttrsUtils;
import com.zyql.ai.selector.tools.DateUtils;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.tools.StringUtils;
import com.zyql.ai.selector.tools.ToastUtils;
import com.zyql.ai.selector.tools.ValueOf;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import t0.C5499a;

/* loaded from: classes4.dex */
public class PictureImageGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final PictureSelectionConfig config;
    private final Context context;
    private OnPhotoSelectChangedListener<LocalMedia> imageSelectChangedListener;
    private boolean showCamera;
    private List<LocalMedia> data = new ArrayList();
    private List<LocalMedia> selectData = new ArrayList();

    public class CameraViewHolder extends RecyclerView.ViewHolder {
        TextView tvCamera;

        public CameraViewHolder(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.tvCamera);
            this.tvCamera = textView;
            PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle == null) {
                textView.setText(PictureImageGridAdapter.this.config.chooseMode == PictureMimeType.ofAudio() ? PictureImageGridAdapter.this.context.getString(R.string.picture_tape) : PictureImageGridAdapter.this.context.getString(R.string.picture_take_picture));
                return;
            }
            int i10 = pictureSelectorUIStyle.picture_adapter_item_camera_backgroundColor;
            if (i10 != 0) {
                view.setBackgroundColor(i10);
            }
            int i11 = PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textSize;
            if (i11 != 0) {
                this.tvCamera.setTextSize(i11);
            }
            int i12 = PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textColor;
            if (i12 != 0) {
                this.tvCamera.setTextColor(i12);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_text != 0) {
                this.tvCamera.setText(view.getContext().getString(PictureSelectionConfig.uiStyle.picture_adapter_item_camera_text));
            } else {
                this.tvCamera.setText(PictureImageGridAdapter.this.config.chooseMode == PictureMimeType.ofAudio() ? PictureImageGridAdapter.this.context.getString(R.string.picture_tape) : PictureImageGridAdapter.this.context.getString(R.string.picture_take_picture));
            }
            int i13 = PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textTopDrawable;
            if (i13 != 0) {
                this.tvCamera.setCompoundDrawablesWithIntrinsicBounds(0, i13, 0, 0);
            }
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View btnCheck;
        View contentView;
        ImageView ivPicture;
        TextView tvCheck;
        TextView tvDuration;
        TextView tvIsGif;
        TextView tvLongChart;

        public ViewHolder(View view) throws Resources.NotFoundException {
            super(view);
            this.contentView = view;
            this.ivPicture = (ImageView) view.findViewById(R.id.ivPicture);
            this.tvCheck = (TextView) view.findViewById(R.id.tvCheck);
            this.btnCheck = view.findViewById(R.id.btnCheck);
            this.tvDuration = (TextView) view.findViewById(R.id.tv_duration);
            this.tvIsGif = (TextView) view.findViewById(R.id.tv_isGif);
            this.tvLongChart = (TextView) view.findViewById(R.id.tv_long_chart);
            PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle == null) {
                PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
                if (pictureParameterStyle == null) {
                    this.tvCheck.setBackground(AttrsUtils.getTypeValueDrawable(view.getContext(), R.attr.picture_checked_style, R.drawable.picture_checkbox_selector));
                    return;
                } else {
                    int i10 = pictureParameterStyle.pictureCheckedStyle;
                    if (i10 != 0) {
                        this.tvCheck.setBackgroundResource(i10);
                        return;
                    }
                    return;
                }
            }
            int i11 = pictureSelectorUIStyle.picture_check_style;
            if (i11 != 0) {
                this.tvCheck.setBackgroundResource(i11);
            }
            int i12 = PictureSelectionConfig.uiStyle.picture_check_textSize;
            if (i12 != 0) {
                this.tvCheck.setTextSize(i12);
            }
            int i13 = PictureSelectionConfig.uiStyle.picture_check_textColor;
            if (i13 != 0) {
                this.tvCheck.setTextColor(i13);
            }
            int i14 = PictureSelectionConfig.uiStyle.picture_adapter_item_textSize;
            if (i14 > 0) {
                this.tvDuration.setTextSize(i14);
            }
            int i15 = PictureSelectionConfig.uiStyle.picture_adapter_item_textColor;
            if (i15 != 0) {
                this.tvDuration.setTextColor(i15);
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_tag_text != 0) {
                this.tvIsGif.setText(view.getContext().getString(PictureSelectionConfig.uiStyle.picture_adapter_item_tag_text));
            }
            if (PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_show) {
                this.tvIsGif.setVisibility(0);
            } else {
                this.tvIsGif.setVisibility(8);
            }
            int i16 = PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_background;
            if (i16 != 0) {
                this.tvIsGif.setBackgroundResource(i16);
            }
            int i17 = PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textColor;
            if (i17 != 0) {
                this.tvIsGif.setTextColor(i17);
            }
            int i18 = PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textSize;
            if (i18 != 0) {
                this.tvIsGif.setTextSize(i18);
            }
        }
    }

    public PictureImageGridAdapter(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.context = context;
        this.config = pictureSelectionConfig;
        this.showCamera = pictureSelectionConfig.isCamera;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x02a5  */
    @android.annotation.SuppressLint({"StringFormatMatches"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void changeCheckboxState(com.zyql.ai.selector.adapter.PictureImageGridAdapter.ViewHolder r11, com.zyql.ai.selector.entity.LocalMedia r12) {
        /*
            Method dump skipped, instructions count: 795
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.adapter.PictureImageGridAdapter.changeCheckboxState(com.zyql.ai.selector.adapter.PictureImageGridAdapter$ViewHolder, com.zyql.ai.selector.entity.LocalMedia):void");
    }

    private void dispatchHandleMask(ViewHolder viewHolder, LocalMedia localMedia) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isWithVideoImage && pictureSelectionConfig.maxVideoSelectNum > 0) {
            if (getSelectedSize() < this.config.maxSelectNum) {
                localMedia.setMaxSelectEnabledMask(false);
                return;
            }
            boolean zIsSelected = viewHolder.tvCheck.isSelected();
            viewHolder.ivPicture.setColorFilter(C5499a.a(zIsSelected ? androidx.core.content.a.c(this.context, R.color.picture_color_80) : androidx.core.content.a.c(this.context, R.color.picture_color_half_white), BlendModeCompat.SRC_ATOP));
            localMedia.setMaxSelectEnabledMask(!zIsSelected);
            return;
        }
        LocalMedia localMedia2 = this.selectData.size() > 0 ? this.selectData.get(0) : null;
        if (localMedia2 != null) {
            boolean zIsSelected2 = viewHolder.tvCheck.isSelected();
            if (this.config.chooseMode != PictureMimeType.ofAll()) {
                if (this.config.chooseMode != PictureMimeType.ofVideo() || this.config.maxVideoSelectNum <= 0) {
                    if (!zIsSelected2 && getSelectedSize() == this.config.maxSelectNum) {
                        viewHolder.ivPicture.setColorFilter(C5499a.a(androidx.core.content.a.c(this.context, R.color.picture_color_half_white), BlendModeCompat.SRC_ATOP));
                    }
                    localMedia.setMaxSelectEnabledMask(!zIsSelected2 && getSelectedSize() == this.config.maxSelectNum);
                    return;
                }
                if (!zIsSelected2 && getSelectedSize() == this.config.maxVideoSelectNum) {
                    viewHolder.ivPicture.setColorFilter(C5499a.a(androidx.core.content.a.c(this.context, R.color.picture_color_half_white), BlendModeCompat.SRC_ATOP));
                }
                localMedia.setMaxSelectEnabledMask(!zIsSelected2 && getSelectedSize() == this.config.maxVideoSelectNum);
                return;
            }
            if (PictureMimeType.isHasImage(localMedia2.getMimeType())) {
                if (!zIsSelected2 && !PictureMimeType.isHasImage(localMedia.getMimeType())) {
                    viewHolder.ivPicture.setColorFilter(C5499a.a(androidx.core.content.a.c(this.context, PictureMimeType.isHasVideo(localMedia.getMimeType()) ? R.color.picture_color_half_white : R.color.picture_color_20), BlendModeCompat.SRC_ATOP));
                }
                localMedia.setMaxSelectEnabledMask(PictureMimeType.isHasVideo(localMedia.getMimeType()));
                return;
            }
            if (PictureMimeType.isHasVideo(localMedia2.getMimeType())) {
                if (!zIsSelected2 && !PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                    viewHolder.ivPicture.setColorFilter(C5499a.a(androidx.core.content.a.c(this.context, PictureMimeType.isHasImage(localMedia.getMimeType()) ? R.color.picture_color_half_white : R.color.picture_color_20), BlendModeCompat.SRC_ATOP));
                }
                localMedia.setMaxSelectEnabledMask(PictureMimeType.isHasImage(localMedia.getMimeType()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(View view) {
        OnPhotoSelectChangedListener<LocalMedia> onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onTakePhoto();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(LocalMedia localMedia, ViewHolder viewHolder, String str, View view) {
        String msg;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isMaxSelectEnabledMask) {
            if (pictureSelectionConfig.isWithVideoImage) {
                int selectedSize = getSelectedSize();
                boolean z10 = false;
                int i10 = 0;
                for (int i11 = 0; i11 < selectedSize; i11++) {
                    if (PictureMimeType.isHasVideo(this.selectData.get(i11).getMimeType())) {
                        i10++;
                    }
                }
                if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                    if (!viewHolder.tvCheck.isSelected() && i10 >= this.config.maxVideoSelectNum) {
                        z10 = true;
                    }
                    msg = StringUtils.getMsg(this.context, localMedia.getMimeType(), this.config.maxVideoSelectNum);
                } else {
                    if (!viewHolder.tvCheck.isSelected() && selectedSize >= this.config.maxSelectNum) {
                        z10 = true;
                    }
                    msg = StringUtils.getMsg(this.context, localMedia.getMimeType(), this.config.maxSelectNum);
                }
                if (z10) {
                    showPromptDialog(msg);
                    return;
                }
            } else if (!viewHolder.tvCheck.isSelected() && getSelectedSize() >= this.config.maxSelectNum) {
                showPromptDialog(StringUtils.getMsg(this.context, localMedia.getMimeType(), this.config.maxSelectNum));
                return;
            }
        }
        String realPath = localMedia.getRealPath();
        if (TextUtils.isEmpty(realPath) || new File(realPath).exists()) {
            changeCheckboxState(viewHolder, localMedia);
        } else {
            Context context = this.context;
            ToastUtils.s(context, PictureMimeType.s(context, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        if (r4.selectionMode != 1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$onBindViewHolder$2(com.zyql.ai.selector.entity.LocalMedia r3, java.lang.String r4, int r5, com.zyql.ai.selector.adapter.PictureImageGridAdapter.ViewHolder r6, android.view.View r7) {
        /*
            r2 = this;
            com.zyql.ai.selector.config.PictureSelectionConfig r7 = r2.config
            boolean r7 = r7.isMaxSelectEnabledMask
            if (r7 == 0) goto Ld
            boolean r7 = r3.isMaxSelectEnabledMask()
            if (r7 == 0) goto Ld
            goto L35
        Ld:
            java.lang.String r7 = r3.getRealPath()
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L2c
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r7 = r0.exists()
            if (r7 != 0) goto L2c
            android.content.Context r2 = r2.context
            java.lang.String r3 = com.zyql.ai.selector.config.PictureMimeType.s(r2, r4)
            com.zyql.ai.selector.tools.ToastUtils.s(r2, r3)
            return
        L2c:
            boolean r7 = r2.showCamera
            if (r7 == 0) goto L32
            int r5 = r5 + (-1)
        L32:
            r7 = -1
            if (r5 != r7) goto L36
        L35:
            return
        L36:
            boolean r7 = com.zyql.ai.selector.config.PictureMimeType.isHasImage(r4)
            if (r7 == 0) goto L42
            com.zyql.ai.selector.config.PictureSelectionConfig r7 = r2.config
            boolean r7 = r7.enablePreview
            if (r7 != 0) goto L6e
        L42:
            com.zyql.ai.selector.config.PictureSelectionConfig r7 = r2.config
            boolean r7 = r7.isSingleDirectReturn
            if (r7 != 0) goto L6e
            boolean r7 = com.zyql.ai.selector.config.PictureMimeType.isHasVideo(r4)
            r0 = 1
            if (r7 == 0) goto L59
            com.zyql.ai.selector.config.PictureSelectionConfig r7 = r2.config
            boolean r1 = r7.enPreviewVideo
            if (r1 != 0) goto L6e
            int r7 = r7.selectionMode
            if (r7 == r0) goto L6e
        L59:
            boolean r4 = com.zyql.ai.selector.config.PictureMimeType.isHasAudio(r4)
            if (r4 == 0) goto L6a
            com.zyql.ai.selector.config.PictureSelectionConfig r4 = r2.config
            boolean r7 = r4.enablePreviewAudio
            if (r7 != 0) goto L6e
            int r4 = r4.selectionMode
            if (r4 != r0) goto L6a
            goto L6e
        L6a:
            r2.changeCheckboxState(r6, r3)
            return
        L6e:
            java.lang.String r4 = r3.getMimeType()
            boolean r4 = com.zyql.ai.selector.config.PictureMimeType.isHasVideo(r4)
            if (r4 == 0) goto Lca
            com.zyql.ai.selector.config.PictureSelectionConfig r4 = r2.config
            int r4 = r4.videoMinSecond
            if (r4 <= 0) goto La1
            long r6 = r3.getDuration()
            com.zyql.ai.selector.config.PictureSelectionConfig r4 = r2.config
            int r4 = r4.videoMinSecond
            long r0 = (long) r4
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 >= 0) goto La1
            android.content.Context r3 = r2.context
            int r5 = com.zyql.ai.selector.R.string.picture_choose_min_seconds
            int r4 = r4 / 1000
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r3 = r3.getString(r5, r4)
            r2.showPromptDialog(r3)
            return
        La1:
            com.zyql.ai.selector.config.PictureSelectionConfig r4 = r2.config
            int r4 = r4.videoMaxSecond
            if (r4 <= 0) goto Lca
            long r6 = r3.getDuration()
            com.zyql.ai.selector.config.PictureSelectionConfig r4 = r2.config
            int r4 = r4.videoMaxSecond
            long r0 = (long) r4
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 <= 0) goto Lca
            android.content.Context r3 = r2.context
            int r5 = com.zyql.ai.selector.R.string.picture_choose_max_seconds
            int r4 = r4 / 1000
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r3 = r3.getString(r5, r4)
            r2.showPromptDialog(r3)
            return
        Lca:
            com.zyql.ai.selector.listener.OnPhotoSelectChangedListener<com.zyql.ai.selector.entity.LocalMedia> r2 = r2.imageSelectChangedListener
            r2.onPictureClick(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.adapter.PictureImageGridAdapter.lambda$onBindViewHolder$2(com.zyql.ai.selector.entity.LocalMedia, java.lang.String, int, com.zyql.ai.selector.adapter.PictureImageGridAdapter$ViewHolder, android.view.View):void");
    }

    private void notifyCheckChanged(ViewHolder viewHolder, LocalMedia localMedia) {
        viewHolder.tvCheck.setText("");
        int size = this.selectData.size();
        for (int i10 = 0; i10 < size; i10++) {
            LocalMedia localMedia2 = this.selectData.get(i10);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                viewHolder.tvCheck.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
            }
        }
    }

    private void showPromptDialog(String str) {
        OnChooseLimitCallback onChooseLimitCallback = PictureSelectionConfig.onChooseLimitCallback;
        if (onChooseLimitCallback != null) {
            onChooseLimitCallback.onChooseLimit(this.context, str);
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(this.context, R.layout.picture_prompt_dialog);
        TextView textView = (TextView) pictureCustomDialog.findViewById(R.id.btnOk);
        ((TextView) pictureCustomDialog.findViewById(R.id.tv_content)).setText(str);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.adapter.PictureImageGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pictureCustomDialog.dismiss();
            }
        });
        pictureCustomDialog.show();
    }

    private void singleRadioMediaImage() {
        List<LocalMedia> list = this.selectData;
        if (list == null || list.size() <= 0) {
            return;
        }
        notifyItemChanged(this.selectData.get(0).position);
        this.selectData.clear();
    }

    private void subSelectPosition() {
        if (this.config.checkNumMode) {
            int size = this.selectData.size();
            int i10 = 0;
            while (i10 < size) {
                LocalMedia localMedia = this.selectData.get(i10);
                i10++;
                localMedia.setNum(i10);
                notifyItemChanged(localMedia.position);
            }
        }
    }

    public void bindData(List<LocalMedia> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.data = list;
        notifyDataSetChanged();
    }

    public void bindSelectData(List<LocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(list.get(i10));
        }
        this.selectData = arrayList;
        if (this.config.isSingleDirectReturn) {
            return;
        }
        subSelectPosition();
        OnPhotoSelectChangedListener<LocalMedia> onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onChange(this.selectData);
        }
    }

    public void clear() {
        if (getSize() > 0) {
            this.data.clear();
        }
    }

    public List<LocalMedia> getData() {
        List<LocalMedia> list = this.data;
        return list == null ? new ArrayList() : list;
    }

    public LocalMedia getItem(int i10) {
        if (getSize() > 0) {
            return this.data.get(i10);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        boolean z10 = this.showCamera;
        int size = this.data.size();
        return z10 ? size + 1 : size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return (this.showCamera && i10 == 0) ? 1 : 2;
    }

    public List<LocalMedia> getSelectedData() {
        List<LocalMedia> list = this.selectData;
        return list == null ? new ArrayList() : list;
    }

    public int getSelectedSize() {
        List<LocalMedia> list = this.selectData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getSize() {
        List<LocalMedia> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean isDataEmpty() {
        List<LocalMedia> list = this.data;
        return list == null || list.size() == 0;
    }

    public boolean isSelected(LocalMedia localMedia) {
        int size = this.selectData.size();
        for (int i10 = 0; i10 < size; i10++) {
            LocalMedia localMedia2 = this.selectData.get(i10);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isShowCamera() {
        return this.showCamera;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i10) {
        if (getItemViewType(i10) == 1) {
            ((CameraViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f31951a.lambda$onBindViewHolder$0(view);
                }
            });
            return;
        }
        final ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        final LocalMedia localMedia = this.data.get(this.showCamera ? i10 - 1 : i10);
        localMedia.position = viewHolder2.getAbsoluteAdapterPosition();
        String path = localMedia.getPath();
        final String mimeType = localMedia.getMimeType();
        if (this.config.checkNumMode) {
            notifyCheckChanged(viewHolder2, localMedia);
        }
        if (this.config.isSingleDirectReturn) {
            viewHolder2.tvCheck.setVisibility(8);
            viewHolder2.btnCheck.setVisibility(8);
        } else {
            selectImage(viewHolder2, isSelected(localMedia));
            viewHolder2.tvCheck.setVisibility(0);
            viewHolder2.btnCheck.setVisibility(0);
            if (this.config.isMaxSelectEnabledMask) {
                dispatchHandleMask(viewHolder2, localMedia);
            }
        }
        viewHolder2.tvIsGif.setVisibility(PictureMimeType.isGif(mimeType) ? 0 : 8);
        if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
            if (localMedia.loadLongImageStatus == -1) {
                localMedia.isLongImage = MediaUtils.isLongImg(localMedia);
                localMedia.loadLongImageStatus = 0;
            }
            viewHolder2.tvLongChart.setVisibility(localMedia.isLongImage ? 0 : 8);
        } else {
            localMedia.loadLongImageStatus = -1;
            viewHolder2.tvLongChart.setVisibility(8);
        }
        boolean zIsHasVideo = PictureMimeType.isHasVideo(mimeType);
        if (zIsHasVideo || PictureMimeType.isHasAudio(mimeType)) {
            viewHolder2.tvDuration.setVisibility(0);
            viewHolder2.tvDuration.setText(DateUtils.formatDurationTime(localMedia.getDuration()));
            PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle == null) {
                viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(zIsHasVideo ? R.drawable.picture_icon_video : R.drawable.picture_icon_audio, 0, 0, 0);
            } else if (zIsHasVideo) {
                int i11 = pictureSelectorUIStyle.picture_adapter_item_video_textLeftDrawable;
                if (i11 != 0) {
                    viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(i11, 0, 0, 0);
                } else {
                    viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.picture_icon_video, 0, 0, 0);
                }
            } else {
                int i12 = pictureSelectorUIStyle.picture_adapter_item_audio_textLeftDrawable;
                if (i12 != 0) {
                    viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(i12, 0, 0, 0);
                } else {
                    viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.picture_icon_audio, 0, 0, 0);
                }
            }
        } else {
            viewHolder2.tvDuration.setVisibility(8);
        }
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            viewHolder2.ivPicture.setImageResource(R.drawable.picture_audio_placeholder);
        } else {
            ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
            if (imageEngine != null) {
                imageEngine.loadGridImage(this.context, path, viewHolder2.ivPicture);
            }
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enablePreview || pictureSelectionConfig.enPreviewVideo || pictureSelectionConfig.enablePreviewAudio) {
            viewHolder2.btnCheck.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f31952a.lambda$onBindViewHolder$1(localMedia, viewHolder2, mimeType, view);
                }
            });
        }
        viewHolder2.contentView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31956a.lambda$onBindViewHolder$2(localMedia, mimeType, i10, viewHolder2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return i10 == 1 ? new CameraViewHolder(LayoutInflater.from(this.context).inflate(R.layout.picture_item_camera, viewGroup, false)) : new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.picture_image_grid_item, viewGroup, false));
    }

    public void selectImage(ViewHolder viewHolder, boolean z10) {
        viewHolder.tvCheck.setSelected(z10);
        viewHolder.ivPicture.setColorFilter(C5499a.a(z10 ? androidx.core.content.a.c(this.context, R.color.picture_color_80) : androidx.core.content.a.c(this.context, R.color.picture_color_20), BlendModeCompat.SRC_ATOP));
    }

    public void setOnPhotoSelectChangedListener(OnPhotoSelectChangedListener onPhotoSelectChangedListener) {
        this.imageSelectChangedListener = onPhotoSelectChangedListener;
    }

    public void setShowCamera(boolean z10) {
        this.showCamera = z10;
    }
}
