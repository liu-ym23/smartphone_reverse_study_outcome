package com.amap.api.services.help;

import android.content.Context;
import com.amap.api.col.jmsl.I2;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.List;

/* loaded from: classes.dex */
public final class Inputtips {

    /* renamed from: a, reason: collision with root package name */
    private IInputtipsSearch f17480a;

    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i10);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) throws AMapException {
        this.f17480a = null;
        try {
            this.f17480a = new I2(context, inputtipsListener);
        } catch (Exception e10) {
            e10.printStackTrace();
            if (e10 instanceof AMapException) {
                throw ((AMapException) e10);
            }
        }
    }

    public InputtipsQuery getQuery() {
        IInputtipsSearch iInputtipsSearch = this.f17480a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.getQuery();
        }
        return null;
    }

    public List<Tip> requestInputtips() throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f17480a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.requestInputtips();
        }
        return null;
    }

    public void requestInputtipsAsyn() {
        IInputtipsSearch iInputtipsSearch = this.f17480a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtipsAsyn();
        }
    }

    public void setInputtipsListener(InputtipsListener inputtipsListener) {
        IInputtipsSearch iInputtipsSearch = this.f17480a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setInputtipsListener(inputtipsListener);
        }
    }

    public void setQuery(InputtipsQuery inputtipsQuery) {
        IInputtipsSearch iInputtipsSearch = this.f17480a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setQuery(inputtipsQuery);
        }
    }

    public void requestInputtips(String str, String str2) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f17480a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2);
        }
    }

    public void requestInputtips(String str, String str2, String str3) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f17480a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2, str3);
        }
    }

    public Inputtips(Context context, InputtipsQuery inputtipsQuery) {
        this.f17480a = null;
        try {
            this.f17480a = new I2(context, inputtipsQuery);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
