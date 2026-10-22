package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public interface IInputtipsSearch {
    InputtipsQuery getQuery();

    ArrayList<Tip> requestInputtips() throws AMapException;

    void requestInputtips(String r100, String r101) throws AMapException;

    void requestInputtips(String r100, String r101, String r102) throws AMapException;

    void requestInputtipsAsyn();

    void setInputtipsListener(Inputtips.InputtipsListener r100);

    void setQuery(InputtipsQuery r100);
}
