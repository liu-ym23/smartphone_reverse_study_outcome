package com.zyql.ai.selector.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.engine.ImageEngine;
import com.zyql.ai.selector.entity.LocalMediaFolder;
import com.zyql.ai.selector.listener.OnAlbumItemClickListener;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import com.zyql.ai.selector.tools.AttrsUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PictureAlbumDirectoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private int chooseMode;
    private List<LocalMediaFolder> folders = new ArrayList();
    private OnAlbumItemClickListener onAlbumItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFirstImage;
        TextView tvFolderName;
        TextView tvSign;

        public ViewHolder(View view) throws Resources.NotFoundException {
            super(view);
            this.ivFirstImage = (ImageView) view.findViewById(R.id.first_image);
            this.tvFolderName = (TextView) view.findViewById(R.id.tv_folder_name);
            TextView textView = (TextView) view.findViewById(R.id.tv_sign);
            this.tvSign = textView;
            PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle != null) {
                int i10 = pictureSelectorUIStyle.picture_album_checkDotStyle;
                if (i10 != 0) {
                    textView.setBackgroundResource(i10);
                }
                int i11 = PictureSelectionConfig.uiStyle.picture_album_textColor;
                if (i11 != 0) {
                    this.tvFolderName.setTextColor(i11);
                }
                int i12 = PictureSelectionConfig.uiStyle.picture_album_textSize;
                if (i12 > 0) {
                    this.tvFolderName.setTextSize(i12);
                    return;
                }
                return;
            }
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle == null) {
                this.tvSign.setBackground(AttrsUtils.getTypeValueDrawable(view.getContext(), R.attr.picture_folder_checked_dot, R.drawable.picture_orange_oval));
                int typeValueColor = AttrsUtils.getTypeValueColor(view.getContext(), R.attr.picture_folder_textColor);
                if (typeValueColor != 0) {
                    this.tvFolderName.setTextColor(typeValueColor);
                }
                float typeValueSize = AttrsUtils.getTypeValueSize(view.getContext(), R.attr.picture_folder_textSize);
                if (typeValueSize > 0.0f) {
                    this.tvFolderName.setTextSize(0, typeValueSize);
                    return;
                }
                return;
            }
            int i13 = pictureParameterStyle.pictureFolderCheckedDotStyle;
            if (i13 != 0) {
                textView.setBackgroundResource(i13);
            }
            int i14 = PictureSelectionConfig.style.folderTextColor;
            if (i14 != 0) {
                this.tvFolderName.setTextColor(i14);
            }
            int i15 = PictureSelectionConfig.style.folderTextSize;
            if (i15 > 0) {
                this.tvFolderName.setTextSize(i15);
            }
        }
    }

    public PictureAlbumDirectoryAdapter(PictureSelectionConfig pictureSelectionConfig) {
        this.chooseMode = pictureSelectionConfig.chooseMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(LocalMediaFolder localMediaFolder, int i10, View view) {
        if (this.onAlbumItemClickListener != null) {
            int size = this.folders.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.folders.get(i11).setChecked(false);
            }
            localMediaFolder.setChecked(true);
            notifyDataSetChanged();
            this.onAlbumItemClickListener.onItemClick(i10, localMediaFolder.isCameraFolder(), localMediaFolder.getBucketId(), localMediaFolder.getName(), localMediaFolder.getData());
        }
    }

    public void bindFolderData(List<LocalMediaFolder> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.folders = list;
        notifyDataSetChanged();
    }

    public List<LocalMediaFolder> getFolderData() {
        List<LocalMediaFolder> list = this.folders;
        return list == null ? new ArrayList() : list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.folders.size();
    }

    public void setChooseMode(int i10) {
        this.chooseMode = i10;
    }

    public void setOnAlbumItemClickListener(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.onAlbumItemClickListener = onAlbumItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i10) {
        int i11;
        final LocalMediaFolder localMediaFolder = this.folders.get(i10);
        String name = localMediaFolder.getName();
        int imageNum = localMediaFolder.getImageNum();
        String firstImagePath = localMediaFolder.getFirstImagePath();
        boolean zIsChecked = localMediaFolder.isChecked();
        viewHolder.tvSign.setVisibility(localMediaFolder.getCheckedNum() > 0 ? 0 : 4);
        viewHolder.itemView.setSelected(zIsChecked);
        PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle != null) {
            int i12 = pictureSelectorUIStyle.picture_album_backgroundStyle;
            if (i12 != 0) {
                viewHolder.itemView.setBackgroundResource(i12);
            }
        } else {
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle != null && (i11 = pictureParameterStyle.pictureAlbumStyle) != 0) {
                viewHolder.itemView.setBackgroundResource(i11);
            }
        }
        if (this.chooseMode == PictureMimeType.ofAudio()) {
            viewHolder.ivFirstImage.setImageResource(R.drawable.picture_audio_placeholder);
        } else {
            ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
            if (imageEngine != null) {
                imageEngine.loadFolderImage(viewHolder.itemView.getContext(), firstImagePath, viewHolder.ivFirstImage);
            }
        }
        Context context = viewHolder.itemView.getContext();
        if (localMediaFolder.getOfAllType() != -1) {
            name = localMediaFolder.getOfAllType() == PictureMimeType.ofAudio() ? context.getString(R.string.picture_all_audio) : context.getString(R.string.picture_camera_roll);
        }
        viewHolder.tvFolderName.setText(context.getString(R.string.picture_camera_roll_num, name, Integer.valueOf(imageNum)));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f31948a.lambda$onBindViewHolder$0(localMediaFolder, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_album_folder_item, viewGroup, false));
    }
}
