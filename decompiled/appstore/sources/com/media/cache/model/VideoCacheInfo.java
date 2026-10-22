package com.media.cache.model;

import java.io.Serializable;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class VideoCacheInfo implements Serializable {
    private long mCachedLength;
    private int mCachedTs;
    private long mDownloadTime;
    private String mFinalUrl;
    private boolean mIsCompleted;
    private float mPercent;
    private int mPort;
    private String mSaveDir;
    private LinkedHashMap<Long, Long> mSegmentList;
    private int mTaskMode;
    private long mTotalLength;
    private int mTotalTs;
    private int mType;
    private String mUrl;

    public VideoCacheInfo(String r10) {
        this.mUrl = r10;
        this.mTotalLength = -1;
        this.mType = -1;
        this.mSegmentList = new LinkedHashMap();
        this.mDownloadTime = 0;
    }

    public long getCachedLength() {
        return this.mCachedLength;
    }

    public int getCachedTs() {
        return this.mCachedTs;
    }

    public long getDownloadTime() {
        return this.mDownloadTime;
    }

    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    public boolean getIsCompleted() {
        return this.mIsCompleted;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public int getPort() {
        return this.mPort;
    }

    public String getSaveDir() {
        return this.mSaveDir;
    }

    public LinkedHashMap<Long, Long> getSegmentList() {
        return this.mSegmentList;
    }

    public int getTaskMode() {
        return this.mTaskMode;
    }

    public long getTotalLength() {
        return this.mTotalLength;
    }

    public int getTotalTs() {
        return this.mTotalTs;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getVideoType() {
        return this.mType;
    }

    public void setCachedLength(long r10) {
        this.mCachedLength = r10;
    }

    public void setCachedTs(int r10) {
        this.mCachedTs = r10;
    }

    public void setDownloadTime(long r10) {
        this.mDownloadTime = r10;
    }

    public void setFinalUrl(String r10) {
        this.mFinalUrl = r10;
    }

    public void setIsCompleted(boolean r10) {
        this.mIsCompleted = r10;
    }

    public void setPercent(float r10) {
        this.mPercent = r10;
    }

    public void setPort(int r10) {
        this.mPort = r10;
    }

    public void setSaveDir(String r10) {
        this.mSaveDir = r10;
    }

    public void setSegmentList(LinkedHashMap<Long, Long> r10) {
        this.mSegmentList = r10;
    }

    public void setTaskMode(int r10) {
        this.mTaskMode = r10;
    }

    public void setTotalLength(long r10) {
        this.mTotalLength = r10;
    }

    public void setTotalTs(int r10) {
        this.mTotalTs = r10;
    }

    public void setUrl(String r10) {
        this.mUrl = r10;
    }

    public void setVideoType(int r10) {
        this.mType = r10;
    }

    public String toString() {
        return "VideoCacheInfo[url=" + this.mUrl + ", complete=" + this.mIsCompleted + ", type=" + this.mType + ", downloadTime=" + this.mDownloadTime + ", cachedLength=" + this.mCachedLength + ", totalLength=" + this.mTotalLength + ", cachedTs=" + this.mCachedTs + ", totalTs=" + this.mTotalTs + ", saveDir=" + this.mSaveDir + ", segmentSize=" + this.mSegmentList.size() + "]";
    }
}
