package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class I2 implements IInputtipsSearch {

    /* renamed from: a, reason: collision with root package name */
    public Context f16104a;

    /* renamed from: b, reason: collision with root package name */
    public Inputtips.InputtipsListener f16105b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f16106c;

    /* renamed from: d, reason: collision with root package name */
    public InputtipsQuery f16107d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.obj = I2.this.f16105b;
            messageObtainMessage.arg1 = 5;
            try {
                try {
                    I2 i22 = I2.this;
                    ArrayList<? extends Parcelable> arrayListC = i22.c(i22.f16107d);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("result", arrayListC);
                    messageObtainMessage.setData(bundle);
                    messageObtainMessage.what = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.what = e10.getErrorCode();
                }
            } finally {
                I2.this.f16106c.sendMessage(messageObtainMessage);
            }
        }
    }

    public I2(Context context, Inputtips.InputtipsListener inputtipsListener) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16104a = context.getApplicationContext();
        this.f16105b = inputtipsListener;
        this.f16106c = HandlerC1626y0.a();
        C1631z1.l(this.f16104a, "InputtipsSearchCore");
    }

    public final ArrayList<Tip> c(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            C1559h0.c(this.f16104a);
            if (inputtipsQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (inputtipsQuery.getKeyword() == null || inputtipsQuery.getKeyword().equals("")) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return new S(this.f16104a, inputtipsQuery).g();
        } catch (Throwable th) {
            C1631z1.o(th, "Inputtips", "requestInputtips");
            if (th instanceof AMapException) {
                throw th;
            }
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public InputtipsQuery getQuery() {
        return this.f16107d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public ArrayList<Tip> requestInputtips() throws AMapException {
        return c(this.f16107d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void requestInputtipsAsyn() {
        try {
            C1535b0.c().b(new a());
        } catch (Throwable th) {
            C1631z1.o(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.f16105b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void setQuery(InputtipsQuery inputtipsQuery) {
        this.f16107d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str != null && !str.equals("")) {
            InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
            this.f16107d = inputtipsQuery;
            inputtipsQuery.setType(str3);
            try {
                C1535b0.c().b(new a());
                return;
            } catch (Throwable th) {
                C1631z1.o(th, "Inputtips", "requestInputtipsAsynThrowable");
                return;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public I2(Context context, InputtipsQuery inputtipsQuery) {
        this.f16104a = context.getApplicationContext();
        this.f16107d = inputtipsQuery;
        this.f16106c = HandlerC1626y0.a();
    }
}
