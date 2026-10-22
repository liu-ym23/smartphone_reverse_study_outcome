package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public final class ba implements IInputtipsSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Inputtips.InputtipsListener f26103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f26104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InputtipsQuery f26105d;

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final ArrayList<Tip> requestInputtips() throws AMapException {
        return a(this.f26105d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        an.a().a(new AnonymousClass1(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        i.a(th, "Inputtips", "requestInputtipsAsynThrowable");
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final InputtipsQuery getQuery() {
        return this.f26105d;
    }

    private ArrayList<Tip> a(InputtipsQuery r100) throws AMapException {
        q.a(this.f26102a);     // Catch: Throwable -> L15
        if (r100 == null) goto L14;
        if (r100.getKeyword() == null) goto L12;
        if (r100.getKeyword().equals("") == true) goto L12;
        return new o(this.f26102a, r100).b();
    L12:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: Throwable -> L15
    L14:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        i.a(th, "Inputtips", "requestInputtips");
        if ((th instanceof AMapException) == true) goto L21;
        return null;
    L21:
        throw th;
    }

    public static /* synthetic */ InputtipsQuery b(ba r100) {
        return r100.f26105d;
    }

    public static /* synthetic */ Handler c(ba r100) {
        return r100.f26104c;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(Inputtips.InputtipsListener r100) {
        this.f26103b = r100;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(InputtipsQuery r100) {
        this.f26105d = r100;
    }

    public static /* synthetic */ Inputtips.InputtipsListener a(ba r100) {
        return r100.f26103b;
    }

    public ba(Context r100, Inputtips.InputtipsListener r101) {
        this.f26102a = r100.getApplicationContext();
        this.f26103b = r101;
        this.f26104c = s.a();
    }

    public static /* synthetic */ ArrayList a(ba r100, InputtipsQuery r101) throws AMapException {
        return r100.a(r101);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String r100, String r101) throws AMapException {
        requestInputtips(r100, r101, null);
    }

    public ba(Context r100, InputtipsQuery r101) {
        this.f26102a = r100.getApplicationContext();
        this.f26105d = r101;
        this.f26104c = s.a();
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String r100, String r101, String r102) throws AMapException {
        if (r100 == null) goto L8;
        if (r100.equals("") == true) goto L8;
        InputtipsQuery r103 = new InputtipsQuery(r100, r101);
        this.f26105d = r103;
        r103.setType(r102);
        requestInputtipsAsyn();
        return;
    L8:
        throw new AMapException(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }
}
