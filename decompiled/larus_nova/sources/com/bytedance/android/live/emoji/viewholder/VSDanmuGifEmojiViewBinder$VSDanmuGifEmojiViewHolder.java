package com.bytedance.android.live.emoji.viewholder;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes45.dex */
public class VSDanmuGifEmojiViewBinder$VSDanmuGifEmojiViewHolder extends RecyclerView.ViewHolder {

    public static final enum ImageLoadStatus extends Enum<ImageLoadStatus> {
        public static final ImageLoadStatus FIRST_TIME_ERROR = null;
        public static final ImageLoadStatus PROCESSING = null;
        public static final ImageLoadStatus RETRY_ERROR = null;
        public static final ImageLoadStatus SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ImageLoadStatus[] f68959a = null;

        static {
            ImageLoadStatus r100 = new ImageLoadStatus("FIRST_TIME_ERROR", 0);
            FIRST_TIME_ERROR = r100;
            ImageLoadStatus r101 = new ImageLoadStatus("RETRY_ERROR", 1);
            RETRY_ERROR = r101;
            ImageLoadStatus r102 = new ImageLoadStatus("PROCESSING", 2);
            PROCESSING = r102;
            ImageLoadStatus r103 = new ImageLoadStatus("SUCCESS", 3);
            SUCCESS = r103;
            f68959a = new ImageLoadStatus[]{r100, r101, r102, r103};
        }

        public static ImageLoadStatus[] values() {
            return (ImageLoadStatus[]) f68959a.clone();
        }

        public static ImageLoadStatus valueOf(String r100) {
            return (ImageLoadStatus) r27.a.a(ImageLoadStatus.class, r100);
        }

        public ImageLoadStatus(String r100, int r101) {
            super(r100, r101);
        }
    }
}
