package com.zyql.ai.crop;

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
import com.zyql.ai.selector.entity.LocalMedia;
import java.util.List;

/* loaded from: classes4.dex */
public class PicturePhotoGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<LocalMedia> list;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i10, View view);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_dot;
        ImageView mIvPhoto;
        ImageView mIvVideo;
        TextView tvGif;

        public ViewHolder(View view) {
            super(view);
            this.mIvPhoto = (ImageView) view.findViewById(R.id.iv_photo);
            this.mIvVideo = (ImageView) view.findViewById(R.id.iv_video);
            this.iv_dot = (ImageView) view.findViewById(R.id.iv_dot);
            this.tvGif = (TextView) view.findViewById(R.id.tv_gif);
        }
    }

    public PicturePhotoGalleryAdapter(List<LocalMedia> list) {
        this.list = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<LocalMedia> list = this.list;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, int i10) {
        LocalMedia localMedia = this.list.get(i10);
        String path = localMedia.getPath();
        if (localMedia.isCut()) {
            viewHolder.iv_dot.setVisibility(0);
            viewHolder.iv_dot.setImageResource(R.drawable.ucrop_oval_true);
        } else {
            viewHolder.iv_dot.setVisibility(4);
        }
        if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            viewHolder.mIvPhoto.setVisibility(8);
            viewHolder.mIvVideo.setVisibility(0);
            viewHolder.mIvVideo.setImageResource(R.drawable.ucrop_ic_default_video);
            return;
        }
        viewHolder.mIvPhoto.setVisibility(0);
        viewHolder.mIvVideo.setVisibility(8);
        viewHolder.tvGif.setVisibility(PictureMimeType.isGif(localMedia.getMimeType()) ? 0 : 8);
        ImageEngine imageEngine = PictureSelectionConfig.imageEngine;
        if (imageEngine != null) {
            imageEngine.loadGridImage(viewHolder.itemView.getContext(), path, viewHolder.mIvPhoto);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.crop.PicturePhotoGalleryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PicturePhotoGalleryAdapter.this.listener != null) {
                    PicturePhotoGalleryAdapter.this.listener.onItemClick(viewHolder.getAbsoluteAdapterPosition(), view);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ucrop_picture_gf_adapter_edit_list, viewGroup, false));
    }
}
