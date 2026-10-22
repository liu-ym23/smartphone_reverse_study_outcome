package com.bytedanceos.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppComments implements Serializable {
    private static final long serialVersionUID = 0;
    private boolean isOnlyScore;
    private float mAverageScore;
    private List<CommentInfo> mComments;
    private int mCommentsCnt;
    private boolean mHasMore;
    private HashMap<Integer, Integer> mScoreMap;
    private int mScoresCnt;

    public AppComments() {
        this.mHasMore = false;
        this.isOnlyScore = false;
    }

    public float getAverageScore() {
        return this.mAverageScore;
    }

    public List<CommentInfo> getComments() {
        return this.mComments;
    }

    public int getCommentsCnt() {
        return this.mCommentsCnt;
    }

    public HashMap<Integer, Integer> getScoreMap() {
        return this.mScoreMap;
    }

    public int getScoresCnt() {
        return this.mScoresCnt;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean isEmpty() {
        List<CommentInfo> r10 = this.mComments;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isEmpty() == true) goto L8;
        return false;
    }

    public boolean isOnlyScore() {
        return this.isOnlyScore;
    }

    public void setAverageScore(float r10) {
        this.mAverageScore = r10;
    }

    public void setComments(List<CommentInfo> r10) {
        this.mComments = r10;
    }

    public void setCommentsCnt(int r10) {
        this.mCommentsCnt = r10;
    }

    public void setHasMore(boolean r10) {
        this.mHasMore = r10;
    }

    public void setOnlyScore(boolean r10) {
        this.isOnlyScore = r10;
    }

    public void setScoreMap(HashMap<Integer, Integer> r10) {
        this.mScoreMap = r10;
    }

    public void setScoresCnt(int r10) {
        this.mScoresCnt = r10;
    }
}
