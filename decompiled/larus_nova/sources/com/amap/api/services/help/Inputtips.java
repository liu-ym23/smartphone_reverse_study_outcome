package com.amap.api.services.help;

import android.content.Context;
import com.amap.api.col.s.ba;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class Inputtips {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IInputtipsSearch f28956a;

    public interface InputtipsListener {
        void onGetInputtips(List<Tip> r100, int r101);
    }

    public final InputtipsQuery getQuery() {
        IInputtipsSearch r100 = this.f28956a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getQuery();
    }

    public final List<Tip> requestInputtips() throws AMapException {
        IInputtipsSearch r100 = this.f28956a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.requestInputtips();
    }

    public final void requestInputtipsAsyn() {
        IInputtipsSearch r100 = this.f28956a;
        if (r100 == null) goto L6;
        r100.requestInputtipsAsyn();
        return;
    }

    public final void setInputtipsListener(InputtipsListener r100) {
        IInputtipsSearch r101 = this.f28956a;
        if (r101 == null) goto L6;
        r101.setInputtipsListener(r100);
        return;
    }

    public final void setQuery(InputtipsQuery r100) {
        IInputtipsSearch r101 = this.f28956a;
        if (r101 == null) goto L6;
        r101.setQuery(r100);
        return;
    }

    public Inputtips(Context r100, InputtipsListener r101) {
        this.f28956a = null;
        this.f28956a = new ba(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final void requestInputtips(String r100, String r101) throws AMapException {
        IInputtipsSearch r102 = this.f28956a;
        if (r102 == null) goto L6;
        r102.requestInputtips(r100, r101);
        return;
    }

    public Inputtips(Context r100, InputtipsQuery r101) {
        this.f28956a = null;
        this.f28956a = new ba(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public final void requestInputtips(String r100, String r101, String r102) throws AMapException {
        IInputtipsSearch r103 = this.f28956a;
        if (r103 == null) goto L6;
        r103.requestInputtips(r100, r101, r102);
        return;
    }
}
