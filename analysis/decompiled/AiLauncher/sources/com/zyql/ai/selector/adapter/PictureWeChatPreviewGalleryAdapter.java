package com.zyql.ai.selector.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.engine.ImageEngine;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PictureWeChatPreviewGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final PictureSelectionConfig config;
    private List<LocalMedia> list;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i10, LocalMedia localMedia, View view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        ImageView ivPlay;
        View viewBorder;

        public ViewHolder(View view) {
            super(view);
            this.ivImage = (ImageView) view.findViewById(R.id.ivImage);
            this.ivPlay = (ImageView) view.findViewById(R.id.ivPlay);
            View viewFindViewById = view.findViewById(R.id.viewBorder);
            this.viewBorder = viewFindViewById;
            PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
            if (pictureSelectorUIStyle != null) {
                viewFindViewById.setBackgroundResource(pictureSelectorUIStyle.picture_bottom_gallery_frameBackground);
            }
        }
    }

    public PictureWeChatPreviewGalleryAdapter(PictureSelectionConfig pictureSelectionConfig) {
        this.config = pictureSelectionConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(ViewHolder viewHolder, int i10, View view) {
        if (this.listener == null || viewHolder.getAbsoluteAdapterPosition() < 0) {
            return;
        }
        this.listener.onItemClick(viewHolder.getAbsoluteAdapterPosition(), getItem(i10), view);
    }

    public void addSingleMediaToData(LocalMedia localMedia) {
        List<LocalMedia> list = this.list;
        if (list != null) {
            list.clear();
            this.list.add(localMedia);
            notifyDataSetChanged();
        }
    }

    public LocalMedia getItem(int i10) {
        List<LocalMedia> list = this.list;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.list.get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<LocalMedia> list = this.list;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public boolean isDataEmpty() {
        List<LocalMedia> list = this.list;
        return list == null || list.size() == 0;
    }

    public void removeMediaToData(LocalMedia localMedia) {
        List<LocalMedia> list = this.list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.list.remove(localMedia);
        notifyDataSetChanged();
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public void setNewData(List<LocalMedia> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.list = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i10) {
        ImageEngine imageEngine;
        LocalMedia item = getItem(i10);
        if (item != null) {
            viewHolder.viewBorder.setVisibility(item.isChecked() ? 0 : 8);
            if (this.config != null && (imageEngine = PictureSelectionConfig.imageEngine) != null) {
                imageEngine.loadImage(viewHolder.itemView.getContext(), item.getPath(), viewHolder.ivImage);
            }
            viewHolder.ivPlay.setVisibility(PictureMimeType.isHasVideo(item.getMimeType()) ? 0 : 8);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.adapter.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f31966a.lambda$onBindViewHolder$0(viewHolder, i10, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_wechat_preview_gallery, viewGroup, false));
    }
}
