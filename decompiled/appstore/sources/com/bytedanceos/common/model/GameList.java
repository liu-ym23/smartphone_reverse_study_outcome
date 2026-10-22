package com.bytedanceos.common.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class GameList {
    private String mApiUrl;
    private ArrayList<GameModel> mDataList;
    private boolean mHasMore;

    public GameList() {
        this.mHasMore = false;
        this.mDataList = new ArrayList();
    }

    private void parseAllGameGiftPacks(JSONArray r10) throws JSONException {
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L6;
        GameInfo r12 = new GameInfo(r10.getJSONObject(r11));
        r12.mApiurl = this.mApiUrl;
        this.mDataList.add(r12);
        r11 = r11 + 1;
        goto L4
    }

    private void parseMyGfitPacks(JSONArray r10) throws JSONException {
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L6;
        GiftPackInfo r12 = new GiftPackInfo(r10.getJSONObject(r11), 1);
        r12.isReceived = true;
        r12.mApiurl = this.mApiUrl;
        this.mDataList.add(r12);
        r11 = r11 + 1;
        goto L4
    }

    public ArrayList<GameModel> getDataList() {
        return this.mDataList;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean isEmpty() {
        ArrayList<GameModel> r10 = this.mDataList;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.isEmpty() == true) goto L8;
        return false;
    }

    public void setApiUrl(String r10) {
        this.mApiUrl = r10;
    }

    public void setDataList(int r10, JSONArray r11) throws JSONException {
        this.mDataList.clear();
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() != 0) goto L8;
        return;
    L8:
        if (1400001 != r10) goto L10;
        parseAllGameGiftPacks(r11);
        return;
    L10:
        parseMyGfitPacks(r11);
    }

    public void setHasMore(boolean r10) {
        this.mHasMore = r10;
    }
}
