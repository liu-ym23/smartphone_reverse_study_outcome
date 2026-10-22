package com.bytedanceos.common.model;

import com.bytedanceos.common.R$id;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class CommentInfo implements Serializable {
    public static final int[] rate_progress_ids = null;
    private static final long serialVersionUID = 1;
    public int app_id;
    public int commentSupportTimes;
    public int comment_id;
    public String content;
    public boolean isFold;
    public boolean isLike;
    public boolean isMyComment;
    public boolean isSupporting;
    public String nickname;
    public int score;
    public String time;
    public String user;
    public String version;

    static {
        rate_progress_ids = new int[]{R$id.comment_rate1_progress, R$id.comment_rate2_progress, R$id.comment_rate3_progress, R$id.comment_rate4_progress, R$id.comment_rate5_progress};
    }

    public CommentInfo() {
        this.isFold = true;
        this.isLike = false;
        this.isSupporting = false;
        this.isMyComment = false;
    }
}
